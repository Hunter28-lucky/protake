package com.efs.sdk.base.core.util.concurrent;

import androidx.annotation.NonNull;
import com.efs.sdk.base.core.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class d<T> implements Runnable {
    private List<b<T>> a = new ArrayList(5);
    private c<T> b;

    public d(@NonNull c<T> cVar) {
        this.b = cVar;
    }

    public final void a(@NonNull List<b<T>> list) {
        this.a.addAll(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public final T a() {
        T tA = null;
        try {
            Iterator<b<T>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            tA = this.b.a();
            Iterator<b<T>> it2 = this.a.iterator();
            while (it2.hasNext()) {
                it2.next().a(this.b, tA);
            }
            Iterator<b<T>> it3 = this.a.iterator();
            while (it3.hasNext()) {
                it3.next().result(tA);
            }
        } catch (Throwable th) {
            Log.w("efs.util.concurrent", th);
            Iterator<b<T>> it4 = this.a.iterator();
            while (it4.hasNext()) {
                it4.next();
            }
        }
        return tA;
    }
}
