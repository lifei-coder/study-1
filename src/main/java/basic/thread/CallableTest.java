package basic.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task  = new FutureTask(new MyTask());
        new Thread(task).start();
        String result = task.get();
        System.out.println(String.format("result: %s", result));
    }

}
