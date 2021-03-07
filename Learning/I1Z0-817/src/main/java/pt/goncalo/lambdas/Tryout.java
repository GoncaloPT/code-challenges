package pt.goncalo.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Tryout {

    int hello;

    public Tryout(int hello) {
        this.hello = hello;
    }

    void anonymousOnLambda() {
        UnaryOperator<String> f = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return null;
            }
        }::apply;

        Integer[] array = {1, 2};
        Arrays.sort(array, Integer::compare);

        Function<String,Object> func = String::toUpperCase;
    }

    static void paralelStreamReduce() {
        List<Integer> integerList = List.of(2, 3);
        int i = integerList
                .parallelStream()
                .reduce(1, Integer::sum, (l, r) -> l * r);
        System.out.println("result " + i);
    }

    @FunctionalInterface
    interface FunctionOne {
        String m();
        //String m(String a);

        default String m(int a) {
            return "a";
        }
    }

    void printProduced(FunctionOne one) {
        System.out.println(one.m());
    }

    void forEachClosure() {

        //FunctionOne stringProducer = () -> "ola";
        Stream<String> fStream = Stream.of("ola", "Adeus");
        fStream.noneMatch(x -> x.contains("a"));

        /// foreach variables are effective final
        for (String f : fStream.collect(Collectors.toList())) {
            printProduced(() -> f);
        }
        String[] arrayOfF = fStream.toArray(String[]::new);
        for (int i = 0; i < arrayOfF.length; i++) {
            final var a = i;
            printProduced(() -> arrayOfF[a]);
        }



    }

    interface Calculable{
        long calculate(int i);

    }

    void exceptionOnLambda(){
        Calculable function = (final var integer)-> {
            return integer+1;
        };

        BinaryOperator<String> a = ( aa,  bb)->{
            return "";
        };

        Long object = function.calculate(1);
    }

    public static void main(String[] args) {
        //paralelStreamReduce();




        Student s1 = new Student("Joao1", 7);
        Student s2 = new Student("Joao2", 9);
        Student s3 = new Student("Joao3", 8);
        Student s4 = new Student("Joao4", 8);

        Stream<Student> students = Stream.of(s1, s2, s3, s4);
        Supplier<Void> test = () -> null;


        Function<String, Student> school = Student::new;

        BiFunction<String, Double, Student> otherFunction = Student::new;


        ToDoubleFunction<Student> f = Student::getMark;

        Map<Double, List<Student>> map = students.collect(Collectors.groupingBy(Student::getMark));

        map.forEach((Double mark, List<Student> studentsList) -> {
            System.out.println("A: " + mark);
            System.out.println("B: " + studentsList);
            double ave = studentsList.stream().collect(Collectors.averagingDouble(f));
            System.out.println(ave);
            System.out.println("=============");
        });
    }


}


