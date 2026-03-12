package Stacks_Easy_Series;

interface Stack{
    public Object pop();
    public Object peek();
    public void push(Object object);
    public int size();
}
public class ArrayStack implements Stack {
    private Object[]a;
    private int size;
    ArrayStack(int capacity){
        a=new Object[capacity];
    }
    @Override
    public Object pop() {
        if(size==0){
            throw new IllegalStateException("STACK IS EMPTY");
        }
        Object temp=a[--size];//store last element
        a[size]=null;//last element taken out
        return temp;//returning that stored last element which is now being popped out
    }

    @Override
    public int size() {
        return size;//return length of array
    }

    @Override
    public void push(Object object) {
        if(size==a.length){
            resize();//dynamic nature
        }
        a[size++]=object;//adding element
    }

    @Override
    public Object peek() {
        if(size==0){
            throw new IllegalArgumentException("Stack is empty");
        }
        return a[size-1];//see what's on top or added recently in stack
    }
    public void resize(){
        Object[]temp=a;
        a=new Object[2*temp.length];
        System.arraycopy(temp,0,a,0,size);
    }

    public boolean checkParenthesis(String str){// (()])
        ArrayStack arrayStack=new ArrayStack(str.length());
        if(str.isEmpty() || str.length()==1){
            return false;
        }
        if(str.charAt(0)==']' || str.charAt(0)=='}' || str.charAt(0)==')'){
            return false;
        }
        for(int i=0;i<str.length();i++){
            char character=str.charAt(i);
            if(character=='[' || character=='{' || character=='('){
                arrayStack.push(character);//)
            }
            else if(character==']' && arrayStack.pop().equals('[')){
                    continue;
            }
            else if(character=='}' && arrayStack.pop().equals('{')){
                continue;
            }
            else if(character==')' && arrayStack.pop().equals('(')){
                continue;
            }
            else{
                return false;
            }
        }
        return arrayStack.size == 0;
    }

    public String reverse(String str){
        ArrayStack arrayStack=new ArrayStack(str.length());
        if(str.isEmpty() || str.length()==1){
            return str;
        }
        for(int i=0;i<str.length();i++){
            char character=str.charAt(i);
            arrayStack.push(character);
        }
        StringBuilder reversed = new StringBuilder();
        while(arrayStack.size!=0) {
            reversed.append(arrayStack.pop());
        }
        return reversed.toString();
    }
    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(5);
//        arrayStack.push("Brownie");
//        arrayStack.push("Ice cream");
//        arrayStack.push("Cake");
//        arrayStack.push("Coffee");
//        arrayStack.push("Milkshake");
//
//        System.out.println(arrayStack.size);//5
//        System.out.println(arrayStack.peek());//milkshake
//        System.out.println(arrayStack.pop());//milkshake
//        System.out.println(arrayStack.peek());//coffee
//
//        arrayStack.push("Cake");
//        arrayStack.push("Coffee");
//        arrayStack.push("Milkshake");

       // System.out.println(arrayStack.size);//5-1+3=7

     //   System.out.println(arrayStack.checkParenthesis("([)"));
        System.out.println(arrayStack.reverse("zyxwvutsrqponmlkjihgfedcba"));
    }
}
