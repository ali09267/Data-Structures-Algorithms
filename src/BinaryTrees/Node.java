package BinaryTrees;

public class Node{
    int data;//data on that node
    Node left;//its left child/subtree
    Node right;//its right child//subtree
    Node(int data){//setting the node in constructor
        this.data=data;//setting data on it
        left=null;//at initial stages, left and right child nodes are null
        right=null;
    }
}

