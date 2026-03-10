package String_Problems;

public class Permutations {
    private static boolean isFreqSame(int[]f1,int[]f2){
        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean isPerm(String s1, String s2){
        int[] freq = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;

            System.out.print(freq[i]+" ");
        }
        System.out.println();
        int windowSize=s1.length();

        for(int i=0;i<s2.length();i++){
            int[]windowFreq=new int[26];
            int windowIdx=0;
            int idx=i;

            while(windowIdx<windowSize && idx<s2.length()){
                windowFreq[s2.charAt(idx)-'a']++;
                windowIdx++;
                idx++;
            }
            if(isFreqSame(freq,windowFreq)){
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        System.out.println(isPerm("ab","eidbaoo"));
    }
}
