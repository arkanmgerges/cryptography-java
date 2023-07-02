// @author Arkan M. Gerges<arkan.m.gerges@gmail.com>

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MainTest {
    @Test
    void encryptAndDecryptAreEqual() {
        var main = new Main();

        String plaintext = "This is a secret and you should not be able to read it 0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        Map<Character, Character> key = main.generateKey();
        String ciphertext = main.encrypt(key, plaintext);
        assertEquals(plaintext, main.decrypt(key, ciphertext));
    }

    @Test
    void encryptAndDecryptAreNotEqual() {
        var main = new Main();

        String plaintext = "This is a secret and you should not be able to read it 0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        Map<Character, Character> key = main.generateKey();
        Map<Character, Character> key2 = main.generateKey();
        String ciphertext = main.encrypt(key, plaintext);
        assertNotEquals(plaintext, main.decrypt(key2, ciphertext));
    }
}
