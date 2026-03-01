package Array_Problems;

public class RemoveDuplicatesFromSorted {
    public static int removeDuplicates(int[]array){
        int x=0;
       for(int i=0;i< array.length;i++){
           if(array[i]!=array[x]){
               x++;
           }
           array[x]=array[i];
       }
       return x+1;
    }
    public static void main(String[] args) {
        int[]array={0,0,0,0,0};
        System.out.println(removeDuplicates(array));

    }
}
