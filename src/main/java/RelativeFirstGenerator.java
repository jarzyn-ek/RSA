import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class RelativeFirstGenerator {

    public static Integer greatestCommonDivisor(Integer a, Integer b) {
        for (Integer i = ((a>b) ? b : a); i > 0; i--) {
            if (a%i==0 && b%i==0) {
                return i;
            }
        }
//        return BigInteger.ONE;
        return null;
    }

    public static Integer generateRelativeFirst(Integer n) {
        boolean stop = false;
        Integer x = 3;
        while (greatestCommonDivisor(n,x) > 1) {
            x += 1;
        }
        return x;
    }
}
