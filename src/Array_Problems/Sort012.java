package Array_Problems;

public class Sort012 {
    public static int[]sortColors(int[]a){//2 2 1 1 0 0
        int n=a.length;
        if(n<=1){
            return a;
        }
        int zero=0,one=0,two=0;
        for(int i=0;i<n;i++){
            if(a[i]==0){
                zero++;
            }
            else if(a[i]==1){
                one++;
            }
            else{
                two++;
            }
        }
        System.out.println(zero+" "+one+" "+two);
        int count=0;
        for(int i=0;i<zero;i++){
            a[count]=0;
            count++;
        }
        for(int i=0;i<one;i++){
            a[count]=1;
            count++;
        }
        for(int i=0;i<two;i++){
            a[count]=2;
            count++;
        }
        return a;
    }
    public static void main(String[] args) {
        int[]a={2,2,0,1,0,1,1};
        int[]newArr=sortColors(a);
        for(Integer i:newArr){
            System.out.print(i+" ");
        }
    }
}
