package java8;
/**
 *@ClassName FunInterface
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/8 18:26
 *@Version 1.0
 */
@FunctionalInterface
public interface FunInterface{
    public abstract  void sayHello(String message);
}

class MainTest{
    public static void main(String[] args) {
        FunInterface hi = (message) -> {
            System.out.println(message);
        };
        hi.sayHello("你好");
    }

}

