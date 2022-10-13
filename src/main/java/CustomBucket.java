import java.util.LinkedList;
import java.util.List;

public class CustomBucket {
    private List<CustomEntry> entries;

    public CustomBucket() {
        this.entries = new LinkedList<>();
    }

    public List<CustomEntry> getEntries() {
        return entries;
    }

    public void addEntry(CustomEntry entry) {
        this.entries.add(entry);
    }

    public void removeEntry(CustomEntry entry) {
        this.entries.remove(entry);
    }
}