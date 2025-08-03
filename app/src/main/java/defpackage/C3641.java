package defpackage;

import android.content.res.Resources;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Size;
import android.util.SizeF;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.protake.R;
import com.mob.pushsdk.MobPush;
import defpackage.C3444;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: CameraIdInfoManager.java */
/* renamed from: ە, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3641 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final String f12648 = "ە";

    /* renamed from: ՠ, reason: contains not printable characters */
    public static C3641 f12649;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public ArrayList<C3485> f12651;

    /* renamed from: ԩ, reason: contains not printable characters */
    public ArrayList<C3485> f12652;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f12650 = false;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean f12653 = false;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f12654 = 28;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f12655 = 30;

    /* renamed from: ԭ, reason: contains not printable characters */
    public double f12656 = 2.1d;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public double f12657 = 1.1d;

    /* compiled from: CameraIdInfoManager.java */
    /* renamed from: ە$Ϳ, reason: contains not printable characters */
    public class C3642 implements Comparator<C3485> {
        public C3642() {
        }

        @Override // java.util.Comparator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public int compare(C3485 c3485, C3485 c34852) {
            return ((int) (c3485.m11358() * 100.0d)) - ((int) (c34852.m11358() * 100.0d));
        }
    }

    /* compiled from: CameraIdInfoManager.java */
    /* renamed from: ە$Ԩ, reason: contains not printable characters */
    public class C3643 implements Comparator<C3485> {
        public C3643() {
        }

        @Override // java.util.Comparator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public int compare(C3485 c3485, C3485 c34852) {
            float[] fArrM11361 = c3485.m11361();
            float[] fArrM113612 = c34852.m11361();
            float fM11724 = C3641.this.m11724(fArrM11361);
            float fM117242 = C3641.this.m11724(fArrM113612);
            int i = (int) (fM11724 * 100.0f);
            int i2 = (int) (100.0f * fM117242);
            if (C3641.this.f12650) {
                C4638.m14099(C3641.f12648, String.format("origin1 : %s , origin2 : %s ", Float.valueOf(fM11724), Float.valueOf(fM117242)));
            }
            if (i == i2) {
                SizeF sizeFM11372 = c3485.m11372();
                SizeF sizeFM113722 = c34852.m11372();
                if (sizeFM11372 != null && sizeFM113722 != null) {
                    if (C3641.this.f12650) {
                        C4638.m14099(C3641.f12648, String.format("sensor_info_physical_size : %s , sensor_info_physical_size2 : %s ", sizeFM11372, sizeFM113722));
                    }
                    double dM11731 = C3641.this.m11731(fM11724, sizeFM11372);
                    double dM117312 = C3641.this.m11731(fM117242, sizeFM113722);
                    int i3 = (int) (dM11731 * 100.0d);
                    int i4 = (int) (100.0d * dM117312);
                    if (C3641.this.f12650) {
                        C4638.m14099(C3641.f12648, String.format("simFocalLength : %s , simFocalLength1 : %s ", Double.valueOf(dM11731), Double.valueOf(dM117312)));
                    }
                    return i4 - i3;
                }
            }
            return i2 - i;
        }
    }

    /* compiled from: CameraIdInfoManager.java */
    /* renamed from: ە$Ԫ, reason: contains not printable characters */
    public class C3644 implements Comparator<C3485> {
        public C3644() {
        }

        @Override // java.util.Comparator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public int compare(C3485 c3485, C3485 c34852) {
            Float fM11363 = c3485.m11363();
            Float fM113632 = c34852.m11363();
            return (fM113632 != null ? (int) (fM113632.floatValue() * 100.0f) : 0) - (fM11363 != null ? (int) (fM11363.floatValue() * 100.0f) : 0);
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static C3641 m11713(CameraManager cameraManager) throws Resources.NotFoundException {
        if (f12649 == null) {
            synchronized (C3641.class) {
                if (f12649 == null) {
                    f12649 = new C3641();
                }
            }
        }
        f12649.m11727(cameraManager);
        return f12649;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m11714(String str, CameraCharacteristics cameraCharacteristics, boolean z, String str2) {
        C3485 c3485 = new C3485(str, cameraCharacteristics);
        c3485.m11398(z);
        c3485.m11400(str2);
        this.f12651.add(c3485);
        if (c3485.m11396()) {
            int[] iArrM11367 = c3485.m11367();
            boolean z2 = false;
            if (this.f12650) {
                C4638.m14099(f12648, String.format("requestAvailableCapabilities : %s ", Arrays.toString(iArrM11367)));
            }
            if (iArrM11367 != null) {
                boolean z3 = false;
                boolean z4 = false;
                for (int i : iArrM11367) {
                    if (i == 0) {
                        z3 = true;
                    } else if (i != 2 && i != 8 && i == 12) {
                        z4 = true;
                    }
                }
                if (!MobPush.Channels.XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
                    if (!z3 || z4) {
                        return;
                    }
                    this.f12652.add(c3485);
                    return;
                }
                if (c3485.m11386()) {
                    return;
                }
                if (c3485.m11383()) {
                    Iterator<C3485> it = this.f12652.iterator();
                    while (it.hasNext()) {
                        C3485 next = it.next();
                        if (next.m11358() == c3485.m11358() && next.m11372().equals(c3485.m11372())) {
                            z2 = true;
                        }
                    }
                }
                if (z2 || !z3 || z4) {
                    return;
                }
                this.f12652.add(c3485);
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m11715(ArrayList<C3485> arrayList, int i, boolean z, boolean z2) {
        Float fM11363;
        boolean z3 = false;
        if (i > 3) {
            C3444.InterfaceC3449.f11901.m12150(true).m12144(arrayList.get(0).m11360());
            C3485 c3485 = arrayList.get(1);
            c3485.m11401(true);
            if (!z2) {
                C3444.InterfaceC3449.f11900.m12150(true).m12144(c3485.m11360());
            }
            C3485 c34852 = arrayList.get(i - 1);
            c34852.m11399(true);
            if (z2) {
                C3444.InterfaceC3449.f11895.m12150(true).m12144(c34852.m11360());
            } else {
                C3444.InterfaceC3449.f11898.m12150(true).m12144(c34852.m11360());
            }
            C3485 c34853 = arrayList.get(i - 2);
            c34853.m11402(true);
            if (z2) {
                C3444.InterfaceC3449.f11897.m12150(true).m12144(c34853.m11360());
                return;
            }
            C3828 c3828 = C3444.InterfaceC3449.f11899;
            c3828.m12150(true).m12144(c34853.m11360());
            C3828 c38282 = C3444.InterfaceC3449.f11902;
            if (c38282.m12143()) {
                return;
            }
            c38282.m12150(true).m12144(c3828.m12137());
            return;
        }
        if (i > 2) {
            C3485 c34854 = arrayList.get(0);
            c34854.m11401(true);
            if (!z2) {
                C3444.InterfaceC3449.f11900.m12150(true).m12144(c34854.m11360());
            }
            C3485 c34855 = arrayList.get(i - 1);
            c34855.m11399(true);
            if (z2) {
                C3444.InterfaceC3449.f11895.m12150(true).m12144(c34855.m11360());
            } else {
                C3444.InterfaceC3449.f11898.m12150(true).m12144(c34855.m11360());
            }
            C3485 c34856 = arrayList.get(i - 2);
            c34856.m11402(true);
            if (z2) {
                C3444.InterfaceC3449.f11897.m12150(true).m12144(c34856.m11360());
                return;
            }
            C3828 c38283 = C3444.InterfaceC3449.f11899;
            c38283.m12150(true).m12144(c34856.m11360());
            C3828 c38284 = C3444.InterfaceC3449.f11902;
            if (c38284.m12143()) {
                return;
            }
            c38284.m12150(true).m12144(c38283.m12137());
            return;
        }
        if (i <= 1) {
            C3485 c34857 = arrayList.get(0);
            c34857.m11402(true);
            if (z2) {
                C3444.InterfaceC3449.f11897.m12150(true).m12144(c34857.m11360());
                return;
            }
            C3828 c38285 = C3444.InterfaceC3449.f11899;
            c38285.m12150(true).m12144(c34857.m11360());
            C3828 c38286 = C3444.InterfaceC3449.f11902;
            if (c38286.m12143()) {
                return;
            }
            c38286.m12150(true).m12144(c38285.m12137());
            return;
        }
        C3485 c34858 = arrayList.get(0);
        C3485 c34859 = arrayList.get(i - 1);
        if (!z ? !((fM11363 = c34858.m11363()) == null || fM11363.floatValue() < 30.0f) : m11724(c34858.m11361()) > 7.0f) {
            z3 = true;
        }
        if (z3) {
            c34858.m11401(true);
            if (!z2) {
                C3444.InterfaceC3449.f11900.m12150(true).m12144(c34858.m11360());
            }
            c34859.m11402(true);
            if (z2) {
                C3444.InterfaceC3449.f11897.m12150(true).m12144(c34859.m11360());
                return;
            }
            C3828 c38287 = C3444.InterfaceC3449.f11899;
            c38287.m12150(true).m12144(c34859.m11360());
            C3828 c38288 = C3444.InterfaceC3449.f11902;
            if (c38288.m12143()) {
                return;
            }
            c38288.m12150(true).m12144(c38287.m12137());
            return;
        }
        c34858.m11402(true);
        if (z2) {
            C3444.InterfaceC3449.f11897.m12150(true).m12144(c34858.m11360());
        } else {
            C3828 c38289 = C3444.InterfaceC3449.f11899;
            c38289.m12150(true).m12144(c34858.m11360());
            C3828 c382810 = C3444.InterfaceC3449.f11902;
            if (!c382810.m12143()) {
                c382810.m12150(true).m12144(c38289.m12137());
            }
        }
        c34859.m11399(true);
        if (z2) {
            C3444.InterfaceC3449.f11895.m12150(true).m12144(c34859.m11360());
        } else {
            C3444.InterfaceC3449.f11898.m12150(true).m12144(c34859.m11360());
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m11716() throws Resources.NotFoundException {
        m11730();
        ArrayList<C3485> arrayList = this.f12652;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<C3485> it = arrayList.iterator();
        while (it.hasNext()) {
            C3485 next = it.next();
            if (this.f12650) {
                String str = f12648;
                C4638.m14099(str, String.format("camera id : %s , isFacing : %s ", next.m11360(), Boolean.valueOf(next.m11383())));
                C4638.m14099(str, String.format("focalLength : %s , sensorSize : %s", Arrays.toString(next.m11361()), next.m11372()));
                C4638.m14099(str, String.format("equivalentFocalLength : %s ", Double.valueOf(next.m11358())));
            }
        }
        if (C2813.m10154()) {
            C3444.InterfaceC3449.f11897.m12150(true).m12144("1");
            C3444.InterfaceC3449.f11902.m12150(true).m12144("0");
            C3444.InterfaceC3449.f11899.m12150(true).m12144("0");
            return;
        }
        String str2 = Build.MODEL;
        if ("Mi 10".equalsIgnoreCase(str2)) {
            C3444.InterfaceC3449.f11897.m12150(true).m12144("1");
            C3444.InterfaceC3449.f11902.m12150(true).m12144("0");
            C3444.InterfaceC3449.f11899.m12150(true).m12144("0");
            if (arrayList.size() > 2) {
                C3444.InterfaceC3449.f11898.m12150(true).m12144("3");
                return;
            }
            return;
        }
        if ("TEL-AN00".equalsIgnoreCase(str2) || "TEL-TN00".equalsIgnoreCase(str2) || "TEL-AN00a".equalsIgnoreCase(str2)) {
            C3444.InterfaceC3449.f11897.m12150(true).m12144("1");
            C3444.InterfaceC3449.f11902.m12150(true).m12144("0");
            if (arrayList.size() <= 2) {
                C3444.InterfaceC3449.f11899.m12150(true).m12144("0");
                return;
            } else {
                C3444.InterfaceC3449.f11899.m12150(true).m12144("2");
                C3444.InterfaceC3449.f11898.m12150(true).m12144("3");
                return;
            }
        }
        if (!MobPush.Channels.XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
            Iterator<C3485> it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                C3485 next2 = it2.next();
                if (next2.m11386() && !next2.m11383()) {
                    C3444.InterfaceC3449.f11902.m12150(true).m12144(next2.m11360());
                    break;
                }
            }
        } else {
            C3444.InterfaceC3449.f11902.m12150(true).m12144("0");
        }
        ArrayList<C3485> arrayListM11725 = m11725(arrayList, true);
        ArrayList<C3485> arrayListM117252 = m11725(arrayList, false);
        boolean zM11717 = m11717(arrayListM117252, false);
        boolean zM117172 = m11717(arrayListM11725, true);
        if (!zM11717 || !zM117172) {
            if ("Pixel 4".equalsIgnoreCase(Build.MODEL) || "flame".equalsIgnoreCase(C2813.f10271)) {
                C3444.InterfaceC3449.f11897.m12150(true).m12144("1");
                C3444.InterfaceC3449.f11902.m12150(true).m12144("0");
                C3444.InterfaceC3449.f11899.m12150(true).m12144("3");
                C3444.InterfaceC3449.f11900.m12150(true).m12144(FinderManager.MACHINE_C);
                return;
            }
            m11730();
            Iterator<C3485> it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                C3485 next3 = it3.next();
                if (next3.m11386() && !next3.m11383()) {
                    C3444.InterfaceC3449.f11902.m12150(true).m12144(next3.m11360());
                    break;
                }
            }
            if (!C2813.f10260 || Build.VERSION.SDK_INT < 28) {
                m11729(arrayListM11725, arrayListM117252);
            } else if (!m11719(arrayList)) {
                m11718(arrayListM117252, false);
                m11718(arrayListM11725, true);
            }
        }
        if (this.f12650) {
            String str3 = f12648;
            C4638.m14099(str3, String.format("rear_auto : %s ", C3444.InterfaceC3449.f11902));
            C4638.m14099(str3, String.format("wide : %s ", C3444.InterfaceC3449.f11899));
            C4638.m14099(str3, String.format("ultra_wide : %s ", C3444.InterfaceC3449.f11898));
            C4638.m14099(str3, String.format("tele : %s ", C3444.InterfaceC3449.f11900));
            C4638.m14099(str3, String.format("super_tele : %s ", C3444.InterfaceC3449.f11901));
            C4638.m14099(str3, String.format("selfie : %s ", C3444.InterfaceC3449.f11897));
            C4638.m14099(str3, String.format("selfie_wide : %s ", C3444.InterfaceC3449.f11895));
            C4638.m14099(str3, String.format("selfie_tele : %s ", C3444.InterfaceC3449.f11896));
        }
        C3828 c3828 = C3444.InterfaceC3449.f11902;
        if (!c3828.m12143() && m11721("0") != null) {
            c3828.m12150(true);
            c3828.m12144("0");
        }
        C3828 c38282 = C3444.InterfaceC3449.f11899;
        if (!c38282.m12143() && m11721("0") != null) {
            c38282.m12150(true);
            c38282.m12144("0");
        }
        C3828 c38283 = C3444.InterfaceC3449.f11897;
        if (c38283.m12143() || m11721("1") == null) {
            return;
        }
        c38283.m12150(true);
        c38283.m12144("1");
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean m11717(ArrayList<C3485> arrayList, boolean z) {
        Size sizeM11365;
        if (arrayList == null) {
            return false;
        }
        if (arrayList.size() == 0) {
            return true;
        }
        int size = arrayList.size();
        if (size == 1) {
            C3485 c3485 = arrayList.get(0);
            double dM11358 = c3485.m11358();
            double d = dM11358 - (z ? this.f12655 : this.f12654);
            int i = z ? 5 : 4;
            if (this.f12650) {
                C4638.m14099(f12648, String.format("equivalentFocalLength : %s , abs : %s , maxAbs : %s", Double.valueOf(dM11358), Double.valueOf(d), Integer.valueOf(i)));
            }
            c3485.m11403(1.0f);
            if (z) {
                c3485.m11402(true);
                C3444.InterfaceC3449.f11897.m12150(true).m12144(c3485.m11360());
            } else {
                c3485.m11402(true);
                C3828 c3828 = C3444.InterfaceC3449.f11899;
                c3828.m12150(true).m12144(c3485.m11360());
                C3828 c38282 = C3444.InterfaceC3449.f11902;
                if (!c38282.m12143()) {
                    c38282.m12150(true).m12144(c3828.m12137());
                }
            }
        } else {
            Collections.sort(arrayList, new C3642());
            C3485 c34852 = arrayList.get(0);
            int i2 = size - 1;
            C3485 c34853 = arrayList.get(i2);
            if (c34853.m11358() == -1.0d || c34852.m11358() == -1.0d) {
                if (this.f12650) {
                    C4638.m14099(f12648, String.format("min : %s , max : %s ", Double.valueOf(c34852.m11358()), Double.valueOf(c34853.m11358())));
                }
                return false;
            }
            if (c34852.m11358() > c34853.m11358()) {
                if (this.f12650) {
                    C4638.m14099(f12648, String.format("why ? min : %s , max : %s ", Double.valueOf(c34852.m11358()), Double.valueOf(c34853.m11358())));
                }
                return false;
            }
            int i3 = 0;
            while (i3 < i2) {
                C3485 c34854 = arrayList.get(i3);
                int i4 = i3 + 1;
                for (int i5 = i4; i5 < size; i5++) {
                    if (c34854.m11358() == arrayList.get(i5).m11358()) {
                        if (this.f12650) {
                            C4638.m14099(f12648, String.format("min : %s , max : %s ", Integer.valueOf(i3), Integer.valueOf(i5)));
                        }
                        return false;
                    }
                }
                i3 = i4;
            }
            Size size2 = null;
            int width = 0;
            int i6 = -1;
            for (int i7 = 0; i7 < size; i7++) {
                C3485 c34855 = arrayList.get(i7);
                double dM113582 = c34855.m11358();
                if (dM113582 >= 22.0d && dM113582 <= 28.0d && (sizeM11365 = c34855.m11365()) != null) {
                    int width2 = sizeM11365.getWidth() * sizeM11365.getHeight();
                    if (size2 == null || width2 >= width) {
                        width = sizeM11365.getWidth() * sizeM11365.getHeight();
                        C4638.m14099(f12648, String.format("widePosition : %s ", Integer.valueOf(i7)));
                        i6 = i7;
                        size2 = sizeM11365;
                    }
                }
            }
            if (i6 == -1) {
                int i8 = 0;
                double d2 = Double.MAX_VALUE;
                while (i8 < size) {
                    int i9 = size;
                    double dAbs = Math.abs(arrayList.get(i8).m11358() - (z ? this.f12655 : this.f12654));
                    if (dAbs < d2) {
                        d2 = dAbs;
                        i6 = i8;
                    }
                    i8++;
                    size = i9;
                }
            }
            int i10 = size;
            if (i6 == -1) {
                if (this.f12650) {
                    C4638.m14099(f12648, String.format("widePosition : %s ", Integer.valueOf(i6)));
                }
                return false;
            }
            C3485 c34856 = arrayList.get(i6);
            c34856.m11402(true);
            c34856.m11403(1.0f);
            double dM113583 = c34856.m11358();
            if (z) {
                C3444.InterfaceC3449.f11897.m12150(true).m12144(c34856.m11360());
            } else {
                C3828 c38283 = C3444.InterfaceC3449.f11899;
                c38283.m12150(true).m12144(c34856.m11360());
                C3828 c38284 = C3444.InterfaceC3449.f11902;
                if (!c38284.m12143()) {
                    c38284.m12150(true).m12144(c38283.m12137());
                }
            }
            double d3 = 1.0d;
            if (i6 != 0) {
                C3485 c34857 = arrayList.get(0);
                c34857.m11399(true);
                double dM113584 = c34857.m11358();
                c34857.m11403((float) (dM113584 / dM113583));
                if (z) {
                    C3444.InterfaceC3449.f11895.m12150(true).m12144(c34857.m11360());
                } else {
                    C3444.InterfaceC3449.f11898.m12150(true).m12144(c34857.m11360());
                }
                d3 = dM113584;
            }
            int i11 = i6 + 1;
            if (i11 < i10) {
                C3485 c34858 = arrayList.get(i11);
                c34858.m11401(true);
                c34858.m11403((float) (c34858.m11358() / dM113583));
                if (!z) {
                    C3444.InterfaceC3449.f11900.m12150(true).m12144(c34858.m11360());
                }
            }
            int i12 = i6 + 2;
            if (i12 < i10) {
                C3485 c34859 = arrayList.get(i12);
                c34859.m11403((float) (c34859.m11358() / dM113583));
                if (!z) {
                    C3444.InterfaceC3449.f11901.m12150(true).m12144(c34859.m11360());
                }
            }
            if (!z) {
                double d4 = dM113583 / d3;
                if (this.f12650) {
                    C4638.m14099(f12648, String.format("v : %s , largeWideEquivalentFocalLength : %s , wideEquivalentFocalLength : %s ", Double.valueOf(d4), Double.valueOf(d3), Double.valueOf(dM113583)));
                }
                if (d4 > this.f12656 || d4 < this.f12657) {
                    if (!this.f12650) {
                        return false;
                    }
                    C4638.m14099(f12648, String.format("largeWideEquivalentFocalLength : %s , wideEquivalentFocalLength : %s ", Double.valueOf(d3), Double.valueOf(dM113583)));
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m11718(ArrayList<C3485> arrayList, boolean z) {
        int size = arrayList.size();
        if (size > 0) {
            Collections.sort(arrayList, new C3643());
            if (m11724(arrayList.get(0).m11361()) != -1.0f) {
                m11715(arrayList, size, true, z);
            } else {
                Collections.sort(arrayList, new C3644());
                m11715(arrayList, size, false, z);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1  */
    /* renamed from: ՠ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m11719(java.util.ArrayList<defpackage.C3485> r21) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3641.m11719(java.util.ArrayList):boolean");
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m11720(CameraManager cameraManager) throws CameraAccessException {
        String[] cameraIdList = cameraManager.getCameraIdList();
        if (this.f12650) {
            C4638.m14099(f12648, String.format("cameraIdList : %s ", Arrays.toString(cameraIdList)));
        }
        for (String str : cameraIdList) {
            try {
                m11714(str, cameraManager.getCameraCharacteristics(str), false, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C3485> it = this.f12652.iterator();
        while (it.hasNext()) {
            C3485 next = it.next();
            if (next.m11386()) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C3485 c3485 = (C3485) it2.next();
            for (String str2 : c3485.m11366()) {
                if (!m11728(cameraIdList, str2)) {
                    m11714(str2, cameraManager.getCameraCharacteristics(str2), true, c3485.m11360());
                }
            }
        }
        if (this.f12650) {
            C4638.m14099(f12648, String.format("mSupportVideoCameraIds : %s ", this.f12652));
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public C3485 m11721(String str) {
        ArrayList<C3485> arrayList = this.f12651;
        if (arrayList != null && arrayList.size() > 0 && str != null && !"".equals(str)) {
            Iterator<C3485> it = this.f12651.iterator();
            while (it.hasNext()) {
                C3485 next = it.next();
                if (next.m11360().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public C3485 m11722(String str) {
        ArrayList<C3485> arrayList = this.f12651;
        if (arrayList != null && arrayList.size() > 0 && str != null && !"".equals(str)) {
            C3828 c3828M11224 = C3444.m11224(str);
            if (c3828M11224.m12143()) {
                return m11721(c3828M11224.m12137());
            }
        }
        return null;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public ArrayList<C3485> m11723() {
        return this.f12651;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final float m11724(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return -1.0f;
        }
        return fArr[0];
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final ArrayList<C3485> m11725(List<C3485> list, boolean z) {
        ArrayList<C3485> arrayList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            for (C3485 c3485 : list) {
                if (!c3485.m11386() && c3485.m11383() == z) {
                    arrayList.add(c3485);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public ArrayList<C3485> m11726() {
        return this.f12652;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m11727(CameraManager cameraManager) throws Resources.NotFoundException {
        if (this.f12653 || cameraManager == null) {
            return;
        }
        this.f12651 = new ArrayList<>();
        this.f12652 = new ArrayList<>();
        try {
            m11720(cameraManager);
            m11716();
            C3410.m11181();
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
        }
        this.f12653 = true;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final boolean m11728(String[] strArr, String str) {
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m11729(ArrayList<C3485> arrayList, ArrayList<C3485> arrayList2) throws Resources.NotFoundException {
        int size = arrayList2.size();
        int size2 = arrayList.size();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(C3444.InterfaceC3449.f11898);
        arrayList3.add(C3444.InterfaceC3449.f11899);
        arrayList3.add(C3444.InterfaceC3449.f11900);
        arrayList3.add(C3444.InterfaceC3449.f11901);
        arrayList3.add(C3444.InterfaceC3449.f11903);
        arrayList3.add(C3444.InterfaceC3449.f11904);
        int iMin = Math.min(arrayList3.size(), size);
        String string = FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_LENS_REAR_AUTO);
        int i = 0;
        while (i < iMin) {
            C3828 c3828 = (C3828) arrayList3.get(i);
            C3485 c3485 = arrayList2.get(i);
            c3828.m12144(c3485.m11360());
            c3828.m12150(true);
            i++;
            String str = String.format("%s%s", string, Integer.valueOf(i));
            c3828.m12148(str);
            c3828.m12146(str);
            c3828.m12145(true);
            C4638.m14099(f12648, String.format("cameraLensBean : %s ", c3828));
            C3828 c38282 = C3444.InterfaceC3449.f11902;
            if (!c38282.m12143()) {
                c38282.m12150(true);
                c38282.m12144(c3485.m11360());
            }
        }
        C3828 c38283 = C3444.InterfaceC3449.f11899;
        if (c38283.m12143()) {
            C3828 c38284 = C3444.InterfaceC3449.f11902;
            c38284.m12150(true);
            c38284.m12144(c38283.m12137());
        }
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(C3444.InterfaceC3449.f11897);
        arrayList4.add(C3444.InterfaceC3449.f11895);
        arrayList4.add(C3444.InterfaceC3449.f11896);
        arrayList4.add(C3444.InterfaceC3449.f11905);
        arrayList4.add(C3444.InterfaceC3449.f11906);
        int iMin2 = Math.min(size2, arrayList4.size());
        String string2 = FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_LENS_SELFIE);
        int i2 = 0;
        while (i2 < iMin2) {
            C3828 c38285 = (C3828) arrayList4.get(i2);
            c38285.m12144(arrayList.get(i2).m11360());
            c38285.m12150(true);
            i2++;
            String str2 = String.format("%s%s", string2, Integer.valueOf(i2));
            c38285.m12148(str2);
            c38285.m12146(str2);
            c38285.m12145(true);
            C4638.m14099(f12648, String.format("cameraLensBean : %s ", c38285));
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m11730() {
        C3444.InterfaceC3449.f11896.m12150(false);
        C3444.InterfaceC3449.f11895.m12150(false);
        C3444.InterfaceC3449.f11897.m12150(false);
        C3444.InterfaceC3449.f11902.m12150(false);
        C3444.InterfaceC3449.f11899.m12150(false);
        C3444.InterfaceC3449.f11898.m12150(false);
        C3444.InterfaceC3449.f11900.m12150(false);
        C3444.InterfaceC3449.f11901.m12150(false);
        C3444.InterfaceC3449.f11903.m12150(false);
        C3444.InterfaceC3449.f11904.m12150(false);
        C3444.InterfaceC3449.f11905.m12150(false);
        C3444.InterfaceC3449.f11906.m12150(false);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final double m11731(float f, SizeF sizeF) {
        return (f * 43.27d) / Math.sqrt((sizeF.getWidth() * sizeF.getWidth()) + (sizeF.getHeight() * sizeF.getHeight()));
    }
}
