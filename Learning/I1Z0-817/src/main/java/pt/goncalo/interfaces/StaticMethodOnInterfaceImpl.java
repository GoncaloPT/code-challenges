package pt.goncalo.interfaces;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StaticMethodOnInterfaceImpl implements StaticMethodOnInterface {

    @Override
    public int m2() {
        return 0;
    }


    int m() {
        var v1 = 1L + 1F;

        var result = 0;
        result = 1 / 2;
        return 1;

    }

    /*void another(var a){
        UnaryOperator<String> bb = (var v) -> {
            v = "a";

        };
        Consumer bb2 = (var v) -> {};
    }

    abstract static class MultipleInheritance implements  StaticMethodOnInterface, DefaultMethodInterface{


    }
     */
}
