package Arrays;

// **********   Next Permutation    *************

// Difficulty: MediumAccuracy: 40.66%Submissions: 164K+Points: 4
// Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 

// Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

// Examples:

// Input: arr = [2, 4, 1, 7, 5, 0]
// Output: [2, 4, 5, 0, 1, 7]
// Explanation: The next permutation of the given array is {2, 4, 5, 0, 1, 7}.
// Input: arr = [3, 2, 1]
// Output: [1, 2, 3]
// Explanation: As arr[] is the last permutation, the next permutation is the lowest one.
// Input: arr = [3, 4, 2, 5, 1]
// Output: [3, 4, 5, 1, 2]
// Explanation: The next permutation of the given array is {3, 4, 5, 1, 2}.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 105

public class NextPermutation {

    public static void main(String[] args) {
        int[] numbers = { 1, 5, 1, 3, 2 };
        // int[] numbers = { 3, 4, 2, 5, 1 };
        // int[] numbers = { 5, 2, 4, 3, 1 };

        NextPermutation np = new NextPermutation();
        PrintArray.print(numbers);
        System.out.println();
        PrintArray.print(np.nextPermutaion(numbers));

    }

    public int[] nextPermutaion(int[] arr) {

        int length = arr.length;
        int pivot = -1;

        for (int i = length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            return this.reverse(arr, 0, length - 1);
        }

        for (int i = length - 1; i > pivot; i--) {
            if (arr[pivot] < arr[i]) {
                swap(arr, pivot, i);
                break;
            }
        }
        int start = pivot + 1;
        int end = length - 1;
        return this.reverse(arr, start, end);

    }

    public int[] reverse(int[] arr, int start, int end) {
        while (start < end) {
            this.swap(arr, start, end);
            start++;
            end--;
        }
        return arr;
    }

    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
