public class MultiplesOfThreeAndFive {

    public static void main(String[] args) {
        System.out.println(solution(50));
    }

    public static int solution(int number) {
        int sum = 0;
        if(number <= 0) {
            return 0;
        } else {
            for(int i = 0; i < number; i++) {
                if((i % 3 == 0) || (i % 5 == 0)) {
                    System.out.println(i);
                    sum += i;
                }
            }
        }
        return sum;
    }
}