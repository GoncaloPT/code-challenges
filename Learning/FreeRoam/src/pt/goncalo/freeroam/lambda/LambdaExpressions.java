package pt.goncalo.freeroam.lambda;

public class LambdaExpressions {

    private interface Hashable{
        int hash(Object o,Integer i, String... a);
    }


    /**
     * Functional interfaces params must match. Only exception is ... = []
     */
    public static void MustMatchParams(){
        Hashable hash1 = (Object o, Integer i, String [] a) -> o.hashCode() +i+a.length;
        //Hashable hash2 = (Object o, int i, String... a) ->o.hashCode() +i+a.length;
        //Hashable hash3 = (String o, Integer i, String... a) ->o.hashCode() +i+a.length;
    }

    interface Omg{
        int m();
    }
    public static void main(String [] args){


    }


    /*
        question 2
     */
    interface Payback<T>{
        T apply(T origin, T rate);
    }

    static void calculate(Double origin, Double rate, Payback<Double> func){
        double payback = func.apply(origin,rate);
        System.out.println(payback);
    }
//    public static void methodReferenceDoubt(){
//        double origin = 1000;
//        double rate = 0.1;
//        calculate(origin, rate, new Payback<Double>() {
//            @Override
//            public Double apply(Double origin, Double rate) {
//                return origin * (1+rate);
//            }
//        }::apply);
//
//        calculate(origin, rate, (Double origin2, Double rate2) -> {
//                return origin2 * (1+rate2);
//            }
//        });
//    }
}
