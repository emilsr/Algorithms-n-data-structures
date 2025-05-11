package uppgift7;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    final static int SIZE = 4;
    static int calls;

    private static class Board{
        public char[][] board;

        public Board(int row, int col){
            board = new char[SIZE][SIZE];
            for(int i=0;i<SIZE;i++) Arrays.fill(board[i],'O');//O means marble
            board[row][col] = 'X';//X means empty
        }

        public Board(char[][] board1){
            board = new char[SIZE][SIZE];
            for(int i=0;i<SIZE;i++){
                for(int j=0;j<SIZE;j++) board[i][j]=board1[i][j];
            }
        }

        public Board copy(){
            return new Board(board);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Board board1)) return false;
            return Arrays.deepEquals(board, board1.board);
        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(board);
        }
    }

    public static void main(String[] args) {
        calls=0;
        System.out.println(solveSolitaire(0,1)+" : "+calls);
        calls=0;
        System.out.println(solveSolitaireDyn(0,2)+" : "+calls);
    }

    private static String solveSolitaireDyn(int row, int col) {
        if(row<0 || col<0 || row >= SIZE || col >= SIZE) return "Illegal input!";
        Board myBoard = new Board(row,col);
        HashSet<Board> memo = new HashSet<>();//Eftersom vi letar efter endast en lösning sparar vi bara misslyckade
        return solveSolitaireDyn(myBoard,SIZE*SIZE-1,memo);
    }
    private static String solveSolitaireDyn(Board myBoard, int nrMarbles, HashSet<Board> memo) {
        calls++;
        if (nrMarbles == 1) return "";
        if(memo.contains(myBoard)) return "X";
        String result;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (myBoard.board[row][col] == 'X') {
                    for (int type = 0; type < 4; type++) {
                        if (makeMove(myBoard.board, row, col, type)) {
                            result = solveSolitaireDyn(myBoard, nrMarbles - 1, memo);
                            if (!result.equals("X")) return move(row, col, type)+", "+result;
                            unMakeMove(myBoard.board, row, col, type);
                        }
                    }
                }
            }
        }
        memo.add(myBoard.copy());
        return "X";
    }

    private static String solveSolitaire(int row, int col) {//Denna räcker för A
        if(row<0 || col<0 || row >= SIZE || col >= SIZE) return "Illegal input!";
        char[][] board = new char[SIZE][SIZE];
        for(int i=0;i<SIZE;i++) Arrays.fill(board[i],'O');//O means marble
        board[row][col] = 'X';//X means empty
        return solveSolitaire(board,SIZE*SIZE-1);
    }
    private static String solveSolitaire(char[][] board, int nrMarbles) {
        calls++;
        if (nrMarbles == 1) return "";
        String result;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 'X') {
                    for (int type = 0; type < 4; type++) {
                        if (makeMove(board, row, col, type)) {
                            result = solveSolitaire(board, nrMarbles - 1);
                            if (!result.equals("X")) return move(row, col, type)+", "+result;
                            unMakeMove(board, row, col, type);
                        }
                    }
                }
            }
        }
        return "X";
    }

    private static String move(int row, int col, int type) {
        if (type == 0) return "("+row+","+(col-2)+")->("+row+","+col+")";
        if (type == 1) return "("+(row-2)+","+col+")->("+row+","+col+")";
        if (type == 2) return "("+row+","+(col+2)+")->("+row+","+col+")";
        if (type == 3) return "("+(row+2)+","+col+")->("+row+","+col+")";
        return "";
    }


    private static boolean makeMove(char[][] board, int row, int col, int type) {
        if (type == 0) {//hoppa från vänster
            if(col>=2 && board[row][col-1]=='O' && board[row][col-2]=='O'){
                board[row][col]='O';
                board[row][col-1]=board[row][col-2]='X';
                return true;
            }
            return false;
        }
        if (type == 1) {//hoppa uppifrån
            if(row>=2 && board[row-1][col]=='O' && board[row-2][col]=='O'){
                board[row][col]='O';
                board[row-1][col]=board[row-2][col]='X';
                return true;
            }
            return false;
        }
        if (type == 2) {//hoppa från höger
            if(col<SIZE-2 && board[row][col+1]=='O' && board[row][col+2]=='O'){
                board[row][col]='O';
                board[row][col+1]=board[row][col+2]='X';
                return true;
            }
            return false;
        }
        if (type == 3) {//hoppa nedifrån
            if(row<SIZE-2 && board[row+1][col]=='O' && board[row+2][col]=='O'){
                board[row][col]='O';
                board[row+1][col]=board[row+2][col]='X';
                return true;
            }
            return false;
        }
        return false;
    }
    private static void unMakeMove(char[][] board, int row, int col, int type) {
        if (type == 0) {//ohoppa från vänster
            board[row][col]='X';
            board[row][col-1]=board[row][col-2]='O';
        }
        if (type == 1) {//ohoppa uppifrån
            board[row][col]='X';
            board[row-1][col]=board[row-2][col]='O';
        }
        if (type == 2) {//ohoppa från höger
            board[row][col]='X';
            board[row][col+1]=board[row][col+2]='O';
        }
        if (type == 3) {//ohoppa nedifrån
                board[row][col]='X';
                board[row+1][col]=board[row+2][col]='O';
        }
    }


}
