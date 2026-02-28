package String_Problems;

import java.util.HashSet;

public class MaxSubString {
    public static int maxSubStrWoRepeatChar(String str){
        int n=str.length();
    if(n<=1){
        return n;
    }

        HashSet<Character>hashSet=new HashSet<>();
    int maxLength=0;
    int left=0;

    for(int right=0;right<n;right++){
        while(hashSet.contains(str.charAt(right))){
            hashSet.remove(str.charAt(left));
            left++;
        }
        hashSet.add(str.charAt(right));
        maxLength=Math.max(maxLength,right-left+1);
    }
    return maxLength;
    }

    public static void main(String[] args) {
        String str="pwwkew";
        System.out.println(maxSubStrWoRepeatChar(str));//wke=>3
    }
}

