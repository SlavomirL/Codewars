import java.util.Arrays;

public class CountByX {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(countBy(1, 10)));
        System.out.println(Arrays.toString(countBy(2, 5)));
    }
    public static int[] countBy(int x, int n){
        int addition = x;
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = x;
            x += addition;
        }
        return numbers;
    }
}