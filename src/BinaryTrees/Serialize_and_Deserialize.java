package BinaryTrees;

public class Serialize_and_Deserialize {
    static int idx=-1;
    static int i=-1;
    static Node deserialize(int[]preOrderSeq){
        idx++;
        if(idx>= preOrderSeq.length || preOrderSeq[idx]==-1){
            return null;
        }
        Node root=new Node(preOrderSeq[idx]);
        root.left=deserialize(preOrderSeq);
        root.right=deserialize(preOrderSeq);

        return root;
    }
    static String serialize(Node root){
        i++;
        if(root==null){
            return "-1";
        }
        return root.data+" "+serialize(root.left)+" "+serialize(root.right);
    }
    public static void main(String[] args) {
        int[]preOrderSeq={1,2,3,4,5,-1,-1,6,-1,7,-1};
        Node root=deserialize(preOrderSeq);
        System.out.println(serialize(root));
    }
}

