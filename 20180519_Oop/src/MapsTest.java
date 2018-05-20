import java.util.HashMap;
import java.util.Map;

public class MapsTest {
    public static void testMaps(){
//        Movie m1 = new Movie("Star Wars", 1977, 9.00);
//        Movie m2 = new Movie("LOTR", 1990, 9.00);
//        Movie m3 = new Movie("Blade Runner 2049", 2018, 9.00);
//        Movie m4 = new Movie("Silence of The lambs", 1992, 10.00);
//        Movie m5 = new Movie("Seven", 1984, 10.00);
//        Movie m6 = new Movie("2001:A Space Odyssey", 1967, 9.50);

        Map<String, String> map = new HashMap<>();
        System.out.println("Testing basic map operations");

        map.put("Key1", "Value1");
        map.put("Key2", "Value2");

        for (String k: map.keySet()){
            System.out.println("key: " + k + "\tvalue: " + map.get(k));
        }

    }
}
