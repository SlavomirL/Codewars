package algos;

public class StreetFighter {
    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        String[] hoveredChars = new String[moves.length];

        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]) {
                case "up":
                    hoveredChars[i] = fighters[0][position[1]];
                    position[0] = 0;
                    break;
                case "down":
                    hoveredChars[i] = fighters[1][position[1]];
                    position[0] = 1;
                    break;
                case "left":
                    if (position[1] == 0) {
                        hoveredChars[i] = fighters[position[0]][5];
                        position[1] = 5;
                        break;
                    } else {
                        hoveredChars[i] = fighters[position[0]][position[1] - 1];
                        position[1] = position[1] - 1;
                        break;
                    }
                case "right":
                    if (position[1] == fighters[1].length - 1) {
                        hoveredChars[i] = fighters[position[0]][0];
                        position[1] = 0;
                        break;
                    } else {
                        hoveredChars[i] = fighters[position[0]][position[1] + 1];
                        position[1] = position[1] + 1;
                        break;
                    }
            }
        }
        return hoveredChars;
    }
}