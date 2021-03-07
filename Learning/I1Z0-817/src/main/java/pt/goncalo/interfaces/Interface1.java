package pt.goncalo.interfaces;

public interface Interface1 {

    static String getName(){
        return "Interface3";
    }

    int theValue = 1;

    static String imStatic(){
        return "imStatic";
    }
    default void m(){
        System.out.println("I'm on 1");
    }

    /**
     * this is a private method of the interface, it's possible since Java 9
     */
    private void m2(){

    }
}
