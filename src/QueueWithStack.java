import java.util.Stack;

public class QueueWithStack<E> {
    private Stack<E> stack;

    //private Queue<E> queue;
    QueueWithStack() {
        stack = new Stack<>();
        //queue = new Queue<>();
    }

    public void print() {
        System.out.println(stack);
    }

    public void add(E e) {
        //System.out.println("size:" + stack.size());
        stack.add(e);
    }

    public E element() {
        return stack.elementAt(0);
    }

    public E peek() {
        Stack<E> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.add(stack.peek());
            stack.pop();
        }
        stack.addAll(temp);
        return temp.peek();
    }

    public void pop() {
        Stack<E> temp = new Stack<>();
        int len = stack.size();
        for (int i = 0; i < len-1; i++) {
            temp.add(stack.pop());
        }
        stack.addAll(temp);
        temp.clear();
        while (!stack.isEmpty()) {
            temp.add(stack.peek());
            stack.pop();
        }
        temp.pop();
        stack.addAll(temp);
        print();
    }
}
