package algos;

public class AlternatingCharacters {


    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                return sum;
            } else {
                if (s.charAt(i) == (s.charAt(i + 1))) {
                    sum++;
                }
            }
        }
        return sum;
    }
}