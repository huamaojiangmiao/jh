package script;

public class RangeDateTime<T> {
    private T start;
    private T end;

    public RangeDateTime(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public boolean equals(RangeDateTime<T> range) {
        if (this.hashCode() == range.hashCode()) {
            return true;
        }
        if (start != null && end != null && start.equals(end)) {
            return true;
        }
        return false;
    }

    public RangeDateTime() {
    }
    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        this.end = end;
    }
}
