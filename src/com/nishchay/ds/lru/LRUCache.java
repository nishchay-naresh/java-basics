package com.nishchay.ds.lru;

import java.util.HashMap;

class LRUCache {

    private HashMap<Integer, Node> map;
    private int cacheSize;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.cacheSize = capacity;
        map = new HashMap<>(cacheSize);
        head = tail = null;
    }


    /*This method will delete node*/
    public void deleteNode(Node deletingNode) {
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
    public void addToHead(Node newNode) {
        newNode.next = head;
        newNode.prev = null;

        if (head != null)
            head.prev = newNode;

        head = newNode;

        if (tail == null)
            tail = head;
    }


    // This method works in O(1)
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    // This method works in O(1)
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            // update the old value
            Node old = map.get(key);
            old.value = value; // updating value in node is sufficient for update, no need to do map.put(updated value) again
            deleteNode(old);
            addToHead(old);
        } else {
            // insert as a new value
            Node newNode = new Node(key, value);
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

	public void printCacheHM() {
		System.out.println("map - " + map);
	}
} 

