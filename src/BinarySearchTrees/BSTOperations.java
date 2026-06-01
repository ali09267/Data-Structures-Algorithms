package BinarySearchTrees;
public class BuildBST {
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

    public static boolean search(int data, Node root){//TIME COMPLEXITY=O(Height) (for balanced BST=O(logN)-->much optimized)
        if(root==null){
            return false;
        }
        if(root.data==data){
            return true;
        }
        if(root.data>data){
            return search(data, root.left);
        }
        else{
            return search(data, root.right);
        }
    }
    public static Node delNode(Node root, int val){
        if(root==null){
            return null;
        }
        if(val< root.data){
            root.left=delNode(root.left, val);
        }
        else if(val>root.data){
            root.right=delNode(root.right, val);
        }
        else{
            if(root.left==null){
                Node temp=root.right;
                root.right=null;
                return temp;
            }
            else if(root.right==null){
                Node temp=root.left;
                root.left=null;
                return temp;
            }
            else{
                Node IS=getIS(root.right);
                root.data=IS.data;
                root.right=delNode(root.right,IS.data);
            }
        }
        return root;
    }
    private static Node getIS(Node root){
     while(root!=null && root.left!=null){
         root=root.left;
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
        inorder(root);
        System.out.println("\n"+search(6,root));

        inorder(root);
        delNode(root,4);
        inorder(root);
    }
}
