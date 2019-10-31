package pl.wypozyczalnia.weather.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwmRain {

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    @JsonProperty("3h")
    private double h;

    @Override
    public String toString() {
        return "WRain{" +
                "h=" + h +
                '}';
    }
}
