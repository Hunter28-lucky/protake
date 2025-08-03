package com.polidea.rxandroidble2.internal.util;

import android.content.Context;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class CheckerLocationPermission_Factory implements InterfaceC3628<CheckerLocationPermission> {
    private final InterfaceC4461<Context> contextProvider;
    private final InterfaceC4461<String[]> scanPermissionsProvider;

    public CheckerLocationPermission_Factory(InterfaceC4461<Context> interfaceC4461, InterfaceC4461<String[]> interfaceC44612) {
        this.contextProvider = interfaceC4461;
        this.scanPermissionsProvider = interfaceC44612;
    }

    public static CheckerLocationPermission_Factory create(InterfaceC4461<Context> interfaceC4461, InterfaceC4461<String[]> interfaceC44612) {
        return new CheckerLocationPermission_Factory(interfaceC4461, interfaceC44612);
    }

    public static CheckerLocationPermission newCheckerLocationPermission(Context context, String[] strArr) {
        return new CheckerLocationPermission(context, strArr);
    }

    @Override // defpackage.InterfaceC4461
    public CheckerLocationPermission get() {
        return new CheckerLocationPermission(this.contextProvider.get(), this.scanPermissionsProvider.get());
    }
}
