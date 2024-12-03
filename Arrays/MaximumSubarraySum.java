package Arrays;

// Examples:

// Input: arr[] = {2, 3, -8, 7, -1, 2, 3}
// Output: 11
// Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.

// Input: arr[] = {-2, -4}
// Output: -2
// Explanation: The subarray {-2} has the largest sum -2.

// Input: arr[] = {5, 4, 1, 7, 8}
// Output: 25
// Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.

// Table of Content

// [Naive Approach] By iterating over all subarrays - O(n^2) Time and O(1) Space
// [Expected Approach] Using Kadane's Algorithm - O(n) Time and O(1) Space

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, -8, 7, -1, 2, 3 };

        MaximumSubarraySum mb = new MaximumSubarraySum();

        System.out.println(mb.findMaxSumOfSubArray(arr));

    }

    public int findMaxSumOfSubArray(int[] arr) {

        int res = arr[0];
        int ending = arr[0];

        for (int i = 1; i < arr.length; i++) {

            ending = Math.max(ending + arr[i], arr[i]);
            res = Math.max(ending, res);

        }

        return res;
    }

}
