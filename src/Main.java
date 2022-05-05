import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println("So fast");
        for (int i = 0; i < 100000; i++) {
            BigInteger big = BigInteger.valueOf(i);
            big = big.pow(i);
            System.out.println(i + "." + big);
        }
    }
}
