package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
    public static int idx=-1;
    static class Pair{
        Node node;//data, left pointer, right pointer
        int hd;//distance of each node from its root
        public Pair(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static Node builtTree(int[] preOrderSeq){
        idx++;
        if(idx>= preOrderSeq.length || preOrderSeq[idx]==-1){
            return null;
        }
        Node root=new Node(preOrderSeq[idx]);
        root.left=builtTree(preOrderSeq);
        root.right=builtTree(preOrderSeq);

        return root;
    }

    public static void bottomView(Node root){
        Queue<Pair> queue=new LinkedList<>();//queue
        TreeMap<Integer, Integer>treeMap=new TreeMap<>();//hash map
        int hd=0;//horizontal distance from root
        queue.add(new Pair(root,0));

        while(!queue.isEmpty()){
            Pair current=queue.remove();

            if(current.node.left!=null){
                queue.add(new Pair(current.node.left, current.hd-1));
            }
            if(current.node.right!=null){
                queue.add(new Pair(current.node.right, current.hd+1));
            }
            treeMap.put(current.hd, current.node.data);

        }
        System.out.println(treeMap);
    }

    public static void main(String[] args) {

        int[]preOrderSeq={1,2,-1,-1,3,4,-1,-1,5};
        Node root=builtTree(preOrderSeq);
        bottomView(root);
    }
}
