package com.blink.academy.film.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.media.AudioManager;
import android.net.Uri;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.android.billingclient.api.Purchase;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.PayAdapterActivity;
import com.blink.academy.film.base.BaseActivity;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.home.HeadsetReceiver;
import com.blink.academy.film.home.fragment.FragmentCallback;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.CacheHuaweiBean;
import com.blink.academy.film.netbean.CachePlayStoreBean;
import com.blink.academy.film.netbean.FilterUIBean;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.srt.SRTConnectionCallbackEntity;
import com.blink.academy.film.netbean.srt.SRTConnectionRoomIdCallbackEntity;
import com.blink.academy.film.netbean.srt.SRTConnectionServerBean;
import com.blink.academy.film.netbean.store.FilterBean;
import com.blink.academy.film.netbean.store.FilterGroupBean;
import com.blink.academy.film.netbean.store.FilterGroupCollectionBean;
import com.blink.academy.film.netbean.store.NvtProductItem;
import com.blink.academy.film.netbean.store.StoreMessageBean;
import com.blink.academy.film.netbean.store.SubscribeInfoCallback;
import com.blink.academy.film.player.PlayerActivity;
import com.blink.academy.film.setting.PortraitSettingActivity;
import com.blink.academy.film.setting.SettingActivity;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.ConnectionManager;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.stream.LinkEntity;
import com.blink.academy.film.stream.LinkManager;
import com.blink.academy.film.stream.NetInfoBean;
import com.blink.academy.film.stream.NsdServiceInfoEntity;
import com.blink.academy.film.stream.PingHelper;
import com.blink.academy.film.stream.ServiceInfoBean;
import com.blink.academy.film.stream.WifiReceiver;
import com.blink.academy.film.stream.ban.ACBanManager;
import com.blink.academy.film.stream.secondscreen.SecondScreenPresenter;
import com.blink.academy.film.support.controller.PayController;
import com.blink.academy.film.support.pay.google.BillingManager;
import com.blink.academy.film.support.pay.google.GooglePayHelper;
import com.blink.academy.film.support.pay.huawei.HuaweiPay;
import com.blink.academy.film.support.receiver.BatteryChangedReceiver;
import com.blink.academy.film.support.socket.IDiscoveryCallBack;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.videotools.CameraView;
import com.blink.academy.film.widgets.SubscribeDialog;
import com.blink.academy.film.widgets.cover.ModeHintDialog;
import com.blink.academy.film.widgets.dialog.ScoreDialog;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;
import com.blink.academy.film.widgets.dialog.login.PrivacyWebView;
import com.blink.academy.film.widgets.exposure.CameraTouchView;
import com.blink.academy.film.widgets.iso.FocusZoomWheelView;
import com.blink.academy.protake.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.mlkit.common.MlKitException;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.uc.crashsdk.export.LogType;
import defpackage.AbstractC2341;
import defpackage.AbstractC3954;
import defpackage.AbstractC4012;
import defpackage.AbstractC5160;
import defpackage.AbstractRunnableC4803;
import defpackage.C2375;
import defpackage.C2462;
import defpackage.C2520;
import defpackage.C2531;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C2628;
import defpackage.C2650;
import defpackage.C2735;
import defpackage.C2764;
import defpackage.C2811;
import defpackage.C2813;
import defpackage.C2949;
import defpackage.C2970;
import defpackage.C3088;
import defpackage.C3151;
import defpackage.C3180;
import defpackage.C3286;
import defpackage.C3295;
import defpackage.C3410;
import defpackage.C3444;
import defpackage.C3485;
import defpackage.C3608;
import defpackage.C3617;
import defpackage.C3621;
import defpackage.C3641;
import defpackage.C3659;
import defpackage.C3687;
import defpackage.C3703;
import defpackage.C3744;
import defpackage.C3768;
import defpackage.C3828;
import defpackage.C3891;
import defpackage.C3902;
import defpackage.C3947;
import defpackage.C3952;
import defpackage.C4008;
import defpackage.C4041;
import defpackage.C4054;
import defpackage.C4062;
import defpackage.C4077;
import defpackage.C4092;
import defpackage.C4112;
import defpackage.C4136;
import defpackage.C4151;
import defpackage.C4320;
import defpackage.C4351;
import defpackage.C4400;
import defpackage.C4425;
import defpackage.C4506;
import defpackage.C4511;
import defpackage.C4535;
import defpackage.C4565;
import defpackage.C4567;
import defpackage.C4628;
import defpackage.C4638;
import defpackage.C4666;
import defpackage.C4689;
import defpackage.C4757;
import defpackage.C4792;
import defpackage.C4843;
import defpackage.C4852;
import defpackage.C5049;
import defpackage.C5220;
import defpackage.C5244;
import defpackage.InterfaceC3866;
import defpackage.InterfaceC4875;
import defpackage.InterfaceC4886;
import defpackage.c8;
import defpackage.c9;
import defpackage.d1;
import defpackage.e5;
import defpackage.h0;
import defpackage.j;
import defpackage.l5;
import defpackage.m;
import defpackage.n;
import defpackage.o3;
import defpackage.o4;
import defpackage.q5;
import defpackage.r1;
import defpackage.v5;
import defpackage.w5;
import defpackage.w7;
import defpackage.z0;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.containers.dpx.DPXReader;
import org.json.JSONException;

/* loaded from: classes.dex */
public class HomeActivity extends BaseActivity {

    /* renamed from: ٴ, reason: contains not printable characters */
    public static HomeActivity f426;

    /* renamed from: ˊ, reason: contains not printable characters */
    public boolean f427;

    /* renamed from: ˋ, reason: contains not printable characters */
    public boolean f428;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public AbstractC3954 f430;

    /* renamed from: ԭ, reason: contains not printable characters */
    public AbstractC5160 f431;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C3295 f432;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C2970 f433;

    /* renamed from: ՠ, reason: contains not printable characters */
    public C3744 f434;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f435;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f436;

    /* renamed from: ׯ, reason: contains not printable characters */
    public CameraView f437;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f443;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f444;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f447;

    /* renamed from: މ, reason: contains not printable characters */
    public float f448;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f449;

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean f450;

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean f451;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f452;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f453;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f459;

    /* renamed from: ޖ, reason: contains not printable characters */
    public boolean f461;

    /* renamed from: ޘ, reason: contains not printable characters */
    public DecoderParamsBean f463;

    /* renamed from: ޙ, reason: contains not printable characters */
    public DecoderParamsBean f464;

    /* renamed from: ޚ, reason: contains not printable characters */
    public DecoderParamsBean f465;

    /* renamed from: ޛ, reason: contains not printable characters */
    public DecoderParamsBean f466;

    /* renamed from: ޜ, reason: contains not printable characters */
    public boolean f467;

    /* renamed from: ޝ, reason: contains not printable characters */
    public boolean f468;

    /* renamed from: ޞ, reason: contains not printable characters */
    public int f469;

    /* renamed from: ޟ, reason: contains not printable characters */
    public boolean f470;

    /* renamed from: ޠ, reason: contains not printable characters */
    public boolean f471;

    /* renamed from: ޡ, reason: contains not printable characters */
    public int f472;

    /* renamed from: ޢ, reason: contains not printable characters */
    public boolean f473;

    /* renamed from: ޣ, reason: contains not printable characters */
    public String f474;

    /* renamed from: ޤ, reason: contains not printable characters */
    public boolean f475;

    /* renamed from: ޥ, reason: contains not printable characters */
    public boolean f476;

    /* renamed from: ޱ, reason: contains not printable characters */
    public boolean f477;

    /* renamed from: ߾, reason: contains not printable characters */
    public boolean f478;

    /* renamed from: ߿, reason: contains not printable characters */
    public boolean f479;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public boolean f480;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public int f481;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public float f482;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public boolean f483;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public boolean f484;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public int f486;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public int f487;

    /* renamed from: ࡨ, reason: contains not printable characters */
    public int f488;

    /* renamed from: ࢠ, reason: contains not printable characters */
    public int f491;

    /* renamed from: ࢢ, reason: contains not printable characters */
    public boolean f493;

    /* renamed from: ࢣ, reason: contains not printable characters */
    public boolean f494;

    /* renamed from: ࢤ, reason: contains not printable characters */
    public ValueAnimator f495;

    /* renamed from: ࢥ, reason: contains not printable characters */
    public ValueAnimator f496;

    /* renamed from: ࢦ, reason: contains not printable characters */
    public boolean f497;

    /* renamed from: ࢧ, reason: contains not printable characters */
    public boolean f498;

    /* renamed from: ࢨ, reason: contains not printable characters */
    public int f499;

    /* renamed from: ࢩ, reason: contains not printable characters */
    public boolean f500;

    /* renamed from: ࢪ, reason: contains not printable characters */
    public int f501;

    /* renamed from: ࢫ, reason: contains not printable characters */
    public int f502;

    /* renamed from: ࢬ, reason: contains not printable characters */
    public int f503;

    /* renamed from: ࢭ, reason: contains not printable characters */
    public AudioManager f504;

    /* renamed from: ࢮ, reason: contains not printable characters */
    public float f505;

    /* renamed from: ࢯ, reason: contains not printable characters */
    public float f506;

    /* renamed from: ࢰ, reason: contains not printable characters */
    public float f507;

    /* renamed from: ࢱ, reason: contains not printable characters */
    public float f508;

    /* renamed from: ࢲ, reason: contains not printable characters */
    public float f509;

    /* renamed from: ࢳ, reason: contains not printable characters */
    public float f510;

    /* renamed from: ࢴ, reason: contains not printable characters */
    public float f511;

    /* renamed from: ࢶ, reason: contains not printable characters */
    public boolean f512;

    /* renamed from: ࢷ, reason: contains not printable characters */
    public boolean f513;

    /* renamed from: ࢸ, reason: contains not printable characters */
    public NvtProductItem f514;

    /* renamed from: ࢹ, reason: contains not printable characters */
    public boolean f515;

    /* renamed from: ࢺ, reason: contains not printable characters */
    public HandlerThread f516;

    /* renamed from: ࢻ, reason: contains not printable characters */
    public Handler f517;

    /* renamed from: ࢼ, reason: contains not printable characters */
    public HandlerThread f518;

    /* renamed from: ࢽ, reason: contains not printable characters */
    public Handler f519;

    /* renamed from: ࣁ, reason: contains not printable characters */
    public long f523;

    /* renamed from: ࣂ, reason: contains not printable characters */
    public int f524;

    /* renamed from: ࣃ, reason: contains not printable characters */
    public float f525;

    /* renamed from: ࣆ, reason: contains not printable characters */
    public boolean f528;

    /* renamed from: ࣇ, reason: contains not printable characters */
    public String f529;

    /* renamed from: ॱ, reason: contains not printable characters */
    public C0361 f530;

    /* renamed from: ৼ, reason: contains not printable characters */
    public BatteryChangedReceiver f531;

    /* renamed from: ૹ, reason: contains not printable characters */
    public long f532;

    /* renamed from: ಀ, reason: contains not printable characters */
    public int f533;

    /* renamed from: ഄ, reason: contains not printable characters */
    public ImageView f536;

    /* renamed from: ഩ, reason: contains not printable characters */
    public SecondScreenPresenter f537;

    /* renamed from: ഺ, reason: contains not printable characters */
    public WifiReceiver f538;

    /* renamed from: ൟ, reason: contains not printable characters */
    public boolean f543;

    /* renamed from: ຆ, reason: contains not printable characters */
    public boolean f544;

    /* renamed from: ຉ, reason: contains not printable characters */
    public int f545;

    /* renamed from: ຌ, reason: contains not printable characters */
    public int f546;

    /* renamed from: ຎ, reason: contains not printable characters */
    public C3703 f547;

    /* renamed from: ຑ, reason: contains not printable characters */
    public long f550;

    /* renamed from: ຠ, reason: contains not printable characters */
    public float f554;

    /* renamed from: ဨ, reason: contains not printable characters */
    public boolean f564;

    /* renamed from: ၚ, reason: contains not printable characters */
    public boolean f565;

    /* renamed from: ၛ, reason: contains not printable characters */
    public int f566;

    /* renamed from: ၜ, reason: contains not printable characters */
    public int f567;

    /* renamed from: ၝ, reason: contains not printable characters */
    public float f568;

    /* renamed from: ၡ, reason: contains not printable characters */
    public float f569;

    /* renamed from: ၥ, reason: contains not printable characters */
    public float f570;

    /* renamed from: ၦ, reason: contains not printable characters */
    public float f571;

    /* renamed from: ၮ, reason: contains not printable characters */
    public String f572;

    /* renamed from: ၯ, reason: contains not printable characters */
    public boolean f573;

    /* renamed from: ၰ, reason: contains not printable characters */
    public HeadsetReceiver f574;

    /* renamed from: ၵ, reason: contains not printable characters */
    public boolean f575;

    /* renamed from: ၸ, reason: contains not printable characters */
    public boolean f578;

    /* renamed from: ၽ, reason: contains not printable characters */
    public int f583;

    /* renamed from: ၾ, reason: contains not printable characters */
    public int f584;

    /* renamed from: ႁ, reason: contains not printable characters */
    public boolean f587;

    /* renamed from: ႎ, reason: contains not printable characters */
    public boolean f588;

    /* renamed from: Ⴭ, reason: contains not printable characters */
    public float[] f590;

    /* renamed from: ჽ, reason: contains not printable characters */
    public float f591;

    /* renamed from: ჾ, reason: contains not printable characters */
    public boolean f592;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f429 = false;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f438 = 2;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f439 = 0;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f440 = 0;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f441 = false;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f442 = false;

    /* renamed from: ކ, reason: contains not printable characters */
    public Boolean f445 = Boolean.FALSE;

    /* renamed from: އ, reason: contains not printable characters */
    public float f446 = 0.0f;

    /* renamed from: ޏ, reason: contains not printable characters */
    public final int f454 = 0;

    /* renamed from: ސ, reason: contains not printable characters */
    public final int f455 = 1;

    /* renamed from: ޑ, reason: contains not printable characters */
    public final int f456 = 2;

    /* renamed from: ޒ, reason: contains not printable characters */
    public final int f457 = 3;

    /* renamed from: ޓ, reason: contains not printable characters */
    public C3947.InterfaceC3948 f458 = new C0132();

    /* renamed from: ޕ, reason: contains not printable characters */
    public WeakHandler f460 = new WeakHandler(new C0190());

    /* renamed from: ޗ, reason: contains not printable characters */
    public final DecoderParamsBean f462 = new DecoderParamsBean();

    /* renamed from: ࡥ, reason: contains not printable characters */
    public boolean f485 = false;

    /* renamed from: ࡩ, reason: contains not printable characters */
    public final int f489 = 0;

    /* renamed from: ࡪ, reason: contains not printable characters */
    public final int f490 = 1;

    /* renamed from: ࢡ, reason: contains not printable characters */
    public int f492 = 0;

    /* renamed from: ࢾ, reason: contains not printable characters */
    public C5220.InterfaceC5225 f520 = new C0220();

    /* renamed from: ࢿ, reason: contains not printable characters */
    public C5220.InterfaceC5224 f521 = new C0243();

    /* renamed from: ࣀ, reason: contains not printable characters */
    public q5.InterfaceC2244 f522 = new C0263();

    /* renamed from: ࣄ, reason: contains not printable characters */
    public boolean f526 = true;

    /* renamed from: ࣅ, reason: contains not printable characters */
    public boolean f527 = true;

    /* renamed from: ೱ, reason: contains not printable characters */
    public boolean f534 = false;

    /* renamed from: ೲ, reason: contains not printable characters */
    public boolean f535 = false;

    /* renamed from: ൎ, reason: contains not printable characters */
    public boolean f539 = true;

    /* renamed from: ൔ, reason: contains not printable characters */
    public boolean f540 = false;

    /* renamed from: ൕ, reason: contains not printable characters */
    public boolean f541 = false;

    /* renamed from: ൖ, reason: contains not printable characters */
    public FragmentCallback f542 = new AnonymousClass20();

    /* renamed from: ຏ, reason: contains not printable characters */
    public float f548 = 1.0f;

    /* renamed from: ຐ, reason: contains not printable characters */
    public HeadsetReceiver.InterfaceC0123 f549 = new C0272();

    /* renamed from: ຒ, reason: contains not printable characters */
    public int f551 = 500;

    /* renamed from: ຓ, reason: contains not printable characters */
    public boolean f552 = false;

    /* renamed from: ຘ, reason: contains not printable characters */
    public int f553 = 0;

    /* renamed from: ຨ, reason: contains not printable characters */
    public boolean f555 = false;

    /* renamed from: ຩ, reason: contains not printable characters */
    public boolean f556 = false;

    /* renamed from: ຬ, reason: contains not printable characters */
    public boolean f557 = false;

    /* renamed from: ໞ, reason: contains not printable characters */
    public boolean f558 = false;

    /* renamed from: ໟ, reason: contains not printable characters */
    public boolean f559 = false;

    /* renamed from: ྈ, reason: contains not printable characters */
    public boolean f560 = false;

    /* renamed from: ྉ, reason: contains not printable characters */
    public boolean f561 = false;

    /* renamed from: ྌ, reason: contains not printable characters */
    public boolean f562 = false;

    /* renamed from: ဢ, reason: contains not printable characters */
    public boolean f563 = false;

    /* renamed from: ၶ, reason: contains not printable characters */
    public boolean f576 = false;

    /* renamed from: ၷ, reason: contains not printable characters */
    public boolean f577 = false;

    /* renamed from: ၹ, reason: contains not printable characters */
    public String f579 = "permissionHasRequest";

    /* renamed from: ၺ, reason: contains not printable characters */
    public boolean f580 = false;

    /* renamed from: ၻ, reason: contains not printable characters */
    public boolean f581 = false;

    /* renamed from: ၼ, reason: contains not printable characters */
    public boolean f582 = false;

    /* renamed from: ၿ, reason: contains not printable characters */
    public int f585 = -1;

    /* renamed from: ႀ, reason: contains not printable characters */
    public boolean f586 = false;

    /* renamed from: Ⴧ, reason: contains not printable characters */
    public int f589 = -1;

    /* renamed from: ჿ, reason: contains not printable characters */
    public boolean f593 = true;

    /* renamed from: com.blink.academy.film.home.HomeActivity$20, reason: invalid class name */
    public class AnonymousClass20 implements FragmentCallback {

        /* renamed from: com.blink.academy.film.home.HomeActivity$20$Ϳ, reason: contains not printable characters */
        public class C0124 implements l5 {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ float f595;

            /* renamed from: Ԩ, reason: contains not printable characters */
            public final /* synthetic */ float f596;

            public C0124(float f, float f2) {
                this.f595 = f;
                this.f596 = f2;
            }

            @Override // defpackage.l5
            /* renamed from: Ϳ, reason: contains not printable characters */
            public void mo1305() {
            }

            @Override // defpackage.l5
            /* renamed from: Ԩ, reason: contains not printable characters */
            public void mo1306() {
            }

