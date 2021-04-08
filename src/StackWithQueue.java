import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackWithQueue<E> {
    private Queue<E> queue;

    StackWithQueue() {
        queue = new LinkedList<>();
    }

    boolean empty() {
        return queue.isEmpty();
    }

//    E peek() {
//
//    }

    E pop() {
        Queue<E> temp = new LinkedList<>();
        int len = queue.size();
        for (int i = 0; i < len-1; i++) {
            temp.add(queue.remove());
        }
        queue.addAll(temp);
        temp.clear();
        while (!queue.isEmpty()) {
            temp.add(queue.peek());
            queue.remove();
        }
        E element = temp.remove();
        queue.addAll(temp);
        print();
        return element;
    }

    E push(E item) {
        queue.add(item);
        return item;
    }

    void print(){
        System.out.println(queue);
    }

//    int search(Object o) {
//
//    }
}
