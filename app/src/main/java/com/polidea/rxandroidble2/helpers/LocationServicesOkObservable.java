package com.polidea.rxandroidble2.helpers;

import android.content.Context;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.DaggerClientComponent;
import defpackage.AbstractC4262;
import defpackage.InterfaceC5102;

/* loaded from: classes2.dex */
public class LocationServicesOkObservable extends AbstractC4262<Boolean> {

    @NonNull
    private final AbstractC4262<Boolean> locationServicesOkObsImpl;

    public LocationServicesOkObservable(@NonNull AbstractC4262<Boolean> abstractC4262) {
        this.locationServicesOkObsImpl = abstractC4262;
    }

    public static LocationServicesOkObservable createInstance(@NonNull Context context) {
        return DaggerClientComponent.builder().applicationContext(context.getApplicationContext()).build().locationServicesOkObservable();
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Boolean> interfaceC5102) {
        this.locationServicesOkObsImpl.subscribe(interfaceC5102);
    }
}
