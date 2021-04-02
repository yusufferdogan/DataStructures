import java.util.*;

public class myDoubleLinkedList<E> {
    private int size = 0;

    /**
     * Pointer to first node.
     */
    private myDoubleLinkedList.Node<E> head;

    /**
     * Pointer to last node.
     */

    private myDoubleLinkedList.Node<E> tail;


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

    public E get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("afdsaa");
        } else {
            Node<E> curNode = head;
            for (int i = 0; i < index; i++) {
                curNode = curNode.next;
            }
            return curNode.item;
        }
    }

    private Node<E> node(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
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
        } else if (index == size() - 1 && size > 2) {
            insertAtTail(element);
        } else {
            for (int i = 0; i < index - 2; i++) {
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

    private E unlink(Node<E> x) {
        Node<E> before = x.prev;
        E element = x.item;
        Node<E> after = x.next;
        if (before == null) {
            after.prev = null;
            x.next = null;
            head = after;
        } else if (after == null) {
            before.next = null;
            x.prev = null;
            tail = before;
        } else {
            before.next = after;
            x.next = null;
            x.prev = null;
            after.prev = before;
        }
        x.item = null;
        size--;
        return element;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        } else {
            return unlink(node(index));
        }
    }

    public int indexOf(Node<E> o) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (o.equals(temp)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
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
        private myDoubleLinkedList.Node<E> temp = head;
        private int index = 0;

        iterator() {

        }

        iterator(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(index);
            } else {
                for (int i = 0; i < index-1; i++) {
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
            //return curNode.next != null;
            return index < size;
        }

        @Override
        public E next() {
            temp = curNode;
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
            if (!contains(node(index).item)) {
                throw new NoSuchElementException();
            } else {
                int index = indexOf(temp);
                System.out.println("indexOf:" + index);
                unlink(node(index));
            }
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
