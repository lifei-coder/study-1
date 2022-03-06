package leetcode;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lifei1@songguo7.com
 * @date 2021/7/26 15:51
 * 按层打印二叉树
 */
public class PrintTree {

    private static Node root = new Node();

    static {
        root.setVal(0);
        Node leftLevel1 = new Node();
        leftLevel1.setVal(1);
        Node leftLevel2 = new Node();
        leftLevel2.setVal(11);
        Node leftLevel3 = new Node();
        leftLevel3.setVal(111);


        Node rightLevel1 = new Node();
        Node rightLevel2 = new Node();
        Node rightLevel3 = new Node();
        rightLevel1.setVal(2);
        rightLevel2.setVal(22);
        rightLevel3.setVal(222);

        leftLevel1.setLeft(leftLevel2);
        leftLevel2.setLeft(leftLevel3);
        rightLevel1.setRight(rightLevel2);
        rightLevel2.setRight(rightLevel3);

        root.setLeft(leftLevel1);
        root.setRight(rightLevel1);
    }


    public static void main(String[] args) {
        printByLayer(root);
        System.out.println("-----------------------");
//        getNLayerNode(root, 1);
        getNLayerNode2(root, 2);
    }

    private static void printByLayer(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.println(current.val + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void getNLayerNode(Node root, int n) {
        LinkedList<Node> curQueue = new LinkedList<>();
        curQueue.offer(root);
        LinkedList<Node> nextQueue = new LinkedList<>();
        int lvl = 1;
        while (lvl != n) {
            Node current = null;
            while (!curQueue.isEmpty()) {
                current = curQueue.poll();
                if (current.left != null) {
                    nextQueue.offer(current.left);
                }
                if (current.right != null) {
                    nextQueue.offer(current.right);
                }
            }
            curQueue = nextQueue;
            nextQueue = new LinkedList<>();
            lvl++;
        }

        System.out.println(curQueue);
    }

    public static void getNLayerNode2(Node root, int n) {
        LinkedList<Node> curQueue = new LinkedList<>();
        curQueue.offer(root);
        while (!curQueue.isEmpty()) {
            int level = 1;
            while (level <= n) {
                int size = curQueue.size();
                for (int i = 0; i < size; i++) {
                    Node node = curQueue.poll();
                    if (level == n) {
                        System.out.println(node.val);
                    }
                    if (node.left != null) {
                        curQueue.offer(node.left);
                    }
                    if (node.right != null) {
                        curQueue.offer(node.right);
                    }
                }
                level++;
            }
            break;
        }
    }
}

@Data
class Node{
    int val;
    Node left;
    Node right;
}


