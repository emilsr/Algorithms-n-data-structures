package main.tentaPrep.ten.ten3_230607.uppgift4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {  {1,5,4,7,8,3,1},
                            {2,6,3,4,7,1,5},
                            {3,5,1,9,1,7,1},
                            {1,3,1,4,5,8,2},
                            {3,1,8,3,1,2,1}};
        System.out.println(maxSum(matrix,1));
        System.out.println(maxSumDy(matrix,1));

    }
    private static int maxSum(int[][] matrix, int startCol) {
        return maxSum(matrix, 0, startCol);
    }

    private static int maxSum(int[][] matrix, int row, int col){
        int sum;

        if (row > 4){
            return 0;
        }
        sum = maxSum(matrix, row+1, col);
        if (col>0) {
            sum = Math.max(sum, maxSum(matrix, row+1, col-1));
        }
        if (col<6){
            sum = Math.max(sum, maxSum(matrix, row+1, col+1));
        }
        return sum + matrix[row][col];
    }

    private static int maxSumDy(int[][] matrix, int startCol) {
        int [][] memory = new int[matrix.length][matrix[0].length];
        //Arrays.fill(memory, -1);
        return maxSumDy(matrix, 0, startCol, memory);
    }

    private static int maxSumDy(int[][] matrix, int row, int col, int[][] memory){
        int sum;

        if (row == 5){
            return 0;
        }

        if (memory[row][col] != 0){
            return memory[row][col];
        }

        sum = maxSumDy(matrix, row+1, col, memory);
        if (col>0) {
            sum = Math.max(sum, maxSumDy(matrix, row+1, col-1, memory));
        }
        if (col<6){
            sum = Math.max(sum, maxSumDy(matrix, row+1, col+1, memory));
        }
        return memory[row][col] = sum + matrix[row][col];
    }

}
