import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileScanner {
    Scanner input = null;

    public void encrypt() {
        System.out.println("Geben Sie den Pfad zu der Datei ein, die Sie verschlüsseln möchten.");
        String pfad = input.nextLine();

        // Überprüft, ob das Dateiformat passt
        if (pfad.endsWith(".txt")) {
            File datei = new File(pfad);
            try {
                input = new Scanner(datei);         // Einlesen der Datei
            } catch (FileNotFoundException e) {
                System.out.println("File ot Found!");
            }
            while (input.hasNext()) {                //Tatsächliche verschlüsselung
                input.nextLine();
            }
        } else {
            System.out.println("Bitte geben Sie einen Gültigen Pfad zu einer TextDatei (.txt) ein.");
        }
    }
}