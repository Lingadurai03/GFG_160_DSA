package Strings.BonusProblems;

// Palindrome Sentence
// Difficulty: EasyAccuracy: 50.04%Submissions: 18K+Points: 2
// Given a single string s, the task is to check if it is a palindrome sentence or not. A palindrome sentence is a sequence of characters, such as word, phrase, or series of symbols that reads the same backward as forward after converting all uppercase letters to lowercase and removing all non-alphanumeric characters.

// Examples:

// Input: s = "Too hot to hoot"
// Output: true
// Explanation: If we remove all non-alphanumeric characters and convert all uppercase letters to lowercase, string s will become “toohottohoot” which is a palindrome.
// Input: s = "Abc 012..## 10cbA"
// Output: true
// Explanation: If we remove all non-alphanumeric characters and convert all uppercase letters to lowercase, string s will become “abc01210cba” which is a palindrome.
// Input: s = "ABC $. def01ASDF"
// Output: false
// Explanation: The processed string becomes "abcdef01asdf", which is not a palindrome.
// Constraints:
// 1<= s.size() <= 106

public class PalindromeSentence {
    public static void main(String[] args) {
        String word = "Too hot to hoot";

        PalindromeSentence ps = new PalindromeSentence();

        System.out.println(ps.checkPalindromeOrNot(word));

    }

    public Boolean checkPalindromeOrNot(String word) {

        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (!isAlphaNumeric(word.charAt(start))) {
                start++;
                continue;
            } else if (!isAlphaNumeric(word.charAt(end))) {
                end--;
                continue;
            } else if (Character.toLowerCase(word.charAt(start)) != Character.toLowerCase(word.charAt(end))) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public Boolean isAlphaNumeric(Character c) {
        return ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }

}
