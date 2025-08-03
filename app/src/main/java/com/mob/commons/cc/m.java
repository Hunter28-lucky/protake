package com.mob.commons.cc;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class m implements r<m> {
    private l a;

    private ConnectivityManager.NetworkCallback a() {
        return new ConnectivityManager.NetworkCallback() { // from class: com.mob.commons.cc.m.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(network);
                m.this.a.a("onAvailable", arrayList);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(network);
                m.this.a.a("onLost", arrayList);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                super.onUnavailable();
            }
        };
    }

    public void a(l lVar) {
        this.a = lVar;
    }

    @Override // com.mob.commons.cc.r
    public boolean a(m mVar, Class<m> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        Object obj;
        if ("setHandler".equals(str) && objArr.length == 1 && (obj = objArr[0]) != null && (obj instanceof l)) {
            mVar.a((l) obj);
        } else {
            if (!"initNetworkCallback".equals(str) || objArr.length != 0) {
                return false;
            }
            objArr2[0] = mVar.a();
        }
        return true;
    }
}
