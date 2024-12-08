package Strings;

import java.util.ArrayList;
import java.util.List;

// Search Pattern (KMP-Algorithm)
// Difficulty: MediumAccuracy: 45.04%Submissions: 94K+Points: 4
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
        System.out.println(ssp.findPatternIdx("abcab", "ab"));

    }

    // Approach 1 (Brute force)

    public List<Integer> findPatternIdx(String str, String ptn) {

        List<Integer> indices = new ArrayList<>();
        int n = str.length();
        int m = ptn.length();

        for (int i = 0; i <= n - m; i++) {

            int j;
            for (j = 0; j < m; j++) {
                if (str.charAt(i + j) != ptn.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                indices.add(i);
            }
        }
        return indices;
    }
}
