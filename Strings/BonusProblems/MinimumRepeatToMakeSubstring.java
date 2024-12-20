package Strings.BonusProblems;

import Arrays.PrintArray;

// Minimum repeat to make substring
// Difficulty: MediumAccuracy: 51.22%Submissions: 65K+Points: 4
// Given two strings s1 and s2. Return a minimum number of times s1 has to be repeated such that s2 is a substring of it. If s2 can never be a substring then return -1.

// Note: Both the strings contain only lowercase letters.

// Examples:

// Input: s1 = "ww", s2 = "www"
// Output: 2
// Explanation: Repeating s1 two times "wwww", s2 is a substring of it.
// Input: s1 = "abcd", s2 = "cdabcdab" 
// Output: 3 
// Explanation: Repeating s1 three times "abcdabcdabcd", s2 is a substring of it. s2 is not a substring of s1 when it is repeated less than 3 times.
// Input: s1 = "ab", s2 = "cab"
// Output: -1
// Explanation: No matter how many times we repeat s1, we can't get a string such that s2 is a substring of it.
// Constraints:
// 1 ≤ s1.size(), s2.size() ≤ 105

public class MinimumRepeatToMakeSubstring {

    public static void main(String[] args) {
        MinimumRepeatToMakeSubstring mrtm = new MinimumRepeatToMakeSubstring();
        System.out.println(mrtm.findRepeatationCount("aabaa",
                "aaab"));

    }

    // Brute force Approach
    // public int findRepeatationCount(String s1, String s2) {

    // for (int i = 0; i < s1.length(); i++) {

    // int rep = 1;
    // Boolean found = true;
    // int idx = i;

    // for (int j = 0; j < s2.length(); j++) {
    // if (s1.charAt(idx) != s2.charAt(j)) {
    // found = false;
    // break;
    // }
    // idx++;

    // if (idx == s1.length()) {
    // idx = 0;
    // if (j != s2.length() - 1) {
    // rep++;
    // }
    // }
    // }
    // if (found) {
    // return rep;
    // }

    // }

    // return -1;

    // }

    // KMP algo

    public int findRepeatationCount(String s1, String s2) {

        int[] lps = this.constructLps(s2);
        int x = (s1.length() + s2.length() - 1) / s1.length();
        if (this.kmpSearch(s1, s2, lps, x)) {
            return x;
        }
        if (this.kmpSearch(s1, s2, lps, x + 1)) {
            return x + 1;
        }

        return -1;
    }

    public Boolean kmpSearch(String txt, String pat, int[] lps, int rep) {
        int m = txt.length();
        int n = pat.length();

        int i = 0, j = 0;

        while (i < m * rep) {
            if (txt.charAt(i % m) == pat.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return true;
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

        }

        return false;
    }

    public int[] constructLps(String str) {

        int[] lps = new int[str.length()];

        int len = 0;
        int idx = 1;
        lps[len] = 0;

        while (idx < str.length()) {

            if (str.charAt(len) == str.charAt(idx)) {
                len++;
                lps[idx] = len;
                idx++;
            } else {
                if (len == 0) {
                    lps[idx] = 0;
                    idx++;

                } else {
                    len = lps[len - 1];
                }
            }

        }

        return lps;

    }
}
