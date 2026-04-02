package BinaryTrees;

import java.util.ArrayList;

public class BinaryTreePaths {

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
    public static ArrayList<String> binaryTreePaths(Node root){
        ArrayList<String>list=new ArrayList<>();
        String path=String.valueOf(root.data);
        return helper(root,path,list);
    }
    public static ArrayList<String> helper(Node root,String path,ArrayList<String>list) {
        if(root.left==null && root.right==null){
            list.add(path);
            return list;
        }
        if(root.left!=null){
            helper(root.left,path+"->"+root.left.data,list);
        }
        if(root.right!=null){
            helper(root.right,path+"->"+root.right.data,list);
        }
        return list;
    }

    public static void main(String[] args) {
        int[]preOrderSeq={1};
        Node root=builtTree(preOrderSeq);
        ArrayList<String>list;
        list=binaryTreePaths(root);
        System.out.println(list);
    }
}
