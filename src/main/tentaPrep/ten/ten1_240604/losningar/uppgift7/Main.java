package main.tentaPrep.ten.ten1_240604.losningar.uppgift7;

import java.util.*;

public class Main {

    static int nr;
    public static class State{
        public int[][] board;
        public int nrMoves;

        public State(int[][] b,int n){
            board=b;
            nrMoves=n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State s = (State) o;
            return Arrays.deepEquals(board,s.board);
        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(board);
        }

        //0-Upper left, 1-Upper right, 2-Lower left, 3 Lower right
        public State rotate(int kind){
            int[][] newBoard = new int[3][3];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++) newBoard[i][j] = board[i][j];
            }
            switch(kind){
                case 0:
                    newBoard[0][0] = board[1][0];
                    newBoard[0][1] = board[0][0];
                    newBoard[1][0] = board[1][1];
                    newBoard[1][1] = board[0][1];
                    break;
                case 1:
                    newBoard[0][1] = board[1][1];
                    newBoard[0][2] = board[0][1];
                    newBoard[1][1] = board[1][2];
                    newBoard[1][2] = board[0][2];
                    break;
                case 2:
                    newBoard[1][0] = board[2][0];
                    newBoard[1][1] = board[1][0];
                    newBoard[2][0] = board[2][1];
                    newBoard[2][1] = board[1][1];
                    break;
                case 3:
                    newBoard[1][1] = board[2][1];
                    newBoard[1][2] = board[1][1];
                    newBoard[2][1] = board[2][2];
                    newBoard[2][2] = board[1][2];
                    break;
            }
            return new State(newBoard,nrMoves+1);
        }

        public boolean correct() {
            return Arrays.deepEquals(board,new int[][] {{1,2,3}, {4,5,6}, {7,8,9}});
        }
    }


    public static void main(String[] args) {

        int[][] board= {{8,9,1},
                        {3,4,7},
                        {2,5,6}};
        nr=0;
        System.out.println(solve(board)+":"+nr);
    }
    private static int solve(int [][] board){
        Queue<State> queue = new ArrayDeque<>();
        Set<State> taken = new HashSet<>();
        State currentState = new State(board,0);
        queue.offer(currentState);
        taken.add(currentState);
        State newState;
        while(!queue.isEmpty()){
            nr++;
            currentState = queue.poll();
            if(currentState.correct()) return currentState.nrMoves;
            for(int i=0;i<4;i++){
                newState = currentState.rotate(i);
                if(taken.add(newState)){
                    queue.offer(newState);
                }
            }

        }
        return -1;
    }

}
