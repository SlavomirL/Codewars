package advent.day5;

/*
* --- Part Two ---
Everyone will starve if you only plant such a small number of seeds. Re-reading the almanac, it looks like the seeds: line actually describes ranges of seed numbers.

The values on the initial seeds: line come in pairs. Within each pair, the first value is the start of the range and the second value is the length of the range. So, in the first line of the example above:

seeds: 79 14 55 13
This line describes two ranges of seed numbers to be planted in the garden. The first range starts with seed number 79 and contains 14 values: 79, 80, ..., 91, 92. The second range starts with seed number 55 and contains 13 values: 55, 56, ..., 66, 67.

Now, rather than considering four seed numbers, you need to consider a total of 27 seed numbers.

In the above example, the lowest location number can be obtained from seed number 82, which corresponds to soil 84, fertilizer 84, water 84, light 77, temperature 45, humidity 46, and location 46. So, the lowest location number is 46.

Consider all of the initial seed numbers listed in the ranges on the first line of the almanac. What is the lowest location number that corresponds to any of the initial seed numbers?
* */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5Hard {

    public static void main(String[] args) {
        System.out.println(findLocation(parseFile()));
//        String[] test = new String[] {"79", "14", "55", "13"};
//        System.out.println(getSeeds(test));
    }


    public static long findLocation(List<List<List<String>>> parsedInput) {
        int initSeedQty = parsedInput.get(0).get(0).size();
        long currentMinLoc = Long.MAX_VALUE;
        for (int i = 0; i < initSeedQty; i++) {
            long result1 = track(Long.parseLong(parsedInput.get(0).get(0).get(i)), parsedInput.get(1));
            long result2 = track(result1, parsedInput.get(2));
            long result3 = track(result2, parsedInput.get(3));
            long result4 = track(result3, parsedInput.get(4));
            long result5 = track(result4, parsedInput.get(5));
            long result6 = track(result5, parsedInput.get(6));
            long result7 = track(result6, parsedInput.get(7));

            if (result7 < currentMinLoc) {
                currentMinLoc = result7;
            }
        }
        return currentMinLoc;
    }

    public static List<List<List<String>>> parseFile() {
        List<List<List<String>>> wholeFileParsed = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("input/Day5.txt"));
//            BufferedReader br = new BufferedReader(new FileReader("input/Day5short.txt"));
            List<String> inputList = br.lines().toList();

            List<List<String>> seedList = new ArrayList<>();
            String[] seedsUnparsed = inputList.get(0).substring(inputList.get(0).indexOf(":") + 2).split(" ");
            List<String> seedsParsed = getSeeds(seedsUnparsed);
            seedList.add(seedsParsed);
            wholeFileParsed.add(seedList);

            boolean subListExists = true;
            List<List<String>> sourceToDestList = new ArrayList<>();
            for (int i = 3; i < inputList.size(); i++) {
                if (!subListExists) {
                    sourceToDestList = new ArrayList<>();
                    subListExists = true;
                }

                if (inputList.get(i).isEmpty()) {
                    wholeFileParsed.add(sourceToDestList);
                    subListExists = false;
                } else {
                    if (Character.isDigit(inputList.get(i).charAt(0))) {
                        List<String> sourceToDest = List.of(inputList.get(i).split(" "));
                        sourceToDestList.add(sourceToDest);
                    }
                }
                if (i == inputList.size() - 1) {
                    wholeFileParsed.add(sourceToDestList);
                    subListExists = false;
                }
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return wholeFileParsed;
    }

    public static List<String> getSeeds(String[] seedArray) {
        List<String> initSeeds = new ArrayList<>();
        List<String> ranges = new ArrayList<>();
        for (int i = 0; i < seedArray.length; i++) {
            if (i % 2 != 0) {
                ranges.add(seedArray[i]);
            } else {
                initSeeds.add(seedArray[i]);
            }
        }
        long seedQty = 0;
        for(int i = 0; i < ranges.size(); i++) {
            seedQty += Long.parseLong(ranges.get(i));
            System.out.println(i + " = " + seedQty);
        }
        List<String> resultSeeds  = new ArrayList<>();
//        String[] resultSeeds = new String[seedQty];
        for(int i = 0; i < seedQty; i++) {
            for(int j = 0; j < initSeeds.size(); j++) {
                for(long k = 0; k < Long.parseLong(ranges.get(j)); k++) {
                    resultSeeds.add(String.valueOf(Long.parseLong(initSeeds.get(j)) + k));
                    i++;
                }
            }
        }
        return resultSeeds;
    }


    public static long track(long beforeValue, List<List<String>> mapping) {
        long resultTrack;
        for (int i = 0; i < mapping.size(); i++) {
            long destination = Long.parseLong(mapping.get(i).get(0));
            long source = Long.parseLong(mapping.get(i).get(1));
            long range = Long.parseLong(mapping.get(i).get(2));

            if (beforeValue >= source && beforeValue <= source + range) {
                resultTrack = beforeValue - source + destination;
                return resultTrack;
            }
        }
        resultTrack = beforeValue;
        return resultTrack;
    }

}