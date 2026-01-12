package ciphers;
import java.util.Scanner;

public class Binairy implements Encrypt{
    // Zentraler Scanner wird genutzt
    private final Scanner input;

    public Binairy(Scanner input) {
        this.input = input;
    }

    @Override
    public void encrypt() {
        StringBuilder result = new StringBuilder();
        System.out.println("Geben Sie den Satz ein, den Sie verschlüsseln möchten.");
        String enter = input.nextLine();
        for (char c : enter.toCharArray()) {
            if(Character.isLetter(c)){
                // Jeder Char muss 8 Bit abbilden. Daher werden alle Chars auf 8Bit mit Nullen ersetzt
                // und dann in Binär-Code umgewandelt
                // Anschließend wird es zum Stringbuilder hinzugefügt
                result.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0')).append(" ");
            } else if(Character.isWhitespace(c)){
                result.append(" ");
            }else {
                result.append(c).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }

    @Override
    public void decrypt() {
        StringBuilder result = new StringBuilder();
        System.out.println("Geben Sie den Satz ein, den Sie entschlüsseln möchten.");
        String enter = input.nextLine();
        String[] enterInt = enter.split(" ");               // Teilt in 8Bit-Block-Strings
        for (String token : enterInt) {
            if (token.matches("[01]{8}")) {
                result.append((char) Integer.parseInt(token, 2));
            } else if (token.isEmpty()) {
                result.append(" ");
            } else {
                result.append(token);
            }
        }
        System.out.println(result.toString().trim());
    }
}
