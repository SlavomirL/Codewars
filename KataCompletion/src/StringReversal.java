public class StringReversal {
    public static void main(String[] args) {
        System.out.println(solution("[w]orld"));
    }

    // reverse a String
    public static String solution(String str) {
        String reversed = "";
        for(int i = str.length()-1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }
        return reversed;
    }

}