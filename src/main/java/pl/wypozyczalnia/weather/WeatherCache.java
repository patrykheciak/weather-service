package pl.wypozyczalnia.weather;

import pl.wypozyczalnia.weather.model.my.Pair;
import pl.wypozyczalnia.weather.model.my.WeatherBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherCache {

    private static final int MAX_TIME_CACHE_IS_FRESH = 1000 * 60 * 60; // 1 hour
    private Map<String, Pair<Long, List<WeatherBody>>> map = new HashMap<>();

    public List<WeatherBody> getCached(String city) {
        if (map.containsKey(city)) {
            Pair<Long, List<WeatherBody>> longListPair = map.get(city);
            Long time = longListPair.getFirst();

            if ((System.currentTimeMillis() - time) < MAX_TIME_CACHE_IS_FRESH) {
                // cache is still 'fresh'
                return longListPair.getSecond();
            } else {
                // cache to old
                map.remove(city);
                return null;
            }
        } else {
            return null;
        }
    }

    public void save(String city, List<WeatherBody> list) {
        map.put(city, new Pair<>(System.currentTimeMillis(), list));
    }
}
