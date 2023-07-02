// @author Arkan M. Gerges<arkan.m.gerges@gmail.com>

import java.util.HashMap;
import java.util.Map;

public class Main {
    public String encrypt(Map<Character, Character> key, String plaintext) {
        StringBuilder result = new StringBuilder();
        for (var i = 0; i < plaintext.length(); i++) {
            if (key.containsKey(plaintext.charAt(i))) {
                result.append(key.get(plaintext.charAt(i)));
            } else {
                result.append(plaintext.charAt(i));
            }
        }
        return result.toString();
    }

    public String decrypt(Map<Character, Character> key, String ciphertext) {
        StringBuilder result = new StringBuilder();
        Map<Character, Character> decryptionKey = generateDecryptionKey(key);
        for (var i = 0; i < ciphertext.length(); i++) {
            if (decryptionKey.containsKey(ciphertext.charAt(i))) {
                result.append(decryptionKey.get(ciphertext.charAt(i)));
            } else {
                result.append(ciphertext.charAt(i));
            }
        }
        return result.toString();
    }

    public Map<Character, Character> generateKey() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        String tmpLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        Map<Character, Character> result = new HashMap<>();
        
        for (var i = 0; i < letters.length(); i++) {
            int randomIndex = (int) (Math.random() * tmpLetters.length());
            result.put(letters.charAt(i), tmpLetters.charAt(randomIndex));
            tmpLetters = tmpLetters.substring(0, randomIndex) + tmpLetters.substring(randomIndex + 1);
        }


        return result;
    }

    public Map<Character, Character> generateDecryptionKey(Map<Character, Character> key) {
        Map<Character, Character> result = new HashMap<>();
        for (var entry : key.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }
}
