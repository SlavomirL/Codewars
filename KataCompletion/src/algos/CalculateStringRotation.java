package algos;

import java.util.Arrays;

/*
 * find out how many times first string has to be shifted to the right so that it equals to second string
 */

public class CalculateStringRotation {

    static int shiftedDiff(String first, String second) {
        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();
        Arrays.sort(firstArr);
        Arrays.sort(secondArr);
        if (!Arrays.equals(firstArr, secondArr)) {
            return -1;
        }

        int count = 0;
        StringBuilder secondCopy = new StringBuilder(second);

        for (int i = 0; i < first.length(); i++) {
            StringBuilder sb = new StringBuilder();
            if (String.valueOf(secondCopy).equals(first)) {
                return count;
            } else {
                sb = sb.append(secondCopy.substring(1, secondCopy.length())).append(secondCopy.substring(0, 1));
                secondCopy = sb;
                count++;
            }
        }
        return count == first.length() ? -1 : count;
    }

    // solution from CodeWars
//        static int shiftedDiff(String first, String second){
//            if (first.length() != second.length())
//                return -1;
//            return (second + second).indexOf(first);
//        }

}