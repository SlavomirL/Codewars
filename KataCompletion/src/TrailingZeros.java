import java.math.BigInteger;

public class TrailingZeros {

    public static void main(String[] args) {
        System.out.println(zeros(25));
    }



    // solution 1: it works but only if n is quite small number, because calculated factorial is getting too big too
    // quickly
    public static int zeros(int n) {
        long factorial = 1;
        int trailingZeros = 0;
        for(int i = 1; i <= n; i++) {
            factorial *= i;
        }
        for(long i = factorial; i > 0; i/=10) {
            if(i % 10 == 0) {
                trailingZeros++;
            } else {
                break;
            }
        }
        return trailingZeros;
    }

    // solution 2: it can handle bigger numbers but requires a lot of computational power
//    public static int zeros(int n) {
//        BigInteger factorial = BigInteger.ONE;
//        int trailingZeros = 0;
//
//        for (int i = 1; i <= n; i++) {
//            factorial = factorial.multiply(BigInteger.valueOf(i));
//        }
//
//        while (factorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
//            trailingZeros++;
//            factorial = factorial.divide(BigInteger.TEN);
//        }
//
//        return trailingZeros;
//    }

    // solution no. 3 to handle even the biggest numbers and also with much less computational power needed
//    public static int zeros(int n) {
//        int trailingZeros = 0;
//
//        while (n > 0) {
//            n /= 5;
//            trailingZeros += n;
//        }
//
//        return trailingZeros;
//    }
}