package pt.goncalo.freeroam.interfaces;

public interface Foo {
    abstract void methodA();
    void methodB();
    static void methodC(){

    }
}

abstract class Bar implements Foo{
    @Override
    public abstract void methodB();


}
