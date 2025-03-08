package main.tentaPrep.ten.ten2_240313.uppgift4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println(minNrOfStepsA(10));
        System.out.println(minNrOfStepsB(3));
        System.out.println(minStepsWidthC(3));
        System.out.println(minNrOfStepsA(623));
        System.out.println(minNrOfStepsB(623));
        System.out.println(minStepsWidthC(623));
    }

    private static int minNrOfStepsA(int position) {
        int answer = minNrOfStepsA(position , 0);
        if (answer == Integer.MAX_VALUE/2){
            return -1;
        }
        return answer;
    }

    private static int minNrOfStepsA(int position, int steps){
        int a= Integer.MAX_VALUE/2, b = Integer.MAX_VALUE/2, c = Integer.MAX_VALUE/2, d = Integer.MAX_VALUE/2;
        if (position == 1){
            return steps;
        }
        if (position<1){
            return Integer.MAX_VALUE/2;
        }
        if(position%7 == 0){
            a = minNrOfStepsA(position-20, steps+1);
        } if (position%5 == 0){
             b = minNrOfStepsA(position-16, steps+1);
        } if (position%2==0){
            c = minNrOfStepsA(position/2, steps+1);
        }
        d = minNrOfStepsA(position-7, steps+1);

        return Math.min(Math.min(a, b), Math.min(c, d));
    }

    private static int minNrOfStepsB(int position) {
        int [] memory = new int[position+1];
        Arrays.fill(memory, -1);
        int answer = minNrOfStepsB(position, memory);
        if (answer-1 == Integer.MAX_VALUE/2) return -1;
        return answer;
    }

    private static int minNrOfStepsB(int position, int[] memory){
        int steps;
        if (position < 1){
            return Integer.MAX_VALUE/2;
        }
        if (memory[position] != -1){
            return memory[position];
        }
        if (position == 1){
            return 0;
        }

        steps = minNrOfStepsB(position-7, memory);
        if (position%7==0) steps = Math.min(steps, minNrOfStepsB(position-20, memory));
        if (position%5==0) steps = Math.min(steps, minNrOfStepsB(position-16, memory));
        if (position%2==0) steps = Math.min(steps, minNrOfStepsB(position/2, memory));

        return memory[position] = steps +1;
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
