package pl.wypozyczalnia.weather.model.openweathermap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class OwmWeatherResponse {
    private String cod;
    private int message;
    private int cnt;
    private List<OwmWeatherInstant> list;
    private OwmCity city;

    private static ObjectMapper mapper = new ObjectMapper();

    public static OwmWeatherResponse fromJson(String json) {
        if (json.isEmpty())
            return null;
        else {
            OwmWeatherResponse response = null;
            try {
                return mapper.readValue(json, OwmWeatherResponse.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public OwmCity getCity() {
        return city;
    }

    public void setCity(OwmCity city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<OwmWeatherInstant> getList() {
        return list;
    }

    public void setList(List<OwmWeatherInstant> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                ", list=" + list +
                ", city=" + city +
                '}';
    }
}