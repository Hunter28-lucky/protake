package defpackage;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* renamed from: ߾, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3874 implements InterfaceC4970 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Set<InterfaceC2405> f13315 = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f13316;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f13317;

    @Override // defpackage.InterfaceC4970
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo12321(@NonNull InterfaceC2405 interfaceC2405) {
        this.f13315.remove(interfaceC2405);
    }

    @Override // defpackage.InterfaceC4970
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo12322(@NonNull InterfaceC2405 interfaceC2405) {
        this.f13315.add(interfaceC2405);
        if (this.f13317) {
            interfaceC2405.onDestroy();
        } else if (this.f13316) {
            interfaceC2405.onStart();
        } else {
            interfaceC2405.onStop();
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m12323() {
        this.f13317 = true;
        Iterator it = j5.m7092(this.f13315).iterator();
        while (it.hasNext()) {
            ((InterfaceC2405) it.next()).onDestroy();
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m12324() {
        this.f13316 = true;
        Iterator it = j5.m7092(this.f13315).iterator();
        while (it.hasNext()) {
            ((InterfaceC2405) it.next()).onStart();
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m12325() {
        this.f13316 = false;
        Iterator it = j5.m7092(this.f13315).iterator();
        while (it.hasNext()) {
            ((InterfaceC2405) it.next()).onStop();
        }
    }
}
