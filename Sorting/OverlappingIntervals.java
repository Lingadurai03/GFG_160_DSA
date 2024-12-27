package Sorting;

import java.util.Arrays;

// Overlapping Intervals
// Difficulty: MediumAccuracy: 57.41%Submissions: 91K+Points: 4
// Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

// Examples:

// Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
// Output: [[1,4], [6,8], [9,10]]
// Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].
// Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
// Output: [[1,9]]
// Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 0 ≤ starti ≤ endi ≤ 105

public class OverlappingIntervals {

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        OverlappingIntervals oi = new OverlappingIntervals();

        // ArrayList<int[]> res = oi.findOverlappingIntervals(arr);
        int[][] resVal = oi.findOverlappingIntervals(arr);

        for (int[] interval : resVal) {
            System.out.println(interval[0] + " " + interval[1]);
        }

    }

    // Brute force approach
    // public ArrayList<int[]> findOverlappingIntervals(int[][] arr) {
    // ArrayList<int[]> result = new ArrayList<>();

    // for (int i = 0; i < arr.length; i++) {
    // int start = arr[i][0];
    // int end = arr[i][1];

    // if (!result.isEmpty() && result.get(result.size() - 1)[1] >= end) {
    // continue;
    // }

    // for (int j = 1; j < arr.length; j++) {
    // if (end >= arr[j][0]) {
    // end = Math.max(end, arr[j][1]);
    // }

    // }
    // result.add(new int[] { start, end });
    // }

    // return result;
    // }

    // // Optimized Approach time - O(n*logn) space - O(n)

    // public ArrayList<int[]> findOverlappingIntervals(int[][] arr) {

    // ArrayList<int[]> result = new ArrayList<>();

    // result.add(new int[] { arr[0][0], arr[0][1] });

    // int idx = 1;

    // while (idx < arr.length) {

    // int[] last = result.get(result.size() - 1);
    // int[] cur = arr[idx];

    // if (last[1] >= cur[0]) {
    // last[1] = Math.max(last[1], cur[1]);
    // } else {
    // result.add(cur);
    // }

    // idx++;

    // }

    // return result;
    // }

    // // Optimized Approach time - O(n*logn) space - O(1)

    public int[][] findOverlappingIntervals(int[][] arr) {

        int idx = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[idx][1] >= arr[i][0]) {
                arr[idx][1] = Math.max(arr[idx][1], arr[i][1]);
            } else {
                idx++;
            }
        }

        return Arrays.copyOfRange(arr, 0, idx + 1);
    }
}
