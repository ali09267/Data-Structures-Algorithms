package Stack_med_series;

interface Stack1{
     int pop();
     int peek();
     void push(int object);
     int size();

}
class LinkStack1 implements Stack1 {
    private static class Node {
        int object;
        Node next;

        public Node(int object, Node next) {
            this.object = object;
            this.next = next;
        }
    }

    Node top;
    int size = 0;

    @Override
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.object;
    }

    public int size() {
        return size;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        Node oldTemp = top;
        top = top.next;
        size--;
        return oldTemp.object;
    }

    public void push(int object) {
        size++;
        top = new Node(object, top);
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public static int postfix(String[]expression){
        LinkStack1 stack1=new LinkStack1();

        for (String s : expression) {
            if (isNumber(s)) {
                stack1.push(Integer.parseInt(s));
            } else {
                if (s.contains("+")) {
                    int a=stack1.pop();
                    int b=stack1.pop();
                    int result = b+a;
                    stack1.push(result);
                } else if (s.contains("-")) {
                    int a=stack1.pop();
                    int b=stack1.pop();
                    int result = b-a;
                    stack1.push(result);
                } else if (s.contains("*")) {
                    int a=stack1.pop();
                    int b=stack1.pop();
                    int result = b*a;
                    stack1.push(result);
                } else if (s.contains("/")) {
                    int a=stack1.pop();
                    int b=stack1.pop();
                    int result = b/a;
                    stack1.push(result);
                } else {
                    throw new IllegalArgumentException("Invalid Expression: " + s);
                }
            }
        }
        if (stack1.size() != 1) { // extra validation
            throw new IllegalArgumentException("Invalid Postfix Expression");
        }
            return (stack1.pop());
    }
    public static boolean isNumber(String element){
        try {
            Integer.parseInt(element);  // or Double.parseDouble(s)
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int prefix(String[] expression){
        LinkStack1 stack1=new LinkStack1();
        int n=expression.length;

        for (int i=n-1;i>=0;i--) {
            if (isNumber(expression[i])) {
                stack1.push(Integer.parseInt(expression[i]));
            } else {
                if (expression[i].contains("+")) {
                    int a=stack1.pop();
                    int b=stack1.pop();
                    int result = a+b;
                    stack1.push(result);
                } else if (expression[i].contains("-")) {
                    int a=stack1.pop();
                    int b=stack1.pop();
                    int result = a-b;
                    stack1.push(result);
                } else if (expression[i].contains("*")) {
                    int a=stack1.pop();
                    int b=stack1.pop();
                    int result = a*b;
                    stack1.push(result);
                } else if (expression[i].contains("/")) {
                    int a=stack1.pop();
                    int b=stack1.pop();
                    int result = a/b;
                    stack1.push(result);
                } else {
                    throw new IllegalArgumentException("Invalid Expression");
                }
            }
        }
        if (stack1.size() != 1) { // extra validation
            throw new IllegalArgumentException("Invalid Postfix Expression");
        }
        return (stack1.pop());
    }

    public static void main(String[] args) {
        String[] arr = {"/","8","0"};
        System.out.println(prefix(arr));
    }
}


