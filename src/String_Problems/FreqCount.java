package String_Problems;

import java.util.HashMap;
import java.util.Map;

public class FreqCount {
    public static Map<Character,Integer> frequencyCount(String str){


        Map<Character,Integer>map=new HashMap<>();
//if string is empty, then return empty map
        if (str == null || str.isEmpty()) {
            return map;
        }
        //length of string
        int n=str.length();

        //itearte over the string (O(N) Time Complexity)
        for(int i=0;i<n;i++){
            if (map.containsKey(str.charAt(i))) {//if map already contains the curr char of str
                int occurrence = map.get(str.charAt(i));//track its occurrence
                occurrence += 1;//increment by one
                map.put(str.charAt(i), occurrence);//put it with updated or incremented frequency
            }else{
                map.put(str.charAt(i),1);//char is appearing for the first time, so just put in map with freq 1
            }
        }
        return map;//return that map with all chars of str with their respective frequencies
    }
    public static void main(String[] args) {
        System.out.println(frequencyCount("I am a piece of trash"));

}
    }

