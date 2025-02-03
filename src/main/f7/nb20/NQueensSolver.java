package main.f7.nb20;

import java.util.ArrayList;
import java.util.List;

public class NQueensSolver {
    private int boardSize;
    private List<List<String>> solutions;

    public NQueensSolver(int n) {
        this.boardSize = n;
        this.solutions = new ArrayList<>();
    }

    public void solve() {
        // Skapa ett tomt bräde
        char[][] board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '.';
            }
        }

        // Starta rekursiv lösning från första raden
        solveNQueens(board, 0);

        // Skriv ut antal lösningar och alla lösningar
        System.out.println("Antal lösningar: " + solutions.size());
        printSolutions();
    }

    private void solveNQueens(char[][] board, int row) {
        // Bas fall: Om alla damer är placerade, lägg till lösningen
        if (row == boardSize) {
            solutions.add(constructSolution(board));
            return;
        }

        // Försök placera en dam i varje kolumn i denna rad
        for (int col = 0; col < boardSize; col++) {
            if (isSafe(board, row, col)) {
                // Placera dam
                board[row][col] = 'Q';

                // Rekursivt försök placera nästa dam
                solveNQueens(board, row + 1);

                // Backa (ta bort damen för att pröva andra placeringar)
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // Kontrollera samma kolumn
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Kontrollera vänster diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Kontrollera höger diagonal
        for (int i = row, j = col; i >= 0 && j < boardSize; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    private void printSolutions() {
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("\nLösning " + (i + 1) + ":");
            for (String row : solutions.get(i)) {
                System.out.println(row);
            }
        }
    }

    public static void main(String[] args) {
        // Exempel användning med 4 damer
        NQueensSolver solver = new NQueensSolver(5);
        solver.solve();
    }
}