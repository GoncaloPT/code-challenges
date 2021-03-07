package pt.goncalo.interfaces;

public interface DefaultMethodInterface {
    int i = 0;
    default int m(){
        return i;
    }

    default int m2(){
        return 0;
    }
}
