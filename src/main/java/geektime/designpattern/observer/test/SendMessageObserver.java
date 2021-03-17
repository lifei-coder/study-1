package geektime.designpattern.observer.test;

import geektime.designpattern.observer.Subscrible;

/**
 * @author lifei1@songguo7.com
 * @date 2021/3/17 20:12
 */
public class SendMessageObserver {

    @Subscrible
    public void handleSendMessage(Long userId) {
        System.out.println("给用户" +userId + " 发送消息 ");
    }

}
