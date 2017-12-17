package json;

import java.util.HashMap;

public class Tester {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("a", 1);
        hm.put("f", 1);
        hm.put("e", 1);
        hm.put("c", 1);
        hm.put("d", 1);
        hm.put("g", 1);
        hm.put("b", 1);
        System.out.println(hm.keySet());
    }
}
