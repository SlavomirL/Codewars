import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class CountCharacters {

    public static void main(String[] args) {

        System.out.println(count("aba"));
    }


    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> charQuantity = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if(charQuantity.containsKey(str.charAt(i))) {
                charQuantity.put(str.charAt(i), charQuantity.get(str.charAt(i))+1);
            } else {
                charQuantity.put(str.charAt(i), 1);
            }
        }
        return charQuantity;
    }

//    static Map<Character, Integer> count(String str) {
//        return str.chars()
//                .mapToObj(c -> (char) c)
//                .collect(toMap(c -> c, c -> 1, Integer::sum)); // toMap method has 3 parameters: 1) the key, 2) the default value, 3) merge function - in this case it increase the value if duplicate key is found
//    }
}