package Stack_med_series;

interface Stack2{
    Object pop();
    Object peek();
    void push(Object object);
    int size();

}
class LinkStack2 implements Stack2 {
    private static class Node {
        Object object;
        Node next;

        public Node(Object object, Node next) {
            this.object = object;
            this.next = next;
        }
    }

    Node top;
    int size = 0;

    @Override
    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.object;
    }

    public int size() {
        return size;
    }

    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        Node oldTemp = top;
        top = top.next;
        size--;
        return oldTemp.object;
    }

    public void push(Object object) {
        size++;
        top = new Node(object, top);
    }
    public boolean isEmpty(){
        return size()==0;
    }

    public static String decodeString(String s) {

       LinkStack2 countStack=new LinkStack2();
       LinkStack2 stringStack=new LinkStack2();

        String current = "";
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');//if its 123, 1->1*10=10+2=12   ->  12*10=120+3=123
            }

            else if (ch == '[') {
                // push the current state
                countStack.push(k);
                stringStack.push(current);

                // reset for next segment
                k = 0;
                current = "";
            }
            else if (ch == ']') {

                int repeat =  (Integer)countStack.pop();//pop most recent number before ]
                String previous = String.valueOf(stringStack.pop());//pop recent stored expression(variable)

                // build the repeated string
                StringBuilder sb = new StringBuilder(previous);
                for (int j = 0; j < repeat; j++) {
                    sb.append(current);
                }
                current = sb.toString();
            }
            else {
                // normal letter  add to current
                current += ch;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("2[3[a]]"));
    }
}



