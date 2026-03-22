package BinaryTrees;

import static java.lang.Math.max;

public class Diameter {
    static int idx=-1;
    static int ans=0;//to store curr diameter of every node (every root node)

    //CALCULATING DIAMETER WITH O(N^2) TIME COMPLEXITY
//    private static int height(Node root){
//        if(root==null){
//            return 0;
//        }
//        int leftH=height(root.left);
//        int rightH=height(root.right);
//        return max(leftH,rightH)+1;
//    }
//    public static int diameter(Node root){
//        if(root==null){
//            return 0;//diameter of empty tree is always 0
//        }
//        int leftD=diameter(root.left);
//        int rightD=diameter(root.right);
//        int currD=height(root.left)+height(root.right);
//        return max(leftD,max(rightD,currD));
//    }

    //CALCULATING DIAMETER WITH O(N) TIME COMPLEXITY
    private static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftH=height(root.left);
        int rightH=height(root.right);
        ans=max(ans,leftH+rightH);//update diameter
        return max(leftH,rightH)+1;//return height
    }
    public static int diameter(Node root){
        height(root);
        return ans;
    }

    static Node builtTree(int[]preOrderSeq){
        idx++;
        if(idx>= preOrderSeq.length || preOrderSeq[idx]==-1){
            return null;
        }
        Node root=new Node(preOrderSeq[idx]);
        root.left=builtTree(preOrderSeq);
        root.right=builtTree(preOrderSeq);

        return root;
    }
    public static void main(String[] args) {
       // int[]preOrderSeq={1,2,3,4,5,-1,-1,6,-1,7,-1,-1,-1};
        int[]preOrderSeq={1,2,4,5,-1,-1,6,-1,-1,3,7,-1,-1,8,-1,9,10,-1,-1,11,-1,-1};

        Node root=builtTree(preOrderSeq);
        System.out.println(diameter(root));
    }
}
/*
        1
       /
      2
     /
    3
   /
  4
 / \
5   6
      \
       7

//1 2 3 4 5 6 7
* */
