package main.tentaPrep.recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MarbleGameW {

    public static class State{
        int red, white, blue, trades;

        public State(int r, int w, int b, int t){
            red = r;
            white = w;
            blue = b;
            trades = t;
        }

        @Override
        public int hashCode() {
            return 31 * (31 * (31 * red + white) + blue) + trades;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            State state = (State) obj;
            return red == state.red && white == state.white && blue == state.blue && trades == state.trades;
        }
    }


    private static int tradeW(int red, int white, int blue) {
        Queue<State> que = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        State initState = new State(red, white, blue, 0);
        que.offer(initState);
        visited.add(initState);

        while(!que.isEmpty()) {
            State currentState = que.poll();

            if (winCom(currentState)){
                return currentState.trades;
            }
            if (currentState.trades > 15){
                return Integer.MAX_VALUE/2;
            }

            State[] nextSates = new State[] {
                    new State(currentState.red + 3, currentState.white + 1, currentState.blue - 1, currentState.trades + 1),
                    new State(currentState.red + 4, currentState.white - 1, currentState.blue + 2, currentState.trades + 1),
                    new State(currentState.red - 1, currentState.white + 5, currentState.blue + 1, currentState.trades + 1)
            };

            for (State nextState : nextSates) {
                if (nextState.red >= 0 && nextState.white >= 0 && nextState.blue >= 0) {
                    if (!visited.contains(nextState)) {
                        que.offer(nextState);
                        visited.add(nextState);
                    }
                }
            }
        }
        return Integer.MAX_VALUE/2;
    }

    private static boolean winCom(State s){
        return s.red == s.white && s.white == s.blue;
    }

    public static void main(String[] args) {
        System.out.println("Should give 1: "+ tradeW(0,5,2));
        System.out.println("Should give 2: "+ tradeW(1,0,1));
        System.out.println("Should give 9: "+ tradeW(0,1,2));
        System.out.println("Should give 9: "+ tradeW(1,2,3));
        System.out.println("Should give 3: "+ tradeW(1,2,5));
        System.out.println("Should give 15: "+ tradeW(3,1,5));


    }
}
