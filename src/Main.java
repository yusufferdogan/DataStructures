import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //QueueWithStack<Integer> qu = new QueueWithStack<>();
//        Stack<Integer> stack = new Stack<>();
//        stack.push(3);
//        System.out.println(stack);
//        stack.push(5);
//        System.out.println(stack);
//        stack.push(7);
//        System.out.println(stack);
//        stack.pop();
//        System.out.println(stack);
//        stack.pop();
//        System.out.println(stack);
//        System.out.println("\n------------------------\n");
//
//        StackWithQueue<Integer> queue = new StackWithQueue<>();
//        queue.push(3);
//        queue.push(5);
//        queue.push(7);
//        queue.print();
//        queue.pop();
        mySingleLinkedList<Integer> list = new mySingleLinkedList<>();
        //mySingleLinkedList<Integer>.myIterator it = list.iterator();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);
        list.print();
        list.swap();
        list.print();

    }

}