package main.F1;

import java.util.ArrayList;

/**
 *  Deletes the first occurrence of target in aList. */
public class NB2 {
    public static void delete(ArrayList<String> aList, String target){
        for (int i = 0; i < aList.size(); i++){
            if (aList.get(i).equals(target)){
                aList.remove(i);
                return;
            }
        }
    }
}
