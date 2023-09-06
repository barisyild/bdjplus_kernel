package com.oracle.security;

import java.security.Provider;
import java.util.List;
import java.util.Map;

public class Service {

    public Service(Provider provider)
    {
    }

    public Service(Provider provider,
                   String type,
                   String algorithm,
                   String className,
                   List aliases,
                   Map attributes)
    {

    }
    public String getType()
    {
        return null;
    }

    public void setType(String type)
    {
    }

    public String getAlgorithm()
    {
        return null;
    }

    public void setAlgorithm(String algorithm)
    {
    }

    public List getAliases()
    {
        return null;
    }

    public void setAliases(List aliases)
    {
    }

    public void setClassName(String className)
    {
    }

    Object newInstance(Object arg) throws java.security.NoSuchAlgorithmException, java.rmi.RemoteException
    {
        return null;
    }
}
