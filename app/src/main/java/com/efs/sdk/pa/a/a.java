package com.efs.sdk.pa.a;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.efs.sdk.pa.PAANRListener;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {
    public volatile boolean a;
    public final Handler b;
    public final Thread c;
    public long d;

    /* renamed from: e, reason: collision with root package name */
    public long f17659e;
    public boolean f;
    public Handler g;
    public PAANRListener h;
    public long i;
    public long j;
    public final long k;
    public boolean l;
    public final Runnable m;
    public final Runnable n;
    private HandlerThread o;
    private Application p;

    public a(Application application, long j) {
        this(application, j, true);
    }

    public static boolean a(StringBuilder sb) {
        Set<Map.Entry<Thread, StackTraceElement[]>> setEntrySet = Thread.getAllStackTraces().entrySet();
        if (setEntrySet.size() == 0) {
            return false;
        }
        boolean z = false;
        for (Map.Entry<Thread, StackTraceElement[]> entry : setEntrySet) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            if (key.getId() == Looper.getMainLooper().getThread().getId()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(key.getName());
                sb2.append(MyUTIL.white_space);
                sb2.append(key.getPriority());
                sb2.append(MyUTIL.white_space);
                sb2.append(key.getState());
                sb2.append("\n");
                for (StackTraceElement stackTraceElement : value) {
                    String string = stackTraceElement.toString();
                    sb2.append("  at  ");
                    sb2.append(string);
                    sb2.append('\n');
                }
                sb2.append("\n");
                sb.insert(0, (CharSequence) sb2);
                z = true;
            } else {
                sb.append(key.getName());
                sb.append(MyUTIL.white_space);
                sb.append(key.getPriority());
                sb.append(MyUTIL.white_space);
                sb.append(key.getState());
                sb.append("\n");
                for (StackTraceElement stackTraceElement2 : value) {
                    String string2 = stackTraceElement2.toString();
                    sb.append("  at  ");
                    sb.append(string2);
                    sb.append('\n');
                }
                sb.append("\n");
            }
        }
        if (!z) {
            sb.insert(0, a(Looper.getMainLooper().getThread()));
        }
        return true;
    }

    public a(Application application, long j, boolean z) {
        this.a = true;
        this.f17659e = 4L;
        this.f = true;
        this.i = 0L;
        this.m = new Runnable() { // from class: com.efs.sdk.pa.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                PAANRListener pAANRListener;
                if (a.this.f) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                a aVar = a.this;
                long j2 = jUptimeMillis - aVar.j;
                if (j2 > aVar.k && (pAANRListener = aVar.h) != null) {
                    pAANRListener.unexcept(Long.valueOf(j2));
                }
                if (a.this.a) {
                    a aVar2 = a.this;
                    aVar2.i = 0L;
                    aVar2.a = false;
                    a aVar3 = a.this;
                    aVar3.b.postAtFrontOfQueue(aVar3.n);
                } else {
                    a aVar4 = a.this;
                    aVar4.i++;
                    if (!aVar4.a) {
                        a aVar5 = a.this;
                        long j3 = aVar5.i;
                        long j4 = aVar5.f17659e;
                        if (j3 >= j4 && j3 == j4) {
                            StringBuilder sb = new StringBuilder();
                            if (aVar5.l) {
                                sb.append(a.a(aVar5.c));
                            } else if (a.a(sb)) {
                            }
                            if (aVar5.h != null && sb.length() > 0) {
                                aVar5.h.anrStack(sb.toString());
                            }
                        }
                    }
                }
                a.this.j = SystemClock.uptimeMillis();
                a aVar6 = a.this;
                aVar6.g.postDelayed(aVar6.m, aVar6.d);
            }
        };
        this.n = new Runnable() { // from class: com.efs.sdk.pa.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a = true;
            }
        };
        this.k = j;
        this.p = application;
        this.l = z;
        long j2 = ((long) (j * 0.8f)) / this.f17659e;
        this.d = j2;
        if (j2 < 100) {
            this.d = 100L;
            this.f17659e = j / 100;
        }
        Log.i("Matrix.AnrTracer", "anrTrace, final mAnrBeatTime:" + this.d + ", mAnrBeatRate:" + this.d);
        this.c = Looper.getMainLooper().getThread();
        this.b = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("ANR HANDLER THREAD");
        this.o = handlerThread;
        handlerThread.start();
        this.g = new Handler(this.o.getLooper());
    }

    public static String a(Thread thread) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        sb.append(thread.getName());
        sb.append(MyUTIL.white_space);
        sb.append(thread.getPriority());
        sb.append(MyUTIL.white_space);
        sb.append(thread.getState());
        sb.append("\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String string = stackTraceElement.toString();
            sb.append("  at  ");
            sb.append(string);
            sb.append('\n');
        }
        sb.append("\n");
        return sb.toString();
    }
}
