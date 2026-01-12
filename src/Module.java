import ciphers.*;
import java.util.Scanner;
import java.util.function.Function;

public enum Module {
    CAESAR("Caesar-Cipher", Caesar::new),
    ATBACH("AtBach-Cipher", AtBach::new),
    VIGENER("Vigenère-Cipher", Vigenere::new),
    MORSE("Morse-Cipher", Morse::new),
    BINAIRY("Binär-Code", Binairy::new),
    EMOJI("Emoji-Cipher", Emoji::new),
    BRAILLE("Braille-Schrift", Braille::new),
    ERROR1("Error", ErrorModule::new);

    private final String name;
    private final Function<Scanner, Encrypt> constructor;

    Module(String name, Function<Scanner, Encrypt> constructor) {
        this.name = name;
        this.constructor = constructor;
    }

    public Encrypt createInstance(Scanner scanner) {
        return constructor.apply(scanner);
    }

    public String getName() {
        return name;
    }
}



