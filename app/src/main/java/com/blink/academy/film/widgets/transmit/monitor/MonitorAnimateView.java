package com.blink.academy.film.widgets.transmit.monitor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.stream.ACCameraInfoBean;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.ACLinkFrameInfoBean;
import com.blink.academy.film.stream.ACUnitView;
import com.blink.academy.film.stream.ACWheelView;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.stream.LinkEntity;
import com.blink.academy.film.stream.LinkManager;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.widgets.RecordButton;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.transmit.CloudMonitorSwitchView;
import com.blink.academy.film.widgets.transmit.CloudPlayerConnectView;
import com.blink.academy.film.widgets.transmit.monitor.ExtendView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView;
import com.blink.academy.protake.R;
import defpackage.AbstractC3491;
import defpackage.AbstractC4012;
import defpackage.C2494;
import defpackage.C2579;
import defpackage.C4008;
import defpackage.C4041;
import defpackage.C4792;
import defpackage.ViewOnTouchListenerC3426;
import defpackage.e5;
import defpackage.l5;
import defpackage.p3;
import defpackage.r1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* loaded from: classes.dex */
public class MonitorAnimateView extends FrameLayout {

    /* renamed from: ʻ, reason: contains not printable characters */
    public InterfaceC1728 f4363;

    /* renamed from: ʽ, reason: contains not printable characters */
    public int f4364;

    /* renamed from: ˆ, reason: contains not printable characters */
    public final int f4365;

    /* renamed from: ˇ, reason: contains not printable characters */
    public final int f4366;

    /* renamed from: ˉ, reason: contains not printable characters */
    public WeakHandler f4367;

    /* renamed from: ˊ, reason: contains not printable characters */
    public List<C2494> f4368;

    /* renamed from: ˋ, reason: contains not printable characters */
    public List<C2494> f4369;

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3491 f4370;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4371;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4372;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f4373;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f4374;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Typeface f4375;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f4376;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f4377;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f4378;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final int f4379;

    /* renamed from: ٴ, reason: contains not printable characters */
    public final int f4380;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f4381;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f4382;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f4383;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f4384;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f4385;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f4386;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f4387;

    /* renamed from: އ, reason: contains not printable characters */
    public int f4388;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f4389;

    /* renamed from: މ, reason: contains not printable characters */
    public int f4390;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f4391;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f4392;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f4393;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f4394;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f4395;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f4396;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f4397;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f4398;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f4399;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f4400;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f4401;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f4402;

    /* renamed from: ޖ, reason: contains not printable characters */
    public float f4403;

    /* renamed from: ޗ, reason: contains not printable characters */
    public List<ACUnitView> f4404;

    /* renamed from: ޘ, reason: contains not printable characters */
    public int f4405;

    /* renamed from: ޙ, reason: contains not printable characters */
    public int f4406;

    /* renamed from: ޚ, reason: contains not printable characters */
    public int f4407;

    /* renamed from: ޛ, reason: contains not printable characters */
    public int f4408;

    /* renamed from: ޜ, reason: contains not printable characters */
    public int f4409;

    /* renamed from: ޝ, reason: contains not printable characters */
    public int f4410;

    /* renamed from: ޞ, reason: contains not printable characters */
    public int f4411;

    /* renamed from: ޟ, reason: contains not printable characters */
    public int f4412;

    /* renamed from: ޠ, reason: contains not printable characters */
    public int f4413;

    /* renamed from: ޡ, reason: contains not printable characters */
    public int f4414;

    /* renamed from: ޢ, reason: contains not printable characters */
    public int f4415;

    /* renamed from: ޣ, reason: contains not printable characters */
    public int f4416;

    /* renamed from: ޤ, reason: contains not printable characters */
    public int f4417;

    /* renamed from: ޥ, reason: contains not printable characters */
    public int f4418;

    /* renamed from: ޱ, reason: contains not printable characters */
    public int f4419;

    /* renamed from: ߾, reason: contains not printable characters */
    public int f4420;

    /* renamed from: ߿, reason: contains not printable characters */
    public int f4421;

    /* renamed from: ࠚ, reason: contains not printable characters */
    public int f4422;

    /* renamed from: ࠤ, reason: contains not printable characters */
    public boolean f4423;

    /* renamed from: ࠨ, reason: contains not printable characters */
    public boolean f4424;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public int f4425;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public int f4426;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public MonitorTextureGroupView f4427;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public MonitorTextureGroupView f4428;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public MonitorTextureGroupView f4429;

    /* renamed from: ࡥ, reason: contains not printable characters */
    public MonitorTextureGroupView f4430;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public MonitorParentView f4431;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public MonitorParentView f4432;

    /* renamed from: ࡨ, reason: contains not printable characters */
    public MonitorParentView f4433;

    /* renamed from: ࡩ, reason: contains not printable characters */
    public MonitorParentView f4434;

    /* renamed from: ࡪ, reason: contains not printable characters */
    public ConstraintLayout f4435;

    /* renamed from: ࢠ, reason: contains not printable characters */
    public ConstraintLayout f4436;

    /* renamed from: ࢡ, reason: contains not printable characters */
    public ConstraintLayout f4437;

    /* renamed from: ࢢ, reason: contains not printable characters */
    public ConstraintLayout f4438;

    /* renamed from: ࢣ, reason: contains not printable characters */
    public int f4439;

    /* renamed from: ࢤ, reason: contains not printable characters */
    public LineFeedTextView f4440;

    /* renamed from: ࢥ, reason: contains not printable characters */
    public LineFeedTextView f4441;

    /* renamed from: ࢦ, reason: contains not printable characters */
    public LineFeedTextView f4442;

    /* renamed from: ࢧ, reason: contains not printable characters */
    public LineFeedTextView f4443;

    /* renamed from: ࢨ, reason: contains not printable characters */
    public ExtendView f4444;

    /* renamed from: ࢩ, reason: contains not printable characters */
    public ExtendView f4445;

    /* renamed from: ࢪ, reason: contains not printable characters */
    public ExtendView f4446;

    /* renamed from: ࢫ, reason: contains not printable characters */
    public ExtendView f4447;

    /* renamed from: ࢬ, reason: contains not printable characters */
    public final C2494 f4448;

    /* renamed from: ࢭ, reason: contains not printable characters */
    public final C2494 f4449;

    /* renamed from: ࢮ, reason: contains not printable characters */
    public final C2494 f4450;

    /* renamed from: ࢯ, reason: contains not printable characters */
    public final C2494 f4451;

    /* renamed from: ࢰ, reason: contains not printable characters */
    public C2494 f4452;

    /* renamed from: ࢱ, reason: contains not printable characters */
    public C2494 f4453;

    /* renamed from: ࢲ, reason: contains not printable characters */
    public C2494 f4454;

    /* renamed from: ࢳ, reason: contains not printable characters */
    public List<C2494> f4455;

    /* renamed from: ࢴ, reason: contains not printable characters */
    public int f4456;

    /* renamed from: ࢶ, reason: contains not printable characters */
    public int f4457;

    /* renamed from: ࢷ, reason: contains not printable characters */
    public int f4458;

    /* renamed from: ࢸ, reason: contains not printable characters */
    public int f4459;

    /* renamed from: ࢹ, reason: contains not printable characters */
    public boolean f4460;

    /* renamed from: ࢺ, reason: contains not printable characters */
    public int f4461;

    /* renamed from: ࢻ, reason: contains not printable characters */
    public int f4462;

    /* renamed from: ࢼ, reason: contains not printable characters */
    public int f4463;

    /* renamed from: ࢽ, reason: contains not printable characters */
    public long f4464;

    /* renamed from: ࢾ, reason: contains not printable characters */
    public boolean f4465;

    /* renamed from: ࢿ, reason: contains not printable characters */
    public boolean f4466;

    /* renamed from: ࣀ, reason: contains not printable characters */
    public int f4467;

    /* renamed from: ࣁ, reason: contains not printable characters */
    public int f4468;

    /* renamed from: ࣂ, reason: contains not printable characters */
    public int f4469;

    /* renamed from: ࣃ, reason: contains not printable characters */
    public int f4470;

    /* renamed from: ࣄ, reason: contains not printable characters */
    public int f4471;

    /* renamed from: ࣅ, reason: contains not printable characters */
    public int f4472;

    /* renamed from: ࣆ, reason: contains not printable characters */
    public float f4473;

    /* renamed from: ࣇ, reason: contains not printable characters */
    public int f4474;

    /* renamed from: ॱ, reason: contains not printable characters */
    public boolean f4475;

    /* renamed from: ৼ, reason: contains not printable characters */
    public int f4476;

    /* renamed from: ૹ, reason: contains not printable characters */
    public int f4477;

    /* renamed from: ಀ, reason: contains not printable characters */
    public int f4478;

    /* renamed from: ೱ, reason: contains not printable characters */
    public int f4479;

    /* renamed from: ೲ, reason: contains not printable characters */
    public int f4480;

    /* renamed from: ഄ, reason: contains not printable characters */
    public int f4481;

    /* renamed from: ഩ, reason: contains not printable characters */
    public int f4482;

    /* renamed from: ഺ, reason: contains not printable characters */
    public int f4483;

    /* renamed from: ൎ, reason: contains not printable characters */
    public int f4484;

    /* renamed from: ൔ, reason: contains not printable characters */
    public int f4485;

    /* renamed from: ൕ, reason: contains not printable characters */
    public int f4486;

    /* renamed from: ൖ, reason: contains not printable characters */
    public float f4487;

    /* renamed from: ൟ, reason: contains not printable characters */
    public int f4488;

    /* renamed from: ຆ, reason: contains not printable characters */
    public int f4489;

    /* renamed from: ຉ, reason: contains not printable characters */
    public int f4490;

    /* renamed from: ຌ, reason: contains not printable characters */
    public int f4491;

    /* renamed from: ຎ, reason: contains not printable characters */
    public int f4492;

    /* renamed from: ຏ, reason: contains not printable characters */
    public int f4493;

    /* renamed from: ຐ, reason: contains not printable characters */
    public int f4494;

    /* renamed from: ຑ, reason: contains not printable characters */
    public int f4495;

    /* renamed from: ຒ, reason: contains not printable characters */
    public int f4496;

    /* renamed from: ຓ, reason: contains not printable characters */
    public int f4497;

    /* renamed from: ຘ, reason: contains not printable characters */
    public int f4498;

    /* renamed from: ຠ, reason: contains not printable characters */
    public int f4499;

    /* renamed from: ຨ, reason: contains not printable characters */
    public int f4500;

    /* renamed from: ຩ, reason: contains not printable characters */
    public float f4501;

    /* renamed from: ຬ, reason: contains not printable characters */
    public float f4502;

    /* renamed from: ໞ, reason: contains not printable characters */
    public float f4503;

    /* renamed from: ໟ, reason: contains not printable characters */
    public float f4504;

    /* renamed from: ྈ, reason: contains not printable characters */
    public float f4505;

    /* renamed from: ྉ, reason: contains not printable characters */
    public float f4506;

    /* renamed from: ྌ, reason: contains not printable characters */
    public float f4507;

    /* renamed from: ဢ, reason: contains not printable characters */
    public float f4508;

    /* renamed from: ဨ, reason: contains not printable characters */
    public float f4509;

    /* renamed from: ၚ, reason: contains not printable characters */
    public float f4510;

    /* renamed from: ၛ, reason: contains not printable characters */
    public float f4511;

    /* renamed from: ၜ, reason: contains not printable characters */
    public float f4512;

    /* renamed from: ၝ, reason: contains not printable characters */
    public int f4513;

    /* renamed from: ၡ, reason: contains not printable characters */
    public int f4514;

    /* renamed from: ၥ, reason: contains not printable characters */
    public int f4515;

    /* renamed from: ၦ, reason: contains not printable characters */
    public int f4516;

    /* renamed from: ၮ, reason: contains not printable characters */
    public int f4517;

    /* renamed from: ၯ, reason: contains not printable characters */
    public int f4518;

    /* renamed from: ၰ, reason: contains not printable characters */
    public int f4519;

    /* renamed from: ၵ, reason: contains not printable characters */
    public int f4520;

    /* renamed from: ၶ, reason: contains not printable characters */
    public int f4521;

    /* renamed from: ၷ, reason: contains not printable characters */
    public int f4522;

    /* renamed from: ၸ, reason: contains not printable characters */
    public int f4523;

    /* renamed from: ၹ, reason: contains not printable characters */
    public int f4524;

    /* renamed from: ၺ, reason: contains not printable characters */
    public int f4525;

    /* renamed from: ၻ, reason: contains not printable characters */
    public int f4526;

    /* renamed from: ၼ, reason: contains not printable characters */
    public int f4527;

    /* renamed from: ၽ, reason: contains not printable characters */
    public int f4528;

    /* renamed from: ၾ, reason: contains not printable characters */
    public int f4529;

    /* renamed from: ၿ, reason: contains not printable characters */
    public int f4530;

    /* renamed from: ႀ, reason: contains not printable characters */
    public int f4531;

    /* renamed from: ႁ, reason: contains not printable characters */
    public int f4532;

    /* renamed from: ႎ, reason: contains not printable characters */
    public int f4533;

    /* renamed from: Ⴧ, reason: contains not printable characters */
    public float f4534;

    /* renamed from: Ⴭ, reason: contains not printable characters */
    public Typeface f4535;

    /* renamed from: ჽ, reason: contains not printable characters */
    public int f4536;

    /* renamed from: ჾ, reason: contains not printable characters */
    public int f4537;

    /* renamed from: ჿ, reason: contains not printable characters */
    public int f4538;

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$Ϳ, reason: contains not printable characters */
    public class C1645 implements CloudPlayerConnectView.InterfaceC1583 {
        public C1645() {
        }

