// @author Arkan M. Gerges<arkan.m.gerges@gmail.com>

import org.jetbrains.annotations.NotNull;

public class Main {
    public static byte @NotNull [] process(Lcg key, byte @NotNull [] message) {
        byte[] result = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            result[i] = (byte) (message[i] ^ key.nextNumberMod256());
        }
        return result;
    }
}
