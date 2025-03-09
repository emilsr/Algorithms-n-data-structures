package main.tentaPrep.ten.ten5_220610.losningar.uppgift7;

import java.util.*;

public class Main {

    private static class Mancala{
        private final int[] marbles;

        public Mancala(int[] marbles){
            this.marbles = Arrays.copyOf(marbles,5);
        }

        @Override
        public String toString() {
            return "Mancala{" + Arrays.toString(marbles) + '}';
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

    public static void main(String[] args) {
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {5,4,3,2,1}));//4
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {4,4,3,2,2}));//3
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {1,2,4,3,5}));//5
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {15,0,0,0,0}));//olösbar
    }

    private static int leastMancalaMoves(int[] start, int[] end) {
        HashMap<Mancala,Integer> memo = new HashMap<>();
        int result = leastMancalaMoves(new Mancala(start), new Mancala(end), 0, memo);
        return result<Integer.MAX_VALUE ? result : -1;
    }

    private static int leastMancalaMoves(Mancala current, Mancala goal, int nrMoves, HashMap<Mancala,Integer> memo) {
        if(nrMoves>5) return Integer.MAX_VALUE;
        if(current.equals(goal)) return 0;
        if(memo.containsKey(current)) return memo.get(current);
        int best=Integer.MAX_VALUE,result;
        Mancala next;
        for(int move = 0; move<5;move++){
            next = current.makeMove(move,true);
            best = Math.min(leastMancalaMoves(next,goal,nrMoves+1,memo),best);
            next = current.makeMove(move,false);
            best = Math.min(leastMancalaMoves(next,goal,nrMoves+1,memo),best);
        }
        if(best<Integer.MAX_VALUE) {
            memo.put(current, best + 1);
            return best + 1;
        }
        return Integer.MAX_VALUE;
    }
}
