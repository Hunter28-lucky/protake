package defpackage;

import defpackage.InterfaceC2902;
import java.util.Queue;

/* compiled from: BaseKeyPool.java */
/* renamed from: ၦ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC5163<T extends InterfaceC2902> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Queue<T> f17101 = j5.m7088(20);

    /* renamed from: Ϳ */
    public abstract T mo9488();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public T m15088() {
        T tPoll = this.f17101.poll();
        return tPoll == null ? (T) mo9488() : tPoll;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m15089(T t) {
        if (this.f17101.size() < 20) {
            this.f17101.offer(t);
        }
    }
}
