package BinaryTrees;

public class SubTree {
    static int idx=-1;
    private static boolean isIdentical(Node p, Node q){
        if(p==null || q==null){
            return p==q;
        }
        boolean isLeftSame=isIdentical(p.left,q.left);
        boolean isRightSame=isIdentical(p.right,q.right);

        return isLeftSame && isRightSame && p.data==q.data;
    }
    public static boolean isSubTree(Node root, Node subRoot){
        if(root==null || subRoot==null){
            return root==subRoot;
        }
        if(root.data == subRoot.data && isIdentical(root,subRoot)){
            return true;
        }
       return isSubTree(root,subRoot.left) || isSubTree(root,subRoot.right);
    }

    public static Node builtTree(int[]preOrderSeq){
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
        idx=-1;
        int[]subSeq={1,2,3,-1,-1};
        Node subRoot=builtTree(subSeq);

        System.out.println(isSubTree(root,subRoot));

    }
}
