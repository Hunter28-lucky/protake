package com.polidea.rxandroidble2.internal.util;

import defpackage.AbstractC4262;

/* loaded from: classes2.dex */
public class ActiveCharacteristicNotification {
    public final boolean isIndication;
    public final AbstractC4262<AbstractC4262<byte[]>> notificationObservable;

    public ActiveCharacteristicNotification(AbstractC4262<AbstractC4262<byte[]>> abstractC4262, boolean z) {
        this.notificationObservable = abstractC4262;
        this.isIndication = z;
    }
}
