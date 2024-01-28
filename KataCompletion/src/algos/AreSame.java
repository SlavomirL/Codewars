package algos;

public class AreSame {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3};
        int[] b = {1, 4, 9, 9};

        System.out.println(comp(a, b));
    }

    public static boolean comp(int[] a, int[] b) {
        if(a == null || b == null) {
            return false;
        }

        if(a.length != b.length) {
            return false;
        }

        if(a.length == 0) {
            return true;
        }

        for(int i = 0; i < a.length; i++) {
            boolean flag = false;
            for(int j = 0; j < b.length; j++) {
                if(a[i] * a[i] == b[j]) {
                    b[j] = -1;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                return false;
            }
        }
        return true;
    }

}
