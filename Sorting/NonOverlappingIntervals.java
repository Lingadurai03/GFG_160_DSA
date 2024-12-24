package Sorting;

import java.util.Arrays;

// Non-overlapping Intervals
// Difficulty: MediumAccuracy: 51.92%Submissions: 31K+Points: 4
// Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

// Examples:

// Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
// Output: 1
// Explanation: [1, 3] can be removed and the rest of the intervals are non-overlapping.
// Input: intervals[][] = [[1, 3], [1, 3], [1, 3]]
// Output: 2
// Explanation: You need to remove two [1, 3] to make the rest of the intervals non-overlapping.
// Input: intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]
// Output: 0
// Explanation: All ranges are already non overlapping.
// Constraints:
// 1 ≤ intervals.size() ≤  105
// |intervalsi| == 2
// 0 ≤ starti < endi <=5*104

public class NonOverlappingIntervals {
    public static void main(String[] args) {

        int[][] arr = {
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 1, 3 }
        };

        NonOverlappingIntervals ni = new NonOverlappingIntervals();

        System.out.println(ni.findMinNumOfIntervals(arr));

    }

    // Approach 1
    public int findMinNumOfIntervals(int[][] arr) {

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0])); // {{1,2}, {1,3}, {2,3}, {3,4}}}
        int intervalCount = 0;
        int i = 1;
        int currentEnd = arr[0][1];

        while (i < arr.length) {
            if (currentEnd > arr[i][0]) {
                currentEnd = Math.min(arr[i][1], currentEnd);
                intervalCount++;
            } else {
                currentEnd = arr[i][1];
            }
            i++;
        }

        return intervalCount;
    }

}
