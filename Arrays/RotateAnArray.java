package Arrays;

// Given an unsorted array arr[]. Rotate the array to the left
// (counter-clockwise direction) by d steps, where d is a positive integer. Do
// the mentioned change in the array in place.

// Note: Consider the array as circular.

// Examples :

// Input: arr[] = [1, 2, 3, 4, 5], d = 2
// Output: [3, 4, 5, 1, 2]
// Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.
// Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
// Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
// Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4
// 6.
// Input: arr[] = [7, 3, 9, 1], d = 9
// Output: [3, 9, 1, 7]
// Explanation: when we rotate 9 times, we'll get 3 9 1 7 as resultant array.
// Constraints:
// 1 <= arr.size(), d <= 105
// 0 <= arr[i] <= 105

// ------------------- Juggling method --------------------------------

// public class RotateAnArray {

// public static void main(String[] args) {

// int[] arr = { 1, 2, 3, 4, 5 };
// RotateAnArray ra = new RotateAnArray();

// PrintArray.print(ra.rotate(arr, 2));

// }

// public int[] rotate(int[] arr, int d) {

// int n = arr.length;
// d = d % n;

// RotateAnArray ra = new RotateAnArray();

// int gcdValue = ra.findGcd(n, d);

// for (int i = 0; i < gcdValue; i++) {
// int temp = arr[i];
// int j = i;

// while (true) {
// int k = (j + d) % n;
// if (k == i)
// break;
// arr[j] = arr[k];
// j = k;

// }
// arr[j] = temp;
// }

// return arr;
// }

// public int findGcd(int a, int b) {
// if (b == 0) {
// return a;
// } else {
// return findGcd(b, a % 2);
// }
// }

// }

// -------------------  Reversal Algorithm --------------------------------

public class RotateAnArray {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;

        int d = 2;
        RotateAnArray ra = new RotateAnArray();
        ra.reverse(arr, 0, d - 1);
        ra.reverse(arr, d, n - 1);
        PrintArray.print(ra.reverse(arr, 0, n - 1));
    }

    public int[] reverse(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

}
