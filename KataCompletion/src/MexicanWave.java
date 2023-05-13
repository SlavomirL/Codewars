import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MexicanWave {

    public static void main(String[] args) {
        for(String result : wave("OI! everyone in here! ")) {
            System.out.println(result);
        }

    }

    /* Your task is to create a function that turns a string into a Mexican Wave. You will be
    passed a string and you must return that string in an array where an uppercase letter is a person standing up. If
     the character in the string is whitespace then pass over it as if it was an empty seat */
    public static String[] wave(String str) {
        String[] results = new String[str.length()];
        ArrayList<String> resultsAsList = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ') {
                String uppered = String.valueOf(str.charAt(i)).toUpperCase();
                if(i == 0) {
                    results[i] = uppered + str.substring(i+1);
                } else if(i == str.length()-1) {
                    results[i] = str.substring(0, i) + uppered;
                } else {
                    results[i] = str.substring(0, i) + uppered + str.substring(i+1);
                }
            }
        }
        for(int i = 0; i < results.length; i++) {
            if (results[i] != null) {
                resultsAsList.add(results[i]);
            }
        }
        return resultsAsList.toArray(new String[0]);
    }

    /* Method from Codewards giving the same* output but by using Stream. *The output is not really the same because this code ignores the upper case letters from the original str, means this solution is a bit better */
//    public static String[] wave(String str) {
//        return IntStream
//                .range(0, str.length())
//                .mapToObj(x -> new StringBuilder(str).replace(x, x+1, String.valueOf(str.charAt(x)).toUpperCase()).toString())
//                .filter(y -> !y.equals(str))
//                .toArray(String[]::new);
//    }

}