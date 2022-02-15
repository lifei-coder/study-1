package basic;

import java.lang.reflect.InvocationTargetException;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class test01 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 is running！");
            }
        }).start();

        new Thread(() -> System.out.println("thread2 is running！")).start();

//        long time = new Date().getTime()/1000;
//        System.out.println(time);
//
//        System.out.println(getDayOfWeek());

//        System.out.println(doubleTrans(discount));
//        System.out.println(doubleTrans(0.1));
//        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toEpochSecond(ZoneOffset.of("+8")));

        int length = 8;
        int number = 7;
        System.out.println(6 & 7);
    }

//    private static String doubleTrans(double num){
//        String number1 = String.format("%.1f", num);
//        double number2 = Double.parseDouble(number1);//類型轉換
//        if(Math.round(number2)-number2 == 0){
//            return String.valueOf((long)number2);
//        }
//        return String.valueOf(number2);
//    }
}