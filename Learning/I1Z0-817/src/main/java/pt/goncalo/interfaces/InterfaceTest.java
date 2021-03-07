package pt.goncalo.interfaces;

public class InterfaceTest implements Interface1,Interface2 {
    public int theMethod(){
        //using this would result in error since the reference is ambiguous
        //return theValue;

        Interface1.imStatic();
        return Interface2.theValue;
    }
    public String imStatic(){
        return "hello";
    }

    public static void main(String[] args) {
        Interface1 test = new InterfaceTest();
        // this fails
        //System.out.println(test.imStatic());
    }


    static class AnotherTest implements Interface3{



        @Override
        public void m() {

        }
    }
}
