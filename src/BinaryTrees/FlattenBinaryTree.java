
   class Node {
      int val;
      Node left;
      Node right;
      Node() {}
    Node(int val) { this.val = val; }
      Node(int val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
   Node nextRight;
    public void flatten(Node root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.left=null;
        root.right=nextRight;
        nextRight=root;
    }
}
