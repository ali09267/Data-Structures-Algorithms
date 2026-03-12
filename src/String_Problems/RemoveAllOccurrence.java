package String_Problems;

public class RemoveAllOccurrence {
    public static String removeAll(String s, String part){
        int n=s.length();
        int p=part.length();
        StringBuilder stringBuilder=new StringBuilder();

        for(int i=0;i<n;i++){
            stringBuilder.append(s.charAt(i));
            if(stringBuilder.toString().endsWith(part)){
                stringBuilder.delete(stringBuilder.length()-p,stringBuilder.length());
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeAll("abcbcbcbcdefbcbcb","bc"));
    }
}
