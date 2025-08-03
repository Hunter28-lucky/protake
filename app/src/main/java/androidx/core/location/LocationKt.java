package androidx.core.location;

import android.location.Location;
import defpackage.C3921;

/* compiled from: Location.kt */
/* loaded from: classes.dex */
public final class LocationKt {
    public static final double component1(Location location) {
        C3921.m12666(location, "<this>");
        return location.getLatitude();
    }

    public static final double component2(Location location) {
        C3921.m12666(location, "<this>");
        return location.getLongitude();
    }
}
