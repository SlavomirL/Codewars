package algos;

import java.util.List;

public class RansomNote {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        for(int i = 0; i < note.size(); i++) {
            for (int j = 0; j < magazine.size(); j++) {
                if(note.get(i).equals(magazine.get(j))) {
                    magazine.set(j, "N/A");
                    break;
                }
                if(j == magazine.size() - 1) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}