package pt.goncalo.freeroam.immutable.wrong;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The purpose of this drill is to showcase what happens when a mutable class is used as
 * key in a Map.
 * The exercise shows that, using mutable classes, one can easily endup with a map with repeated keys.
 * For that we just need to add a object to the map and after that change it's values
 */
public class WrongHashMap {


    public static void main(String [] args){

        Map<MutableClass,String> map = new HashMap<>();
        MutableClass id1 = new MutableClass(1);
        MutableClass id2 = new MutableClass(2);
        map.put(id1, "id1");
        map.put(id2,"id2");
        //print contents of map
        map.entrySet().forEach(System.out::println);
        System.out.println("***********");
        id1.id = 2;
        map.entrySet().forEach(System.out::println);

    }

    private static class MutableClass{
        private Integer id;

        public MutableClass(Integer id){
            Objects.requireNonNull(id,"Id must not be null");
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MutableClass that = (MutableClass) o;
            return id.equals(that.id);
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result;
            return result;
        }

        @Override
        public String toString() {
            return "MutableClass{" +
                    "id=" + id +
                    '}';
        }
    }

}
