package com.bdjplus.kernel;

import com.sony.bdjstack.system.BDJModule;
import org.dvb.event.UserEvent;

import java.util.ArrayList;
import java.util.List;

public class UserEventListener implements org.dvb.event.UserEventListener {
    private int keyIndex = 0;
    private boolean exploited = false;
    private int[] keyPattern = new int[]{38, 38, 461, 40, 40};
    public void userEventReceived(UserEvent userEvent)
    {
        if(exploited)
            return;

        // 37 - left
        // 461 - square
        // 39 - right
        if(userEvent.getType() == 401)
        {
            if(userEvent.getCode() == keyPattern[keyIndex])
            {
                keyIndex++;
                if(keyIndex == keyPattern.length)
                {
                    exploited = true;

                    KernelRW kernelRW = (KernelRW) BDJModule.properties.get("KernelRW");
                    try {
                        // Get all available jvm threads
                        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
                        ThreadGroup parentGroup;
                        while ((parentGroup = rootGroup.getParent()) != null) {
                            rootGroup = parentGroup;
                        }

                        Thread[] threads = new Thread[rootGroup.activeCount()];
                        while (rootGroup.enumerate(threads, true ) == threads.length) {
                            threads = new Thread[threads.length * 2];
                        }

                        List threadsList = new ArrayList();

                        // Kill all threads except for the jailbreak thread
                        for(int i = 0; i < threads.length; i++)
                        {
                            Thread thread = threads[i];
                            if(thread == null)
                                continue;

                            threadsList.add(thread);
                            //thread.setPriority(1);
                        }

                        // Remove current thread from list
                        threadsList.remove(Thread.currentThread());

                        for(int i = 0; i < threadsList.size(); i++)
                        {
                            Thread thread = (Thread) threadsList.get(i);
                            thread.setPriority(1);
                            thread.interrupt();
                        }

                        // Increase priority of jailbreak thread to increase chances of success
                        Thread.currentThread().setPriority(10);
                        kernelRW.main();
                    } catch (Exception e) {
                        BDJModule.log(e);
                    }

                    keyIndex = 0;
                }
            }else{
                keyIndex = 0;
            }
        }else if(userEvent.getType() == 402){

        }
    }
}
