package Strings.BonusProblems;

// Integer to Words
// Difficulty: MediumAccuracy: 22.4%Submissions: 26K+Points: 4
// Write a function to convert a given number n into words.

// The idea is to break down the number into International Number System, i.e., smaller groups of three digits (hundreds, tens, and ones), and convert each group into words.

// Examples :

// Input: n = 0
// Output: "Zero"
// Input: n = 123
// Output: "One Hundred Twenty Three"
// Input: n = 10245
// Output: "Ten Thousand Two Hundred Forty Five"
// Input: n = 2147483647
// Output: "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven"
// Constraints:
// 0 <= n <= 231-1

public class IntegerToWords {
    public static void main(String[] args) {

        IntegerToWords itw = new IntegerToWords();
        System.out.println(itw.convertNumToWords(20000));

    }

    public String convertNumToWords(int n) {
        String[] digits = {
                "", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String[] tens = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"
        };
        String[] words = { "", "Thousand", "Million", "Billion" };

        if (n == 0) {
            return "Zero";
        }
        String res = "";
        int group = 0;
        while (n > 0) {
            if (n % 1000 != 0) {

                int value = n % 1000;
                String temp = "";

                if (value >= 100) {
                    temp = digits[value / 100] + " Hundred ";
                    value %= 100;
                }
                if (value >= 20) {
                    temp += tens[value / 10] + " ";
                    value %= 10;
                }
                if (value > 0) {
                    temp += digits[value] + " ";
                }

                temp += words[group] + " ";

                res = temp + res;

            }
            group++;
            n /= 1000;

        }

        return res.trim();
    }

}
