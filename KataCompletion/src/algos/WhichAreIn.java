package algos;

import java.util.Arrays;

public class WhichAreIn {

// my initial approach
//    public static String[] inArray(String[] array1, String[] array2) {
//        String[] substrings = new String[array1.length];
//        int count = 0;
//        for (int i = 0; i < array1.length; i++) {
//            for (int j = 0; j < array2.length; j++) {
//                if (array2[j].contains(array1[i])) {
//                    substrings[i] = array1[i];
//                    count++;
//                    break;
//                }
//            }
//        }
//        substrings = Arrays.copyOf(substrings, count);
//        Arrays.sort(substrings,0, count);
//        return substrings;
//    }

    // improved version that works for all test cases
    public static String[] inArray(String[] array1, String[] array2) {
        String[] substrings = new String[array1.length];
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == null) {
                continue;
            }
            for (int j = 0; j < array2.length; j++) {
                if (array2[j] == null) {
                    continue;
                }
                if (array2[j].contains(array1[i])) {
                    substrings[count++] = array1[i];
                    break;
                }
            }
        }
        substrings = Arrays.copyOf(substrings, count);
        if (count != 0) {
            Arrays.sort(substrings);
        }
        return substrings;
    }

    // CodeWars solution
    public static String[] inArrayCW(String[] array1, String[] array2) {
        return Arrays.stream(array1)
                .filter(str ->
                        Arrays.stream(array2).anyMatch(s -> s.contains(str)))
                .distinct()
                .sorted()
                .toArray(String[]::new);
    }

}