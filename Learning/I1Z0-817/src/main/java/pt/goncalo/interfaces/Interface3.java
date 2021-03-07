package pt.goncalo.interfaces;

public interface Interface3 extends Interface1{
    default String getName(){
        return "Interface1";
    }
}
