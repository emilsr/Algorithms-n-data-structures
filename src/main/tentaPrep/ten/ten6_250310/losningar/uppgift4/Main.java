package uppgift4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int nrCalls;
    public static void main(String[] args){
        nrCalls=0;
        System.out.println(mostStones(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1}));
        System.out.println(nrCalls);
        System.out.println(mostStones2(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1}));
        nrCalls=0;
        System.out.println(mostStonesDyn(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1}));
        System.out.println(nrCalls);

        System.out.println(mostStones(new int[]{1, 3, 1, 0, 2, 0, 3, 3, 0, 3, 2, 3, 0, 1}));
        System.out.println(mostStones2(new int[]{1, 3, 1, 0, 2, 0, 3, 3, 0, 3, 2, 3, 0, 1}));
        System.out.println(mostStonesDyn(new int[]{1, 3, 1, 0, 2, 0, 3, 3, 0, 3, 2, 3, 0, 1}));

        System.out.println("**************************");
        System.out.println(mostStones(new int[]{3, 2,2,2,2,3, 2}));
        System.out.println(mostStones(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1}));
        System.out.println(mostStones(new int[]{1, 3, 1, 0, 2, 0, 3, 3, 0, 3, 2, 3, 0, 1}));
        System.out.println(mostStones(new int[]{0,0,0,0,0,0,0,0,0}));
        System.out.println(mostStones(new int[]{1,1,1,1,1,1,1,1,1,1}));
        System.out.println(mostStones(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1}));
        System.out.println(mostStones(new int[]{3, 2, 1, 0,0,  1, 3,0, 1, 2, 3, 1, 3 , 0 , 1, 2, 0, 2, 3, 0, 3}));
        System.out.println(mostStones(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1, 3, 2, 0, 1, 0, 3, 1, 3}));
        System.out.println(mostStones(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1, 0, 0, 0 , 1, 2, 3, 1, 0}));
        System.out.println(mostStones(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1, 3, 3, 3,2, 2, 2, 1, 1, 1, 3, 2}));
        System.out.println("**************************");
        System.out.println(mostStonesDyn(new int[]{3, 2,2,2,2,3, 2}));
        System.out.println(mostStonesDyn(new int[]{1, 3, 1, 0, 2, 0, 3, 3, 0, 3, 2, 3, 0, 1}));
        System.out.println(mostStonesDyn(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1}));
        System.out.println(mostStonesDyn(new int[]{0,0,0,0,0,0,0,0,0}));
        System.out.println(mostStonesDyn(new int[]{1,1,1,1,1,1,1,1,1,1}));
        System.out.println(mostStonesDyn(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1}));
        System.out.println(mostStonesDyn(new int[]{3, 2, 1, 0,0,  1, 3,0, 1, 2, 3, 1, 3 , 0 , 1, 2, 0, 2, 3, 0, 3}));
        System.out.println(mostStonesDyn(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1, 3, 2, 0, 1, 0, 3, 1, 3}));
        System.out.println(mostStonesDyn(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1, 0, 0, 0 , 1, 2, 3, 1, 0}));
        System.out.println(mostStonesDyn(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1, 3, 3, 3,2, 2, 2, 1, 1, 1, 3, 2}));
    }

    private static int mostStones(int[] stones) {
        return mostStones(stones, 0);
    }

    private static int mostStones(int[] stones, int position) {
        nrCalls++;
        if(position>=stones.length) return 0;
        int max=0;
        for(int i=0;i<=stones[position];i++){
            max = Math.max(max,i+mostStones(stones,position+1+i*2));
        }
        return max;
    }

    private static int mostStonesDyn(int[] stones) {
        int[] memo = new int[stones.length];
        Arrays.fill(memo,-1);
        return mostStonesDyn(stones, 0,memo);
    }

    private static int mostStonesDyn(int[] stones, int position, int[] memo) {
        nrCalls++;
        if(position>=stones.length) return 0;
        if(memo[position]!=-1) return memo[position];
        int max=0;
        for(int i=0;i<=stones[position];i++){
            max = Math.max(max,i+mostStonesDyn(stones,position+1+i*2, memo));
        }
        return memo[position]=max;
    }

    //Denna ingår inte i uppgiften
    private static ArrayList<Integer> mostStones2(int[] stones) {
        return mostStones2(stones, 0);
    }

    private static ArrayList<Integer> mostStones2(int[] stones, int position) {
        if(position>=stones.length) return new ArrayList<>();
        ArrayList<Integer> best = new ArrayList<>(), current;
        int max=0;
        for(int i=0;i<=stones[position];i++){
            current = mostStones2(stones,position+1+i*2);
            current.add(0,i);
            if(max<sum(current)){
                max = sum(current);
                best=current;
            }
        }
        return best;
    }

    private static int sum(ArrayList<Integer> list){
        int sum=0;
        for(Integer number:list){
            sum+=number;
        }
        return sum;
    }
}
