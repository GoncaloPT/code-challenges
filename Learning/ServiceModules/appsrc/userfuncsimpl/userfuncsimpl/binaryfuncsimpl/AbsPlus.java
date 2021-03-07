package userfuncsimpl.binaryfuncsimpl;

import binaryfuncsimpl.BinaryFunc;

public class AbsPlus implements BinaryFunc{
    private static final String IMPLEMENTATION_NAME = "absPlus";
    @Override
    public String getName() {
        return IMPLEMENTATION_NAME;
    }

    @Override
    public int func(int a, int b) {
        return Math.abs(a) + Math.abs(b);
    }

    
}