package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ListCompositeDisposable.java */
/* renamed from: க, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4465 implements InterfaceC4478, InterfaceC2806 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public List<InterfaceC4478> f15361;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public volatile boolean f15362;

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        if (this.f15362) {
            return;
        }
        synchronized (this) {
            if (this.f15362) {
                return;
            }
            this.f15362 = true;
            List<InterfaceC4478> list = this.f15361;
            this.f15361 = null;
            m13726(list);
        }
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.f15362;
    }

    @Override // defpackage.InterfaceC2806
    /* renamed from: Ϳ */
    public boolean mo9333(InterfaceC4478 interfaceC4478) {
        C4246.m13353(interfaceC4478, "d is null");
        if (!this.f15362) {
            synchronized (this) {
                if (!this.f15362) {
                    List linkedList = this.f15361;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.f15361 = linkedList;
                    }
                    linkedList.add(interfaceC4478);
                    return true;
                }
            }
        }
        interfaceC4478.dispose();
        return false;
    }

    @Override // defpackage.InterfaceC2806
    /* renamed from: Ԩ */
    public boolean mo9334(InterfaceC4478 interfaceC4478) {
        if (!mo9335(interfaceC4478)) {
            return false;
        }
        interfaceC4478.dispose();
        return true;
    }

    @Override // defpackage.InterfaceC2806
    /* renamed from: ԩ */
    public boolean mo9335(InterfaceC4478 interfaceC4478) {
        C4246.m13353(interfaceC4478, "Disposable item is null");
        if (this.f15362) {
            return false;
        }
        synchronized (this) {
            if (this.f15362) {
                return false;
            }
            List<InterfaceC4478> list = this.f15361;
            if (list != null && list.remove(interfaceC4478)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m13726(List<InterfaceC4478> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<InterfaceC4478> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (Throwable th) {
                C4089.m13026(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.m7024((Throwable) arrayList.get(0));
        }
    }
}
