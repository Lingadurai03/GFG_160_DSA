package Strings;

import java.util.ArrayList;
import java.util.List;

// Search Pattern (KMP-Algorithm)
// Difficulty: Medium
// Accuracy: 45.04%Submissions: 94K+Points: 4
// Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices. 
// Note: Return an empty list in case of no occurrences of pattern.

// Examples :

// Input: txt = "abcab", pat = "ab"
// Output: [0, 3]
// Explanation: The string "ab" occurs twice in txt, one starts at index 0 and the other at index 3. 
// Input: txt = "abesdu", pat = "edu"
// Output: []
// Explanation: There's no substring "edu" present in txt.
// Input: txt = "aabaacaadaabaaba", pat = "aaba"
// Output: [0, 9, 12]
// Explanation:

// Constraints:
// 1 ≤ txt.size() ≤ 106
// 1 ≤ pat.size() < txt.size()
// Both the strings consist of lowercase English alphabets.

public class StringSearchPattern {
    public static void main(String[] args) {

        StringSearchPattern ssp = new StringSearchPattern();
        System.out.println(ssp.findPatternIdx("aabaacaadaabaaba", "aaba"));

    }

    // // Approach 1 (Brute force)

    // public List<Integer> findPatternIdx(String str, String ptn) {

    // List<Integer> indices = new ArrayList<>();
    // int n = str.length();
    // int m = ptn.length();

    // for (int i = 0; i <= n - m; i++) {

    // int j;
    // for (j = 0; j < m; j++) {
    // if (str.charAt(i + j) != ptn.charAt(j)) {
    // break;
    // }
    // }

    // if (j == m) {
    // indices.add(i);
    // }
    // }
    // return indices;
    // }

    // Approach 2 KPN

    public List<Integer> findPatternIdx(String str, String ptn) {

        int n = str.length();
        int m = ptn.length();

        int[] lps = new int[m];

        this.constructLPS(ptn, lps);

        List<Integer> indices = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < n) {
            if (str.charAt(i) == ptn.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    indices.add(i - j);
                    j = lps[j - 1];
                    System.out.println(j);
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return indices;
    }

    public void constructLPS(String pat, int[] lps) {

        int len = 0;

        lps[len] = 0;

        int i = 1;

        while (i < lps.length) {
            if (pat.charAt(len) == pat.charAt(i)) {
                lps[i] = len + 1;
                i++;
                len++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }

        }
    }
}
