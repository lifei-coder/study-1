package geektime.designpattern.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 代理模式：它在不改变原始类（或者叫被代理类）代码的情况下，通过引入代理类来给原始类附加功能。
 * 代理模式在平时的开发经常被用到，常用在业务系统中开发一些非功能性需求，比如：监控、统计、鉴权、限流、事务、幂等、日志。
 *
 * 这里的要点有：
 * 1.必须有一个接口，因为Proxy.newProxyInstance参数要求是接口。
 * 2.代理目标对象必须实现这个接口
 * 3.转换成接口层面调用代理方法。
 *
 */
public class TestMain {

    public static void main(String[] args) {

        Hello hello = new Hello();
        // 这里的InvocationHandler是用匿名内部类的方式实现。也可以单独抽离出来一个类实现InvocationHandler接口
        Object proxyInstance = Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("代理中....");
                    method.invoke(hello, args);
                    System.out.println("代理完....");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return result;
            }
        });
        HelloInterface IHello = (HelloInterface)proxyInstance;
        IHello.sayHello("李飞");
    }

}
