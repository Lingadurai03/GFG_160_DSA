package Strings;

// Implement Atoi
// Difficulty: MediumAccuracy: 32.58%Submissions: 241K+Points: 4
// Given a string s, the objective is to convert it into integer format without utilizing any built-in functions. Refer the below steps to know about atoi() function.

// Cases for atoi() conversion:

// Skip any leading whitespaces.
// Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
// Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
// If the integer is greater than 231 – 1, then return 231 – 1 and if the integer is smaller than -231, then return -231.
// Examples:

// Input: s = "-123"
// Output: -123
// Explanation: It is possible to convert -123 into an integer so we returned in the form of an integer
// Input: s = "  -"
// Output: 0
// Explanation: No digits are present, therefore the returned answer is 0.
// Input: s = " 1231231231311133"
// Output: 2147483647
// Explanation: The converted number will be greater than 231 – 1, therefore print 231 – 1 = 2147483647.
// Input: s = "-999999999999"
// Output: -2147483648
// Explanation: The converted number is smaller than -231, therefore print -231 = -2147483648.
// Input: s = "  -0012gfg4"
// Output: -12
// Explanation: Nothing is read after -12 as a non-digit character ‘g’ was encountered.
// Constraints:
// 1 ≤ |s| ≤ 15

public class ImplementAtoi {
    public static void main(String[] args) {
        String str = "   234567894567893";
        ImplementAtoi ia = new ImplementAtoi();
        System.out.println(ia.convertToNumber(str));
        ;

    }

    // public int convertToNumber(String str) {
    // int symbol = 1;
    // long value = 0;

    // for (int i = 0; i < str.length(); i++) {
    // int zeroValue = Integer.valueOf('0');
    // int maxValue = Integer.valueOf('9');

    // if (str.charAt(i) == '-') {
    // symbol = -1;
    // } else if (str.charAt(i) == '+') {
    // symbol = 1;
    // } else if (Integer.valueOf(str.charAt(i)) > maxValue) {
    // break;
    // } else if (Integer.valueOf(str.charAt(i)) <= maxValue ||
    // Integer.valueOf(str.charAt(i)) <= zeroValue) {
    // if (Integer.MAX_VALUE < (value * 10) + (Integer.valueOf(str.charAt(i)) %
    // zeroValue)) {
    // return Integer.MAX_VALUE;
    // }
    // value = (value * 10) + (Integer.valueOf(str.charAt(i)) % zeroValue);
    // }
    // }

    // return (int) (value * symbol);
    // }

    public int convertToNumber(String str) {

        // Your code here

        int sign = 1;
        int res = 0;
        int index = 0;

        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            if (str.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }

        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(index) > '7')) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            res = (res * 10) + (str.charAt(index) - '0');
            index++;
        }
        return sign * res;

    }

}
