package geektime.designpattern.observer.callback;

/**
 * @author lifei1@songguo7.com
 * @date 2021/3/18 11:10
 */
public class CallbackImpl implements ICallback {

    @Override
    public void methodToCallback() {
        System.out.println("执行回调方法");
    }

}
