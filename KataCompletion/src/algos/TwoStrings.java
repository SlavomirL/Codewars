package algos;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     * Method should check if strings contain at least one shared letter.
     */

    // initial approach
//    public static String twoStrings(String s1, String s2) {
//
//
//        for (int i = 0; i < s1.length(); i++) {
//            if (s2.contains(String.valueOf(s1.charAt(i)))) {
//                return "YES";
//            }
//        }
//        return "NO";
//    }


    // optimized approach
    public static String twoStrings(String s1, String s2) {
        Set<Character> s1Set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Set.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            if (s1Set.contains(s2.charAt(i))) {
                return "YES";
            }
        }
        return "NO";
    }
}