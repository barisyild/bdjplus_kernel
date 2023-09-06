package com.bdjplus.kernel;

import java.util.Map;

public class NativeLAcces extends ClassLoader_NaLi
{
    private Map symbols;
    public NativeLAcces(Map arg)
    {
        super(java.lang.Object.class, "", false);
        symbols = arg;
    }
    protected long findEntry(String name)
    {
        Object q = symbols.get(name);
        if(q != null)
            return ((Long)q).longValue();
        return super.findEntry(name);
    }
}
