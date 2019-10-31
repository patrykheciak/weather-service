package pl.wypozyczalnia.weather.model.my;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBody {
    public int cod;
    public String message;
    public List<WeatherBody> list;

    public ResponseBody(int cod, String message, List<WeatherBody> list) {
        this.cod = cod;
        this.message = message;
        this.list = list;
    }
}
