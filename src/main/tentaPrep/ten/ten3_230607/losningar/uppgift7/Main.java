package main.tentaPrep.ten.ten3_230607.losningar.uppgift7;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(nrOfPaths(1, 3));
    }

    private static int nrOfPaths(int m, int n) {
        int[][] city = new int[2 * m + 1][2 * n + 1];
        return nrOfPaths(0, 2 * n, city);
    }

    private static int nrOfPaths(int rowPos, int colPos, int[][] city) {
        city[rowPos][colPos]++;
        if (rowPos == city.length - 1 && colPos == 0) {
            print2D(city);
            city[rowPos][colPos]--;
            return 1;
        }
        int nrOfPaths = 0;
        if (rowPos + 1 < city.length-1 && city[rowPos + 1][colPos] == 0) {//syd
            city[rowPos + 1][colPos] = 1;
            nrOfPaths += nrOfPaths(rowPos + 2, colPos, city);
            city[rowPos + 1][colPos] = 0;
        }
        if (rowPos - 1 >= 1 && city[rowPos - 1][colPos] == 0) {//nord
            city[rowPos - 1][colPos] = 1;
            nrOfPaths += nrOfPaths(rowPos - 2, colPos, city);
            city[rowPos - 1][colPos] = 0;
        }
        if (colPos + 1 < city[0].length-1 && city[rowPos][colPos + 1] == 0) {//öst
            city[rowPos][colPos + 1] = 1;
            nrOfPaths += nrOfPaths(rowPos, colPos + 2, city);
            city[rowPos][colPos + 1] = 0;
        }
        if (colPos - 1 >= 1 && city[rowPos][colPos - 1] == 0) {//väst
            city[rowPos][colPos - 1] = 1;
            nrOfPaths += nrOfPaths(rowPos, colPos - 2, city);
            city[rowPos][colPos - 1] = 0;
        }
        city[rowPos][colPos]--;
        return nrOfPaths;
    }

    static void print2D(int[][] a) {
        for (int[] r : a) {
            for(int p: r) System.out.print(p);
            System.out.println();
        }
        System.out.println();
    }
}
