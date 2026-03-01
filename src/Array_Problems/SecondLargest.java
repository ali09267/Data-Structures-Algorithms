package Array_Problems;

public class SecondLargest {
    public static int second(int[]array){
        int n= array.length;
        if(n<2) return -1;

        int max = -1;
        int secondMax = -1;

        for (int j : array) {
            if (j > max) {
                secondMax = max; // old max becomes second max
                max = j;
            } else if (j < max && j > secondMax) {
                secondMax = j; // update second max
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        int[]a={2,2,2,2,2};
        System.out.println(second(a));
    }
}
