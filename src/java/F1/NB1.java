package java.F1;

import java.util.ArrayList;

/**
 * Rep1aces each occurrence of o1dItem in aList with newItem.
 */
public class NB1 {

    static public void replace(ArrayList<String> aList, String oldItem, String newItem) {
        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i).equals(oldItem)) {
                aList.set(i, newItem);
            }
        }
    }
}
