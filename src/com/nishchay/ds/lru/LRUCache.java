package com.nishchay.ds.lru;

import java.util.HashMap;

class LRUCache<K,V> {

    static class Node<K,V> {

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
            return key + "->" + value ;
        }

    }

    private HashMap<K, Node<K,V>> map;
    private int cacheSize;
    private Node<K,V> head, tail;

    public LRUCache(int capacity) {
        this.cacheSize = capacity;
        map = new HashMap<>(cacheSize);
        head = tail = null;
    }


    /*This method will delete node*/
    public void deleteNode(Node<K,V> deletingNode) {
        if (deletingNode.prev != null) {
            deletingNode.prev.next = deletingNode.next;
        } else {
            head = deletingNode.next;
        }

        if (deletingNode.next != null) {
            deletingNode.next.prev = deletingNode.prev;
        } else {
            tail = deletingNode.prev;
        }
    }


    /*This method will make passed node as head*/
    public void addToHead(Node<K,V> newNode) {
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
            Node<K,V> node = map.get(key);
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
            Node<K,V> old = map.get(key);
            old.value = value; // updating value in node is sufficient for update, no need to do map.put(updated value) again
            deleteNode(old);
            addToHead(old);
        } else {
            // insert as a new value
            Node<K,V> newNode = new Node<>(key, value);
            if (map.size() < cacheSize) {
                addToHead(newNode);
            } else {
                map.remove(tail.key);
                // remove last node
                deleteNode(tail);
                addToHead(newNode);
            }
            map.put(key, newNode);
        }
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                '}';
    }
}

