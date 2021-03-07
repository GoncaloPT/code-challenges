package userfuncsimpl.binaryfuncsimpl;

import userfuncs.binaryfuncsimpl.BinaryFunc;

public class AbsMinus implements BinaryFunc {
    private static final String IMPLEMENTATION_NAME = "AbsMinus";

    @Override
    public String getName() {
        return IMPLEMENTATION_NAME;
    }

    @Override
    public int func(int a, int b) {
        return Math.abs(a) - Math.abs(b);
    }

}