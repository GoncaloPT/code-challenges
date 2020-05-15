# Design Patterns

This project holds design pattern implementations using java

## Flyweight

### Problems solved by
1. Large number of objects should be supported efficiently.
1. Creating large numbers of objects should be avoided.

### Considerations 
* Flyweight should store invariant state while providing a way for clients to pass in variant values  
* Flyweight objects should be immutable
* Flyweight implementation must ensure that instances with same values are considered equal, independently of the actual object instance

### Implementation
To demonstrate a possible implementation we will use flyweight pattern to hold colors.



