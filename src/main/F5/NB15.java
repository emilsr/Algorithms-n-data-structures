package main.F5;

/**
 * Skriv en rekursiv statisk metod som tar en textsträng med ett tal i binär form och returnerar
 * motsvarande heltal. Använd en wrapper-metod om det behövs. Exempel: ”1011” ska returnera 11.
 * Skriv också en metod som tar en int och returnerar en sträng med det binära talet. Även här behöver
 * du antagligen en wrapper-metod.
 */

public class NB15 {

    public static int binaryToInt(String binary) {
        return binaryToInt(binary, binary.length() - 1, 0);
    }

    private static int binaryToInt(String binary, int index, int result) {
        if (index < 0) {
            return result;
        }

        int bit = binary.charAt(index) - '0';
        result += bit * Math.pow(2, binary.length() - 1 - index);
        return binaryToInt(binary, index - 1, result);
    }

    public static String intToBinary(int number) {
        if (number == 0) {
            return "0";
        }
        return intToBinary(number, "");
    }

    private static String intToBinary(int number, String binary) {
        if (number == 0) {
            return binary;
        }

        binary = (number % 2) + binary;
        return intToBinary(number / 2, binary);
    }

    public static void main(String[] args) {
        // Testa binaryToInt
        String binaryStr = "110100100";
        int decimalValue = binaryToInt(binaryStr);
        System.out.println("Binary " + binaryStr + " to Decimal: " + decimalValue);

        // Testa intToBinary
        int number = 420;
        String binaryRepresentation = intToBinary(number);
        System.out.println("Decimal " + number + " to Binary: " + binaryRepresentation);
    }
}
