package pt.goncalo.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapDoubts {


    /**
     * What does Map.compute does
     */
    public void computeWhat(){
        // It's no compile error to declare Map like this:
        Map map = new HashMap<>();
        map.put("nome","Gonçalo");

        map.compute("nome2", (k,v) -> v == null? "was empty":v);
        map.forEach((k,v) -> System.out.println("key: " + k + " value " + v ));


    }

    public static void main(String[] args) {
        new HashMapDoubts().computeWhat();
    }
}
