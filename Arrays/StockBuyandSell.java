package Arrays;

// Given an array prices[] of size n denoting the cost of stock on each day, the task is to find the maximum total profit if we can buy and sell the stocks any number of times.

// Note: We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.

// Examples:

// Input: prices[] = {100, 180, 260, 310, 40, 535, 695}
// Output: 865
// Explanation: Buy the stock on day 0 and sell it on day 3 => 310 - 100 = 210
//                        Buy the stock on day 4 and sell it on day 6 => 695 - 40 = 655
//                        Maximum Profit  = 210 + 655 = 865

// Input: prices[] = {4, 2, 2, 2, 4}
// Output: 2
// Explanation: Buy the stock on day 3 and sell it on day 4 => 4 - 2 = 2
//                        Maximum Profit  = 2

public class StockBuyandSell {

    public static void main(String[] args) {
        int[] prices = { 100, 180, 260, 310, 40, 535, 695 };
        // int[] prices = { 4, 2, 2, 2, 4 };

        StockBuyandSell sb = new StockBuyandSell();

        System.out.println(sb.findProfit(prices));

    }

    // Approch one
    // public int findProfit(int[] arr) {
    // int profit = 0;
    // int expense = 0;
    // boolean isBuying = false;

    // for (int i = 0; i < arr.length - 1; i++) {
    // if (arr[i] < arr[i + 1] && !isBuying) {
    // isBuying = true;
    // expense += arr[i];
    // } else if (arr[i] > arr[i + 1] && isBuying) {
    // isBuying = false;
    // profit += arr[i];
    // }

    // if (isBuying && i == arr.length - 2) {
    // profit += arr[i + 1];
    // }

    // }

    // return profit - expense;

    // }

    // Approch two

    public int findProfit(int[] arr) {
        int profit = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {

                profit += arr[i + 1] - arr[i];
            }
        }
        return profit;
    }

}
