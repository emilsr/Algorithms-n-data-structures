package F1;

import java.util.ArrayList;
import java.util.List;

/**
 * return the number of times a Sting appears in a List
 */

public class StringCount {
    public static int count(List<String> list, String str) {
        int count = 0;
        for (String s : list) {
            if (s.equals(str)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Match");
        list.add("A");
        list.add("B");
        list.add("Match");
        list.add("match");
        System.out.println("nr of matches: " + count(list, "Match"));
    }
}
