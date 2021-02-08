package homeWork8;

import java.util.Arrays;

public class MyStack<E> {
    private E[] element;
    private int size;
    private final int capacity = 1;

    public MyStack() {
        this.element = (E[]) new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean clear() {
        this.element = (E[]) new Object[capacity];
        this.size = 0;
        return true;
    }

    public void push(Object value) {
        addHead((E) value);
        this.size++;
    }

    private void addHead(E value) {
        if (size >= element.length) {
            element = Arrays.copyOf(element, element.length + 1);
        }
        element[size] = value;
    }

    public boolean remove(int index) {

        if (index < size && index >= 0) {
            element[index] = null;
            for (int i = 0; i < this.size - 1; i++) {
                if (element[i] == null) {
                    element[i] = element[i + 1];
                    element[i + 1] = null;
                }
            }
            this.element = Arrays.copyOf(element, element.length - 1);
            this.size--;
            return true;
        }
        return false;
    }

    public E peek() {
        if (size != 0) {
            return element[size - 1];
        }
        return null;
    }

    public E pop() {
        E lastElement = peek();
        remove(size - 1);
        return lastElement;
    }

    @Override
    public String toString() {
        return Arrays.toString(element);
    }
}

class Test {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        System.out.println(stack);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.remove(3));
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.remove(3));
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.remove(0));
        System.out.println(stack);
        System.out.println(stack.clear());
        System.out.println(stack);


    }
}
