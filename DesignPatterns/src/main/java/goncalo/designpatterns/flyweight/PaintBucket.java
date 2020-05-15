package goncalo.designpatterns.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * Created by: @author Gonçalo Silva
 * 14/05/2020
 */
@Data
@AllArgsConstructor
public class PaintBucket {
    private String reference;
    private Color color;
}
