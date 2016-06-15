package base;


public class ThrowablesDemo {

    public static void checked() throws Throwable{
        throw new Exception();
    }

    public static void runtime() throws Throwable{
        throw new RuntimeException();
    }

    public static void error() throws Throwable{
        throw new Error();
    }

    public static void main(String[] args){
        //
    }
}
