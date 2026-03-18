package BinaryTrees;

public class Size {
    static int idx=-1;
    public static int sizeOfTree(Node root){
        if(root==null){
            return 0;//count of empty tree is always 0
        }
        int leftCount=sizeOfTree(root.left);//count of left subtree
        int rightCount=sizeOfTree(root.right);//count of right subtree

        return leftCount+rightCount+1;
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
        int[]preOrderSeq={1,2,3,4,5,-1,-1,6,-1,7,-1};
        Node root=builtTree(preOrderSeq);
        System.out.println(sizeOfTree(root));
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

