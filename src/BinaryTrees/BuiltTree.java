package BinaryTrees;

public class BuiltTree {
    static int preIdx=0;
    static Node builtTree(int[]preOrderSeq,int[]inOrderSeq,int l,int r){
        if(l>r){
            return null;
        }
        Node root=new Node(preOrderSeq[preIdx++]);
        int inIdx=search(inOrderSeq,l,r,root.data);

        root.left=builtTree(preOrderSeq,inOrderSeq,l,inIdx-1);
        root.right=builtTree(preOrderSeq,inOrderSeq,inIdx+1,r);

        return root;
    }
    static int search(int[]inOrderSeq,int l, int r, int val){
        for(int i=l;i<=r;i++){
            if(inOrderSeq[i]==val){
                return i;
            }
        }
        return -1;
    }
    public static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};

        Node root=builtTree(preorder, inorder,0, inorder.length-1);

        System.out.println("Inorder of constructed tree:");
        printInorder(root);
    }
}
