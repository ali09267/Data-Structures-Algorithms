package BinaryTrees;

public class InvertBinaryTree {
    public static int idx=-1;
    public static void swap(Node node){
        Node temp=node.left;
        node.left=node.right;
        node.right=temp;
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
    public static Node inverse(Node root){
        if(root==null){
            return null;
        }
        swap(root);
        inverse(root.left);
        inverse(root.right);
        return root;
    }

    public static void print(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        print(root.left);
        print(root.right);
    }
    public static void main(String[] args) {
        int[]preOrder={1,2,4,-1,-1,-1,3,-1,5,-1,-1};
        Node root=builtTree(preOrder);
        Node invertRoot=inverse(root);
        print(invertRoot);

    }
}
