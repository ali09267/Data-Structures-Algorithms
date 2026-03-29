package BinaryTrees;

public class KLevel {
    static int idx=-1;
    public static void kthLevel(Node root, int k){
        if(root==null){
            return;
        }
        if(k==1){
            System.out.print(root.data+" ");
        }
        kthLevel(root.left,k-1);
        kthLevel(root.right,k-1);
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
        int[]preOrderSeq={1,2,7,-1,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root=builtTree(preOrderSeq);
        kthLevel(root,2);
    }
}
