package com.nishchay.ds.lru;

import java.util.HashMap;

public class LRUCache<K, V> {

    static class Node<K, V> {

        final K key;
        V value;
        Node<K, V> next, prev;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = prev = null;
        }

        @Override
        public String toString() {
            return key + "->" + value;
        }

    }

    private HashMap<K, Node<K, V>> map;
    private int cacheSize;
    private Node<K, V> head, tail;

    public LRUCache(int capacity) {
        this.cacheSize = capacity;
        map = new HashMap<>(cacheSize);
        head = tail = null;
    }


    /* This method will delete a node from doubly link list takes node as in input */
    private void deleteNode(Node<K, V> deletingNode) {

        // first node - from head
        if(deletingNode.prev == null){
            head = deletingNode.next;
            deletingNode.next.prev = deletingNode.prev;
        // last node - from tail
        }else if(deletingNode.next == null){
            tail = deletingNode.prev;
            deletingNode.prev.next = deletingNode.next;
        // deleting from middle
        }else{
            deletingNode.next.prev = deletingNode.prev;
            deletingNode.prev.next = deletingNode.next;
        }

    }

    // same method logic as above, hut above one is easy to understand
    private void deleteNode1(Node<K, V> deletingNode) {
        if (deletingNode.prev != null) {
            deletingNode.prev.next = deletingNode.next;
        } else {
            head = deletingNode.next;
        }

        // last node - from tail
        if (deletingNode.next != null) {
            deletingNode.next.prev = deletingNode.prev;
        } else {
            tail = deletingNode.prev;
        }
    }

    /*This method will make passed node as head*/
    private void addToHead(Node<K, V> newNode) {
        newNode.next = head;
        newNode.prev = null;

        if (head != null)
            head.prev = newNode;

        head = newNode;

        if (tail == null)
            tail = head;
    }


    // This method works in O(1)
    public V get(K key) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return null;
    }

    // This method works in O(1)
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            // update the old value
            Node<K, V> oldEntry = map.get(key);
            oldEntry.value = value; // updating value in node is sufficient for update, no need to do map.put(updated value) again
            deleteNode(oldEntry);
            addToHead(oldEntry);
        } else {
            // insert as a new value
            Node<K, V> newNode = new Node<>(key, value);
            evictIfNeeded();
            addToHead(newNode);
            map.put(key, newNode);
        }
    }

    private void evictIfNeeded() {
        if (map.size() >= cacheSize) {
            // remove from tail - oldest entry
            map.remove(tail.key);
            deleteNode(tail);
        }
    }


    @Override
    public String toString() {
/*        return "LRUCache{" +
                "map=" + map +
                '}';*/

        StringBuilder sb = new StringBuilder("LRUCache{");

        String delim = " head => ";
        for (Node p = head; p != null; p = p.next) {
            sb.append(delim);
            sb.append(p.toString());
            delim = ", ";

        }
        sb.append(" }");
        return sb.toString();
    }
}

