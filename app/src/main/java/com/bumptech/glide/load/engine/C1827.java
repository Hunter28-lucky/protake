package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.InterfaceC1809;
import defpackage.C4564;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC3773;
import defpackage.InterfaceC4900;
import java.io.File;
import java.util.List;

/* compiled from: ResourceCacheGenerator.java */
/* renamed from: com.bumptech.glide.load.engine.ؠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1827 implements InterfaceC1809, InterfaceC3129.InterfaceC3130<Object> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC1809.InterfaceC1810 f5340;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C1811<?> f5341;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f5342;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f5343 = -1;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC3773 f5344;

    /* renamed from: ՠ, reason: contains not printable characters */
    public List<InterfaceC4900<File, ?>> f5345;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f5346;

    /* renamed from: ֏, reason: contains not printable characters */
    public volatile InterfaceC4900.C4901<?> f5347;

    /* renamed from: ׯ, reason: contains not printable characters */
    public File f5348;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C4564 f5349;

    public C1827(C1811<?> c1811, InterfaceC1809.InterfaceC1810 interfaceC1810) {
        this.f5341 = c1811;
        this.f5340 = interfaceC1810;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809
    public void cancel() {
        InterfaceC4900.C4901<?> c4901 = this.f5347;
        if (c4901 != null) {
            c4901.f16545.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809
    /* renamed from: Ϳ */
    public boolean mo4916() {
        List<InterfaceC3773> listM4922 = this.f5341.m4922();
        boolean z = false;
        if (listM4922.isEmpty()) {
            return false;
        }
        List<Class<?>> listM4931 = this.f5341.m4931();
        if (listM4931.isEmpty() && File.class.equals(this.f5341.m4935())) {
            return false;
        }
        while (true) {
            if (this.f5345 != null && m4985()) {
                this.f5347 = null;
                while (!z && m4985()) {
                    List<InterfaceC4900<File, ?>> list = this.f5345;
                    int i = this.f5346;
                    this.f5346 = i + 1;
                    this.f5347 = list.get(i).mo8(this.f5348, this.f5341.m4937(), this.f5341.m4925(), this.f5341.m4929());
                    if (this.f5347 != null && this.f5341.m4938(this.f5347.f16545.mo7075())) {
                        this.f5347.f16545.mo7078(this.f5341.m4930(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f5343 + 1;
            this.f5343 = i2;
            if (i2 >= listM4931.size()) {
                int i3 = this.f5342 + 1;
                this.f5342 = i3;
                if (i3 >= listM4922.size()) {
                    return false;
                }
                this.f5343 = 0;
            }
            InterfaceC3773 interfaceC3773 = listM4922.get(this.f5342);
            Class<?> cls = listM4931.get(this.f5343);
            this.f5349 = new C4564(this.f5341.m4921(), interfaceC3773, this.f5341.m4933(), this.f5341.m4937(), this.f5341.m4925(), this.f5341.m4936(cls), cls, this.f5341.m4929());
            File fileMo10207 = this.f5341.m4923().mo10207(this.f5349);
            this.f5348 = fileMo10207;
            if (fileMo10207 != null) {
                this.f5344 = interfaceC3773;
                this.f5345 = this.f5341.m4928(fileMo10207);
                this.f5346 = 0;
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m4985() {
        return this.f5346 < this.f5345.size();
    }

    @Override // defpackage.InterfaceC3129.InterfaceC3130
    /* renamed from: ԩ */
    public void mo4918(@NonNull Exception exc) {
        this.f5340.mo4856(this.f5349, exc, this.f5347.f16545, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // defpackage.InterfaceC3129.InterfaceC3130
    /* renamed from: Ԭ */
    public void mo4919(Object obj) {
        this.f5340.mo4854(this.f5344, obj, this.f5347.f16545, DataSource.RESOURCE_DISK_CACHE, this.f5349);
    }
}
