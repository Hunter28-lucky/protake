package com.blink.academy.film.support.face.ui;

import android.util.Size;
import defpackage.C3483;
import defpackage.C4638;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: FaceDataStabilization.java */
/* renamed from: com.blink.academy.film.support.face.ui.Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C0789 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final String f1569 = "Ϳ";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f1570 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public HashMap<Integer, C0790> f1571 = new HashMap<>();

    /* renamed from: ԩ, reason: contains not printable characters */
    public GraphicOverlay f1572;

    /* compiled from: FaceDataStabilization.java */
    /* renamed from: com.blink.academy.film.support.face.ui.Ϳ$Ϳ, reason: contains not printable characters */
    public static class C0790 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public long f1573;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final List<C3483> f1574 = new ArrayList();

        /* renamed from: ԩ, reason: contains not printable characters */
        public C3483 f1575;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m1902(C3483 c3483, long j) {
            if (j - this.f1573 > 300) {
                this.f1574.clear();
            }
            this.f1573 = j;
            this.f1574.add(c3483);
            this.f1575 = m1904(this.f1574);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C3483 m1903(C3483 c3483, C3483 c34832) {
            if (c3483 == null) {
                return c34832;
            }
            if (c34832 == null) {
                return c3483;
            }
            int iM11337 = (c3483.m11337() + c34832.m11337()) >> 1;
            int iM11338 = (c3483.m11338() + c34832.m11338()) >> 1;
            int width = (c3483.m11343().getWidth() + c34832.m11343().getWidth()) >> 1;
            C3483 c34833 = new C3483(c3483.m11344(), iM11337, iM11338, new Size(width, width));
            c34833.m11348(c3483.m11342());
            c34833.m11347(c3483.m11341());
            c34833.m11346(c34832.m11340());
            c34833.m11345(c34832.m11339());
            return c34833;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C3483 m1904(List<C3483> list) {
            C3483 c3483M1903 = null;
            if (list.size() < 5) {
                return null;
            }
            Iterator<C3483> it = list.iterator();
            while (it.hasNext()) {
                c3483M1903 = m1903(c3483M1903, it.next());
            }
            return c3483M1903;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public C3483 m1905() {
            return this.f1575;
        }
    }

    public C0789(GraphicOverlay graphicOverlay) {
        this.f1572 = graphicOverlay;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m1901(List<C3483> list, int i, int i2) {
        if (this.f1570) {
            C4638.m14099(f1569, String.format("list.size : %s ", Integer.valueOf(list.size())));
        }
        this.f1572.m1895(i, i2, false);
        this.f1572.m1893();
        if (list.size() == 0) {
            this.f1571.clear();
        }
        for (C3483 c3483 : list) {
            Integer numM11344 = c3483.m11344();
            C0790 c0790 = this.f1571.get(numM11344);
            if (c0790 == null) {
                c0790 = new C0790();
            }
            c0790.m1902(c3483, System.currentTimeMillis());
            this.f1571.put(numM11344, c0790);
            if (c0790.m1905() != null) {
                this.f1572.m1892(new C0791(this.f1572, c0790.m1905()));
            }
        }
    }
}
