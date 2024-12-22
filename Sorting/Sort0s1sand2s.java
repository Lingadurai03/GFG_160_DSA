package Sorting;

import Arrays.PrintArray;

// Sort 0s, 1s and 2s
// Difficulty: EasyAccuracy: 50.58%Submissions: 734K+Points: 2
// Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

// Examples:

// Input: arr[] = [0, 1, 2, 0, 1, 2]
// Output: [0, 0, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.
// Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
// Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.
// Constraints:
// 1 <= arr.size() <= 106
// 0 <= arr[i] <= 2

public class Sort0s1sand2s {

    public static void main(String[] args) {
        int[] a = { 0, 1, 2, 0, 1, 2 };

        Sort0s1sand2s s = new Sort0s1sand2s();

        PrintArray.print(s.sortArr(a));
    }

    // // Native Approach

    // public int[] sortArr(int[] arr) {

    // int e0 = 0;
    // int e1 = 0;

    // for (int el : arr) {
    // if (el == 0) {
    // e0++;
    // } else if (el == 1) {
    // e1++;
    // }
    // }

    // for (int i = 0; i < arr.length; i++) {
    // if (e0 != 0) {
    // arr[i] = 0;
    // e0--;
    // } else if (e1 != 0) {
    // arr[i] = 1;
    // e1--;
    // } else {
    // arr[i] = 2;
    // }
    // }

    // return arr;
    // }

    // Dutch National flag algo

    public int[] sortArr(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                this.swap(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {

                this.swap(arr, mid, high);
                System.out.println(arr[high]);
                high--;

            }
        }

        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
