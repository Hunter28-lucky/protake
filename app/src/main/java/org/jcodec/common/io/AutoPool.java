package org.jcodec.common.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class AutoPool {
    private static AutoPool instance = new AutoPool();
    private final List<AutoResource> resources;
    private ScheduledExecutorService scheduler;

    private AutoPool() {
        final List<AutoResource> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        this.resources = listSynchronizedList;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, daemonThreadFactory());
        this.scheduler = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: org.jcodec.common.io.AutoPool.1
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator it = listSynchronizedList.iterator();
                while (it.hasNext()) {
                    ((AutoResource) it.next()).setCurTime(jCurrentTimeMillis);
                }
            }
        }, 0L, 100L, TimeUnit.MILLISECONDS);
    }

    private ThreadFactory daemonThreadFactory() {
        return new ThreadFactory() { // from class: org.jcodec.common.io.AutoPool.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                thread.setName(AutoPool.class.getName());
                return thread;
            }
        };
    }

    public static AutoPool getInstance() {
        return instance;
    }

    public void add(AutoResource autoResource) {
        this.resources.add(autoResource);
    }
}
