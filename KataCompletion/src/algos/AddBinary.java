package algos;

public class AddBinary {

    public static void main(String[] args) {

        String a = "11";
        String b = "1";
        String c = "1010";
        String d = "1011";
        String e = "10100010";
        String f = "1111";
        String g = "11111100000111";
        String h = "11000000000110";
        // 110111100001101

//        System.out.println(addBinary(a, b));
//        System.out.println(addBinary(c, d));

        System.out.println(addBinaryGeri(a, b));
        System.out.println(addBinaryGeri(c, d));
        System.out.println(addBinaryGeri(e, f));
        System.out.println(addBinaryGeri(g, h));

        System.out.println(addBinaryAgain(a,b));
        System.out.println(addBinaryAgain(c,d));
        System.out.println(addBinaryAgain(e, f));
        System.out.println(addBinaryAgain(g, h));

    }

//    public static String addBinaryFirstAttempt(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int aLength = a.length();
//        int bLength = b.length();
//        Integer aInt = Integer.valueOf(a);
//        Integer bInt = Integer.valueOf(b);
//        int aDigit = 0;
//        int bDigit = 0;
//
//        for(int i = 0; i < a.length(); i++) {
//            int multiplier = 1;
//            for(int j = 0; j < aLength - 1; j++) {
//                multiplier *= 10;
//            }
//            aDigit = aInt % multiplier;
//        }
//
//        for(int i = 0; i < b.length(); i++) {
//            int multiplier = 1;
//            for(int j = 0; j < bLength - 1; j++) {
//                multiplier *= 10;
//            }
//            bDigit = bInt % multiplier;
//        }
//
//        if(aDigit + bDigit == 0) {
//            sb.append(0);
//        }
//        if(aDigit + bDigit == 1) {
//            sb.append(1);
//        }
//        if(aDigit + bDigit == 2) {
//            sb.append(0);
//            // do something else
//        }
//    }


    public static String addBinaryGeri(String a, String b) {
        int length = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < length; i++) {
            int indexA = a.length() - 1 - i;
            int indexB = b.length() - 1 - i;
            int digitA = indexA >= 0 ? a.charAt(indexA) - '0' : 0;
            int digitB = indexB >= 0 ? b.charAt(indexB) - '0' : 0;
            int sum = digitA + digitB + carry;

//            this whole block can be written in two lines as shown below
//            if (sum == 0) {
//                carry = 0;
//                sb.append(0);
//            } else if (sum == 1) {
//                carry = 0;
//                sb.append(1);
//            } else if (sum == 2) {
////                carry = 1;
////                sb.append(0);
////            }else {
//                carry = 1;
//                sb.append(1);
//            }
            carry = sum >= 2 ? 1 : 0;
            sb.append(sum % 2);
        }

        if (carry == 1) {
            sb.append(1);
        }
//        return sb.reverse().toString();
        return String.valueOf(sb.reverse());
    }

    public static String addBinaryAgain(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < maxLength; i++) {
            int indexA = a.length() - i - 1;
            int indexB = b.length() - i - 1;
            int digitA;
            int digitB;
            if(indexA < 0) {
                digitA = 0;
            } else {
                digitA = a.charAt(indexA) - '0';
            }
            if(indexB < 0) {
                digitB = 0;
            } else {
                digitB = b.charAt(indexB) - '0';
            }
            int sum = digitA + digitB + carry;

            if(sum == 0) {
                carry = 0;
                sb.append(0);
            } else if (sum == 1) {
                carry = 0;
                sb.append(1);
            } else if (sum == 2){
                carry = 1;
                sb.append(0);
            } else {
                carry = 1;
                sb.append(1);
            }
        }

        if(carry == 1) {
            sb.append(1);
        }
//        return sb.reverse().toString();
        return String.valueOf(sb.reverse());
    }

}