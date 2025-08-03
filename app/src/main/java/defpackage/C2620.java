package defpackage;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.InterfaceC3889;

/* compiled from: LruResourceCache.java */
/* renamed from: ɲ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2620 extends C4658<InterfaceC3773, InterfaceC4536<?>> implements InterfaceC3889 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC3889.InterfaceC3890 f9733;

    public C2620(long j) {
        super(j);
    }

    @Override // defpackage.InterfaceC3889
    @SuppressLint({"InlinedApi"})
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo9574(int i) {
        if (i >= 40) {
            m14135();
        } else if (i >= 20 || i == 15) {
            m14141(m14138() / 2);
        }
    }

    @Override // defpackage.InterfaceC3889
    @Nullable
    /* renamed from: ԩ, reason: contains not printable characters */
    public /* bridge */ /* synthetic */ InterfaceC4536 mo9575(@NonNull InterfaceC3773 interfaceC3773, @Nullable InterfaceC4536 interfaceC4536) {
        return (InterfaceC4536) super.m14139(interfaceC3773, interfaceC4536);
    }

    @Override // defpackage.InterfaceC3889
    /* renamed from: Ԫ, reason: contains not printable characters */
    public void mo9576(@NonNull InterfaceC3889.InterfaceC3890 interfaceC3890) {
        this.f9733 = interfaceC3890;
    }

    @Override // defpackage.InterfaceC3889
    @Nullable
    /* renamed from: ԫ, reason: contains not printable characters */
    public /* bridge */ /* synthetic */ InterfaceC4536 mo9577(@NonNull InterfaceC3773 interfaceC3773) {
        return (InterfaceC4536) super.m14140(interfaceC3773);
    }

    @Override // defpackage.C4658
    /* renamed from: ؠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public int mo9578(@Nullable InterfaceC4536<?> interfaceC4536) {
        return interfaceC4536 == null ? super.mo9578(null) : interfaceC4536.mo4977();
    }

    @Override // defpackage.C4658
    /* renamed from: ހ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo9579(@NonNull InterfaceC3773 interfaceC3773, @Nullable InterfaceC4536<?> interfaceC4536) {
        InterfaceC3889.InterfaceC3890 interfaceC3890 = this.f9733;
        if (interfaceC3890 == null || interfaceC4536 == null) {
            return;
        }
        interfaceC3890.mo4950(interfaceC4536);
    }
}
