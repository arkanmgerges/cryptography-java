// @author Arkan M. Gerges<arkan.m.gerges@gmail.com>

import java.util.HashMap;
import java.util.Map;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;

public class Main {
    public String encrypt(int key, String plaintext) {
        Map<Character, Character> keyMap = generateKey(key);
        StringBuilder result = new StringBuilder();
        for (var i = 0; i < plaintext.length(); i++) {
            if (keyMap.containsKey(plaintext.charAt(i))) {
                result.append(keyMap.get(plaintext.charAt(i)));
            } else {
                result.append(plaintext.charAt(i));
            }
        }
        return result.toString();
    }

    public String decrypt(int offset, String ciphertext) {
        Map<Character, Character> key = generateDecryptionKey(offset);
        StringBuilder result = new StringBuilder();
        for (var i = 0; i < ciphertext.length(); i++) {
            if (key.containsKey(ciphertext.charAt(i))) {
                result.append(key.get(ciphertext.charAt(i)));
            } else {
                result.append(ciphertext.charAt(i));
            }
        }
        return result.toString();
    }

    // Using streams
    // public String decrypt(int offset, String ciphertext) {
    // Map<Character, Character> key = generateDecryptionKey(offset);

    // return IntStream.range(0, ciphertext.length())
    // .mapToObj(i -> key.containsKey(ciphertext.charAt(i)) ?
    // key.get(ciphertext.charAt(i))
    // : ciphertext.charAt(i))
    // .map(Object::toString)
    // .collect(Collectors.joining());
    // }

    public Map<Character, Character> generateDecryptionKey(int offset) {
        Map<Character, Character> result = new HashMap<>();
        for (var entry : generateKey(offset).entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }

    // Using streams
    // public Map<Character, Character> generateDecryptionKey(int offset) {
    // return generateKey(offset).entrySet().stream()
    // .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (v1, v2) ->
    // v1, HashMap::new));
    // }

    public Map<Character, Character> generateKey(int offset) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+{}[]|\\:;\"',./<>?`~";
        Map<Character, Character> result = new HashMap<>();
        for (var i = 0; i < letters.length(); i++) {
            result.put(letters.charAt(i), letters.charAt((i + offset) % letters.length()));
        }
        return result;
    }

}