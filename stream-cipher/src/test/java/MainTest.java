// @author Arkan M. Gerges<arkan.m.gerges@gmail.com>

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MainTest {
    @Test
    void encryptAndDecryptAreEqual() {
        String plaintext = "This is a secret and you should not be able to read it 0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        Lcg key = new Lcg(10);
        byte[] ciphertext = Main.process(key, plaintext.getBytes(StandardCharsets.UTF_8));
        key = new Lcg(10);
        assertEquals(plaintext, new String(Main.process(key, ciphertext), StandardCharsets.UTF_8));
    }

    @Test
    void encryptAndDecryptAreNotEqualWhenKeysAreDifferent() {
        String plaintext = "This is a secret and you should not be able to read it 0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        Lcg key = new Lcg(10);
        byte[] ciphertext = Main.process(key, plaintext.getBytes(StandardCharsets.UTF_8));
        key = new Lcg(11);
        assertNotEquals(plaintext, new String(Main.process(key, ciphertext), StandardCharsets.UTF_8));
    }
}
