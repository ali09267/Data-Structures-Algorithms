package Stacks_Easy_Series;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_By_Two_Queues {
    Queue<Object>queue1=new LinkedList<>();
    Queue<Object>queue2=new LinkedList<>();

    public void push(Object x){

    while ((!queue1.isEmpty())){
        Object temp=queue1.remove();
        queue2.add(temp);
    }
    queue1.add(x);
        while ((!queue2.isEmpty())){
            Object temp=queue2.remove();
            queue1.add(temp);
        }
    }
    public Object pop(){
        if(queue1.isEmpty()){
            throw new IllegalStateException("STACK IS EMPTY");
        }
    return queue1.remove();
    }
    public Object peek(){
        if(queue1.isEmpty()){
            throw new IllegalStateException("STACK IS EMPTY");
        }
    return queue1.peek();
    }
    public boolean isEmpty(){
    return queue1.isEmpty();
    }
    public static void main(String[] args) {

    }
}
