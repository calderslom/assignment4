package assignment4;

import java.util.LinkedList;
import java.lang.Math;

class HashTable<T extends Hashable> implements HashTableInterface<T> {
    private int hashTableSize;
    private LinkedList<T>[] table;

    public HashTable(int size) {
        hashTableSize = 9973;
        table = new LinkedList[hashTableSize];
        for (int i = 0; i < hashTableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public HashTable() {
    }

    private int hash(int x) { // This portion as per assignment 4 instructions
        x = ((x >>> 16) ^ x) * 0x45d9f3b;
        x = ((x >>> 16) ^ x) * 0x45d9f3b;
        x = (x >>> 16) ^ x;
        return Math.abs(x) % hashTableSize;
    }

    public void clear() {
        for (int i = 0; i < hashTableSize; i++) {
            table[i].clear();
        }
    }

    public void add(T item) {
        int index = hash(item.hashCode());
        table[index].add(item);
    }

    public void remove(T item) {
        int index = hash(item.hashCode());
        table[index].remove(item);
    }

    public boolean contains(T item) {
        int index = hash(item.hashCode());
        return table[index].contains(item);
    }
}