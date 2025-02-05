package main.f8.nb26_1;

import java.util.HashMap;

public class FrequentCount {

    public static int frequentCount(String[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }

        HashMap<String, Integer> map = new HashMap<>();
        int maxCount = 0;

        for (String str: arr){
            int count = map.getOrDefault(str, 0) + 1;
            map.put(str, count);

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
