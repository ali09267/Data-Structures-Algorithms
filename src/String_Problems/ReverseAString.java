package String_Problems;

public class ReverseAString {
    public static String reverse(String str){
        StringBuilder reversedStr= new StringBuilder();
        if(str.isEmpty() || str.length()==1){
            return str;
        }
        for(int i=str.length()-1;i>=0;i--){
            reversedStr.append(str.charAt(i));
        }
        return reversedStr.toString();
    }
    public static void main(String[] args) {
        System.out.println(reverse("Java"));
    }
}
