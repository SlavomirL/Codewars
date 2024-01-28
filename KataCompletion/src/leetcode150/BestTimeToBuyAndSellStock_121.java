package leetcode150;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock_121 {

    public static void main(String[] args) {
        int[] input1 = {15, 20, 11, 20, 99, 100, 5, 40, 3, 20, 1, 4, 2, 7};
        System.out.println(maxProfit(input1));

        int[] input2 = {15, 20, 11, 20, 99, 100, 5, 40, 3, 20, 1, 4, 2, 7};
        System.out.println(maxProfitLC2(input2));

        int[] input3 = {15, 20, 11, 20, 99, 100, 5, 40, 3, 20, 1, 4, 2, 7};
        System.out.println(maxProfitLC0(input3));

    }


    // moje riesenie - 361 ms
    public static int maxProfit(int[] prices) {
        int min;
        int max;
        int indexMax = 0;
        int maxDiff = 0;
        int tempDiff = 0;

        //  15 20 11 20 99 100 5 40 3 20 1 4 2 7
        //  7, 1, 5, 3, 6, 4
        while (prices.length > 1) {
            min = prices[0];
            max = prices[0];

            for (int i = 0; i < prices.length; i++) {
                if (prices[i] >= max) {
                    max = prices[i];
                    indexMax = i;
                }
            }

            for (int i = 0; i < indexMax; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                }
            }

            tempDiff = max - min;
            if (tempDiff > maxDiff) {
                maxDiff = tempDiff;
            }
            prices = Arrays.copyOfRange(prices, indexMax + 1, prices.length);
        }
        return maxDiff;
    }

    // leetcode riesenie - 2 ms
//    {15, 20, 11, 20, 99, 100, 5, 40, 3, 20, 1, 4, 2, 7};
    public static int maxProfitLC2(int[] prices) {
        int maxProfit = 0; // S - B

        int sell = 1;
        int buy = 0;

        while (sell < prices.length) {

            if (prices[buy] > prices[sell]) {
                buy = sell;
            } else {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            }
            sell++;
        }
        return maxProfit;

    }
// riesenie leet code - 0ms?
    public static int maxProfitLC0(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int max = 0;

        // nechapem tuto cast kodu
//        if(n > 100 && prices[0] == 397) return 9995;
//        if(n > 100 && prices[0] == 10000) return 3;
//        if(n > 100 && prices[0] == 9973) return 0;
//        if(n > 100 && prices[0] == 5507) return 9972;
//        if(n > 100) return 999;

        for(int i : prices){
            min = Math.min(min, i);
            max = Math.max(max, i-min);

        }
        return max;
    }


}