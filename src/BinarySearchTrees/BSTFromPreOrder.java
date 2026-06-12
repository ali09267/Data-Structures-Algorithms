package BinarySearchTrees;

public class BSTFromPreOrder {
    public static Node builtBST(int[]preOrder){

        int bound=Integer.MAX_VALUE;
        return insert(preOrder,new int[]{0},bound);
    }
    public static Node insert(int[]preOrder, int[] i, int bound){
        if(i[0]>=preOrder.length || preOrder[i[0]]>bound){//curr root val is > then prev root val i.e.(left node is greater than root node) so put null means not to add val their as it will violate the property of BST
            return null;
        }
        Node root=new Node(preOrder[i[0]++]);
        root.left=insert(preOrder, i, root.data);
        root.right=insert(preOrder, i, bound);
        return root;
    }
    public static void preOrderT(Node root){
        if(root==null){
            return;
        }

        preOrderT(root.left);
        System.out.print(root.data+" ");
        preOrderT(root.right);
    }
    public static void main(String[] args) {
        int[]preOrder={6,3,1,4,8,9};
        Node root=builtBST(preOrder);
        preOrderT(root);
    }
}
