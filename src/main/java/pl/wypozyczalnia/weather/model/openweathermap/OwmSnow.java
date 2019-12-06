package pl.wypozyczalnia.weather.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwmSnow {
    @Override
    public String toString() {
        return "OwmSnow{" +
                "h=" + h +
                '}';
    }

    @JsonProperty("3h")
    private double h;

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
