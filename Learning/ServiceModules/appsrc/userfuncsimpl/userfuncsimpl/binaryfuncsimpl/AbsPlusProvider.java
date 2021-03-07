package userfuncsimpl.binaryfuncsimpl;

import userfuncs.binaryfuncs.BinFuncProvider;
import userfuncs.binaryfuncs.BinaryFunc;


public class AbsPlusProvider implements BinFuncProvider {

    @Override
    public BinaryFunc get() {
        return new AbsPlus();
    }
    
}