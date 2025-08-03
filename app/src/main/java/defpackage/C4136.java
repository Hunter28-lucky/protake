package defpackage;

import com.blink.academy.film.netbean.FilterUIBean;
import com.blink.academy.film.netbean.store.FilterGroupBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PreviewDataManager.java */
/* renamed from: অ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4136 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C4136 f14333;

    /* compiled from: PreviewDataManager.java */
    /* renamed from: অ$Ϳ, reason: contains not printable characters */
    public class C4137 extends TypeToken<List<FilterGroupBean>> {
        public C4137() {
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static C4136 m13108() {
        if (f14333 == null) {
            synchronized (C4136.class) {
                if (f14333 == null) {
                    f14333 = new C4136();
                }
            }
        }
        return f14333;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m13109(int[] iArr) {
        List<C2531> listM13179 = C4151.m13162().m13179();
        if (r1.m8139(listM13179)) {
            return true;
        }
        for (int i : iArr) {
            boolean z = false;
            for (C2531 c2531 : listM13179) {
                String strM9347 = c2531.m9347();
                if (i == c2531.m9346() && r1.m8143(strM9347)) {
                    z = true;
                }
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m13110(int i) {
        if (i == 0) {
            return false;
        }
        C5244 c5244M13180 = C4151.m13162().m13180();
        if (r1.m8137(c5244M13180)) {
            return true;
        }
        String strM15270 = c5244M13180.m15270();
        if (!r1.m8143(strM15270)) {
            return true;
        }
        for (FilterGroupBean filterGroupBean : (List) new Gson().fromJson(strM15270, new C4137().getType())) {
            if (filterGroupBean.getId() == i && m13108().m13109(filterGroupBean.getFilters())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m13111(h0 h0Var) {
        List<FilterUIBean> listM6126 = h0Var.m6126();
        if (r1.m8139(listM6126)) {
            return false;
        }
        for (int i = 0; i < listM6126.size() && !r1.m8138(listM6126.get(i).getReal_path()); i++) {
            if (i == listM6126.size() - 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m13112(int i) {
        ArrayList<h0> arrayListM11244 = C3444.m11227().m11244();
        if (r1.m8144(arrayListM11244)) {
            for (int i2 = 0; i2 < arrayListM11244.size(); i2++) {
                if (arrayListM11244.get(i2).m6136() == i) {
                    return i2;
                }
            }
        }
        return 0;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean m13113(int i) {
        ArrayList<h0> arrayListM11244 = C3444.m11227().m11244();
        if (r1.m8144(arrayListM11244)) {
            return m13108().m13114(arrayListM11244.get(i));
        }
        return true;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m13114(h0 h0Var) {
        if (h0Var.m6136() == 0) {
            return false;
        }
        return e5.m5988().m5993() ? !m13111(h0Var) : h0Var.m6147();
    }
}
