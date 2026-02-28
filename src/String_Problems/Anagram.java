package String_Problems;

public class Anagram {
    public static boolean isAnagram(String str1,String str2){

        if(str1.length()!=str2.length()){
            return false;
        }
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();

        int[]count=new int[26];
        for(int i=0;i<str1.length();i++){
            count[str1.charAt(i)-'a']++;
        }
        for(int i=0;i<str2.length();i++){
            count[str2.charAt(i)-'a']--;
        }
        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("this is what","evil"));
    }
}
