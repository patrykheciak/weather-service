package pl.wypozyczalnia.weather;

import pl.wypozyczalnia.weather.model.my.WeatherBody;
import pl.wypozyczalnia.weather.model.openweathermap.OwmWeatherInstant;
import pl.wypozyczalnia.weather.model.openweathermap.OwmWeatherResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherBodyExtractor {
    public static List<WeatherBody> extractFrom(OwmWeatherResponse wr) {
        if (wr != null) {
            List<OwmWeatherInstant> instants = wr.getList();
            ArrayList<WeatherBody> bodies = new ArrayList<>();

            for (OwmWeatherInstant weatherInstant : instants) {
                double tempCels = weatherInstant.getMain().getTemp() - 273.15;
                Date date = new Date(1000 * weatherInstant.getDt());
                double rain = weatherInstant.getRain() == null ? 0.0 : weatherInstant.getRain().getH();
                double snow = weatherInstant.getSnow() == null ? 0.0 : weatherInstant.getSnow().getH();
                String icon = weatherInstant.getWeather().get(0).getIcon();
                bodies.add(new WeatherBody(date, wr.getCity().getName(), String.format("%.2f", tempCels), rain, snow, icon));
            }
            return bodies;
        }
        return null;
    }
}
