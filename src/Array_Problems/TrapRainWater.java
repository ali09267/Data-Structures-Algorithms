package Array_Problems;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TrapRainWater {
    public static int rainWaterTrap(int[]a){
        if(a.length<=2){
            return 0;
        }

        int n=a.length;
        int[]leftMax=new int[n];
        int[]rightMax=new int[n];
        int ans=0;

        leftMax[0]=a[0];
        rightMax[n-1]=a[n-1];

        for(int i=1;i<n;i++){
            leftMax[i]=max(leftMax[i-1],a[i]);
        }

        for(int i=n-2;i>=0;i--){
            rightMax[i]=max(rightMax[i+1],a[i]);
        }

        for(int i=0;i<n;i++){
            ans=ans+(min(leftMax[i],rightMax[i])-a[i]);
        }
        return  ans;
    }
    public static void main(String[] args) {
        int[]arr={4,2,0,3,5};
        System.out.println(rainWaterTrap(arr));

        //BRUTE FORCE APPROACH

//        int leftMax=0;
//        int rightMax=0;
//        int sum=0;
//        for(int i=0;i<n;i++){
//
//            for(int j=0;j<=i;j++){
//                leftMax=max(leftMax,arr[j]);
//            }
//
//            System.out.println(i+" th iteration and left max is "+leftMax);
//
//            for(int k=i;k<n;k++){
//                rightMax=max(rightMax,arr[k]);
//            }
//
//            System.out.println(i+" th iteration and right max is "+rightMax);
//
//            int water=min(leftMax,rightMax)-arr[i];
//            if(water>0){
//                sum=sum+water;
//            }
//            leftMax=0;
//            rightMax=0;
//        }
//
//        System.out.println(sum);
    }
}
