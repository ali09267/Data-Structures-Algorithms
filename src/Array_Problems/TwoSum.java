package Array_Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[]array, int target){
        Map<Integer,Integer>map=new HashMap<>();
        int first, second;

        for(int i=0;i< array.length;i++){
            first=array[i];
            second=target-first;
            System.out.println("iteration "+i+": "+first+"+"+second+"="+(first+second));

            if(map.get(second)!=null){
                return new int[]{i,map.get(second)};
            }
            map.put(first,i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[]a={5,9,7,11,2};
        System.out.println(Arrays.toString(twoSum(a, 9)));
    }
}
