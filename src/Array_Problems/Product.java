package Array_Problems;


public class Product {
    public static int[]productExceptSelf(int[]a){
       int suff=1;
       int n=a.length;

       if(n<=1){
           return a;
       }

       int[]suffix=new int[n];

       for(int i=n-1;i>0;i--){
           suffix[i]=suff;
           suff*=a[i];
       }
       int pre=1;
       int[]prefix=new int[n];
       for(int i=0;i<n;i++){
           prefix[i]=pre;
           pre*=a[i];
       }

       for(int i=0;i<n;i++){
           a[i]=prefix[i]*suffix[i];
       }
       return a;
    }

    public static void main(String[] args) {
        int[]a={5,2,1,0};
        int[]p=productExceptSelf(a);

        for(Integer i:p){
            System.out.print(i+" ");
        }
    }
}
