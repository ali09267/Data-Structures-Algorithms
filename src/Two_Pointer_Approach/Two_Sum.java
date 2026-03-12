package Two_Pointer_Approach;

public class Two_Sum {
    public static int[] sum(int[]array,int target){
        int left=0;//starting index
        int right=array.length-1;//last idx

        int sum;
        while(left<right){
            sum=array[left]+array[right];//summing first and last

            if(sum<target){
                left++;//sum is small, increment first
            }

            else if(sum>target){
                right--;//sum is large, decrement last
            }
            else {
                return new int[]{left+1,right+1};//sum is equal return those indices on which summing elements coming equals to the target
            }
        }
        return new int[]{-1,-1};//no such indices
    }
    public static void main(String[] args) {
        int[]array={2,2,4,6,8,10};
        int[]output=sum(array,12);

        for(Integer i:output){
            System.out.print(i+" ");
        }
    }
}
