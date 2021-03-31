public class Main {
    public static void main(String[] args) {

        mySingleLinkedList<Integer> list = new mySingleLinkedList<>();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.print();
        list.addAfter(list.getNode(2), -1);
        list.print();
        list.addFirst(99);
        list.print();
        list.removeFirst();
        list.print();
        list.removeFirst();
        list.print();
        list.removeAfter(list.getHead());
        list.print();





    }
}
