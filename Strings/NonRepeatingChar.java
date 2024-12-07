package Strings;

import java.util.HashMap;

// Non Repeating Character
// Difficulty: EasyAccuracy: 40.43%Submissions: 258K+Points: 2
// Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
// Note: When you return '$' driver code will output -1.

// Examples:

// Input: s = "geeksforgeeks"
// Output: 'f'
// Explanation: In the given string, 'f' is the first character in the string which does not repeat.
// Input: s = "racecar"
// Output: 'e'
// Explanation: In the given string, 'e' is the only character in the string which does not repeat.
// Input: s = "aabbccc"
// Output: -1
// Explanation: All the characters in the given string are repeating.
// Constraints:
// 1 <= s.size() <= 105

public class NonRepeatingChar {
    public static void main(String[] args) {
        String s = "geeksforgeeks";

        NonRepeatingChar nrc = new NonRepeatingChar();

        System.out.println(nrc.findNonRepeatingChar(s));

    }

    public char findNonRepeatingChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return '$';
    }

}
