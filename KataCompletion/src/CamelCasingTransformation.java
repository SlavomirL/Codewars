import java.util.stream.IntStream;

class CamelCasingTransformation{

    public static void main(String[] args) {

        System.out.println(toCamelCase("hi-all"));
    }

    public static String toCamelCase(String str){
        String[] words = str.split("[-_ ]+");

        return IntStream.range(0, words.length)
            .mapToObj( index -> {
                String word = words[index];
                if (index == 0) {
                    return word;
                } else {
                    return Character.toUpperCase(word.charAt(0)) + word.substring(1);
                }
            })
            .reduce("", String::concat);
    }
}
