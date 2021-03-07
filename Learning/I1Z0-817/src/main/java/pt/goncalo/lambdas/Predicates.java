package pt.goncalo.lambdas;

import java.util.function.Predicate;

public class Predicates {

    void syntaxTest(){
        Predicate p = (var a) -> (int) a % 2 == 1;


        Object a = new Integer(1);
        // this is invalid
        //boolean isEven = a % 2 == 0;
        boolean isEven = (Integer)a % 2 == 0;
        boolean isEven2 = (int)a % 2 == 0;

        int i = 0;
        double d = 1;
        d = i;

    }

    public static void main(String[] args) {
        new Predicates().syntaxTest();
    }
}
