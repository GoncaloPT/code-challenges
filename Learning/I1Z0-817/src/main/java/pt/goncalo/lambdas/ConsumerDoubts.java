package pt.goncalo.lambdas;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class ConsumerDoubts {

    static class Model{
        final String name;

        public Model(String name) {
            this.name = name;
        }

        /**
         * Can this be used as a consumer ?!
         * @return
         */
        String canThisBeAConsumer(){
            return "ola";
        }


    }

    /**
     * Can consumer be chained and andThen usage
     */
    void consumerChain(String theValue){
        // Cannot shadow variables
        //Function<String,Integer> theFunction = (theValue) -> 1;




        Stream<String> theStream = Stream.of("a","b","c");
        theStream.filter((p) -> false);
        theStream.count();
        Consumer<String> c = (var theString) -> theString.toUpperCase();
        c.andThen(s -> s.toLowerCase());
        c.accept("ola");
    }

    /**
     * Can a consumer accept a method ( using method reference ) that as return ?!
     * Answer: Seems it can...
     */
    void canConsumerReturn(){


        Stream.of(new Model("a")).forEach(Model::canThisBeAConsumer);

    }
}
