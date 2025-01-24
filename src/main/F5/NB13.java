package main.F5;

public class NB13 {

    public static double rot(int n, int a, int e){
        if (a*a - n > e) {
            return a;
        }
        a = (a*a +n) / 2*a;
        return rot(n, a, e);
    }

    

}
