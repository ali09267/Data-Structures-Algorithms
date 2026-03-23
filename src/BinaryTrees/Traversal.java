package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {
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
    static void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    static void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }
    static void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    static void levelOrderTraversal(Node root){
        Queue<Node>queue=new LinkedList<>();//initialize a queue
        queue.add(root);//add root at first go

        while(queue.size()>0){//if queue is not empty (traversal of tree is remaining)

            Node curr=queue.peek();//store top most element of Queue(first element of a level)
            queue.remove();//remove it (successfully traversed it)
            System.out.print(curr.data+" ");//print that traversed node
            if(curr.left!=null) {//if it have a left child store that (that is next to be traversed)
                queue.add(curr.left);
            }
            if(curr.right!=null){//if it have a right child store that in Queue that is next to be traversed
                queue.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        int[]preOrderSeq={1,2,3,4,5,-1,-1,6,-1,7,-1};
        Node root=builtTree(preOrderSeq);
        System.out.println("PRE ORDER TRAVERSAL");
        preOrderTraversal(root);
        System.out.println("\nINORDER TRAVERSAL");
        inOrderTraversal(root);
        System.out.println("\nPOST-ORDER TRAVERSAL");
        postOrderTraversal(root);
        System.out.println("\nLEVEL-ORDER TRAVERSAL");
        levelOrderTraversal(root);
    }
}
/*
        1
       /
      2
     /
    3
   /
  4
 / \
5   6
      \
       7

//1 2 3 4 5 6 7
* */


