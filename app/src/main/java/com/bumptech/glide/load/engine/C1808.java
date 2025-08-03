package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.InterfaceC1809;
import defpackage.C2851;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC3773;
import defpackage.InterfaceC4900;
import java.io.File;
import java.util.List;

/* compiled from: DataCacheGenerator.java */
/* renamed from: com.bumptech.glide.load.engine.Ԩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1808 implements InterfaceC1809, InterfaceC3129.InterfaceC3130<Object> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final List<InterfaceC3773> f5248;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C1811<?> f5249;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC1809.InterfaceC1810 f5250;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f5251;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC3773 f5252;

    /* renamed from: ՠ, reason: contains not printable characters */
    public List<InterfaceC4900<File, ?>> f5253;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f5254;

    /* renamed from: ֏, reason: contains not printable characters */
    public volatile InterfaceC4900.C4901<?> f5255;

    /* renamed from: ׯ, reason: contains not printable characters */
    public File f5256;

    public C1808(C1811<?> c1811, InterfaceC1809.InterfaceC1810 interfaceC1810) {
        this(c1811.m4922(), c1811, interfaceC1810);
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809
    public void cancel() {
        InterfaceC4900.C4901<?> c4901 = this.f5255;
        if (c4901 != null) {
            c4901.f16545.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809
    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean mo4916() {
        while (true) {
            boolean z = false;
            if (this.f5253 != null && m4917()) {
                this.f5255 = null;
                while (!z && m4917()) {
                    List<InterfaceC4900<File, ?>> list = this.f5253;
                    int i = this.f5254;
                    this.f5254 = i + 1;
                    this.f5255 = list.get(i).mo8(this.f5256, this.f5249.m4937(), this.f5249.m4925(), this.f5249.m4929());
                    if (this.f5255 != null && this.f5249.m4938(this.f5255.f16545.mo7075())) {
                        this.f5255.f16545.mo7078(this.f5249.m4930(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f5251 + 1;
            this.f5251 = i2;
            if (i2 >= this.f5248.size()) {
                return false;
            }
            InterfaceC3773 interfaceC3773 = this.f5248.get(this.f5251);
            File fileMo10207 = this.f5249.m4923().mo10207(new C2851(interfaceC3773, this.f5249.m4933()));
            this.f5256 = fileMo10207;
            if (fileMo10207 != null) {
                this.f5252 = interfaceC3773;
                this.f5253 = this.f5249.m4928(fileMo10207);
                this.f5254 = 0;
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m4917() {
        return this.f5254 < this.f5253.size();
    }

    @Override // defpackage.InterfaceC3129.InterfaceC3130
    /* renamed from: ԩ, reason: contains not printable characters */
    public void mo4918(@NonNull Exception exc) {
        this.f5250.mo4856(this.f5252, exc, this.f5255.f16545, DataSource.DATA_DISK_CACHE);
    }

    @Override // defpackage.InterfaceC3129.InterfaceC3130
    /* renamed from: Ԭ, reason: contains not printable characters */
    public void mo4919(Object obj) {
        this.f5250.mo4854(this.f5252, obj, this.f5255.f16545, DataSource.DATA_DISK_CACHE, this.f5252);
    }

    public C1808(List<InterfaceC3773> list, C1811<?> c1811, InterfaceC1809.InterfaceC1810 interfaceC1810) {
        this.f5251 = -1;
        this.f5248 = list;
        this.f5249 = c1811;
        this.f5250 = interfaceC1810;
    }
}
