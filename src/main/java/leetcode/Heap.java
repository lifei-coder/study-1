package leetcode;


public class Heap {
    private int[] a;
    private int capacity;
    private int count; // 已经存在数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }


    public void inset(int data) {
        if (count >= capacity) return;
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) {
            swap(a, i, i/2);
            i = i/2;
        }
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
