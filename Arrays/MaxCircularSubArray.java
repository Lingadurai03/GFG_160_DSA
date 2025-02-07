package Arrays;

// Max Circular Subarray Sum
// Difficulty: HardAccuracy: 29.37%Submissions: 134K+Points: 8
// Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.

// Examples:

// Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
// Output: 22
// Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
// Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
// Output: 23
// Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
// Input: arr[] = [-1, 40, -14, 7, 6, 5, -4, -1] 
// Output: 52
// Explanation: Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52.
// Constraints:
// 1 <= arr.size() <= 105
// -104 <= arr[i] <= 104

public class MaxCircularSubArray {
    public static void main(String[] args) {

        int[] arr = { 8, -8, 9, -9, 10, -11, 12 };
        MaxCircularSubArray mcs = new MaxCircularSubArray();

        System.out.println(mcs.findMaxCircularSubArray(arr));

    }

    // // Brute Force Method

    // public int findMaxCircularSubArray(int[] arr) {
    // int maxSum = 0;

    // for (int i = 0; i < arr.length; i++) {
    // int currentSum = 0;
    // for (int j = 0; j < arr.length; j++) {
    // int idx = (i + j) % arr.length;
    // currentSum += arr[idx];
    // maxSum = Math.max(maxSum, currentSum);
    // }
    // }
    // return maxSum;

    // }

    public int findMaxCircularSubArray(int[] arr) {

        int currentMaxSum = 0;
        int currentMinSum = 0;
        int totalSum = arr[0];
        int maxSum = arr[0];
        int minSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMaxSum = Math.max(currentMaxSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currentMaxSum);

            currentMinSum = Math.min(currentMinSum + arr[i], arr[i]);
            minSum = Math.min(minSum, currentMinSum);

            totalSum += arr[i];
        }

        int normalSum = maxSum;
        int circularSum = totalSum - minSum;

        if (circularSum == 0) {
            return normalSum;
        }

        return Math.max(circularSum, normalSum);
    }

}
