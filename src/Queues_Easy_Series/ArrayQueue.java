package Queues_Easy_Series;

interface Queue{
    public void add(Object object);
    public Object first();
    public Object remove();
    public int size();
}
public class ArrayQueue implements Queue{
    private int size;
    private Object[]a;
    private int front;
    private int rear ;
    public ArrayQueue(int capacity){
        a = new Object[capacity];
        front = 0;//track of first element
        rear = -1;//track of every added element
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public Object first() {
        if(size==0){
            throw new IllegalArgumentException("Queue is empty");
        }
        return a[front];
    }

    @Override
    public void add(Object object) {
        if (rear == a.length - 1) {
            resize();
        }
        a[++rear] = object;
        size++;
    }

    @Override
    public Object remove() {
        if(size==0){
            throw new IllegalArgumentException("Queue is empty");
        }
        Object temp = a[front];//storing first element
        front++;//jumping to next
        size--;
        return temp;//returning first element
    }

    public void resize(){
    Object[]temp=a;
    a=new Object[2*a.length];
    System.arraycopy(temp,0,a,0,size);
    }
    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);
        arrayQueue.add(5);

        System.out.println(arrayQueue.first());//1
        System.out.println(arrayQueue.remove());//1
        System.out.println(arrayQueue.size());//4
        arrayQueue.add(6);
        arrayQueue.add(7);
        arrayQueue.add(8);
        System.out.println(arrayQueue.first());
        System.out.println(arrayQueue.size);

    }
}
