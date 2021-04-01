import java.util.*;

public class myDoubleLinkedList<E> {
    int size = 0;

    /**
     * Pointer to first node.
     */
    myDoubleLinkedList.Node<E> head;

    /**
     * Pointer to last node.
     */

    myDoubleLinkedList.Node<E> tail;


    protected myDoubleLinkedList() {
    }

    public void print() {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public void printReverse() {
        Node<E> temp = tail;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.item + " ");
            temp = temp.prev;
        }
        System.out.println("\n");
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        } else {
            Node<E> curNode = head;
            for (int i = 0; i < index; i++) {
                curNode = curNode.next;
            }
            return curNode.item;
        }
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        } else {
            Node<E> curNode = head;
            for (int i = 0; i < index; i++) {
                curNode = curNode.next;
            }
            E oldVal = curNode.item;
            curNode.item = element;
            return oldVal;
        }
    }

    void insertAtHead(E element) {
        if (head == null) {
            tail = new Node<>(null, element, null);
            head = tail;
        } else {
            Node<E> newNode = new Node<>(null, element, head);
            head.prev = newNode;
            head = newNode;
        }
    }

    void insertAtTail(E element) {
        if (tail == null) {
            tail = new Node<>(head, element, null);
            head = tail;
        } else {
            Node<E> newNode = new Node<>(tail, element, null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void add(int index, E element) {
        Node<E> curnode = head;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0) {
            insertAtHead(element);
        } else if (index == size() - 1) {
            insertAtTail(element);
        } else {
            for (int i = 0; i < index - 1; i++) {
                curnode = curnode.next;
            }
            curnode.next = new Node<>(curnode, element, curnode.next);
        }
        size++;
    }

    public void add(E element) {
        insertAtTail(element);
        size++;
    }

    public E remove(int index) {
        return head.item;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E o) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (o.equals(temp)) {
                return true;
            }
        }
        return false;
    }

    public iterator iterator() {
        return new iterator();
    }

    public iterator iterator(int index) {
        return new iterator(index);
    }

    class iterator implements ListIterator<E> {
        private myDoubleLinkedList.Node<E> curNode = head;
        private myDoubleLinkedList.Node<E> next = tail;
        private int index = 0;

        iterator() {

        }

        iterator(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(index);
            } else {
                for (int i = 0; i < index; i++) {
                    curNode = curNode.next;
                    index++;
                }
            }
        }

        void begin() {
            curNode = head;
        }

        void end() {
            curNode = tail;
        }

        @Override
        public boolean hasNext() {
            return curNode.next != null;
        }

        @Override
        public E next() {
            myDoubleLinkedList.Node<E> temp = curNode;
            if (hasNext()) {
                curNode = curNode.next;
                index++;
                return temp.item;
            } else {
                if (temp != null) {
                    return temp.item;
                }
                return null;
            }
        }

        @Override
        public boolean hasPrevious() {
            return curNode.prev != null;
        }

        @Override
        public E previous() {
            myDoubleLinkedList.Node<E> temp = curNode;
            if (hasPrevious()) {
                curNode = curNode.prev;
                index--;
                return temp.item;
            } else {
                if (temp != null) {
                    return temp.item;
                }
                return null;
            }
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {
            myDoubleLinkedList.Node<E> newNode = new Node<>(null, e, null);


        }
    }

    private static class Node<E> {
        E item;
        myDoubleLinkedList.Node<E> next;
        myDoubleLinkedList.Node<E> prev;

        Node(myDoubleLinkedList.Node<E> prev, E element, myDoubleLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
