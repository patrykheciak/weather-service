package pl.wypozyczalnia.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wypozyczalnia.weather.model.my.ResponseBody;
import pl.wypozyczalnia.weather.model.my.WeatherBody;
import pl.wypozyczalnia.weather.model.openweathermap.OwmWeatherResponse;

import java.util.List;

@RestController
public class WeatherController {

    private String APP_ID = "40072c42adae4d5b39f2679f6c1302a4";
    private OpenWeatherMapApi api = new OpenWeatherMapApi(APP_ID);
    private ApiCallLimiter limiter = new ApiCallLimiter();
    private WeatherCache cache = new WeatherCache();

    @GetMapping("/hello")
    public Object hello(String city) {

        // if cached than return
        List<WeatherBody> cachedList = cache.getCached(city);
        if (cachedList != null){
            System.out.println("Retrieved from cache");
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseBody(200, null, cachedList));
        }

        if (limiter.canCall()) {
            String apiResponse = api.getWeather(city);
            limiter.called();
            System.out.println("Retrieved from API");

            ObjectMapper mapper = new ObjectMapper();
            try {
                JsonNode jsonNode = mapper.readTree(apiResponse);
                if (jsonNode.get("cod").asInt() == 200) {
                    OwmWeatherResponse weatherResponse = OwmWeatherResponse.fromJson(apiResponse);
                    List<WeatherBody> list = WeatherBodyExtractor.extractFrom(weatherResponse);

                    cache.save(city, list);

                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseBody(200, null, list));
                } else {
                    int status = jsonNode.get("cod").asInt();
                    String message = jsonNode.get("message").asText();
                    return ResponseEntity.status(status).body(new ResponseBody(status, message, null));
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseBody(500, "Something went wrong", null));
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(new ResponseBody(429, "Exceeded 60 calls per second.", null));
        }
    }
}
