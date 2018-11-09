package exercise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class test01 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        String str = "hello";
        list.add(1);
        list.add(2);

        Method[] methods = list.getClass().getMethods();
//        for (Method m : methods) {
//            System.out.println(m.getName());
//        }
        methods[1].invoke(list, str);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
