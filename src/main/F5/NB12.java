package main.F5;

//Skriv en rekursiv static metod som beräknar x^n där n är ett positivt heltal. Skriv en iterativ metod som
//löser samma uppgift.

public class NB12 {

    public static int xByPowerOfN(int x, int n){
        return xByPowerOfN(x, n, 1);
    }

    public static int xByPowerOfN(int x, int n, int curent){
        if (curent == n ) {
            return x;
        }
        return x = x * xByPowerOfN(x, n, curent+1);
    }

    public static int xByPowerOfNIterator(int x, int n){
        int tot = x;
        for (int i = 1; i < n; i++){
            tot = tot * x;
        } return tot;
    }

    public static void main(String[] args){
        System.out.println(xByPowerOfN(3, 4));
        System.out.println(xByPowerOfNIterator(3, 4));

    }
}
