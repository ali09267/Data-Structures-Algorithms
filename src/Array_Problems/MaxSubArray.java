package Array_Problems;

public class MaxSubArray {
    public static int maxSubArray(int[]a){
        int sum= Integer.MIN_VALUE;
        int maxSum= Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            sum =sum + a[i];
            maxSum = Math.max(maxSum, sum);
            if(sum<0){
                sum=0;//as negative value can never be maximum hence reset it to 0 but after storing max sum otherwise on edge cases liek we have all elements in array as negative, we would get proper max sub array sum (which would of course be -ve value) so that is why we will check is current sum is less than 0 at the end after updating max sum
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[]array={-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
    }
}
