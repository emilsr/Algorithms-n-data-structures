package main.f6.nb16;

import java.util.LinkedList;
import java.util.Queue;

public class NB16 {

    public static class State{
        int blue;
        int white;
        int red;
        int trades;
        
        State(int b, int w, int r, int t){
            this.blue = b;
            this.white = w;
            this.red = r;
            this.trades = t;
        }
    }


    public static int tradeMarble(int b, int w, int r){
        Queue<State> tradeQueue = new LinkedList<>(); 
        State gameState = new State(b, w, r, 0);
        while (!winCon(gameState) && gameState.trades < 15) {
            tradeQueue.offer(new State(gameState.blue - 1, gameState.white + 3, gameState.red + 1, gameState.trades + 1));
            tradeQueue.offer(new State(gameState.blue + 3, gameState.white - 1, gameState.red + 4, gameState.trades + 1));
            tradeQueue.offer(new State(gameState.blue + 2, gameState.white + 1, gameState.red - 1, gameState.trades + 1));
            gameState = tradeQueue.poll();
        }
        return gameState.trades;
    }

    private static boolean winCon(State s){
        if (s.red == s.white && s.red == s.blue) {
            return true;
        } return false;
    }


    public static void main(String[] args) {
        System.out.println(tradeMarble(5, 1, 3));
        System.out.println(tradeMarble(2, 1, 3));
        System.out.println(tradeMarble(22, 22, 13));
    }

}
