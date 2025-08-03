package defpackage;

import android.graphics.Paint;
import android.text.TextPaint;
import com.blink.academy.film.FilmApp;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GridsHelper.java */
/* renamed from: Ȇ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2513 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static C2513 f9319;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public ArrayList<C2685> f9320 = new ArrayList<>();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public ArrayList<C4196> f9321 = new ArrayList<>();

    /* renamed from: ԩ, reason: contains not printable characters */
    public ArrayList<C4196> f9322 = new ArrayList<>();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public ArrayList<C4196> f9323 = new ArrayList<>();

    /* renamed from: ԫ, reason: contains not printable characters */
    public ArrayList<C4196> f9324 = new ArrayList<>();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f9325;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f9326;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f9327;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static C2513 m9282() {
        if (f9319 == null) {
            synchronized (C2513.class) {
                if (f9319 == null) {
                    f9319 = new C2513();
                }
            }
        }
        return f9319;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public ArrayList<C4196> m9283() {
        return this.f9321;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m9284() {
        return this.f9325;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m9285() {
        return this.f9326;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int m9286() {
        return this.f9327;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public ArrayList<C2685> m9287() {
        return this.f9320;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public ArrayList<C4196> m9288() {
        return this.f9323;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<C4196> m9289() {
        return this.f9324;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final String m9290(C3255 c3255) {
        return String.format("%s:%s", w.m8496(c3255.m10920() + ""), w.m8496(c3255.m10924() + ""));
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public ArrayList<C4196> m9291() {
        return this.f9322;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public C2685 m9292(int i) {
        return this.f9320.get(i);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m9293(ArrayList<C2685> arrayList) {
        int i = C2579.f9594;
        if (i == 0) {
            return;
        }
        int iM14386 = (int) (C4792.m14375().m14386() * C4792.m14375().m14434());
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14381());
        textPaint.setTypeface(FilmApp.m404());
        int iMeasureText = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iMeasureText = (int) (iMeasureText + textPaint.measureText(FilmApp.m402().getResources().getString(arrayList.get(i2).m9905()).toUpperCase()));
        }
        if ((iM14386 * 2 * arrayList.size()) + iMeasureText + (C2579.m9438(20.0f) * (arrayList.size() - 1)) > i) {
            int size = (int) (((i - r5) / arrayList.size()) / 2.0f);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList.get(i3).m9906(size);
            }
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m9294() {
        this.f9320.clear();
        this.f9321.clear();
        this.f9322.clear();
        this.f9323.clear();
        ArrayList<C2685> arrayListM14862 = C5050.m14861().m14862();
        for (int i = 0; i < arrayListM14862.size(); i++) {
            C2685 c2685 = arrayListM14862.get(i);
            if (c2685.isSelected()) {
                this.f9325 = i;
            }
            this.f9320.add(c2685);
        }
        ArrayList<C3255> arrayListM11232 = C3444.m11232();
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12429 = c3891M13890.m12429();
        if (iM12429 == 0) {
            if (arrayListM11232.get(0).m10921() != 1.7777778f) {
                arrayListM11232.remove(0);
                arrayListM11232.add(0, C3444.m11227().m11243());
            }
        } else if (iM12429 == 2) {
            if (arrayListM11232.get(0).m10921() != 2.76f) {
                arrayListM11232.remove(0);
                arrayListM11232.add(0, C3444.m11227().m11236());
            }
        } else if (arrayListM11232.get(0).m10921() != 2.37f) {
            arrayListM11232.remove(0);
            arrayListM11232.add(0, C3444.m11227().m11235());
        }
        int i2 = 0;
        while (i2 < arrayListM11232.size()) {
            C4196 c4196 = new C4196();
            C3255 c3255 = arrayListM11232.get(i2);
            if (c3255.m10921() != (c3891M13890.m12404() * 1.0f) / c3891M13890.m12403()) {
                c4196.setSelected(false);
            } else if (c3891M13890.m12425() != 0 || i2 == 0) {
                c4196.setSelected(true);
                this.f9326 = i2;
            } else {
                c4196.setSelected(false);
            }
            c4196.m13244(c3255);
            if (C4792.m14375().m14498()) {
                c4196.m13251(m9290(c3255));
            } else {
                c4196.m13251(c3255.m10922());
            }
            c4196.m13252(c3255.m10923());
            c4196.setItemViewType(3);
            this.f9321.add(c4196);
            i2++;
        }
        ArrayList<C4460> arrayListM14864 = C5050.m14861().m14864();
        for (int i3 = 0; i3 < arrayListM14864.size(); i3++) {
            C4196 c41962 = new C4196();
            c41962.setItemViewType(5);
            C4460 c4460 = arrayListM14864.get(i3);
            if (c4460.m13721() == (c3891M13890.m12464() * 1.0f) / 100.0f) {
                c41962.setSelected(true);
                this.f9327 = i3;
            } else {
                c41962.setSelected(false);
            }
            c41962.m13249(c4460);
            c41962.m13251(c4460.toString());
            this.f9322.add(c41962);
        }
        ArrayList<C2944> arrayListM14863 = C5050.m14861().m14863();
        for (int i4 = 0; i4 < arrayListM14863.size(); i4++) {
            C4196 c41963 = new C4196();
            c41963.setItemViewType(5);
            C2944 c2944 = arrayListM14863.get(i4);
            int type = c2944.getType();
            if (type == 0) {
                c41963.setSelected(c3891M13890.m12470() == 1);
                c2944.setSelected(c3891M13890.m12470() == 1);
            } else if (type == 1) {
                c41963.setSelected(c3891M13890.m12405() == 1);
                c2944.setSelected(c3891M13890.m12405() == 1);
            } else if (type == 2) {
                c41963.setSelected(c3891M13890.m12427() == 1);
                c2944.setSelected(c3891M13890.m12427() == 1);
            }
            c41963.m13246(c2944);
            c41963.m13251(c2944.m10345());
            c41963.m13252(c2944.m10346());
            this.f9323.add(c41963);
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final float m9295() {
        float fMeasureText;
        int iM14386;
        Paint paint = new Paint();
        paint.setTextSize(C4792.m14375().m14386());
        paint.setTypeface(FilmApp.m404());
        Iterator<C4196> it = this.f9323.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            C4196 next = it.next();
            if (next.m13233() != 0) {
                fMeasureText = paint.measureText(FilmApp.m402().getResources().getString(next.m13233()));
                iM14386 = C4792.m14375().m14386();
            } else {
                fMeasureText = paint.measureText(next.m13232());
                iM14386 = C4792.m14375().m14386();
            }
            f += fMeasureText + (iM14386 * 2) + 2.0f;
        }
        float fM9438 = C2579.f9598 - C2579.m9438(15.0f);
        if (f > fM9438) {
            return fM9438 / f;
        }
        return 1.0f;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m9296(int i) {
        this.f9324.clear();
        if (i == 1) {
            this.f9324.addAll(this.f9322);
        } else {
            if (i != 2) {
                return;
            }
            this.f9324.addAll(this.f9323);
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m9297(int i) {
        this.f9325 = i;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m9298(int i) {
        this.f9326 = i;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m9299(int i) {
        this.f9327 = i;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m9300() {
        float fM9295 = m9295();
        Iterator<C4196> it = this.f9323.iterator();
        while (it.hasNext()) {
            C4196 next = it.next();
            next.m13243((int) (C4792.m14375().m14386() * fM9295));
            next.m13248((int) (C4792.m14375().m14386() * fM9295));
        }
    }
}
