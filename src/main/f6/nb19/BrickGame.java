package main.f6.nb19;

import java.util.List;

public class BrickGame {
    public enum Cell {
        BLANK,
        WHITE,
        EMPTY,
    }

    public class Move{
        int from, to;
        public Move(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "(" + from + "-->" + to + ") ";
        }
    }


    public void findSolutions(Cell[] board, List<Move> moves) {
        if (isTargetState(board)){
            System.out.println(formatMoves(moves));
            return;
        }

        for (Move move : moves) {}
    }
}
