package LinkedList_Easy_Series;

class Node{
    float data;
    Node next;
    Node(float data){
        this.data=data;
    }
    Node(float data,Node next){
        this.data=data;
        this.next=next;
    }
    public void insert(float x,Node head){
        Node p=head;
        while(p.next!=null){
            if(p.next.data>x){
                break;
            }
            p=p.next;
        }
        p.next=new Node(x,p.next);
    }
    public void print(){
        for(Node i=this;i!=null;i=i.next){
            System.out.print(i.data+"->");
        }
        System.out.println("null");
    }
    public int size(){
        int size=0;
        for(Node i=this;i!=null;i=i.next){
            size++;
        }
        return size;
    }
    public float sum(){
        float sum=0;
        for(Node i=this;i!=null;i=i.next){
            sum=sum+i.data;
        }
        return sum;
    }
    public float avg(){
        float avg=0;
        int size=size();
        float sum=sum();

        return sum/size;
    }
    public Node lastElement() {
        Node curr = this;
        while (true) {
            if (curr.next == null) {
                return curr;
            }
            curr = curr.next;
        }
    }

    public Node middleElement(){
        Node p=this;
        Node hare=p;
        Node tortoise=p;

        while(p.next!=null){
            if(hare.next==null){
                return tortoise;
            }
            else if(hare.next.next==null){
                return tortoise.next;
            }
            hare=hare.next.next;
            tortoise=tortoise.next;
            p=p.next;
        }
        return p;
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

    public int search(float x){
        Node curr=this;
        int idx=0;

        while(curr!=null){
            if(curr.data==x){
                return idx;
            }
            idx++;
            curr=curr.next;
        }
        return -1;
    }

    public Node delete(float x){
        Node start=this;
        Node p=start;
        if(start.data==x){
            return start.next;
        }
        while(p.next!=null){
            if(p.next.data==x){
                p.next=p.next.next;
                break;
            }
            p=p.next;
        }
        return start;
    }

    public boolean isCycle(){
        Node start=this;
        Node hare=start;
        Node tortoise=start;

        while(hare.next!=null && hare.next.next!=null){

            hare=hare.next.next;
            tortoise=tortoise.next;
            if(hare==tortoise){
                return true;
            }
        }
        return false;
    }
    public Node insertAtPosition(float x,int idx){
        Node head=this;
        Node p=head;
        if(idx>size()){
            return this;
        }
        if(idx==0){
            p=new Node(x,head);
            return p;
        }
        int i=1;
        while(p.next!=null){
            if(i==idx){
                p.next=new Node(x,p.next);
                break;
            }
            i++;
            p=p.next;
        }
        return head;
    }


}
public class LinkedList1 {
    public static void main(String[] args) {
        Node head=new Node(1);
        Node p=head;
                p.next=new Node(2);
                p=p.next;
//                p.next=new Node(3);
//                p=p.next;
//                p.next=new Node(4);
//                p=p.next;
//                p.next=new Node(5);

                head.print();

       // head.insert(6,head);
                head.print();
        System.out.println("Size of the Linked List: "+head.size());//7
        System.out.println("Sum of the Linked List: "+head.sum());//23.2
        System.out.println("Average of the Linked List: "+head.avg());
        System.out.println("Last element of the Linked List: "+head.lastElement().data);//4.7
        System.out.println("Middle element of the Linked List: "+head.middleElement().data);
        System.out.println(head.isCycle());

//        Node reversedList=head.reverse();
//        reversedList.print();

        System.out.println(head.search(6));
        Node deletedList=head.delete(4.7f);
        deletedList.print();

        Node afterInsertion=head.insertAtPosition(32, 0);
        afterInsertion.print();
//        Node first=new Node(1);
//        Node second=new Node(2);
//        Node third=new Node(3);
//
//        first.next=second;
//        second.next=third;
//        third.next=first;
//
//        System.out.println(first.isCycle());


    }
}
