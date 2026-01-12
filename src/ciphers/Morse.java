package ciphers;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Morse implements Encrypt{
    // Zentraler Scanner wird genutzt
    private final Scanner input;

    public Morse(Scanner input) {
        this.input = input;
    }

    // Morse-Bibliothek
    Map<Character, String> morse = Map.ofEntries(
            Map.entry('a', "·-"), Map.entry('b', "-···"), Map.entry('c', "-·-·"), Map.entry('d', "-··"),
            Map.entry('e', "·"), Map.entry('f', "··-·"), Map.entry('g', "--·"), Map.entry('h', "····"),
            Map.entry('i', "··"), Map.entry('j', "·---"), Map.entry('k', "-·-"), Map.entry('l', "·-··"),
            Map.entry('m', "--"), Map.entry('n', "-·"), Map.entry('o', "---"), Map.entry('p', "·--·"),
            Map.entry('q', "--·-"), Map.entry('r', "·-·"), Map.entry('s', "···"), Map.entry('t', "-"),
            Map.entry('u', "··-"), Map.entry('v', "···-"), Map.entry('w', "·--"), Map.entry('x', "-··-"),
            Map.entry('y', "-·--"), Map.entry('z', "--··"),
            Map.entry('0', "-----"), Map.entry('1', "·----"), Map.entry('2', "··---"), Map.entry('3', "···--"),
            Map.entry('4', "····-"), Map.entry('5', "·····"), Map.entry('6', "-····"), Map.entry('7', "--···"),
            Map.entry('8', "---··"), Map.entry('9', "----·")
    );

    @Override
    public void encrypt() {
        System.out.println("Bitte gib den Satz ein, den du in Morse-Code haben möchtest!");
        String entry = input.nextLine().toLowerCase().trim();
        StringBuilder ausgabe = new StringBuilder();

        for (char c : entry.toCharArray()) {
            String s = morse.get(c);
            if (s != null) {
                ausgabe.append(s).append(" ");
            } else if (c == ' ') {
                ausgabe.append("/ "); // Worttrennung
            } else {
                ausgabe.append(c + " "); // unbekannte Zeichen
            }
        }
        System.out.println("Deine Eingabe lautet in Morse-Code:\n" + ausgabe.toString().trim());
    }

    @Override
    public void decrypt() {
        System.out.println("Bitte gib den Morse-Code ein, den du in einen Satz zurückverwandeln willst!");
        String entry2 = input.nextLine().trim();

        // Morse → Buchstaben-Map
        Map<String, Character> morseToChar = new HashMap<>();
        for (Map.Entry<Character, String> e : morse.entrySet()) {
            morseToChar.put(e.getValue(), e.getKey());
        }

        StringBuilder output = new StringBuilder();
        String[] words = entry2.split(" / "); // Wörter trennen
        for (String word : words) {
            String[] letters = word.split(" "); // Buchstaben trennen
            for (String letter : letters) {
                if (morseToChar.containsKey(letter)) {
                    output.append(morseToChar.get(letter));
                } else {
                    output.append(letter); // unverändert anhängen
                }
            }
            output.append(" "); // Worttrennung
        }
        System.out.println("Dein Satz lautet:\n" + output.toString().trim());
    }
}
