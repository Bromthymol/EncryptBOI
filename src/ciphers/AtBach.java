package ciphers;
import java.util.Scanner;

public class AtBach implements Encrypt{
    // Zentraler Scanner wird genutzt
    private final Scanner input;

    public AtBach(Scanner input) {
        this.input = input;
    }

    @Override
    public void encrypt() {
        // Eingabe-Aufforderung
        StringBuilder result = new StringBuilder();                                 //Erstellt einen flexiblen String
        System.out.println("Geben Sie den Satz ein, den Sie verschlüsseln möchten.");
        String enter = input.nextLine();

        for(char character : enter.toCharArray()){                                  //For-Each: Iteriert jedes Element im Char-Array der Eingabe durch
            if(Character.isLetter(character)){                                      //Testet, ob die Eingabe ein Buchstabe ist
                char base = Character.isUpperCase(character) ? 'A' : 'a';           //Setzt einen Basiswert für die Berechnung des neuen Buchstabens
                char shifted = (char) (25 - (character - base) + base);             //Berechnet den neuen Buchstaben
                result.append(shifted);                                             //Fügt den neuen Buchstaben an den String an

            } else {
                result.append(character);
            }
        }
        System.out.println("Der verschlüsselte Satz lautet:\n" + result.toString());
    }

    @Override
    public void decrypt() {
        // Eingabe-Aufforderung
        StringBuilder result = new StringBuilder();                                 //Erstellt einen flexiblen String
        System.out.println("Geben Sie den Satz ein, den Sie entschlüsseln möchten.");
        String enter = input.nextLine();

        for(char character : enter.toCharArray()){                                  //For-Each: Iteriert jedes Element im Char-Array der Eingabe durch
            if(Character.isLetter(character)){                                      //Testet, ob die Eingabe ein Buchstabe ist
                char base = Character.isUpperCase(character) ? 'A' : 'a';           //Setzt einen Basiswert für die Berechnung des neuen Buchstabens
                char shifted = (char) (25 - (character - base) + base);             //Berechnet den neuen Buchstaben
                result.append(shifted);                                             //Fügt den neuen Buchstaben an den String an

            } else {
                result.append(character);
            }
        }
        System.out.println("Der verschlüsselte Satz lautet:\n" + result.toString());
    }
}
