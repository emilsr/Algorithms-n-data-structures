package main.tentaPrep.ten2_240313.uppgift4;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println(minNrOfStepsA(70));
        //System.out.println(minNrOfStepsB(70));
        System.out.println(minStepsWidthC(70));
    }

    private static int minNrOfStepsA(int position) {
        return minNrOfStepsA(position , 0);
    }

    private static int minNrOfStepsA(int position, int steps){
        if (position == 1){
            System.out.println("we got here!!!!");
            return steps;
        }
        if (steps>50) return -1;
        if (position % 7 == 0 && position > 20){
            System.out.println("P: " + position + " S: " + steps);
            return minNrOfStepsA(position-20, steps+1);
        }
        if (position % 5 == 0 && position > 16){
            System.out.println("P: " + position + " S: " + steps);
            return minNrOfStepsA(position-16, steps+1);
        }
        if (position % 2 == 0){
            System.out.println("P: " + position + " S: " + steps);
            return minNrOfStepsA(position/2, steps+1);
        }
        if (position > 7) {
            System.out.println("P: " + position + " S: " + steps);
            return minNrOfStepsA(position-7, steps+1);
        }
        return -1;
    }

    private static int minNrOfStepsB(int position) {
        return 0;
    }

    private static int minStepsWidthC(int position){
        if (position == 1) return 0;

        Queue<State> q = new LinkedList<>();
        State state = new State(position, 0);
        q.offer(state);

        while (!q.isEmpty()){
            state = q.poll();
            if (state.p == 1) return state.s;
            if (state.p % 7 == 0 && state.p > 20) q.offer(new State(state.p-20, state.s+1));
            if (state.p % 5 == 0 && state.p > 16) q.offer(new State(state.p-16, state.s+1));
            if (state.p % 2 == 0) q.offer(new State(state.p/2, state.s+1));
            if (state.p > 7) q.offer(new State(state.p-7, state.s+1));
        }
        return -1;
    }

    private static class State{
        int p = 0;
        int s = 0;

        private State(int p, int s){
            this.p = p;
            this.s = s;
        }
    }
}
