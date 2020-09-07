package basic;

import java.lang.reflect.InvocationTargetException;

public class test01 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 is running！");
            }
        }).start();

        new Thread(() -> System.out.println("thread2 is running！")).start();

    }

}
