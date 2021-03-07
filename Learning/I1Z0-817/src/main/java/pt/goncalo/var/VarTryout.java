package pt.goncalo.var;

import java.util.ArrayList;

public class VarTryout {

    /**
     * Doubt was: can i declare a var var = ?
     */
    public void declaration(){
        var var = new ArrayList<>();
        var.add("String");
        var.add(1);
        var.forEach(System.out::println);
        var a = var.get(0);
        var b = var.get(1);
    }
    void changeAfterAssignment(){
        var integer = 1;
        // int to float change doesn't compile
        //integer = 10/2.2;
        var anObject = new VarTryout();
        // Object type to other object type doesn't work
        //anObject = "a";

        var dummyComparable = new Comparable<String>(){
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };
        // Even String being a subtype ( implementation ) of Comparable, the attribution to string is not allowed
        //dummyComparable = "a";
    }

    public static void main(String[] args) {
        new VarTryout().declaration();
    }
}
