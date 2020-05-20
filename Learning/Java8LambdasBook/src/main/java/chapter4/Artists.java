package chapter4;
import chapter3.Chapter3;
import java.util.List;
import java.util.Optional;

public class Artists{

    private List<Chapter3.Artist> artists;

    public Artists(List<Chapter3.Artist> artists) {
        this.artists = artists;
    }

    public Chapter3.Artist getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            indexException(index);
        }
        return artists.get(index);
    }

    /**
     * Exercise 3 chapter 4
     * @param index
     * @return
     */
    public Optional<Chapter3.Artist> getArtistRefactor(int index) {


        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    private void indexException(int index) {
        throw new IllegalArgumentException(index +
                " doesn't correspond to an Artist");
    }

    public String getArtistName(int index) {
        try {
            Chapter3.Artist artist = getArtist(index);
            return artist.getName();
        } catch (IllegalArgumentException e) {
            return "unknown";
        }
    }

}

