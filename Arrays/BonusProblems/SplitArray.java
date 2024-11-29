package Arrays.BonusProblems;

import java.util.ArrayList;
import java.util.List;

// Split array in three equal sum subarrays
// Difficulty: MediumAccuracy: 52.9%Submissions: 25K+Points: 4
// Given an array, arr[], determine if arr can be split into three consecutive parts such that the sum of each part is equal. If possible, return any index pair(i, j) in an array such that sum(arr[0..i]) = sum(arr[i+1..j]) = sum(arr[j+1..n-1]), otherwise return an array {-1,-1}.

// Note: Since multiple answers are possible, return any of them. The driver code will print true if it is correct otherwise, it will print false.

// Examples :

// Input:  arr[] = [1, 3, 4, 0, 4]
// Output: true
// Explanation: [1, 2] is valid pair as sum of subarray arr[0..1] is equal to sum of subarray arr[2..3] and also to sum of subarray arr[4..4]. The sum is 4, so driver code prints true.
// Input: arr[] = [2, 3, 4]
// Output: false
// Explanation: No three subarrays exist which have equal sum.
// Input: arr[] = [0, 1, 1]
// Output: false
// Constraints:
// 3 ≤ arr.size() ≤ 106
// 0 ≤ arr[i] ≤ 106

public class SplitArray {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1 };

        SplitArray s = new SplitArray();
        System.out.println(s.splitArr(arr));
        ;

    }

    public List<Integer> splitArr(int[] arr) {

        List<Integer> result = new ArrayList<Integer>();
        if (arr.length < 3) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        int totalSum = 0;
        for (int value : arr) {
            totalSum += value;
        }

        int portionValue = totalSum / 3;

        if (totalSum % 3 != 0) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        int portionSum = 0, index = 0;

        for (int i = 0; i < arr.length; i++) {

            portionSum += arr[i];

            if (portionSum == portionValue) {
                result.add(i);
                index++;
                portionSum = 0;
                if (index == 2) {
                    break;
                }

            }

        }

        if (result.size() < 2) {
            result.clear();
            result.add(-1);
            result.add(-1);
            return result;
        }
        return result;

    }
}
