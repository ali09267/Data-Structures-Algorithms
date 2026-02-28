package String_Problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    public static String firstNonRepeating(String str){
        if(str==null || str.isEmpty()){
            return "-1";
        }
        int n=str.length();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            if (map.containsKey(str.charAt(i))) {
                int occurrence = map.get(str.charAt(i));
                occurrence += 1;
                map.put(str.charAt(i), occurrence);
            } else {
                map.put(str.charAt(i),1);
            }
        }
        for(int i=0;i<n;i++){
            if(map.get(str.charAt(i))==1){
                return String.valueOf(str.charAt(i));
            }
        }
        return "-1";

    }
    public static void main(String[] args) {
        System.out.println(firstNonRepeating("vaaabaa"));
    }
}
