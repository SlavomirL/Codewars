package algos;

public class HighestScoringWord {

    /*
    * in a String of words, find out which word has the highest value after assigning values to letters like this:
    * a = 1
    * b = 2
    * z = 26
    */

    public static String high(String s) {
        String[] words = s.split(" ");
        String higher = "";
        int max = 0;
        for (String word : words) {
            int sum = 0;
            for (int i = 0; i < word.length(); i++) {
                sum += word.charAt(i) - 96;
            }
            if (sum > max) {
                higher = word;
                max = sum;
            }
        }
        return higher;
    }
}