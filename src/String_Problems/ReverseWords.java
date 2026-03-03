package String_Problems;

public class ReverseWords {

    public static String reverseWordsInStr(String string){
        int n=string.length();
        StringBuilder answer= new StringBuilder();
        if(n<=1){
            return string;
        }
        String reversedString=new StringBuilder(string).reverse().toString();

        for(int i=0;i<n;i++){
            StringBuilder word= new StringBuilder();
            while(i<n && (reversedString.charAt(i))!=' '){
                word.append(reversedString.charAt(i));
                i++;
            }
            word.reverse();

            if(!word.isEmpty()){
                answer.append(" ").append(word);
            }

        }
        return answer.substring(1);
    }
    public static void main(String[] args) {
        System.out.println(reverseWordsInStr("HELLO MELLO KELLO"));
    }
}
