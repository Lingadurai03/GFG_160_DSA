package Searching.BonusProblems;

// Median of 2 Sorted Arrays of Different Sizes
// Difficulty: HardAccuracy: 28.4%Submissions: 125K+Points: 8
// Given two sorted arrays a[] and b[], find and return the median of the combined array after merging them into a single sorted array.

// Examples:

// Input: a[] = [-5, 3, 6, 12, 15], b[] = [-12, -10, -6, -3, 4, 10]
// Output: 3
// Explanation: The merged array is [-12, -10, -6, -5, -3, 3, 4, 6, 10, 12, 15]. So the median of the merged array is 3.
// Input: a[] = [2, 3, 5, 8], b[] = [10, 12, 14, 16, 18, 20]
// Output: 11
// Explanation: The merged array is [2, 3, 5, 8, 10, 12, 14, 16, 18, 20]. So the median of the merged array is (10 + 12) / 2 = 11.
// Input: a[] = [], b[] = [2, 4, 5, 6]
// Output: 4.5
// Explanation: The merged array is [2, 4, 5, 6]. So the median of the merged array is (4 + 5) / 2 = 4.5.
// Constraints: 
// 0 ≤ a.size(), b.size() ≤ 106
// 1 ≤ a[i], b[i] ≤ 109
// a.size() + b.size() > 0

public class MedianOf2SortedArraysOfDifferentSizes {
    public static void main(String[] args) {
        int[] a = { -5, 3, 6, 12, 15 };
        int[] b = { -12, -10, -6, -3, 4, 10 };

        MedianOf2SortedArraysOfDifferentSizes md = new MedianOf2SortedArraysOfDifferentSizes();
        System.out.println(md.findMedium(a, b));

    }

    public double findMedium(int[] a, int b[]) {

        int n = a.length;
        int m = b.length;

        if (n > m) {
            return findMedium(b, a);
        }
        int low = 0;
        int high = n;

        while (low <= high) {
            int m1 = low + (high - low) / 2;
            int m2 = ((n + m + 1) / 2) - m1;

            int l1 = m1 == 0 ? Integer.MIN_VALUE : a[m1 - 1];
            int r1 = m1 == n ? Integer.MAX_VALUE : a[m1];

            int l2 = m2 == 0 ? Integer.MIN_VALUE : b[m2 - 1];
            int r2 = m2 == m ? Integer.MAX_VALUE : b[m2];

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;

                else
                    return Math.max(l1, l2);
            }
            if (l1 > r2) {
                high = m1 - 1;
            }
            if (l2 > r1) {
                low = m1 + 1;
            }
        }
        return 0;

    }

}
