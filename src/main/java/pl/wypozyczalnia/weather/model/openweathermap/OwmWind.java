package pl.wypozyczalnia.weather.model.openweathermap;

public class OwmWind {
    private double speed;
    private int deg;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "WWind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
