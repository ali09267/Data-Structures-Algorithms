package Two_Pointer_Approach;

public class ReverseString {
    public static String reverse(String str){

        int len=str.length();
        if(len==0 || len==1){
            return str;
        }

        char[]array=str.toCharArray();//converting string to array of characters

        for(int i=0;i<len/2;i++){
            char temp=array[i];//first element
            array[i]=array[len-1-i];//equate to last element
            array[len-1-i]=temp;//equate last element back to first element
        }
        str=new String(array);
        return str;
    }
    public static void main(String[] args) {
        System.out.println(reverse("racecar"));
    }
}
