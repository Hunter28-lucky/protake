package defpackage;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.home.fragment.FragmentCallback;
import com.blink.academy.film.netbean.store.NvtProductItem;
import com.blink.academy.film.netbean.store.NvtProductListCallbackEntity;
import com.blink.academy.film.stream.NetInfoBean;
import com.blink.academy.film.widgets.PayProductDialog;
import com.blink.academy.film.widgets.transmit.TransmitSettingView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorView;
import java.util.List;

/* compiled from: HomeTransmitFragment.java */
/* renamed from: ݦ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3744 extends Fragment {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3230 f12963;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public FragmentCallback f12964;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC3749 f12965;

    /* compiled from: HomeTransmitFragment.java */
    /* renamed from: ݦ$Ϳ, reason: contains not printable characters */
    public class C3745 implements TransmitSettingView.InterfaceC1640 {
        public C3745() {
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingView.InterfaceC1640
        /* renamed from: Ϳ */
        public void mo4378() throws Resources.NotFoundException {
            C3744.this.m12025();
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingView.InterfaceC1640
        /* renamed from: Ԩ */
        public void mo4379(int i) {
            if (C3744.this.f12964 != null) {
                C3744.this.f12964.mo1225(i);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingView.InterfaceC1640
        /* renamed from: ԩ */
        public void mo4380() {
            if (C3744.this.f12965 != null) {
                C3744.this.f12965.mo1573();
            } else if (C3744.this.f12964 != null) {
                C3744.this.f12964.mo1258();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingView.InterfaceC1640
        /* renamed from: Ԫ */
        public boolean mo4381() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingView.InterfaceC1640
        /* renamed from: ԫ */
        public void mo4382(boolean z) {
            if (C3744.this.f12965 != null) {
                C3744.this.f12965.mo1571();
            }
            if (C3744.this.f12964 != null) {
                C3744.this.f12964.mo1246(false, C3744.this.f12965 == null);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingView.InterfaceC1640
        /* renamed from: Ԯ */
        public void mo4383(boolean z) {
            if (C3744.this.f12964 != null) {
                C3744.this.f12964.mo1188(z);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingView.InterfaceC1640
        /* renamed from: ֏ */
        public void mo4384(int i, int i2, boolean z) {
            if (C3744.this.f12965 != null) {
                C3744.this.f12965.mo1566(i, i2, z);
            }
            C3744.this.f12964.mo1237(i, i2, z, C3744.this.f12965 == null ? null : C3744.this.f12965.mo1572());
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingView.InterfaceC1640
        /* renamed from: ފ */
        public void mo4385() {
            if (C3744.this.f12965 != null) {
                C3744.this.f12965.mo1568();
            }
            C3744.this.f12964.mo1214();
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingView.InterfaceC1640
        /* renamed from: ދ */
        public void mo4386(int i, String str, boolean z) {
            if (C3744.this.f12965 != null) {
                C3744.this.f12965.mo1569(i, str, z);
            }
            C3744.this.f12964.mo1218(i, str, z);
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingView.InterfaceC1640
        /* renamed from: ތ */
        public void mo4387() {
            C3744.this.f12964.mo1235();
            if (C3744.this.f12965 != null) {
                C3744.this.f12965.mo1570();
            }
            if (C3744.this.f12963 != null) {
                C3744.this.f12963.f11382.m4706();
            }
        }
    }

    /* compiled from: HomeTransmitFragment.java */
    /* renamed from: ݦ$Ԩ, reason: contains not printable characters */
    public class C3746 implements MonitorView.InterfaceC1779 {
        public C3746() {
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorView.InterfaceC1779
        /* renamed from: Ϳ */
        public void mo4708() throws Resources.NotFoundException {
            C3744.this.m12025();
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorView.InterfaceC1779
        /* renamed from: Ԩ */
        public void mo4709() {
            if (C3744.this.f12965 != null) {
                C3744.this.f12965.mo1567();
            } else if (C3744.this.f12964 != null) {
                C3744.this.f12964.mo1204();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorView.InterfaceC1779
        /* renamed from: ԩ */
        public void mo4710() {
            if (C3744.this.f12964 != null) {
                C3744.this.f12964.mo1265();
                C3744.this.f12964.mo1288();
            }
        }
    }

    /* compiled from: HomeTransmitFragment.java */
    /* renamed from: ݦ$Ԫ, reason: contains not printable characters */
    public class C3747 implements PayProductDialog.InterfaceC0936 {
        public C3747() {
        }

        @Override // com.blink.academy.film.widgets.PayProductDialog.InterfaceC0936
        /* renamed from: Ϳ */
        public boolean mo2493() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.PayProductDialog.InterfaceC0936
        /* renamed from: ԩ */
        public void mo2494(NvtProductItem nvtProductItem) {
            if (C3744.this.f12965 != null) {
                C3744.this.f12965.mo1564(nvtProductItem);
            } else if (C3744.this.f12964 != null) {
                C3744.this.f12964.mo1183(nvtProductItem);
            }
        }

        @Override // com.blink.academy.film.widgets.PayProductDialog.InterfaceC0936
        /* renamed from: ֈ */
        public void mo2495() {
            if (C3744.this.f12965 != null) {
                C3744.this.f12965.mo1565();
            } else if (C3744.this.f12964 != null) {
                C3744.this.f12964.mo1191();
            }
        }
    }

    /* compiled from: HomeTransmitFragment.java */
    /* renamed from: ݦ$Ԭ, reason: contains not printable characters */
    public class RunnableC3748 implements Runnable {
        public RunnableC3748() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C3744.this.f12963 != null) {
                C3744.this.f12963.f11382.m4685();
            }
        }
    }

    /* compiled from: HomeTransmitFragment.java */
    /* renamed from: ݦ$Ԯ, reason: contains not printable characters */
    public interface InterfaceC3749 {
        /* renamed from: ԩ */
        void mo1564(NvtProductItem nvtProductItem);

        /* renamed from: ֈ */
        void mo1565();

        /* renamed from: ֏ */
        void mo1566(int i, int i2, boolean z);

        /* renamed from: މ */
        void mo1567();

        /* renamed from: ފ */
        void mo1568();

        /* renamed from: ދ */
        void mo1569(int i, String str, boolean z);

        /* renamed from: ތ */
        void mo1570();

        /* renamed from: ލ */
        void mo1571();

        /* renamed from: ގ */
        DecoderParamsBean mo1572();

        /* renamed from: ޏ */
        void mo1573();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f12963 = AbstractC3230.m10892(LayoutInflater.from(getContext()), viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.setClassLoader(getClass().getClassLoader());
        }
        if (arguments != null) {
            try {
                this.f12964 = (FragmentCallback) arguments.getParcelable("fcallback");
            } catch (Exception unused) {
                this.f12964 = C4425.m13657().m13658();
            }
        }
        m12004();
        return this.f12963.getRoot();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m11996() {
        this.f12963.f11382.m4677();
        this.f12963.f11382.setVisibility(8);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m11997() {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 == null) {
            return;
        }
        abstractC3230.f11383.m2479();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m11998() {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 == null) {
            return;
        }
        abstractC3230.f11381.m4352();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m11999() {
        this.f12963.f11381.setOnTransmitStateChangeListener(new C3745());
        this.f12963.f11382.setOnChangeListener(new C3746());
        this.f12963.f11383.setOnPayProductDialogListener(new C3747());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m12000() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f12963.f11381.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = C2579.m9444();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C2579.m9440(getContext());
        this.f12963.f11381.setLayoutParams(layoutParams);
        this.f12963.f11383.setPortrait(false);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean m12001() {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 == null) {
            return false;
        }
        return abstractC3230.f11381.m4350();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m12002(int i) {
        this.f12963.f11381.m4353(i);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m12003(boolean z) {
        this.f12963.f11381.m4354(z);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m12004() {
        m12000();
        m11999();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m12005(boolean z) {
        this.f12963.f11381.m4356(z);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m12006() {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 != null) {
            abstractC3230.f11381.m4363();
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m12007() {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 != null) {
            abstractC3230.f11381.m4364();
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m12008(int i) {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 == null || !abstractC3230.f11381.m4350()) {
            return;
        }
        this.f12963.f11381.m4358(i);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m12009(NetInfoBean netInfoBean) {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 != null) {
            abstractC3230.f11381.setWifiInfo(netInfoBean);
        }
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m12010(boolean z) {
        this.f12963.f11381.m4361(z);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m12011() {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 != null) {
            abstractC3230.f11382.m4697();
            this.f12963.f11382.m4689();
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m12012(int i, int i2, boolean z, String str, int i3) {
        m12021(i, i2, z, str, i3);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m12013() {
        this.f12963.f11383.m2485();
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m12014() {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 != null) {
            abstractC3230.f11382.m4694();
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m12015() {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 != null) {
            abstractC3230.f11382.m4695();
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m12016(String str) {
        this.f12963.f11381.m4365(str);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m12017() {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 != null) {
            abstractC3230.f11381.m4366();
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m12018() {
        if (this.f12963.f11382.m4684()) {
            m12011();
        } else {
            m12006();
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m12019(NetInfoBean netInfoBean) {
        m12018();
        m12009(netInfoBean);
        m12015();
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m12020(boolean z, boolean z2) {
        if (z) {
            m12007();
        }
        if (z2) {
            m12014();
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m12021(int i, int i2, boolean z, String str, int i3) {
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 == null || !abstractC3230.f11382.m4684()) {
            return;
        }
        this.f12963.f11382.m4699(i, i2, z, str, i3);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m12022(InterfaceC3749 interfaceC3749) {
        this.f12965 = interfaceC3749;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m12023() {
        FilmApp.m405().m428(new RunnableC3748(), 200L);
        AbstractC3230 abstractC3230 = this.f12963;
        if (abstractC3230 != null) {
            abstractC3230.f11381.m4362();
        }
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m12024() {
        this.f12963.f11382.setVisibility(0);
        this.f12963.f11382.m4703();
        FragmentCallback fragmentCallback = this.f12964;
        if (fragmentCallback != null) {
            this.f12963.f11382.m4690(fragmentCallback.mo1221());
        }
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m12025() throws Resources.NotFoundException {
        NvtProductListCallbackEntity nvtProductListCallbackEntityM7597 = n.m7588().m7597();
        List<NvtProductItem> items = nvtProductListCallbackEntityM7597 == null ? null : nvtProductListCallbackEntityM7597.getItems();
        this.f12963.f11383.m2489(null);
        this.f12963.f11383.setList(items);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m12026() {
        this.f12963.f11381.setVisibility(0);
        this.f12963.f11381.m4375();
        FragmentCallback fragmentCallback = this.f12964;
        if (fragmentCallback != null) {
            if (this.f12965 != null) {
                fragmentCallback.mo1246(true, false);
            }
            this.f12964.mo1225(this.f12963.f11381.getQualityType());
        }
    }
}
