package saturdayAlgo;

import java.util.ArrayList;
import java.util.List;

public class SplitStringsBySeparator_2788 {

    public static void main(String[] args) {
        List<String> input1 = List.of("$easy$", "$problem$");
        List<String> input2 = List.of("$easy$", "$problem$");

        System.out.println(splitWordsBySeparator(input1, '$'));
        System.out.println(splitWordsBySeparatorPeter(input2, '$'));
    }

    // my solution. there is one if statement missing without which the output is incorrect
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList();
        for (int i = 0; i < words.size(); i++) {
            String[] subList = words.get(i).replace(separator, ' ').split("\s"); // "\s" is whitespace
            for (int j = 0; j < subList.length; j++) {
                result.add(subList[j]); // if statement missing here
            }
        }
        return result;
    }

    // peters solution
    public static List<String> splitWordsBySeparatorPeter(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            String[] separated = word.replace(separator, ' ').split(" ");
            for (String sep : separated) {
                if (sep.length() != 0) {
                    result.add(sep);
                }
            }
        }
        return result;
    }
}
