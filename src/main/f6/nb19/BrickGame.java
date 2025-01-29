package main.f6.nb19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrickGame {
    enum Piece {
        BLACK, WHITE, EMPTY
    }

    static class Move {
        int from, to;

        Move(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return (from + 1) + "->" + (to + 1);
        }
    }

    static boolean isTargetState(Piece[] board) {
        Piece[] target = {
                Piece.WHITE, Piece.WHITE, Piece.WHITE,
                Piece.EMPTY,
                Piece.BLACK, Piece.BLACK, Piece.BLACK
        };
        return Arrays.equals(board, target);
    }

    static boolean canMove(Piece[] board, int from, int to) {
        // Check bounds
        if (to < 0 || to >= board.length) return false;

        // Check if destination is empty
        if (board[to] != Piece.EMPTY) return false;

        // Check piece movement rules
        if (board[from] == Piece.BLACK && to <= from) return false;
        if (board[from] == Piece.WHITE && to >= from) return false;

        // For jumps (distance of 2)
        if (Math.abs(to - from) == 2) {
            int middle = (from + to) / 2;
            return board[middle] != Piece.EMPTY;
        }

        // For single moves (distance of 1)
        return Math.abs(to - from) == 1;
    }

    static Piece[] makeMove(Piece[] board, Move move) {
        Piece[] newBoard = Arrays.copyOf(board, board.length);
        newBoard[move.to] = newBoard[move.from];
        newBoard[move.from] = Piece.EMPTY;
        return newBoard;
    }

    static void findSolutions(Piece[] board, List<Move> moves) {
        if (isTargetState(board)) {
            System.out.println(formatMoves(moves));
            return;
        }

        for (int pos = 0; pos < board.length; pos++) {
            if (board[pos] == Piece.EMPTY) continue;

            // Try all possible moves for current piece
            for (int offset : new int[]{1, 2, -1, -2}) {
                int newPos = pos + offset;
                if (canMove(board, pos, newPos)) {
                    Move move = new Move(pos, newPos);
                    Piece[] newBoard = makeMove(board, move);

                    moves.add(move);
                    findSolutions(newBoard, moves);
                    moves.remove(moves.size() - 1);  // backtrack
                }
            }
        }
    }

    static String formatMoves(List<Move> moves) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moves.size(); i++) {
            sb.append(moves.get(i));
            if (i < moves.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Piece[] initialBoard = {
                Piece.BLACK, Piece.BLACK, Piece.BLACK,
                Piece.EMPTY,
                Piece.WHITE, Piece.WHITE, Piece.WHITE
        };

        findSolutions(initialBoard, new ArrayList<>());
    }
}