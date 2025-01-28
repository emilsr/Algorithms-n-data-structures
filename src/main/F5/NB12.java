package main.F5;

//Skriv en rekursiv static metod som beräknar x^n där n är ett positivt heltal. Skriv en iterativ metod som
//löser samma uppgift.

public class NB12 {

    public static int xByPowerOfN(int x, int n){
        return xByPowerOfN(x, n, 1);
    }

    public static int xByPowerOfN(int x, int n, int current){
        if (current == n ) {
            return x;
        }
        return x * xByPowerOfN(x, n, current+1);
    }

    public static int xByPowerOfNIterator(int x, int n){
        int tot = x;
        for (int i = 1; i < n; i++){
            tot = tot * x;
        } return tot;
    }

    public static void main(String[] args){
        System.out.println(xByPowerOfN(0, 2));
        System.out.println(xByPowerOfNIterator(3, 4));

    }
}
