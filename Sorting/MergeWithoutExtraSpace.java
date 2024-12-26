package Sorting;

import Arrays.PrintArray;

// Merge Without Extra Space
// Difficulty: HardAccuracy: 32.01%Submissions: 279K+Points: 8
// Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.

// Examples:

// Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
// Output:
// 2 2 3 4
// 7 10
// Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10
// Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
// Output:
// 1 2 3 5 8 9
// 10 13 15 20
// Explanation: After merging two sorted arrays we get 1 2 3 5 8 9 10 13 15 20.
// Input: a[] = [0, 1], b[] = [2, 3]
// Output:
// 0 1
// 2 3
// Explanation: After merging two sorted arrays we get 0 1 2 3.
// Constraints:
// 1 <= a.size(), b.size() <= 105
// 0 <= a[i], b[i] <= 107

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        MergeWithoutExtraSpace me = new MergeWithoutExtraSpace();

        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 0, 2, 6, 8, 9 };

        me.merge(arr1, arr2);

        PrintArray.print(arr1);
        System.out.println();
        PrintArray.print(arr2);

    }

    // Brute force Approach Time O(n*m) Space O(1)
    // public void merge(int[] arr1, int[] arr2) {

    // int arr1Length = arr1.length - 1;

    // for (int i = arr2.length - 1; i >= 0; i--) {
    // if (arr2[i] < arr1[arr1Length]) {

    // // ----- Normal Approach ----
    // // int temp = arr2[i];
    // // arr2[i] = arr1[arr1Length];
    // // arr1[arr1Length] = temp;

    // // int newElementIdx = arr1Length;
    // // while (newElementIdx > 0 && arr1[newElementIdx] < arr1[newElementIdx - 1])
    // {
    // // int val = arr1[newElementIdx];
    // // arr1[newElementIdx] = arr1[newElementIdx - 1];
    // // arr1[newElementIdx - 1] = val;
    // // newElementIdx--;
    // // }

    // // ---- Insertion Sort ----
    // int last = arr1[arr1.length - 1];
    // int j = arr1.length - 2;

    // while (j >= 0 && arr1[j] > arr2[i]) {
    // arr1[j + 1] = arr1[j];
    // j--;
    // }
    // arr1[j + 1] = arr2[i];
    // arr2[i] = last;

    // }
    // }

    // }

    // Gap Method

    public void merge(int[] a, int[] b) {

        int lengtOfA = a.length;
        int lengtOfB = b.length;

        int gap = (lengtOfA + lengtOfB + 1) / 2;

        while (gap > 0) {

            int i = 0;
            int j = gap;

            while (j < lengtOfA + lengtOfB) {

                if (j < lengtOfA && a[i] > a[j]) {
                    swap(a, a, i, j);
                } else if (i < lengtOfA && j >= lengtOfA && a[i] > b[j - lengtOfA]) {
                    swap(a, b, i, j - lengtOfA);
                } else if (i >= lengtOfA && b[i - lengtOfA] > b[j - lengtOfA]) {
                    swap(b, b, i - lengtOfA, j - lengtOfA);
                }

                i++;
                j++;

            }
            if (gap == 1)
                break;

            gap = (gap + 1) / 2;
        }

    }

    public void swap(int[] a, int[] b, int i, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

}
