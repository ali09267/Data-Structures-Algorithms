package Array_Problems;

import java.util.HashSet;
import java.util.Set;

public class Duplicates {
    public static Set<Integer> findDuplicates(int[]array){
        Set<Integer>visited=new HashSet<>();
        Set<Integer>duplicates=new HashSet<>();
        int j=0;

        for(int i=0;i< array.length;i++){
            if(visited.contains(array[i])){
               duplicates.add(array[i]);
            }
            else{
                visited.add(array[i]);
            }
        }
        return duplicates;
    }
    public static void main(String[] args) {
        int[]array={2,2,1,7,7,4,9,2,3,8};
        System.out.println(findDuplicates(array));
    }
}
