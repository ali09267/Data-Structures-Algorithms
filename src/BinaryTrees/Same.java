package BinaryTrees;

public class Same {
    static int idx=-1;
    public static boolean isSame(Node p,Node q){
        if(p==null || q==null){
            return p==q;
        }
        boolean isLeftSame=isSame(p.left,q.left);
        boolean isRightSame=isSame(p.right,q.right);

        return isLeftSame && isRightSame && p.data==q.data;
    }

    public static Node builtTree(int[]preOrderSeq){
        idx++;
        if(idx>= preOrderSeq.length){
            return null;
        }
        if(preOrderSeq[idx]==-1){
            return null;
        }

        Node root=new Node(preOrderSeq[idx]);
        root.left=builtTree(preOrderSeq);
        root.right=builtTree(preOrderSeq);

        return root;
    }

    public static void main(String[] args) {
        int[]preOrderSeq={1,2,3,4,5,-1,-1,6,-1,7,-1};
        int[]preOrderSeq2={1,2,3,4,5,-1,-1,6,-1,7,-1,-1,-1};

        Node root=builtTree(preOrderSeq);
        idx=-1;
        Node root2=builtTree(preOrderSeq2);

        System.out.println(isSame(root,root2));

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
