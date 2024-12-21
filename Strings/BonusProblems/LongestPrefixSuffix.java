package Strings.BonusProblems;

// Longest Prefix Suffix
// Difficulty: HardAccuracy: 27.91%Submissions: 140K+Points: 8
// Given a string of characters s, find the length of the longest prefix which is also a suffix.
// Note: Prefix and suffix can be overlapping but they should not be equal to the entire string.

// Examples :

// Input: s = "abab"
// Output: 2
// Explanation: "ab" is the longest prefix and suffix. 
// Input: s = "aabcdaabc"
// Output: 4
// Explanation: The string "aabc" is the longest prefix and suffix.
// Input: s = "aaaa"
// Output: 3
// Explanation: "aaa" is the longest prefix and suffix. 
// Constraints:
// 1 ≤ s.size() ≤ 106
// s contains only lowercase English alphabets.

public class LongestPrefixSuffix {

    public static void main(String[] args) {
        String str = "bbaddaccad";

        LongestPrefixSuffix l = new LongestPrefixSuffix();

        int res = l.constructLPS(str);

        System.out.println(res);

    }

    public int constructLPS(String str) {
        int[] lps = new int[str.length()];

        int len = 0;
        int idx = 1;

        while (idx < lps.length) {
            if (str.charAt(idx) == str.charAt(len)) {
                len++;
                lps[idx] = len;
                idx++;
            } else {
                if (len == 0) {
                    idx++;
                } else {
                    len = lps[len - 1];
                }
            }
        }

        return lps[lps.length - 1];
    }

}
