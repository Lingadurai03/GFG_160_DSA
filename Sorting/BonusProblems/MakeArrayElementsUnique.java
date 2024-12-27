package Sorting.BonusProblems;

import java.util.Arrays;

// Make array elements unique
// Difficulty: MediumAccuracy: 51.43%Submissions: 59K+Points: 4
// Given an integer array arr[ ], your task is to find the minimum number of increment operations required to make all the array elements unique. i.e. no value in the array should occur more than once. In one operation, a value can be incremented by 1 only.

// Note: The answer will always fit into a 32-bit integer.

// Examples :

// Input: arr[] = [3, 2, 1, 2, 1, 7]
// Output: 6
// Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7]. It can be shown that it is impossible for the array to have all unique values with 5 or less operations.
// Input: arr[] = [1, 2, 2]
// Output: 1
// Explanation: After one operation [2 -> 3], the array could be [1, 2, 3].
// Input: arr[] = [5, 4, 3, 2, 1]
// Output: 0
// Explanation: All elements are unique.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 0 ≤ arr[i] ≤ 106

public class MakeArrayElementsUnique {
    public static void main(String[] args) {

        int[] arr = { 3, 2, 1, 2, 1, 7 };

        MakeArrayElementsUnique me = new MakeArrayElementsUnique();

        System.out.println(me.makeUnique(arr));

    }

    public int makeUnique(int[] arr) {

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == arr[i + 1]) {
                arr[i + 1] += 1;
                count++;
            }
            if (arr[i] > arr[i + 1]) {
                count += arr[i] - arr[i + 1] + 1;
                arr[i + 1] += arr[i] - arr[i + 1] + 1;
            }

        }
        return count;
    }

}
