package LinkedList_Hard_Series;

public class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
    public static void print(Node head){
        for(Node i = head; i!=null; i=i.next){
            System.out.print(i.data+"->");
        }
        System.out.println("null");
    }

    public static Node segregate(Node head){

        if(head==null || head.next==null){
            return head;//if list is empty or have single node
        }

        Node evenHead=null,evenTail=null;//even list
        Node oddHead=null,oddTail=null;//odd list

        Node current=head;

        while(current!=null){

            if(current.data%2==0){//if even node
                if(evenHead==null){
                    evenHead=evenTail=current;//if head is even update it to head
                }
                else{
                    evenTail.next=current;//else add it accordingly
                    evenTail=current;
                }
            }
            else{
                if(oddHead==null){
                    oddHead=oddTail=current;//similarly if head is odd, update to head
                }
                else{
                    oddTail.next=current;//else add it accordingly
                    oddTail=current;
                }
            }
            current=current.next;
        }
        if (evenHead == null) return oddHead;//all are odd
        if (oddHead == null) return evenHead;//all are even

        evenTail.next=oddHead;//even nodes first
        oddTail.next=null;//odd nodes last

        return evenHead;//return list
    }


    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        Node p=head.next;
        p.next=new Node(4);
        p=p.next;
        p.next=new Node(5);
        p=p.next;
        p.next=new Node(6);
        p=p.next;
        p.next=new Node(7);
        p=p.next;
        p.next=new Node(8);
        p=p.next;
        p.next=new Node(9);

        Node newList=segregate(head);
        print(newList);
    }
}


