public class CalculateBmi {
    public static void main(String[] args) {
        System.out.println(bmi(91, 1.81));
    }
    public static String bmi(double weight, double height) {
        double myBmi = weight / (height*height);
        System.out.println(myBmi);
        if(myBmi <= 18.5) {
            return "Underweight";
        } else if(myBmi <= 25.0) {
            return "Normal";
        } else if(myBmi <= 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}