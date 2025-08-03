package defpackage;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker.java */
/* loaded from: classes.dex */
public final class e1 implements InterfaceC2405 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Set<c1<?>> f6599 = Collections.newSetFromMap(new WeakHashMap());

    @Override // defpackage.InterfaceC2405
    public void onDestroy() {
        Iterator it = j5.m7092(this.f6599).iterator();
        while (it.hasNext()) {
            ((c1) it.next()).onDestroy();
        }
    }

    @Override // defpackage.InterfaceC2405
    public void onStart() {
        Iterator it = j5.m7092(this.f6599).iterator();
        while (it.hasNext()) {
            ((c1) it.next()).onStart();
        }
    }

    @Override // defpackage.InterfaceC2405
    public void onStop() {
        Iterator it = j5.m7092(this.f6599).iterator();
        while (it.hasNext()) {
            ((c1) it.next()).onStop();
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m5981() {
        this.f6599.clear();
    }

    @NonNull
    /* renamed from: ՠ, reason: contains not printable characters */
    public List<c1<?>> m5982() {
        return j5.m7092(this.f6599);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m5983(@NonNull c1<?> c1Var) {
        this.f6599.add(c1Var);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m5984(@NonNull c1<?> c1Var) {
        this.f6599.remove(c1Var);
    }
}
