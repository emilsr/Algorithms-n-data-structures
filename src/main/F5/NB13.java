package main.F5;

public class NB13 {

    public static double rot(double n, double a, double e){
        if (n < 0){
            throw new ArithmeticException("n < 0");
        }
        if (n == 0){
            return 0;
        }
        double temp = Math.abs(a*a - n);
        if (temp < e) {
            System.out.println("temp: " + temp);
            return a;
        }
        a = ((a*a)+n) / (2*a);
        System.out.println("a: " + a);
        return rot(n, a, e);
    }

    public static void main(String[] args) {
        System.out.println(rot(4, 4, 0.01));
    }


}
