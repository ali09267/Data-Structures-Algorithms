package BinarySearchTrees;

public class SortedArrayToBST {
    private static Node helper(int[]nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        Node root=new Node(nums[mid]);
        root.left=helper(nums,start,mid-1);
        root.right=helper(nums,mid+1,end);
        return root;
    }
    public static Node builtTree(int[]nums){
        return helper(nums,0,nums.length-1);
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int[]nums={-10,-3,3,6,12};
        Node root=builtTree(nums);
        inOrder(root);
    }
}
