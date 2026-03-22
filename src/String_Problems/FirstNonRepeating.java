package String_Problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    public static String firstNonRepeating(String str){//vaaabaa
        if(str==null || str.isEmpty()){
            return "-1";
        }
        int n=str.length();//7
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {

            //THIS IF BLOCK SIMPLY INCREMENT THE FREQUENCY OF INCOMING OR REPEATED CHARACTER

            if (map.containsKey(str.charAt(i))) {//if map already contains curr char of str
                int occurrence = map.get(str.charAt(i));//then get its value i.e. key/frequency/no: of occurrence
                occurrence += 1;//increment by one
                map.put(str.charAt(i), occurrence);//put or update its occurrence

                //THIS BLOCK SIMPLY PUT ITS FREQUENCY TO 1, EXECUTES WHEN CHARACTER IS BEING ACCESSED FOR THE 1ST TIME
            } else {
                map.put(str.charAt(i),1);
            }
        }
        //ACCESS EVERY CHARACTER AND RETURNS FIRST NON-REPEATING CHARACTER
        for(int i=0;i<n;i++){
            if(map.get(str.charAt(i))==1){//first most char having one frequency
                return String.valueOf(str.charAt(i));//return that
            }
        }
        return "-1";//-1 if not any

    }
    public static void main(String[] args) {
        System.out.println(firstNonRepeating("vaaabaa"));
    }
}
