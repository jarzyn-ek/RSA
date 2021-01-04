import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class BigPrimeNumberGenerator {

    public static boolean checkIfPrime(int number) {

        if (number % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(number); i+=2) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Integer generate(int min, int max) {

        boolean stop = false;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max);

        while (!stop) {
            if (randomNum % 2 == 0) {
                randomNum += 1;
            }
            stop = checkIfPrime(randomNum);
            if (stop) {
                return randomNum;
            } else {
                randomNum += 2;
            }
        }
        return null;
    }
}
