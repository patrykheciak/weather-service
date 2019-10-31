package pl.wypozyczalnia.weather.model.my;

import java.util.Date;

public class WeatherBody {
    public Date date;
    public String city;
    public String temperature;
    public double rain;

    public WeatherBody(Date date, String city, String temperature, double rain) {
        this.date = date;
        this.city = city;
        this.temperature = temperature;
        this.rain = rain;
    }
}