package Array_Problems;
public class Strassens {
    public int[][] arrayMultiplication(int[][]A, int[][]B){
        int n=A.length;//to store the order
        int[][]C=new int[n][n];//to store the result
        if(n==1){
            C[0][0]=A[0][0]*B[0][0];//matrix is of 1 element
            return C;
        }
        else{
            //making split arrays of first matrix(one array into four parts)
           int[][]A11=new int[n/2][n/2];//FIRST QUARTER
            int[][]A12=new int[n/2][n/2];//SECOND QUARTER
            int[][]A21=new int[n/2][n/2];//THIRD QUARTER
            int[][]A22=new int[n/2][n/2];//FOURTH QUARTER

            //making split arrays of second matrix (one array into four parts)
            int[][]B11=new int[n/2][n/2];//FIRST QUARTER
            int[][]B12=new int[n/2][n/2];//2ND Q
            int[][]B21=new int[n/2][n/2];//3RD Q
            int[][]B22=new int[n/2][n/2];//4TH Q

            //actual splitting starts
            split(A,A11,0,0);//SPLIT FIRST QUARTER
            split(A,A12,0,n/2);//SPLIT 2ND
            split(A,A21,n/2,0);//SPLIT 3RD
            split(A,A22,n/2,n/2);//SPLIT 4TH

            //same for second matrix
            split(B,B11,0,0);
            split(B,B12,0,n/2);
            split(B,B21,n/2,0);
            split(B,B22,n/2,n/2);

            //Strassen's formulae
            int[][]m1=arrayMultiplication(add(A11,A22),add(B11,B22));
            int[][]m2=arrayMultiplication(add(A21,A22),B11);
            int[][]m3=arrayMultiplication(A11,sub(B12,B22));
            int[][]m4=arrayMultiplication(A22,sub(B21,B11));
            int[][]m5=arrayMultiplication(add(A11,A12),B22);
            int[][]m6=arrayMultiplication(sub(A21,A11),add(B11,B12));
            int[][]m7=arrayMultiplication(sub(A12,A22),add(B21,B22));

            int[][]C11=add(sub(add(m1,m4),m5),m7);
            int[][]C12=add(m3,m5);
            int[][]C21=add(m2,m4);
            int[][]C22=add(sub(add(m1,m3),m2),m6);

            //combining those split parts
            join(C11,C,0,0);//join C11 to C's first quarter
            join(C12,C,0,n/2);//join C12 to C's 2nd Q
            join(C21,C,n/2,0);//join C21 to C's 3rd Q
            join(C22,C,n/2,n/2);//join C22 to C's 4th Q

        }
        return C;
    }
    public int[][] sub(int[][]A,int[][]B){
        int n=A.length;
        int[][] C=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                C[i][j]=A[i][j]-B[i][j];
            }
        }
        return C;
    }

    public int[][] add(int[][]A,int[][]B){
        int n=A.length;
        int[][] C=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                C[i][j]=A[i][j]+B[i][j];
            }
        }
        return C;
    }

    public void split(int[][]P,int[][]C,int ib,int jb){

        for(int i1=0,i2=ib ; i1<C.length ; i1++,i2++){
            for(int j1=0,j2=jb ; j1<C.length ; j1++,j2++){
                C[i1][j1]=P[i2][j2];//copy parent matrix's quarter into child matrix
            }
        }
    }

    public void join(int[][]C,int[][]P,int ib,int jb){

        for(int i1=0,i2=ib ; i1<C.length ; i1++,i2++){
            for(int j1=0,j2=jb ; j1<C.length ; j1++,j2++){
                P[i2][j2]=C[i1][j1];
            }
        }
    }
    public static void main(String[] args) {
        Strassens strassens=new Strassens();
        int[][]A={{1,5},{9,2}};
        int[][]B={{1,0},{0,1}};
        int n=A.length;
        int[][]C=strassens.arrayMultiplication(A,B);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }

    }
}
