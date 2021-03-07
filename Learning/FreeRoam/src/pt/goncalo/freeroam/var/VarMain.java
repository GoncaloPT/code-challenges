package pt.goncalo.freeroam.var;

import java.util.LinkedList;

public class VarMain {


    public static void varOnObjectList(){
        var testList = new LinkedList<>();
        testList.add("ad");
        testList.add(new Object());

        for(Object o: testList){
            System.out.println("object:" + o);
        }
    }

    public static void main(String [] args){
        varOnObjectList();
    }
}