            @Override // defpackage.l5
            /* renamed from: ԩ, reason: contains not printable characters */
            public void mo1307(float f) {
                if (HomeActivity.this.f492 == 1) {
                    float f2 = this.f595;
                    float f3 = f2 + ((this.f596 - f2) * f);
                    HomeActivity.this.f437.setScaleX(f3);
                    HomeActivity.this.f437.setScaleY(f3);
                    HomeActivity.this.f431.mo10615(f3, f3);
                    HomeActivity.this.f431.mo10605(f3, f3);
                    HomeActivity.this.f447 = 0.0f;
                    HomeActivity.this.f448 = 0.0f;
                    HomeActivity.this.f431.mo10608((2.0f - f) * 0.5f);
                    HomeActivity.this.f431.mo10602(1.0f - f);
                    return;
                }
                if (HomeActivity.this.f492 == 2) {
                    float f4 = this.f595;
                    float f5 = f4 + ((this.f596 - f4) * f);
                    HomeActivity.this.f437.setScaleX(f5);
                    HomeActivity.this.f437.setScaleY(f5);
                    HomeActivity.this.f431.mo10615(f5, f5);
                    HomeActivity.this.f431.mo10605(f5, f5);
                    return;
                }
                if (HomeActivity.this.f492 == 0) {
                    float f6 = this.f595;
                    float f7 = f6 + ((this.f596 - f6) * f);
                    HomeActivity.this.f437.setScaleX(f7);
                    HomeActivity.this.f437.setScaleY(f7);
                    HomeActivity.this.f431.mo10615(f7, f7);
                    HomeActivity.this.f431.mo10605(f7, f7);
                    float f8 = 1.0f - f;
                    float f9 = HomeActivity.this.f447 * f8;
                    float f10 = f8 * HomeActivity.this.f448;
                    HomeActivity.this.f437.setTranslationX(f9);
                    HomeActivity.this.f437.setTranslationY(f10);
                    HomeActivity.this.f431.mo10616(f9, f10);
                    HomeActivity.this.f431.mo10608((1.0f + f) * 0.5f);
                    HomeActivity.this.f431.mo10602(f);
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$20$Ԩ, reason: contains not printable characters */
        public class C0125 extends AbstractC4012 {
            public C0125() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                Intent intent;
                super.onAnimationEnd(view);
                if (HomeActivity.this.f429) {
                    C4638.m14099("readCurrentConfigState", "toSetting:" + C4535.m13880().m13890().toString());
                }
                if (C4792.m14375().m14498()) {
                    intent = new Intent(HomeActivity.this, (Class<?>) PortraitSettingActivity.class);
                } else {
                    intent = new Intent(HomeActivity.this, (Class<?>) SettingActivity.class);
                    HomeActivity.this.f453 = 1;
                }
                intent.addFlags(65536);
                HomeActivity.this.startActivity(intent);
                HomeActivity.this.overridePendingTransition(0, 0);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$20$Ԫ, reason: contains not printable characters */
        public class C0126 extends AbstractC4012 {
            public C0126() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                if (HomeActivity.this.f429) {
                    C4638.m14099("readCurrentConfigState", "toSetting:" + C4535.m13880().m13890().toString());
                }
                if (HomeActivity.this.f431 instanceof C3295) {
                    HomeActivity.this.f434.m11998();
                    if (HomeActivity.this.getSupportFragmentManager().getFragments().contains(HomeActivity.this.f434)) {
                        HomeActivity.this.getSupportFragmentManager().beginTransaction().hide(HomeActivity.this.f434).show(HomeActivity.this.f432).commitAllowingStateLoss();
                        HomeActivity.this.getSupportFragmentManager().beginTransaction().remove(o3.m7669().m7671()).commit();
                    }
                }
                Intent intent = new Intent(HomeActivity.this, (Class<?>) PlayerActivity.class);
                HomeActivity.this.f453 = 2;
                intent.addFlags(65536);
                HomeActivity.this.startActivity(intent);
                HomeActivity.this.overridePendingTransition(0, 0);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$20$Ԭ, reason: contains not printable characters */
        public class C0127 implements C4852.InterfaceC4855 {

            /* renamed from: com.blink.academy.film.home.HomeActivity$20$Ԭ$Ϳ, reason: contains not printable characters */
            public class RunnableC0128 implements Runnable {
                public RunnableC0128() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C4638.m14099("ccccccc", "startRecord:");
                    HomeActivity.this.m971();
                    HomeActivity.this.m969();
                }
            }

            public C0127() {
            }

            @Override // defpackage.C4852.InterfaceC4855
            public void onFinish() {
                HomeActivity.this.f460.postDelayed(new RunnableC0128(), (C3947.m12727().m12758() == 1 || C3947.m12727().m12759() == 1) ? 300 : 0);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$20$Ԯ, reason: contains not printable characters */
        public class RunnableC0129 implements Runnable {
            public RunnableC0129() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C4565 filmPreviewFilter = HomeActivity.this.f437.getFilmPreviewFilter();
                filmPreviewFilter.m11904();
                filmPreviewFilter.m11918();
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$20$ՠ, reason: contains not printable characters */
        public class RunnableC0130 implements Runnable {
            public RunnableC0130() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C4077 c4077 = C2650.f9865;
                if (c4077 != null) {
                    c4077.m11904();
                    C2650.f9865.m11918();
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$20$ֈ, reason: contains not printable characters */
        public class RunnableC0131 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ boolean f604;

            public RunnableC0131(boolean z) {
                this.f604 = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                C4077 c4077 = C2650.f9865;
                if (c4077 != null) {
                    if (this.f604) {
                        c4077.m11904();
                    } else {
                        c4077.m11920();
                    }
                    C2650.f9865.m11918();
                }
            }
        }

        public AnonymousClass20() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        public WeakHandler getHandler() {
            return HomeActivity.this.f460;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        public int getRecordMode() {
            return HomeActivity.this.f472;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1181() {
            HomeActivity.this.f451 = false;
            if (C4151.m13162().m13176() != 4) {
                HomeActivity.this.m1049();
                return;
            }
            HomeActivity.this.f451 = true;
            C4151.m13162().m13195();
            HomeActivity.this.f431.mo10579();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1182() {
            HomeActivity.this.f450 = false;
            if (C4151.m13162().m13176() != 3) {
                HomeActivity.this.m1092();
                return;
            }
            HomeActivity.this.f450 = true;
            C4151.m13162().m13195();
            HomeActivity.this.f431.mo10579();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1183(NvtProductItem nvtProductItem) {
            HomeActivity.this.f514 = nvtProductItem;
            if (e5.m5988().m5994()) {
                HomeActivity.this.m980();
                HomeActivity.this.m1114(1);
            } else if (FilmApp.m405().m430()) {
                HomeActivity.this.m1176(4);
            } else {
                HomeActivity.this.f449 = 4;
                HomeActivity.this.f547.m11880(false);
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1184(int i, float f) {
            boolean z;
            j.m7056(C2462.m9035().m9050(i));
            HomeActivity homeActivity = HomeActivity.this;
            homeActivity.f475 = homeActivity.m1026(i);
            HomeActivity homeActivity2 = HomeActivity.this;
            homeActivity2.f480 = homeActivity2.m1143(f);
            HomeActivity homeActivity3 = HomeActivity.this;
            homeActivity3.m1134(homeActivity3.m988());
            if (i != C2764.m10018().m10029()) {
                z = true;
                C2764.m10018().m10046(i);
            } else {
                z = false;
            }
            C2764.m10018().m10044(f);
            HomeActivity.this.m1140(0, i, C4535.m13880().m13890().m12442());
            C4535.m13880().m13890().m12552(f);
            C4535.m13880().m13890().m12554(i);
            HomeActivity.this.f437.m2042(z);
            C2650.m9790(new RunnableC0131(z));
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1185(boolean z, boolean z2, boolean z3) {
            if (z && z2) {
                HomeActivity.this.m978(15, z3);
            } else if (z) {
                HomeActivity.this.m978(16, z3);
            } else if (z2) {
                HomeActivity.this.m978(17, z3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: Ԭ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo1186(int r14, int r15, java.lang.String r16, int r17) {
            /*
                Method dump skipped, instructions count: 513
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.home.HomeActivity.AnonymousClass20.mo1186(int, int, java.lang.String, int):void");
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1187() {
            C3947.m12727().m12779(!C3947.m12727().m12765());
            if (C3947.m12727().m12765()) {
                if (HomeActivity.this.f439 == 1) {
                    HomeActivity.this.m1071();
                }
            } else if (HomeActivity.this.f439 == 1) {
                HomeActivity.this.m998(true);
            }
            HomeActivity.this.m1153(true, 4);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: Ԯ, reason: contains not printable characters */
        public void mo1188(boolean z) {
            HomeActivity.this.m1048(z, false);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ԯ, reason: contains not printable characters */
        public void mo1189(int i, String str) {
            if (HomeActivity.this.f429) {
                C4638.m14099("FilmHomeActivity", String.format("cameraState : %s , timeLapse : %s ", Integer.valueOf(HomeActivity.this.f439), Integer.valueOf(i)));
            }
            HomeActivity.this.f437.m2028(i);
            int timeLapseTimeMs = HomeActivity.this.f437.getTimeLapseTimeMs();
            int targetVideoFps = HomeActivity.this.f437.getTargetVideoFps();
            HomeActivity homeActivity = HomeActivity.this;
            homeActivity.m1083(str, homeActivity.f487, HomeActivity.this.f486, timeLapseTimeMs, targetVideoFps);
            HomeActivity.this.f437.m1990();
            C4535.m13880().m13890().m12436(i);
            C4535.m13880().m13915();
            C3947.m12727().m12775(HomeActivity.this.f458);
            if (i == 0 && HomeActivity.this.f439 == 1) {
                HomeActivity.this.f437.m1973((int) C3947.m12727().m12738(), C3947.m12727().m12735());
                HomeActivity.this.f431.mo10563();
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ՠ, reason: contains not printable characters */
        public void mo1190(int i) {
            if (e5.m5988().m5993()) {
                HomeActivity.this.m1049();
            } else {
                HomeActivity.this.f430.f13676.m2595(null, 1);
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ֈ, reason: contains not printable characters */
        public void mo1191() {
            if (FilmApp.m405().m430()) {
                HomeActivity.this.m1176(1);
            } else {
                HomeActivity.this.f449 = 1;
                HomeActivity.this.f547.m11880(false);
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ֏, reason: contains not printable characters */
        public void mo1192() {
            if (C3947.m12727().m12765()) {
                if (HomeActivity.this.f439 == 1) {
                    HomeActivity.this.m1071();
                }
            } else if (HomeActivity.this.f439 == 1) {
                HomeActivity.this.m998(true);
            }
            HomeActivity.this.m1153(true, 1);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ׯ, reason: contains not printable characters */
        public void mo1193(int i) {
            HomeActivity.this.f585 = i;
            C4535.m13880().m13890().m12497(HomeActivity.this.f585);
            C4535.m13880().m13915();
            HomeActivity.this.m1069(i);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ؠ, reason: contains not printable characters */
        public void mo1194(int i, int i2) {
            c8.m200(i, i2);
            HomeActivity.this.f431.mo10582(i + "K");
            C3444.m11227().m11271(1);
            HomeActivity.this.f437.m2046(1, null);
            C4535.m13880().m13890().m12392(1);
            C4535.m13880().m13890().m12347(i);
            C4535.m13880().m13890().m12373(i2);
            HomeActivity.this.f431.mo10485(HomeActivity.this.m965(1));
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ހ, reason: contains not printable characters */
        public void mo1195(float f, float f2, boolean z) {
            int i;
            int i2;
            HomeActivity.this.m1150();
            HomeActivity.this.f525 = f / f2;
            HomeActivity.this.f431.mo10580(HomeActivity.this.f525, HomeActivity.this.f482);
            if (HomeActivity.this.f537 != null) {
                HomeActivity.this.f537.refreshViewOnFrameRatioChange(HomeActivity.this.f525, HomeActivity.this.f482, true);
            }
            float f3 = HomeActivity.this.f525;
            if (HomeActivity.this.f493) {
                HomeActivity.this.m977(true);
                HomeActivity.this.m1137();
            } else {
                HomeActivity.this.f431.mo10588();
            }
            HomeActivity.this.m1162();
            HomeActivity.this.m1108();
            int iM8846 = HomeActivity.this.f437.getTargetVideoSize().m8846();
            int iM8843 = (int) (r2.m8843() / HomeActivity.this.m1053(C4535.m13880().m13890()));
            int i3 = iM8843 - (iM8843 % 2);
            float f4 = iM8846;
            float f5 = i3;
            if ((1.0f * f4) / f5 > f3) {
                int i4 = (int) (f5 * f3);
                i2 = i4 - (i4 % 2);
                i = i3;
            } else {
                int i5 = (int) (f4 / f3);
                i = i5 - (i5 % 2);
                i2 = iM8846;
            }
            C4535.m13880().m13890().m12520(f);
            C4535.m13880().m13890().m12519(f2);
            C4535.m13880().m13915();
            if (HomeActivity.this.f429) {
                C4638.m14099("FilmHomeActivity", String.format("w : %s , h : %s , isSelect : %s ", Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)));
                C4638.m14099("FilmHomeActivity", String.format("targetPreviewWidth : %s , targetPreviewHeight : %s , resultWidth : %s , resultHeight : %s ", Integer.valueOf(iM8846), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)));
            }
            HomeActivity.this.f437.m2025(i2);
            HomeActivity.this.f437.m2024(i);
            if (C3444.m11227().m11256()) {
                HomeActivity.this.f437.m2041();
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ށ, reason: contains not printable characters */
        public void mo1196(w7 w7Var) {
            int iM8513 = w7Var.m8513();
            C3444.m11227().m11271(iM8513);
            HomeActivity.this.f437.m2046(iM8513 == 9 ? 2 : iM8513, null);
            HomeActivity.this.f431.mo10485(HomeActivity.this.m965(iM8513));
            C4535.m13880().m13890().m12392(iM8513);
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ނ, reason: contains not printable characters */
        public void mo1197(boolean z) {
            HomeActivity.this.f553 = 2;
            C3444.m11227().m11262(z);
            HomeActivity.this.f437.m2001(C3444.m11227().m11254());
            if (HomeActivity.this.f429) {
                C4638.m14099("reConfigAudio", String.format("reConfigAudio : %s ", "onAutoGainChange"));
            }
            HomeActivity.this.f437.m1988();
            C4535.m13880().m13890().m12499(C3444.m11227().m11254());
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ރ, reason: contains not printable characters */
        public void mo1198(boolean z) {
            int i;
            int i2;
            C3444.m11227().m11265(z);
            if (z) {
                if (HomeActivity.this.f493) {
                    HomeActivity.this.f431.mo10603(C4792.m14375().m14414());
                    if (HomeActivity.this.f537 != null) {
                        HomeActivity.this.f537.setHomeRatioCoverCropAlpha(C4792.m14375().m14414());
                    }
                } else {
                    HomeActivity.this.f431.mo10603(C4792.m14375().m14414());
                    if (HomeActivity.this.f537 != null) {
                        HomeActivity.this.f537.setHomeRatioCoverCropAlpha(C4792.m14375().m14414());
                    }
                }
            } else if (HomeActivity.this.f493) {
                HomeActivity.this.f431.mo10603(0);
                if (HomeActivity.this.f537 != null) {
                    HomeActivity.this.f537.setHomeRatioCoverCropAlpha(0);
                }
            } else {
                HomeActivity.this.f431.mo10603(C4792.m14375().m14413());
                if (HomeActivity.this.f537 != null) {
                    HomeActivity.this.f537.setHomeRatioCoverCropAlpha(C4792.m14375().m14413());
                }
            }
            float f = HomeActivity.this.f525;
            int iM8846 = HomeActivity.this.f437.getTargetVideoSize().m8846();
            int iM8843 = (int) (r2.m8843() / HomeActivity.this.m1053(C4535.m13880().m13890()));
            int i3 = iM8843 - (iM8843 % 2);
            float f2 = iM8846;
            float f3 = i3;
            if ((1.0f * f2) / f3 > f) {
                int i4 = (int) (f3 * f);
                i2 = i4 - (i4 % 2);
                i = i3;
            } else {
                int i5 = (int) (f2 / f);
                i = i5 - (i5 % 2);
                i2 = iM8846;
            }
            if (HomeActivity.this.f429) {
                C4638.m14099("FilmHomeActivity", String.format("targetPreviewWidth : %s , targetPreviewHeight : %s , resultWidth : %s , resultHeight : %s ", Integer.valueOf(iM8846), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)));
            }
            HomeActivity.this.f437.m2025(i2);
            HomeActivity.this.f437.m2024(i);
            HomeActivity.this.f437.m2041();
            C4535.m13880().m13890().m12556(z);
            C4535.m13880().m13915();
            if (HomeActivity.this.f493) {
                HomeActivity.this.m977(true);
            }
            HomeActivity.this.m1108();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ބ, reason: contains not printable characters */
        public void mo1199(int i) {
            C3891 c3891M13890 = C4535.m13880().m13890();
            if (i != 0) {
                switch (i) {
                    case 1:
                        HomeActivity.this.f505 = 5.0f;
                        c3891M13890.m12507(HomeActivity.this.f505);
                        C2764.m10018().m10038(HomeActivity.this.f505 / 10.0f);
                        break;
                    case 2:
                        HomeActivity.this.f506 = 4.0f;
                        c3891M13890.m12511(HomeActivity.this.f506);
                        C2764.m10018().m10047(HomeActivity.this.f506 / 10.0f);
                        break;
                    case 3:
                        HomeActivity.this.f507 = 3.0f;
                        c3891M13890.m12508(HomeActivity.this.f507);
                        C2764.m10018().m10040(HomeActivity.this.f507 / 10.0f);
                        break;
                    case 4:
                        HomeActivity.this.f508 = 3.0f;
                        c3891M13890.m12505(HomeActivity.this.f508);
                        C2764.m10018().m10036(HomeActivity.this.f508 / 10.0f);
                        break;
                    case 5:
                        HomeActivity.this.f509 = 6.0f;
                        c3891M13890.m12509(HomeActivity.this.f509);
                        C2764.m10018().m10042(HomeActivity.this.f509 / 10.0f);
                        break;
                    case 6:
                        HomeActivity.this.f510 = 10.0f;
                        c3891M13890.m12506(HomeActivity.this.f510);
                        C2764.m10018().m10043(HomeActivity.this.f510 / 10.0f);
                        break;
                    case 7:
                        HomeActivity.this.f511 = 6.0f;
                        c3891M13890.m12512(HomeActivity.this.f511);
                        C2764.m10018().m10048(HomeActivity.this.f511 / 10.0f);
                        break;
                }
            } else {
                HomeActivity.this.f505 = 5.0f;
                HomeActivity.this.f506 = 4.0f;
                HomeActivity.this.f507 = 3.0f;
                HomeActivity.this.f508 = 3.0f;
                HomeActivity.this.f509 = 6.0f;
                HomeActivity.this.f510 = 10.0f;
                HomeActivity.this.f511 = 6.0f;
                c3891M13890.m12507(HomeActivity.this.f505);
                c3891M13890.m12511(HomeActivity.this.f506);
                c3891M13890.m12508(HomeActivity.this.f507);
                c3891M13890.m12505(HomeActivity.this.f508);
                c3891M13890.m12509(HomeActivity.this.f509);
                c3891M13890.m12506(HomeActivity.this.f510);
                c3891M13890.m12512(HomeActivity.this.f511);
                C2764.m10018().m10038(HomeActivity.this.f505 / 10.0f);
                C2764.m10018().m10047(HomeActivity.this.f506 / 10.0f);
                C2764.m10018().m10040(HomeActivity.this.f507 / 10.0f);
                C2764.m10018().m10036(HomeActivity.this.f508 / 10.0f);
                C2764.m10018().m10042(HomeActivity.this.f509 / 10.0f);
                C2764.m10018().m10043(HomeActivity.this.f510 / 10.0f);
                C2764.m10018().m10048(HomeActivity.this.f511 / 10.0f);
            }
            C4535.m13880().m13915();
            HomeActivity.this.f437.m2038();
            HomeActivity.this.m1129();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޅ, reason: contains not printable characters */
        public void mo1200(int i) {
            HomeActivity.this.f437.m2029(i);
            if (HomeActivity.this.f437.getCaptureMode() == 0) {
                HomeActivity.this.f437.m2041();
            } else {
                HomeActivity.this.f439 = 0;
                HomeActivity.this.m954();
            }
            C4535.m13880().m13890().m12348(i);
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ކ, reason: contains not printable characters */
        public void mo1201(int i, float f) {
            switch (i) {
                case 1:
                    HomeActivity.this.f505 = f;
                    C2764.m10018().m10038(HomeActivity.this.f505 / 10.0f);
                    break;
                case 2:
                    HomeActivity.this.f506 = f;
                    C2764.m10018().m10047(HomeActivity.this.f506 / 10.0f);
                    break;
                case 3:
                    HomeActivity.this.f507 = f;
                    C2764.m10018().m10040(HomeActivity.this.f507 / 10.0f);
                    break;
                case 4:
                    HomeActivity.this.f508 = f;
                    C2764.m10018().m10036(HomeActivity.this.f508 / 10.0f);
                    break;
                case 5:
                    HomeActivity.this.f509 = f;
                    C2764.m10018().m10042(HomeActivity.this.f509 / 10.0f);
                    break;
                case 6:
                    HomeActivity.this.f510 = f;
                    C2764.m10018().m10043(HomeActivity.this.f510 / 10.0f);
                    break;
                case 7:
                    HomeActivity.this.f511 = f;
                    C2764.m10018().m10048(HomeActivity.this.f511 / 10.0f);
                    break;
            }
            HomeActivity.this.f437.m2038();
            HomeActivity.this.m1129();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: އ, reason: contains not printable characters */
        public void mo1202(w5 w5Var) {
            HomeActivity.this.f439 = 0;
            HomeActivity.this.f437.setTargetVideoSize(w5Var.m8506());
            HomeActivity.this.m954();
            C3891 c3891M13890 = C4535.m13880().m13890();
            c3891M13890.m12358(w5Var.m8506().m8846());
            c3891M13890.m12357(w5Var.m8506().m8843());
            C4535.m13880().m13915();
            C2949 c2949M12803 = C3952.m12801().m12803(HomeActivity.this.f565 ? c3891M13890.m12399() : c3891M13890.m12380());
            if (c2949M12803 != null) {
                c2949M12803.m10361(w5Var.m8506().m8846());
                c2949M12803.m10360(w5Var.m8506().m8843());
                C3952.m12801().m12804(c2949M12803);
            }
            C4535.m13880().m13911(w5Var.m8506().m8846());
            C4535.m13880().m13910(w5Var.m8506().m8843());
            HomeActivity.this.f437.m1989();
            HomeActivity.this.m1129();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ވ, reason: contains not printable characters */
        public boolean mo1203() {
            return HomeActivity.this.f553 != 2;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: މ, reason: contains not printable characters */
        public void mo1204() {
            HomeActivity.this.f449 = 3;
            HomeActivity.this.f547.m11880(false);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ފ, reason: contains not printable characters */
        public void mo1205(float f) {
            C3444.m11227().m11263(f);
            HomeActivity.this.f437.setAudioLevel(f);
            C4535.m13880().m13890().m12500(f);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ދ, reason: contains not printable characters */
        public void mo1206(boolean z) {
            C3891 c3891M13890 = C4535.m13880().m13890();
            c3891M13890.m12510(z);
            C4535.m13880().m13915();
            if (z) {
                C2764.m10018().m10038(c3891M13890.m12385() / 10.0f);
                C2764.m10018().m10047(c3891M13890.m12390() / 10.0f);
                C2764.m10018().m10040(c3891M13890.m12386() / 10.0f);
                C2764.m10018().m10036(c3891M13890.m12382() / 10.0f);
                C2764.m10018().m10042(c3891M13890.m12387() / 10.0f);
                C2764.m10018().m10043(c3891M13890.m12382() / 10.0f);
                C2764.m10018().m10048(c3891M13890.m12396() / 10.0f);
            } else {
                C2764.m10018().m10038(0.0f);
                C2764.m10018().m10047(0.0f);
                C2764.m10018().m10040(0.0f);
                C2764.m10018().m10036(0.0f);
                C2764.m10018().m10042(0.0f);
                C2764.m10018().m10043(0.0f);
                C2764.m10018().m10048(0.0f);
            }
            HomeActivity.this.f437.m2038();
            HomeActivity.this.m1129();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ތ, reason: contains not printable characters */
        public void mo1207(int i) {
            HomeActivity.this.f553 = 2;
            C3444.m11227().m11264(i);
            HomeActivity.this.f437.m2005(C3444.m11227().m11242());
            if (HomeActivity.this.f429) {
                C4638.m14099("reConfigAudio", String.format("reConfigAudio : %s ", "onMicrophoneTypeChange"));
            }
            HomeActivity.this.f437.m1988();
            C4535.m13880().m13890().m12531(C3444.m11227().m11242());
            C4535.m13880().m13890().m12353(C3444.m11227().m11242());
            C4535.m13880().m13915();
            HomeActivity.this.m987(i);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ލ, reason: contains not printable characters */
        public void mo1208(C3828 c3828) throws JSONException {
            HomeActivity.this.f439 = 0;
            if (HomeActivity.this.f429) {
                C4638.m14099("FilmHomeActivity", String.format("cameraState : %s ", Integer.valueOf(HomeActivity.this.f439)));
            }
            HomeActivity.this.f431.mo10609(c3828);
            C3891 c3891M13890 = C4535.m13880().m13890();
            HomeActivity.this.m1087(false);
            HomeActivity.this.m1016(c3828.m12137());
            c3891M13890.m12515(C3444.m11223(c3828));
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ގ, reason: contains not printable characters */
        public void mo1209(int i) {
            HomeActivity.this.f585 = i;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޏ, reason: contains not printable characters */
        public void mo1210() {
            if (HomeActivity.this.f439 == 1) {
                if (HomeActivity.this.f533 == 0) {
                    HomeActivity.this.f533 = 1;
                    HomeActivity.this.f430.f13664.m2043(2);
                } else {
                    HomeActivity.this.f533 = 0;
                    HomeActivity.this.f430.f13664.m2043(0);
                }
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ސ, reason: contains not printable characters */
        public boolean mo1211() {
            return HomeActivity.this.f556;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޑ, reason: contains not printable characters */
        public void mo1212() {
            HomeActivity.this.m1097();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޒ, reason: contains not printable characters */
        public float mo1213() {
            return HomeActivity.this.f437.getTranslationX();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޓ, reason: contains not printable characters */
        public void mo1214() {
            HomeActivity.this.m1018(true);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޔ, reason: contains not printable characters */
        public void mo1215() {
            HomeActivity.this.m1084();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޕ, reason: contains not printable characters */
        public boolean mo1216() {
            return HomeActivity.this.f527;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޖ, reason: contains not printable characters */
        public void mo1217() {
            HomeActivity.this.m1170();
            HomeActivity.this.m1047();
            HomeActivity homeActivity = HomeActivity.this;
            homeActivity.m1148(homeActivity.f526);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޗ, reason: contains not printable characters */
        public void mo1218(int i, String str, boolean z) {
            if (HomeActivity.this.f434 != null) {
                HomeActivity.this.f468 = true;
                HomeActivity.this.f434.m12024();
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޘ, reason: contains not printable characters */
        public void mo1219(boolean z) {
            HomeActivity.this.f527 = z;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޙ, reason: contains not printable characters */
        public void mo1220(float f, float f2) {
            HomeActivity.this.f437.m2006(f, f2);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޚ, reason: contains not printable characters */
        public boolean mo1221() {
            return HomeActivity.this.f484;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޛ, reason: contains not printable characters */
        public int mo1222() {
            return HomeActivity.this.f533;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޜ, reason: contains not printable characters */
        public boolean mo1223() {
            return HomeActivity.this.f470;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޝ, reason: contains not printable characters */
        public void mo1224(boolean z) {
            HomeActivity.this.f470 = z;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޞ, reason: contains not printable characters */
        public void mo1225(int i) {
            if (HomeActivity.this.f543) {
                return;
            }
            if (i == 2) {
                HomeActivity homeActivity = HomeActivity.this;
                homeActivity.f466 = homeActivity.f464;
            } else if (i == 3) {
                HomeActivity homeActivity2 = HomeActivity.this;
                homeActivity2.f466 = homeActivity2.f465;
            } else {
                HomeActivity homeActivity3 = HomeActivity.this;
                homeActivity3.f466 = homeActivity3.f463;
            }
            ACHelper.getInstance().setSelectDecoderParamsBean(HomeActivity.this.f466);
            ACHelper aCHelper = ACHelper.getInstance();
            boolean z = true;
            if (i != 1 && i != 3) {
                z = false;
            }
            aCHelper.setSpeed(z);
            ACHelper.getInstance().setCameraQualityType(i);
            if (!HomeActivity.this.f543 || ACHelper.getInstance().isCameraIsAlbumMode()) {
                return;
            }
            HomeActivity.this.m1038();
            ConnectionManager.getInstance().rePreviewEncode(HomeActivity.this.f462);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޟ, reason: contains not printable characters */
        public float mo1226() {
            return HomeActivity.this.f437.getTranslationY();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޠ, reason: contains not printable characters */
        public boolean mo1227() {
            return HomeActivity.this.f493;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޡ, reason: contains not printable characters */
        public boolean mo1228() {
            return HomeActivity.this.m955();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޢ, reason: contains not printable characters */
        public boolean mo1229() {
            return HomeActivity.this.m1178();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޣ, reason: contains not printable characters */
        public void mo1230() {
            float fM12744 = C3947.m12727().m12744();
            if (HomeActivity.this.f439 == 1) {
                HomeActivity.this.f437.m2012((int) fM12744, C3947.m12727().m12734());
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޤ, reason: contains not printable characters */
        public void mo1231() {
            if (HomeActivity.this.f440 == 1) {
                return;
            }
            HomeActivity.this.m993(1);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޥ, reason: contains not printable characters */
        public void mo1232() {
            HomeActivity.this.m1091();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ޱ, reason: contains not printable characters */
        public void mo1233(int i) {
            HomeActivity.this.m1056(i);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ߾, reason: contains not printable characters */
        public boolean mo1234() {
            return HomeActivity.this.m1104();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ߿, reason: contains not printable characters */
        public void mo1235() {
            if (HomeActivity.this.f434 != null) {
                HomeActivity.this.f468 = false;
                HomeActivity.this.f434.m11996();
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡠ, reason: contains not printable characters */
        public void mo1236() {
            if (HomeActivity.this.m1104() && System.currentTimeMillis() - HomeActivity.this.f532 >= 200 && HomeActivity.this.f439 == 1) {
                HomeActivity.this.f532 = System.currentTimeMillis();
                HomeActivity.this.f565 = !r0.f565;
                C4535.m13880().m13890().m12363(HomeActivity.this.f565);
                if (HomeActivity.this.f565) {
                    if (!(C3947.m12727().m12769() && C3947.m12727().m12767())) {
                        C3947.m12727().m12779(true);
                    }
                }
                C4535.m13880().m13915();
                HomeActivity.this.f431.mo10509();
                HomeActivity.this.m1029();
                HomeActivity.this.m1160();
                HomeActivity.this.m1066();
                HomeActivity.this.m970();
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡡ, reason: contains not printable characters */
        public void mo1237(int i, int i2, boolean z, DecoderParamsBean decoderParamsBean) {
            ACBanManager.getInstance().clearAlreadySetControl();
            HomeActivity.this.f452 = i2;
            boolean z2 = true;
            HomeActivity.this.f467 = true;
            TransmitHelper.getInstance().setStartCameraTransmit(HomeActivity.this.f467);
            ACHelper aCHelper = ACHelper.getInstance();
            if (i != 1 && i != 3) {
                z2 = false;
            }
            aCHelper.setSpeed(z2);
            ACHelper.getInstance().setCameraQualityType(i);
            if (HomeActivity.this.f431 != null) {
                HomeActivity.this.f431.mo10614();
            }
            HomeActivity homeActivity = HomeActivity.this;
            if (decoderParamsBean == null) {
                decoderParamsBean = homeActivity.f462;
            }
            homeActivity.m1109(decoderParamsBean);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡢ, reason: contains not printable characters */
        public void mo1238(float f) {
            int iM12730 = C3947.m12727().m12730(f);
            float f2 = iM12730;
            if (f2 != HomeActivity.this.f554) {
                HomeActivity.this.f554 = f2;
                C3947.m12727().m12783(((f + 1.0f) * 1.0f) / 2.0f);
                HomeActivity.this.f431.mo10551();
                if (HomeActivity.this.f439 == 1) {
                    HomeActivity.this.f437.m2012(iM12730, C3947.m12727().m12734());
                }
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡣ, reason: contains not printable characters */
        public void mo1239(boolean z) {
            HomeActivity.this.m1033(z);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡤ, reason: contains not printable characters */
        public void mo1240() {
            HomeActivity.this.m1170();
            HomeActivity.this.f431.mo10478(false);
            C4008.m12876(HomeActivity.this.f430.f13658, 0.0f, 100, new C0125());
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡥ, reason: contains not printable characters */
        public void mo1241() {
            HomeActivity.this.m1036();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡦ, reason: contains not printable characters */
        public void mo1242(boolean z) {
            C3444.m11227().m11266(z);
            C4535.m13880().m13890().m12492(z);
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡧ, reason: contains not printable characters */
        public void mo1243() {
            HomeActivity.this.m983();
            HomeActivity.this.m1001();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡨ, reason: contains not printable characters */
        public float mo1244() {
            return HomeActivity.this.f482;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡩ, reason: contains not printable characters */
        public void mo1245() {
            if (HomeActivity.this.m1070()) {
                if (HomeActivity.this.f488 == 0) {
                    HomeActivity.this.f488 = 1;
                } else {
                    HomeActivity.this.f488 = 0;
                }
                HomeActivity.this.m1064();
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࡪ, reason: contains not printable characters */
        public void mo1246(boolean z, boolean z2) {
            HomeActivity.this.f513 = z;
            if (z) {
                if (z2) {
                    if (HomeActivity.this.f431 instanceof C3295) {
                        ((C3295) HomeActivity.this.f431).m11131();
                    }
                    HomeActivity.this.m1025();
                    if (!HomeActivity.this.f467) {
                        if (HomeActivity.this.f440 == 1) {
                            HomeActivity.this.m1120();
                            HomeActivity.this.f440 = 0;
                            HomeActivity.this.m975();
                        }
                        HomeActivity.this.m1110();
                    }
                }
                HomeActivity.this.m994();
            } else if (z2) {
                if (HomeActivity.this.f431 instanceof C3295) {
                    ((C3295) HomeActivity.this.f431).m11114();
                }
                if (!HomeActivity.this.f467) {
                    HomeActivity.this.m1094();
                }
                HomeActivity.this.m1149();
            }
            HomeActivity.this.f461 = z;
            HomeActivity.this.m1125(z, false);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢠ, reason: contains not printable characters */
        public boolean mo1247() {
            return HomeActivity.this.f557;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢡ, reason: contains not printable characters */
        public int mo1248() {
            return HomeActivity.this.f439;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢢ, reason: contains not printable characters */
        public void mo1249(boolean z) {
            HomeActivity.this.f515 = z;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢣ, reason: contains not printable characters */
        public float mo1250() {
            return HomeActivity.this.f525;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢤ, reason: contains not printable characters */
        public boolean mo1251() {
            return HomeActivity.this.f562;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢥ, reason: contains not printable characters */
        public boolean mo1252() {
            return HomeActivity.this.f528;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢦ, reason: contains not printable characters */
        public void mo1253(float f) {
            if (HomeActivity.this.f439 == 1) {
                HomeActivity.this.f437.m1972(f);
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢧ, reason: contains not printable characters */
        public void mo1254(float f, float f2, float f3) {
            if (C2520.m9312().m9319(HomeActivity.this.f430.f13664.getCameraID())) {
                C3947.m12727().m12781(f3);
            } else {
                C3947.m12727().m12782(f3);
            }
            if (HomeActivity.this.f439 == 1) {
                HomeActivity.this.f437.m1975(f, f2);
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢨ, reason: contains not printable characters */
        public void mo1255() {
            if (HomeActivity.this.f440 == 1) {
                return;
            }
            if (HomeActivity.this.f526 != HomeActivity.this.f527) {
                HomeActivity.this.f526 = true;
                HomeActivity.this.f527 = true;
            }
            HomeActivity.this.m1170();
            HomeActivity.this.m1084();
            HomeActivity homeActivity = HomeActivity.this;
            homeActivity.m1148(homeActivity.f526);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢩ, reason: contains not printable characters */
        public void mo1256() {
            HomeActivity.this.f431.mo10485(false);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢪ, reason: contains not printable characters */
        public void mo1257(boolean z) {
            HomeActivity.this.m952(z);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢫ, reason: contains not printable characters */
        public void mo1258() {
            HomeActivity.this.m993(2);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢬ, reason: contains not printable characters */
        public void mo1259() {
            HomeActivity.this.m993(1);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢭ, reason: contains not printable characters */
        public void mo1260(int i) {
            HomeActivity.this.m1059(i);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢮ, reason: contains not printable characters */
        public boolean mo1261() {
            return HomeActivity.this.f526;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢯ, reason: contains not printable characters */
        public int mo1262() {
            return HomeActivity.this.f438;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢰ, reason: contains not printable characters */
        public void mo1263() {
            int iM9566 = C2618.m9566("play_open_numbers", 0);
            if (C4843.m14569().m14571() && iM9566 <= 4) {
                int i = iM9566 + 1;
                C2618.m9571("play_open_numbers", i);
                if (i == 4) {
                    HomeActivity.this.m1075();
                    return;
                }
            }
            if (HomeActivity.this.f576) {
                return;
            }
            HomeActivity.this.f576 = true;
            HomeActivity.this.m1170();
            C4008.m12876(HomeActivity.this.f430.f13658, 0.0f, 100, new C0126());
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢱ, reason: contains not printable characters */
        public void mo1264(int i) {
            C3891 c3891M13890 = C4535.m13880().m13890();
            switch (i) {
                case 1:
                    HomeActivity.this.f505 = c3891M13890.m12385();
                    C2764.m10018().m10038(HomeActivity.this.f505 / 10.0f);
                    break;
                case 2:
                    HomeActivity.this.f506 = c3891M13890.m12390();
                    C2764.m10018().m10047(HomeActivity.this.f506 / 10.0f);
                    break;
                case 3:
                    HomeActivity.this.f507 = c3891M13890.m12386();
                    C2764.m10018().m10040(HomeActivity.this.f507 / 10.0f);
                    break;
                case 4:
                    HomeActivity.this.f508 = c3891M13890.m12382();
                    C2764.m10018().m10036(HomeActivity.this.f508 / 10.0f);
                    break;
                case 5:
                    HomeActivity.this.f509 = c3891M13890.m12387();
                    C2764.m10018().m10042(HomeActivity.this.f509 / 10.0f);
                    break;
                case 6:
                    HomeActivity.this.f510 = c3891M13890.m12383();
                    C2764.m10018().m10043(HomeActivity.this.f510 / 10.0f);
                    break;
                case 7:
                    HomeActivity.this.f511 = c3891M13890.m12396();
                    C2764.m10018().m10048(HomeActivity.this.f511 / 10.0f);
                    break;
            }
            HomeActivity.this.f437.m2038();
            HomeActivity.this.m1129();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢲ, reason: contains not printable characters */
        public void mo1265() {
            HomeActivity.this.f484 = !r0.f484;
            z0.m8636(HomeActivity.this, HomeActivity.this.f484 ? 1 : 0);
            HomeActivity homeActivity = HomeActivity.this;
            homeActivity.m1090(homeActivity.f484 ? R.string.POPUP_BRIGHTNESS_MAX : R.string.POPUP_BRIGHTNESS_NORMAL);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢳ, reason: contains not printable characters */
        public void mo1266(float f) {
            float fM12738 = C3947.m12727().m12738();
            float fM12735 = C3947.m12727().m12735();
            if (HomeActivity.this.f439 == 1) {
                HomeActivity.this.f437.m1973((int) fM12738, fM12735);
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢴ, reason: contains not printable characters */
        public int mo1267() {
            return HomeActivity.this.f440;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢶ, reason: contains not printable characters */
        public boolean mo1268() {
            return HomeActivity.this.f560;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢷ, reason: contains not printable characters */
        public boolean mo1269() {
            return HomeActivity.this.m1179();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢸ, reason: contains not printable characters */
        public boolean mo1270() {
            return HomeActivity.this.f565;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢹ, reason: contains not printable characters */
        public void mo1271() {
            float fM12738 = C3947.m12727().m12738();
            float fM12735 = C3947.m12727().m12735();
            if (HomeActivity.this.f439 == 1) {
                HomeActivity.this.f437.m1973((int) fM12738, fM12735);
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢺ, reason: contains not printable characters */
        public void mo1272(String str) {
            HomeActivity.this.m1175(str);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢻ, reason: contains not printable characters */
        public void mo1273(boolean z) {
            boolean z2 = C3947.m12727().m12729() == 1;
            if (!z) {
                if (z2) {
                    if (HomeActivity.this.f589 != -2) {
                        HomeActivity homeActivity = HomeActivity.this;
                        homeActivity.f585 = homeActivity.f589;
                        HomeActivity.this.f589 = -1;
                        HomeActivity homeActivity2 = HomeActivity.this;
                        homeActivity2.m1069(homeActivity2.f585);
                    } else {
                        HomeActivity.this.f589 = -1;
                    }
                }
                C4535.m13880().m13915();
                return;
            }
            if (z2) {
                if (HomeActivity.this.f585 != -1) {
                    HomeActivity.this.f589 = -2;
                    return;
                }
                HomeActivity homeActivity3 = HomeActivity.this;
                homeActivity3.f589 = homeActivity3.f585;
                HomeActivity.this.f585 = 2;
                HomeActivity homeActivity4 = HomeActivity.this;
                homeActivity4.m1069(homeActivity4.f585);
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢼ, reason: contains not printable characters */
        public void mo1274(boolean z) {
            HomeActivity.this.f526 = z;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢽ, reason: contains not printable characters */
        public void mo1275() {
            if (HomeActivity.this.f534 || HomeActivity.this.f535) {
                return;
            }
            HomeActivity.this.f541 = true;
            HomeActivity.this.m1029();
            HomeActivity.this.m970();
            if (HomeActivity.this.m1159(C4535.m13880().m13890().m12442())) {
                HomeActivity.this.m1132();
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢾ, reason: contains not printable characters */
        public void mo1276(RectF rectF) {
            HomeActivity.this.f437.setMeterAfRegion(HomeActivity.this.f431.mo10513());
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࢿ, reason: contains not printable characters */
        public void mo1277() {
            m1300();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࣀ, reason: contains not printable characters */
        public void mo1278(float f) {
            if (HomeActivity.this.f439 == 1) {
                HomeActivity.this.f437.m1975(0.0f, f);
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࣁ, reason: contains not printable characters */
        public void mo1279(float f) {
            if (HomeActivity.this.f439 == 1) {
                if (f > 1.0f || f < 0.0f) {
                    if ((f == 1.25f || f == -0.25f) && -1.0f != HomeActivity.this.f437.getFocusPercent()) {
                        HomeActivity.this.f437.m1972(-1.0f);
                        return;
                    }
                    return;
                }
                float fM12756 = C3947.m12727().m12756(f);
                if (HomeActivity.this.f429) {
                    C4638.m14099("slimmm", "realFocusPByPro:" + fM12756 + " pro:" + f);
                }
                if (fM12756 != HomeActivity.this.f437.getFocusPercent()) {
                    HomeActivity.this.f437.m1972(fM12756);
                }
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࣂ, reason: contains not printable characters */
        public void mo1280() {
            HomeActivity.this.m1050();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࣃ, reason: contains not printable characters */
        public int mo1281() {
            return HomeActivity.this.f487;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࣄ, reason: contains not printable characters */
        public void mo1282(float f, float f2) {
            HomeActivity.this.m1073(f, f2);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࣅ, reason: contains not printable characters */
        public void mo1283(int i, float f) {
            if (HomeActivity.this.f439 == 1) {
                HomeActivity.this.f437.m2012(i, f);
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࣆ, reason: contains not printable characters */
        public boolean mo1284() {
            return HomeActivity.this.f561;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ࣇ, reason: contains not printable characters */
        public void mo1285(int i) {
            HomeActivity.this.m956(i);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ৼ, reason: contains not printable characters */
        public boolean mo1286() {
            return HomeActivity.this.m988();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ૹ, reason: contains not printable characters */
        public int mo1287() {
            return HomeActivity.this.f486;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ಀ, reason: contains not printable characters */
        public void mo1288() {
            HomeActivity.this.f431.mo10566();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ೱ, reason: contains not printable characters */
        public void mo1289(boolean z) {
            HomeActivity.this.f528 = z;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ೲ, reason: contains not printable characters */
        public void mo1290(float f, float f2, boolean z, boolean z2) {
            HomeActivity.this.m1171(f, f2, z, z2);
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ഄ, reason: contains not printable characters */
        public boolean mo1291() {
            return HomeActivity.this.f563;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ഩ, reason: contains not printable characters */
        public boolean mo1292() {
            return C2764.m10018().m10019();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ഺ, reason: contains not printable characters */
        public boolean mo1293() {
            return HomeActivity.this.m974();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ൎ, reason: contains not printable characters */
        public boolean mo1294() {
            return HomeActivity.this.f555;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ൔ, reason: contains not printable characters */
        public void mo1295() {
            if (HomeActivity.this.f439 == 1) {
                float fM12738 = C3947.m12727().m12738();
                HomeActivity.this.f437.m1973((int) fM12738, C3947.m12727().m12735());
            }
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ൕ, reason: contains not printable characters */
        public boolean mo1296() {
            return C4535.m13880().m13890().m12389();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ൖ, reason: contains not printable characters */
        public boolean mo1297() {
            return HomeActivity.this.f558;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ൟ, reason: contains not printable characters */
        public void mo1298(int i) {
            if (!HomeActivity.this.m955()) {
                HomeActivity.this.f431.mo10611(true);
                return;
            }
            if (i != 1) {
                if (i == 0) {
                    HomeActivity.this.m1035();
                    HomeActivity.this.f440 = 0;
                    HomeActivity.this.f431.mo10611(false);
                    HomeActivity.this.f512 = true;
                    HomeActivity.this.m975();
                    HomeActivity.this.f431.mo10591(true);
                    return;
                }
                return;
            }
            HomeActivity.this.m1170();
            if (HomeActivity.this.f526) {
                HomeActivity.this.m1047();
            }
            HomeActivity.this.f523 = System.currentTimeMillis();
            HomeActivity.this.f440 = 1;
            HomeActivity.this.f431.mo10611(false);
            HomeActivity.this.m1006(true);
            HomeActivity.this.f431.mo10591(false);
            HomeActivity.this.m1139(true, new C0127());
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ຆ, reason: contains not printable characters */
        public void mo1299() throws JSONException {
            if (HomeActivity.this.f565) {
                return;
            }
            HomeActivity.this.m1106();
        }

        /* renamed from: ຉ, reason: contains not printable characters */
        public final void m1300() {
            int i;
            int iM9439 = C2579.m9439(HomeActivity.this);
            int iM9444 = C2579.m9444();
            float f = (iM9444 * 1.0f) / iM9439;
            int i2 = HomeActivity.this.f492;
            float f2 = 2.0f;
            if (i2 == 0) {
                HomeActivity.this.f492 = 1;
                i = R.string.POPUP_DISPLAY_ZOOM_FULLSCREEN;
                HomeActivity.this.f548 = f;
                f2 = f;
                f = 1.0f;
            } else if (i2 != 1) {
                HomeActivity.this.f492 = 0;
                HomeActivity.this.f548 = 1.0f;
                i = R.string.POPUP_DISPLAY_ZOOM_ORIGIN;
                f = 2.0f;
                f2 = 1.0f;
            } else {
                HomeActivity.this.f492 = 2;
                i = R.string.POPUP_DISPLAY_ZOOM_2X;
                HomeActivity.this.f548 = 2.0f;
            }
            C4638.m14099("FilmHomeActivity", String.format("changeCameraZoom screenW : %s , cameraW : %s , cameraShowType : %s , fromScale : %s , toScale : %s ", Integer.valueOf(iM9444), Integer.valueOf(iM9439), Integer.valueOf(HomeActivity.this.f492), Float.valueOf(f), Float.valueOf(f2)));
            HomeActivity homeActivity = HomeActivity.this;
            homeActivity.f493 = homeActivity.f492 != 0;
            if (HomeActivity.this.f493) {
                HomeActivity.this.m990();
            }
            C4535.m13880().m13890().m12444();
            HomeActivity.this.m977(false);
            HomeActivity.this.m1162();
            HomeActivity.this.m1090(i);
            C4008.m12880(0.0f, 1.0f, 200L, new C0124(f, f2));
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ຌ, reason: contains not printable characters */
        public void mo1301(int i, float f) {
            C3891 c3891M13890 = C4535.m13880().m13890();
            switch (i) {
                case 1:
                    c3891M13890.m12507(f);
                    HomeActivity.this.f505 = f;
                    C2764.m10018().m10038(HomeActivity.this.f505 / 10.0f);
                    break;
                case 2:
                    c3891M13890.m12511(f);
                    HomeActivity.this.f506 = f;
                    C2764.m10018().m10047(HomeActivity.this.f506 / 10.0f);
                    break;
                case 3:
                    c3891M13890.m12508(f);
                    HomeActivity.this.f507 = f;
                    C2764.m10018().m10040(HomeActivity.this.f507 / 10.0f);
                    break;
                case 4:
                    c3891M13890.m12505(f);
                    HomeActivity.this.f508 = f;
                    C2764.m10018().m10036(HomeActivity.this.f508 / 10.0f);
                    break;
                case 5:
                    c3891M13890.m12509(f);
                    HomeActivity.this.f509 = f;
                    C2764.m10018().m10042(HomeActivity.this.f509 / 10.0f);
                    break;
                case 6:
                    c3891M13890.m12506(f);
                    HomeActivity.this.f510 = f;
                    C2764.m10018().m10043(HomeActivity.this.f510 / 10.0f);
                    break;
                case 7:
                    c3891M13890.m12512(f);
                    HomeActivity.this.f511 = f;
                    C2764.m10018().m10048(HomeActivity.this.f511 / 10.0f);
                    break;
            }
            C4535.m13880().m13915();
            HomeActivity.this.f437.m2038();
            HomeActivity.this.m1129();
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ຎ, reason: contains not printable characters */
        public boolean mo1302() {
            return HomeActivity.this.f559;
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ຏ, reason: contains not printable characters */
        public void mo1303(boolean z, int i) {
            C3410.C3411 c3411M9318 = C2520.m9312().m9318(i);
            if (c3411M9318 == null || !c3411M9318.m11188() || HomeActivity.this.f437.getCameraID().equals(c3411M9318.m11183().m11360())) {
                return;
            }
            HomeActivity.this.f485 = true;
            if (HomeActivity.this.f440 == 1) {
                HomeActivity.this.f431.mo10542(0, false);
            }
            HomeActivity.this.m1016(c3411M9318.m11183().m11360());
        }

        @Override // com.blink.academy.film.home.fragment.FragmentCallback
        /* renamed from: ຐ, reason: contains not printable characters */
        public void mo1304(int i) {
            HomeActivity.this.f438 = i;
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$Ϳ, reason: contains not printable characters */
    public class C0132 implements C3947.InterfaceC3948 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$Ϳ$Ϳ, reason: contains not printable characters */
        public class RunnableC0133 implements Runnable {
            public RunnableC0133() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.m1121();
            }
        }

        public C0132() {
        }

        @Override // defpackage.C3947.InterfaceC3948
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1308() {
            HomeActivity.this.runOnUiThread(new RunnableC0133());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$Ԩ, reason: contains not printable characters */
    public class C0134 implements BillingManager.OnSupportEnable {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ BillingManager f608;

        /* renamed from: com.blink.academy.film.home.HomeActivity$Ԩ$Ϳ, reason: contains not printable characters */
        public class C0135 implements InterfaceC4875 {

            /* renamed from: com.blink.academy.film.home.HomeActivity$Ԩ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC0136 implements Runnable {
                public RunnableC0136() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3659.m11744().m11745(1);
                    HomeActivity.this.m1082(true);
                }
            }

            /* renamed from: com.blink.academy.film.home.HomeActivity$Ԩ$Ϳ$Ԩ, reason: contains not printable characters */
            public class RunnableC0137 implements Runnable {
                public RunnableC0137() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3659.m11744().m11745(1);
                    HomeActivity.this.m1082(true);
                }
            }

            public C0135() {
            }

            @Override // defpackage.InterfaceC4875
            /* renamed from: Ϳ, reason: contains not printable characters */
            public void mo1309(int i) {
                if (HomeActivity.this.f429) {
                    C4638.m14099("slimmmmmmm", "fail:" + i);
                }
                if (i == 8 || i == 0 || i == -2) {
                    HomeActivity.this.f460.post(new RunnableC0137());
                }
                HomeActivity.this.m980();
            }

            @Override // defpackage.InterfaceC4875
            /* renamed from: Ԩ, reason: contains not printable characters */
            public void mo1310(Purchase purchase) {
                if (HomeActivity.this.f429) {
                    C4638.m14099("slimmmmmmm", "onQuerySuc");
                }
                if (purchase != null) {
                    C2618.m9573("local_sub_pus_sp", new Gson().toJson(purchase));
                    C3659.m11744().m11751(0);
                } else {
                    HomeActivity.this.f460.post(new RunnableC0136());
                }
                HomeActivity.this.m980();
            }
        }

        public C0134(BillingManager billingManager) {
            this.f608 = billingManager;
        }

        @Override // com.blink.academy.film.support.pay.google.BillingManager.OnSupportEnable
        public void onDisable() {
            C4843.m14569().m14573(false);
            if (HomeActivity.this.f429) {
                C4638.m14099("WME", "isCanGooglePlay: " + C4843.m14569().m14571());
            }
            C3659.m11744().m11745(1);
            this.f608.destroy();
        }

        @Override // com.blink.academy.film.support.pay.google.BillingManager.OnSupportEnable
        public void onEnable() {
            C4843.m14569().m14573(true);
            if (HomeActivity.this.f429) {
                C4638.m14099("WME", "isCanGooglePlay: " + C4843.m14569().m14571());
            }
            this.f608.destroy();
            CachePlayStoreBean cachePlayStoreBeanM11747 = C3659.m11744().m11747();
            if (cachePlayStoreBeanM11747 != null) {
                C4757.m14304().m14319(HomeActivity.this, cachePlayStoreBeanM11747.getSubsId(), new C0135());
            } else {
                HomeActivity.this.m980();
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$Ԫ, reason: contains not printable characters */
    public class RunnableC0138 implements Runnable {

        /* renamed from: com.blink.academy.film.home.HomeActivity$Ԫ$Ϳ, reason: contains not printable characters */
        public class C0139 extends AbstractC4012 {
            public C0139() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                if (HomeActivity.this.f536 != null) {
                    HomeActivity homeActivity = HomeActivity.this;
                    homeActivity.f430.f13674.removeView(homeActivity.f536);
                    C2735.m9988(C4062.f14100);
                    C4062.f14100 = null;
                    HomeActivity.this.f536 = null;
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$Ԫ$Ԩ, reason: contains not printable characters */
        public class RunnableC0140 implements Runnable {
            public RunnableC0140() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.m1061(false);
            }
        }

        public RunnableC0138() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4008.m12876(HomeActivity.this.f430.f13658, 1.0f, 200, new C0139());
            if (HomeActivity.this.f575) {
                return;
            }
            HomeActivity.this.f460.postDelayed(new RunnableC0140(), 200L);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$Ԭ, reason: contains not printable characters */
    public class C0141 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SettingHintDialog f616;

        /* renamed from: com.blink.academy.film.home.HomeActivity$Ԭ$Ϳ, reason: contains not printable characters */
        public class C0142 extends AbstractC4012 {
            public C0142() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C0141.this.f616.setAlpha(0.0f);
                C0141.this.f616.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$Ԭ$Ԩ, reason: contains not printable characters */
        public class C0143 extends AbstractC4012 {
            public C0143() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C0141.this.f616.setVisibility(8);
            }
        }

        public C0141(SettingHintDialog settingHintDialog) {
            this.f616 = settingHintDialog;
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1311(int i) {
            C4008.m12876(this.f616, 0.0f, 100, new C0143());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1312(int i, C3891 c3891) {
            C4008.m12876(this.f616, 0.0f, 100, new C0142());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$Ԯ, reason: contains not printable characters */
    public class C0144 extends OperationCallback<Void> {
        public C0144() {
        }

        @Override // com.mob.OperationCallback
        public void onFailure(Throwable th) {
        }

        @Override // com.mob.OperationCallback
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onComplete(Void r1) {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ՠ, reason: contains not printable characters */
    public class C0145 implements PrivacyWebView.InterfaceC1095 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f621;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ՠ$Ϳ, reason: contains not printable characters */
        public class C0146 extends AbstractC4012 {
            public C0146() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13671.setVisibility(8);
                C0145 c0145 = C0145.this;
                HomeActivity.this.f449 = c0145.f621;
                C0145 c01452 = C0145.this;
                int i = c01452.f621;
                if (i == 2) {
                    HomeActivity.this.f547.m11880(true);
                } else {
                    if (i == 5) {
                        return;
                    }
                    HomeActivity.this.f547.m11880(false);
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ՠ$Ԩ, reason: contains not printable characters */
        public class C0147 extends AbstractC4012 {
            public C0147() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13671.setVisibility(8);
            }
        }

        public C0145(int i) {
            this.f621 = i;
        }

        @Override // com.blink.academy.film.widgets.dialog.login.PrivacyWebView.InterfaceC1095
        public void onDisagree() {
            HomeActivity.this.f430.f13659.setVisibility(8);
            HomeActivity.this.m1042(false);
            C4008.m12876(HomeActivity.this.f430.f13671, 0.0f, 100, new C0147());
            if (this.f621 == 5) {
                HomeActivity.this.finish();
            }
        }

        @Override // com.blink.academy.film.widgets.dialog.login.PrivacyWebView.InterfaceC1095
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1314(boolean z) {
            HomeActivity.this.f430.f13659.setVisibility(8);
            if (z) {
                C2618.m9571("privacy_alert_v_sp2", C2618.m9566("privacy_remote_v_sp", C2618.m9566("privacy_remote_v_sp", 1)));
            } else {
                C2618.m9571("terms_alert_v_sp2", C2618.m9566("terms_remote_v_sp", C2618.m9566("terms_remote_v_sp", 1)));
            }
            HomeActivity.this.m1042(true);
            C4008.m12876(HomeActivity.this.f430.f13671, 0.0f, 100, new C0146());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ֈ, reason: contains not printable characters */
    public class C0148 implements InterfaceC3866 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ֈ$Ϳ, reason: contains not printable characters */
        public class C0149 implements n.InterfaceC2190 {
            public C0149() {
            }

            @Override // defpackage.n.InterfaceC2190
            public void onFail() {
                if (HomeActivity.this.f434 != null) {
                    HomeActivity.this.f434.m12017();
                }
            }

            @Override // defpackage.n.InterfaceC2190
            public void onSuc() {
                ACHelper.getInstance().onNeedRefreshTime();
                if (HomeActivity.this.f434 != null) {
                    HomeActivity.this.f434.m12017();
                }
            }
        }

        public C0148() {
        }

        @Override // defpackage.InterfaceC3866
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1315() {
            n.m7588().m7594(new C0149());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$֏, reason: contains not printable characters */
    public class C0150 implements InterfaceC4886 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$֏$Ϳ, reason: contains not printable characters */
        public class C0151 implements InterfaceC3866 {

            /* renamed from: com.blink.academy.film.home.HomeActivity$֏$Ϳ$Ϳ, reason: contains not printable characters */
            public class C0152 implements n.InterfaceC2190 {
                public C0152() {
                }

                @Override // defpackage.n.InterfaceC2190
                public void onFail() {
                    if (HomeActivity.this.f434 != null) {
                        HomeActivity.this.f434.m12017();
                    }
                }

                @Override // defpackage.n.InterfaceC2190
                public void onSuc() {
                    ACHelper.getInstance().onNeedRefreshTime();
                    if (HomeActivity.this.f434 != null) {
                        HomeActivity.this.f434.m12017();
                    }
                }
            }

            public C0151() {
            }

            @Override // defpackage.InterfaceC3866
            /* renamed from: Ϳ */
            public void mo1315() {
                n.m7588().m7594(new C0152());
            }
        }

        public C0150() {
        }

        @Override // defpackage.InterfaceC4886
        public void onQueryPurchases(List<Purchase> list) {
            if (r1.m8144(list)) {
                C4638.m14104("bozai", "本地有待消费的订单   " + list);
                C4757.m14304().m14306(HomeActivity.this, list, new C0151());
            }
        }

        @Override // defpackage.InterfaceC4886
        public void onQueryPurchasesFail(int i) {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ׯ, reason: contains not printable characters */
    public class C0153 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ׯ$Ϳ, reason: contains not printable characters */
        public class C0154 extends AbstractC4012 {
            public C0154() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) throws JSONException {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13663.setVisibility(8);
                C4535.m13880().m13906();
                HomeActivity.this.m1087(true);
                HomeActivity.this.m1014();
                HomeActivity.this.m1063(true);
            }
        }

        public C0153() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) throws JSONException {
            HomeActivity.this.f430.f13663.setVisibility(8);
            C4535.m13880().m13906();
            HomeActivity.this.m1087(true);
            HomeActivity.this.m1014();
            HomeActivity.this.m1063(true);
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            C4008.m12876(HomeActivity.this.f430.f13663, 0.0f, 100, new C0154());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC0155 implements View.OnClickListener {
        public ViewOnClickListenerC0155() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ހ, reason: contains not printable characters */
    public class C0156 extends AbstractC4012 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ހ$Ϳ, reason: contains not printable characters */
        public class RunnableC0157 implements Runnable {
            public RunnableC0157() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.m972();
                HomeActivity.this.m1131();
                HomeActivity.this.f453 = 3;
                HomeActivity.this.setRequestedOrientation(0);
                C4792.m14375().m14504(false);
            }
        }

        public C0156() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            HomeActivity.this.f460.postDelayed(new RunnableC0157(), 50L);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ށ, reason: contains not printable characters */
    public class C0158 extends AbstractC4012 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ށ$Ϳ, reason: contains not printable characters */
        public class RunnableC0159 implements Runnable {
            public RunnableC0159() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.m1131();
                HomeActivity.this.m1086();
                HomeActivity.this.f453 = 3;
                HomeActivity.this.setRequestedOrientation(1);
                C4792.m14375().m14504(true);
            }
        }

        public C0158() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            HomeActivity.this.f460.postDelayed(new RunnableC0159(), 50L);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ނ, reason: contains not printable characters */
    public class C0160 implements C4567.InterfaceC4571 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ނ$Ϳ, reason: contains not printable characters */
        public class RunnableC0161 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f638;

            public RunnableC0161(int i) {
                this.f638 = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f431.mo10521(this.f638);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ނ$Ԩ, reason: contains not printable characters */
        public class RunnableC0162 implements Runnable {
            public RunnableC0162() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f540 = !r0.f540;
                HomeActivity.this.f431.mo10504(HomeActivity.this.f540);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ނ$Ԫ, reason: contains not printable characters */
        public class RunnableC0163 implements Runnable {
            public RunnableC0163() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HomeActivity.this.f539) {
                    HomeActivity.this.f539 = false;
                    HomeActivity.this.f540 = false;
                    if (C4535.m13880().m13890().m12490()) {
                        HomeActivity.this.f431.mo10510();
                    }
                }
                HomeActivity.this.f431.mo10504(HomeActivity.this.f540);
                HomeActivity.this.m1090(R.string.POPUP_PROTAKE_FOCUS_CONNECTED);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ނ$Ԭ, reason: contains not printable characters */
        public class RunnableC0164 implements Runnable {
            public RunnableC0164() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f431.mo10642();
                HomeActivity.this.m1090(R.string.POPUP_PROTAKE_FOCUS_DISCONNECTED);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ނ$Ԯ, reason: contains not printable characters */
        public class RunnableC0165 implements Runnable {
            public RunnableC0165() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HomeActivity.this.f439 == 1) {
                    HomeActivity.this.f431.mo10542(0, true);
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ނ$ՠ, reason: contains not printable characters */
        public class RunnableC0166 implements Runnable {
            public RunnableC0166() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HomeActivity.this.f540) {
                    HomeActivity.this.f431.mo10532();
                } else {
                    HomeActivity.this.f431.mo10510();
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ނ$ֈ, reason: contains not printable characters */
        public class RunnableC0167 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ boolean f645;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ int f646;

            public RunnableC0167(boolean z, int i) {
                this.f645 = z;
                this.f646 = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!HomeActivity.this.f540) {
                    boolean zM12772 = C3947.m12727().m12772();
                    if (HomeActivity.this.f439 == 1) {
                        if (zM12772) {
                            HomeActivity.this.m1027(this.f645, this.f646);
                            return;
                        } else {
                            HomeActivity.this.m966(this.f645, this.f646);
                            return;
                        }
                    }
                    return;
                }
                if (C3947.m12727().m12729() == 1) {
                    HomeActivity.this.f460.removeMessages(MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD);
                    if (HomeActivity.this.f585 == -1 && !HomeActivity.this.f442) {
                        HomeActivity.this.f442 = true;
                        HomeActivity homeActivity = HomeActivity.this;
                        homeActivity.f589 = homeActivity.f585;
                        HomeActivity.this.f585 = 0;
                        HomeActivity homeActivity2 = HomeActivity.this;
                        homeActivity2.m1069(homeActivity2.f585);
                    }
                    HomeActivity.this.f460.sendEmptyMessageDelayed(MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, 2000L);
                }
                if (HomeActivity.this.f439 == 1) {
                    if (C3947.m12727().m12765()) {
                        HomeActivity.this.m962(this.f645, this.f646);
                    } else if (C3947.m12727().m12749()) {
                        HomeActivity.this.m1166(this.f645, this.f646);
                    } else {
                        HomeActivity.this.m1146(this.f645, this.f646);
                    }
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ނ$֏, reason: contains not printable characters */
        public class RunnableC0168 implements Runnable {
            public RunnableC0168() {
            }

            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                C3891 c3891 = new C3891();
                String string = HomeActivity.this.getResources().getString(R.string.POPUP_TITLE_PROTAKE_FOCUS_UPDATE);
                String string2 = HomeActivity.this.getResources().getString(R.string.POPUP_DESC_PROTAKE_FOCUS_UPDATE);
                String string3 = HomeActivity.this.getResources().getString(R.string.BUTTON_CANCEL);
                String string4 = HomeActivity.this.getResources().getString(R.string.POPUP_DESC_PROTAKE_FOCUS_CONFIRM);
                c3891.m12515(string);
                c3891.m12553(string2);
                c3891.m12516(string3);
                c3891.m12503(string4);
                HomeActivity.this.m1015(c3891);
            }
        }

        public C0160() {
        }

        @Override // defpackage.C4567.InterfaceC4571
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1316() {
            HomeActivity.this.runOnUiThread(new RunnableC0163());
        }

        @Override // defpackage.C4567.InterfaceC4571
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1317() {
            HomeActivity.this.runOnUiThread(new RunnableC0168());
        }

        @Override // defpackage.C4567.InterfaceC4571
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1318(int i) {
            HomeActivity.this.runOnUiThread(new RunnableC0161(i));
        }

        @Override // defpackage.C4567.InterfaceC4571
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1319() {
            HomeActivity.this.runOnUiThread(new RunnableC0165());
        }

        @Override // defpackage.C4567.InterfaceC4571
        /* renamed from: Ԭ, reason: contains not printable characters */
        public int mo1320() {
            return HomeActivity.this.f431.mo10487();
        }

        @Override // defpackage.C4567.InterfaceC4571
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1321() {
            HomeActivity.this.runOnUiThread(new RunnableC0164());
        }

        @Override // defpackage.C4567.InterfaceC4571
        /* renamed from: Ԯ, reason: contains not printable characters */
        public void mo1322() {
            if (HomeActivity.this.f565) {
                HomeActivity.this.runOnUiThread(new RunnableC0166());
            }
        }

        @Override // defpackage.C4567.InterfaceC4571
        /* renamed from: ԯ, reason: contains not printable characters */
        public void mo1323() {
            if (HomeActivity.this.f565) {
                HomeActivity.this.runOnUiThread(new RunnableC0162());
            }
        }

        @Override // defpackage.C4567.InterfaceC4571
        /* renamed from: ՠ, reason: contains not printable characters */
        public void mo1324(boolean z, int i) {
            if (HomeActivity.this.f565) {
                HomeActivity.this.runOnUiThread(new RunnableC0167(z, i));
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ރ, reason: contains not printable characters */
    public class C0169 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ރ$Ϳ, reason: contains not printable characters */
        public class C0170 extends AbstractC4012 {
            public C0170() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13666.setVisibility(8);
            }
        }

        public C0169() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            HomeActivity.this.f430.f13666.setVisibility(8);
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            C4008.m12876(HomeActivity.this.f430.f13666, 0.0f, 100, new C0170());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ބ, reason: contains not printable characters */
    public class C0171 implements c9.InterfaceC0055 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$Ϳ, reason: contains not printable characters */
        public class RunnableC0172 implements Runnable {
            public RunnableC0172() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                HomeActivity.this.f431.mo10542(8, true);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$Ԩ, reason: contains not printable characters */
        public class RunnableC0173 implements Runnable {
            public RunnableC0173() {
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                if (HomeActivity.this.f439 == 1) {
                    int iMo10487 = HomeActivity.this.f431.mo10487();
                    if (iMo10487 == 1) {
                        HomeActivity.this.m958(true);
                        return;
                    }
                    if (iMo10487 == 2) {
                        HomeActivity.this.m992(true);
                    } else {
                        if (HomeActivity.this.f440 == 1) {
                            return;
                        }
                        if (HomeActivity.this.f565) {
                            HomeActivity.this.m1133();
                        } else {
                            HomeActivity.this.m1106();
                        }
                    }
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$Ԫ, reason: contains not printable characters */
        public class RunnableC0174 implements Runnable {
            public RunnableC0174() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                if (HomeActivity.this.f439 == 1) {
                    int iMo10487 = HomeActivity.this.f431.mo10487();
                    if (iMo10487 == 1) {
                        HomeActivity.this.m958(false);
                        return;
                    }
                    if (iMo10487 == 2) {
                        HomeActivity.this.m992(false);
                    } else {
                        if (!HomeActivity.this.f565 || C3947.m12727().m12765()) {
                            return;
                        }
                        HomeActivity.this.f431.mo10532();
                    }
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$Ԭ, reason: contains not printable characters */
        public class RunnableC0175 implements Runnable {
            public RunnableC0175() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                HomeActivity.this.f431.mo10542(1, true);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$Ԯ, reason: contains not printable characters */
        public class RunnableC0176 implements Runnable {
            public RunnableC0176() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                if (HomeActivity.this.f439 == 1) {
                    HomeActivity.this.f431.mo10542(0, true);
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ՠ, reason: contains not printable characters */
        public class RunnableC0177 implements Runnable {
            public RunnableC0177() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                HomeActivity.this.f431.mo10542(2, true);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ֈ, reason: contains not printable characters */
        public class RunnableC0178 implements Runnable {
            public RunnableC0178() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.m1090(R.string.POPUP_GIMBAL_CONNECTED);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$֏, reason: contains not printable characters */
        public class RunnableC0179 implements Runnable {
            public RunnableC0179() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.m1090(R.string.POPUP_GIMBAL_DISCONNECTED);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ׯ, reason: contains not printable characters */
        public class RunnableC0180 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f660;

            public RunnableC0180(int i) {
                this.f660 = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                HomeActivity.this.f431.mo10521(this.f660);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ؠ, reason: contains not printable characters */
        public class RunnableC0181 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ boolean f662;

            /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ؠ$Ϳ, reason: contains not printable characters */
            public class C0182 implements FocusZoomWheelView.InterfaceC1175 {

                /* renamed from: Ϳ, reason: contains not printable characters */
                public final /* synthetic */ float f664;

                public C0182(float f) {
                    this.f664 = f;
                }

                @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1175
                /* renamed from: Ϳ, reason: contains not printable characters */
                public void mo1325() {
                    HomeActivity.this.m1163(this.f664);
                }
            }

            public RunnableC0181(boolean z) {
                this.f662 = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                float f;
                int i = 1;
                if (HomeActivity.this.f439 == 1) {
                    if (!HomeActivity.this.f565) {
                        HomeActivity.this.m1032(this.f662);
                        return;
                    }
                    if (C3947.m12727().m12772()) {
                        HomeActivity.this.m1032(this.f662);
                        return;
                    }
                    if (HomeActivity.this.f431.mo10531()) {
                        return;
                    }
                    if (C3947.m12727().m12729() == 1) {
                        HomeActivity.this.f460.removeMessages(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR);
                        if (HomeActivity.this.f585 == -1 && !HomeActivity.this.f441) {
                            HomeActivity.this.f441 = true;
                            HomeActivity homeActivity = HomeActivity.this;
                            homeActivity.f589 = homeActivity.f585;
                            HomeActivity.this.f585 = 2;
                            HomeActivity homeActivity2 = HomeActivity.this;
                            homeActivity2.m1069(homeActivity2.f585);
                        }
                        HomeActivity.this.f460.sendEmptyMessageDelayed(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 200L);
                    }
                    float fM12736 = C3947.m12727().m12736();
                    if (this.f662) {
                        HomeActivity.this.f546 = 0;
                        f = fM12736 + 0.005f;
                    } else {
                        HomeActivity.this.f545 = 0;
                        f = fM12736 - 0.005f;
                    }
                    if (f > 1.0f) {
                        if (this.f662) {
                            if (f > 1.25f) {
                                return;
                            }
                            if (HomeActivity.this.f545 < 5) {
                                HomeActivity.m645(HomeActivity.this);
                                return;
                            } else {
                                HomeActivity.this.f545 = 0;
                                f = 1.25f;
                            }
                        } else if (HomeActivity.this.f546 < 5) {
                            HomeActivity.m734(HomeActivity.this);
                            return;
                        } else {
                            HomeActivity.this.f546 = 0;
                            i = 2;
                            f = 1.0f;
                        }
                    } else if (f >= 0.0f) {
                        i = -1;
                    } else if (this.f662) {
                        if (HomeActivity.this.f545 < 5) {
                            HomeActivity.m645(HomeActivity.this);
                            return;
                        } else {
                            HomeActivity.this.f545 = 0;
                            i = 4;
                            f = 0.0f;
                        }
                    } else {
                        if (f < -0.25f) {
                            return;
                        }
                        if (HomeActivity.this.f546 < 5) {
                            HomeActivity.m734(HomeActivity.this);
                            return;
                        } else {
                            HomeActivity.this.f546 = 0;
                            i = 3;
                            f = -0.25f;
                        }
                    }
                    C3947.m12727().m12785(f);
                    if (i == -1) {
                        HomeActivity.this.m1163(f);
                        return;
                    }
                    if (f > 1.0f || f < 0.0f) {
                        HomeActivity.this.m1099(f);
                    }
                    HomeActivity.this.f431.mo10507(i, new C0182(f));
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ހ, reason: contains not printable characters */
        public class RunnableC0183 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ boolean f666;

            public RunnableC0183(boolean z) {
                this.f666 = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                if (HomeActivity.this.f565) {
                    if (C3947.m12727().m12729() == 1) {
                        HomeActivity.this.f460.removeMessages(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR);
                        if (HomeActivity.this.f585 == -1 && !HomeActivity.this.f441) {
                            HomeActivity.this.f441 = true;
                            HomeActivity homeActivity = HomeActivity.this;
                            homeActivity.f589 = homeActivity.f585;
                            HomeActivity.this.f585 = 0;
                            HomeActivity homeActivity2 = HomeActivity.this;
                            homeActivity2.m1069(homeActivity2.f585);
                        }
                        HomeActivity.this.f460.sendEmptyMessageDelayed(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 500L);
                    }
                    if (HomeActivity.this.f439 == 1) {
                        if (C3947.m12727().m12765()) {
                            float fM12734 = C3947.m12727().m12734();
                            C3947.m12727().m12783(Math.min(1.0f, Math.max(0.0f, this.f666 ? fM12734 + 0.005f : fM12734 - 0.005f)));
                            HomeActivity.this.f431.mo10551();
                            if (HomeActivity.this.f439 == 1) {
                                HomeActivity.this.f437.m2012((int) C3947.m12727().m12744(), C3947.m12727().m12734());
                                return;
                            }
                            return;
                        }
                        if (C3947.m12727().m12749()) {
                            float fM12738 = C3947.m12727().m12738();
                            int iM12751 = C3947.m12727().m12751();
                            int iM12752 = C3947.m12727().m12752();
                            int i = iM12751 - iM12752;
                            float f = iM12752;
                            float f2 = i;
                            float f3 = ((fM12738 - f) * 1.0f) / f2;
                            C3947.m12727().m12787((Math.min(1.0f, Math.max(0.0f, this.f666 ? f3 + 0.005f : f3 - 0.005f)) * f2) + f);
                            HomeActivity.this.f431.mo10563();
                            HomeActivity.this.f431.mo10607(C4792.m14375().m14431());
                            HomeActivity.this.m1030();
                            HomeActivity.this.f431.mo10561();
                            if (HomeActivity.this.f439 == 1) {
                                HomeActivity.this.f437.m1973((int) fM12738, C3947.m12727().m12735());
                                return;
                            }
                            return;
                        }
                        float fM12739 = C3947.m12727().m12739();
                        List<Float> listM12740 = C3947.m12727().m12740();
                        if (r1.m8144(listM12740)) {
                            float fFloatValue = listM12740.get(0).floatValue();
                            float fFloatValue2 = listM12740.get(listM12740.size() - 1).floatValue();
                            float f4 = fFloatValue - fFloatValue2;
                            float fMo10519 = HomeActivity.this.f431.mo10519(fM12739, fFloatValue2, f4);
                            if (fMo10519 < 0.0f) {
                                fMo10519 = 0.0f;
                            } else if (fMo10519 > 1.0f) {
                                fMo10519 = 1.0f;
                            }
                            float fMin = Math.min(1.0f, Math.max(0.0f, this.f666 ? fMo10519 + 0.005f : fMo10519 - 0.005f));
                            float f5 = (f4 * fMin) + fFloatValue2;
                            int iM12471 = C4535.m13880().m13890().m12471();
                            if (iM12471 != 0) {
                                C3947.m12727().m12784(f5 / (C3947.m12727().m12760(iM12471) * 360.0f));
                            } else {
                                C3947.m12727().m12784(f5 / (C3947.m12727().m12747() * 360.0f));
                            }
                            C3947.m12727().m12788(f5);
                            HomeActivity.this.f431.mo10563();
                            HomeActivity.this.f431.mo10619(C4792.m14375().m14431());
                            HomeActivity.this.m1121();
                            HomeActivity.this.f431.mo10577();
                            HomeActivity.this.f431.mo10620(fMin);
                            if (HomeActivity.this.f439 == 1) {
                                HomeActivity.this.f437.m1973((int) C3947.m12727().m12738(), C3947.m12727().m12735());
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ށ, reason: contains not printable characters */
        public class RunnableC0184 implements Runnable {
            public RunnableC0184() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                if (HomeActivity.this.f527 || HomeActivity.this.f526) {
                    HomeActivity.this.f431.mo10542(3, false);
                } else {
                    HomeActivity.this.f431.mo10542(3, false);
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ނ, reason: contains not printable characters */
        public class RunnableC0185 implements Runnable {
            public RunnableC0185() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                if (HomeActivity.this.f565) {
                    HomeActivity.this.f431.mo10542(9, true);
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ރ, reason: contains not printable characters */
        public class RunnableC0186 implements Runnable {
            public RunnableC0186() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                HomeActivity.this.f431.mo10542(5, true);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ބ, reason: contains not printable characters */
        public class RunnableC0187 implements Runnable {
            public RunnableC0187() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                if (HomeActivity.this.f565) {
                    HomeActivity.this.f431.mo10510();
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ޅ, reason: contains not printable characters */
        public class RunnableC0188 implements Runnable {
            public RunnableC0188() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                HomeActivity.this.f431.mo10542(6, true);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ބ$ކ, reason: contains not printable characters */
        public class RunnableC0189 implements Runnable {
            public RunnableC0189() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f545 = 0;
                HomeActivity.this.f546 = 0;
                HomeActivity.this.f431.mo10542(7, true);
            }
        }

        public C0171() {
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: Ϳ */
        public void mo241() {
            HomeActivity.this.runOnUiThread(new RunnableC0186());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: Ԩ */
        public void mo242() {
            HomeActivity.this.runOnUiThread(new RunnableC0174());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ԩ */
        public void mo243(int i) {
            HomeActivity.this.runOnUiThread(new RunnableC0180(i));
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: Ԫ */
        public void mo244() {
            HomeActivity.this.runOnUiThread(new RunnableC0176());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ԫ */
        public void mo245(boolean z) {
            HomeActivity.this.runOnUiThread(new RunnableC0183(z));
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: Ԭ */
        public int mo246() {
            return HomeActivity.this.f431.mo10487();
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ԭ */
        public void mo247() {
            HomeActivity.this.runOnUiThread(new RunnableC0173());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: Ԯ */
        public void mo248() {
            HomeActivity.this.runOnUiThread(new RunnableC0188());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ԯ */
        public void mo249(boolean z) {
            HomeActivity.this.runOnUiThread(new RunnableC0181(z));
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ՠ */
        public void mo250() {
            HomeActivity.this.runOnUiThread(new RunnableC0189());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ֈ */
        public void mo251() {
            HomeActivity.this.runOnUiThread(new RunnableC0187());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ֏ */
        public void mo252() {
            HomeActivity.this.runOnUiThread(new RunnableC0185());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ׯ */
        public void mo253() {
            HomeActivity.this.runOnUiThread(new RunnableC0184());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ؠ */
        public void mo254() {
            HomeActivity.this.runOnUiThread(new RunnableC0172());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ހ */
        public void mo255() {
            HomeActivity.this.runOnUiThread(new RunnableC0175());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ށ */
        public void mo256() {
            HomeActivity.this.runOnUiThread(new RunnableC0179());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ނ */
        public void mo257() {
            HomeActivity.this.runOnUiThread(new RunnableC0178());
        }

        @Override // defpackage.c9.InterfaceC0055
        /* renamed from: ރ */
        public void mo258() {
            HomeActivity.this.runOnUiThread(new RunnableC0177());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޅ, reason: contains not printable characters */
    public class C0190 implements Handler.Callback {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޅ$Ϳ, reason: contains not printable characters */
        public class C0191 implements CameraTouchView.InterfaceC1143 {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ int f675;

            public C0191(int i) {
                this.f675 = i;
            }

            @Override // com.blink.academy.film.widgets.exposure.CameraTouchView.InterfaceC1143
            /* renamed from: Ϳ, reason: contains not printable characters */
            public void mo1326() {
                HomeActivity.this.f460.sendEmptyMessage(this.f675);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޅ$Ԩ, reason: contains not printable characters */
        public class C0192 implements CameraTouchView.InterfaceC1143 {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ int f677;

            public C0192(int i) {
                this.f677 = i;
            }

            @Override // com.blink.academy.film.widgets.exposure.CameraTouchView.InterfaceC1143
            /* renamed from: Ϳ */
            public void mo1326() {
                HomeActivity.this.f460.sendEmptyMessage(this.f677);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޅ$Ԫ, reason: contains not printable characters */
        public class C0193 implements CameraTouchView.InterfaceC1143 {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ int f679;

            public C0193(int i) {
                this.f679 = i;
            }

            @Override // com.blink.academy.film.widgets.exposure.CameraTouchView.InterfaceC1143
            /* renamed from: Ϳ */
            public void mo1326() {
                HomeActivity.this.f460.sendEmptyMessage(this.f679);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޅ$Ԭ, reason: contains not printable characters */
        public class C0194 implements n.InterfaceC2190 {

            /* renamed from: com.blink.academy.film.home.HomeActivity$ޅ$Ԭ$Ϳ, reason: contains not printable characters */
            public class RunnableC0195 implements Runnable {
                public RunnableC0195() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (HomeActivity.this.f434 != null) {
                        HomeActivity.this.f434.m12017();
                    }
                }
            }

            /* renamed from: com.blink.academy.film.home.HomeActivity$ޅ$Ԭ$Ԩ, reason: contains not printable characters */
            public class RunnableC0196 implements Runnable {
                public RunnableC0196() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (HomeActivity.this.f434 != null) {
                        HomeActivity.this.f434.m12017();
                    }
                }
            }

            public C0194() {
            }

            @Override // defpackage.n.InterfaceC2190
            public void onFail() {
                HomeActivity.this.runOnUiThread(new RunnableC0196());
            }

            @Override // defpackage.n.InterfaceC2190
            public void onSuc() {
                HomeActivity.this.runOnUiThread(new RunnableC0195());
            }
        }

        public C0190() {
        }

        /* JADX WARN: Removed duplicated region for block: B:73:0x0261  */
        @Override // android.os.Handler.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean handleMessage(@androidx.annotation.NonNull android.os.Message r20) {
            /*
                Method dump skipped, instructions count: 812
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.home.HomeActivity.C0190.handleMessage(android.os.Message):boolean");
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ކ, reason: contains not printable characters */
    public class C0197 implements ACHelper.OnCameraCallback {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ ACHelper f684;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ކ$Ϳ, reason: contains not printable characters */
        public class RunnableC0198 implements Runnable {
            public RunnableC0198() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HomeActivity.this.f434 != null) {
                    HomeActivity.this.f434.m12020(HomeActivity.this.f467, HomeActivity.this.f468);
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ކ$Ԩ, reason: contains not printable characters */
        public class RunnableC0199 implements Runnable {
            public RunnableC0199() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int wifiViewLevelByLevel;
                if (HomeActivity.this.f434 != null) {
                    NetInfoBean netInfoBean = ACHelper.getInstance().getNetInfoBean();
                    if (netInfoBean == null) {
                        netInfoBean = FinderManager.getInstance().getNetInfoBean();
                    }
                    HomeActivity.this.f434.m12019(netInfoBean);
                    String monitorSignalNetType = LinkManager.getInstance().getMonitorSignalNetType();
                    String str = !r1.m8143(monitorSignalNetType) ? "Wi-Fi" : monitorSignalNetType;
                    int i = !"Wi-Fi".equals(str) ? 1 : 0;
                    if (netInfoBean != null) {
                        int wifiLevel = netInfoBean.getWifiLevel();
                        if (HomeActivity.this.f468 && !"Wi-Fi".equals(str)) {
                            wifiLevel = ACHelper.getInstance().wifiLevel(PingHelper.getInstance().getAkamaiWifiStatus());
                        }
                        wifiViewLevelByLevel = ACHelper.getInstance().getWifiViewLevelByLevel(wifiLevel);
                    } else {
                        wifiViewLevelByLevel = 1;
                    }
                    HomeActivity.this.f434.m12012(wifiViewLevelByLevel, i, LinkManager.getInstance().isHasCloudLinkForMonitorCheck(), str, ACHelper.getInstance().getWifiViewLevelByLevel(ACHelper.getInstance().wifiLevel(PingHelper.getInstance().getProtakeWifiStatus())));
                    if ((HomeActivity.this.f431 instanceof C3295) && HomeActivity.this.f467) {
                        TransmitHelper.getInstance().setConnectionNum(HomeActivity.this.m1169());
                        TransmitHelper transmitHelper = TransmitHelper.getInstance();
                        HomeActivity homeActivity = HomeActivity.this;
                        transmitHelper.setConnectionUnit(homeActivity.m1023(homeActivity.f452));
                        TransmitHelper.getInstance().setWifiStatus(wifiViewLevelByLevel);
                        C3295 c3295 = (C3295) HomeActivity.this.f431;
                        int iM1169 = HomeActivity.this.m1169();
                        HomeActivity homeActivity2 = HomeActivity.this;
                        c3295.m11170(true, iM1169, homeActivity2.m1023(homeActivity2.f452), wifiViewLevelByLevel);
                        ACHelper.PlayerDeviceIconChangeListener playerDeviceIconChangeListener = C0197.this.f684.playerDeviceIconChangeListener;
                        if (playerDeviceIconChangeListener != null) {
                            playerDeviceIconChangeListener.onChange();
                        }
                    }
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ކ$Ԫ, reason: contains not printable characters */
        public class RunnableC0200 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ LinkEntity f688;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ boolean f689;

            public RunnableC0200(LinkEntity linkEntity, boolean z) {
                this.f688 = linkEntity;
                this.f689 = z;
            }

            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                boolean z;
                String[] bannedList = ACHelper.getInstance().getBannedList();
                if (bannedList != null && bannedList.length > 0) {
                    for (String str : bannedList) {
                        if (str.equals(e5.m5988().m5991())) {
                            return;
                        }
                    }
                }
                String[] controllableList = ACHelper.getInstance().getControllableList();
                if (controllableList == null || controllableList.length <= 0) {
                    z = false;
                } else {
                    for (String str2 : controllableList) {
                        if (str2.equals(this.f688.getAcMonitorInfoBean().getUuid())) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                }
                if (z) {
                    if (this.f689) {
                        if (HomeActivity.this.f440 != 1) {
                            HomeActivity.this.f431.mo10542(0, true);
                            HomeActivity.this.m1175(TransmitHelper.getShowHintMessage(this.f688.getAcMonitorInfoBean()) + HomeActivity.this.getResources().getString(R.string.MONITOR_LABEL_START_RECORDING));
                            return;
                        }
                        return;
                    }
                    if (HomeActivity.this.f440 == 1) {
                        HomeActivity.this.f431.mo10542(0, true);
                        HomeActivity.this.m1175(TransmitHelper.getShowHintMessage(this.f688.getAcMonitorInfoBean()) + HomeActivity.this.getResources().getString(R.string.MONITOR_LABEL_STOP_RECORDING));
                    }
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ކ$Ԭ, reason: contains not printable characters */
        public class RunnableC0201 implements Runnable {
            public RunnableC0201() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if ((HomeActivity.this.f431 instanceof C3295) && ((C3295) HomeActivity.this.f431).m11134()) {
                    HomeActivity.this.f542.mo1263();
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ކ$Ԯ, reason: contains not printable characters */
        public class RunnableC0202 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f692;

            public RunnableC0202(int i) {
                this.f692 = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f692 == 1) {
                    HomeActivity homeActivity = HomeActivity.this;
                    homeActivity.m1012(R.string.MONITOR_ERROR_OLD_VERSION_MONITOR, homeActivity.getResources().getString(R.string.GLOBAL_APP_NAME));
                } else {
                    HomeActivity homeActivity2 = HomeActivity.this;
                    homeActivity2.m1012(R.string.MONITOR_ERROR_OLD_VERSION_CAMERA, homeActivity2.getResources().getString(R.string.GLOBAL_APP_NAME));
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ކ$ՠ, reason: contains not printable characters */
        public class RunnableC0203 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ float f694;

            public RunnableC0203(float f) {
                this.f694 = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.m1163(this.f694);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ކ$ֈ, reason: contains not printable characters */
        public class RunnableC0204 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ float f696;

            public RunnableC0204(float f) {
                this.f696 = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                float fMax = Math.max(0.0f, Math.min(1.0f, this.f696));
                HomeActivity.this.f431.mo10585(fMax);
                C3947.m12727().m12789(fMax);
                HomeActivity.this.f437.m1975(0.0f, C3947.m12727().m12754(fMax));
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ކ$֏, reason: contains not printable characters */
        public class RunnableC0205 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ boolean f698;

            public RunnableC0205(boolean z) {
                this.f698 = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!HomeActivity.this.f565 || C3947.m12727().m12772() == this.f698) {
                    return;
                }
                HomeActivity.this.f431.mo10510();
            }
        }

        public C0197(ACHelper aCHelper) {
            this.f684 = aCHelper;
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void needShowHintText(int i, LinkEntity linkEntity) {
            HomeActivity.this.runOnUiThread(new RunnableC0202(i));
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void onAlbumModeClickByClient(boolean z, LinkEntity linkEntity) {
            HomeActivity.this.runOnUiThread(new RunnableC0201());
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void onBitrateScaleChange(float f) {
            if (HomeActivity.this.f543) {
                ConnectionManager.getInstance().updateBitrate((int) (f * (HomeActivity.this.f466 == HomeActivity.this.f464 ? 3000000.0f : HomeActivity.this.f466 == HomeActivity.this.f465 ? 1000000.0f : 1500000.0f)));
            }
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void onCheckRefreshRoomId() {
            if (HomeActivity.this.f578 || r1.m8143(ACHelper.getInstance().getRoomId()) || PingHelper.getInstance().getProtakeWifiStatus() <= 0) {
                return;
            }
            HomeActivity.this.m1048(false, true);
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void onFocusChange(float f) {
            if (ACHelper.getInstance().isFocusZoomWheelTouching()) {
                return;
            }
            HomeActivity.this.runOnUiThread(new RunnableC0203(f));
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void onRecordClickByClient(boolean z, LinkEntity linkEntity) {
            HomeActivity.this.f460.post(new RunnableC0200(linkEntity, z));
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void onWheelModeChange(boolean z) {
            if (ACHelper.getInstance().isFocusZoomWheelTouching()) {
                return;
            }
            HomeActivity.this.runOnUiThread(new RunnableC0205(z));
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void onZoomChange(float f) {
            if (ACHelper.getInstance().isFocusZoomWheelTouching()) {
                return;
            }
            HomeActivity.this.runOnUiThread(new RunnableC0204(f));
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void refreshMachineViews() {
            HomeActivity.this.runOnUiThread(new RunnableC0198());
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void refreshViewsLow() {
            HomeActivity.this.runOnUiThread(new RunnableC0199());
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
        public void updateLocalWifiInfo(NetInfoBean netInfoBean) {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$އ, reason: contains not printable characters */
    public class C0206 implements IDiscoveryCallBack {

        /* renamed from: com.blink.academy.film.home.HomeActivity$އ$Ϳ, reason: contains not printable characters */
        public class RunnableC0207 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ NsdServiceInfo f701;

            public RunnableC0207(NsdServiceInfo nsdServiceInfo) {
                this.f701 = nsdServiceInfo;
            }

            @Override // java.lang.Runnable
            public void run() throws NumberFormatException {
                if (HomeActivity.this.f429) {
                    C4638.m14099("slimC213", "serviceInfo:" + this.f701);
                }
                Map<String, byte[]> attributes = this.f701.getAttributes();
                Set<String> setKeySet = attributes.keySet();
                ServiceInfoBean serviceInfoBean = null;
                if (r1.m8144(setKeySet)) {
                    for (String str : setKeySet) {
                        if ("info".equals(str)) {
                            serviceInfoBean = (ServiceInfoBean) new Gson().fromJson(new String(attributes.get(str), StandardCharsets.UTF_8), ServiceInfoBean.class);
                        }
                    }
                }
                if (serviceInfoBean == null) {
                    return;
                }
                NsdServiceInfoEntity nsdServiceInfoEntity = new NsdServiceInfoEntity();
                nsdServiceInfoEntity.setNsdServiceInfo(this.f701);
                nsdServiceInfoEntity.setServiceInfoBean(serviceInfoBean);
                FinderManager.getInstance().addNsdServiceInfo(nsdServiceInfoEntity);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$އ$Ԩ, reason: contains not printable characters */
        public class RunnableC0208 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ NsdServiceInfo f703;

            public RunnableC0208(NsdServiceInfo nsdServiceInfo) {
                this.f703 = nsdServiceInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Map<String, byte[]> attributes = this.f703.getAttributes();
                Set<String> setKeySet = attributes.keySet();
                ServiceInfoBean serviceInfoBean = null;
                if (r1.m8144(setKeySet)) {
                    for (String str : setKeySet) {
                        if ("info".equals(str)) {
                            serviceInfoBean = (ServiceInfoBean) new Gson().fromJson(new String(attributes.get(str), StandardCharsets.UTF_8), ServiceInfoBean.class);
                        }
                    }
                }
                NsdServiceInfoEntity nsdServiceInfoEntity = new NsdServiceInfoEntity();
                nsdServiceInfoEntity.setNsdServiceInfo(this.f703);
                nsdServiceInfoEntity.setServiceInfoBean(serviceInfoBean);
                FinderManager.getInstance().addToLost(nsdServiceInfoEntity);
                if (HomeActivity.this.f429) {
                    C4638.m14099("slimC213", "onServiceLost");
                }
            }
        }

        public C0206() {
        }

        @Override // com.blink.academy.film.support.socket.IDiscoveryCallBack
        public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
            HomeActivity.this.runOnUiThread(new RunnableC0207(nsdServiceInfo));
        }

        @Override // com.blink.academy.film.support.socket.IDiscoveryCallBack
        public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
            if (nsdServiceInfo == null) {
                return;
            }
            HomeActivity.this.runOnUiThread(new RunnableC0208(nsdServiceInfo));
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ވ, reason: contains not printable characters */
    public class C0209 implements FinderManager.OnFinderCallback {
        public C0209() {
        }

        @Override // com.blink.academy.film.stream.FinderManager.OnFinderCallback
        public void needStopPush() {
            HomeActivity.this.m1096();
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$މ, reason: contains not printable characters */
    public class C0210 implements C3151.InterfaceC3152 {
        public C0210() {
        }

        @Override // defpackage.C3151.InterfaceC3152
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1327(Location location) {
            C3902.m12637().m12642(location);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ފ, reason: contains not printable characters */
    public class C0211 implements FinderManager.OnNSDServerCallback {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ DecoderParamsBean f707;

        public C0211(DecoderParamsBean decoderParamsBean) {
            this.f707 = decoderParamsBean;
        }

        @Override // com.blink.academy.film.stream.FinderManager.OnNSDServerCallback
        public void onStartFail() {
            HomeActivity.this.m1096();
        }

        @Override // com.blink.academy.film.stream.FinderManager.OnNSDServerCallback
        public void onStartSuc() {
            HomeActivity.this.m1038();
            ConnectionManager.getInstance().startPush(this.f707);
            if (ACHelper.getInstance().isNeedCloudPush()) {
                HomeActivity.this.m1118();
            } else {
                ACHelper.getInstance().setCloudPush(false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ދ, reason: contains not printable characters */
    public class C0212 implements n.InterfaceC2189 {
        public C0212() {
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

    /* renamed from: com.blink.academy.film.home.HomeActivity$ތ, reason: contains not printable characters */
    public class RunnableC0213 implements Runnable {
        public RunnableC0213() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!HomeActivity.this.f543) {
                if (!HomeActivity.this.f461) {
                    HomeActivity.this.m1067();
                }
                HomeActivity.this.m995(false);
            } else if (HomeActivity.this.f513) {
                HomeActivity.this.m1018(true);
            } else {
                HomeActivity.this.m1103(true);
                HomeActivity.this.m1067();
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ލ, reason: contains not printable characters */
    public class C0214 extends TypeToken<List<FilterGroupBean>> {
        public C0214() {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ގ, reason: contains not printable characters */
    public class RunnableC0215 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f712;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ގ$Ϳ, reason: contains not printable characters */
        public class RunnableC0216 implements Runnable {
            public RunnableC0216() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f430.f13664.m2043(0);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ގ$Ԩ, reason: contains not printable characters */
        public class RunnableC0217 implements Runnable {

            /* renamed from: com.blink.academy.film.home.HomeActivity$ގ$Ԩ$Ϳ, reason: contains not printable characters */
            public class RunnableC0218 implements Runnable {

                /* renamed from: com.blink.academy.film.home.HomeActivity$ގ$Ԩ$Ϳ$Ϳ, reason: contains not printable characters */
                public class RunnableC0219 implements Runnable {
                    public RunnableC0219() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        HomeActivity.this.f430.f13664.m2043(0);
                    }
                }

                public RunnableC0218() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.f430.f13664.m2043(2);
                    HomeActivity.this.f460.postDelayed(new RunnableC0219(), 100L);
                }
            }

            public RunnableC0217() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f430.f13664.m2043(0);
                HomeActivity.this.f460.postDelayed(new RunnableC0218(), 35L);
            }
        }

        public RunnableC0215(boolean z) {
            this.f712 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f712) {
                if (C3947.m12727().m12759() == 1) {
                    HomeActivity.this.f430.f13664.m2043(2);
                    HomeActivity.this.f460.postDelayed(new RunnableC0216(), 100L);
                    return;
                }
                return;
            }
            if (C3947.m12727().m12759() == 1) {
                HomeActivity.this.f430.f13664.m2043(2);
                HomeActivity.this.f460.postDelayed(new RunnableC0217(), 126L);
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޏ, reason: contains not printable characters */
    public class C0220 implements C5220.InterfaceC5225 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޏ$Ϳ, reason: contains not printable characters */
        public class RunnableC0221 implements Runnable {
            public RunnableC0221() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f553 = 0;
                if (HomeActivity.this.f429) {
                    C4638.m14099("mAudioRecordState", String.format("mAudioRecordState : %s ", Integer.valueOf(HomeActivity.this.f553)));
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޏ$Ԩ, reason: contains not printable characters */
        public class RunnableC0222 implements Runnable {
            public RunnableC0222() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f553 = 1;
                if (HomeActivity.this.f429) {
                    C4638.m14099("mAudioRecordState", String.format("mAudioRecordState : %s ", Integer.valueOf(HomeActivity.this.f553)));
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޏ$Ԫ, reason: contains not printable characters */
        public class RunnableC0223 implements Runnable {
            public RunnableC0223() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f553 = 0;
                if (HomeActivity.this.f429) {
                    C4638.m14099("mAudioRecordState", String.format("mAudioRecordState : %s ", Integer.valueOf(HomeActivity.this.f553)));
                }
            }
        }

        public C0220() {
        }

        @Override // defpackage.C5220.InterfaceC5225
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1328() {
            HomeActivity.this.f460.postDelayed(new RunnableC0223(), 300L);
        }

        @Override // defpackage.C5220.InterfaceC5225
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1329(String str) {
            HomeActivity.this.runOnUiThread(new RunnableC0221());
        }

        @Override // defpackage.C5220.InterfaceC5225
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1330() {
            HomeActivity.this.f460.postDelayed(new RunnableC0222(), 300L);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ސ, reason: contains not printable characters */
    public class C0224 extends TypeToken<List<FilterGroupBean>> {
        public C0224() {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޑ, reason: contains not printable characters */
    public class C0225 extends TypeToken<List<FilterBean>> {
        public C0225() {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޒ, reason: contains not printable characters */
    public class C0226 extends TypeToken<List<FilterGroupCollectionBean>> {
        public C0226() {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޓ, reason: contains not printable characters */
    public class C0227 implements n.InterfaceC2190 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f725;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޓ$Ϳ, reason: contains not printable characters */
        public class RunnableC0228 implements Runnable {
            public RunnableC0228() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0227 c0227 = C0227.this;
                HomeActivity.this.f430.f13676.m2595(null, c0227.f725);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޓ$Ԩ, reason: contains not printable characters */
        public class RunnableC0229 implements Runnable {
            public RunnableC0229() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0227 c0227 = C0227.this;
                HomeActivity.this.f430.f13676.m2595(null, c0227.f725);
            }
        }

        public C0227(int i) {
            this.f725 = i;
        }

        @Override // defpackage.n.InterfaceC2190
        public void onFail() {
            HomeActivity.this.runOnUiThread(new RunnableC0229());
        }

        @Override // defpackage.n.InterfaceC2190
        public void onSuc() {
            HomeActivity.this.runOnUiThread(new RunnableC0228());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޔ, reason: contains not printable characters */
    public class C0230 implements C4689.InterfaceC4697 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f729;

        public C0230(int i) {
            this.f729 = i;
        }

        @Override // defpackage.C4689.InterfaceC4697
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1331(int i) {
            HomeActivity.this.m981(i, this.f729);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޕ, reason: contains not printable characters */
    public class C0231 implements C4689.InterfaceC4697 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f731;

        public C0231(boolean z) {
            this.f731 = z;
        }

        @Override // defpackage.C4689.InterfaceC4697
        /* renamed from: Ϳ */
        public void mo1331(int i) {
            if (this.f731) {
                C4689.m14213(HomeActivity.this).m14222();
                HomeActivity.this.m1156(i == 2 ? 1 : 2);
            } else if (i == 2) {
                HomeActivity.this.m1155(2);
            } else if (i == 4) {
                HomeActivity.this.m1155(4);
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޖ, reason: contains not printable characters */
    public class C0232 implements C4689.InterfaceC4696 {
        public C0232() {
        }

        @Override // defpackage.C4689.InterfaceC4696
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1332() {
            HomeActivity.this.f430.f13676.m2594(false);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޗ, reason: contains not printable characters */
    public class C0233 implements C4757.InterfaceC4768 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f734;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ int f735;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޗ$Ϳ, reason: contains not printable characters */
        public class RunnableC0234 implements Runnable {

            /* renamed from: com.blink.academy.film.home.HomeActivity$ޗ$Ϳ$Ϳ, reason: contains not printable characters */
            public class C0235 implements n.InterfaceC2190 {
                public C0235() {
                }

                @Override // defpackage.n.InterfaceC2190
                public void onFail() {
                    if (HomeActivity.this.f434 != null) {
                        HomeActivity.this.f434.m12017();
                    }
                }

                @Override // defpackage.n.InterfaceC2190
                public void onSuc() {
                    ACHelper.getInstance().onNeedRefreshTime();
                    if (HomeActivity.this.f434 != null) {
                        HomeActivity.this.f434.m12017();
                    }
                }
            }

            public RunnableC0234() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f535 = false;
                j.m7057(C0233.this.f734);
                C3617.m11671(HomeActivity.this).m11673();
                C4689.m14213(HomeActivity.this).m14222();
                HomeActivity.this.m1082(true);
                C0233 c0233 = C0233.this;
                if (c0233.f735 == 1) {
                    if (HomeActivity.this.f434 != null) {
                        HomeActivity.this.f434.m11997();
                    }
                    n.m7588().m7594(new C0235());
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޗ$Ԩ, reason: contains not printable characters */
        public class RunnableC0236 implements Runnable {
            public RunnableC0236() {
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                HomeActivity.this.f535 = false;
                C3617.m11671(HomeActivity.this).m11673();
                C4689.m14213(HomeActivity.this).m14222();
                HomeActivity.this.m1004();
                HomeActivity.this.m1034(23);
            }
        }

        public C0233(int i, int i2) {
            this.f734 = i;
            this.f735 = i2;
        }

        @Override // defpackage.C4757.InterfaceC4768
        public void onFail() {
            HomeActivity.this.f535 = false;
            C3617.m11671(HomeActivity.this).m11673();
        }

        @Override // defpackage.C4757.InterfaceC4768
        /* renamed from: Ϳ */
        public void mo437() {
            HomeActivity.this.runOnUiThread(new RunnableC0236());
        }

        @Override // defpackage.C4757.InterfaceC4768
        /* renamed from: Ԩ */
        public void mo438() {
            HomeActivity.this.f460.post(new RunnableC0234());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޘ, reason: contains not printable characters */
    public class C0237 extends CallBack<String> {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޘ$Ϳ, reason: contains not printable characters */
        public class RunnableC0238 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ ApiException f741;

            public RunnableC0238(ApiException apiException) {
                this.f741 = apiException;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f430.f13676.m2594(false);
                if (C3703.m11871(this.f741.getCode())) {
                    C3659.m11744().m11745(1);
                }
                HomeActivity.this.m1082(true);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޘ$Ԩ, reason: contains not printable characters */
        public class RunnableC0239 implements Runnable {
            public RunnableC0239() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f430.f13676.m2594(false);
                C3659.m11744().m11745(0);
                HomeActivity.this.m1082(true);
            }
        }

        public C0237() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            HomeActivity.this.f460.post(new RunnableC0238(apiException));
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            HomeActivity.this.f460.post(new RunnableC0239());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޙ, reason: contains not printable characters */
    public class C0240 extends CallBack<String> {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޙ$Ϳ, reason: contains not printable characters */
        public class RunnableC0241 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ ApiException f745;

            public RunnableC0241(ApiException apiException) {
                this.f745 = apiException;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f430.f13676.m2594(false);
                if (C3703.m11871(this.f745.getCode())) {
                    C3659.m11744().m11745(1);
                }
                HomeActivity.this.m1082(true);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޙ$Ԩ, reason: contains not printable characters */
        public class RunnableC0242 implements Runnable {
            public RunnableC0242() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f430.f13676.m2594(false);
                C3659.m11744().m11745(0);
                HomeActivity.this.m1082(true);
            }
        }

        public C0240() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            HomeActivity.this.f460.post(new RunnableC0241(apiException));
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            HomeActivity.this.f460.post(new RunnableC0242());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޚ, reason: contains not printable characters */
    public class C0243 implements C5220.InterfaceC5224 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޚ$Ϳ, reason: contains not printable characters */
        public class RunnableC0244 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ double f749;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ double f750;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final /* synthetic */ boolean f751;

            public RunnableC0244(double d, double d2, boolean z) {
                this.f749 = d;
                this.f750 = d2;
                this.f751 = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f431.mo10617((float) this.f749, (float) this.f750, this.f751);
            }
        }

        public C0243() {
        }

        @Override // defpackage.C5220.InterfaceC5224
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1333(double d, double d2, boolean z) {
            Handler handler = HomeActivity.this.f517;
            if (handler != null) {
                handler.post(new RunnableC0244(d, d2, z));
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޛ, reason: contains not printable characters */
    public class RunnableC0245 implements Runnable {
        public RunnableC0245() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeActivity.this.f430.f13676.m2594(false);
            HomeActivity.this.m1082(true);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޜ, reason: contains not printable characters */
    public class C0246 implements C3608.InterfaceC3610 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f754;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ boolean f755;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޜ$Ϳ, reason: contains not printable characters */
        public class RunnableC0247 implements Runnable {
            public RunnableC0247() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C2618.m9572("last_net_time_sp", System.currentTimeMillis());
                C2618.m9572("last_net_error_time_sp", 0L);
                C2618.m9570("show_one_week_hint_sp", false);
                if (e5.m5988().m5993()) {
                    C0246 c0246 = C0246.this;
                    if (c0246.f754) {
                        HomeActivity.this.m1112();
                    }
                    HomeActivity.this.m1065(true);
                    return;
                }
                if (e5.m5988().m5993() != C0246.this.f755) {
                    C4151.m13162().m13168();
                }
                HomeActivity.this.m967();
                HomeActivity.this.m1112();
            }
        }

        public C0246(boolean z, boolean z2) {
            this.f754 = z;
            this.f755 = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ԫ, reason: contains not printable characters */
        public /* synthetic */ void m1335() throws JSONException {
            UserBean userBeanM5990 = e5.m5988().m5990();
            long jLongValue = C2618.m9567("last_net_error_time_sp", 0L).longValue();
            if (jLongValue == 0) {
                C2618.m9572("last_net_error_time_sp", System.currentTimeMillis());
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                if (userBeanM5990 != null) {
                    if (jCurrentTimeMillis < 604800000 || jCurrentTimeMillis >= 1209600000) {
                        if (jCurrentTimeMillis >= 1209600000) {
                            C2618.m9570("show_one_week_hint_sp", false);
                            HomeActivity.this.m1004();
                            HomeActivity.this.m1034(20);
                        }
                    } else if (!C2618.m9565("show_one_week_hint_sp", false)) {
                        C2618.m9570("show_one_week_hint_sp", true);
                        HomeActivity.this.m1173();
                    }
                } else if (jCurrentTimeMillis >= 1209600000 && e5.m5988().m5993()) {
                    C2618.m9572("last_net_error_time_sp", 0L);
                    C2618.m9570("show_one_week_hint_sp", false);
                    HomeActivity.this.m1004();
                    HomeActivity.this.m1034(20);
                }
            }
            HomeActivity.this.m1112();
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1336() {
            HomeActivity.this.runOnUiThread(new RunnableC0247());
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1337() {
            HomeActivity.this.runOnUiThread(new Runnable() { // from class: ര
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f15995.m1335();
                }
            });
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: ԩ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo1338(int r5) throws org.json.JSONException {
            /*
                r4 = this;
                e5 r0 = defpackage.e5.m5988()
                com.blink.academy.film.netbean.UserBean r0 = r0.m5990()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto Le
                r0 = r1
                goto Lf
            Le:
                r0 = r2
            Lf:
                com.blink.academy.film.home.HomeActivity r3 = com.blink.academy.film.home.HomeActivity.this
                com.blink.academy.film.home.HomeActivity.m932(r3)
                if (r5 != r1) goto L1a
                r5 = 22
            L18:
                r2 = r0
                goto L2e
            L1a:
                r1 = 3
                if (r5 != r1) goto L20
                r5 = 21
                goto L18
            L20:
                r1 = 23
                r3 = 4
                if (r5 == r3) goto L2d
                r3 = 6
                if (r5 == r3) goto L2d
                r3 = 7
                if (r5 != r3) goto L2c
                goto L2d
            L2c:
                r2 = r0
            L2d:
                r5 = r1
            L2e:
                if (r2 == 0) goto L35
                com.blink.academy.film.home.HomeActivity r0 = com.blink.academy.film.home.HomeActivity.this
                com.blink.academy.film.home.HomeActivity.m933(r0, r5)
            L35:
                com.blink.academy.film.home.HomeActivity r5 = com.blink.academy.film.home.HomeActivity.this
                com.blink.academy.film.home.HomeActivity.m934(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.home.HomeActivity.C0246.mo1338(int):void");
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޝ, reason: contains not printable characters */
    public class C0248 implements n.InterfaceC2187 {
        public C0248() {
        }

        @Override // defpackage.n.InterfaceC2187
        public void onSuccess() {
            HomeActivity.this.m1115(null);
        }

        @Override // defpackage.n.InterfaceC2187
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1339() {
            HomeActivity.this.m1115(null);
        }

        @Override // defpackage.n.InterfaceC2187
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1340() {
            HomeActivity.this.m1115(null);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޞ, reason: contains not printable characters */
    public class C0249 implements SubscribeDialog.InterfaceC0965 {
        public C0249() {
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo1341() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1342() throws Resources.NotFoundException {
            C4320.m13462(HomeActivity.this);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1343() {
            if (n.m7588().m7605() == null) {
                HomeActivity.this.f430.f13676.m2594(false);
                return;
            }
            if (C4843.m14569().m14572() && C4843.m14569().m14571()) {
                HomeActivity.this.m1124(true);
            } else {
                HomeActivity.this.m1156(C4843.m14569().m14570() != 1 ? 2 : 1);
            }
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1344() {
            if (e5.m5988().m5994()) {
                HomeActivity.this.m985();
            } else {
                if (FilmApp.m405().m430()) {
                    HomeActivity.this.m1176(1);
                    return;
                }
                HomeActivity.this.m1042(true);
                HomeActivity.this.f449 = 1;
                HomeActivity.this.f547.m11880(false);
            }
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1345() {
            boolean zM5994 = e5.m5988().m5994();
            if (zM5994) {
                if (!zM5994 || r1.m8137(n.m7588().m7605())) {
                    return;
                }
                HomeActivity.this.m1037();
                return;
            }
            if (FilmApp.m405().m430()) {
                HomeActivity.this.m1176(2);
                return;
            }
            HomeActivity.this.m1042(true);
            HomeActivity.this.f449 = 2;
            HomeActivity.this.f547.m11880(true);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo1346() {
            C4320.m13460(HomeActivity.this);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1347() {
            C4320.m13461(HomeActivity.this);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޟ, reason: contains not printable characters */
    public class C0250 implements InterfaceC4875 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SubscribeInfoCallback f760;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޟ$Ϳ, reason: contains not printable characters */
        public class RunnableC0251 implements Runnable {
            public RunnableC0251() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f430.f13676.m2594(false);
            }
        }

        public C0250(SubscribeInfoCallback subscribeInfoCallback) {
            this.f760 = subscribeInfoCallback;
        }

        @Override // defpackage.InterfaceC4875
        /* renamed from: Ϳ */
        public void mo1309(int i) {
            HomeActivity.this.f460.post(new RunnableC0251());
        }

        @Override // defpackage.InterfaceC4875
        /* renamed from: Ԩ */
        public void mo1310(Purchase purchase) {
            C2618.m9573("local_sub_pus_sp", new Gson().toJson(purchase));
            C2618.m9573("local_sub_id_sp", this.f760.getSub_gplay_id());
            C3659.m11744().m11751(0);
            HomeActivity.this.m1057();
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޠ, reason: contains not printable characters */
    public class C0252 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޠ$Ϳ, reason: contains not printable characters */
        public class C0253 extends AbstractC4012 {
            public C0253() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13675.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޠ$Ԩ, reason: contains not printable characters */
        public class C0254 extends AbstractC4012 {
            public C0254() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13675.setVisibility(8);
            }
        }

        public C0252() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            C4008.m12876(HomeActivity.this.f430.f13675, 0.0f, 100, new C0254());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) throws JSONException {
            C4008.m12876(HomeActivity.this.f430.f13675, 0.0f, 100, new C0253());
            HomeActivity.this.m1004();
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޡ, reason: contains not printable characters */
    public class C0255 implements ScoreDialog.InterfaceC1020 {
        public C0255() {
        }

        @Override // com.blink.academy.film.widgets.dialog.ScoreDialog.InterfaceC1020
        public void cancel() {
            HomeActivity.this.f431.mo10476(true);
        }

        @Override // com.blink.academy.film.widgets.dialog.ScoreDialog.InterfaceC1020
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1348(float f) throws Resources.NotFoundException {
            HomeActivity.this.f431.mo10476(true);
            C4320.m13462(HomeActivity.this);
        }

        @Override // com.blink.academy.film.widgets.dialog.ScoreDialog.InterfaceC1020
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1349(float f) {
        }

        @Override // com.blink.academy.film.widgets.dialog.ScoreDialog.InterfaceC1020
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1350() {
            HomeActivity.this.f431.mo10476(true);
        }

        @Override // com.blink.academy.film.widgets.dialog.ScoreDialog.InterfaceC1020
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1351() {
            HomeActivity.this.f431.mo10476(true);
            C4054.m12975().m12977(HomeActivity.this.getPackageName(), "com.android.vending");
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޢ, reason: contains not printable characters */
    public class C0256 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޢ$Ϳ, reason: contains not printable characters */
        public class C0257 extends AbstractC4012 {
            public C0257() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13675.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޢ$Ԩ, reason: contains not printable characters */
        public class C0258 extends AbstractC4012 {
            public C0258() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13675.setVisibility(8);
            }
        }

        public C0256() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            C4008.m12876(HomeActivity.this.f430.f13675, 0.0f, 100, new C0258());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            C4008.m12876(HomeActivity.this.f430.f13675, 0.0f, 100, new C0257());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޣ, reason: contains not printable characters */
    public class C0259 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޣ$Ϳ, reason: contains not printable characters */
        public class C0260 extends AbstractC4012 {
            public C0260() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13675.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޣ$Ԩ, reason: contains not printable characters */
        public class C0261 extends AbstractC4012 {
            public C0261() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13675.setVisibility(8);
            }
        }

        public C0259() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            C4008.m12876(HomeActivity.this.f430.f13675, 0.0f, 100, new C0261());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            C4008.m12876(HomeActivity.this.f430.f13675, 0.0f, 100, new C0260());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޤ, reason: contains not printable characters */
    public class C0262 extends CallBack<String> {
        public C0262() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޥ, reason: contains not printable characters */
    public class C0263 implements q5.InterfaceC2244 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ޥ$Ϳ, reason: contains not printable characters */
        public class RunnableC0264 implements Runnable {

            /* renamed from: com.blink.academy.film.home.HomeActivity$ޥ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC0265 implements Runnable {
                public RunnableC0265() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.f431.mo10611(true);
                }
            }

            public RunnableC0264() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - HomeActivity.this.f523 > 600) {
                    HomeActivity.this.f431.mo10611(true);
                } else {
                    HomeActivity.this.f460.postDelayed(new RunnableC0265(), 600 - (System.currentTimeMillis() - HomeActivity.this.f523));
                }
                HomeActivity.this.m1152();
            }
        }

        public C0263() {
        }

        @Override // defpackage.q5.InterfaceC2244
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1352() {
            HomeActivity.this.runOnUiThread(new RunnableC0264());
        }

        @Override // defpackage.q5.InterfaceC2244
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1353(long j) {
            if (C4535.m13880().m13890().m12424() == 1) {
                HomeActivity.this.f437.getTargetPreviewFps();
                HomeActivity.this.f437.getTargetVideoFps();
                HomeActivity.this.f431.mo10559(j);
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ޱ, reason: contains not printable characters */
    public class DialogInterfaceOnDismissListenerC0266 implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC0266() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$߾, reason: contains not printable characters */
    public class C0267 extends CallBack<UserBean> {

        /* renamed from: com.blink.academy.film.home.HomeActivity$߾$Ϳ, reason: contains not printable characters */
        public class C0268 implements n.InterfaceC2190 {

            /* renamed from: com.blink.academy.film.home.HomeActivity$߾$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC0269 implements Runnable {
                public RunnableC0269() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (HomeActivity.this.f434 != null) {
                        HomeActivity.this.f434.m12017();
                    }
                }
            }

            public C0268() {
            }

            @Override // defpackage.n.InterfaceC2190
            public void onFail() {
                if (HomeActivity.this.f434 != null) {
                    HomeActivity.this.f434.m12017();
                }
            }

            @Override // defpackage.n.InterfaceC2190
            public void onSuc() {
                HomeActivity.this.runOnUiThread(new RunnableC0269());
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$߾$Ԩ, reason: contains not printable characters */
        public class RunnableC0270 implements Runnable {
            public RunnableC0270() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SubscribeDialog subscribeDialog;
                boolean zM5993 = e5.m5988().m5993();
                if (HomeActivity.this.f449 != 2 || zM5993) {
                    if (HomeActivity.this.f449 == 3) {
                        if (HomeActivity.this.f434 != null) {
                            HomeActivity.this.f434.m12023();
                        }
                    } else if (HomeActivity.this.f449 == 4) {
                        HomeActivity.this.m980();
                        HomeActivity.this.m1114(1);
                    }
                    if (zM5993 && (subscribeDialog = HomeActivity.this.f430.f13676) != null) {
                        subscribeDialog.m2583();
                    }
                } else {
                    HomeActivity.this.m1037();
                }
                if (HomeActivity.this.f434 != null) {
                    HomeActivity.this.f434.m12013();
                }
                HomeActivity.this.m1065(zM5993);
            }
        }

        public C0267() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(UserBean userBean) {
            if (e5.m5988().m5993()) {
                HomeActivity.this.m1112();
            }
            HomeActivity.this.m1088();
            n.m7588().m7594(new C0268());
            HomeActivity.this.runOnUiThread(new RunnableC0270());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$߿, reason: contains not printable characters */
    public class C0271 implements C3703.InterfaceC3719 {
        public C0271() {
        }

        @Override // defpackage.C3703.InterfaceC3719
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1355() {
            if (C4843.m14569().m14572() && C4843.m14569().m14571()) {
                HomeActivity.this.m1124(false);
            } else if (C4843.m14569().m14570() == 1) {
                HomeActivity.this.m1155(2);
            } else if (C4843.m14569().m14570() == 2) {
                HomeActivity.this.m1155(4);
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡠ, reason: contains not printable characters */
    public class C0272 implements HeadsetReceiver.InterfaceC0123 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࡠ$Ϳ, reason: contains not printable characters */
        public class RunnableC0273 implements Runnable {
            public RunnableC0273() {
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                if (HomeActivity.this.f440 == 1) {
                    HomeActivity.this.m1120();
                    HomeActivity.this.f440 = 0;
                    HomeActivity.this.m975();
                }
                if (HomeActivity.this.f429) {
                    C4638.m14099("FilmHomeActivity", " onHeadsetDisconnected: ");
                }
                if (HomeActivity.this.f429) {
                    C4638.m14099("FilmHomeActivity", String.format("reConfigAudio : %s ", "onHeadsetDisconnected"));
                }
                HomeActivity.this.m1168(false, 1);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࡠ$Ԩ, reason: contains not printable characters */
        public class RunnableC0274 implements Runnable {
            public RunnableC0274() {
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                if (HomeActivity.this.f440 == 1) {
                    HomeActivity.this.m1120();
                    HomeActivity.this.f440 = 0;
                    HomeActivity.this.m975();
                }
                if (HomeActivity.this.f429) {
                    C4638.m14099("FilmHomeActivity", "onHeadsetDisconnected: ");
                }
                if (HomeActivity.this.f429) {
                    C4638.m14099("FilmHomeActivity", String.format("reConfigAudio : %s ", "onBlueToothHeadsetDisconnected"));
                }
                HomeActivity.this.m1168(false, 2);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࡠ$Ԫ, reason: contains not printable characters */
        public class RunnableC0275 implements Runnable {
            public RunnableC0275() {
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                if (HomeActivity.this.f440 == 1) {
                    HomeActivity.this.m1120();
                    HomeActivity.this.f440 = 0;
                    HomeActivity.this.m975();
                }
                if (HomeActivity.this.f429) {
                    C4638.m14099("MicrophoneTypeChange", "onHeadsetConnected: ");
                }
                HomeActivity.this.f564 = true;
                if (HomeActivity.this.f429) {
                    C4638.m14099("reConfigAudio", String.format("reConfigAudio : %s ", "onHeadsetConnected"));
                }
                HomeActivity.this.m1168(true, 1);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࡠ$Ԭ, reason: contains not printable characters */
        public class RunnableC0276 implements Runnable {
            public RunnableC0276() {
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                if (HomeActivity.this.f440 == 1) {
                    HomeActivity.this.m1120();
                    HomeActivity.this.f440 = 0;
                    HomeActivity.this.m975();
                }
                if (HomeActivity.this.f429) {
                    C4638.m14099("MicrophoneTypeChange", "onBlueToothHeadsetConnected: ");
                }
                HomeActivity.this.f564 = true;
                if (HomeActivity.this.f429) {
                    C4638.m14099("reConfigAudio", String.format("reConfigAudio : %s ", "onBlueToothHeadsetConnected"));
                }
                HomeActivity.this.m1168(true, 2);
            }
        }

        public C0272() {
        }

        @Override // com.blink.academy.film.home.HeadsetReceiver.InterfaceC0123
        /* renamed from: Ϳ */
        public void mo622() {
            HomeActivity.this.runOnUiThread(new RunnableC0274());
        }

        @Override // com.blink.academy.film.home.HeadsetReceiver.InterfaceC0123
        /* renamed from: Ԩ */
        public void mo623() {
            HomeActivity.this.runOnUiThread(new RunnableC0275());
        }

        @Override // com.blink.academy.film.home.HeadsetReceiver.InterfaceC0123
        /* renamed from: ԩ */
        public void mo624() {
            HomeActivity.this.runOnUiThread(new RunnableC0276());
        }

        @Override // com.blink.academy.film.home.HeadsetReceiver.InterfaceC0123
        /* renamed from: Ԫ */
        public void mo625() {
            HomeActivity.this.runOnUiThread(new RunnableC0273());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡡ, reason: contains not printable characters */
    public class C0277 implements ModeHintDialog.InterfaceC1014 {
        public C0277() {
        }

        @Override // com.blink.academy.film.widgets.cover.ModeHintDialog.InterfaceC1014
        public void onClose() {
            HomeActivity.this.f430.f13669.m2849();
            C2618.m9570("mode_hint_sp", true);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡢ, reason: contains not printable characters */
    public class RunnableC0278 implements Runnable {
        public RunnableC0278() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HomeActivity.this.f527) {
                HomeActivity.this.f431.mo10639();
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡣ, reason: contains not printable characters */
    public class RunnableC0279 implements Runnable {
        public RunnableC0279() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HomeActivity.this.f527) {
                HomeActivity.this.f431.mo10633(true, 100);
                HomeActivity.this.f431.mo10526(0, 0, 100);
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡤ, reason: contains not printable characters */
    public class RunnableC0280 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f791;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ long f792;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࡤ$Ϳ, reason: contains not printable characters */
        public class RunnableC0281 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f794;

            public RunnableC0281(int i) {
                this.f794 = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity homeActivity = HomeActivity.this;
                homeActivity.m1134(homeActivity.m988());
                HomeActivity.this.f430.f13665.setStyleText(C2462.m9035().m9062(this.f794));
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࡤ$Ԩ, reason: contains not printable characters */
        public class RunnableC0282 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f796;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ C4565 f797;

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࡤ$Ԩ$Ϳ, reason: contains not printable characters */
            public class RunnableC0283 implements Runnable {

                /* renamed from: com.blink.academy.film.home.HomeActivity$ࡤ$Ԩ$Ϳ$Ϳ, reason: contains not printable characters */
                public class RunnableC0284 implements Runnable {
                    public RunnableC0284() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C4077 c4077 = C2650.f9865;
                        if (c4077 != null) {
                            c4077.m11904();
                            C2650.f9865.m11918();
                        }
                    }
                }

                public RunnableC0283() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    float f;
                    float fExp = (float) ((Math.exp((((System.currentTimeMillis() - HomeActivity.this.f550) * 1.0f) / HomeActivity.this.f551) * (-2.544d)) * 1.054d) - 0.06807d);
                    if (fExp <= 0.017f) {
                        HomeActivity.this.f437.setCurrentFilter(RunnableC0282.this.f797);
                        HomeActivity.this.f437.m2045(0.0f, 0.0f, 1.0f, 1.0f);
                        HomeActivity.this.f552 = false;
                        C2650.m9790(new RunnableC0284());
                        return;
                    }
                    RunnableC0280 runnableC0280 = RunnableC0280.this;
                    if (runnableC0280.f791) {
                        f = 1.0f - fExp;
                    } else {
                        f = 1.0f - fExp;
                        fExp = 0.0f;
                    }
                    if (HomeActivity.this.f429) {
                        C4638.m14099("FilmHomeActivity", String.format("setFilterWidthAnimation leftSlide : %s , x : %s , w : %s , changeFilterTime : %s ", Boolean.valueOf(RunnableC0280.this.f791), Float.valueOf(fExp), Float.valueOf(f), Integer.valueOf(HomeActivity.this.f551)));
                    }
                    HomeActivity.this.f437.m2045(fExp, 0.0f, f, 1.0f);
                    HomeActivity.this.f437.postOnAnimation(this);
                }
            }

            public RunnableC0282(int i, C4565 c4565) {
                this.f796 = i;
                this.f797 = c4565;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f550 = System.currentTimeMillis();
                if (HomeActivity.this.f494) {
                    HomeActivity.this.f460.removeMessages(201);
                    if (HomeActivity.this.f495 != null) {
                        HomeActivity.this.f495.cancel();
                        HomeActivity.this.f497 = true;
                    }
                    if (HomeActivity.this.f496 != null) {
                        HomeActivity.this.f496.cancel();
                        HomeActivity.this.f498 = true;
                    }
                    HomeActivity.this.f497 = false;
                    HomeActivity.this.m982(0.0f, 1.0f, 0L);
                    HomeActivity homeActivity = HomeActivity.this;
                    homeActivity.m1140(homeActivity.f551, this.f796, HomeActivity.this.f499);
                } else {
                    HomeActivity.this.f494 = true;
                    HomeActivity.this.f497 = false;
                    HomeActivity.this.m982(0.0f, 1.0f, r0.f551);
                    HomeActivity homeActivity2 = HomeActivity.this;
                    homeActivity2.m1140(homeActivity2.f551, this.f796, HomeActivity.this.f499);
                }
                HomeActivity.this.f437.m1996(new RunnableC0283());
            }
        }

        public RunnableC0280(boolean z, long j) {
            this.f791 = z;
            this.f792 = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j;
            long jNanoTime = System.nanoTime();
            int iM957 = HomeActivity.this.m957(this.f791);
            long jNanoTime2 = System.nanoTime();
            HomeActivity homeActivity = HomeActivity.this;
            homeActivity.f475 = homeActivity.m1026(iM957);
            HomeActivity homeActivity2 = HomeActivity.this;
            homeActivity2.f480 = homeActivity2.m1143(100.0f);
            j.m7056(C2462.m9035().m9050(iM957));
            HomeActivity.this.runOnUiThread(new RunnableC0281(iM957));
            if (iM957 != C2764.m10018().m10029()) {
                C2764.m10018().m10046(iM957);
            }
            C2764.m10018().m10044(100.0f);
            long jNanoTime3 = System.nanoTime();
            C4535.m13880().m13890().m12552(100.0f);
            C4535.m13880().m13890().m12554(iM957);
            C4535.m13880().m13915();
            long jNanoTime4 = System.nanoTime();
            C4565 c4565 = new C4565(iM957);
            if (HomeActivity.this.f565) {
                HomeActivity homeActivity3 = HomeActivity.this;
                homeActivity3.m997(c4565, homeActivity3.f585);
            }
            long jNanoTime5 = System.nanoTime();
            long jNanoTime6 = System.nanoTime();
            long jNanoTime7 = System.nanoTime();
            if (this.f791) {
                j = jNanoTime6;
                HomeActivity.this.f437.m2031(1.0f, 0.0f, 0.0f, 0.0f);
            } else {
                j = jNanoTime6;
                HomeActivity.this.f437.m2031(0.0f, 0.0f, 0.0f, 0.0f);
            }
            HomeActivity.this.f437.m2000(c4565);
            if (HomeActivity.this.f429) {
                C4638.m14099("MeasureFilterTime", String.format("time t2-t1 : %s ,t3-t2 : %s , t4-t3 : %s , t5-t4 : %s ", Long.valueOf(jNanoTime - this.f792), Long.valueOf(jNanoTime2 - jNanoTime), Long.valueOf(jNanoTime3 - jNanoTime2), Long.valueOf(jNanoTime4 - jNanoTime3)));
                C4638.m14099("MeasureFilterTime", String.format("time t6-t5 : %s ,t7-t6 : %s , t8-t7 : %s ", Long.valueOf(jNanoTime5 - jNanoTime4), Long.valueOf(j - jNanoTime5), Long.valueOf(jNanoTime7 - j)));
                C4638.m14099("MeasureFilterTime", String.format("start setFilterWidthAnimation : %s ", Long.valueOf(jNanoTime7 - jNanoTime)));
            }
            HomeActivity.this.runOnUiThread(new RunnableC0282(iM957, c4565));
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡥ, reason: contains not printable characters */
    public class C0285 implements ValueAnimator.AnimatorUpdateListener {
        public C0285() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            HomeActivity.this.f430.f13665.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡦ, reason: contains not printable characters */
    public class C0286 extends AnimatorListenerAdapter {
        public C0286() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            HomeActivity.this.f497 = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (HomeActivity.this.f497) {
                return;
            }
            HomeActivity.this.f497 = false;
            HomeActivity.this.f460.sendEmptyMessageDelayed(201, 1000L);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            HomeActivity.this.f497 = false;
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡧ, reason: contains not printable characters */
    public class C0287 implements ValueAnimator.AnimatorUpdateListener {
        public C0287() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            HomeActivity.this.f430.f13665.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡨ, reason: contains not printable characters */
    public class C0288 extends AnimatorListenerAdapter {
        public C0288() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            HomeActivity.this.f498 = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!HomeActivity.this.f498) {
                HomeActivity.this.f494 = false;
            }
            HomeActivity.this.f498 = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            HomeActivity.this.f498 = false;
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡩ, reason: contains not printable characters */
    public class C0289 implements n.InterfaceC2187 {
        public C0289() {
        }

        @Override // defpackage.n.InterfaceC2187
        public void onSuccess() {
            if (C4151.m13162().m13167()) {
                HomeActivity.this.m1041();
            }
        }

        @Override // defpackage.n.InterfaceC2187
        /* renamed from: Ϳ */
        public void mo1339() {
            HomeActivity.this.m1115(null);
        }

        @Override // defpackage.n.InterfaceC2187
        /* renamed from: Ԩ */
        public void mo1340() {
            HomeActivity.this.m1115(null);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࡪ, reason: contains not printable characters */
    public class C0290 implements C4151.InterfaceC4169 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࡪ$Ϳ, reason: contains not printable characters */
        public class RunnableC0291 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ float f807;

            public RunnableC0291(float f) {
                this.f807 = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f431.mo10625((Math.round((this.f807 * 100000.0f) / 100.0f) / 10.0f) + "");
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࡪ$Ԩ, reason: contains not printable characters */
        public class RunnableC0292 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f809;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ List f810;

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࡪ$Ԩ$Ϳ, reason: contains not printable characters */
            public class RunnableC0293 implements Runnable {
                public RunnableC0293() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.f431.mo10579();
                }
            }

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࡪ$Ԩ$Ԩ, reason: contains not printable characters */
            public class RunnableC0294 implements Runnable {
                public RunnableC0294() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C4151.m13162().m13163();
                    HomeActivity.this.m1041();
                }
            }

            public RunnableC0292(int i, List list) {
                this.f809 = i;
                this.f810 = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f809 == 1) {
                    HomeActivity.this.m1115(this.f810);
                    C4151.m13162().m13169();
                    HomeActivity.this.f460.postDelayed(new RunnableC0293(), 100L);
                } else {
                    if (HomeActivity.this.f451) {
                        return;
                    }
                    if (C4151.m13162().m13186() < -1) {
                        HomeActivity.this.f460.postDelayed(new RunnableC0294(), 200L);
                    } else {
                        HomeActivity.this.f431.mo10579();
                        C4151.m13162().m13169();
                    }
                }
            }
        }

        public C0290() {
        }

        @Override // defpackage.C4151.InterfaceC4169
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1356(int i) {
            HomeActivity.this.runOnUiThread(new RunnableC0292(i, new ArrayList(C4151.m13162().m13183())));
        }

        @Override // defpackage.C4151.InterfaceC4169
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1357(float f) {
            HomeActivity.this.runOnUiThread(new RunnableC0291(f));
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢠ, reason: contains not printable characters */
    public class C0295 implements C4151.InterfaceC4169 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢠ$Ϳ, reason: contains not printable characters */
        public class RunnableC0296 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ float f815;

            public RunnableC0296(float f) {
                this.f815 = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f431.mo10598((Math.round((this.f815 * 100000.0f) / 100.0f) / 10.0f) + "");
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢠ$Ԩ, reason: contains not printable characters */
        public class RunnableC0297 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f817;

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࢠ$Ԩ$Ϳ, reason: contains not printable characters */
            public class RunnableC0298 implements Runnable {
                public RunnableC0298() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.f431.mo10579();
                }
            }

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࢠ$Ԩ$Ԩ, reason: contains not printable characters */
            public class RunnableC0299 implements Runnable {
                public RunnableC0299() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C4151.m13162().m13163();
                    HomeActivity.this.m1092();
                }
            }

            public RunnableC0297(int i) {
                this.f817 = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f817 == 1) {
                    HomeActivity.this.m1115(null);
                    C4151.m13162().m13169();
                    HomeActivity homeActivity = HomeActivity.this;
                    homeActivity.m1127(homeActivity.m1178());
                    HomeActivity.this.f460.postDelayed(new RunnableC0298(), 100L);
                    return;
                }
                if (HomeActivity.this.f450) {
                    return;
                }
                if (C4151.m13162().m13186() < -1) {
                    HomeActivity.this.f460.postDelayed(new RunnableC0299(), 200L);
                } else {
                    HomeActivity.this.f431.mo10579();
                    C4151.m13162().m13169();
                }
            }
        }

        public C0295() {
        }

        @Override // defpackage.C4151.InterfaceC4169
        /* renamed from: Ϳ */
        public void mo1356(int i) {
            HomeActivity.this.runOnUiThread(new RunnableC0297(i));
        }

        @Override // defpackage.C4151.InterfaceC4169
        /* renamed from: Ԩ */
        public void mo1357(float f) {
            HomeActivity.this.runOnUiThread(new RunnableC0296(f));
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢡ, reason: contains not printable characters */
    public class RunnableC0300 implements Runnable {
        public RunnableC0300() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeActivity.this.f431.mo10551();
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ, reason: contains not printable characters */
    public class C0301 extends CameraView.AbstractC0827 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public long f822;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$Ϳ, reason: contains not printable characters */
        public class RunnableC0302 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ AbstractC2341.C2343 f824;

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC0303 implements Runnable {
                public RunnableC0303() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.f439 = 1;
                    if (HomeActivity.this.f429) {
                        C4638.m14099("FilmHomeActivity", String.format("cameraState : %s ", Integer.valueOf(HomeActivity.this.f439)));
                    }
                }
            }

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$Ϳ$Ԩ, reason: contains not printable characters */
            public class RunnableC0304 implements Runnable {
                public RunnableC0304() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.m979();
                }
            }

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$Ϳ$Ԫ, reason: contains not printable characters */
            public class RunnableC0305 implements Runnable {
                public RunnableC0305() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.m979();
                }
            }

            public RunnableC0302(AbstractC2341.C2343 c2343) {
                this.f824 = c2343;
            }

            @Override // java.lang.Runnable
            public void run() {
                C4506 c4506M8784 = this.f824.m8784();
                d1 d1VarM8785 = this.f824.m8785();
                C3891 c3891M13890 = C4535.m13880().m13890();
                String strM12212 = c4506M8784.m12212();
                String strM11223 = C3444.m11223(C3444.m11225(strM12212));
                if (HomeActivity.this.f565) {
                    c3891M13890.m12515(strM11223);
                } else {
                    c3891M13890.m12503(strM11223);
                    if (HomeActivity.this.f485) {
                        HomeActivity.this.f485 = false;
                    } else {
                        HomeActivity.this.f431.mo10622();
                    }
                }
                C2375 c2375M13816 = c4506M8784.m13816();
                int iM8846 = c2375M13816.m8846();
                int iM8843 = c2375M13816.m8843();
                int iM12225 = c4506M8784.m12225();
                int iM12229 = c4506M8784.m12229();
                c3891M13890.m12354(iM12225);
                c3891M13890.m12395(iM12229);
                HomeActivity.this.f491 = d1VarM8785.m5896();
                int iM12231 = c4506M8784.m12231();
                if (c3891M13890.m12488() != 9) {
                    c3891M13890.m12392(iM12231);
                }
                c3891M13890.m12357(iM8843);
                c3891M13890.m12358(iM8846);
                if (HomeActivity.this.f543 && !HomeActivity.this.f544) {
                    HomeActivity.this.m1038();
                    ConnectionManager.getInstance().rePreviewEncode(HomeActivity.this.f462);
                }
                HomeActivity.this.f544 = false;
                C2949 c2949M12803 = C3952.m12801().m12803(c4506M8784.m12212());
                if (c2949M12803 == null) {
                    C2949 c2949 = new C2949();
                    c2949.m10358(System.currentTimeMillis());
                    c2949.m10357(c4506M8784.m12212());
                    c2949.m10360(iM8843);
                    c2949.m10361(iM8846);
                    C3952.m12801().m12802(c2949);
                } else {
                    if (HomeActivity.this.f429) {
                        C4638.m14099("slim", "cameraId:" + c4506M8784.m12212() + "  fps:" + c4506M8784.m12225() + "  width:" + c4506M8784.m12227());
                    }
                    c2949M12803.m10360(iM8843);
                    c2949M12803.m10361(iM8846);
                    C3952.m12801().m12804(c2949M12803);
                }
                if (HomeActivity.this.f488 == 1) {
                    HomeActivity.this.m1064();
                }
                C3947.m12727().m12780(this.f824, HomeActivity.this.f458);
                HomeActivity.this.m1068();
                if (HomeActivity.this.f592) {
                    HomeActivity.this.f592 = false;
                    HomeActivity.this.m1072();
                }
                List<String> listM12746 = C3947.m12727().m12746();
                List<Integer> listM12748 = C3947.m12727().m12748();
                List<Integer> listM13817 = c4506M8784.m13817();
                if (listM12746 != null && listM12746.size() > 0 && listM12748 != null && listM12748.size() > 0) {
                    String str = listM12746.get(listM12746.size() - 1);
                    Integer numValueOf = Integer.valueOf(C3947.m12727().m12751());
                    C4638.m14099("FilmHomeActivity", String.format("s : %s , integer : %s", str, numValueOf));
                    C4792.m14375().m14501(str, String.valueOf(numValueOf), !listM13817.contains(25) ? "30 (150×)" : "24 (12.5×)");
                    HomeActivity.this.f431.mo10562();
                }
                HomeActivity.this.f590 = d1VarM8785.m12221();
                HomeActivity.this.f591 = c4506M8784.m12223();
                C2375 c2375M138162 = c4506M8784.m13816();
                SortedSet<C2375> sortedSetM13818 = c4506M8784.m13818();
                int iM122252 = d1VarM8785.m12225();
                int iM122292 = d1VarM8785.m12229();
                d1VarM8785.m5902();
                C3444.m11227().m11268(sortedSetM13818, c2375M138162);
                Iterator<w5> it = C3444.m11227().m11247().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    w5 next = it.next();
                    if (next.isSelected()) {
                        HomeActivity.this.f431.mo10574(next.m8506().m8845());
                        break;
                    }
                }
                HomeActivity.this.f431.mo10575();
                HomeActivity.this.f460.postDelayed(new RunnableC0303(), 500L);
                C3444.m11233(strM12212);
                if (HomeActivity.this.f565) {
                    Iterator<C3828> it2 = C3444.m11230().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        C3828 next2 = it2.next();
                        if (next2.m12142()) {
                            HomeActivity.this.f431.mo10609(next2);
                            break;
                        }
                    }
                }
                HomeActivity.this.f431.mo10565();
                C3485 c3485M13807 = c4506M8784.m13807();
                c3485M13807.m11355();
                C3444.m11234(c3485M13807);
                HomeActivity.this.f431.mo10583();
                if (listM13817 == null || listM13817.size() <= 0) {
                    C3444.m11227().m11269(null, iM122252, iM122292);
                } else {
                    C3444.m11227().m11269(listM13817, iM122252, iM122292);
                }
                HomeActivity homeActivity = HomeActivity.this;
                homeActivity.f487 = homeActivity.m1105();
                HomeActivity.this.f431.mo10558();
                HomeActivity.this.m1019();
                HomeActivity.this.f431.mo10563();
                HomeActivity.this.f431.mo10564();
                if (!HomeActivity.this.f587) {
                    HomeActivity.this.f587 = true;
                    HomeActivity.this.m1153(false, 0);
                    HomeActivity.this.f431.mo10551();
                }
                if (!HomeActivity.this.f588) {
                    HomeActivity.this.f588 = true;
                    HomeActivity.this.m1054();
                }
                HomeActivity homeActivity2 = HomeActivity.this;
                if (homeActivity2.f586) {
                    homeActivity2.f586 = false;
                    homeActivity2.f460.postDelayed(new RunnableC0304(), 500L);
                } else {
                    homeActivity2.f460.postDelayed(new RunnableC0305(), 100L);
                }
                if (HomeActivity.this.f565) {
                    HomeActivity homeActivity3 = HomeActivity.this;
                    homeActivity3.m1069(homeActivity3.f585);
                } else {
                    HomeActivity.this.m1069(-1);
                }
                HomeActivity.this.m1145();
                if (C3444.m11227().m11253() != 9 || C4535.m13880().m13890().m12484() <= 30) {
                    return;
                }
                HomeActivity.this.f437.m2046(2, null);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$Ԩ, reason: contains not printable characters */
        public class RunnableC0306 implements Runnable {
            public RunnableC0306() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C2650.m9786()) {
                    return;
                }
                C2650.m9783(320, MPEGConst.SEQUENCE_ERROR_CODE);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$Ԫ, reason: contains not printable characters */
        public class RunnableC0307 implements Runnable {
            public RunnableC0307() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f439 = 0;
                if (HomeActivity.this.f429) {
                    C4638.m14099("FilmHomeActivity", String.format("cameraState : %s ", Integer.valueOf(HomeActivity.this.f439)));
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$Ԭ, reason: contains not printable characters */
        public class RunnableC0308 implements Runnable {
            public RunnableC0308() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.m964();
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$Ԯ, reason: contains not printable characters */
        public class RunnableC0309 implements Runnable {

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$Ԯ$Ϳ, reason: contains not printable characters */
            public class RunnableC0310 implements Runnable {
                public RunnableC0310() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.f431.mo10611(true);
                    HomeActivity.this.f431.mo10612(0);
                }
            }

            public RunnableC0309() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.f440 = 0;
                HomeActivity.this.f460.postDelayed(new RunnableC0310(), 100L);
                HomeActivity.this.f431.mo10591(true);
                HomeActivity.this.m1122(true);
                HomeActivity.this.m986();
                ConnectionManager.getInstance().setRecording(false);
                HomeActivity.this.m964();
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$ՠ, reason: contains not printable characters */
        public class C0311 extends AbstractRunnableC4803 {

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ AbstractC2341.C2344 f834;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0311(int i, AbstractC2341.C2344 c2344) {
                super(i);
                this.f834 = c2344;
            }

            @Override // java.lang.Runnable
            public void run() throws Throwable {
                HomeActivity.this.m1040(this.f834, true);
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢢ$ֈ, reason: contains not printable characters */
        public class RunnableC0312 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f836;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ int f837;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final /* synthetic */ int f838;

            /* renamed from: Ԯ, reason: contains not printable characters */
            public final /* synthetic */ int f839;

            /* renamed from: ԯ, reason: contains not printable characters */
            public final /* synthetic */ long f840;

            public RunnableC0312(int i, int i2, int i3, int i4, long j) {
                this.f836 = i;
                this.f837 = i2;
                this.f838 = i3;
                this.f839 = i4;
                this.f840 = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f836 != 1 && this.f837 != HomeActivity.this.f501) {
                    HomeActivity.this.f431.mo10582(this.f837 + "K");
                    HomeActivity.this.f501 = this.f837;
                }
                if (this.f836 != 1 && (this.f837 != HomeActivity.this.f502 || this.f838 != HomeActivity.this.f503)) {
                    HomeActivity.this.f431.mo10626(this.f837, this.f838);
                    HomeActivity.this.f502 = this.f837;
                    HomeActivity.this.f503 = this.f838;
                }
                if (C3947.m12727().m12765() || !HomeActivity.this.f565) {
                    C3947.m12727().m12787(this.f839);
                    float f = (this.f840 * 1.0f) / 1.0E9f;
                    C3947.m12727().m12784(f);
                    C3947.m12727().m12788(Math.min(360.0f, Math.max(0.0f, f * 360.0f * C3947.m12727().m12747())));
                    if (HomeActivity.this.f565) {
                        HomeActivity.this.m1019();
                    }
                }
            }
        }

        public C0301() {
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1358(AbstractC2341.C2343 c2343) {
            super.mo1358(c2343);
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1359() {
            super.mo1359();
            HomeActivity.this.runOnUiThread(new RunnableC0307());
        }

        @Override // defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1360(AbstractC2341.C2344 c2344) {
            C3768.m12064(new C0311(5, c2344));
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1361(AbstractC2341.C2343 c2343) {
            super.mo1361(c2343);
            C4506 c4506M8784 = c2343.m8784();
            int iM12220 = c4506M8784.m12220();
            long jM12216 = c4506M8784.m12216();
            int iM13809 = c4506M8784.m13809();
            int iM13810 = c4506M8784.m13810();
            if (iM13809 < C3444.m11227().m11250()) {
                iM13809 = C3444.m11227().m11250();
            } else if (iM13809 > C3444.m11227().m11249()) {
                iM13809 = C3444.m11227().m11249();
            }
            int i = iM13809;
            if (iM13810 < C3444.m11227().m11252()) {
                iM13810 = C3444.m11227().m11252();
            } else if (iM13810 > C3444.m11227().m11251()) {
                iM13810 = C3444.m11227().m11251();
            }
            int i2 = iM13810;
            int iM12488 = C4535.m13880().m13890().m12488();
            if (System.currentTimeMillis() - this.f822 > 66) {
                this.f822 = System.currentTimeMillis();
                HomeActivity.this.runOnUiThread(new RunnableC0312(iM12488, i, i2, iM12220, jM12216));
            }
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1362(String str) {
            super.mo1362(str);
            HomeActivity.this.runOnUiThread(new RunnableC0308());
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo1363(AbstractC2341.C2343 c2343) {
            super.mo1363(c2343);
            HomeActivity.this.runOnUiThread(new RunnableC0302(c2343));
            HomeActivity.this.f437.m2064(new RunnableC0306());
        }

        @Override // com.blink.academy.film.videotools.CameraView.InterfaceC0828
        /* renamed from: Ԯ, reason: contains not printable characters */
        public void mo1364() {
            HomeActivity.this.runOnUiThread(new RunnableC0309());
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: ԯ, reason: contains not printable characters */
        public void mo1365(AbstractC2341.C2344 c2344) throws Throwable {
            super.mo1365(c2344);
            HomeActivity.this.m1116(c2344);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢣ, reason: contains not printable characters */
    public class RunnableC0313 implements Runnable {
        public RunnableC0313() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeActivity.this.m1022();
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢤ, reason: contains not printable characters */
    public class RunnableC0314 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f843;

        public RunnableC0314(boolean z) {
            this.f843 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f843) {
                return;
            }
            HomeActivity.this.m1174();
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢥ, reason: contains not printable characters */
    public class RunnableC0315 implements Runnable {
        public RunnableC0315() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeActivity.this.f431.mo10522();
            if (C3444.m11227().m11253() == 9 && C4535.m13880().m13890().m12484() <= 30) {
                HomeActivity.this.f437.m2046(2, null);
            }
            HomeActivity.this.m1097();
            HomeActivity.this.f431.mo10591(true);
            HomeActivity.this.f440 = 0;
            if (HomeActivity.this.f512) {
                return;
            }
            HomeActivity.this.m1122(true);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢦ, reason: contains not printable characters */
    public class RunnableC0316 implements Runnable {
        public RunnableC0316() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeActivity.this.f431.mo10621("N/A", 0);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢧ, reason: contains not printable characters */
    public class RunnableC0317 implements Runnable {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢧ$Ϳ, reason: contains not printable characters */
        public class RunnableC0318 implements Runnable {
            public RunnableC0318() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC5160 abstractC5160 = HomeActivity.this.f431;
                HomeActivity homeActivity = HomeActivity.this;
                abstractC5160.mo10621(homeActivity.f529, homeActivity.f488);
            }
        }

        public RunnableC0317() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iM12462;
            int iM12463;
            if (HomeActivity.this.f488 == 0) {
                HomeActivity.this.f529 = m.m7511().m7513(104, 0);
            } else {
                try {
                    HomeActivity.this.f529 = m.m7511().m7513(103, 0);
                    C3891 c3891M13890 = C4535.m13880().m13890();
                    C2949 c2949M12803 = HomeActivity.this.f565 ? C3952.m12801().m12803(c3891M13890.m12399()) : C3952.m12801().m12803(c3891M13890.m12380());
                    if (c2949M12803 != null) {
                        iM12462 = c2949M12803.m10354();
                        iM12463 = c2949M12803.m10355();
                    } else {
                        iM12462 = c3891M13890.m12462();
                        iM12463 = c3891M13890.m12463();
                    }
                    int iM10145 = C2811.m10145(iM12463, iM12462, c3891M13890.m12482(), c3891M13890.m12484(), c3891M13890.m12478());
                    HomeActivity homeActivity = HomeActivity.this;
                    homeActivity.f529 = o4.m7681((((Float.parseFloat(homeActivity.f529) / (iM10145 + HomeActivity.this.f491)) * 1000000.0f) * 8.0f) / 60.0f);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    HomeActivity.this.f529 = "N/A";
                }
            }
            HomeActivity.this.runOnUiThread(new RunnableC0318());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢨ, reason: contains not printable characters */
    public class RunnableC0319 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC2341.C2344 f849;

        public RunnableC0319(AbstractC2341.C2344 c2344) {
            this.f849 = c2344;
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeActivity.this.f431.mo10611(true);
            if (this.f849.m8789()) {
                HomeActivity homeActivity = HomeActivity.this;
                homeActivity.f586 = true;
                homeActivity.m999();
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢩ, reason: contains not printable characters */
    public class C0320 extends AbstractC4012 {
        public C0320() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢪ, reason: contains not printable characters */
    public class C0321 implements l5 {
        public C0321() {
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
            HomeActivity.this.f448 = 0.0f;
            HomeActivity.this.f447 = 0.0f;
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            float f2 = 1.0f - f;
            HomeActivity.this.f437.setTranslationX(HomeActivity.this.f447 * f2);
            HomeActivity.this.f437.setTranslationY(HomeActivity.this.f448 * f2);
            HomeActivity.this.f431.mo10616(HomeActivity.this.f447 * f2, HomeActivity.this.f448 * f2);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢫ, reason: contains not printable characters */
    public class C0322 extends AbstractRunnableC4803 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ String f853;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC2341.C2344 f854;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ C2628 f855;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ C3621 f856;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f857;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢫ$Ϳ, reason: contains not printable characters */
        public class RunnableC0323 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ Map f859;

            public RunnableC0323(Map map) {
                this.f859 = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                j.m7055(this.f859);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0322(int i, String str, AbstractC2341.C2344 c2344, C2628 c2628, C3621 c3621, Runnable runnable) {
            super(i);
            this.f853 = str;
            this.f854 = c2344;
            this.f855 = c2628;
            this.f856 = c3621;
            this.f857 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            System.currentTimeMillis();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            C3687 c3687 = new C3687(this.f853);
            HomeActivity.this.f437.getTargetVideoFps();
            HomeActivity.this.f437.getTargetPreviewFps();
            c3687.m11830(this.f854.m8786());
            this.f855.m9658(this.f854.m8786());
            HomeActivity.this.m1117(this.f855, this.f854.m8787());
            c3687.m11831(this.f854.m8787());
            c3687.m11832();
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            C2735.m9987(this.f853, this.f855);
            if (C3180.m10799()) {
                C3180.m10808(C3180.m10800() + 1);
            }
            System.currentTimeMillis();
            if (HomeActivity.this.f429) {
                C4638.m14099("FilmHomeActivity", String.format("copyFileResult : %s , cost : %s , metadata cost : %s ", Boolean.TRUE, Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2)));
            }
            HomeActivity.this.f460.post(new RunnableC0323(j.m7051(this.f855, this.f856)));
            Runnable runnable = this.f857;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢬ, reason: contains not printable characters */
    public class RunnableC0324 implements Runnable {
        public RunnableC0324() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeActivity.this.f437.m1974(true);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢭ, reason: contains not printable characters */
    public class C0325 implements BatteryChangedReceiver.InterfaceC0793 {
        public C0325() {
        }

        @Override // com.blink.academy.film.support.receiver.BatteryChangedReceiver.InterfaceC0793
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1366() {
        }

        @Override // com.blink.academy.film.support.receiver.BatteryChangedReceiver.InterfaceC0793
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1367(int i, int i2) {
            HomeActivity.this.f474 = i + "%";
            HomeActivity.this.f431.mo10593(i);
        }

        @Override // com.blink.academy.film.support.receiver.BatteryChangedReceiver.InterfaceC0793
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1368(int i) {
        }

        @Override // com.blink.academy.film.support.receiver.BatteryChangedReceiver.InterfaceC0793
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1369(int i, String str, int i2) {
        }

        @Override // com.blink.academy.film.support.receiver.BatteryChangedReceiver.InterfaceC0793
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1370(int i) {
        }

        @Override // com.blink.academy.film.support.receiver.BatteryChangedReceiver.InterfaceC0793
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo1371() {
        }

        @Override // com.blink.academy.film.support.receiver.BatteryChangedReceiver.InterfaceC0793
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1372(int i) {
            if (i == 1) {
                HomeActivity.this.f431.mo10527(0.0f, 100);
                return;
            }
            if (i == 2) {
                HomeActivity.this.f431.mo10527(1.0f, 100);
                return;
            }
            if (i == 3) {
                HomeActivity.this.f431.mo10527(0.0f, 100);
            } else if (i == 4) {
                HomeActivity.this.f431.mo10527(0.0f, 100);
            } else {
                if (i != 5) {
                    return;
                }
                HomeActivity.this.f431.mo10527(1.0f, 100);
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢮ, reason: contains not printable characters */
    public class C0326 implements n.InterfaceC2186 {
        public C0326() {
        }

        @Override // defpackage.n.InterfaceC2186
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1373(StoreMessageBean storeMessageBean) {
            C4666 c4666M14156 = C4666.m14156();
            HomeActivity homeActivity = HomeActivity.this;
            c4666M14156.m14159(storeMessageBean, homeActivity, homeActivity.f430.f13656);
            if (!FilmApp.m405().m431(true) || HomeActivity.this.f577) {
                return;
            }
            HomeActivity.this.m1176(5);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢯ, reason: contains not printable characters */
    public class C0327 implements n.InterfaceC2190 {

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢯ$Ϳ, reason: contains not printable characters */
        public class RunnableC0328 implements Runnable {
            public RunnableC0328() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HomeActivity.this.f434 != null) {
                    HomeActivity.this.f434.m12017();
                }
            }
        }

        public C0327() {
        }

        @Override // defpackage.n.InterfaceC2190
        public void onFail() {
            if (HomeActivity.this.f434 != null) {
                HomeActivity.this.f434.m12017();
            }
        }

        @Override // defpackage.n.InterfaceC2190
        public void onSuc() {
            HomeActivity.this.runOnUiThread(new RunnableC0328());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢰ, reason: contains not printable characters */
    public class RunnableC0329 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f866;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f867;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢰ$Ϳ, reason: contains not printable characters */
        public class C0330 implements n.InterfaceC2188 {

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࢰ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC0331 implements Runnable {
                public RunnableC0331() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.f578 = false;
                    if (HomeActivity.this.f434 != null) {
                        HomeActivity.this.f434.m12002(2);
                    }
                }
            }

            /* renamed from: com.blink.academy.film.home.HomeActivity$ࢰ$Ϳ$Ԩ, reason: contains not printable characters */
            public class RunnableC0332 implements Runnable {

                /* renamed from: ԫ, reason: contains not printable characters */
                public final /* synthetic */ SRTConnectionRoomIdCallbackEntity f871;

                public RunnableC0332(SRTConnectionRoomIdCallbackEntity sRTConnectionRoomIdCallbackEntity) {
                    this.f871 = sRTConnectionRoomIdCallbackEntity;
                }

                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.f578 = false;
                    SRTConnectionRoomIdCallbackEntity sRTConnectionRoomIdCallbackEntity = this.f871;
                    if (sRTConnectionRoomIdCallbackEntity == null) {
                        if (HomeActivity.this.f434 != null) {
                            HomeActivity.this.f434.m12002(1);
                        }
                    } else {
                        String srt_room_id = sRTConnectionRoomIdCallbackEntity.getSrt_room_id();
                        if (HomeActivity.this.f434 != null) {
                            ACHelper.getInstance().setRoomId(srt_room_id);
                            HomeActivity.this.f434.m12016(srt_room_id);
                        }
                    }
                }
            }

            public C0330() {
            }

            @Override // defpackage.n.InterfaceC2188
            public void onFail() {
                HomeActivity.this.runOnUiThread(new RunnableC0331());
            }

            @Override // defpackage.n.InterfaceC2188
            /* renamed from: Ϳ, reason: contains not printable characters */
            public void mo1374(SRTConnectionRoomIdCallbackEntity sRTConnectionRoomIdCallbackEntity) {
                HomeActivity.this.runOnUiThread(new RunnableC0332(sRTConnectionRoomIdCallbackEntity));
            }
        }

        public RunnableC0329(boolean z, boolean z2) {
            this.f866 = z;
            this.f867 = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HomeActivity.this.f578) {
                return;
            }
            HomeActivity.this.f578 = true;
            if (HomeActivity.this.f434 != null) {
                HomeActivity.this.f434.m12003(this.f866);
            }
            n.m7588().m7600(this.f867, new C0330());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢱ, reason: contains not printable characters */
    public class C0333 extends TypeToken<List<FilterGroupBean>> {
        public C0333() {
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢲ, reason: contains not printable characters */
    public class RunnableC0334 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f874;

        public RunnableC0334(boolean z) {
            this.f874 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4565 filmPreviewFilter = HomeActivity.this.f437.getFilmPreviewFilter();
            if (filmPreviewFilter == null) {
                return;
            }
            if (this.f874) {
                filmPreviewFilter.m11904();
            } else {
                filmPreviewFilter.m11920();
            }
            filmPreviewFilter.m11918();
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢳ, reason: contains not printable characters */
    public class RunnableC0335 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f876;

        public RunnableC0335(boolean z) {
            this.f876 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4077 c4077 = C2650.f9865;
            if (c4077 != null) {
                if (this.f876) {
                    c4077.m11904();
                } else {
                    c4077.m11920();
                }
                C2650.f9865.m11918();
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢴ, reason: contains not printable characters */
    public class C0336 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SettingHintDialog f878;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢴ$Ϳ, reason: contains not printable characters */
        public class C0337 extends AbstractC4012 {
            public C0337() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13670.setVisibility(8);
            }
        }

        public C0336(SettingHintDialog settingHintDialog) {
            this.f878 = settingHintDialog;
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            if (FilmApp.m405().m408()) {
                C4008.m12876(this.f878, 0.0f, 100, new C0337());
            }
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            ArrayList arrayList = new ArrayList();
            switch (i) {
                case 34:
                    arrayList.add("android.permission.CAMERA");
                    break;
                case 35:
                    arrayList.add("android.permission.RECORD_AUDIO");
                    break;
                case 36:
                    if (Build.VERSION.SDK_INT < 33) {
                        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                        break;
                    } else {
                        arrayList.add("android.permission.READ_MEDIA_IMAGES");
                        arrayList.add("android.permission.READ_MEDIA_VIDEO");
                        break;
                    }
            }
            ActivityCompat.requestPermissions(HomeActivity.this, (String[]) arrayList.toArray(new String[arrayList.size()]), 101);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢶ, reason: contains not printable characters */
    public class C0338 extends AbstractC4012 {
        public C0338() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            HomeActivity.this.f430.f13670.setVisibility(0);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢷ, reason: contains not printable characters */
    public class C0339 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SettingHintDialog f882;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢷ$Ϳ, reason: contains not printable characters */
        public class C0340 extends AbstractC4012 {
            public C0340() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13670.setVisibility(8);
                HomeActivity.this.f428 = false;
            }
        }

        public C0339(SettingHintDialog settingHintDialog) {
            this.f882 = settingHintDialog;
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            if (FilmApp.m405().m426()) {
                C4008.m12876(this.f882, 0.0f, 100, new C0340());
            }
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", HomeActivity.this.getPackageName(), null));
            HomeActivity.this.startActivity(intent);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢸ, reason: contains not printable characters */
    public class C0341 extends AbstractC4012 {
        public C0341() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            HomeActivity.this.f430.f13670.setVisibility(0);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢹ, reason: contains not printable characters */
    public class C0342 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SettingHintDialog f886;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢹ$Ϳ, reason: contains not printable characters */
        public class C0343 extends AbstractC4012 {
            public C0343() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13670.setVisibility(8);
            }
        }

        public C0342(SettingHintDialog settingHintDialog) {
            this.f886 = settingHintDialog;
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            if (FilmApp.m405().m426()) {
                C4008.m12876(this.f886, 0.0f, 100, new C0343());
            }
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            ActivityCompat.requestPermissions(HomeActivity.this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 101);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢺ, reason: contains not printable characters */
    public class C0344 extends AbstractC4012 {
        public C0344() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            HomeActivity.this.f430.f13670.setVisibility(0);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢻ, reason: contains not printable characters */
    public class C0345 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SettingHintDialog f890;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢻ$Ϳ, reason: contains not printable characters */
        public class C0346 extends AbstractC4012 {
            public C0346() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                HomeActivity.this.f430.f13670.setVisibility(8);
            }
        }

        public C0345(SettingHintDialog settingHintDialog) {
            this.f890 = settingHintDialog;
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            if (FilmApp.m405().m426()) {
                C4008.m12876(this.f890, 0.0f, 100, new C0346());
            }
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            ActivityCompat.requestPermissions(HomeActivity.this, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"}, 100001);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢼ, reason: contains not printable characters */
    public class C0347 extends AbstractC4012 {
        public C0347() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            HomeActivity.this.f430.f13670.setVisibility(0);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢽ, reason: contains not printable characters */
    public class RunnableC0348 implements Runnable {
        public RunnableC0348() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeActivity.this.setRequestedOrientation(1);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢾ, reason: contains not printable characters */
    public class C0349 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SettingHintDialog f895;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ boolean f896;

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢾ$Ϳ, reason: contains not printable characters */
        public class C0350 extends AbstractC4012 {
            public C0350() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C0349.this.f895.setAlpha(0.0f);
                C0349.this.f895.setVisibility(8);
                C4638.m14101("WME", "needRefreshFps: " + C0349.this.f896);
                C0349 c0349 = C0349.this;
                if (c0349.f896) {
                    HomeActivity.this.f431.mo10550();
                }
            }
        }

        /* renamed from: com.blink.academy.film.home.HomeActivity$ࢾ$Ԩ, reason: contains not printable characters */
        public class C0351 extends AbstractC4012 {
            public C0351() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C0349.this.f895.setVisibility(8);
            }
        }

        public C0349(SettingHintDialog settingHintDialog, boolean z) {
            this.f895 = settingHintDialog;
            this.f896 = z;
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            C4008.m12876(this.f895, 0.0f, 100, new C0351());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            C4008.m12876(this.f895, 0.0f, 100, new C0350());
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࢿ, reason: contains not printable characters */
    public class RunnableC0352 implements Runnable {
        public RunnableC0352() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4565 filmPreviewFilter = HomeActivity.this.f437.getFilmPreviewFilter();
            if (filmPreviewFilter != null) {
                filmPreviewFilter.m13989(true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࣀ, reason: contains not printable characters */
    public class RunnableC0353 implements Runnable {
        public RunnableC0353() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4565 filmPreviewFilter = HomeActivity.this.f437.getFilmPreviewFilter();
            if (filmPreviewFilter != null) {
                filmPreviewFilter.m13988(true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࣁ, reason: contains not printable characters */
    public class RunnableC0354 implements Runnable {
        public RunnableC0354() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4565 filmPreviewFilter = HomeActivity.this.f437.getFilmPreviewFilter();
            if (filmPreviewFilter != null) {
                filmPreviewFilter.m13987(true);
            }
            HomeActivity.this.f431.mo10599(0);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࣂ, reason: contains not printable characters */
    public class RunnableC0355 implements Runnable {
        public RunnableC0355() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4565 filmPreviewFilter = HomeActivity.this.f437.getFilmPreviewFilter();
            if (filmPreviewFilter != null) {
                filmPreviewFilter.m13988(false);
                filmPreviewFilter.m13989(false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࣃ, reason: contains not printable characters */
    public class C0356 extends AbstractC4012 {
        public C0356() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࣄ, reason: contains not printable characters */
    public class C0357 extends AbstractC4012 {
        public C0357() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࣅ, reason: contains not printable characters */
    public class RunnableC0358 implements Runnable {
        public RunnableC0358() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            if (HomeActivity.this.f437 == null || HomeActivity.this.f439 != 1) {
                return;
            }
            if (!HomeActivity.this.f565) {
                HomeActivity.this.m1106();
                return;
            }
            C3641.m11713(null).m11726();
            String cameraID = HomeActivity.this.f437.getCameraID();
            ArrayList<C3828> arrayListM11230 = C3444.m11230();
            ArrayList arrayList = new ArrayList();
            Iterator<C3828> it = arrayListM11230.iterator();
            while (it.hasNext()) {
                C3828 next = it.next();
                if (next.m12143()) {
                    arrayList.add(next);
                }
            }
            if (r1.m8144(arrayList)) {
                int i = 0;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (((C3828) arrayList.get(i2)).m12137().equals(cameraID) && (i = i2 + 1) > arrayList.size() - 1) {
                        i = 0;
                    }
                }
                String strM12137 = ((C3828) arrayList.get(i)).m12137();
                C3891 c3891M13890 = C4535.m13880().m13890();
                HomeActivity.this.m1087(false);
                HomeActivity.this.f437.m2008(strM12137);
                HomeActivity.this.m1063(true);
                c3891M13890.m12515(C3444.m11223(arrayListM11230.get(i)));
                C4535.m13880().m13915();
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࣆ, reason: contains not printable characters */
    public class RunnableC0359 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f907;

        public RunnableC0359(boolean z) {
            this.f907 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMo10512;
            boolean z = true;
            if (HomeActivity.this.f439 == 1) {
                if (HomeActivity.this.f565) {
                    float fM12742 = C3947.m12727().m12742();
                    float fMax = Math.max(0.0f, Math.min(1.0f, this.f907 ? fM12742 + 0.005f : fM12742 - 0.005f));
                    HomeActivity.this.f431.mo10585(fMax);
                    C3947.m12727().m12789(fMax);
                    HomeActivity.this.f437.m1975(0.0f, C3947.m12727().m12754(fMax));
                    return;
                }
                if (C2520.m9312().m9319(HomeActivity.this.f430.f13664.getCameraID())) {
                    fMo10512 = HomeActivity.this.f431.mo10512(C3947.m12727().m12732());
                } else {
                    z = false;
                    fMo10512 = HomeActivity.this.f431.mo10512(C3947.m12727().m12733());
                }
                float fMo10511 = HomeActivity.this.f431.mo10511(Math.max(0.0f, Math.min(1.0f, this.f907 ? fMo10512 + 0.005f : fMo10512 - 0.005f)));
                if (z) {
                    C3947.m12727().m12781(fMo10511);
                } else {
                    C3947.m12727().m12782(fMo10511);
                }
                HomeActivity.this.f431.mo10546();
                HomeActivity.this.f431.mo10506(fMo10511, HomeActivity.this.f431.mo10530());
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ࣇ, reason: contains not printable characters */
    public class ViewOnSystemUiVisibilityChangeListenerC0360 implements View.OnSystemUiVisibilityChangeListener {
        public ViewOnSystemUiVisibilityChangeListenerC0360() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            if ((i & 2) == 0) {
                HomeActivity.this.m462();
            }
        }
    }

    /* renamed from: com.blink.academy.film.home.HomeActivity$ৼ, reason: contains not printable characters */
    public class C0361 extends BroadcastReceiver {
        public C0361() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (r1.m8143(action) && "android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                    if (intExtra == 12) {
                        c9.m219().m237();
                        return;
                    }
                    if (intExtra != 13) {
                        return;
                    }
                    if (c9.m219().m226() != null) {
                        c9.m219().m225();
                    }
                    c9.m219().m220();
                    c9.m219().m224();
                    if (C4567.m14006().m14013() != null) {
                        C4567.m14006().m14012();
                    }
                    C4567.m14006().m14009();
                    C4567.m14006().m14011();
                }
            }
        }

        public /* synthetic */ C0361(HomeActivity homeActivity, C0132 c0132) {
            this();
        }
    }

    /* renamed from: ȉ, reason: contains not printable characters */
    public static /* synthetic */ int m645(HomeActivity homeActivity) {
        int i = homeActivity.f545;
        homeActivity.f545 = i + 1;
        return i;
    }

    /* renamed from: Υ, reason: contains not printable characters */
    public static HomeActivity m700() {
        return f426;
    }

    /* renamed from: ײ, reason: contains not printable characters */
    public static /* synthetic */ int m734(HomeActivity homeActivity) {
        int i = homeActivity.f546;
        homeActivity.f546 = i + 1;
        return i;
    }

    /* renamed from: ໃ, reason: contains not printable characters */
    public static /* synthetic */ int m907(HomeActivity homeActivity) {
        int i = homeActivity.f459;
        homeActivity.f459 = i + 1;
        return i;
    }

    /* renamed from: ར, reason: contains not printable characters */
    public static /* synthetic */ float m913(HomeActivity homeActivity, float f) {
        float f2 = homeActivity.f446 + f;
        homeActivity.f446 = f2;
        return f2;
    }

    public final void initListener() {
        this.f430.f13676.setPortrait(C4792.m14375().m14498());
        this.f430.f13676.setOnSubscribeDialogListener(new C0249());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        C3744 c3744;
        if ((this.f431 instanceof C3295) && (c3744 = this.f434) != null && c3744.m12001()) {
            this.f434.m11997();
            this.f434.m11998();
        } else if (this.f440 == 1) {
            this.f431.mo10542(0, false);
        } else if (this.f430.f13668.m2873()) {
            this.f430.f13668.m2868();
            this.f431.mo10476(true);
        } else {
            C2650.m9796(null);
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f429) {
            C4638.m14099("FilmHomeActivity", String.format("HomeActivity :  %s ", "onConfigurationChanged"));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(@Nullable Bundle bundle) {
        try {
            this.f538 = new WifiReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f538, intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(ViewCompat.MEASURED_STATE_MASK));
        int iM9446 = C2579.m9446(this);
        if (!C4792.m14375().m14498() || iM9446 == 1) {
            this.f534 = false;
        } else {
            this.f534 = true;
            this.f460.postDelayed(new RunnableC0348(), 0L);
        }
        super.onCreate(bundle);
        f426 = this;
        C4425.m13657().m13659(this.f542);
        C2618.m9570("open_camera_sp", true);
        C3088.m10679().mo10680(this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC0360());
        C4792.m14375().m14466(getWindow().getDecorView(), this);
        if (this.f535) {
            return;
        }
        this.f430 = (AbstractC3954) DataBindingUtil.setContentView(this, R.layout.activity_home);
        this.f504 = (AudioManager) getSystemService("audio");
        ArrayList<C3485> arrayListM11726 = C3641.m11713(null).m11726();
        if (arrayListM11726 == null || arrayListM11726.size() == 0) {
            if (this.f429) {
                C4638.m14101("FilmHomeActivity", String.format("supportVideoCameraIds : %s ", " = null or size = 0"));
            }
            Intent launchIntentForPackage = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(67108864);
                launchIntentForPackage.addFlags(32768);
                startActivity(launchIntentForPackage);
            }
            finish();
            return;
        }
        Bitmap bitmap = C4062.f14100;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f577 = true;
            ImageView imageView = new ImageView(this);
            this.f536 = imageView;
            imageView.setImageBitmap(C4062.f14100);
            this.f430.f13674.addView(this.f536, new ConstraintLayout.LayoutParams(-1, -1));
        } else if (C2618.m9566("terms_alert_v_sp2", 0) < 1) {
            C2618.m9566("terms_alert_v_sp2", 1);
            C2618.m9570("terms_alert_sp", true);
        }
        C4628.m14086().m14088();
        C4628.m14086().m14089(this);
        BillingManager billingManager = new BillingManager(this, null);
        billingManager.supportEnable(new C0134(billingManager));
        z0.m8638(0);
        m1095();
        TransmitHelper.setHasCheckLocationPermission(C2618.m9565("permission_has_check_location", false));
        TransmitHelper.setHasCheckBluetoothPermission(C2618.m9565("permission_has_check_bluetooth", false));
        m1126();
        this.f575 = C2618.m9565(this.f579, false);
        this.f460.sendEmptyMessageDelayed(JpegConst.RST1, 30000L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        C2650.m9796(null);
        C3703 c3703 = this.f547;
        if (c3703 != null) {
            c3703.m11873();
        }
        f426 = null;
        FinderManager.getInstance().release();
        if (this.f453 != 3) {
            m1098();
        }
        try {
            unregisterReceiver(this.f538);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onDestroy();
        if (this.f429) {
            C4638.m14099("FilmHomeActivity", String.format(" home : %s ", "onDestroy"));
        }
        C4792.m14375().m14502(false);
        C4757.m14304().m14309();
        C4689.m14213(this).m14221();
        C3617.m11671(this).m11672();
        C4628.m14086().m14090();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if ((i != 25 && i != 24) || this.f439 != 1 || C3947.m12727().m12761() != 1) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.f430.f13669.getVisibility() != 0 && keyEvent.getAction() == 0 && this.f593) {
            this.f593 = false;
            this.f431.mo10542(0, false);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if ((i != 25 && i != 24) || this.f439 != 1) {
            return super.onKeyUp(i, keyEvent);
        }
        if (!this.f593) {
            this.f593 = true;
        }
        return true;
    }

    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.f429) {
            C4638.m14099("FilmAudioRecord", String.format("HomeActivity :  %s ", "start onPause"));
        }
        if (this.f467 || this.f468) {
            int i = this.f453;
            if (i != 2 && i != 1) {
                stopNSDFinder();
                if (this.f467) {
                    m1018(false);
                }
                m1067();
                ConnectionManager.getInstance().releaseSrt();
                if (this.f468) {
                    LinkManager.getInstance().release();
                    m1089(false);
                }
                if (this.f453 == 3) {
                    this.f467 = false;
                    TransmitHelper.getInstance().setStartCameraTransmit(this.f467);
                    this.f543 = false;
                    this.f468 = false;
                    this.f461 = false;
                }
            } else if (i == 2) {
                this.f437.mo1967();
                this.f437.setVisibility(4);
            }
        } else {
            if (this.f461) {
                m1067();
            }
            this.f437.mo1967();
            this.f437.setVisibility(4);
        }
        if (C4112.m13054()) {
            C3151.m10755(FilmApp.m402(), false).m10759();
        }
        if (C2650.m9786()) {
            C2650.m9791(null);
        }
        m1122(true);
        WeakHandler weakHandler = this.f460;
        if (weakHandler != null) {
            weakHandler.removeMessages(101);
        }
        try {
            if (this.f473) {
                this.f574.m621(null);
                unregisterReceiver(this.f574);
            }
            if (this.f473) {
                m1005();
                this.f473 = false;
            }
            if (this.f573) {
                m984();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        m1120();
        try {
            this.f517 = null;
            this.f516.quit();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            this.f519 = null;
            this.f518.quit();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (this.f429) {
            C4638.m14099("FilmAudioRecord", String.format("HomeActivity :  %s ", "before super.onPause"));
        }
        this.f431.mo10505();
        if (C4041.m12959()) {
            C4041.m12962(null);
        }
        super.onPause();
        if (this.f429) {
            C4638.m14099("FilmAudioRecord", String.format("HomeActivity :  %s ", "onPause"));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) throws JSONException {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 101) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (iArr[i2] == -1) {
                    this.f584++;
                    if (strArr[i2].equals("android.permission.CAMERA")) {
                        this.f583 = 8;
                    } else if (strArr[i2].equals("android.permission.RECORD_AUDIO")) {
                        this.f583 = 9;
                    } else if (strArr[i2].equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        this.f583 = 10;
                    }
                    this.f584 = 0;
                    return;
                }
            }
            if (this.f584 == 0) {
                this.f473 = true;
                m976();
            }
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (this.f429) {
            C4638.m14099("FilmHomeActivity", String.format("HomeActivity :  %s ", "onRestart"));
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (this.f429) {
            C4638.m14099("FilmHomeActivity", String.format("HomeActivity :  %s ", "onRestoreInstanceState"));
        }
    }

    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws JSONException {
        super.onResume();
        C4638.m14101("WME", "onResume");
        this.f576 = false;
        if (this.f534) {
            return;
        }
        ACHelper.getInstance().setCameraIsAlbumMode(false);
        ?? r2 = z0.m8637() == 1 ? 1 : 0;
        this.f484 = r2;
        z0.m8636(this, r2);
        AbstractC5160 abstractC5160 = this.f431;
        if (abstractC5160 instanceof C3295) {
            ((C3295) abstractC5160).m11165(this.f484);
        }
        int iM9446 = C2579.m9446(this);
        if (C4792.m14375().m14498()) {
            if (iM9446 != 1) {
                setRequestedOrientation(1);
                this.f473 = false;
                this.f541 = false;
                return;
            }
        } else if (iM9446 != 0) {
            setRequestedOrientation(0);
            this.f473 = false;
            this.f541 = false;
            return;
        }
        if (!this.f573) {
            m1080();
        }
        if (C4112.m13057()) {
            HandlerThread handlerThread = new HandlerThread("HomeStorageBack");
            this.f518 = handlerThread;
            handlerThread.setPriority(1);
            this.f518.start();
            this.f519 = new Handler(this.f518.getLooper());
            WeakHandler weakHandler = this.f460;
            if (weakHandler != null) {
                weakHandler.sendEmptyMessage(101);
            }
        } else {
            m1064();
        }
        SettingHintDialog settingHintDialog = this.f430.f13670;
        if (settingHintDialog != null) {
            settingHintDialog.setAlpha(0.0f);
            this.f428 = false;
            this.f430.f13670.setVisibility(8);
        }
        C4092.f14229 = C4092.m13042(this);
        if (this.f431.mo10470() && !this.f565) {
            this.f431.mo10502();
            m1071();
        }
        if (m1061(true)) {
            this.f473 = true;
            m976();
        }
        m1157();
        this.f431.mo10611(true);
        if (this.f429) {
            C4638.m14099("FilmAudioRecord", String.format("HomeActivity :  %s ", "onResume"));
        }
        m1172();
        m1180();
        SecondScreenPresenter secondScreenPresenter = this.f537;
        if (secondScreenPresenter != null) {
            secondScreenPresenter.refreshViewOnFrameRatioChange(this.f525, this.f482);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f429) {
            C4638.m14099("FilmHomeActivity", String.format("HomeActivity :  %s ", "onSaveInstanceState"));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        m462();
        if (this.f429) {
            C4638.m14099("FilmHomeActivity", String.format("HomeActivity :  %s ", "onStart"));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (this.f429) {
            C4638.m14099("FilmAudioRecord", String.format("HomeActivity :  %s ", "before onStop"));
        }
        super.onStop();
        if (this.f453 == 0) {
            m1098();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            m462();
            if (this.f541) {
                this.f460.postDelayed(new RunnableC0138(), 400L);
            }
        }
    }

    public final void startNSDFinder() {
        FinderManager.getInstance().startNSDFinder(this, new C0206(), new C0209());
    }

    public final void stopNSDFinder() {
        FinderManager.getInstance().stopNSDFinder();
    }

    public final void stopNSDServer() {
        FinderManager.getInstance().releaseServer();
    }

    /* renamed from: ć, reason: contains not printable characters */
    public final void m952(boolean z) {
        if (z) {
            int i = this.f585;
            if (i != -1) {
                this.f589 = -2;
                return;
            }
            this.f589 = i;
            this.f585 = 0;
            m1069(0);
            return;
        }
        int i2 = this.f589;
        if (i2 == -2) {
            this.f589 = -1;
            return;
        }
        this.f585 = i2;
        this.f589 = -1;
        m1069(i2);
    }

    /* renamed from: ċ, reason: contains not printable characters */
    public final void m953(boolean z) {
        this.f431.mo10636(z);
    }

    /* renamed from: Į, reason: contains not printable characters */
    public final void m954() {
        m1063(false);
    }

    /* renamed from: į, reason: contains not printable characters */
    public final boolean m955() {
        ArrayList arrayList = new ArrayList();
        if (!C4112.m13056()) {
            arrayList.add("android.permission.CAMERA");
            this.f583 = 8;
            if (!this.f428) {
                m1000(8);
            }
            return false;
        }
        if (C4112.m13057()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            arrayList.add("android.permission.READ_MEDIA_IMAGES");
            arrayList.add("android.permission.READ_MEDIA_VIDEO");
        } else {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        this.f583 = 10;
        if (!this.f428) {
            m1000(10);
        }
        return false;
    }

    /* renamed from: Ĵ, reason: contains not printable characters */
    public final void m956(int i) {
        SettingHintDialog settingHintDialog = this.f430.f13660;
        settingHintDialog.m2906(i);
        settingHintDialog.setOnButtonClick(new C0141(settingHintDialog));
        settingHintDialog.setAlpha(0.0f);
        settingHintDialog.m2908(i, null);
        C4008.m12876(settingHintDialog, 1.0f, 100, null);
    }

    /* renamed from: ĵ, reason: contains not printable characters */
    public final int m957(boolean z) {
        int iMo10515 = this.f431.mo10515();
        ArrayList<h0> arrayListM11244 = C3444.m11227().m11244();
        if (r1.m8139(arrayListM11244)) {
            return 0;
        }
        this.f499 = arrayListM11244.get(iMo10515).m6136();
        int iM1008 = m1008(z, iMo10515, arrayListM11244, 0);
        this.f431.mo10597(iM1008);
        return arrayListM11244.get(iM1008).m6136();
    }

    /* renamed from: ļ, reason: contains not printable characters */
    public final void m958(boolean z) {
        this.f431.mo10477(z);
    }

    /* renamed from: ŗ, reason: contains not printable characters */
    public void m959() {
        SettingHintDialog settingHintDialog = this.f430.f13670;
        settingHintDialog.m2906(38);
        settingHintDialog.setOnButtonClick(new C0345(settingHintDialog));
        settingHintDialog.setAlpha(0.0f);
        settingHintDialog.m2908(38, null);
        C4008.m12876(settingHintDialog, 1.0f, 100, new C0347());
    }

    /* renamed from: Ť, reason: contains not printable characters */
    public final void m960() {
        c9.m219().m232(new C0171());
    }

    /* renamed from: ť, reason: contains not printable characters */
    public final boolean m961(float f) {
        return Math.round(f) != 0;
    }

    /* renamed from: Ŧ, reason: contains not printable characters */
    public final void m962(boolean z, int i) {
        float fM12734 = C3947.m12727().m12734();
        C3947.m12727().m12783(Math.min(1.0f, Math.max(0.0f, z ? (C4567.f15620 * i) + fM12734 : fM12734 - (C4567.f15620 * i))));
        this.f431.mo10552(fM12734);
        if (this.f439 == 1) {
            this.f437.m2012((int) C3947.m12727().m12744(), C3947.m12727().m12734());
        }
    }

    /* renamed from: ŧ, reason: contains not printable characters */
    public final void m963() {
        C3703 c3703 = new C3703(this, new DialogInterfaceOnDismissListenerC0266(), new C0267(), C4792.m14375().m14498(), false, new C0271());
        this.f547 = c3703;
        c3703.m11877();
    }

    /* renamed from: Ŷ, reason: contains not printable characters */
    public final void m964() {
        if (C2650.m9786()) {
            C2650.m9791(null);
        }
        this.f437.m1976();
        this.f439 = 0;
        if (this.f429) {
            C4638.m14099("FilmHomeActivity", String.format("cameraState : %s ", 0));
        }
        this.f586 = true;
        C4008.m12878(this.f430.f13657, 100, new C0320());
        m1111();
    }

    /* renamed from: Ÿ, reason: contains not printable characters */
    public final boolean m965(int i) {
        if (i == 2) {
            return true;
        }
        return i == 9 && this.f440 == 0;
    }

    /* renamed from: Ɩ, reason: contains not printable characters */
    public final void m966(boolean z, int i) {
        char c;
        this.f460.removeMessages(JpegConst.RST0);
        if (C3947.m12727().m12729() == 1) {
            this.f460.removeMessages(MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD);
            int i2 = this.f585;
            if (i2 == -1 && !this.f442) {
                this.f442 = true;
                this.f589 = i2;
                this.f585 = 2;
                m1069(2);
            }
            this.f460.sendEmptyMessageDelayed(MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, 2000L);
        }
        float fM12736 = C3947.m12727().m12736();
        float f = z ? (C4567.f15620 * i) + fM12736 : fM12736 - (C4567.f15620 * i);
        float fMo10514 = this.f431.mo10514();
        if (f > 1.0f) {
            if (z) {
                if (f > 1.25f) {
                    return;
                }
                if (fMo10514 < 90.0f) {
                    this.f431.mo10473(8.0f, 90.0f);
                    this.f460.sendEmptyMessageDelayed(JpegConst.RST0, 200L);
                    return;
                } else {
                    this.f460.removeMessages(JpegConst.RST0);
                    f = 1.25f;
                    c = 1;
                }
            } else if (fMo10514 > 60.0f) {
                this.f431.mo10473(-8.0f, 60.0f);
                this.f460.sendEmptyMessageDelayed(JpegConst.RST0, 200L);
                return;
            } else {
                f = 1.0f;
                c = 2;
            }
        } else if (f >= 0.0f) {
            c = 65535;
        } else if (z) {
            if (fMo10514 < -60.0f) {
                this.f431.mo10473(8.0f, -60.0f);
                this.f460.sendEmptyMessageDelayed(JpegConst.RST0, 200L);
                return;
            } else {
                c = 4;
                f = 0.0f;
            }
        } else {
            if (f < -0.25f) {
                return;
            }
            if (fMo10514 > -90.0f) {
                this.f431.mo10473(-8.0f, -90.0f);
                this.f460.sendEmptyMessageDelayed(JpegConst.RST0, 200L);
                return;
            } else {
                c = 3;
                f = -0.25f;
            }
        }
        C3947.m12727().m12785(f);
        if (c == 65535) {
            m1039(f, fM12736);
            return;
        }
        if (f > 1.0f || f < 0.0f) {
            m1099(f);
        }
        m1163(f);
    }

    /* renamed from: Ɨ, reason: contains not printable characters */
    public void m967() {
        if (C4136.m13108().m13113(this.f431.mo10515())) {
            m1123();
        }
        m1044();
        m1024(false);
    }

    /* renamed from: ƚ, reason: contains not printable characters */
    public final boolean m968() {
        return !(C4535.m13880().m13890().m12460() == 1 || this.f440 == 1);
    }

    /* renamed from: ƨ, reason: contains not printable characters */
    public final void m969() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890.m12437() == 1 && C4112.m13054()) {
            C3151.m10755(this, false).m10758();
        }
        this.f572 = this.f474;
        m991(false);
        if (c3891M13890.m12488() == 9) {
            this.f431.mo10485(false);
        }
        if (this.f565 && !C2618.m9565("location__bool_info_sp", false)) {
            C2618.m9570("location__bool_res_sp", true);
            return;
        }
        j.m7068();
        if (C3444.m11227().m11253() == 9) {
            this.f437.m2046(3, new RunnableC0324());
        } else {
            this.f437.m1974(true);
        }
        ConnectionManager.getInstance().setRecording(true);
    }

    /* renamed from: Ƭ, reason: contains not printable characters */
    public final void m970() {
        this.f431.mo10576();
    }

    /* renamed from: ƭ, reason: contains not printable characters */
    public final void m971() {
        try {
            AudioManager audioManager = this.f504;
            if (audioManager != null) {
                audioManager.adjustStreamVolume(3, -100, 0);
            }
        } catch (Exception e2) {
            C4638.m14101("closeSound", "closeSound error " + e2.getMessage());
        }
    }

    /* renamed from: Ƴ, reason: contains not printable characters */
    public final void m972() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        List<Fragment> fragments = supportFragmentManager.getFragments();
        if (r1.m8144(fragments)) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof C2970) {
                    supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                }
            }
        }
        C2970 c2970 = this.f433;
        if (c2970 != null) {
            c2970.m10610();
            this.f433 = null;
        }
    }

    /* renamed from: ƽ, reason: contains not printable characters */
    public final void m973(AbstractC2341.C2344 c2344) {
        runOnUiThread(new RunnableC0319(c2344));
    }

    /* renamed from: ǀ, reason: contains not printable characters */
    public final boolean m974() {
        return (this.f505 == 0.0f && this.f506 == 0.0f && this.f507 == 0.0f && this.f508 == 0.0f && this.f510 == 0.0f && this.f509 == 0.0f && this.f511 == 0.0f) ? false : true;
    }

    /* renamed from: ǰ, reason: contains not printable characters */
    public final void m975() {
        m1139(false, null);
        m1006(false);
        m1122(false);
    }

    /* renamed from: ț, reason: contains not printable characters */
    public final void m976() throws JSONException {
        if (this.f541) {
            if (this.f427) {
                this.f427 = false;
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, o3.m7669().m7671()).hide(o3.m7669().m7671()).commitAllowingStateLoss();
            }
            m1013(true, true);
            m989();
            m1093();
            m1145();
            m1085();
            if ((!this.f468 && !this.f513) || this.f467) {
                this.f437.mo1968();
                this.f437.setVisibility(0);
            }
            if (this.f467) {
                if (this.f431 instanceof C3295) {
                    this.f432.m11170(TransmitHelper.getInstance().isStartCameraTransmit(), TransmitHelper.getInstance().getConnectionNum(), TransmitHelper.getInstance().getSelectUnitString(TransmitHelper.getInstance().getConnectionUnitType()), TransmitHelper.getInstance().getWifiStatus());
                }
                int i = this.f453;
                if (i != 2 && i != 1 && i != 3) {
                    m1125(true, true);
                    m1109(this.f462);
                    m995(true);
                }
            } else if (this.f461) {
                m1125(true, true);
            }
            if (this.f468) {
                int i2 = this.f453;
                if (i2 != 2 && i2 != 1 && i2 != 3) {
                    m1125(true, true);
                    m1089(true);
                }
            } else if (this.f461) {
                m1125(true, true);
            }
            this.f453 = 0;
            m1052();
            C3617.m11670();
            m987(C3444.m11227().m11242());
            HandlerThread handlerThread = new HandlerThread("HomeBack");
            this.f516 = handlerThread;
            handlerThread.setPriority(1);
            this.f516.start();
            this.f517 = new Handler(this.f516.getLooper());
            IntentFilter intentFilter = new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
            this.f574.m621(this.f549);
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
            registerReceiver(this.f574, intentFilter);
            m1088();
            m1097();
        }
    }

    /* renamed from: Ȝ, reason: contains not printable characters */
    public final void m977(boolean z) {
        this.f431.mo10548(z);
    }

    /* renamed from: Ȳ, reason: contains not printable characters */
    public final void m978(int i, boolean z) {
        SettingHintDialog settingHintDialog = this.f430.f13661;
        settingHintDialog.m2906(i);
        settingHintDialog.setOnButtonClick(new C0349(settingHintDialog, z));
        settingHintDialog.setAlpha(0.0f);
        settingHintDialog.m2908(i, null);
        C4008.m12876(settingHintDialog, 1.0f, 100, null);
    }

    /* renamed from: ȷ, reason: contains not printable characters */
    public final void m979() {
        C4008.m12879(this.f430.f13657, 100, new C0357());
    }

    /* renamed from: Ɂ, reason: contains not printable characters */
    public final void m980() {
        List<Purchase> listM13592 = C4400.m13591().m13592();
        if (!r1.m8144(listM13592)) {
            C4757.m14304().m14320(this, false, new C0150());
            return;
        }
        C4638.m14104("bozai", "本地有待消费的订单   " + listM13592);
        C4757.m14304().m14306(this, listM13592, new C0148());
    }

    /* renamed from: ɂ, reason: contains not printable characters */
    public final void m981(int i, int i2) {
        String product_id;
        String google_id;
        String sub_hms_id;
        String str;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String access_token = "";
        if (i2 == -1) {
            SubscribeInfoCallback subscribeInfoCallbackM7605 = n.m7588().m7605();
            if (!r1.m8142(subscribeInfoCallbackM7605)) {
                return;
            }
            String subscription_product_id = subscribeInfoCallbackM7605.getSubscription_product_id();
            String sub_gplay_id = subscribeInfoCallbackM7605.getSub_gplay_id();
            sub_hms_id = subscribeInfoCallbackM7605.getSub_hms_id();
            product_id = subscription_product_id;
            google_id = sub_gplay_id;
        } else if (i2 != 1) {
            product_id = "";
            google_id = product_id;
            sub_hms_id = google_id;
        } else {
            if (!r1.m8142(this.f514)) {
                return;
            }
            product_id = this.f514.getProduct_id();
            google_id = this.f514.getGoogle_id();
            sub_hms_id = "";
        }
        boolean z = i2 == -1;
        if (r1.m8142(userBeanM5990)) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else if (i != 2 && i != 4) {
            return;
        } else {
            str = "";
        }
        this.f535 = true;
        C3617.m11671(this).m11675();
        C0233 c0233 = new C0233(i, i2);
        if (i == 1 || i == 3) {
            PayAdapterActivity.m436(this, i, str, access_token, product_id, google_id, sub_hms_id, z, c0233);
        } else {
            C4757.m14304().m14316(this, i, str, access_token, product_id, google_id, sub_hms_id, z, c0233);
        }
    }

    /* renamed from: ɉ, reason: contains not printable characters */
    public final void m982(float f, float f2, long j) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.f495 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(j);
        this.f495.setInterpolator(C4008.m12881());
        this.f495.addUpdateListener(new C0285());
        this.f495.addListener(new C0286());
        this.f495.start();
    }

    /* renamed from: ɍ, reason: contains not printable characters */
    public final void m983() {
    }

    /* renamed from: ɛ, reason: contains not printable characters */
    public final void m984() {
        unregisterReceiver(this.f531);
        this.f573 = false;
    }

    /* renamed from: ɜ, reason: contains not printable characters */
    public final void m985() {
        this.f430.f13675.setVisibility(0);
        this.f430.f13675.setAlpha(0.0f);
        this.f430.f13675.m2908(18, null);
        this.f430.f13675.setOnButtonClick(new C0252());
        C4008.m12876(this.f430.f13675, 1.0f, 100, null);
    }

    /* renamed from: ɫ, reason: contains not printable characters */
    public final void m986() {
        if (m965(C4535.m13880().m13890().m12488())) {
            this.f431.mo10485(true);
        }
    }

    /* renamed from: ɬ, reason: contains not printable characters */
    public void m987(int i) {
        this.f431.mo10589(i);
    }

    /* renamed from: ɹ, reason: contains not printable characters */
    public final boolean m988() {
        if (C4535.m13880().m13890().m12460() == 1) {
            return false;
        }
        return this.f475 || this.f480 || this.f476 || this.f477 || this.f478 || this.f479;
    }

    /* renamed from: ɺ, reason: contains not printable characters */
    public final void m989() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        m1091();
        this.f431.mo10528();
        m1045(c3891M13890.m12427() == 1);
        SecondScreenPresenter secondScreenPresenter = this.f537;
        if (secondScreenPresenter != null) {
            secondScreenPresenter.refreshViewOnFrameRatioChange(this.f525, this.f482);
        }
    }

    /* renamed from: ɼ, reason: contains not printable characters */
    public void m990() {
        this.f431.mo10600();
    }

    /* renamed from: ʇ, reason: contains not printable characters */
    public final void m991(boolean z) {
        this.f431.mo10596(z);
        if ((z ? 1.0f : 0.3f) == 1.0f) {
            m1097();
        }
    }

    /* renamed from: ʏ, reason: contains not printable characters */
    public final void m992(boolean z) {
        this.f431.mo10474(z);
    }

    /* renamed from: ʖ, reason: contains not printable characters */
    public final void m993(int i) {
        this.f469 = i;
        if (e5.m5988().m5993()) {
            return;
        }
        if (r1.m8142(n.m7588().m7605())) {
            this.f430.f13676.m2595(null, i);
        } else {
            n.m7588().m7604(new C0227(i));
        }
    }

    /* renamed from: ʟ, reason: contains not printable characters */
    public final void m994() {
        if (TransmitHelper.hasCheckLocationPermission() || C4112.m13054()) {
            return;
        }
        m1031();
        C2618.m9570("permission_has_check_location", true);
        TransmitHelper.setHasCheckLocationPermission(true);
    }

    /* renamed from: ʡ, reason: contains not printable characters */
    public final void m995(boolean z) {
        this.f434.m12005(z);
    }

    /* renamed from: ʢ, reason: contains not printable characters */
    public final void m996(String str) {
        if (C2520.m9312().m9319(str)) {
            this.f431.mo10623(false, false);
            this.f533 = 0;
            this.f430.f13664.m2013(0);
        } else if (this.f533 == 1) {
            this.f431.mo10623(true, true);
        } else {
            this.f431.mo10623(true, false);
        }
    }

    /* renamed from: Ͱ, reason: contains not printable characters */
    public final void m997(C4565 c4565, int i) {
        if (i == -1) {
            c4565.m13988(false);
            c4565.m13989(false);
        } else if (i == 0) {
            c4565.m13989(true);
        } else if (i == 1) {
            c4565.m13987(true);
        } else {
            if (i != 2) {
                return;
            }
            c4565.m13988(true);
        }
    }

    /* renamed from: Ͳ, reason: contains not printable characters */
    public final void m998(boolean z) {
        int iM12737 = (int) C3947.m12727().m12737();
        int iM12747 = C3947.m12727().m12747() > iM12737 ? C3947.m12727().m12747() : iM12737;
        float fM12738 = C3947.m12727().m12738() * C3947.m12727().m12735();
        boolean z2 = C3947.m12727().m12769() && C3947.m12727().m12767();
        if (z2) {
            float f = iM12747;
            float fMin = Math.min(Math.max(fM12738 / (1.0f / f), C3947.m12727().m12752()), C3947.m12727().m12751());
            List<Integer> listM12748 = C3947.m12727().m12748();
            List<Float> listM12745 = C3947.m12727().m12745();
            if (r1.m8144(listM12748) && r1.m8144(listM12745) && ((fMin * 1.0f) / f) / fM12738 > 1.5f) {
                int iM12752 = (((int) (C3947.m12727().m12752() / fM12738)) / iM12737) * iM12737;
                if (r1 % iM12737 > 0.0f) {
                    iM12752 += iM12737;
                }
                int iFloatValue = (int) (1.0f / listM12745.get(listM12745.size() - 1).floatValue());
                iM12747 = iM12752 > iFloatValue ? iM12737 * (iFloatValue / iM12737) : iM12752;
                fMin = Math.min(Math.max(fM12738 / (1.0f / iM12747), C3947.m12727().m12752()), C3947.m12727().m12751());
            }
            float f2 = 1.0f / iM12747;
            C3947.m12727().m12784(f2);
            float f3 = f2 * 360.0f;
            float fM12747 = C3947.m12727().m12747() * f3;
            int iM12471 = C4535.m13880().m13890().m12471();
            if (iM12471 != 0) {
                fM12747 = C3947.m12727().m12760(iM12471) * f3;
            }
            C3947.m12727().m12788(fM12747);
            C3947.m12727().m12787(fMin);
        } else {
            C3947.m12727().m12787(0.0f);
            C3947.m12727().m12784(0.0f);
        }
        C4535.m13880().m13915();
        if (z2) {
            float fM127382 = C3947.m12727().m12738();
            float fM12735 = C3947.m12727().m12735();
            int i = (int) fM127382;
            if (i != this.f437.getIso() || this.f437.getTime() != ((long) (fM12735 * Math.pow(10.0d, 9.0d)))) {
                this.f437.m1973(i, fM12735);
            }
        } else {
            m1121();
            m1030();
        }
        this.f431.mo10563();
        if (z) {
            m1019();
        }
    }

    /* renamed from: ͳ, reason: contains not printable characters */
    public final void m999() {
        C4008.m12878(this.f430.f13657, 100, new C0356());
    }

    /* renamed from: ͷ, reason: contains not printable characters */
    public final void m1000(int i) {
        this.f428 = true;
        SettingHintDialog settingHintDialog = this.f430.f13670;
        settingHintDialog.m2906(i);
        settingHintDialog.setOnButtonClick(new C0339(settingHintDialog));
        settingHintDialog.setAlpha(0.0f);
        settingHintDialog.m2908(i, null);
        C4008.m12876(settingHintDialog, 1.0f, 100, new C0341());
    }

    /* renamed from: Ί, reason: contains not printable characters */
    public final void m1001() {
        z0.m8638(0);
        if (C4792.m14375().m14498()) {
            C4008.m12876(this.f430.f13658, 0.0f, 100, new C0156());
        } else {
            C4008.m12876(this.f430.f13658, 0.0f, 100, new C0158());
        }
    }

    /* renamed from: ΐ, reason: contains not printable characters */
    public final boolean m1002(float f) {
        return Math.round(f) != 0;
    }

    /* renamed from: Ξ, reason: contains not printable characters */
    public final void m1003() {
        this.f437.m1984();
        this.f431.mo10641();
    }

    /* renamed from: Ϋ, reason: contains not printable characters */
    public final void m1004() throws JSONException {
        String str;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str2 = "";
        if (userBeanM5990 != null) {
            String str3 = userBeanM5990.getId() + "";
            str = userBeanM5990.getAccess_token() + "";
            str2 = str3;
        } else {
            str = "";
        }
        C3608.m11650().m11653(str2, str, new C0262());
        e5.m5988().m5995();
        this.f500 = true;
        m1014();
        m1065(false);
        n.m7588().m7589();
        if (this.f439 == 1) {
            m1087(true);
            m1063(true);
        }
        m1088();
    }

    /* renamed from: ε, reason: contains not printable characters */
    public final void m1005() {
        try {
            unregisterReceiver(this.f530);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: ν, reason: contains not printable characters */
    public final void m1006(boolean z) {
        if (this.f533 != 1) {
            this.f460.post(new RunnableC0215(z));
        }
    }

    /* renamed from: τ, reason: contains not printable characters */
    public final void m1007() {
        AbstractC5160 abstractC5160 = this.f431;
        if (abstractC5160 != null && abstractC5160 == this.f433) {
            m972();
        }
        AbstractC5160 abstractC51602 = this.f431;
        if (abstractC51602 == null || abstractC51602 != this.f432) {
            this.f432 = new C3295();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fcallback", this.f542);
            this.f432.setArguments(bundle);
            this.f431 = this.f432;
            this.f434 = o3.m7669().m7671();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("fcallback", this.f542);
            this.f434.setArguments(bundle2);
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.fragment_container, this.f431);
            fragmentTransactionBeginTransaction.add(R.id.fragment_container, this.f434);
            fragmentTransactionBeginTransaction.show(this.f431).hide(this.f434).commitAllowingStateLoss();
        }
    }

    /* renamed from: ϒ, reason: contains not printable characters */
    public final int m1008(boolean z, int i, ArrayList<h0> arrayList, int i2) {
        int size = z ? i == arrayList.size() + (-1) ? 0 : i + 1 : i == 0 ? arrayList.size() - 1 : i - 1;
        if (!C4136.m13108().m13114(arrayList.get(size))) {
            return size;
        }
        if (i2 < arrayList.size()) {
            return m1008(z, size, arrayList, i2 + 1);
        }
        return 0;
    }

    /* renamed from: ϔ, reason: contains not printable characters */
    public final void m1009(boolean z, int i) {
        float fM1079 = m1079();
        float fM12739 = C3947.m12727().m12739();
        List<Float> listM12740 = C3947.m12727().m12740();
        if (r1.m8144(listM12740)) {
            float fFloatValue = listM12740.get(0).floatValue();
            float fFloatValue2 = listM12740.get(listM12740.size() - 1).floatValue();
            float f = fFloatValue - fFloatValue2;
            float fMo10519 = this.f431.mo10519(fM12739, fFloatValue2, f);
            if (fMo10519 < 0.0f) {
                fMo10519 = 0.0f;
            } else if (fMo10519 > 1.0f) {
                fMo10519 = 1.0f;
            }
            float fMin = Math.min(1.0f, Math.max(0.0f, z ? fMo10519 + (C4567.f15620 * i) : fMo10519 - (C4567.f15620 * i)));
            float f2 = (f * fMin) + fFloatValue2;
            int iM12471 = C4535.m13880().m13890().m12471();
            if (iM12471 != 0) {
                C3947.m12727().m12784(f2 / (C3947.m12727().m12760(iM12471) * 360.0f));
            } else {
                C3947.m12727().m12784(f2 / (C3947.m12727().m12747() * 360.0f));
            }
            C3947.m12727().m12788(f2);
            this.f431.mo10536(fM1079);
            this.f431.mo10619(C4792.m14375().m14431());
            this.f431.mo10607(-1);
            m1121();
            this.f431.mo10577();
            this.f431.mo10620(fMin);
            if (this.f439 == 1) {
                this.f437.m1973((int) C3947.m12727().m12738(), C3947.m12727().m12735());
            }
        }
    }

    /* renamed from: Ϝ, reason: contains not printable characters */
    public final void m1010() {
        ACHelper aCHelper = ACHelper.getInstance();
        aCHelper.startLoop();
        aCHelper.setOnCameraCallback(new C0197(aCHelper));
    }

    /* renamed from: Ϟ, reason: contains not printable characters */
    public final void m1011() {
        this.f481 = C4535.m13880().m13890().m12429();
    }

    /* renamed from: Ϩ, reason: contains not printable characters */
    public final void m1012(int i, String str) {
        m1175(String.format(getResources().getString(i), str));
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0422  */
    /* renamed from: Ϯ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1013(boolean r17, boolean r18) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.home.HomeActivity.m1013(boolean, boolean):void");
    }

    /* renamed from: ϲ, reason: contains not printable characters */
    public final void m1014() {
        this.f471 = true;
        m1093();
        m1072();
        m1145();
        m1170();
        m1047();
    }

    /* renamed from: ϳ, reason: contains not printable characters */
    public final void m1015(C3891 c3891) {
        this.f430.f13666.setOnButtonClick(new C0169());
        this.f430.f13666.setVisibility(0);
        this.f430.f13666.setAlpha(0.0f);
        this.f430.f13666.m2908(33, c3891);
        C4008.m12876(this.f430.f13666, 1.0f, 100, null);
    }

    /* renamed from: Ѓ, reason: contains not printable characters */
    public void m1016(String str) {
        if (this.f437.getCameraID().equals(str)) {
            return;
        }
        C4535.m13880().m13890().m12463();
        int iM12462 = C4535.m13880().m13890().m12462();
        int iM13897 = C4535.m13880().m13897();
        int iM13896 = C4535.m13880().m13896();
        if (iM13897 != 0 && iM13896 != 0 && iM13896 != iM12462) {
            this.f437.setTargetVideoSize(new C2375(iM13897, iM13896));
        }
        m996(str);
        this.f437.m2008(str);
        m1063(true);
    }

    /* renamed from: Ј, reason: contains not printable characters */
    public final void m1017(boolean z) {
        this.f431.mo10637(z);
    }

    /* renamed from: с, reason: contains not printable characters */
    public final void m1018(boolean z) {
        m1110();
        m1103(z);
    }

    /* renamed from: х, reason: contains not printable characters */
    public final void m1019() {
        m1030();
        m1121();
    }

    /* renamed from: ч, reason: contains not printable characters */
    public final boolean m1020(C3891 c3891) {
        if (r1.m8137(c3891)) {
            return true;
        }
        if (c3891.m12442() == 0) {
            return false;
        }
        String strM15270 = C4151.m13162().m13180().m15270();
        if (!r1.m8143(strM15270) || e5.m5988().m5993()) {
            return false;
        }
        for (FilterGroupBean filterGroupBean : (List) new Gson().fromJson(strM15270, new C0333().getType())) {
            if (filterGroupBean.getId() == c3891.m12442()) {
                return filterGroupBean.isPurchase_required();
            }
        }
        return true;
    }

    /* renamed from: ѕ, reason: contains not printable characters */
    public void m1021(boolean z) {
        this.f483 = false;
        if (this.f429) {
            C4638.m14099("readCurrentConfigState", "backHome:" + C4535.m13880().m13890().toString());
        }
        this.f592 = true;
        this.f471 = z;
        C3947.m12727().m12793(true);
        this.f431.mo10478(true);
        m1170();
        m1047();
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (C4136.m13108().m13110(c3891M13890.m12442())) {
            m1102(c3891M13890);
        }
    }

    /* renamed from: ѵ, reason: contains not printable characters */
    public final void m1022() {
        this.f431.mo10614();
    }

    /* renamed from: ҁ, reason: contains not printable characters */
    public final String m1023(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : TransmitHelper.CAMERA_UNIT_D_CONTENT : TransmitHelper.CAMERA_UNIT_C_CONTENT : TransmitHelper.CAMERA_UNIT_B_CONTENT : "A";
    }

    /* renamed from: Ґ, reason: contains not printable characters */
    public final void m1024(boolean z) {
        if (e5.m5988().m5993()) {
            return;
        }
        C4535.m13880().m13905(z);
    }

    /* renamed from: ґ, reason: contains not printable characters */
    public final void m1025() {
        if (r1.m8143(ACHelper.getInstance().getRoomId())) {
            this.f434.m12016(ACHelper.getInstance().getRoomId());
        }
        getSupportFragmentManager().beginTransaction().hide(this.f432).show(this.f434).commitAllowingStateLoss();
        this.f434.m12026();
    }

    /* renamed from: Ғ, reason: contains not printable characters */
    public final boolean m1026(int i) {
        return i != 0;
    }

    /* renamed from: ғ, reason: contains not printable characters */
    public final void m1027(boolean z, int i) {
        float fM12742 = C3947.m12727().m12742();
        float fMax = Math.max(0.0f, Math.min(1.0f, z ? (C4567.f15620 * i) + fM12742 : fM12742 - (C4567.f15620 * i)));
        C3947.m12727().m12789(fMax);
        this.f431.mo10586(fMax, fM12742);
        this.f437.m1975(0.0f, C3947.m12727().m12754(fMax));
    }

    /* renamed from: Ү, reason: contains not printable characters */
    public final void m1028() {
        this.f431.mo10571();
    }

    /* renamed from: ү, reason: contains not printable characters */
    public final void m1029() {
        m1028();
        m1177();
        m1158();
        m1065(e5.m5988().m5993());
    }

    /* renamed from: ұ, reason: contains not printable characters */
    public final void m1030() {
        this.f431.mo10606();
    }

    /* renamed from: ӵ, reason: contains not printable characters */
    public final void m1031() {
        SettingHintDialog settingHintDialog = this.f430.f13670;
        settingHintDialog.m2906(37);
        settingHintDialog.setOnButtonClick(new C0342(settingHintDialog));
        settingHintDialog.setAlpha(0.0f);
        settingHintDialog.m2908(37, null);
        C4008.m12876(settingHintDialog, 1.0f, 100, new C0344());
    }

    /* renamed from: ӷ, reason: contains not printable characters */
    public void m1032(boolean z) {
        runOnUiThread(new RunnableC0359(z));
    }

    /* renamed from: Բ, reason: contains not printable characters */
    public final void m1033(boolean z) {
        if (m968() && !this.f552) {
            if (this.f429) {
                C4638.m14099("MeasureFilterTime", String.format("before start setFilterWidthAnimation", new Object[0]));
            }
            long jNanoTime = System.nanoTime();
            this.f552 = true;
            this.f437.m2064(new RunnableC0280(z, jNanoTime));
        }
    }

    /* renamed from: Դ, reason: contains not printable characters */
    public final void m1034(int i) {
        this.f430.f13675.setVisibility(0);
        this.f430.f13675.setAlpha(0.0f);
        this.f430.f13675.m2908(i, null);
        this.f430.f13675.setOnButtonClick(new C0259());
        C4008.m12876(this.f430.f13675, 1.0f, 100, null);
    }

    /* renamed from: Ի, reason: contains not printable characters */
    public final void m1035() {
        try {
            AudioManager audioManager = this.f504;
            if (audioManager != null) {
                audioManager.adjustStreamVolume(3, 100, 0);
            }
        } catch (Exception e2) {
            C4638.m14101("recoverSound", "closeSound error " + e2.getMessage());
        }
    }

    /* renamed from: Լ, reason: contains not printable characters */
    public final void m1036() {
        if (m1058()) {
            this.f437.m2034(true);
        }
    }

    /* renamed from: Հ, reason: contains not printable characters */
    public final void m1037() {
        m1114(-1);
    }

    /* renamed from: Ր, reason: contains not printable characters */
    public final void m1038() {
        ACHelper.getInstance().copyDecodeParamBean(this.f466, this.f462);
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12463 = c3891M13890.m12463();
        int iM12462 = c3891M13890.m12462();
        DecoderParamsBean decoderParamsBean = this.f462;
        decoderParamsBean.m483(Math.min(decoderParamsBean.m475(), iM12463));
        DecoderParamsBean decoderParamsBean2 = this.f462;
        decoderParamsBean2.m481(Math.min(decoderParamsBean2.m473(), iM12462));
    }

    /* renamed from: Ւ, reason: contains not printable characters */
    public final void m1039(float f, float f2) {
        this.f431.mo10556(f, f2);
        if (f <= 1.0f && f >= 0.0f) {
            float fM12756 = C3947.m12727().m12756(f);
            if (this.f429) {
                C4638.m14099("slimmm", "realFocusPByPro:" + fM12756 + " pro:" + f);
            }
            if (fM12756 != this.f437.getFocusPercent()) {
                this.f437.m1972(fM12756);
            }
        } else if ((f == 1.25f || f == -0.25f) && -1.0f != this.f437.getFocusPercent()) {
            this.f437.m1972(-1.0f);
        }
        m1099(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x038a  */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* renamed from: է, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1040(defpackage.AbstractC2341.C2344 r19, boolean r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 913
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.home.HomeActivity.m1040(İ$Ԫ, boolean):void");
    }

    /* renamed from: ժ, reason: contains not printable characters */
    public final void m1041() {
        C4151.m13162().m13173(new C0290());
    }

    /* renamed from: լ, reason: contains not printable characters */
    public final void m1042(boolean z) {
        MobSDK.submitPolicyGrantResult(z, new C0144());
    }

    /* renamed from: ծ, reason: contains not printable characters */
    public void m1043(DecoderParamsBean decoderParamsBean) {
        if (this.f467) {
            if (this.f431 instanceof C3295) {
                this.f432.m11170(TransmitHelper.getInstance().isStartCameraTransmit(), TransmitHelper.getInstance().getConnectionNum(), TransmitHelper.getInstance().getSelectUnitString(TransmitHelper.getInstance().getConnectionUnitType()), TransmitHelper.getInstance().getWifiStatus());
            }
            m1125(true, true);
            m1109(decoderParamsBean);
            m995(true);
        }
        if (this.f468) {
            m1125(true, true);
            m1089(true);
        }
    }

    /* renamed from: հ, reason: contains not printable characters */
    public final void m1044() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (e5.m5988().m5993()) {
            return;
        }
        if (C4136.m13108().m13113(this.f431.mo10515())) {
            m1074(c3891M13890);
        }
        m1065(false);
        m1142();
        m1130();
    }

    /* renamed from: ձ, reason: contains not printable characters */
    public final void m1045(boolean z) {
        this.f431.mo10635(z);
    }

    /* renamed from: ո, reason: contains not printable characters */
    public void m1046() {
        if (this.f467 || this.f468) {
            stopNSDFinder();
            if (this.f467) {
                m1018(false);
            }
            m1067();
            ConnectionManager.getInstance().releaseSrt();
            if (this.f468) {
                LinkManager.getInstance().release();
                m1089(false);
            }
            if (this.f453 == 3) {
                this.f467 = false;
                TransmitHelper.getInstance().setStartCameraTransmit(this.f467);
                this.f543 = false;
                this.f468 = false;
                this.f461 = false;
            }
        }
    }

    /* renamed from: ռ, reason: contains not printable characters */
    public void m1047() {
        this.f431.mo10630();
    }

    /* renamed from: ս, reason: contains not printable characters */
    public final void m1048(boolean z, boolean z2) {
        if (this.f467) {
            return;
        }
        runOnUiThread(new RunnableC0329(z2, z));
    }

    /* renamed from: օ, reason: contains not printable characters */
    public final void m1049() {
        this.f451 = false;
        if (C4151.m13162().m13167()) {
            m1041();
        } else {
            n.m7588().m7602(new C0289());
        }
    }

    /* renamed from: ג, reason: contains not printable characters */
    public final void m1050() {
        if (m1058()) {
            this.f437.m2034(false);
        }
    }

    /* renamed from: ד, reason: contains not printable characters */
    public final boolean m1051(float f) {
        return Math.round(f) != 0;
    }

    /* renamed from: ך, reason: contains not printable characters */
    public final void m1052() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        registerReceiver(this.f530, intentFilter);
    }

    /* renamed from: ל, reason: contains not printable characters */
    public final float m1053(C3891 c3891) {
        if (c3891 == null) {
            return 1.0f;
        }
        int iM12429 = c3891.m12429();
        if (iM12429 != 1) {
            return iM12429 != 2 ? 1.0f : 1.55f;
        }
        return 1.3333334f;
    }

    /* renamed from: ן, reason: contains not printable characters */
    public final void m1054() {
        this.f431.mo10485(m965(C4535.m13880().m13890().m12488()));
    }

    /* renamed from: נ, reason: contains not printable characters */
    public final void m1055() {
        this.f431.mo10501();
    }

    /* renamed from: ץ, reason: contains not printable characters */
    public final void m1056(int i) {
        if (m1058()) {
            this.f437.m2035(true, i);
        }
    }

    /* renamed from: ױ, reason: contains not printable characters */
    public final void m1057() {
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (userBeanM5990 == null || userBeanM5990.getIs_subscription_user()) {
            this.f460.post(new RunnableC0245());
            return;
        }
        CachePlayStoreBean cachePlayStoreBeanM11747 = C3659.m11744().m11747();
        CacheHuaweiBean cacheHuaweiBeanM11746 = C3659.m11744().m11746();
        if (cachePlayStoreBeanM11747 == null) {
            if (cacheHuaweiBeanM11746 != null) {
                PayController.queryHuaweiOrder(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), HuaweiPay.generateHuaweiJson(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), cacheHuaweiBeanM11746.getInAppPurchaseData(), cacheHuaweiBeanM11746.getInAppSignature()), new C0240());
                return;
            }
            return;
        }
        Purchase purchase = cachePlayStoreBeanM11747.getPurchase();
        PayController.queryPlayStoreOrder(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), GooglePayHelper.generateGoogleJson(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), purchase.getOriginalJson(), purchase.getSignature()), new C0237());
    }

    /* renamed from: ة, reason: contains not printable characters */
    public final boolean m1058() {
        return C4535.m13880().m13890().m12375() == -1;
    }

    /* renamed from: ر, reason: contains not printable characters */
    public final void m1059(int i) {
        if (m1058()) {
            this.f437.m2035(false, i);
        }
    }

    /* renamed from: ز, reason: contains not printable characters */
    public final void m1060(int i) {
        this.f431.mo10549(i);
    }

    /* renamed from: ٳ, reason: contains not printable characters */
    public final boolean m1061(boolean z) {
        boolean z2;
        if (!m1147(z)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        boolean zM13056 = C4112.m13056();
        if (!FilmApp.m405().m425() || zM13056) {
            z2 = true;
        } else {
            z2 = this.f575;
            if (z && !z2) {
                return false;
            }
        }
        if (!zM13056) {
            arrayList.add("android.permission.CAMERA");
            if (!FilmApp.m405().m426() && z2) {
                this.f583 = 8;
                m1000(8);
                return false;
            }
        }
        if (!FilmApp.m405().m426() || !z) {
            if (!C4112.m13055()) {
                arrayList.add("android.permission.RECORD_AUDIO");
                if (z2) {
                    this.f583 = 9;
                    m1000(9);
                    return false;
                }
            }
            if (!C4112.m13057()) {
                if (Build.VERSION.SDK_INT >= 33) {
                    arrayList.add("android.permission.READ_MEDIA_IMAGES");
                    arrayList.add("android.permission.READ_MEDIA_VIDEO");
                } else {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                if (z2) {
                    this.f583 = 10;
                    m1000(10);
                    return false;
                }
            }
        }
        int size = arrayList.size();
        if (size <= 0) {
            this.f430.f13670.setVisibility(8);
            return true;
        }
        if (!this.f575) {
            ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[size]), 101);
            this.f575 = true;
            C2618.m9570(this.f579, true);
        }
        return false;
    }

    /* renamed from: ڈ, reason: contains not printable characters */
    public final void m1062(boolean z) {
        this.f431.mo10463(z);
    }

    /* renamed from: ډ, reason: contains not printable characters */
    public final void m1063(boolean z) {
        this.f586 = z;
        m999();
        this.f437.m1987(z);
    }

    /* renamed from: ڊ, reason: contains not printable characters */
    public final void m1064() {
        if (!C4112.m13057()) {
            runOnUiThread(new RunnableC0316());
        } else {
            if (this.f519 == null) {
                return;
            }
            if (this.f488 != 1 || C4112.m13056()) {
                this.f519.post(new RunnableC0317());
            }
        }
    }

    /* renamed from: ڋ, reason: contains not printable characters */
    public final void m1065(boolean z) {
        m1060(C4535.m13880().m13890().m12460());
        this.f430.f13676.setSignState(e5.m5988().m5994());
        if (!z) {
            if (this.f565) {
                this.f431.mo10640(100);
                return;
            } else {
                this.f431.mo10524(100);
                return;
            }
        }
        this.f430.f13676.m2583();
        this.f431.mo10524(0);
        C3744 c3744 = this.f434;
        if (c3744 != null) {
            int i = this.f469;
            if (i == 2) {
                c3744.m12008(1);
            } else if (i == 3) {
                c3744.m12008(2);
            }
        }
    }

    /* renamed from: ڌ, reason: contains not printable characters */
    public final void m1066() {
        String cameraID = this.f437.getCameraID();
        C3891 c3891M13890 = C4535.m13880().m13890();
        C3828 c3828M11224 = C3444.m11224(c3891M13890.m12399());
        C3828 c3828M112242 = C3444.m11224(c3891M13890.m12380());
        if (this.f565) {
            if (c3828M11224.m12137().equals(c3828M112242.m12137())) {
                if (C2520.m9312().m9321(c3828M112242.m12137())) {
                    C3444.m11233(C2520.m9312().m9317().m12137());
                    this.f431.mo10609(C2520.m9312().m9317());
                }
                m1068();
                return;
            }
            this.f430.f13664.setTargetVideoSize(new C2375(c3891M13890.m12463(), c3891M13890.m12462()));
            m1016(c3828M11224.m12137());
            this.f439 = 0;
            C3444.m11233(c3828M11224.m12137());
            this.f431.mo10609(c3828M11224);
            return;
        }
        if (c3828M11224.m12137().equals(c3828M112242.m12137())) {
            if (C2520.m9312().m9323(cameraID)) {
                this.f431.mo10609(C2520.m9312().m9315());
            }
            this.f431.mo10622();
            return;
        }
        this.f430.f13664.setTargetVideoSize(new C2375(c3891M13890.m12463(), c3891M13890.m12462()));
        String strM12137 = c3828M112242.m12137();
        String strM9313 = C2520.m9312().m9313(strM12137, C2520.m9312().m9319(strM12137) ? C3947.m12727().m12732() : C3947.m12727().m12733());
        float[] fArrMo10516 = this.f431.mo10516();
        this.f437.m2014(fArrMo10516[0]);
        this.f437.m2033(fArrMo10516[1]);
        m1016(strM9313);
        this.f439 = 0;
        if (C2520.m9312().m9315().m12137().equals(c3828M112242.m12137()) || C2520.m9312().m9325(c3828M112242.m12137()) || C2520.m9312().m9326(c3828M112242.m12137()) || C2520.m9312().m9324(c3828M112242.m12137()) || C2520.m9312().m9327(c3828M112242.m12137())) {
            c3828M112242 = C2520.m9312().m9315();
        }
        this.f431.mo10609(c3828M112242);
    }

    /* renamed from: ڍ, reason: contains not printable characters */
    public final void m1067() {
        ACHelper.getInstance().stopLoop();
    }

    /* renamed from: ڎ, reason: contains not printable characters */
    public final void m1068() {
        this.f431.mo10587();
        C3485 c3485M12731 = C3947.m12727().m12731();
        if (c3485M12731 != null) {
            this.f555 = c3485M12731.m11391();
            this.f556 = c3485M12731.m11394();
            this.f557 = c3485M12731.m11392();
            this.f558 = c3485M12731.m11393();
            this.f559 = c3485M12731.m11395();
            this.f560 = c3485M12731.m11376();
            this.f561 = c3485M12731.m11378();
            this.f562 = c3485M12731.m11377();
            this.f563 = c3485M12731.m11379();
        } else {
            this.f555 = false;
            this.f556 = false;
            this.f557 = false;
            this.f558 = false;
            this.f559 = false;
            this.f560 = false;
            this.f561 = false;
            this.f562 = false;
            this.f563 = false;
        }
        ACHelper.getInstance().setFocusEnable(this.f558);
        ACHelper.getInstance().setZoomEnable(this.f559);
        if (this.f565) {
            if (!this.f556 || !this.f557) {
                C3947.m12727().m12779(true);
            }
            this.f431.mo10541();
            m1153(true, 3);
        }
    }

    /* renamed from: ڏ, reason: contains not printable characters */
    public final void m1069(int i) {
        if (i != 1) {
            this.f431.mo10599(8);
        }
        if (i == -1) {
            this.f437.m2064(new RunnableC0355());
            return;
        }
        if (i == 0) {
            this.f437.m2064(new RunnableC0352());
        } else if (i == 1) {
            this.f437.m2064(new RunnableC0354());
        } else {
            if (i != 2) {
                return;
            }
            this.f437.m2064(new RunnableC0353());
        }
    }

    /* renamed from: ڐ, reason: contains not printable characters */
    public final boolean m1070() {
        if (C4112.m13057()) {
            return true;
        }
        this.f583 = 10;
        if (this.f428) {
            return false;
        }
        m1000(10);
        return false;
    }

    /* renamed from: ڑ, reason: contains not printable characters */
    public void m1071() {
        C3947.m12727().m12783(0.5f);
        if (this.f439 == 1) {
            this.f437.m2012((int) C3947.m12727().m12744(), C3947.m12727().m12734());
        }
        this.f460.post(new RunnableC0300());
    }

    /* renamed from: ڒ, reason: contains not printable characters */
    public final void m1072() {
        C3947.m12727().m12776();
        this.f431.mo10551();
        this.f431.mo10534();
        this.f431.mo10584();
        this.f431.mo10554();
        m1121();
        m1030();
        boolean zM12765 = C3947.m12727().m12765();
        C3947.m12727().m12735();
        this.f431.mo10533();
        if (zM12765) {
            this.f431.mo10475(true);
            this.f431.mo10480(true);
            this.f431.mo10607(-1);
            this.f431.mo10619(-1);
            this.f431.mo10471(1.0f);
        } else {
            this.f431.mo10475(false);
            this.f431.mo10480(false);
            this.f431.mo10607(-1);
            this.f431.mo10619(-1);
            this.f431.mo10471(0.2f);
        }
        m989();
        m977(false);
        m1137();
        m1162();
        m1108();
        if (this.f471) {
            this.f565 = C4535.m13880().m13890().m12457();
            if (!this.f500) {
                m1029();
            }
            m1160();
            m970();
            this.f431.mo10544();
            this.f431.mo10570(0);
            this.f431.mo10568();
            this.f471 = false;
        }
        C3891 c3891M13890 = C4535.m13880().m13890();
        m1099(c3891M13890.m12412());
        this.f431.mo10485(m965(c3891M13890.m12488()));
        int iM12487 = c3891M13890.m12487();
        this.f438 = iM12487;
        C2650.m9797(iM12487);
        m1085();
        this.f585 = C4535.m13880().m13890().m12375();
        ArrayList<C4351> arrayListM11226 = C3444.m11226();
        Iterator<C4351> it = arrayListM11226.iterator();
        while (it.hasNext()) {
            it.next().m13507(false);
        }
        int i = this.f585;
        if (i == -1 || i < 0 || i >= arrayListM11226.size()) {
            return;
        }
        arrayListM11226.get(this.f585).m13507(true);
    }

    /* renamed from: ڔ, reason: contains not printable characters */
    public final void m1073(float f, float f2) {
        float fMo10518;
        int i;
        float fMo10517;
        int i2;
        if (f == this.f447 && f2 == this.f448) {
            return;
        }
        this.f447 = f;
        this.f448 = f2;
        C3891 c3891M13890 = C4535.m13880().m13890();
        boolean zM12494 = c3891M13890.m12494();
        if (zM12494) {
            fMo10518 = this.f431.mo10518() * this.f548;
            i = C2579.f9594;
        } else if (!C4792.m14375().m14498()) {
            fMo10518 = C2579.f9598 * this.f548;
            i = C2579.f9594;
        } else if (c3891M13890.m12429() == 1) {
            fMo10518 = ((C2579.f9597 * 1.0f) / 2.37f) * this.f548;
            i = C2579.f9594;
        } else if (c3891M13890.m12429() == 2) {
            fMo10518 = ((C2579.f9597 * 1.0f) / 2.76f) * this.f548;
            i = C2579.f9594;
        } else {
            fMo10518 = ((C2579.f9597 * 1.0f) / 1.7777778f) * this.f548;
            i = C2579.f9594;
        }
        float f3 = (fMo10518 - i) / 2.0f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (Math.abs(f) > f3) {
            if (f > 0.0f) {
                this.f447 = f3;
            } else {
                this.f447 = -f3;
            }
        }
        if (c3891M13890.m12429() == 1 || c3891M13890.m12429() == 2) {
            if (zM12494) {
                fMo10517 = this.f431.mo10517() * this.f548;
                i2 = C2579.f9593;
            } else if (C4792.m14375().m14498()) {
                fMo10517 = C2579.f9597 * this.f548;
                i2 = C2579.f9593;
            } else if (c3891M13890.m12429() == 2) {
                fMo10517 = ((C2579.f9598 * 1.0f) / 2.76f) * this.f548;
                i2 = C2579.f9593;
            } else {
                fMo10517 = ((C2579.f9598 * 1.0f) / 2.37f) * this.f548;
                i2 = C2579.f9593;
            }
        } else if (zM12494) {
            fMo10517 = this.f431.mo10517() * this.f548;
            i2 = C2579.f9593;
        } else {
            fMo10517 = C2579.m9449(this) * this.f548;
            i2 = C2579.f9593;
        }
        float f4 = (fMo10517 - i2) / 2.0f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (Math.abs(f2) > f4) {
            if (f2 > 0.0f) {
                this.f448 = f4;
            } else {
                this.f448 = -f4;
            }
        }
        this.f437.setTranslationX(this.f447);
        this.f437.setTranslationY(this.f448);
        this.f431.mo10616(this.f447, this.f448);
    }

    /* renamed from: ڗ, reason: contains not printable characters */
    public final void m1074(C3891 c3891) {
        m1164();
        m1055();
        this.f475 = false;
        m1060(c3891.m12460());
    }

    /* renamed from: ژ, reason: contains not printable characters */
    public final void m1075() {
        this.f430.f13668.setVisibility(0);
        this.f430.f13668.setAlpha(0.0f);
        this.f430.f13668.m2878();
        this.f430.f13668.setOnChangeListener(new C0255());
    }

    /* renamed from: ڙ, reason: contains not printable characters */
    public final void m1076(C2628 c2628, C3621 c3621, AbstractC2341.C2344 c2344, String str, Runnable runnable) {
        C3768.m12063(new C0322(5, str, c2344, c2628, c3621, runnable));
    }

    /* renamed from: ہ, reason: contains not printable characters */
    public final void m1077() {
        this.f431.mo10472();
    }

    /* renamed from: ۂ, reason: contains not printable characters */
    public void m1078() {
        this.f427 = true;
    }

    /* renamed from: ۃ, reason: contains not printable characters */
    public final float m1079() {
        float fFloatValue;
        float fFloatValue2;
        float fM12739 = C3947.m12727().m12739();
        float fM12735 = C3947.m12727().m12735();
        List<Float> listM12740 = C3947.m12727().m12740();
        List<Float> listM12745 = C3947.m12727().m12745();
        boolean zM12764 = C3947.m12727().m12764();
        if (!r1.m8144(listM12740)) {
            return 0.0f;
        }
        if (zM12764) {
            fFloatValue = listM12740.get(0).floatValue();
            fFloatValue2 = listM12740.get(listM12740.size() - 1).floatValue();
        } else {
            float fFloatValue3 = listM12745.get(0).floatValue();
            float fFloatValue4 = listM12745.get(listM12745.size() - 1).floatValue();
            fFloatValue = fFloatValue3;
            fFloatValue2 = fFloatValue4;
        }
        float f = fFloatValue - fFloatValue2;
        float fMo10519 = zM12764 ? this.f431.mo10519(fM12739, fFloatValue2, f) : this.f431.mo10519(fM12735, fFloatValue2, f);
        float f2 = fMo10519 >= 0.0f ? fMo10519 > 1.0f ? 1.0f : fMo10519 : 0.0f;
        return zM12764 ? f2 : C3947.m12727().m12743(f2);
    }

    /* renamed from: ۯ, reason: contains not printable characters */
    public final void m1080() {
        registerReceiver(this.f531, m1151());
        m.m7511().m7518();
        this.f573 = true;
    }

    /* renamed from: ܖ, reason: contains not printable characters */
    public final void m1081() {
        C2811.m10140();
        ACHelper.getInstance().initCheck265();
        if (C2813.f10275) {
            return;
        }
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890.m12478() == 1) {
            c3891M13890.m12343(0);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: ܝ, reason: contains not printable characters */
    public final void m1082(boolean z) {
        String access_token;
        UserBean userBeanM5990 = e5.m5988().m5990();
        boolean z2 = true;
        String str = "";
        if (userBeanM5990 != null) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else {
            if (C3659.m11744().m11747() == null && C3659.m11744().m11746() == null) {
                z2 = false;
            }
            access_token = "";
        }
        boolean zM5993 = e5.m5988().m5993();
        if (z2) {
            C3608.m11650().m11659(str, access_token, new C0246(z, zM5993));
        } else {
            m1112();
        }
    }

    /* renamed from: ܪ, reason: contains not printable characters */
    public final void m1083(String str, int i, int i2, int i3, int i4) {
        String str2 = "";
        int i5 = 0;
        if (i3 != 0 && str != null && !"".equalsIgnoreCase(str)) {
            str2 = String.format("(%s)", str);
        }
        ACHelper.getInstance().setFpsTimeLapseValue(str2);
        if (this.f429) {
            C4638.m14099("FilmHomeActivity", String.format("onVideoFpsChoose  timeLapseTimeMs : %s ", Integer.valueOf(i3)));
        }
        if (i2 == 2 && i == 1) {
            i5 = R.drawable.icon_13_alert;
        }
        this.f431.mo10557(String.valueOf(i4), i5, str2);
    }

    /* renamed from: ݚ, reason: contains not printable characters */
    public final void m1084() {
        if (this.f565) {
            m1017(this.f527);
        } else {
            m953(this.f527);
        }
    }

    /* renamed from: ݫ, reason: contains not printable characters */
    public final void m1085() {
        this.f431.mo10581();
    }

    /* renamed from: ݬ, reason: contains not printable characters */
    public final void m1086() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        List<Fragment> fragments = supportFragmentManager.getFragments();
        if (r1.m8144(fragments)) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof C3295) {
                    supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                }
            }
        }
        C3295 c3295 = this.f432;
        if (c3295 != null) {
            c3295.m11112();
            this.f432 = null;
        }
    }

    /* renamed from: ݱ, reason: contains not printable characters */
    public final void m1087(boolean z) throws JSONException {
        m1013(z, false);
    }

    /* renamed from: ߞ, reason: contains not printable characters */
    public final void m1088() {
        m1048(false, false);
    }

    /* renamed from: ߟ, reason: contains not printable characters */
    public final void m1089(boolean z) {
        this.f434.m12010(z);
    }

    /* renamed from: ߢ, reason: contains not printable characters */
    public final void m1090(int i) {
        m1175(getResources().getString(i));
    }

    /* renamed from: ߣ, reason: contains not printable characters */
    public final void m1091() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        m1150();
        this.f525 = (c3891M13890.m12404() * 1.0f) / c3891M13890.m12403();
    }

    /* renamed from: ߤ, reason: contains not printable characters */
    public final void m1092() {
        C4151.m13162().m13171(new C0295());
    }

    /* renamed from: ߦ, reason: contains not printable characters */
    public final void m1093() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        ArrayList<h0> arrayListM11244 = C3444.m11227().m11244();
        int iM12442 = c3891M13890.m12442();
        int i = 0;
        if (r1.m8144(arrayListM11244)) {
            Iterator<h0> it = arrayListM11244.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (iM12442 == it.next().m6136()) {
                    i2 = iM12442;
                }
            }
            if (i2 != iM12442 || m1020(c3891M13890)) {
                m1102(c3891M13890);
            } else {
                i = i2;
            }
        }
        this.f475 = m1026(i);
        this.f480 = m1143(c3891M13890.m12438());
        this.f476 = m961(c3891M13890.m12402());
        this.f477 = m1051(c3891M13890.m12398());
        this.f478 = m1002(c3891M13890.m12397());
        this.f479 = m1135(c3891M13890.m12489());
        m1134(m988());
        m1011();
        m1022();
        this.f431.mo10582(((int) c3891M13890.m12469()) + "K");
        this.f430.f13665.setAlpha(0.0f);
        m1127(m1178());
        m1065(e5.m5988().m5993());
        this.f505 = c3891M13890.m12385();
        this.f506 = c3891M13890.m12390();
        this.f507 = c3891M13890.m12386();
        this.f508 = c3891M13890.m12382();
        this.f509 = c3891M13890.m12387();
        this.f510 = c3891M13890.m12383();
        this.f511 = c3891M13890.m12396();
        m1129();
    }

    /* renamed from: ߧ, reason: contains not printable characters */
    public final void m1094() {
        if (C4112.m13056()) {
            this.f437.mo1968();
            this.f437.setVisibility(0);
        }
    }

    /* renamed from: ࠔ, reason: contains not printable characters */
    public final void m1095() {
        this.f565 = C4535.m13880().m13890().m12495();
        CameraView cameraView = this.f430.f13664;
        this.f437 = cameraView;
        cameraView.m2002(this.f521);
        this.f437.m2010(this.f522);
        this.f437.m2003(this.f520);
        m1101();
        this.f531 = new BatteryChangedReceiver();
        this.f530 = new C0361(this, null);
        m1167();
        initListener();
        this.f574 = new HeadsetReceiver(this.f549);
        this.f430.f13663.m2906(6);
        this.f430.f13663.setOnButtonClick(new C0153());
        m1081();
        this.f435 = C2579.m9443(this);
        this.f436 = C2579.m9442(this);
        C2462.m9035().m9037();
        ViewGroup.LayoutParams layoutParams = this.f437.getLayoutParams();
        int iM9450 = C2579.m9450(this);
        int iM9449 = C2579.m9449(this);
        int i = this.f435;
        if (iM9450 > i) {
            int i2 = (((int) ((i * 9.0f) / 16.0f)) >> 1) << 1;
            if (this.f429) {
                C4638.m14099("FilmHomeActivity", String.format("viewWidth : %s , viewHeight : %s ", Integer.valueOf(i), Integer.valueOf(i2)));
            }
            iM9449 = i2;
            iM9450 = i;
        }
        layoutParams.width = iM9450;
        layoutParams.height = iM9449;
        C2579.f9597 = iM9449;
        C2579.f9598 = iM9450;
        ViewGroup.LayoutParams layoutParams2 = this.f430.f13658.getLayoutParams();
        if (C4792.m14375().m14498()) {
            layoutParams2.width = this.f435;
            layoutParams2.height = this.f436;
        } else {
            layoutParams2.width = this.f435;
            layoutParams2.height = this.f436;
        }
        this.f430.f13658.setLayoutParams(layoutParams2);
        this.f430.f13658.setAlpha(0.0f);
        this.f437.setLayoutParams(layoutParams);
        this.f430.f13669.m2852();
        this.f430.f13668.m2877(C4792.m14375().m14498());
        m963();
        m1107();
        m960();
        m1128();
        if (C4792.m14375().m14498()) {
            m1086();
            m972();
            m1144();
        } else {
            m972();
            m1086();
            m1007();
        }
        this.f430.f13659.setOnClickListener(new ViewOnClickListenerC0155());
        this.f430.f13659.setVisibility(8);
        m1113();
    }

    /* renamed from: ࡀ, reason: contains not printable characters */
    public final void m1096() {
        this.f460.post(new RunnableC0213());
    }

    /* renamed from: ࡋ, reason: contains not printable characters */
    public final void m1097() {
        if (!r1.m8144(C5049.m14852().m14856())) {
            this.f431.mo10476(false);
        } else if (this.f440 != 1) {
            this.f431.mo10476(true);
        } else {
            this.f431.mo10476(false);
        }
    }

    /* renamed from: उ, reason: contains not printable characters */
    public final void m1098() {
        SecondScreenPresenter secondScreenPresenter = this.f537;
        if (secondScreenPresenter != null) {
            secondScreenPresenter.release();
            this.f537 = null;
            this.f437.m2023(null);
        }
    }

    /* renamed from: ग, reason: contains not printable characters */
    public final void m1099(float f) {
        this.f431.mo10553(f);
    }

    /* renamed from: ट, reason: contains not printable characters */
    public void m1100() {
        m1098();
    }

    /* renamed from: न, reason: contains not printable characters */
    public final void m1101() {
        C3828 c3828M11224;
        C3891 c3891M13890 = C4535.m13880().m13890();
        C3828 c3828M112242 = C3444.m11224(this.f565 ? c3891M13890.m12399() : c3891M13890.m12380());
        if (!c3828M112242.m12143()) {
            if (this.f565) {
                c3828M11224 = C3444.m11224("3");
                c3891M13890.m12515("3");
            } else {
                c3828M11224 = C3444.m11224("0");
                c3891M13890.m12503("0");
            }
            c3828M112242 = c3828M11224;
        }
        C3444.m11233(c3828M112242.m12137());
        this.f437.setCaptureListener(new C0301());
    }

    /* renamed from: ऩ, reason: contains not printable characters */
    public final void m1102(C3891 c3891) {
        m1132();
        m1074(c3891);
    }

    /* renamed from: प, reason: contains not printable characters */
    public final void m1103(boolean z) {
        if (z) {
            this.f467 = false;
            TransmitHelper.getInstance().setStartCameraTransmit(this.f467);
        }
        TransmitHelper.getInstance().setConnectionNum(0);
        TransmitHelper.getInstance().setConnectionUnit("");
        TransmitHelper.getInstance().setWifiStatus(5);
        ((C3295) this.f431).m11170(false, 0, "", 5);
        if (ACHelper.getInstance().playerDeviceIconChangeListener != null) {
            ACHelper.getInstance().playerDeviceIconChangeListener.onChange();
        }
        this.f543 = false;
        stopNSDServer();
        ConnectionManager.getInstance().stopPush();
        m995(false);
    }

    /* renamed from: ऱ, reason: contains not printable characters */
    public final boolean m1104() {
        if (C4112.m13056()) {
            return true;
        }
        this.f583 = 8;
        if (this.f428) {
            return false;
        }
        m1000(8);
        return false;
    }

    /* renamed from: ऽ, reason: contains not printable characters */
    public final int m1105() {
        ArrayList<v5> arrayListM11248 = C3444.m11227().m11248();
        int type = 0;
        for (int i = 0; i < arrayListM11248.size(); i++) {
            v5 v5Var = arrayListM11248.get(i);
            if (v5Var.isSelected()) {
                type = v5Var.getType();
            }
        }
        return type;
    }

    /* renamed from: ग़, reason: contains not printable characters */
    public final void m1106() throws JSONException {
        int i = this.f439;
        if (i != 1) {
            return;
        }
        this.f439 = 0;
        String cameraID = this.f437.getCameraID();
        C3891 c3891M13890 = C4535.m13880().m13890();
        String strM12137 = C2520.m9312().m9315().m12137();
        String strM121372 = C2520.m9312().m9316().m12137();
        if (strM12137.equals(cameraID) || C2520.m9312().m9325(cameraID) || C2520.m9312().m9326(cameraID) || C2520.m9312().m9324(cameraID) || C2520.m9312().m9327(cameraID)) {
            if (!C2520.m9312().m9320()) {
                this.f439 = i;
                return;
            }
            c3891M13890.m12503("1");
            m1087(false);
            this.f431.mo10609(C2520.m9312().m9316());
            m1016(strM121372);
            C4535.m13880().m13915();
            return;
        }
        if (!strM121372.equals(cameraID) && !C2520.m9312().m9328(cameraID)) {
            if (!C2520.m9312().m9320()) {
                this.f439 = i;
                return;
            }
            m1087(false);
            this.f431.mo10609(C2520.m9312().m9316());
            m1016(strM121372);
            c3891M13890.m12503("1");
            C4535.m13880().m13915();
            return;
        }
        if (!C2520.m9312().m9322()) {
            this.f439 = i;
            return;
        }
        c3891M13890.m12503("0");
        m1087(false);
        m1016(C2520.m9312().m9313(strM12137, C3947.m12727().m12733()));
        this.f431.mo10609(C2520.m9312().m9315());
        C4535.m13880().m13915();
    }

    /* renamed from: ॸ, reason: contains not printable characters */
    public final void m1107() {
        if (C2618.m9565("mode_hint_sp", false)) {
            this.f430.f13669.setVisibility(8);
        } else {
            this.f430.f13669.setVisibility(0);
            this.f430.f13669.m2857();
        }
        this.f430.f13669.setOnCloseListener(new C0277());
    }

    /* renamed from: ঀ, reason: contains not printable characters */
    public final void m1108() {
        this.f431.mo10573();
    }

    /* renamed from: ঢ, reason: contains not printable characters */
    public final void m1109(DecoderParamsBean decoderParamsBean) {
        if (C4112.m13054()) {
            C3151.m10755(this, false).m10757(new C0210());
            C3151.m10755(this, false).m10758();
        }
        this.f544 = true;
        m1094();
        this.f543 = true;
        m1141(decoderParamsBean);
    }

    /* renamed from: ণ, reason: contains not printable characters */
    public final void m1110() {
        if (C4112.m13056()) {
            this.f437.mo1967();
            this.f437.setVisibility(4);
        }
    }

    /* renamed from: দ, reason: contains not printable characters */
    public final void m1111() {
        this.f430.f13663.setVisibility(0);
        this.f430.f13663.setAlpha(0.0f);
        this.f430.f13663.m2908(6, null);
        C4008.m12876(this.f430.f13663, 1.0f, 100, null);
    }

    /* renamed from: ঽ, reason: contains not printable characters */
    public final void m1112() {
        n.m7588().m7602(new C0248());
    }

    /* renamed from: ৎ, reason: contains not printable characters */
    public final void m1113() {
        this.f463 = new DecoderParamsBean(2130708361, 2000000, 30, 1, LogType.UNEXP_ANR, 720, "video/hevc");
        this.f464 = new DecoderParamsBean(2130708361, 3000000, 30, 1, DPXReader.TVINFO_OFFSET, 1080, "video/hevc");
        this.f465 = new DecoderParamsBean(2130708361, 1000000, 30, 1, LogType.UNEXP_ANR, 720, "video/hevc");
    }

    /* renamed from: ઙ, reason: contains not printable characters */
    public final void m1114(int i) {
        C4689.m14213(this).m14230(C4792.m14375().m14498());
        C4689.m14213(this).m14232(this, new C0230(i));
    }

    /* renamed from: ડ, reason: contains not printable characters */
    public final void m1115(List<FilterBean> list) {
        long jCurrentTimeMillis = this.f429 ? System.currentTimeMillis() : 0L;
        C5244 c5244M13180 = C4151.m13162().m13180();
        List<C2531> listM13179 = C4151.m13162().m13179();
        boolean zM1138 = m1138(list);
        C4638.m14101("WME", "currentLutHasUpdate: " + zM1138);
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c5244M13180 != null) {
            String strM15270 = c5244M13180.m15270();
            String strM15267 = c5244M13180.m15267();
            String strM15269 = c5244M13180.m15269();
            Gson gson = new Gson();
            List<FilterGroupBean> list2 = (List) gson.fromJson(strM15270, new C0224().getType());
            List<FilterBean> list3 = (List) gson.fromJson(strM15267, new C0225().getType());
            List<FilterGroupCollectionBean> list4 = (List) gson.fromJson(strM15269, new C0226().getType());
            if (r1.m8144(list4)) {
                if (c3891M13890.m12442() != C4511.m13838().m13850(listM13179, c3891M13890, list2, list3, list4, 0)) {
                    m1102(c3891M13890);
                } else if (zM1138) {
                    m1164();
                }
                int iM13176 = C4151.m13162().m13176();
                if (iM13176 != 2 && iM13176 != 3) {
                    this.f431.mo10578();
                }
            } else {
                m1102(c3891M13890);
            }
        } else {
            this.f431.mo10579();
        }
        m1140(0, C4535.m13880().m13890().m12442(), 0);
        if (this.f429) {
            C4638.m14101("WME", "time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    /* renamed from: દ, reason: contains not printable characters */
    public final void m1116(AbstractC2341.C2344 c2344) throws Throwable {
        m973(c2344);
        m1040(c2344, false);
    }

    /* renamed from: ન, reason: contains not printable characters */
    public final void m1117(C2628 c2628, C3286 c3286) {
        c2628.m9661(c3286.m11047());
        c2628.m9662(c3286.m10997());
        c2628.m9664(c3286.m11000());
        c2628.m9663(c3286.m10999());
        c2628.m9655(c3286.m10991());
        c2628.m9651(c3286.m10986());
        c2628.m9650(c3286.m10985());
        c2628.m9675(c3286.m11011());
        c2628.m9648(c3286.m10983());
        c2628.m9660(c3286.m10995());
        c2628.m9671(c3286.m11007());
        c2628.m9656(c3286.m10992());
        c2628.m9676(c3286.m11012());
        c2628.m9670(c3286.m11006());
        c2628.m9667(c3286.m11003());
        c2628.m9672(c3286.m11008());
        c2628.m9668(c3286.m11004());
        c2628.m9652(c3286.m10987());
        c2628.m9669(c3286.m11005());
        c2628.m9653(c3286.m10988());
        c2628.m9673(c3286.m11009());
        c2628.m9654(c3286.m10989());
        c2628.m9647(c3286.m10982());
        c2628.m9665(c3286.m11001());
        c2628.m9646(c3286.m10981());
        c2628.m9666(c3286.m11002());
        c2628.m9657(c3286.m10993());
        c2628.m9659(c3286.m10994());
        c2628.m9649(c3286.m10984());
        c2628.m9645(c3286.m10979());
        c2628.m9674(c3286.m11010());
        C5049.m14852().m14860(c2628);
    }

    /* renamed from: ર, reason: contains not printable characters */
    public final void m1118() {
        n.m7588().m7599(new C0212(), true, ACHelper.getInstance().getRoomId());
    }

    /* renamed from: ઽ, reason: contains not printable characters */
    public final void m1119(float f, float f2, long j) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.f496 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(j);
        this.f496.setInterpolator(C4008.m12881());
        this.f496.addUpdateListener(new C0287());
        this.f496.addListener(new C0288());
        this.f496.start();
    }

    /* renamed from: ஈ, reason: contains not printable characters */
    public final void m1120() {
        this.f431.mo10612(0);
        this.f431.mo10591(true);
    }

    /* renamed from: ட, reason: contains not printable characters */
    public final void m1121() {
        this.f431.mo10618();
    }

    /* renamed from: ர, reason: contains not printable characters */
    public final void m1122(boolean z) {
        this.f443 = 0L;
        this.f446 = 0.0f;
        if (C3444.m11227().m11259()) {
            this.f460.removeMessages(103);
        } else {
            this.f460.removeMessages(102);
        }
        this.f431.mo10529(0L, 0, false);
        m991(true);
        ConnectionManager.getInstance().setRecording(false);
        m986();
        m1060(this.f472);
        this.f431.mo10590();
        this.f431.mo10634(false);
        if (z) {
            return;
        }
        this.f437.m1974(false);
    }

    /* renamed from: ಽ, reason: contains not printable characters */
    public void m1123() {
        if (e5.m5988().m5993()) {
            return;
        }
        C2764.m10018().m10045();
    }

    /* renamed from: ട, reason: contains not printable characters */
    public final void m1124(boolean z) {
        C4689.m14213(this).m14230(C4792.m14375().m14498());
        C4689.m14213(this).m14233(new C0231(z), new C0232());
    }

    /* renamed from: റ, reason: contains not printable characters */
    public final void m1125(boolean z, boolean z2) {
        if (!z) {
            if (this.f467) {
                return;
            }
            ConnectionManager.getInstance().releaseSrt();
            stopNSDFinder();
            m1067();
            return;
        }
        if (!this.f467 || z2) {
            if (ConnectionManager.getInstance().srtNull()) {
                startNSDFinder();
                if (!ConnectionManager.getInstance().initSrt()) {
                    C4638.m14101("FilmHomeActivity", "initSrt failed");
                    C4638.m14101("FilmHomeActivity", "retry initSrt :" + ConnectionManager.getInstance().initSrt());
                }
            }
            m1010();
        }
    }

    /* renamed from: ง, reason: contains not printable characters */
    public final void m1126() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        List<Fragment> fragments = supportFragmentManager.getFragments();
        if (r1.m8144(fragments)) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof C3744) {
                    supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                }
            }
        }
    }

    /* renamed from: ร, reason: contains not printable characters */
    public final void m1127(boolean z) {
        this.f431.mo10569(z);
    }

    /* renamed from: ว, reason: contains not printable characters */
    public final void m1128() {
        C4567.m14006().m14018(new C0160());
    }

    /* renamed from: ฯ, reason: contains not printable characters */
    public final void m1129() {
        this.f431.mo10547();
    }

    /* renamed from: ะ, reason: contains not printable characters */
    public final boolean m1130() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12429 = c3891M13890.m12429();
        int iM12478 = c3891M13890.m12478();
        if (iM12429 != 0) {
            return true;
        }
        return C2813.f10275 && iM12478 != 0;
    }

    /* renamed from: โ, reason: contains not printable characters */
    public final void m1131() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f430.f13658.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = C2579.f9594;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C2579.f9593;
        this.f430.f13658.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f430.f13664.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = C2579.f9598;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = C2579.f9597;
        this.f430.f13664.setLayoutParams(layoutParams2);
    }

    /* renamed from: ใ, reason: contains not printable characters */
    public final void m1132() {
        C4535.m13880().m13907();
        this.f475 = false;
        this.f480 = false;
        if (C2764.m10018().m10029() != 0) {
            C2764.m10018().m10045();
        }
    }

    /* renamed from: ไ, reason: contains not printable characters */
    public void m1133() {
        runOnUiThread(new RunnableC0358());
    }

    /* renamed from: ຈ, reason: contains not printable characters */
    public final void m1134(boolean z) {
        this.f431.mo10567(z);
    }

    /* renamed from: ບ, reason: contains not printable characters */
    public final boolean m1135(float f) {
        return Math.round(f) != 0;
    }

    /* renamed from: ວ, reason: contains not printable characters */
    public final void m1136(int i) throws JSONException {
        this.f575 = true;
        if (FilmApp.m405().m407() && "alert".equals(C2618.m9569("first_request_alert_sp", ""))) {
            if (this.f473 || !C4112.m13056()) {
                return;
            }
            this.f473 = true;
            m976();
            return;
        }
        SettingHintDialog settingHintDialog = this.f430.f13670;
        settingHintDialog.m2906(i);
        C2618.m9573("first_request_alert_sp", "alert");
        settingHintDialog.setOnButtonClick(new C0336(settingHintDialog));
        settingHintDialog.setAlpha(0.0f);
        settingHintDialog.m2908(i, null);
        C4008.m12876(settingHintDialog, 1.0f, 100, new C0338());
    }

    /* renamed from: ະ, reason: contains not printable characters */
    public final void m1137() {
        if (this.f447 == 0.0f && this.f448 == 0.0f) {
            return;
        }
        C4008.m12880(0.0f, 1.0f, 200L, new C0321());
    }

    /* renamed from: ຳ, reason: contains not printable characters */
    public final boolean m1138(List<FilterBean> list) {
        boolean z = false;
        if (r1.m8144(list)) {
            ArrayList<h0> arrayListM11244 = C3444.m11227().m11244();
            if (r1.m8144(arrayListM11244)) {
                h0 h0Var = arrayListM11244.get(this.f431.mo10515());
                if (r1.m8142(h0Var) && h0Var.m6136() != 0) {
                    List<FilterUIBean> listM6126 = h0Var.m6126();
                    ArrayList arrayList = new ArrayList();
                    Iterator<FilterUIBean> it = listM6126.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(it.next().getFilterBean().getId()));
                    }
                    if (r1.m8144(arrayList)) {
                        Iterator<FilterBean> it2 = list.iterator();
                        while (it2.hasNext()) {
                            if (arrayList.contains(Integer.valueOf(it2.next().getId()))) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: ཀ, reason: contains not printable characters */
    public final void m1139(boolean z, C4852.InterfaceC4855 interfaceC4855) {
        if (C3947.m12727().m12758() != 1) {
            if (interfaceC4855 != null) {
                interfaceC4855.onFinish();
            }
        } else if (z) {
            C4852.m14581().m14582(this, "protake_bleep_on.wav", interfaceC4855);
        } else {
            C4852.m14581().m14582(this, "protake_bleep_off.wav", interfaceC4855);
        }
    }

    /* renamed from: ཁ, reason: contains not printable characters */
    public final void m1140(int i, int i2, int i3) {
        this.f431.mo10481(i, i2, i3);
    }

    /* renamed from: ག, reason: contains not printable characters */
    public final void m1141(DecoderParamsBean decoderParamsBean) {
        FinderManager.getInstance().startNSDServer(this, new C0211(decoderParamsBean));
    }

    /* renamed from: ཅ, reason: contains not printable characters */
    public final void m1142() {
        this.f431.mo10503();
    }

    /* renamed from: ཆ, reason: contains not printable characters */
    public final boolean m1143(float f) {
        return Math.round(f) != 100;
    }

    /* renamed from: ཇ, reason: contains not printable characters */
    public final void m1144() {
        AbstractC5160 abstractC5160 = this.f431;
        if (abstractC5160 != null && abstractC5160 == this.f432) {
            m1086();
        }
        AbstractC5160 abstractC51602 = this.f431;
        if (abstractC51602 == null || abstractC51602 != this.f433) {
            this.f433 = new C2970();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fcallback", this.f542);
            this.f433.setArguments(bundle);
            this.f431 = this.f433;
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, this.f431).commitAllowingStateLoss();
        }
    }

    /* renamed from: ཊ, reason: contains not printable characters */
    public final void m1145() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12460 = c3891M13890.m12460();
        this.f472 = iM12460;
        m1060(iM12460);
        m1129();
        m1134(m988());
        m1127(m1178());
        boolean z = this.f472 == 1;
        this.f431.mo10613(z);
        if (z) {
            C3444.m11227().m11265(false);
            c3891M13890.m12556(false);
            C4535.m13880().m13915();
        }
        if (C3444.m11227().m11256()) {
            this.f431.mo10603(C4792.m14375().m14414());
            SecondScreenPresenter secondScreenPresenter = this.f537;
            if (secondScreenPresenter != null) {
                secondScreenPresenter.setHomeRatioCoverCropAlpha(C4792.m14375().m14414());
                return;
            }
            return;
        }
        this.f431.mo10603(C4792.m14375().m14413());
        SecondScreenPresenter secondScreenPresenter2 = this.f537;
        if (secondScreenPresenter2 != null) {
            secondScreenPresenter2.setHomeRatioCoverCropAlpha(C4792.m14375().m14413());
        }
    }

    /* renamed from: ཋ, reason: contains not printable characters */
    public final void m1146(boolean z, int i) {
        if (C3947.m12727().m12764()) {
            m1009(z, i);
        } else {
            m1165(z, i);
        }
    }

    /* renamed from: ཌ, reason: contains not printable characters */
    public final boolean m1147(boolean z) throws JSONException {
        if (!FilmApp.m405().m408()) {
            return true;
        }
        if (!C4112.m13056() && FilmApp.m405().m408() && z && (!this.f580)) {
            this.f580 = true;
            m1136(34);
            return false;
        }
        if (!C4112.m13055() && FilmApp.m405().m408() && z && (!this.f581)) {
            this.f581 = true;
            m1136(35);
            return false;
        }
        if (C4112.m13057() || !FilmApp.m405().m408() || !z || !(!this.f582)) {
            return true;
        }
        this.f582 = true;
        m1136(36);
        return false;
    }

    /* renamed from: ཎ, reason: contains not printable characters */
    public void m1148(boolean z) {
        this.f431.mo10638(z);
    }

    /* renamed from: ཏ, reason: contains not printable characters */
    public final void m1149() {
        this.f434.m11998();
        getSupportFragmentManager().beginTransaction().hide(this.f434).show(this.f432).commitAllowingStateLoss();
    }

    /* renamed from: ཐ, reason: contains not printable characters */
    public final void m1150() {
        m1011();
        if (this.f481 == 1 && C4535.m13880().m13890().m12460() != 1) {
            this.f482 = 2.37f;
        } else if (this.f481 != 2 || C4535.m13880().m13890().m12460() == 1) {
            this.f482 = 1.7777778f;
        } else {
            this.f482 = 2.76f;
        }
    }

    /* renamed from: ད, reason: contains not printable characters */
    public final IntentFilter m1151() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        return intentFilter;
    }

    /* renamed from: ན, reason: contains not printable characters */
    public final void m1152() {
        this.f444 = this.f437.getTargetVideoFps();
        boolean zM11259 = C3444.m11227().m11259();
        this.f472 = C4535.m13880().m13890().m12460();
        if (zM11259) {
            this.f524 = this.f437.getTimeLapseTimeMs();
            this.f460.sendEmptyMessage(103);
        } else {
            this.f460.sendEmptyMessage(102);
        }
        this.f431.mo10592();
        this.f431.mo10634(true);
        this.f512 = false;
    }

    /* renamed from: པ, reason: contains not printable characters */
    public final void m1153(boolean z, int i) {
        if (this.f429) {
            C4638.m14099("slim", "source:" + i);
        }
        boolean zM12765 = C3947.m12727().m12765();
        this.f431.mo10533();
        if (zM12765) {
            if (z && this.f439 == 1) {
                if (this.f437.getIso() != 0 || this.f437.getTime() != 0) {
                    this.f437.m2007();
                }
                if (this.f437.getmEVPercent() != C3947.m12727().m12734() || this.f437.getSelectedExp() != ((int) C3947.m12727().m12744())) {
                    this.f437.m2012((int) C3947.m12727().m12744(), C3947.m12727().m12734());
                }
            }
            this.f431.mo10475(true);
            this.f431.mo10480(true);
            this.f431.mo10607(-1);
            this.f431.mo10619(-1);
            this.f431.mo10471(1.0f);
        } else {
            this.f431.mo10607(-1);
            this.f431.mo10619(-1);
            this.f431.mo10475(false);
            this.f431.mo10480(false);
            this.f431.mo10471(0.2f);
            float fM12738 = C3947.m12727().m12738();
            float fM12735 = C3947.m12727().m12735();
            if (z && this.f439 == 1) {
                int i2 = (int) fM12738;
                if (i2 != this.f437.getIso() || this.f437.getTime() != ((long) (fM12735 * Math.pow(10.0d, 9.0d)))) {
                    this.f437.m1973(i2, fM12735);
                }
                if (this.f437.getmEVPercent() != 0.5f || this.f437.getSelectedExp() != 0) {
                    this.f437.m2012(0, 0.5f);
                }
            }
        }
        C4535.m13880().m13915();
    }

    /* renamed from: ཕ, reason: contains not printable characters */
    public final void m1154(boolean z, int i) {
        this.f431.mo10508(z, i);
    }

    /* renamed from: བ, reason: contains not printable characters */
    public final void m1155(int i) {
        m981(i, -1);
    }

    /* renamed from: མ, reason: contains not printable characters */
    public final void m1156(int i) {
        SubscribeInfoCallback subscribeInfoCallbackM7605 = n.m7588().m7605();
        C4757.m14304().m14323(i, this, subscribeInfoCallbackM7605.getSub_gplay_id(), subscribeInfoCallbackM7605.getSub_hms_id(), new C0250(subscribeInfoCallbackM7605));
    }

    /* renamed from: ཙ, reason: contains not printable characters */
    public final void m1157() {
        n.m7588().m7604(null);
        n.m7588().m7596(null);
        n.m7588().m7594(new C0327());
        int iM13176 = C4151.m13162().m13176();
        m1082((iM13176 == 3 || iM13176 == 4) ? false : true);
    }

    /* renamed from: ཚ, reason: contains not printable characters */
    public final void m1158() {
        if (this.f565) {
            m1062(true);
        } else {
            m1062(false);
        }
    }

    /* renamed from: ཛ, reason: contains not printable characters */
    public final boolean m1159(int i) {
        if (i == 0) {
            return false;
        }
        C5244 c5244M13180 = C4151.m13162().m13180();
        if (r1.m8137(c5244M13180)) {
            return true;
        }
        String strM15270 = c5244M13180.m15270();
        if (!r1.m8143(strM15270)) {
            return true;
        }
        for (FilterGroupBean filterGroupBean : (List) new Gson().fromJson(strM15270, new C0214().getType())) {
            if (filterGroupBean.getId() == i && C4136.m13108().m13109(filterGroupBean.getFilters())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ཝ, reason: contains not printable characters */
    public final void m1160() {
        if (!this.f565) {
            if (this.f439 == 1) {
                m1071();
            }
            m1154(true, 100);
            this.f431.mo10523();
            this.f460.postDelayed(new RunnableC0279(), 100L);
            m1069(-1);
            String cameraID = this.f437.getCameraID();
            if (!C2520.m9312().m9315().m12137().equals(cameraID) && !C2520.m9312().m9316().m12137().equals(cameraID)) {
                this.f431.mo10609(C2520.m9312().m9315());
            }
            float[] fArrMo10516 = this.f431.mo10516();
            this.f437.m2006(fArrMo10516[0], fArrMo10516[1]);
            return;
        }
        this.f431.mo10633(false, 100);
        this.f431.mo10526(-1, 0, 100);
        m1154(false, 100);
        this.f460.postDelayed(new RunnableC0278(), 100L);
        this.f431.mo10502();
        if (this.f439 == 1) {
            if (C3947.m12727().m12765()) {
                m1071();
            } else {
                m998(false);
            }
            m1019();
            this.f437.m1975(0.0f, C3947.m12727().m12754(C3947.m12727().m12742()));
            float fM12736 = C3947.m12727().m12736();
            if (fM12736 > 1.0f || fM12736 < 0.0f) {
                this.f437.m1972(-1.0f);
            } else {
                this.f437.m1972(C3947.m12727().m12756(fM12736));
            }
        }
        int iM11253 = C3444.m11227().m11253();
        if (iM11253 == 9) {
            iM11253 = 2;
        }
        this.f437.m2046(iM11253, null);
        m1069(this.f585);
        Iterator<C3828> it = C3444.m11230().iterator();
        while (it.hasNext()) {
            C3828 next = it.next();
            if (next.m12142()) {
                this.f431.mo10609(next);
                return;
            }
        }
    }

    /* renamed from: ཟ, reason: contains not printable characters */
    public void m1161() {
        m1180();
    }

    /* renamed from: ཡ, reason: contains not printable characters */
    public final void m1162() {
        this.f431.mo10560(this.f493);
    }

    /* renamed from: ལ, reason: contains not printable characters */
    public final void m1163(float f) {
        this.f431.mo10555(f);
        if (f <= 1.0f && f >= 0.0f) {
            float fM12756 = C3947.m12727().m12756(f);
            if (this.f429) {
                C4638.m14099("slimmm", "realFocusPByPro:" + fM12756 + " pro:" + f);
            }
            if (fM12756 != this.f437.getFocusPercent()) {
                this.f437.m1972(fM12756);
            }
        } else if ((f == 1.25f || f == -0.25f) && -1.0f != this.f437.getFocusPercent()) {
            this.f437.m1972(-1.0f);
        }
        m1099(f);
    }

    /* renamed from: ཤ, reason: contains not printable characters */
    public final void m1164() {
        this.f437.m2064(new RunnableC0334(true));
        C2650.m9790(new RunnableC0335(true));
    }

    /* renamed from: ཥ, reason: contains not printable characters */
    public final void m1165(boolean z, int i) {
        List<Float> listM12745 = C3947.m12727().m12745();
        if (r1.m8144(listM12745)) {
            float fFloatValue = listM12745.get(0).floatValue();
            float fFloatValue2 = listM12745.get(listM12745.size() - 1).floatValue();
            float f = fFloatValue - fFloatValue2;
            float fM12743 = C3947.m12727().m12743((C3947.m12727().m12735() - fFloatValue2) / f);
            float fM12755 = C3947.m12727().m12755(Math.min(1.0f, Math.max(0.0f, z ? (C4567.f15620 * i) + fM12743 : fM12743 - (C4567.f15620 * i))));
            float f2 = fFloatValue2 + (f * fM12755);
            float f3 = 360.0f * f2;
            float fM12747 = C3947.m12727().m12747() * f3;
            int iM12471 = C4535.m13880().m13890().m12471();
            if (iM12471 != 0) {
                fM12747 = C3947.m12727().m12760(iM12471) * f3;
            }
            C3947.m12727().m12784(f2);
            C3947.m12727().m12788(fM12747);
            this.f431.mo10536(fM12743);
            this.f431.mo10619(C4792.m14375().m14431());
            this.f431.mo10607(-1);
            m1121();
            this.f431.mo10577();
            this.f431.mo10620(fM12755);
            if (this.f439 == 1) {
                this.f437.m1973((int) C3947.m12727().m12738(), C3947.m12727().m12735());
            }
        }
    }

    /* renamed from: ས, reason: contains not printable characters */
    public final void m1166(boolean z, int i) {
        float fM12738 = C3947.m12727().m12738();
        int iM12751 = C3947.m12727().m12751();
        int iM12752 = C3947.m12727().m12752();
        int i2 = iM12751 - iM12752;
        float f = iM12752;
        float f2 = i2;
        float fM12750 = C3947.m12727().m12750(((fM12738 - f) * 1.0f) / f2);
        C3947.m12727().m12787((C3947.m12727().m12757(Math.min(1.0f, Math.max(0.0f, z ? (C4567.f15620 * i) + fM12750 : fM12750 - (C4567.f15620 * i)))) * f2) + f);
        this.f431.mo10535(fM12750);
        this.f431.mo10607(C4792.m14375().m14431());
        this.f431.mo10619(-1);
        m1030();
        this.f431.mo10561();
        if (this.f439 == 1) {
            this.f437.m1973((int) fM12738, C3947.m12727().m12735());
        }
    }

    /* renamed from: ཫ, reason: contains not printable characters */
    public final void m1167() {
        this.f531.m1906(new C0325());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019a  */
    /* renamed from: ྊ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1168(boolean r10, int r11) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 525
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.home.HomeActivity.m1168(boolean, int):void");
    }

    /* renamed from: ဂ, reason: contains not printable characters */
    public final int m1169() {
        return Math.min(LinkManager.getInstance().getClientListSize(), 8);
    }

    /* renamed from: င, reason: contains not printable characters */
    public final void m1170() {
        this.f431.mo10525();
    }

    /* renamed from: ဎ, reason: contains not printable characters */
    public final void m1171(float f, float f2, boolean z, boolean z2) {
        this.f460.removeMessages(109);
        this.f567 = this.f566;
        this.f571 = this.f569;
        this.f570 = this.f568;
        this.f431.mo10631(f, f2, z, z2);
    }

    /* renamed from: ပ, reason: contains not printable characters */
    public final void m1172() {
        n.m7588().m7590(new C0326());
    }

    /* renamed from: ဝ, reason: contains not printable characters */
    public final void m1173() {
        C4638.m14099("slimmm", "55555");
        this.f430.f13675.setVisibility(0);
        this.f430.f13675.setAlpha(0.0f);
        this.f430.f13675.m2908(19, null);
        this.f430.f13675.setOnButtonClick(new C0256());
        C4008.m12876(this.f430.f13675, 1.0f, 100, null);
    }

    /* renamed from: ၐ, reason: contains not printable characters */
    public final void m1174() {
        runOnUiThread(new RunnableC0315());
    }

    /* renamed from: ၑ, reason: contains not printable characters */
    public final void m1175(String str) {
        this.f430.f13665.m2580(str, false);
        this.f550 = System.currentTimeMillis();
        if (!this.f494) {
            this.f494 = true;
            this.f497 = false;
            m982(0.0f, 1.0f, this.f551);
            return;
        }
        this.f460.removeMessages(201);
        ValueAnimator valueAnimator = this.f495;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f497 = true;
        }
        ValueAnimator valueAnimator2 = this.f496;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f498 = true;
        }
        this.f497 = false;
        m982(0.0f, 1.0f, 0L);
    }

    /* renamed from: ၒ, reason: contains not printable characters */
    public final void m1176(int i) {
        ViewGroup.LayoutParams layoutParams = this.f430.f13671.getLayoutParams();
        if (C4792.m14375().m14498()) {
            int iM9438 = C2579.f9600 - C2579.m9438(50.0f);
            layoutParams.width = iM9438;
            int i2 = (int) (iM9438 * 1.2f);
            layoutParams.height = i2;
            if (i2 > C2579.f9599 - C2579.m9438(20.0f)) {
                layoutParams.height = C2579.f9599 - C2579.m9438(20.0f);
            }
        } else {
            layoutParams.height = ((int) (C2579.f9600 * 0.7f)) + C2579.m9438(45.0f);
            int i3 = C2579.f9599;
            int i4 = (int) (i3 * 0.6f);
            layoutParams.width = i4;
            if (i4 > i3 - C2579.m9438(20.0f)) {
                layoutParams.width = C2579.f9599 - C2579.m9438(20.0f);
            }
        }
        this.f430.f13671.setLayoutParams(layoutParams);
        this.f430.f13672.m2984(layoutParams.width, layoutParams.height);
        this.f430.f13672.setShowType(i == 5 ? 0 : 1);
        this.f430.f13672.m2985(new C0145(i));
        this.f430.f13659.setVisibility(0);
        this.f430.f13671.setAlpha(0.0f);
        this.f430.f13671.setVisibility(0);
        C4008.m12876(this.f430.f13671, 1.0f, 100, null);
    }

    /* renamed from: Ⴄ, reason: contains not printable characters */
    public final void m1177() {
        this.f431.mo10572();
    }

    /* renamed from: Ⴈ, reason: contains not printable characters */
    public final boolean m1178() {
        return !(C4535.m13880().m13890().m12460() == 1);
    }

    /* renamed from: Ⴡ, reason: contains not printable characters */
    public final boolean m1179() {
        if (C4112.m13055()) {
            return true;
        }
        this.f583 = 9;
        if (this.f428) {
            return false;
        }
        m1000(9);
        return false;
    }

    /* renamed from: ა, reason: contains not printable characters */
    public final void m1180() {
        this.f537 = SecondScreenPresenter.getInstance(this, C4535.m13880().m13902());
        SecondScreenPresenter.getInstance(this, C4535.m13880().m13902()).setEnable(C4535.m13880().m13902());
        this.f437.m2023(this.f537);
        this.f537.setScreenOrientation(C2579.m9446(this));
        this.f537.onResume();
    }
}
