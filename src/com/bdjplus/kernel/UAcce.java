package com.bdjplus.kernel;

import jdk.internal.misc.Unsafe;
import jdk.internal.reflect.MagicAccessorImpl;

public class UAcce extends MagicAccessorImpl implements javax.media.protocol.Seekable
{
    public long seek(long addr)
    {
        return Unsafe.theUnsafe.getLong(addr);
    }
    public long tell()
    {
        return 0;
    }
    public boolean isRandomAccess()
    {
        return false;
    }
}
