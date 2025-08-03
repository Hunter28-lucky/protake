package com.efs.sdk.pa.a;

import android.os.SystemClock;
import android.util.Printer;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: classes.dex */
final class e implements Printer {
    private long f;
    private boolean b = false;
    private String c = null;
    private long d = -1;

    /* renamed from: e, reason: collision with root package name */
    private long f17661e = -1;
    public Vector<d> a = new Vector<>();

    @Override // android.util.Printer
    public final void println(String str) {
        if (str.startsWith(">")) {
            this.d = SystemClock.elapsedRealtime();
            this.f17661e = SystemClock.currentThreadTimeMillis();
            this.c = str;
            this.b = true;
            Iterator<d> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            return;
        }
        if (this.b && str.startsWith("<")) {
            this.b = false;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.d;
            if (jElapsedRealtime > this.f) {
                long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - this.f17661e;
                Iterator<d> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.c, jElapsedRealtime, jCurrentThreadTimeMillis);
                }
            }
        }
    }
}
