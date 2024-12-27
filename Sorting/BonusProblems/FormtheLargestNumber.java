package Sorting.BonusProblems;

import java.util.ArrayList;
import java.util.Collections;

// Form the Largest Number
// Difficulty: MediumAccuracy: 37.82%Submissions: 164K+Points: 4
// Given an array of integers arr[] representing non-negative integers, arrange them so that after concatenating all of them in order, it results in the largest possible number. Since the result may be very large, return it as a string.

// Examples:

// Input: arr[] = [3, 30, 34, 5, 9]
// Output: "9534330"
// Explanation: Given numbers are [3, 30, 34, 5, 9], the arrangement "9534330" gives the largest value.
// Input: arr[] = [54, 546, 548, 60]
// Output: "6054854654"
// Explanation: Given numbers are [54, 546, 548, 60], the arrangement "6054854654" gives the largest value.
// Input: arr[] = [3, 4, 6, 5, 9]
// Output: "96543"
// Explanation: Given numbers are [3, 4, 6, 5, 9], the arrangement "96543" gives the largest value.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 0 ≤ arr[i] ≤ 105

public class FormtheLargestNumber {
    public static void main(String[] args) {

        FormtheLargestNumber fl = new FormtheLargestNumber();

        System.out.println(fl.constructLargeNumber(new int[] { 0, 0 }));
    }

    public String constructLargeNumber(int[] arr) {

        ArrayList<String> numbers = new ArrayList<>();

        for (int el : arr) {
            numbers.add(Integer.toString(el));
        }

        Collections.sort(numbers, (a, b) -> compare(a, b) ? -1 : 1);

        if (numbers.get(0).equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();

        for (String s : numbers) {
            res.append(s);
        }

        return res.toString();
    }

    public Boolean compare(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1) > 0;
    }

}
