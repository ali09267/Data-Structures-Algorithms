package String_Problems;

import java.util.*;

public class GroupAnagrams {
//    public static List<List<String>> grpAnagrams(String[]strs){
//        if (strs == null || strs.length == 0) return new ArrayList<>();
//
//        Map<String, List<String>> map = new HashMap<>();
//        for (String s : strs) {
//            char[] charArray = s.toCharArray();
//            Arrays.sort(charArray);
//            String key = new String(charArray);
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//            map.get(key).add(s);
//        }
//
//        return new ArrayList<>(map.values());
//    }

    public static List<List<String>> grpAnagrams(String[]strs){
        if (strs == null || strs.length == 0) return new ArrayList<>();//edge case
        int n= strs.length;//length of strings array
        Map<String,List<String>>map=new HashMap<>();//for storing sorted str as key and original str as val
        List<List<String>>output=new ArrayList<>();//to store originals str (with same key) as groups whereas nested list is used for making groups inside list

        for(int i=0;i<n;i++){//main loop to iterate over array
            char[]chars=strs[i].toCharArray();//convert each element of array to char
            Arrays.sort(chars);//as sorting is based on characters not Strings

            if(!map.containsKey(String.valueOf(chars))){//if map doesn't contain corresponding value based on curr key then make a new group
                List<String>vals=new ArrayList<>();//new group/new list
                vals.add(strs[i]);//add new string to that list
                map.put(String.valueOf(chars),vals);//put in map and its sorted version as its key
                output.add(vals);//add to output
            }
            else{
                map.get(String.valueOf(chars)).add(strs[i]);//return values to where key is mapped/simply add to output as its key is already stored
            }
        }
        return output;
    }
    public static void main(String[] args) {
        String[]str={"eat","ate","tea","listen","sad","silent","strike","ads"};
        System.out.println(grpAnagrams(str));
    }
}
