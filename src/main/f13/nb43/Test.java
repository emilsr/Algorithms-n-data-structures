package main.f13.nb43;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ChangeExchange changeExchange = new ChangeExchange(new int[]{500, 12, 10, 1});
        System.out.println(Arrays.toString(changeExchange.exchange(520)));
    }
}
