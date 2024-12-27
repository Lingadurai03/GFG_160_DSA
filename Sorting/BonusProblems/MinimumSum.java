package Sorting.BonusProblems;

// Minimum sum
// Difficulty: MediumAccuracy: 17.14%Submissions: 143K+Points: 4
// Given an array arr[] such that each element is in the range [0, 9] find the minimum possible sum of two numbers formed using the elements of the array. All digits in the given array must be used to form the two numbers. Return a string without leading zeroes.

// Examples :

// Input: arr[] = [6, 8, 4, 5, 2, 3]
// Output: "604"
// Explanation: The minimum sum is formed by numbers 358 and 246.
// Input: arr[] = [5, 3, 0, 7, 4]
// Output: "82"
// Explanation: The minimum sum is formed by numbers 35 and 047.
// Input: arr[] = [9, 4]
// Output: "13"
// Explanation: The minimum sum is formed by numbers 9 and 4.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 0 ≤ arr[i] ≤ 9

public class MinimumSum {
    public static void main(String[] args) {

        MinimumSum ms = new MinimumSum();

        int[] arr = { 9, 4 };
        ms.sort(arr, 0, arr.length - 1);
        // PrintArray.print(arr);

        System.out.println(ms.findMinimumSum(arr));

    }

    public String findMinimumSum(int[] arr) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                s1.append(arr[i]);
            } else {
                s2.append(arr[i]);
            }
        }

        return this.add(s1.toString(), s2.toString());
    }

    // Time O(nlogn) Space O(n)
    public String add(String s1, String s2) {
        int l1 = s1.length() - 1;
        int l2 = s2.length() - 1;

        int carry = 0;

        StringBuilder res = new StringBuilder();

        while (l1 >= 0 || l2 >= 0 || carry > 0) {

            int sum = carry;

            if (l1 >= 0) {
                sum += s1.charAt(l1) - '0';
            }
            if (l2 >= 0) {
                sum += s2.charAt(l2) - '0';
            }

            res.append(sum % 10);
            carry = sum / 10;
            l1--;
            l2--;

        }

        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        res.reverse();

        return res.toString();

    }

    public void sort(int[] arr, int l, int r) {

        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            this.merge(arr, l, m, r);
        }
    }

    public void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[j + m + 1];
        }

        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];

            } else {
                arr[k++] = right[j++];

            }

        }

        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }

    }

}
