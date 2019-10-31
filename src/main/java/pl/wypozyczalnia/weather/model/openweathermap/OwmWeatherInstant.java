package pl.wypozyczalnia.weather.model.openweathermap;

import java.util.List;

public class OwmWeatherInstant {
    private long dt;
    private OwmMain main;
    private List<OwmWeather> weather;
    private OwmClouds clouds;
    private OwmWind wind;
    private OwmSys sys;
    private String dt_txt;
    private OwmRain rain;


    public OwmRain getRain() {
        return rain;
    }

    public void setRain(OwmRain rain) {
        this.rain = rain;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public OwmMain getMain() {
        return main;
    }

    public void setMain(OwmMain main) {
        this.main = main;
    }

    public List<OwmWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<OwmWeather> weather) {
        this.weather = weather;
    }

    public OwmClouds getClouds() {
        return clouds;
    }

    public void setClouds(OwmClouds clouds) {
        this.clouds = clouds;
    }

    public OwmWind getWind() {
        return wind;
    }

    public void setWind(OwmWind wind) {
        this.wind = wind;
    }

    public OwmSys getSys() {
        return sys;
    }

    public void setSys(OwmSys sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @Override
    public String toString() {
        return "WeatherInstant{" +
                "dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", sys=" + sys +
                ", dt_txt='" + dt_txt + '\'' +
                ", rain=" + rain +
                '}';
    }
}