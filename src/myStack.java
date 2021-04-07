public class myStack<E> {
    private E[] arr;
    private int capacity = 3;
    private int size = 0;

    public myStack() {
        capacity = 10;
        arr = (E[]) new Object[capacity];
    }

    public E peek() {
        return arr[size - 1];
    }

    public E pop() {
        E element = arr[size - 1];
        size--;
        return element;
    }

    //unchecked//
    public void push(E element) {
        if (size + 1 >= capacity) {
            capacity *= 2;
            E[] newarr = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newarr[i] = arr[i];
            }
            arr = newarr;
        }
        arr[size] = element;
        size++;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    public void remove(E element) {
        E[] newarr = (E[]) new Object[capacity];
        int k = 0;
        int index = indexOf(element);
        for (int i = 0; i < size; i++) {
            if (i == index)
                continue;
            newarr[k++] = arr[i];
        }
        arr = newarr;
        size--;
        //return element;
    }

    public E reversePeek() {
        return arr[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String res = "[ ";
        for (int i = 0; i < size; i++) {
            res += arr[i] + " ";
        }
        res += "]\n";
        return res;
    }


    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.equals(b)) return true;
        if (a.length() != b.length()) return false;

        int len = a.length();
        myStack<Character> stack = new myStack<>();
        myStack<Character> stack2 = new myStack<>();
        for (int i = 0; i < len; i++) {
            stack.push(a.charAt(i));
            stack2.push(b.charAt(i));
        }

        for (int i = 0; i < len; i++) {
            System.out.println("i:" + i);
            System.out.println("string:" + b);
            System.out.println("Stack:" + stack);
            System.out.println("Stack2:" + stack2);
            System.out.println("\n-------------------------");
            if (stack2.contains(stack.peek())) {
                if (stack.isEmpty()) return false;
                stack2.remove(stack.pop());
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
