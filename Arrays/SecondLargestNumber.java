package Arrays;

// Given an array of positive integers arr[], return the second largest element
// from the array. If the second largest element doesn't exist then return -1.

// Note: The second largest element should not be equal to the largest element.

// Examples:

// Input: arr[] = [12, 35, 1, 10, 34, 1]
// Output: 34
// Explanation: The largest element of the array is 35 and the second largest
// element is 34.

// Input: arr[] = [10, 5, 10]
// Output: 5
// Explanation: The largest element of the array is 10 and the second largest
// element is 5.

// Input: arr[] = [10, 10, 10]
// Output: -1
// Explanation: The largest element of the array is 10 and the second largest
// element does not exist.

// Constraints:
// 2 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 105

class SecondLargestNumber {

    public static void main(String[] args) {
        int[] arr = { 12, 35, 1, 10, 34, 1 };
        SecondLargestNumber sln = new SecondLargestNumber();

        System.out.println(sln.getSecondLargest(arr));
    }

    public int getSecondLargest(int[] arr) {
        int max = -1;
        int secondMax = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
}