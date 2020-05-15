package goncalo.designpatterns.flyweight;/*
 * Created by: @author silvagc
 * 14/05/2020
 */

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Paint Store
 * Uses Color, which is a demonstration of the flyweight pattern
 */
public class PaintStore {

    /**
     *
     * @param wantedColors
     * @return
     */
    public Collection<PaintBucket> sell(Stream<? extends String> wantedColors) {
        return wantedColors.map(
                wantedColor -> new PaintBucket("ref1", Color.withName(wantedColor))
        ).collect(Collectors.toList());
    }




}
