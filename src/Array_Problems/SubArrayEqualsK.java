package Array_Problems;

import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualsK {
    public static int maxSubArrayEqualsK(int[]a,int k){
        int n=a.length;
        int[] prefixSum=new int[n];
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            sum=sum+a[i];
            prefixSum[i]=sum;
            System.out.print(prefixSum[i]+" ");
        }
        System.out.println();
        int maxLength=0;
        for(int i=0;i<n;i++){
            int num=prefixSum[i]-k;
            if(prefixSum[i]==k){
                maxLength=i+1;
            }
            if(map.containsKey(num)){
                System.out.println("Val for "+num+" is "+map.get(num));
                maxLength=Math.max(maxLength,i-map.get(num));
                System.out.println("max length is "+maxLength);
            }
            if(!map.containsKey(prefixSum[i])){
                map.put(prefixSum[i],i);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[]a={1, -1, 5, -2, 3};
        System.out.println(maxSubArrayEqualsK(a,3));//3
    }

    public static class adding_n_bit_binary_arrays {
        public static int[] add(int[]array1, int[]array2){
            int[] newArray=new int[array1.length+1];
            int carry=0;
            int sum=0;
            for(int i=array1.length-1;i>=0;i--){
                sum=array1[i]+array2[i]+carry;
                if(sum>1){
                    carry=1;
                }
                else{
                    carry=0;
                }
                sum=sum%2;
                newArray[i+1]=sum;
            }
            newArray[0]=carry;
            return newArray;
        }
        public static void main(String[] args) {
            int[]array1={1,1,0,1};
            int[]array2={0,0,0,1};

            int[] newArray =add(array1,array2);
            for(Integer i:newArray){
                System.out.print(i+" ");
            }
        }
    }

    public static class Insertion_sort {
        public static int[] sort(int[]array){

            for(int j=1;j<array.length;j++){
                int key=array[j];//current key
                int i=j-1;//to access element before it

                while(i>=0 && array[i]>key){//ith position is valid and it's greater than current
                    array[i+1]=array[i];//convert right part to the left part(half swapping)
                    i=i-1;//jump a place back
                }
                array[i+1]=key;//you found the position for key just place it
            }
            return array;
        }
        public static void main(String[] args) {
            int[]array={4,0,-3,8,-5,5,2,1,1,9};
            int[]sortedArray=sort(array);

            for(Integer i:sortedArray){
                System.out.println(i);
            }
        }
    }
}
