package algos;

public class PileOfTowels {

    public static void main(String[] args) {
        String[] towels = {"red", "blue", "red", "blue", "red"};
        int[] usedTowels = {4};

        String[] result = sortTowels(towels, usedTowels);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static String[] sortTowels(String[] towels, int[] usedTowels) {
        int towelsPerWeek = Integer.MIN_VALUE;
        for (int i = 0; i < usedTowels.length; i++) {
            if (usedTowels[i] > towelsPerWeek) {
                towelsPerWeek = usedTowels[i];
            }
        }

        for (int i = towels.length - towelsPerWeek; i < towels.length; i++) { // 1 do 4
            for (int j = i + 1; j < towels.length; j++) { // 2 do 4, 3 do 4, 4 do 4
                if (towels[i].equals("blue") && towels[j].equals("red")) {
                    towels[i] = "red";
                    towels[j] = "blue";
                    break;
                }
            }
        }
        return towels;
    }

}