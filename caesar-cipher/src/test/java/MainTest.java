// @author Arkan M. Gerges<arkan.m.gerges@gmail.com>

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class MainTest {
    @Test
    void encryptAndDecryptWithKeyOffset3() {
        var main = new Main();

        String plaintext = "This is a secret and you should not be able to read it 0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        String ciphertext = main.encrypt(3, plaintext);
        assertEquals(plaintext, main.decrypt(3, ciphertext));
    }

    @Test
    void encryptAndDecryptWithKeyOffset30() {
        var main = new Main();

        String plaintext = "This is a secret and you should not be able to read it 0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        String ciphertext = main.encrypt(30, plaintext);
        assertEquals(plaintext, main.decrypt(30, ciphertext));
    }

    @Test
    void encryptAndDecryptWithKeyOffset100() {
        var main = new Main();

        String plaintext = "This is a secret and you should not be able to read it 0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        String ciphertext = main.encrypt(100, plaintext);
        assertEquals(plaintext, main.decrypt(100, ciphertext));
    }

       @Test
    void encryptAndDecryptWithDifferentKeys() {
        var main = new Main();

        String plaintext = "This is a secret and you should not be able to read it 0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        String ciphertext = main.encrypt(100, plaintext);
        assertFalse(plaintext == main.decrypt(30, ciphertext));
    }
}