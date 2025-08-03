package io.reactivex.internal.disposables;

import defpackage.C3671;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC4478;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public enum DisposableHelper implements InterfaceC4478 {
    DISPOSED;

    public static boolean dispose(AtomicReference<InterfaceC4478> atomicReference) {
        InterfaceC4478 andSet;
        InterfaceC4478 interfaceC4478 = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (interfaceC4478 == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(InterfaceC4478 interfaceC4478) {
        return interfaceC4478 == DISPOSED;
    }

    public static boolean replace(AtomicReference<InterfaceC4478> atomicReference, InterfaceC4478 interfaceC4478) {
        InterfaceC4478 interfaceC44782;
        do {
            interfaceC44782 = atomicReference.get();
            if (interfaceC44782 == DISPOSED) {
                if (interfaceC4478 == null) {
                    return false;
                }
                interfaceC4478.dispose();
                return false;
            }
        } while (!C4905.m14631(atomicReference, interfaceC44782, interfaceC4478));
        return true;
    }

    public static void reportDisposableSet() {
        C3671.m11803(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<InterfaceC4478> atomicReference, InterfaceC4478 interfaceC4478) {
        InterfaceC4478 interfaceC44782;
        do {
            interfaceC44782 = atomicReference.get();
            if (interfaceC44782 == DISPOSED) {
                if (interfaceC4478 == null) {
                    return false;
                }
                interfaceC4478.dispose();
                return false;
            }
        } while (!C4905.m14631(atomicReference, interfaceC44782, interfaceC4478));
        if (interfaceC44782 == null) {
            return true;
        }
        interfaceC44782.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<InterfaceC4478> atomicReference, InterfaceC4478 interfaceC4478) {
        C4246.m13353(interfaceC4478, "d is null");
        if (C4905.m14631(atomicReference, null, interfaceC4478)) {
            return true;
        }
        interfaceC4478.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean trySet(AtomicReference<InterfaceC4478> atomicReference, InterfaceC4478 interfaceC4478) {
        if (C4905.m14631(atomicReference, null, interfaceC4478)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        interfaceC4478.dispose();
        return false;
    }

    public static boolean validate(InterfaceC4478 interfaceC4478, InterfaceC4478 interfaceC44782) {
        if (interfaceC44782 == null) {
            C3671.m11803(new NullPointerException("next is null"));
            return false;
        }
        if (interfaceC4478 == null) {
            return true;
        }
        interfaceC44782.dispose();
        reportDisposableSet();
        return false;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return true;
    }
}
