package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.netbean.FilterUIBean;
import com.blink.academy.film.videotools.C0851;
import com.blink.academy.film.videotools.C0855;
import com.blink.academy.film.videotools.FrameRenderer;
import com.blink.academy.protake.R;
import defpackage.C3927;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FilmFilterManager.java */
/* renamed from: ͻ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2764 {

    /* renamed from: ؠ, reason: contains not printable characters */
    public static C2764 f10105;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public float f10106 = 0.0f;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public float f10107 = 0.0f;

    /* renamed from: ԩ, reason: contains not printable characters */
    public float f10108 = 0.0f;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public float f10109 = 0.0f;

    /* renamed from: ԫ, reason: contains not printable characters */
    public float f10110 = 100.0f;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f10111 = 0;

    /* renamed from: ԭ, reason: contains not printable characters */
    public float f10112 = 0.0f;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f10113 = 0.0f;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f10114 = 0.0f;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f10115 = 0.0f;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f10116 = 0.0f;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f10117 = 0.0f;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f10118 = 0.0f;

    public C2764() {
        m10035(C4535.m13880().m13890());
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static List<C4974> m10016(int i) {
        if (i == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FilterUIBean filterUIBean : C2462.m9035().m9061(i).m6126()) {
            String save_path = filterUIBean.getSave_path();
            String real_path = filterUIBean.getReal_path();
            boolean zExists = new File(real_path).exists();
            System.nanoTime();
            byte[] bArrM14802 = zExists ? C5015.m14802(real_path) : C5015.m14802(save_path);
            System.nanoTime();
            C3927.C3928 c3928M12687 = zExists ? C3927.m12687(bArrM14802) : C3927.m12686(bArrM14802);
            System.nanoTime();
            C4974 c4974 = new C4974();
            c4974.m10882(c3928M12687.m12689(), true);
            c4974.m14761(c3928M12687.m12690());
            System.nanoTime();
            c4974.m13477();
            arrayList.add(c4974);
            System.nanoTime();
        }
        return arrayList;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Bitmap m10017(List<String> list) throws Throwable {
        C4974 c4974;
        C2390 c2390;
        C5083 c5083;
        C3732 c3732M11944 = C3732.m11944("generatePreviewBitmap");
        c3732M11944.m11958();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            C3927.C3928 c3928M12687 = C3927.m12687(C5015.m14802(it.next()));
            C4974 c49742 = new C4974();
            c49742.m10882(c3928M12687.m12689(), true);
            c49742.m14761(c3928M12687.m12690());
            c49742.m13477();
            arrayList.add(c49742);
        }
        if (arrayList.size() > 1) {
            c4974 = new C4974();
            C3606 c3606 = new C3606();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                c3606.m11636((C4974) it2.next());
            }
            C5083 c50832 = new C5083();
            c50832.m14912();
            C2390 c23902 = new C2390(4096, 64, true);
            c50832.m14914(c3606, c23902);
            c4974.m10884(c23902.m8883());
            c5083 = c50832;
            c2390 = c23902;
        } else {
            c4974 = (C4974) arrayList.get(0);
            c2390 = null;
            c5083 = null;
        }
        long jNanoTime = System.nanoTime();
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(FilmApp.m402().getResources(), R.drawable.portrait);
        C4638.m14099("readStrream", String.format("generatePreviewBitmap decodeResource cost1 : %s ", Long.valueOf((System.nanoTime() - jNanoTime) / 1000000)));
        if (bitmapDecodeResource.getWidth() != 640) {
            return bitmapDecodeResource;
        }
        C0851 c0851M2108 = new C0855(bitmapDecodeResource, 2, 0).m2108(c3732M11944);
        FrameRenderer frameRenderer = new FrameRenderer();
        frameRenderer.m2059(c0851M2108);
        ArrayList<Bitmap> arrayListM2056 = frameRenderer.m2056(c3732M11944, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), new C4327[]{c4974}, new int[]{0});
        frameRenderer.m2050();
        frameRenderer.m2049();
        c0851M2108.m2097();
        c0851M2108.m2098();
        if (c2390 != null) {
            c2390.m8880();
        }
        if (c5083 != null) {
            c5083.m14911();
        }
        c3732M11944.m11959();
        return arrayListM2056.get(0);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static C2764 m10018() {
        if (f10105 == null) {
            synchronized (C2764.class) {
                if (f10105 == null) {
                    f10105 = new C2764();
                }
            }
        }
        return f10105;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m10019() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 != null && c3891M13890.m12460() == 1) {
            return false;
        }
        if (c3891M13890 == null || c3891M13890.m12484() <= 30) {
            return (c3891M13890 == null || c3891M13890.m12463() <= 1280) && C2500.f9257;
        }
        return false;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public float m10020() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10115;
        }
        return 0.0f;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public float m10021() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10107;
        }
        return 0.0f;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float m10022() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10112;
        }
        return 0.0f;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public float m10023() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10108;
        }
        return 0.0f;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float m10024() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10114;
        }
        return 0.0f;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public float m10025() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10109;
        }
        return 0.0f;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public float m10026() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10116;
        }
        return 0.0f;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public float m10027() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10117;
        }
        return 0.0f;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public float m10028() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10110;
        }
        return 100.0f;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public int m10029() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10111;
        }
        return 0;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public float m10030() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10113;
        }
        return 0.0f;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public float m10031() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10118;
        }
        return 0.0f;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public int m10032() {
        return m10034() ? 1 : 0;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public float m10033() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890 == null || c3891M13890.m12460() != 1) {
            return this.f10106;
        }
        return 0.0f;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public boolean m10034() {
        if (this.f10113 == 0.0f && this.f10114 == 0.0f && this.f10115 == 0.0f && this.f10116 == 0.0f && this.f10117 == 0.0f && this.f10118 == 0.0f) {
            return false;
        }
        return m10019();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m10035(C3891 c3891) {
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public C2764 m10036(float f) {
        this.f10115 = f;
        return this;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public C2764 m10037(float f) {
        this.f10107 = f;
        return this;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public C2764 m10038(float f) {
        this.f10112 = f;
        return this;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public C2764 m10039(float f) {
        this.f10108 = f;
        return this;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public C2764 m10040(float f) {
        this.f10114 = f;
        return this;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public C2764 m10041(float f) {
        this.f10109 = f;
        return this;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public C2764 m10042(float f) {
        this.f10116 = f;
        return this;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public C2764 m10043(float f) {
        this.f10117 = f;
        return this;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public C2764 m10044(float f) {
        this.f10110 = f;
        return this;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public C2764 m10045() {
        m10046(0);
        m10044(100.0f);
        return this;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public C2764 m10046(int i) {
        this.f10111 = i;
        return this;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public C2764 m10047(float f) {
        this.f10113 = f;
        return this;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public C2764 m10048(float f) {
        this.f10118 = f;
        return this;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public C2764 m10049(float f) {
        this.f10106 = f;
        return this;
    }
}
