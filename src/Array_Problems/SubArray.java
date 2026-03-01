package Array_Problems;

import java.util.HashMap;

public class SubArray {
    public static int subArrayEqualsK(int[]array,int k){
        int n=array.length;
        int[]prefixSum=new int[n];

        prefixSum[0]=array[0];

        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+array[i];
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        int count=0;
        for(int j=0;j<n;j++){
            if(prefixSum[j]==k){
                count++;
            }
            int val=prefixSum[j]-k;

            if (map.containsKey(val)) {
                count += map.get(val);
            }
            map.put(prefixSum[j], map.getOrDefault(prefixSum[j], 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
    int[]array={100,-50,-50,100};
        System.out.println(subArrayEqualsK(array,50));
    }

    public static class MergeSorting {
        public int[] mergeSort(int[]a, int low, int high){
            int mid;
            int[] sortedArray=new int[a.length];

            if(low<high){//if array have multiple elements not single element
                mid=(low+high)/2;//calc mid index
                mergeSort(a,low,mid);//call this function again (divide from first to mid again)
                mergeSort(a,mid+1,high);//call this function again (divide from mid to last again)
                sortedArray=merge(a,low,mid,high);
            }
            return sortedArray;
        }

        public int[]merge(int[]a,int low,int mid,int high){

                int m=mid-low+1;//length of one sub-array
                int n=high-mid;//length of other sub-array

            int[]L=new int[m];//left sub-array
            int[]R=new int[n];//right sub-array

            // Copy data
            for (int i = 0; i < m; i++) {
                L[i] = a[low + i];
            }

            for (int j = 0; j < n; j++) {
                R[j] = a[mid + 1 + j];
            }

            int i = 0;
            int j = 0;
            int k = low;

                while(i<m && j<n) {
                    if (L[i] <= R[j]) {
                        a[k++] = L[i++];
                    } else {
                        a[k++] = R[j++];
                    }
                }
                for(;i<m;i++){
                    a[k++]=L[i];
                }
                for(;j<n;j++){
                    a[k++]=R[j];
                }

            return a;
        }
        public static void main(String[] args) {
            int[]array={4,1,7,2,9,8,5,2,5,10};

            MergeSorting mergeSorting=new MergeSorting();
            int[]newArray=mergeSorting.mergeSort(array,0, array.length-1);

            for(Integer i:newArray){
                System.out.print(i+" ");
            }
        }
    }
}
