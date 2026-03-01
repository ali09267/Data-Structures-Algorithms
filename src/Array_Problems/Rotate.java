package Array_Problems;

public class Rotate {
    public static int[]rotate(int[]array,int k){

        int n= array.length;

        if(k>n){
             k=k%n;
        }
        if(k==n){
            return array;
        }
        int[] rotatedArray=new int[n];
        int j=0;
        for(int i=n-k;i<n;i++){
            rotatedArray[j]=array[i];
            j++;
        }

        for(int i=0;i<n-k;i++){
            rotatedArray[j]=array[i];
            j++;
        }
        return rotatedArray;
    }
    public static void main(String[] args) {
        int[]array={1,2,2,2,3,4,5};
        int[] newArray;
        newArray=rotate(array,5);

        for(Integer i:newArray){
            System.out.print(i+" ");
        }


    }
}
