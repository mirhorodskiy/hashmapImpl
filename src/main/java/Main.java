import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap(5, 0.75);

        Triangle triangle1 = new Triangle(3, -3, 7, -3, 5, 5);
        System.out.println(triangle1.perimeter());

        Triangle triangle3 = new Triangle(2, -1, 4, -1, 3, 3);
        System.out.println(triangle3.perimeter());


        map.insert(triangle1);
        map.insert(triangle3);

        map.insert(new Triangle(2, -1, 4, -1, 3, 5));
        map.insert(new Triangle(2, -1, 4, -1, 3, 6));
        map.insert(new Triangle(2, -1, 4, -1, 3, 7));
        map.insert(new Triangle(2, -1, 4, -1, 3, 8));
        map.insert(new Triangle(2, -1, 4, -1, 3, 9));
        map.insert(new Triangle(2, -1, 4, -1, 3, 10));
        map.insert(new Triangle(2, -1, 4, -1, 3, 11));
        map.insert(new Triangle(2, -1, 4, -1, 3, 12));
        map.insert(new Triangle(2, -1, 4, -1, 3, 13));
        map.insert(new Triangle(2, -1, 4, -1, 3, 14));
        map.insert(new Triangle(2, -1, 4, -1, 3, 15));
        map.insert(new Triangle(3, -1, 4, -1, 3, 16));

//        System.out.println(map.get(triangle1.perimeter()));
//        System.out.println(map.get(triangle3.perimeter()));
        System.out.println("Delete " + triangle1);
        map.delete(triangle1.perimeter());
        System.out.println(map.get(triangle1.perimeter()));


        CustomBucket[] b = map.getBuckets();
        for (int i = 0; i < b.length; i++) {
            System.out.print(i + ": ");
            if (b[i] != null)
                System.out.println(b[i].getEntries());
            else
                System.out.println("null");
        }
    }
}
