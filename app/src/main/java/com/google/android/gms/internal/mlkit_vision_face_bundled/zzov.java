package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public class zzov extends IOException {
    private zzps zza;

    public zzov(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    public static zzou zza() {
        return new zzou("Protocol message tag had invalid wire type.");
    }

    public static zzov zzb() {
        return new zzov("Protocol message contained an invalid tag (zero).");
    }

    public static zzov zzc() {
        return new zzov("Protocol message had invalid UTF-8.");
    }

    public static zzov zzd() {
        return new zzov("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzov zze() {
        return new zzov("Failed to parse the message.");
    }

    public static zzov zzg() {
        return new zzov("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzov zzf(zzps zzpsVar) {
        this.zza = zzpsVar;
        return this;
    }

    public zzov(String str) {
        super(str);
        this.zza = null;
    }
}
