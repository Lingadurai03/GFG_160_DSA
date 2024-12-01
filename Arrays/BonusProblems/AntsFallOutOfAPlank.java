package Arrays.BonusProblems;

import Arrays.PrintArray;

// We have a wooden plank of the length n units. Some ants are walking on the plank, each ant moves with a speed of 1 unit per second. Some of the ants move to the left, the other move to the right.
// When two ants moving in two different directions meet at some point, they change their directions and continue moving again. Assume changing directions does not take any additional time. When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.

// Given an integer n and two integer arrays left[] and right[], the positions of the ants moving to the left and the right, return the moment when the last ant(s) fall out of the plank.

// Examples :

// Input: n = 4, left[] = [2], right[] = [0, 1, 3]
// Output: 4

// Explanation: As seen in the above image, the last ant falls off the plank at t = 4.
// Input:  n = 4, left[] = [], right[] = [0, 1, 2, 3, 4]
// Output: 4

//  Explanation: All ants are going to the right, the ant at index 0 needs 7 seconds to fall.
// Input: n = 3, left[] = [0], right[] = [3]
// Output: 0
// Explanation: The ants will fall off the plank as they are already on the end of the plank.

public class AntsFallOutOfAPlank {

    public static void main(String[] args) {
        AntsFallOutOfAPlank af = new AntsFallOutOfAPlank();

        int n = 3;
        int[] left = {}, right = { 3 };

        System.out.println(af.getLastMoment(n, left, right));
    }

    // normal solution

    // public int getLastMoment(int n, int left[], int right[]) {

    // for (int i = 0; i < right.length; i++) {
    // right[i] = n - right[i];
    // }

    // int leftBigValue = this.findBiggestValue(left);
    // int rightBigValue = this.findBiggestValue(right);

    // return Math.max(leftBigValue, rightBigValue);

    // }

    // public int findBiggestValue(int[] arr) {
    // if (arr.length == 0)
    // return 0;
    // int bigValue = arr[0];

    // for (int i = 1; i < arr.length; i++) {
    // bigValue = Math.max(bigValue, arr[i]);
    // }
    // return bigValue;
    // }

    // solution two

    public int getLastMoment(int n, int left[], int right[]) {
        int maxTimes = 0;

        for (int value : left) {
            maxTimes = Math.max(value, maxTimes);
        }

        for (int value : right) {
            maxTimes = Math.max(maxTimes, n - value);
        }

        return maxTimes;
    }
}
