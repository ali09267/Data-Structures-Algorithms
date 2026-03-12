package LinkedList_Med_Series;


class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
    }

    public Node flatten(Node head){
        if (head==null){
            return head;//if head is null return null
        }
        Node curr=head;
        while(curr!=null){
            if(curr.bottom!=null){
                //flatten child nodes
                Node next=curr.next;
                curr.next=flatten(curr.bottom);

                //tail of new LL
                while(curr.next!=null){
                    curr=curr.next;
                }
                //attach tail with nxt pointer
                if(next!=null){
                    curr.next=next;
                }
            }
            curr=curr.next;
        }
        return head;
    }
    void printMultiLevel(Node head) {
        Node row = head;
        while (row != null) {
            Node col = row;
            while (col != null) {
                System.out.print(col.data + " ");
                col = col.bottom;
            }
            System.out.println();
            row = row.next;
        }
    }
    void print(){

        for(Node p=this;p!=null;p=p.next) {
            System.out.print(p.data+"->");
        }
        System.out.print("NULL\n");
    }
    int size(){
        int size=0;

        for(Node p=this;p!=null;p=p.next) {
            System.out.print(p.data+"->");
            size++;
        }
        return size;
    }

    public static Node split(Node head){
        Node hare=head;
        Node tortoise=head;

        if(head==null){
            return null;
        }

        while(hare.next!=null && hare.next.next!=null){
            hare=hare.next.next;
            tortoise=tortoise.next;
        }
         Node temp=tortoise.next;
        tortoise.next=null;
        return temp;
    }

    static Node merge(Node first, Node second) {

        // If either list is empty, return the other list
        if (first == null) return second;
        if (second == null) return first;

        // Pick the smaller value between first and second nodes
        if (first.data < second.data) {

            // Recursively merge the rest of the lists and
            // link the result to the current node
            first.next = merge(first.next, second);
            return first;
        }
        else {
            // Recursively merge the rest of the lists
            // and link the result to the current node
            second.next = merge(first, second.next);
            return second;
        }
    }

    Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node secondHalf;

        secondHalf=split(head);

        head=mergeSort(head);
        secondHalf=mergeSort(secondHalf);

        return merge(head,secondHalf);
    }
    Node sum(Node head1,Node head2){

        Node dummy=new Node(0);
        Node curr=dummy;
        int carry=0;
        Node p1=head1;
        Node p2=head2;

        while(p1!=null || p2!=null || carry!=0){

            int val1 = (p1 != null) ? p1.data : 0;
            int val2 = (p2 != null) ? p2.data : 0;

            int sum=val1+val2+carry;
            carry=sum/10;
            curr.next=new Node(sum%10);

            if(p1!=null){p1=p1.next;}
            if(p2!=null){p2=p2.next;}
            curr=curr.next;
        }
        return dummy.next;
    }
    public Node reverse(){
        Node prev=null;
        Node curr=this;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;//main work is done here
            //to go ahead
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public Node reverseKNodes(Node head,int k){
        Node curr=head;
        int count=0;
        while(count<k){
            if(curr==null){
                return head;
            }
            count++;
            curr=curr.next;
        }
        Node prevNode=reverseKNodes(curr,k);

        count=0;
        curr=head;
        while(count<k){
            Node next=curr.next;
            curr.next=prevNode;
            prevNode=curr;
            curr=next;

            count++;
        }
        return prevNode;
    }

    public static Node delete(Node head,int m,int n){
        Node curr=head;
        if(curr==null){//checking end of the LL
            return curr;
        }
        int i=1;
        while(i<m && curr!=null){
            curr=curr.next;//skipping m nodes
            i++;
        }

        if(curr==null){
            return head;//checking whether list is remaining
        }

        Node q=curr.next;
        i=0;
        while(i<n && q!=null){
            q=q.next;//leaving n nodes behind
            i++;
        }

       curr.next=delete(q,m,n);//connecting mth node with m+n+1th node
       return head;
    }

    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Count length
        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: k might be greater than length
        k = k % length;
        if (k == 0) return head;

        // Step 3: Find new tail (length - k)th node
        int skip = length - k;
        Node newTail = head;
        for (int i = 1; i < skip; i++) {
            newTail = newTail.next;
        }

        // Step 4: Define new head
        Node newHead = newTail.next;

        // Step 5: Rotate
        newTail.next = null;
        tail.next = head;

        return newHead;
    }


}
public class Flattening {
    public static void main(String[] args) {
//        Node head=new Node(1);
//        head.next=new Node(5);
//        head.bottom=new Node(2);
//        head.bottom.bottom=new Node(3);
//        head.bottom.bottom.bottom=new Node(4);
//
//        head.next.bottom=new Node(6);
//
//        head.printMultiLevel(head);
//        head.print();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//        head.flatten(head);
//        head.print();

        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next=new Node(6);
        head.next.next.next.next.next.next=new Node(7);
        head.next.next.next.next.next.next.next=new Node(8);

        Node rotateList=head.rotate(head,7);
        rotateList.print();
//        Node newList=Node.delete(head,2,2);
//        newList.print();

       //head.print();
//       Node reversedK=head.reverseKNodes(head,2);
//       reversedK.print();
//

//        Node head1=new Node(8);
//        head1.next=new Node(2);
//        head1.next.next=new Node(3);
//        head1.next.next.next=new Node(1);
//        head1.next.next.next.next=new Node(9);
//        head1.next.next.next.next.next=new Node(4);
//
//        head.print();
//        Node reverseHead=head.reverse();
//        Node reverseHead1=head1.reverse();
//
//
//        reverseHead.print();
//        reverseHead1.print();
//
//        Node temp=(head.mergeSort(reverseHead));//1-2-3-4-8-9
//        System.out.println("Merge Sort:- ");
//        temp.print();
//
//        System.out.println();
//
//        Node sumOfList=head.sum(reverseHead,reverseHead1);
//        System.out.println("Sum of 2 lists: ");
//        sumOfList.print();


    }
}
