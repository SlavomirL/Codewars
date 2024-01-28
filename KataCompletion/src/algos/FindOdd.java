package algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOdd {

    public static int findIt(int[] a) {
        Map<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!helper.containsKey(a[i])) {
                helper.put(a[i], 1);
            } else {
                helper.put(a[i], helper.get(a[i]) + 1);
            }
        }
        for (Integer key : helper.keySet()) {
            if(helper.get(key) % 2 != 0) {
                return key;
            }
        }
        return -1;
    }

    // same thing but with Streams
    public static int findItStreams(int[] a) {
        Map<Integer, Long> helper = Arrays.stream(a)
                .boxed()
                .collect(HashMap::new, (map, key) -> map.merge(key, 1L, Long::sum), HashMap::putAll);

        return helper.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }

}