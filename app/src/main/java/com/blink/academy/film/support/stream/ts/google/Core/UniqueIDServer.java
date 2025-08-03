package com.blink.academy.film.support.stream.ts.google.Core;

/* loaded from: classes.dex */
public class UniqueIDServer {
    private static UniqueIDServer singleton_instance;
    private int next_id_value = 1;

    private UniqueIDServer() {
    }

    private static synchronized UniqueIDServer getInstance() {
        if (singleton_instance == null) {
            singleton_instance = new UniqueIDServer();
        }
        return singleton_instance;
    }

    public static synchronized int getUniqueID() {
        int i;
        UniqueIDServer uniqueIDServer = getInstance();
        i = uniqueIDServer.next_id_value;
        uniqueIDServer.next_id_value = i + 1;
        return i;
    }
}
