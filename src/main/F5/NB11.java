package main.F5;

import java.lang.reflect.Array;

//Skriv en rekursiv static metod som hittar största värdet i en array av ints.

public class NB11 {    

    static public int findLargestInt(int[] array){
        return findLargestInt(array, 0, -1);

    } 

    static public int findLargestInt(int[] array, int index, int currentLargest){
        if (index == array.length) {
            return currentLargest;
        }
        if (currentLargest < array[index]) {
            currentLargest = array[index];
        }

        return findLargestInt(array, index+1, currentLargest);

    } 

    public static void main(String[] args)  {
        int[] array = {10, 6, 4, 9, 12, 56, 0}; 
        System.out.println("Array: " + array);
        System.out.println("Largest int in array: " +  findLargestInt(array));

        
    }

    
}
