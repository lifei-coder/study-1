package geektime.designpattern.代理模式;

public class Hello implements HelloInterface{

    public void sayHello(String name) {
        System.out.println("实现hello: " + name);
    }

    public void sayGoodBye(String name) {
        System.out.println("实现sayGoodBye: " + name);
    }
}
