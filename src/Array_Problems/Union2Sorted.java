package Array_Problems;

import java.util.ArrayList;

public class Union2Sorted {
    public static ArrayList<Integer> union(int[]left, int[]right){
        ArrayList<Integer>list=new ArrayList<>();

        int i=0,j=0;
            while(i<left.length && j< right.length) {
                if (left[i] <= right[j]) {
                    list.add(left[i]);
                    i++;
                } else if (right[j] < left[i]) {
                    list.add(right[j]);
                    j++;
                }
            }
            while(i<left.length){
                list.add(left[i]);
                i++;
            }
        while(j<right.length){
            list.add(right[j]);
            j++;
        }

        return list;
    }
    public static void main(String[] args) {
        ArrayList<Integer>list;
        int[]arr1={2,2,3};
        int[]arr2={2,100};
        list=union(arr1,arr2);

        for(Integer i:list){
            System.out.print(i+" ");
        }
    }
}
