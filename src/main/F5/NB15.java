package main.F5;

/**
 * Skriv en rekursiv statisk metod som tar en textsträng med ett tal i binär form och returnerar
 * motsvarande heltal. Använd en wrapper-metod om det behövs. Exempel: ”1011” ska returnera 11.
 * Skriv också en metod som tar en int och returnerar en sträng med det binära talet. Även här behöver
 * du antagligen en wrapper-metod.
 */

public class NB15 {

    public static int binaryToInt(String binary) {
        if (binary.length() == 0){
            return 0;
        }
        else if (binary.length() == 1) return Integer.parseInt(binary);


        return 0;
    }
}
