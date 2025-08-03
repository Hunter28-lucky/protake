package android.location;

import android.os.Parcelable;

/* loaded from: classes.dex */
public final /* synthetic */ class GnssStatus implements Parcelable {

    public /* synthetic */ class Callback {
        static {
            throw new NoClassDefFoundError();
        }
    }

    static {
        throw new NoClassDefFoundError();
    }

    public native /* synthetic */ boolean equals(Object obj);

    public native /* synthetic */ float getAzimuthDegrees(int i);

    public native /* synthetic */ float getCn0DbHz(int i);

    public native /* synthetic */ int getConstellationType(int i);

    public native /* synthetic */ float getElevationDegrees(int i);

    public native /* synthetic */ int getSatelliteCount();

    public native /* synthetic */ int getSvid(int i);

    public native /* synthetic */ boolean hasAlmanacData(int i);

    public native /* synthetic */ boolean hasEphemerisData(int i);

    public native /* synthetic */ int hashCode();

    public native /* synthetic */ boolean usedInFix(int i);
}
