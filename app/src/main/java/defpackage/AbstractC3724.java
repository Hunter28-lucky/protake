package defpackage;

import android.graphics.PointF;
import android.opengl.GLES20;
import defpackage.C3927;
import java.util.Iterator;
import java.util.List;

/* compiled from: FilmFilter.java */
/* renamed from: ݖ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3724 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f12893;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C3606 f12894;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C2390 f12895;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C3606 f12896;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C5083 f12897;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C5083 f12898;

    /* renamed from: ԭ, reason: contains not printable characters */
    public float f12899;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f12900;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f12901;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f12902;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f12903;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f12904;

    /* renamed from: ׯ, reason: contains not printable characters */
    public C4327 f12905;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C4198 f12906;

    /* renamed from: ހ, reason: contains not printable characters */
    public C4198 f12907;

    /* renamed from: ށ, reason: contains not printable characters */
    public C4198 f12908;

    /* renamed from: ނ, reason: contains not printable characters */
    public C4198 f12909;

    /* renamed from: ރ, reason: contains not printable characters */
    public C4974 f12910;

    /* renamed from: ބ, reason: contains not printable characters */
    public float[] f12911;

    /* renamed from: ޅ, reason: contains not printable characters */
    public C4974 f12912;

    /* renamed from: ކ, reason: contains not printable characters */
    public C3606 f12913;

    /* renamed from: އ, reason: contains not printable characters */
    public C2390 f12914;

    public AbstractC3724() {
        this(C2764.m10018().m10029(), C2764.m10018().m10032());
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m11901() {
        try {
            C3927.C3928 c3928M12686 = C3927.m12686(C5015.m14801("lut/beauty_bright.dat"));
            C4974 c4974 = new C4974();
            this.f12910 = c4974;
            c4974.m10882(c3928M12686.m12689(), false);
            this.f12910.m14761(c3928M12686.m12690());
            this.f12910.m13477();
        } catch (Exception e2) {
            e2.printStackTrace();
            C4974 c49742 = this.f12910;
            if (c49742 != null) {
                c49742.m13471();
                this.f12910.mo10877();
            }
            this.f12910 = null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m11902(int i) {
        h0 h0VarM9061 = C2462.m9035().m9061(i);
        if (h0VarM9061 != null) {
            List<C4974> listM10016 = C2764.m10016(i);
            System.nanoTime();
            if (listM10016 == null || listM10016.size() <= 0) {
                return;
            }
            if (!h0VarM9061.m6141()) {
                this.f12912 = listM10016.get(0);
                return;
            }
            this.f12912 = new C4974();
            this.f12913 = new C3606();
            this.f12914 = new C2390(4096, 64, true);
            System.nanoTime();
            Iterator<C4974> it = listM10016.iterator();
            while (it.hasNext()) {
                this.f12913.m11636(it.next());
            }
            this.f12898.m14914(this.f12913, this.f12914);
            GLES20.glFinish();
            System.nanoTime();
            this.f12912.m10884(this.f12914.m8883());
            if (h0VarM9061.m6146()) {
                this.f12912.m14763(1.0f);
            } else {
                this.f12912.m14763(0.0f);
            }
            this.f12912.m14761(C5083.f16883);
            System.nanoTime();
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public abstract void mo11903();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m11904() {
        m11905(C2764.m10018().m10029());
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m11905(int i) {
        System.nanoTime();
        List<C4327> listM11637 = this.f12896.m11637();
        if (listM11637 != null) {
            listM11637.clear();
        }
        List<C4327> listM11638 = this.f12896.m11638();
        if (listM11638 != null) {
            listM11638.clear();
        }
        this.f12896.m11636(this.f12905);
        C4974 c4974 = this.f12910;
        if (c4974 != null) {
            this.f12896.m11636(c4974);
        }
        C4974 c49742 = this.f12912;
        if (c49742 != null) {
            c49742.m13471();
            this.f12912.mo10877();
            this.f12912 = null;
        }
        C2390 c2390 = this.f12914;
        if (c2390 != null) {
            c2390.m8880();
            this.f12914 = null;
        }
        C3606 c3606 = this.f12913;
        if (c3606 != null) {
            c3606.m13471();
            this.f12913.mo10877();
            this.f12913 = null;
        }
        System.nanoTime();
        System.nanoTime();
        System.nanoTime();
        m11902(i);
        m11920();
        C4974 c49743 = this.f12912;
        if (c49743 != null) {
            this.f12896.m11636(c49743);
        }
        System.nanoTime();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m11906() {
        this.f12899 = 0.0f;
        m11915();
        this.f12900 = 0.0f;
        m11910();
        this.f12901 = 0.0f;
        m11912();
        this.f12902 = 0.0f;
        m11913();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void mo11907() {
        this.f12895.m8880();
        C2390 c2390 = this.f12914;
        if (c2390 != null) {
            c2390.m8880();
        }
        this.f12897.m14911();
        this.f12898.m14911();
        C4327 c4327 = this.f12905;
        if (c4327 != null) {
            c4327.m13471();
            this.f12905.mo10877();
        }
        C4198 c4198 = this.f12906;
        if (c4198 != null) {
            c4198.m13471();
            this.f12906.mo10877();
        }
        C4198 c41982 = this.f12907;
        if (c41982 != null) {
            c41982.m13471();
            this.f12907.mo10877();
        }
        C4198 c41983 = this.f12908;
        if (c41983 != null) {
            c41983.m13471();
            this.f12908.mo10877();
        }
        C4198 c41984 = this.f12909;
        if (c41984 != null) {
            c41984.m13471();
            this.f12909.mo10877();
        }
        this.f12896.m13471();
        C3606 c3606 = this.f12913;
        if (c3606 != null) {
            c3606.m13471();
            this.f12913.mo10877();
        }
        C4974 c4974 = this.f12912;
        if (c4974 != null) {
            c4974.m13471();
            this.f12912.mo10877();
        }
        this.f12894.m13471();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C3606 m11908() {
        return this.f12894;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public int m11909() {
        return this.f12893;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m11910() {
        float f = this.f12900;
        if (f > 0.0f) {
            this.f12907.m13267(new PointF[]{new PointF(0.0f, ((f * 0.11764706f) / 50.0f) + 0.0f), new PointF(0.5f, 0.5f), new PointF(1.0f, 1.0f)});
        } else {
            this.f12907.m13267(new PointF[]{new PointF(((f * (-0.11764706f)) / 50.0f) + 0.0f, 0.0f), new PointF(0.5f, 0.5f), new PointF(1.0f, 1.0f)});
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m11911() {
        float f = this.f12904;
        C4974 c4974 = this.f12910;
        if (c4974 != null) {
            c4974.m14762(f);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m11912() {
        this.f12908.m13267(new PointF[]{new PointF(0.0f, 0.0f), new PointF(0.5f, ((this.f12901 * 0.11764706f) / 50.0f) + 0.5f), new PointF(1.0f, 1.0f)});
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m11913() {
        float f = (this.f12902 * 0.11764706f) / 50.0f;
        this.f12909.m13267(new PointF[]{new PointF(0.0f, 0.0f), new PointF(0.25f, 0.25f - f), new PointF(0.5f, f + 0.5f), new PointF(1.0f, 1.0f)});
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m11914() {
        float f = this.f12903 / 100.0f;
        C4974 c4974 = this.f12912;
        if (c4974 != null) {
            c4974.m14762(f);
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m11915() {
        float f = this.f12899;
        if (f > 0.0f) {
            this.f12906.m13267(new PointF[]{new PointF(0.0f, 0.0f), new PointF(0.5f, 0.5f), new PointF(1.0f - ((f * 0.11764706f) / 50.0f), 1.0f)});
        } else {
            this.f12906.m13267(new PointF[]{new PointF(0.0f, 0.0f), new PointF(0.5f, 0.5f), new PointF(1.0f, 1.0f - ((f * (-0.11764706f)) / 50.0f))});
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m11916() {
        this.f12904 = C2764.m10018().m10022();
        m11911();
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m11917(float f) {
        this.f12904 = f;
        m11911();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m11918() {
        System.nanoTime();
        this.f12897.m14914(this.f12896, this.f12895);
        System.nanoTime();
        GLES20.glFinish();
        System.nanoTime();
        System.nanoTime();
        System.nanoTime();
        mo11919();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public abstract void mo11919();

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m11920() {
        this.f12903 = C2764.m10018().m10028();
        m11914();
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m11921(int i) {
        this.f12903 = i;
        m11914();
    }

    public AbstractC3724(int i, int i2) throws Throwable {
        this.f12893 = 1;
        this.f12911 = C3927.f13554;
        System.nanoTime();
        this.f12893 = i2;
        this.f12894 = new C3606();
        C2390 c2390 = new C2390(4096, 64, true);
        this.f12895 = c2390;
        this.f12899 = C2764.m10018().m10033();
        this.f12900 = C2764.m10018().m10021();
        this.f12901 = C2764.m10018().m10023();
        this.f12902 = C2764.m10018().m10025();
        this.f12903 = C2764.m10018().m10028();
        this.f12905 = new C4327();
        this.f12906 = new C4198();
        m11915();
        this.f12907 = new C4198();
        m11910();
        this.f12908 = new C4198();
        m11912();
        this.f12909 = new C4198();
        m11913();
        m11901();
        m11916();
        C3606 c3606 = new C3606();
        this.f12896 = c3606;
        c3606.m11636(this.f12905);
        C4974 c4974 = this.f12910;
        if (c4974 != null) {
            c3606.m11636(c4974);
        }
        System.nanoTime();
        C5083 c5083 = new C5083();
        this.f12897 = c5083;
        c5083.m14912();
        C5083 c50832 = new C5083();
        this.f12898 = c50832;
        c50832.m14912();
        System.nanoTime();
        m11902(i);
        System.nanoTime();
        m11914();
        C4974 c49742 = this.f12912;
        if (c49742 != null) {
            c3606.m11636(c49742);
        }
        c5083.m14914(c3606, c2390);
        GLES20.glFinish();
        mo11903();
        System.nanoTime();
    }
}
