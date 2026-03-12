package Stack_med_series;

interface Stack{
    public int pop();
    public int peek();
    public void push(int object);
    public int size();

}
 class LinkStack implements Stack {
    private static class Node {
        int object;
        Node next;

        public Node(int object, Node next) {
            this.object = object;
            this.next = next;
        }
    }
    Node top;
    int size=0;

    @Override
    public int peek() {
        if(size==0){
            throw new IllegalStateException("Stack is empty");
        }
        return top.object;
    }
    public int size(){
        return size;
    }
    public int pop(){
        if(size==0){
            throw new IllegalStateException("Stack is empty");
        }
        Node oldTemp=top;
        top=top.next;
        size--;
        return oldTemp.object;
    }

    public void push(int object){
        size++;
        top=new Node(object,top);
    }

    public static int[] nextGreaterElement(int[]array){
        LinkStack stack=new LinkStack();//empty stack
        int n= array.length;//size of array
        int[]resultArray=new int[n];//initialized result array with same length as of input array

        for(int i=n-1;i>=0;i--){
            while((stack.size > 0) && stack.peek() <= array[i]){
                stack.pop();
            }
            if(stack.size()==0){
                resultArray[i]=-1;
            }
            else{
                resultArray[i]=stack.peek();
            }
            stack.push(array[i]);
        }
        return resultArray;
    }

    public static int[]stockSpan(int[]array){
        int n=array.length;
        LinkStack stack=new LinkStack();
        int[]result=new int[n];

        for(int i=0;i<n;i++){

            while(stack.size!=0 && array[stack.peek()]<=array[i]){
                    stack.pop();//drop all the less and equal to values from today from stack
                }//stopped where lage price occurs
                if(stack.size==0){
                    result[i]=i+1;//no small price, just add 1
                }
                else{
                    result[i] = i - stack.peek();//minimizing index of prev High element from curr element
                }
            stack.push(i);//push today's price to stack
        }
        return result;
    }
    public static void main(String[] args) {
//        double[]array={13, 7, 6, 12,2000};
//        double[] result=nextGreaterElement(array);
//
//        for(Double i:result){
//            System.out.println(i);
//        }

        int[]array={10,4,5,90,120,80};
        int[] result=stockSpan(array);

        for(Integer i:result){
            System.out.println(i);
        }

    }
}


