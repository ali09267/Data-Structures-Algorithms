package LinkedList_Easy_Series;

class Node1{
    int data;
    Node1 next;
    Node1 bottom;
    Node1(int data){
        this.data=data;
    }
    Node1(int data,Node1 next){
        this.data=data;
        this.next=next;
    }
    void print(){
        for(Node1 i=this;i!=null;i=i.next){
            System.out.print(i.data+"->");
        }
        System.out.println("null");
    }
    public int size(){
        int size=0;
        for(Node1 i=this;i!=null;i=i.next){
            size++;
        }
        return size;
    }

    public Node1 deleteFromLast(int n){
        Node1 start=this;
        Node1 p=start;
        if(n==start.size()){
            return start.next;
        }
        for(int i=0;i<start.size()-n-1;i++){
            p=p.next;
        }
        p.next=p.next.next;
        return start;
    }

    public Node1 intersectingNode(Node1 head1,Node1 head2){
        Node1 curr1=head1;
        Node1 curr2=head2;

        int diff=Math.abs(head1.size()- head2.size());

        if(head1.size()> head2.size()) {
            for (int i = 0; i < diff; i++) {
                curr1 = curr1.next;
            }
        }
        else {
            for (int i = 0; i < diff; i++) {
                curr2 = curr2.next;
            }
        }
        while(curr1!=null && curr2!=null){
            if(curr1==curr2){
                return curr1;
            }
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return null;
    }
    public boolean isPalindrome(){
        Node1 head=this;//1-2-2-1
        Node1 mid=getMid(head);//2

       Node1 reversedSecondHalf=reverse(mid.next);//1-2
       Node1 firstHalf=head;//1-2

        while (firstHalf != null && reversedSecondHalf != null) {
            if (firstHalf.data != reversedSecondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        // If both are null, they're same length
        return true;

    }
    public static Node1 getMid(Node1 head){
        Node1 hare=head;
        Node1 tortoise=head;
        while(hare!=null && hare.next!=null && hare.next.next!=null){
            hare=hare.next.next;
            tortoise=tortoise.next;
        }
        return tortoise;
    }
    public static Node1 reverse(Node1 current){
        Node1 prev=null;
        Node1 next;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    public String cycleNode(){
        Node1 head=this;
        Node1 hare=head;
        Node1 tortoise=head;

        while(hare.next!=null && hare.next.next!=null){//to check cycle
            hare=hare.next.next;
            tortoise=tortoise.next;
            if(hare==tortoise){
                break;
            }
        }
        if(hare.next==null || hare.next.next==null){//if cycle don't occur (while loop break by null)
            return "No Cycle Detected";
        }
        tortoise = head;
        while (tortoise != hare) {//to check node that causing cycle
            tortoise = tortoise.next;
            hare = hare.next;
        }

        return "Cycle detected at node with value: " + hare.data;
    }

   public static Node1 merge(Node1 current1,Node1 current2){

        //current1 2-4-6-8      current2 1-3-5-7-9      1-2-3-4
       Node1 p=new Node1(0);
        Node1 tail=p;

        while(current1!=null && current2!=null){
            if(current2.data<=current1.data){
               tail.next=current2;
               current2=current2.next;
            }
            else {
                tail.next = current1;
                current1=current1.next;
            }
            tail=tail.next;
        }
       if(current1!=null){
        tail.next=current1;
       }
       else {
        tail.next=current2;
       }
        return p.next;
    }


}
public class LinkedListMed {
    public static void main(String[] args) {
        Node1 head = new Node1(1);
        Node1 second = new Node1(3);
        Node1 third=new Node1(5);
        Node1 fourth=new Node1(7);
        Node1 fifth=new Node1(9);

// Properly linking the nodes
        head.next = second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;

// Creating the cycle: fifth → second
        //fifth.next = second;


        Node1 head2 = new Node1(2);
        Node1 second2 = new Node1(4);
        Node1 third2 = new Node1(6);
        Node1 fourth2 = new Node1(8);


// Properly linking the nodes
        head2.next = second2;
        second2.next = third2;
        third2.next=fourth2;
// Creating the cycle: fifth → second
       // fifth.next = second;

       // head.print();
       // Node1 newList=head.deleteFromLast(5);
        //newList.print();


       // System.out.println(head.cycleNode());
        Node1 sortedList=Node1.merge(head,head2);
        sortedList.print();
    }
}
