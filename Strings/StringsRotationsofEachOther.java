
package Strings;

// Strings Rotations of Each Other
// Difficulty: EasyAccuracy: 43.83%Submissions: 233K+Points: 2
// You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

// Note: The characters in the strings are in lowercase.

// Examples :

// Input: s1 = "abcd", s2 = "cdab"
// Output: true
// Explanation: After 2 right rotations, s1 will become equal to s2.
// Input: s1 = "aab", s2 = "aba"
// Output: true
// Explanation: After 1 left rotation, s1 will become equal to s2.
// Input: s1 = "abcd", s2 = "acbd"
// Output: false
// Explanation: Strings are not rotations of each other.
// Constraints:
// 1 <= s1.size(), s2.size() <= 105

public class StringsRotationsofEachOther {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";

        StringsRotationsofEachOther sr = new StringsRotationsofEachOther();

        System.out.println(sr.findStringEqualOrNot(s1, s2));

    }

    public Boolean findStringEqualOrNot(String s1, String s2) {
        String txt = s1 + s1;
        String pat = s2;

        int[] lps = this.constructLps(pat);

        int i = 0;
        int j = 0;

        while (i < txt.length()) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if (j == pat.length()) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }

        }
        return false;
    }

    public int[] constructLps(String ptn) {
        int[] lps = new int[ptn.length()];

        int len = 0;

        lps[len] = 0;

        int i = 1;

        while (i < ptn.length()) {
            if (ptn.charAt(i) == ptn.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    i++;

                }
            }
        }
        return lps;

    }

}
