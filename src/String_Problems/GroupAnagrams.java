package String_Problems;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> grpAnagrams(String[]strs){//will return list of list of strs grouped together based on their anagramic behaviours
        if (strs == null || strs.length == 0) return new ArrayList<>();//edge case
        int n= strs.length;//length of strings array
        Map<String,List<String>>map=new HashMap<>();//for storing sorted str as key and original str as val
        List<List<String>>output=new ArrayList<>();//to store originals str (with same key) as groups whereas nested list is used for making groups inside list

        for(int i=0;i<n;i++){//main loop to iterate over array
            char[]chars=strs[i].toCharArray();//convert each element of array to char such as "eat"=>['e','a','t']
            Arrays.sort(chars);//as sorting is based on characters not Strings such as ['e','a','t']=>['a','e','t']

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
