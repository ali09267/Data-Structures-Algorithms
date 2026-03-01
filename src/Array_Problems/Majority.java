package Array_Problems;


public class Majority {
    //assumes majority element always exists
    public static int calcMajority(int[]array){
        int freq=0;int ans=0;

        for(int i=0;i< array.length;i++){
            if(freq==0){
                ans=array[i];
            }
            if(ans==array[i]){
                freq++;
            }
            else{
                freq--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    int[]array={1,2,2,1,1,2,2,3,3,3,3,3};
        System.out.println(calcMajority(array));
    }
}
