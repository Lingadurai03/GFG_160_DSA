package Searching;

import java.util.Arrays;

// Aggressive Cows
// Difficulty: MediumAccuracy: 59.57%Submissions: 103K+Points: 4
// You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

// Examples :

// Input: stalls[] = [1, 2, 4, 8, 9], k = 3
// Output: 3
// Explanation: The first cow can be placed at stalls[0], 
// the second cow can be placed at stalls[2] and 
// the third cow can be placed at stalls[3]. 
// The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
// Input: stalls[] = [10, 1, 2, 7, 5], k = 3
// Output: 4
// Explanation: The first cow can be placed at stalls[0],
// the second cow can be placed at stalls[1] and
// the third cow can be placed at stalls[4].
// The minimum distance between cows, in this case, is 4, which also is the largest among all possible ways.
// Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
// Output: 1
// Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
// The minimum distance between cows, in this case, is 1, which also is the largest among all possible ways.
// Constraints:
// 2 <= stalls.size() <= 106
// 0 <= stalls[i] <= 108
// 1 <= k <= stalls.size()

public class AggressiveCows {

    public static void main(String[] args) {

        int[] arr = { 2, 12, 11, 3, 26, 7 };
        int k = 5;

        AggressiveCows a = new AggressiveCows();

        System.out.println(a.aggressiveCows(arr, k));

    }

    // Time O((max-min)n) space O(1)
    // public int aggressiveCows(int[] arr, int k) {
    // Arrays.sort(arr);

    // int res = 0;
    // int min = 1;
    // int max = arr[arr.length - 1] - arr[0];

    // for (int i = min; i <= max; i++) {
    // if (check(arr, k, i)) {
    // res++;
    // }
    // }

    // return res;
    // }

    public int aggressiveCows(int[] arr, int k) {

        Arrays.sort(arr);

        int res = 0;

        int low = 1;
        int high = arr[arr.length - 1] - arr[0];

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(arr, k, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return res;
    }

    public Boolean check(int[] arr, int k, int dist) {

        int count = 1;
        int prev = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev >= dist) {
                prev = arr[i];
                count++;
            }
        }

        return count >= k;

    }

}