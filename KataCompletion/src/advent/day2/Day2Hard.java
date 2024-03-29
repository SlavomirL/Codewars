package advent.day2;

/*
* --- Part Two ---
The Elf says they've stopped producing snow because they aren't getting any water! He isn't sure why the water stopped; however, he can show you how to get to the water source to check it out for yourself. It's just up ahead!

As you continue your walk, the Elf poses a second question: in each game you played, what is the fewest number of cubes of each color that could have been in the bag to make the game possible?

Again consider the example games from earlier:

Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
In game 1, the game could have been played with as few as 4 red, 2 green, and 6 blue cubes. If any color had even one fewer cube, the game would have been impossible.
Game 2 could have been played with a minimum of 1 red, 3 green, and 4 blue cubes.
Game 3 must have been played with at least 20 red, 13 green, and 6 blue cubes.
Game 4 required at least 14 red, 3 green, and 15 blue cubes.
Game 5 needed no fewer than 6 red, 3 green, and 2 blue cubes in the bag.
The power of a set of cubes is equal to the numbers of red, green, and blue cubes multiplied together. The power of the minimum set of cubes in game 1 is 48. In games 2-5 it was 12, 1560, 630, and 36, respectively. Adding up these five powers produces the sum 2286.

For each game, find the minimum set of cubes that must have been present. What is the sum of the power of these sets?*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2Hard {

    public static List<Map<String, Integer>> inputProcessing(String input) {
        String[] lines = input.split("\n"); // rozdelenie hlavneho inputu na riadky

        List<Map<String, Integer>> result = new ArrayList<>();


        for (int i = 0; i < lines.length; i++) { // v kazdom riadku urob:
            String[] firstSplit = lines[i].substring(lines[i].indexOf(":") + 2).trim().split(";");
            Map<String, Integer> lineMap = new HashMap<>();
            for (int j = 0; j < firstSplit.length; j++) {
                String[] secondSplit = firstSplit[j].split(",");
                for(int k = 0; k < secondSplit.length; k++) {
                    String key = secondSplit[k].trim().substring(secondSplit[k].trim().indexOf(" ") + 1);
                    Integer value = Integer.valueOf(secondSplit[k].trim().substring(0, secondSplit[k].trim().indexOf(" ")));
                    if(lineMap.containsKey(key)) {
                        if(value > lineMap.get(key)) {
                            lineMap.put(key, value);
                        }
                    } else {
                        lineMap.put(key, value);
                    }
                }
            }
            result.add(lineMap);
        }
        return result;
    }


    public static int solution(String input) {
        int result = 0;
        int subtotal = 1;
        List<Map<String, Integer>> processed = inputProcessing(input);
        for(int i = 0; i < processed.size(); i++) {
            subtotal = 1;
            for(Map.Entry<String, Integer> entry : processed.get(i).entrySet()) {
                subtotal *= entry.getValue();
            }
            result += subtotal;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(inputProcessing(shortInput));
        System.out.println(solution(shortInput)); // 1305
        System.out.println(solution(input));
    }

    static String shortInput = "Game 1: 13 red, 18 green; 5 green, 3 red, 5 blue\n" +
            "Game 2: 2 green, 3 blue, 5 red; 9 green, 4 red, 2 blue; 4 green, 3 blue\n";


    static String input = "Game 1: 13 red, 18 green; 5 green, 3 red, 5 blue; 5 green, 9 red, 6 blue; 3 blue, 3 green\n" +
            "Game 2: 2 green, 3 blue, 5 red; 9 green, 4 red, 2 blue; 4 green, 3 blue; 2 blue, 3 red; 5 red, 3 blue, 9 green; 9 green, 5 red, 2 blue\n" +
            "Game 3: 12 green, 3 red, 3 blue; 2 blue, 5 green, 2 red; 2 red, 3 blue, 11 green; 2 red, 8 green, 7 blue\n" +
            "Game 4: 1 green, 2 blue; 7 green, 13 red; 2 blue, 5 green, 7 red; 6 green, 2 red\n" +
            "Game 5: 6 blue, 4 green; 8 blue, 7 green; 1 red, 10 blue\n" +
            "Game 6: 4 red, 4 blue, 2 green; 8 green, 1 blue, 8 red; 9 green, 1 red, 3 blue\n" +
            "Game 7: 3 red, 12 green, 4 blue; 1 blue, 3 red, 6 green; 4 blue, 3 red, 15 green; 11 green, 2 blue, 2 red\n" +
            "Game 8: 13 blue, 7 green, 8 red; 5 green, 8 blue, 2 red; 5 red, 6 blue, 7 green; 6 green, 6 red, 3 blue; 7 blue, 8 red, 6 green\n" +
            "Game 9: 4 blue, 1 green, 4 red; 16 red, 1 green, 7 blue; 11 red, 3 green, 7 blue\n" +
            "Game 10: 5 green, 1 red; 5 green, 3 blue; 1 red, 7 green, 3 blue; 1 blue, 6 green; 2 green, 4 blue\n" +
            "Game 11: 10 green, 2 blue, 2 red; 14 green, 1 blue, 3 red; 13 green; 3 green, 2 red; 3 red, 1 blue, 2 green; 1 red, 10 green, 2 blue\n" +
            "Game 12: 9 green, 2 blue; 11 green, 1 blue; 2 red, 1 blue; 1 blue, 2 red, 3 green; 1 blue, 2 red, 3 green\n" +
            "Game 13: 11 blue, 3 red, 8 green; 9 red, 7 blue; 7 blue, 4 red\n" +
            "Game 14: 17 blue, 2 red; 1 green, 13 blue, 1 red; 4 blue, 1 red, 4 green; 2 blue, 5 red, 13 green; 3 blue, 4 green, 6 red; 9 green, 14 blue, 6 red\n" +
            "Game 15: 7 green, 2 blue, 3 red; 4 red, 18 green; 8 green, 1 blue; 3 red, 15 green, 2 blue; 1 red, 15 green; 9 green, 3 red, 1 blue\n" +
            "Game 16: 10 red, 19 blue, 5 green; 12 red, 5 blue; 6 red, 3 green, 14 blue; 8 red, 10 blue, 6 green; 7 green, 10 red, 17 blue\n" +
            "Game 17: 3 green, 3 red, 1 blue; 3 blue, 1 green, 2 red; 4 green, 3 red, 2 blue\n" +
            "Game 18: 1 red, 2 blue; 1 green, 4 blue; 1 blue; 5 blue; 1 green, 3 red, 6 blue\n" +
            "Game 19: 3 blue, 5 red, 8 green; 10 red, 6 blue, 11 green; 5 blue, 7 red, 8 green; 9 blue, 6 green, 5 red; 8 red, 12 green, 8 blue; 1 blue, 5 green, 10 red\n" +
            "Game 20: 16 blue, 2 green; 10 green, 1 red, 4 blue; 13 green, 5 red, 9 blue\n" +
            "Game 21: 1 blue, 1 green, 14 red; 2 blue; 5 green, 1 blue; 2 green, 11 red; 2 red, 4 green; 2 green, 16 red\n" +
            "Game 22: 1 green, 10 red, 4 blue; 1 green, 4 blue, 8 red; 2 blue, 8 red; 4 green, 14 red; 1 blue, 5 red, 2 green\n" +
            "Game 23: 17 green, 3 red, 16 blue; 9 green, 15 red; 3 red, 8 blue, 15 green\n" +
            "Game 24: 1 green, 1 blue; 2 blue, 1 green, 2 red; 3 green, 1 blue, 1 red; 3 blue, 1 red; 2 green, 5 blue\n" +
            "Game 25: 11 red, 2 green; 7 red, 6 green; 10 red, 1 blue, 8 green; 8 green, 4 red; 6 green, 10 red; 2 blue, 7 red\n" +
            "Game 26: 2 green, 2 blue, 8 red; 1 blue, 1 red, 6 green; 9 red, 6 green, 2 blue\n" +
            "Game 27: 5 red, 7 blue, 3 green; 3 blue, 1 red; 1 green, 1 red, 9 blue\n" +
            "Game 28: 17 red, 5 green, 10 blue; 3 red, 14 blue, 1 green; 11 blue, 11 green\n" +
            "Game 29: 16 red, 4 green, 4 blue; 3 green, 5 blue, 11 red; 7 blue, 8 red, 1 green; 1 green, 10 red, 4 blue; 2 green, 4 blue, 8 red\n" +
            "Game 30: 3 green, 6 blue; 18 green, 3 blue; 14 green, 11 blue; 7 blue, 2 red, 17 green; 1 red, 12 green, 7 blue\n" +
            "Game 31: 11 red, 2 green, 3 blue; 10 green, 11 blue, 15 red; 12 green, 17 blue, 5 red; 5 green, 2 red, 12 blue; 13 blue, 13 green, 4 red\n" +
            "Game 32: 4 red, 2 blue, 5 green; 7 blue, 15 red; 11 blue, 4 green, 8 red\n" +
            "Game 33: 18 blue, 3 green, 3 red; 3 green, 6 red; 2 blue, 4 red, 1 green; 3 green, 5 red, 3 blue\n" +
            "Game 34: 5 red, 2 blue, 16 green; 9 red, 10 blue, 3 green; 8 red, 10 green, 13 blue\n" +
            "Game 35: 7 blue, 5 red; 3 red, 1 blue; 4 blue, 7 red, 1 green; 4 red, 4 blue, 1 green; 3 blue, 7 red; 4 red, 1 green, 3 blue\n" +
            "Game 36: 14 blue; 10 blue, 1 green; 10 blue, 4 green; 4 blue, 1 green, 1 red; 1 red, 6 blue, 4 green; 1 green, 1 red, 11 blue\n" +
            "Game 37: 8 red, 13 green, 5 blue; 11 red, 16 green, 8 blue; 2 green, 10 blue, 11 red\n" +
            "Game 38: 2 red, 1 blue, 10 green; 7 red, 6 blue, 14 green; 18 red, 1 blue, 5 green; 5 green, 5 blue, 13 red; 14 red, 5 green; 15 green, 13 red, 2 blue\n" +
            "Game 39: 1 blue, 5 red; 9 red, 9 green; 4 blue, 10 green, 4 red; 3 green, 11 red, 1 blue; 2 green, 11 red, 4 blue\n" +
            "Game 40: 9 blue, 4 green; 12 green, 1 red; 2 red, 15 green, 10 blue\n" +
            "Game 41: 1 blue, 14 red, 12 green; 16 green, 2 blue, 3 red; 6 green, 9 red\n" +
            "Game 42: 4 green, 13 red, 9 blue; 9 green, 9 red, 4 blue; 7 blue, 10 red, 9 green; 4 green, 18 blue, 14 red; 9 blue, 7 green, 2 red\n" +
            "Game 43: 7 red, 6 blue; 4 green; 3 red, 6 green; 7 blue, 6 green, 8 red; 9 green, 7 blue, 7 red; 5 blue, 5 green, 6 red\n" +
            "Game 44: 5 red, 8 blue; 2 red, 5 green; 6 green, 11 blue, 2 red; 1 green, 1 blue, 2 red\n" +
            "Game 45: 3 blue, 7 green, 1 red; 5 red, 1 blue; 2 blue, 3 red; 8 green, 5 red\n" +
            "Game 46: 4 red, 4 blue, 17 green; 1 blue, 5 green, 1 red; 1 red, 1 blue, 7 green; 18 green, 7 blue\n" +
            "Game 47: 14 red, 3 green, 2 blue; 4 green, 4 red, 2 blue; 13 red, 1 blue\n" +
            "Game 48: 5 red, 12 blue, 2 green; 3 blue, 1 red, 2 green; 10 blue, 7 red\n" +
            "Game 49: 6 blue, 11 red; 11 red, 17 blue, 11 green; 16 blue, 12 green, 6 red\n" +
            "Game 50: 12 blue, 3 green, 1 red; 3 green, 10 blue, 3 red; 11 blue, 3 red\n" +
            "Game 51: 12 green, 1 blue, 8 red; 6 blue, 1 green, 9 red; 17 red, 5 blue; 7 blue, 9 green, 9 red; 13 green, 10 red, 2 blue\n" +
            "Game 52: 5 blue, 1 green; 1 red, 1 green, 3 blue; 8 blue, 1 green; 1 green, 7 blue; 3 blue; 1 red, 6 blue\n" +
            "Game 53: 11 green, 5 red; 16 green, 6 blue; 4 red, 19 green, 4 blue\n" +
            "Game 54: 6 green, 4 blue, 8 red; 7 red, 6 green, 5 blue; 5 blue, 4 red; 5 blue, 14 red\n" +
            "Game 55: 11 blue, 1 green; 2 red, 5 blue, 1 green; 10 blue, 1 green; 11 blue; 2 green, 2 red, 5 blue\n" +
            "Game 56: 1 red, 9 blue, 1 green; 2 red, 8 blue; 1 green, 9 blue, 10 red; 5 blue, 1 green; 15 blue, 1 red; 12 blue, 4 red\n" +
            "Game 57: 1 green, 17 blue; 10 blue, 2 green; 2 red, 16 blue; 6 green, 15 blue; 5 green; 2 red, 1 green\n" +
            "Game 58: 2 blue, 4 green, 2 red; 5 blue; 5 red, 3 green, 2 blue; 5 red, 2 green, 5 blue; 7 green, 3 red, 4 blue; 4 red\n" +
            "Game 59: 8 blue, 2 red, 2 green; 15 blue, 1 green, 4 red; 9 blue, 1 red; 3 green, 5 red, 5 blue\n" +
            "Game 60: 3 red, 2 blue, 6 green; 1 red, 5 green; 2 blue, 10 green; 6 green, 2 red\n" +
            "Game 61: 6 green, 4 blue; 1 red, 4 blue, 15 green; 1 blue, 16 green, 3 red; 6 red, 12 green, 2 blue; 3 red, 14 green, 1 blue; 3 red, 2 blue, 9 green\n" +
            "Game 62: 1 green, 2 red; 4 red; 1 green, 4 red, 1 blue; 1 red, 1 blue, 1 green\n" +
            "Game 63: 8 green, 4 red, 4 blue; 5 red, 4 blue, 8 green; 3 green, 1 blue\n" +
            "Game 64: 5 blue, 2 green, 5 red; 3 green, 2 blue, 1 red; 6 blue, 2 red, 1 green; 2 green, 2 blue, 3 red; 3 blue, 1 red\n" +
            "Game 65: 2 red, 7 green, 5 blue; 8 blue, 3 green, 4 red; 1 red, 6 green, 1 blue\n" +
            "Game 66: 1 green, 6 red; 5 red, 1 green, 1 blue; 4 red, 1 blue, 1 green; 1 blue, 2 red, 1 green; 1 blue, 5 red; 1 blue, 8 red\n" +
            "Game 67: 6 red, 8 blue, 8 green; 5 green, 2 red, 10 blue; 4 red, 1 green; 7 blue, 2 green\n" +
            "Game 68: 7 green, 9 red, 15 blue; 4 green, 6 red, 3 blue; 1 blue, 5 green, 4 red; 9 green, 14 red, 6 blue; 8 blue, 15 red, 4 green; 7 green, 14 blue, 6 red\n" +
            "Game 69: 4 green; 2 blue; 4 green, 8 blue, 11 red; 3 green, 9 red, 4 blue; 1 red, 2 blue; 2 green, 5 blue, 11 red\n" +
            "Game 70: 6 blue, 16 green, 4 red; 6 green, 13 red, 2 blue; 7 green, 1 red, 2 blue; 8 green, 4 blue, 1 red; 10 red, 11 green\n" +
            "Game 71: 6 blue, 7 red; 10 blue, 2 green, 4 red; 12 red, 10 blue, 1 green\n" +
            "Game 72: 13 red, 13 blue; 6 red, 10 blue, 7 green; 3 blue, 5 green, 4 red; 8 green, 9 blue\n" +
            "Game 73: 1 red, 1 green, 8 blue; 1 green, 8 blue; 2 green, 6 blue; 2 blue; 1 red, 12 blue; 12 blue, 3 green\n" +
            "Game 74: 2 blue, 1 green, 1 red; 3 blue, 1 red, 1 green; 3 blue, 2 red; 3 blue, 1 red; 1 green\n" +
            "Game 75: 10 red, 1 green, 4 blue; 12 red, 11 blue, 9 green; 18 green, 14 red, 5 blue\n" +
            "Game 76: 4 blue, 3 green, 11 red; 4 blue, 1 green, 12 red; 11 blue, 2 green, 4 red; 2 blue, 2 green, 11 red; 12 red, 1 blue; 4 red, 2 green, 15 blue\n" +
            "Game 77: 2 red, 10 blue, 6 green; 6 blue, 2 red, 8 green; 1 red, 9 green, 7 blue\n" +
            "Game 78: 3 green, 10 red; 2 blue, 4 red, 3 green; 8 red, 3 blue, 4 green; 1 blue, 7 red\n" +
            "Game 79: 4 green, 2 red; 2 red, 14 green; 1 blue, 5 green, 8 red; 4 red, 20 green; 3 green, 1 blue, 8 red; 4 green, 1 blue\n" +
            "Game 80: 2 green; 3 green, 13 red, 10 blue; 6 blue, 10 red, 1 green; 10 green, 12 red, 3 blue; 10 blue, 17 red, 5 green; 8 red, 2 blue, 6 green\n" +
            "Game 81: 4 green, 2 blue, 4 red; 16 red, 1 blue, 20 green; 7 blue, 10 red, 9 green; 7 blue, 2 green, 14 red\n" +
            "Game 82: 4 blue, 8 green, 5 red; 14 red, 8 blue, 1 green; 11 red, 13 green\n" +
            "Game 83: 2 blue, 2 green, 10 red; 10 green, 4 red, 3 blue; 11 green, 14 red, 4 blue; 2 blue, 11 red; 3 blue, 1 green, 4 red\n" +
            "Game 84: 12 blue, 9 green, 10 red; 1 red, 6 green, 4 blue; 7 red, 3 green, 16 blue; 3 green, 3 blue\n" +
            "Game 85: 2 red, 4 blue; 4 blue, 1 green, 6 red; 9 blue, 1 red; 1 green, 4 blue, 10 red; 5 green, 7 red, 17 blue\n" +
            "Game 86: 2 red, 3 blue, 1 green; 2 blue, 2 red, 2 green; 10 blue, 2 green; 5 green, 4 red, 6 blue\n" +
            "Game 87: 1 red, 7 blue, 9 green; 3 green, 2 blue; 1 red, 4 blue, 10 green; 10 green, 7 blue, 1 red; 6 blue, 9 green; 9 blue, 7 green, 1 red\n" +
            "Game 88: 1 blue, 14 red, 9 green; 4 green, 9 red; 8 green, 1 blue, 10 red\n" +
            "Game 89: 13 red, 1 green; 2 blue, 10 red; 1 green, 3 blue, 13 red; 1 green, 14 red, 3 blue; 2 green, 6 red; 1 green, 12 red\n" +
            "Game 90: 1 red, 2 blue, 9 green; 1 blue, 3 red, 2 green; 10 green, 9 red; 1 red, 9 green, 4 blue; 3 blue, 13 green, 13 red\n" +
            "Game 91: 2 red, 8 green, 8 blue; 3 green, 2 red, 6 blue; 5 green, 4 red\n" +
            "Game 92: 8 green, 12 blue, 4 red; 7 red, 4 green; 4 blue, 7 green, 7 red; 7 blue, 5 green\n" +
            "Game 93: 1 green, 1 red, 2 blue; 3 green, 1 red, 3 blue; 1 red, 8 blue; 1 green, 13 blue; 1 red, 4 blue, 4 green\n" +
            "Game 94: 2 blue, 7 red, 17 green; 2 green, 1 blue, 5 red; 3 blue, 7 green, 1 red; 6 red, 1 blue, 1 green; 1 green, 1 blue, 1 red\n" +
            "Game 95: 4 blue, 3 green, 4 red; 17 red, 2 blue; 6 blue, 16 green, 15 red; 7 blue, 17 green; 1 red, 3 green, 3 blue; 7 red, 14 green, 4 blue\n" +
            "Game 96: 6 red, 3 blue; 7 green, 5 blue, 10 red; 9 green, 1 blue; 6 blue, 1 red, 12 green; 3 blue, 10 green\n" +
            "Game 97: 3 green, 1 red, 13 blue; 1 red, 8 green, 2 blue; 1 green, 2 blue, 2 red; 1 red, 4 green, 9 blue\n" +
            "Game 98: 1 green, 8 red, 7 blue; 8 blue, 8 red, 3 green; 1 blue, 2 red; 4 red, 7 blue; 3 green, 3 blue, 3 red\n" +
            "Game 99: 9 blue, 14 red; 3 blue, 10 red, 5 green; 3 blue, 3 green, 6 red\n" +
            "Game 100: 12 blue, 2 green; 2 green, 4 red, 13 blue; 9 blue, 1 red, 2 green; 2 green, 3 red, 1 blue";
}
