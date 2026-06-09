package BinarySearchTrees;

public class LowestCommonAncestor {
    static Node lca(Node root,Node p,Node q){
        if(root==null){
            return null;
        }
        if(root.data>p.data && root.data>q.data){
            return lca(root.left,p,q);
        }
        else if(root.data<p.data && root.data<q.data){
            return lca(root.right,p,q);
        }
        else{
            return root;
        }
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

    public static void main(String[] args) {
        int[]array={5,2,7,1,8,4,3,9};
        Node root=insert(array);
        Node lca=(lca(root,root.left,root.left.left));
        System.out.println(lca.data);
    }
}
