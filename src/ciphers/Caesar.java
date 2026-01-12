package ciphers;
import java.util.Scanner;

public class Caesar implements Encrypt{
    // Zentraler Scanner wird genutzt
    private final Scanner input;

    public Caesar(Scanner input) {
        this.input = input;
    }

    @Override
    public void encrypt() {
        // Eingabe-Aufforderung
        System.out.println("Geben Sie den Satz ein, den Sie verschlüsseln möchten.");
        String enter1 = input.nextLine();
        System.out.println("Geben Sie nun eine Zahl ein, die zur Verschlüsselung genutzt werden soll");
        int enter2 = input.nextInt();

        // Stringbuilder für die Ausgabe
        StringBuilder result = new StringBuilder();

        // Test, ob Char ein Buchstabe ist, wenn nicht: anhängen
        for (char character : enter1.toCharArray()) {
            if (Character.isLetter(character)) {                    // Buchstabe?
                if (Character.isUpperCase(character)) {             // Großbuchstabe?
                    char base = 'A';
                    char shifted = (char) (((character - base + enter2) + 26) % 26 + base);
                    result.append(shifted);
                } else if (Character.isLowerCase(character)){       //Is it not a capital letter?
                    char base = 'a';
                    char shifted = (char) (((character - base + enter2) + 26) % 26 + base);
                    result.append(shifted);
                }
            } else {
                result.append(character);
            }
        }
        System.out.println("Der verschlüsselte Satz lautet:\n" + result.toString());
    }

    @Override
    public void decrypt() {
        // Eingabe-Aufforderung
        System.out.println("Geben Sie den Satz ein, den Sie entschlüsseln möchten.");
        String enter1 = input.nextLine();
        System.out.println("Geben Sie nun die Zahl ein, mit der verschlüsselt wurde.");   // Decryption setzt voraus, dass die Zahl bekannt ist
        int enter2 = input.nextInt();

        // Stringbuilder für die Ausgabe
        StringBuilder result = new StringBuilder();

        // Test, ob Char ein Buchstabe ist, wenn nicht: anhängen
        for (char character : enter1.toCharArray()) {
            if (Character.isLetter(character)) {                    // Buchstabe?
                if (Character.isUpperCase(character)) {             // Großbuchstabe?
                    char base = 'A';
                    char shifted = (char) (((character - base - enter2) + 26) % 26 + base);
                    result.append(shifted);
                } else if (Character.isLowerCase(character)){       //Is it not a capital letter?
                    char base = 'a';
                    char shifted = (char) (((character - base - enter2) + 26) % 26 + base);
                    result.append(shifted);
                }
            } else {
                result.append(character);
            }
        }
        System.out.println("Der verschlüsselte Satz lautet:\n" + result.toString());
    }
}
