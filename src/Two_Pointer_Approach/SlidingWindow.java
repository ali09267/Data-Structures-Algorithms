package Two_Pointer_Approach;

public class SlidingWindow {

        // Function to find maximum sum of sub-array of size k
        public static int maxSumSubArray(int[] arr, int k) {
            int n = arr.length;

            // Edge case
            if (n < k) {
                System.out.println("Invalid input: k is larger than array size");
                return -1;
            }

            // Step 1: Calculate sum of first window
            int windowSum = 0;
            for (int i = 0; i < k; i++) {
                windowSum += arr[i];
            }

            int maxSum = windowSum;

            // Step 2: Slide the window
            for (int i = k; i < n; i++) {
                windowSum = windowSum - arr[i - k] + arr[i]; // remove left, add right
                maxSum = Math.max(maxSum, windowSum);
            }

            return maxSum;
        }

        public static void main(String[] args) {
            int[] arr = {2, 3, 4, 1, 5};
            int k = 2;

            int result = maxSumSubArray(arr, k);
            System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
        }

}
