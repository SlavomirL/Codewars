package algos;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        System.out.println("1) TwoDimArrayHourglassSum.java");

        System.out.println();
        System.out.println("2) AlternatingCharacters.java");
        System.out.println(AlternatingCharacters.alternatingCharacters("AABBAA"));

        System.out.println();
        System.out.println("3) RansomNote.java");
        List<String> magazine = new ArrayList<>();
        magazine.add("two");
        magazine.add("times");
        magazine.add("three");
        magazine.add("is");
        magazine.add("not");
        magazine.add("four");
        List<String> notes = new ArrayList<>();
        notes.add("two");
        notes.add("times");
        notes.add("two");
        notes.add("is");
        notes.add("four");

        RansomNote.checkMagazine(magazine, notes);

        System.out.println();
        System.out.println("4) LeftRotationArrays");
        List<Integer> numArray = new ArrayList<>();
        numArray.add(1);
        numArray.add(2);
        numArray.add(3);
        numArray.add(4);
        numArray.add(5);

        System.out.println(LeftRotationArrays.rotLeft(numArray, 7));

        System.out.println();
        System.out.println("5) MakingAnagrams");
        String s1 = "cde";
        String s2 = "abc";
        String s11 = "fcrxzwscanmligyxyvym";
        String s12 = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(MakingAnagrams.makeAnagram(s1, s2));
        System.out.println(MakingAnagrams.makeAnagram(s11, s12));
        String s111 = "abc";
        String s112 = "aaa";
        System.out.println(MakingAnagrams.makeAnagram(s111, s112));

        System.out.println();
        System.out.println("6) TwoStrings");
        System.out.println(TwoStrings.twoStrings(s1, s2));

        System.out.println();
        System.out.println("7) SubarrayDivision");
        //          5 consecutive numbers should equal to 2 - no solution
        System.out.println(SubarrayDivision.birthday(numArray, 5, 2));
        //          2 consecutive numbers should equal to 5 - 1 solution
        System.out.println(SubarrayDivision.birthday(numArray, 2, 25));

        System.out.println();
        System.out.println("8) CompareTheTriplets");
        List<Integer> alice = new ArrayList<>();
        alice.add(1);
        alice.add(2);
        alice.add(3);
        List<Integer> bob = new ArrayList<>();
        bob.add(1);
        bob.add(3);
        bob.add(2);
        System.out.println(CompareTheTriplets.compareTriplets(alice, bob));

        System.out.println();
        System.out.println("9) DiagonalDifference");
        List<List<Integer>> twoDimList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                row.add((int) (Math.random() * 10));
            }
            twoDimList.add(row);
        }
        for (List<Integer> row : twoDimList) {
            for (Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println(DiagonalDifference.diagonalDifference(twoDimList));

        System.out.println();
        System.out.println("10) HighestScoringWord");
        System.out.println(HighestScoringWord.high("what time are we climbing up to the volcano"));


        System.out.println();
        System.out.println("11) StreetFighter");
        String[][] fighters = {
                {"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
                {"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"}
        };
        int[] initial_position = {0, 0};
        String[] moves = {"up", "left", "right", "left", "left"};
        System.out.println(Arrays.toString(StreetFighter.streetFighterSelection(fighters, initial_position, moves)));


        System.out.println();
        System.out.println("12) FindUniqueNumber");
        double[] sameNumArr = {0,0,0,0,0,0,0,0,0,0,0.123456};
        System.out.println(FindUniqueNumber.findUniq(sameNumArr));


        System.out.println();
        System.out.println("13) StringArrayDuplicates");
        String[] words = {"codewars", "cccoooddeewarsss"};
        for(String w : StringArrayDuplicates.dup(words)) {
            System.out.println(w);
        }

        System.out.println();
        System.out.println("14) CalculateStringRotation");
        System.out.println(CalculateStringRotation.shiftedDiff("fatigue", "tiguefa"));

        System.out.println();
        System.out.println("15) PascalsTriangle");
        System.out.println(Arrays.toString(PascalsTriangle.generate(5)));

        System.out.println();
        System.out.println("16) SeparateWheatFromChaff");
        long[] positiveNegativeArray = {5,4,-6,-8,7,8,9,10,-5,-7,-8,1,2};
        System.out.println(Arrays.toString(SeparateWheatFromChaff.wheatFromChaff(positiveNegativeArray)));
        System.out.println(Arrays.toString(SeparateWheatFromChaff.wheatFromChaffImproved(positiveNegativeArray)));

        System.out.println();
        System.out.println("17) WhichAreIn");
        String[] array1 = {"ho", "lo", "gu"};
        String[] array2 = {"holub", "oldo", "gunar"};
        System.out.println(Arrays.toString(WhichAreIn.inArray(array1, array2)));

        System.out.println();
        System.out.println("18) ValidParentheses");
        System.out.println(ValidParentheses.validParentheses("(a)c(de}{)()()"));
        System.out.println(ValidParentheses.validParentheses("()(((()))))()"));


        System.out.println();
        System.out.println("20) DuplicatesEverywhere");
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(2, List.of("A", "B", "C", "Y"));
        map.put(4, List.of("A", "A", "B", "C"));
        map.put(5, List.of("B", "A", "B", "C", "A"));
        Map<Integer, List<String>> processedMap = DuplicatesEverywhere.removeDuplicates(map);
        processedMap.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
        DuplicatesEverywhere.removeDuplicates(map);

        System.out.println();
        System.out.println("21) FindOdd");
        int[] numbers = {3,0,3,0,3,1,1,1,1,1,1,2,2,3};
        System.out.println(FindOdd.findIt(numbers));
        System.out.println(FindOdd.findItStreams(numbers));

    }
}