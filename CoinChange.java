
package com.learnToEarn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

public class CoinChange {

    public static int getWaysDynamic(int amount, int[] coins) {
        int rowLen = coins.length;
        int colLen = amount;
        int dp[][] = new int[coins.length][amount + 1];
        for (int row = 0; row < coins.length; row++) {
            dp[row][0] = 1;
        }
        for (int col = 1; col <= amount; col++) {
            int value = (col % coins[0] == 0) ? 1 : 0;
            dp[0][col] = value;
        }
        for (int row = 1; row < coins.length; row++) {
            for (int col = 1; col <= amount; col++) {
                if (coins[row] > col && row > 0) {
                    dp[row][col] = dp[row - 1][col];
                } else {
                    int value = col - coins[row];
                    dp[row][col] = dp[row - 1][col] + dp[row][value];
                }
            }
        }

        for (int row = 0; row < coins.length; row++) {
            for (int col = 0; col <= amount; col++) {
                System.out.print(dp[row][col] + " ");
            }
            System.out.println("\n");
        }

        return dp[rowLen - 1][amount];
    }

    public static long getWaysDynamicList(int n, List<Long> coins) {
        int rowLen = coins.size();
        int colLen = n;
        long dp[][] = new long[rowLen][n + 1];
        for (int row = 0; row < rowLen; row++) {
            dp[row][0] = 1;
        }
        for (int col = 1; col <= n; col++) {
            int value = (col % coins.get(0) == 0) ? 1 : 0;
            dp[0][col] = value;
        }
        for (int row = 1; row < rowLen; row++) {
            for (int col = 1; col <= n; col++) {
                if (coins.get(row) > col && row > 0) {
                    dp[row][col] = dp[row - 1][col];
                } else {
                    int value = (int) (col - coins.get(row));
                    dp[row][col] = dp[row - 1][col] + dp[row][value];
                }
            }
        }

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col <= n; col++) {
                System.out.print(dp[row][col] + " ");
            }
            System.out.println("\n");
        }

        return dp[rowLen - 1][n];
    }

    public static void main(String[] args) {
        List<Long> c = new ArrayList<>();
       /* c.add(2L);
        c.add(5L);
        c.add(3L);
        c.add(6L);*/
        /*c.add(1L);
        c.add(2L);
        c.add(3L);*/
        c.add(44L);
        c.add(5L);
        c.add(39L);
        c.add(9L);
        c.add(6L);
        c.add(25L);
        c.add(3L);
        c.add(28L);
        c.add(16L);
        c.add(19L);
        c.add(4L);
        c.add(49L);
        c.add(40L);
        c.add(22L);
        c.add(2L);
        c.add(12L);
        c.add(45L);
        c.add(33L);
        c.add(23L);
        c.add(42L);
        c.add(34L);
        c.add(15L);
        c.add(46L);
        c.add(26L);
        c.add(13L);
        c.add(31L);
        c.add(8L);
        int[] coins = new int[27];
        //44 5 9 39 6 25 3 28 16 19 4 49 40 22 2 12 45 33 23 42 34 15 46 26 13 31 8
        coins[0] = 44;
        coins[1] = 5;
        coins[2] = 9;
        coins[3] = 39;
        coins[4] = 6;
        coins[5] = 25;
        coins[6] = 3;
        coins[7] = 28;
        coins[8] = 16;

        // 19 4 49 40 22 2 12 45 33 23 42 34 15 46 26 13 31 8
        coins[9] = 19;
        coins[10] = 4;
        coins[11] = 49;
        coins[12] = 40;
        coins[13] = 22;
        coins[14] = 2;
        coins[15] = 12;
        coins[16] = 45;
        coins[17] = 33;

        // 23 42 34 15 46 26 13 31 8
        coins[18] = 23;
        coins[19] = 42;
        coins[20] = 34;
        coins[21] = 15;
        coins[22] = 46;
        coins[23] = 26;
        coins[24] = 13;
        coins[25] = 31;
        coins[26] = 8;


        //44 5 9 39 6 25 3 28 16 19 4 49 40 22 2 12 45 33 23 42 34 15 46 26 13 31 8


        // System.out.println(new Date().getTime());
        //System.out.println(getWays(27, c));
        //System.out.println(new Date().getTime());

        int arr[] = {44, 5, 9, 39, 6, 25, 3, 28, 16, 19, 4, 49, 40, 22, 2, 12, 45, 33, 23, 42, 34, 15, 46, 26, 13, 31, 8};
        int m = arr.length;
        // System.out.println("countWays: " + countWays(arr, m, 27));


        Arrays.sort(coins);
      //  System.out.println("getWaysDynamic: " + getWaysDynamic(27, coins));

        int[] testC = new int[5];
        testC[0] = 2;
        testC[1] = 3;
        testC[2] = 5;
        testC[3] = 10;
        //testC[4] = 20;

        System.out.println(new Date().getTime());

        System.out.println("getWaysDynamic using testC: " + getWaysDynamic(15, testC));

        System.out.println(new Date().getTime());

        List<Long> weights = new ArrayList<>();
        weights.add(2L);
        weights.add(3L);
        weights.add(5L);
        weights.add(10L);
        System.out.println(new Date().getTime());

        System.out.println("getWaysDynamicList using weights: " + getWaysDynamicList(15, weights));

        System.out.println(new Date().getTime());

        System.out.println(new Date().getTime());

        System.out.println("getWaysDynamicList using coins size 27: " + getWaysDynamicList(27, c));

        System.out.println(new Date().getTime());
    }
}
