package main.tentaPrep.recursion;

public class MarbleGame {
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



    public static void main(String[] args) {
        System.out.println("Should give 1: "+ tradeD(2,0,5));
        System.out.println("Should give 2: "+ tradeD(1,1,0));
        System.out.println("Should give 9: "+ tradeD(2,0,1));
        System.out.println("Should give 9: "+ tradeD(3,1,2));
        System.out.println("Should give 3: "+ tradeD(5,1,2));
        System.out.println("Should give 15: "+ tradeD(5,3,1));
    }

}
