package leetcode;

public class BinarySearchTree {

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    private Node tree;

    public Node find(int data) {
        Node p =  tree;

        while (p != null) {
            if (data == p.data) {
                return p;
            } else if (data < p.data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                if (p.left == null) {
                    p.left = new Node(data);
                }
                p = p.left;
            } else { // data > p.data
                if (p.right == null) {
                    p.right = new Node(data);
                }
                p = p.right;
            }
        }
    }

    public void delete(int data) {
        Node p = tree; // p是需要删除的节点
        Node pp = null; // pp记录p的父节点

        while (p != null && p.data != data) { // 找到需要删除的节点
            pp = p;
            if (data > p.data)
                p = p.right;
            else
                p = p.left;
        }
        if (p == null)
            // 没有需要删除的节点
            return;

        if (p.left != null && p.right != null) {
            Node node = p.right;
            Node Pnode = p;
            while (node.left != null) {
                Pnode = node;
                node = node.left;
            }
            p.data = node.data;
            p = node;
            pp = Pnode;
        }

        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }


        if (pp == null)
            tree = child;
        else if (pp.left == p)
            pp.left = child;
        else
            pp.right = child;

    }




}
