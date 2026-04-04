package BinaryTrees;

import java.util.ArrayList;

public class Morris {
    static int idx=-1;
    static Node builtTree(int[]preOrderSeq){
        idx++;
        if(idx>= preOrderSeq.length || preOrderSeq[idx]==-1){
            return null;
        }
        Node root=new Node(preOrderSeq[idx]);//ROOT
        root.left=builtTree(preOrderSeq);//LEFT
        root.right=builtTree(preOrderSeq);//RIGHT

        return root;
    }

    static ArrayList<Integer> inOrder(Node root){
        Node curr=root;
        ArrayList<Integer>list=new ArrayList<>();

        while(curr!=null){
            if(curr.left==null){
                list.add(curr.data);
                curr=curr.right;
            }
            else{
                //find IP(rightmost node of left BT)
                Node ip=curr.left;
                while(ip.right!=null && ip.right!=curr){//rightmost exist and it is not repeated curr
                    ip=ip.right;//rightmost
                }
                if(ip.right==null){
                    ip.right=curr;//temp thread or conn towards curr
                    curr=curr.left;
                }
                else{
                    ip.right=null;//destroy that conn
                    list.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] preOrderSeq={1,2,-1,-1,3,4,-1,-1,5};
        Node root=builtTree(preOrderSeq);

        System.out.println(inOrder(root));//2 1 4 3 5
    }
}
