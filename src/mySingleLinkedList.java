public class mySingleLinkedList<E> {
    private Node<E> head = null;
    private int size = 0;

    void addFirst(E item) {
        head = new Node<>(item, head);
        size++;
    }

    void addAfter(Node<E> node, E item) {
        if(node.next == null){
            node.next = new Node<>(item);
        }
        else {
            Node<E> temp = node.next;
            node.next = new Node<>(item,temp);
            temp.next = null;
        }
        size++;
    }

    E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp.next != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    public int getSize() {
        return size;
    }

    void print() {
        myIterator<E> it = iterator();
        for (int i = 0; i < getSize(); i++) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n\n");
    }
    public Node<E> getNode(int index) {
        if(head == null){
            return null;
        }
        else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public Node<E> getHead() {
        return head;
    }

    public void set(int index, E element) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = element;
    }

    public boolean add(E anEntry) {
        if (head == null) {
            head = new Node<E>(anEntry, null);
        } else {
            Node<E> temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node<E>(anEntry, null);
        }
        size++;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public myIterator<E> iterator() {
        return new myIterator<E>(0);
    }

    class myIterator<E> {
        Node curNode = head;

        public myIterator(int index) {
            if (index < 0 || index >= getSize()) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            for (int i = 0; i < index; i++) {
                curNode = curNode.next;
            }
        }

        boolean hasNext() {
            return curNode.next != null;
        }

        E next() {
            Node<E> temp = curNode;
            if (hasNext()) {
                curNode = curNode.next;
                return temp.data;
            } else {
                if (temp != null) {
                    return temp.data;
                }
                return null;
            }
        }

    }

    private static class Node<E> {
        Node<E> next;
        public E data;

        private Node(E newData) {
            data = newData;
            next = null;
        }

        private Node(E newData, Node<E> newNode) {
            data = newData;
            next = newNode;
        }
    }
}
