import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class RSAApp {

    public static PairOfKeys generateKeys() {
        int p = BigPrimeNumberGenerator.generate(1000,10000);
        int q = BigPrimeNumberGenerator.generate(1000,10000);
        int n = p*q;
        int phi = (p-1)*(q-1);
        int e = BigPrimeNumberGenerator.generate(10,100);
        //e*d % phi = 1
        int d = GenerateDNumber.generate(e, phi);
        //(d, n) -> klucz prywatny, (e, n) -> klucz publiczny,
        System.out.println("Parametry: ");
        System.out.println("p: " + p + " q: " + q + " n: " + n + " phi: " + phi + " e: " + e + " d: " + d);
        return new PairOfKeys(new Key(n, d), new Key(n, e));
    }

    public static List<BigInteger> encryptMessage(String message, Key key) {
        List<BigInteger> encrypted = new LinkedList<BigInteger>();
        for (char letter : message.toCharArray()) {
            encrypted.add(BigInteger.valueOf((int)letter).pow(key.notN).mod(BigInteger.valueOf(key.n)));
        }
        return encrypted;
    }


    public static String decryptMessage(List<BigInteger> message, Key key) {
        String decrypted = new String();
        for (BigInteger letter : message) {
            decrypted += (char) Integer.parseInt(String.valueOf(letter.modPow(BigInteger.valueOf(key.notN),BigInteger.valueOf(key.n))));
            //System.out.println((char) Integer.parseInt(String.valueOf(letter.modPow(BigInteger.valueOf(key.notN),BigInteger.valueOf(key.n)))));
        }
        return decrypted;
    }

    public static void main(String[] args) {
        PairOfKeys pairOfKeys = generateKeys();
        String message = new String("Wybrane zagadnienia kryptograficzne to super przedmiot");
        List<BigInteger> encrypted = encryptMessage(message, pairOfKeys.publicKey);
        String decrypted = decryptMessage(encrypted, pairOfKeys.privateKey);

        System.out.println(decrypted);
    }
}
