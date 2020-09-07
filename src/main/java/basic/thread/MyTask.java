package basic.thread;

import java.util.concurrent.Callable;

public class MyTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        int i = 0;
        while (true) {
            System.out.println(String.format("i=, %s", i));
            i++;
            if (i>10) break;
        }
        return String.valueOf(i);
    }
}
