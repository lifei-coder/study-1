package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * -XX:MaxDirectMemorySize：指定DirectMemory容量，不指定则默认与Java堆最大值（-Xmx指定）一样
 *
 * VM args: -Xmx20M -XX:MaxDirectMemorySize=10M
 */

public class _4DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

}
