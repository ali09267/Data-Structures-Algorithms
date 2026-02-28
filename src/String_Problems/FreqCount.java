package String_Problems;

import java.util.HashMap;
import java.util.Map;

public class FreqCount {
    public static Map<Character,Integer> frequencyCount(String str){


        Map<Character,Integer>map=new HashMap<>();

        if (str == null || str.isEmpty()) {
            return map;
        }
        int n=str.length();

        for(int i=0;i<n;i++){
            if (map.containsKey(str.charAt(i))) {
                int occurrence = map.get(str.charAt(i));
                occurrence += 1;
                map.put(str.charAt(i), occurrence);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        System.out.println(frequencyCount("I am a piece of trash"));

}
    }

