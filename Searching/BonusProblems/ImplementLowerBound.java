package Searching.BonusProblems;

// Implement Lower Bound
// Difficulty: EasyAccuracy: 57.28%Submissions: 3K+Points: 2
// Given a sorted array arr[] and a number target, the task is to find the lower bound of the target in this given array. The lower bound of a number is defined as the smallest index in the sorted array where the element is greater than or equal to the given number.

// Note: If all the elements in the given array are smaller than the target, the lower bound will be the length of the array. 

// Examples :

// Input:  arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
// Output: 3
// Explanation: 3 is the smallest index in arr[] where element (arr[3] = 10) is greater than or equal to 9.
// Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 11
// Output: 4
// Explanation: 4 is the smallest index in arr[] where element (arr[4] = 11) is greater than or equal to 11.
// Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 100
// Output: 7
// Explanation: As no element in arr[] is greater than 100, return the length of array.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ 106
// 1 ≤ target ≤ 106

public class ImplementLowerBound {
    public static void main(String[] args) {

        int[] arr = { 2, 3, 7, 10, 11, 11, 25 };
        int target = 100;

        ImplementLowerBound ilb = new ImplementLowerBound();

        System.out.println(ilb.findLowerBoundOfTarget(arr, target));

    }

    public int findLowerBoundOfTarget(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int res = arr.length;
        if (arr[high] < target) {
            return res;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

}
