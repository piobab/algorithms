package com.nectivo.algorithms.datatypes;

/**
 * Created by piobab on 26.05.2014.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            x.left = put(x.left, key, value);
        } else if(cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        return x;
    }

    /**
     * Return value corresponding to given key, or null if no such key.
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    public void delete(Key key) {

    }

    public Iterable<Key> iterator() {
        return null;
    }
}
