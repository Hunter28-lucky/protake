package defpackage;

import android.content.res.Resources;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.netbean.store.FilterGroupCollectionBean;
import com.blink.academy.protake.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LooksHelper.java */
/* renamed from: ఒ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4511 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static C4511 f15451;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f15454;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f15456;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f15457;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f15452 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public ArrayList<C4196> f15453 = new ArrayList<>();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f15455 = 0;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f15458 = false;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public List<h0> f15459 = new ArrayList();

    /* renamed from: ԫ, reason: contains not printable characters */
    public static C4511 m13838() {
        if (f15451 == null) {
            synchronized (C4511.class) {
                if (f15451 == null) {
                    f15451 = new C4511();
                }
            }
        }
        return f15451;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m13839() {
        if (this.f15453 != null) {
            return !m13852(C4535.m13880().m13890().m12442());
        }
        return false;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m13840() {
        return this.f15457;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public C4196 m13841(int i) {
        return this.f15453.get(this.f15457);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m13842(h0 h0Var) {
        String name_th;
        FilterGroupCollectionBean filterGroupCollectionBeanM6140 = h0Var.m6140();
        if (r1.m8142(filterGroupCollectionBeanM6140) && filterGroupCollectionBeanM6140.getFilter_groups() != null) {
            if (C5213.m15210()) {
                name_th = filterGroupCollectionBeanM6140.getName_cn();
                if (C5213.m15219() && r1.m8143(filterGroupCollectionBeanM6140.getName_zht())) {
                    name_th = filterGroupCollectionBeanM6140.getName_zht();
                }
            } else {
                name_th = C5213.m15217() ? filterGroupCollectionBeanM6140.getName_th() : C5213.m15216() ? filterGroupCollectionBeanM6140.getName_kr() : C5213.m15213() ? filterGroupCollectionBeanM6140.getName_ja() : filterGroupCollectionBeanM6140.getName_en();
            }
            int length = filterGroupCollectionBeanM6140.getFilter_groups().length;
            if (r1.m8143(name_th) && length != 0) {
                return String.format("%s (%s)", name_th, Integer.valueOf(length));
            }
        }
        return "";
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public ArrayList<C4196> m13843() {
        return this.f15453;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public int m13844(h0 h0Var) {
        return h0Var.m6136();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String m13845(String str, String str2) {
        return C4151.m13162().m13184(false, str, str2);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public int m13846(C4196 c4196) {
        if (c4196 != null) {
            return c4196.m13231();
        }
        return 0;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public float m13847(h0 h0Var) {
        return h0Var.m6139();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public h0 m13848(int i) {
        if (i == -1) {
            i = 0;
        }
        return this.f15453.get(i).m13228();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m13849() throws Resources.NotFoundException {
        String string;
        boolean zM14498 = C4792.m14375().m14498();
        this.f15453.clear();
        C3891 c3891M13890 = C4535.m13880().m13890();
        ArrayList<h0> arrayListM11244 = C3444.m11227().m11244();
        int iM12442 = c3891M13890.m12442();
        float fM12438 = c3891M13890.m12438();
        if (r1.m8144(arrayListM11244)) {
            int i = 0;
            while (i < arrayListM11244.size()) {
                h0 h0Var = arrayListM11244.get(i);
                h0Var.setSelected(h0Var.m6136() == iM12442);
                C4196 c4196M13247 = new C4196().m13247(h0Var);
                c4196M13247.setSelected(h0Var.isSelected());
                if (m13853(h0Var)) {
                    c4196M13247.m13250(3);
                } else if (m13851()) {
                    c4196M13247.m13250(h0Var.isSelected() ? 2 : 0);
                } else {
                    c4196M13247.m13250(h0Var.isSelected() ? 1 : 0);
                }
                h0Var.m6175(h0Var.isSelected() ? fM12438 : 100.0f);
                if (i == this.f15455 && !this.f15456) {
                    h0Var.m6172(false);
                }
                if (!C5213.m15210()) {
                    string = C5213.m15213() ? i == 0 ? FilmApp.m402().getResources().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF) : h0Var.m6131() : C5213.m15216() ? i == 0 ? FilmApp.m402().getResources().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF) : h0Var.m6132() : C5213.m15217() ? i == 0 ? FilmApp.m402().getResources().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF) : h0Var.m6133() : i == 0 ? FilmApp.m402().getResources().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF) : h0Var.m6130();
                } else if (i == 0) {
                    string = FilmApp.m402().getResources().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF);
                } else {
                    string = h0Var.m6129();
                    if (C5213.m15219() && r1.m8143(h0Var.m6134())) {
                        string = h0Var.m6134();
                    }
                }
                c4196M13247.m13251(string);
                if (zM14498) {
                    c4196M13247.setItemViewType(7);
                } else {
                    c4196M13247.setItemViewType(2);
                }
                this.f15453.add(c4196M13247);
                if (h0Var.isSelected()) {
                    this.f15457 = i;
                }
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0297  */
    /* renamed from: ׯ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int m13850(java.util.List<defpackage.C2531> r22, defpackage.C3891 r23, java.util.List<com.blink.academy.film.netbean.store.FilterGroupBean> r24, java.util.List<com.blink.academy.film.netbean.store.FilterBean> r25, java.util.List<com.blink.academy.film.netbean.store.FilterGroupCollectionBean> r26, int r27) {
        /*
            Method dump skipped, instructions count: 1017
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C4511.m13850(java.util.List, ࠆ, java.util.List, java.util.List, java.util.List, int):int");
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean m13851() {
        return this.f15454;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final boolean m13852(int i) {
        return i == 0;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean m13853(h0 h0Var) {
        return C4136.m13108().m13114(h0Var);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m13854() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12442 = c3891M13890.m12442();
        float fM12438 = c3891M13890.m12438();
        for (int i = 0; i < this.f15453.size(); i++) {
            C4196 c4196 = this.f15453.get(i);
            h0 h0VarM13228 = c4196.m13228();
            c4196.setSelected(h0VarM13228.m6136() == iM12442);
            if (m13853(h0VarM13228)) {
                c4196.m13250(3);
                if (h0VarM13228.m6136() == iM12442) {
                    c4196.setSelected(false);
                    this.f15453.get(0).setSelected(true);
                } else {
                    c4196.setSelected(h0VarM13228.m6136() == iM12442);
                }
            } else {
                c4196.m13250(h0VarM13228.m6136() == iM12442 ? 1 : 0);
                c4196.setSelected(h0VarM13228.m6136() == iM12442);
            }
            c4196.m13228().m6175(h0VarM13228.m6136() == iM12442 ? fM12438 : 100.0f);
            c4196.m13228().m6172(true);
        }
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m13855(int i) {
        this.f15457 = i;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m13856(int i) {
        C4196 c4196 = this.f15453.get(i);
        c4196.setSelected(true);
        c4196.m13228().setSelected(true);
        c4196.m13250(1);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m13857(ArrayList<C4196> arrayList, int i) {
        C4196 c4196 = arrayList.get(i);
        c4196.setSelected(true);
        c4196.m13228().setSelected(true);
        c4196.m13250(1);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m13858(int i) {
        C4196 c4196 = this.f15453.get(i);
        c4196.setSelected(false);
        h0 h0VarM13228 = c4196.m13228();
        h0VarM13228.setSelected(false);
        h0VarM13228.m6175(100.0f);
        c4196.m13250(0);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m13859(ArrayList<C4196> arrayList, int i) {
        C4196 c4196 = arrayList.get(i);
        c4196.setSelected(false);
        h0 h0VarM13228 = c4196.m13228();
        h0VarM13228.setSelected(false);
        h0VarM13228.m6175(100.0f);
        c4196.m13250(0);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m13860(boolean z) {
        this.f15456 = z;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m13861(boolean z) {
        this.f15454 = z;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m13862(int i, C4196 c4196) {
        if (c4196 != null) {
            c4196.m13250(i);
        }
    }
}
