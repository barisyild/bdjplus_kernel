package com.oracle;

import java.security.Provider.Service;
import java.security.Provider;
import java.util.List;

public class ProviderAdapter {
    public static List getServices(Provider provider) {
        return null;
    }

    public static Service getService(Provider provider, String type, String algorithm) {
        return null;
    }

    public static void setProviderAccessor(ProviderAccessor providerAccessor)
    {

    }
}
