package pl.wypozyczalnia.weather;

import java.util.ArrayList;
import java.util.List;

public class ApiCallLimiter {

    private List<Long> calls;

    public ApiCallLimiter() {
        calls = new ArrayList<>();
    }

    public boolean canCall() {
        removeOlderThanMinute();
        return calls.size() < 60;
    }

    public  void called() {
        calls.add(System.currentTimeMillis());
    }

    private void removeOlderThanMinute() {
        if (calls.size() > 1)
            calls.removeIf(next -> Math.abs(System.currentTimeMillis() - next) > 60 * 1000); // 1 minute in ms
    }
}
