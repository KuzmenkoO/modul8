package homeWork8;

import java.util.Objects;

public class MyHashMap<K, V> {
    private static float loadFactor = 0.75f;
    private Node<K, V>[] table;
    private int size;
    private float threshold;
    private int capacity = 16;

    public MyHashMap() {
        this.table = new Node[capacity];
        this.size = 0;
        this.threshold = loadFactor * table.length;
    }

    private static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        for (Node<K, V> el : table) {
            el = null;
        }
        this.table = new Node[capacity];
        this.size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            putForNullKey(value);
            return;
        }
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        addNode(key, value, hash, index);
    }

    public V get(K key) {
        for (Node<K, V> node : table) {
            if (node != null && node.key.equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    public void remove(Object key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].key.equals(key)) {
                table[i]= table[i].getNextNode();
                table[size]=null;
                size--;
            }
        }
    }

    private void addNode(K key, V value, int hash, int index) {
        Node<K, V> newNode = new Node<>(hash, key, value, null);
        Node<K, V> prevNode = table[index];
        if (prevNode == null) {
            table[index] = newNode;
        } else {
            do {
                if (prevNode.hash == hash && (prevNode.key == key || key.equals(prevNode.key))) {
                    prevNode.value = value;
                    return;
                }
                if (prevNode.getNextNode() != null) {
                    prevNode = prevNode.getNextNode();
                } else {
                    break;
                }

            } while (prevNode != null);
            newNode.setNextNode(prevNode);
        }
        size++;
    }

    private void putForNullKey(V value) {
        addNode(null, value, 0, 0);
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Node<K, V> n : table) {
            if (n != null) {
                result.append(n.toString()).append(", ");
            }
        }

        return result.toString();
    }

    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> nextNode;

        public Node(int hash, K key, V value, Node<K, V> nextNode) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.nextNode = nextNode;
        }

        public final K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public final V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public int hashCode() {
            return Objects.hash(key, value);
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return this.key == node.key && Objects.equals(this.value, node.value);
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public Node<K, V> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<K, V> nextNode) {
            this.nextNode = nextNode;
        }
    }
}

