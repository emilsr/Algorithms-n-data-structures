package main.tentaPrep.kryssTal.f1;

import java.util.ArrayList;

public class SelfCheck1n2 {
    public static void replace(ArrayList<String> aList, String oldItem, String newItem){
        for (int i = 0; i<aList.size(); i++){
            if (aList.get(i) == oldItem) {
                aList.set(i, newItem);
            }
        }
    }

    public static void delete(ArrayList<String> aList, String target){
        aList.remove(target);
    }


    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<String>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");

        SelfCheck1n2.replace(test,"2","4");
        System.out.println(test.toString());
        SelfCheck1n2.delete(test, "4");
        System.out.println(test.toString());

    }
}
