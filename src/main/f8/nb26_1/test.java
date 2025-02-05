package main.f8.nb26_1;

public class test {
    public static void main(String[] args) {
        String[] arr = {"man", "gråter" , "när" ,"man","tänker","när"};
        FrequentCount test = new FrequentCount();
        System.out.println(test.frequentCount(arr));
    }
}
