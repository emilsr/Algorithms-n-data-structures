package main.tentaPrep.recursion;

import java.util.LinkedList;
import java.util.Queue;

public class MarbleGame {
    /**
     * Goal: trade marbles so you have the same nr of marble of etch color in as fue moves as possible.
     * Rols:
     *
     */

    private class State{
        int red, white, blue, trades;

        public State(int r, int w, int b, int t){
            red = r;
            white = w;
            blue = b;
            trades = t;
        }
    }

    public static int tradeD(int blue, int red, int white){
        return tradeD(blue, red, white, 0);
    }

    private static int tradeD(int blue, int red, int white, int trades){
        if (blue == red && red == white) return trades;
        if (trades > 15) return Integer.MAX_VALUE/2;

        return Math.min(tradeD(blue-1, red+3, white+1, trades+1),
                Math.min((tradeD(blue+2, red+4, white-1, trades+1)),
                        tradeD(blue+1, red-1, white+5, trades+1)));
    }

    private int tradeW( int red, int white, int blue) {
        Queue<State> que = new LinkedList<>();
        State gameState = new State(red, white, blue, 0);
        while(!winCom(gameState) && gameState.trades < 15); {
            que.offer(new State(gameState.red+3, gameState.white+1, gameState.blue-1, gameState.trades + 1));
            que.offer(new State(gameState.red-1, gameState.white+5, gameState.blue+1, gameState.trades + 1));
            que.offer(new State(gameState.red+4, gameState.white-1, gameState.blue+2, gameState.trades + 1));
        }
        return que.poll().trades;
    }

    private boolean winCom(State s){
        return (s.red == s.white && s.white == s.blue);
    }

    public static void main(String[] args) {
        System.out.println("Should give 1: "+ tradeD(2,0,5));
        System.out.println("Should give 2: "+ tradeD(1,1,0));
        System.out.println("Should give 9: "+ tradeD(2,0,1));
        System.out.println("Should give 9: "+ tradeD(3,1,2));
        System.out.println("Should give 3: "+ tradeD(5,1,2));
        System.out.println("Should give 15: "+ tradeD(5,3,1));
        System.out.println("-----------------------------------------------");
        System.out.println("Should give 1: "+ tradeW(2,0,5));
        System.out.println("Should give 2: "+ tradeW(1,1,0));
        System.out.println("Should give 9: "+ tradeW(2,0,1));
        System.out.println("Should give 9: "+ tradeW(3,1,2));
        System.out.println("Should give 3: "+ tradeW(5,1,2));
        System.out.println("Should give 15: "+ tradeW(5,3,1));


    }

}
