package com.blink.academy.filter.core;

import android.util.Log;
import com.blink.academy.filter.core.FramebufferTexture;
import defpackage.C2584;
import defpackage.C4625;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.blink.academy.filter.core.Ԩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1789 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final String f5108 = C4625.m14082("CB0MAjUQGhIHDhdxUlBbKw==");

    /* renamed from: ԭ, reason: contains not printable characters */
    public static boolean f5109 = false;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static C1789 f5110 = new C1789();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f5111 = 0;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public long f5112 = 1000000000;

    /* renamed from: ԩ, reason: contains not printable characters */
    public long f5113 = 838860800;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Queue<C1790> f5114 = new LinkedList();

    /* renamed from: ԫ, reason: contains not printable characters */
    public Queue<C1790> f5115 = new LinkedList();

    /* renamed from: com.blink.academy.filter.core.Ԩ$Ϳ, reason: contains not printable characters */
    public static final class C1790 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public long f5116;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f5117;

        /* renamed from: ԩ, reason: contains not printable characters */
        public C1788 f5118;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean f5119;

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f5120;

        public C1790(C1788 c1788, int i, boolean z) {
            this.f5118 = c1788;
            this.f5117 = i;
            this.f5119 = z;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m4799() {
            this.f5116 = System.nanoTime();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized void m4794(C1788 c1788) {
        this.f5114.add(new C1790(c1788, this.f5111, true));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized void m4795() {
        m4796(this.f5114);
        m4796(this.f5115);
        if (f5109) {
            Log.d(f5108, String.format(C4625.m14082("KgoeGyIdFjUNBypccEZBPAoDGxMdAQAEExEIE0FWIw4EATkcCE5BTgESRkBWKkNNSjRSCQYEDg=="), Integer.valueOf(this.f5114.size()), Integer.valueOf(this.f5115.size())));
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4796(Queue<C1790> queue) {
        long jM9463 = C2584.m9463();
        Iterator<C1790> it = queue.iterator();
        while (it.hasNext()) {
            C1790 next = it.next();
            if (next.f5118.f5107 == jM9463) {
                it.remove();
                next.f5118.m4789();
            }
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public synchronized void m4797(C1788 c1788) {
        Iterator<C1790> it = this.f5114.iterator();
        while (it.hasNext()) {
            C1790 next = it.next();
            if (next.f5118 == c1788) {
                if (next.f5120 > 0) {
                    return;
                }
                it.remove();
                if (next.f5119) {
                    return;
                }
                if (next.f5117 != this.f5111) {
                    c1788.m4789();
                    return;
                } else {
                    next.m4799();
                    this.f5115.add(next);
                    return;
                }
            }
        }
        throw new RenderException(C4625.m14082("KB0MAjUQGhIHDhcSXFVVKx0IC3AQGgBBAhEVQBNGIAQDACcc"));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public synchronized C1788 m4798(int i, int i2, FramebufferTexture.Format format) {
        long jM9463 = C2584.m9463();
        Iterator<C1790> it = this.f5115.iterator();
        while (it.hasNext()) {
            C1790 next = it.next();
            C1788 c1788 = next.f5118;
            if (c1788.f5101 == i && c1788.f5102 == i2 && c1788.f5103 == format && c1788.f5107 == jM9463) {
                it.remove();
                next.f5117 = this.f5111;
                this.f5114.add(next);
                return c1788;
            }
        }
        C1788 c17882 = new C1788(i, i2, format);
        this.f5114.add(new C1790(c17882, this.f5111, false));
        return c17882;
    }
}
