package BinarySearchTrees;

public class KthSmallestInBST {
    static int prevOrder=0;
    public static int kthSmallest(Node root,int k){
        if(root==null){
            return -1;
        }
        if(root.left!=null){
            int leftAns=kthSmallest(root.left,k);
            if(leftAns!=-1){
                return leftAns;
            }
        }

        if(prevOrder+1==k){
            return root.data;
        }
        prevOrder++;

        if(root.right!=null){
            int rightAns=kthSmallest(root.right,k);
            if(rightAns!=-1){
                return rightAns;
            }
        }
        return -1;
    }
    public static Node insert(int[]a){
        Node root=null;
        for (int j : a) {
            root = build(root, j);
        }
        return root;
    }
    public static Node build(Node root,int val){
        if(root==null){
            return new Node(val);//actual placement of root
        }
        if(val<root.data){
            root.left=build(root.left,val);
        }
        if(val> root.data){
            root.right=build(root.right,val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int[]array={5,2,7,1,8,4};
        Node root=insert(array);
        System.out.println(kthSmallest(root,4));
    }
}
