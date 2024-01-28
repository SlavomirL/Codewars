package algos;

public class FindUniqueNumber {

    /* given the array of numbers, find the number that is different to others */

    // this is my initial solution that  was not working for super large arrays
//    public static double findUniq(double arr[]) {
//        int countOne = 0;
//        int countTwo = 0;
//        for(int i = 0; i <= arr.length / 2 - 1; i++) {
//            countOne += arr[i];
//            countTwo += arr[arr.length / 2 + i];
//        }
//        if(countOne == countTwo) {
//            return arr[arr.length - 1];
//        } else {
//            if(countOne > countTwo) {
//                return arr[arr.length - 1] + countOne - countTwo;
//            } else {
//                return arr[0] - (countOne - countTwo);
//            }
//        }
//    }

    // my second solution
    public static double findUniq(double arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                if (i == 0) {
                    if (arr[0] == arr[2]) {
                        return arr[1];
                    } else {
                        return arr[0];
                    }
                } else {
                    return arr[i + 1];
                }
            }
        }
        return -1;
    }

    // solution from CodeWars - for future reference
//    public static double findUniq(double[] arr) {
//        Arrays.sort(arr);
//        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
//    }

}