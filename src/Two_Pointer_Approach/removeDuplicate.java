package Two_Pointer_Approach;

public class removeDuplicate {
    public static int[] removeDuplicates(int[]array){

        int i=0;

        int newArrLength=1;//since first element cannot be a duplicate

        //calculating length of original array by removing duplicates
        while(i<array.length-1){
            if(array[i]!=array[i+1]){
                newArrLength=newArrLength+1;
            }
            i++;
        }

        int[]newArray=new int[newArrLength];//length of original array w/o duplicates

        newArray[0] = array[0];//copy first element as it is as first element cannot be a duplicate
        int j = 1;

        for (i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {//if element is not a duplicate
                newArray[j] = array[i];//insert it into new array
                j++;//increment idx for new array
            }
        }

        return newArray;//return new array that actually contains original array element but w/o duplicates
    }

    public static void main(String[] args) {
        int[]arr={1,1,1,1,1,1,1,1,1,1};
        int[]newArr=removeDuplicates(arr);

        for (int j : newArr) {
            System.out.print(j + " ");
        }
    }
}
