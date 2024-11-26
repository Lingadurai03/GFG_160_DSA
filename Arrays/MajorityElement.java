package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;

// Majority Element II
// Difficulty: MediumAccuracy: 48.1%Submissions: 93K+Points: 4
// You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

// Note: The answer should be returned in an increasing format.

// Examples:

// Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
// Output: [5, 6]
// Explanation: 5 and 6 occur more n/3 times.
// Input: arr[] = [1, 2, 3, 4, 5]
// Output: []
// Explanation: no candidate occur more than n/3 times.
// Constraint:
// 1 <= arr.size() <= 106
// -109 <= arr[i] <= 109

public class MajorityElement {

    public static void main(String[] args) {
        // int[] arr = { 2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6 };
        int[] arr = { 3, 5, 3, 4, 5 };
        // int[] arr = { 2, 1, 1, 1, 1, 3, 5, 1, 1, 2 };
        // int[] arr = { 2, 2, 2, 2, 1, 3, 3, 3, 3, 3 };
        MajorityElement me = new MajorityElement();

        PrintArray.print(me.findMajorityElement(arr));
    }

    // // Nested Loop O(n^2)
    // public int[] findMajorityElement(int[] arr) {
    // int[] tempArr = {};
    // int arrLength = arr.length;
    // int k = arrLength / 3;

    // if (k < 1) {
    // return arr;
    // }

    // for (int i = 0; i < arrLength - 1; i++) {
    // int count = 1;
    // for (int j = i + 1; j < arrLength; j++) {
    // if (arr[i] == arr[j]) {
    // count++;
    // if (count > k && !this.valueIsInArray(tempArr, arr[i])) {
    // tempArr = this.resize(tempArr, tempArr.length + 1);
    // tempArr[tempArr.length - 1] = arr[i];
    // }
    // }
    // }
    // }

    // return tempArr;

    // }

    // Boyer-Moore Majority Voting Algorithm O(n)

    public int[] findMajorityElement(int[] arr) {
        int length = arr.length;
        int ratio = length / 3;

        int[] tempArr = {};

        int candidate1 = -1, candidate2 = -1;
        int candidateVote1 = 0, candidateVote2 = 0;

        for (int i = 0; i < length; i++) {
            // System.out.println(arr[i]);

            if (candidate1 == arr[i]) {
                candidateVote1++;
            } else if (candidate2 == arr[i]) {
                candidateVote2++;
            } else if (candidateVote1 == 0) {
                candidate1 = arr[i];
                candidateVote1++;
            } else if (candidateVote2 == 0) {
                candidate2 = arr[i];
                candidateVote2++;
            } else {
                candidateVote1--;
                candidateVote2--;

            }

        }

        candidateVote1 = 0;
        candidateVote2 = 0;

        for (int i = 0; i < length; i++) {
            if (candidate1 == arr[i])
                candidateVote1++;
            if (candidate2 == arr[i])
                candidateVote2++;

        }

        if (candidateVote1 > ratio) {
            tempArr = this.resize(tempArr, tempArr.length + 1);
            tempArr[tempArr.length - 1] = candidate1;
        }
        if (candidateVote2 > ratio) {
            tempArr = this.resize(tempArr, tempArr.length + 1);
            tempArr[tempArr.length - 1] = candidate2;
        }

        return tempArr;
    }

    public boolean valueIsInArray(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }

        }
        return false;
    }

    public int[] resize(int[] arr, int size) {
        int[] tempArr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }

        return tempArr;

    }

}
