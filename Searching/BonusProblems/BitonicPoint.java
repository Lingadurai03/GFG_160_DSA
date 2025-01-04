package Searching.BonusProblems;

// Bitonic Point
// Difficulty: EasyAccuracy: 58.67%Submissions: 134K+Points: 2
// Given an array of integers arr[] that is first strictly increasing and then maybe strictly decreasing, find the bitonic point, that is the maximum element in the array.
// Bitonic Point is a point before which elements are strictly increasing and after which elements are strictly decreasing.

// Examples:

// Input: arr[] = [1, 2, 4, 5, 7, 8, 3]
// Output: 8
// Explanation: Elements before 8 are strictly increasing [1, 2, 4, 5, 7] and elements after 8 are strictly decreasing [3].
// Input: arr[] = [10, 20, 30, 40, 50]
// Output: 50
// Explanation: Elements before 50 are strictly increasing [10, 20, 30 40] and there are no elements after 50.
// Input: arr[] = [120, 100, 80, 20, 0]
// Output: 120
// Explanation: There are no elements before 120 and elements after 120 are strictly decreasing [100, 80, 20, 0].
// Constraints:
// 3 ≤ arr.size() ≤ 105
// 1 ≤ arr[i]≤ 106

public class BitonicPoint {
    public static void main(String[] args) {

        int[] arr = { 120, 100, 80, 20, 0 };

        BitonicPoint bp = new BitonicPoint();

        System.out.println(bp.findBotonicPoint(arr));

    }

    public int findBotonicPoint(int[] arr) {
        int res = 0;

        int n = arr.length;

        if (arr[0] > arr[1]) {
            return arr[0];
        }
        if (arr[n - 1] > arr[n - 2]) {
            return arr[n - 1];
        }

        int low = 1;
        int high = arr.length - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[mid + 1]) {
                res = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

}
