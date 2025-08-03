package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: FitCenter.java */
/* renamed from: ۉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3629 extends AbstractC3231 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final byte[] f12587 = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(InterfaceC3773.f13027);

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        return obj instanceof C3629;
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        return 1572326941;
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f12587);
    }

    @Override // defpackage.AbstractC3231
    /* renamed from: ԩ */
    public Bitmap mo9540(@NonNull InterfaceC2731 interfaceC2731, @NonNull Bitmap bitmap, int i, int i2) {
        return b3.m116(interfaceC2731, bitmap, i, i2);
    }
}
