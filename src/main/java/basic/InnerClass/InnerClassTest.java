package basic.InnerClass;

public class InnerClassTest {

    public static void main(String[] args) {
        PersonPrinter personPrinter = new PersonPrinter(18, '男', "大学本科");
        personPrinter.printPerson();
    }

}

// 这不是内部类，只是为了少写一个main方法的java文件
class PersonPrinter {

    private int age;
    private char sex;
    private String degree;

    public PersonPrinter(int age, char sex, String degree) {
        this.age = age;
        this.sex = sex;
        this.degree = degree;
    }

    public void printPerson(){
        Worker worker = new Worker();
        worker.workerInfo();
    }

    // an inner class
    public class Worker{
        public void workerInfo(){
            if (age >= 18) {
                System.out.println("我是一名工人, age:" + age);
            } else {
                System.out.println("我是一名小孩子, age:" + age);
            }
        }
    }

}
