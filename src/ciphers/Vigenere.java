package ciphers;
import java.util.Scanner;

public class Vigenere implements Encrypt{
    // Zentraler Scanner wird genutzt
    private final Scanner input;

    public Vigenere(Scanner input) {
        this.input = input;
    }

    @Override
    public void encrypt() {
        // Eingabe-Aufforderung
        System.out.println("Geben Sie den Satz ein, den Sie verschlüsseln möchten.");
        String enter = input.nextLine();
        System.out.println("Geben Sie nun das Codewort ein, das Sie verwenden möchten.");
        String codeWord = input.nextLine();

        // Erstellung zweier flexibler Strings für Resultat und Codewort
        StringBuilder result = new StringBuilder();
        StringBuilder code = new StringBuilder();

        // Notwendige Variablen
        int len = enter.length();
        int t = 0;

        // Erstellung eines Char-Array aus dem Codewort
        for(int i = 0; i < len; i++){
            char keychar = codeWord.charAt(i % codeWord.length());
            code.append(keychar);
        }

        // Verschlüsselungs-Methode
        for(char character : enter.toCharArray()){
            if (Character.isLetter(character)) {                                        // Testet ob der char überhaupt ein Buchstabe ist
                char base = Character.isUpperCase(character) ? 'A' : 'a';               // Gibt den Basiswert zur Berechnung der Verschiebung an
                int shift = Character.toUpperCase(code.charAt(t)) -'A';                 // Berechnet die Zahl um die verschoben werden soll
                char shifted = (char) ((character - base + shift) % 26 + base);         // Berechnet die tatsächliche Verschiebung

                result.append(shifted);                                                 // Fügt den neu errechneten char dem result-Array hinzu
                t++;

            } else {
                result.append(character);                                               // Chars, die keine Buchstaben sind, werden direkt angehängt
            }
        }
        System.out.println("Der verschlüsselte Satz lautet:\n" + result.toString());    // Das Resultat wird ausgegeben
    }

    @Override
    public void decrypt() {
        // Eingabe-Aufforderung
        System.out.println("Geben Sie den Satz ein, den Sie entschlüsseln möchten.");
        String enter = input.nextLine();
        System.out.println("Geben Sie nun das Codewort ein, das verwendet wurde.");
        String codeWord = input.nextLine();

        // Erstellung zweier flexibler Strings für Resultat und Codewort
        StringBuilder result = new StringBuilder();
        StringBuilder code = new StringBuilder();

        // Notwendige Variablen
        int len = enter.length();
        int t = 0;

        // Erstellung eines Char-Array aus dem Codewort
        for(int i = 0; i < len; i++){
            char keychar = codeWord.charAt(i % codeWord.length());
            code.append(keychar);
        }

        // Entschlüsselungs-Methode
        for(char character : enter.toCharArray()){
            if (Character.isLetter(character)) {                                        // Testet ob der char überhaupt ein Buchstabe ist
                char base = Character.isUpperCase(character) ? 'A' : 'a';               // Gibt den Basiswert zur Berechnung der Verschiebung an
                int shift = Character.toUpperCase(code.charAt(t)) -'A';                 // Berechnet die Zahl um die verschoben werden soll
                char shifted = (char) ((character - base - shift + 26) % 26 + base);    // Tatsächliche Entschlüsselung

                result.append(shifted);                                                 // Fügt den neu errechneten char dem result-Array hinzu
                t++;

            } else {
                result.append(character);                                               // chars, die keine Buchstaben sind, werden direkt angehängt
            }
        }
        System.out.println("Der verschlüsselte Satz lautet:\n" + result.toString());    // Das Resultat wird ausgegeben
    }
}
