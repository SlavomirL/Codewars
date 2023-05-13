class CamelCasingBreak {

    public static void main(String[] args) {
        System.out.println(camelCase("camelCasing"));
    }

    public static String camelCase(String input) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            if(Character.isUpperCase(input.charAt(i))) {
                sb = sb.append(" ").append(input.charAt(i));
            } else {
                sb = sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

//    public static String camelCase(String input) {
//        return input.replaceAll("([A-Z])", " $1"); // " $1" is backreferencing -> means that anything that was found by
//        // regex will be replaced with " " and this regex. if you have more regex groups, you backreference them with
//        // $2, $3 etc.
//    }
}