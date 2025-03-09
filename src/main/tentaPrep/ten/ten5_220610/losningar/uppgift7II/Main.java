package main.tentaPrep.ten.ten5_220610.losningar.uppgift7II;

import java.util.*;

public class Main {

    private static class Mancala{
        private final int[] marbles;

        public Mancala(int[] marbles){
            this.marbles = Arrays.copyOf(marbles,5);
        }

        @Override
        public String toString() {
            return "Mancala{" +
                    "marbles=" + Arrays.toString(marbles) +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Mancala mancala = (Mancala) o;
            return Arrays.equals(marbles, mancala.marbles);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(marbles);
        }

        public Mancala makeMove(int pot, boolean clockwise){
            Mancala m = new Mancala(marbles);
            int nrOfMarbles = m.marbles[pot];
            m.marbles[pot] = 0;
            if(clockwise){
                while(nrOfMarbles>0){
                    m.marbles[pot]++;
                    nrOfMarbles--;
                    pot = (pot+1)%5;
                }
            }else{
                while(nrOfMarbles>0){
                    m.marbles[pot]++;
                    nrOfMarbles--;
                    pot=(pot-1+5)%5;
                }
            }
            return m;
        }
    }

    private static class State{
        private Mancala board;
        private int nrMoves;

        public State(Mancala board, int nrMoves) {
            this.board = board;
            this.nrMoves = nrMoves;
        }
    }

    public static void main(String[] args) {
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {5,4,3,2,1}));//4
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {4,4,3,2,2}));//3
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {1,2,4,3,5}));//5
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {1,2,4,4,5}));//olösbar
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {15,0,0,0,0}));//olösbar
    }

    private static int leastMancalaMoves(int[] start, int[] end) {
        Queue<State> que = new ArrayDeque<>();
        State current = new State(new Mancala(start),0);
        Mancala goal = new Mancala(end),next;
        HashSet<Mancala> set = new HashSet<>();
        set.add(current.board);
        while(!current.board.equals(goal)){
            for(int move = 0; move<5;move++){
                next = current.board.makeMove(move,true);
                if(!set.contains(next)){
                    set.add(next);
                    que.offer(new State(next,current.nrMoves+1));
                }
                next = current.board.makeMove(move,false);
                if(!set.contains(next)){
                    set.add(next);
                    que.offer(new State(next,current.nrMoves+1));
                }
            }
            if(que.isEmpty()) return -1;
            current = que.poll();
        }
        return current.nrMoves;
    }


}
