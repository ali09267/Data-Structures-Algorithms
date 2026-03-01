package Array_Problems;

import java.util.HashMap;

public class MostFrequencies {
    public static int mostOccurringElement(int[]array){
        HashMap<Integer,Integer>map=new HashMap<>();
        int maxFreq=0;
        int ans=-1;
        for (int j : array) {
            if (map.containsKey(j)) {
                int occurrence = map.get(j);
                occurrence += 1;
                map.put(j, occurrence);
            } else {
                map.put(j, 1);
            }
            if (map.get(j) > maxFreq) {
                ans = j;
                maxFreq = map.get(j);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]array={1,2,2,2,1,3,7,0,0,0,0,0,0,6,3,9,1,1,4,5,7};
        int element=mostOccurringElement(array);
        System.out.println(element);
    }
}
