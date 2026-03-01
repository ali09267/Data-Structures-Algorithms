package Array_Problems;

public class MovingZeros {
    public static int[] moveZeros(int[]array){
        int j=0;
        for(int i=0;i< array.length;i++){
            if(array[i]!=0) {
                array[j] = array[i];
                j++;
            }
        }
        for(int i=j;i< array.length;i++){
            array[i]=0;
        }
        return array;
    }
    public static void main(String[] args) {
        int[]array={0,0,0,0,5,2};//1,2,4,3,8,9,0,0,0,0,0
        int[]newArray=moveZeros(array);

        for(Integer i:newArray){
            System.out.print(i+" ");
        }
    }
}
