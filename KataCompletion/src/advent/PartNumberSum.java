package advent;

public class PartNumberSum {
    public static void main(String[] args) {
        String schematic =
                "467..114..\n" +
                        "...*......\n" +
                        "..35..633.\n" +
                        "......#...\n" +
                        "617*......\n" +
                        ".....+.58.\n" +
                        "..592.....\n" +
                        "......755.\n" +
                        "...$.*....\n" +
                        ".664.598..";

        int sumOfPartNumbers = calculatePartNumberSum(schematic);
        System.out.println("Sum of all part numbers: " + sumOfPartNumbers);
    }

    public static int calculatePartNumberSum(String schematic) {
        String[] lines = schematic.split("\n");
        int sum = 0;

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                if (Character.isDigit(lines[i].charAt(j)) && isPartNumber(lines, i, j)) {
                    sum += Character.getNumericValue(lines[i].charAt(j));
                }
            }
        }
        return sum;
    }

    public static boolean isPartNumber(String[] lines, int row, int col) {
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int k = 0; k < 8; k++) {
            int newRow = row + dx[k];
            int newCol = col + dy[k];

            if (isValidPosition(lines, newRow, newCol) && lines[newRow].charAt(newCol) != '.') {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidPosition(String[] lines, int row, int col) {
        return row >= 0 && row < lines.length && col >= 0 && col < lines[row].length();
    }
}