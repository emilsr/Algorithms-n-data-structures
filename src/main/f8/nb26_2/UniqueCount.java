package main.f8.nb26_2;

import java.util.HashSet;

public class UniqueCount {
    public static int uniqueCount(String[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashSet<String> uniqueStrings = new HashSet<>();

        for (String str : arr) {
            uniqueStrings.add(str);
        }

        return uniqueStrings.size();
    }
}
