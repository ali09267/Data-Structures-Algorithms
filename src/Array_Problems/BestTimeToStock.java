package Array_Problems;

public class BestTimeToStock {
    public static int best_time_to_buy(int[]a){
        int n=a.length;
        if(n==0 || n==1){
            return 0;
        }
        int min=a[0];
        int max=0;
        int sell;
        for(int i=0;i<n;i++){
            if(min>a[i]){
                min=a[i];
            }
            sell=a[i]-min;
            max=Math.max(sell,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[]a={};
        System.out.println(best_time_to_buy(a));//5
    }
}
