package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.srt.SRTConnectionCallbackEntity;
import com.blink.academy.film.netbean.srt.SRTConnectionServerBean;
import com.blink.academy.film.netbean.store.NvtInfoCallbackEntity;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.ConnectionManager;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.stream.LinkManager;
import com.blink.academy.film.stream.PingHelper;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.SwitchButton2;
import com.blink.academy.protake.R;
import defpackage.AbstractC4403;
import defpackage.C2462;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.e5;
import defpackage.n;
import defpackage.p3;
import defpackage.r1;

/* loaded from: classes.dex */
public class TransmitSettingPag1 extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4403 f4269;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4270;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4271;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f4272;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f4273;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f4274;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f4275;

    /* renamed from: ֏, reason: contains not printable characters */
    public String f4276;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f4277;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f4278;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f4279;

    /* renamed from: ށ, reason: contains not printable characters */
    public InterfaceC1616 f4280;

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1592 implements View.OnClickListener {
        public ViewOnClickListenerC1592() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4275 = 4;
            FinderManager.getInstance().setSelectMachine(FinderManager.MACHINE_D);
            TransmitSettingPag1.this.m4289(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1593 implements View.OnClickListener {
        public ViewOnClickListenerC1593() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4273 = 1;
            TransmitSettingPag1.this.m4294(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1594 implements View.OnClickListener {
        public ViewOnClickListenerC1594() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4273 = 2;
            TransmitSettingPag1.this.m4294(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1595 implements View.OnClickListener {
        public ViewOnClickListenerC1595() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4273 = 3;
            TransmitSettingPag1.this.m4294(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1596 implements View.OnClickListener {
        public ViewOnClickListenerC1596() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4273 = 4;
            TransmitSettingPag1.this.m4294(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1597 implements View.OnClickListener {
        public ViewOnClickListenerC1597() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TransmitSettingPag1.this.f4280 != null) {
                TransmitSettingPag1.this.f4280.mo4309();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ֈ, reason: contains not printable characters */
    public class C1598 implements SwitchButton.InterfaceC0969 {
        public C1598() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            if (TransmitSettingPag1.this.f4280 != null) {
                TransmitSettingPag1.this.f4278 = z;
                C2618.m9570("transmit_monitor_control", TransmitSettingPag1.this.f4278);
                LinkManager.getInstance().setControllable(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$֏, reason: contains not printable characters */
    public class C1599 implements SwitchButton.InterfaceC0969 {
        public C1599() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            if (TransmitSettingPag1.this.f4280 != null) {
                TransmitSettingPag1.this.f4277 = z;
                C2618.m9570("transmit_camera_control", TransmitSettingPag1.this.f4277);
                ConnectionManager.getInstance().setControllable(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ׯ, reason: contains not printable characters */
    public class C1600 implements SwitchButton2.InterfaceC0975 {

        /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ׯ$Ϳ, reason: contains not printable characters */
        public class C1601 implements n.InterfaceC2189 {
            public C1601() {
            }

            @Override // defpackage.n.InterfaceC2189
            public void onFail(ApiException apiException) {
                ACHelper.getInstance().setCloudPush(true);
            }

            @Override // defpackage.n.InterfaceC2189
            public void onSuc(SRTConnectionCallbackEntity sRTConnectionCallbackEntity) {
                SRTConnectionServerBean srt_server = sRTConnectionCallbackEntity.getSrt_server();
                ConnectionManager.getInstance().startNet(srt_server.getIp(), srt_server.getPort(), sRTConnectionCallbackEntity.getSrt_passphrase(), "0.1 camera " + sRTConnectionCallbackEntity.getSrt_room_id() + MyUTIL.white_space + e5.m5988().m5991() + MyUTIL.white_space + sRTConnectionCallbackEntity.getSrt_connection_id(), sRTConnectionCallbackEntity);
            }
        }

        public C1600() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0975
        /* renamed from: Ϳ */
        public boolean mo2673() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0975
        /* renamed from: Ԩ */
        public void mo2674(SwitchButton2 switchButton2, boolean z, boolean z2) {
            if (z2) {
                C2618.m9570("cloud_camera_sp", z);
                if (z) {
                    TransmitSettingPag1.this.m4290(ACHelper.getInstance().getRoomId());
                } else if (r1.m8143(ACHelper.getInstance().getRoomId())) {
                    TransmitSettingPag1.this.m4284();
                } else {
                    TransmitSettingPag1.this.m4283(0);
                }
                if (TransmitHelper.getInstance().isStartCameraTransmit()) {
                    if (z) {
                        n.m7588().m7599(new C1601(), true, ACHelper.getInstance().getRoomId());
                    } else {
                        ConnectionManager.getInstance().disableNet();
                    }
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ؠ, reason: contains not printable characters */
    public class C1602 implements SwitchButton2.InterfaceC0976 {
        public C1602() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0976
        /* renamed from: Ϳ */
        public void mo2675() {
            if (TransmitSettingPag1.this.f4280 == null || TransmitHelper.getInstance().isStartCameraTransmit() || TransmitSettingPag1.this.f4269.f15169.getAlpha() != 1.0f) {
                return;
            }
            TransmitSettingPag1.this.f4280.mo4311(false);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ހ, reason: contains not printable characters */
    public class RunnableC1603 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4292;

        public RunnableC1603(boolean z) {
            this.f4292 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TransmitSettingPag1.this.m4282() || TransmitSettingPag1.this.f4272 != 1) {
                if (this.f4292) {
                    C2618.m9571("transmit_equipment_type", TransmitSettingPag1.this.f4272);
                }
            } else {
                TransmitSettingPag1.this.f4272 = 2;
                TransmitSettingPag1.this.m4292(false);
                if (TransmitSettingPag1.this.f4280 != null) {
                    TransmitSettingPag1.this.f4280.mo4308();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ށ, reason: contains not printable characters */
    public class ViewOnClickListenerC1604 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ށ$Ϳ, reason: contains not printable characters */
        public class RunnableC1605 implements Runnable {
            public RunnableC1605() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TransmitSettingPag1.this.f4272 = 2;
                TransmitSettingPag1.this.m4292(false);
                if (TransmitSettingPag1.this.f4280 != null) {
                    TransmitSettingPag1.this.f4280.mo4308();
                }
            }
        }

        public ViewOnClickListenerC1604() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4272 = 1;
            if (TransmitSettingPag1.this.m4282()) {
                TransmitSettingPag1.this.m4292(true);
                return;
            }
            TransmitSettingPag1.this.f4269.f15147.m2575(false, 100);
            TransmitSettingPag1.this.f4269.f15146.m2575(true, 100);
            TransmitSettingPag1.this.f4269.f15146.postDelayed(new RunnableC1605(), 100L);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ނ, reason: contains not printable characters */
    public class ViewOnClickListenerC1606 implements View.OnClickListener {
        public ViewOnClickListenerC1606() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TransmitSettingPag1.this.f4280 == null || TransmitSettingPag1.this.f4269.f15152.getVisibility() != 0) {
                return;
            }
            TransmitSettingPag1.this.f4280.mo4311(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ރ, reason: contains not printable characters */
    public class ViewOnClickListenerC1607 implements View.OnClickListener {
        public ViewOnClickListenerC1607() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TransmitSettingPag1.this.f4280 != null) {
                TransmitSettingPag1.this.f4280.mo4306();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ބ, reason: contains not printable characters */
    public class RunnableC1608 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4298;

        public RunnableC1608(boolean z) {
            this.f4298 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TransmitSettingPag1.this.f4269 != null) {
                TransmitSettingPag1.this.f4269.f15152.setEnabled(this.f4298);
                TransmitSettingPag1.this.f4269.f15152.setAlpha(this.f4298 ? 1.0f : 0.3f);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ޅ, reason: contains not printable characters */
    public class ViewOnClickListenerC1609 implements View.OnClickListener {
        public ViewOnClickListenerC1609() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4272 = 2;
            TransmitSettingPag1.this.m4292(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ކ, reason: contains not printable characters */
    public class ViewOnClickListenerC1610 implements View.OnClickListener {
        public ViewOnClickListenerC1610() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4274 = 2;
            TransmitSettingPag1.this.m4296(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$އ, reason: contains not printable characters */
    public class ViewOnClickListenerC1611 implements View.OnClickListener {
        public ViewOnClickListenerC1611() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4274 = 3;
            TransmitSettingPag1.this.m4296(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ވ, reason: contains not printable characters */
    public class ViewOnClickListenerC1612 implements View.OnClickListener {
        public ViewOnClickListenerC1612() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4274 = 1;
            TransmitSettingPag1.this.m4296(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$މ, reason: contains not printable characters */
    public class ViewOnClickListenerC1613 implements View.OnClickListener {
        public ViewOnClickListenerC1613() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4275 = 1;
            FinderManager.getInstance().setSelectMachine("1");
            TransmitSettingPag1.this.m4289(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ފ, reason: contains not printable characters */
    public class ViewOnClickListenerC1614 implements View.OnClickListener {
        public ViewOnClickListenerC1614() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4275 = 2;
            FinderManager.getInstance().setSelectMachine("2");
            TransmitSettingPag1.this.m4289(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ދ, reason: contains not printable characters */
    public class ViewOnClickListenerC1615 implements View.OnClickListener {
        public ViewOnClickListenerC1615() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingPag1.this.f4275 = 3;
            FinderManager.getInstance().setSelectMachine(FinderManager.MACHINE_C);
            TransmitSettingPag1.this.m4289(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ތ, reason: contains not printable characters */
    public interface InterfaceC1616 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo4306();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo4307(int i);

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo4308();

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo4309();

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo4310();

        /* renamed from: Ԯ, reason: contains not printable characters */
        void mo4311(boolean z);
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ލ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1617 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f4307;

        /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ލ$Ϳ, reason: contains not printable characters */
        public class RunnableC1618 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4308;

            public RunnableC1618(View view) {
                this.f4308 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4308.isEnabled()) {
                    ViewOnTouchListenerC1617.this.f4307.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1617(View view) {
            this.f4307 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4307.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler(Looper.myLooper()).postDelayed(new RunnableC1618(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ގ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1619 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public StrokeTextViewWithBottomBlock f4310;

        /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPag1$ގ$Ϳ, reason: contains not printable characters */
        public class RunnableC1620 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4311;

            public RunnableC1620(View view) {
                this.f4311 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4311.isEnabled()) {
                    ViewOnTouchListenerC1619.this.f4310.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1619(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock) {
            this.f4310 = strokeTextViewWithBottomBlock;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (this.f4310.m2574()) {
                    return false;
                }
                this.f4310.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler(Looper.myLooper()).postDelayed(new RunnableC1620(view), 100L);
            return false;
        }
    }

    public TransmitSettingPag1(@NonNull Context context) {
        super(context);
        this.f4272 = 1;
        this.f4273 = 1;
        this.f4274 = 1;
        m4276();
    }

    public String getCameraDevice() {
        return this.f4276;
    }

    public int getCameraUnitType() {
        return this.f4275;
    }

    public int getEquipmentType() {
        return this.f4272;
    }

    public int getJobType() {
        return this.f4273;
    }

    public int getQualityType() {
        return this.f4274;
    }

    public void setOnChangeListener(InterfaceC1616 interfaceC1616) {
        this.f4280 = interfaceC1616;
    }

    public void setResetEnable(boolean z) {
        post(new RunnableC1608(z));
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m4275() {
        C2462.m9035().m9065();
        C4535.m13880().m13890().m12524(1001);
        C4535.m13880().m13915();
        m4291();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m4276() {
        this.f4269 = AbstractC4403.m13595(LayoutInflater.from(getContext()), this, true);
        m4300(false);
        m4277();
        m4278();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m4277() {
        this.f4270 = C2579.m9444();
        this.f4271 = C2579.m9440(getContext());
        C2579.m9439(getContext());
        float fM14471 = C4792.m14375().m14471();
        this.f4279 = (int) ((C4792.m14375().m14384() * fM14471) + 0.5f);
        int iM14468 = C4792.m14375().m14468();
        int iM14377 = C4792.m14375().m14377();
        int iM14478 = (int) (C4792.m14375().m14478(105.0f, fM14471) - (C2579.m9438(2.5f) + C4792.m14375().m14443()));
        int iM144782 = C4792.m14375().m14478(112.0f, fM14471);
        this.f4269.f15148.setContentTextColor(-1);
        float fM14397 = (int) ((C4792.m14375().m14397() * fM14471) + 0.5f);
        this.f4269.f15148.m2562(0, fM14397);
        this.f4269.f15167.setContentTextColor(-1);
        this.f4269.f15167.m2562(0, fM14397);
        this.f4269.f15142.setContentTextColor(-1);
        this.f4269.f15142.m2562(0, fM14397);
        this.f4269.f15133.setContentTextColor(-1);
        this.f4269.f15133.m2562(0, fM14397);
        this.f4269.f15158.setContentTextColor(-1);
        this.f4269.f15158.m2562(0, fM14397);
        this.f4269.f15136.setContentTextColor(-1);
        this.f4269.f15136.m2562(0, fM14397);
        this.f4269.f15160.setContentTextColor(-1);
        this.f4269.f15160.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4269.f15148.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = iM14468;
        this.f4269.f15148.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4269.f15146.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = iM14377;
        this.f4269.f15146.setLayoutParams(layoutParams2);
        m4288();
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4269.f15147.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = iM144782;
        this.f4269.f15147.setLayoutParams(layoutParams3);
        m4304(this.f4269.f15147, this.f4279, R.string.MONITOR_SETTINGS_VALUE_DEVICE_ROLE_MONITOR, R.drawable.icon_22_device_monitor);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4269.f15165.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = (int) (this.f4270 / 2.0f);
        this.f4269.f15165.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f4269.f15166.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = iM144782;
        this.f4269.f15166.setLayoutParams(layoutParams5);
        m4302(this.f4269.f15166, this.f4279, R.string.MONITOR_SETTINGS_VALUE_PRIORITY_STABILITY);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f4269.f15163.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = iM14377;
        this.f4269.f15163.setLayoutParams(layoutParams6);
        m4302(this.f4269.f15163, this.f4279, R.string.MONITOR_SETTINGS_VALUE_PRIORITY_QUALITY);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f4269.f15164.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin = iM144782;
        this.f4269.f15164.setLayoutParams(layoutParams7);
        m4302(this.f4269.f15164, this.f4279, R.string.MONITOR_SETTINGS_VALUE_PRIORITY_LATENCY);
        int i = (int) (iM144782 / 2.0f);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f4269.f15141.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = iM14478;
        ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i;
        this.f4269.f15141.setLayoutParams(layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f4269.f15142.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams9).leftMargin = i;
        this.f4269.f15142.setLayoutParams(layoutParams9);
        m4303(this.f4269.f15137, this.f4279, "A");
        this.f4269.f15137.setPadding(i, iM14377, i, iM14377);
        this.f4269.f15138.setPadding(i, iM14377, i, iM14377);
        this.f4269.f15139.setPadding(i, iM14377, i, iM14377);
        this.f4269.f15140.setPadding(i, iM14377, i, iM14377);
        m4303(this.f4269.f15138, this.f4279, TransmitHelper.CAMERA_UNIT_B_CONTENT);
        m4303(this.f4269.f15139, this.f4279, TransmitHelper.CAMERA_UNIT_C_CONTENT);
        m4303(this.f4269.f15140, this.f4279, TransmitHelper.CAMERA_UNIT_D_CONTENT);
        float fM9438 = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f4269.f15132.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).rightMargin = C4792.m14375().m14476(100) + iM14468;
        this.f4269.f15132.setLayoutParams(layoutParams10);
        ConstraintLayout.LayoutParams layoutParams11 = (ConstraintLayout.LayoutParams) this.f4269.f15159.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams11).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams10).rightMargin;
        this.f4269.f15159.setLayoutParams(layoutParams11);
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f4269.f15160.getLayoutParams();
        int i2 = (int) fM9438;
        ((ViewGroup.MarginLayoutParams) layoutParams12).leftMargin = i2;
        this.f4269.f15160.setLayoutParams(layoutParams12);
        ConstraintLayout.LayoutParams layoutParams13 = (ConstraintLayout.LayoutParams) this.f4269.f15133.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams13).leftMargin = i2;
        this.f4269.f15133.setLayoutParams(layoutParams13);
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) this.f4269.f15170.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams14).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams14).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams14).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        this.f4269.f15170.setLayoutParams(layoutParams14);
        this.f4269.f15170.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams15 = (ConstraintLayout.LayoutParams) this.f4269.f15171.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams15).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams15).width = ((ViewGroup.MarginLayoutParams) layoutParams14).width;
        ((ViewGroup.MarginLayoutParams) layoutParams15).height = ((ViewGroup.MarginLayoutParams) layoutParams14).height;
        this.f4269.f15171.setLayoutParams(layoutParams15);
        this.f4269.f15171.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) this.f4269.f15135.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams16).topMargin = iM14478;
        this.f4269.f15135.setLayoutParams(layoutParams16);
        this.f4269.f15134.getPaint().measureText("WWWW");
        ConstraintLayout.LayoutParams layoutParams17 = (ConstraintLayout.LayoutParams) this.f4269.f15134.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams17).topMargin = iM14377;
        this.f4269.f15134.setLayoutParams(layoutParams17);
        this.f4269.f15134.m2562(0, this.f4279);
        this.f4269.f15134.setContentTextColor(-1);
        this.f4269.f15176.setTypeface(FilmApp.m404());
        this.f4269.f15176.setTextSize(0, C4792.m14375().m14397());
        this.f4269.f15176.setText(R.string.BUTTON_RESET);
        ConstraintLayout.LayoutParams layoutParams18 = (ConstraintLayout.LayoutParams) this.f4269.f15151.getLayoutParams();
        TextPaint paint = this.f4269.f15176.getPaint();
        int iM14476 = C4792.m14375().m14476(23);
        int iM144762 = C4792.m14375().m14476(26);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = (int) (fontMetrics.descent - fontMetrics.ascent);
        float f2 = iM144762 * 2;
        ((ViewGroup.MarginLayoutParams) layoutParams18).width = (int) (paint.measureText(getContext().getString(R.string.BUTTON_RESET).toUpperCase()) + f2);
        int i3 = (int) (f + (iM14476 * 2));
        ((ViewGroup.MarginLayoutParams) layoutParams18).height = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams18).leftMargin = iM144782;
        this.f4269.f15151.setLayoutParams(layoutParams18);
        ConstraintLayout.LayoutParams layoutParams19 = (ConstraintLayout.LayoutParams) this.f4269.f15168.getLayoutParams();
        int iM143772 = C4792.m14375().m14377() * 2;
        ((ViewGroup.MarginLayoutParams) layoutParams19).height = ((ViewGroup.MarginLayoutParams) layoutParams18).height + iM143772;
        ((ViewGroup.MarginLayoutParams) layoutParams19).width = ((ViewGroup.MarginLayoutParams) layoutParams18).width + iM143772;
        this.f4269.f15168.setLayoutParams(layoutParams19);
        ConstraintLayout.LayoutParams layoutParams20 = (ConstraintLayout.LayoutParams) this.f4269.f15157.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams20).leftMargin = (int) (this.f4270 / 2.0f);
        this.f4269.f15157.setLayoutParams(layoutParams20);
        ConstraintLayout.LayoutParams layoutParams21 = (ConstraintLayout.LayoutParams) this.f4269.f15155.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams21).topMargin = iM14377;
        this.f4269.f15155.setLayoutParams(layoutParams21);
        m4302(this.f4269.f15155, this.f4279, R.string.MONITOR_SETTINGS_VALUE_JOB_DIRECTOR);
        ConstraintLayout.LayoutParams layoutParams22 = (ConstraintLayout.LayoutParams) this.f4269.f15153.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams22).leftMargin = iM144782;
        this.f4269.f15153.setLayoutParams(layoutParams22);
        m4302(this.f4269.f15153, this.f4279, R.string.MONITOR_SETTINGS_VALUE_JOB_DP);
        ConstraintLayout.LayoutParams layoutParams23 = (ConstraintLayout.LayoutParams) this.f4269.f15154.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams23).leftMargin = iM144782;
        this.f4269.f15154.setLayoutParams(layoutParams23);
        m4302(this.f4269.f15154, this.f4279, R.string.MONITOR_SETTINGS_VALUE_JOB_CLIENT);
        ConstraintLayout.LayoutParams layoutParams24 = (ConstraintLayout.LayoutParams) this.f4269.f15156.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams24).leftMargin = iM144782;
        this.f4269.f15156.setLayoutParams(layoutParams24);
        m4302(this.f4269.f15156, this.f4279, R.string.MONITOR_SETTINGS_VALUE_JOB_OTHERS);
        ConstraintLayout.LayoutParams layoutParams25 = (ConstraintLayout.LayoutParams) this.f4269.f15143.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams25).leftMargin = C4792.m14375().m14479(1140.0f, fM14471);
        this.f4269.f15143.setLayoutParams(layoutParams25);
        ConstraintLayout.LayoutParams layoutParams26 = (ConstraintLayout.LayoutParams) this.f4269.f15161.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams26).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams25).leftMargin;
        this.f4269.f15161.setLayoutParams(layoutParams26);
        ConstraintLayout.LayoutParams layoutParams27 = (ConstraintLayout.LayoutParams) this.f4269.f15152.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams27).width = (int) (paint.measureText(getContext().getString(R.string.BUTTON_RESET).toUpperCase()) + f2);
        ((ViewGroup.MarginLayoutParams) layoutParams27).height = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams27).leftMargin = C4792.m14375().m14479(30.0f, fM14471);
        this.f4269.f15152.setLayoutParams(layoutParams27);
        this.f4269.f15177.setTypeface(FilmApp.m404());
        this.f4269.f15177.setTextSize(0, C4792.m14375().m14397());
        this.f4269.f15177.setText(R.string.BUTTON_RESET);
        ConstraintLayout.LayoutParams layoutParams28 = (ConstraintLayout.LayoutParams) this.f4269.f15150.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams28).width = (int) (paint.measureText(getContext().getString(R.string.BUTTON_EXTEND).toUpperCase()) + f2);
        ((ViewGroup.MarginLayoutParams) layoutParams28).height = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams28).leftMargin = C4792.m14375().m14479(30.0f, fM14471);
        ((ViewGroup.MarginLayoutParams) layoutParams28).topMargin = iM14377;
        this.f4269.f15150.setLayoutParams(layoutParams28);
        this.f4269.f15175.setTypeface(FilmApp.m404());
        this.f4269.f15175.setTextSize(0, C4792.m14375().m14397());
        this.f4269.f15175.setText(R.string.BUTTON_EXTEND);
        this.f4269.f15173.setBgColor(getResources().getColor(R.color.colorTransmitBlue, null));
        this.f4269.f15172.setBgColor(getResources().getColor(R.color.colorTransmitBlue, null));
        ConstraintLayout.LayoutParams layoutParams29 = (ConstraintLayout.LayoutParams) this.f4269.f15169.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams29).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams29).width = ((ViewGroup.MarginLayoutParams) layoutParams14).width;
        ((ViewGroup.MarginLayoutParams) layoutParams29).height = ((ViewGroup.MarginLayoutParams) layoutParams14).height;
        ((ViewGroup.MarginLayoutParams) layoutParams29).leftMargin = C4792.m14375().m14479(30.0f, fM14471);
        this.f4269.f15169.setLayoutParams(layoutParams29);
        this.f4269.f15169.setTextSize(C4792.m14375().m14481() * fM14471);
        this.f4269.f15144.m2562(0, this.f4279);
        this.f4269.f15144.setContentTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
        this.f4269.f15145.setContentTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
        this.f4269.f15145.m2562(0, fM14397);
        this.f4269.f15174.m2562(0, this.f4279);
        this.f4269.f15174.setContentTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
        this.f4269.f15149.setContentTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
        this.f4269.f15149.m2562(0, fM14397);
        this.f4269.f15169.m2659(getResources().getColor(R.color.colorTransmitBlue, null));
        this.f4269.f15148.setDrawBorder(false);
        this.f4269.f15142.setDrawBorder(false);
        this.f4269.f15160.setDrawBorder(false);
        this.f4269.f15136.setDrawBorder(false);
        this.f4269.f15158.setDrawBorder(false);
        this.f4269.f15133.setDrawBorder(false);
        this.f4269.f15145.setDrawBorder(false);
        this.f4269.f15144.setDrawBorder(false);
        this.f4269.f15164.m2571();
        this.f4269.f15166.m2571();
        this.f4269.f15163.m2571();
        this.f4269.f15167.setDrawBorder(false);
        this.f4269.f15146.m2571();
        this.f4269.f15147.m2571();
        this.f4269.f15153.m2571();
        this.f4269.f15154.m2571();
        this.f4269.f15155.m2571();
        this.f4269.f15156.m2571();
        this.f4269.f15137.m2571();
        this.f4269.f15138.m2571();
        this.f4269.f15139.m2571();
        this.f4269.f15140.m2571();
        this.f4269.f15134.setDrawBorder(false);
        m4279();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m4278() {
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock = this.f4269.f15146;
        strokeTextViewWithBottomBlock.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock2 = this.f4269.f15147;
        strokeTextViewWithBottomBlock2.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock2));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock3 = this.f4269.f15163;
        strokeTextViewWithBottomBlock3.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock3));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock4 = this.f4269.f15166;
        strokeTextViewWithBottomBlock4.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock4));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock5 = this.f4269.f15164;
        strokeTextViewWithBottomBlock5.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock5));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock6 = this.f4269.f15137;
        strokeTextViewWithBottomBlock6.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock6));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock7 = this.f4269.f15138;
        strokeTextViewWithBottomBlock7.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock7));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock8 = this.f4269.f15139;
        strokeTextViewWithBottomBlock8.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock8));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock9 = this.f4269.f15140;
        strokeTextViewWithBottomBlock9.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock9));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock10 = this.f4269.f15155;
        strokeTextViewWithBottomBlock10.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock10));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock11 = this.f4269.f15153;
        strokeTextViewWithBottomBlock11.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock11));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock12 = this.f4269.f15154;
        strokeTextViewWithBottomBlock12.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock12));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock13 = this.f4269.f15156;
        strokeTextViewWithBottomBlock13.setOnTouchListener(new ViewOnTouchListenerC1619(strokeTextViewWithBottomBlock13));
        AbstractC4403 abstractC4403 = this.f4269;
        abstractC4403.f15168.setOnTouchListener(new ViewOnTouchListenerC1617(abstractC4403.f15151));
        FrameLayout frameLayout = this.f4269.f15152;
        frameLayout.setOnTouchListener(new ViewOnTouchListenerC1617(frameLayout));
        FrameLayout frameLayout2 = this.f4269.f15150;
        frameLayout2.setOnTouchListener(new ViewOnTouchListenerC1617(frameLayout2));
        this.f4269.f15146.setOnClickListener(new ViewOnClickListenerC1604());
        this.f4269.f15147.setOnClickListener(new ViewOnClickListenerC1609());
        this.f4269.f15163.setOnClickListener(new ViewOnClickListenerC1610());
        this.f4269.f15164.setOnClickListener(new ViewOnClickListenerC1611());
        this.f4269.f15166.setOnClickListener(new ViewOnClickListenerC1612());
        this.f4269.f15137.setOnClickListener(new ViewOnClickListenerC1613());
        this.f4269.f15138.setOnClickListener(new ViewOnClickListenerC1614());
        this.f4269.f15139.setOnClickListener(new ViewOnClickListenerC1615());
        this.f4269.f15140.setOnClickListener(new ViewOnClickListenerC1592());
        this.f4269.f15155.setOnClickListener(new ViewOnClickListenerC1593());
        this.f4269.f15153.setOnClickListener(new ViewOnClickListenerC1594());
        this.f4269.f15154.setOnClickListener(new ViewOnClickListenerC1595());
        this.f4269.f15156.setOnClickListener(new ViewOnClickListenerC1596());
        this.f4269.f15168.setOnClickListener(new ViewOnClickListenerC1597());
        this.f4269.f15171.setOnCheckedChangeListener(new C1598());
        this.f4269.f15170.setOnCheckedChangeListener(new C1599());
        this.f4269.f15169.setOnCheckedChangeListener(new C1600());
        this.f4269.f15169.setOnInterceptToggle(new C1602());
        this.f4269.f15152.setOnClickListener(new ViewOnClickListenerC1606());
        this.f4269.f15150.setOnClickListener(new ViewOnClickListenerC1607());
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m4279() {
        this.f4274 = C2618.m9566("transmit_quality_type", 1);
        this.f4272 = C2618.m9566("transmit_equipment_type", 1);
        this.f4273 = C2618.m9566("transmit_monitor_job", 1);
        this.f4277 = C2618.m9565("transmit_camera_control", true);
        this.f4278 = C2618.m9565("transmit_monitor_control", true);
        ConnectionManager.getInstance().setControllable(this.f4277);
        LinkManager.getInstance().setControllable(this.f4278);
        m4287(this.f4277);
        m4295(this.f4278);
        m4292(false);
        m4294(false);
        m4296(false);
        m4289(false);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public boolean m4280() {
        return this.f4269.f15170.isChecked();
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean m4281() {
        return this.f4269.f15171.isChecked();
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final boolean m4282() {
        UserBean userBeanM5990 = e5.m5988().m5990();
        return userBeanM5990 != null && userBeanM5990.getIs_subscription_user();
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m4283(int i) {
        if (i == 1) {
            this.f4269.f15144.m2561(getResources().getString(R.string.MONITOR_STATUES_CANNOT_NO_INTERNET));
        } else {
            this.f4269.f15144.m2561(getResources().getString(R.string.MONITOR_STATUES_CAMERA_DISCONNECTED_CLOUD_UNREACHABLE));
        }
        ACHelper.getInstance().setRoomId("");
        this.f4269.f15144.setVisibility(0);
        this.f4269.f15169.setVisibility(0);
        this.f4269.f15169.setEnabled(true);
        this.f4269.f15169.setChecked(false);
        this.f4269.f15169.setEnabled(false);
        this.f4269.f15162.setVisibility(8);
        this.f4269.f15152.setVisibility(8);
        this.f4269.f15169.setAlpha(0.3f);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m4284() {
        this.f4269.f15144.m2561(getResources().getString(R.string.MONITOR_STATUES_READY));
        this.f4269.f15144.setVisibility(0);
        this.f4269.f15169.setVisibility(0);
        this.f4269.f15169.setEnabled(true);
        this.f4269.f15169.setChecked(false);
        this.f4269.f15162.setVisibility(8);
        this.f4269.f15152.setVisibility(8);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m4285(boolean z) {
        if (!z) {
            this.f4269.f15162.setVisibility(0);
            this.f4269.f15144.setVisibility(4);
        }
        if (r1.m8143(ACHelper.getInstance().getRoomId())) {
            return;
        }
        this.f4269.f15152.setVisibility(8);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m4286() {
        if (TransmitHelper.getInstance().isStartCameraTransmit()) {
            return;
        }
        int netState = PingHelper.getInstance().getNetState();
        if (netState == 0 || netState == 1) {
            m4283(1);
        } else {
            if (netState != 2) {
                return;
            }
            m4283(2);
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m4287(boolean z) {
        this.f4277 = z;
        this.f4269.f15170.setChecked(z);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m4288() {
        if (m4282()) {
            m4304(this.f4269.f15146, this.f4279, R.string.MONITOR_SETTINGS_VALUE_DEVICE_ROLE_CAMERA, R.drawable.icon_22_device_camera);
            return;
        }
        m4304(this.f4269.f15146, this.f4279, R.string.MONITOR_SETTINGS_VALUE_DEVICE_ROLE_CAMERA, R.drawable.icon_20_lock);
        this.f4272 = 2;
        m4292(true);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final void m4289(boolean z) {
        int i = z ? 100 : 0;
        int i2 = this.f4275;
        if (i2 == 1) {
            this.f4269.f15137.m2575(true, i);
            this.f4269.f15138.m2575(false, i);
            this.f4269.f15139.m2575(false, i);
            this.f4269.f15140.m2575(false, i);
        } else if (i2 == 2) {
            this.f4269.f15138.m2575(true, i);
            this.f4269.f15137.m2575(false, i);
            this.f4269.f15139.m2575(false, i);
            this.f4269.f15140.m2575(false, i);
        } else if (i2 == 3) {
            this.f4269.f15139.m2575(true, i);
            this.f4269.f15137.m2575(false, i);
            this.f4269.f15138.m2575(false, i);
            this.f4269.f15140.m2575(false, i);
        } else if (i2 == 4) {
            this.f4269.f15140.m2575(true, i);
            this.f4269.f15137.m2575(false, i);
            this.f4269.f15138.m2575(false, i);
            this.f4269.f15139.m2575(false, i);
        } else if (i2 == 6) {
            this.f4269.f15137.m2575(false, i);
            this.f4269.f15138.m2575(false, i);
            this.f4269.f15139.m2575(false, i);
            this.f4269.f15140.m2575(false, i);
        }
        TransmitHelper.getInstance().setConnectionUnitType(this.f4275);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m4290(String str) {
        if (!r1.m8143(str)) {
            m4283(0);
            return;
        }
        boolean zM9565 = C2618.m9565("cloud_camera_sp", false);
        this.f4269.f15169.setAlpha(1.0f);
        if (!zM9565) {
            m4284();
            return;
        }
        this.f4269.f15144.m2561(str);
        this.f4269.f15144.setVisibility(0);
        this.f4269.f15169.setVisibility(0);
        this.f4269.f15152.setVisibility(0);
        this.f4269.f15162.setVisibility(8);
        this.f4269.f15169.setEnabled(true);
        this.f4269.f15169.m2670(false, true);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m4291() {
        this.f4269.f15134.m2561(C2462.m9035().m9064());
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final void m4292(boolean z) {
        if (this.f4272 == 2) {
            this.f4269.f15157.setVisibility(0);
            this.f4269.f15135.setVisibility(0);
            this.f4269.f15159.setVisibility(0);
            this.f4269.f15161.setVisibility(0);
            this.f4269.f15132.setVisibility(8);
            this.f4269.f15165.setVisibility(8);
            this.f4269.f15141.setVisibility(8);
            this.f4269.f15143.setVisibility(8);
            this.f4269.f15147.m2575(true, 100);
            this.f4269.f15146.m2575(false, 100);
        } else {
            this.f4269.f15157.setVisibility(8);
            this.f4269.f15135.setVisibility(8);
            this.f4269.f15159.setVisibility(8);
            this.f4269.f15161.setVisibility(8);
            this.f4269.f15132.setVisibility(0);
            this.f4269.f15165.setVisibility(0);
            this.f4269.f15141.setVisibility(0);
            this.f4269.f15143.setVisibility(0);
            this.f4269.f15147.m2575(false, 100);
            this.f4269.f15146.m2575(true, 100);
        }
        InterfaceC1616 interfaceC1616 = this.f4280;
        if (interfaceC1616 != null) {
            interfaceC1616.mo4310();
        }
        this.f4269.f15146.postDelayed(new RunnableC1603(z), 100L);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m4293(int i) {
        this.f4272 = i;
        m4292(true);
        m4288();
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m4294(boolean z) {
        int i = this.f4273;
        if (i == 1) {
            this.f4269.f15155.m2575(true, 100);
            this.f4269.f15153.m2575(false, 100);
            this.f4269.f15154.m2575(false, 100);
            this.f4269.f15156.m2575(false, 100);
        } else if (i == 2) {
            this.f4269.f15153.m2575(true, 100);
            this.f4269.f15155.m2575(false, 100);
            this.f4269.f15154.m2575(false, 100);
            this.f4269.f15156.m2575(false, 100);
        } else if (i == 3) {
            this.f4269.f15154.m2575(true, 100);
            this.f4269.f15155.m2575(false, 100);
            this.f4269.f15153.m2575(false, 100);
            this.f4269.f15156.m2575(false, 100);
        } else if (i != 4) {
            this.f4269.f15155.m2575(true, 100);
            this.f4269.f15153.m2575(false, 100);
            this.f4269.f15154.m2575(false, 100);
            this.f4269.f15156.m2575(false, 100);
        } else {
            this.f4269.f15156.m2575(true, 100);
            this.f4269.f15155.m2575(false, 100);
            this.f4269.f15153.m2575(false, 100);
            this.f4269.f15154.m2575(false, 100);
        }
        if (z) {
            C2618.m9571("transmit_monitor_job", this.f4273);
            if (this.f4280 != null) {
                p3.m7891().m7894(this.f4273);
            }
        }
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m4295(boolean z) {
        this.f4278 = z;
        this.f4269.f15171.setChecked(z);
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final void m4296(boolean z) {
        int i = this.f4274;
        if (i == 1) {
            this.f4269.f15166.m2575(true, 100);
            this.f4269.f15163.m2575(false, 100);
            this.f4269.f15164.m2575(false, 100);
        } else if (i == 2) {
            this.f4269.f15166.m2575(false, 100);
            this.f4269.f15163.m2575(true, 100);
            this.f4269.f15164.m2575(false, 100);
        } else if (i != 3) {
            this.f4269.f15166.m2575(true, 100);
            this.f4269.f15163.m2575(false, 100);
            this.f4269.f15164.m2575(false, 100);
        } else {
            this.f4269.f15166.m2575(false, 100);
            this.f4269.f15163.m2575(false, 100);
            this.f4269.f15164.m2575(true, 100);
        }
        if (z) {
            C2618.m9571("transmit_quality_type", this.f4274);
            InterfaceC1616 interfaceC1616 = this.f4280;
            if (interfaceC1616 != null) {
                interfaceC1616.mo4307(this.f4274);
            }
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public void m4297() {
        m4289(false);
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public void m4298(boolean z) {
        float f = z ? 0.2f : 1.0f;
        boolean z2 = !z;
        this.f4269.f15148.setAlpha(f);
        this.f4269.f15146.setAlpha(f);
        this.f4269.f15146.setEnabled(z2);
        this.f4269.f15147.setAlpha(f);
        this.f4269.f15147.setEnabled(z2);
        this.f4269.f15165.setAlpha(f);
        this.f4269.f15163.setEnabled(z2);
        this.f4269.f15166.setEnabled(z2);
        this.f4269.f15164.setEnabled(z2);
        this.f4269.f15152.setAlpha(f);
        this.f4269.f15152.setEnabled(z2);
        if (this.f4272 == 1) {
            this.f4269.f15142.setAlpha(f);
            m4300(z);
        }
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public void m4299() {
        NvtInfoCallbackEntity nvtInfoCallbackEntityM7595 = n.m7588().m7595();
        if (nvtInfoCallbackEntityM7595 == null) {
            this.f4269.f15174.setContentTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
            this.f4269.f15174.m2561("N/A");
            return;
        }
        int iMax = (int) (Math.max(0L, nvtInfoCallbackEntityM7595.getBalance()) / 60);
        if (iMax < 5) {
            this.f4269.f15174.setContentTextColor(getResources().getColor(R.color.colorRed, null));
        } else {
            this.f4269.f15174.setContentTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
        }
        this.f4269.f15174.m2561(iMax + MyUTIL.white_space + getResources().getString(R.string.MONITOR_MINUTES));
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public void m4300(boolean z) {
        String selectMachine = FinderManager.getInstance().getSelectMachine();
        boolean zMachineCanUse = FinderManager.getInstance().machineCanUse("1");
        boolean zMachineCanUse2 = FinderManager.getInstance().machineCanUse("2");
        boolean zMachineCanUse3 = FinderManager.getInstance().machineCanUse(FinderManager.MACHINE_C);
        boolean zMachineCanUse4 = FinderManager.getInstance().machineCanUse(FinderManager.MACHINE_D);
        if (!z) {
            if (selectMachine.equals("1")) {
                this.f4275 = 1;
            } else if (selectMachine.equals("2")) {
                this.f4275 = 2;
            } else if (selectMachine.equals(FinderManager.MACHINE_C)) {
                this.f4275 = 3;
            } else if (selectMachine.equals(FinderManager.MACHINE_D)) {
                this.f4275 = 4;
            } else {
                this.f4275 = 6;
            }
            m4289(true);
        }
        m4305(this.f4269.f15137, !z && zMachineCanUse);
        m4305(this.f4269.f15138, !z && zMachineCanUse2);
        m4305(this.f4269.f15139, !z && zMachineCanUse3);
        m4305(this.f4269.f15140, !z && zMachineCanUse4);
        m4299();
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public void m4301() {
        m4279();
        m4291();
        m4297();
        m4288();
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public final void m4302(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, float f, int i) {
        strokeTextViewWithBottomBlock.m2576(0, f);
        strokeTextViewWithBottomBlock.setTextColor(-1);
        strokeTextViewWithBottomBlock.setText(getResources().getString(i));
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public final void m4303(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, float f, String str) {
        strokeTextViewWithBottomBlock.m2576(0, f);
        strokeTextViewWithBottomBlock.setTextColor(-1);
        strokeTextViewWithBottomBlock.setText(str);
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final void m4304(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, float f, int i, int i2) {
        strokeTextViewWithBottomBlock.m2576(0, f);
        strokeTextViewWithBottomBlock.setTextColor(-1);
        strokeTextViewWithBottomBlock.m2577(getResources().getString(i), i2);
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public final void m4305(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, boolean z) {
        strokeTextViewWithBottomBlock.setAlpha(z ? 1.0f : 0.2f);
        strokeTextViewWithBottomBlock.setEnabled(z);
    }

    public TransmitSettingPag1(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4272 = 1;
        this.f4273 = 1;
        this.f4274 = 1;
        m4276();
    }

    public TransmitSettingPag1(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4272 = 1;
        this.f4273 = 1;
        this.f4274 = 1;
        m4276();
    }
}
