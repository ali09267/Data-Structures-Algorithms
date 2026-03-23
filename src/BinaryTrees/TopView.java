package BinaryTrees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
    static int idx=-1;
   static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
     Node builtTree(int[]preOrderSeq){
        idx++;
        if(idx>= preOrderSeq.length || preOrderSeq[idx]==-1){//our sequence is completed, or we have reached at the end leaf of our tree
            return null;
        }
        Node root=new Node(preOrderSeq[idx]);
        root.left=builtTree(preOrderSeq);
        root.right=builtTree(preOrderSeq);

        return root;
    }
    public static void topView(Node root){
            Queue<Pair> queue=new LinkedList<>();

        TreeMap<Integer,Integer>treeMap=new TreeMap<>();

            queue.add(new Pair(root,0));

            while(!queue.isEmpty()){

                Pair current=queue.peek();
                queue.remove();
                if(!treeMap.containsKey(current.hd)){
                    treeMap.put(current.hd,current.node.data);
                }
                if(current.node.left!=null){
                    queue.add(new Pair(current.node.left,current.hd-1));
                }
                if(current.node.right!=null){
                    queue.add(new Pair(current.node.right,current.hd+1));
                }

            }
        System.out.println(treeMap);

    }

    public static void main(String[] args) {
        TopView top=new TopView();
        int[]preOrderSeq={1,2,-1,-1,3,4,-1,-1,5};
        Node root=top.builtTree(preOrderSeq);
        topView(root);
    }
}
