package String_Problems;

public class StrToInt {
    public static int strToInt(String str) {
        //ignore leading whitespace
        str=str.trim();
        //edge case for empty string
        if(str.isEmpty()){
            return 0;
        }
        //store the sign
        int i=0;
        int sign=1;//positive sign if no sign exists like "982" is +ve and "-982" is -ve
        long num=0;//to hold max and min value(2^31)

        if(str.charAt(i)=='-' || str.charAt(i)=='+'){
            sign=(str.charAt(i)=='-') ?-1:1;//1 representing positive integer while -1 representing -ve integer
            i++;
        }
        while(i<str.length() && Character.isDigit(str.charAt(i))){
            num=num*10+(str.charAt(i)-'0');
            if(num*sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else if(num*sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)num*sign;
    }
    public static void main(String[] args) {
        System.out.println(strToInt("12bishes and trump "));
    }
}
