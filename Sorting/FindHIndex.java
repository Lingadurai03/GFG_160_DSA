package Sorting;

// Find H-Index
// Difficulty: MediumAccuracy: 53.4%Submissions: 30K+Points: 4
// Given an integer array citations[], where citations[i] is the number of citations a researcher received for the ith paper. The task is to find the H-index.

// H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.

// Examples:

// Input: citations[] = [3, 0, 5, 3, 0]
// Output: 3
// Explanation: There are at least 3 papers (3, 5, 3) with at least 3 citations.
// Input: citations[] = [5, 1, 2, 4, 1]
// Output: 2
// Explanation: There are 3 papers (with citation counts of 5, 2, and 4) that have 2 or more citations. However, the H-Index cannot be 3 because there aren't 3 papers with 3 or more citations.
// Input: citations[] = [0, 0]
// Output: 0
// Constraints:
// 1 ≤ citations.size() ≤ 106
// 0 ≤ citations[i] ≤ 106

public class FindHIndex {
    public static void main(String[] args) {
        Integer[] arr = { 0, 0 };

        FindHIndex fi = new FindHIndex();

        System.out.println(fi.findH(arr));
        ;

    }

    // Approach 1

    // public int findH(Integer[] arr) {
    // Arrays.sort(arr);
    // int value = 0;
    // int n = arr.length - 1;
    // for (int i = 0; i < arr.length; i++) {
    // if (arr[n - i] < i + 1) {
    // break;
    // }
    // value += 1;
    // }
    // return value;
    // }

    // Approach 2

    public int findH(Integer[] arr) {
        int n = arr.length;
        int[] freq = new int[n + 1];

        for (int num : arr) {
            if (num >= n) {
                freq[n] += 1;
            } else {
                freq[num] += 1;
            }
        }

        int count = 0;

        int idx = freq.length - 1;

        while (count < idx) {
            count += freq[idx];
            if (count < idx) {

                idx--;
            }

        }

        return idx;
    }

}
