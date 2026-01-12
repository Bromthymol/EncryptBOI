package ciphers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Emoji implements Encrypt{

    // Zentraler Scanner wird genutzt
    private final Scanner input;

    public Emoji(Scanner input) {
        this.input = input;
    }

    // Erstellung einer Map als Bib für die Buchstaben

    public static final Map<Character, String> emojithek = Map.ofEntries(
            Map.entry('a', "😀"), Map.entry('b', "😁"), Map.entry('c', "😂"),
            Map.entry('d', "🤣"), Map.entry('e', "😃"), Map.entry('f', "😄"),
            Map.entry('g', "😅"), Map.entry('h', "😆"), Map.entry('i', "😉"),
            Map.entry('j', "😊"), Map.entry('k', "😋"), Map.entry('l', "😎"),
            Map.entry('m', "😍"), Map.entry('n', "😘"), Map.entry('o', "😗"),
            Map.entry('p', "😙"), Map.entry('q', "😚"), Map.entry('r', "☺"),
            Map.entry('s', "🙂"), Map.entry('t', "🤗"), Map.entry('u', "🤩"),
            Map.entry('v', "🤔"), Map.entry('w', "🤨"), Map.entry('x', "😐"),
            Map.entry('y', "😑"), Map.entry('z', "😶"),Map.entry('0', "🀄"),
            Map.entry('1', "🎱"), Map.entry('2', "🎲"), Map.entry('3', "🃏"),
            Map.entry('4', "🎯"), Map.entry('5', "🎵"), Map.entry('6', "🎶"),
            Map.entry('7', "⚡"), Map.entry('8', "🔥"), Map.entry('9', "🌟")
    );

    @Override
    public void encrypt() {
        StringBuilder result = new StringBuilder();
        System.out.println("Geben Sie den Satz ein, den Sie verschlüsseln wollen.");
        String enter = input.nextLine().toLowerCase().trim();

        // Verschlüsselung
        for(char s : enter.toCharArray()){
            if(emojithek.containsKey(s)){
                result.append(emojithek.get(s));
            } else if(Character.isWhitespace(s)){
                result.append(" ");
            } else {
                result.append(s);
            }
        }
        System.out.println(result);
    }

    @Override
    public void decrypt() {
        // Emoji → Buchstaben-Map
        Map<String, Character> emojiToChar = new HashMap<>();
        for (Map.Entry<Character, String> e : emojithek.entrySet()) {
            emojiToChar.put(e.getValue(), e.getKey());
        }
        StringBuilder result = new StringBuilder();
        System.out.println("Gib eine Emoji-Kette ein:");
        String enter = input.nextLine().trim();

        int i = 0;
        while (i < enter.length()) {
            String found = null;
            // Prüfe jedes Emoji in der Map, ob es an der aktuellen Position passt
            for (String emoji : emojiToChar.keySet()) {
                if (enter.startsWith(emoji, i)) {
                    found = emoji;
                    break;
                }
            }
            if (found != null) {
                result.append(emojiToChar.get(found));
                i += found.length();
            } else {
                // Leerzeichen oder andere Zeichen
                result.append(enter.charAt(i));
                i++;
            }
        }

        System.out.println(result.toString());
    }
}
