package algos;

class StringArrayDuplicates {

    // remove all consecutive duplicate letters in every String in array


    // my solution
    public static String[] dup(String[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(arr[i].charAt(0)));
            for (int j = 1; j < arr[i].length(); j++) {
                if (!(arr[i].charAt(j) == (arr[i].charAt(j - 1)))) {
                    sb.append(arr[i].charAt(j));
                }
            }
            result[i] = sb.toString();
        }
        return result;
    }


    // solution from CodeWars
    public static String[] dupCW(String[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i].replaceAll("(.)\\1+", "$1");
        return arr;
    }

}