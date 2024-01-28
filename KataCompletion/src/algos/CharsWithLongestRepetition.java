package algos;

public class CharsWithLongestRepetition {

    /*
    * For a given string s find the character c (or C) with longest consecutive repetition and return:

Object[]{c, l};
where l (or L) is the length of the repetition. If there are two or more characters with the same l return the first in order of appearance.

For empty string return:

Object[]{"", 0}
Happy coding! :)
* */

    public static void main(String[] args) {
        String input = "";
        Object[] result = findChar(input);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static Object[] findChar(String s) {
        int maxReps = 0;
        char currentChar = ' ';
        char maxChar = ' ';
        for (int i = 0; i < s.length() - 1; i++) {
            int repetitions = 1;
            currentChar = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    repetitions++;
                    i++;
                } else {
                    break;
                }
            }

            if (repetitions > maxReps) {
                maxReps = repetitions;
                maxChar = currentChar;
            }
        }

        String maxCharStr = maxChar == ' ' ? "" : String.valueOf(maxChar);

        return new Object[]{maxCharStr, maxReps};
    }
}