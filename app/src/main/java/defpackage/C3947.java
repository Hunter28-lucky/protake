package defpackage;

import android.os.Build;
import android.util.Range;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.mob.pushsdk.MobPush;
import defpackage.AbstractC2341;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: IsoExposureHelper.java */
/* renamed from: ࡕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3947 {

    /* renamed from: ޞ, reason: contains not printable characters */
    public static final String f13600 = "ࡕ";

    /* renamed from: ޟ, reason: contains not printable characters */
    public static C3947 f13601 = null;

    /* renamed from: ޠ, reason: contains not printable characters */
    public static boolean f13602 = false;

    /* renamed from: ޡ, reason: contains not printable characters */
    public static final float[] f13603 = {360.0f, 324.0f, 270.0f, 216.0f, 180.0f, 172.8f, 150.0f, 144.0f, 120.0f, 108.0f, 90.0f, 75.0f, 72.0f, 60.0f, 45.0f, 37.5f, 30.0f, 22.5f, 15.0f, 11.2f, 9.0f, 7.0f, 5.0f, 3.0f, 1.0f, 0.5f};

    /* renamed from: ޢ, reason: contains not printable characters */
    public static final float[] f13604 = {6.0f, 12.0f, 24.0f, 25.0f, 30.0f, 50.0f, 60.0f, 100.0f, 125.0f, 200.0f, 250.0f, 500.0f, 1000.0f, 2000.0f, 3000.0f, 4000.0f};

    /* renamed from: ޣ, reason: contains not printable characters */
    public static long f13605;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public AbstractC2341.C2343 f13606;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f13607;

    /* renamed from: ԩ, reason: contains not printable characters */
    public List<Float> f13608;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public List<String> f13609;

    /* renamed from: ԫ, reason: contains not printable characters */
    public List<Float> f13610;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public List<String> f13611;

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<Integer> f13612;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f13613;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f13614;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f13615;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f13616;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f13617;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f13618;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f13619;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f13620;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f13621;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f13622;

    /* renamed from: ރ, reason: contains not printable characters */
    public float f13623;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f13624;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f13625;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f13626;

    /* renamed from: އ, reason: contains not printable characters */
    public int f13627;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f13628;

    /* renamed from: މ, reason: contains not printable characters */
    public int f13629;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f13630;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f13631;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f13632;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f13633;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f13634;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f13635;

    /* renamed from: ސ, reason: contains not printable characters */
    public boolean f13636;

    /* renamed from: ޑ, reason: contains not printable characters */
    public boolean f13637;

    /* renamed from: ޒ, reason: contains not printable characters */
    public boolean f13638;

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean f13639;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f13640;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f13641;

    /* renamed from: ޖ, reason: contains not printable characters */
    public long f13642;

    /* renamed from: ޗ, reason: contains not printable characters */
    public boolean f13643;

    /* renamed from: ޘ, reason: contains not printable characters */
    public boolean f13644;

    /* renamed from: ޙ, reason: contains not printable characters */
    public boolean f13645;

    /* renamed from: ޚ, reason: contains not printable characters */
    public List<InterfaceC3949> f13646;

    /* renamed from: ޜ, reason: contains not printable characters */
    public int[] f13648;

    /* renamed from: ޛ, reason: contains not printable characters */
    public int f13647 = 0;

    /* renamed from: ޝ, reason: contains not printable characters */
    public int f13649 = 0;

    /* compiled from: IsoExposureHelper.java */
    /* renamed from: ࡕ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC3948 {
        /* renamed from: Ϳ */
        void mo1308();
    }

    /* compiled from: IsoExposureHelper.java */
    /* renamed from: ࡕ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC3949 {
        void onChange();
    }

    static {
        f13605 = 1000000000L;
        if (Build.MANUFACTURER.equalsIgnoreCase(MobPush.Channels.HUAWEI)) {
            f13605 = 500000000L;
        }
    }

    public C3947() {
        m12776();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static float m12726(float f, int i, int i2) {
        if (f == 0.5f) {
            return 0.0f;
        }
        float f2 = 1.0f - f;
        char c = f2 < 0.25f ? (char) 0 : (((double) f2) < 0.25d || f2 >= 0.5f) ? (f2 <= 0.5f || f2 > 0.75f) ? (char) 65534 : (char) 65535 : (char) 1;
        float f3 = i;
        float f4 = f3 * 0.5f;
        float f5 = f4 + 0.5f;
        float f6 = (f3 * 1.0f) + 0.5f;
        float f7 = -f4;
        float f8 = -f6;
        if (c == 65534) {
            return f7 + ((f8 - f7) * ((f2 - 0.75f) / 0.25f));
        }
        if (c == 65535) {
            return f7 * ((f2 - 0.5f) / 0.25f);
        }
        if (c == 0) {
            return f5 + ((f6 - f5) * ((0.25f - f2) / 0.25f));
        }
        if (c != 1) {
            return 0.0f;
        }
        return f5 * ((0.25f - (f2 - 0.25f)) / 0.25f);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static C3947 m12727() {
        if (f13601 == null) {
            synchronized (C3947.class) {
                if (f13601 == null) {
                    f13601 = new C3947();
                }
            }
        }
        return f13601;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m12728(float f) {
        float f2 = 1.0f / f;
        if (this.f13610.contains(Float.valueOf(f2))) {
            return;
        }
        this.f13610.add(Float.valueOf(f2));
        if (f < 1.0f) {
            float fFloatValue = new BigDecimal(f2).setScale(1, 4).floatValue();
            if (String.valueOf(fFloatValue).endsWith("0")) {
                this.f13611.add("" + ((long) fFloatValue));
            } else {
                this.f13611.add("" + fFloatValue);
            }
        } else {
            this.f13611.add("1/" + ((long) f));
        }
        if (f13602) {
            if (f >= 1.0f) {
                C4638.m14099(f13600, "1/" + ((long) f));
                return;
            }
            float fFloatValue2 = new BigDecimal(f2).setScale(1, 4).floatValue();
            C4638.m14099(f13600, "" + fFloatValue2);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m12729() {
        return this.f13634;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m12730(float f) {
        int iRound;
        int i = this.f13648[1];
        float f2 = i * 0.5f;
        float f3 = i * 1.0f;
        float f4 = -(i * 0.5f);
        float f5 = -(i * 1.0f);
        if (f == 0.0f) {
            iRound = 0;
        } else if (f > 0.0f) {
            if (f > 0.5f) {
                iRound = Math.round(f2 + ((f3 - f2) * ((f - 0.5f) / 0.5f)));
            } else {
                iRound = Math.round(f2 * (f / 0.5f));
            }
        } else if (f < -0.5f) {
            iRound = Math.round(f4 + ((f5 - f4) * (((-0.5f) - f) / 0.5f)));
        } else {
            iRound = Math.round(f4 * ((-f) / 0.5f));
        }
        C4638.m14099("slim", "result:" + iRound);
        return iRound;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C3485 m12731() {
        C4506 c4506M8784;
        AbstractC2341.C2343 c2343 = this.f13606;
        if (c2343 == null || (c4506M8784 = c2343.m8784()) == null) {
            return null;
        }
        return c4506M8784.m13807();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public float m12732() {
        return this.f13625;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float m12733() {
        return this.f13624;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public float m12734() {
        return this.f13620;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float m12735() {
        return this.f13614;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public float m12736() {
        return this.f13622;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public float m12737() {
        return this.f13626;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public float m12738() {
        return this.f13613;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public float m12739() {
        return this.f13621;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public List<Float> m12740() {
        return this.f13608;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public List<String> m12741() {
        return this.f13609;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public float m12742() {
        return this.f13623;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public float m12743(float f) {
        return (float) Math.sqrt(f);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public float m12744() {
        float f = this.f13620;
        int[] iArr = this.f13648;
        return m12726(f, iArr[1], iArr[0]);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public List<Float> m12745() {
        return this.f13610;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public List<String> m12746() {
        return this.f13611;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public int m12747() {
        return this.f13607;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public List<Integer> m12748() {
        return this.f13612;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public boolean m12749() {
        return this.f13639;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public float m12750(float f) {
        return (float) Math.sqrt(f);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public int m12751() {
        return this.f13640;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public int m12752() {
        return this.f13641;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public float m12753(float f) {
        return (float) (Math.log(f) / Math.log(2.0d));
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public float m12754(float f) {
        return (float) Math.pow(2.0d, f);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public float m12755(float f) {
        return (float) Math.pow(f, 2.0d);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public float m12756(float f) {
        return (float) (1.0d - Math.pow(1.0f - f, 0.5d));
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public float m12757(float f) {
        return (float) Math.pow(f, 2.0d);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public int m12758() {
        return this.f13632;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public int m12759() {
        return this.f13633;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public float m12760(int i) {
        float f = 1000.0f / i;
        long j = this.f13642;
        float f2 = j > 0 ? 1.0E9f / j : 1.0f;
        return f < f2 ? f2 : f;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public int m12761() {
        return this.f13635;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m12762() {
        boolean z;
        float fRound;
        long jRound;
        float fRound2;
        long jRound2;
        float f;
        float fRound3;
        long jRound3;
        if (this.f13617) {
            this.f13617 = false;
            this.f13610 = new ArrayList();
            this.f13611 = new ArrayList();
            this.f13608 = new ArrayList();
            this.f13609 = new ArrayList();
            C4506 c4506M8784 = this.f13606.m8784();
            this.f13607 = this.f13606.m8785().m12229();
            long jM13813 = c4506M8784.m13813();
            long jMin = Math.min(f13605, c4506M8784.m13811());
            this.f13642 = jMin;
            float fM12760 = this.f13607;
            int iM12471 = C4535.m13880().m13890().m12471();
            if (iM12471 != 0) {
                fM12760 = m12760(iM12471);
                z = true;
            } else {
                z = false;
            }
            float[] fArr = f13603;
            int length = fArr.length;
            int i = 0;
            while (i < length) {
                float f2 = fArr[i];
                float[] fArr2 = fArr;
                double d = f2 / (fM12760 * 360.0f);
                double dMin = d * 1000.0d * 1000.0d * 1000.0d;
                if (z) {
                    dMin = Math.min(jMin, Math.max(jM13813, dMin));
                    double d2 = dMin / 1.0E9d;
                    if (d2 >= 1.0d) {
                        fRound3 = (float) (1.0d / d2);
                    } else {
                        jRound3 = Math.round(1.0d / d2);
                        fRound3 = jRound3;
                    }
                } else {
                    fRound3 = Math.round(1.0d / d);
                    if (fRound3 < fM12760) {
                        jRound3 = (long) fM12760;
                        fRound3 = jRound3;
                    }
                }
                if (dMin >= jM13813 && dMin <= jMin) {
                    this.f13608.add(Float.valueOf(f2));
                    int i2 = (int) f2;
                    if (f2 - i2 > 0.0f) {
                        this.f13609.add(f2 + "°");
                    } else {
                        this.f13609.add(i2 + "°");
                    }
                    if (f13602) {
                        String str = f13600;
                        StringBuilder sb = new StringBuilder();
                        sb.append("opener:");
                        sb.append(f2);
                        sb.append(MyUTIL.white_space);
                        sb.append(this.f13609.get(r13.size() - 1));
                        sb.append(" minExposureTime:");
                        sb.append(jM13813);
                        C4638.m14099(str, sb.toString());
                    }
                    if (z && f2 == 360.0f) {
                        m12728(fRound3);
                    }
                }
                i++;
                fArr = fArr2;
            }
            boolean z2 = true;
            ArrayList arrayList = new ArrayList();
            for (float f3 : f13604) {
                arrayList.add(Float.valueOf(f3));
            }
            float f4 = fM12760 * 360.0f;
            double d3 = 0.5f / f4;
            double dMin2 = d3 * 1000.0d * 1000.0d * 1000.0d;
            if (z) {
                dMin2 = Math.min(jMin, Math.max(jM13813, dMin2));
                double d4 = dMin2 / 1.0E9d;
                if (d4 >= 1.0d) {
                    fRound = (float) (1.0d / d4);
                } else {
                    jRound = Math.round(1.0d / d4);
                    fRound = jRound;
                }
            } else {
                fRound = Math.round(1.0d / d3);
                if (fRound < fM12760) {
                    jRound = (long) fM12760;
                    fRound = jRound;
                }
            }
            double d5 = jM13813;
            if (dMin2 >= d5 && dMin2 <= jMin) {
                float f5 = 4000.0f;
                while (z2) {
                    f5 *= 2.0f;
                    if (fRound > f5) {
                        arrayList.add(Float.valueOf(f5));
                    } else {
                        z2 = false;
                    }
                }
                arrayList.add(Float.valueOf(fRound));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                double dFloatValue = 1.0f / ((Float) it.next()).floatValue();
                double dMin3 = dFloatValue * 1000.0d * 1000.0d * 1000.0d;
                if (z) {
                    dMin3 = Math.min(jMin, Math.max(d5, dMin3));
                    double d6 = dMin3 / 1.0E9d;
                    if (d6 >= 1.0d) {
                        fRound2 = (float) (1.0d / d6);
                    } else {
                        jRound2 = Math.round(1.0d / d6);
                        fRound2 = jRound2;
                    }
                } else {
                    fRound2 = Math.round(1.0d / dFloatValue);
                    if (fRound2 < fM12760) {
                        jRound2 = (long) fM12760;
                        fRound2 = jRound2;
                    }
                }
                Iterator it2 = it;
                if (dMin3 >= d5) {
                    f = fM12760;
                    if (dMin3 <= jMin && fRound2 <= fRound) {
                        m12728(fRound2);
                    }
                } else {
                    f = fM12760;
                }
                fM12760 = f;
                it = it2;
            }
            m12784(this.f13614);
            m12788(f4 * this.f13614);
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final void m12763() {
        if (this.f13643) {
            return;
        }
        this.f13612 = new ArrayList();
        int i = 0;
        while (i < 25600) {
            i = i == 0 ? 50 : i * 2;
            if (i >= this.f13616 && i <= this.f13615 && i <= 25600) {
                this.f13612.add(Integer.valueOf(i));
                if (f13602) {
                    C4638.m14099(f13600, "ISO:" + i + " min:" + this.f13616 + " max:" + this.f13615);
                }
            }
        }
        r1.m8144(this.f13612);
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public boolean m12764() {
        return this.f13637;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public boolean m12765() {
        return this.f13636;
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public int m12766() {
        return this.f13630;
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public boolean m12767() {
        return this.f13645;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public int m12768() {
        return this.f13627;
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public boolean m12769() {
        return this.f13644;
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public int m12770() {
        return this.f13629;
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public int m12771() {
        return this.f13628;
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public boolean m12772() {
        return this.f13638;
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public final void m12773() {
        if (r1.m8144(this.f13646)) {
            Iterator<InterfaceC3949> it = this.f13646.iterator();
            while (it.hasNext()) {
                it.next().onChange();
            }
        }
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public void m12774() {
        this.f13617 = true;
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public void m12775(InterfaceC3948 interfaceC3948) {
        this.f13617 = true;
        m12762();
        m12773();
        if (interfaceC3948 != null) {
            interfaceC3948.mo1308();
        }
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public void m12776() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        this.f13636 = c3891M13890.m12381();
        this.f13637 = c3891M13890.m12376();
        this.f13619 = c3891M13890.m12409();
        m12787(c3891M13890.m12414());
        m12788(c3891M13890.m12416());
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            m12784((c3891M13890.m12416() * 1.0f) / (m12760(iM12471) * 360.0f));
        } else {
            m12784((c3891M13890.m12416() * 1.0f) / (c3891M13890.m12484() * 360));
        }
        this.f13622 = c3891M13890.m12412();
        this.f13623 = c3891M13890.m12417();
        this.f13620 = c3891M13890.m12410();
        this.f13638 = c3891M13890.m12490();
        this.f13639 = c3891M13890.m12433();
        this.f13626 = c3891M13890.m12413();
        this.f13627 = c3891M13890.m12424();
        this.f13628 = c3891M13890.m12466();
        this.f13632 = c3891M13890.m12458();
        this.f13633 = c3891M13890.m12459();
        this.f13629 = c3891M13890.m12446();
        this.f13630 = c3891M13890.m12422();
        this.f13631 = c3891M13890.m12460();
        this.f13634 = c3891M13890.m12379();
        this.f13635 = c3891M13890.m12486();
        this.f13624 = c3891M13890.m12407();
        this.f13625 = c3891M13890.m12406();
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public void m12777(boolean z) {
        this.f13637 = z;
        C4535.m13880().m13890().m12498(z);
        C4535.m13880().m13915();
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public void m12778(int i) {
        this.f13634 = i;
        C4535.m13880().m13890().m12502(this.f13634);
        C4535.m13880().m13915();
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public void m12779(boolean z) {
        this.f13636 = z;
        C4535.m13880().m13890().m12504(z);
        C4535.m13880().m13915();
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public void m12780(AbstractC2341.C2343 c2343, InterfaceC3948 interfaceC3948) {
        boolean z;
        this.f13606 = c2343;
        C4506 c4506M8784 = c2343.m8784();
        d1 d1VarM8785 = c2343.m8785();
        this.f13640 = c4506M8784.m13812();
        this.f13641 = c4506M8784.m13814();
        this.f13607 = d1VarM8785.m12229();
        this.f13616 = this.f13641;
        this.f13615 = this.f13640;
        Range<Integer> rangeM11355 = c4506M8784.m13807().m11355();
        boolean z2 = false;
        boolean z3 = true;
        this.f13648 = new int[]{((Integer) rangeM11355.getLower()).intValue(), ((Integer) rangeM11355.getUpper()).intValue()};
        m12763();
        int i = this.f13618;
        int i2 = this.f13607;
        if (i != i2 || this.f13617) {
            this.f13618 = i2;
            this.f13617 = true;
            m12762();
            m12773();
            z = true;
        } else {
            z = false;
        }
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            float fM12760 = 1.0f / m12760(iM12471);
            if (this.f13614 > fM12760) {
                this.f13614 = fM12760;
                this.f13621 = 360.0f;
                if (interfaceC3948 != null) {
                    interfaceC3948.mo1308();
                }
            } else if (r1.m8144(this.f13610)) {
                float f = this.f13614;
                List<Float> list = this.f13610;
                if (f < list.get(list.size() - 1).floatValue()) {
                    List<Float> list2 = this.f13610;
                    float fFloatValue = list2.get(list2.size() - 1).floatValue();
                    this.f13614 = fFloatValue;
                    this.f13621 = fFloatValue * 360.0f * this.f13618;
                    if (interfaceC3948 != null) {
                        interfaceC3948.mo1308();
                    }
                }
            }
            z = false;
        } else {
            float f2 = this.f13614;
            int i3 = this.f13607;
            if (f2 > 1.0f / i3) {
                this.f13614 = 1.0f / i3;
                this.f13621 = 360.0f;
                if (interfaceC3948 != null) {
                    interfaceC3948.mo1308();
                }
            } else if (r1.m8144(this.f13610)) {
                float f3 = this.f13614;
                List<Float> list3 = this.f13610;
                if (f3 < list3.get(list3.size() - 1).floatValue()) {
                    List<Float> list4 = this.f13610;
                    float fFloatValue2 = list4.get(list4.size() - 1).floatValue();
                    this.f13614 = fFloatValue2;
                    this.f13621 = fFloatValue2 * 360.0f * this.f13618;
                    if (interfaceC3948 != null) {
                        interfaceC3948.mo1308();
                    }
                }
            }
            z = false;
        }
        if (z) {
            this.f13621 = this.f13614 * 360.0f * this.f13618;
            if (iM12471 != 0) {
                this.f13621 = this.f13614 * 360.0f * m12760(iM12471);
            }
            if (interfaceC3948 != null) {
                interfaceC3948.mo1308();
            }
        }
        if (this.f13613 > m12751()) {
            this.f13613 = m12751();
            C4535.m13880().m13890().m12530(this.f13613);
            z2 = true;
        }
        if (this.f13613 < m12752()) {
            this.f13613 = m12752();
            C4535.m13880().m13890().m12530(this.f13613);
        } else {
            z3 = z2;
        }
        if (z3) {
            C4535.m13880().m13915();
        }
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public void m12781(float f) {
        this.f13625 = f;
        C4535.m13880().m13890().m12522(this.f13625);
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public void m12782(float f) {
        this.f13624 = f;
        C4535.m13880().m13890().m12523(f);
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public void m12783(float f) {
        this.f13620 = f;
        C4535.m13880().m13890().m12526(f);
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public void m12784(float f) {
        this.f13645 = f > 0.0f;
        if (r1.m8144(this.f13610)) {
            float fMin = Math.min(this.f13610.get(0).floatValue(), f);
            List<Float> list = this.f13610;
            f = Math.max(list.get(list.size() - 1).floatValue(), fMin);
        }
        this.f13614 = f;
        C4535.m13880().m13890().m12527(f);
    }

    /* renamed from: ࡤ, reason: contains not printable characters */
    public void m12785(float f) {
        this.f13622 = f;
        C4535.m13880().m13890().m12528(f);
    }

    /* renamed from: ࡥ, reason: contains not printable characters */
    public void m12786(float f) {
        this.f13626 = f;
        C4535.m13880().m13890().m12529(f);
        C4535.m13880().m13915();
    }

    /* renamed from: ࡦ, reason: contains not printable characters */
    public void m12787(float f) {
        this.f13644 = f > 0.0f;
        if (r1.m8144(this.f13612)) {
            f = Math.max(m12752(), Math.min(m12751(), f));
        }
        this.f13613 = f;
        C4535.m13880().m13890().m12530(f);
    }

    /* renamed from: ࡧ, reason: contains not printable characters */
    public void m12788(float f) {
        this.f13621 = f;
        C4535.m13880().m13890().m12532(f);
    }

    /* renamed from: ࡨ, reason: contains not printable characters */
    public void m12789(float f) {
        C4638.m14099("slimabpoint", "mCurrentZoomP:" + f);
        this.f13623 = f;
        C4535.m13880().m13890().m12533(f);
    }

    /* renamed from: ࡩ, reason: contains not printable characters */
    public void m12790(int i) {
        this.f13630 = i;
        C4535.m13880().m13890().m12538(i);
        C4535.m13880().m13915();
    }

    /* renamed from: ࡪ, reason: contains not printable characters */
    public void m12791(int i) {
        this.f13627 = i;
        C4535.m13880().m13890().m12540(i);
        C4535.m13880().m13915();
    }

    /* renamed from: ࢠ, reason: contains not printable characters */
    public void m12792(boolean z) {
        this.f13639 = z;
        C4535.m13880().m13890().m12549(this.f13639);
        C4535.m13880().m13915();
    }

    /* renamed from: ࢡ, reason: contains not printable characters */
    public void m12793(boolean z) {
        this.f13617 = z;
    }

    /* renamed from: ࢢ, reason: contains not printable characters */
    public void m12794(int i) {
        this.f13629 = i;
        C4535.m13880().m13890().m12365(i);
        C4535.m13880().m13915();
    }

    /* renamed from: ࢣ, reason: contains not printable characters */
    public void m12795(int i) {
        this.f13632 = i;
        C4535.m13880().m13890().m12384(i);
        C4535.m13880().m13915();
    }

    /* renamed from: ࢤ, reason: contains not printable characters */
    public void m12796(int i) {
        this.f13633 = i;
        C4535.m13880().m13890().m12360(i);
        C4535.m13880().m13915();
    }

    /* renamed from: ࢥ, reason: contains not printable characters */
    public void m12797(int i) {
        this.f13631 = i;
        C3891 c3891M13890 = C4535.m13880().m13890();
        c3891M13890.m12388(i);
        if (i == 0) {
            c3891M13890.m12359(0);
        } else if (i == 1) {
            c3891M13890.m12359(1);
        }
        C4535.m13880().m13915();
    }

    /* renamed from: ࢦ, reason: contains not printable characters */
    public void m12798(int i) {
        this.f13628 = i;
        C4535.m13880().m13890().m12355(i);
        C4535.m13880().m13915();
    }

    /* renamed from: ࢧ, reason: contains not printable characters */
    public void m12799(int i) {
        this.f13635 = i;
        C4535.m13880().m13890().m12350(i);
        C4535.m13880().m13915();
    }

    /* renamed from: ࢨ, reason: contains not printable characters */
    public void m12800(boolean z, boolean z2) {
        this.f13638 = z;
        if (z2) {
            return;
        }
        C4535.m13880().m13890().m12393(z);
        C4535.m13880().m13915();
    }
}
