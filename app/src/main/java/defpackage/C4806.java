package defpackage;

import com.github.thibaultbee.srtdroid.Srt;

/* compiled from: SocketFactory.java */
/* renamed from: ඣ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4806 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static C4806 f16284;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Object f16285 = new Object();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f16286 = 0;

    /* renamed from: ԩ, reason: contains not printable characters */
    public Srt f16287;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static C4806 m14521() {
        if (f16284 == null) {
            synchronized (C4806.class) {
                if (f16284 == null) {
                    f16284 = new C4806();
                }
            }
        }
        return f16284;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m14522() {
        synchronized (this.f16285) {
            if (this.f16286 == 0) {
                m14525();
            }
            this.f16286++;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C4672 m14523() {
        m14522();
        return new C4672();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public C2701 m14524() {
        m14522();
        return new C2701();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean m14525() {
        try {
            Srt srt = Srt.INSTANCE;
            this.f16287 = srt;
            srt.startUp();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m14526() {
        synchronized (this.f16285) {
            int i = this.f16286 - 1;
            this.f16286 = i;
            if (i == 0) {
                m14527();
            }
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m14527() {
        Srt srt = this.f16287;
        if (srt != null) {
            srt.cleanUp();
            this.f16287 = null;
        }
    }
}
