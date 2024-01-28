//public class SudokuValidator {
//
//    class subSquare {
//        private int squares = 9;
//        private int x; // i
//        private int y; // j
//
//        public int[] getCenter(int i, int j) {
//            if (i > 5) {
//                x = 7;
//            } else if (i > 2) {
//                x = 4;
//            } else {
//                x = 1;
//            }
//
//            if (j > 5) {
//                y = 7;
//            } else if (j > 2) {
//                y = 4;
//            } else {
//                y = 1;
//            }
//
//            return new int[]{x, y};
//
//        }
//    }
//
//    public static void main(String[] args) {
//        int[][] board = {
//                {1, 2, 3, 4, 5, 6, 7, 8, 9},
//                {2, 3, 4, 5, 6, 7, 8, 9, 1},
//                {3, 4, 5, 6, 7, 8, 9, 1, 2},
//                {4, 5, 6, 7, 8, 9, 1, 2, 3},
//                {5, 6, 7, 8, 9, 1, 2, 3, 4},
//                {6, 7, 8, 9, 1, 2, 3, 4, 5},
//                {7, 8, 9, 1, 2, 3, 4, 5, 6},
//                {8, 9, 1, 2, 3, 4, 5, 6, 7},
//                {9, 1, 2, 3, 4, 5, 6, 7, 8}
//        };
//        System.out.println(validate(board));
//
//    }
//
//        public static boolean validate ( int[][] board){
//
//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board[i].length; j++) {
//                    for (int k = j + 1; k < board[i].length; k++) {
//                        if (board[i][j] == board[i][k] || board[i][j] == 0) {
//                            return false;
//                        }
//                        if (board[j][i] == board[k][i] || board[j][i] == 0) {
//                            return false;
//                        }
//                    }
//
//                    if ((i+1) % 3 == 0 && (j+1) % 3 == 0) { // i = 9, j = 6
//
//                        for (int x = i; x > i - 3; x--) { // x = 9,8,7
//                            for (int y = j; y > j - 3; y--) { // y = 6,5,4
//
//                                for (int xc = x - 1; xc > x - 3; xc--) { // xc = 8,7
//                                    for (int yc = y - 1; yc > y - 3; yc--) { // yc = 5,4
//                                        if (board[x][y] == board[xc][yc]) {
//                                            return false;
//                                        }
//                                        if (board[y][x] == board[yc][xc]) {
//                                            return false;
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                }
//            }
//
//            int[][] subSquareCenter = {
//                    {1, 1}, {1, 4}, {1, 7},
//                    {4, 1}, {4, 4}, {4, 7},
//                    {7, 1}, {7, 4}, {7, 7}
//            };
//
//            for (int c = 0; c < subSquareCenter.length; c++) {
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; j++) {
//
//                    }
//                }
//            }
//
//            return true;
//        }
//    }
