package Sorting;

import java.util.ArrayList;

// Insert Interval
// Difficulty: MediumAccuracy: 50.61%Submissions: 32K+Points: 4
// Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.

// Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Examples:

// Input: intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]
// Output: [[1,3], [4,7], [8,10]]
// Explanation: The newInterval [5,6] overlaps with [4,5] and [6,7].
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,9]
// Output: [[1,2], [3,10], [12,16]]
// Explanation: The new interval [4,9] overlaps with [3,5],[6,7],[8,10].
// Constraints:
// 1 ≤ intervals.size() ≤  105
// 0 ≤ start[i], end[i] ≤ 109

public class InsertInterval {
    public static void main(String[] args) {

        int[][] arr = {
                { 1, 3 },
                { 4, 5 },
                { 6, 7 },
                { 8, 10 }
        };
        int[] newInterval = { 5, 6 };

        InsertInterval i = new InsertInterval();

        ArrayList<int[]> result = i.insert(arr, newInterval);

        for (int[] a : result) {
            System.out.println(a[0] + " " + a[1]);
        }

    }

    // Approach 1 time O(n*log(n)) space O(n)
    // public ArrayList<int[]> insert(int[][] arr, int[] newInterval) {

    // int[][] finalArr = new int[arr.length + 1][2];

    // finalArr[0] = newInterval;

    // for (int i = 0; i < arr.length; i++) {
    // finalArr[i + 1] = arr[i];
    // }

    // Arrays.sort(finalArr, (a, b) -> Integer.compare(a[0], b[0]));

    // ArrayList<int[]> res = new ArrayList<>();

    // res.add(new int[] { finalArr[0][0], finalArr[0][1] });

    // for (int i = 0; i < finalArr.length; i++) {
    // int[] last = res.get(res.size() - 1);
    // int[] cur = finalArr[i];

    // if (cur[0] <= last[1]) {
    // last[1] = Math.max(cur[1], last[1]);
    // } else {
    // res.add(cur);
    // }
    // }

    // return res;

    // }

    // Approach 2 timem O(1) space O(n)
    public ArrayList<int[]> insert(int[][] arr, int[] newInterval) {

        ArrayList<int[]> res = new ArrayList<>();
        int n = arr.length;
        int i = 0;

        while (i < n && arr[i][1] < newInterval[0]) {
            res.add(arr[i]);
            i++;

        }

        while (i < n && arr[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(arr[i][0], newInterval[0]);
            newInterval[1] = Math.max(arr[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        while (i < n) {
            res.add(arr[i]);
            i++;
        }

        return res;
    }

}
