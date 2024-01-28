package advent.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5HardAnother {

    public static void main(String[] args) {
        // output file
        List<List<String[]>> ranges = getRanges();
        for (int i = 0; i < ranges.size(); i++) {
            for (int j = 0; j < ranges.get(i).size(); j++) {
                for (int k = 0; k < ranges.get(i).get(j).length; k++) {
                    System.out.print(ranges.get(i).get(j)[k] + " | ");
                }
                System.out.println();
            }
            System.out.println("===");
        }
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

    public static List<List<String[]>> getRanges() {
        /*
         * inputLines = read file
         * alLRanges = final result - list of lists of arrays (ranges)
         * seedList = first list in the allRanges
         * subListRanges = another List in the allRanges
         * subSubRange = each line in particular subListRanges
         * */
        try {
            BufferedReader br = new BufferedReader(new FileReader("input/Day5.txt"));
//        BufferedReader br = new BufferedReader(new FileReader("input/Day5short.txt"));

            List<String> inputLines = br.lines().toList();
            List<List<String[]>> allRanges = new ArrayList<>();

            List<String[]> seedList = new ArrayList<>();
            String[] seedRangesRough = inputLines.get(0).substring(inputLines.get(0).indexOf(":") + 2).split(" ");
            for (int i = 0; i < seedRangesRough.length; i += 2) {
                String[] seedRanges = new String[2];
                seedRanges[0] = seedRangesRough[i];
                seedRanges[1] = seedRangesRough[i + 1];
                seedList.add(seedRanges);
            }
            allRanges.add(seedList);

            boolean subListExists = true;
            List<String[]> subListRanges = new ArrayList<>();
            for (int i = 3; i < inputLines.size(); i++) {
                if (!subListExists) {
                    subListRanges = new ArrayList<>();
                    subListExists = true;
                }
                if (inputLines.get(i).isEmpty()) {
                    allRanges.add(subListRanges);
                    subListExists = false;
                } else {
                    if (Character.isDigit(inputLines.get(i).charAt(0))) {
                        String[] subSubRange = inputLines.get(i).split(" ");
                        subListRanges.add(subSubRange);
                    }
                }
                if (i == inputLines.size() - 1) {
                    allRanges.add(subListRanges);
                    subListExists = false;
                }
            }
            return allRanges;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static long track(long beforeValue, List<List<String>> mapping) {
//        long resultTrack;
//        long rangeMin;
//        long rangeMax;
//
//        for (int i = mapping.size() - 1; i >= 0; i--) {
//            for (int j = mapping.get(i).size())
//                long destination = Long.parseLong(mapping.get(i).get(0));
//            long source = Long.parseLong(mapping.get(i).get(1));
//            long range = Long.parseLong(mapping.get(i).get(2));
//
//            if (beforeValue >= source && beforeValue <= source + range) {
//                resultTrack = beforeValue - source + destination;
//                return resultTrack;
//            }
//        }
//        resultTrack = beforeValue;
//        return resultTrack;
//    }

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
        for (int i = 0; i < ranges.size(); i++) {
            seedQty += Long.parseLong(ranges.get(i));
            System.out.println(i + " = " + seedQty);
        }
        List<String> resultSeeds = new ArrayList<>();
//        String[] resultSeeds = new String[seedQty];
        for (int i = 0; i < seedQty; i++) {
            for (int j = 0; j < initSeeds.size(); j++) {
                for (long k = 0; k < Long.parseLong(ranges.get(j)); k++) {
                    resultSeeds.add(String.valueOf(Long.parseLong(initSeeds.get(j)) + k));
                    i++;
                }
            }
        }
        return resultSeeds;
    }

}
