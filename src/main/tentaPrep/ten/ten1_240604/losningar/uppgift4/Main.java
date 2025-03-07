package main.tentaPrep.ten.ten1_240604.losningar.uppgift4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        int[][] maze = {{31,32,33,34,37,11,36},
                        {32,33,35,26,35,36,39},
                        {31,32,13,32,31,37,37},
                        {11,39,13,14,15,16,17},
                        {18,19,33,32,31,32,33},
                        {16,38,21,22,23,24,25}};
        int[][] maze2 = {{31,32,33,34,37,11,36},
                {32,33,35,26,35,36,39},
                {31,32,13,32,31,37,37},
                {11,39,13,14,15,16,17},
                {18,25,33,32,31,32,33},
                {16,38,21,22,23,24,25}};
        System.out.println(existsPath(maze));
    }

    private static boolean existsPath(int[][] maze) {
        boolean[] taken = new boolean[1000];
        return existsPath(maze, taken, 0,0);
    }

    private static boolean existsPath(int[][] maze, boolean[] taken, int row, int col) {
        if(row<0 || col<0 || row>maze.length-1 || col>maze[0].length-1) return false;
        if(taken[maze[row][col]]) return false;
        if(row==maze.length-1 && col==maze[0].length-1) return true;

        taken[maze[row][col]] = true;
        if(existsPath(maze,taken,row,col+1)) return true;
        if(existsPath(maze,taken,row,col-1)) return true;
        if(existsPath(maze,taken,row+1,col)) return true;
        taken[maze[row][col]] = false;
        return false;
    }



}
