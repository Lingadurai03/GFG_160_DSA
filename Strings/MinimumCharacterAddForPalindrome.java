package Strings;

// Minimum Characters to Add at Front for Palindrome

// Given a string s, the task is to find the minimum number of characters to be added to the front of s to make it palindrome. A palindrome string is a sequence of characters that reads the same forward and backward.

// Examples: 

// Input: s = "abc"
// Output: 2
// Explanation: We can make above string palindrome as "cbabc", by adding 'b' and 'c' at front.

// Input: str = "aacecaaaa"
// Output: 2
// Explanation: We can make above string palindrome as "aaaacecaaaa" by adding two a's at front of string.

// Table of Content

// [Naive Approach] Checking all prefixes - O(n^2) Time and O(1) Space
// [Expected Approach] Using lps array of KMP Algorithm - O(n) Time and O(n) Space
// [Naive Approach] Checking all prefixes - O(n^2) Time and O(1) Space
// The idea is based on the observation that we need to find the longest prefix from given string which is also a palindrome. Then minimum front characters to be added to make given string palindrome will be the remaining characters.

public class MinimumCharacterAddForPalindrome {

    public static void main(String[] args) {

        String s = "abc";

        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        s = s + "$" + rev;

        MinimumCharacterAddForPalindrome mcap = new MinimumCharacterAddForPalindrome();

        int[] lps = mcap.computeLPS(s);

        System.out.println((n - lps[lps.length - 1]));

    }

    public int[] computeLPS(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

}
