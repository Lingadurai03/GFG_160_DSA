package Strings.BonusProblems;

import java.util.ArrayList;
import java.util.List;

// CamelCase Pattern Matching
// Difficulty: MediumAccuracy: 16.18%Submissions: 46K+Points: 4
// Given a dictionary of words arr[] where each word follows CamelCase notation, print all words in the dictionary that match with a given pattern pat consisting of uppercase characters only.

// CamelCase is the practice of writing compound words or phrases such that each word or abbreviation begins with a capital letter. Common examples include PowerPoint and Wikipedia, GeeksForGeeks, CodeBlocks, etc.

// Example: "GeeksForGeeks" matches the pattern "GFG", because if we combine all the capital letters in "GeeksForGeeks" they become "GFG". Also note "GeeksForGeeks" matches with the pattern "GFG" and also "GF", but does not match with "FG".

// Note: The driver code will sort your answer before checking and return the answer in any order.

// Examples:

// Input: arr[] = ["WelcomeGeek", "WelcomeToGeeksForGeeks", "GeeksForGeeks"], pat = "WTG"
// Output: ["WelcomeToGeeksForGeeks"]
// Explanation: Since only "WelcomeToGeeksForGeeks" matches the pattern, it is the only answer.
// Input: arr[] = ["Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab"], pat = "HA"
// Output: []
// Explanation: None of the words matches the given pattern.
// Constraints:
// 1<= arr.size() <=1000
// 1<= pat.size() <=100
// 1<= arr[i].size() <=100

public class CamelCasePatternMatching {
    public static void main(String[] args) {

        String[] words = { "Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab" };
        String ptn = "HT";

        CamelCasePatternMatching ccpm = new CamelCasePatternMatching();
        System.out.println(ccpm.checkPatternMatching(words, ptn));
    }

    public ArrayList<String> checkPatternMatching(String[] words, String ptn) {
        ArrayList<String> result = new ArrayList<String>();

        for (String word : words) {
            int i = 0, j = 0;
            while (i < word.length() && j < ptn.length()) {
                if (word.charAt(i) > 'Z') {
                    i++;
                } else if (word.charAt(i) != ptn.charAt(j)) {
                    break;
                } else {
                    i++;
                    j++;
                }
            }
            if (j == ptn.length()) {
                result.add(word);
                continue;
            }
        }
        return result;
    }
}
