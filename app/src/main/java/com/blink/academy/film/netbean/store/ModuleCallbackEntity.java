package com.blink.academy.film.netbean.store;

import java.util.List;

/* loaded from: classes.dex */
public class ModuleCallbackEntity {
    private String client_nonce;
    private List<ModuleFilterBean> modules;
    private String server_nonce;
    private int timestamp;

    public String getClient_nonce() {
        return this.client_nonce;
    }

    public List<ModuleFilterBean> getModules() {
        return this.modules;
    }

    public String getServer_nonce() {
        return this.server_nonce;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public ModuleCallbackEntity setClient_nonce(String str) {
        this.client_nonce = str;
        return this;
    }

    public ModuleCallbackEntity setModules(List<ModuleFilterBean> list) {
        this.modules = list;
        return this;
    }

    public ModuleCallbackEntity setServer_nonce(String str) {
        this.server_nonce = str;
        return this;
    }

    public ModuleCallbackEntity setTimestamp(int i) {
        this.timestamp = i;
        return this;
    }
}
