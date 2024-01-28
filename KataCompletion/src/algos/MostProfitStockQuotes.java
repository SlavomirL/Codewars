package algos;/*
* Return the most profit from stock quotes.
*
* Stock quotes are stored in an array in order of date. The stock profit is the difference in prices in buying and selling stock. Each day, you can either buy one unit of stock, sell any number of stock units you have already bought, or do nothing. Therefore, the most profit is the maximum difference of all pairs in a sequence of stock prices.

@param {array} quotes
@return {number} max profit
Example:

 [ 1, 2, 3, 4, 5, 6 ]        => 15  (buy at 1,2,3,4,5 and then sell all at 6)
 [ 6, 5, 4, 3, 2, 1 ]        => 0   (nothing to buy for profit)
 [ 1, 6, 5, 10, 8, 7 ]       => 18  (buy at 1,6,5 and sell all at 10)
 [ 1, 2, 10, 3, 2, 7, 3, 2 ] => 26  (buy at 1,2 and sell them at 10. Then buy at 3,2 and sell them at 7)
* */

import java.util.Arrays;
import java.util.OptionalLong;

public class MostProfitStockQuotes {

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5, 6};
        int[] input2 = {6, 5, 4, 3, 2, 1};
        int[] input3 = {1, 6, 5, 10, 8, 7};
        int[] input4 = {1, 2, 10, 3, 2, 7, 3, 2};

        System.out.println(stockProfit(input1));
        System.out.println(stockProfit(input2));
        System.out.println(stockProfit(input3));
        System.out.println(stockProfit(input4));

    }


    public static long stockProfit(int[] input) {
        long profit = 0;
        int[] subInput = input;
        while (subInput != null) {
            int counter = 0;
            int invested = 0;
            long max = findMaxValue(subInput);
            for (int i = 0; i < subInput.length; i++) {
                if (subInput[i] != max) {
                    counter++;
                    invested += subInput[i];
                }
                if (subInput[i] == max) {
                    profit = profit + counter * max - invested;
                    subInput = Arrays.copyOfRange(subInput, i + 1, subInput.length);
                    if (subInput.length < 2) {
                        subInput = null;
                    }
                    break;
                }
            }
        }
        return profit;
    }

    public static long findMaxValue(int[] input) {
        OptionalLong max = Arrays.stream(input).asLongStream().max();
        long maxValue = max.getAsLong();
        return maxValue;
    }

}