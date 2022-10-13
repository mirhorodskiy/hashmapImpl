import java.util.List;

public class CustomHashMap {

    private CustomBucket[] bucket;
    private final double loadFactor;
    private int countElem;
    private int length;

    public CustomHashMap(int size, double loadFactor) {

        bucket = new CustomBucket[size];
        this.loadFactor = loadFactor;
        this.length = size;
        this.countElem = 0;

    }

    public boolean insert(Triangle newTriangle) {
        if (countElem > loadFactor * bucket.length) {
            System.out.println("rebuilding");
            rebuildTable();
        }

        double key = newTriangle.perimeter();
        int index = codeIndex(key);
        if (bucket[index] == null) {
            bucket[index] = new CustomBucket();
            countElem++;
        }
        bucket[index].addEntry(new CustomEntry(key, newTriangle));
        return true;
    }

    private int codeIndex(double key) {
        return (int) (key % length);
    }

    private void rebuildTable() {

        this.length *= 2;
        CustomBucket[] newArray = new CustomBucket[length];
        for (CustomBucket customBucket : bucket) {
            if (customBucket != null) {
                List<CustomEntry> entryList = customBucket.getEntries();
                for (CustomEntry entry : entryList) {
                    add(entry, newArray);
                }
            }
        }

        this.bucket = newArray;
        System.out.println("rebuild success");
    }


    public Triangle get(double key) {
        int index = codeIndex(key);
        for (int i = 0; i < bucket[index].getEntries().size(); i++) {
            CustomEntry customEntry = bucket[index].getEntries().get(i);
            if (customEntry.getKey() == key) {
                return customEntry.getValue();
            }
        }
        return null;
    }



    public boolean containsKey(double key) {
        int index = codeIndex(key);
        return bucket[index] != null;
    }

    private void add(CustomEntry obj, CustomBucket[] newArray) {
        double key = obj.getValue().perimeter();
        int index = codeIndex(key);

        if (newArray[index] == null) {
            newArray[index] = new CustomBucket();
        }
        newArray[index].addEntry(obj);
    }


    private CustomEntry getEntry(double key) {
        int index = codeIndex(key);
        for (int i = 0; i < bucket[index].getEntries().size(); i++) {
            CustomEntry customEntry = bucket[index].getEntries().get(i);
            if (customEntry.getKey() == key) {
                return customEntry;
            }
        }
        return null;
    }

    public void delete(double key) {
        if (containsKey(key)) {
            int hash = codeIndex(key);
            bucket[hash].removeEntry(getEntry(key));
            countElem--;
        }
    }

    public CustomBucket[] getBuckets() {
        return bucket;
    }

}
