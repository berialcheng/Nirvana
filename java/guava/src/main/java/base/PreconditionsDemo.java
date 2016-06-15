package base;

import com.google.common.base.Preconditions;


public class PreconditionsDemo {

    public static void method(String arg, boolean state, double calc){
        Preconditions.checkNotNull(arg, "arg should not be null");
        Preconditions.checkState(state, "state not correct , actual is %s", "A");
        Preconditions.checkArgument(calc > 1.0, "calc less than 1.0");
        //Preconditions.checkElementIndex()
    }

    public static void main(String[] args){
        //method(null, true, 1.1);
        //method("", false, 1.1);
        method("", true, 0.9);
    }
}
