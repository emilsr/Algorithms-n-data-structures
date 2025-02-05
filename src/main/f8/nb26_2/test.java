package main.f8.nb26_2;

public class test {
    public static void main(String[] args) {
        String[] arr = {"man", "gråter", "när", "man", "tänker", "när"};
        UniqueCount u = new UniqueCount();
        System.out.println(u.uniqueCount(arr));
    }
}
