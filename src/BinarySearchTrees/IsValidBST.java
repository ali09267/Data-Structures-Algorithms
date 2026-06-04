package BinarySearchTrees;

public class IsValidBST {
    public static boolean isBST(Node root){
       return helper(root,null,null);
    }
    private static boolean helper(Node root, Node min, Node max){
        if(root==null){
            return true;
        }
        if(min!=null && min.data>= root.data){
            return false;
        }
        if(max!=null && max.data<= root.data){
            return false;
        }
        return helper(root.left,min,root) && helper(root.right,root,max);
    }
    private static Node build(Node root,int val){
        if(root==null){
            return new Node(val);//actual placement of that value
        }
        if(val<root.data){
            root.left=build(root.left,val);//move left as this value less than root
        }
        else if(val> root.data){
            root.right=build(root.right,val);//move right as this value greater than root
        }
        return root;
    }
    public static Node insert(int[]array){
        Node root=null;
        for (int j : array) {
            root = build(root, j);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[]a={3,2,1,5,6,4};
        Node root=insert(a);
        System.out.println(isBST(root));
    }
}
