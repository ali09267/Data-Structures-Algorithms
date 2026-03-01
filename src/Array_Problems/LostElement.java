package Array_Problems;

public class LostElement {
    public static int missingElement(int[]array){
        int n= array.length;//array.length+1 if numbers are from 1 to n
        int expected_sum=(n*(n+1))/2;
        int actual_sum=0;

        for (int j : array) {
            actual_sum += j;
        }
        return expected_sum-actual_sum;
    }
    public static void main(String[] args) {
        int[]array={0,2,1,6,8,4,7,3};
        System.out.println(missingElement(array));
    }
}
