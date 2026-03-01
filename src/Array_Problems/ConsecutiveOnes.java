package Array_Problems;

public class ConsecutiveOnes {
    public static int countMax1s(int[]array){//1 1 0 0 1 1 1 1 0 0 1 1 1 1 1
        int n= array.length;
        int count=0;
        int maxCount=0;
        for(int i=0;i<n;i++){
            if(array[i]==1) {
                count++;
            }
            else{
                count=0;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int[]array={0};
        System.out.println(countMax1s(array));
    }
}
