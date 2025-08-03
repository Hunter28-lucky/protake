package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Deque;
import java.util.LinkedList;

/* compiled from: FrameRator.java */
/* renamed from: Ք, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3229 implements Handler.Callback {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Deque<Long> f11378 = new LinkedList();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Handler f11379 = new Handler(Looper.getMainLooper(), this);

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f11380;

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            this.f11380 = m10889();
            this.f11379.sendEmptyMessageDelayed(0, 1000L);
        }
        return false;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m10888() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f11378) {
            this.f11378.offerLast(Long.valueOf(jCurrentTimeMillis));
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int m10889() {
        int size;
        synchronized (this.f11378) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (!this.f11378.isEmpty() && (jCurrentTimeMillis - this.f11378.peekFirst().longValue() > 1000 || this.f11378.size() > 30)) {
                this.f11378.pollFirst();
            }
            size = this.f11378.size();
        }
        return size;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m10890() {
        this.f11379.removeCallbacksAndMessages(null);
        this.f11379.sendEmptyMessage(0);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m10891() {
        this.f11379.removeCallbacksAndMessages(null);
        synchronized (this.f11378) {
            this.f11378.clear();
        }
    }
}
