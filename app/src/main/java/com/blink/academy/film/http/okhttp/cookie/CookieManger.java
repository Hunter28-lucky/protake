package com.blink.academy.film.http.okhttp.cookie;

import android.content.Context;
import defpackage.C2632;
import defpackage.C3573;
import defpackage.InterfaceC2896;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class CookieManger implements InterfaceC2896 {
    private static PersistentCookieStore cookieStore;
    private static Context mContext;

    public CookieManger(Context context) {
        mContext = context;
        if (cookieStore == null) {
            cookieStore = new PersistentCookieStore(context);
        }
    }

    public void addCookies(List<C2632> list) {
        cookieStore.addCookies(list);
    }

    public PersistentCookieStore getCookieStore() {
        return cookieStore;
    }

    @Override // defpackage.InterfaceC2896
    public List<C2632> loadForRequest(C3573 c3573) {
        List<C2632> list = cookieStore.get(c3573);
        return list != null ? list : new ArrayList();
    }

    public void remove(C3573 c3573, C2632 c2632) {
        cookieStore.remove(c3573, c2632);
    }

    public void removeAll() {
        cookieStore.removeAll();
    }

    public void saveFromResponse(C3573 c3573, C2632 c2632) {
        if (c2632 != null) {
            cookieStore.add(c3573, c2632);
        }
    }

    @Override // defpackage.InterfaceC2896
    public void saveFromResponse(C3573 c3573, List<C2632> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<C2632> it = list.iterator();
        while (it.hasNext()) {
            cookieStore.add(c3573, it.next());
        }
    }
}
