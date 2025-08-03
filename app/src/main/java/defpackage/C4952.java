package defpackage;

import java.util.List;

/* compiled from: ArrayWheelAdapter.java */
/* renamed from: ຐ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4952<T> implements a8 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<T> f16671;

    public C4952(List<T> list) {
        this.f16671 = list;
    }

    @Override // defpackage.a8
    public Object getItem(int i) {
        return (i < 0 || i >= this.f16671.size()) ? "" : this.f16671.get(i);
    }

    @Override // defpackage.a8
    /* renamed from: Ϳ */
    public int mo15() {
        return this.f16671.size();
    }
}
