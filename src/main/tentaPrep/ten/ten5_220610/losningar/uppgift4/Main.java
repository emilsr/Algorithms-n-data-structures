package main.tentaPrep.ten.ten5_220610.losningar.uppgift4;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    private static class State{
        public int pos,i;

        public State(int pos, int i) {
            this.pos = pos;
            this.i = i;
        }

        public State jumpUp(){
            return new State(pos+(2*i-1),i+1);
        }

        public State jumpDown(){
            return new State(pos-(2*i-1),i+1);
        }

        public boolean canJumpDown(){
            return pos-(2*i-1)>=0;
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<=50;i++) {
            System.out.println(numberJumps(i, 4)+":"+numberJumps2(i, 4));
        }
    }

    private static int numberJumps(int start, int goal) {
        return numberJumps(start,goal,1);
    }

    private static int numberJumps(int pos, int goal, int i) {
        if(pos == goal) return 0;
        if(i == 16 || pos<0) return Integer.MAX_VALUE/2;
        return 1+Math.min(numberJumps(pos-(2*i-1),goal,i+1),numberJumps(pos+(2*i-1),goal,i+1));
    }

    private static int numberJumps2(int start, int goal) {
        Queue<State> que = new ArrayDeque<>();
        State current = new State(start,1);
        while(current.pos!=goal){
            que.offer(current.jumpUp());
            if(current.canJumpDown())
                que.offer(current.jumpDown());
            current = que.poll();
        }
        return current.i-1;
    }
}
