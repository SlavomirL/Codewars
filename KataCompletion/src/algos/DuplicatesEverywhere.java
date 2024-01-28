package algos;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicatesEverywhere {

    /*
    * You are given a table, in which every key is a stringified number, and each corresponding value is an array of characters.
    * Create a function that returns a table with the same keys, but each character should appear only once among the value-arrays, e.g.
    * Whenever two keys share the same character, they should be compared numerically, and the larger key will keep that character.
    * If duplicate characters are found in the same array, the first occurance should be kept.
    */

//    public static Map<Integer, List<String>> removeDuplicateIds(Map<Integer, List<String>> obj) {
//        Map<Integer, List<String>> copy = obj;
//        return Stream
//                .of(obj)
//                .sorted(Comparator.comparing(obj::keySet))
//                .collect(Collectors.toMap());
//
//    }


    public static Map<Integer, List<String>> removeDuplicates(Map<Integer, List<String>> map) {
        // Map letters to their maximum associated keys
        Map<String, Integer> letterToMaxKey = map.entrySet().stream() // Convert the map into a stream of entries
                .flatMap(entry -> entry.getValue().stream() // For each entry, flatten the list of values
                        .map(letter -> Map.entry(letter, entry.getKey()))) // Map each letter to its associated key
                .collect(Collectors.groupingBy( // Collect elements into a map based on specified conditions
                        Map.Entry::getKey, // Use the letter as the key
                        Collectors.collectingAndThen( // Perform an additional operation after grouping
                                Collectors.maxBy(Comparator.comparingInt(entry -> entry.getValue())), // Get the maximum associated key
                                optional -> optional.map(Map.Entry::getValue).orElse(null) // Extract the maximum key value
                        )));

        // Create a new map to store the processed data
        Map<Integer, List<String>> result = new HashMap<>();

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) { // Loop through each entry in the original map
            int key = entry.getKey(); // Get the key from the current entry

            // Process the values associated with the key
            List<String> values = entry.getValue().stream() // Convert the list of values associated with the key into a stream
                    .filter(letter -> key == letterToMaxKey.getOrDefault(letter, key)) // Filter letters based on conditions
                    .distinct() // Ensure only distinct occurrences of letters are collected
                    .collect(Collectors.toList()); // Collect filtered and distinct letters into a list

            result.put(key, values); // Put the resulting list of distinct letters into the result map with the corresponding key
        }

        return result; // Return the resulting map containing processed data
    }
}