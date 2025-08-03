package com.polidea.rxandroidble2.internal.util;

import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class UUIDUtil_Factory implements InterfaceC3628<UUIDUtil> {
    private static final UUIDUtil_Factory INSTANCE = new UUIDUtil_Factory();

    public static UUIDUtil_Factory create() {
        return INSTANCE;
    }

    @Override // defpackage.InterfaceC4461
    public UUIDUtil get() {
        return new UUIDUtil();
    }
}
