package java8;
/**
 *@ClassName LambdaTest
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/8 18:41
 *@Version 1.0
 */
public class LambdaTest{

    public static void main(String[] args) {
   /*     Runnable run = new Runnable(){
            @Override
            public void run() {
                System.out.println("AAA");
            }
        };
        run.run();

        new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名子类匿名对象");
            }
        }.run();*/

        //用Lambda表达式以后可以这些写
        Runnable run1=()->{
            System.out.println("aaa");
        };

        new Thread(run1).start();
        run1.run();

    }
}

