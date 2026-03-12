package Stacks_Easy_Series;

interface Stack1{
    public Object pop();
    public Object peek();
    public void push(Object object);
    public int size();

}
public class LinkStack implements Stack{
    private static class Node {
        Object object;
        Node next;

        public Node(Object object, Node next) {
            this.object = object;
            this.next = next;
        }
    }
    Node top;
    int size=0;

    @Override
    public Object peek() {
        if(size==0){
            throw new IllegalStateException("Stack is empty");
        }
        return top.object;
    }
    public int size(){
        return size;
    }
    public Object pop(){
        if(size==0){
            throw new IllegalStateException("Stack is empty");
        }
        Node oldTemp=top;
        top=top.next;
        size--;
        return oldTemp.object;
    }

    public void push(Object object){
        size++;
        top=new Node(object,top);
    }
    public static void main(String[] args) {
        LinkStack linkStack=new LinkStack();
        linkStack.push(1);
        linkStack.push(2);
        linkStack.push(3);
        linkStack.push(4);
        linkStack.push(5);

        System.out.println(linkStack.size);//5
        System.out.println(linkStack.peek());//5
        System.out.println(linkStack.pop());//5
    }
}
