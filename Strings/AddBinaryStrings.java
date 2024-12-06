package Strings;

// Add Binary Strings
// Difficulty: MediumAccuracy: 23.25%Submissions: 84K+Points: 4
// Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
// Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

// Input: s1 = "1101", s2 = "111"
// Output: 10100
// Explanation:
//  1101
// + 111
// 10100
// Input: s1 = "00100", s2 = "010"
// Output: 110
// Explanation: 
//   100
// +  10
//   110
// Constraints:
// 1 ≤s1.size(), s2.size()≤ 106

public class AddBinaryStrings {

    public static void main(String[] args) {
        AddBinaryStrings abs = new AddBinaryStrings();
        System.out.println(abs.sumOfBinaryString("1101000", "1000"));
        ;

    }

    // Approach 1

    // public String sumOfBinaryString(String a, String b) {
    // int valueA = this.convertBinaryToInteger(a);
    // int valueB = this.convertBinaryToInteger(b);
    // int sum = valueA + valueB;

    // return this.convertIntegerToBinary(sum);
    // }

    // public int convertBinaryToInteger(String str) {
    // int sum = 0;
    // for (int i = str.length() - 1; i >= 0; i--) {
    // sum = sum + (int) ((str.charAt(i) - '0') * Math.pow(2, ((str.length() - 1) -
    // i)));
    // }

    // return sum;
    // }

    // public String convertIntegerToBinary(int num) {
    // StringBuilder binaryString = new StringBuilder();

    // while (num > 0) {
    // binaryString.insert(0, num % 2);
    // num /= 2;

    // }
    // return binaryString.toString();
    // }

    // Approach 2
    public String sumOfBinaryString(String a, String b) {

        a = this.trimLeadingZeros(a);
        b = this.trimLeadingZeros(b);

        int lengthOfA = a.length() - 1;
        int lengthOfB = b.length() - 1;

        if (lengthOfA < lengthOfB) {
            return this.sumOfBinaryString(b, a);
        }

        int carry = 0;
        StringBuilder result = new StringBuilder();

        for (int i = lengthOfA; i >= 0; i--) {

            int bit1 = a.charAt(i) - '0';
            int sum = carry + bit1;

            if (lengthOfB >= 0) {
                int bit2 = b.charAt(lengthOfB) - '0';
                sum = sum + bit2;
                lengthOfB--;

            }

            int bit = sum % 2;
            carry = sum / 2;

            result.insert(0, bit);
        }

        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
        // a = this.trimLeadingZeros(a);
        // b = this.trimLeadingZeros(b);

        // int lengthOfA = a.length() - 1;
        // int lengthOfB = b.length() - 1;

        // if (lengthOfA < lengthOfB) {
        // return sumOfBinaryString(b, a);
        // }

        // int carry = 0;
        // StringBuilder result = new StringBuilder();

        // for (int i = lengthOfA; i >= 0; i--) {
        // int bit1 = a.charAt(i) - '0';
        // int sum = bit1 + carry;

        // if (lengthOfB >= 0) {
        // int bit2 = b.charAt(lengthOfB) - '0';
        // sum += bit2;
        // lengthOfB--;
        // }

        // int bit = sum % 2;
        // carry = sum / 2;

        // result.insert(0, bit);
        // }

        // if (carry > 0) {
        // result.insert(0, carry);
        // }

        // return result.toString();

    }

    public String trimLeadingZeros(String str) {
        int firstOne = str.indexOf('1');

        return (firstOne == -1) ? "0" : str.substring(firstOne);

    }

}
