package pt.goncalo.lambdas;

public class DefaultsAndFuntionalInterfaces {

    @FunctionalInterface
    interface TestingDefault{
        int calculate(int i, int j);

        default int sum(int i, int j){
            return i+j;
        }

    }


    public static void main(String[] args) {
        TestingDefault multiply = (i,j)-> i*j;


        System.out.println("multiply 1*2 is " + multiply.calculate(1,2));
        System.out.println("sum 1+2 is " + multiply.sum(1,2));
    }
}
