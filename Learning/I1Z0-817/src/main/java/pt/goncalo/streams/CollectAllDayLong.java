package pt.goncalo.streams;

import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectAllDayLong {

    void parallelCollect() {
        Stream<String> names = Stream.of("Gonçalo", "Samuel");


        // 1st value of collect is the initial value
        // 2nd is the accumulator, a BiConsumer take receives the current value and the current accumulation result
        // 3rd value the combiner. Do remember that this is also a BiConsumer. Therefore no value is returned from this function.
        //  The result that gets returned to the collect() caller is the value from a in combiner (a,b) -> ()
        StringBuilder build = names
                .parallel()
                .collect(StringBuilder::new, StringBuilder::append, (StringBuilder a, StringBuilder b) -> {
                            System.out.println("a is " + a.toString());
                            System.out.println("b is " + b.toString());
                            System.out.println("b.append(a).toString(); is " + b.append(a).toString());
                            a.append("rightBranch");
                        }
                );
        System.out.println(build.toString());
    }

    /**
     * why does
     * List.of("a","b").stream().collect(String::new, String::concat, String::concat)
     * produces an empty string and not ab
     * <p>
     * Response:
     * <p>
     * As you know........ String is immulatble, therefore string.concat results a new string. Since
     * accumulator ( the 2nd argument of collect ) is a BiConsumer then the result string ( which has both values )
     * is lost
     */
    void collectWithNewSupplier() {
    /*    String result = List.of("a","b").stream().collect(String::new, String::concat, String::concat);
        System.out.println("result is : " + result);
*/
        Supplier<String> supplier = () -> {
            System.out.println("called supplier");
            return "";
        };

        BiConsumer<String, String> accumulator1 = (element, tempResult) -> {
            System.out.println("element is " + element);
            System.out.println("tempResult is " + tempResult);
            element = element.concat(tempResult);
        };

        String result2 = List.of("a", "b").stream().collect(supplier, accumulator1, String::concat);
        System.out.println("result2 is : " + result2);

    }

    // count() and counting always return Long!!!
    void collectorsCounting() {
        List<Integer> l1 = List.of(1);
        List<Integer> l2 = List.of(1, 2);
        Collection<Long> result =
                Stream.of(l1, l2).collect(Collectors.groupingBy(List::size, Collectors.counting())).values();
    }


    void collectLists(){
        List<Integer> l1 = List.of(1);
        List<Integer> l2 = List.of(1,2);
        List<Integer> l3 = List.of(2,3);
        List<Integer> l4 = List.of(3,4,5);

        Collection<Long> result = Stream.of(l1,l2,l3,l4)
        .collect(Collectors.groupingBy(List::size, Collectors.counting()))
        .values();
        System.out.println("result is " + result);
    }



    public static void main(String[] args) {
        //new CollectAllDayLong().parallelCollect();
        new CollectAllDayLong().collectLists();
    }
}
// The Collectors.counting method returns a Collector object
// This means the result variable is of type Collection.