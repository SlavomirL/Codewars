package algos;

public class BishopMovementChecker {

    public static void main(String[] args) {
        System.out.println(bishop("a1", "a3", 0)); // false
        System.out.println(bishop("a1", "c3", 1)); // true
        System.out.println(bishop("a1", "a3", 2)); // true
        System.out.println(bishop("a1", "a2", 2)); // false
        System.out.println(bishop("h1", "h3", 2)); // true
        System.out.println(bishop("h1", "a1", 2)); // false
        System.out.println(bishop("h1", "b3", 2)); // true
        System.out.println(bishop("c5", "d6", 0)); // false
        System.out.println(bishop("c5", "a7", 1)); // true
    }

    /*
    *   8 |_|#|_|#|_|#|_|#|
        7 |#|_|#|_|#|_|#|_|
        6 |_|#|_|#|_|#|_|#|
        5 |#|_|#|_|#|_|#|_|
        4 |_|#|_|#|_|#|_|#|
        3 |#|_|#|_|#|_|#|_|
        2 |_|#|_|#|_|#|_|#|
        1 |#|_|#|_|#|_|#|_|
           a b c d e f g h
    *
    *
    * */

    public static boolean bishop(String positionStart, String positionEnd, int n) {
        if(n == 0) {
            return positionStart.equals(positionEnd);
        }

        int startCol = positionStart.charAt(0);
        int startRow = positionStart.charAt(1) - '0';
        int endCol = positionEnd.charAt(0);
        int endRow = positionEnd.charAt(1) - '0';

        int startSum = startCol + startRow;
        int endSum = endCol + endRow;

        if (startSum % 2 == 0 && endSum % 2 == 0) {
            if (n >= 2) {
                return true;
            } else {
                if (startCol - endCol == startRow - endRow || startCol - endCol == -1 * (startRow - endRow)) {
                    // you can use Math.abs() instead to get always positive number
                    return true;
                } else {
                    return false;
                }
            }
        }

        if (startSum % 2 != 0 && endSum % 2 != 0) {
            if (n >= 2) {
                return true;
            } else {
                if (startCol - endCol == startRow - endRow || startCol - endCol == -1 * (startRow - endRow)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

}
