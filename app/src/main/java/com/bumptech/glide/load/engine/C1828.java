package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.InterfaceC1809;
import defpackage.AbstractC3541;
import defpackage.C2851;
import defpackage.C4904;
import defpackage.C5147;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC3773;
import defpackage.InterfaceC3823;
import defpackage.InterfaceC4900;
import java.util.Collections;
import java.util.List;

/* compiled from: SourceGenerator.java */
/* renamed from: com.bumptech.glide.load.engine.ހ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1828 implements InterfaceC1809, InterfaceC3129.InterfaceC3130<Object>, InterfaceC1809.InterfaceC1810 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C1811<?> f5350;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC1809.InterfaceC1810 f5351;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f5352;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C1808 f5353;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Object f5354;

    /* renamed from: ՠ, reason: contains not printable characters */
    public volatile InterfaceC4900.C4901<?> f5355;

    /* renamed from: ֈ, reason: contains not printable characters */
    public C2851 f5356;

    public C1828(C1811<?> c1811, InterfaceC1809.InterfaceC1810 interfaceC1810) {
        this.f5350 = c1811;
        this.f5351 = interfaceC1810;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809
    public void cancel() {
        InterfaceC4900.C4901<?> c4901 = this.f5355;
        if (c4901 != null) {
            c4901.f16545.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809
    /* renamed from: Ϳ */
    public boolean mo4916() {
        Object obj = this.f5354;
        if (obj != null) {
            this.f5354 = null;
            m4986(obj);
        }
        C1808 c1808 = this.f5353;
        if (c1808 != null && c1808.mo4916()) {
            return true;
        }
        this.f5353 = null;
        this.f5355 = null;
        boolean z = false;
        while (!z && m4987()) {
            List<InterfaceC4900.C4901<?>> listM4926 = this.f5350.m4926();
            int i = this.f5352;
            this.f5352 = i + 1;
            this.f5355 = listM4926.get(i);
            if (this.f5355 != null && (this.f5350.m4924().mo11484(this.f5355.f16545.mo7077()) || this.f5350.m4938(this.f5355.f16545.mo7075()))) {
                this.f5355.f16545.mo7078(this.f5350.m4930(), this);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809.InterfaceC1810
    /* renamed from: Ԩ */
    public void mo4854(InterfaceC3773 interfaceC3773, Object obj, InterfaceC3129<?> interfaceC3129, DataSource dataSource, InterfaceC3773 interfaceC37732) {
        this.f5351.mo4854(interfaceC3773, obj, interfaceC3129, this.f5355.f16545.mo7077(), interfaceC3773);
    }

    @Override // defpackage.InterfaceC3129.InterfaceC3130
    /* renamed from: ԩ */
    public void mo4918(@NonNull Exception exc) {
        this.f5351.mo4856(this.f5356, exc, this.f5355.f16545, this.f5355.f16545.mo7077());
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809.InterfaceC1810
    /* renamed from: Ԫ */
    public void mo4856(InterfaceC3773 interfaceC3773, Exception exc, InterfaceC3129<?> interfaceC3129, DataSource dataSource) {
        this.f5351.mo4856(interfaceC3773, exc, interfaceC3129, this.f5355.f16545.mo7077());
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809.InterfaceC1810
    /* renamed from: ԫ */
    public void mo4857() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.InterfaceC3129.InterfaceC3130
    /* renamed from: Ԭ */
    public void mo4919(Object obj) {
        AbstractC3541 abstractC3541M4924 = this.f5350.m4924();
        if (obj == null || !abstractC3541M4924.mo11484(this.f5355.f16545.mo7077())) {
            this.f5351.mo4854(this.f5355.f16543, obj, this.f5355.f16545, this.f5355.f16545.mo7077(), this.f5356);
        } else {
            this.f5354 = obj;
            this.f5351.mo4857();
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4986(Object obj) {
        long jM14630 = C4904.m14630();
        try {
            InterfaceC3823<X> interfaceC3823M4934 = this.f5350.m4934(obj);
            C5147 c5147 = new C5147(interfaceC3823M4934, obj, this.f5350.m4929());
            this.f5356 = new C2851(this.f5355.f16543, this.f5350.m4933());
            this.f5350.m4923().mo10208(this.f5356, c5147);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f5356 + ", data: " + obj + ", encoder: " + interfaceC3823M4934 + ", duration: " + C4904.m14629(jM14630));
            }
            this.f5355.f16545.mo7076();
            this.f5353 = new C1808(Collections.singletonList(this.f5355.f16543), this.f5350, this);
        } catch (Throwable th) {
            this.f5355.f16545.mo7076();
            throw th;
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean m4987() {
        return this.f5352 < this.f5350.m4926().size();
    }
}
