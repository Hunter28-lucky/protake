package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: CenterCrop.java */
/* renamed from: ۮ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3647 extends AbstractC3231 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final byte[] f12662 = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(InterfaceC3773.f13027);

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        return obj instanceof C3647;
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        return -599754482;
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f12662);
    }

    @Override // defpackage.AbstractC3231
    /* renamed from: ԩ */
    public Bitmap mo9540(@NonNull InterfaceC2731 interfaceC2731, @NonNull Bitmap bitmap, int i, int i2) {
        return b3.m113(interfaceC2731, bitmap, i, i2);
    }
}
