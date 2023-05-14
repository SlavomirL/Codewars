import java.util.Arrays;

public class FindTheParityOutlier {

    public static void main(String[] args) {
        int[] exampleTest1 = {2,6,8,-10,3};
        int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};

        System.out.println(find(new int[]{2,1,2,4,6,8,10,10,12,14,16,18,20}));
        System.out.println(find(new int[]{3,3,4,7,11,13,151,13,18,21,27}));
        System.out.println(find(exampleTest1));
        System.out.println(find(exampleTest2));
        System.out.println(find(exampleTest3));
    }

    static int find(int[] integers){

        if(integers[0] % 2 == 0 && integers[1] % 2 == 0) {
            for(int i = 2; i < integers.length; i++) {
                if (integers[i] % 2 != 0) {
                    return integers[i];
                }
            }
        } else if(integers[0] % 2 != 0 && integers[1] % 2 != 0) {
            for(int i = 2; i < integers.length; i++) {
                if (integers[i] % 2 == 0) {
                    return integers[i];
                }
            }
        } else {
            if(integers[2] % 2 == 0) {
                if (integers[0] % 2 == 0) {
                    return integers[1];
                } else {
                    return integers[0];
                }
            } else {
                if (integers[0] % 2 == 0) {
                    return integers[0];
                } else {
                    return integers[1];
                }
            }
        }
        return 0;
    }

//    // much better solution
//    public static int find(int[] integers){
//        int[] odd = Arrays.stream(integers).filter(n -> n % 2 != 0).toArray();
//        int[] even = Arrays.stream(integers).filter(n -> n % 2 == 0).toArray();
//
//        return odd.length == 1 ? odd[0] : even[0];
//    }

}
