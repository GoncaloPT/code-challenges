package pt.goncalo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Reducing {

    /**
     * Can reduce identity and accumulator have different types?
     */

    public void reduceIt(){
        var strings = Stream.of("a","b");
        //doesn't work: strings.reduce(1,(x1,x2)-> x1.concat(x2));
        String result = strings.reduce("", String::concat);
        System.out.println(result);
    }

    /**
     * if i have int i = stream<Integer>.reduce() does it unbox?
     */
    public void doesReduceAutoUnbox(){

        Stream<Integer> stream = Stream.of(1,2,3);
        int result = stream.parallel().reduce(1,Integer::sum, (x,y)-> x*y);
        System.out.println(result);
        Predicate<String> a = String::isEmpty;
        a = a.or((e) -> false);
        a.test("hello");
    }

    static int add(int i1, int i2){
        return i1 + i2;
    }
    public void reduceWithDifferentTypes(){
        Data d1 = new Data(1);
        Data d2 = new Data(2);
        int result = Stream.of(d1,d2)
                .reduce(0, (data1,data2)-> data1.number + data2);


    }

    public static void main(String[] args) {
        var r = new Reducing();
        r.reduceIt();
        r.doesReduceAutoUnbox();
    }



    public static class Data{
        int number;

        public Data(int number) {
            this.number = number;
        }
    }
}
