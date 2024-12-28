package Searching;

// K-th element of two Arrays
// Difficulty: MediumAccuracy: 37.4%Submissions: 306K+Points: 4
// Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

// Examples :

// Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
// Output: 6
// Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
// Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
// Output: 256
// Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.
// Constraints:

// 1 <= a.size(), b.size() <= 106
// 1 <= k <= a.size() + b.size()
// 0 <= a[i], b[i] < 108

public class KthElementOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = { 100, 112, 256, 349, 770 };
        int[] arr2 = { 72, 86, 113, 119, 265, 445, 892 };

        int k = 7;

        KthElementOfTwoArrays kth = new KthElementOfTwoArrays();
        System.out.println(kth.findK(arr1, arr2, k));

    }

    // public int findK(int[] arr1, int[] arr2, int k) {
    // int res = 0;
    // int i = 0;
    // int j = 0;

    // while (k > 0 && i < arr1.length - 1 && j < arr2.length - 1) {
    // if (arr1[i] < arr2[j]) {
    // res = arr1[i];
    // i++;
    // } else {
    // res = arr2[j];
    // j++;
    // }
    // k--;
    // }
    // while (i < arr1.length - 1 && k > 0) {
    // res = arr1[i];
    // i++;
    // }
    // while (j < arr2.length - 1 && k > 0) {
    // res = arr2[i];
    // j++;
    // }
    // return res;
    // }

    public int findK(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;

        if (n > m)
            return findK(b, a, k);

        int lo = Math.max(0, k - m), hi = Math.min(k, n);

        while (lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = k - mid1;

            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : a[mid1]);

            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
            int r2 = (mid2 == m ? Integer.MAX_VALUE : b[mid2]);

            if (l1 <= r2 && l2 <= r1) {

                return Math.max(l1, l2);
            }

            if (l1 > r2)
                hi = mid1 - 1;

            else
                lo = mid1 + 1;
        }

        return 0;
    }

}
