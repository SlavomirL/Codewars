public class PigLatin {
    // Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.

    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool"));
        System.out.println(pigIt("Hello world !"));
    }

    public static String pigIt(String str) {
        String[] words = str.split(" ");
        String result = "";
        for(int i = 0; i < words.length; i++) {
            if (!words[i].matches("[^a-zA-Z]")) {
                words[i] = words[i].substring(1) + words[i].charAt(0) + "ay";
            }
            if(i < words.length-1) {
                result = result + words[i] + " ";
            } else {
                result = result + words[i];
            }
        }
        return result;
    }
}