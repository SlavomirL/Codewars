package algos;

public class MultiplesOf3And5 {

    /*
    * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.

Note: If the number is a multiple of both 3 and 5, only count it once.
    * */

    public static void main(String[] args) {
        int input1 = 10;
        int input2 = 123456;
        System.out.println(countMultiples(input1));
        System.out.println(countMultiples(input2));



    }

    public static long countMultiples(int input) {
        if(input < 0) {
            return 0;
        }
        long count = 0;
        for(int i = 0; i < input; i++) {
            if(i % 3 == 0 || i % 5 == 0) {
                count += i;
            }
        }
        return count;
    }


}
