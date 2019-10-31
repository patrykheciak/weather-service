package pl.wypozyczalnia.weather.model.my;

public class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F f, S s){
        first = f;
        second = s;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }
}
