package algos;

public class RussianPlurals {

    public static void main(String[] args) {
        String[] forms = {"singular", "plural", "genitiv"};
        System.out.println(chooseForm(forms, 0));
        System.out.println(chooseForm(forms, 1));
        System.out.println(chooseForm(forms, 2));
        System.out.println(chooseForm(forms, 3));
        System.out.println(chooseForm(forms, 4));
        System.out.println(chooseForm(forms, 5));
        System.out.println(chooseForm(forms, 11));
        System.out.println(chooseForm(forms, 20));
        System.out.println(chooseForm(forms, 21));
        System.out.println(chooseForm(forms, 22));


/*
        0, "genitiv"
        1, "singular"
        2, "plural"
        3, "plural"
        4, "plural"
        5, "genitiv"
        11, "genitiv"
        20, "genitiv"
        21, "singular"
        22, "plural"
        */
    }

    public static String chooseForm(String[] forms, int number) {
        if (number % 10 == 1) {
            if (number % 100 != 11) {
                return forms[0];
            }
        } else if (number % 10 == 2 || number % 10 == 3 || number % 10 == 4) {
            if (number % 100 != 12 && number % 100 != 13 || number % 100 != 14) {
                return forms[1];
            }
        } else {
            return forms[2];
        }
        return forms[2];
    }
}
