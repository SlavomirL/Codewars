import java.util.ArrayList;
import java.util.List;

class EurekaNumber {

    public static void main(String[] args) {
        System.out.println(sumDigPow(500,10000));
    }

    /* Take a Number And Sum Its Digits Raised To The Consecutive Powers. Parameters should be two numbers that
    define the range to be checked. Result is List of all numbers that fulfills the above described condition.*/
    public static List<Long> sumDigPow(long a, long b) {
        List<Long> results = new ArrayList<>();
        long digitIndex = 0;
        long sum = 0;

        for(long i = a; i <= b; i++) {
            sum = 0;
            for(long j = i; j > 0; j /= 10) {
                digitIndex = String.valueOf(j).length();
                sum = (long)(sum + (Math.pow(j % 10, digitIndex)));
            }
            if(sum == i) {
                results.add(sum);
            }
        }
        return results;
    }


}