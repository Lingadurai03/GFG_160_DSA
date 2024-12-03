package Arrays;

// Given an integer array, the task is to find the maximum product of any subarray.

// Examples:

// Input: arr[] = {-2, 6, -3, -10, 0, 2}
// Output: 180
// Explanation: The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180

// Input: arr[] = {-1, -3, -10, 0, 60}
// Output: 60
// Explanation: The subarray with maximum product is {60}.

// Table of Content

// [Naive Approach] By using two nested loops – O(n^2) Time and O(1) Space
// [Expected Approach 1] Using minimum and maximum product ending at any index - O(n) Time and O(1) Space
// [Expected Approach 2] By traversing in both directions - O(n) Time and O(1) Space

public class MaximumProduct {
    public static void main(String[] args) {
        int[] arr = { -2, 6, -3, -10, 0, 2 };

        MaximumProduct mp = new MaximumProduct();
        System.out.println(mp.findMaxProduct(arr));

    }

    public int findMaxProduct(int[] arr) {

        int minProduct = arr[0];
        int maxProduct = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(maxProduct * arr[i], minProduct * arr[i]));
            minProduct = Math.min(arr[i], Math.min(maxProduct * arr[i], minProduct * arr[i]));
            maxProduct = temp;

            result = Math.max(maxProduct, result);
        }
        return result;
    }

}
