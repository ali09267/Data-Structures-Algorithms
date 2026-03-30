package BinaryTrees;

public class LowestCommonAncestor {
    static int idx=-1;
    //TIME COMPLEXITY IS O(N)
    //SPACE COMPLEXITY IS O(N) AT WORSE CASE WHEN OUR BT IS SKEWED
    public static Node LCA(Node root,Node p,Node q){
        if(root==null || root==p || root==q){
            return root;
        }
        Node leftLCA=LCA(root.left, p, q);
        Node rightLCA=LCA(root.right, p, q);

        if(leftLCA!=null && rightLCA!=null){
            return root;
        }
        else if(leftLCA!=null){
            return leftLCA;
        }
        else{
            return rightLCA;
        }

    }
    public static Node builtTree(int[]preOrderSeq){
        idx++;

        if(idx> preOrderSeq.length || preOrderSeq[idx]==-1){
            return null;
        }
        Node root=new Node(preOrderSeq[idx]);
        root.left=builtTree(preOrderSeq);
        root.right=builtTree(preOrderSeq);
        return root;
    }

    public static void main(String[] args) {
        int[]preOrderSeq={1,2,4,5,-1,-1,6,-1,-1,-1,3,7,-1,-1,8,-1,9,-1,10,-1,11,-1,-1};
        Node root=builtTree(preOrderSeq);
        System.out.println(LCA(root,root.right.left,root.right.right));
    }
}
