package com.blink.academy.filter.core;

import android.opengl.GLES20;
import com.blink.academy.filter.core.FramebufferTexture;
import defpackage.C3624;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.blink.academy.filter.core.ՠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1794 extends C1793 {

    /* renamed from: ށ, reason: contains not printable characters */
    public List<C1793> f5141;

    /* renamed from: ނ, reason: contains not printable characters */
    public List<C1793> f5142;

    public C1794() {
        this(null);
    }

    public C1794(List<C1793> list) {
        this.f5141 = list;
        if (list == null) {
            this.f5141 = new ArrayList();
        }
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: Ϳ */
    public void mo4800() {
        Iterator<C1793> it = this.f5141.iterator();
        while (it.hasNext()) {
            it.next().mo4800();
        }
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: Ԩ */
    public C1788 mo4801(C1788 c1788, C1788 c17882, float[] fArr, float[] fArr2, Drawable2d drawable2d) {
        if (!this.f5131) {
            mo4803();
        }
        int size = this.f5142.size();
        C1788 c17883 = null;
        for (int i = 0; i < size; i++) {
            C1793 c1793 = this.f5142.get(i);
            if (i == size - 1) {
                c1793.mo4801(c1788, c17882, fArr, fArr2, drawable2d);
                if (c17883 != null) {
                    C1789.f5110.m4797(c17882);
                }
            } else {
                C1788 c1788Mo4801 = c1793.mo4801(null, c17882, fArr, fArr2, drawable2d);
                if (i != 0) {
                    C1789.f5110.m4797(c17882);
                }
                c17883 = c17882;
                c17882 = c1788Mo4801;
            }
        }
        return c1788;
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: ԩ */
    public void mo4809(int i, Drawable2d drawable2d) {
        float[] fArr = C3624.f12578;
        mo4802(i, fArr, fArr, drawable2d);
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: Ԫ */
    public void mo4802(int i, float[] fArr, float[] fArr2, Drawable2d drawable2d) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, iArr, 0);
        C1788 c1788 = new C1788(this.f5139, this.f5140, FramebufferTexture.Format.f5087, iArr[0], 0);
        C1788 c1788M4785 = C1788.m4785(i, 0, 0);
        C1789.f5110.m4794(c1788);
        C1789.f5110.m4794(c1788M4785);
        mo4801(c1788, c1788M4785, fArr, fArr2, drawable2d);
        C1789.f5110.m4797(c1788);
        C1789.f5110.m4797(c1788M4785);
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        if (this.f5131) {
            return;
        }
        Iterator<C1793> it = this.f5141.iterator();
        while (it.hasNext()) {
            it.next().mo4803();
        }
        this.f5131 = true;
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: ކ */
    public void mo4823(int i, int i2) {
        this.f5139 = i;
        this.f5140 = i2;
        Iterator<C1793> it = this.f5141.iterator();
        while (it.hasNext()) {
            it.next().mo4823(i, i2);
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m4824(C1793 c1793) {
        if (c1793 == null) {
            return;
        }
        this.f5141.add(c1793);
        m4828();
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m4825() {
        for (C1793 c1793 : this.f5141) {
            if (c1793 instanceof AbstractC1792) {
                ((AbstractC1792) c1793).m4805();
            }
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public C1788 m4826(C1788 c1788, C1788 c17882, Drawable2d drawable2d) {
        float[] fArr = C3624.f12578;
        return mo4801(c1788, c17882, fArr, fArr, drawable2d);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public List<C1793> m4827() {
        return this.f5142;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m4828() {
        if (this.f5141 == null) {
            return;
        }
        List<C1793> list = this.f5142;
        if (list == null) {
            this.f5142 = new ArrayList();
        } else {
            list.clear();
        }
        for (C1793 c1793 : this.f5141) {
            if (c1793 instanceof C1794) {
                C1794 c1794 = (C1794) c1793;
                c1794.m4828();
                List<C1793> listM4827 = c1794.m4827();
                if (listM4827 != null && !listM4827.isEmpty()) {
                    this.f5142.addAll(listM4827);
                }
            } else {
                this.f5142.add(c1793);
            }
        }
    }
}
