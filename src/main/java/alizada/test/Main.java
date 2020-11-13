package alizada.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String a = "aa";
        System.out.println();add(a);
    }

    private static <T> T add(T type) {
        if (type instanceof Map) {
            return (T) new HashMap();
        }
        return null;
    }
}
