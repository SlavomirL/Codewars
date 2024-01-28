package algos;

import java.util.ArrayList;
import java.util.List;

public class LeftRotationArrays {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int move;
        if (d > a.size()) {
            move = d % a.size();
        } else {
            move = d;
        }

        List<Integer> aCopy = new ArrayList<>();

        for (int j = 0; j < a.size(); j++) {
            if (j < (a.size() - move)) {
                aCopy.add(j, a.get(j + move));
            } else {
                aCopy.add(j, a.get(j - (a.size() - move)));
            }
        }
        return aCopy;
    }
}