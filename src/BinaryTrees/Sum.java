package BinaryTrees;

public class Sum {
    static int idx=-1;
    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=sumOfNodes(root.left);
        int rightSum=sumOfNodes(root.right);

        return leftSum+rightSum+root.data;
    }
    static Node builtTree(int[]preOrderSeq){
        idx++;
        if(idx>= preOrderSeq.length || preOrderSeq[idx]==-1){//our sequence is completed, or we have reached at the end leaf of our tree
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
        System.out.println(sumOfNodes(root));
    }

}
