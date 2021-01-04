import java.math.BigInteger;

public class GenerateDNumber {

    public static int generate(Integer e, Integer phi) {
        for (int i = 1;; i++) {
            if (i*e%phi == 1) {
                return i;
            }
        }
    }
}
