package pl.wypozyczalnia.weather;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class OpenWeatherMapApi {

    private String apiKey;
    private RestTemplate restTemplate;
    private static final String API_URL =
            "http://api.openweathermap.org/data/2.5/forecast?q={city},{countryCode}&APPID={APP_ID}";
    private static final String COUNTRY_CODE = "PL";

    public OpenWeatherMapApi(String appId) {
        this.apiKey = appId;
        restTemplate = new RestTemplate();
    }

    public String getWeather(String city) {
        try {
            return restTemplate.getForObject(API_URL, String.class, city, COUNTRY_CODE, apiKey);
        } catch (HttpClientErrorException e) {
//            e.printStackTrace();
            return e.getResponseBodyAsString();
        } catch (RestClientException e) {
            e.printStackTrace();
            return "";
        }
    }
}
