package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifei1@songguo7.com
 * @date 2022/3/4 下午11:46
 */
public class _93LRUCacheTest {

    static class Node {
        public Node pre;
        public Node next;

        public String key;
        public String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LruCache {
        public Node head;
        public Node tail;
        public int length;
        public Map<String, Node> map;

        public LruCache(int size) {
            map = new HashMap<>();
            head = new Node("null", "null");
            tail = new Node("null", "null");
            length = size;
            head.next = tail;
            tail.pre = head;
        }

        public void put(String key, String value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                refresh(node);
                return;
            } else {
                if (map.size() == length) {
                    Node last = tail.pre;
                    map.remove(last.key);
                    delete(last);
                }
            }
            Node newNode = new Node(key, value);
            map.put(newNode.key, newNode);
            refresh(newNode);
        }

        private void delete(Node node) {
            if (node.pre != null) {
                Node left = node.pre;
                Node right = node.next;
                left.next = right;
                right.pre = left;
            }

        }

        private void refresh(Node node) {
            delete(node);
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            node.pre = head;
        }

        public String get(String key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                refresh(node);
                return node.value;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(4);
        lruCache.put("1", "lifei1");
        lruCache.put("2", "lifei2");
        lruCache.put("3", "lifei3");
        lruCache.put("4", "lifei4");
        lruCache.put("5", "lifei5");
        lruCache.get("2");
        Node cur = lruCache.head.next;
        while (cur != null) {
            System.out.printf("key: " + cur.key + ", value:" + cur.value);
            System.out.println("   \n");
            cur= cur.next;
        }

    }

}
