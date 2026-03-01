package String_Problems;

public class Compression {
    public static String[] stringCompression(String[]input){
        int i=0;//curr position being read
        int n=input.length;//total length of input array
        int k=0;//new position to insert (insert position in compressed str)

        while(i<n){//main loop
            int j=i+1;//j is nxt idx of i
            while(j<n && input[j].equals(input[i])){//chars are repeated (nxt idx is same as prev idx)
                j+=1;//jump j (simply ignoring all repeated chars by moving j pointer to a unique char)
            }
            input[k++] = input[i];//input that char to input array (simply override)
            int count=j-i;//then calc count of that repeated char (if any otherwise 1)
            if(count>1){//char is repeated then store its repeated value
                String strC=String.valueOf(count);//convert count integer to string (from 2 to "2")
                for(int c = 0; c<strC.length(); c++){
                    input[k++]=String.valueOf(strC.charAt(c));//simply storing count of that char at nxt idx
                }
            }
            i=j;//jump i to unique char as all repeated chars are stored
        }
        String[] result = new String[k];//output array
        System.arraycopy(input, 0, result, 0, k);//just simply copying elements (compressed str) from input arr to result arr
        return result;//return that f***ki*g output array
    }
    public static void main(String[] args) {
        String[]input={"a","a","b","b","c","c","c","b","c","c"};
        String[]output;
        output=stringCompression(input);

        for(String i:output){
            System.out.print(i+" ");
        }//a 2 b 2 c 3 b 1 c 2
    }
}
