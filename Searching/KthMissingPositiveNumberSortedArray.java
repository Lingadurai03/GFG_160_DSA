package Searching;

// Kth Missing Positive Number in a Sorted Array
// Difficulty: MediumAccuracy: 53.02%Submissions: 30K+Points: 4
// Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  

// Examples :

// Input: arr[] = [2, 3, 4, 7, 11], k = 5
// Output: 9
// Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
// Input: arr[] = [1, 2, 3], k = 2
// Output: 5
// Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.
// Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
// Output: 2
// Explanation: Missing are 1, 2, 4, 6… and 2nd missing number is 2.
// Constraints:
// 1 <= arr.size() <= 105
// 1 <= k <= 105
// 1 <= arr[i]<= 106

public class KthMissingPositiveNumberSortedArray {
    public static void main(String[] args) {

        KthMissingPositiveNumberSortedArray km = new KthMissingPositiveNumberSortedArray();

        int[] arr = { 3, 5, 9, 10, 11, 12 };

        System.out.println(km.findNthElement(arr, 2));

    }

    // O(n) Time and O(n) Space
    // public int findNthElement(int[] arr, int k) {

    // ArrayList<Integer> arrList = new ArrayList<>();

    // int count = 1;
    // int i = 0;
    // while (arrList.size() < k) {
    // if (arr[i] == count) {
    // i++;
    // } else {
    // arrList.add(count);
    // }
    // count++;

    // }
    // return arrList.get(arrList.size() - 1);

    // }

    // O(n) Time and O(1) Space
    // public int findNthElement(int[] arr, int k) {
    // int n = arr.length;

    // for (int i = 0; i < n; i++) {
    // if (arr[i] > k + i) {
    // return k + i;
    // }
    // }

    // return n + k;
    // }

    // Using Binary Search - O(log n) Time and O(1) Space

    public int findNthElement(int[] arr, int k) {
        int res = arr.length + k;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > k + mid) {
                res = k + mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

}
