package com.bdjplus.kernel;

//this class exists only to fool javac. its never loaded at runtime
public class ClassLoader_NaLi
{
    public ClassLoader_NaLi(Class cls, String s, boolean q){}
    boolean load()
    {
        return false;
    }
    protected long findEntry(String name)
    {
        return 0;
    }
}
