package pt.goncalo.microprofilefirsttryout.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/*
 * Created by: @author Gonçalo Silva
 * 20/05/2020
 */
@Data
@Builder
public class Person {
    private final String id;
    private final String name;
    private final int age;


}
