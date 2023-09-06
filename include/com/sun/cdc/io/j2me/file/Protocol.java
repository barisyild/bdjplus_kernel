package com.sun.cdc.io.j2me.file;

import javax.microedition.io.Connection;
import java.io.IOException;
import java.rmi.RemoteException;
import com.sun.cdc.io.j2me.file.Protocol;

public class Protocol {
    public Connection prim_openProtocol(String path, String unused, int mode) throws IOException, RemoteException {
        return null;
    }

    public void prim_realOpen() throws IOException, RemoteException {

    }
}
