package basic.InnerClass;

public class AnonymousInnerClassTest {

    public static void main(String[] args) {
        // 匿名内部类方式 创建对象
        // 匿名内部类就是重写父类或接口的方法
        Bird bird = new Bird() {
            @Override
            public int fly() {
                return 1000;
            }

            @Override
            public String getName() {
                return "大雁";
            }
        };
        System.out.println(bird.getName() + "能够飞" + bird.fly() + "米");
    }


}
// 这里可以是普通类或者抽象类
abstract class Bird{
    private String name;
    // 定义一个抽象方法
    public abstract int fly();

    public String getName(){return name;};
    public void setName(String name){this.name = name;}
}