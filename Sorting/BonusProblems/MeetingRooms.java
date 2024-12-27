package Sorting.BonusProblems;

import java.util.Arrays;

// Meeting Rooms
// Difficulty: EasyAccuracy: 65.12%Submissions: 21K+Points: 2
// Given an array arr[][] such that arr[i][0] is the starting time of ith meeting and arr[i][1] is the ending time of ith meeting, the task is to check if it is possible for a person to attend all the meetings such that he can attend only one meeting at a particular time.

// Note: A person can attend a meeting if its starting time is greater than or equal to the previous meeting's ending time.

// Examples:

// Input: arr[][] = [[1, 4], [10, 15], [7, 10]]
// Output: true
// Explanation: Since all the meetings are held at different times, it is possible to attend all the meetings.
// Input: arr[][] = [[2, 4], [9, 12], [6, 10]]
// Output: false
// Explanation: It is not possible to attend the second and third meetings simultaneously.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 0 ≤ arr[i] ≤ 2*106

public class MeetingRooms {
    public static void main(String[] args) {

        int[][] arr = {
                { 2, 4 },
                { 9, 12 },
                { 6, 10 }
        };

        MeetingRooms mr = new MeetingRooms();
        System.out.println(mr.isAvailable(arr));

    }

    public Boolean isAvailable(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i][1] > arr[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

}
