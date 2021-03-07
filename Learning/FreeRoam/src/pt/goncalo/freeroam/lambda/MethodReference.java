package pt.goncalo.freeroam.lambda;

import java.util.stream.Stream;

public class MethodReference {


    public static class User{
        private String name;
        public User(String name){
            this.name = name;
        }

        /**
         * Although used as a consumer in method reference, it can return something
         * @return
         */
        public String print(){
            System.out.println("The name is " + name + " and will return string");
            return name;
        }

        public void print2(){
            System.out.println("The name is " + name + " and will not return");

        }


    }

    public static void main(String [] args){
        User user = new User("1");
        Stream.of(user).forEach(User::print);
        Stream.of(user).forEach(User::print2);

    }
}
