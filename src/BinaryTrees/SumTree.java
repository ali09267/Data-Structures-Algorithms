package BinaryTrees;

public class SumTree {
    public static int idx=-1;
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

    public static int sumTransmission(Node root){//O(N) TIME COMPLEXITY
        if(root==null){
            return 0;
        }
        int leftSum=sumTransmission(root.left);
        int rightSum=sumTransmission(root.right);
        root.data+=leftSum+rightSum;

        return root.data;
    }
    public static void printPreOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        int[]preOrderSeq={1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root=builtTree(preOrderSeq);
        System.out.println("Before conversion");
        printPreOrder(root);
        sumTransmission(root);
        System.out.println("\nAfter conversion");
        printPreOrder(root);
    }
}
