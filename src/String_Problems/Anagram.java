package String_Problems;

public class Anagram {
    public static boolean isAnagram(String str1,String str2){

        if(str1.length()!=str2.length()){
            return false;
        }
        //normalizing strings by removing all whitespaces and converting to lowercase
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();

        //frequency array to track frequency of every char of string
        int[]count=new int[26];

        //track frequency of str1
        for(int i=0;i<str1.length();i++){
            count[str1.charAt(i)-'a']++;
        }

        //subtract the frequencies of characters of str2 from it
        for(int i=0;i<str2.length();i++){
            count[str2.charAt(i)-'a']--;
        }
        //if every freq is 0 then both strings were anagrams
        for (int j : count) {
            if (j != 0) {//not an anagram because of non-zero frequency on subtracting of freq of str2 from str1
                return false;
            }
        }
        return true;//else return true
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("this is what","evil"));
    }
}
