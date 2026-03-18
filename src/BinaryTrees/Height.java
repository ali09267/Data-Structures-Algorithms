package BinaryTrees;

public class Height {
    static int idx=-1;
    public static int height(Node root){
        if(root==null){
            return 0;//height of empty tree is always 0
        }
        int leftH=height(root.left);//height of left subtree
        int rightH=height(root.right);//height of right subtree

        return Math.max(leftH,rightH)+1;//max of left subtree and right subtree + 1 due to increment of 1 as we jump over the levels
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
        System.out.println(height(root));
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
