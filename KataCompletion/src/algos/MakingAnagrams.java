package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakingAnagrams {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     *
     * Question to solve: how many letters from each String has to be removed in order to form anagram?
     */


    public static int makeAnagram(String a, String b) {
        List<Character> aList = new ArrayList<>();
        List<Character> bList = new ArrayList<>();

        for (int i = 0; i < a.length(); i++) {
            aList.add(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            bList.add(b.charAt(i));
        }

        for (int i = 0; i < aList.size(); i++) {
            if (bList.contains(aList.get(i))) {
                bList.remove(bList.indexOf(aList.get(i)));
                aList.remove(i);
                i--;
            }
        }
        return aList.size() + bList.size();
    }

    // different approach - optimised
    public static int MakeAnagramOptimised(String a, String b) {
        Map<Character, Integer> freqA = new HashMap<>();
        Map<Character, Integer> freqB = new HashMap<>();

        for (char c : a.toCharArray()) {
            freqA.put(c, freqA.getOrDefault(c, 0) + 1);
        }
        for (char c : b.toCharArray()) {
            freqB.put(c, freqB.getOrDefault(c, 0) + 1);
        }

        int deletions = 0;

        for (char c : freqA.keySet()) {
            int countA = freqA.get(c);
            int countB = freqB.getOrDefault(c, 0);
            deletions += Math.abs(countA - countB);
        }
        for (char c : freqB.keySet()) {
            if (!freqA.containsKey(c)) {
                deletions += freqB.get(c);
            }
        }
        return deletions;
    }
}