// A Java program to demonstrate working of recursion
public class RecursionTest {
    static void printFun(int test)  {
        if (test < 1)
            System.out.println("test = 0");
        else {
            System.out.println("before recursion = " + test);
            printFun(test - 1); // statement 2
            // the code below is executed last. Once the 'test < 1' is true, code below is executed for each invoked
            // printFun method recursively, means last invoked method is executed first etc. (like nested statements)
            System.out.println("after recursion = " + test);
            System.out.println("end of else statement");
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int test = 3;
        printFun(test);
    }
}