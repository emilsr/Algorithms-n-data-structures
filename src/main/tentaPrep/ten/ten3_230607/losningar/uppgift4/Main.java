package main.tentaPrep.ten.ten3_230607.losningar.uppgift4;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {  {1,5,4,7,8,3,1},
                            {2,6,3,4,7,1,5},
                            {3,5,1,9,1,7,1},
                            {1,3,1,4,5,8,2},
                            {3,1,8,3,1,2,1}};
        System.out.println(maxSum(matrix,1));
        System.out.println(maxSumDyn(matrix,1));
    }
    private static int maxSum(int[][] matrix, int startCol) {
        if(matrix.length < 1 || startCol<0 || startCol>matrix[0].length-1) return -1;
        return maxSum(matrix,startCol,0);
    }
    private static int maxSum(int[][] matrix, int col, int row) {
        if(row==matrix.length-1) return matrix[row][col];
        int best = maxSum(matrix,col,row+1);
        if(col-1>=0) best = Math.max(best, maxSum(matrix,col-1,row+1));
        if(col+1<matrix[row].length) best = Math.max(best, maxSum(matrix,col+1,row+1));
        return matrix[row][col] + best;
    }

    private static int maxSumDyn(int[][] matrix, int startCol) {//kräver positiva heltal
        if(matrix.length < 1 || startCol<0 || startCol>matrix[0].length-1) return -1;
        int[][] memo = new int[matrix.length][matrix[0].length];
        return maxSumDyn(matrix,startCol,0,memo);
    }
    private static int maxSumDyn(int[][] matrix, int col, int row,int[][] memo) {
        if(memo[row][col]!=0) return memo[row][col];
        if(row==matrix.length-1) return memo[row][col] = matrix[row][col];
        int best = maxSumDyn(matrix,col,row+1,memo);
        if(col-1>=0) best = Math.max(best, maxSumDyn(matrix,col-1,row+1,memo));
        if(col+1<matrix[row].length) best = Math.max(best, maxSumDyn(matrix,col+1,row+1,memo));
        return memo[row][col] = matrix[row][col] + best;
    }

    private static int maxSumPos(int[][] matrix, int startCol) {//kräver heltal>=0
        if(matrix.length < 1 || startCol<0 || startCol>matrix[0].length-1) return -1;
        return maxSumPos(matrix,startCol,0);
    }
    private static int maxSumPos(int[][] matrix, int col, int row) {
        if(row>matrix.length-1 || col<0 || col>matrix[row].length-1) return 0;
        return matrix[row][col] + Math.max(maxSumPos(matrix,col-1,row+1),Math.max(maxSumPos(matrix,col,row+1), maxSumPos(matrix,col+1,row+1)));
    }


}
