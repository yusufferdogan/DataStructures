import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(5);
//        list.add(7);
//        ListIterator<Integer> ito = list.listIterator();
//        ito.add(990);
//        ito.add(333);
//        list.add(-1);
//        ListIterator<Integer> ito2 = list.listIterator();
//        while (ito2.hasNext()) {
//            System.out.println(ito2.next());
//        }
//        System.out.println("--------------------------------------------------------------");

        myDoubleLinkedList<Integer> dList = new myDoubleLinkedList<>();
        myDoubleLinkedList<Integer>.iterator it = dList.iterator();

        dList.add(0);
        dList.add(1);
        dList.add(2);
        dList.add(3);
        dList.add(0,-99);

//        dList.print();
        it.begin();
        for (int i = 0; i < dList.size(); i++){
            System.out.println(it.next());
        }
    }


//        mySingleLinkedList<Integer> list = new mySingleLinkedList<>();
//        list.add(3);
//        list.add(5);
//        list.add(7);
//        list.add(9);
//        list.print();
//        list.addAfter(list.getNode(2), -1);
//        list.print();
//        list.addFirst(99);
//        list.print();
//        list.removeFirst();
//        list.print();
//        list.removeFirst();
//        list.print();
//        list.removeAfter(list.getHead());
//        list.print();


}
