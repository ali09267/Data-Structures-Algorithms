package BinarySearchTrees;

public class MinDistance {
    static Node prev=null;
    public static Node insert(int[]a){
        Node root=null;
        for (int j : a) {
            root = builtTree(root, j);
        }
        return root;
    }
    private static Node builtTree(Node root, int val){
        if(root==null){
            return new Node(val);//actual placement of root
        }
        if(val<root.data){
            root.left=builtTree(root.left,val);
        }
        if(val> root.data){
            root.right=builtTree(root.right,val);
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

    public static int minDistance(Node root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int ans=Integer.MAX_VALUE;
        if(root.left!=null){
            int leftMin=minDistance(root.left);
            ans=Math.min(ans,leftMin);
        }
        if(prev!=null){
            ans=Math.min(ans,root.data- prev.data);
        }
        prev=root;//update prev node to curr node for nxt iteration
        if(root.right!=null){
            int rightMin=minDistance(root.right);
            ans=Math.min(ans,rightMin);
        }
        return ans;//minimum val of LST, root-prev, RST
    }
    public static void main(String[] args) {
        int[]a={83,62,88,42,82,52};
        Node root=insert(a);
        inorder(root);
        System.out.println(minDistance(root));
    }
}
