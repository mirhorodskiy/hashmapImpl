import java.util.Objects;

public class CustomEntry {
    private double key;
    private Triangle value;

    public CustomEntry(double key, Triangle value) {
        this.key = key;
        this.value = value;
    }

    public double getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Triangle getValue() {
        return value;
    }

    public void setValue(Triangle value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomEntry)) return false;
        CustomEntry entry = (CustomEntry) o;
        return Double.compare(entry.key, key) == 0 && value.equals(entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
