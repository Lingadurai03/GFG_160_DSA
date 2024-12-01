package Arrays.BonusProblems;

// Maximize Number of 1's
// Difficulty: MediumAccuracy: 39.46%Submissions: 51K+Points: 4
// Given a binary array arr[] (containing only 0s and 1s) and an integer k, you are allowed to flip at most k 0s to 1s. Find the maximum number of consecutive 1's that can be obtained in the array after performing the operation at most k times.

// Examples:

// Input: arr[] = [1, 0, 1], k = 1
// Output: 3
// Explanation: Maximum subarray of consecutive 1's is of size 3 which can be obtained after flipping the zero present at the 1st index.
// Input: arr[] = [1, 0, 0, 1, 0, 1, 0, 1], k = 2
// Output: 5
// Explanation: By flipping the zeroes at indices 4 and 6, we get the longest subarray from index 3 to 7 containing all 1’s.
// Input: arr[] = [1, 1], k = 2
// Output: 2
// Explanation: Since the array is already having the max consecutive 1's, hence we dont need to perform any operation. Hence the answer is 2
// Constraints:
// 1 <= arr.size() <= 105
// 0 <= k <= arr.size()
// 0 <= arr[i] <= 1

public class MaximizeNumberOf1s {

    public static void main(String[] args) {

        int[] arr = { 1, 0, 0, 1, 0, 1, 0, 1 };

        MaximizeNumberOf1s mn = new MaximizeNumberOf1s();
        System.out.println(mn.findMaximumNumberOf1s(arr, 2));

    }

    // brute force method
    // public int findMaximumNumberOf1s(int[] arr, int k) {

    // int maxLengthOf1s = 0;

    // for (int i = 0; i < arr.length; i++) {
    // int count = 0;
    // for (int j = i; j < arr.length; j++) {
    // if (arr[j] == 0) {
    // count++;
    // }
    // if (count > k) {
    // break;
    // }

    // maxLengthOf1s = Math.max(maxLengthOf1s, ((j - i) + 1));

    // }
    // }

    // return maxLengthOf1s;
    // }

    // Sliding window

    public int findMaximumNumberOf1s(int[] arr, int k) {
        int maxLengthOf1s = 0;

        int start = 0, end = 0;
        int count = 0;
        while (end < arr.length) {

            if (arr[end] == 0) {
                count++;
            }
            while (count > k) {
                if (arr[start] == 0) {
                    count--;
                }
                start++;
            }

            maxLengthOf1s = (end - start) + 1;
            end++;
        }

        return maxLengthOf1s;

    }

}
