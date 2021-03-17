package geektime.designpattern.observer.test;

import geektime.designpattern.observer.EventBus;

/**
 * @author lifei1@songguo7.com
 * @date 2021/3/17 20:03
 */
public class UserController {

    public static LoginObserver loginObserver = new LoginObserver();
    public static SendMessageObserver sendMessageObserver = new SendMessageObserver();

    public static EventBus eventBus = new EventBus();

    static {
        eventBus.register(loginObserver);
        eventBus.register(sendMessageObserver);
    }


    public static void main(String[] args) {

        Long userId = 112L;
        System.out.println(userId + " 模拟用户登录.");

        // 告知观察者执行
        eventBus.post(userId);


    }
}
