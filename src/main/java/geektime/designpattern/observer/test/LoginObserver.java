package geektime.designpattern.observer.test;

import geektime.designpattern.observer.Subscrible;

/**
 * @author lifei1@songguo7.com
 * @date 2021/3/17 20:04
 */
public class LoginObserver {

    @Subscrible
    public void handleLogin(Long userId) {
        System.out.println(userId + "  已经用户登录");
    }

}
