package goncalo.designpatterns.flyweight;

import java.util.WeakHashMap;
/*
 * Created by: @author silvagc
 * 14/05/2020
 *
 * Used WeahHashMap for caching. WeakhashMap uses keys of type WeakReference.
 * A WeakReference object is collected by GC eagerly. This means that WeakReference do not prevent referents ( objects that refer them ) to be reclaimed vy GC
 * This means that a key entry in the map will be discarded when there is no "Strong" reference to it.
 * Additional information:
 * {@see https://www.baeldung.com/java-weakhashmap}
 */
public class Color {
    private final String name;
    private static WeakHashMap<String, Color> COLOR_CACHE = new WeakHashMap<>();
    private Color(String name) {
        this.name = name;
    }

    /**
     * Factory method
     * @param color
     * @return
     */
    public static Color withName(String color){
        return COLOR_CACHE.computeIfAbsent(color, Color::new);
    }

    public static int colorsInCache(){
        return COLOR_CACHE.size();
    }


}
