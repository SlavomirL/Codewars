public class DistanceCheck {

    public static void main(String[] args) {
        System.out.println(zeroFuel(100,20,5));
    }

    public static boolean zeroFuel(double distanceToPump, double mpg, double fuelLeft) {
        if(distanceToPump > mpg * fuelLeft) {
            return false;
        } else {
            return true;
        }
    }

}