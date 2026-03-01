package Array_Problems;

import java.util.PriorityQueue;

public class Kth_Largest {
    public static int K(int[]array, int k){
        PriorityQueue<Integer>priorityQueue=new PriorityQueue<>();
        int n= array.length;
        for(int i=0;i<n;i++){
            if(priorityQueue.size()<k){
                priorityQueue.add(array[i]);
            }
            else if(array[i]>priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(array[i]);
            }
        }//O(N)
        return priorityQueue.peek();
    }
    public static void main(String[] args) {
        int[]array={2,3,3};
        System.out.println(K(array,3));
    }
}
