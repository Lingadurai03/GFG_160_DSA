package Arrays;

public class MaximumProduct {
    public static void main(String[] args) {
        int[] arr = { -2, 6, -3, -10, 0, 2 };

        MaximumProduct mp = new MaximumProduct();
        System.out.println(mp.findMaxProduct(arr));

    }

    public int findMaxProduct(int[] arr) {

        int minProduct = arr[0];
        int maxProduct = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(maxProduct * arr[i], minProduct * arr[i]));
            minProduct = Math.min(arr[i], Math.min(maxProduct * arr[i], minProduct * arr[i]));
            maxProduct = temp;

            result = Math.max(maxProduct, result);
        }
        return result;
    }

}
