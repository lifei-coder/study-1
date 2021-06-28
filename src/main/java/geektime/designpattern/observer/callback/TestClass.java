package geektime.designpattern.observer.callback;

/**
 * @author lifei1@songguo7.com
 * @date 2021/3/18 11:10
 */
public class TestClass {
    public static void main(String[] args) {
        HandlerClass handlerClass = new HandlerClass();
        // 1 通过匿名内部类 或者 lambda表达式
        handlerClass.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("回调函数");
            }
        });

        System.out.println("------------");
        // 2 通过传对象实例
        CallbackImpl callback = new CallbackImpl();
        handlerClass.process(callback);
    }
}
