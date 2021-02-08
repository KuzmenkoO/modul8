package homeWork8;

import java.util.Arrays;

class MyQueue<T> {
    private int size;
    private T[] element;
    private int capacity = 10;

    public MyQueue() {
        this.element = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void add(Object value) {
        addLast((T) value);
        this.size++;
    }

    private void addLast(T value) {
        if (size < element.length) {
            element[size] = value;
        } else {
            element = Arrays.copyOf(element, element.length * 2);
            element[size] = value;
        }
    }

    public int size() {
        return this.size;
    }

    public void remove(int index) {
        if (index <= size && index >= 0) {
            element[index] = null;
            for (int i = 0; i < this.size-1; i++) {
                if (element[i] == null) {
                    element[i] = element[i + 1];
                    element[i + 1] = null;
                }
            }
            this.size--;
        }
    }

    public void clear() {
        this.element = (T[]) new Object[capacity];
        this.size = 0;
    }

    public T peek(){
        return (T) element[0].toString();
    }

    public T pull(){
        T firstElement = element[0];
        remove(0);
        return (T)firstElement.toString();
    }

    @Override
    public String toString() {
        return Arrays.toString(element);
    }
}

class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);
        myQueue.add(9);
        myQueue.add(10);
        System.out.println(myQueue.toString() + " " + myQueue.size());
        myQueue.add(11);
        System.out.println(myQueue.toString() + " " + myQueue.size());
        myQueue.remove(0);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pull());
        System.out.println(myQueue.peek());
        myQueue.add(12);
        myQueue.add(13);
        System.out.println(myQueue.toString() + " " + myQueue.size());
        myQueue.clear();
        System.out.println(myQueue.toString() + " " + myQueue.size());
    }
}



