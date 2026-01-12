import ciphers.Encrypt;

import java.util.Random;
import java.util.Scanner;

public class EncryptBoi {

    Random rand = new Random();

    // Scanner wird einmalig und zentral für alle Klassen erstellt
    private final Scanner input = new Scanner(System.in);

    public Scanner getScanner() {
        return input;
    }

    // Attribute
    Module module;
    Operation operation;

    // Begrüßungsmethode und Hauptmenü
    public void start() {
        System.out.printf("Herzlich willkommen bei Encrypticon%nIhrem allround Verschlüsselungstool!%n" +
                "      --- by Till Dävel ---%n%n");

        while(true){
            System.out.printf("Bitte wählen Sie einen Algorithmus aus, den Sie verwenden möchten%n" +
                    "1      Caesar-Chiffre%n" +
                    "2      AtBach-Chiffre%n" +
                    "3      Vigenère-Chiffre%n" +
                    "4      Morse-Code%n" +
                    "5      Binär-Code%n" +
                    "6      Emoji-Chiffre%n" +
                    "7      Zufällige Auswahl%n" +
                    "8      Programm beenden%n");

            // Abfangen des Exit-Befehls
            int select1 = input.nextInt();
            input.nextLine();
            if(select1 == 8){
                System.exit(0);
            }

            // Generierung eines zufälligen Moduls bei Fall 5
            Module randModule = Module.values()[rand.nextInt(Module.values().length - 2)];

            // Korrektes Modul wird ausgewählt
            module = switch(select1){
                case 1 -> Module.CAESAR;
                case 2 -> Module.ATBACH;
                case 3 -> Module.VIGENER;
                case 4 -> Module.MORSE;
                case 5 -> Module.BINAIRY;
                case 6 -> Module.EMOJI;
                case 7 -> randModule;// Zufällige Auswahl
                default -> Module.ERROR1;
            };

            // Korrekte Methode wird ausgewählt
            System.out.printf("Welchen Vorgang möchten Sie durchführen?%n" +
                    "1      Verschlüsseln%n" +
                    "2      Entschlüsseln%n");
            int select2 = input.nextInt();
            input.nextLine();
            operation = (select2 == 1) ? Operation.ENCRYPT :
                    (select2 == 2) ? Operation.DECRYPT : Operation.ERROR2;

            // Algorithmus-Objekt erzeugen
            Encrypt algo = module.createInstance(input);
            String randModName = module.getName();          // Gibt den Namen des Algorithmus zurück
            operation.apply(algo);                          // Wählt die gewünschte Methode aus dem Modul aus

            // Kleine Anmerkung, für Random-Mode unbedingt nötig
            System.out.printf("\nDiese Verschlüsselung wurde mit %s erstellt.%n", randModName);
            System.out.println(); // Leerzeile für bessere Lesbarkeit
        }
    }
}
