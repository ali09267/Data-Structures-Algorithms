package String_Problems;

public class firstOccurence {
    public static int strStr(String s,String needle){
        if(needle.length()>s.length() || s.isEmpty()){
            return -1;
        }
        if(needle.isEmpty()){
            return 0;
        }

        for(int i=0;i<s.length();i++){
           if(s.charAt(i)==needle.charAt(0)){
               if(s.startsWith(needle, i)){
                   return i;
               }
           }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("leetcode","code"));
    }
}
