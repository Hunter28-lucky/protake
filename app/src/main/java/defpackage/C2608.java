package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: CenterInside.java */
/* renamed from: ɪ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2608 extends AbstractC3231 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final byte[] f9706 = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(InterfaceC3773.f13027);

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        return obj instanceof C2608;
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        return -670243078;
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f9706);
    }

    @Override // defpackage.AbstractC3231
    /* renamed from: ԩ, reason: contains not printable characters */
    public Bitmap mo9540(@NonNull InterfaceC2731 interfaceC2731, @NonNull Bitmap bitmap, int i, int i2) {
        return b3.m114(interfaceC2731, bitmap, i, i2);
    }
}
