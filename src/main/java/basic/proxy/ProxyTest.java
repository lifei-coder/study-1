package basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {

    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            TraceHandler traceHandler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, traceHandler);
            elements[i] = proxy;
        }
        // 定义一个随机数
        Integer key = new Random().nextInt(elements.length) + 1;
        int result = Arrays.binarySearch(elements, key);
        if (result >= 0)
            System.out.println(elements[result]);
    }
}


class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object t) {
        this.target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        // 打印方法名
        System.out.print("." + method.getName() + "(");
        // 打印明确参数
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
                if (i < args.length - 1)
                    System.out.print(",");
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}



