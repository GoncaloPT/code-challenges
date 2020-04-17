package chapter4;

import chapter3.Chapter3;

import java.util.stream.Stream;

public interface Performance {
    String getName();
    Stream<Chapter3.Artist> getMusicians();

    /**
     * Exercise 1 of chapter 4
     * @return
     */
    default Stream<Chapter3.Artist> getAllMusicians(){
        return getMusicians().flatMap(artist -> artist.getMembers() );
    }


}
