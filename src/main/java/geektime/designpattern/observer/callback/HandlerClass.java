package geektime.designpattern.observer.callback;

/**
 * @author lifei1@songguo7.com
 * @date 2021/3/18 11:08
 */
public class HandlerClass {

    public void process(ICallback callback) {
        // 前置处理...
        System.out.println("HandlerClass前置处理...");

        callback.methodToCallback();

        // 后置处理...
        System.out.println("HandlerClass后置处理...");
    }
}
