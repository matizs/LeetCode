import java.util.Stack;

public class LiveCoding3 {
    public static void main(String...msg) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
class Queue {
    Stack stack = new Stack();
    Stack tempStack = new Stack();

    public Object poll() {
        int size = tempStack.size();
        if(size == 0 ) {
            Stack temp = tempStack;
            tempStack = stack;
            stack = temp;
        }
        return tempStack.pop();
    }

    public void add(Object data) {
        stack.add(data);
    }
}