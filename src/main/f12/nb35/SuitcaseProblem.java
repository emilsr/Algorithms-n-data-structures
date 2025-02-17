package main.f12.nb35;


import java.util.Scanner;

public class SuitcaseProblem {
    int suitcaseWeight;
    int[] weightsOfItems = new int[10];
    int[] valuesOfItems = new int[10];


    public void run(){
        State currentState = main.f12.nb35.State.SUITCASE;
        System.out.println("Running SuitcaseProblem");
        System.out.println("enter max wight for the suitcase, ENTER 0 to exit: ");
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (scanner.nextInt() != 0){
            if ( currentState == State.SUITCASE){
                    suitcaseWeight = scanner.nextInt();
                    currentState = State.PACKAGE_VALUE;
            } else if (currentState == State.PACKAGE_VALUE){
                System.out.println("enter a value for the package, ENTER 0 to exit: ");
                valuesOfItems[n] = scanner.nextInt();
            } else if (currentState == State.PACKAGE_WEIGHT){
                System.out.println("enter a weight for the package, ENTER 0 to exit: ");
                weightsOfItems[n] = scanner.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        SuitcaseProblem suitcaseProblem = new SuitcaseProblem();
        suitcaseProblem.run();
    }
}