        @Override // com.blink.academy.film.widgets.transmit.CloudPlayerConnectView.InterfaceC1583
        /* renamed from: Ϳ */
        public void mo4229() {
            if (MonitorAnimateView.this.f4363 != null) {
                MonitorAnimateView.this.f4363.mo4550();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.CloudPlayerConnectView.InterfaceC1583
        /* renamed from: Ԩ */
        public void mo4230() throws InterruptedException, Resources.NotFoundException {
            MonitorAnimateView.this.f4370.f12205.performClick();
            FinderManager.getInstance().updateRemoteMap(FinderManager.getInstance().getMachineByLinkIndex(MonitorAnimateView.this.f4448.m9101()), "");
            if (MonitorAnimateView.this.f4425 != 3) {
                MonitorAnimateView.this.f4448.m9158(-1);
                if (-1 != MonitorAnimateView.this.f4448.m9090().getLinkIndex()) {
                    MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                    monitorAnimateView.m4469(monitorAnimateView.f4448, -1);
                    MonitorAnimateView.this.f4448.m9131().getRatioCoverView().setAlpha(0.0f);
                    MonitorAnimateView.this.f4448.m9090().getTextureView().setCanShow(false);
                }
            }
            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
            monitorAnimateView2.m4472(monitorAnimateView2.f4448);
            MonitorAnimateView.this.f4448.m9146(-2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$Ԩ, reason: contains not printable characters */
    public class C1646 implements CloudPlayerConnectView.InterfaceC1583 {
        public C1646() {
        }

        @Override // com.blink.academy.film.widgets.transmit.CloudPlayerConnectView.InterfaceC1583
        /* renamed from: Ϳ */
        public void mo4229() {
            if (MonitorAnimateView.this.f4363 != null) {
                MonitorAnimateView.this.f4363.mo4550();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.CloudPlayerConnectView.InterfaceC1583
        /* renamed from: Ԩ */
        public void mo4230() throws InterruptedException, Resources.NotFoundException {
            MonitorAnimateView.this.f4370.f12206.performClick();
            FinderManager.getInstance().updateRemoteMap(FinderManager.getInstance().getMachineByLinkIndex(MonitorAnimateView.this.f4449.m9101()), "");
            if (MonitorAnimateView.this.f4425 != 3) {
                MonitorAnimateView.this.f4449.m9158(-1);
                if (-1 != MonitorAnimateView.this.f4449.m9090().getLinkIndex()) {
                    MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                    monitorAnimateView.m4469(monitorAnimateView.f4449, -1);
                    MonitorAnimateView.this.f4449.m9131().getRatioCoverView().setAlpha(0.0f);
                    MonitorAnimateView.this.f4449.m9090().getTextureView().setCanShow(false);
                }
            }
            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
            monitorAnimateView2.m4472(monitorAnimateView2.f4449);
            MonitorAnimateView.this.f4449.m9146(-2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$Ԫ, reason: contains not printable characters */
    public class C1647 implements CloudPlayerConnectView.InterfaceC1583 {
        public C1647() {
        }

        @Override // com.blink.academy.film.widgets.transmit.CloudPlayerConnectView.InterfaceC1583
        /* renamed from: Ϳ */
        public void mo4229() {
            if (MonitorAnimateView.this.f4363 != null) {
                MonitorAnimateView.this.f4363.mo4550();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.CloudPlayerConnectView.InterfaceC1583
        /* renamed from: Ԩ */
        public void mo4230() throws InterruptedException, Resources.NotFoundException {
            MonitorAnimateView.this.f4370.f12207.performClick();
            FinderManager.getInstance().updateRemoteMap(FinderManager.getInstance().getMachineByLinkIndex(MonitorAnimateView.this.f4450.m9101()), "");
            if (MonitorAnimateView.this.f4425 != 3) {
                MonitorAnimateView.this.f4450.m9158(-1);
                if (-1 != MonitorAnimateView.this.f4450.m9090().getLinkIndex()) {
                    MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                    monitorAnimateView.m4469(monitorAnimateView.f4450, -1);
                    MonitorAnimateView.this.f4450.m9131().getRatioCoverView().setAlpha(0.0f);
                    MonitorAnimateView.this.f4450.m9090().getTextureView().setCanShow(false);
                }
            }
            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
            monitorAnimateView2.m4472(monitorAnimateView2.f4450);
            MonitorAnimateView.this.f4450.m9146(-2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$Ԭ, reason: contains not printable characters */
    public class C1648 implements CloudPlayerConnectView.InterfaceC1583 {
        public C1648() {
        }

        @Override // com.blink.academy.film.widgets.transmit.CloudPlayerConnectView.InterfaceC1583
        /* renamed from: Ϳ */
        public void mo4229() {
            if (MonitorAnimateView.this.f4363 != null) {
                MonitorAnimateView.this.f4363.mo4550();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.CloudPlayerConnectView.InterfaceC1583
        /* renamed from: Ԩ */
        public void mo4230() throws InterruptedException, Resources.NotFoundException {
            MonitorAnimateView.this.f4370.f12208.performClick();
            FinderManager.getInstance().updateRemoteMap(FinderManager.getInstance().getMachineByLinkIndex(MonitorAnimateView.this.f4451.m9101()), "");
            if (MonitorAnimateView.this.f4425 != 3) {
                MonitorAnimateView.this.f4451.m9158(-1);
                if (-1 != MonitorAnimateView.this.f4451.m9090().getLinkIndex()) {
                    MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                    monitorAnimateView.m4469(monitorAnimateView.f4451, -1);
                    MonitorAnimateView.this.f4451.m9131().getRatioCoverView().setAlpha(0.0f);
                    MonitorAnimateView.this.f4451.m9090().getTextureView().setCanShow(false);
                }
            }
            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
            monitorAnimateView2.m4472(monitorAnimateView2.f4451);
            MonitorAnimateView.this.f4451.m9146(-2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1649 implements View.OnClickListener {
        public ViewOnClickListenerC1649() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MonitorAnimateView.this.f4363 != null) {
                MonitorAnimateView.this.f4363.mo4554();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ՠ, reason: contains not printable characters */
    public class RunnableC1650 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4544;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ long[] f4545;

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ՠ$Ϳ, reason: contains not printable characters */
        public class ViewTreeObserverOnGlobalLayoutListenerC1651 implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ LineFeedTextView f4547;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ ViewTreeObserver f4548;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final /* synthetic */ long f4549;

            public ViewTreeObserverOnGlobalLayoutListenerC1651(LineFeedTextView lineFeedTextView, ViewTreeObserver viewTreeObserver, long j) {
                this.f4547 = lineFeedTextView;
                this.f4548 = viewTreeObserver;
                this.f4549 = j;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout = this.f4547.getLayout();
                if (layout != null) {
                    this.f4548.removeOnGlobalLayoutListener(this);
                    int lineStart = layout.getLineStart(0);
                    int lineEnd = layout.getLineEnd(0);
                    if (MonitorAnimateView.this.f4452.m9096().length() > 0) {
                        MonitorAnimateView.this.f4452.m9098().getPaint().measureText(MonitorAnimateView.this.f4452.m9096().substring(lineStart, lineEnd));
                        RunnableC1650 runnableC1650 = RunnableC1650.this;
                        if (!runnableC1650.f4544 || MonitorAnimateView.this.f4452.m9099() <= 1) {
                            return;
                        }
                        this.f4547.getMaxWidth();
                        RunnableC1650.this.f4545[0] = System.currentTimeMillis() - this.f4549;
                    }
                }
            }
        }

        public RunnableC1650(boolean z, long[] jArr) {
            this.f4544 = z;
            this.f4545 = jArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            MonitorAnimateView.this.f4452.m9098().setMaxWidth((int) (MonitorAnimateView.this.f4397 * MonitorAnimateView.this.f4534));
            LineFeedTextView lineFeedTextViewM9098 = MonitorAnimateView.this.f4452.m9098();
            ViewTreeObserver viewTreeObserver = lineFeedTextViewM9098.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1651(lineFeedTextViewM9098, viewTreeObserver, jCurrentTimeMillis));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ֈ, reason: contains not printable characters */
    public class C1652 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ C2494 f4551;

        public C1652(C2494 c2494) {
            this.f4551 = c2494;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) throws InterruptedException, Resources.NotFoundException {
            super.onAnimationEnd(view);
            this.f4551.m9129().setVisibility(8);
            this.f4551.m9190(0);
            this.f4551.m9187("");
            MonitorAnimateView.this.m4534(this.f4551, -1);
            MonitorAnimateView.this.m4472(this.f4551);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$֏, reason: contains not printable characters */
    public class RunnableC1653 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f4553;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f4554;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f4555;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f4556;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f4557;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final /* synthetic */ MonitorTextureGroupView f4558;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final /* synthetic */ MonitorParentView f4559;

        /* renamed from: ֏, reason: contains not printable characters */
        public final /* synthetic */ TextView f4560;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final /* synthetic */ ACUnitView f4561;

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$֏$Ϳ, reason: contains not printable characters */
        public class C1654 implements l5 {

            /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$֏$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC1655 implements Runnable {
                public RunnableC1655() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C4008.m12877(MonitorAnimateView.this.f4452.m9098(), 1.0f, 100, null);
                }
            }

            public C1654() {
            }

            @Override // defpackage.l5
            /* renamed from: Ϳ */
            public void mo1305() {
                if (RunnableC1653.this.f4561.getTextureView().getTexId() != -1) {
                    RunnableC1653.this.f4561.getTextureView().setSkipOverrideRender(true);
                }
                if (!MonitorAnimateView.this.f4452.m9139()) {
                    C4008.m12877(MonitorAnimateView.this.f4370.f12188, 1.0f, 0, null);
                }
                MonitorAnimateView.this.f4465 = false;
                MonitorAnimateView.this.f4452.m9098().post(new RunnableC1655());
            }

            @Override // defpackage.l5
            /* renamed from: Ԩ */
            public void mo1306() {
                if (RunnableC1653.this.f4561.getTextureView().getTexId() != -1) {
                    RunnableC1653.this.f4561.getTextureView().setSkipOverrideRender(false);
                }
            }

            @Override // defpackage.l5
            /* renamed from: ԩ */
            public void mo1307(float f) {
                RunnableC1653 runnableC1653 = RunnableC1653.this;
                float f2 = runnableC1653.f4554;
                int i = MonitorAnimateView.this.f4397;
                RunnableC1653 runnableC16532 = RunnableC1653.this;
                int i2 = (int) (f2 + ((i - runnableC16532.f4554) * f));
                float f3 = runnableC16532.f4555;
                int i3 = MonitorAnimateView.this.f4398;
                RunnableC1653 runnableC16533 = RunnableC1653.this;
                int i4 = (int) (f3 + ((i3 - runnableC16533.f4555) * f));
                float f4 = runnableC16533.f4556;
                int i5 = MonitorAnimateView.this.f4406;
                RunnableC1653 runnableC16534 = RunnableC1653.this;
                int i6 = (int) (f4 + ((i5 - runnableC16534.f4556) * f));
                float f5 = runnableC16534.f4557;
                int i7 = MonitorAnimateView.this.f4407;
                RunnableC1653 runnableC16535 = RunnableC1653.this;
                int i8 = (int) (f5 + ((i7 - runnableC16535.f4557) * f));
                MonitorAnimateView.this.m4465(runnableC16535.f4558, i2, i4, i6, i8);
                RunnableC1653 runnableC16536 = RunnableC1653.this;
                MonitorAnimateView.this.m4464(runnableC16536.f4559, i2, i4, i6, i8);
                RunnableC1653 runnableC16537 = RunnableC1653.this;
                float f6 = runnableC16537.f4556;
                int i9 = MonitorAnimateView.this.f4406;
                RunnableC1653 runnableC16538 = RunnableC1653.this;
                MonitorAnimateView.this.m4463(runnableC16538.f4560, i2, i4, (int) (f6 + ((i9 - runnableC16538.f4556) * f)), i8);
            }
        }

        public RunnableC1653(int i, int i2, int i3, int i4, int i5, MonitorTextureGroupView monitorTextureGroupView, MonitorParentView monitorParentView, TextView textView, ACUnitView aCUnitView) {
            this.f4553 = i;
            this.f4554 = i2;
            this.f4555 = i3;
            this.f4556 = i4;
            this.f4557 = i5;
            this.f4558 = monitorTextureGroupView;
            this.f4559 = monitorParentView;
            this.f4560 = textView;
            this.f4561 = aCUnitView;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4008.m12880(0.0f, 1.0f, this.f4553, new C1654());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ׯ, reason: contains not printable characters */
    public class RunnableC1656 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ TextView f4565;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ TextView f4566;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4567;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ long[] f4568;

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ׯ$Ϳ, reason: contains not printable characters */
        public class ViewTreeObserverOnGlobalLayoutListenerC1657 implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ ViewTreeObserver f4570;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ long f4571;

            /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ׯ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC1658 implements Runnable {

                /* renamed from: ԫ, reason: contains not printable characters */
                public final /* synthetic */ float f4573;

                public RunnableC1658(float f) {
                    this.f4573 = f;
                }

                @Override // java.lang.Runnable
                public void run() {
                    MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                    int iMax = (int) Math.max(Math.ceil(monitorAnimateView.m4478(monitorAnimateView.f4453) / (MonitorAnimateView.this.f4381 * MonitorAnimateView.this.f4534)), 1.0d);
                    float f = this.f4573;
                    if (iMax <= 1) {
                        f = 0.0f;
                    }
                    RunnableC1656 runnableC1656 = RunnableC1656.this;
                    MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                    monitorAnimateView2.m4463(runnableC1656.f4565, monitorAnimateView2.f4381, MonitorAnimateView.this.f4382, (int) (MonitorAnimateView.this.f4409 + f), MonitorAnimateView.this.f4408);
                    RunnableC1656 runnableC16562 = RunnableC1656.this;
                    MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                    monitorAnimateView3.m4463(runnableC16562.f4566, monitorAnimateView3.f4381, MonitorAnimateView.this.f4382, (int) (MonitorAnimateView.this.f4410 + f), MonitorAnimateView.this.f4408);
                }
            }

            public ViewTreeObserverOnGlobalLayoutListenerC1657(ViewTreeObserver viewTreeObserver, long j) {
                this.f4570 = viewTreeObserver;
                this.f4571 = j;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout = RunnableC1656.this.f4565.getLayout();
                if (layout != null) {
                    this.f4570.removeOnGlobalLayoutListener(this);
                    int lineStart = layout.getLineStart(0);
                    int lineEnd = layout.getLineEnd(0);
                    if (MonitorAnimateView.this.f4453.m9096().length() <= 0) {
                        MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                        monitorAnimateView.m4543(monitorAnimateView.f4453, MonitorAnimateView.this.f4454, 0.0f, 0);
                        return;
                    }
                    float maxWidth = (RunnableC1656.this.f4565.getMaxWidth() - RunnableC1656.this.f4565.getPaint().measureText(MonitorAnimateView.this.f4453.m9096().substring(lineStart, lineEnd))) / 2.0f;
                    RunnableC1656 runnableC1656 = RunnableC1656.this;
                    if (runnableC1656.f4567) {
                        MonitorAnimateView.this.postDelayed(new RunnableC1658(maxWidth), 300L);
                        return;
                    }
                    MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                    int iMax = (int) Math.max(Math.ceil(monitorAnimateView2.m4478(monitorAnimateView2.f4453) / (MonitorAnimateView.this.f4381 * MonitorAnimateView.this.f4534)), 1.0d);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    RunnableC1656 runnableC16562 = RunnableC1656.this;
                    runnableC16562.f4568[0] = jCurrentTimeMillis - this.f4571;
                    if (iMax > 1) {
                        MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                        monitorAnimateView3.m4543(monitorAnimateView3.f4453, MonitorAnimateView.this.f4454, maxWidth, (int) RunnableC1656.this.f4568[0]);
                    } else {
                        MonitorAnimateView monitorAnimateView4 = MonitorAnimateView.this;
                        monitorAnimateView4.m4543(monitorAnimateView4.f4453, MonitorAnimateView.this.f4454, 0.0f, (int) RunnableC1656.this.f4568[0]);
                    }
                }
            }
        }

        public RunnableC1656(TextView textView, TextView textView2, boolean z, long[] jArr) {
            this.f4565 = textView;
            this.f4566 = textView2;
            this.f4567 = z;
            this.f4568 = jArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f4565.setMaxWidth((int) (MonitorAnimateView.this.f4381 * MonitorAnimateView.this.f4534));
            this.f4566.setMaxWidth((int) (MonitorAnimateView.this.f4381 * MonitorAnimateView.this.f4534));
            ViewTreeObserver viewTreeObserver = this.f4565.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1657(viewTreeObserver, jCurrentTimeMillis));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ؠ, reason: contains not printable characters */
    public class C1659 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ C2494 f4575;

        public C1659(C2494 c2494) {
            this.f4575 = c2494;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) throws InterruptedException, Resources.NotFoundException {
            super.onAnimationEnd(view);
            this.f4575.m9129().setVisibility(8);
            this.f4575.m9190(0);
            this.f4575.m9187("");
            MonitorAnimateView.this.m4534(this.f4575, -1);
            MonitorAnimateView.this.m4472(this.f4575);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ހ, reason: contains not printable characters */
    public class C1660 implements ExtendView.InterfaceC1642 {
        public C1660() {
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.ExtendView.InterfaceC1642
        /* renamed from: Ϳ */
        public void mo4393() {
            if (MonitorAnimateView.this.f4363 != null) {
                MonitorAnimateView.this.f4363.mo4550();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ށ, reason: contains not printable characters */
    public class C1661 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f4578;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ int f4579;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ int f4580;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f4581;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ MonitorTextureGroupView f4582;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ MonitorParentView f4583;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ float f4584;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ TextView f4585;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f4586;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final /* synthetic */ int f4587;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final /* synthetic */ int f4588;

        /* renamed from: ֏, reason: contains not printable characters */
        public final /* synthetic */ int f4589;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final /* synthetic */ MonitorTextureGroupView f4590;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final /* synthetic */ MonitorParentView f4591;

        /* renamed from: ހ, reason: contains not printable characters */
        public final /* synthetic */ TextView f4592;

        /* renamed from: ށ, reason: contains not printable characters */
        public final /* synthetic */ ACUnitView f4593;

        /* renamed from: ނ, reason: contains not printable characters */
        public final /* synthetic */ ACUnitView f4594;

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ށ$Ϳ, reason: contains not printable characters */
        public class RunnableC1662 implements Runnable {
            public RunnableC1662() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C4008.m12877(MonitorAnimateView.this.f4453.m9098(), 1.0f, 100, null);
                C4008.m12877(MonitorAnimateView.this.f4454.m9098(), 1.0f, 100, null);
            }
        }

        public C1661(int i, int i2, int i3, int i4, MonitorTextureGroupView monitorTextureGroupView, MonitorParentView monitorParentView, float f, TextView textView, int i5, int i6, int i7, int i8, MonitorTextureGroupView monitorTextureGroupView2, MonitorParentView monitorParentView2, TextView textView2, ACUnitView aCUnitView, ACUnitView aCUnitView2) {
            this.f4578 = i;
            this.f4579 = i2;
            this.f4580 = i3;
            this.f4581 = i4;
            this.f4582 = monitorTextureGroupView;
            this.f4583 = monitorParentView;
            this.f4584 = f;
            this.f4585 = textView;
            this.f4586 = i5;
            this.f4587 = i6;
            this.f4588 = i7;
            this.f4589 = i8;
            this.f4590 = monitorTextureGroupView2;
            this.f4591 = monitorParentView2;
            this.f4592 = textView2;
            this.f4593 = aCUnitView;
            this.f4594 = aCUnitView2;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
            if (this.f4593.getTextureView().getTexId() != -1) {
                this.f4593.getTextureView().setSkipOverrideRender(true);
            }
            if (this.f4594.getTextureView().getTexId() != -1) {
                this.f4594.getTextureView().setSkipOverrideRender(true);
            }
            MonitorAnimateView.this.f4465 = false;
            MonitorAnimateView.this.f4453.m9098().post(new RunnableC1662());
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
            if (this.f4593.getTextureView().getTexId() != -1) {
                this.f4593.getTextureView().setSkipOverrideRender(false);
            }
            if (this.f4594.getTextureView().getTexId() != -1) {
                this.f4594.getTextureView().setSkipOverrideRender(false);
            }
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            int i = (int) (this.f4578 + ((MonitorAnimateView.this.f4381 - this.f4578) * f));
            int i2 = (int) (this.f4579 + ((MonitorAnimateView.this.f4382 - this.f4579) * f));
            int i3 = (int) (this.f4580 + ((MonitorAnimateView.this.f4409 - this.f4580) * f) + 0.5f);
            int i4 = (int) (this.f4581 + ((MonitorAnimateView.this.f4408 - this.f4581) * f) + 0.5f);
            MonitorAnimateView.this.m4465(this.f4582, i, i2, i3, i4);
            MonitorAnimateView.this.m4464(this.f4583, i, i2, i3, i4);
            MonitorAnimateView.this.m4463(this.f4585, i, i2, (int) (this.f4580 + (((MonitorAnimateView.this.f4409 - this.f4580) + this.f4584) * f) + 0.5f), i4);
            int i5 = (int) (this.f4586 + ((MonitorAnimateView.this.f4381 - this.f4586) * f));
            int i6 = (int) (this.f4587 + ((MonitorAnimateView.this.f4382 - this.f4587) * f));
            int i7 = (int) (this.f4588 + ((MonitorAnimateView.this.f4410 - this.f4588) * f) + 0.5f);
            int i8 = (int) (this.f4589 + ((MonitorAnimateView.this.f4408 - this.f4589) * f) + 0.5f);
            MonitorAnimateView.this.m4465(this.f4590, i5, i6, i7, i8);
            MonitorAnimateView.this.m4464(this.f4591, i5, i6, i7, i8);
            MonitorAnimateView.this.m4463(this.f4592, i5, i6, (int) (this.f4588 + (((MonitorAnimateView.this.f4410 - this.f4588) + this.f4584) * f) + 0.5f), i8);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ނ, reason: contains not printable characters */
    public class RunnableC1663 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2494 f4597;

        public RunnableC1663(C2494 c2494) {
            this.f4597 = c2494;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4597.m9098().setMaxWidth((int) (MonitorAnimateView.this.f4384 * MonitorAnimateView.this.f4534));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ރ, reason: contains not printable characters */
    public class RunnableC1664 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2494 f4599;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ long[] f4600;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4601;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ C2494 f4602;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ C2494 f4603;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final /* synthetic */ C2494 f4604;

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ރ$Ϳ, reason: contains not printable characters */
        public class ViewTreeObserverOnGlobalLayoutListenerC1665 implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ ViewTreeObserver f4606;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ long f4607;

            /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ރ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC1666 implements Runnable {

                /* renamed from: ԫ, reason: contains not printable characters */
                public final /* synthetic */ float f4609;

                public RunnableC1666(float f) {
                    this.f4609 = f;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RunnableC1664 runnableC1664 = RunnableC1664.this;
                    int iMax = (int) Math.max(Math.ceil(MonitorAnimateView.this.m4478(runnableC1664.f4599) / (MonitorAnimateView.this.f4384 * MonitorAnimateView.this.f4534)), 1.0d);
                    float f = this.f4609;
                    if (iMax <= 1) {
                        f = 0.0f;
                    }
                    MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                    monitorAnimateView.m4463(monitorAnimateView.f4440, MonitorAnimateView.this.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4457 + f), MonitorAnimateView.this.f4456);
                    MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                    monitorAnimateView2.m4463(monitorAnimateView2.f4441, MonitorAnimateView.this.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4459 + f), MonitorAnimateView.this.f4456);
                    MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                    monitorAnimateView3.m4463(monitorAnimateView3.f4442, MonitorAnimateView.this.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4457 + f), MonitorAnimateView.this.f4458);
                    MonitorAnimateView monitorAnimateView4 = MonitorAnimateView.this;
                    monitorAnimateView4.m4463(monitorAnimateView4.f4443, MonitorAnimateView.this.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4459 + f), MonitorAnimateView.this.f4458);
                }
            }

            public ViewTreeObserverOnGlobalLayoutListenerC1665(ViewTreeObserver viewTreeObserver, long j) {
                this.f4606 = viewTreeObserver;
                this.f4607 = j;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RunnableC1664 runnableC1664 = RunnableC1664.this;
                int iMax = (int) Math.max(Math.ceil(MonitorAnimateView.this.m4478(runnableC1664.f4599) / (MonitorAnimateView.this.f4384 * MonitorAnimateView.this.f4534)), 1.0d);
                Layout layout = MonitorAnimateView.this.f4440.getLayout();
                if (layout != null) {
                    this.f4606.removeOnGlobalLayoutListener(this);
                    int lineStart = layout.getLineStart(0);
                    int lineEnd = layout.getLineEnd(0);
                    if (MonitorAnimateView.this.f4440.getText().length() <= 0) {
                        RunnableC1664 runnableC16642 = RunnableC1664.this;
                        MonitorAnimateView.this.m4544(runnableC16642.f4599, runnableC16642.f4602, runnableC16642.f4603, runnableC16642.f4604, 0.0f, 0);
                        return;
                    }
                    float fMeasureText = MonitorAnimateView.this.f4440.getPaint().measureText(MonitorAnimateView.this.f4440.getText().toString().substring(lineStart, lineEnd));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    RunnableC1664.this.f4600[0] = jCurrentTimeMillis - this.f4607;
                    float maxWidth = (MonitorAnimateView.this.f4440.getMaxWidth() - fMeasureText) / 2.0f;
                    if (maxWidth != MonitorAnimateView.this.f4440.getTranslationX()) {
                        RunnableC1664 runnableC16643 = RunnableC1664.this;
                        if (runnableC16643.f4601) {
                            MonitorAnimateView.this.postDelayed(new RunnableC1666(maxWidth), 300L);
                        } else if (iMax <= 1) {
                            MonitorAnimateView.this.m4544(runnableC16643.f4599, runnableC16643.f4602, runnableC16643.f4603, runnableC16643.f4604, 0.0f, (int) runnableC16643.f4600[0]);
                        } else {
                            MonitorAnimateView.this.m4544(runnableC16643.f4599, runnableC16643.f4602, runnableC16643.f4603, runnableC16643.f4604, maxWidth, (int) runnableC16643.f4600[0]);
                        }
                    }
                }
            }
        }

        public RunnableC1664(C2494 c2494, long[] jArr, boolean z, C2494 c24942, C2494 c24943, C2494 c24944) {
            this.f4599 = c2494;
            this.f4600 = jArr;
            this.f4601 = z;
            this.f4602 = c24942;
            this.f4603 = c24943;
            this.f4604 = c24944;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ViewTreeObserver viewTreeObserver = MonitorAnimateView.this.f4440.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1665(viewTreeObserver, jCurrentTimeMillis));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ބ, reason: contains not printable characters */
    public class C1667 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f4611;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ int f4612;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ int f4613;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f4614;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f4615;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f4616;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f4617;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f4618;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f4619;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final /* synthetic */ int f4620;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final /* synthetic */ int f4621;

        /* renamed from: ֏, reason: contains not printable characters */
        public final /* synthetic */ int f4622;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final /* synthetic */ int f4623;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final /* synthetic */ int f4624;

        /* renamed from: ހ, reason: contains not printable characters */
        public final /* synthetic */ int f4625;

        /* renamed from: ށ, reason: contains not printable characters */
        public final /* synthetic */ int f4626;

        /* renamed from: ނ, reason: contains not printable characters */
        public final /* synthetic */ MonitorTextureGroupView f4627;

        /* renamed from: ރ, reason: contains not printable characters */
        public final /* synthetic */ MonitorTextureGroupView f4628;

        /* renamed from: ބ, reason: contains not printable characters */
        public final /* synthetic */ MonitorTextureGroupView f4629;

        /* renamed from: ޅ, reason: contains not printable characters */
        public final /* synthetic */ MonitorTextureGroupView f4630;

        /* renamed from: ކ, reason: contains not printable characters */
        public final /* synthetic */ MonitorParentView f4631;

        /* renamed from: އ, reason: contains not printable characters */
        public final /* synthetic */ MonitorParentView f4632;

        /* renamed from: ވ, reason: contains not printable characters */
        public final /* synthetic */ MonitorParentView f4633;

        /* renamed from: މ, reason: contains not printable characters */
        public final /* synthetic */ MonitorParentView f4634;

        /* renamed from: ފ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4635;

        /* renamed from: ދ, reason: contains not printable characters */
        public final /* synthetic */ float f4636;

        /* renamed from: ތ, reason: contains not printable characters */
        public final /* synthetic */ TextView f4637;

        /* renamed from: ލ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4638;

        /* renamed from: ގ, reason: contains not printable characters */
        public final /* synthetic */ TextView f4639;

        /* renamed from: ޏ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4640;

        /* renamed from: ސ, reason: contains not printable characters */
        public final /* synthetic */ TextView f4641;

        /* renamed from: ޑ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4642;

        /* renamed from: ޒ, reason: contains not printable characters */
        public final /* synthetic */ TextView f4643;

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ބ$Ϳ, reason: contains not printable characters */
        public class RunnableC1668 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ C2494 f4645;

            public RunnableC1668(C2494 c2494) {
                this.f4645 = c2494;
            }

            @Override // java.lang.Runnable
            public void run() {
                C4008.m12877(this.f4645.m9098(), 1.0f, 100, null);
            }
        }

        public C1667(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, MonitorTextureGroupView monitorTextureGroupView, MonitorTextureGroupView monitorTextureGroupView2, MonitorTextureGroupView monitorTextureGroupView3, MonitorTextureGroupView monitorTextureGroupView4, MonitorParentView monitorParentView, MonitorParentView monitorParentView2, MonitorParentView monitorParentView3, MonitorParentView monitorParentView4, boolean z, float f, TextView textView, boolean z2, TextView textView2, boolean z3, TextView textView3, boolean z4, TextView textView4) {
            this.f4611 = i;
            this.f4612 = i2;
            this.f4613 = i3;
            this.f4614 = i4;
            this.f4615 = i5;
            this.f4616 = i6;
            this.f4617 = i7;
            this.f4618 = i8;
            this.f4619 = i9;
            this.f4620 = i10;
            this.f4621 = i11;
            this.f4622 = i12;
            this.f4623 = i13;
            this.f4624 = i14;
            this.f4625 = i15;
            this.f4626 = i16;
            this.f4627 = monitorTextureGroupView;
            this.f4628 = monitorTextureGroupView2;
            this.f4629 = monitorTextureGroupView3;
            this.f4630 = monitorTextureGroupView4;
            this.f4631 = monitorParentView;
            this.f4632 = monitorParentView2;
            this.f4633 = monitorParentView3;
            this.f4634 = monitorParentView4;
            this.f4635 = z;
            this.f4636 = f;
            this.f4637 = textView;
            this.f4638 = z2;
            this.f4639 = textView2;
            this.f4640 = z3;
            this.f4641 = textView3;
            this.f4642 = z4;
            this.f4643 = textView4;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
            for (int i = 0; i < MonitorAnimateView.this.f4455.size(); i++) {
                C2494 c2494 = MonitorAnimateView.this.f4455.get(i);
                c2494.m9090().getTextureView().setSkipOverrideRender(true);
                c2494.m9098().post(new RunnableC1668(c2494));
            }
            MonitorAnimateView.this.f4465 = false;
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
            for (int i = 0; i < MonitorAnimateView.this.f4455.size(); i++) {
                MonitorAnimateView.this.f4455.get(i).m9090().getTextureView().setSkipOverrideRender(false);
            }
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            int i = (int) (this.f4611 + ((MonitorAnimateView.this.f4384 - this.f4611) * f));
            int i2 = (int) (this.f4612 + ((MonitorAnimateView.this.f4383 - this.f4612) * f));
            int i3 = (int) (this.f4613 + ((MonitorAnimateView.this.f4457 - this.f4613) * f));
            int i4 = (int) (this.f4614 + ((MonitorAnimateView.this.f4456 - this.f4614) * f));
            int i5 = (int) (this.f4615 + ((MonitorAnimateView.this.f4384 - this.f4615) * f));
            int i6 = (int) (this.f4616 + ((MonitorAnimateView.this.f4383 - this.f4616) * f));
            int i7 = (int) (this.f4617 + ((MonitorAnimateView.this.f4459 - this.f4617) * f));
            int i8 = (int) (this.f4618 + ((MonitorAnimateView.this.f4456 - this.f4618) * f));
            int i9 = (int) (this.f4619 + ((MonitorAnimateView.this.f4384 - this.f4619) * f));
            int i10 = (int) (this.f4620 + ((MonitorAnimateView.this.f4383 - this.f4620) * f));
            int i11 = (int) (this.f4621 + ((MonitorAnimateView.this.f4457 - this.f4621) * f));
            int i12 = (int) (this.f4622 + ((MonitorAnimateView.this.f4458 - this.f4622) * f));
            int i13 = (int) (this.f4623 + ((MonitorAnimateView.this.f4384 - this.f4623) * f));
            int i14 = (int) (this.f4624 + ((MonitorAnimateView.this.f4383 - this.f4624) * f));
            int i15 = (int) (this.f4625 + ((MonitorAnimateView.this.f4459 - this.f4625) * f));
            int i16 = (int) (this.f4626 + ((MonitorAnimateView.this.f4458 - this.f4626) * f));
            MonitorAnimateView.this.m4465(this.f4627, i, i2, i3, i4);
            MonitorAnimateView.this.m4465(this.f4628, i5, i6, i7, i8);
            MonitorAnimateView.this.m4465(this.f4629, i9, i10, i11, i12);
            MonitorAnimateView.this.m4465(this.f4630, i13, i14, i15, i16);
            MonitorAnimateView.this.m4464(this.f4631, i, i2, i3, i4);
            MonitorAnimateView.this.m4464(this.f4632, i5, i6, i7, i8);
            MonitorAnimateView.this.m4464(this.f4633, i9, i10, i11, i12);
            MonitorAnimateView.this.m4464(this.f4634, i13, i14, i15, i16);
            if (this.f4635) {
                MonitorAnimateView.this.m4463(this.f4637, i, i2, (int) (this.f4613 + (((MonitorAnimateView.this.f4457 - this.f4613) + this.f4636) * f)), i4);
            }
            if (this.f4638) {
                MonitorAnimateView.this.m4463(this.f4639, i5, i6, (int) (this.f4617 + (((MonitorAnimateView.this.f4459 - this.f4617) + this.f4636) * f)), i8);
            }
            if (this.f4640) {
                MonitorAnimateView.this.m4463(this.f4641, i9, i10, (int) (this.f4621 + (((MonitorAnimateView.this.f4457 - this.f4621) + this.f4636) * f)), i12);
            }
            if (this.f4642) {
                MonitorAnimateView.this.m4463(this.f4643, i13, i14, (int) (this.f4625 + (((MonitorAnimateView.this.f4459 - this.f4625) + this.f4636) * f)), i16);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޅ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1669 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ LineFeedTextView f4647;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ ViewTreeObserver f4648;

        public ViewTreeObserverOnGlobalLayoutListenerC1669(LineFeedTextView lineFeedTextView, ViewTreeObserver viewTreeObserver) {
            this.f4647 = lineFeedTextView;
            this.f4648 = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f4647.getLayout();
            if (layout == null || MonitorAnimateView.this.f4465) {
                return;
            }
            this.f4648.removeOnGlobalLayoutListener(this);
            int lineStart = layout.getLineStart(0);
            int lineEnd = layout.getLineEnd(0);
            if (MonitorAnimateView.this.f4452.m9096().length() > 0) {
                float fMeasureText = MonitorAnimateView.this.f4452.m9098().getPaint().measureText(MonitorAnimateView.this.f4452.m9096().substring(lineStart, lineEnd));
                MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                if (((int) Math.max(Math.ceil(monitorAnimateView.m4478(monitorAnimateView.f4452) / (MonitorAnimateView.this.f4397 * MonitorAnimateView.this.f4534)), 1.0d)) <= 1) {
                    MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                    monitorAnimateView2.m4463(monitorAnimateView2.f4452.m9098(), MonitorAnimateView.this.f4397, MonitorAnimateView.this.f4398, MonitorAnimateView.this.f4406, MonitorAnimateView.this.f4407);
                    return;
                }
                float maxWidth = (this.f4647.getMaxWidth() - fMeasureText) / 2.0f;
                if (maxWidth != MonitorAnimateView.this.f4452.m9098().getTranslationX()) {
                    MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                    monitorAnimateView3.m4463(monitorAnimateView3.f4452.m9098(), MonitorAnimateView.this.f4397, MonitorAnimateView.this.f4398, (int) (MonitorAnimateView.this.f4406 + maxWidth), MonitorAnimateView.this.f4407);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ކ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1670 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ LineFeedTextView f4650;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ ViewTreeObserver f4651;

        public ViewTreeObserverOnGlobalLayoutListenerC1670(LineFeedTextView lineFeedTextView, ViewTreeObserver viewTreeObserver) {
            this.f4650 = lineFeedTextView;
            this.f4651 = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f4650.getLayout();
            if (layout == null || MonitorAnimateView.this.f4465) {
                return;
            }
            int lineStart = layout.getLineStart(0);
            int lineEnd = layout.getLineEnd(0);
            MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
            if (((int) Math.max(Math.ceil(monitorAnimateView.m4478(monitorAnimateView.f4453) / (MonitorAnimateView.this.f4381 * MonitorAnimateView.this.f4534)), 1.0d)) > 1) {
                float maxWidth = (this.f4650.getMaxWidth() - this.f4650.getPaint().measureText(MonitorAnimateView.this.f4453.m9096().substring(lineStart, lineEnd))) / 2.0f;
                MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                monitorAnimateView2.m4463(this.f4650, monitorAnimateView2.f4381, MonitorAnimateView.this.f4382, (int) (MonitorAnimateView.this.f4409 + maxWidth), MonitorAnimateView.this.f4408);
            } else {
                MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                monitorAnimateView3.m4463(this.f4650, monitorAnimateView3.f4381, MonitorAnimateView.this.f4382, MonitorAnimateView.this.f4409, MonitorAnimateView.this.f4408);
            }
            this.f4651.removeOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$އ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1671 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ LineFeedTextView f4653;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ ViewTreeObserver f4654;

        public ViewTreeObserverOnGlobalLayoutListenerC1671(LineFeedTextView lineFeedTextView, ViewTreeObserver viewTreeObserver) {
            this.f4653 = lineFeedTextView;
            this.f4654 = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f4653.getLayout();
            if (layout == null || MonitorAnimateView.this.f4465) {
                return;
            }
            MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
            if (((int) Math.max(Math.ceil(monitorAnimateView.m4478(monitorAnimateView.f4453) / (MonitorAnimateView.this.f4381 * MonitorAnimateView.this.f4534)), 1.0d)) > 1) {
                float maxWidth = (this.f4653.getMaxWidth() - this.f4653.getPaint().measureText(MonitorAnimateView.this.f4454.m9096().substring(layout.getLineStart(0), layout.getLineEnd(0)))) / 2.0f;
                MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                monitorAnimateView2.m4463(this.f4653, monitorAnimateView2.f4381, MonitorAnimateView.this.f4382, (int) (MonitorAnimateView.this.f4410 + maxWidth), MonitorAnimateView.this.f4408);
            } else {
                MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                monitorAnimateView3.m4463(this.f4653, monitorAnimateView3.f4381, MonitorAnimateView.this.f4382, MonitorAnimateView.this.f4410, MonitorAnimateView.this.f4408);
            }
            this.f4654.removeOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ވ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1672 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ TextView f4656;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ ViewTreeObserver f4657;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2494 f4658;

        public ViewTreeObserverOnGlobalLayoutListenerC1672(TextView textView, ViewTreeObserver viewTreeObserver, C2494 c2494) {
            this.f4656 = textView;
            this.f4657 = viewTreeObserver;
            this.f4658 = c2494;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f4656.getLayout();
            if (layout != null) {
                this.f4657.removeOnGlobalLayoutListener(this);
                if (MonitorAnimateView.this.f4465) {
                    return;
                }
                int lineStart = layout.getLineStart(0);
                int lineEnd = layout.getLineEnd(0);
                if (this.f4658.m9096().length() > 0) {
                    float fMeasureText = this.f4656.getPaint().measureText(this.f4658.m9096().substring(lineStart, lineEnd));
                    int iMax = (int) Math.max(Math.ceil(MonitorAnimateView.this.m4478(this.f4658) / (MonitorAnimateView.this.f4384 * MonitorAnimateView.this.f4534)), 1.0d);
                    float maxWidth = (this.f4656.getMaxWidth() - fMeasureText) / 2.0f;
                    if (maxWidth != this.f4656.getTranslationX()) {
                        int iM9101 = this.f4658.m9101();
                        if (iM9101 == 0) {
                            if (iMax <= 1) {
                                MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                                monitorAnimateView.m4463(this.f4656, monitorAnimateView.f4384, MonitorAnimateView.this.f4383, MonitorAnimateView.this.f4457, MonitorAnimateView.this.f4456);
                                return;
                            } else {
                                MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                                monitorAnimateView2.m4463(this.f4656, monitorAnimateView2.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4457 + maxWidth), MonitorAnimateView.this.f4456);
                                return;
                            }
                        }
                        if (iM9101 == 1) {
                            if (iMax <= 1) {
                                MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                                monitorAnimateView3.m4463(this.f4656, monitorAnimateView3.f4384, MonitorAnimateView.this.f4383, MonitorAnimateView.this.f4459, MonitorAnimateView.this.f4456);
                                return;
                            } else {
                                MonitorAnimateView monitorAnimateView4 = MonitorAnimateView.this;
                                monitorAnimateView4.m4463(this.f4656, monitorAnimateView4.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4459 + maxWidth), MonitorAnimateView.this.f4456);
                                return;
                            }
                        }
                        if (iM9101 == 2) {
                            if (iMax <= 1) {
                                MonitorAnimateView monitorAnimateView5 = MonitorAnimateView.this;
                                monitorAnimateView5.m4463(this.f4656, monitorAnimateView5.f4384, MonitorAnimateView.this.f4383, MonitorAnimateView.this.f4457, MonitorAnimateView.this.f4458);
                                return;
                            } else {
                                MonitorAnimateView monitorAnimateView6 = MonitorAnimateView.this;
                                monitorAnimateView6.m4463(this.f4656, monitorAnimateView6.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4457 + maxWidth), MonitorAnimateView.this.f4458);
                                return;
                            }
                        }
                        if (iMax <= 1) {
                            MonitorAnimateView monitorAnimateView7 = MonitorAnimateView.this;
                            monitorAnimateView7.m4463(this.f4656, monitorAnimateView7.f4384, MonitorAnimateView.this.f4383, MonitorAnimateView.this.f4459, MonitorAnimateView.this.f4458);
                        } else {
                            MonitorAnimateView monitorAnimateView8 = MonitorAnimateView.this;
                            monitorAnimateView8.m4463(this.f4656, monitorAnimateView8.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4459 + maxWidth), MonitorAnimateView.this.f4458);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$މ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1673 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ LineFeedTextView f4660;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ ViewTreeObserver f4661;

        public ViewTreeObserverOnGlobalLayoutListenerC1673(LineFeedTextView lineFeedTextView, ViewTreeObserver viewTreeObserver) {
            this.f4660 = lineFeedTextView;
            this.f4661 = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f4660.getLayout();
            if (layout != null) {
                this.f4661.removeOnGlobalLayoutListener(this);
                int lineStart = layout.getLineStart(0);
                int lineEnd = layout.getLineEnd(0);
                if (MonitorAnimateView.this.f4452.m9096().length() > 0) {
                    String strSubstring = MonitorAnimateView.this.f4452.m9096().substring(lineStart, lineEnd);
                    TextPaint paint = MonitorAnimateView.this.f4452.m9098().getPaint();
                    if (paint.measureText(MonitorAnimateView.this.f4452.m9096()) > MonitorAnimateView.this.f4397 * MonitorAnimateView.this.f4534) {
                        float maxWidth = (this.f4660.getMaxWidth() - paint.measureText(strSubstring)) / 2.0f;
                        if (maxWidth != MonitorAnimateView.this.f4452.m9098().getTranslationX()) {
                            MonitorAnimateView.this.f4452.m9098().setTranslationX(maxWidth);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ފ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1674 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ LineFeedTextView f4663;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ ViewTreeObserver f4664;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ LineFeedTextView f4665;

        public ViewTreeObserverOnGlobalLayoutListenerC1674(LineFeedTextView lineFeedTextView, ViewTreeObserver viewTreeObserver, LineFeedTextView lineFeedTextView2) {
            this.f4663 = lineFeedTextView;
            this.f4664 = viewTreeObserver;
            this.f4665 = lineFeedTextView2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f4663.getLayout();
            if (layout != null) {
                this.f4664.removeOnGlobalLayoutListener(this);
                String strSubstring = MonitorAnimateView.this.f4453.m9096().substring(layout.getLineStart(0), layout.getLineEnd(0));
                TextPaint paint = this.f4663.getPaint();
                float fMeasureText = paint.measureText(strSubstring);
                if (paint.measureText(MonitorAnimateView.this.f4453.m9096()) > MonitorAnimateView.this.f4381 * MonitorAnimateView.this.f4534) {
                    float maxWidth = (this.f4663.getMaxWidth() - fMeasureText) / 2.0f;
                    MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                    monitorAnimateView.m4463(this.f4663, monitorAnimateView.f4381, MonitorAnimateView.this.f4382, (int) (MonitorAnimateView.this.f4409 + maxWidth), MonitorAnimateView.this.f4408);
                    MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                    monitorAnimateView2.m4463(this.f4665, monitorAnimateView2.f4381, MonitorAnimateView.this.f4382, (int) (MonitorAnimateView.this.f4410 + maxWidth), MonitorAnimateView.this.f4408);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ދ, reason: contains not printable characters */
    public class C1675 implements ExtendView.InterfaceC1642 {
        public C1675() {
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.ExtendView.InterfaceC1642
        /* renamed from: Ϳ */
        public void mo4393() {
            if (MonitorAnimateView.this.f4363 != null) {
                MonitorAnimateView.this.f4363.mo4550();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ތ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1676 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ TextView f4668;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ ViewTreeObserver f4669;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2494 f4670;

        public ViewTreeObserverOnGlobalLayoutListenerC1676(TextView textView, ViewTreeObserver viewTreeObserver, C2494 c2494) {
            this.f4668 = textView;
            this.f4669 = viewTreeObserver;
            this.f4670 = c2494;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f4668.getLayout();
            if (layout != null) {
                this.f4669.removeOnGlobalLayoutListener(this);
                int lineStart = layout.getLineStart(0);
                int lineEnd = layout.getLineEnd(0);
                if (this.f4670.m9096().length() > 0) {
                    String strSubstring = this.f4670.m9096().substring(lineStart, lineEnd);
                    TextPaint paint = this.f4668.getPaint();
                    float fMeasureText = paint.measureText(strSubstring);
                    if (paint.measureText(this.f4670.m9096()) > MonitorAnimateView.this.f4384 * MonitorAnimateView.this.f4534) {
                        float maxWidth = (this.f4668.getMaxWidth() - fMeasureText) / 2.0f;
                        if (maxWidth != this.f4668.getTranslationX()) {
                            int iM9101 = this.f4670.m9101();
                            if (iM9101 == 0) {
                                MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                                monitorAnimateView.m4463(this.f4668, monitorAnimateView.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4457 + maxWidth), MonitorAnimateView.this.f4456);
                            } else if (iM9101 == 1) {
                                MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                                monitorAnimateView2.m4463(this.f4668, monitorAnimateView2.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4459 + maxWidth), MonitorAnimateView.this.f4456);
                            } else if (iM9101 == 2) {
                                MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                                monitorAnimateView3.m4463(this.f4668, monitorAnimateView3.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4457 + maxWidth), MonitorAnimateView.this.f4458);
                            } else {
                                MonitorAnimateView monitorAnimateView4 = MonitorAnimateView.this;
                                monitorAnimateView4.m4463(this.f4668, monitorAnimateView4.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4459 + maxWidth), MonitorAnimateView.this.f4458);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ލ, reason: contains not printable characters */
    public class ViewOnClickListenerC1677 implements View.OnClickListener {
        public ViewOnClickListenerC1677() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ގ, reason: contains not printable characters */
    public class ViewOnClickListenerC1678 implements View.OnClickListener {
        public ViewOnClickListenerC1678() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MonitorAnimateView.this.f4363 != null) {
                MonitorAnimateView.this.f4363.mo4552();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޏ, reason: contains not printable characters */
    public class C1679 implements MonitorUnitView.InterfaceC1755 {
        public C1679() {
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo4547(int i, boolean z) throws InterruptedException, Resources.NotFoundException {
            MonitorAnimateView.this.f4448.m9158(i);
            if (i != MonitorAnimateView.this.f4448.m9090().getLinkIndex()) {
                MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                monitorAnimateView.m4469(monitorAnimateView.f4448, i);
                MonitorAnimateView.this.f4448.m9131().getRatioCoverView().setAlpha(0.0f);
                MonitorAnimateView.this.f4448.m9090().getTextureView().setCanShow(false);
            }
            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
            monitorAnimateView2.m4472(monitorAnimateView2.f4448);
            if (i == -1) {
                if (z) {
                    MonitorAnimateView.this.f4448.m9146(-1);
                }
            } else if (z) {
                MonitorAnimateView.this.f4448.m9146(i);
                MonitorAnimateView.this.f4448.m9088();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo4548(boolean z, boolean z2) {
            if (MonitorAnimateView.this.f4448.m9109().getAlpha() == 1.0f) {
                MonitorAnimateView.this.f4448.m9090().setTextureCanRender(z);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: ԩ, reason: contains not printable characters */
        public int mo4549() {
            return MonitorAnimateView.this.f4448.m9101();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ސ, reason: contains not printable characters */
    public class C1680 implements MonitorUnitView.InterfaceC1755 {
        public C1680() {
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: Ϳ */
        public void mo4547(int i, boolean z) throws InterruptedException, Resources.NotFoundException {
            if (MonitorAnimateView.this.f4449.m9101() != i) {
                MonitorAnimateView.this.f4449.m9131().getRatioCoverView().setAlpha(0.0f);
                MonitorAnimateView.this.f4449.m9090().getTextureView().setCanShow(false);
            }
            MonitorAnimateView.this.f4449.m9158(i);
            MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
            monitorAnimateView.m4469(monitorAnimateView.f4449, i);
            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
            monitorAnimateView2.m4472(monitorAnimateView2.f4449);
            if (i == -1) {
                if (z) {
                    MonitorAnimateView.this.f4449.m9146(-1);
                }
            } else if (z) {
                MonitorAnimateView.this.f4449.m9146(i);
                MonitorAnimateView.this.f4449.m9088();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: Ԩ */
        public void mo4548(boolean z, boolean z2) {
            if (MonitorAnimateView.this.f4449.m9109().getAlpha() == 1.0f) {
                MonitorAnimateView.this.f4449.m9090().setTextureCanRender(z);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: ԩ */
        public int mo4549() {
            return MonitorAnimateView.this.f4449.m9101();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޑ, reason: contains not printable characters */
    public class C1681 implements MonitorUnitView.InterfaceC1755 {
        public C1681() {
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: Ϳ */
        public void mo4547(int i, boolean z) throws InterruptedException, Resources.NotFoundException {
            if (MonitorAnimateView.this.f4450.m9101() != i) {
                MonitorAnimateView.this.f4450.m9131().getRatioCoverView().setAlpha(0.0f);
                MonitorAnimateView.this.f4450.m9090().getTextureView().setCanShow(false);
            }
            MonitorAnimateView.this.f4450.m9158(i);
            if (i != MonitorAnimateView.this.f4450.m9090().getLinkIndex()) {
                MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                monitorAnimateView.m4469(monitorAnimateView.f4450, i);
            }
            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
            monitorAnimateView2.m4472(monitorAnimateView2.f4450);
            if (i == -1) {
                if (z) {
                    MonitorAnimateView.this.f4450.m9146(-1);
                }
            } else if (z) {
                MonitorAnimateView.this.f4450.m9146(i);
                MonitorAnimateView.this.f4450.m9088();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: Ԩ */
        public void mo4548(boolean z, boolean z2) {
            if (MonitorAnimateView.this.f4450.m9109().getAlpha() == 1.0f) {
                MonitorAnimateView.this.f4450.m9090().setTextureCanRender(z);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: ԩ */
        public int mo4549() {
            return MonitorAnimateView.this.f4450.m9101();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޒ, reason: contains not printable characters */
    public class C1682 implements MonitorUnitView.InterfaceC1755 {
        public C1682() {
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: Ϳ */
        public void mo4547(int i, boolean z) throws InterruptedException, Resources.NotFoundException {
            if (MonitorAnimateView.this.f4451.m9101() != i) {
                MonitorAnimateView.this.f4451.m9131().getRatioCoverView().setAlpha(0.0f);
                MonitorAnimateView.this.f4451.m9090().getTextureView().setCanShow(false);
            }
            MonitorAnimateView.this.f4451.m9158(i);
            if (i != MonitorAnimateView.this.f4451.m9090().getLinkIndex()) {
                MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                monitorAnimateView.m4469(monitorAnimateView.f4451, i);
            }
            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
            monitorAnimateView2.m4472(monitorAnimateView2.f4451);
            if (i == -1) {
                if (z) {
                    MonitorAnimateView.this.f4451.m9146(-1);
                }
            } else if (z) {
                MonitorAnimateView.this.f4451.m9146(i);
                MonitorAnimateView.this.f4451.m9088();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: Ԩ */
        public void mo4548(boolean z, boolean z2) {
            if (MonitorAnimateView.this.f4451.m9109().getAlpha() == 1.0f) {
                MonitorAnimateView.this.f4451.m9090().setTextureCanRender(z);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView.InterfaceC1755
        /* renamed from: ԩ */
        public int mo4549() {
            return MonitorAnimateView.this.f4451.m9101();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޓ, reason: contains not printable characters */
    public class ViewOnClickListenerC1683 implements View.OnClickListener {
        public ViewOnClickListenerC1683() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MonitorAnimateView.this.f4464 == 0) {
                MonitorAnimateView.this.f4464 = System.currentTimeMillis();
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - MonitorAnimateView.this.f4464 < 400) {
                    return;
                } else {
                    MonitorAnimateView.this.f4464 = jCurrentTimeMillis;
                }
            }
            if (MonitorAnimateView.this.f4425 != 1) {
                int linkIndex = MonitorAnimateView.this.f4427.getAcUnitView().getLinkIndex();
                if (FinderManager.getInstance().machineCanConnect(MonitorAnimateView.this.m4480(linkIndex)) > 0) {
                    if (MonitorAnimateView.this.f4425 == 2) {
                        MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                        monitorAnimateView.f4466 = monitorAnimateView.f4454.m9090() == MonitorAnimateView.this.f4427.getAcUnitView();
                        if (MonitorAnimateView.this.f4466) {
                            if (MonitorAnimateView.this.f4454.m9097() == 7) {
                                return;
                            }
                            MonitorAnimateView.this.f4452.m9158(linkIndex);
                            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                            monitorAnimateView2.f4452 = monitorAnimateView2.f4454;
                        } else {
                            if (MonitorAnimateView.this.f4453.m9097() == 7) {
                                return;
                            }
                            MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                            monitorAnimateView3.f4452 = monitorAnimateView3.f4453;
                        }
                    } else {
                        C2494 c2494M4483 = MonitorAnimateView.this.m4483(linkIndex);
                        if (c2494M4483 == null || c2494M4483.m9097() == 7) {
                            return;
                        } else {
                            MonitorAnimateView.this.f4452 = c2494M4483;
                        }
                    }
                    if (MonitorAnimateView.this.f4363 == null || linkIndex == -1) {
                        return;
                    }
                    MonitorAnimateView monitorAnimateView4 = MonitorAnimateView.this;
                    monitorAnimateView4.m4467(monitorAnimateView4.f4370.f12189);
                    MonitorAnimateView.this.f4452.m9158(linkIndex);
                    MonitorAnimateView.this.f4460 = true;
                    MonitorAnimateView.this.f4363.mo4555();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޔ, reason: contains not printable characters */
    public class ViewOnClickListenerC1684 implements View.OnClickListener {
        public ViewOnClickListenerC1684() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MonitorAnimateView.this.f4464 == 0) {
                MonitorAnimateView.this.f4464 = System.currentTimeMillis();
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - MonitorAnimateView.this.f4464 < 400) {
                    return;
                } else {
                    MonitorAnimateView.this.f4464 = jCurrentTimeMillis;
                }
            }
            if (MonitorAnimateView.this.f4425 != 1) {
                int linkIndex = MonitorAnimateView.this.f4428.getAcUnitView().getLinkIndex();
                if (FinderManager.getInstance().machineCanConnect(MonitorAnimateView.this.m4480(linkIndex)) > 0) {
                    if (MonitorAnimateView.this.f4425 == 2) {
                        MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                        monitorAnimateView.f4466 = monitorAnimateView.f4454.m9090() == MonitorAnimateView.this.f4428.getAcUnitView();
                        if (MonitorAnimateView.this.f4466) {
                            if (MonitorAnimateView.this.f4454.m9097() == 7) {
                                return;
                            }
                            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                            monitorAnimateView2.f4452 = monitorAnimateView2.f4454;
                        } else {
                            if (MonitorAnimateView.this.f4453.m9097() == 7) {
                                return;
                            }
                            MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                            monitorAnimateView3.f4452 = monitorAnimateView3.f4453;
                        }
                    } else {
                        C2494 c2494M4483 = MonitorAnimateView.this.m4483(linkIndex);
                        if (c2494M4483 == null || c2494M4483.m9097() == 7) {
                            return;
                        } else {
                            MonitorAnimateView.this.f4452 = c2494M4483;
                        }
                    }
                    if (MonitorAnimateView.this.f4363 == null || linkIndex == -1) {
                        return;
                    }
                    MonitorAnimateView monitorAnimateView4 = MonitorAnimateView.this;
                    monitorAnimateView4.m4467(monitorAnimateView4.f4370.f12190);
                    MonitorAnimateView.this.f4452.m9158(linkIndex);
                    MonitorAnimateView.this.f4460 = true;
                    MonitorAnimateView.this.f4363.mo4555();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޕ, reason: contains not printable characters */
    public class ViewOnClickListenerC1685 implements View.OnClickListener {
        public ViewOnClickListenerC1685() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MonitorAnimateView.this.f4464 == 0) {
                MonitorAnimateView.this.f4464 = System.currentTimeMillis();
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - MonitorAnimateView.this.f4464 < 400) {
                    return;
                } else {
                    MonitorAnimateView.this.f4464 = jCurrentTimeMillis;
                }
            }
            if (MonitorAnimateView.this.f4425 != 1) {
                int linkIndex = MonitorAnimateView.this.f4429.getAcUnitView().getLinkIndex();
                if (FinderManager.getInstance().machineCanConnect(MonitorAnimateView.this.m4480(linkIndex)) > 0) {
                    if (MonitorAnimateView.this.f4425 == 2) {
                        MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                        monitorAnimateView.f4466 = monitorAnimateView.f4454.m9090() == MonitorAnimateView.this.f4429.getAcUnitView();
                        if (MonitorAnimateView.this.f4466) {
                            if (MonitorAnimateView.this.f4454.m9097() == 7) {
                                return;
                            }
                            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                            monitorAnimateView2.f4452 = monitorAnimateView2.f4454;
                        } else {
                            if (MonitorAnimateView.this.f4453.m9097() == 7) {
                                return;
                            }
                            MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                            monitorAnimateView3.f4452 = monitorAnimateView3.f4453;
                        }
                    } else {
                        C2494 c2494M4483 = MonitorAnimateView.this.m4483(linkIndex);
                        if (c2494M4483 == null || c2494M4483.m9097() == 7) {
                            return;
                        } else {
                            MonitorAnimateView.this.f4452 = c2494M4483;
                        }
                    }
                    if (MonitorAnimateView.this.f4363 == null || linkIndex == -1) {
                        return;
                    }
                    MonitorAnimateView monitorAnimateView4 = MonitorAnimateView.this;
                    monitorAnimateView4.m4467(monitorAnimateView4.f4370.f12191);
                    MonitorAnimateView.this.f4452.m9158(linkIndex);
                    MonitorAnimateView.this.f4460 = true;
                    MonitorAnimateView.this.f4363.mo4555();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޖ, reason: contains not printable characters */
    public class C1686 implements ExtendView.InterfaceC1642 {
        public C1686() {
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.ExtendView.InterfaceC1642
        /* renamed from: Ϳ */
        public void mo4393() {
            if (MonitorAnimateView.this.f4363 != null) {
                MonitorAnimateView.this.f4363.mo4550();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޗ, reason: contains not printable characters */
    public class ViewOnClickListenerC1687 implements View.OnClickListener {
        public ViewOnClickListenerC1687() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MonitorAnimateView.this.f4464 == 0) {
                MonitorAnimateView.this.f4464 = System.currentTimeMillis();
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - MonitorAnimateView.this.f4464 < 400) {
                    return;
                } else {
                    MonitorAnimateView.this.f4464 = jCurrentTimeMillis;
                }
            }
            if (MonitorAnimateView.this.f4425 != 1) {
                int linkIndex = MonitorAnimateView.this.f4430.getAcUnitView().getLinkIndex();
                if (FinderManager.getInstance().machineCanConnect(MonitorAnimateView.this.m4480(linkIndex)) > 0) {
                    if (MonitorAnimateView.this.f4425 == 2) {
                        MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                        monitorAnimateView.f4466 = monitorAnimateView.f4454.m9090() == MonitorAnimateView.this.f4430.getAcUnitView();
                        if (MonitorAnimateView.this.f4466) {
                            if (MonitorAnimateView.this.f4454.m9097() == 7) {
                                return;
                            }
                            MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                            monitorAnimateView2.f4452 = monitorAnimateView2.f4454;
                        } else {
                            if (MonitorAnimateView.this.f4453.m9097() == 7) {
                                return;
                            }
                            MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                            monitorAnimateView3.f4452 = monitorAnimateView3.f4453;
                        }
                    } else {
                        C2494 c2494M4483 = MonitorAnimateView.this.m4483(linkIndex);
                        if (c2494M4483 == null || c2494M4483.m9097() == 7) {
                            return;
                        }
                        MonitorAnimateView monitorAnimateView4 = MonitorAnimateView.this;
                        monitorAnimateView4.f4452 = monitorAnimateView4.m4483(linkIndex);
                    }
                    if (MonitorAnimateView.this.f4363 == null || linkIndex == -1) {
                        return;
                    }
                    MonitorAnimateView monitorAnimateView5 = MonitorAnimateView.this;
                    monitorAnimateView5.m4467(monitorAnimateView5.f4370.f12192);
                    MonitorAnimateView.this.f4452.m9158(linkIndex);
                    MonitorAnimateView.this.f4460 = true;
                    MonitorAnimateView.this.f4363.mo4555();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޘ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1688 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޘ$Ϳ, reason: contains not printable characters */
        public class RunnableC1689 implements Runnable {
            public RunnableC1689() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MonitorAnimateView.this.f4427.getAcUnitView().setAlpha(1.0f);
                MonitorAnimateView.this.f4440.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC1688() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1 && action != 3) {
                    return false;
                }
                MonitorAnimateView.this.f4440.postDelayed(new RunnableC1689(), 100L);
                return false;
            }
            int linkIndex = MonitorAnimateView.this.f4427.getAcUnitView().getLinkIndex();
            if (MonitorAnimateView.this.f4363 == null || linkIndex == -1 || MonitorAnimateView.this.f4425 == 1) {
                return false;
            }
            MonitorAnimateView.this.f4427.getAcUnitView().setAlpha(0.3f);
            MonitorAnimateView.this.f4440.setAlpha(0.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޙ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1690 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޙ$Ϳ, reason: contains not printable characters */
        public class RunnableC1691 implements Runnable {
            public RunnableC1691() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MonitorAnimateView.this.f4428.getAcUnitView().setAlpha(1.0f);
                MonitorAnimateView.this.f4441.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC1690() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1 && action != 3) {
                    return false;
                }
                MonitorAnimateView.this.f4441.postDelayed(new RunnableC1691(), 100L);
                return false;
            }
            int linkIndex = MonitorAnimateView.this.f4428.getAcUnitView().getLinkIndex();
            if (MonitorAnimateView.this.f4363 == null || linkIndex == -1 || MonitorAnimateView.this.f4425 == 1) {
                return false;
            }
            MonitorAnimateView.this.f4428.getAcUnitView().setAlpha(0.3f);
            MonitorAnimateView.this.f4441.setAlpha(0.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޚ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1692 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޚ$Ϳ, reason: contains not printable characters */
        public class RunnableC1693 implements Runnable {
            public RunnableC1693() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MonitorAnimateView.this.f4429.getAcUnitView().setAlpha(1.0f);
                MonitorAnimateView.this.f4442.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC1692() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1 && action != 3) {
                    return false;
                }
                MonitorAnimateView.this.f4442.postDelayed(new RunnableC1693(), 100L);
                return false;
            }
            int linkIndex = MonitorAnimateView.this.f4429.getAcUnitView().getLinkIndex();
            if (MonitorAnimateView.this.f4363 == null || linkIndex == -1 || MonitorAnimateView.this.f4425 == 1) {
                return false;
            }
            MonitorAnimateView.this.f4429.getAcUnitView().setAlpha(0.3f);
            MonitorAnimateView.this.f4442.setAlpha(0.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޛ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1694 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޛ$Ϳ, reason: contains not printable characters */
        public class RunnableC1695 implements Runnable {
            public RunnableC1695() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MonitorAnimateView.this.f4430.getAcUnitView().setAlpha(1.0f);
                MonitorAnimateView.this.f4443.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC1694() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1 && action != 3) {
                    return false;
                }
                MonitorAnimateView.this.f4443.postDelayed(new RunnableC1695(), 100L);
                return false;
            }
            int linkIndex = MonitorAnimateView.this.f4430.getAcUnitView().getLinkIndex();
            if (MonitorAnimateView.this.f4363 == null || linkIndex == -1 || MonitorAnimateView.this.f4425 == 1) {
                return false;
            }
            MonitorAnimateView.this.f4430.getAcUnitView().setAlpha(0.3f);
            MonitorAnimateView.this.f4443.setAlpha(0.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޜ, reason: contains not printable characters */
    public class C1696 implements RecordButton.InterfaceC0941 {
        public C1696() {
        }

        @Override // com.blink.academy.film.widgets.RecordButton.InterfaceC0941
        /* renamed from: Ϳ */
        public boolean mo2506() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.RecordButton.InterfaceC0941
        /* renamed from: Ԩ */
        public void mo2507(int i) {
            ACHelper.getInstance().setMonitorRecording(i == 1);
            ACHelper.getInstance().sendCaptureEventMsg();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޝ, reason: contains not printable characters */
    public class C1697 implements ACHelper.OnMonitorCallback {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޝ$Ϳ, reason: contains not printable characters */
        public class RunnableC1698 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ LinkEntity f4693;

            public RunnableC1698(LinkEntity linkEntity) {
                this.f4693 = linkEntity;
            }

            @Override // java.lang.Runnable
            public void run() {
                LinkEntity linkEntity = this.f4693;
                if (linkEntity != null) {
                    ACCameraInfoBean acCameraInfoBean = linkEntity.getAcCameraInfoBean();
                    if (acCameraInfoBean != null) {
                        String[] block = acCameraInfoBean.getBlock();
                        String strM5991 = e5.m5988().m5991();
                        boolean z = false;
                        z = false;
                        if (block != null && block.length > 0) {
                            boolean zEquals = false;
                            for (int i = 0; i < block.length && !(zEquals = block[i].equals(strM5991)); i++) {
                            }
                            z = zEquals;
                        }
                        this.f4693.changeBanState(z);
                    }
                    if (this.f4693.isBanned()) {
                        return;
                    }
                }
                MonitorAnimateView.this.m4528(this.f4693);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޝ$Ԩ, reason: contains not printable characters */
        public class RunnableC1699 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f4695;

            public RunnableC1699(int i) {
                this.f4695 = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                MonitorAnimateView.this.m4530(this.f4695);
            }
        }

        public C1697() {
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnMonitorCallback
        public void onLinkRelease(int i) {
            FilmApp.m405().m427(new RunnableC1699(i));
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnMonitorCallback
        public void refreshOnGetLinkFrameInfo(LinkEntity linkEntity) {
            FilmApp.m405().m427(new RunnableC1698(linkEntity));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޞ, reason: contains not printable characters */
    public class ViewOnClickListenerC1700 implements View.OnClickListener {
        public ViewOnClickListenerC1700() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorAnimateView.this.f4370.f12205.performClick();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޟ, reason: contains not printable characters */
    public class ViewOnClickListenerC1701 implements View.OnClickListener {
        public ViewOnClickListenerC1701() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorAnimateView.this.f4370.f12206.performClick();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1702 implements View.OnClickListener {
        public ViewOnClickListenerC1702() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorAnimateView.this.f4370.f12207.performClick();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޡ, reason: contains not printable characters */
    public class C1703 implements ExtendView.InterfaceC1642 {
        public C1703() {
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.ExtendView.InterfaceC1642
        /* renamed from: Ϳ */
        public void mo4393() {
            if (MonitorAnimateView.this.f4363 != null) {
                MonitorAnimateView.this.f4363.mo4550();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޢ, reason: contains not printable characters */
    public class ViewOnClickListenerC1704 implements View.OnClickListener {
        public ViewOnClickListenerC1704() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorAnimateView.this.f4370.f12208.performClick();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޣ, reason: contains not printable characters */
    public class C1705 implements Handler.Callback {
        public C1705() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) throws Resources.NotFoundException {
            int i = message.what;
            if (i == 10001) {
                C2494 c2494 = (C2494) message.obj;
                if (c2494.m9102() != 0) {
                    c2494.m9108().m4583(c2494.m9133(), c2494.m9140());
                    c2494.m9160(0L);
                    c2494.m9170(null);
                    c2494.m9169(c2494.m9133());
                    if (MonitorAnimateView.this.f4425 == 1 && MonitorAnimateView.this.f4363 != null) {
                        MonitorAnimateView.this.f4363.mo4553(false);
                    }
                }
            } else if (i == 10002) {
                MonitorAnimateView.this.f4475 = false;
            } else if (i == 10003) {
                MonitorAnimateView.this.m4506();
                MonitorAnimateView.this.f4367.sendEmptyMessage(10003);
            }
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޤ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1706 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ LineFeedTextView f4703;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2494 f4704;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ String f4705;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ ViewTreeObserver f4706;

        public ViewTreeObserverOnGlobalLayoutListenerC1706(LineFeedTextView lineFeedTextView, C2494 c2494, String str, ViewTreeObserver viewTreeObserver) {
            this.f4703 = lineFeedTextView;
            this.f4704 = c2494;
            this.f4705 = str;
            this.f4706 = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            float maxWidth;
            Layout layout = this.f4703.getLayout();
            if (layout != null) {
                String strSubstring = this.f4704.m9096().substring(layout.getLineStart(0), layout.getLineEnd(0));
                float fMeasureText = this.f4703.getPaint().measureText(strSubstring);
                if (MonitorAnimateView.this.f4425 == 1) {
                    this.f4704.m9155((int) Math.max(Math.ceil(r2.measureText(this.f4705) / (MonitorAnimateView.this.f4397 * MonitorAnimateView.this.f4534)), 1.0d));
                    maxWidth = this.f4704.m9099() > 1 ? (this.f4703.getMaxWidth() - fMeasureText) / 2.0f : 0.0f;
                    if (MonitorAnimateView.this.f4465) {
                        return;
                    }
                    MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
                    monitorAnimateView.m4463(this.f4703, monitorAnimateView.f4397, MonitorAnimateView.this.f4398, (int) (MonitorAnimateView.this.f4406 + maxWidth), MonitorAnimateView.this.f4407);
                } else if (MonitorAnimateView.this.f4425 == 2) {
                    this.f4704.m9155((int) Math.max(Math.ceil(r2.measureText(this.f4705) / (MonitorAnimateView.this.f4381 * MonitorAnimateView.this.f4534)), 1.0d));
                    maxWidth = this.f4704.m9099() > 1 ? (this.f4703.getMaxWidth() - fMeasureText) / 2.0f : 0.0f;
                    if (MonitorAnimateView.this.f4465) {
                        return;
                    }
                    if (this.f4704 == MonitorAnimateView.this.f4453) {
                        MonitorAnimateView monitorAnimateView2 = MonitorAnimateView.this;
                        monitorAnimateView2.m4463(this.f4703, monitorAnimateView2.f4381, MonitorAnimateView.this.f4382, (int) (MonitorAnimateView.this.f4409 + maxWidth), MonitorAnimateView.this.f4408);
                    } else {
                        MonitorAnimateView monitorAnimateView3 = MonitorAnimateView.this;
                        monitorAnimateView3.m4463(this.f4703, monitorAnimateView3.f4381, MonitorAnimateView.this.f4382, (int) (MonitorAnimateView.this.f4410 + maxWidth), MonitorAnimateView.this.f4408);
                    }
                } else {
                    this.f4704.m9155((int) Math.max(Math.ceil(r2.measureText(this.f4705) / (MonitorAnimateView.this.f4384 * MonitorAnimateView.this.f4534)), 1.0d));
                    maxWidth = this.f4704.m9099() > 1 ? (this.f4703.getMaxWidth() - fMeasureText) / 2.0f : 0.0f;
                    if (MonitorAnimateView.this.f4465) {
                        return;
                    }
                    int iM9101 = this.f4704.m9101();
                    if (iM9101 == 0) {
                        MonitorAnimateView monitorAnimateView4 = MonitorAnimateView.this;
                        monitorAnimateView4.m4463(this.f4703, monitorAnimateView4.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4457 + maxWidth), MonitorAnimateView.this.f4456);
                    } else if (iM9101 == 1) {
                        MonitorAnimateView monitorAnimateView5 = MonitorAnimateView.this;
                        monitorAnimateView5.m4463(this.f4703, monitorAnimateView5.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4459 + maxWidth), MonitorAnimateView.this.f4456);
                    } else if (iM9101 == 2) {
                        MonitorAnimateView monitorAnimateView6 = MonitorAnimateView.this;
                        monitorAnimateView6.m4463(this.f4703, monitorAnimateView6.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4457 + maxWidth), MonitorAnimateView.this.f4458);
                    } else {
                        MonitorAnimateView monitorAnimateView7 = MonitorAnimateView.this;
                        monitorAnimateView7.m4463(this.f4703, monitorAnimateView7.f4384, MonitorAnimateView.this.f4383, (int) (MonitorAnimateView.this.f4459 + maxWidth), MonitorAnimateView.this.f4458);
                    }
                }
                this.f4706.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޥ, reason: contains not printable characters */
    public class C1707 implements ACWheelView.OnValueChange {
        public C1707() {
        }

        @Override // com.blink.academy.film.stream.ACWheelView.OnValueChange
        public void onAnimChange(boolean z) {
        }

        @Override // com.blink.academy.film.stream.ACWheelView.OnValueChange
        public void onFocusChange(float f) {
            LinkEntity linkEntityByLinkIndex;
            if (MonitorAnimateView.this.f4452 == null || (linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(MonitorAnimateView.this.f4452.m9090().getLinkIndex())) == null) {
                return;
            }
            linkEntityByLinkIndex.sendFocusChangeEvent(f);
        }

        @Override // com.blink.academy.film.stream.ACWheelView.OnValueChange
        public void onHideAB() {
        }

        @Override // com.blink.academy.film.stream.ACWheelView.OnValueChange
        public void onModeChange(boolean z) {
            LinkEntity linkEntityByLinkIndex;
            if (!MonitorAnimateView.this.f4475) {
                MonitorAnimateView.this.f4475 = true;
                MonitorAnimateView.this.f4367.removeMessages(10002);
                MonitorAnimateView.this.f4367.sendEmptyMessageDelayed(10002, 1000L);
            }
            if (MonitorAnimateView.this.f4452 == null || (linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(MonitorAnimateView.this.f4452.m9090().getLinkIndex())) == null) {
                return;
            }
            linkEntityByLinkIndex.sendWheelStataChangeEvent(z);
        }

        @Override // com.blink.academy.film.stream.ACWheelView.OnValueChange
        public void onTouchChange(boolean z) {
        }

        @Override // com.blink.academy.film.stream.ACWheelView.OnValueChange
        public void onTouchChange2(boolean z) {
            if (z) {
                MonitorAnimateView.this.f4475 = true;
                MonitorAnimateView.this.f4367.removeMessages(10002);
            } else {
                MonitorAnimateView.this.f4367.sendEmptyMessageDelayed(10002, 1000L);
            }
            if (z) {
                C4008.m12884(MonitorAnimateView.this.f4370.f12168, 1.3f, 1.3f, 100, null);
            } else {
                C4008.m12884(MonitorAnimateView.this.f4370.f12168, 1.0f, 1.0f, 100, null);
            }
        }

        @Override // com.blink.academy.film.stream.ACWheelView.OnValueChange
        public void onZoomChange(float f) {
            LinkEntity linkEntityByLinkIndex;
            if (MonitorAnimateView.this.f4452 == null || (linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(MonitorAnimateView.this.f4452.m9090().getLinkIndex())) == null) {
                return;
            }
            linkEntityByLinkIndex.sendZoomChangeEvent(f);
        }

        @Override // com.blink.academy.film.stream.ACWheelView.OnValueChange
        public void onZoomEnableChange(boolean z) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޱ, reason: contains not printable characters */
    public class ViewOnClickListenerC1708 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޱ$Ϳ, reason: contains not printable characters */
        public class C1709 extends AbstractC4012 {
            public C1709() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12193.setVisibility(8);
                MonitorAnimateView.this.f4427.getCloudBgCover().setVisibility(8);
                MonitorAnimateView.this.f4370.f12197.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޱ$Ԩ, reason: contains not printable characters */
        public class C1710 extends AbstractC4012 {
            public C1710() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12217.setVisibility(4);
                MonitorAnimateView.this.f4370.f12186.setVisibility(4);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޱ$Ԫ, reason: contains not printable characters */
        public class C1711 extends AbstractC4012 {
            public C1711() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12213.setVisibility(4);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ޱ$Ԭ, reason: contains not printable characters */
        public class C1712 extends AbstractC4012 {
            public C1712() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12213.setVisibility(4);
            }
        }

        public ViewOnClickListenerC1708() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            if (MonitorAnimateView.this.f4370.f12193.getVisibility() == 0) {
                C4008.m12876(MonitorAnimateView.this.f4370.f12193, 0.0f, 150, new C1709());
                C4008.m12876(MonitorAnimateView.this.f4427.getCloudBgCover(), 0.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12197, 0.0f, 150, null);
                MonitorAnimateView.this.f4370.f12201.setVisibility(8);
                MonitorAnimateView.this.f4448.m9147(false);
                MonitorAnimateView.this.f4370.f12186.setVisibility(0);
                if (MonitorAnimateView.this.f4425 == 1) {
                    C4008.m12876(MonitorAnimateView.this.f4370.f12188, 1.0f, 150, null);
                    if (MonitorAnimateView.this.f4363 != null) {
                        MonitorAnimateView.this.f4363.mo4553(false);
                    }
                    C4008.m12876(MonitorAnimateView.this.f4370.f12186, 0.0f, 0, null);
                    C4008.m12876(MonitorAnimateView.this.f4370.f12186, 1.0f, 150, null);
                }
                MonitorAnimateView.this.f4370.f12213.setVisibility(0);
                MonitorAnimateView.this.f4370.f12209.setVisibility(0);
                MonitorAnimateView.this.f4370.f12217.setVisibility(0);
                C4008.m12876(MonitorAnimateView.this.f4370.f12213, 0.0f, 0, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12217, 0.0f, 0, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12213, 1.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12217, 1.0f, 150, null);
                C4008.m12877(MonitorAnimateView.this.f4444, 1.0f, 150, null);
                MonitorAnimateView.this.f4370.f12205.m4221(0);
                return;
            }
            MonitorAnimateView.this.f4370.f12193.setVisibility(0);
            C4008.m12876(MonitorAnimateView.this.f4370.f12193, 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12193, 1.0f, 150, null);
            MonitorAnimateView.this.f4427.getCloudBgCover().setVisibility(0);
            MonitorAnimateView.this.f4370.f12197.setVisibility(0);
            MonitorAnimateView.this.f4370.f12201.setVisibility(0);
            C4008.m12876(MonitorAnimateView.this.f4427.getCloudBgCover(), 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4427.getCloudBgCover(), 1.0f, 150, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12197, 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12197, 1.0f, 150, null);
            MonitorAnimateView.this.f4370.f12205.m4221(1);
            MonitorAnimateView.this.f4448.m9147(true);
            MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
            monitorAnimateView.m4527(monitorAnimateView.f4448);
            MonitorAnimateView.this.f4367.removeMessages(10003);
            MonitorAnimateView.this.f4367.sendEmptyMessage(10003);
            if (MonitorAnimateView.this.f4425 == 1) {
                C4008.m12876(MonitorAnimateView.this.f4370.f12188, 0.0f, 150, new C1710());
                C4008.m12876(MonitorAnimateView.this.f4370.f12217, 0.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12186, 0.0f, 150, null);
                if (MonitorAnimateView.this.f4363 != null) {
                    MonitorAnimateView.this.f4363.mo4553(true);
                }
                if (!C2579.m9452(MonitorAnimateView.this.getContext())) {
                    C4008.m12876(MonitorAnimateView.this.f4370.f12213, 0.0f, 150, new C1711());
                }
            } else {
                C4008.m12876(MonitorAnimateView.this.f4370.f12213, 0.0f, 150, new C1712());
            }
            C4008.m12877(MonitorAnimateView.this.f4444, 0.0f, 150, null);
            MonitorAnimateView.this.f4370.f12209.setVisibility(4);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$߾, reason: contains not printable characters */
    public class ViewOnClickListenerC1713 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$߾$Ϳ, reason: contains not printable characters */
        public class C1714 extends AbstractC4012 {
            public C1714() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12194.setVisibility(8);
                MonitorAnimateView.this.f4428.getCloudBgCover().setVisibility(8);
                MonitorAnimateView.this.f4370.f12198.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$߾$Ԩ, reason: contains not printable characters */
        public class C1715 extends AbstractC4012 {
            public C1715() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12187.setVisibility(4);
                MonitorAnimateView.this.f4370.f12218.setVisibility(4);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$߾$Ԫ, reason: contains not printable characters */
        public class C1716 extends AbstractC4012 {
            public C1716() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12214.setVisibility(4);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$߾$Ԭ, reason: contains not printable characters */
        public class C1717 extends AbstractC4012 {
            public C1717() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12214.setVisibility(4);
            }
        }

        public ViewOnClickListenerC1713() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            if (MonitorAnimateView.this.f4370.f12194.getVisibility() == 0) {
                C4008.m12876(MonitorAnimateView.this.f4370.f12194, 0.0f, 150, new C1714());
                C4008.m12876(MonitorAnimateView.this.f4428.getCloudBgCover(), 0.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12198, 0.0f, 150, null);
                MonitorAnimateView.this.f4370.f12206.m4221(0);
                MonitorAnimateView.this.f4370.f12202.setVisibility(8);
                MonitorAnimateView.this.f4449.m9147(false);
                MonitorAnimateView.this.f4370.f12187.setVisibility(0);
                if (MonitorAnimateView.this.f4425 == 1) {
                    C4008.m12876(MonitorAnimateView.this.f4370.f12188, 1.0f, 150, null);
                    if (MonitorAnimateView.this.f4363 != null) {
                        MonitorAnimateView.this.f4363.mo4553(false);
                    }
                    C4008.m12876(MonitorAnimateView.this.f4370.f12187, 0.0f, 0, null);
                    C4008.m12876(MonitorAnimateView.this.f4370.f12187, 1.0f, 150, null);
                }
                MonitorAnimateView.this.f4370.f12214.setVisibility(0);
                MonitorAnimateView.this.f4370.f12210.setVisibility(0);
                MonitorAnimateView.this.f4370.f12218.setVisibility(0);
                C4008.m12876(MonitorAnimateView.this.f4370.f12214, 0.0f, 0, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12218, 0.0f, 0, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12214, 1.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12218, 1.0f, 150, null);
                C4008.m12877(MonitorAnimateView.this.f4445, 1.0f, 150, null);
                return;
            }
            MonitorAnimateView.this.f4370.f12206.m4221(1);
            MonitorAnimateView.this.f4370.f12194.setVisibility(0);
            MonitorAnimateView.this.f4428.getCloudBgCover().setVisibility(0);
            MonitorAnimateView.this.f4370.f12198.setVisibility(0);
            MonitorAnimateView.this.f4370.f12202.setVisibility(0);
            C4008.m12876(MonitorAnimateView.this.f4370.f12194, 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4428.getCloudBgCover(), 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12198, 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12194, 1.0f, 150, null);
            C4008.m12876(MonitorAnimateView.this.f4428.getCloudBgCover(), 1.0f, 150, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12198, 1.0f, 150, null);
            MonitorAnimateView.this.f4449.m9147(true);
            MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
            monitorAnimateView.m4527(monitorAnimateView.f4449);
            MonitorAnimateView.this.f4367.removeMessages(10003);
            MonitorAnimateView.this.f4367.sendEmptyMessage(10003);
            if (MonitorAnimateView.this.f4425 == 1) {
                C4008.m12876(MonitorAnimateView.this.f4370.f12188, 0.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12187, 0.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12218, 0.0f, 150, new C1715());
                if (MonitorAnimateView.this.f4363 != null) {
                    MonitorAnimateView.this.f4363.mo4553(true);
                }
                if (!C2579.m9452(MonitorAnimateView.this.getContext())) {
                    C4008.m12876(MonitorAnimateView.this.f4370.f12214, 0.0f, 150, new C1716());
                }
            } else {
                C4008.m12876(MonitorAnimateView.this.f4370.f12214, 0.0f, 150, new C1717());
            }
            MonitorAnimateView.this.f4370.f12210.setVisibility(4);
            C4008.m12877(MonitorAnimateView.this.f4445, 0.0f, 150, null);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$߿, reason: contains not printable characters */
    public class ViewOnClickListenerC1718 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$߿$Ϳ, reason: contains not printable characters */
        public class C1719 extends AbstractC4012 {
            public C1719() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12195.setVisibility(8);
                MonitorAnimateView.this.f4429.getCloudBgCover().setVisibility(8);
                MonitorAnimateView.this.f4370.f12199.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$߿$Ԩ, reason: contains not printable characters */
        public class C1720 extends AbstractC4012 {
            public C1720() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12180.setVisibility(4);
                MonitorAnimateView.this.f4370.f12219.setVisibility(4);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$߿$Ԫ, reason: contains not printable characters */
        public class C1721 extends AbstractC4012 {
            public C1721() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12215.setVisibility(4);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$߿$Ԭ, reason: contains not printable characters */
        public class C1722 extends AbstractC4012 {
            public C1722() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12215.setVisibility(4);
            }
        }

        public ViewOnClickListenerC1718() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            if (MonitorAnimateView.this.f4370.f12195.getVisibility() == 0) {
                MonitorAnimateView.this.f4370.f12207.m4221(0);
                C4008.m12876(MonitorAnimateView.this.f4370.f12195, 0.0f, 150, new C1719());
                C4008.m12876(MonitorAnimateView.this.f4429.getCloudBgCover(), 0.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12199, 0.0f, 150, null);
                MonitorAnimateView.this.f4370.f12203.setVisibility(8);
                MonitorAnimateView.this.f4450.m9147(false);
                MonitorAnimateView.this.f4370.f12180.setVisibility(0);
                if (MonitorAnimateView.this.f4425 == 1) {
                    C4008.m12876(MonitorAnimateView.this.f4370.f12188, 1.0f, 150, null);
                    if (MonitorAnimateView.this.f4363 != null) {
                        MonitorAnimateView.this.f4363.mo4553(false);
                    }
                    C4008.m12876(MonitorAnimateView.this.f4370.f12180, 0.0f, 0, null);
                    C4008.m12876(MonitorAnimateView.this.f4370.f12180, 1.0f, 150, null);
                }
                MonitorAnimateView.this.f4370.f12215.setVisibility(0);
                MonitorAnimateView.this.f4370.f12211.setVisibility(0);
                MonitorAnimateView.this.f4370.f12219.setVisibility(0);
                C4008.m12876(MonitorAnimateView.this.f4370.f12215, 0.0f, 0, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12219, 0.0f, 0, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12215, 1.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12219, 1.0f, 150, null);
                C4008.m12877(MonitorAnimateView.this.f4446, 1.0f, 150, null);
                return;
            }
            MonitorAnimateView.this.f4370.f12207.m4221(1);
            MonitorAnimateView.this.f4370.f12195.setVisibility(0);
            MonitorAnimateView.this.f4429.getCloudBgCover().setVisibility(0);
            MonitorAnimateView.this.f4370.f12199.setVisibility(0);
            MonitorAnimateView.this.f4370.f12203.setVisibility(0);
            C4008.m12876(MonitorAnimateView.this.f4370.f12195, 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4429.getCloudBgCover(), 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12199, 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12195, 1.0f, 150, null);
            C4008.m12876(MonitorAnimateView.this.f4429.getCloudBgCover(), 1.0f, 150, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12199, 1.0f, 150, null);
            MonitorAnimateView.this.f4450.m9147(true);
            MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
            monitorAnimateView.m4527(monitorAnimateView.f4450);
            MonitorAnimateView.this.f4367.removeMessages(10003);
            MonitorAnimateView.this.f4367.sendEmptyMessage(10003);
            if (MonitorAnimateView.this.f4425 == 1) {
                C4008.m12876(MonitorAnimateView.this.f4370.f12188, 0.0f, 150, new C1720());
                C4008.m12876(MonitorAnimateView.this.f4370.f12180, 0.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12219, 0.0f, 150, null);
                if (MonitorAnimateView.this.f4363 != null) {
                    MonitorAnimateView.this.f4363.mo4553(true);
                }
                if (!C2579.m9452(MonitorAnimateView.this.getContext())) {
                    C4008.m12876(MonitorAnimateView.this.f4370.f12215, 0.0f, 150, new C1721());
                }
            } else {
                C4008.m12876(MonitorAnimateView.this.f4370.f12215, 0.0f, 150, new C1722());
            }
            MonitorAnimateView.this.f4370.f12211.setVisibility(4);
            C4008.m12877(MonitorAnimateView.this.f4446, 0.0f, 150, null);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ࡠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1723 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ࡠ$Ϳ, reason: contains not printable characters */
        public class C1724 extends AbstractC4012 {
            public C1724() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12196.setVisibility(8);
                MonitorAnimateView.this.f4430.getCloudBgCover().setVisibility(8);
                MonitorAnimateView.this.f4370.f12200.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ࡠ$Ԩ, reason: contains not printable characters */
        public class C1725 extends AbstractC4012 {
            public C1725() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12181.setVisibility(4);
                MonitorAnimateView.this.f4370.f12220.setVisibility(4);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ࡠ$Ԫ, reason: contains not printable characters */
        public class C1726 extends AbstractC4012 {
            public C1726() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12216.setVisibility(4);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ࡠ$Ԭ, reason: contains not printable characters */
        public class C1727 extends AbstractC4012 {
            public C1727() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                MonitorAnimateView.this.f4370.f12216.setVisibility(4);
            }
        }

        public ViewOnClickListenerC1723() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            if (MonitorAnimateView.this.f4370.f12196.getVisibility() == 0) {
                MonitorAnimateView.this.f4370.f12208.m4221(0);
                C4008.m12876(MonitorAnimateView.this.f4370.f12196, 0.0f, 150, new C1724());
                C4008.m12876(MonitorAnimateView.this.f4430.getCloudBgCover(), 0.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12200, 0.0f, 150, null);
                MonitorAnimateView.this.f4370.f12204.setVisibility(8);
                MonitorAnimateView.this.f4451.m9147(false);
                MonitorAnimateView.this.f4370.f12181.setVisibility(0);
                if (MonitorAnimateView.this.f4425 == 1) {
                    C4008.m12876(MonitorAnimateView.this.f4370.f12188, 1.0f, 150, null);
                    if (MonitorAnimateView.this.f4363 != null) {
                        MonitorAnimateView.this.f4363.mo4553(false);
                    }
                    C4008.m12876(MonitorAnimateView.this.f4370.f12181, 0.0f, 0, null);
                    C4008.m12876(MonitorAnimateView.this.f4370.f12181, 1.0f, 150, null);
                }
                MonitorAnimateView.this.f4370.f12216.setVisibility(0);
                MonitorAnimateView.this.f4370.f12212.setVisibility(0);
                MonitorAnimateView.this.f4370.f12220.setVisibility(0);
                C4008.m12876(MonitorAnimateView.this.f4370.f12216, 0.0f, 0, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12220, 0.0f, 0, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12216, 1.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12220, 1.0f, 150, null);
                C4008.m12877(MonitorAnimateView.this.f4447, 1.0f, 150, null);
                return;
            }
            MonitorAnimateView.this.f4370.f12208.m4221(1);
            MonitorAnimateView.this.f4370.f12196.setVisibility(0);
            MonitorAnimateView.this.f4430.getCloudBgCover().setVisibility(0);
            MonitorAnimateView.this.f4370.f12200.setVisibility(0);
            MonitorAnimateView.this.f4370.f12204.setVisibility(0);
            C4008.m12876(MonitorAnimateView.this.f4370.f12196, 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4430.getCloudBgCover(), 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12200, 0.0f, 0, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12196, 1.0f, 150, null);
            C4008.m12876(MonitorAnimateView.this.f4430.getCloudBgCover(), 1.0f, 150, null);
            C4008.m12876(MonitorAnimateView.this.f4370.f12200, 1.0f, 150, null);
            MonitorAnimateView.this.f4451.m9147(true);
            MonitorAnimateView monitorAnimateView = MonitorAnimateView.this;
            monitorAnimateView.m4527(monitorAnimateView.f4451);
            MonitorAnimateView.this.f4367.removeMessages(10003);
            MonitorAnimateView.this.f4367.sendEmptyMessage(10003);
            if (MonitorAnimateView.this.f4425 == 1) {
                C4008.m12876(MonitorAnimateView.this.f4370.f12188, 0.0f, 150, new C1725());
                C4008.m12876(MonitorAnimateView.this.f4370.f12181, 0.0f, 150, null);
                C4008.m12876(MonitorAnimateView.this.f4370.f12220, 0.0f, 150, null);
                if (MonitorAnimateView.this.f4363 != null) {
                    MonitorAnimateView.this.f4363.mo4553(true);
                }
                if (!C2579.m9452(MonitorAnimateView.this.getContext())) {
                    C4008.m12876(MonitorAnimateView.this.f4370.f12216, 0.0f, 150, new C1726());
                }
            } else {
                C4008.m12876(MonitorAnimateView.this.f4370.f12216, 0.0f, 150, new C1727());
            }
            MonitorAnimateView.this.f4370.f12212.setVisibility(4);
            C4008.m12877(MonitorAnimateView.this.f4447, 0.0f, 150, null);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ࡡ, reason: contains not printable characters */
    public interface InterfaceC1728 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo4550();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo4551(boolean z);

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo4552();

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo4553(boolean z);

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo4554();

        /* renamed from: Ԭ, reason: contains not printable characters */
        void mo4555();

        /* renamed from: ԭ, reason: contains not printable characters */
        void mo4556(boolean z);
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ࡢ, reason: contains not printable characters */
    public static class C1729 implements MonitorFlagView.InterfaceC1741 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C2494 f4729;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public MonitorAnimateView f4730;

        public C1729(C2494 c2494, MonitorAnimateView monitorAnimateView) {
            this.f4729 = c2494;
            this.f4730 = monitorAnimateView;
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView.InterfaceC1741
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo4557() {
            this.f4730.m4501(this.f4729);
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView.InterfaceC1741
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo4558() {
            LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4729.m9101()).sendAlbumTagEvent(100);
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView.InterfaceC1741
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo4559() {
            LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4729.m9101()).sendAlbumTagEvent(102);
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView.InterfaceC1741
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo4560() {
            LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4729.m9101());
            if (linkEntityByLinkIndex != null) {
                linkEntityByLinkIndex.sendAlbumTagEvent(101);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView.InterfaceC1741
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo4561() {
            int i = this.f4729.m9104() == 0 ? 1 : 0;
            this.f4730.m4473();
            this.f4729.m9162(i);
            if (this.f4730.getChangeListener() != null) {
                this.f4730.getChangeListener().mo4551(i == 1);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView.InterfaceC1741
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo4562(int i) {
            if (i == 1) {
                this.f4729.m9131().setCoverRatioVisible(false);
            } else {
                this.f4729.m9131().setCoverRatioVisible(true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView$ࡣ, reason: contains not printable characters */
    public static class C1730 implements MonitorPlayerControlView.InterfaceC1747 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C2494 f4731;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public MonitorAnimateView f4732;

        public C1730(C2494 c2494, MonitorAnimateView monitorAnimateView) {
            this.f4731 = c2494;
            this.f4732 = monitorAnimateView;
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView.InterfaceC1747
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo4563() {
            LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4731.m9101());
            if (linkEntityByLinkIndex != null) {
                linkEntityByLinkIndex.sendPlayEvent();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView.InterfaceC1747
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo4564() {
            LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4731.m9101());
            if (linkEntityByLinkIndex != null) {
                linkEntityByLinkIndex.sendAlbumControlEvent(-2);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView.InterfaceC1747
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo4565() {
            LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4731.m9101());
            if (linkEntityByLinkIndex != null) {
                linkEntityByLinkIndex.sendAlbumControlEvent(2);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView.InterfaceC1747
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo4566() {
            LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4731.m9101());
            if (linkEntityByLinkIndex != null) {
                linkEntityByLinkIndex.sendAlbumControlEvent(1);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView.InterfaceC1747
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo4567() {
            LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4731.m9101());
            if (linkEntityByLinkIndex != null) {
                linkEntityByLinkIndex.sendAlbumControlEvent(-1);
            }
        }
    }

    public MonitorAnimateView(@NonNull Context context) {
        super(context);
        this.f4379 = 400;
        this.f4404 = new ArrayList();
        this.f4425 = 1;
        this.f4448 = new C2494();
        this.f4449 = new C2494();
        this.f4450 = new C2494();
        this.f4451 = new C2494();
        this.f4455 = new ArrayList();
        this.f4465 = false;
        this.f4534 = 0.9f;
        this.f4368 = new ArrayList();
        this.f4369 = new ArrayList();
        this.f4380 = 10001;
        this.f4365 = 10002;
        this.f4366 = 10003;
        this.f4367 = new WeakHandler(new C1705());
        this.f4424 = true;
        this.f4423 = false;
        this.f4364 = 1;
        this.f4422 = -1;
        m4488();
    }

    private int getRecordStatus() {
        int i = this.f4425;
        if (i == 1) {
            return m4479(this.f4452.m9101(), this.f4452.m9140());
        }
        if (i == 2) {
            return m4479(this.f4453.m9101(), this.f4453.m9140()) | m4479(this.f4454.m9101(), this.f4454.m9140());
        }
        if (i != 3) {
            return 0;
        }
        int iM4479 = m4479(0, this.f4448.m9140());
        int iM44792 = m4479(1, this.f4449.m9140());
        return iM4479 | iM44792 | m4479(2, this.f4450.m9140()) | m4479(3, this.f4451.m9140());
    }

    private void setTextureParentChildrenSize(View view) {
        m4538(view, this.f4397, this.f4398, this.f4406, this.f4407);
    }

    public List<ACUnitView> getACUnitViewList() {
        return this.f4404;
    }

    public InterfaceC1728 getChangeListener() {
        return this.f4363;
    }

    public int getCurrentSelectType() {
        return this.f4425;
    }

    public void setOnChangeListener(InterfaceC1728 interfaceC1728) {
        this.f4363 = interfaceC1728;
    }

    /* renamed from: ࡩ, reason: contains not printable characters */
    public final void m4460(boolean z, View view, int i, AbstractC4012 abstractC4012) {
        view.setAlpha(z ? 1.0f : 0.0f);
    }

    /* renamed from: ࡪ, reason: contains not printable characters */
    public final void m4461(boolean z, View view, AbstractC4012 abstractC4012) {
        m4460(z, view, 100, abstractC4012);
    }

    /* renamed from: ࢠ, reason: contains not printable characters */
    public final void m4462(CloudPlayerConnectView cloudPlayerConnectView, int i, int i2, int i3) {
        C4008.m12886(cloudPlayerConnectView, i, i2, i3, null);
    }

    /* renamed from: ࢡ, reason: contains not printable characters */
    public final void m4463(View view, int i, int i2, int i3, int i4) {
        C4008.m12886(view, (i3 - this.f4406) - ((this.f4397 - i) / 2.0f), (i4 - this.f4407) - ((this.f4398 - i2) / 2.0f), 0, null);
    }

    /* renamed from: ࢢ, reason: contains not printable characters */
    public final void m4464(MonitorParentView monitorParentView, int i, int i2, int i3, int i4) {
        monitorParentView.m4595(i, i2);
        C4008.m12886(monitorParentView, i3, i4, 0, null);
        monitorParentView.setProgressBarScale((i * 1.0f) / this.f4397);
    }

    /* renamed from: ࢣ, reason: contains not printable characters */
    public final void m4465(MonitorTextureGroupView monitorTextureGroupView, int i, int i2, int i3, int i4) {
        C4008.m12884(monitorTextureGroupView, (i * 1.0f) / this.f4397, (i2 * 1.0f) / this.f4398, 0, null);
        C4008.m12886(monitorTextureGroupView, i3, i4, 0, null);
    }

    /* renamed from: ࢤ, reason: contains not printable characters */
    public final void m4466() throws InterruptedException, Resources.NotFoundException {
        C2494 c2494;
        boolean z = FinderManager.getInstance().machineCanConnect("1") > 0;
        boolean z2 = FinderManager.getInstance().machineCanConnect("2") > 0;
        boolean z3 = FinderManager.getInstance().machineCanConnect(FinderManager.MACHINE_C) > 0;
        boolean z4 = FinderManager.getInstance().machineCanConnect(FinderManager.MACHINE_D) > 0;
        if (this.f4465) {
            return;
        }
        int i = this.f4425;
        if (i == 1) {
            int iM9091 = this.f4452.m9091();
            if (iM9091 != -2) {
                if (iM9091 >= 0) {
                    if (FinderManager.getInstance().machineCanConnect(m4480(this.f4452.m9101())) < 0) {
                        int iM4476 = m4476(this.f4452.m9101(), z, z2, z3, z4);
                        this.f4452.m9158(iM4476);
                        m4472(this.f4452);
                        m4535(this.f4452, iM4476);
                        if (this.f4466) {
                            C2494 c24942 = this.f4454;
                            if (c24942 != null) {
                                c24942.m9146(-2);
                                return;
                            }
                            return;
                        }
                        C2494 c24943 = this.f4453;
                        if (c24943 != null) {
                            c24943.m9146(-2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f4452.m9090().getLinkIndex() == -1) {
                int iM4474 = m4474(z, z2, z3, z4);
                if (iM4474 != -1) {
                    this.f4452.m9158(iM4474);
                    m4534(this.f4452, iM4474);
                    if (this.f4466) {
                        C2494 c24944 = this.f4454;
                        if (c24944 != null) {
                            c24944.m9146(-2);
                            return;
                        }
                        return;
                    }
                    C2494 c24945 = this.f4453;
                    if (c24945 != null) {
                        c24945.m9146(-2);
                        return;
                    }
                    return;
                }
                return;
            }
            int linkIndex = this.f4452.m9090().getLinkIndex();
            boolean z5 = FinderManager.getInstance().machineCanConnect(m4480(linkIndex)) > 0;
            if (linkIndex == -1 || z5) {
                return;
            }
            int iM44762 = m4476(linkIndex, z, z2, z3, z4);
            this.f4452.m9158(iM44762);
            m4472(this.f4452);
            m4535(this.f4452, iM44762);
            if (this.f4466) {
                C2494 c24946 = this.f4454;
                if (c24946 != null) {
                    c24946.m9146(-2);
                    return;
                }
                return;
            }
            C2494 c24947 = this.f4453;
            if (c24947 != null) {
                c24947.m9146(-2);
                return;
            }
            return;
        }
        if (i != 2) {
            if (i == 3) {
                C2494 c2494M4483 = m4483(0);
                C2494 c2494M44832 = m4483(1);
                C2494 c2494M44833 = m4483(2);
                C2494 c2494M44834 = m4483(3);
                if (z) {
                    if (c2494M4483 != null) {
                        m4534(c2494M4483, 0);
                    }
                    if (this.f4370.f12182.getAlpha() != 1.0f) {
                        this.f4370.f12182.setAlpha(1.0f);
                    }
                } else {
                    if (this.f4370.f12182.getAlpha() != 1.0f) {
                        this.f4370.f12182.setAlpha(1.0f);
                    }
                    if (c2494M4483 != null) {
                        m4472(c2494M4483);
                        c2494M4483.m9131().getAcUnitView().setTextureCanRender(false);
                        m4504(c2494M4483, 0);
                    }
                }
                if (z2) {
                    if (c2494M44832 != null) {
                        m4534(c2494M44832, 1);
                    }
                    if (this.f4370.f12183.getAlpha() != 1.0f) {
                        this.f4370.f12183.setAlpha(1.0f);
                    }
                } else {
                    if (this.f4370.f12183.getAlpha() != 1.0f) {
                        this.f4370.f12183.setAlpha(1.0f);
                    }
                    if (c2494M44832 != null) {
                        m4472(c2494M44832);
                        c2494M44832.m9131().getAcUnitView().setTextureCanRender(false);
                        m4504(c2494M44832, 1);
                    }
                }
                if (z3) {
                    if (c2494M44833 != null) {
                        m4534(c2494M44833, 2);
                    }
                    if (this.f4370.f12184.getAlpha() != 1.0f) {
                        this.f4370.f12184.setAlpha(1.0f);
                    }
                } else {
                    if (this.f4370.f12184.getAlpha() != 1.0f) {
                        this.f4370.f12184.setAlpha(1.0f);
                    }
                    if (c2494M44833 != null) {
                        m4472(c2494M44833);
                        c2494M44833.m9131().getAcUnitView().setTextureCanRender(false);
                        m4504(c2494M44833, 2);
                    }
                }
                if (z4) {
                    if (c2494M44834 != null) {
                        m4534(c2494M44834, 3);
                    }
                    if (this.f4370.f12185.getAlpha() != 1.0f) {
                        this.f4370.f12185.setAlpha(1.0f);
                        return;
                    }
                    return;
                }
                if (this.f4370.f12185.getAlpha() != 1.0f) {
                    this.f4370.f12185.setAlpha(1.0f);
                }
                if (c2494M44834 != null) {
                    m4472(c2494M44834);
                    c2494M44834.m9131().getAcUnitView().setTextureCanRender(false);
                    m4504(c2494M44834, 3);
                    return;
                }
                return;
            }
            return;
        }
        C2494 c24948 = this.f4453;
        C2494 c24949 = this.f4454;
        if (c24948.m9091() != -2) {
            c2494 = c24949;
            if (c24948.m9091() >= 0) {
                if (!(FinderManager.getInstance().machineCanConnect(m4480(this.f4453.m9101())) > 0)) {
                    int iM4475 = m4475(this.f4454.m9101(), z, z2, z3, z4);
                    this.f4453.m9158(iM4475);
                    m4472(this.f4453);
                    m4535(this.f4453, iM4475);
                    this.f4453.m9146(-2);
                }
            }
        } else if (c24948.m9090().getLinkIndex() == -1) {
            c2494 = c24949;
            int iM44752 = m4475(c24949.m9101(), z, z2, z3, z4);
            if (iM44752 != -1) {
                c24948.m9158(iM44752);
                m4534(c24948, iM44752);
                c24948.m9146(-2);
            }
        } else {
            c2494 = c24949;
            int linkIndex2 = c24948.m9090().getLinkIndex();
            boolean z6 = FinderManager.getInstance().machineCanConnect(m4480(linkIndex2)) > 0;
            if (linkIndex2 != -1 && !z6) {
                int iM44753 = m4475(c2494.m9101(), z, z2, z3, z4);
                c24948.m9158(iM44753);
                this.f4453 = c24948;
                m4472(c24948);
                m4535(c24948, iM44753);
                c24948.m9146(-2);
            }
        }
        if (c2494.m9091() != -2) {
            C2494 c249410 = c2494;
            if (c249410.m9091() >= 0) {
                if (FinderManager.getInstance().machineCanConnect(m4480(c249410.m9101())) > 0) {
                    return;
                }
                int iM44754 = m4475(c24948.m9101(), z, z2, z3, z4);
                c249410.m9158(iM44754);
                m4472(c249410);
                m4535(c249410, iM44754);
                c249410.m9146(-2);
                return;
            }
            return;
        }
        if (c2494.m9090().getLinkIndex() == -1) {
            this.f4454 = c2494;
            int iM44755 = m4475(this.f4453.m9101(), z, z2, z3, z4);
            if (iM44755 != -1) {
                this.f4454.m9158(iM44755);
                m4534(this.f4454, iM44755);
                this.f4454.m9146(-2);
                return;
            }
            return;
        }
        C2494 c249411 = c2494;
        int linkIndex3 = c249411.m9090().getLinkIndex();
        if ((FinderManager.getInstance().machineCanConnect(m4480(linkIndex3)) > 0) || linkIndex3 == -1) {
            return;
        }
        int iM44756 = m4475(c24948.m9101(), z, z2, z3, z4);
        c249411.m9158(iM44756);
        m4472(c249411);
        m4535(c249411, iM44756);
        c249411.m9146(-2);
    }

    /* renamed from: ࢥ, reason: contains not printable characters */
    public final void m4467(ConstraintLayout constraintLayout) {
        if (constraintLayout != null) {
            constraintLayout.bringToFront();
            if (constraintLayout.getParent() != null) {
                constraintLayout.getParent().requestLayout();
                constraintLayout.invalidate();
            }
        }
    }

    /* renamed from: ࢦ, reason: contains not printable characters */
    public final void m4468(int i, LinkEntity linkEntity) {
        String str;
        String str2;
        String str3;
        String cityCNT;
        if (linkEntity.isCloudCameraLink()) {
            String rRoomId = linkEntity.getRRoomId();
            ACCameraInfoBean acCameraInfoBean = linkEntity.getAcCameraInfoBean();
            if (acCameraInfoBean != null) {
                String netType = acCameraInfoBean.getNetType();
                String cityCN = acCameraInfoBean.getCityCN();
                String cityEN = acCameraInfoBean.getCityEN();
                cityCNT = acCameraInfoBean.getCityCNT();
                str = netType;
                str3 = cityCN;
                str2 = cityEN;
            } else {
                str = "";
                str2 = str;
                str3 = str2;
                cityCNT = str3;
            }
            int i2 = this.f4425;
            if (i2 == 1) {
                C2494 c2494 = this.f4452;
                if (c2494 != null && c2494.m9101() == i) {
                    this.f4452.m9094().setVisibility(0);
                    this.f4452.m9094().m4222(rRoomId, str, linkEntity.getLinkStatus(), str2, str3, cityCNT);
                    return;
                }
                return;
            }
            if (i2 != 2) {
                C2494 c2494M4483 = m4483(i);
                if (c2494M4483 == null) {
                    return;
                }
                c2494M4483.m9094().setVisibility(0);
                c2494M4483.m9094().m4222(rRoomId, str, linkEntity.getLinkStatus(), str2, str3, cityCNT);
                return;
            }
            List<C2494> listM4484 = m4484(i);
            if (r1.m8144(listM4484)) {
                for (int i3 = 0; i3 < listM4484.size(); i3++) {
                    C2494 c24942 = listM4484.get(i3);
                    c24942.m9094().setVisibility(0);
                    c24942.m9094().m4222(rRoomId, str, linkEntity.getLinkStatus(), str2, str3, cityCNT);
                }
            }
        }
    }

    /* renamed from: ࢧ, reason: contains not printable characters */
    public final void m4469(C2494 c2494, int i) throws InterruptedException, Resources.NotFoundException {
        ACUnitView aCUnitViewM9090 = c2494.m9090();
        aCUnitViewM9090.setTextureCanRender(false);
        aCUnitViewM9090.clearTexture();
        aCUnitViewM9090.setLinkIndex(i);
        m4504(c2494, i);
        c2494.m9088();
        if (C2579.m9451(getContext()) || this.f4370.f12170.getVisibility() == 0) {
            return;
        }
        this.f4370.f12170.setVisibility(0);
    }

    /* renamed from: ࢨ, reason: contains not printable characters */
    public final void m4470(int i, int i2, LinkEntity linkEntity) {
        int i3 = this.f4425;
        if (i3 == 1) {
            C2494 c2494 = this.f4452;
            if (c2494 != null && c2494.m9101() == i) {
                m4471(this.f4452, i2, linkEntity);
                m4525(this.f4452, linkEntity);
                return;
            }
            return;
        }
        if (i3 != 2) {
            C2494 c2494M4483 = m4483(i);
            if (c2494M4483 == null) {
                return;
            }
            m4471(c2494M4483, i2, linkEntity);
            m4525(c2494M4483, linkEntity);
            return;
        }
        List<C2494> listM4484 = m4484(i);
        if (r1.m8144(listM4484)) {
            for (int i4 = 0; i4 < listM4484.size(); i4++) {
                C2494 c24942 = listM4484.get(i4);
                m4471(c24942, i2, linkEntity);
                m4525(c24942, linkEntity);
            }
        }
    }

    /* renamed from: ࢩ, reason: contains not printable characters */
    public final void m4471(C2494 c2494, int i, LinkEntity linkEntity) {
        boolean z;
        InterfaceC1728 interfaceC1728;
        int iM9133 = c2494.m9133();
        if (c2494.m9138() && c2494.m9110() != i && c2494.m9102() != 0 && System.currentTimeMillis() - c2494.m9102() > 3000) {
            c2494.m9169(i);
        }
        if (iM9133 != i) {
            c2494.m9090().setTextureCanRender(true);
            if (c2494.m9138() && c2494.m9111() != null) {
                this.f4367.removeMessages(10001, c2494);
            }
            c2494.m9145(false);
            c2494.m9160(0L);
            c2494.m9170(null);
            if (i == 1) {
                m4513(c2494, true);
            } else {
                m4524(c2494, false);
            }
            c2494.m9197(i);
        }
        if (this.f4425 == 1 && (interfaceC1728 = this.f4363) != null) {
            interfaceC1728.mo4556(i != 1);
        }
        if (!C2579.m9451(getContext())) {
            if (this.f4425 == 1) {
                if (i != 1) {
                    if (this.f4370.f12170.getVisibility() != 0) {
                        this.f4370.f12170.setVisibility(0);
                    }
                } else if (this.f4370.f12170.getVisibility() != 8) {
                    this.f4370.f12170.setVisibility(8);
                }
            } else if (this.f4370.f12170.getVisibility() != 0) {
                this.f4370.f12170.setVisibility(0);
            }
        }
        if (linkEntity.getAcCameraInfoBean() != null) {
            ACCameraInfoBean acCameraInfoBean = linkEntity.getAcCameraInfoBean();
            String[] controlable = acCameraInfoBean.getControlable();
            if (controlable == null || controlable.length <= 0) {
                z = false;
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= controlable.length) {
                        break;
                    }
                    if (!e5.m5988().m5991().equals(controlable[i2])) {
                        i2++;
                    } else if (LinkManager.getInstance().isControllable()) {
                        z = true;
                    }
                }
                z = false;
            }
            boolean recording = acCameraInfoBean.getRecording();
            boolean zM9143 = c2494.m9143();
            c2494.m9186(recording);
            if (!z) {
                if (c2494.m9140()) {
                    c2494.m9156(false);
                    c2494.m9108().m4583(i, false);
                    c2494.m9114().m4612(3);
                    return;
                }
                return;
            }
            if (c2494.m9140() && iM9133 == i && zM9143 == recording) {
                return;
            }
            if (i == 0) {
                c2494.m9156(true);
                c2494.m9108().m4583(0, !recording);
            } else if (i == 1) {
                c2494.m9156(true);
                c2494.m9108().m4583(1, true);
                if (this.f4425 == 1) {
                    c2494.m9108().m4581(true, 0, true);
                }
                c2494.m9114().m4612(acCameraInfoBean.getAlbumControlable());
            }
        }
    }

    /* renamed from: ࢪ, reason: contains not printable characters */
    public final void m4472(C2494 c2494) {
        if (c2494 != null) {
            float fM9119 = c2494.m9119();
            float fM9106 = c2494.m9106();
            boolean zM9141 = c2494.m9141();
            c2494.m9131().getRatioCoverView().m2400();
            if (fM9119 != 1.7777778f || fM9106 != 1.7777778f || zM9141) {
                MonitorTextureGroupView monitorTextureGroupViewM9131 = c2494.m9131();
                monitorTextureGroupViewM9131.m4635(1.7777778f, 1.7777778f, false);
                monitorTextureGroupViewM9131.m4637(100, false, false);
                monitorTextureGroupViewM9131.m4636(C4792.m14375().m14413(), 0);
                c2494.m9179(1.7777778f);
                c2494.m9164(1.7777778f);
                c2494.m9168(false);
                c2494.m9192(false);
                c2494.m9193(100);
            }
            c2494.m9100().m4596(false);
        }
    }

    /* renamed from: ࢫ, reason: contains not printable characters */
    public void m4473() {
        this.f4448.m9162(0);
        this.f4449.m9162(0);
        this.f4450.m9162(0);
        this.f4451.m9162(0);
    }

    /* renamed from: ࢬ, reason: contains not printable characters */
    public final int m4474(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z) {
            return 0;
        }
        if (z2) {
            return 1;
        }
        if (z3) {
            return 2;
        }
        return z4 ? 3 : -1;
    }

    /* renamed from: ࢭ, reason: contains not printable characters */
    public final int m4475(int i, boolean z, boolean z2, boolean z3, boolean z4) {
        if (i != 0 && z) {
            return 0;
        }
        if (i != 1 && z2) {
            return 1;
        }
        if (i == 2 || !z3) {
            return (i == 3 || !z4) ? -1 : 3;
        }
        return 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
    
        if (r8 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0020, code lost:
    
        if (r9 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002b, code lost:
    
        if (r9 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0038, code lost:
    
        if (r9 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return 3;
     */
    /* renamed from: ࢮ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m4476(int r5, boolean r6, boolean r7, boolean r8, boolean r9) {
        /*
            r4 = this;
            r0 = 0
            r1 = 3
            r2 = 2
            r3 = 1
            if (r5 == 0) goto L2e
            if (r5 == r3) goto L23
            if (r5 == r2) goto L18
            if (r5 == r1) goto Ld
            goto L3c
        Ld:
            if (r9 != 0) goto L3c
            if (r6 == 0) goto L12
            goto L3d
        L12:
            if (r7 == 0) goto L15
            goto L32
        L15:
            if (r8 == 0) goto L3c
            goto L36
        L18:
            if (r8 != 0) goto L3c
            if (r6 == 0) goto L1d
            goto L3d
        L1d:
            if (r7 == 0) goto L20
            goto L32
        L20:
            if (r9 == 0) goto L3c
            goto L2d
        L23:
            if (r7 != 0) goto L3c
            if (r6 == 0) goto L28
            goto L3d
        L28:
            if (r8 == 0) goto L2b
            goto L36
        L2b:
            if (r9 == 0) goto L3c
        L2d:
            goto L3a
        L2e:
            if (r6 != 0) goto L3c
            if (r7 == 0) goto L34
        L32:
            r0 = r3
            goto L3d
        L34:
            if (r8 == 0) goto L38
        L36:
            r0 = r2
            goto L3d
        L38:
            if (r9 == 0) goto L3c
        L3a:
            r0 = r1
            goto L3d
        L3c:
            r0 = -1
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.m4476(int, boolean, boolean, boolean, boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x02b2  */
    /* renamed from: ࢯ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m4477(defpackage.C2494 r21) throws java.lang.InterruptedException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 707
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.m4477(ǭ):java.lang.String");
    }

    /* renamed from: ࢰ, reason: contains not printable characters */
    public final float m4478(C2494 c2494) {
        if (c2494 == null) {
            return 1.0f;
        }
        return this.f4440.getPaint().measureText(c2494.m9096());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARN: Type inference failed for: r12v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* renamed from: ࢱ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m4479(int r11, boolean r12) {
        /*
            r10 = this;
            com.blink.academy.film.stream.LinkManager r0 = com.blink.academy.film.stream.LinkManager.getInstance()
            com.blink.academy.film.stream.LinkEntity r0 = r0.getLinkEntityByLinkIndex(r11)
            r1 = 0
            if (r0 == 0) goto Lb9
            com.blink.academy.film.stream.ACCameraInfoBean r2 = r0.getAcCameraInfoBean()
            r3 = 1
            if (r2 == 0) goto La5
            java.lang.String[] r4 = r2.getControlable()
            if (r4 == 0) goto L58
            int r5 = r4.length
            if (r5 <= 0) goto L58
            int r5 = r4.length
            r6 = r1
        L1d:
            if (r6 >= r5) goto L34
            r7 = r4[r6]
            e5 r8 = defpackage.e5.m5988()
            java.lang.String r8 = r8.m5991()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L31
            r4 = r3
            goto L35
        L31:
            int r6 = r6 + 1
            goto L1d
        L34:
            r4 = r1
        L35:
            if (r4 != r3) goto L59
            java.lang.String[] r5 = r2.getBlock()
            if (r5 == 0) goto L59
            int r6 = r5.length
            if (r6 <= 0) goto L59
            int r6 = r5.length
            r7 = r1
        L42:
            if (r7 >= r6) goto L59
            r8 = r5[r7]
            e5 r9 = defpackage.e5.m5988()
            java.lang.String r9 = r9.m5991()
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L55
            goto L58
        L55:
            int r7 = r7 + 1
            goto L42
        L58:
            r4 = r1
        L59:
            boolean r2 = r2.getRecording()
            if (r2 == 0) goto L81
            java.util.List r11 = r10.m4484(r11)
            int r2 = r11.size()
            if (r2 == 0) goto La7
            java.util.Iterator r11 = r11.iterator()
        L6d:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto La7
            java.lang.Object r2 = r11.next()
            ǭ r2 = (defpackage.C2494) r2
            com.blink.academy.film.widgets.transmit.monitor.MonitorParentView r2 = r2.m9100()
            r2.m4596(r3)
            goto L6d
        L81:
            java.util.List r11 = r10.m4484(r11)
            int r12 = r11.size()
            if (r12 == 0) goto La3
            java.util.Iterator r11 = r11.iterator()
        L8f:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto La3
            java.lang.Object r12 = r11.next()
            ǭ r12 = (defpackage.C2494) r12
            com.blink.academy.film.widgets.transmit.monitor.MonitorParentView r12 = r12.m9100()
            r12.m4596(r1)
            goto L8f
        La3:
            r12 = r1
            goto La7
        La5:
            r12 = r1
            r4 = r12
        La7:
            com.blink.academy.film.stream.ACLinkFrameInfoBean r11 = r0.getAcLinkFrameInfoBean()
            if (r11 == 0) goto Lbb
            int r11 = r11.getVideoMode()
            if (r11 != r3) goto Lb4
            goto Lb5
        Lb4:
            r3 = r1
        Lb5:
            if (r3 == 0) goto Lbb
            r4 = r1
            goto Lbb
        Lb9:
            r12 = r1
            r4 = r12
        Lbb:
            com.blink.academy.film.stream.LinkManager r11 = com.blink.academy.film.stream.LinkManager.getInstance()
            boolean r11 = r11.isControllable()
            if (r11 != 0) goto Lc6
            goto Lc7
        Lc6:
            r1 = r4
        Lc7:
            int r11 = com.blink.academy.film.support.socket.TransmitHelper.buildMonitorState(r1, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.m4479(int, boolean):int");
    }

    /* renamed from: ࢲ, reason: contains not printable characters */
    public final String m4480(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "" : FinderManager.MACHINE_D : FinderManager.MACHINE_C : "2" : "1";
    }

    /* renamed from: ࢳ, reason: contains not printable characters */
    public final float m4481(ACCameraInfoBean aCCameraInfoBean) {
        return ACHelper.getInstance().getRealRatioByRatioIndex(aCCameraInfoBean.getRatio(), aCCameraInfoBean.getStreamType());
    }

    /* renamed from: ࢴ, reason: contains not printable characters */
    public final String m4482(LinkEntity linkEntity) {
        ACCameraInfoBean acCameraInfoBean;
        if (linkEntity == null || (acCameraInfoBean = linkEntity.getAcCameraInfoBean()) == null || m4499(acCameraInfoBean)) {
            return "";
        }
        int cameraType = acCameraInfoBean.getCameraType();
        StringBuilder sb = new StringBuilder();
        String dimension = acCameraInfoBean.getDimension();
        String strM7892 = p3.m7891().m7892(cameraType);
        String fps = acCameraInfoBean.getFps();
        String pixelFormatStr = linkEntity.getAcLinkFrameInfoBean() != null ? ACHelper.getInstance().getPixelFormatStr(acCameraInfoBean.getPixelFormat()) : "";
        if (r1.m8143(dimension) && r1.m8143(fps) && r1.m8143(strM7892)) {
            sb.append(MyUTIL.white_space + dimension);
            sb.append(" / ");
            sb.append(fps + " FPS");
            sb.append(" / ");
            if (r1.m8143(pixelFormatStr)) {
                sb.append(pixelFormatStr);
                sb.append(" / ");
            }
            sb.append(strM7892);
        }
        return sb.toString();
    }

    /* renamed from: ࢶ, reason: contains not printable characters */
    public final C2494 m4483(int i) {
        for (int i2 = 0; i2 < this.f4455.size(); i2++) {
            if (this.f4455.get(i2).m9090().getLinkIndex() == i) {
                return this.f4455.get(i2);
            }
        }
        return null;
    }

    /* renamed from: ࢷ, reason: contains not printable characters */
    public List<C2494> m4484(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f4455.size(); i2++) {
            if (this.f4455.get(i2).m9090().getLinkIndex() == i) {
                arrayList.add(this.f4455.get(i2));
            }
        }
        return arrayList;
    }

    /* renamed from: ࢸ, reason: contains not printable characters */
    public final C2494 m4485(C2494 c2494) {
        for (int i = 0; i < this.f4455.size(); i++) {
            C2494 c24942 = this.f4455.get(i);
            if (c24942 != c2494) {
                return c24942;
            }
        }
        return this.f4455.get(0);
    }

    /* renamed from: ࢹ, reason: contains not printable characters */
    public final String m4486(String str) {
        if (!r1.m8143(str)) {
            return "";
        }
        return MyUTIL.white_space + str + MyUTIL.white_space;
    }

    /* renamed from: ࢺ, reason: contains not printable characters */
    public final int m4487(LinkEntity linkEntity) {
        ACCameraInfoBean acCameraInfoBean;
        if (linkEntity == null || (acCameraInfoBean = linkEntity.getAcCameraInfoBean()) == null) {
            return 4;
        }
        return ACHelper.getInstance().getWifiViewLevel(acCameraInfoBean.getWifiStatus());
    }

    /* renamed from: ࢻ, reason: contains not printable characters */
    public final void m4488() {
        this.f4370 = AbstractC3491.m11410(LayoutInflater.from(getContext()), this, true);
        m4491();
        m4492();
    }

    /* renamed from: ࢼ, reason: contains not printable characters */
    public final void m4489() {
        this.f4404.clear();
        this.f4404.add(this.f4427.getAcUnitView());
        this.f4404.add(this.f4428.getAcUnitView());
        this.f4404.add(this.f4429.getAcUnitView());
        this.f4404.add(this.f4430.getAcUnitView());
    }

    /* renamed from: ࢽ, reason: contains not printable characters */
    public final void m4490() throws InterruptedException, Resources.NotFoundException {
        C2494 c2494M4485;
        C2494 c2494M44852;
        boolean z;
        C4008.m12877(this.f4370.f12188, 0.0f, 0, null);
        C4008.m12877(this.f4370.f12182, 0.0f, 0, null);
        C4008.m12877(this.f4370.f12183, 0.0f, 0, null);
        C4008.m12877(this.f4370.f12184, 0.0f, 0, null);
        C4008.m12877(this.f4370.f12185, 0.0f, 0, null);
        if (C2579.m9451(getContext())) {
            this.f4448.m9090().setInSingle(false);
            this.f4449.m9090().setInSingle(false);
            this.f4450.m9090().setInSingle(false);
            this.f4451.m9090().setInSingle(false);
        }
        int i = this.f4425;
        if (i != 1) {
            if (i == 3) {
                c2494M4485 = this.f4453;
                if (c2494M4485 == null) {
                    c2494M4485 = this.f4454;
                    if (c2494M4485 == null) {
                        c2494M44852 = this.f4452;
                        c2494M4485 = m4485(c2494M44852);
                    } else {
                        c2494M44852 = m4485(c2494M4485);
                    }
                } else {
                    C2494 c2494M44853 = this.f4454;
                    if (c2494M44853 == null) {
                        c2494M44853 = m4485(c2494M4485);
                    } else if (c2494M4485 == c2494M44853) {
                    }
                    C2494 c2494 = c2494M44853;
                    c2494M44852 = c2494M4485;
                    c2494M4485 = c2494;
                }
            } else {
                c2494M4485 = null;
            }
            c2494M44852 = c2494M4485;
        } else if (this.f4466) {
            c2494M4485 = this.f4452;
            c2494M44852 = this.f4453;
            if (c2494M44852 == null) {
                c2494M44852 = m4485(c2494M4485);
            } else if (c2494M4485 == c2494M44852) {
                c2494M44852 = this.f4454;
                c2494M44852.m9158(c2494M44852.m9101());
                if (c2494M44852.m9101() != -1) {
                    if (FinderManager.getInstance().machineCanConnect(m4480(c2494M44852.m9101())) > 0) {
                        m4534(c2494M44852, c2494M44852.m9101());
                    }
                }
            } else if (c2494M44852.m9101() != -1) {
                if (FinderManager.getInstance().machineCanConnect(m4480(c2494M44852.m9101())) > 0) {
                    m4534(c2494M44852, c2494M44852.m9101());
                }
            }
        } else {
            c2494M44852 = this.f4452;
            c2494M4485 = this.f4454;
            if (c2494M4485 == null) {
                c2494M4485 = m4485(c2494M44852);
            } else if (c2494M44852 == c2494M4485) {
                c2494M4485 = this.f4453;
                c2494M4485.m9158(c2494M4485.m9101());
                if (c2494M4485.m9101() != -1) {
                    if (FinderManager.getInstance().machineCanConnect(m4480(c2494M4485.m9101())) > 0) {
                        m4534(c2494M4485, c2494M4485.m9101());
                    }
                }
            } else if (c2494M4485.m9101() != -1) {
                if (FinderManager.getInstance().machineCanConnect(m4480(c2494M4485.m9101())) > 0) {
                    m4534(c2494M4485, c2494M4485.m9101());
                }
            }
        }
        if (c2494M44852 != null) {
            if (!(FinderManager.getInstance().machineCanConnect(m4480(c2494M44852.m9101())) > 0)) {
                m4534(c2494M44852, -1);
                c2494M44852.m9158(-1);
            }
            if (c2494M44852.m9139()) {
                c2494M44852.m9108().setVisibility(4);
                c2494M44852.m9114().setVisibility(4);
                c2494M44852.m9118().setVisibility(0);
            } else {
                c2494M44852.m9109().setVisibility(0);
                c2494M44852.m9114().setVisibility(0);
            }
        }
        if (c2494M4485 != null) {
            if (!(FinderManager.getInstance().machineCanConnect(m4480(c2494M4485.m9101())) > 0)) {
                m4534(c2494M4485, -1);
                c2494M4485.m9158(-1);
            }
            if (c2494M4485.m9139()) {
                c2494M4485.m9108().setVisibility(4);
                c2494M4485.m9114().setVisibility(4);
                c2494M4485.m9118().setVisibility(0);
            } else {
                c2494M4485.m9109().setVisibility(0);
                c2494M4485.m9114().setVisibility(0);
            }
        }
        this.f4453 = c2494M44852;
        this.f4454 = c2494M4485;
        this.f4466 = false;
        this.f4452 = c2494M44852;
        m4467(c2494M44852.m9129());
        m4467(this.f4454.m9129());
        float fM4478 = m4478(c2494M44852);
        float fM44782 = m4478(c2494M4485);
        int iMax = (int) Math.max(Math.ceil(fM4478 / (this.f4381 * this.f4534)), 1.0d);
        int iMax2 = (int) Math.max(Math.ceil(fM44782 / (this.f4381 * this.f4534)), 1.0d);
        if (c2494M44852.m9099() == iMax && c2494M4485.m9099() == iMax2) {
            z = false;
        } else {
            for (int i2 = 0; i2 < this.f4455.size(); i2++) {
                C2494 c24942 = this.f4455.get(i2);
                if (c24942 == this.f4453 || c24942 == this.f4454) {
                    C4008.m12877(c24942.m9098(), 0.0f, 100, null);
                }
                c24942.m9155(Math.max(iMax, iMax2));
            }
            z = true;
        }
        this.f4425 = 2;
        c2494M44852.m9131();
        LineFeedTextView lineFeedTextViewM9098 = c2494M44852.m9098();
        c2494M44852.m9100();
        c2494M44852.m9128();
        c2494M44852.m9090();
        c2494M4485.m9131();
        LineFeedTextView lineFeedTextViewM90982 = c2494M4485.m9098();
        c2494M4485.m9100();
        c2494M4485.m9128();
        c2494M4485.m9090();
        lineFeedTextViewM9098.postDelayed(new RunnableC1656(lineFeedTextViewM9098, lineFeedTextViewM90982, z, new long[]{0}), z ? 100L : 0L);
        if (z) {
            m4543(this.f4453, this.f4454, 0.0f, 0);
        }
        if (!C2579.m9451(getContext())) {
            m4545(this.f4370.f12170, this.f4420, this.f4421, 400);
        }
        this.f4448.m9108().m4577(false, true);
        this.f4449.m9108().m4577(false, true);
        this.f4450.m9108().m4577(false, true);
        this.f4451.m9108().m4577(false, true);
    }

    /* renamed from: ࢾ, reason: contains not printable characters */
    public final void m4491() {
        ConstraintLayout.LayoutParams layoutParams;
        int iM14480;
        ConstraintLayout.LayoutParams layoutParams2;
        m4496();
        setPadding(this.f4399, 0, 0, 0);
        this.f4440 = new LineFeedTextView(getContext());
        this.f4441 = new LineFeedTextView(getContext());
        this.f4442 = new LineFeedTextView(getContext());
        this.f4443 = new LineFeedTextView(getContext());
        this.f4444 = new ExtendView(getContext());
        this.f4445 = new ExtendView(getContext());
        this.f4446 = new ExtendView(getContext());
        this.f4447 = new ExtendView(getContext());
        this.f4444.setOnCallback(new C1660());
        this.f4445.setOnCallback(new C1675());
        this.f4446.setOnCallback(new C1686());
        this.f4447.setOnCallback(new C1703());
        if (C2579.m9452(getContext())) {
            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4370.f12178.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams3).height = -1;
            this.f4370.f12178.setLayoutParams(layoutParams3);
        }
        this.f4427 = new MonitorTextureGroupView(getContext());
        this.f4428 = new MonitorTextureGroupView(getContext());
        this.f4429 = new MonitorTextureGroupView(getContext());
        this.f4430 = new MonitorTextureGroupView(getContext());
        this.f4427.setPivotX(0.0f);
        this.f4427.setPivotY(0.0f);
        this.f4428.setPivotX(0.0f);
        this.f4428.setPivotY(0.0f);
        this.f4429.setPivotX(0.0f);
        this.f4429.setPivotY(0.0f);
        this.f4430.setPivotX(0.0f);
        this.f4430.setPivotY(0.0f);
        this.f4370.f12213.setPivotX(1.0f);
        this.f4370.f12213.setPivotY(1.0f);
        this.f4370.f12214.setPivotX(1.0f);
        this.f4370.f12214.setPivotY(1.0f);
        this.f4370.f12215.setPivotX(1.0f);
        this.f4370.f12215.setPivotY(1.0f);
        this.f4370.f12216.setPivotX(1.0f);
        this.f4370.f12216.setPivotY(1.0f);
        this.f4427.m4635(1.7777778f, 1.7777778f, false);
        this.f4428.m4635(1.7777778f, 1.7777778f, false);
        this.f4429.m4635(1.7777778f, 1.7777778f, false);
        this.f4430.m4635(1.7777778f, 1.7777778f, false);
        this.f4427.m4637(100, false, false);
        this.f4428.m4637(100, false, false);
        this.f4429.m4637(100, false, false);
        this.f4430.m4637(100, false, false);
        this.f4427.m4634(this.f4397, this.f4398);
        this.f4428.m4634(this.f4397, this.f4398);
        this.f4429.m4634(this.f4397, this.f4398);
        this.f4430.m4634(this.f4397, this.f4398);
        this.f4431 = new MonitorParentView(getContext());
        this.f4432 = new MonitorParentView(getContext());
        this.f4433 = new MonitorParentView(getContext());
        this.f4434 = new MonitorParentView(getContext());
        this.f4431.m4594(this.f4397, C2579.m9438(2.0f));
        this.f4432.m4594(this.f4397, C2579.m9438(2.0f));
        this.f4433.m4594(this.f4397, C2579.m9438(2.0f));
        this.f4434.m4594(this.f4397, C2579.m9438(2.0f));
        this.f4435 = new ConstraintLayout(getContext());
        this.f4436 = new ConstraintLayout(getContext());
        this.f4437 = new ConstraintLayout(getContext());
        this.f4438 = new ConstraintLayout(getContext());
        this.f4435.setId(View.generateViewId());
        this.f4436.setId(View.generateViewId());
        this.f4437.setId(View.generateViewId());
        this.f4438.setId(View.generateViewId());
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams4.leftToLeft = this.f4435.getId();
        layoutParams4.rightToRight = this.f4435.getId();
        layoutParams4.bottomToBottom = this.f4435.getId();
        layoutParams4.topToTop = this.f4435.getId();
        this.f4440.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams5.leftToLeft = this.f4436.getId();
        layoutParams5.rightToRight = this.f4436.getId();
        layoutParams5.bottomToBottom = this.f4436.getId();
        layoutParams5.topToTop = this.f4436.getId();
        this.f4441.setLayoutParams(layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams6.leftToLeft = this.f4437.getId();
        layoutParams6.rightToRight = this.f4437.getId();
        layoutParams6.bottomToBottom = this.f4437.getId();
        layoutParams6.topToTop = this.f4437.getId();
        this.f4442.setLayoutParams(layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams7.leftToLeft = this.f4438.getId();
        layoutParams7.rightToRight = this.f4438.getId();
        layoutParams7.bottomToBottom = this.f4438.getId();
        layoutParams7.topToTop = this.f4438.getId();
        this.f4443.setLayoutParams(layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams8.leftToLeft = this.f4435.getId();
        layoutParams8.rightToRight = this.f4435.getId();
        layoutParams8.bottomToBottom = this.f4435.getId();
        layoutParams8.topToTop = this.f4435.getId();
        this.f4444.setLayoutParams(layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams9.leftToLeft = this.f4436.getId();
        layoutParams9.rightToRight = this.f4436.getId();
        layoutParams9.bottomToBottom = this.f4436.getId();
        layoutParams9.topToTop = this.f4436.getId();
        this.f4445.setLayoutParams(layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams10.leftToLeft = this.f4437.getId();
        layoutParams10.rightToRight = this.f4437.getId();
        layoutParams10.topToBottom = this.f4442.getId();
        layoutParams10.bottomToBottom = this.f4437.getId();
        layoutParams10.topToTop = this.f4437.getId();
        this.f4446.setLayoutParams(layoutParams10);
        ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams11.leftToLeft = this.f4438.getId();
        layoutParams11.rightToRight = this.f4438.getId();
        layoutParams11.topToBottom = this.f4443.getId();
        layoutParams11.bottomToBottom = this.f4438.getId();
        layoutParams11.topToTop = this.f4438.getId();
        this.f4447.setLayoutParams(layoutParams11);
        this.f4444.setVisibility(4);
        this.f4445.setVisibility(4);
        this.f4446.setVisibility(4);
        this.f4447.setVisibility(4);
        this.f4440.setGravity(17);
        this.f4441.setGravity(17);
        this.f4442.setGravity(17);
        this.f4443.setGravity(17);
        this.f4440.setTypeface(this.f4375);
        this.f4440.setTextSize(0, this.f4376);
        this.f4440.setText(getResources().getString(R.string.MONITOR_STATUES_CHOOSE_ONE));
        this.f4440.setTextColor(-1);
        this.f4441.setTypeface(this.f4375);
        this.f4441.setTextSize(0, this.f4376);
        this.f4441.setText(getResources().getString(R.string.MONITOR_STATUES_CHOOSE_ONE));
        this.f4441.setTextColor(-1);
        this.f4442.setTypeface(this.f4375);
        this.f4442.setTextSize(0, this.f4376);
        this.f4442.setText(getResources().getString(R.string.MONITOR_STATUES_CHOOSE_ONE));
        this.f4442.setTextColor(-1);
        this.f4443.setTypeface(this.f4375);
        this.f4443.setTextSize(0, this.f4376);
        this.f4443.setText(getResources().getString(R.string.MONITOR_STATUES_CHOOSE_ONE));
        this.f4443.setTextColor(-1);
        this.f4427.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f4428.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f4429.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f4430.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f4431.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f4432.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f4433.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f4434.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f4435.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f4436.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f4437.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f4438.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setTextureParentChildrenSize(this.f4427);
        setTextureParentChildrenSize(this.f4431);
        this.f4435.addView(this.f4440, 0);
        this.f4435.addView(this.f4427, 1);
        this.f4435.addView(this.f4431, 2);
        this.f4435.addView(this.f4444, 3);
        setTextureParentChildrenSize(this.f4428);
        setTextureParentChildrenSize(this.f4432);
        this.f4436.addView(this.f4441, 0);
        this.f4436.addView(this.f4428, 1);
        this.f4436.addView(this.f4432, 2);
        this.f4436.addView(this.f4445, 3);
        setTextureParentChildrenSize(this.f4429);
        setTextureParentChildrenSize(this.f4433);
        this.f4437.addView(this.f4442, 0);
        this.f4437.addView(this.f4429, 1);
        this.f4437.addView(this.f4433, 2);
        this.f4437.addView(this.f4446, 3);
        setTextureParentChildrenSize(this.f4430);
        setTextureParentChildrenSize(this.f4434);
        this.f4438.addView(this.f4443, 0);
        this.f4438.addView(this.f4430, 1);
        this.f4438.addView(this.f4434, 2);
        this.f4438.addView(this.f4447, 3);
        m4493();
        this.f4370.f12234.addView(this.f4438);
        this.f4370.f12233.addView(this.f4437);
        this.f4370.f12232.addView(this.f4436);
        this.f4370.f12231.addView(this.f4435);
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f4435.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams12).width = this.f4397 + (this.f4406 * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams12).height = this.f4398 + (this.f4407 * 2);
        layoutParams12.leftToLeft = R.id.texture_parent1;
        layoutParams12.topToTop = R.id.texture_parent1;
        this.f4435.setLayoutParams(layoutParams12);
        ConstraintLayout.LayoutParams layoutParams13 = (ConstraintLayout.LayoutParams) this.f4436.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams13).width = this.f4397 + (this.f4406 * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams13).height = this.f4398 + (this.f4407 * 2);
        layoutParams13.leftToLeft = R.id.texture_parent2;
        layoutParams13.topToTop = R.id.texture_parent2;
        this.f4436.setLayoutParams(layoutParams13);
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) this.f4437.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams14).width = this.f4397 + (this.f4406 * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams14).height = this.f4398 + (this.f4407 * 2);
        layoutParams14.leftToLeft = R.id.texture_parent3;
        layoutParams14.topToTop = R.id.texture_parent3;
        this.f4437.setLayoutParams(layoutParams14);
        ConstraintLayout.LayoutParams layoutParams15 = (ConstraintLayout.LayoutParams) this.f4438.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams15).width = this.f4397 + (this.f4406 * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams15).height = this.f4398 + (this.f4407 * 2);
        layoutParams15.leftToLeft = R.id.texture_parent4;
        layoutParams15.topToTop = R.id.texture_parent4;
        this.f4438.setLayoutParams(layoutParams15);
        int iM14454 = (int) (C4792.m14375().m14454() * this.f4378);
        ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) this.f4370.f12227.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams16).topMargin = this.f4419;
        ((ViewGroup.MarginLayoutParams) layoutParams16).leftMargin = this.f4418;
        this.f4370.f12227.setLayoutParams(layoutParams16);
        this.f4370.f12240.m2562(0, this.f4376);
        this.f4370.f12240.setContentTypeFace(this.f4535);
        this.f4370.f12240.setContentTextColor(-1);
        this.f4370.f12236.m2562(0, this.f4376);
        this.f4370.f12236.setContentTypeFace(this.f4535);
        this.f4370.f12236.setContentTextColor(-1);
        this.f4370.f12217.m2562(0, this.f4376);
        this.f4370.f12217.setContentTypeFace(this.f4375);
        this.f4370.f12217.setContentTextColor(-1);
        ConstraintLayout.LayoutParams layoutParams17 = (ConstraintLayout.LayoutParams) this.f4370.f12228.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams17).topMargin = this.f4419;
        ((ViewGroup.MarginLayoutParams) layoutParams17).leftMargin = this.f4418;
        this.f4370.f12228.setLayoutParams(layoutParams17);
        this.f4370.f12241.m2562(0, this.f4376);
        this.f4370.f12241.setContentTypeFace(this.f4535);
        this.f4370.f12241.setContentTextColor(-1);
        this.f4370.f12237.m2562(0, this.f4376);
        this.f4370.f12237.setContentTypeFace(this.f4535);
        this.f4370.f12237.setContentTextColor(-1);
        this.f4370.f12218.m2562(0, this.f4376);
        this.f4370.f12218.setContentTypeFace(this.f4375);
        this.f4370.f12218.setContentTextColor(-1);
        ConstraintLayout.LayoutParams layoutParams18 = (ConstraintLayout.LayoutParams) this.f4370.f12229.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams18).topMargin = this.f4419;
        ((ViewGroup.MarginLayoutParams) layoutParams18).leftMargin = this.f4418;
        this.f4370.f12229.setLayoutParams(layoutParams18);
        this.f4370.f12242.m2562(0, this.f4376);
        this.f4370.f12242.setContentTypeFace(this.f4535);
        this.f4370.f12242.setContentTextColor(-1);
        this.f4370.f12238.m2562(0, this.f4376);
        this.f4370.f12238.setContentTypeFace(this.f4535);
        this.f4370.f12238.setContentTextColor(-1);
        this.f4370.f12219.m2562(0, this.f4376);
        this.f4370.f12219.setContentTypeFace(this.f4375);
        this.f4370.f12219.setContentTextColor(-1);
        ConstraintLayout.LayoutParams layoutParams19 = (ConstraintLayout.LayoutParams) this.f4370.f12230.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams19).topMargin = this.f4419;
        ((ViewGroup.MarginLayoutParams) layoutParams19).leftMargin = this.f4418;
        this.f4370.f12230.setLayoutParams(layoutParams19);
        this.f4370.f12243.m2562(0, this.f4376);
        this.f4370.f12243.setContentTypeFace(this.f4535);
        this.f4370.f12243.setContentTextColor(-1);
        this.f4370.f12239.m2562(0, this.f4376);
        this.f4370.f12239.setContentTypeFace(this.f4535);
        this.f4370.f12239.setContentTextColor(-1);
        this.f4370.f12220.m2562(0, this.f4376);
        this.f4370.f12220.setContentTypeFace(this.f4375);
        this.f4370.f12220.setContentTextColor(-1);
        Paint.FontMetrics fontMetrics = this.f4370.f12240.getPaint().getFontMetrics();
        this.f4439 = (int) (fontMetrics.bottom - fontMetrics.top);
        ConstraintLayout.LayoutParams layoutParams20 = (ConstraintLayout.LayoutParams) this.f4370.f12172.getLayoutParams();
        int i = this.f4439;
        ((ViewGroup.MarginLayoutParams) layoutParams20).width = i;
        ((ViewGroup.MarginLayoutParams) layoutParams20).height = i;
        this.f4370.f12172.setLayoutParams(layoutParams20);
        ConstraintLayout.LayoutParams layoutParams21 = (ConstraintLayout.LayoutParams) this.f4370.f12173.getLayoutParams();
        int i2 = this.f4439;
        ((ViewGroup.MarginLayoutParams) layoutParams21).width = i2;
        ((ViewGroup.MarginLayoutParams) layoutParams21).height = i2;
        this.f4370.f12173.setLayoutParams(layoutParams21);
        ConstraintLayout.LayoutParams layoutParams22 = (ConstraintLayout.LayoutParams) this.f4370.f12174.getLayoutParams();
        int i3 = this.f4439;
        ((ViewGroup.MarginLayoutParams) layoutParams22).width = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams22).height = i3;
        this.f4370.f12174.setLayoutParams(layoutParams22);
        ConstraintLayout.LayoutParams layoutParams23 = (ConstraintLayout.LayoutParams) this.f4370.f12175.getLayoutParams();
        int i4 = this.f4439;
        ((ViewGroup.MarginLayoutParams) layoutParams23).width = i4;
        ((ViewGroup.MarginLayoutParams) layoutParams23).height = i4;
        this.f4370.f12175.setLayoutParams(layoutParams23);
        int iM14476 = (int) (((C4792.m14375().m14476((C4792.m14375().m14488() * 2) + 658) * C4792.m14375().m14434()) + 0.5f) * 0.9f);
        int iM144762 = (int) (C4792.m14375().m14476(50) * 0.9f);
        FrameLayout.LayoutParams layoutParams24 = (FrameLayout.LayoutParams) this.f4370.f12168.getLayoutParams();
        layoutParams24.width = iM14476;
        layoutParams24.height = iM14476;
        layoutParams24.leftMargin = iM144762;
        this.f4370.f12168.setLayoutParams(layoutParams24);
        ConstraintLayout.LayoutParams layoutParams25 = (ConstraintLayout.LayoutParams) this.f4370.f12169.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams25).rightMargin = this.f4406;
        ((ViewGroup.MarginLayoutParams) layoutParams25).height = (int) (layoutParams24.height + (C4792.m14375().m14476(30) * 0.9f));
        ((ViewGroup.MarginLayoutParams) layoutParams25).width = (int) ((C4792.m14375().m14476(C4792.m14375().m14488() + 242) * C4792.m14375().m14434()) + iM144762);
        this.f4370.f12168.setHandler(new WeakHandler());
        this.f4370.f12168.setCardWidth(((ViewGroup.MarginLayoutParams) layoutParams25).width);
        this.f4370.f12168.hide(0);
        this.f4370.f12168.setOnValueChange(new C1707());
        this.f4370.f12172.m4164(0);
        this.f4370.f12173.m4164(0);
        this.f4370.f12174.m4164(0);
        this.f4370.f12175.m4164(0);
        this.f4370.f12188.m2562(0, this.f4377);
        this.f4370.f12188.setContentTextColor(-1);
        float f = ((this.f4373 - (this.f4381 * 2)) - this.f4405) / 2.0f;
        float f2 = (this.f4374 - this.f4382) / 2.0f;
        float totalWidth = this.f4370.f12209.getTotalWidth();
        float totalHeight = this.f4370.f12209.getTotalHeight();
        int i5 = this.f4374 - (this.f4383 * 2);
        int i6 = this.f4405;
        float f3 = (i5 - i6) / 2.0f;
        float f4 = ((this.f4373 - (this.f4384 * 2)) - i6) / 2.0f;
        float fMeasureText = this.f4370.f12188.getPaint().measureText(getResources().getString(R.string.MONITOR_SECTOR_CONNECT_CAMERAS));
        ConstraintLayout.LayoutParams layoutParams26 = (ConstraintLayout.LayoutParams) this.f4370.f12188.getLayoutParams();
        float f5 = C4792.f16138;
        ((ViewGroup.MarginLayoutParams) layoutParams26).width = (int) (fMeasureText + f5);
        ((ViewGroup.MarginLayoutParams) layoutParams26).leftMargin = (int) (((((this.f4373 - this.f4397) / 2.0f) + this.f4400) - (f5 / 2.0f)) + C2579.m9438(3.0f));
        this.f4370.f12188.setLayoutParams(layoutParams26);
        ConstraintLayout.LayoutParams layoutParams27 = (ConstraintLayout.LayoutParams) this.f4370.f12221.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams27).width = C4792.m14375().m14458();
        ((ViewGroup.MarginLayoutParams) layoutParams27).height = C4792.m14375().m14457();
        ((ViewGroup.MarginLayoutParams) layoutParams27).rightMargin = (int) (this.f4406 - ((((ViewGroup.MarginLayoutParams) layoutParams27).width * 57.0f) / 138.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams27).bottomMargin = C4792.m14375().m14456() + C4792.m14375().m14476(15);
        this.f4370.f12221.setLayoutParams(layoutParams27);
        this.f4370.f12221.m2505(((ViewGroup.MarginLayoutParams) layoutParams27).width, ((ViewGroup.MarginLayoutParams) layoutParams27).height);
        this.f4370.f12221.m2503(false);
        ConstraintLayout.LayoutParams layoutParams28 = (ConstraintLayout.LayoutParams) this.f4370.f12176.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams28).width = C4792.m14375().m14476(36) + C4792.m14375().m14432();
        ((ViewGroup.MarginLayoutParams) layoutParams28).height = (int) (C2579.m9438(60.0f) * this.f4378);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.f4377);
        textPaint.setTypeface(this.f4375);
        Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
        int i7 = (int) ((((ViewGroup.MarginLayoutParams) layoutParams27).bottomMargin + ((((ViewGroup.MarginLayoutParams) layoutParams27).height - ((ViewGroup.MarginLayoutParams) layoutParams28).height) / 2.0f)) - ((int) ((((fontMetrics2.bottom - fontMetrics2.top) - fontMetrics2.descent) + fontMetrics2.ascent) / 2.0f)));
        ((ViewGroup.MarginLayoutParams) layoutParams28).bottomMargin = i7;
        this.f4385 = i7;
        float f6 = iM14454;
        int i8 = ((ViewGroup.MarginLayoutParams) layoutParams28).width;
        int i9 = ((ViewGroup.MarginLayoutParams) layoutParams27).width;
        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams27).rightMargin;
        this.f4386 = ((int) (f6 - ((i8 - r8) / 2.0f))) + i9 + i10;
        ((ViewGroup.MarginLayoutParams) layoutParams28).rightMargin = ((int) (f6 - ((i8 - r8) / 2.0f))) + i9 + i10;
        this.f4370.f12176.setLayoutParams(layoutParams28);
        m4507("A1D2");
        int iM144802 = C4792.m14375().m14480(50.0f, this.f4378);
        int i11 = this.f4373;
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams28).width;
        this.f4387 = (int) (-(((i11 - i12) / 2.0f) - this.f4386));
        this.f4388 = (int) (((ViewGroup.MarginLayoutParams) layoutParams28).bottomMargin - ((this.f4374 - f2) + ((f2 - ((ViewGroup.MarginLayoutParams) layoutParams28).height) / 2.0f)));
        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams28).rightMargin;
        int i14 = ((ViewGroup.MarginLayoutParams) layoutParams27).width;
        this.f4389 = (int) ((-(((((i11 - i12) - i13) - (r8 - i12)) - (i13 / 2.0f)) + ((int) (((i11 - (this.f4384 * 2)) - this.f4405) / 2.0f)))) + ((i14 - i12) / 2.0f));
        this.f4390 = (int) (-(((r9 - r14) / 2.0f) - this.f4385));
        int i15 = ((ViewGroup.MarginLayoutParams) layoutParams27).rightMargin;
        this.f4391 = (int) (-(((i11 - i14) / 2.0f) - i15));
        this.f4392 = -iM144802;
        this.f4393 = (int) (i15 / 2.0f);
        this.f4394 = (int) (-(((r9 - ((ViewGroup.MarginLayoutParams) layoutParams27).height) / 2.0f) - ((ViewGroup.MarginLayoutParams) layoutParams27).bottomMargin));
        ConstraintLayout.LayoutParams layoutParams29 = (ConstraintLayout.LayoutParams) this.f4370.f12177.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams29).width = C2579.m9438(44.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams29).height = C2579.m9438(44.0f);
        this.f4370.f12177.setLayoutParams(layoutParams29);
        m4545(this.f4370.f12176, this.f4387, 0.0f, 0);
        this.f4431.m4595(this.f4397, this.f4398);
        this.f4432.m4595(this.f4397, this.f4398);
        this.f4433.m4595(this.f4397, this.f4398);
        this.f4434.m4595(this.f4397, this.f4398);
        ConstraintLayout.LayoutParams layoutParams30 = (ConstraintLayout.LayoutParams) this.f4370.f12186.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams30).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams16).topMargin - C4792.m14375().m14478(27.0f, this.f4378);
        if (C2579.m9452(getContext())) {
            ((ViewGroup.MarginLayoutParams) layoutParams30).bottomMargin = C4792.m14375().m14480(55.0f, this.f4378) - C4792.m14375().m14478(27.0f, this.f4378);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams30).leftMargin = (int) (((((this.f4373 - this.f4397) / 2.0f) - C4792.m14375().m14459()) - (C4792.f16138 / 2.0f)) + C2579.m9438(3.0f));
        this.f4370.f12186.setLayoutParams(layoutParams30);
        int i16 = ((ViewGroup.MarginLayoutParams) layoutParams30).leftMargin;
        ConstraintLayout.LayoutParams layoutParams31 = (ConstraintLayout.LayoutParams) this.f4370.f12188.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams31).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams30).bottomMargin + this.f4370.f12186.getTotalHeight();
        this.f4370.f12188.setLayoutParams(layoutParams31);
        ConstraintLayout.LayoutParams layoutParams32 = (ConstraintLayout.LayoutParams) this.f4370.f12187.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams32).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams30).bottomMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams32).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams30).leftMargin;
        this.f4370.f12187.setLayoutParams(layoutParams32);
        int i17 = this.f4400;
        this.f4472 = ((int) (((((this.f4381 * 2) + f) + this.f4405) - this.f4370.f12186.getTotalWidth()) + i17)) - i16;
        this.f4396 = i17 - i16;
        int i18 = ((ViewGroup.MarginLayoutParams) layoutParams30).bottomMargin;
        this.f4395 = -(((int) ((((this.f4374 - this.f4405) - this.f4382) / 2.0f) - this.f4370.f12187.getTotalHeight())) - i18);
        int totalHeight2 = ((-i18) + ((int) (((this.f4374 - this.f4405) - (this.f4383 * 2)) / 2.0f))) - this.f4370.f12186.getTotalHeight();
        this.f4468 = totalHeight2;
        int i19 = totalHeight2 + this.f4383;
        int i20 = this.f4405;
        this.f4469 = i19 + i20;
        float f7 = i16;
        int i21 = (int) (f4 - f7);
        this.f4470 = i21;
        this.f4471 = i21 + this.f4384 + i20;
        ConstraintLayout.LayoutParams layoutParams33 = (ConstraintLayout.LayoutParams) this.f4370.f12180.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams33).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams30).bottomMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams33).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams30).leftMargin;
        this.f4370.f12180.setLayoutParams(layoutParams33);
        ConstraintLayout.LayoutParams layoutParams34 = (ConstraintLayout.LayoutParams) this.f4370.f12181.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams34).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams30).bottomMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams34).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams30).leftMargin;
        this.f4370.f12181.setLayoutParams(layoutParams34);
        this.f4370.f12240.getPaint().getFontMetrics();
        Paint.FontMetrics fontMetrics3 = this.f4370.f12241.getPaint().getFontMetrics();
        this.f4401 = -((ViewGroup.MarginLayoutParams) layoutParams16).leftMargin;
        int i22 = this.f4374;
        int i23 = this.f4382;
        float f8 = fontMetrics3.bottom;
        float f9 = fontMetrics3.top;
        this.f4402 = (int) (((((i22 - i23) / 2.0f) - (f8 - f9)) - ((ViewGroup.MarginLayoutParams) layoutParams16).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams16).topMargin);
        this.f4417 = (int) (((((i22 - i23) / 2.0f) - (f8 - f9)) - C4792.m14375().m14480(20.0f, this.f4378)) + ((fontMetrics3.bottom - fontMetrics3.top) * (1.0f - this.f4403)));
        if (C2579.m9452(getContext())) {
            this.f4417 += this.f4538;
        }
        this.f4370.f12182.setText("A");
        this.f4370.f12182.setTextSize(0, this.f4376);
        this.f4370.f12182.setTypeface(this.f4375);
        this.f4370.f12182.setTextColor(-1);
        this.f4370.f12183.setTextSize(0, this.f4376);
        this.f4370.f12183.setTypeface(this.f4375);
        this.f4370.f12183.setText(TransmitHelper.CAMERA_UNIT_B_CONTENT);
        this.f4370.f12183.setTextColor(-1);
        this.f4370.f12184.setTextSize(0, this.f4376);
        this.f4370.f12184.setTypeface(this.f4375);
        this.f4370.f12184.setText(TransmitHelper.CAMERA_UNIT_C_CONTENT);
        this.f4370.f12184.setTextColor(-1);
        this.f4370.f12185.setText(TransmitHelper.CAMERA_UNIT_D_CONTENT);
        this.f4370.f12185.setTextSize(0, this.f4376);
        this.f4370.f12185.setTypeface(this.f4375);
        this.f4370.f12185.setTextColor(-1);
        TextPaint paint = this.f4370.f12182.getPaint();
        float fM14480 = this.f4457 - C4792.m14375().m14480(20.0f, this.f4378);
        ConstraintLayout.LayoutParams layoutParams35 = (ConstraintLayout.LayoutParams) this.f4370.f12182.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams35).leftMargin = (int) (fM14480 - paint.measureText(TransmitHelper.CAMERA_UNIT_B_CONTENT));
        ((ViewGroup.MarginLayoutParams) layoutParams35).topMargin = this.f4456;
        this.f4370.f12182.setLayoutParams(layoutParams35);
        ConstraintLayout.LayoutParams layoutParams36 = (ConstraintLayout.LayoutParams) this.f4370.f12183.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams36).leftMargin = this.f4457 + this.f4405 + (this.f4384 * 2) + C4792.m14375().m14480(20.0f, this.f4378);
        this.f4370.f12183.setLayoutParams(layoutParams36);
        ConstraintLayout.LayoutParams layoutParams37 = (ConstraintLayout.LayoutParams) this.f4370.f12184.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams37).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams35).topMargin;
        this.f4370.f12184.setLayoutParams(layoutParams37);
        this.f4370.f12227.setPivotX(0.0f);
        this.f4370.f12227.setPivotY(1.0f);
        this.f4370.f12228.setPivotX(0.0f);
        this.f4370.f12228.setPivotY(1.0f);
        this.f4370.f12229.setPivotX(0.0f);
        this.f4370.f12229.setPivotY(1.0f);
        this.f4370.f12230.setPivotX(0.0f);
        this.f4370.f12230.setPivotY(1.0f);
        this.f4370.f12223.setPivotX(0.0f);
        this.f4370.f12223.setPivotY(1.0f);
        this.f4370.f12224.setPivotX(0.0f);
        this.f4370.f12224.setPivotY(1.0f);
        this.f4370.f12225.setPivotX(0.0f);
        this.f4370.f12225.setPivotY(1.0f);
        this.f4370.f12226.setPivotX(0.0f);
        this.f4370.f12226.setPivotY(1.0f);
        this.f4370.f12240.setPivotX(0.0f);
        this.f4370.f12240.setPivotY(1.0f);
        this.f4370.f12241.setPivotX(0.0f);
        this.f4370.f12241.setPivotY(1.0f);
        this.f4370.f12242.setPivotX(0.0f);
        this.f4370.f12243.setPivotY(1.0f);
        this.f4370.f12243.setPivotX(0.0f);
        this.f4370.f12243.setPivotY(1.0f);
        this.f4473 = 0.6f;
        ConstraintLayout.LayoutParams layoutParams38 = (ConstraintLayout.LayoutParams) this.f4370.f12223.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams38).topMargin = (int) (C4792.m14375().m14476(30) * this.f4378);
        ((ViewGroup.MarginLayoutParams) layoutParams38).leftMargin = this.f4418;
        this.f4370.f12223.setLayoutParams(layoutParams38);
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setTextSize(C4792.m14375().m14384());
        textPaint2.setTypeface(FilmApp.m404());
        Paint.FontMetrics fontMetrics4 = textPaint2.getFontMetrics();
        float f10 = (((fontMetrics4.bottom - fontMetrics4.top) - fontMetrics4.descent) + fontMetrics4.ascent) / 2.0f;
        this.f4476 = (int) (this.f4417 + f10);
        this.f4511 = this.f4381 + f;
        int i24 = this.f4405;
        this.f4512 = (r9 * 2) + f + i24;
        this.f4477 = (int) (this.f4419 + (fontMetrics3.bottom - fontMetrics3.top) + ((ViewGroup.MarginLayoutParams) layoutParams38).topMargin);
        this.f4510 = ((ViewGroup.MarginLayoutParams) layoutParams16).leftMargin;
        this.f4499 = (int) (this.f4461 + f10);
        this.f4500 = (int) (this.f4462 + f10);
        this.f4508 = this.f4384 + f4;
        this.f4509 = i24 + f4 + (r2 * 2);
        ConstraintLayout.LayoutParams layoutParams39 = (ConstraintLayout.LayoutParams) this.f4370.f12224.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams39).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams38).topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams39).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams38).leftMargin;
        this.f4370.f12224.setLayoutParams(layoutParams39);
        ConstraintLayout.LayoutParams layoutParams40 = (ConstraintLayout.LayoutParams) this.f4370.f12225.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams40).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams38).topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams40).width = ((ViewGroup.MarginLayoutParams) layoutParams38).width;
        ((ViewGroup.MarginLayoutParams) layoutParams40).height = ((ViewGroup.MarginLayoutParams) layoutParams38).height;
        ((ViewGroup.MarginLayoutParams) layoutParams40).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams38).leftMargin;
        this.f4370.f12225.setLayoutParams(layoutParams40);
        ConstraintLayout.LayoutParams layoutParams41 = (ConstraintLayout.LayoutParams) this.f4370.f12226.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams41).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams38).topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams41).width = ((ViewGroup.MarginLayoutParams) layoutParams38).width;
        ((ViewGroup.MarginLayoutParams) layoutParams41).height = ((ViewGroup.MarginLayoutParams) layoutParams38).height;
        ((ViewGroup.MarginLayoutParams) layoutParams41).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams38).leftMargin;
        this.f4370.f12226.setLayoutParams(layoutParams41);
        int playerBtnWidth = (int) this.f4370.f12213.getPlayerBtnWidth();
        int totalHeight3 = (int) this.f4370.f12213.getTotalHeight();
        int i25 = (int) (((ViewGroup.MarginLayoutParams) layoutParams16).topMargin + ((this.f4439 - totalHeight3) / 2.0f));
        int iM144763 = C4792.m14375().m14476(40);
        int i26 = (int) (this.f4373 * 0.029213483f);
        if (C2579.m9452(getContext())) {
            iM14480 = (int) (C4792.m14375().m14480(55.0f, this.f4378) + ((this.f4439 - totalHeight3) / 2.0f));
            this.f4513 = (((this.f4371 - this.f4373) / 2) + iM14480) - this.f4370.f12205.getLeftMarginOffset();
            int i27 = this.f4538;
            int i28 = this.f4374;
            layoutParams = layoutParams35;
            this.f4514 = ((int) (i27 + (i28 * 0.05f))) + iM14480;
            this.f4525 = ((int) (i27 + (i28 * 0.05f) + ((i26 * 35) / 144))) + iM14480;
            this.f4526 = (int) (((f7 + (this.f4373 * 0.9f)) - iM14480) - C4792.m14375().m14479(25.0f, this.f4378));
        } else {
            layoutParams = layoutParams35;
            this.f4513 = this.f4418 - this.f4370.f12205.getLeftMarginOffset();
            this.f4515 = this.f4498 + this.f4419 + this.f4439 + this.f4370.f12223.getViewRealHeight() + (((ViewGroup.MarginLayoutParams) layoutParams38).topMargin * 2);
            this.f4516 = (((this.f4498 + this.f4419) + this.f4370.f12223.getViewRealHeight()) + (((ViewGroup.MarginLayoutParams) layoutParams38).topMargin * 2)) - ((int) (C4792.m14375().m14476(20) * this.f4378));
            int i29 = this.f4419;
            this.f4517 = i29;
            this.f4514 = this.f4515;
            this.f4525 = i29 + ((this.f4439 - iM144763) / 2) + C4792.m14375().m14476(25);
            this.f4526 = ((this.f4418 + this.f4397) - ((this.f4439 - iM144763) / 2)) - C4792.m14375().m14479(30.0f, this.f4378);
            iM14480 = i25;
        }
        int i30 = (int) (((ViewGroup.MarginLayoutParams) layoutParams27).rightMargin + ((((ViewGroup.MarginLayoutParams) layoutParams27).width - playerBtnWidth) / 2.0f));
        int iM9438 = C2579.m9438(2.0f);
        this.f4474 = iM14480;
        this.f4485 = (int) (((ViewGroup.MarginLayoutParams) layoutParams30).bottomMargin + ((this.f4370.f12186.getTotalHeight() - C2579.m9438(this.f4378 * 44.0f)) / 2.0f) + this.f4370.f12186.getBottomLineHeight());
        float f11 = this.f4406 - ((int) ((this.f4373 * 0.02846442f) * this.f4378));
        float fM9438 = C2579.m9438(44.0f);
        float f12 = this.f4378;
        this.f4486 = (int) (f11 - (((fM9438 * f12) - ((this.f4373 * 0.035205994f) * f12)) / 2.0f));
        if (C2579.m9452(getContext())) {
            this.f4485 += this.f4538;
        }
        ConstraintLayout.LayoutParams layoutParams42 = (ConstraintLayout.LayoutParams) this.f4370.f12209.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams42).rightMargin = this.f4486;
        ((ViewGroup.MarginLayoutParams) layoutParams42).bottomMargin = this.f4485;
        this.f4370.f12209.setLayoutParams(layoutParams42);
        ConstraintLayout.LayoutParams layoutParams43 = (ConstraintLayout.LayoutParams) this.f4370.f12210.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams43).rightMargin = this.f4486;
        ((ViewGroup.MarginLayoutParams) layoutParams43).bottomMargin = this.f4485;
        this.f4370.f12210.setLayoutParams(layoutParams43);
        ConstraintLayout.LayoutParams layoutParams44 = (ConstraintLayout.LayoutParams) this.f4370.f12211.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams44).rightMargin = this.f4486;
        ((ViewGroup.MarginLayoutParams) layoutParams44).bottomMargin = this.f4485;
        this.f4370.f12211.setLayoutParams(layoutParams44);
        ConstraintLayout.LayoutParams layoutParams45 = (ConstraintLayout.LayoutParams) this.f4370.f12212.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams45).rightMargin = this.f4486;
        ((ViewGroup.MarginLayoutParams) layoutParams45).bottomMargin = this.f4485;
        this.f4370.f12212.setLayoutParams(layoutParams45);
        float f13 = 0;
        this.f4478 = (int) (f2 + f13);
        int i31 = this.f4381;
        int i32 = this.f4405;
        this.f4479 = (int) (i31 + f + i32 + ((i31 - totalWidth) / 2.0f));
        this.f4480 = (int) (((i31 - totalWidth) / 2.0f) + f);
        this.f4481 = (int) (f3 + this.f4383 + i32 + f13);
        int i33 = this.f4384;
        this.f4482 = (int) (i33 + f4 + i32 + ((i33 - totalWidth) / 2.0f));
        this.f4483 = (int) (((i33 - totalWidth) / 2.0f) + f4);
        this.f4484 = (int) (f3 + f13);
        if (C2579.m9452(getContext())) {
            int i34 = this.f4478;
            int i35 = this.f4538;
            this.f4478 = i34 + i35;
            this.f4481 += i35;
            this.f4484 += i35;
        }
        this.f4495 = i30;
        this.f4496 = this.f4474;
        ConstraintLayout.LayoutParams layoutParams46 = (ConstraintLayout.LayoutParams) this.f4370.f12213.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams46).rightMargin = this.f4495;
        ((ViewGroup.MarginLayoutParams) layoutParams46).topMargin = this.f4496;
        this.f4370.f12213.setLayoutParams(layoutParams46);
        this.f4370.f12213.m4583(2, true);
        ConstraintLayout.LayoutParams layoutParams47 = (ConstraintLayout.LayoutParams) this.f4370.f12214.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams47).rightMargin = this.f4495;
        ((ViewGroup.MarginLayoutParams) layoutParams47).topMargin = this.f4496;
        this.f4370.f12214.setLayoutParams(layoutParams47);
        this.f4370.f12214.m4583(2, true);
        ConstraintLayout.LayoutParams layoutParams48 = (ConstraintLayout.LayoutParams) this.f4370.f12215.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams48).rightMargin = this.f4495;
        ((ViewGroup.MarginLayoutParams) layoutParams48).topMargin = this.f4496;
        this.f4370.f12215.setLayoutParams(layoutParams48);
        this.f4370.f12215.m4583(2, true);
        ConstraintLayout.LayoutParams layoutParams49 = (ConstraintLayout.LayoutParams) this.f4370.f12216.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams49).rightMargin = this.f4495;
        ((ViewGroup.MarginLayoutParams) layoutParams49).topMargin = this.f4496;
        this.f4370.f12216.setLayoutParams(layoutParams49);
        this.f4370.f12216.m4583(2, true);
        ConstraintLayout.LayoutParams layoutParams50 = (ConstraintLayout.LayoutParams) this.f4370.f12205.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams50).leftMargin = this.f4513;
        ((ViewGroup.MarginLayoutParams) layoutParams50).topMargin = this.f4514;
        this.f4370.f12205.setLayoutParams(layoutParams50);
        ConstraintLayout.LayoutParams layoutParams51 = (ConstraintLayout.LayoutParams) this.f4370.f12206.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams51).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams50).leftMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams51).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams50).topMargin;
        this.f4370.f12206.setLayoutParams(layoutParams51);
        ConstraintLayout.LayoutParams layoutParams52 = (ConstraintLayout.LayoutParams) this.f4370.f12207.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams52).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams50).leftMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams52).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams50).topMargin;
        this.f4370.f12207.setLayoutParams(layoutParams52);
        ConstraintLayout.LayoutParams layoutParams53 = (ConstraintLayout.LayoutParams) this.f4370.f12208.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams53).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams50).leftMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams53).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams50).topMargin;
        this.f4370.f12208.setLayoutParams(layoutParams53);
        ConstraintLayout.LayoutParams layoutParams54 = (ConstraintLayout.LayoutParams) this.f4370.f12197.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams54).width = iM144763;
        ((ViewGroup.MarginLayoutParams) layoutParams54).height = iM144763;
        ((ViewGroup.MarginLayoutParams) layoutParams54).topMargin = this.f4525;
        ((ViewGroup.MarginLayoutParams) layoutParams54).leftMargin = this.f4526;
        this.f4370.f12197.setLayoutParams(layoutParams54);
        ConstraintLayout.LayoutParams layoutParams55 = (ConstraintLayout.LayoutParams) this.f4370.f12198.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams55).width = ((ViewGroup.MarginLayoutParams) layoutParams54).width;
        ((ViewGroup.MarginLayoutParams) layoutParams55).height = ((ViewGroup.MarginLayoutParams) layoutParams54).height;
        ((ViewGroup.MarginLayoutParams) layoutParams55).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams54).leftMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams55).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams54).topMargin;
        this.f4370.f12198.setLayoutParams(layoutParams55);
        ConstraintLayout.LayoutParams layoutParams56 = (ConstraintLayout.LayoutParams) this.f4370.f12199.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams56).width = ((ViewGroup.MarginLayoutParams) layoutParams54).width;
        ((ViewGroup.MarginLayoutParams) layoutParams56).height = ((ViewGroup.MarginLayoutParams) layoutParams54).height;
        ((ViewGroup.MarginLayoutParams) layoutParams56).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams54).leftMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams56).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams54).topMargin;
        this.f4370.f12199.setLayoutParams(layoutParams56);
        ConstraintLayout.LayoutParams layoutParams57 = (ConstraintLayout.LayoutParams) this.f4370.f12200.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams57).width = ((ViewGroup.MarginLayoutParams) layoutParams54).width;
        ((ViewGroup.MarginLayoutParams) layoutParams57).height = ((ViewGroup.MarginLayoutParams) layoutParams54).height;
        ((ViewGroup.MarginLayoutParams) layoutParams57).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams54).leftMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams57).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams54).topMargin;
        this.f4370.f12200.setLayoutParams(layoutParams57);
        CloudMonitorSwitchView cloudMonitorSwitchView = this.f4370.f12205;
        cloudMonitorSwitchView.setOnTouchListener(new ViewOnTouchListenerC3426(cloudMonitorSwitchView));
        this.f4370.f12205.setOnClickListener(new ViewOnClickListenerC1708());
        CloudMonitorSwitchView cloudMonitorSwitchView2 = this.f4370.f12206;
        cloudMonitorSwitchView2.setOnTouchListener(new ViewOnTouchListenerC3426(cloudMonitorSwitchView2));
        this.f4370.f12206.setOnClickListener(new ViewOnClickListenerC1713());
        CloudMonitorSwitchView cloudMonitorSwitchView3 = this.f4370.f12207;
        cloudMonitorSwitchView3.setOnTouchListener(new ViewOnTouchListenerC3426(cloudMonitorSwitchView3));
        this.f4370.f12207.setOnClickListener(new ViewOnClickListenerC1718());
        CloudMonitorSwitchView cloudMonitorSwitchView4 = this.f4370.f12208;
        cloudMonitorSwitchView4.setOnTouchListener(new ViewOnTouchListenerC3426(cloudMonitorSwitchView4));
        this.f4370.f12208.setOnClickListener(new ViewOnClickListenerC1723());
        this.f4370.f12193.setOnCloudConnectCallback(new C1645());
        this.f4370.f12194.setOnCloudConnectCallback(new C1646());
        this.f4370.f12195.setOnCloudConnectCallback(new C1647());
        this.f4370.f12196.setOnCloudConnectCallback(new C1648());
        this.f4487 = this.f4370.f12213.getNeedScale();
        float f14 = iM9438;
        this.f4488 = (int) ((((this.f4381 + f) + this.f4405) + f14) - this.f4370.f12213.getOffsetWidth());
        float f15 = f + f14;
        this.f4489 = (int) (f15 - this.f4370.f12213.getOffsetWidth());
        this.f4490 = (int) ((f2 + f14) - this.f4370.f12213.getOffsetHeight());
        this.f4537 = (int) (((this.f4370.f12213.getPlayerBtnCircleWidth() * this.f4487) - (C4792.m14375().m14462() * this.f4378)) / 2.0f);
        this.f4491 = (int) ((((this.f4405 + f4) + this.f4384) + f14) - this.f4370.f12213.getOffsetWidth());
        this.f4492 = (int) ((f3 + f14) - this.f4370.f12213.getOffsetHeight());
        float f16 = f4 + f14;
        this.f4493 = (int) (f16 - this.f4370.f12213.getOffsetWidth());
        this.f4494 = (int) ((((f3 + this.f4383) + this.f4405) + f14) - this.f4370.f12213.getOffsetHeight());
        this.f4520 = (int) (this.f4490 + ((this.f4370.f12213.getTotalHeight() - this.f4370.f12205.getViewHeight()) / 2.0f));
        this.f4522 = (int) (this.f4492 + ((this.f4370.f12213.getTotalHeight() - this.f4370.f12205.getViewHeight()) / 2.0f));
        this.f4524 = (int) (this.f4494 + ((this.f4370.f12213.getTotalHeight() - this.f4370.f12205.getViewHeight()) / 2.0f));
        this.f4529 = (int) (this.f4490 + ((this.f4370.f12213.getTotalHeight() - ((ViewGroup.MarginLayoutParams) layoutParams54).height) / 2.0f));
        this.f4531 = (int) (this.f4492 + ((this.f4370.f12213.getTotalHeight() - ((ViewGroup.MarginLayoutParams) layoutParams54).height) / 2.0f));
        this.f4533 = (int) (this.f4494 + ((this.f4370.f12213.getTotalHeight() - ((ViewGroup.MarginLayoutParams) layoutParams54).height) / 2.0f));
        if (C2579.m9452(getContext())) {
            int i36 = this.f4490;
            int i37 = this.f4538;
            this.f4490 = i36 + i37;
            this.f4492 += i37;
            this.f4494 += i37;
            this.f4520 += i37;
            this.f4522 += i37;
            this.f4524 += i37;
            this.f4529 += i37;
            this.f4531 += i37;
            this.f4533 += i37;
        }
        int i38 = (int) f15;
        this.f4518 = i38;
        int i39 = this.f4405;
        int i40 = this.f4381;
        this.f4519 = i38 + i39 + i40;
        int i41 = (int) f16;
        this.f4521 = i41;
        this.f4523 = i41 + i39 + this.f4384;
        int iM14479 = (int) ((((f - f14) - ((ViewGroup.MarginLayoutParams) layoutParams54).width) + i40) - C4792.m14375().m14479(30.0f, this.f4378));
        this.f4527 = iM14479;
        this.f4528 = iM14479 + this.f4405 + this.f4381;
        int iM144792 = (int) ((((this.f4384 + f4) - f14) - ((ViewGroup.MarginLayoutParams) layoutParams54).width) - C4792.m14375().m14479(30.0f, this.f4378));
        this.f4530 = iM144792;
        this.f4532 = iM144792 + this.f4405 + this.f4384;
        TextPaint paint2 = this.f4370.f12217.getPaint();
        float fMeasureText2 = paint2.measureText("00:00:00");
        Paint.FontMetrics fontMetrics5 = paint2.getFontMetrics();
        float f17 = fontMetrics5.bottom - fontMetrics5.top;
        float f18 = fontMetrics5.descent - fontMetrics5.ascent;
        this.f4448.m9176(fMeasureText2);
        this.f4449.m9176(fMeasureText2);
        this.f4450.m9176(fMeasureText2);
        this.f4451.m9176(fMeasureText2);
        ConstraintLayout.LayoutParams layoutParams58 = (ConstraintLayout.LayoutParams) this.f4370.f12217.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams58).rightMargin = (int) (this.f4486 + ((totalWidth - fMeasureText2) / 2.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams58).topMargin = (int) ((((this.f4374 - ((ViewGroup.MarginLayoutParams) layoutParams42).bottomMargin) - totalHeight) - 0.0f) - f17);
        if (C2579.m9452(getContext())) {
            ((ViewGroup.MarginLayoutParams) layoutParams58).topMargin += this.f4538 * 2;
        }
        this.f4370.f12217.setLayoutParams(layoutParams58);
        ConstraintLayout.LayoutParams layoutParams59 = (ConstraintLayout.LayoutParams) this.f4370.f12218.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams59).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams58).rightMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams59).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams58).topMargin;
        this.f4370.f12218.setLayoutParams(layoutParams59);
        ConstraintLayout.LayoutParams layoutParams60 = (ConstraintLayout.LayoutParams) this.f4370.f12219.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams60).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams58).rightMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams60).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams58).topMargin;
        this.f4370.f12219.setLayoutParams(layoutParams60);
        ConstraintLayout.LayoutParams layoutParams61 = (ConstraintLayout.LayoutParams) this.f4370.f12220.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams61).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams58).rightMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams61).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams58).topMargin;
        this.f4370.f12220.setLayoutParams(layoutParams61);
        int iM9441 = C2579.m9441();
        this.f4497 = ((ViewGroup.MarginLayoutParams) layoutParams58).rightMargin;
        this.f4498 = ((ViewGroup.MarginLayoutParams) layoutParams58).topMargin;
        int i42 = this.f4405;
        float f19 = iM9441;
        this.f4501 = this.f4381 + f + i42 + f19;
        this.f4502 = f + f19;
        float f20 = this.f4403;
        float f21 = (fMeasureText2 * (1.0f - f20)) / 2.0f;
        this.f4503 = (((this.f4384 + f4) + i42) - f21) + f19;
        this.f4504 = (f4 - f21) + f19;
        float f22 = (f18 * (1.0f - f20)) / 2.0f;
        this.f4505 = this.f4461 - f22;
        this.f4506 = this.f4462 - f22;
        this.f4507 = this.f4417 - f22;
        if (C2579.m9452(getContext())) {
            ConstraintLayout.LayoutParams layoutParams62 = (ConstraintLayout.LayoutParams) this.f4370.f12231.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams63 = (ConstraintLayout.LayoutParams) this.f4370.f12232.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams64 = (ConstraintLayout.LayoutParams) this.f4370.f12233.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams65 = (ConstraintLayout.LayoutParams) this.f4370.f12234.getLayoutParams();
            int i43 = this.f4538;
            ((ViewGroup.MarginLayoutParams) layoutParams62).topMargin = i43;
            ((ViewGroup.MarginLayoutParams) layoutParams63).topMargin = i43;
            ((ViewGroup.MarginLayoutParams) layoutParams64).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams62).topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams65).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams62).topMargin;
            this.f4370.f12231.setLayoutParams(layoutParams62);
            this.f4370.f12232.setLayoutParams(layoutParams63);
            this.f4370.f12233.setLayoutParams(layoutParams64);
            this.f4370.f12234.setLayoutParams(layoutParams65);
            ConstraintLayout.LayoutParams layoutParams66 = (ConstraintLayout.LayoutParams) this.f4370.f12222.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams66).bottomMargin = this.f4538;
            this.f4370.f12222.setLayoutParams(layoutParams66);
            ((ViewGroup.MarginLayoutParams) layoutParams30).bottomMargin += this.f4538;
            this.f4370.f12186.setLayoutParams(layoutParams30);
            ((ViewGroup.MarginLayoutParams) layoutParams32).bottomMargin += this.f4538;
            this.f4370.f12187.setLayoutParams(layoutParams32);
            ((ViewGroup.MarginLayoutParams) layoutParams33).bottomMargin += this.f4538;
            this.f4370.f12180.setLayoutParams(layoutParams33);
            ((ViewGroup.MarginLayoutParams) layoutParams34).bottomMargin += this.f4538;
            this.f4370.f12181.setLayoutParams(layoutParams34);
            ConstraintLayout.LayoutParams layoutParams67 = (ConstraintLayout.LayoutParams) this.f4370.f12188.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams67).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams30).bottomMargin + this.f4370.f12186.getTotalHeight();
            this.f4370.f12188.setLayoutParams(layoutParams67);
            layoutParams2 = layoutParams28;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin += this.f4538;
            this.f4370.f12176.setLayoutParams(layoutParams2);
            ConstraintLayout.LayoutParams layoutParams68 = layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams68).topMargin += this.f4538;
            this.f4370.f12182.setLayoutParams(layoutParams68);
            ((ViewGroup.MarginLayoutParams) layoutParams37).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams68).topMargin;
            this.f4370.f12184.setLayoutParams(layoutParams37);
        } else {
            layoutParams2 = layoutParams28;
        }
        m4541(false);
        m4489();
        this.f4370.f12221.setAlpha(0.2f);
        this.f4370.f12221.setEnabled(false);
        if (!C2579.m9451(getContext())) {
            this.f4370.f12170.setVisibility(0);
            int iM144764 = (int) (C4792.m14375().m14476(70) * C4792.m14375().m14434());
            ConstraintLayout.LayoutParams layoutParams69 = (ConstraintLayout.LayoutParams) this.f4370.f12171.getLayoutParams();
            int i44 = (int) (iM144764 * 1.1f);
            ((ViewGroup.MarginLayoutParams) layoutParams69).width = i44;
            ((ViewGroup.MarginLayoutParams) layoutParams69).height = i44;
            this.f4370.f12171.setLayoutParams(layoutParams69);
            ConstraintLayout.LayoutParams layoutParams70 = (ConstraintLayout.LayoutParams) this.f4370.f12235.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams70).leftMargin = C4792.m14375().m14476(20);
            this.f4370.f12235.setLayoutParams(layoutParams70);
            this.f4370.f12235.setContentTypeFace(FilmApp.m404());
            this.f4370.f12235.m2562(0, C4792.m14375().m14381());
            this.f4370.f12235.setTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
            int iMeasureText = ((int) this.f4370.f12235.getPaint().measureText(getResources().getString(R.string.ADD_CLOUD_CAMERA))) + ((ViewGroup.MarginLayoutParams) layoutParams69).width + ((ViewGroup.MarginLayoutParams) layoutParams70).leftMargin;
            ConstraintLayout.LayoutParams layoutParams71 = (ConstraintLayout.LayoutParams) this.f4370.f12170.getLayoutParams();
            int i45 = this.f4373 / 2;
            int i46 = ((ViewGroup.MarginLayoutParams) layoutParams27).rightMargin;
            int i47 = ((ViewGroup.MarginLayoutParams) layoutParams27).width;
            ((ViewGroup.MarginLayoutParams) layoutParams71).rightMargin = i46 + i47 + (((i45 - ((i46 + i47) + (((ViewGroup.MarginLayoutParams) layoutParams2).width / 2))) - iMeasureText) / 2);
            ((ViewGroup.MarginLayoutParams) layoutParams71).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams27).bottomMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams71).topMargin = C4792.m14375().m14476(15);
            this.f4370.f12170.setLayoutParams(layoutParams71);
            this.f4370.f12170.setOnClickListener(new ViewOnClickListenerC1649());
            ConstraintLayout constraintLayout = this.f4370.f12170;
            constraintLayout.setOnTouchListener(new ViewOnTouchListenerC3426(constraintLayout));
            if (C4792.m14375().m14484() >= 2.0f) {
                this.f4420 = ((int) ((this.f4371 - C2579.f9598) / 2.0f)) / 2;
            } else {
                this.f4420 = 0;
            }
            this.f4421 = this.f4388;
        }
        m4542();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ࢿ, reason: contains not printable characters */
    public final void m4492() {
        this.f4370.f12178.setOnClickListener(new ViewOnClickListenerC1677());
        AbstractC3491 abstractC3491 = this.f4370;
        abstractC3491.f12177.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC3491.f12176));
        this.f4370.f12177.setOnClickListener(new ViewOnClickListenerC1678());
        this.f4370.f12186.setOnChangeListener(new C1679());
        this.f4370.f12187.setOnChangeListener(new C1680());
        this.f4370.f12180.setOnChangeListener(new C1681());
        this.f4370.f12181.setOnChangeListener(new C1682());
        this.f4427.setOnClickListener(new ViewOnClickListenerC1683());
        this.f4428.setOnClickListener(new ViewOnClickListenerC1684());
        this.f4429.setOnClickListener(new ViewOnClickListenerC1685());
        this.f4430.setOnClickListener(new ViewOnClickListenerC1687());
        this.f4427.setOnTouchListener(new ViewOnTouchListenerC1688());
        this.f4428.setOnTouchListener(new ViewOnTouchListenerC1690());
        this.f4429.setOnTouchListener(new ViewOnTouchListenerC1692());
        this.f4430.setOnTouchListener(new ViewOnTouchListenerC1694());
        this.f4370.f12221.setOnRecordButtonClick(new C1696());
        this.f4370.f12213.setOnChangeClick(new C1729(this.f4448, this));
        this.f4370.f12214.setOnChangeClick(new C1729(this.f4449, this));
        this.f4370.f12215.setOnChangeClick(new C1729(this.f4450, this));
        this.f4370.f12216.setOnChangeClick(new C1729(this.f4451, this));
        this.f4370.f12209.setOnChangeListener(new C1730(this.f4448, this));
        this.f4370.f12210.setOnChangeListener(new C1730(this.f4449, this));
        this.f4370.f12211.setOnChangeListener(new C1730(this.f4450, this));
        this.f4370.f12212.setOnChangeListener(new C1730(this.f4451, this));
        ACHelper.getInstance().setOnMonitorCallback(new C1697());
        this.f4370.f12201.setOnClickListener(new ViewOnClickListenerC1700());
        this.f4370.f12202.setOnClickListener(new ViewOnClickListenerC1701());
        this.f4370.f12203.setOnClickListener(new ViewOnClickListenerC1702());
        this.f4370.f12204.setOnClickListener(new ViewOnClickListenerC1704());
        AbstractC3491 abstractC34912 = this.f4370;
        abstractC34912.f12201.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC34912.f12197));
        AbstractC3491 abstractC34913 = this.f4370;
        abstractC34913.f12202.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC34913.f12198));
        AbstractC3491 abstractC34914 = this.f4370;
        abstractC34914.f12203.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC34914.f12199));
        AbstractC3491 abstractC34915 = this.f4370;
        abstractC34915.f12204.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC34915.f12200));
    }

    /* renamed from: ࣀ, reason: contains not printable characters */
    public final void m4493() {
        this.f4448.m9194(this.f4427);
        this.f4448.m9189(this.f4370.f12227);
        this.f4448.m9157(this.f4431);
        this.f4448.m9195(this.f4435);
        this.f4448.m9188(this.f4370.f12240);
        this.f4448.m9200(this.f4370.f12172);
        this.f4448.m9154(this.f4440);
        this.f4448.m9161(this.f4444);
        this.f4448.m9167(this.f4370.f12186);
        this.f4448.m9146(-2);
        this.f4448.m9158(-1);
        this.f4448.m9182(this.f4370.f12223.getRecordTimeFrame());
        this.f4448.m9185(this.f4370.f12223.getRecordTimeFrame().getLayoutWidth());
        this.f4448.m9180(this.f4370.f12223.getRecordDeviceNum());
        this.f4448.m9184(this.f4370.f12223);
        this.f4448.m9191(this.f4370.f12189);
        this.f4448.m9166(this.f4370.f12213);
        this.f4448.m9173(this.f4370.f12209);
        this.f4448.m9199(this.f4370.f12236);
        this.f4448.m9177(this.f4370.f12217);
        this.f4448.m9151(this.f4370.f12193);
        this.f4448.m9150(this.f4370.f12205);
        this.f4448.m9149(this.f4370.f12197);
        this.f4448.m9148(this.f4370.f12201);
        this.f4448.m9196(this.f4370.f12188);
        this.f4448.m9165(this);
        this.f4449.m9194(this.f4428);
        this.f4449.m9189(this.f4370.f12228);
        this.f4449.m9157(this.f4432);
        this.f4449.m9195(this.f4436);
        this.f4449.m9188(this.f4370.f12241);
        this.f4449.m9200(this.f4370.f12173);
        this.f4449.m9154(this.f4441);
        this.f4449.m9161(this.f4445);
        this.f4449.m9167(this.f4370.f12187);
        this.f4449.m9146(-2);
        this.f4449.m9158(-1);
        this.f4449.m9182(this.f4370.f12224.getRecordTimeFrame());
        this.f4449.m9185(this.f4370.f12224.getRecordTimeFrame().getLayoutWidth());
        this.f4449.m9180(this.f4370.f12224.getRecordDeviceNum());
        this.f4449.m9184(this.f4370.f12224);
        this.f4449.m9191(this.f4370.f12190);
        this.f4449.m9166(this.f4370.f12214);
        this.f4449.m9173(this.f4370.f12210);
        this.f4449.m9199(this.f4370.f12237);
        this.f4449.m9177(this.f4370.f12218);
        this.f4449.m9151(this.f4370.f12194);
        this.f4449.m9150(this.f4370.f12206);
        this.f4449.m9149(this.f4370.f12198);
        this.f4449.m9148(this.f4370.f12202);
        this.f4449.m9196(this.f4370.f12188);
        this.f4449.m9165(this);
        this.f4450.m9194(this.f4429);
        this.f4450.m9189(this.f4370.f12229);
        this.f4450.m9157(this.f4433);
        this.f4450.m9195(this.f4437);
        this.f4450.m9188(this.f4370.f12242);
        this.f4450.m9200(this.f4370.f12174);
        this.f4450.m9154(this.f4442);
        this.f4450.m9161(this.f4446);
        this.f4450.m9167(this.f4370.f12180);
        this.f4450.m9146(-2);
        this.f4450.m9158(-1);
        this.f4450.m9182(this.f4370.f12225.getRecordTimeFrame());
        this.f4450.m9185(this.f4370.f12225.getRecordTimeFrame().getLayoutWidth());
        this.f4450.m9180(this.f4370.f12225.getRecordDeviceNum());
        this.f4450.m9184(this.f4370.f12225);
        this.f4450.m9191(this.f4370.f12191);
        this.f4450.m9166(this.f4370.f12215);
        this.f4450.m9173(this.f4370.f12211);
        this.f4450.m9199(this.f4370.f12238);
        this.f4450.m9177(this.f4370.f12219);
        this.f4450.m9151(this.f4370.f12195);
        this.f4450.m9150(this.f4370.f12207);
        this.f4450.m9149(this.f4370.f12199);
        this.f4450.m9148(this.f4370.f12203);
        this.f4450.m9196(this.f4370.f12188);
        this.f4450.m9165(this);
        this.f4451.m9194(this.f4430);
        this.f4451.m9189(this.f4370.f12230);
        this.f4451.m9157(this.f4434);
        this.f4451.m9195(this.f4438);
        this.f4451.m9188(this.f4370.f12243);
        this.f4451.m9200(this.f4370.f12175);
        this.f4451.m9154(this.f4443);
        this.f4451.m9161(this.f4447);
        this.f4451.m9167(this.f4370.f12181);
        this.f4451.m9146(-2);
        this.f4451.m9158(-1);
        this.f4451.m9182(this.f4370.f12226.getRecordTimeFrame());
        this.f4451.m9185(this.f4370.f12226.getRecordTimeFrame().getLayoutWidth());
        this.f4451.m9180(this.f4370.f12226.getRecordDeviceNum());
        this.f4451.m9184(this.f4370.f12226);
        this.f4451.m9191(this.f4370.f12192);
        this.f4451.m9166(this.f4370.f12216);
        this.f4451.m9173(this.f4370.f12212);
        this.f4451.m9199(this.f4370.f12239);
        this.f4451.m9177(this.f4370.f12220);
        this.f4451.m9151(this.f4370.f12196);
        this.f4451.m9150(this.f4370.f12208);
        this.f4451.m9149(this.f4370.f12200);
        this.f4451.m9148(this.f4370.f12204);
        this.f4451.m9196(this.f4370.f12188);
        this.f4451.m9165(this);
        this.f4455.clear();
        this.f4455.add(this.f4448);
        this.f4455.add(this.f4449);
        this.f4455.add(this.f4450);
        this.f4455.add(this.f4451);
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03c8 A[LOOP:4: B:148:0x03c0->B:150:0x03c8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0230  */
    /* renamed from: ࣁ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4494() {
        /*
            Method dump skipped, instructions count: 1299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.m4494():void");
    }

    /* renamed from: ࣂ, reason: contains not printable characters */
    public final void m4495(boolean z) throws InterruptedException, Resources.NotFoundException {
        C2494 c2494;
        boolean z2;
        AbstractC4012 abstractC4012;
        ACLinkFrameInfoBean acLinkFrameInfoBean;
        AbstractC4012 abstractC40122 = null;
        C4008.m12877(this.f4370.f12185, 0.0f, 0, null);
        C4008.m12877(this.f4370.f12184, 0.0f, 0, null);
        C4008.m12877(this.f4370.f12183, 0.0f, 0, null);
        C4008.m12877(this.f4370.f12182, 0.0f, 0, null);
        this.f4368.clear();
        int i = this.f4425;
        if (i == 2) {
            c2494 = this.f4452;
        } else if (i == 3) {
            c2494 = this.f4452;
            if (FinderManager.getInstance().machineCanConnect(m4480(c2494.m9101())) > 0) {
                c2494.m9158(-1);
            }
        } else {
            c2494 = this.f4455.get(0);
        }
        if (c2494 == null) {
            this.f4465 = false;
            return;
        }
        if (C2579.m9451(getContext())) {
            this.f4448.m9090().setInSingle(false);
            this.f4449.m9090().setInSingle(false);
            this.f4450.m9090().setInSingle(false);
            this.f4451.m9090().setInSingle(false);
            c2494.m9090().setInSingle(true);
            if (!C4041.m12959() && z) {
                C4041.m12956(320, MPEGConst.SEQUENCE_ERROR_CODE);
            }
        }
        int iMax = (int) Math.max(Math.ceil(this.f4440.getPaint().measureText(this.f4452.m9096()) / (this.f4397 * this.f4534)), 1.0d);
        if (this.f4452.m9099() != iMax) {
            this.f4452.m9155(iMax);
            C4008.m12877(this.f4452.m9098(), 0.0f, 100, null);
            for (int i2 = 0; i2 < this.f4455.size(); i2++) {
                C2494 c24942 = this.f4455.get(i2);
                C4008.m12877(c24942.m9098(), 0.0f, 100, null);
                c24942.m9155(iMax);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        long[] jArr = {0};
        this.f4452.m9098().postDelayed(new RunnableC1650(z2, jArr), z2 ? 100L : 0L);
        int i3 = z ? 400 : 10;
        m4467(c2494.m9129());
        this.f4425 = 1;
        this.f4452 = c2494;
        c2494.m9158(c2494.m9090().getLinkIndex());
        MonitorTextureGroupView monitorTextureGroupViewM9131 = c2494.m9131();
        LineFeedTextView lineFeedTextViewM9098 = c2494.m9098();
        MonitorParentView monitorParentViewM9100 = c2494.m9100();
        ConstraintLayout constraintLayoutM9128 = c2494.m9128();
        ACUnitView aCUnitViewM9090 = c2494.m9090();
        CloudPlayerConnectView cloudPlayerConnectViewM9095 = c2494.m9095();
        for (int i4 = 0; i4 < this.f4455.size(); i4++) {
            C2494 c24943 = this.f4455.get(i4);
            C2494 c24944 = this.f4452;
            if (c24943 != c24944) {
                C4008.m12877(c24943.m9129(), 0.0f, i3, new C1652(c24943));
                C4008.m12877(c24943.m9109(), 0.0f, 0, null);
                C4008.m12877(c24943.m9122(), 0.0f, 0, null);
            } else {
                c24944.m9129().setVisibility(0);
                this.f4452.m9129().setAlpha(1.0f);
            }
        }
        if (this.f4452.m9133() == 1) {
            this.f4370.f12222.setAlpha(0.0f);
            this.f4370.f12222.setVisibility(8);
        }
        if (this.f4452.m9133() == 0) {
            C4008.m12877(this.f4452.m9120(), 1.0f, i3, null);
        }
        C2494 c24945 = this.f4452;
        m4504(c24945, c24945.m9101());
        int width = (int) (monitorTextureGroupViewM9131.getWidth() * monitorTextureGroupViewM9131.getScaleX());
        int height = (int) (monitorTextureGroupViewM9131.getHeight() * monitorTextureGroupViewM9131.getScaleY());
        int translationX = (int) monitorTextureGroupViewM9131.getTranslationX();
        int translationY = (int) monitorTextureGroupViewM9131.getTranslationY();
        constraintLayoutM9128.getLeft();
        constraintLayoutM9128.getTop();
        this.f4370.f12187.getRight();
        C4008.m12884(constraintLayoutM9128, 1.0f, 1.0f, i3, null);
        int i5 = 0;
        while (i5 < this.f4455.size()) {
            C2494 c24946 = this.f4455.get(i5);
            if (c24946 == this.f4452) {
                C4008.m12877(c24946.m9109(), 1.0f, i3, abstractC40122);
                m4545(c24946.m9109(), 0.0f, 0.0f, i3);
                if (c24946.m9139()) {
                    c24946.m9109().setVisibility(4);
                    if (C2579.m9452(getContext())) {
                        c24946.m9108().setVisibility(0);
                    }
                    c24946.m9118().setVisibility(4);
                    c24946.m9114().setVisibility(4);
                } else {
                    c24946.m9109().setVisibility(0);
                    c24946.m9114().setVisibility(0);
                    c24946.m9118().setVisibility(0);
                }
                c24946.m9109().m4639(this.f4452.m9101());
            } else {
                c24946.m9109().setVisibility(4);
                C4008.m12877(c24946.m9109(), 0.0f, 0, null);
            }
            i5++;
            abstractC40122 = null;
        }
        postDelayed(new RunnableC1653(i3, width, height, translationX, translationY, monitorTextureGroupViewM9131, monitorParentViewM9100, lineFeedTextViewM9098, aCUnitViewM9090), jArr[0]);
        C4008.m12884(constraintLayoutM9128, 1.0f, 1.0f, i3, null);
        m4545(this.f4370.f12176, this.f4387, 0.0f, i3);
        m4545(this.f4370.f12177, this.f4387, 0.0f, i3);
        m4545(this.f4370.f12222, 0.0f, 0.0f, i3);
        m4545(constraintLayoutM9128, 0.0f, 0.0f, i3);
        m4545(this.f4452.m9124(), 0.0f, 0.0f, i3);
        m4545(this.f4452.m9114(), 1.0f, 1.0f, i3);
        m4545(this.f4452.m9108(), 1.0f, 1.0f, i3);
        m4545(this.f4452.m9118(), 1.0f, 1.0f, i3);
        if (!C2579.m9451(getContext())) {
            m4545(this.f4370.f12170, 0.0f, 0.0f, i3);
        }
        int linkIndex = this.f4452.m9090().getLinkIndex();
        LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(linkIndex);
        m4503((linkEntityByLinkIndex == null || (acLinkFrameInfoBean = linkEntityByLinkIndex.getAcLinkFrameInfoBean()) == null || !r1.m8143(acLinkFrameInfoBean.getVideoDes())) ? false : true, this.f4452.m9133() == 1, false);
        m4545(this.f4452.m9094(), 1.0f, this.f4364, i3);
        m4545(this.f4452.m9093(), 1.0f, 1.0f, i3);
        m4545(this.f4452.m9092(), 1.0f, 1.0f, i3);
        m4545(this.f4452.m9103(), 1.0f, 1.0f, i3);
        m4462(cloudPlayerConnectViewM9095, 0, 0, i3);
        this.f4452.m9084(true, i3);
        if (this.f4452.m9133() == 0) {
            abstractC4012 = null;
            C4008.m12877(this.f4452.m9120(), 1.0f, i3, null);
        } else {
            abstractC4012 = null;
        }
        C4008.m12884(this.f4452.m9124(), 1.0f, 1.0f, i3, abstractC4012);
        C4008.m12884(this.f4452.m9118(), 1.0f, 1.0f, i3, abstractC4012);
        this.f4452.m9108().m4586(1.0f, i3, this.f4452.m9133(), this.f4452.m9140());
        m4502(true, linkIndex, i3, this.f4452.m9140());
        this.f4448.m9108().m4577(true, z);
        this.f4449.m9108().m4577(true, z);
        this.f4450.m9108().m4577(true, z);
        this.f4451.m9108().m4577(true, z);
        if (this.f4452.m9133() == 1) {
            this.f4370.f12170.setVisibility(8);
        }
    }

    /* renamed from: ࣃ, reason: contains not printable characters */
    public final void m4496() {
        this.f4371 = C2579.m9444();
        this.f4372 = C2579.m9445();
        C2579.m9439(getContext());
        this.f4400 = 0;
        C4792.m14375().m14480(15.0f, this.f4378);
        this.f4373 = C2579.m9439(getContext());
        this.f4374 = C2579.m9440(getContext());
        this.f4399 = 0;
        this.f4467 = C4792.m14375().m14459();
        this.f4375 = FilmApp.m404();
        this.f4535 = FilmApp.m403();
        this.f4376 = C4792.m14375().m14381();
        this.f4378 = C4792.m14375().m14434();
        this.f4377 = (int) ((C4792.m14375().m14377() * this.f4378) + 0.5f);
        this.f4403 = 0.8f;
        int i = this.f4372;
        int i2 = this.f4374;
        this.f4538 = (i - i2) / 2;
        int i3 = (int) (i2 * 0.9f);
        this.f4398 = i3;
        int i4 = (int) (i3 * 1.7777778f);
        this.f4397 = i4;
        this.f4397 = i4 + (i4 % 2);
        this.f4398 = i3 + (i3 % 2);
        this.f4406 = (int) ((this.f4373 - r5) / 2.0f);
        this.f4407 = (int) ((i2 - r2) / 2.0f);
        int iM9439 = C2579.m9439(getContext());
        int iM14480 = C4792.m14375().m14480(13.0f, this.f4378);
        this.f4405 = iM14480;
        int i5 = this.f4467;
        int i6 = (int) (((iM9439 - iM14480) / 2.0f) - i5);
        this.f4381 = i6;
        int i7 = (int) ((i6 / 16.0f) * 9.0f);
        this.f4382 = i7;
        int i8 = i6 - (i6 % 2);
        this.f4381 = i8;
        this.f4382 = i7 - (i7 % 2);
        this.f4408 = (int) ((this.f4374 - r8) / 2.0f);
        int i9 = this.f4400 + i5;
        this.f4409 = i9;
        this.f4410 = i9 + iM14480 + i8;
        this.f4411 = (-(iM14480 + i8)) / 2;
        this.f4412 = (iM14480 + i8) / 2;
        this.f4536 = 0;
        this.f4418 = i5 + C4792.m14375().m14476(10);
        this.f4419 = C4792.m14375().m14480(55.0f, this.f4378);
        if (C2579.m9452(getContext())) {
            this.f4419 = C4792.m14375().m14480(4.0f, this.f4378);
            int i10 = (this.f4372 - this.f4374) / 2;
            int iM9447 = C2579.m9447();
            if (i10 > iM9447) {
                this.f4419 += i10 - iM9447;
            }
        }
        this.f4426 = (this.f4373 - this.f4370.f12187.getTotalWidth()) - this.f4467;
        int iM9440 = C2579.m9440(getContext());
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.f4377 / 0.8f);
        textPaint.setTypeface(this.f4375);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        int i11 = (int) (fontMetrics.bottom - fontMetrics.top);
        int iM144802 = C4792.m14375().m14480(25.0f, this.f4378);
        int iM144803 = iM144802 + i11 + C4792.m14375().m14480(15.0f, this.f4378);
        this.f4456 = iM144803;
        int i12 = this.f4405;
        int i13 = (int) (((iM9440 - i12) / 2.0f) - iM144803);
        this.f4383 = i13;
        int i14 = (int) ((i13 * 16.0f) / 9.0f);
        this.f4384 = i14;
        int i15 = i14 + (i14 % 2);
        this.f4384 = i15;
        int i16 = i13 + (i13 % 2);
        this.f4383 = i16;
        int i17 = (int) (((this.f4373 - (i15 * 2)) - i12) / 2.0f);
        this.f4457 = i17;
        this.f4458 = iM144803 + i12 + i16;
        this.f4459 = i17 + i12 + i15;
        this.f4413 = (-(i12 + i16)) / 2;
        this.f4414 = (i16 + i12) / 2;
        this.f4415 = (-(i12 + i15)) / 2;
        this.f4416 = (i12 + i15) / 2;
        this.f4461 = iM144802;
        this.f4462 = (this.f4374 - iM144802) - i11;
        if (C2579.m9452(getContext())) {
            int i18 = this.f4461;
            int i19 = this.f4538;
            this.f4461 = i18 + i19;
            this.f4462 += i19;
        }
        this.f4463 = (int) (((iM9439 - (this.f4384 * 2)) + this.f4405) / 2.0f);
    }

    /* renamed from: ࣄ, reason: contains not printable characters */
    public void m4497(int i) {
        this.f4370.f12176.m4625();
    }

    /* renamed from: ࣅ, reason: contains not printable characters */
    public boolean m4498() {
        return this.f4465;
    }

    /* renamed from: ࣆ, reason: contains not printable characters */
    public final boolean m4499(ACCameraInfoBean aCCameraInfoBean) {
        if (aCCameraInfoBean == null) {
            return false;
        }
        String[] outRange = aCCameraInfoBean.getOutRange();
        String strM5991 = e5.m5988().m5991();
        if (outRange == null || outRange.length <= 0) {
            return false;
        }
        boolean z = false;
        for (String str : outRange) {
            if (str.equals(strM5991)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009e A[PHI: r6
      0x009e: PHI (r6v2 boolean) = (r6v1 boolean), (r6v1 boolean), (r6v1 boolean), (r6v4 boolean) binds: [B:21:0x0074, B:22:0x0076, B:28:0x008a, B:34:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: ࣇ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4500(int r9) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.m4500(int):void");
    }

    /* renamed from: ৼ, reason: contains not printable characters */
    public final void m4501(C2494 c2494) {
        c2494.m9160(System.currentTimeMillis());
        Message message = new Message();
        message.what = 10001;
        message.obj = c2494;
        c2494.m9170(message);
        this.f4367.sendMessageDelayed(message, 3000L);
        c2494.m9145(true);
        if (c2494.m9133() == 0) {
            c2494.m9169(1);
        } else if (c2494.m9133() == 1) {
            c2494.m9169(0);
        }
        c2494.m9108().m4583(3, false);
        LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(c2494.m9101());
        if (linkEntityByLinkIndex != null) {
            linkEntityByLinkIndex.sendAlbumModeEvent();
        }
    }

    /* renamed from: ૹ, reason: contains not printable characters */
    public final void m4502(boolean z, int i, int i2, boolean z2) {
        ACLinkFrameInfoBean acLinkFrameInfoBean;
        if (!z) {
            this.f4370.f12168.hide(i2);
            return;
        }
        LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(i);
        if (linkEntityByLinkIndex != null && (acLinkFrameInfoBean = linkEntityByLinkIndex.getAcLinkFrameInfoBean()) != null && acLinkFrameInfoBean.getCaptureMode() > 0) {
            boolean zIsCloudCameraLink = linkEntityByLinkIndex.isCloudCameraLink();
            boolean z3 = acLinkFrameInfoBean.getVideoMode() == 1;
            if (!zIsCloudCameraLink && this.f4452.m9090().getLinkIndex() == i && !z3 && !this.f4452.m9139()) {
                if (!this.f4475) {
                    this.f4370.f12168.setHasFocusAuto(acLinkFrameInfoBean.isFocusHasAuto());
                    this.f4370.f12168.refreshLayout(acLinkFrameInfoBean.getFocusValue(), acLinkFrameInfoBean.getZoomValue(), acLinkFrameInfoBean.getWheelMode() > 0, acLinkFrameInfoBean.isFocusEnable() && z2, acLinkFrameInfoBean.isZoomEnable() && z2, z2);
                }
                this.f4370.f12168.show(i2);
                return;
            }
        }
        this.f4370.f12168.hide(0);
    }

    /* renamed from: ಀ, reason: contains not printable characters */
    public final void m4503(boolean z, boolean z2, boolean z3) {
        C2494 c2494;
        if (C2579.m9452(getContext())) {
            return;
        }
        if (this.f4424 == z && this.f4423 == z2) {
            return;
        }
        this.f4423 = z2;
        this.f4424 = z;
        if (!z) {
            this.f4364 = this.f4517 - this.f4515;
        } else if (z2) {
            this.f4364 = this.f4517 - this.f4516;
        } else {
            this.f4364 = 1;
        }
        if (this.f4425 == 1 && (c2494 = this.f4452) != null && z3) {
            m4545(c2494.m9094(), 1.0f, this.f4364, 0);
        }
    }

    /* renamed from: ೱ, reason: contains not printable characters */
    public final void m4504(C2494 c2494, int i) throws InterruptedException, Resources.NotFoundException {
        if (this.f4465) {
            return;
        }
        if (this.f4425 == 3) {
            if (FinderManager.getInstance().machineCanConnect(m4480(i)) >= 0 || c2494.m9133() == 2) {
                return;
            }
            m4509();
            return;
        }
        if (i != -1 || c2494.m9133() == 2) {
            return;
        }
        m4509();
    }

    /* renamed from: ೲ, reason: contains not printable characters */
    public final void m4505() {
        if (this.f4465) {
            return;
        }
        int i = this.f4425;
        if (i == 1) {
            LineFeedTextView lineFeedTextViewM9098 = this.f4452.m9098();
            ViewTreeObserver viewTreeObserver = lineFeedTextViewM9098.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1673(lineFeedTextViewM9098, viewTreeObserver));
            return;
        }
        if (i == 2) {
            LineFeedTextView lineFeedTextViewM90982 = this.f4453.m9098();
            LineFeedTextView lineFeedTextViewM90983 = this.f4454.m9098();
            ViewTreeObserver viewTreeObserver2 = this.f4453.m9098().getViewTreeObserver();
            viewTreeObserver2.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1674(lineFeedTextViewM90982, viewTreeObserver2, lineFeedTextViewM90983));
            return;
        }
        if (i == 3) {
            for (int i2 = 0; i2 < this.f4455.size(); i2++) {
                C2494 c2494 = this.f4455.get(i2);
                LineFeedTextView lineFeedTextViewM90984 = c2494.m9098();
                ViewTreeObserver viewTreeObserver3 = lineFeedTextViewM90984.getViewTreeObserver();
                viewTreeObserver3.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1676(lineFeedTextViewM90984, viewTreeObserver3, c2494));
            }
        }
    }

    /* renamed from: ഄ, reason: contains not printable characters */
    public void m4506() throws Resources.NotFoundException {
        if (this.f4370 != null) {
            m4527(this.f4448);
            m4527(this.f4449);
            m4527(this.f4450);
            m4527(this.f4451);
        }
    }

    /* renamed from: ഩ, reason: contains not printable characters */
    public void m4507(String str) {
        this.f4370.f12176.m4627(str);
    }

    /* renamed from: ഺ, reason: contains not printable characters */
    public void m4508(int i, int i2, boolean z, String str, int i3) {
        this.f4370.f12176.m4629(i);
        this.f4370.f12176.m4630(i2, z);
        this.f4370.f12176.m4631(str);
        this.f4370.f12176.m4628(i3);
        this.f4370.f12176.m4632();
        m4532();
    }

    /* renamed from: ൎ, reason: contains not printable characters */
    public void m4509() throws InterruptedException, Resources.NotFoundException {
        int i = this.f4425;
        String str = "";
        if (i == 1) {
            C2494 c2494 = this.f4452;
            if (c2494 == null) {
                return;
            }
            String strM4477 = m4477(c2494);
            if ("LEFT".equals(strM4477)) {
                this.f4452.m9103().setVisibility(0);
            } else {
                this.f4452.m9103().setVisibility(8);
                str = strM4477;
            }
            if (this.f4452.m9096().equals(str)) {
                return;
            }
            this.f4452.m9098().setText(str);
            this.f4452.m9152(str);
            LineFeedTextView lineFeedTextViewM9098 = this.f4452.m9098();
            ViewTreeObserver viewTreeObserver = lineFeedTextViewM9098.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1669(lineFeedTextViewM9098, viewTreeObserver));
            return;
        }
        if (i != 2) {
            if (i == 3) {
                for (int i2 = 0; i2 < this.f4455.size(); i2++) {
                    C2494 c24942 = this.f4455.get(i2);
                    String strM44772 = m4477(c24942);
                    if ("LEFT".equals(strM44772)) {
                        c24942.m9103().setVisibility(0);
                        strM44772 = "";
                    } else {
                        c24942.m9103().setVisibility(8);
                    }
                    if (!c24942.m9096().equals(strM44772)) {
                        c24942.m9098().setText(strM44772);
                        c24942.m9152(strM44772);
                        LineFeedTextView lineFeedTextViewM90982 = c24942.m9098();
                        ViewTreeObserver viewTreeObserver2 = lineFeedTextViewM90982.getViewTreeObserver();
                        viewTreeObserver2.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1672(lineFeedTextViewM90982, viewTreeObserver2, c24942));
                    }
                }
                return;
            }
            return;
        }
        C2494 c24943 = this.f4453;
        if (c24943 != null) {
            String strM44773 = m4477(c24943);
            if ("LEFT".equals(strM44773)) {
                this.f4453.m9103().setVisibility(0);
                strM44773 = "";
            } else {
                this.f4453.m9103().setVisibility(8);
            }
            if (!this.f4453.m9096().equals(strM44773)) {
                this.f4453.m9098().setText(strM44773);
                this.f4453.m9152(strM44773);
                LineFeedTextView lineFeedTextViewM90983 = this.f4453.m9098();
                ViewTreeObserver viewTreeObserver3 = this.f4453.m9098().getViewTreeObserver();
                viewTreeObserver3.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1670(lineFeedTextViewM90983, viewTreeObserver3));
            }
        }
        C2494 c24944 = this.f4454;
        if (c24944 != null) {
            String strM44774 = m4477(c24944);
            if ("LEFT".equals(strM44774)) {
                this.f4454.m9103().setVisibility(0);
            } else {
                this.f4454.m9103().setVisibility(8);
                str = strM44774;
            }
            if (this.f4454.m9096().equals(str)) {
                return;
            }
            this.f4454.m9098().setText(str);
            this.f4454.m9152(str);
            LineFeedTextView lineFeedTextViewM90984 = this.f4454.m9098();
            ViewTreeObserver viewTreeObserver4 = this.f4454.m9098().getViewTreeObserver();
            viewTreeObserver4.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1671(lineFeedTextViewM90984, viewTreeObserver4));
        }
    }

    /* renamed from: ൔ, reason: contains not printable characters */
    public void m4510() {
        this.f4466 = false;
        this.f4425 = 1;
        m4467(this.f4452.m9129());
        this.f4370.f12176.m4622();
        if (this.f4452.m9129().getVisibility() == 8) {
            this.f4452.m9129().setVisibility(0);
            this.f4452.m9129().setAlpha(1.0f);
        }
        for (int i = 0; i < this.f4455.size(); i++) {
            C2494 c2494 = this.f4455.get(i);
            m4472(c2494);
            m4534(c2494, -1);
            c2494.m9109().m4639(-1);
            c2494.m9146(-2);
            c2494.m9088();
            c2494.m9163(-1);
        }
    }

    /* renamed from: ൕ, reason: contains not printable characters */
    public final void m4511(LinkEntity linkEntity) {
        int linkIndex = linkEntity.getLinkIndex();
        int i = this.f4425;
        if (i == 1) {
            if (linkIndex == -1 || this.f4452.m9133() == 0) {
                return;
            }
            m4536(this.f4452, linkEntity);
            return;
        }
        if (i != 2) {
            C2494 c2494M4483 = m4483(linkIndex);
            if (c2494M4483 == null || FinderManager.getInstance().machineCanConnect(m4480(linkIndex)) < 0 || c2494M4483.m9133() == 0) {
                return;
            }
            m4536(c2494M4483, linkEntity);
            return;
        }
        if (linkIndex == -1) {
            return;
        }
        List<C2494> listM4484 = m4484(linkIndex);
        if (r1.m8144(listM4484)) {
            for (int i2 = 0; i2 < listM4484.size(); i2++) {
                C2494 c2494 = listM4484.get(i2);
                if (c2494.m9133() == 0) {
                    return;
                }
                m4536(c2494, linkEntity);
            }
        }
    }

    /* renamed from: ൖ, reason: contains not printable characters */
    public final void m4512(int i, String str) {
        if (str == null) {
            return;
        }
        int i2 = this.f4425;
        if (i2 == 1) {
            if (i == -1 || this.f4452.m9116().equals(str)) {
                return;
            }
            this.f4452.m9118().m2561(str);
            this.f4452.m9175(str);
            m4537(this.f4452.m9118(), 1.0f, 1.0f);
            return;
        }
        if (i2 != 2) {
            C2494 c2494M4483 = m4483(i);
            if (c2494M4483 == null || FinderManager.getInstance().machineCanConnect(m4480(i)) < 0 || c2494M4483.m9116().equals(str)) {
                return;
            }
            c2494M4483.m9118().m2561(str);
            c2494M4483.m9175(str);
            return;
        }
        if (i == -1) {
            return;
        }
        String strM9116 = this.f4453.m9116();
        String strM91162 = this.f4454.m9116();
        if (i == this.f4453.m9101() && !strM9116.equals(str)) {
            this.f4453.m9118().m2561(str);
            this.f4453.m9175(str);
        }
        if (i != this.f4454.m9101() || strM91162.equals(str)) {
            return;
        }
        this.f4454.m9118().m2561(str);
        this.f4454.m9175(str);
    }

    /* renamed from: ൟ, reason: contains not printable characters */
    public final void m4513(C2494 c2494, boolean z) {
        if (z) {
            c2494.m9087();
            c2494.m9202();
            if (this.f4425 == 1) {
                c2494.m9108().m4581(true, 0, c2494.m9140());
            }
        }
    }

    /* renamed from: ຆ, reason: contains not printable characters */
    public final void m4514(C2494 c2494, LinkEntity linkEntity) {
        ACCameraInfoBean acCameraInfoBean;
        boolean zIsPlaying;
        if (c2494.m9133() != 1 || linkEntity == null || (acCameraInfoBean = linkEntity.getAcCameraInfoBean()) == null || c2494.m9142() == (zIsPlaying = acCameraInfoBean.isPlaying())) {
            return;
        }
        c2494.m9114().m4608(zIsPlaying);
        c2494.m9178(zIsPlaying);
    }

    /* renamed from: ຉ, reason: contains not printable characters */
    public void m4515() {
        int i = this.f4425;
        if (i == 1) {
            LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4452.m9101());
            m4514(this.f4452, linkEntityByLinkIndex);
            m4516(this.f4452, linkEntityByLinkIndex);
            return;
        }
        if (i == 2) {
            LinkEntity linkEntityByLinkIndex2 = LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4453.m9101());
            LinkEntity linkEntityByLinkIndex3 = LinkManager.getInstance().getLinkEntityByLinkIndex(this.f4454.m9101());
            m4514(this.f4453, linkEntityByLinkIndex2);
            m4514(this.f4454, linkEntityByLinkIndex3);
            m4516(this.f4453, linkEntityByLinkIndex2);
            m4516(this.f4454, linkEntityByLinkIndex3);
            return;
        }
        for (int i2 = 0; i2 < this.f4455.size(); i2++) {
            C2494 c2494 = this.f4455.get(i2);
            LinkEntity linkEntityByLinkIndex4 = LinkManager.getInstance().getLinkEntityByLinkIndex(c2494.m9101());
            m4514(c2494, linkEntityByLinkIndex4);
            m4516(c2494, linkEntityByLinkIndex4);
        }
    }

    /* renamed from: ຌ, reason: contains not printable characters */
    public final void m4516(C2494 c2494, LinkEntity linkEntity) throws InterruptedException, Resources.NotFoundException {
        if (c2494 == null) {
            return;
        }
        if (linkEntity != null) {
            m4468(linkEntity.getLinkIndex(), linkEntity);
        }
        String strM4477 = m4477(c2494);
        if ("LEFT".equals(strM4477)) {
            c2494.m9103().setVisibility(0);
            strM4477 = "";
        } else {
            c2494.m9103().setVisibility(8);
        }
        String str = strM4477;
        if (c2494.m9096().equals(str)) {
            return;
        }
        c2494.m9098().setText(str);
        c2494.m9152(str);
        if (this.f4465) {
            return;
        }
        LineFeedTextView lineFeedTextViewM9098 = c2494.m9098();
        ViewTreeObserver viewTreeObserver = c2494.m9098().getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1706(lineFeedTextViewM9098, c2494, str, viewTreeObserver));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009a A[PHI: r7
      0x009a: PHI (r7v33 int) = (r7v0 int), (r7v0 int), (r7v36 int) binds: [B:20:0x006c, B:22:0x0072, B:27:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* renamed from: ຎ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4517(boolean r25) {
        /*
            Method dump skipped, instructions count: 1395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.m4517(boolean):void");
    }

    /* renamed from: ຏ, reason: contains not printable characters */
    public final void m4518() {
        if (this.f4465) {
            return;
        }
        int iM9133 = this.f4452.m9133();
        if (iM9133 == 0) {
            m4520();
        } else if (iM9133 == 1 && this.f4425 == 1) {
            m4519();
        }
    }

    /* renamed from: ຐ, reason: contains not printable characters */
    public final void m4519() {
        if (this.f4370.f12222.getAlpha() != 0.0f || this.f4370.f12222.getVisibility() == 0) {
            this.f4370.f12222.setAlpha(0.0f);
            this.f4370.f12222.setVisibility(8);
            this.f4370.f12222.setEnabled(false);
        }
    }

    /* renamed from: ຑ, reason: contains not printable characters */
    public final void m4520() {
        if (this.f4370.f12222.getAlpha() != 1.0f || this.f4370.f12222.getVisibility() == 8) {
            this.f4370.f12222.setEnabled(true);
            this.f4370.f12222.setAlpha(1.0f);
            this.f4370.f12222.setVisibility(0);
        }
    }

    /* renamed from: ຒ, reason: contains not printable characters */
    public void m4521() {
        int recordStatus = getRecordStatus();
        if (this.f4422 == recordStatus) {
            return;
        }
        this.f4422 = recordStatus;
        int monitorEnableState = TransmitHelper.getMonitorEnableState(recordStatus);
        int monitorRecordState = TransmitHelper.getMonitorRecordState(this.f4422);
        if (monitorEnableState != 1) {
            if (this.f4370.f12221.isEnabled()) {
                this.f4370.f12221.setEnabled(false);
            }
            if (this.f4370.f12221.getAlpha() != 0.3f) {
                this.f4370.f12221.setAlpha(0.3f);
            }
        } else {
            if (!this.f4370.f12221.isEnabled()) {
                this.f4370.f12221.setEnabled(true);
            }
            if (this.f4370.f12221.getAlpha() != 1.0f) {
                this.f4370.f12221.setAlpha(1.0f);
            }
        }
        int state = this.f4370.f12221.getState();
        if (monitorRecordState != 1) {
            if (state != 0) {
                this.f4370.f12221.setStateWithAnim(0);
            }
        } else if (state != 1) {
            this.f4370.f12221.setStateWithAnim(1);
        }
    }

    /* renamed from: ຓ, reason: contains not printable characters */
    public final void m4522(int i, String str) {
        if (str == null) {
            return;
        }
        int i2 = this.f4425;
        if (i2 == 1) {
            if (i == -1 || this.f4452.m9121().equals(str) || i != this.f4452.m9090().getLinkIndex()) {
                return;
            }
            this.f4452.m9120().m2561(str);
            this.f4452.m9181(str);
            return;
        }
        if (i2 != 2) {
            C2494 c2494M4483 = m4483(i);
            if (c2494M4483 == null || c2494M4483.m9121().equals(str)) {
                return;
            }
            c2494M4483.m9120().m2561(str);
            c2494M4483.m9181(str);
            return;
        }
        if (i == -1) {
            return;
        }
        List<C2494> listM4484 = m4484(i);
        if (r1.m8144(listM4484)) {
            for (int i3 = 0; i3 < listM4484.size(); i3++) {
                C2494 c2494 = listM4484.get(i3);
                if (!c2494.m9121().equals(str)) {
                    c2494.m9120().m2561(str);
                    c2494.m9181(str);
                }
            }
        }
    }

    /* renamed from: ຘ, reason: contains not printable characters */
    public final void m4523(int i, String str) {
        if (str == null) {
            return;
        }
        int i2 = this.f4425;
        if (i2 == 1) {
            if (i == -1 || this.f4452.m9123().equals(str)) {
                return;
            }
            this.f4452.m9122().m2513(str);
            this.f4452.m9183(str);
            this.f4452.m9163(i);
            if (this.f4452.m9131().getRatioCoverView().getAlpha() < 1.0f) {
                m4517(false);
                return;
            }
            return;
        }
        if (i2 != 2) {
            C2494 c2494M4483 = m4483(i);
            if (c2494M4483 == null || c2494M4483.m9123().equals(str) || FinderManager.getInstance().machineCanConnect(m4480(i)) < 0) {
                return;
            }
            if (c2494M4483.m9131().getRatioCoverView().getAlpha() < 1.0f) {
                m4517(false);
            }
            c2494M4483.m9122().m2513(str);
            c2494M4483.m9183(str);
            c2494M4483.m9163(i);
            return;
        }
        if (i == -1) {
            return;
        }
        String strM9123 = this.f4453.m9123();
        String strM91232 = this.f4454.m9123();
        if (i == this.f4453.m9101()) {
            if (!strM9123.equals(str)) {
                this.f4453.m9122().m2513(str);
                this.f4453.m9183(str);
            }
            this.f4453.m9163(i);
            if (this.f4453.m9131().getRatioCoverView().getAlpha() < 1.0f) {
                m4517(false);
            }
        }
        if (i == this.f4454.m9101()) {
            if (!strM91232.equals(str)) {
                this.f4454.m9122().m2513(str);
                this.f4454.m9183(str);
            }
            this.f4454.m9163(i);
            if (this.f4454.m9131().getRatioCoverView().getAlpha() < 1.0f) {
                m4517(false);
            }
        }
    }

    /* renamed from: ຠ, reason: contains not printable characters */
    public final void m4524(C2494 c2494, boolean z) {
        boolean z2 = FinderManager.getInstance().machineCanConnect(m4480(c2494.m9101())) > 0;
        if (!z) {
            c2494.m9085();
            c2494.m9203();
        }
        if (z || !z2) {
            c2494.m9120().setAlpha(0.0f);
        } else {
            c2494.m9120().setAlpha(1.0f);
        }
    }

    /* renamed from: ຨ, reason: contains not printable characters */
    public final void m4525(C2494 c2494, LinkEntity linkEntity) {
        if (c2494 == null || linkEntity == null) {
            return;
        }
        String strM4482 = m4482(linkEntity);
        String strM9126 = c2494.m9126();
        if (r1.m8143(strM4482)) {
            if (!strM9126.equals(strM4482)) {
                c2494.m9127().m2561(strM4482);
                c2494.m9187(strM4482);
            }
            if (c2494.m9127().getAlpha() != 1.0f && c2494.m9133() == 0) {
                m4461(true, c2494.m9127(), null);
            }
        } else if (r1.m8143(c2494.m9126())) {
            c2494.m9127().m2561("");
            c2494.m9187("");
            c2494.m9190(0);
            m4461(false, c2494.m9127(), null);
        }
        if (c2494.m9137() == -1) {
            m4531(c2494, linkEntity.getLinkIndex());
        }
    }

    /* renamed from: ຩ, reason: contains not printable characters */
    public final void m4526() {
        if (this.f4452 == null) {
            this.f4452 = this.f4455.get(3);
        }
        if (this.f4452.m9101() == -1) {
            for (int i = 0; i < this.f4455.size(); i++) {
                C2494 c2494 = this.f4455.get(i);
                if (c2494.m9090().getLinkIndex() != -1) {
                    this.f4452 = c2494;
                    return;
                }
            }
        }
    }

    /* renamed from: ຬ, reason: contains not printable characters */
    public final void m4527(C2494 c2494) throws Resources.NotFoundException {
        LinkEntity linkEntityByLinkIndex;
        if (c2494 != null) {
            int iM9101 = c2494.m9101();
            if (iM9101 == -1 || !c2494.m9139() || (linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(iM9101)) == null || linkEntityByLinkIndex.getRealLinkStatus() != 2) {
                c2494.m9095().m4227("");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - linkEntityByLinkIndex.getmCreateTime();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            c2494.m9095().m4227(String.format("%02d:%02d:%02d", Long.valueOf(timeUnit.toHours(jCurrentTimeMillis)), Long.valueOf(timeUnit.toMinutes(jCurrentTimeMillis) - TimeUnit.HOURS.toMinutes(timeUnit.toHours(jCurrentTimeMillis))), Long.valueOf(timeUnit.toSeconds(jCurrentTimeMillis) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(jCurrentTimeMillis)))));
        }
    }

    /* renamed from: ໞ, reason: contains not printable characters */
    public final void m4528(LinkEntity linkEntity) {
        if (this.f4465) {
            return;
        }
        int linkIndex = linkEntity.getLinkIndex();
        ACLinkFrameInfoBean acLinkFrameInfoBean = linkEntity.getAcLinkFrameInfoBean();
        ACCameraInfoBean acCameraInfoBean = linkEntity.getAcCameraInfoBean();
        if (acCameraInfoBean == null || acLinkFrameInfoBean == null) {
            return;
        }
        acCameraInfoBean.getControlable();
        int videoMode = acLinkFrameInfoBean.getVideoMode();
        m4470(linkIndex, videoMode, linkEntity);
        m4468(linkIndex, linkEntity);
        String videoTimeCode = acLinkFrameInfoBean.getVideoTimeCode();
        String videoDes = acLinkFrameInfoBean.getVideoDes();
        if (videoMode == 0) {
            m4523(linkIndex, videoTimeCode);
            m4522(linkIndex, videoDes);
        } else {
            m4511(linkEntity);
            m4512(linkIndex, videoTimeCode);
        }
        m4521();
        m4518();
        if (!(this.f4425 == 1)) {
            m4502(false, linkIndex, 0, true);
        } else if (this.f4452.m9090().getLinkIndex() == linkIndex) {
            m4502(true, linkIndex, 0, this.f4452.m9140());
            m4503(true, this.f4452.m9133() == 1, true);
        }
    }

    /* renamed from: ໟ, reason: contains not printable characters */
    public void m4529() {
        if (this.f4465) {
            return;
        }
        m4466();
        AbstractC3491 abstractC3491 = this.f4370;
        if (abstractC3491 != null) {
            abstractC3491.f12186.m4647();
        }
        AbstractC3491 abstractC34912 = this.f4370;
        if (abstractC34912 != null) {
            abstractC34912.f12187.m4647();
            this.f4370.f12180.m4647();
            this.f4370.f12181.m4647();
        }
    }

    /* renamed from: ྈ, reason: contains not printable characters */
    public final void m4530(int i) {
        int i2 = this.f4425;
        if (i2 == 1) {
            if (i == this.f4452.m9105()) {
                this.f4452.m9088();
                this.f4452.m9163(-1);
                this.f4452.m9090().setTextureCanRender(false);
                this.f4452.m9090().clearTexture();
                m4502(false, i, 0, true);
                m4503(false, false, true);
            }
        } else if (i2 == 2) {
            if (this.f4453.m9105() == i) {
                this.f4453.m9088();
                this.f4453.m9163(-1);
                this.f4453.m9090().setTextureCanRender(false);
                this.f4453.m9090().clearTexture();
            }
            if (this.f4454.m9105() == i) {
                this.f4454.m9088();
                this.f4454.m9163(-1);
                this.f4454.m9090().setTextureCanRender(false);
                this.f4454.m9090().clearTexture();
            }
        } else {
            for (int i3 = 0; i3 < this.f4455.size(); i3++) {
                C2494 c2494 = this.f4455.get(i3);
                if (c2494.m9105() == i) {
                    c2494.m9088();
                    c2494.m9163(-1);
                    c2494.m9090().setTextureCanRender(false);
                    c2494.m9090().clearTexture();
                }
            }
        }
        m4521();
    }

    /* renamed from: ྉ, reason: contains not printable characters */
    public final void m4531(C2494 c2494, int i) {
        LinkEntity linkEntityByLinkIndex = LinkManager.getInstance().getLinkEntityByLinkIndex(i);
        if (this.f4465 || c2494 == null) {
            return;
        }
        if (linkEntityByLinkIndex == null) {
            c2494.m9136().setAlpha(0.0f);
            return;
        }
        int iM4487 = m4487(linkEntityByLinkIndex);
        ACLinkFrameInfoBean acLinkFrameInfoBean = linkEntityByLinkIndex.getAcLinkFrameInfoBean();
        ACCameraInfoBean acCameraInfoBean = linkEntityByLinkIndex.getAcCameraInfoBean();
        if (acCameraInfoBean != null) {
            String netType = acCameraInfoBean.getNetType();
            c2494.m9136().m4164(("Wi-Fi".equals(netType) || !r1.m8143(netType)) ? 0 : 1);
        }
        if (iM4487 == c2494.m9137()) {
            return;
        }
        if (iM4487 == 4) {
            c2494.m9136().setAlpha(0.0f);
            return;
        }
        if (c2494.m9097() == 1) {
            c2494.m9136().setAlpha(0.0f);
        } else if (acLinkFrameInfoBean != null) {
            c2494.m9201(iM4487);
            c2494.m9136().setAlpha(1.0f);
            c2494.m9136().m4171(iM4487);
        }
    }

    /* renamed from: ྌ, reason: contains not printable characters */
    public void m4532() {
        int i = this.f4425;
        if (i == 1) {
            C2494 c2494 = this.f4452;
            if (c2494 != null) {
                m4531(c2494, c2494.m9101());
                return;
            }
            return;
        }
        if (i != 2) {
            if (i == 3) {
                m4531(m4483(0), 0);
                m4531(m4483(1), 1);
                m4531(m4483(2), 2);
                m4531(m4483(3), 3);
                return;
            }
            return;
        }
        C2494 c24942 = this.f4453;
        if (c24942 != null) {
            m4531(c24942, c24942.m9101());
        }
        C2494 c24943 = this.f4454;
        if (c24943 != null) {
            m4531(c24943, c24943.m9101());
        }
    }

    /* renamed from: ဢ, reason: contains not printable characters */
    public final void m4533(C2494 c2494, boolean z, float f, float f2, int i, boolean z2, boolean z3) {
        if (c2494 != null) {
            if (i > 0 && c2494.m9131().getRatioCoverView().getAlpha() < 1.0f) {
                i = 0;
            }
            MonitorTextureGroupView monitorTextureGroupViewM9131 = c2494.m9131();
            if (f != c2494.m9119() || f2 != c2494.m9106()) {
                monitorTextureGroupViewM9131.m4635(f, f2, i != 0);
                c2494.m9164(f2);
                c2494.m9179(f);
            }
            if (z != c2494.m9141()) {
                c2494.m9168(z);
                if (z) {
                    monitorTextureGroupViewM9131.m4636(C4792.m14375().m14414(), i);
                } else {
                    monitorTextureGroupViewM9131.m4636(C4792.m14375().m14413(), i);
                }
            }
            boolean zM2412 = monitorTextureGroupViewM9131.getRatioCoverView().m2412();
            if (!zM2412 && monitorTextureGroupViewM9131.getRatioCoverView().m2401() && c2494.m9119() == 1.7777778f) {
                monitorTextureGroupViewM9131.getRatioCoverView().m2413();
                zM2412 = true;
            }
            if (!zM2412 || !z2 || monitorTextureGroupViewM9131.getRatioCoverView().getAlpha() >= 1.0f || c2494.m9101() == -1) {
                return;
            }
            monitorTextureGroupViewM9131.getRatioCoverView().setAlpha(1.0f);
            c2494.m9090().getTextureView().setCanShow(true);
        }
    }

    /* renamed from: ဨ, reason: contains not printable characters */
    public final void m4534(C2494 c2494, int i) throws InterruptedException, Resources.NotFoundException {
        ACUnitView aCUnitViewM9090 = c2494.m9090();
        aCUnitViewM9090.setLinkIndex(i);
        if (i == -1) {
            aCUnitViewM9090.setTextureCanRender(false);
            aCUnitViewM9090.clearTexture();
            if (c2494.m9101() != i) {
                c2494.m9088();
                c2494.m9131().getRatioCoverView().setAlpha(0.0f);
                c2494.m9090().getTextureView().setCanShow(false);
            }
        } else if (FinderManager.getInstance().machineCanConnect(m4480(i)) > 0) {
            aCUnitViewM9090.setTextureCanRender(true);
            if (c2494.m9101() != i) {
                c2494.m9088();
                c2494.m9131().getRatioCoverView().setAlpha(0.0f);
                c2494.m9090().getTextureView().setCanShow(false);
            }
        } else {
            aCUnitViewM9090.setTextureCanRender(false);
            aCUnitViewM9090.clearTexture();
            if (c2494.m9101() != i) {
                c2494.m9088();
                c2494.m9131().getRatioCoverView().setAlpha(0.0f);
                c2494.m9090().getTextureView().setCanShow(false);
            }
        }
        m4504(c2494, i);
    }

    /* renamed from: ၚ, reason: contains not printable characters */
    public final void m4535(C2494 c2494, int i) throws InterruptedException, Resources.NotFoundException {
        ACUnitView aCUnitViewM9090 = c2494.m9090();
        aCUnitViewM9090.setTextureCanRender(false);
        aCUnitViewM9090.setLinkIndex(i);
        if (i != -1) {
            aCUnitViewM9090.setTextureCanRender(true);
        } else {
            aCUnitViewM9090.setTextureCanRender(false);
            aCUnitViewM9090.clearTexture();
        }
        c2494.m9088();
        m4504(c2494, i);
        if (c2494.m9131().getRatioCoverView().getAlpha() > 0.0f) {
            c2494.m9131().getRatioCoverView().setAlpha(0.0f);
            c2494.m9131().getAcUnitView().getTextureView().setCanShow(false);
        }
    }

    /* renamed from: ၛ, reason: contains not printable characters */
    public final void m4536(C2494 c2494, LinkEntity linkEntity) {
        ACLinkFrameInfoBean acLinkFrameInfoBean = linkEntity.getAcLinkFrameInfoBean();
        if (acLinkFrameInfoBean == null) {
            return;
        }
        String videoDes = acLinkFrameInfoBean.getVideoDes();
        acLinkFrameInfoBean.getVideoTimeCode();
        double videoPercent = acLinkFrameInfoBean.getVideoPercent();
        int videoTag = acLinkFrameInfoBean.getVideoTag();
        ACCameraInfoBean acCameraInfoBean = linkEntity.getAcCameraInfoBean();
        if (acCameraInfoBean == null) {
            return;
        }
        int albumControlable = acCameraInfoBean.getAlbumControlable();
        if (videoDes != null && !c2494.m9134().equals(videoDes)) {
            c2494.m9135().m2561(m4486(videoDes));
            c2494.m9198(videoDes);
        }
        if (c2494.m9113() != videoTag) {
            c2494.m9108().m4582(videoTag);
            c2494.m9172(videoTag);
        }
        if (c2494.m9112() != albumControlable) {
            if (c2494.m9140()) {
                c2494.m9114().m4612(albumControlable);
                c2494.m9171(albumControlable);
            } else {
                c2494.m9114().m4612(3);
            }
        }
        if (c2494.m9115() != videoPercent) {
            c2494.m9100().setProgress(videoPercent);
            c2494.m9174(videoPercent);
        }
        c2494.m9163(linkEntity.getLinkIndex());
    }

    /* renamed from: ၜ, reason: contains not printable characters */
    public final void m4537(View view, float f, float f2) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    /* renamed from: ၝ, reason: contains not printable characters */
    public final void m4538(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        view.setLayoutParams(layoutParams);
        view.setTranslationX(i3);
        view.setTranslationY(i4);
    }

    /* renamed from: ၡ, reason: contains not printable characters */
    public void m4539() {
        this.f4465 = true;
        m4490();
    }

    /* renamed from: ၥ, reason: contains not printable characters */
    public void m4540() {
        this.f4465 = true;
        this.f4466 = false;
        m4494();
    }

    /* renamed from: ၦ, reason: contains not printable characters */
    public boolean m4541(boolean z) {
        this.f4465 = true;
        m4526();
        this.f4460 = false;
        m4495(z);
        C2494 c2494 = this.f4452;
        if (c2494 != null) {
            return c2494.m9139();
        }
        return false;
    }

    /* renamed from: ၮ, reason: contains not printable characters */
    public final void m4542() {
    }

    /* renamed from: ၯ, reason: contains not printable characters */
    public final void m4543(C2494 c2494, C2494 c24942, float f, int i) {
        int i2;
        AbstractC4012 abstractC4012;
        int i3;
        LineFeedTextView lineFeedTextView;
        MonitorTextureGroupView monitorTextureGroupViewM9131 = c2494.m9131();
        LineFeedTextView lineFeedTextViewM9098 = c2494.m9098();
        MonitorParentView monitorParentViewM9100 = c2494.m9100();
        ConstraintLayout constraintLayoutM9128 = c2494.m9128();
        ACUnitView aCUnitViewM9090 = c2494.m9090();
        CloudPlayerConnectView cloudPlayerConnectViewM9095 = c2494.m9095();
        MonitorTextureGroupView monitorTextureGroupViewM91312 = c24942.m9131();
        LineFeedTextView lineFeedTextViewM90982 = c24942.m9098();
        MonitorParentView monitorParentViewM91002 = c24942.m9100();
        ConstraintLayout constraintLayoutM91282 = c24942.m9128();
        ACUnitView aCUnitViewM90902 = c24942.m9090();
        CloudPlayerConnectView cloudPlayerConnectViewM90952 = c24942.m9095();
        int i4 = 0;
        while (i4 < this.f4455.size()) {
            C2494 c24943 = this.f4455.get(i4);
            if (c24943 == c2494 || c24943 == c24942) {
                lineFeedTextView = lineFeedTextViewM9098;
                c24943.m9129().setVisibility(0);
                C4008.m12877(c24943.m9129(), 1.0f, 400, null);
                c24943.m9109().setVisibility(0);
                C4008.m12877(c24943.m9109(), 1.0f, 400, null);
                if (c24943 == c2494) {
                    m4545(c24943.m9109(), this.f4396, this.f4395, 400);
                }
                if (c24943 == c24942) {
                    m4545(c24943.m9109(), this.f4472, this.f4395, 400);
                }
                c24943.m9108().m4586(this.f4487, 400, c24943.m9133(), c24943.m9140());
            } else {
                lineFeedTextView = lineFeedTextViewM9098;
                C4008.m12877(c24943.m9129(), 0.0f, 400, null);
                C4008.m12877(c24943.m9128(), 0.0f, 400, new C1659(c24943));
                C4008.m12877(c24943.m9109(), 0.0f, 0, null);
            }
            i4++;
            lineFeedTextViewM9098 = lineFeedTextView;
        }
        LineFeedTextView lineFeedTextView2 = lineFeedTextViewM9098;
        if (this.f4370.f12222.getAlpha() == 0.0f || this.f4370.f12222.getVisibility() == 8) {
            i2 = 0;
            this.f4370.f12222.setVisibility(0);
            abstractC4012 = null;
            i3 = 400;
            C4008.m12877(this.f4370.f12222, 1.0f, 400, null);
        } else {
            i2 = 0;
            abstractC4012 = null;
            i3 = 400;
        }
        this.f4453.m9109().setVisibility(i2);
        this.f4454.m9109().setVisibility(i2);
        float f2 = this.f4403;
        C4008.m12884(constraintLayoutM9128, f2, f2, i3, abstractC4012);
        float f3 = this.f4403;
        C4008.m12884(constraintLayoutM91282, f3, f3, i3, abstractC4012);
        RecordTimeLayout recordTimeLayoutM9124 = this.f4453.m9124();
        float f4 = this.f4473;
        C4008.m12884(recordTimeLayoutM9124, f4, f4, i3, abstractC4012);
        RecordTimeLayout recordTimeLayoutM91242 = this.f4454.m9124();
        float f5 = this.f4473;
        C4008.m12884(recordTimeLayoutM91242, f5, f5, i3, abstractC4012);
        StrokeTextView strokeTextViewM9118 = this.f4453.m9118();
        float f6 = this.f4403;
        C4008.m12884(strokeTextViewM9118, f6, f6, i3, abstractC4012);
        StrokeTextView strokeTextViewM91182 = this.f4454.m9118();
        float f7 = this.f4403;
        C4008.m12884(strokeTextViewM91182, f7, f7, i3, abstractC4012);
        C4008.m12877(this.f4454.m9120(), 1.0f, 0, abstractC4012);
        C4008.m12877(this.f4453.m9120(), 1.0f, 0, abstractC4012);
        m4502(false, -1, 100, true);
        this.f4453.m9109().m4639(this.f4453.m9101());
        this.f4454.m9109().m4639(this.f4454.m9101());
        int i5 = this.f4410;
        int iM9125 = (int) (this.f4511 - (c2494.m9125() * this.f4473));
        int iM91252 = (int) (this.f4512 - (c24942.m9125() * this.f4473));
        m4545(this.f4370.f12176, this.f4387, this.f4388, 400);
        m4545(this.f4370.f12177, this.f4387, this.f4388, 400);
        m4545(this.f4370.f12222, this.f4391, this.f4392, 400);
        m4545(constraintLayoutM9128, this.f4409 - this.f4418, this.f4417 - this.f4419, 400);
        m4545(constraintLayoutM91282, i5 - this.f4418, this.f4417 - this.f4419, 400);
        if (c2494.m9125() != 0.0f) {
            m4545(c2494.m9124(), iM9125 - this.f4510, this.f4476 - this.f4477, 400);
            this.f4453.m9084(false, 400);
        }
        if (c24942.m9125() != 0.0f) {
            m4545(c24942.m9124(), iM91252 - this.f4510, this.f4476 - this.f4477, 400);
            this.f4454.m9084(false, 400);
        }
        m4545(c2494.m9114(), this.f4486 - this.f4479, this.f4485 - this.f4478, 400);
        m4545(c24942.m9114(), this.f4486 - this.f4480, this.f4485 - this.f4478, 400);
        m4545(c2494.m9108(), this.f4495 - this.f4488, this.f4490 - this.f4496, 400);
        m4545(c24942.m9108(), this.f4495 - this.f4489, this.f4490 - this.f4496, 400);
        m4545(c2494.m9094(), this.f4518 - this.f4513, this.f4520 - this.f4514, 400);
        m4545(c24942.m9094(), this.f4519 - this.f4513, this.f4520 - this.f4514, 400);
        m4545(c2494.m9093(), this.f4527 - this.f4526, this.f4529 - this.f4525, 400);
        m4545(c2494.m9092(), this.f4527 - this.f4526, this.f4529 - this.f4525, 400);
        m4545(c24942.m9093(), this.f4528 - this.f4526, this.f4529 - this.f4525, 400);
        m4545(c24942.m9092(), this.f4528 - this.f4526, this.f4529 - this.f4525, 400);
        m4545(c2494.m9103(), (-(this.f4381 + this.f4405)) / 2.0f, 0.0f, 400);
        m4545(c24942.m9103(), (this.f4381 + this.f4405) / 2.0f, 0.0f, 400);
        m4462(cloudPlayerConnectViewM9095, this.f4411, 0, 400);
        m4462(cloudPlayerConnectViewM90952, this.f4412, 0, 400);
        float fM9117 = this.f4501 - ((this.f4453.m9117() * (1.0f - this.f4403)) / 2.0f);
        float fM91172 = this.f4502 - ((this.f4454.m9117() * (1.0f - this.f4403)) / 2.0f);
        m4545(c2494.m9118(), this.f4497 - fM9117, this.f4507 - this.f4498, 400);
        m4545(c24942.m9118(), this.f4497 - fM91172, this.f4507 - this.f4498, 400);
        C4008.m12880(0.0f, 1.0f, 400, new C1661((int) (monitorTextureGroupViewM9131.getWidth() * monitorTextureGroupViewM9131.getScaleX()), (int) (monitorTextureGroupViewM9131.getHeight() * monitorTextureGroupViewM9131.getScaleY()), (int) monitorTextureGroupViewM9131.getTranslationX(), (int) monitorTextureGroupViewM9131.getTranslationY(), monitorTextureGroupViewM9131, monitorParentViewM9100, f, lineFeedTextView2, (int) (monitorTextureGroupViewM91312.getWidth() * monitorTextureGroupViewM91312.getScaleX()), (int) (monitorTextureGroupViewM91312.getHeight() * monitorTextureGroupViewM91312.getScaleY()), (int) monitorTextureGroupViewM91312.getTranslationX(), (int) monitorTextureGroupViewM91312.getTranslationY(), monitorTextureGroupViewM91312, monitorParentViewM91002, lineFeedTextViewM90982, aCUnitViewM9090, aCUnitViewM90902));
    }

    /* renamed from: ၰ, reason: contains not printable characters */
    public final void m4544(C2494 c2494, C2494 c24942, C2494 c24943, C2494 c24944, float f, int i) {
        int i2;
        int i3;
        boolean z;
        MonitorParentView monitorParentViewM9100 = c2494.m9100();
        MonitorParentView monitorParentViewM91002 = c24942.m9100();
        MonitorParentView monitorParentViewM91003 = c24943.m9100();
        MonitorParentView monitorParentViewM91004 = c24944.m9100();
        MonitorTextureGroupView monitorTextureGroupViewM9131 = c2494.m9131();
        MonitorTextureGroupView monitorTextureGroupViewM91312 = c24942.m9131();
        MonitorTextureGroupView monitorTextureGroupViewM91313 = c24943.m9131();
        MonitorTextureGroupView monitorTextureGroupViewM91314 = c24944.m9131();
        LineFeedTextView lineFeedTextViewM9098 = c2494.m9098();
        LineFeedTextView lineFeedTextViewM90982 = c24942.m9098();
        LineFeedTextView lineFeedTextViewM90983 = c24943.m9098();
        LineFeedTextView lineFeedTextViewM90984 = c24944.m9098();
        CloudPlayerConnectView cloudPlayerConnectViewM9095 = c2494.m9095();
        CloudPlayerConnectView cloudPlayerConnectViewM90952 = c24942.m9095();
        CloudPlayerConnectView cloudPlayerConnectViewM90953 = c24943.m9095();
        CloudPlayerConnectView cloudPlayerConnectViewM90954 = c24944.m9095();
        if (this.f4370.f12222.getAlpha() == 0.0f || this.f4370.f12222.getVisibility() == 8) {
            this.f4370.f12222.setVisibility(0);
            C4008.m12877(this.f4370.f12222, 1.0f, 400, null);
        }
        TextView textView = this.f4370.f12185;
        FinderManager.getInstance().machineCanConn(FinderManager.MACHINE_D);
        C4008.m12877(textView, 1.0f, 400, null);
        TextView textView2 = this.f4370.f12184;
        FinderManager.getInstance().machineCanConn(FinderManager.MACHINE_C);
        C4008.m12877(textView2, 1.0f, 400, null);
        TextView textView3 = this.f4370.f12183;
        FinderManager.getInstance().machineCanConn("2");
        C4008.m12877(textView3, 1.0f, 400, null);
        TextView textView4 = this.f4370.f12182;
        FinderManager.getInstance().machineCanConn("1");
        C4008.m12877(textView4, 1.0f, 400, null);
        C4008.m12877(this.f4370.f12188, 0.0f, 0, null);
        for (int i4 = 0; i4 < this.f4455.size(); i4++) {
            C2494 c24945 = this.f4455.get(i4);
            c24945.m9129().setVisibility(0);
            C4008.m12877(c24945.m9129(), 1.0f, 400, null);
            ConstraintLayout constraintLayoutM9128 = c24945.m9128();
            float f2 = this.f4403;
            C4008.m12884(constraintLayoutM9128, f2, f2, 400, null);
            C4008.m12877(c24945.m9109(), 0.0f, 0, null);
            c24945.m9109().setVisibility(4);
            c24945.m9108().m4586(this.f4487, 400, c24945.m9133(), c24945.m9140());
        }
        m4545(this.f4370.f12176, this.f4389, this.f4390, 400);
        m4545(this.f4370.f12177, this.f4389, this.f4390, 400);
        m4545(this.f4370.f12222, this.f4393, this.f4394, 400);
        m4545(this.f4370.f12186, this.f4396, this.f4395, 400);
        ConstraintLayout constraintLayoutM91282 = c2494.m9128();
        ConstraintLayout constraintLayoutM91283 = c24942.m9128();
        ConstraintLayout constraintLayoutM91284 = c24943.m9128();
        ConstraintLayout constraintLayoutM91285 = c24944.m9128();
        MonitorUnitView monitorUnitViewM9109 = c2494.m9109();
        MonitorUnitView monitorUnitViewM91092 = c24942.m9109();
        MonitorUnitView monitorUnitViewM91093 = c24943.m9109();
        MonitorUnitView monitorUnitViewM91094 = c24944.m9109();
        int i5 = this.f4457;
        int i6 = this.f4384;
        int i7 = this.f4405;
        int iM9125 = (int) (this.f4508 - (c2494.m9125() * this.f4473));
        int iM91252 = (int) (this.f4509 - (c24942.m9125() * this.f4473));
        int iM91253 = (int) (this.f4508 - (c24943.m9125() * this.f4473));
        int iM91254 = (int) (this.f4509 - (c24944.m9125() * this.f4473));
        m4545(constraintLayoutM91282, this.f4457 - this.f4418, this.f4461 - this.f4419, 400);
        m4545(constraintLayoutM91283, ((i5 + i6) + i7) - this.f4418, this.f4461 - this.f4419, 400);
        m4545(constraintLayoutM91284, this.f4457 - this.f4418, this.f4462 - this.f4419, 400);
        m4545(constraintLayoutM91285, ((i5 + i6) + i7) - this.f4418, this.f4462 - this.f4419, 400);
        m4545(monitorUnitViewM9109, this.f4470, -this.f4469, 400);
        m4545(monitorUnitViewM91092, this.f4471, -this.f4469, 400);
        m4545(monitorUnitViewM91093, this.f4470, -this.f4468, 400);
        m4545(monitorUnitViewM91094, this.f4471, -this.f4468, 400);
        m4545(c2494.m9114(), this.f4486 - this.f4482, this.f4485 - this.f4481, 400);
        m4545(c24942.m9114(), this.f4486 - this.f4483, this.f4485 - this.f4481, 400);
        m4545(c24943.m9114(), this.f4486 - this.f4482, this.f4485 - this.f4484, 400);
        m4545(c24944.m9114(), this.f4486 - this.f4483, this.f4485 - this.f4484, 400);
        m4545(c2494.m9108(), this.f4495 - this.f4491, this.f4492 - this.f4496, 400);
        m4545(c24942.m9108(), this.f4495 - this.f4493, this.f4492 - this.f4496, 400);
        m4545(c24943.m9108(), this.f4495 - this.f4491, this.f4494 - this.f4496, 400);
        m4545(c24944.m9108(), this.f4495 - this.f4493, this.f4494 - this.f4496, 400);
        m4545(c2494.m9094(), this.f4521 - this.f4513, this.f4522 - this.f4514, 400);
        m4545(c24942.m9094(), this.f4523 - this.f4513, this.f4522 - this.f4514, 400);
        m4545(c24943.m9094(), this.f4521 - this.f4513, this.f4524 - this.f4514, 400);
        m4545(c24944.m9094(), this.f4523 - this.f4513, this.f4524 - this.f4514, 400);
        m4545(c2494.m9093(), this.f4530 - this.f4526, this.f4531 - this.f4525, 400);
        m4545(c24942.m9093(), this.f4532 - this.f4526, this.f4531 - this.f4525, 400);
        m4545(c24943.m9093(), this.f4530 - this.f4526, this.f4533 - this.f4525, 400);
        m4545(c24944.m9093(), this.f4532 - this.f4526, this.f4533 - this.f4525, 400);
        m4545(c2494.m9092(), this.f4530 - this.f4526, this.f4531 - this.f4525, 400);
        m4545(c24942.m9092(), this.f4532 - this.f4526, this.f4531 - this.f4525, 400);
        m4545(c24943.m9092(), this.f4530 - this.f4526, this.f4533 - this.f4525, 400);
        m4545(c24944.m9092(), this.f4532 - this.f4526, this.f4533 - this.f4525, 400);
        m4545(c2494.m9118(), this.f4497 - this.f4503, this.f4505 - this.f4498, 400);
        m4545(c24942.m9118(), this.f4497 - this.f4504, this.f4505 - this.f4498, 400);
        m4545(c24943.m9118(), this.f4497 - this.f4503, this.f4506 - this.f4498, 400);
        m4545(c24944.m9118(), this.f4497 - this.f4504, this.f4506 - this.f4498, 400);
        if (c2494.m9125() != 0.0f) {
            m4545(c2494.m9124(), iM9125 - this.f4510, this.f4499 - this.f4477, 400);
            c2494.m9084(false, 400);
        }
        if (c24942.m9125() != 0.0f) {
            m4545(c24942.m9124(), iM91252 - this.f4510, this.f4499 - this.f4477, 400);
            c24942.m9084(false, 400);
        }
        if (c24943.m9125() != 0.0f) {
            m4545(c24943.m9124(), iM91253 - this.f4510, this.f4500 - this.f4477, 400);
            c24943.m9084(false, 400);
        }
        if (c24944.m9125() != 0.0f) {
            m4545(c24944.m9124(), iM91254 - this.f4510, this.f4500 - this.f4477, 400);
            i2 = 0;
            c24944.m9084(false, 400);
        } else {
            i2 = 0;
        }
        C4008.m12877(c2494.m9120(), 1.0f, i2, null);
        C4008.m12877(c24942.m9120(), 1.0f, i2, null);
        C4008.m12877(c24943.m9120(), 1.0f, i2, null);
        C4008.m12877(c24944.m9120(), 1.0f, i2, null);
        RecordTimeLayout recordTimeLayoutM9124 = c2494.m9124();
        float f3 = this.f4473;
        C4008.m12884(recordTimeLayoutM9124, f3, f3, 400, null);
        RecordTimeLayout recordTimeLayoutM91242 = c24942.m9124();
        float f4 = this.f4473;
        C4008.m12884(recordTimeLayoutM91242, f4, f4, 400, null);
        RecordTimeLayout recordTimeLayoutM91243 = c24943.m9124();
        float f5 = this.f4473;
        C4008.m12884(recordTimeLayoutM91243, f5, f5, 400, null);
        RecordTimeLayout recordTimeLayoutM91244 = c24944.m9124();
        float f6 = this.f4473;
        C4008.m12884(recordTimeLayoutM91244, f6, f6, 400, null);
        StrokeTextView strokeTextViewM9118 = c2494.m9118();
        float f7 = this.f4403;
        C4008.m12884(strokeTextViewM9118, f7, f7, 400, null);
        StrokeTextView strokeTextViewM91182 = c24942.m9118();
        float f8 = this.f4403;
        C4008.m12884(strokeTextViewM91182, f8, f8, 400, null);
        StrokeTextView strokeTextViewM91183 = c24943.m9118();
        float f9 = this.f4403;
        C4008.m12884(strokeTextViewM91183, f9, f9, 400, null);
        StrokeTextView strokeTextViewM91184 = c24944.m9118();
        float f10 = this.f4403;
        C4008.m12884(strokeTextViewM91184, f10, f10, 400, null);
        m4462(cloudPlayerConnectViewM9095, this.f4415, this.f4413, 400);
        m4462(cloudPlayerConnectViewM90952, this.f4416, this.f4413, 400);
        m4462(cloudPlayerConnectViewM90953, this.f4415, this.f4414, 400);
        m4462(cloudPlayerConnectViewM90954, this.f4416, this.f4414, 400);
        ExtendView extendViewM9103 = c2494.m9103();
        ExtendView extendViewM91032 = c24942.m9103();
        ExtendView extendViewM91033 = c24943.m9103();
        ExtendView extendViewM91034 = c24944.m9103();
        int i8 = this.f4384;
        int i9 = this.f4405;
        m4545(extendViewM9103, (-(i8 + i9)) / 2.0f, (-(this.f4383 + i9)) / 2.0f, 400);
        int i10 = this.f4384;
        int i11 = this.f4405;
        m4545(extendViewM91032, (i10 + i11) / 2.0f, (-(this.f4383 + i11)) / 2.0f, 400);
        int i12 = this.f4384;
        int i13 = this.f4405;
        m4545(extendViewM91033, (-(i12 + i13)) / 2.0f, (this.f4383 + i13) / 2.0f, 400);
        int i14 = this.f4384;
        int i15 = this.f4405;
        m4545(extendViewM91034, (i14 + i15) / 2.0f, (this.f4383 + i15) / 2.0f, 400);
        m4502(false, -1, 100, true);
        int width = (int) (monitorTextureGroupViewM9131.getWidth() * monitorTextureGroupViewM9131.getScaleX());
        int height = (int) (monitorTextureGroupViewM9131.getHeight() * monitorTextureGroupViewM9131.getScaleY());
        int translationX = (int) monitorTextureGroupViewM9131.getTranslationX();
        int translationY = (int) monitorTextureGroupViewM9131.getTranslationY();
        int width2 = (int) (monitorTextureGroupViewM91312.getWidth() * monitorTextureGroupViewM91312.getScaleX());
        int height2 = (int) (monitorTextureGroupViewM91312.getHeight() * monitorTextureGroupViewM91312.getScaleY());
        int translationX2 = (int) monitorTextureGroupViewM91312.getTranslationX();
        int translationY2 = (int) monitorTextureGroupViewM91312.getTranslationY();
        int width3 = (int) (monitorTextureGroupViewM91313.getWidth() * monitorTextureGroupViewM91313.getScaleX());
        int height3 = (int) (monitorTextureGroupViewM91313.getHeight() * monitorTextureGroupViewM91313.getScaleY());
        int translationX3 = (int) monitorTextureGroupViewM91313.getTranslationX();
        int translationY3 = (int) monitorTextureGroupViewM91313.getTranslationY();
        int width4 = (int) (monitorTextureGroupViewM91314.getWidth() * monitorTextureGroupViewM91314.getScaleX());
        int height4 = (int) (monitorTextureGroupViewM91314.getHeight() * monitorTextureGroupViewM91314.getScaleY());
        int translationX4 = (int) monitorTextureGroupViewM91314.getTranslationX();
        int translationY4 = (int) monitorTextureGroupViewM91314.getTranslationY();
        int i16 = this.f4457;
        int i17 = this.f4406;
        int i18 = this.f4397;
        int i19 = this.f4384;
        int i20 = (int) (((i16 + f) - i17) - ((i18 - i19) / 2.0f));
        float f11 = translationX2 + f;
        int i21 = (int) ((f11 - i17) - ((i18 - i19) / 2.0f));
        int i22 = (int) (((i16 + f) - i17) - ((i18 - i19) / 2.0f));
        int i23 = (int) ((f11 - i17) - ((i18 - i19) / 2.0f));
        int i24 = this.f4456;
        int i25 = this.f4407;
        int i26 = this.f4398;
        int i27 = this.f4383;
        int i28 = (int) ((i24 - i25) - ((i26 - i27) / 2.0f));
        int i29 = (int) ((i24 - i25) - ((i26 - i27) / 2.0f));
        int i30 = this.f4458;
        int i31 = (int) ((i30 - i25) - ((i26 - i27) / 2.0f));
        int i32 = (int) ((i30 - i25) - ((i26 - i27) / 2.0f));
        boolean z2 = Math.abs(lineFeedTextViewM9098.getTranslationX() - ((float) i20)) > 1.0f || Math.abs(lineFeedTextViewM9098.getTranslationX() - ((float) i28)) > 1.0f || f == 0.0f;
        boolean z3 = Math.abs(lineFeedTextViewM90982.getTranslationX() - ((float) i21)) > 1.0f || Math.abs(lineFeedTextViewM90982.getTranslationY() - ((float) i29)) > 1.0f || f == 0.0f;
        boolean z4 = Math.abs(lineFeedTextViewM90983.getTranslationX() - ((float) i22)) > 1.0f || Math.abs(lineFeedTextViewM90983.getTranslationY() - ((float) i31)) > 1.0f || f == 0.0f;
        if (Math.abs(lineFeedTextViewM90984.getTranslationX() - i23) <= 1.0f && Math.abs(lineFeedTextViewM90984.getTranslationY() - i32) <= 1.0f) {
            if (f != 0.0f) {
                i3 = 400;
                z = false;
            }
            C4008.m12880(0.0f, 1.0f, i3, new C1667(width, height, translationX, translationY, width2, height2, translationX2, translationY2, width3, height3, translationX3, translationY3, width4, height4, translationX4, translationY4, monitorTextureGroupViewM9131, monitorTextureGroupViewM91312, monitorTextureGroupViewM91313, monitorTextureGroupViewM91314, monitorParentViewM9100, monitorParentViewM91002, monitorParentViewM91003, monitorParentViewM91004, z2, f, lineFeedTextViewM9098, z3, lineFeedTextViewM90982, z4, lineFeedTextViewM90983, z, lineFeedTextViewM90984));
        }
        i3 = 400;
        z = true;
        C4008.m12880(0.0f, 1.0f, i3, new C1667(width, height, translationX, translationY, width2, height2, translationX2, translationY2, width3, height3, translationX3, translationY3, width4, height4, translationX4, translationY4, monitorTextureGroupViewM9131, monitorTextureGroupViewM91312, monitorTextureGroupViewM91313, monitorTextureGroupViewM91314, monitorParentViewM9100, monitorParentViewM91002, monitorParentViewM91003, monitorParentViewM91004, z2, f, lineFeedTextViewM9098, z3, lineFeedTextViewM90982, z4, lineFeedTextViewM90983, z, lineFeedTextViewM90984));
    }

    /* renamed from: ၵ, reason: contains not printable characters */
    public final void m4545(View view, float f, float f2, int i) {
        C4008.m12886(view, f, f2, i, null);
    }

    /* renamed from: ၶ, reason: contains not printable characters */
    public final void m4546(C2494 c2494, int i, boolean z, int i2) {
        if (c2494 != null) {
            if (i == c2494.m9130() && z == c2494.m9144()) {
                return;
            }
            c2494.m9131().m4637(i, z, i2 != 0);
            c2494.m9193(i);
            c2494.m9192(z);
        }
    }

    public MonitorAnimateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4379 = 400;
        this.f4404 = new ArrayList();
        this.f4425 = 1;
        this.f4448 = new C2494();
        this.f4449 = new C2494();
        this.f4450 = new C2494();
        this.f4451 = new C2494();
        this.f4455 = new ArrayList();
        this.f4465 = false;
        this.f4534 = 0.9f;
        this.f4368 = new ArrayList();
        this.f4369 = new ArrayList();
        this.f4380 = 10001;
        this.f4365 = 10002;
        this.f4366 = 10003;
        this.f4367 = new WeakHandler(new C1705());
        this.f4424 = true;
        this.f4423 = false;
        this.f4364 = 1;
        this.f4422 = -1;
        m4488();
    }

    public MonitorAnimateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4379 = 400;
        this.f4404 = new ArrayList();
        this.f4425 = 1;
        this.f4448 = new C2494();
        this.f4449 = new C2494();
        this.f4450 = new C2494();
        this.f4451 = new C2494();
        this.f4455 = new ArrayList();
        this.f4465 = false;
        this.f4534 = 0.9f;
        this.f4368 = new ArrayList();
        this.f4369 = new ArrayList();
        this.f4380 = 10001;
        this.f4365 = 10002;
        this.f4366 = 10003;
        this.f4367 = new WeakHandler(new C1705());
        this.f4424 = true;
        this.f4423 = false;
        this.f4364 = 1;
        this.f4422 = -1;
        m4488();
    }
}
