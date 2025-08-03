package com.blink.academy.film.support.socket;

import android.net.nsd.NsdServiceInfo;

/* loaded from: classes.dex */
public interface IDiscoveryCallBack {
    void onServiceFound(NsdServiceInfo nsdServiceInfo);

    void onServiceLost(NsdServiceInfo nsdServiceInfo);
}
