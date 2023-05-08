public class Sid {

    public static void main(String[] args) {
        System.out.println(simpleMultiplication(5));
    }

    // if it is an odd number, multiply by 9. if its even, multiply by 8
    public static int simpleMultiplication(int n) {
        if(n % 2 == 0) {
            return n * 8;
        }
        return n * 9;
    }
}