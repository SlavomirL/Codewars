package algos;

public class ValidParentheses {

    // check if the parentheses in the input String are correct, in correct order

    public static boolean validParentheses(String parens) {
        int left = 0;
        int right = 0;
        for(int i = 0; i < parens.length(); i++) {
            if(String.valueOf(parens.charAt(i)).equals("(")) {
                left ++;
            } else if (String.valueOf(parens.charAt(i)).equals(")")) {
                right ++;
            }
            if(right > left) {
                return false;
            }
        }
        return left==right;
    }
}