package BinaryTrees;
import java.util.*;

class Pair{
    Node node;
    int val;
    Pair(Node node,int val){
        this.node=node;
        this.val=val;
    }
}
public class MaxWidth {
    static int idx=-1;
    public static Node builtTree(int[]preOrderSeq){
        idx++;

        if(idx> preOrderSeq.length || preOrderSeq[idx]==-1){
            return null;
        }
        Node root=new Node(preOrderSeq[idx]);
        root.left=builtTree(preOrderSeq);
        root.right=builtTree(preOrderSeq);
        return root;
    }

    public static int maximumWidth(Node root){
        Deque<Pair>q=new LinkedList<>();
        q.add(new Pair(root,0));
        int maxWidth=0;
        while(!q.isEmpty()){
            int currSize=q.size();
            int stIdx=q.peek().val;
            int endIdx=q.getLast().val;
            maxWidth=Math.max(maxWidth,endIdx-stIdx+1);//assuming complete BT indexing

            for(int i=0;i<currSize;i++){
                Pair current=q.pop();
                if(current.node.left!=null){
                    q.add(new Pair(current.node.left,current.val*2+1));
                }
                if(current.node.right!=null){
                    q.add(new Pair(current.node.right,current.val*2+2));
                }
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        int[]preOrderSeq={1,3,5,-1,-1,4,-1,-1,2,-1,9,-1,-1};
        Node root=builtTree(preOrderSeq);
        System.out.println(maximumWidth(root));//4
    }
}
