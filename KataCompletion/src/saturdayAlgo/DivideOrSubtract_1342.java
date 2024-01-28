package saturdayAlgo;

public class DivideOrSubtract_1342 {

    public static void main(String[] args) {
        int input = 14;
        System.out.println(numberOfSteps(input));
    }

    public static int numberOfSteps(int num) {
        int steps = 0;
        int remainder = num;
        while(remainder > 0) {
            if(remainder % 2 == 0) {
                remainder /= 2;
            } else {
                remainder -= 1;
            }
            steps++;
        }
        return steps;
    }

}