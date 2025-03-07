package main.tentaPrep.ten.ten1_240604.uppgift4;

/**
 * Mycket bra jobbat, tänket är identiskt med Nicklas men nu bör undvika magiska numer
 */

public class Main {

    public static void main(String[] args){

        int[][] maze = {{31,32,33,34,37,11,36},
                        {32,33,35,26,35,36,39},
                        {31,32,13,32,31,37,37},
                        {11,39,13,14,15,16,17},
                        {18,19,33,32,31,32,33},
                        {16,38,21,22,23,24,25}};
        System.out.println(existsPath(maze));
    }

    static boolean[] visited = new boolean[1000];

    private static boolean existsPath(int[][] maze) {
        return existsPath(maze,0, 0, 0);
    }

    private static boolean existsPath(int[][] maze, int y, int x, int c) {
        System.out.println("Visiting: " + y +", " + x + " -> " + maze[y][x]);
        visited[maze[y][x]] = true;

        if (winCon(y, x)) return true;

        if (validationCheck(y, x+1, maze) && existsPath(maze, y, x+1, c+1)) return true;
        if (validationCheck(y+1, x, maze) && existsPath(maze, y+1, x, c+1)) return true;
        if (validationCheck(y, x-1, maze) && existsPath(maze, y, x-1, c+1)) return true;

        visited[maze[y][x]] = false;

        return false;
    }

    private static boolean winCon(int y, int x){
        return x == 6 && y == 5;
    }

    private static boolean validationCheck(int y, int x, int[][] maze){
        return !isOutOfBound(y, x) && !visited[maze[y][x]];
    }

    private static boolean isOutOfBound(int y, int x){
        return y < 0 || y > 5 || x < 0 || x > 6;
    }
}
