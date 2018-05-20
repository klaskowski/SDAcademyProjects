import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MorseCode morseCode = new MorseCode();
        System.out.println("Please input your message:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.toLowerCase();
        System.out.println("Original message: ");
        System.out.println(input);
        String output = new String();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String s = String.valueOf(c);
            String mCode = MorseCode.MORSE_CODE.get(s);
            if (mCode == null) {
                mCode = " ";
            }
            output = output.concat(mCode);
        }
        System.out.println("Translated message: ");
        System.out.println(output);
    }
}
