package defpackage;

import android.bluetooth.BluetoothDevice;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import defpackage.C3560;
import defpackage.C4489;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProtakeFocusManager.java */
/* renamed from: ౙ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4567 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final String f15618 = "ౙ";

    /* renamed from: ՠ, reason: contains not printable characters */
    public static C4567 f15619 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static float f15620 = 0.041666668f;

    /* renamed from: ԩ, reason: contains not printable characters */
    public C4489 f15623;

    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC4573 f15625;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC4571 f15626;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC4574 f15627;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC4572 f15628;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f15622 = 24;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C4489.InterfaceC4491 f15624 = new C4569();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<C3637> f15621 = new ArrayList();

    /* compiled from: ProtakeFocusManager.java */
    /* renamed from: ౙ$Ϳ, reason: contains not printable characters */
    public class C4568 implements C3560.InterfaceC3564 {
        public C4568() {
        }

        @Override // defpackage.C3560.InterfaceC3564
        /* renamed from: Ϳ */
        public void mo11516(C4489 c4489) {
            BluetoothDevice bluetoothDeviceM13768;
            boolean z = true;
            if (r1.m8144(C4567.this.f15621)) {
                for (C3637 c3637 : C4567.this.f15621) {
                    if (c3637.m11702() != null && (bluetoothDeviceM13768 = c3637.m11702().m13768()) != null && bluetoothDeviceM13768.getAddress().equals(c4489.m13768().getAddress())) {
                        z = false;
                    }
                }
            }
            if (z) {
                C3637 c36372 = new C3637();
                c36372.m11704(false);
                c36372.m11705(c4489);
                C4567.this.f15621.add(c36372);
                if (C4567.this.f15625 != null) {
                    C4567.this.f15625.mo2923();
                }
                String strM9569 = C2618.m9569("protake_focus_his_sp", "");
                if (!C4567.this.m14015() && r1.m8143(strM9569) && strM9569.equals(c4489.m13769())) {
                    C4567.this.m14007(c36372);
                    C4567.this.m14008(c36372);
                    c4489.m13766();
                }
            }
        }

        @Override // defpackage.C3560.InterfaceC3564
        /* renamed from: Ԩ */
        public void mo11517() {
            if (C4567.this.f15625 != null) {
                C4567.this.f15625.mo2923();
            }
        }

        @Override // defpackage.C3560.InterfaceC3564
        /* renamed from: ԩ */
        public void mo11518(C4489 c4489) {
            BluetoothDevice bluetoothDeviceM13768;
            if (r1.m8144(C4567.this.f15621)) {
                Iterator it = C4567.this.f15621.iterator();
                while (it.hasNext()) {
                    C3637 c3637 = (C3637) it.next();
                    if (c3637.m11702() != null && (bluetoothDeviceM13768 = c3637.m11702().m13768()) != null && bluetoothDeviceM13768.getAddress().equals(c4489.m13768().getAddress())) {
                        it.remove();
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: ProtakeFocusManager.java */
    /* renamed from: ౙ$Ԩ, reason: contains not printable characters */
    public class C4569 implements C4489.InterfaceC4491 {
        public C4569() {
        }

        @Override // defpackage.C4489.InterfaceC4491
        /* renamed from: Ϳ */
        public void mo13780(int i, int i2, int i3, String str) {
            String str2 = C4567.this.m14026(i) + MyUTIL.white_space + C4567.this.m14025(i2) + MyUTIL.white_space + i2;
            C4638.m14099(C4567.f15618, "onKeyEvent:" + str2);
            if (((i == 1004 || i == 1003) || i2 != 2001) && C4567.this.f15628 == null && C4567.this.f15627 == null && C4567.this.f15626 != null) {
                C4567.this.m14010(i, i2);
            }
        }
    }

    /* compiled from: ProtakeFocusManager.java */
    /* renamed from: ౙ$Ԫ, reason: contains not printable characters */
    public class C4570 implements C4489.InterfaceC4492 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ C3637 f15631;

        public C4570(C3637 c3637) {
            this.f15631 = c3637;
        }

        @Override // defpackage.C4489.InterfaceC4492
        /* renamed from: Ϳ */
        public void mo13781(int i) {
            if (i == 0) {
                this.f15631.m11704(false);
                if (C4567.this.f15625 != null) {
                    C4567.this.f15625.mo2923();
                    C4567.this.f15625.mo2922();
                } else if (C4567.this.f15627 != null) {
                    C4567.this.f15627.mo1722();
                }
                C4567.this.f15623 = null;
                if (C4567.this.f15626 != null) {
                    C4567.this.f15626.mo1321();
                    return;
                }
                return;
            }
            if (i == 1) {
                if (C4567.this.f15625 != null) {
                    C4567.this.f15625.mo2923();
                }
            } else {
                if (i != 2) {
                    return;
                }
                this.f15631.m11704(false);
                C4567.this.f15623 = this.f15631.m11702();
                if (C4567.this.f15625 != null) {
                    C2618.m9573("protake_focus_his_sp", this.f15631.m11702().m13769());
                    C4567.this.f15625.mo2923();
                    C4567.this.f15625.mo2924();
                } else if (C4567.this.f15627 != null) {
                    C4567.this.f15627.mo1720();
                }
                if (C4567.this.f15626 != null) {
                    C4567.this.f15626.mo1316();
                }
            }
        }

        @Override // defpackage.C4489.InterfaceC4492
        /* renamed from: Ԩ */
        public void mo13782() {
            if (C4567.this.f15628 != null) {
                return;
            }
            if (C4567.this.f15627 != null) {
                C4567.this.f15627.mo1721();
            } else if (C4567.this.f15626 != null) {
                C4567.this.f15626.mo1317();
            }
        }
    }

    /* compiled from: ProtakeFocusManager.java */
    /* renamed from: ౙ$Ԭ, reason: contains not printable characters */
    public interface InterfaceC4571 {
        /* renamed from: Ϳ */
        void mo1316();

        /* renamed from: Ԩ */
        void mo1317();

        /* renamed from: ԩ */
        void mo1318(int i);

        /* renamed from: Ԫ */
        void mo1319();

        /* renamed from: Ԭ */
        int mo1320();

        /* renamed from: ԭ */
        void mo1321();

        /* renamed from: Ԯ */
        void mo1322();

        /* renamed from: ԯ */
        void mo1323();

        /* renamed from: ՠ */
        void mo1324(boolean z, int i);
    }

    /* compiled from: ProtakeFocusManager.java */
    /* renamed from: ౙ$Ԯ, reason: contains not printable characters */
    public interface InterfaceC4572 {
    }

    /* compiled from: ProtakeFocusManager.java */
    /* renamed from: ౙ$ՠ, reason: contains not printable characters */
    public interface InterfaceC4573 {
        /* renamed from: Ԩ */
        void mo2922();

        /* renamed from: ԩ */
        void mo2923();

        /* renamed from: Ԫ */
        void mo2924();
    }

    /* compiled from: ProtakeFocusManager.java */
    /* renamed from: ౙ$ֈ, reason: contains not printable characters */
    public interface InterfaceC4574 {
        /* renamed from: Ϳ */
        void mo1720();

        /* renamed from: Ԩ */
        void mo1721();

        /* renamed from: ԭ */
        void mo1722();
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public static C4567 m14006() {
        if (f15619 == null) {
            synchronized (C4567.class) {
                if (f15619 == null) {
                    f15619 = new C4567();
                }
            }
        }
        return f15619;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m14007(C3637 c3637) {
        c3637.m11702().m13776(this.f15624);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m14008(C3637 c3637) {
        c3637.m11702().m13778(new C4570(c3637));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m14009() {
        this.f15621.clear();
        C3560.m11508().m11512();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m14010(int i, int i2) {
        InterfaceC4571 interfaceC4571 = this.f15626;
        if (interfaceC4571 != null) {
            if (i != 1004) {
            }
            int iMo1320 = interfaceC4571.mo1320();
            if (iMo1320 != 0 && i == 1000) {
                this.f15626.mo1318(iMo1320);
            }
            switch (i) {
                case 1000:
                    this.f15626.mo1319();
                    break;
                case 1001:
                    this.f15626.mo1323();
                    break;
                case 1002:
                    this.f15626.mo1322();
                    break;
                case 1003:
                    this.f15626.mo1324(!C4535.m13880().m13903(), i2);
                    break;
                case 1004:
                    this.f15626.mo1324(C4535.m13880().m13903(), i2);
                    break;
            }
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m14011() {
        f15619 = null;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m14012() {
        if (r1.m8144(this.f15621)) {
            for (C3637 c3637 : this.f15621) {
                c3637.m11704(false);
                C4489 c4489M11702 = c3637.m11702();
                if (c4489M11702 != null) {
                    c4489M11702.m13767();
                }
            }
        }
        this.f15623 = null;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public C4489 m14013() {
        return this.f15623;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public List<C3637> m14014() {
        return this.f15621;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public boolean m14015() {
        if (r1.m8144(this.f15621)) {
            Iterator<C3637> it = this.f15621.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().m11702().m13774()) {
                    z = true;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m14016(C3637 c3637) {
        m14007(c3637);
        m14008(c3637);
        C3560.m11508().m11513(c3637.m11702());
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m14017() {
        this.f15623 = null;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m14018(InterfaceC4571 interfaceC4571) {
        this.f15626 = interfaceC4571;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m14019(InterfaceC4572 interfaceC4572) {
        this.f15628 = interfaceC4572;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m14020(InterfaceC4573 interfaceC4573) {
        this.f15625 = interfaceC4573;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m14021(InterfaceC4574 interfaceC4574) {
        this.f15627 = interfaceC4574;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m14022(int i) {
        if (this.f15622 == i || i == 0) {
            return;
        }
        this.f15622 = i;
        f15620 = 1.0f / i;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m14023() {
        if (C2749.m10011() && C2749.m10010() && C2749.m10009(FilmApp.m402()) && C2749.m10008(FilmApp.m402())) {
            C3560.m11508().m11514(new C4568());
        }
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m14024() {
        C3560.m11508().m11515();
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final String m14025(int i) {
        switch (i) {
            case 2000:
                return "pressed";
            case 2001:
                return "released";
            case 2002:
                return "roll";
            default:
                return "Failed";
        }
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final String m14026(int i) {
        switch (i) {
            case 1000:
                return "record";
            case 1001:
                return "FN1";
            case 1002:
                return "FN2";
            case 1003:
                return "wheel ccw";
            case 1004:
                return "wheel cw";
            default:
                return "Failed";
        }
    }
}
