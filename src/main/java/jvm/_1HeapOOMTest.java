package jvm;


import java.util.ArrayList;

/**
 * VM Args: -Xms20m -Xmx20 -XX:+HeapDumpOnOutOfMemoryError
 * -XX:+HeapDumpOnOutOfMemoryError 有此参数时，在发生堆OOM时会生成dump文件
 */
public class _1HeapOOMTest {

    static class OOMObject {
    }

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
