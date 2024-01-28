package saturdayAlgo;

public class SwapOneStringToEqualize_1790 {

    public static void main(String[] args) {
        String s1 = "banka";
        String s2 = "kanbc";
        System.out.println(areAlmostEqual(s1, s2));
        System.out.println(areAlmostEqualAndras(s1,s2));
    }


    // my solution
    public static boolean areAlmostEqual(String s1, String s2) {
        int first = -1;
        int second = -1;

        if (s1.equals(s2)) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else {
                    second = i;
                }
                count++;
            }
        }
        if (count == 2) {
            StringBuilder s2SB = new StringBuilder();
            for (int i = 0; i < s2.length(); i++) {
                if (i == first) {
                    s2SB.append(String.valueOf(s2.charAt(second)));
                } else if (i == second) {
                    s2SB.append(String.valueOf(s2.charAt(first)));
                } else {
                    s2SB.append(String.valueOf(s2.charAt(i)));
                }
            }
            return s1.equals(String.valueOf(s2SB));
        }
        return false;
    }

    // andras solution
    public static boolean areAlmostEqualAndras(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int differences = 0;
        boolean foundInterchangable = false;
        char s1First = 1;
        char s2First = 1;

        for (int i = 0; i < s1.length(); i++) {

            if (differences == 0 && s1.charAt(i) != s2.charAt(i)) {

                differences++;
                s1First = s1.charAt(i);
                s2First = s2.charAt(i);

            } else if (differences == 1 && s1.charAt(i) != s2.charAt(i)) {

                differences++;
                if (s1First == s2.charAt(i) && s2First == s1.charAt(i)) {
                    foundInterchangable = true;
                } else {
                    return false;
                }

            } else if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }

        }
        return foundInterchangable;
    }

}
