package main.tentaPrep.ten.ten2_240313.Losningar.uppgift6;

import java.util.*;

public class Main {
    private static class Position implements Comparable{
        private int row, column, time;
        public Position(int row, int column, int time) {
            this.row = row;
            this.column = column;
            this.time = time;
        }

        public Position newPosition(int type, int timeTrap){//kontrollerar ej kanter!
            switch(type){
                case 0: return new Position(row-1,column,time+timeTrap+1);
                case 1: return new Position(row,column+1,time+timeTrap+1);
                case 2: return new Position(row+1,column,time+timeTrap+1);
                case 3: return new Position(row,column-1,time+timeTrap+1);
            }
            return null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && column == position.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        @Override
        public int compareTo(Object o) {
            if (o == null || getClass() != o.getClass()) return 0;
            Position position = (Position) o;
            return time - position.time;
        }
    }

    public static void main(String[] args){
        char[][] maze = {   {'*','*','*','*','*','*','*','*','*'},
                            {'*',' ',' ',' ','*',' ',' ','M','*'},
                            {'*',' ','*',' ','*','2',' ',' ','*'},
                            {'*',' ','*',' ','6','7','1','2','*'},
                            {'*',' ','*',' ',' ','*','*',' ','*'},
                            {'*',' ','*',' ',' ','5',' ',' ','*'},
                            {'*','S','8','7',' ',' ','2',' ','*'},
                            {'*','*','*','*','*','*','*','*','*'}};//25
        char[][] maze2 = {  {'*','*','*','*','*','*','*','*','*'},
                            {'*',' ',' ',' ','*',' ',' ','M','*'},
                            {'*',' ','*',' ','*','2',' ',' ','*'},
                            {'*',' ','*',' ','6','7','1','2','*'},
                            {'*',' ','*',' ',' ','*','*','9','*'},
                            {'*',' ','*',' ',' ','5',' ',' ','*'},
                            {'*','S','8','7',' ',' ','2',' ','*'},
                            {'*','*','*','*','*','*','*','*','*'}};//29
        char[][] maze3 = {  {'*','*','*','*','*','*','*','*','*'},
                            {'*','4','7','3','8','2','9','M','*'},
                            {'*','1','5','7','1','2','5','1','*'},
                            {'*','4','2','2','6','7','1','2','*'},
                            {'*','2','4','3','3','*','*','9','*'},
                            {'*','3','7','6','4','5','6','2','*'},
                            {'*','S','8','7','2','9','2','6','*'},
                            {'*','*','*','*','*','*','*','*','*'}};//39
        System.out.println(shortestTime(maze));
    }

    private static int shortestTime(char[][] maze) {
        Position startPosition=null, currentPosition, newPosition;
        int[][] timeAt = new int[maze.length][maze[0].length];
        for(int[] row: timeAt)
            Arrays.fill(row,-1);
        for(int i=0;i<maze.length;i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 'S'){
                    startPosition = new Position(i, j, 0);
                    timeAt[i][j] = 0;
                }
            }
        }
        PriorityQueue<Position> queue = new PriorityQueue<>();
        queue.offer(startPosition);
        while (!queue.isEmpty()){
            print(timeAt);
            System.out.println("***");
            currentPosition=queue.poll();
            if(maze[currentPosition.row][currentPosition.column]=='M')
                return currentPosition.time;
            int trapTime=0;
            if('1'<=maze[currentPosition.row][currentPosition.column] && maze[currentPosition.row][currentPosition.column]<='9') trapTime = maze[currentPosition.row][currentPosition.column] - '0';
            for(int i=0;i<4;i++){
                newPosition = currentPosition.newPosition(i,trapTime);
                if(maze[newPosition.row][newPosition.column]!='*' && (timeAt[newPosition.row][newPosition.column] == -1 || timeAt[newPosition.row][newPosition.column]>newPosition.time)){
                    timeAt[newPosition.row][newPosition.column] = newPosition.time;
                    queue.offer(newPosition);
                }
            }
        }
        return -1;
    }

    private static void print(int[][] v){
        for(int[] r:v)
            System.out.println(Arrays.toString(r));
    }

}
