package pl.wypozyczalnia.weather.model.openweathermap;

public class OwmSys {
    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    @Override
    public String toString() {
        return "Wsys{" +
                "pod='" + pod + '\'' +
                '}';
    }
}
