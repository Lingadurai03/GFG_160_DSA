package Searching.BonusProblems;

// Square Root
// Difficulty: EasyAccuracy: 54.03%Submissions: 289K+Points: 2
// Given a positive integer n, find the square root of n. If n is not a perfect square, then return the floor value.

// Floor value of any number is the greatest Integer which is less than or equal to that number

// Examples:

// Input: n = 4
// Output: 2
// Explanation: Since, 4 is a perfect square, so its square root is 2.
// Input: n = 11
// Output: 3
// Explanation: Since, 11 is not a perfect square, floor of square root of 11 is 3.
// Input: n = 1
// Output: 1
// Constraints:
// 1 ≤ n ≤  3 x 104

public class SquareRoot {
    public static void main(String[] args) {

        SquareRoot sr = new SquareRoot();

        System.out.println(sr.findSquareRootValue(34));

    }

    public int findSquareRootValue(int n) {
        int low = 0;
        int high = n;

        int res = 0;
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (mid * mid <= n) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return res;
    }

}
