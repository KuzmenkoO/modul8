package homeWork8;

import java.util.Arrays;

class MyArrayList<T> {
    private T[] elementData = (T[]) new Object[10];
    private int size = 0;

    public void add(T value) {
        if (size < elementData.length) {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null) {
                    elementData[i] = value;
                    break;
                }
            }
        } else {
            this.elementData = Arrays.copyOf(elementData, elementData.length * 2);
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null) {
                    elementData[i] = (T) value;
                    break;
                }
            }
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public void remove(int index) {
        if (index >= 0 && index < elementData.length) {
            elementData[index] = null;
            for (int i = index; i < this.size; i++) {
                if (elementData[i] == null && i < elementData.length - 1) {
                    elementData[i] = elementData[i + 1];
                    elementData[i + 1] = null;
                }
            }
            this.size--;
        }
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return elementData[index];
    }

    public void clear() {
        this.elementData = (T[]) new Object[10];
        this.size = 0;
    }

    @Override
    public String toString() {
        elementData = Arrays.copyOf(elementData, size);
        return Arrays.toString(elementData);
    }
}

class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 1; i <= 5; i++) {
            myArrayList.add(i);
        }
        System.out.println((myArrayList) + "  " + myArrayList.size());
        for (int i = 6; i <= 10; i++) {
            myArrayList.add(i);
        }
        myArrayList.add(100);
        System.out.println(myArrayList + "  " + myArrayList.size());
        for (int i = 11; i <= 15; i++) {
            myArrayList.add(i);
        }
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(15));
        System.out.println(myArrayList + "  " + myArrayList.size());

        System.out.println(myArrayList.size());

        System.out.println(myArrayList.get(21));


        myArrayList.remove(25);

        myArrayList.remove(5);
        System.out.println(myArrayList + "  " + myArrayList.size());
        myArrayList.clear();
        System.out.println(myArrayList);
        System.out.println(myArrayList + "  " + myArrayList.size());
    }
}
