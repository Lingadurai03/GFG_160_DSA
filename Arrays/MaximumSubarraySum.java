package Arrays;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, -8, 7, -1, 2, 3 };

        MaximumSubarraySum mb = new MaximumSubarraySum();

        System.out.println(mb.findMaxSumOfSubArray(arr));

    }

    public int findMaxSumOfSubArray(int[] arr) {

        int res = arr[0];
        int ending = arr[0];

        for (int i = 1; i < arr.length; i++) {

            ending = Math.max(ending + arr[i], arr[i]);
            res = Math.max(ending, res);

        }

        return res;
    }

}
