public class BasicOperations {
    public static void main(String[] args) {

        System.out.println(basicMath("/",10,2));
    }

    public static Integer basicMath(String op, int v1, int v2) {
        if (op.equals("+")) {
            return v1 + v2;
        } else if (op.equals("-")) {
            return v1 - v2;
        } else if (op.equals("*")) {
            return v1 * v2;
        } else if (op.equals("/")) {
            return v1 / v2;
        }
        return 0;
    }
}
