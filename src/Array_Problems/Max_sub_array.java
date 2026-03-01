package Array_Problems;


public class Max_sub_array {
    public int maxSumArray(int[]A,int low, int high){
        if(low==high){
            return A[low];//returning leaf nodes when array is fully divided into individual elements
        }
        int mid=(low+high)/2;

        int left_sum=maxSumArray(A,low,mid);
        //System.out.println("Left Sub Array sum: "+left_sum);
        int right_sum=maxSumArray(A,mid+1,high);
       // System.out.println("Right Sub Array sum: "+right_sum);
        int cross_sum=maxCrossSum(A,low,mid,high);
      // System.out.println("Cross Sub Array sum: "+cross_sum);

        return Math.max(Math.max(left_sum, right_sum), cross_sum);
    }
    public int maxCrossSum(int[]A, int low, int mid, int high){
        int left_sum=Integer.MIN_VALUE;
        int right_sum=Integer.MIN_VALUE;
        int sum=0;

        for(int i=mid;i>=low;i--){
            sum=sum+A[i];
            if(sum>left_sum){
                left_sum=sum;
            }
        }
    sum=0;
        for(int i=mid+1;i<=high;i++){
            sum=sum+A[i];
            if(sum>right_sum){
                right_sum=sum;
            }
        }
        return left_sum+right_sum;
    }
    public static void main(String[] args) {
    Max_sub_array max_sub_array=new Max_sub_array();
    int[]A={-2,-5,6,-2,-3,1,5,-6};
        System.out.println(max_sub_array.maxSumArray(A,0,A.length-1));
    }
}
