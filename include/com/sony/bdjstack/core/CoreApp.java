package com.sony.bdjstack.core;

import com.sony.mhpstack.mhpsupport.appsupport.AppObject;
import org.dvb.application.AppsDatabaseEvent;
import org.dvb.application.AppsDatabaseEventListener;
import sun.awt.AppContext;
import com.oracle.ProviderAccessor;

import javax.tv.xlet.Xlet;

public class CoreApp implements AppsDatabaseEventListener {
    private Xlet xlet;

    private CoreApp(Xlet xlet, String str)
    {

    }
    public AppObject appContextCleanup;

    public void newDatabase(AppsDatabaseEvent appsDatabaseEvent) {

    }

    public void entryAdded(AppsDatabaseEvent appsDatabaseEvent) {

    }

    public void entryRemoved(AppsDatabaseEvent appsDatabaseEvent) {

    }

    public void entryChanged(AppsDatabaseEvent appsDatabaseEvent) {

    }

    public static class AppContextCleanup extends AppObject {
        public AppContextCleanup(AppContext appContext)
        {

        }
    }
}
