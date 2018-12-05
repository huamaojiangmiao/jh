package script;

public class RangeData<T>{
    private T max;
    private T min;

    public RangeData() {
    }
    public RangeData(T min, T max) {
        this.min = min;
        this.max = max;
    }
    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }
}
