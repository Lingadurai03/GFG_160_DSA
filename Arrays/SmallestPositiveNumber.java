package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

// Smallest Positive Missing Number
// Difficulty: MediumAccuracy: 25.13%Submissions: 377K+Points: 4
// You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

// Note: Positive number starts from 1. The array can have negative integers too.

// Examples:

// Input: arr[] = [2, -3, 4, 1, 1, 7]
// Output: 3
// Explanation: Smallest positive missing number is 3.
// Input: arr[] = [5, 3, 2, 5, 1]
// Output: 4
// Explanation: Smallest positive missing number is 4.
// Input: arr[] = [-8, 0, -1, -4, -3]
// Output: 1
// Explanation: Smallest positive missing number is 1.
// Constraints:  
// 1 <= arr.size() <= 105
// -106 <= arr[i] <= 106

public class SmallestPositiveNumber {

    public static void main(String[] args) {
        int[] arr = { 1, -19 };
        SmallestPositiveNumber spn = new SmallestPositiveNumber();

        System.out.println(spn.findMissingNumber(arr));
    }

    // Approach One
    // public int findMissingNumber(int[] arr) {

    // Arrays.sort(arr);

    // int missingNumber = 1;

    // for (int num : arr) {
    // if (num == missingNumber) {
    // missingNumber++;
    // } else if (num > missingNumber) {
    // break;

    // }
    // }

    // return missingNumber;
    // }

    // Approach Two

    public int findMissingNumber(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        for (int i = 0; i < arr.length; i++) {

            while (arr[i] >= 1 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]) {

                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return arr.length + 1;
    }

}
