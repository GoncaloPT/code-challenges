package userfuncs.binaryfuncs;

/**
 * This interface defines a function that takes two int arguments and returns an
 * int result. This, it can describe any binary operation on two ints that
 * returns an int
 */
public interface BinaryFunc {
    public String getName();

    public int func(int a, int b);
}