package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.InterfaceC3507;

/* compiled from: GifBitmapProvider.java */
/* renamed from: ପ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4426 implements InterfaceC3507.InterfaceC3508 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC2731 f15268;

    /* renamed from: Ԩ, reason: contains not printable characters */
    @Nullable
    public final InterfaceC4950 f15269;

    public C4426(InterfaceC2731 interfaceC2731, @Nullable InterfaceC4950 interfaceC4950) {
        this.f15268 = interfaceC2731;
        this.f15269 = interfaceC4950;
    }

    @Override // defpackage.InterfaceC3507.InterfaceC3508
    @NonNull
    /* renamed from: Ϳ */
    public Bitmap mo11446(int i, int i2, @NonNull Bitmap.Config config) {
        return this.f15268.mo9983(i, i2, config);
    }

    @Override // defpackage.InterfaceC3507.InterfaceC3508
    @NonNull
    /* renamed from: Ԩ */
    public int[] mo11447(int i) {
        InterfaceC4950 interfaceC4950 = this.f15269;
        return interfaceC4950 == null ? new int[i] : (int[]) interfaceC4950.mo9474(i, int[].class);
    }

    @Override // defpackage.InterfaceC3507.InterfaceC3508
    /* renamed from: ԩ */
    public void mo11448(@NonNull Bitmap bitmap) {
        this.f15268.mo9428(bitmap);
    }

    @Override // defpackage.InterfaceC3507.InterfaceC3508
    /* renamed from: Ԫ */
    public void mo11449(@NonNull byte[] bArr) {
        InterfaceC4950 interfaceC4950 = this.f15269;
        if (interfaceC4950 == null) {
            return;
        }
        interfaceC4950.put(bArr);
    }

    @Override // defpackage.InterfaceC3507.InterfaceC3508
    @NonNull
    /* renamed from: ԫ */
    public byte[] mo11450(int i) {
        InterfaceC4950 interfaceC4950 = this.f15269;
        return interfaceC4950 == null ? new byte[i] : (byte[]) interfaceC4950.mo9474(i, byte[].class);
    }

    @Override // defpackage.InterfaceC3507.InterfaceC3508
    /* renamed from: Ԭ */
    public void mo11451(@NonNull int[] iArr) {
        InterfaceC4950 interfaceC4950 = this.f15269;
        if (interfaceC4950 == null) {
            return;
        }
        interfaceC4950.put(iArr);
    }
}
