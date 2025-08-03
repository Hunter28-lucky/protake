package defpackage;

import com.blink.academy.film.support.socket.TransmitHelper;
import defpackage.C3444;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* compiled from: ContentNameManager.java */
/* renamed from: Ƴ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2462 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static C2462 f9153;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<C3755> f9154 = C3184.m10827().m10852();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public List<String> f9155 = new ArrayList();

    /* renamed from: ԩ, reason: contains not printable characters */
    public List<String> f9156 = new ArrayList();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f9157;

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f9158;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f9159;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f9160;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f9161;

    public C2462() {
        String str;
        for (int i = 65; i <= 90; i++) {
            this.f9155.add("" + ((char) i));
        }
        for (int i2 = 1; i2 <= 999; i2++) {
            if (i2 < 10) {
                str = "00" + i2;
            } else if (i2 < 100) {
                str = "0" + i2;
            } else {
                str = i2 + "";
            }
            this.f9156.add(str);
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static C2462 m9035() {
        if (f9153 == null) {
            synchronized (C2462.class) {
                if (f9153 == null) {
                    f9153 = new C2462();
                }
            }
        }
        return f9153;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m9036(int i) {
        if (r1.m8144(this.f9154)) {
            for (C3755 c3755 : this.f9154) {
                if (i == c3755.m12032()) {
                    c3755.m12034(c3755.m12031() + 1);
                    C3184.m10827().m10866(c3755);
                    return;
                }
            }
        }
        C3755 c37552 = new C3755();
        c37552.m12034(1);
        c37552.m12035(i);
        c37552.m12036(System.currentTimeMillis());
        this.f9154.add(c37552);
        C3184.m10827().m10830(c37552);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m9037() {
        boolean z = true;
        boolean z2 = false;
        while (z) {
            File file = new File(m9047());
            if (!file.exists() || file.length() == 0) {
                z = false;
            } else {
                m9036(C4535.m13880().m13890().m12408());
                z2 = true;
            }
        }
        return z2;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public String m9038(int i) {
        return r1.m8144(this.f9155) ? this.f9155.get((i / 1000) - 1) : "";
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int m9039(String str) {
        if (r1.m8144(this.f9155)) {
            return this.f9155.indexOf(str);
        }
        return 0;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public List<String> m9040() {
        return this.f9155;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m9041(int i) {
        if (!r1.m8144(this.f9154)) {
            return 0;
        }
        for (C3755 c3755 : this.f9154) {
            if (i == c3755.m12032()) {
                return c3755.m12031();
            }
        }
        return 0;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public String m9042(int i) {
        int iM9041 = m9035().m9041(i) + 1;
        if (iM9041 < 10) {
            return "0000" + iM9041;
        }
        if (iM9041 < 100) {
            return "000" + iM9041;
        }
        if (iM9041 < 1000) {
            return "00" + iM9041;
        }
        if (iM9041 < 10000) {
            return "0" + iM9041;
        }
        return iM9041 + "";
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String m9043() {
        return this.f9157;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public String m9044() {
        return this.f9159;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public String m9045() {
        return this.f9161;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public String m9046() {
        return this.f9158;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public String m9047() {
        File file = new File(C4062.m12991(), m9048());
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public String m9048() {
        int iM12408 = C4535.m13880().m13890().m12408();
        this.f9157 = this.f9155.get((iM12408 / 1000) - 1);
        this.f9158 = this.f9156.get((iM12408 - (r1 * 1000)) - 1);
        this.f9159 = m9042(iM12408);
        this.f9160 = m9064();
        this.f9161 = this.f9157 + this.f9158 + TransmitHelper.CAMERA_UNIT_C_CONTENT + this.f9159 + "_" + m9054() + "_" + this.f9160;
        return this.f9161 + ".MP4";
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public String m9049(String str) {
        if (str.length() >= 5) {
            return str;
        }
        return str + m9059(5 - str.length());
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public String m9050(int i) {
        Iterator<h0> it = C3444.m11227().m11244().iterator();
        String strM6128 = "Off";
        while (it.hasNext()) {
            h0 next = it.next();
            if (i == next.m6136()) {
                strM6128 = next.m6128();
            }
        }
        return strM6128;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public String m9051(int i) {
        int iM9041 = m9035().m9041(i) + 1 + 1;
        if (iM9041 < 10) {
            return "0000" + iM9041;
        }
        if (iM9041 < 100) {
            return "000" + iM9041;
        }
        if (iM9041 < 1000) {
            return "00" + iM9041;
        }
        if (iM9041 < 10000) {
            return "0" + iM9041;
        }
        return iM9041 + "";
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public String m9052() {
        int iM12408 = C4535.m13880().m13890().m12408();
        return (this.f9155.get((iM12408 / 1000) - 1) + this.f9156.get((iM12408 - (r1 * 1000)) - 1) + TransmitHelper.CAMERA_UNIT_C_CONTENT + m9051(iM12408) + "_" + m9054() + "_" + m9064()) + ".MP4";
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public String m9053() {
        File file = new File(C4062.m12991(), m9052());
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final String m9054() {
        return new SimpleDateFormat("yyMMdd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public String m9055(String str, int i) {
        if (!r1.m8143(str)) {
            return i + "";
        }
        return str + "_" + i;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final String m9056() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            sb.append(random.nextBoolean() ? ((char) (random.nextInt(26) + 65)) + "" : "" + Math.min(random.nextInt(10), 9));
        }
        return sb.toString();
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public String m9057() {
        int iM12408 = C4535.m13880().m13890().m12408();
        int i = iM12408 / 1000;
        this.f9157 = this.f9155.get(i - 1);
        this.f9158 = this.f9156.get((iM12408 - (i * 1000)) - 1);
        String strM9042 = m9042(iM12408);
        this.f9159 = strM9042;
        return String.format("%s%s C%s", this.f9157, this.f9158, strM9042);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public List<String> m9058() {
        return this.f9156;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final String m9059(int i) {
        return (i == 1 || i == 2) ? "\t" : i != 3 ? i != 4 ? "" : "\t\t\t" : "\t\t";
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public String m9060(int i) {
        String strM6138 = "";
        if (i == 0) {
            return "";
        }
        Iterator<h0> it = C3444.m11227().m11244().iterator();
        while (it.hasNext()) {
            h0 next = it.next();
            if (i == next.m6136()) {
                strM6138 = next.m6138();
            }
        }
        return strM6138;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public h0 m9061(int i) {
        ArrayList<h0> arrayListM11244 = C3444.m11227().m11244();
        if (!r1.m8144(arrayListM11244)) {
            return null;
        }
        Iterator<h0> it = arrayListM11244.iterator();
        while (it.hasNext()) {
            h0 next = it.next();
            if (i == next.m6136()) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public String m9062(int i) {
        String strM6138 = C3444.InterfaceC3451.f11909;
        Iterator<h0> it = C3444.m11227().m11244().iterator();
        while (it.hasNext()) {
            h0 next = it.next();
            if (i == next.m6136()) {
                strM6138 = next.m6138();
            }
        }
        return strM6138;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public int m9063(String str) {
        int iM6136 = 0;
        if (r1.m8138(str)) {
            return 0;
        }
        Iterator<h0> it = C3444.m11227().m11244().iterator();
        while (it.hasNext()) {
            h0 next = it.next();
            if (str.equals(next.m6138())) {
                iM6136 = next.m6136();
            }
        }
        return iM6136;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public String m9064() {
        String strM9569 = C2618.m9569("suffix_sp", "");
        if (r1.m8143(strM9569)) {
            return strM9569;
        }
        String strM9056 = m9056();
        C2618.m9573("suffix_sp", strM9056);
        return strM9056;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m9065() {
        this.f9154 = new ArrayList();
        C3184.m10827().m10838();
        C2618.m9573("suffix_sp", "");
    }
}
