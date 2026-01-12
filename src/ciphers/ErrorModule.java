package ciphers;
import java.util.Scanner;

public class ErrorModule implements Encrypt{
    // Zentraler Scanner wird genutzt
    private final Scanner input;

    public ErrorModule(Scanner input) {
        this.input = input;
    }

    @Override
    public void encrypt() {
        System.out.println("Unknown algorithm!");
    }

    @Override
    public void decrypt() {
        System.out.println("Unknown encryption method!");
    }
}
