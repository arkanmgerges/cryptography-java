/**
 * The Linear Congruential Generator (LCG) is a simple pseudorandom number generator.
 * {@linkplain https://en.wikipedia.org/wiki/Linear_congruential_generator for more information}
 *
 * @author Arkan M. Gerges<arkan.m.gerges@gmail.com>
 */

public class Lcg {
    private long next;
    static final long modulus = (long) Math.pow(2, 31);

    public Lcg(long seed) {
        this.next = seed;
    }

    public long nextNumber() {
        // The following numbers were taken from the Wikipedia article on LCGs (see the link above), and uses the ANSI C parameters.
        return this.next = (this.next * 1103515245 + 12345) % modulus;
    }

    public long nextNumberMod256() {
        return this.nextNumber() % 256;
    }
}
