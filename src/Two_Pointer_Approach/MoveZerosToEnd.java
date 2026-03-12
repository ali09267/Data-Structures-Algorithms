package Two_Pointer_Approach;

public class MoveZerosToEnd {
    public static int[] moveZeros(int[]array){//1 0 5 0 7 0 9
       int insertPos=0;

       //moving non-zeros to front
       for(int i=0;i<array.length;i++){
           if(array[i]!=0){
               array[insertPos]=array[i];
               insertPos++;
           }
       }
       //adding zeros in rest of the array
       for(int i=insertPos;i<array.length;i++){
           array[i]=0;
       }
        return array;
    }
    public static void main(String[] args) {
        int[]array={1,0,5,0,7,0,9};
        int[]output=moveZeros(array);

        for(Integer i:output){
            System.out.print(i+" ");
        }
        System.out.println();

    }
}
