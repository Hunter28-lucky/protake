package com.blink.academy.film.player;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.android.billingclient.api.Purchase;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.base.BaseActivity;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.home.HomeActivity;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.CacheHuaweiBean;
import com.blink.academy.film.netbean.CachePlayStoreBean;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.store.NvtProductItem;
import com.blink.academy.film.netbean.store.SubscribeInfoCallback;
import com.blink.academy.film.player.jz.cn.jzvd.Jzvd;
import com.blink.academy.film.player.view.FilmPlayer;
import com.blink.academy.film.player.view.FootagePanel;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.ConnectionManager;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.stream.LinkEntity;
import com.blink.academy.film.stream.NetInfoBean;
import com.blink.academy.film.stream.PingHelper;
import com.blink.academy.film.support.controller.PayController;
import com.blink.academy.film.support.pay.google.GooglePayHelper;
import com.blink.academy.film.support.pay.huawei.HuaweiPay;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.SubscribeDialog;
import com.blink.academy.film.widgets.TagView;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;
import com.blink.academy.film.widgets.dialog.login.PrivacyWebView;
import com.blink.academy.protake.R;
import com.google.gson.Gson;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.uc.crashsdk.export.LogType;
import defpackage.AbstractC3958;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C2612;
import defpackage.C2618;
import defpackage.C2628;
import defpackage.C2813;
import defpackage.C3088;
import defpackage.C3180;
import defpackage.C3184;
import defpackage.C3608;
import defpackage.C3617;
import defpackage.C3659;
import defpackage.C3688;
import defpackage.C3703;
import defpackage.C3744;
import defpackage.C3891;
import defpackage.C4008;
import defpackage.C4041;
import defpackage.C4151;
import defpackage.C4272;
import defpackage.C4320;
import defpackage.C4400;
import defpackage.C4535;
import defpackage.C4567;
import defpackage.C4638;
import defpackage.C4689;
import defpackage.C4757;
import defpackage.C4792;
import defpackage.C4843;
import defpackage.C5049;
import defpackage.C5202;
import defpackage.C5213;
import defpackage.C5299;
import defpackage.ComponentCallbacks2C3498;
import defpackage.InterfaceC3866;
import defpackage.InterfaceC4172;
import defpackage.InterfaceC4875;
import defpackage.InterfaceC4886;
import defpackage.c9;
import defpackage.e5;
import defpackage.j;
import defpackage.n;
import defpackage.o3;
import defpackage.r1;
import defpackage.z0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.containers.dpx.DPXReader;

/* loaded from: classes.dex */
public class PlayerActivity extends BaseActivity {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3958 f1011;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f1012;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4272 f1013;

    /* renamed from: ֏, reason: contains not printable characters */
    public C3744 f1018;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f1021;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f1022;

    /* renamed from: ނ, reason: contains not printable characters */
    public C3703 f1023;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f1024;

    /* renamed from: ބ, reason: contains not printable characters */
    public ValueAnimator f1025;

    /* renamed from: ޅ, reason: contains not printable characters */
    public boolean f1026;

    /* renamed from: ކ, reason: contains not printable characters */
    public ValueAnimator f1027;

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f1028;

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f1029;

    /* renamed from: މ, reason: contains not printable characters */
    public long f1030;

    /* renamed from: ފ, reason: contains not printable characters */
    public NvtProductItem f1031;

    /* renamed from: ގ, reason: contains not printable characters */
    public List<C5202> f1035;

    /* renamed from: ޏ, reason: contains not printable characters */
    public LinearLayoutManager f1036;

    /* renamed from: ސ, reason: contains not printable characters */
    public DecoderParamsBean f1037;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f1038;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f1039;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f1040;

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean f1041;

    /* renamed from: ޕ, reason: contains not printable characters */
    public long f1042;

    /* renamed from: ޖ, reason: contains not printable characters */
    public long f1043;

    /* renamed from: ޘ, reason: contains not printable characters */
    public int f1045;

    /* renamed from: ޙ, reason: contains not printable characters */
    public int f1046;

    /* renamed from: ޚ, reason: contains not printable characters */
    public int f1047;

    /* renamed from: ޜ, reason: contains not printable characters */
    public boolean f1049;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f1014 = -1;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f1015 = false;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f1016 = 500;

    /* renamed from: ֈ, reason: contains not printable characters */
    public WeakHandler f1017 = new WeakHandler(new C0469());

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f1019 = false;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f1020 = false;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f1032 = 0;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f1033 = 0;

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean f1034 = false;

    /* renamed from: ޗ, reason: contains not printable characters */
    public int f1044 = 100;

    /* renamed from: ޛ, reason: contains not printable characters */
    public int f1048 = 0;

    /* renamed from: com.blink.academy.film.player.PlayerActivity$Ϳ, reason: contains not printable characters */
    public class C0450 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$Ϳ$Ϳ, reason: contains not printable characters */
        public class C0451 extends AbstractC4012 {
            public C0451() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PlayerActivity.this.f1011.f13725.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$Ϳ$Ԩ, reason: contains not printable characters */
        public class C0452 extends AbstractC4012 {
            public C0452() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PlayerActivity.this.f1011.f13725.setVisibility(8);
            }
        }

        public C0450() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            C4008.m12876(PlayerActivity.this.f1011.f13725, 0.0f, 100, new C0452());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            C4008.m12876(PlayerActivity.this.f1011.f13725, 0.0f, 100, new C0451());
            PlayerActivity.this.m1529();
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$Ԩ, reason: contains not printable characters */
    public class C0453 extends CallBack<String> {
        public C0453() {
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

    /* renamed from: com.blink.academy.film.player.PlayerActivity$Ԫ, reason: contains not printable characters */
    public class DialogInterfaceOnDismissListenerC0454 implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC0454() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$Ԭ, reason: contains not printable characters */
    public class C0455 extends CallBack<UserBean> {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$Ԭ$Ϳ, reason: contains not printable characters */
        public class RunnableC0456 implements Runnable {
            public RunnableC0456() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zM5993 = e5.m5988().m5993();
                if (PlayerActivity.this.f1024 != 2 || zM5993) {
                    if (PlayerActivity.this.f1024 == 3) {
                        if (PlayerActivity.this.f1018 != null) {
                            PlayerActivity.this.f1018.m12023();
                        }
                    } else if (PlayerActivity.this.f1024 == 4) {
                        PlayerActivity.this.m1504();
                        PlayerActivity.this.m1543(1);
                    }
                    if (zM5993 && PlayerActivity.this.f1011.f13726 != null) {
                        PlayerActivity.this.f1011.f13726.m2583();
                    }
                } else {
                    PlayerActivity.this.m1542();
                }
                if (PlayerActivity.this.f1018 != null) {
                    PlayerActivity.this.f1018.m12013();
                }
                PlayerActivity.this.m1532(zM5993);
            }
        }

        public C0455() {
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
            PlayerActivity.this.runOnUiThread(new RunnableC0456());
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$Ԯ, reason: contains not printable characters */
    public class C0457 implements C3703.InterfaceC3719 {
        public C0457() {
        }

        @Override // defpackage.C3703.InterfaceC3719
        /* renamed from: Ϳ */
        public void mo1355() {
            if (C4843.m14569().m14572() && C4843.m14569().m14571()) {
                PlayerActivity.this.m1544(false);
            } else if (C4843.m14569().m14570() == 1) {
                PlayerActivity.this.m1507(2);
            } else if (C4843.m14569().m14570() == 2) {
                PlayerActivity.this.m1507(4);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ՠ, reason: contains not printable characters */
    public class C0458 implements InterfaceC3866 {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ՠ$Ϳ, reason: contains not printable characters */
        public class C0459 implements n.InterfaceC2190 {
            public C0459() {
            }

            @Override // defpackage.n.InterfaceC2190
            public void onFail() {
            }

            @Override // defpackage.n.InterfaceC2190
            public void onSuc() {
                ACHelper.getInstance().onNeedRefreshTime();
            }
        }

        public C0458() {
        }

        @Override // defpackage.InterfaceC3866
        /* renamed from: Ϳ */
        public void mo1315() {
            n.m7588().m7594(new C0459());
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ֈ, reason: contains not printable characters */
    public class C0460 implements InterfaceC4886 {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ֈ$Ϳ, reason: contains not printable characters */
        public class C0461 implements InterfaceC3866 {

            /* renamed from: com.blink.academy.film.player.PlayerActivity$ֈ$Ϳ$Ϳ, reason: contains not printable characters */
            public class C0462 implements n.InterfaceC2190 {
                public C0462() {
                }

                @Override // defpackage.n.InterfaceC2190
                public void onFail() {
                }

                @Override // defpackage.n.InterfaceC2190
                public void onSuc() {
                    ACHelper.getInstance().onNeedRefreshTime();
                }
            }

            public C0461() {
            }

            @Override // defpackage.InterfaceC3866
            /* renamed from: Ϳ */
            public void mo1315() {
                n.m7588().m7594(new C0462());
            }
        }

        public C0460() {
        }

        @Override // defpackage.InterfaceC4886
        public void onQueryPurchases(List<Purchase> list) {
            if (r1.m8144(list)) {
                C4638.m14104("bozai", "本地有待消费的订单   " + list);
                C4757.m14304().m14306(PlayerActivity.this, list, new C0461());
            }
        }

        @Override // defpackage.InterfaceC4886
        public void onQueryPurchasesFail(int i) {
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$֏, reason: contains not printable characters */
    public class C0463 implements C4689.InterfaceC4697 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f1063;

        public C0463(int i) {
            this.f1063 = i;
        }

        @Override // defpackage.C4689.InterfaceC4697
        /* renamed from: Ϳ */
        public void mo1331(int i) {
            PlayerActivity.this.m1508(i, this.f1063);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ׯ, reason: contains not printable characters */
    public class C0464 implements C4757.InterfaceC4768 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f1065;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ int f1066;

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ׯ$Ϳ, reason: contains not printable characters */
        public class RunnableC0465 implements Runnable {

            /* renamed from: com.blink.academy.film.player.PlayerActivity$ׯ$Ϳ$Ϳ, reason: contains not printable characters */
            public class C0466 implements n.InterfaceC2190 {
                public C0466() {
                }

                @Override // defpackage.n.InterfaceC2190
                public void onFail() {
                }

                @Override // defpackage.n.InterfaceC2190
                public void onSuc() {
                    ACHelper.getInstance().onNeedRefreshTime();
                }
            }

            public RunnableC0465() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1022 = false;
                j.m7057(C0464.this.f1065);
                C3617.m11671(PlayerActivity.this).m11673();
                C4689.m14213(PlayerActivity.this).m14222();
                PlayerActivity.this.m1537(true);
                C0464 c0464 = C0464.this;
                if (c0464.f1066 == 1) {
                    if (PlayerActivity.this.f1018 != null) {
                        PlayerActivity.this.f1018.m11997();
                    }
                    n.m7588().m7594(new C0466());
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ׯ$Ԩ, reason: contains not printable characters */
        public class RunnableC0467 implements Runnable {
            public RunnableC0467() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1022 = false;
                C3617.m11671(PlayerActivity.this).m11673();
                C4689.m14213(PlayerActivity.this).m14222();
            }
        }

        public C0464(int i, int i2) {
            this.f1065 = i;
            this.f1066 = i2;
        }

        @Override // defpackage.C4757.InterfaceC4768
        public void onFail() {
            PlayerActivity.this.f1022 = false;
            C3617.m11671(PlayerActivity.this).m11673();
        }

        @Override // defpackage.C4757.InterfaceC4768
        /* renamed from: Ϳ */
        public void mo437() {
            PlayerActivity.this.runOnUiThread(new RunnableC0467());
        }

        @Override // defpackage.C4757.InterfaceC4768
        /* renamed from: Ԩ */
        public void mo438() {
            PlayerActivity.this.f1017.post(new RunnableC0465());
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ؠ, reason: contains not printable characters */
    public class C0468 implements C4689.InterfaceC4697 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1071;

        public C0468(boolean z) {
            this.f1071 = z;
        }

        @Override // defpackage.C4689.InterfaceC4697
        /* renamed from: Ϳ */
        public void mo1331(int i) {
            if (this.f1071) {
                C4689.m14213(PlayerActivity.this).m14222();
                PlayerActivity.this.m1528(i == 2 ? 1 : 2);
            } else if (i == 2) {
                PlayerActivity.this.m1507(2);
            } else if (i == 4) {
                PlayerActivity.this.m1507(4);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ހ, reason: contains not printable characters */
    public class C0469 implements Handler.Callback {
        public C0469() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 100) {
                if (!PlayerActivity.this.f1015 || !PlayerActivity.this.f1011.f13712.m1594() || PlayerActivity.this.f1011.f13712.m1593()) {
                    return false;
                }
                PlayerActivity.this.f1011.f13712.startButton.performClick();
                return false;
            }
            if (i != 201) {
                return false;
            }
            if (!PlayerActivity.this.f1029) {
                PlayerActivity.this.m1510(0.0f, 0.0f, 0L);
                return false;
            }
            PlayerActivity.this.m1510(1.0f, 0.0f, r5.f1016);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ށ, reason: contains not printable characters */
    public class C0470 implements C4689.InterfaceC4696 {
        public C0470() {
        }

        @Override // defpackage.C4689.InterfaceC4696
        /* renamed from: Ϳ */
        public void mo1332() {
            PlayerActivity.this.f1011.f13726.m2594(false);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ނ, reason: contains not printable characters */
    public class C0471 extends CallBack<String> {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ނ$Ϳ, reason: contains not printable characters */
        public class RunnableC0472 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ ApiException f1076;

            public RunnableC0472(ApiException apiException) {
                this.f1076 = apiException;
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1011.f13726.m2594(false);
                if (C3703.m11871(this.f1076.getCode())) {
                    C3659.m11744().m11745(1);
                }
                PlayerActivity.this.m1537(true);
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ނ$Ԩ, reason: contains not printable characters */
        public class RunnableC0473 implements Runnable {
            public RunnableC0473() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1011.f13726.m2594(false);
                C3659.m11744().m11745(0);
                PlayerActivity.this.m1537(true);
            }
        }

        public C0471() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            PlayerActivity.this.f1017.post(new RunnableC0472(apiException));
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            PlayerActivity.this.f1017.post(new RunnableC0473());
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ރ, reason: contains not printable characters */
    public class C0474 extends CallBack<String> {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ރ$Ϳ, reason: contains not printable characters */
        public class RunnableC0475 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ ApiException f1080;

            public RunnableC0475(ApiException apiException) {
                this.f1080 = apiException;
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1011.f13726.m2594(false);
                if (C3703.m11871(this.f1080.getCode())) {
                    C3659.m11744().m11745(1);
                }
                PlayerActivity.this.m1537(true);
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ރ$Ԩ, reason: contains not printable characters */
        public class RunnableC0476 implements Runnable {
            public RunnableC0476() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1011.f13726.m2594(false);
                C3659.m11744().m11745(0);
                PlayerActivity.this.m1537(true);
            }
        }

        public C0474() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            PlayerActivity.this.f1017.post(new RunnableC0475(apiException));
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            PlayerActivity.this.f1017.post(new RunnableC0476());
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ބ, reason: contains not printable characters */
    public class RunnableC0477 implements Runnable {
        public RunnableC0477() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerActivity.this.f1011.f13726.m2594(false);
            PlayerActivity.this.m1537(true);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޅ, reason: contains not printable characters */
    public class C0478 implements C3608.InterfaceC3610 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1084;

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޅ$Ϳ, reason: contains not printable characters */
        public class RunnableC0479 implements Runnable {
            public RunnableC0479() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C2618.m9572("last_net_time_sp", System.currentTimeMillis());
                C2618.m9572("last_net_error_time_sp", 0L);
                C2618.m9570("show_one_week_hint_sp", false);
                if (e5.m5988().m5993()) {
                    PlayerActivity.this.m1532(true);
                } else if (e5.m5988().m5993() != C0478.this.f1084) {
                    C4151.m13162().m13168();
                }
            }
        }

        public C0478(boolean z) {
            this.f1084 = z;
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ϳ */
        public void mo1336() {
            PlayerActivity.this.runOnUiThread(new RunnableC0479());
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ԩ */
        public void mo1337() {
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: ԩ */
        public void mo1338(int i) {
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ކ, reason: contains not printable characters */
    public class C0480 implements InterfaceC4875 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SubscribeInfoCallback f1087;

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ކ$Ϳ, reason: contains not printable characters */
        public class RunnableC0481 implements Runnable {
            public RunnableC0481() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1011.f13726.m2594(false);
            }
        }

        public C0480(SubscribeInfoCallback subscribeInfoCallback) {
            this.f1087 = subscribeInfoCallback;
        }

        @Override // defpackage.InterfaceC4875
        /* renamed from: Ϳ */
        public void mo1309(int i) {
            PlayerActivity.this.f1017.post(new RunnableC0481());
        }

        @Override // defpackage.InterfaceC4875
        /* renamed from: Ԩ */
        public void mo1310(Purchase purchase) {
            C2618.m9573("local_sub_pus_sp", new Gson().toJson(purchase));
            C2618.m9573("local_sub_id_sp", this.f1087.getSub_gplay_id());
            C3659.m11744().m11751(0);
            PlayerActivity.this.m1525();
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$އ, reason: contains not printable characters */
    public class C0482 implements n.InterfaceC2190 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f1090;

        /* renamed from: com.blink.academy.film.player.PlayerActivity$އ$Ϳ, reason: contains not printable characters */
        public class RunnableC0483 implements Runnable {
            public RunnableC0483() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1011.f13726.m2595(null, C0482.this.f1090);
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$އ$Ԩ, reason: contains not printable characters */
        public class RunnableC0484 implements Runnable {
            public RunnableC0484() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1011.f13726.m2595(null, C0482.this.f1090);
            }
        }

        public C0482(int i) {
            this.f1090 = i;
        }

        @Override // defpackage.n.InterfaceC2190
        public void onFail() {
            PlayerActivity.this.runOnUiThread(new RunnableC0484());
        }

        @Override // defpackage.n.InterfaceC2190
        public void onSuc() {
            PlayerActivity.this.runOnUiThread(new RunnableC0483());
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ވ, reason: contains not printable characters */
    public class C0485 extends RecyclerView.OnScrollListener {
        public C0485() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                PlayerActivity.this.m1503();
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$މ, reason: contains not printable characters */
    public class C0486 implements InterfaceC4172 {
        public C0486() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ, reason: contains not printable characters */
        public void mo1558(int i) throws NumberFormatException {
            if (C5049.m14852().m14858()) {
                if (r1.m8144(PlayerActivity.this.f1035)) {
                    C5202 c5202 = (C5202) PlayerActivity.this.f1035.get(i);
                    c5202.m15174(true ^ c5202.m15172());
                    PlayerActivity.this.f1013.notifyItemChanged(i);
                    PlayerActivity.this.m1554();
                    if (PlayerActivity.this.f1048 != 5) {
                        PlayerActivity.this.f1048 = 5;
                        PlayerActivity.this.m1555();
                        return;
                    }
                    return;
                }
                return;
            }
            if (PlayerActivity.this.f1014 == i) {
                return;
            }
            if (r1.m8144(PlayerActivity.this.f1035)) {
                if (PlayerActivity.this.f1014 != -1) {
                    ((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).setSelected(false);
                }
                PlayerActivity.this.f1013.notifyItemChanged(PlayerActivity.this.f1014);
                PlayerActivity.this.f1014 = i;
                ((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).setSelected(true);
                PlayerActivity.this.f1013.notifyItemChanged(PlayerActivity.this.f1014);
                PlayerActivity.this.m1523();
            }
            PlayerActivity.this.f1015 = false;
            PlayerActivity.this.m1550();
        }

        @Override // defpackage.InterfaceC4172
        /* renamed from: ՠ, reason: contains not printable characters */
        public void mo1559(int i, int i2, Object obj) {
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ފ, reason: contains not printable characters */
    public class ViewOnClickListenerC0487 implements View.OnClickListener {
        public ViewOnClickListenerC0487() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ދ, reason: contains not printable characters */
    public class RunnableC0488 implements Runnable {
        public RunnableC0488() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerActivity.this.m1546();
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ތ, reason: contains not printable characters */
    public class ViewOnClickListenerC0489 implements View.OnClickListener {
        public ViewOnClickListenerC0489() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerActivity.this.m1511();
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ލ, reason: contains not printable characters */
    public class ViewOnClickListenerC0490 implements View.OnClickListener {
        public ViewOnClickListenerC0490() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayerActivity.this.f1012) {
                PlayerActivity.this.f1011.f13691.performClick();
            } else if (PlayerActivity.this.f1011.f13692.m1606()) {
                PlayerActivity.this.f1011.f13682.performClick();
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ގ, reason: contains not printable characters */
    public class ViewOnClickListenerC0491 implements View.OnClickListener {
        public ViewOnClickListenerC0491() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!PlayerActivity.this.f1011.f13692.m1606() && PlayerActivity.this.f1012) {
                PlayerActivity.this.f1011.f13691.performClick();
            }
            PlayerActivity.this.m1538(!r3.f1011.f13692.m1606(), 100);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޏ, reason: contains not printable characters */
    public class C0492 implements FootagePanel.InterfaceC0573 {
        public C0492() {
        }

        @Override // com.blink.academy.film.player.view.FootagePanel.InterfaceC0573
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1560(int i) throws NumberFormatException {
            PlayerActivity.this.m1531(i == 0);
            if (PlayerActivity.this.f1014 == -1 || !r1.m8144(PlayerActivity.this.f1035) || PlayerActivity.this.f1014 >= PlayerActivity.this.f1035.size()) {
                return;
            }
            float fM1513 = PlayerActivity.this.m1513(((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).m15171());
            if (PlayerActivity.this.f1011.f13712.m1593()) {
                if (fM1513 == 0.0f) {
                    fM1513 = 1.0f;
                }
                PlayerActivity.this.f1011.f13712.m1592(fM1513);
            }
            PlayerActivity.this.f1011.f13712.m1591(fM1513);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ސ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0493 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ސ$Ϳ, reason: contains not printable characters */
        public class RunnableC0494 implements Runnable {
            public RunnableC0494() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1011.f13705.setAlpha(1.0f);
                PlayerActivity.this.f1011.f13735.setAlpha(1.0f);
                PlayerActivity.this.f1011.f13695.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC0493() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!C2813.f10275) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                PlayerActivity.this.f1011.f13705.setAlpha(0.3f);
                PlayerActivity.this.f1011.f13735.setAlpha(0.3f);
                PlayerActivity.this.f1011.f13695.setAlpha(0.3f);
            } else if (action == 1 || action == 3) {
                new Handler(Looper.myLooper()).postDelayed(new RunnableC0494(), 100L);
            }
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޑ, reason: contains not printable characters */
    public class ViewOnClickListenerC0495 implements View.OnClickListener {
        public ViewOnClickListenerC0495() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerActivity.this.m1545();
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޒ, reason: contains not printable characters */
    public class ViewOnClickListenerC0496 implements View.OnClickListener {
        public ViewOnClickListenerC0496() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C5049.m14852().m14858()) {
                C5049.m14852().m14859(false);
                PlayerActivity.this.f1048 = 0;
                PlayerActivity.this.m1502();
                PlayerActivity.this.m1514();
                PlayerActivity.this.m1553();
                PlayerActivity.this.m1554();
                PlayerActivity.this.m1552();
                return;
            }
            C5049.m14852().m14859(true);
            PlayerActivity.this.m1552();
            PlayerActivity.this.m1554();
            if (PlayerActivity.this.f1013 != null) {
                PlayerActivity.this.f1013.notifyDataSetChanged();
            }
            if (PlayerActivity.this.f1012) {
                return;
            }
            PlayerActivity.this.m1539(true, 100);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޓ, reason: contains not printable characters */
    public class ViewOnClickListenerC0497 implements View.OnClickListener {
        public ViewOnClickListenerC0497() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerActivity.this.m1539(!r3.f1012, 100);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޔ, reason: contains not printable characters */
    public class ViewOnClickListenerC0498 implements View.OnClickListener {
        public ViewOnClickListenerC0498() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!C5049.m14852().m14858()) {
                if (PlayerActivity.this.f1014 == -1 || !r1.m8144(PlayerActivity.this.f1035) || PlayerActivity.this.f1014 >= PlayerActivity.this.f1035.size()) {
                    return;
                }
                if (PlayerActivity.this.f1015) {
                    PlayerActivity.this.f1015 = false;
                    if (PlayerActivity.this.f1011.f13712.m1594() && PlayerActivity.this.f1011.f13712.m1593()) {
                        PlayerActivity.this.f1011.f13712.startButton.performClick();
                    }
                    PlayerActivity.this.m1501();
                }
                PlayerActivity playerActivity = PlayerActivity.this;
                C4320.m13465(playerActivity, ((C5202) playerActivity.f1035.get(PlayerActivity.this.f1014)).m15171().m9592());
                return;
            }
            if (r1.m8144(PlayerActivity.this.f1035)) {
                if (PlayerActivity.this.f1015) {
                    PlayerActivity.this.f1015 = false;
                    if (PlayerActivity.this.f1011.f13712.m1594() && PlayerActivity.this.f1011.f13712.m1593()) {
                        PlayerActivity.this.f1011.f13712.startButton.performClick();
                    }
                    PlayerActivity.this.m1501();
                }
                ArrayList arrayList = new ArrayList();
                for (C5202 c5202 : PlayerActivity.this.f1035) {
                    if (c5202.m15172()) {
                        arrayList.add(c5202.m15171().m9592());
                    }
                }
                if (r1.m8144(arrayList)) {
                    j.m7060();
                    if (arrayList.size() > 1) {
                        C4320.m13466(PlayerActivity.this, arrayList);
                    } else {
                        C4320.m13465(PlayerActivity.this, (String) arrayList.get(0));
                    }
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޕ, reason: contains not printable characters */
    public class ViewOnClickListenerC0499 implements View.OnClickListener {
        public ViewOnClickListenerC0499() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            int i = 0;
            if (!C5049.m14852().m14858()) {
                if (PlayerActivity.this.f1014 != -1) {
                    if (PlayerActivity.this.f1015) {
                        PlayerActivity.this.f1015 = false;
                        if (PlayerActivity.this.f1011.f13712.m1594() && PlayerActivity.this.f1011.f13712.m1593()) {
                            PlayerActivity.this.f1011.f13712.startButton.performClick();
                        }
                        PlayerActivity.this.m1501();
                    }
                    PlayerActivity.this.m1540(false, 0);
                    return;
                }
                return;
            }
            if (PlayerActivity.this.f1015) {
                PlayerActivity.this.f1015 = false;
                if (PlayerActivity.this.f1011.f13712.m1594() && PlayerActivity.this.f1011.f13712.m1593()) {
                    PlayerActivity.this.f1011.f13712.startButton.performClick();
                }
                PlayerActivity.this.m1501();
            }
            Iterator it = PlayerActivity.this.f1035.iterator();
            while (it.hasNext()) {
                if (((C5202) it.next()).m15172()) {
                    i++;
                }
            }
            PlayerActivity.this.m1540(true, i);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޖ, reason: contains not printable characters */
    public class C0500 implements C4567.InterfaceC4572 {
        public C0500() {
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޗ, reason: contains not printable characters */
    public class C0501 implements c9.InterfaceC0057 {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޗ$Ϳ, reason: contains not printable characters */
        public class RunnableC0502 implements Runnable {
            public RunnableC0502() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerActivity.this.f1011.f13714.isEnabled()) {
                    PlayerActivity.this.f1011.f13714.performClick();
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޗ$Ԩ, reason: contains not printable characters */
        public class RunnableC0503 implements Runnable {
            public RunnableC0503() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerActivity.this.f1011.f13715.isEnabled()) {
                    PlayerActivity.this.f1011.f13715.performClick();
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޗ$Ԫ, reason: contains not printable characters */
        public class RunnableC0504 implements Runnable {
            public RunnableC0504() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerActivity.this.f1011.f13709.isEnabled()) {
                    PlayerActivity.this.f1011.f13709.performClick();
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޗ$Ԭ, reason: contains not printable characters */
        public class RunnableC0505 implements Runnable {
            public RunnableC0505() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerActivity.this.f1011.f13710.isEnabled()) {
                    PlayerActivity.this.f1011.f13710.performClick();
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޗ$Ԯ, reason: contains not printable characters */
        public class RunnableC0506 implements Runnable {
            public RunnableC0506() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerActivity.this.f1011.f13680.isEnabled()) {
                    PlayerActivity.this.f1011.f13680.performClick();
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޗ$ՠ, reason: contains not printable characters */
        public class RunnableC0507 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ boolean f1116;

            public RunnableC0507(boolean z) {
                this.f1116 = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.m1526(this.f1116, true);
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޗ$ֈ, reason: contains not printable characters */
        public class RunnableC0508 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ boolean f1118;

            public RunnableC0508(boolean z) {
                this.f1118 = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.m1526(this.f1118, false);
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޗ$֏, reason: contains not printable characters */
        public class RunnableC0509 implements Runnable {
            public RunnableC0509() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerActivity.this.f1011.f13680.isEnabled()) {
                    PlayerActivity.this.f1011.f13680.performClick();
                }
            }
        }

        public C0501() {
        }

        @Override // defpackage.c9.InterfaceC0057
        /* renamed from: Ϳ */
        public void mo262() {
            PlayerActivity.this.runOnUiThread(new RunnableC0506());
        }

        @Override // defpackage.c9.InterfaceC0057
        /* renamed from: Ԩ */
        public void mo263() {
            PlayerActivity.this.runOnUiThread(new RunnableC0504());
        }

        @Override // defpackage.c9.InterfaceC0057
        /* renamed from: ԩ */
        public void mo264() {
            PlayerActivity.this.runOnUiThread(new RunnableC0502());
        }

        @Override // defpackage.c9.InterfaceC0057
        /* renamed from: Ԫ */
        public void mo265() {
            PlayerActivity.this.runOnUiThread(new RunnableC0505());
        }

        @Override // defpackage.c9.InterfaceC0057
        /* renamed from: ԫ */
        public void mo266(boolean z) {
            PlayerActivity.this.runOnUiThread(new RunnableC0508(z));
        }

        @Override // defpackage.c9.InterfaceC0057
        /* renamed from: ԭ */
        public void mo267() {
            PlayerActivity.this.runOnUiThread(new RunnableC0503());
        }

        @Override // defpackage.c9.InterfaceC0057
        /* renamed from: Ԯ */
        public void mo268() {
            PlayerActivity.this.runOnUiThread(new RunnableC0509());
        }

        @Override // defpackage.c9.InterfaceC0057
        /* renamed from: ԯ */
        public void mo269(boolean z) {
            PlayerActivity.this.runOnUiThread(new RunnableC0507(z));
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޘ, reason: contains not printable characters */
    public class ViewOnClickListenerC0510 implements View.OnClickListener {
        public ViewOnClickListenerC0510() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerActivity.this.f1041 = !r2.f1041;
            PlayerActivity.this.m1524();
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޙ, reason: contains not printable characters */
    public class ViewOnClickListenerC0511 implements View.OnClickListener {
        public ViewOnClickListenerC0511() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws NumberFormatException {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - PlayerActivity.this.f1043 < PlayerActivity.this.f1044) {
                return;
            }
            PlayerActivity.this.f1043 = jCurrentTimeMillis;
            if (PlayerActivity.this.f1014 == -1 || !r1.m8144(PlayerActivity.this.f1035)) {
                return;
            }
            PlayerActivity.this.f1015 = !r7.f1015;
            PlayerActivity.this.m1501();
            PlayerActivity.this.f1044 = 100;
            if (PlayerActivity.this.f1015 && PlayerActivity.this.f1011.f13712.preloading) {
                PlayerActivity.this.f1011.f13712.preloading = false;
                PlayerActivity.this.f1011.f13712.state = 0;
                PlayerActivity.this.f1044 = 500;
            }
            if (PlayerActivity.this.f1015) {
                j.m7059();
            }
            if (PlayerActivity.this.f1011.f13712.m1594()) {
                if (!PlayerActivity.this.f1015) {
                    if (PlayerActivity.this.f1011.f13712.m1593()) {
                        PlayerActivity.this.f1011.f13712.startButton.performClick();
                    }
                } else {
                    if (PlayerActivity.this.f1011.f13712.m1593()) {
                        return;
                    }
                    PlayerActivity.this.f1011.f13712.startButton.performClick();
                    float fM1513 = PlayerActivity.this.m1513(((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).m15171());
                    if (fM1513 == 0.0f) {
                        fM1513 = 1.0f;
                    }
                    PlayerActivity.this.f1011.f13712.m1592(fM1513);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޚ, reason: contains not printable characters */
    public class ViewOnClickListenerC0512 implements View.OnClickListener {
        public ViewOnClickListenerC0512() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws NumberFormatException {
            if (r1.m8144(PlayerActivity.this.f1035)) {
                ((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).setSelected(false);
                PlayerActivity.this.f1013.notifyItemChanged(PlayerActivity.this.f1014);
                PlayerActivity.m1451(PlayerActivity.this);
                if (PlayerActivity.this.f1014 < 0) {
                    PlayerActivity.this.f1014 = 0;
                }
                ((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).setSelected(true);
                PlayerActivity.this.f1013.notifyItemChanged(PlayerActivity.this.f1014);
                PlayerActivity.this.m1550();
                PlayerActivity.this.m1523();
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޛ, reason: contains not printable characters */
    public class ViewOnClickListenerC0513 implements View.OnClickListener {
        public ViewOnClickListenerC0513() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws NumberFormatException {
            if (r1.m8144(PlayerActivity.this.f1035)) {
                boolean z = false;
                if (System.currentTimeMillis() - PlayerActivity.this.f1042 < 1000 || PlayerActivity.this.m1505()) {
                    ((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).setSelected(false);
                    PlayerActivity.this.f1013.notifyItemChanged(PlayerActivity.this.f1014);
                    PlayerActivity.m1450(PlayerActivity.this);
                    if (PlayerActivity.this.f1014 > PlayerActivity.this.f1035.size() - 1) {
                        PlayerActivity playerActivity = PlayerActivity.this;
                        playerActivity.f1014 = playerActivity.f1035.size() - 1;
                    } else {
                        z = true;
                    }
                    ((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).setSelected(true);
                    PlayerActivity.this.f1013.notifyItemChanged(PlayerActivity.this.f1014);
                    PlayerActivity.this.m1550();
                    if (z) {
                        PlayerActivity.this.m1523();
                    }
                } else if (PlayerActivity.this.f1014 != -1) {
                    ACHelper.getInstance().setAlbumPercent(0.0f);
                    ACHelper.getInstance().setAlbumControllState(PlayerActivity.this.f1021);
                    PlayerActivity.this.m1536("00:00:00");
                    PlayerActivity.this.f1011.f13723.setValueAndUpdateUI(0.0f);
                    PlayerActivity.this.f1011.f13712.m1595(0);
                }
                PlayerActivity.this.f1042 = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޜ, reason: contains not printable characters */
    public class ViewOnClickListenerC0514 implements View.OnClickListener {
        public ViewOnClickListenerC0514() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayerActivity.this.f1014 != -1) {
                PlayerActivity.this.m1506(1);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޝ, reason: contains not printable characters */
    public class ViewOnClickListenerC0515 implements View.OnClickListener {
        public ViewOnClickListenerC0515() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayerActivity.this.f1014 != -1) {
                PlayerActivity.this.m1506(2);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޞ, reason: contains not printable characters */
    public class ViewOnClickListenerC0516 implements View.OnClickListener {
        public ViewOnClickListenerC0516() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayerActivity.this.f1014 != -1) {
                PlayerActivity.this.m1506(0);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޟ, reason: contains not printable characters */
    public class C0517 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޟ$Ϳ, reason: contains not printable characters */
        public class C0518 extends AbstractC4012 {
            public C0518() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PlayerActivity.this.f1011.f13693.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޟ$Ԩ, reason: contains not printable characters */
        public class RunnableC0519 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ C5202 f1130;

            public RunnableC0519(C5202 c5202) {
                this.f1130 = c5202;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3180.m10795(this.f1130.m15171().m9592());
                C3180.m10795(this.f1130.m15171().m9634());
                C3180.m10795(this.f1130.m15171().m9635());
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޟ$Ԫ, reason: contains not printable characters */
        public class RunnableC0520 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ C5202 f1132;

            public RunnableC0520(C5202 c5202) {
                this.f1132 = c5202;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3180.m10795(this.f1132.m15171().m9592());
                C3180.m10795(this.f1132.m15171().m9634());
                C3180.m10795(this.f1132.m15171().m9635());
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޟ$Ԭ, reason: contains not printable characters */
        public class C0521 extends AbstractC4012 {
            public C0521() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PlayerActivity.this.f1011.f13693.setVisibility(8);
            }
        }

        public C0517() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            C4008.m12876(PlayerActivity.this.f1011.f13693, 0.0f, 100, new C0521());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) throws NumberFormatException {
            C4008.m12876(PlayerActivity.this.f1011.f13693, 0.0f, 100, new C0518());
            if (i == 5) {
                if (r1.m8144(PlayerActivity.this.f1035)) {
                    j.m7058();
                    Jzvd.backPress();
                    PlayerActivity.this.f1011.f13712.posterImageView.setVisibility(8);
                    if (PlayerActivity.this.f1014 != -1) {
                        C5202 c5202 = (C5202) PlayerActivity.this.f1035.remove(PlayerActivity.this.f1014);
                        C5049.m14852().m14854(c5202.m15171());
                        new Thread(new RunnableC0519(c5202)).start();
                    }
                    PlayerActivity.this.f1015 = false;
                    PlayerActivity.this.m1501();
                    PlayerActivity.this.f1011.f13723.setValueAndUpdateUI(0.0f);
                    PlayerActivity.this.m1535("");
                    if (!r1.m8144(PlayerActivity.this.f1035)) {
                        PlayerActivity.this.f1014 = -1;
                        PlayerActivity.this.m1536("00:00:00");
                        PlayerActivity.this.f1011.f13680.performClick();
                        return;
                    }
                    if (PlayerActivity.this.f1014 > 1) {
                        PlayerActivity.m1451(PlayerActivity.this);
                        ((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).setSelected(true);
                    } else {
                        ((C5202) PlayerActivity.this.f1035.get(0)).setSelected(true);
                        PlayerActivity.this.f1014 = 0;
                    }
                    PlayerActivity.this.m1523();
                    PlayerActivity.this.m1514();
                    PlayerActivity.this.m1515();
                    PlayerActivity.this.f1013.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (i == 13 && r1.m8144(PlayerActivity.this.f1035)) {
                Jzvd.backPress();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                boolean z = false;
                for (int i2 = 0; i2 < PlayerActivity.this.f1035.size(); i2++) {
                    C5202 c52022 = (C5202) PlayerActivity.this.f1035.get(i2);
                    if (c52022.m15172()) {
                        arrayList.add(c52022);
                        arrayList2.add(c52022.m15171());
                        if (i2 == PlayerActivity.this.f1014) {
                            z = true;
                        }
                        new Thread(new RunnableC0520(c52022)).start();
                    }
                }
                PlayerActivity.this.f1035.removeAll(arrayList);
                if (r1.m8144(arrayList2)) {
                    C5049.m14852().m14855(arrayList2);
                }
                PlayerActivity.this.f1015 = false;
                PlayerActivity.this.m1501();
                PlayerActivity.this.f1011.f13723.setValueAndUpdateUI(0.0f);
                PlayerActivity.this.m1535("");
                if (!r1.m8144(PlayerActivity.this.f1035)) {
                    PlayerActivity.this.f1014 = -1;
                    PlayerActivity.this.m1536("00:00:00");
                    PlayerActivity.this.f1011.f13680.performClick();
                    return;
                }
                if (z) {
                    PlayerActivity.this.f1011.f13712.posterImageView.setVisibility(8);
                    if (PlayerActivity.this.f1014 > 1) {
                        PlayerActivity.m1451(PlayerActivity.this);
                        if (PlayerActivity.this.f1014 > PlayerActivity.this.f1035.size() - 1) {
                            PlayerActivity playerActivity = PlayerActivity.this;
                            playerActivity.f1014 = playerActivity.f1035.size() - 1;
                        }
                        ((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).setSelected(true);
                    } else {
                        ((C5202) PlayerActivity.this.f1035.get(0)).setSelected(true);
                        PlayerActivity.this.f1014 = 0;
                    }
                    PlayerActivity.this.m1523();
                }
                if (!r1.m8144(PlayerActivity.this.f1035)) {
                    PlayerActivity.this.f1011.f13712.posterImageView.setVisibility(8);
                }
                PlayerActivity.this.f1048 = 5;
                PlayerActivity.this.m1555();
                PlayerActivity.this.m1514();
                PlayerActivity.this.m1515();
                PlayerActivity.this.m1554();
                PlayerActivity.this.f1013.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޠ, reason: contains not printable characters */
    public class C0522 implements FilmSeekBar.InterfaceC0896 {
        public C0522() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1561(float f, float f2) {
            PlayerActivity.this.f1011.f13712.m1595((int) f2);
            PlayerActivity.this.f1011.f13712.posterImageView.setVisibility(8);
            if (r1.m8144(PlayerActivity.this.f1035) && PlayerActivity.this.f1014 != -1) {
                long jM9591 = ((C5202) PlayerActivity.this.f1035.get(PlayerActivity.this.f1014)).m15171().m9591();
                if (jM9591 > 0) {
                    PlayerActivity playerActivity = PlayerActivity.this;
                    playerActivity.m1536(playerActivity.f1011.f13712.m1596((long) (jM9591 * f)));
                }
            }
            ACHelper.getInstance().setAlbumPercent(f);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޡ, reason: contains not printable characters */
    public class C0523 implements FilmPlayer.InterfaceC0566 {
        public C0523() {
        }

        @Override // com.blink.academy.film.player.view.FilmPlayer.InterfaceC0566
        public void onFinish() {
            PlayerActivity.this.f1015 = false;
            PlayerActivity.this.f1011.f13723.setValueAndUpdateUI(100.0f);
            ACHelper.getInstance().setAlbumPercent(1.0f);
            PlayerActivity.this.m1501();
        }

        @Override // com.blink.academy.film.player.view.FilmPlayer.InterfaceC0566
        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo1562() {
            return PlayerActivity.this.f1015;
        }

        @Override // com.blink.academy.film.player.view.FilmPlayer.InterfaceC0566
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1563(int i, String str) {
            if (PlayerActivity.this.f1011.f13723.m2303() || !PlayerActivity.this.f1015) {
                return;
            }
            if (!PlayerActivity.this.f1011.f13712.m1594()) {
                float f = i;
                ACHelper.getInstance().setAlbumPercent((1.0f * f) / 100.0f);
                PlayerActivity.this.f1011.f13723.setValueAndUpdateUI(f);
                PlayerActivity.this.m1536(str);
                return;
            }
            if (PlayerActivity.this.f1011.f13712.m1593()) {
                float f2 = i;
                PlayerActivity.this.f1011.f13723.setValueAndUpdateUI(f2);
                PlayerActivity.this.m1536(str);
                ACHelper.getInstance().setAlbumPercent((f2 * 1.0f) / 100.0f);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޢ, reason: contains not printable characters */
    public class ViewOnClickListenerC0524 implements View.OnClickListener {
        public ViewOnClickListenerC0524() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8144(PlayerActivity.this.f1035) && C5049.m14852().m14858()) {
                if (PlayerActivity.this.f1048 == 1) {
                    PlayerActivity.this.f1048 = 0;
                } else {
                    PlayerActivity.this.f1048 = 1;
                }
                PlayerActivity.this.m1555();
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޣ, reason: contains not printable characters */
    public class ViewOnClickListenerC0525 implements View.OnClickListener {
        public ViewOnClickListenerC0525() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8144(PlayerActivity.this.f1035) && C5049.m14852().m14858()) {
                if (PlayerActivity.this.f1048 == 2) {
                    PlayerActivity.this.f1048 = 0;
                } else {
                    PlayerActivity.this.f1048 = 2;
                }
                PlayerActivity.this.m1555();
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޤ, reason: contains not printable characters */
    public class ViewOnClickListenerC0526 implements View.OnClickListener {
        public ViewOnClickListenerC0526() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8144(PlayerActivity.this.f1035) && C5049.m14852().m14858()) {
                if (PlayerActivity.this.f1048 == 3) {
                    PlayerActivity.this.f1048 = 0;
                } else {
                    PlayerActivity.this.f1048 = 3;
                }
                PlayerActivity.this.m1555();
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޥ, reason: contains not printable characters */
    public class ViewOnClickListenerC0527 implements View.OnClickListener {
        public ViewOnClickListenerC0527() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8144(PlayerActivity.this.f1035) && C5049.m14852().m14858()) {
                if (PlayerActivity.this.f1048 == 4) {
                    PlayerActivity.this.f1048 = 0;
                } else {
                    PlayerActivity.this.f1048 = 4;
                }
                PlayerActivity.this.m1555();
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ޱ, reason: contains not printable characters */
    public class C0528 implements ACHelper.FilmAlbumCallback {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޱ$Ϳ, reason: contains not printable characters */
        public class RunnableC0529 implements Runnable {
            public RunnableC0529() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerActivity.this.f1011.f13712.m1594()) {
                    PlayerActivity.this.f1011.f13710.performClick();
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޱ$Ԩ, reason: contains not printable characters */
        public class RunnableC0530 implements Runnable {
            public RunnableC0530() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerActivity.this.f1011.f13715.isEnabled()) {
                    PlayerActivity.this.f1011.f13715.performClick();
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޱ$Ԫ, reason: contains not printable characters */
        public class RunnableC0531 implements Runnable {
            public RunnableC0531() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.m1527(false);
                ACHelper.getInstance().setAlbumControllState(PlayerActivity.this.f1021);
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޱ$Ԭ, reason: contains not printable characters */
        public class RunnableC0532 implements Runnable {
            public RunnableC0532() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.m1527(true);
                ACHelper.getInstance().setAlbumControllState(PlayerActivity.this.f1021);
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޱ$Ԯ, reason: contains not printable characters */
        public class RunnableC0533 implements Runnable {
            public RunnableC0533() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerActivity.this.f1011.f13709.isEnabled()) {
                    PlayerActivity.this.f1011.f13709.performClick();
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޱ$ՠ, reason: contains not printable characters */
        public class RunnableC0534 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f1147;

            public RunnableC0534(int i) {
                this.f1147 = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                switch (this.f1147) {
                    case 100:
                        if (PlayerActivity.this.f1014 != -1) {
                            PlayerActivity.this.m1506(0);
                            break;
                        }
                        break;
                    case 101:
                        if (PlayerActivity.this.f1014 != -1) {
                            PlayerActivity.this.m1506(1);
                            break;
                        }
                        break;
                    case 102:
                        if (PlayerActivity.this.f1014 != -1) {
                            PlayerActivity.this.m1506(2);
                            break;
                        }
                        break;
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ޱ$ֈ, reason: contains not printable characters */
        public class RunnableC0535 implements Runnable {
            public RunnableC0535() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Jzvd.backPress();
                PlayerActivity.this.m1511();
            }
        }

        public C0528() {
        }

        @Override // com.blink.academy.film.stream.ACHelper.FilmAlbumCallback
        public void onAlbumTagClickByClient(int i, LinkEntity linkEntity) {
            PlayerActivity.this.runOnUiThread(new RunnableC0534(i));
        }

        @Override // com.blink.academy.film.stream.ACHelper.FilmAlbumCallback
        public void onControlClickByClient(int i, LinkEntity linkEntity) {
            PlayerActivity.this.f1021 = ACHelper.getInstance().getAlbumControllState();
            ACHelper.getInstance().setAlbumControllState(3);
            if (i == -2) {
                PlayerActivity.this.runOnUiThread(new RunnableC0530());
                return;
            }
            if (i == -1) {
                PlayerActivity.this.runOnUiThread(new RunnableC0531());
            } else if (i == 1) {
                PlayerActivity.this.runOnUiThread(new RunnableC0532());
            } else {
                if (i != 2) {
                    return;
                }
                PlayerActivity.this.runOnUiThread(new RunnableC0533());
            }
        }

        @Override // com.blink.academy.film.stream.ACHelper.FilmAlbumCallback
        public void onModeChange(boolean z, LinkEntity linkEntity) {
            PlayerActivity.this.runOnUiThread(new RunnableC0535());
        }

        @Override // com.blink.academy.film.stream.ACHelper.FilmAlbumCallback
        public void onPlayClickByClient(boolean z, LinkEntity linkEntity) {
            PlayerActivity.this.runOnUiThread(new RunnableC0529());
        }

        @Override // com.blink.academy.film.stream.ACHelper.FilmAlbumCallback
        public boolean playing() {
            if (PlayerActivity.this.f1011.f13712.m1594()) {
                return PlayerActivity.this.f1011.f13712.m1593();
            }
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$߾, reason: contains not printable characters */
    public class RunnableC0536 implements Runnable {
        public RunnableC0536() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = PlayerActivity.this.f1011.f13732.getPaint().measureText(PlayerActivity.this.f1011.f13732.getText().toString().toUpperCase());
            ViewGroup.LayoutParams layoutParams = PlayerActivity.this.f1011.f13683.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + (PlayerActivity.this.f1045 * 2));
            PlayerActivity.this.f1011.f13683.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$߿, reason: contains not printable characters */
    public class C0537 implements ACHelper.OnDeviceInit {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$߿$Ϳ, reason: contains not printable characters */
        public class RunnableC0538 implements Runnable {
            public RunnableC0538() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C2813.f10275) {
                    PlayerActivity.this.f1011.f13705.setAlpha(1.0f);
                    PlayerActivity.this.f1011.f13735.setAlpha(1.0f);
                } else {
                    PlayerActivity.this.f1011.f13705.setAlpha(0.3f);
                    PlayerActivity.this.f1011.f13735.setAlpha(0.3f);
                }
            }
        }

        public C0537() {
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnDeviceInit
        public void onInit() {
            FilmApp.m405().m427(new RunnableC0538());
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡠ, reason: contains not printable characters */
    public class ViewOnClickListenerC0539 implements View.OnClickListener {
        public ViewOnClickListenerC0539() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡡ, reason: contains not printable characters */
    public class RunnableC0540 implements Runnable {
        public RunnableC0540() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = PlayerActivity.this.f1011.f13731.getPaint().measureText(PlayerActivity.this.getResources().getString(R.string.PLAYBACK_SELECT_ALL).toUpperCase());
            ViewGroup.LayoutParams layoutParams = PlayerActivity.this.f1011.f13731.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            PlayerActivity.this.f1011.f13731.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡢ, reason: contains not printable characters */
    public class RunnableC0541 implements Runnable {
        public RunnableC0541() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = PlayerActivity.this.f1011.f13732.getPaint().measureText(PlayerActivity.this.f1011.f13732.getText().toString().toUpperCase());
            ViewGroup.LayoutParams layoutParams = PlayerActivity.this.f1011.f13683.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + (PlayerActivity.this.f1045 * 2));
            PlayerActivity.this.f1011.f13683.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡣ, reason: contains not printable characters */
    public class C0542 implements ACHelper.PlayerDeviceIconChangeListener {
        public C0542() {
        }

        @Override // com.blink.academy.film.stream.ACHelper.PlayerDeviceIconChangeListener
        public void onChange() {
            int wifiViewLevelByLevel;
            if (!TransmitHelper.getInstance().isStartCameraTransmit()) {
                PlayerActivity.this.m1534(false, 0, "", 5);
                return;
            }
            NetInfoBean netInfoBean = ACHelper.getInstance().getNetInfoBean();
            if (netInfoBean == null) {
                netInfoBean = FinderManager.getInstance().getNetInfoBean();
            }
            if (netInfoBean != null) {
                wifiViewLevelByLevel = ACHelper.getInstance().getWifiViewLevelByLevel(netInfoBean.getWifiLevel());
            } else {
                wifiViewLevelByLevel = 1;
            }
            int hasConnectionNum = TransmitHelper.getInstance().getHasConnectionNum();
            String selectUnitString = TransmitHelper.getInstance().getSelectUnitString(TransmitHelper.getInstance().getConnectionUnitType());
            TransmitHelper.getInstance().setConnectionNum(hasConnectionNum);
            TransmitHelper.getInstance().setConnectionUnit(selectUnitString);
            TransmitHelper.getInstance().setWifiStatus(wifiViewLevelByLevel);
            PlayerActivity.this.m1534(true, hasConnectionNum, selectUnitString, wifiViewLevelByLevel);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡤ, reason: contains not printable characters */
    public class C0543 implements C3744.InterfaceC3749 {

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡤ$Ϳ, reason: contains not printable characters */
        public class C0544 extends AbstractC4012 {
            public C0544() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                List<Fragment> fragments = PlayerActivity.this.getSupportFragmentManager().getFragments();
                if (r1.m8144(fragments) && fragments.contains(PlayerActivity.this.f1018)) {
                    PlayerActivity.this.getSupportFragmentManager().beginTransaction().hide(PlayerActivity.this.f1018).commitAllowingStateLoss();
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡤ$Ԩ, reason: contains not printable characters */
        public class RunnableC0545 implements Runnable {
            public RunnableC0545() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1011.f13719.setKeepScreenOn(true);
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡤ$Ԫ, reason: contains not printable characters */
        public class RunnableC0546 implements Runnable {
            public RunnableC0546() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f1011.f13719.setKeepScreenOn(false);
            }
        }

        public C0543() {
        }

        @Override // defpackage.C3744.InterfaceC3749
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1564(NvtProductItem nvtProductItem) {
            PlayerActivity.this.f1031 = nvtProductItem;
            if (e5.m5988().m5994()) {
                PlayerActivity.this.m1504();
                PlayerActivity.this.m1543(1);
            } else if (FilmApp.m405().m430()) {
                PlayerActivity.this.m1547(4);
            } else {
                PlayerActivity.this.f1024 = 4;
                PlayerActivity.this.f1023.m11880(false);
            }
        }

        @Override // defpackage.C3744.InterfaceC3749
        /* renamed from: ֈ, reason: contains not printable characters */
        public void mo1565() {
            if (FilmApp.m405().m430()) {
                PlayerActivity.this.m1547(1);
            } else {
                PlayerActivity.this.f1024 = 1;
                PlayerActivity.this.f1023.m11880(false);
            }
        }

        @Override // defpackage.C3744.InterfaceC3749
        /* renamed from: ֏, reason: contains not printable characters */
        public void mo1566(int i, int i2, boolean z) {
            TransmitHelper.getInstance().setStartCameraTransmit(true);
            PlayerActivity.this.f1011.f13712.m1611(true);
            PlayerActivity.this.runOnUiThread(new RunnableC0545());
        }

        @Override // defpackage.C3744.InterfaceC3749
        /* renamed from: މ, reason: contains not printable characters */
        public void mo1567() {
            PlayerActivity.this.f1024 = 3;
            PlayerActivity.this.f1023.m11880(false);
        }

        @Override // defpackage.C3744.InterfaceC3749
        /* renamed from: ފ, reason: contains not printable characters */
        public void mo1568() {
            TransmitHelper.getInstance().setStartCameraTransmit(false);
            PlayerActivity.this.f1011.f13712.m1611(false);
            TransmitHelper.getInstance().setConnectionNum(0);
            TransmitHelper.getInstance().setConnectionUnit("");
            TransmitHelper.getInstance().setWifiStatus(5);
            PlayerActivity.this.m1534(false, 0, "", 5);
            PlayerActivity.this.runOnUiThread(new RunnableC0546());
        }

        @Override // defpackage.C3744.InterfaceC3749
        /* renamed from: ދ, reason: contains not printable characters */
        public void mo1569(int i, String str, boolean z) {
        }

        @Override // defpackage.C3744.InterfaceC3749
        /* renamed from: ތ, reason: contains not printable characters */
        public void mo1570() {
        }

        @Override // defpackage.C3744.InterfaceC3749
        /* renamed from: ލ, reason: contains not printable characters */
        public void mo1571() {
            C4008.m12877(PlayerActivity.this.f1011.f13720, 1.0f, 200, new C0544());
        }

        @Override // defpackage.C3744.InterfaceC3749
        /* renamed from: ގ, reason: contains not printable characters */
        public DecoderParamsBean mo1572() {
            return PlayerActivity.this.f1037;
        }

        @Override // defpackage.C3744.InterfaceC3749
        /* renamed from: ޏ, reason: contains not printable characters */
        public void mo1573() {
            PlayerActivity.this.m1533();
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡥ, reason: contains not printable characters */
    public class RunnableC0547 implements Runnable {
        public RunnableC0547() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4008.m12876(PlayerActivity.this.f1011.f13713, 1.0f, 200, null);
            z0.m8635(PlayerActivity.this);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡦ, reason: contains not printable characters */
    public class C0548 extends AbstractC4012 {
        public C0548() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            PlayerActivity.this.finish();
            PlayerActivity.this.overridePendingTransition(0, 0);
            if (HomeActivity.m700() != null) {
                HomeActivity.m700().m1021(false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡧ, reason: contains not printable characters */
    public class C0549 implements ValueAnimator.AnimatorUpdateListener {
        public C0549() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PlayerActivity.this.f1011.f13694.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡨ, reason: contains not printable characters */
    public class C0550 extends AnimatorListenerAdapter {
        public C0550() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            PlayerActivity.this.f1028 = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!PlayerActivity.this.f1028) {
                PlayerActivity.this.f1029 = false;
            }
            PlayerActivity.this.f1028 = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            PlayerActivity.this.f1028 = false;
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡩ, reason: contains not printable characters */
    public class C0551 implements ValueAnimator.AnimatorUpdateListener {
        public C0551() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PlayerActivity.this.f1011.f13694.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࡪ, reason: contains not printable characters */
    public class C0552 extends AnimatorListenerAdapter {
        public C0552() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            PlayerActivity.this.f1026 = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (PlayerActivity.this.f1026) {
                return;
            }
            PlayerActivity.this.f1026 = false;
            PlayerActivity.this.f1017.sendEmptyMessageDelayed(201, 1000L);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            PlayerActivity.this.f1026 = false;
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࢠ, reason: contains not printable characters */
    public class C0553 extends AbstractC4012 {
        public C0553() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            PlayerActivity.this.getSupportFragmentManager().beginTransaction().show(PlayerActivity.this.f1018).commitAllowingStateLoss();
            PlayerActivity.this.f1018.m12026();
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࢡ, reason: contains not printable characters */
    public class RunnableC0554 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f1168;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2628 f1169;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ HandlerThread f1170;

        public RunnableC0554(String str, C2628 c2628, HandlerThread handlerThread) {
            this.f1168 = str;
            this.f1169 = c2628;
            this.f1170 = handlerThread;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            String[] strArrSplit = this.f1168.split("/");
            if (strArrSplit.length >= 1) {
                String strM10791 = C3180.m10791(this.f1168, strArrSplit[strArrSplit.length - 1]);
                if (r1.m8143(strM10791)) {
                    this.f1169.m9641(strM10791);
                    C3184.m10827().m10865(this.f1169);
                }
            }
            this.f1170.quit();
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࢢ, reason: contains not printable characters */
    public class C0555 implements PrivacyWebView.InterfaceC1095 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f1172;

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ࢢ$Ϳ, reason: contains not printable characters */
        public class C0556 extends AbstractC4012 {
            public C0556() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PlayerActivity.this.f1011.f13716.setVisibility(8);
                C0555 c0555 = C0555.this;
                PlayerActivity.this.f1024 = c0555.f1172;
                C0555 c05552 = C0555.this;
                if (c05552.f1172 == 2) {
                    PlayerActivity.this.f1023.m11880(true);
                } else {
                    PlayerActivity.this.f1023.m11880(false);
                }
            }
        }

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ࢢ$Ԩ, reason: contains not printable characters */
        public class C0557 extends AbstractC4012 {
            public C0557() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PlayerActivity.this.f1011.f13716.setVisibility(8);
            }
        }

        public C0555(int i) {
            this.f1172 = i;
        }

        @Override // com.blink.academy.film.widgets.dialog.login.PrivacyWebView.InterfaceC1095
        public void onDisagree() {
            PlayerActivity.this.f1011.f13684.setVisibility(8);
            PlayerActivity.this.m1551(false);
            C4008.m12876(PlayerActivity.this.f1011.f13716, 0.0f, 100, new C0557());
        }

        @Override // com.blink.academy.film.widgets.dialog.login.PrivacyWebView.InterfaceC1095
        /* renamed from: Ϳ */
        public void mo1314(boolean z) {
            PlayerActivity.this.f1011.f13684.setVisibility(8);
            if (z) {
                C2618.m9571("privacy_alert_v_sp2", C2618.m9566("privacy_remote_v_sp", 1));
            } else {
                C2618.m9571("terms_alert_v_sp2", C2618.m9566("terms_remote_v_sp", 1));
            }
            PlayerActivity.this.m1551(true);
            C4008.m12876(PlayerActivity.this.f1011.f13716, 0.0f, 100, new C0556());
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࢣ, reason: contains not printable characters */
    public class C0558 extends OperationCallback<Void> {
        public C0558() {
        }

        @Override // com.mob.OperationCallback
        public void onFailure(Throwable th) {
        }

        @Override // com.mob.OperationCallback
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onComplete(Void r1) {
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࢤ, reason: contains not printable characters */
    public class C0559 implements SubscribeDialog.InterfaceC0965 {
        public C0559() {
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ϳ */
        public boolean mo1341() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԩ */
        public void mo1342() throws Resources.NotFoundException {
            C4320.m13462(PlayerActivity.this);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԩ */
        public void mo1343() {
            if (n.m7588().m7605() == null) {
                PlayerActivity.this.f1011.f13726.m2594(false);
                return;
            }
            if (C4843.m14569().m14572() && C4843.m14569().m14571()) {
                PlayerActivity.this.m1544(true);
            } else {
                PlayerActivity.this.m1528(C4843.m14569().m14570() != 1 ? 2 : 1);
            }
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԫ */
        public void mo1344() {
            if (e5.m5988().m5994()) {
                PlayerActivity.this.m1548();
            } else {
                if (FilmApp.m405().m430()) {
                    PlayerActivity.this.m1547(1);
                    return;
                }
                PlayerActivity.this.m1551(true);
                PlayerActivity.this.f1024 = 1;
                PlayerActivity.this.f1023.m11880(false);
            }
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԫ */
        public void mo1345() {
            boolean zM5994 = e5.m5988().m5994();
            if (zM5994) {
                if (!zM5994 || r1.m8137(n.m7588().m7605())) {
                    return;
                }
                PlayerActivity.this.m1542();
                return;
            }
            if (FilmApp.m405().m430()) {
                PlayerActivity.this.m1547(2);
                return;
            }
            PlayerActivity.this.m1551(true);
            PlayerActivity.this.f1024 = 2;
            PlayerActivity.this.f1023.m11880(true);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԭ */
        public void mo1346() {
            C4320.m13460(PlayerActivity.this);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԭ */
        public void mo1347() {
            C4320.m13461(PlayerActivity.this);
        }
    }

    /* renamed from: com.blink.academy.film.player.PlayerActivity$ࢥ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC0560 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f1178;

        /* renamed from: com.blink.academy.film.player.PlayerActivity$ࢥ$Ϳ, reason: contains not printable characters */
        public class RunnableC0561 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1179;

            public RunnableC0561(View view) {
                this.f1179 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1179.isEnabled()) {
                    ViewOnTouchListenerC0560.this.f1178.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0560(View view) {
            this.f1178 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f1178.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0561(view), 100L);
            return false;
        }
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static /* synthetic */ int m1450(PlayerActivity playerActivity) {
        int i = playerActivity.f1014;
        playerActivity.f1014 = i + 1;
        return i;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public static /* synthetic */ int m1451(PlayerActivity playerActivity) {
        int i = playerActivity.f1014;
        playerActivity.f1014 = i - 1;
        return i;
    }

    public final void initListener() {
        m1522();
        this.f1011.f13687.setOnClickListener(new ViewOnClickListenerC0487());
        this.f1011.f13680.setOnClickListener(new ViewOnClickListenerC0489());
        this.f1011.f13714.setOnClickListener(new ViewOnClickListenerC0490());
        this.f1011.f13682.setOnClickListener(new ViewOnClickListenerC0491());
        this.f1011.f13692.setOnSwitch(new C0492());
        this.f1011.f13734.setContentTypeFace(FilmApp.m403());
        AbstractC3958 abstractC3958 = this.f1011;
        abstractC3958.f13691.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC3958.f13701));
        AbstractC3958 abstractC39582 = this.f1011;
        abstractC39582.f13685.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC39582.f13697));
        AbstractC3958 abstractC39583 = this.f1011;
        abstractC39583.f13718.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC39583.f13707));
        AbstractC3958 abstractC39584 = this.f1011;
        abstractC39584.f13710.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC39584.f13704));
        AbstractC3958 abstractC39585 = this.f1011;
        abstractC39585.f13709.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC39585.f13703));
        AbstractC3958 abstractC39586 = this.f1011;
        abstractC39586.f13715.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC39586.f13706));
        TagView tagView = this.f1011.f13727;
        tagView.setOnTouchListener(new ViewOnTouchListenerC0560(tagView));
        TagView tagView2 = this.f1011.f13728;
        tagView2.setOnTouchListener(new ViewOnTouchListenerC0560(tagView2));
        TagView tagView3 = this.f1011.f13729;
        tagView3.setOnTouchListener(new ViewOnTouchListenerC0560(tagView3));
        AbstractC3958 abstractC39587 = this.f1011;
        abstractC39587.f13724.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC39587.f13708));
        AbstractC3958 abstractC39588 = this.f1011;
        abstractC39588.f13683.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC39588.f13732));
        AbstractC3958 abstractC39589 = this.f1011;
        abstractC39589.f13686.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC39589.f13731));
        AbstractC3958 abstractC395810 = this.f1011;
        abstractC395810.f13688.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC395810.f13698));
        AbstractC3958 abstractC395811 = this.f1011;
        abstractC395811.f13689.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC395811.f13699));
        AbstractC3958 abstractC395812 = this.f1011;
        abstractC395812.f13690.setOnTouchListener(new ViewOnTouchListenerC0560(abstractC395812.f13700));
        FrameLayout frameLayout = this.f1011.f13680;
        frameLayout.setOnTouchListener(new ViewOnTouchListenerC0560(frameLayout));
        this.f1011.f13730.setOnTouchListener(new ViewOnTouchListenerC0493());
        this.f1011.f13730.setOnClickListener(new ViewOnClickListenerC0495());
        this.f1011.f13683.setOnClickListener(new ViewOnClickListenerC0496());
        this.f1011.f13691.setOnClickListener(new ViewOnClickListenerC0497());
        this.f1011.f13724.setOnClickListener(new ViewOnClickListenerC0498());
        this.f1011.f13685.setOnClickListener(new ViewOnClickListenerC0499());
        this.f1011.f13718.setOnClickListener(new ViewOnClickListenerC0510());
        this.f1011.f13710.setOnClickListener(new ViewOnClickListenerC0511());
        this.f1011.f13709.setOnClickListener(new ViewOnClickListenerC0512());
        this.f1011.f13715.setOnClickListener(new ViewOnClickListenerC0513());
        this.f1011.f13728.setOnClickListener(new ViewOnClickListenerC0514());
        this.f1011.f13729.setOnClickListener(new ViewOnClickListenerC0515());
        this.f1011.f13727.setOnClickListener(new ViewOnClickListenerC0516());
        this.f1011.f13693.setOnButtonClick(new C0517());
        this.f1011.f13723.setOnProChange(new C0522());
        this.f1011.f13712.setOnProChange(new C0523());
        this.f1011.f13686.setOnClickListener(new ViewOnClickListenerC0524());
        this.f1011.f13688.setOnClickListener(new ViewOnClickListenerC0525());
        this.f1011.f13689.setOnClickListener(new ViewOnClickListenerC0526());
        this.f1011.f13690.setOnClickListener(new ViewOnClickListenerC0527());
        ACHelper.getInstance().setFilmAlbumCallback(new C0528());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        m1511();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1011.f13713.setAlpha(0.0f);
        m1519(false);
        this.f1017.postDelayed(new RunnableC0488(), 300L);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws NumberFormatException {
        super.onCreate(bundle);
        this.f1037 = new DecoderParamsBean();
        if (ACHelper.getInstance().getSelectDecoderParamsBean() != null) {
            ACHelper.getInstance().copyDecodeParamBean(ACHelper.getInstance().getSelectDecoderParamsBean(), this.f1037);
        } else {
            DecoderParamsBean decoderParamsBean = new DecoderParamsBean(2130708361, 2000000, 30, 1, LogType.UNEXP_ANR, 720, "video/hevc");
            DecoderParamsBean decoderParamsBean2 = new DecoderParamsBean(2130708361, 3000000, 30, 1, DPXReader.TVINFO_OFFSET, 1080, "video/hevc");
            DecoderParamsBean decoderParamsBean3 = new DecoderParamsBean(2130708361, 1000000, 30, 1, LogType.UNEXP_ANR, 720, "video/hevc");
            int iM9566 = C2618.m9566("transmit_quality_type", 1);
            if (iM9566 == 1) {
                ACHelper.getInstance().copyDecodeParamBean(decoderParamsBean, this.f1037);
            } else if (iM9566 == 3) {
                ACHelper.getInstance().copyDecodeParamBean(decoderParamsBean3, this.f1037);
            } else {
                ACHelper.getInstance().copyDecodeParamBean(decoderParamsBean2, this.f1037);
            }
        }
        C4567.m14006().m14019(new C0500());
        c9.m219().m234(new C0501());
        C4792.m14375().m14466(getWindow().getDecorView(), this);
        C3088.m10679().mo10680(this);
        AbstractC3958 abstractC3958 = (AbstractC3958) DataBindingUtil.setContentView(this, R.layout.activity_player);
        this.f1011 = abstractC3958;
        abstractC3958.f13713.setAlpha(0.0f);
        this.f1041 = C4535.m13880().m13890().m12461() == 1;
        m1518();
        m1519(true);
        initListener();
        m1521();
        m1539(false, 0);
        m1538(false, 0);
        int iM9446 = C2579.m9446(this);
        if (C4792.m14375().m14498() && iM9446 != 1) {
            setRequestedOrientation(1);
            return;
        }
        m1546();
        m1503();
        m1534(TransmitHelper.getInstance().isStartCameraTransmit(), TransmitHelper.getInstance().getConnectionNum(), TransmitHelper.getInstance().getSelectUnitString(TransmitHelper.getInstance().getConnectionUnitType()), TransmitHelper.getInstance().getWifiStatus());
        m1516();
        m1531(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Jzvd.releaseAllVideos();
        C4567.m14006().m14019(null);
        c9.m219().m234(null);
        ACHelper.getInstance().setFilmAlbumCallback(null);
        ACHelper.getInstance().setPlayerDeviceIconChangeListener(null);
        super.onDestroy();
    }

    public void onDownload(View view) {
        C2628 c2628M15171 = this.f1035.get(this.f1014).m15171();
        String strM9592 = c2628M15171.m9592();
        if (C3180.m10802(c2628M15171.m9593())) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("DownloadBack");
        handlerThread.setPriority(1);
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new RunnableC0554(strM9592, c2628M15171, handlerThread));
    }

    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() throws InterruptedException {
        super.onPause();
        this.f1011.f13712.m1609();
        if (this.f1015) {
            if (this.f1011.f13712.m1594() && this.f1011.f13712.m1593()) {
                this.f1011.f13712.startButton.performClick();
            }
            this.f1015 = false;
            m1501();
        }
        if (HomeActivity.m700() != null && !this.f1019) {
            HomeActivity.m700().m1046();
            this.f1020 = true;
            HomeActivity.m700().m1100();
        }
        if (C4041.m12959()) {
            C4041.m12962(null);
        }
    }

    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1011.f13712.m1610();
        ACHelper.getInstance().setCameraIsAlbumMode(true);
        if (HomeActivity.m700() == null || !this.f1020) {
            return;
        }
        HomeActivity.m700().m1043(this.f1037);
        this.f1019 = false;
        this.f1020 = false;
        HomeActivity.m700().m1161();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            m462();
        }
    }

    /* renamed from: ࢯ, reason: contains not printable characters */
    public final void m1501() {
        if (this.f1014 == -1 || !r1.m8144(this.f1035)) {
            return;
        }
        if (this.f1015) {
            this.f1011.f13704.setImageResource(R.drawable.icon_34_player_pause);
        } else {
            this.f1011.f13704.setImageResource(R.drawable.icon_34_player_play);
        }
    }

    /* renamed from: ࢰ, reason: contains not printable characters */
    public final void m1502() {
        int i = this.f1048;
        if (i != 0) {
            if (i == 1) {
                this.f1011.f13731.setTextColor(C4792.m14375().m14431());
                this.f1011.f13698.setImageResource(R.drawable.icon_30_player_good);
                this.f1011.f13699.setImageResource(R.drawable.icon_30_player_keep);
                this.f1011.f13700.setImageResource(R.drawable.icon_30_player_ng);
                return;
            }
            if (i == 2) {
                this.f1011.f13731.setTextColor(-1);
                this.f1011.f13698.setImageResource(R.drawable.icon_30_player_good_selected);
                this.f1011.f13699.setImageResource(R.drawable.icon_30_player_keep);
                this.f1011.f13700.setImageResource(R.drawable.icon_30_player_ng);
                return;
            }
            if (i == 3) {
                this.f1011.f13731.setTextColor(-1);
                this.f1011.f13698.setImageResource(R.drawable.icon_30_player_good);
                this.f1011.f13699.setImageResource(R.drawable.icon_30_player_keep_selected);
                this.f1011.f13700.setImageResource(R.drawable.icon_30_player_ng);
                return;
            }
            if (i == 4) {
                this.f1011.f13731.setTextColor(-1);
                this.f1011.f13698.setImageResource(R.drawable.icon_30_player_good);
                this.f1011.f13699.setImageResource(R.drawable.icon_30_player_keep);
                this.f1011.f13700.setImageResource(R.drawable.icon_30_player_ng_selected);
                return;
            }
            if (i != 5) {
                return;
            }
        }
        this.f1011.f13731.setTextColor(-1);
        this.f1011.f13698.setImageResource(R.drawable.icon_30_player_good);
        this.f1011.f13699.setImageResource(R.drawable.icon_30_player_keep);
        this.f1011.f13700.setImageResource(R.drawable.icon_30_player_ng);
    }

    /* renamed from: ࢱ, reason: contains not printable characters */
    public final void m1503() {
    }

    /* renamed from: ࢲ, reason: contains not printable characters */
    public final void m1504() {
        List<Purchase> listM13592 = C4400.m13591().m13592();
        if (!r1.m8144(listM13592)) {
            C4757.m14304().m14320(this, false, new C0460());
            return;
        }
        C4638.m14104("bozai", "本地有待消费的订单   " + listM13592);
        C4757.m14304().m14306(this, listM13592, new C0458());
    }

    /* renamed from: ࢳ, reason: contains not printable characters */
    public final boolean m1505() {
        int i;
        if (!r1.m8144(this.f1035) || (i = this.f1014) == -1) {
            return false;
        }
        long jM9591 = this.f1035.get(i).m15171().m9591();
        return (jM9591 > 0 || this.f1011.f13723.getPro() == 0.0f) && this.f1011.f13723.getPro() * ((float) jM9591) <= 1000.0f;
    }

    /* renamed from: ࢴ, reason: contains not printable characters */
    public final void m1506(int i) {
        C2628 c2628M15171 = this.f1035.get(this.f1014).m15171();
        int iM9596 = c2628M15171.m9596();
        int iM9630 = c2628M15171.m9630();
        int iM9594 = c2628M15171.m9594();
        int i2 = 0;
        if (i == 0) {
            if (iM9594 == 1) {
                c2628M15171.m9642(0);
            } else {
                c2628M15171.m9644(0);
                c2628M15171.m9642(1);
                c2628M15171.m9678(0);
            }
        } else if (i == 1) {
            if (iM9596 == 1) {
                c2628M15171.m9644(0);
            } else {
                c2628M15171.m9644(1);
                c2628M15171.m9642(0);
                c2628M15171.m9678(0);
            }
        } else if (iM9630 == 1) {
            c2628M15171.m9678(0);
        } else {
            c2628M15171.m9644(0);
            c2628M15171.m9642(0);
            c2628M15171.m9678(1);
        }
        if (c2628M15171.m9596() == 1) {
            i2 = 1;
        } else if (c2628M15171.m9594() == 1) {
            i2 = 2;
        } else if (c2628M15171.m9630() == 1) {
            i2 = 3;
        }
        j.m7061(i2);
        C5049.m14852().m14860(c2628M15171);
        this.f1013.notifyItemChanged(this.f1014);
        m1515();
    }

    /* renamed from: ࢶ, reason: contains not printable characters */
    public final void m1507(int i) {
        m1508(i, -1);
    }

    /* renamed from: ࢷ, reason: contains not printable characters */
    public final void m1508(int i, int i2) {
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
            if (!r1.m8142(this.f1031)) {
                return;
            }
            product_id = this.f1031.getProduct_id();
            google_id = this.f1031.getGoogle_id();
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
        this.f1022 = true;
        C3617.m11671(this).m11675();
        C4757.m14304().m14316(this, i, str, access_token, product_id, google_id, sub_hms_id, z, new C0464(i, i2));
    }

    /* renamed from: ࢸ, reason: contains not printable characters */
    public final void m1509(boolean z) {
        this.f1011.f13724.setEnabled(z);
        this.f1011.f13685.setEnabled(z);
        this.f1011.f13708.setAlpha(z ? 1.0f : 0.2f);
        this.f1011.f13697.setAlpha(z ? 1.0f : 0.2f);
    }

    /* renamed from: ࢹ, reason: contains not printable characters */
    public final void m1510(float f, float f2, long j) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.f1027 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(j);
        this.f1027.setInterpolator(C4008.m12881());
        this.f1027.addUpdateListener(new C0549());
        this.f1027.addListener(new C0550());
        this.f1027.start();
    }

    /* renamed from: ࢺ, reason: contains not printable characters */
    public final void m1511() {
        if (this.f1049) {
            return;
        }
        C3744 c3744 = this.f1018;
        if (c3744 != null) {
            c3744.m12022(null);
            getSupportFragmentManager().beginTransaction().remove(this.f1018).commitAllowingStateLoss();
            if (HomeActivity.m700() != null) {
                HomeActivity.m700().m1078();
            }
        }
        ComponentCallbacks2C3498.m11419(this).m11426();
        this.f1049 = true;
        this.f1019 = true;
        C4008.m12876(this.f1011.f13713, 0.0f, 200, new C0548());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /* renamed from: ࢻ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m1512(defpackage.C2628 r6) throws java.lang.NumberFormatException {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L50
            int r1 = r6.m9636()
            if (r1 != 0) goto L3f
            java.lang.String r2 = r6.m9590()
            boolean r3 = defpackage.r1.m8143(r2)
            if (r3 == 0) goto L3f
            java.lang.String r3 = " / "
            java.lang.String[] r2 = r2.split(r3)
            if (r2 == 0) goto L3f
            int r3 = r2.length
            r4 = 3
            if (r3 != r4) goto L3f
            r3 = 2
            r2 = r2[r3]
            boolean r3 = defpackage.r1.m8143(r2)
            if (r3 == 0) goto L3f
            java.lang.String r3 = " FPS"
            java.lang.String[] r2 = r2.split(r3)
            if (r2 == 0) goto L3f
            int r3 = r2.length
            r4 = 1
            if (r3 != r4) goto L3f
            r0 = r2[r0]     // Catch: java.lang.Exception -> L3b
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L3b
            goto L40
        L3b:
            r0 = move-exception
            r0.printStackTrace()
        L3f:
            r0 = r1
        L40:
            if (r0 != 0) goto L50
            java.lang.String r6 = r6.m9620()
            boolean r1 = defpackage.r1.m8143(r6)
            if (r1 == 0) goto L50
            int r0 = java.lang.Integer.parseInt(r6)
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.player.PlayerActivity.m1512(ɹ):int");
    }

    /* renamed from: ࢼ, reason: contains not printable characters */
    public final float m1513(C2628 c2628) throws NumberFormatException {
        int iM1512 = m1512(c2628);
        int footageState = this.f1011.f13692.getFootageState();
        int i = footageState != 1 ? footageState != 2 ? footageState != 3 ? 0 : 30 : 25 : 24;
        if (i == 0 || iM1512 == 0) {
            return 0.0f;
        }
        return (i * 1.0f) / iM1512;
    }

    /* renamed from: ࢽ, reason: contains not printable characters */
    public final void m1514() {
        if (this.f1014 == -1 || !r1.m8144(this.f1035)) {
            this.f1011.f13715.setEnabled(false);
            this.f1011.f13709.setEnabled(false);
            this.f1011.f13710.setEnabled(false);
            this.f1011.f13685.setEnabled(false);
            this.f1011.f13724.setEnabled(false);
            this.f1011.f13682.setEnabled(false);
            this.f1011.f13704.setAlpha(0.2f);
            this.f1011.f13703.setAlpha(0.2f);
            this.f1011.f13706.setAlpha(0.2f);
            this.f1011.f13697.setAlpha(0.2f);
            this.f1011.f13708.setAlpha(0.2f);
            this.f1011.f13702.setAlpha(0.2f);
            ACHelper.getInstance().setAlbumControllState(3);
            return;
        }
        if (r1.m8144(this.f1035)) {
            this.f1011.f13715.setEnabled(true);
            this.f1011.f13709.setEnabled(true);
            this.f1011.f13710.setEnabled(true);
            this.f1011.f13685.setEnabled(true);
            this.f1011.f13724.setEnabled(true);
            this.f1011.f13682.setEnabled(true);
            this.f1011.f13704.setAlpha(1.0f);
            this.f1011.f13703.setAlpha(1.0f);
            this.f1011.f13706.setAlpha(1.0f);
            this.f1011.f13697.setAlpha(1.0f);
            this.f1011.f13708.setAlpha(1.0f);
            this.f1011.f13702.setAlpha(1.0f);
            int i = this.f1014;
            if (i == 0) {
                this.f1011.f13709.setEnabled(false);
                this.f1011.f13703.setAlpha(0.2f);
                ACHelper.getInstance().setAlbumControllState(1);
            } else {
                if (i != this.f1035.size() - 1) {
                    ACHelper.getInstance().setAlbumControllState(0);
                    return;
                }
                this.f1011.f13715.setEnabled(false);
                this.f1011.f13706.setAlpha(0.2f);
                ACHelper.getInstance().setAlbumControllState(2);
            }
        }
    }

    /* renamed from: ࢾ, reason: contains not printable characters */
    public final void m1515() {
        int i;
        if (!r1.m8144(this.f1035) || (i = this.f1014) == -1) {
            this.f1011.f13727.setImageRes(R.drawable.icon_30_player_good);
            this.f1011.f13728.setImageRes(R.drawable.icon_30_player_keep);
            this.f1011.f13729.setImageRes(R.drawable.icon_30_player_ng);
            ACHelper.getInstance().setAlbumTagStr("99");
            return;
        }
        C2628 c2628M15171 = this.f1035.get(i).m15171();
        int i2 = 99;
        if (c2628M15171.m9594() == 1) {
            this.f1011.f13727.setImageRes(R.drawable.icon_30_player_good_selected);
            i2 = 100;
        } else {
            this.f1011.f13727.setImageRes(R.drawable.icon_30_player_good);
        }
        if (c2628M15171.m9596() == 1) {
            this.f1011.f13728.setImageRes(R.drawable.icon_30_player_keep_selected);
            i2 = 101;
        } else {
            this.f1011.f13728.setImageRes(R.drawable.icon_30_player_keep);
        }
        if (c2628M15171.m9630() == 1) {
            this.f1011.f13729.setImageRes(R.drawable.icon_30_player_ng_selected);
            i2 = 102;
        } else {
            this.f1011.f13729.setImageRes(R.drawable.icon_30_player_ng);
        }
        ACHelper.getInstance().setAlbumTagStr("" + i2);
    }

    /* renamed from: ࢿ, reason: contains not printable characters */
    public final void m1516() {
        ACHelper.getInstance().setPlayerDeviceIconChangeListener(new C0542());
    }

    /* renamed from: ࣀ, reason: contains not printable characters */
    public final void m1517() {
        C4272 c4272 = new C4272(this, this.f1046, this.f1047, this.f1035, new C0486());
        this.f1013 = c4272;
        c4272.setHasStableIds(true);
        this.f1013.m13383(C4792.m14375().m14498());
    }

    /* renamed from: ࣁ, reason: contains not printable characters */
    public final void m1518() {
        if (C4792.m14375().m14498()) {
            return;
        }
        C3744 c3744M7671 = o3.m7669().m7671();
        this.f1018 = c3744M7671;
        c3744M7671.m12022(new C0543());
        getSupportFragmentManager().beginTransaction().add(R.id.play_fr, this.f1018).commitAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().hide(this.f1018).commitAllowingStateLoss();
    }

    /* renamed from: ࣂ, reason: contains not printable characters */
    public final void m1519(boolean z) {
        float fM14455;
        int i;
        int i2;
        int i3;
        int i4;
        int iM9449 = C2579.m9449(this);
        int iM9443 = C2579.m9443(this);
        C2579.m9440(this);
        int iM9450 = C2579.m9450(this);
        int iM94492 = C2579.m9449(this);
        float fM14434 = C4792.m14375().m14434();
        ViewGroup.LayoutParams layoutParams = this.f1011.f13712.getLayoutParams();
        layoutParams.width = iM9450;
        layoutParams.height = iM94492;
        this.f1011.f13712.setLayoutParams(layoutParams);
        this.f1011.f13712.m1611(TransmitHelper.getInstance().isStartCameraTransmit());
        this.f1011.f13719.setKeepScreenOn(TransmitHelper.getInstance().isStartCameraTransmit());
        ViewGroup.LayoutParams layoutParams2 = this.f1011.f13720.getLayoutParams();
        layoutParams2.width = iM9443;
        layoutParams2.height = iM94492;
        this.f1011.f13720.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f1011.f13719.getLayoutParams();
        layoutParams3.width = iM9450;
        layoutParams3.height = iM94492;
        this.f1011.f13719.setLayoutParams(layoutParams3);
        int i5 = (iM9443 - layoutParams.width) / 2;
        boolean zM14498 = C4792.m14375().m14498();
        if (zM14498) {
            fM14455 = C4792.m14375().m14455(1125.0f);
            i = layoutParams.height;
        } else {
            fM14455 = C4792.m14375().m14455(1125.0f);
            i = layoutParams.width;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f1011.f13680.getLayoutParams();
        float f = 124.0f * fM14434 * fM14455;
        layoutParams4.width = (int) (f - C2579.m9438(2.0f));
        layoutParams4.height = (int) (f - C2579.m9438(2.0f));
        float f2 = i;
        layoutParams4.topMargin = (int) (0.02846442f * f2);
        int i6 = (int) (0.023970038f * f2);
        layoutParams4.rightMargin = i6;
        this.f1011.f13680.setLayoutParams(layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.f1011.f13696.getLayoutParams();
        layoutParams5.width = (int) (layoutParams4.width * 0.6917293f);
        int i7 = (int) (layoutParams4.width * 0.6917293f);
        layoutParams5.height = i7;
        layoutParams5.topMargin = (int) (((layoutParams4.height - i7) / 2) + (i7 * 0.1388889f));
        this.f1011.f13696.setLayoutParams(layoutParams5);
        ViewGroup.LayoutParams layoutParams6 = this.f1011.f13681.getLayoutParams();
        if (zM14498) {
            layoutParams6.height = (int) (0.27790263f * f2);
        } else {
            layoutParams6.height = (int) (0.20299625f * f2);
        }
        this.f1011.f13681.setLayoutParams(layoutParams6);
        if (zM14498) {
            i2 = iM9449;
            i3 = 8;
            this.f1011.f13705.setVisibility(8);
            this.f1011.f13735.setVisibility(8);
            this.f1011.f13730.setVisibility(8);
            this.f1011.f13695.setVisibility(8);
        } else {
            int iM14432 = C4792.m14375().m14432();
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f1011.f13705.getLayoutParams();
            layoutParams7.width = C2579.m9438(50.0f * fM14434);
            layoutParams7.height = C4792.m14375().m14432();
            layoutParams7.rightMargin = (int) ((f2 * 0.046441946f) - ((layoutParams7.width - iM14432) / 2.0f));
            layoutParams7.topMargin = (int) ((layoutParams4.topMargin + ((layoutParams4.height - r4) / 2.0f)) - C4792.m14375().m14476(10));
            this.f1011.f13705.setLayoutParams(layoutParams7);
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f1011.f13730.getLayoutParams();
            layoutParams8.width = C2579.m9438(44.0f);
            layoutParams8.height = C2579.m9438(44.0f);
            layoutParams8.rightMargin = (int) (layoutParams7.rightMargin + ((layoutParams7.width - layoutParams8.width) / 2.0f));
            layoutParams8.topMargin = (int) (layoutParams7.topMargin + ((layoutParams7.height - r11) / 2.0f));
            this.f1011.f13730.setLayoutParams(layoutParams8);
            int i8 = !"Wi-Fi".equals(C3688.m11833(FilmApp.m402())) ? 1 : 0;
            if (!TransmitHelper.getInstance().isStartCameraTransmit()) {
                i8 = 0;
            }
            this.f1011.f13705.m4159(i8);
            this.f1011.f13705.m4168(5);
            this.f1011.f13705.setCenterState(1);
            int iM14476 = C4792.m14375().m14476(36);
            int iM14391 = C4792.m14375().m14391();
            this.f1011.f13735.setText(ACHelper.getInstance().getRoomId());
            i2 = iM9449;
            this.f1011.f13735.m4177(0, C4792.m14375().m14396(), FilmApp.m403(), C4792.m14375().m14393());
            this.f1011.f13735.m4175(R.drawable.icon_15_monitor_cloud_stroke15_monitor_cloud_stroke, R.drawable.icon_15_monitor_cloud);
            this.f1011.f13735.m4176(iM14476, iM14476);
            this.f1011.f13735.m4174(5);
            if (r1.m8143(ACHelper.getInstance().getRoomId())) {
                RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f1011.f13735.getLayoutParams();
                layoutParams9.leftMargin = (layoutParams7.width - ((int) (((this.f1011.f13735.getTvPaint().measureText(ACHelper.getInstance().getRoomId()) + C4792.f16138) + iM14476) + iM14391))) / 2;
                this.f1011.f13735.setLayoutParams(layoutParams9);
            }
            this.f1011.f13695.m2562(0, (int) ((C4792.m14375().m14378() * fM14434) + 0.5f));
            this.f1011.f13695.setContentTypeFace(FilmApp.m403());
            TextPaint paint = this.f1011.f13695.getPaint();
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int i9 = (int) (fontMetrics.bottom - fontMetrics.top);
            RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f1011.f13695.getLayoutParams();
            layoutParams10.topMargin = (layoutParams7.topMargin + layoutParams7.height) - i9;
            layoutParams10.width = (int) (paint.measureText(ExifInterface.LONGITUDE_WEST) + C4792.f16138);
            int i10 = layoutParams7.width;
            layoutParams10.rightMargin = (int) ((((-i10) + ((i10 - iM14432) / 2.0f)) - C4792.m14375().m14480(5.0f, fM14434)) - layoutParams10.width);
            this.f1011.f13695.setLayoutParams(layoutParams10);
            this.f1011.f13695.m2560((int) C4792.f16138, 0, 0, 0);
            this.f1011.f13705.setVisibility(0);
            this.f1011.f13730.setVisibility(0);
            this.f1011.f13695.setVisibility(0);
            if (zM14498) {
                this.f1011.f13694.setVisibility(8);
            } else {
                this.f1011.f13694.setVisibility(0);
            }
            this.f1011.f13694.setAlpha(0.0f);
            ACHelper.getInstance().onCheck265Done(new C0537());
            i3 = 8;
        }
        m1520();
        this.f1011.f13684.setOnClickListener(new ViewOnClickListenerC0539());
        this.f1011.f13684.setVisibility(i3);
        int i11 = (int) (0.035205994f * f2);
        RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) this.f1011.f13701.getLayoutParams();
        if (zM14498) {
            layoutParams11.rightMargin = (int) (0.047940075f * f2);
        } else {
            layoutParams11.rightMargin = i6;
        }
        layoutParams11.bottomMargin = (int) (0.033707865f * f2);
        layoutParams11.width = i11;
        layoutParams11.height = i11;
        this.f1011.f13701.setLayoutParams(layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) this.f1011.f13723.getLayoutParams();
        layoutParams12.width = (int) (0.41348314f * f2);
        int i12 = (int) (0.03670412f * f2);
        layoutParams12.height = i12;
        if (zM14498) {
            int i13 = layoutParams11.bottomMargin;
            layoutParams12.bottomMargin = layoutParams11.height + i13 + i13;
        } else {
            layoutParams12.bottomMargin = layoutParams11.bottomMargin + ((layoutParams11.height - i12) / 2);
        }
        this.f1011.f13723.setLayoutParams(layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) this.f1011.f13697.getLayoutParams();
        int i14 = (int) (0.037453182f * f2);
        layoutParams13.rightMargin = i14;
        layoutParams13.bottomMargin = layoutParams11.bottomMargin;
        layoutParams13.width = i11;
        layoutParams13.height = i11;
        this.f1011.f13697.setLayoutParams(layoutParams13);
        RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) this.f1011.f13708.getLayoutParams();
        layoutParams14.rightMargin = i14;
        layoutParams14.bottomMargin = layoutParams11.bottomMargin;
        layoutParams14.width = i11;
        layoutParams14.height = i11;
        this.f1011.f13708.setLayoutParams(layoutParams14);
        RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) this.f1011.f13704.getLayoutParams();
        layoutParams15.width = i11;
        layoutParams15.height = i11;
        layoutParams15.bottomMargin = (int) (0.026217228f * f2);
        this.f1011.f13704.setLayoutParams(layoutParams15);
        RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) this.f1011.f13703.getLayoutParams();
        layoutParams16.width = i11;
        layoutParams16.height = i11;
        layoutParams16.leftMargin = (int) (0.046441946f * f2);
        layoutParams16.bottomMargin = layoutParams15.bottomMargin;
        this.f1011.f13703.setLayoutParams(layoutParams16);
        RelativeLayout.LayoutParams layoutParams17 = (RelativeLayout.LayoutParams) this.f1011.f13706.getLayoutParams();
        layoutParams17.width = i11;
        layoutParams17.height = i11;
        layoutParams17.rightMargin = layoutParams16.leftMargin;
        layoutParams17.bottomMargin = layoutParams15.bottomMargin;
        this.f1011.f13706.setLayoutParams(layoutParams17);
        RelativeLayout.LayoutParams layoutParams18 = (RelativeLayout.LayoutParams) this.f1011.f13702.getLayoutParams();
        layoutParams18.width = i11;
        layoutParams18.height = i11;
        layoutParams18.leftMargin = C2579.m9438(10.0f);
        layoutParams18.bottomMargin = layoutParams17.bottomMargin;
        this.f1011.f13702.setLayoutParams(layoutParams18);
        RelativeLayout.LayoutParams layoutParams19 = (RelativeLayout.LayoutParams) this.f1011.f13707.getLayoutParams();
        layoutParams19.width = i11;
        layoutParams19.height = i11;
        layoutParams19.rightMargin = C2579.m9438(10.0f);
        layoutParams19.bottomMargin = layoutParams15.bottomMargin;
        int iM14384 = C4792.m14375().m14384() * 2;
        RelativeLayout.LayoutParams layoutParams20 = (RelativeLayout.LayoutParams) this.f1011.f13718.getLayoutParams();
        layoutParams20.height = iM14384;
        layoutParams20.width = iM14384;
        layoutParams20.bottomMargin = layoutParams19.bottomMargin - ((iM14384 - layoutParams19.height) / 2);
        layoutParams20.rightMargin = layoutParams19.rightMargin + ((layoutParams19.width - iM14384) / 2);
        this.f1011.f13718.setLayoutParams(layoutParams20);
        RelativeLayout.LayoutParams layoutParams21 = (RelativeLayout.LayoutParams) this.f1011.f13691.getLayoutParams();
        layoutParams21.height = iM14384;
        layoutParams21.width = iM14384;
        layoutParams21.bottomMargin = layoutParams11.bottomMargin - ((iM14384 - layoutParams11.height) / 2);
        layoutParams21.rightMargin = layoutParams11.rightMargin - ((iM14384 - layoutParams11.width) / 2);
        this.f1011.f13691.setLayoutParams(layoutParams21);
        RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) this.f1011.f13685.getLayoutParams();
        layoutParams22.height = iM14384;
        layoutParams22.width = iM14384;
        layoutParams22.bottomMargin = layoutParams13.bottomMargin - ((iM14384 - layoutParams13.height) / 2);
        layoutParams22.rightMargin = layoutParams13.rightMargin - ((iM14384 - layoutParams13.width) / 2);
        this.f1011.f13685.setLayoutParams(layoutParams22);
        RelativeLayout.LayoutParams layoutParams23 = (RelativeLayout.LayoutParams) this.f1011.f13724.getLayoutParams();
        layoutParams23.height = iM14384;
        layoutParams23.width = iM14384;
        layoutParams23.bottomMargin = layoutParams14.bottomMargin - ((iM14384 - layoutParams14.height) / 2);
        layoutParams23.rightMargin = layoutParams14.rightMargin - ((iM14384 - layoutParams14.width) / 2);
        this.f1011.f13724.setLayoutParams(layoutParams23);
        RelativeLayout.LayoutParams layoutParams24 = (RelativeLayout.LayoutParams) this.f1011.f13710.getLayoutParams();
        layoutParams24.height = iM14384;
        layoutParams24.width = iM14384;
        layoutParams24.bottomMargin = layoutParams15.bottomMargin - ((iM14384 - layoutParams15.height) / 2);
        this.f1011.f13710.setLayoutParams(layoutParams24);
        RelativeLayout.LayoutParams layoutParams25 = (RelativeLayout.LayoutParams) this.f1011.f13709.getLayoutParams();
        layoutParams25.height = iM14384;
        layoutParams25.width = iM14384;
        layoutParams25.bottomMargin = layoutParams16.bottomMargin - ((iM14384 - layoutParams16.height) / 2);
        layoutParams25.leftMargin = layoutParams16.leftMargin - ((iM14384 - layoutParams16.width) / 2);
        this.f1011.f13709.setLayoutParams(layoutParams25);
        RelativeLayout.LayoutParams layoutParams26 = (RelativeLayout.LayoutParams) this.f1011.f13715.getLayoutParams();
        layoutParams26.height = iM14384;
        layoutParams26.width = iM14384;
        layoutParams26.bottomMargin = layoutParams17.bottomMargin - ((iM14384 - layoutParams17.height) / 2);
        layoutParams26.rightMargin = layoutParams17.rightMargin - ((iM14384 - layoutParams17.width) / 2);
        this.f1011.f13715.setLayoutParams(layoutParams26);
        RelativeLayout.LayoutParams layoutParams27 = (RelativeLayout.LayoutParams) this.f1011.f13682.getLayoutParams();
        layoutParams27.height = iM14384;
        layoutParams27.width = iM14384;
        layoutParams27.bottomMargin = layoutParams18.bottomMargin - ((iM14384 - layoutParams18.height) / 2);
        layoutParams27.leftMargin = layoutParams18.leftMargin - ((iM14384 - layoutParams18.width) / 2);
        this.f1011.f13682.setLayoutParams(layoutParams27);
        int i15 = (int) (0.029213483f * f2);
        if (zM14498) {
            this.f1045 = (int) (0.04344569f * f2);
        } else {
            this.f1045 = (int) (0.021722846f * f2);
        }
        int iM14396 = C4792.m14375().m14396();
        int iM144762 = C4792.m14375().m14476(2);
        int i16 = (int) (0.041198503f * f2);
        RelativeLayout.LayoutParams layoutParams28 = (RelativeLayout.LayoutParams) this.f1011.f13727.getLayoutParams();
        layoutParams28.topMargin = layoutParams4.topMargin - ((i15 - layoutParams4.height) / 2);
        this.f1011.f13727.setLayoutParams(layoutParams28);
        this.f1011.f13727.m2680(i15, i15);
        this.f1011.f13727.setTextSize(iM14396);
        this.f1011.f13727.setTextColor(-1);
        this.f1011.f13727.setContentMargin(iM144762);
        this.f1011.f13727.setImageRes(R.drawable.icon_30_player_good);
        int i17 = i16 / 2;
        this.f1011.f13727.setPadding(this.f1045, 0, i17, 0);
        RelativeLayout.LayoutParams layoutParams29 = (RelativeLayout.LayoutParams) this.f1011.f13728.getLayoutParams();
        if (zM14498) {
            i4 = iM14384;
            layoutParams29.removeRule(1);
            layoutParams29.addRule(3, R.id.tag_good);
            layoutParams29.topMargin = i16 - (i15 / 2);
            this.f1011.f13728.setPadding(this.f1045, 0, i17, 0);
        } else {
            i4 = iM14384;
            layoutParams29.removeRule(3);
            layoutParams29.addRule(1, R.id.tag_good);
            layoutParams29.topMargin = layoutParams28.topMargin;
            this.f1011.f13728.setPadding(i17, 0, i17, 0);
        }
        this.f1011.f13728.setLayoutParams(layoutParams29);
        this.f1011.f13728.m2680(i15, i15);
        this.f1011.f13728.setTextSize(iM14396);
        this.f1011.f13728.setTextColor(-1);
        this.f1011.f13728.setContentMargin(iM144762);
        this.f1011.f13728.setImageRes(R.drawable.icon_30_player_keep);
        RelativeLayout.LayoutParams layoutParams30 = (RelativeLayout.LayoutParams) this.f1011.f13729.getLayoutParams();
        if (zM14498) {
            layoutParams30.removeRule(1);
            layoutParams30.addRule(3, R.id.tag_keep);
            layoutParams30.topMargin = i16 - (i15 / 2);
            this.f1011.f13729.setPadding(this.f1045, 0, i17, 0);
        } else {
            layoutParams30.removeRule(3);
            layoutParams30.addRule(1, R.id.tag_keep);
            layoutParams30.topMargin = layoutParams28.topMargin;
            this.f1011.f13729.setPadding(i17, 0, i17, 0);
        }
        this.f1011.f13729.setLayoutParams(layoutParams30);
        this.f1011.f13729.m2680(i15, i15);
        this.f1011.f13729.setTextSize(iM14396);
        this.f1011.f13729.setTextColor(-1);
        this.f1011.f13729.setContentMargin(iM144762);
        this.f1011.f13729.setImageRes(R.drawable.icon_30_player_ng);
        this.f1011.f13736.setTextColor(-1);
        this.f1011.f13736.m2562(0, C4792.m14375().m14384());
        this.f1011.f13734.setTextColor(-1);
        this.f1011.f13734.m2562(0, C4792.m14375().m14396());
        Paint.FontMetrics fontMetrics2 = this.f1011.f13736.getPaint().getFontMetrics();
        int i18 = (int) (fontMetrics2.bottom - fontMetrics2.top);
        RelativeLayout.LayoutParams layoutParams31 = (RelativeLayout.LayoutParams) this.f1011.f13736.getLayoutParams();
        layoutParams31.topMargin = layoutParams4.topMargin + ((layoutParams4.height - i18) / 2);
        this.f1011.f13736.setLayoutParams(layoutParams31);
        if (z) {
            m1536("00:00:00");
            m1535("");
        }
        if (C4792.m14375().m14498()) {
            int i19 = (int) (0.16479401f * f2);
            this.f1046 = i19;
            this.f1047 = (int) (i19 + ((((i19 * 224.0f) / 255.0f) * 7.0f) / 16.0f));
        } else {
            int i20 = (int) (0.19101124f * f2);
            this.f1046 = i20;
            this.f1047 = (int) (i20 + ((((i20 * 224.0f) / 255.0f) * 7.0f) / 16.0f));
        }
        ViewGroup.LayoutParams layoutParams32 = this.f1011.f13722.getLayoutParams();
        layoutParams32.height = C4792.m14375().m14498() ? this.f1047 : this.f1046;
        this.f1011.f13722.setLayoutParams(layoutParams32);
        this.f1011.f13723.setMin(0.0f);
        this.f1011.f13723.setMax(100.0f);
        this.f1038 = layoutParams4.rightMargin + C4792.m14375().m14476(15) + i5;
        this.f1039 = layoutParams28.leftMargin + i5;
        this.f1040 = (int) (f2 * 0.020224718f);
        this.f1011.f13732.setTextColor(-1);
        this.f1011.f13732.m2562(0, C4792.m14375().m14384());
        this.f1011.f13732.m2561(getResources().getString(R.string.PLAYBACK_SELECT).toUpperCase());
        RelativeLayout.LayoutParams layoutParams33 = (RelativeLayout.LayoutParams) this.f1011.f13732.getLayoutParams();
        Paint.FontMetrics fontMetrics3 = this.f1011.f13732.getPaint().getFontMetrics();
        int i21 = (int) (fontMetrics3.bottom - fontMetrics3.top);
        int i22 = layoutParams14.bottomMargin + ((layoutParams14.height - i21) / 2);
        layoutParams33.bottomMargin = i22;
        layoutParams33.leftMargin = this.f1045;
        this.f1011.f13732.setLayoutParams(layoutParams33);
        RelativeLayout.LayoutParams layoutParams34 = (RelativeLayout.LayoutParams) this.f1011.f13683.getLayoutParams();
        layoutParams34.bottomMargin = 0;
        layoutParams34.height = i21 + i22 + (i22 / 2);
        this.f1011.f13683.setLayoutParams(layoutParams34);
        RelativeLayout.LayoutParams layoutParams35 = (RelativeLayout.LayoutParams) this.f1011.f13731.getLayoutParams();
        this.f1011.f13731.setTextColor(-1);
        this.f1011.f13731.m2562(0, C4792.m14375().m14384());
        this.f1011.f13731.m2561(getResources().getString(R.string.PLAYBACK_SELECT_ALL).toUpperCase());
        Paint.FontMetrics fontMetrics4 = this.f1011.f13731.getPaint().getFontMetrics();
        int i23 = (int) (fontMetrics4.bottom - fontMetrics4.top);
        if (zM14498) {
            int i24 = layoutParams11.bottomMargin;
            int i25 = layoutParams11.height;
            layoutParams35.bottomMargin = ((i25 - i23) / 2) + i24 + i25 + i24;
        } else {
            layoutParams35.bottomMargin = layoutParams11.bottomMargin + ((layoutParams11.height - i23) / 2);
        }
        int iMeasureText = (int) this.f1011.f13731.getPaint().measureText(getResources().getString(R.string.PLAYBACK_SELECT_ALL).toUpperCase());
        layoutParams35.leftMargin = (iM9450 - (((i15 * 3) + iMeasureText) + (i14 * 3))) / 2;
        this.f1011.f13731.setLayoutParams(layoutParams35);
        RelativeLayout.LayoutParams layoutParams36 = (RelativeLayout.LayoutParams) this.f1011.f13698.getLayoutParams();
        layoutParams36.width = i15;
        layoutParams36.height = i15;
        if (zM14498) {
            int i26 = layoutParams11.bottomMargin;
            int i27 = layoutParams11.height;
            layoutParams36.bottomMargin = ((i27 - i15) / 2) + i26 + i27 + i26;
        } else {
            layoutParams36.bottomMargin = layoutParams11.bottomMargin + ((layoutParams11.height - i15) / 2);
        }
        layoutParams36.leftMargin = i14;
        this.f1011.f13698.setLayoutParams(layoutParams36);
        RelativeLayout.LayoutParams layoutParams37 = (RelativeLayout.LayoutParams) this.f1011.f13699.getLayoutParams();
        layoutParams37.width = i15;
        layoutParams37.height = i15;
        layoutParams37.bottomMargin = layoutParams36.bottomMargin;
        layoutParams37.leftMargin = layoutParams36.leftMargin;
        this.f1011.f13699.setLayoutParams(layoutParams37);
        RelativeLayout.LayoutParams layoutParams38 = (RelativeLayout.LayoutParams) this.f1011.f13700.getLayoutParams();
        layoutParams38.width = i15;
        layoutParams38.height = i15;
        layoutParams38.bottomMargin = layoutParams36.bottomMargin;
        layoutParams38.leftMargin = layoutParams36.leftMargin;
        this.f1011.f13700.setLayoutParams(layoutParams38);
        RelativeLayout.LayoutParams layoutParams39 = (RelativeLayout.LayoutParams) this.f1011.f13733.getLayoutParams();
        layoutParams39.bottomMargin = (int) (layoutParams36.height + layoutParams36.bottomMargin + (i2 * 0.03654189f));
        this.f1011.f13733.setLayoutParams(layoutParams39);
        this.f1011.f13733.setTextColor(-1);
        this.f1011.f13733.m2562(0, C4792.m14375().m14396());
        this.f1011.f13733.m2561(getResources().getString(R.string.PLAYBACK_SELECT_FILTER).toUpperCase());
        RelativeLayout.LayoutParams layoutParams40 = (RelativeLayout.LayoutParams) this.f1011.f13686.getLayoutParams();
        int i28 = i4;
        layoutParams40.width = i28;
        layoutParams40.height = i28;
        layoutParams40.leftMargin = layoutParams35.leftMargin - ((i28 - iMeasureText) / 2);
        layoutParams40.bottomMargin = layoutParams35.bottomMargin + ((i23 - i28) / 2);
        this.f1011.f13686.setLayoutParams(layoutParams40);
        RelativeLayout.LayoutParams layoutParams41 = (RelativeLayout.LayoutParams) this.f1011.f13688.getLayoutParams();
        layoutParams41.width = i28;
        layoutParams41.height = i28;
        layoutParams41.leftMargin = layoutParams36.leftMargin + ((layoutParams36.width - i28) / 2);
        layoutParams41.bottomMargin = layoutParams36.bottomMargin + ((layoutParams36.height - i28) / 2);
        this.f1011.f13688.setLayoutParams(layoutParams41);
        RelativeLayout.LayoutParams layoutParams42 = (RelativeLayout.LayoutParams) this.f1011.f13689.getLayoutParams();
        layoutParams42.width = i28;
        layoutParams42.height = i28;
        layoutParams42.leftMargin = layoutParams41.leftMargin;
        layoutParams42.bottomMargin = layoutParams41.bottomMargin;
        this.f1011.f13689.setLayoutParams(layoutParams42);
        RelativeLayout.LayoutParams layoutParams43 = (RelativeLayout.LayoutParams) this.f1011.f13690.getLayoutParams();
        layoutParams43.width = i28;
        layoutParams43.height = i28;
        layoutParams43.leftMargin = layoutParams41.leftMargin;
        layoutParams43.bottomMargin = layoutParams41.bottomMargin;
        this.f1011.f13690.setLayoutParams(layoutParams43);
        RelativeLayout.LayoutParams layoutParams44 = (RelativeLayout.LayoutParams) this.f1011.f13687.getLayoutParams();
        int i29 = layoutParams40.width;
        int i30 = layoutParams41.leftMargin;
        layoutParams44.width = i29 + i30 + i30 + layoutParams42.leftMargin + layoutParams42.width + layoutParams43.leftMargin + layoutParams43.width + C4792.m14375().m14476(20);
        layoutParams44.height = layoutParams39.bottomMargin + C4792.m14375().m14476(20);
        layoutParams44.leftMargin = layoutParams40.leftMargin - C4792.m14375().m14476(10);
        this.f1011.f13687.setLayoutParams(layoutParams44);
        m1524();
        this.f1011.f13731.post(new RunnableC0540());
        this.f1011.f13732.post(new RunnableC0541());
    }

    /* renamed from: ࣃ, reason: contains not printable characters */
    public final void m1520() {
        C3703 c3703 = new C3703(this, new DialogInterfaceOnDismissListenerC0454(), new C0455(), C4792.m14375().m14498(), false, new C0457());
        this.f1023 = c3703;
        c3703.m11877();
    }

    /* renamed from: ࣄ, reason: contains not printable characters */
    public final void m1521() throws NumberFormatException {
        this.f1035 = new ArrayList();
        List<C2628> listM14856 = C5049.m14852().m14856();
        if (r1.m8144(listM14856)) {
            for (C2628 c2628 : listM14856) {
                C5202 c5202 = new C5202();
                c5202.m15173(c2628);
                this.f1035.add(c5202);
            }
        }
        if (r1.m8144(this.f1035)) {
            Iterator<C5202> it = this.f1035.iterator();
            while (it.hasNext()) {
                C2628 c2628M15171 = it.next().m15171();
                if (!new File(c2628M15171.m9592()).exists()) {
                    it.remove();
                    C3180.m10795(c2628M15171.m9634());
                    C3180.m10795(c2628M15171.m9635());
                    C5049.m14852().m14854(c2628M15171);
                }
            }
        }
        if (r1.m8144(this.f1035)) {
            this.f1035.get(0).setSelected(true);
            this.f1014 = 0;
            m1523();
        }
        m1517();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 0, false);
        this.f1036 = linearLayoutManager;
        this.f1011.f13721.setLayoutManager(linearLayoutManager);
        this.f1011.f13721.addItemDecoration(new C2612(this.f1040, this.f1039, this.f1038));
        this.f1011.f13721.setOverScrollMode(2);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) this.f1011.f13721.getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
            simpleItemAnimator.setChangeDuration(0L);
        }
        this.f1011.f13721.setItemAnimator(null);
        this.f1011.f13721.setAdapter(this.f1013);
        this.f1011.f13721.addOnScrollListener(new C0485());
        m1514();
        m1515();
    }

    /* renamed from: ࣅ, reason: contains not printable characters */
    public final void m1522() {
        this.f1011.f13726.setPortrait(C4792.m14375().m14498());
        this.f1011.f13726.setOnSubscribeDialogListener(new C0559());
    }

    /* renamed from: ࣆ, reason: contains not printable characters */
    public final void m1523() throws NumberFormatException {
        C2628 c2628M15171 = this.f1035.get(this.f1014).m15171();
        DecoderParamsBean selectDecoderParamsBean = ACHelper.getInstance().getSelectDecoderParamsBean();
        int iM9633 = c2628M15171.m9633();
        int iM9632 = c2628M15171.m9632();
        int iMax = Math.max(iM9632, iM9633);
        int iMin = Math.min(iM9632, iM9633);
        float f = (iM9633 * 1.0f) / iM9632;
        float fM475 = (this.f1037.m475() * 1.0f) / this.f1037.m473();
        if (selectDecoderParamsBean == null) {
            selectDecoderParamsBean = new DecoderParamsBean(2130708361, 2000000, 30, 1, LogType.UNEXP_ANR, 720, "video/hevc");
            DecoderParamsBean decoderParamsBean = new DecoderParamsBean(2130708361, 3000000, 30, 1, DPXReader.TVINFO_OFFSET, 1080, "video/hevc");
            DecoderParamsBean decoderParamsBean2 = new DecoderParamsBean(2130708361, 1000000, 30, 1, LogType.UNEXP_ANR, 720, "video/hevc");
            int iM9566 = C2618.m9566("transmit_quality_type", 1);
            if (iM9566 != 1) {
                selectDecoderParamsBean = iM9566 == 3 ? decoderParamsBean2 : decoderParamsBean;
            }
        }
        boolean z = fM475 != f;
        if (z) {
            int iMax2 = Math.max(selectDecoderParamsBean.m475(), selectDecoderParamsBean.m473());
            Math.min(selectDecoderParamsBean.m475(), selectDecoderParamsBean.m473());
            int iMin2 = Math.min(iMax, iMax2);
            int i = (int) (((iMin * iMin2) * 1.0f) / iMax);
            int i2 = i - (i % 2);
            if (c2628M15171.m9633() > c2628M15171.m9632()) {
                this.f1037.m483(iMin2);
                this.f1037.m481(i2);
            } else if (c2628M15171.m9633() < c2628M15171.m9632()) {
                this.f1037.m483(i2);
                this.f1037.m481(iMin2);
            } else {
                this.f1037.m483(iMin2);
                this.f1037.m481(iMin2);
            }
        }
        if (TransmitHelper.getInstance().isStartCameraTransmit() && z) {
            ConnectionManager.getInstance().rePreviewEncode(this.f1037);
        }
        m1531(true);
        int iM1512 = m1512(c2628M15171);
        this.f1011.f13692.m1602(iM1512 + "");
        this.f1011.f13692.m1601();
        if (this.f1011.f13692.getFootageState() != 0) {
            this.f1011.f13712.m1612(c2628M15171.m9592(), "", c2628M15171.m9633(), c2628M15171.m9632(), m1513(c2628M15171));
        } else {
            this.f1011.f13712.m1612(c2628M15171.m9592(), "", c2628M15171.m9633(), c2628M15171.m9632(), 0.0f);
        }
        this.f1011.f13712.posterImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        C5299.m15341().m15343(this, this.f1011.f13712.posterImageView, c2628M15171.m9634());
        m1535(c2628M15171.m9629());
        m1536(this.f1011.f13712.m1596(c2628M15171.m9591()));
        this.f1011.f13712.startPreloading();
    }

    /* renamed from: ࣇ, reason: contains not printable characters */
    public final void m1524() {
        if (this.f1041) {
            this.f1011.f13707.setImageResource(R.drawable.icon_34_player_repeat_on);
        } else {
            this.f1011.f13707.setImageResource(R.drawable.icon_34_player_repeat_off);
        }
        C4535.m13880().m13890().m12346(this.f1041 ? 1 : 0);
        C4535.m13880().m13915();
        this.f1011.f13712.setRepeat(this.f1041);
    }

    /* renamed from: ৼ, reason: contains not printable characters */
    public final void m1525() {
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (userBeanM5990 == null || userBeanM5990.getIs_subscription_user()) {
            this.f1017.post(new RunnableC0477());
            return;
        }
        CachePlayStoreBean cachePlayStoreBeanM11747 = C3659.m11744().m11747();
        CacheHuaweiBean cacheHuaweiBeanM11746 = C3659.m11744().m11746();
        if (cachePlayStoreBeanM11747 == null) {
            if (cacheHuaweiBeanM11746 != null) {
                PayController.queryHuaweiOrder(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), HuaweiPay.generateHuaweiJson(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), cacheHuaweiBeanM11746.getInAppPurchaseData(), cacheHuaweiBeanM11746.getInAppSignature()), new C0474());
                return;
            }
            return;
        }
        Purchase purchase = cachePlayStoreBeanM11747.getPurchase();
        PayController.queryPlayStoreOrder(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), GooglePayHelper.generateGoogleJson(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), purchase.getOriginalJson(), purchase.getSignature()), new C0471());
    }

    /* renamed from: ૹ, reason: contains not printable characters */
    public final void m1526(boolean z, boolean z2) {
        int i;
        if (!this.f1034 && r1.m8144(this.f1035) && (i = this.f1014) >= 0) {
            this.f1034 = true;
            long jM9591 = this.f1035.get(i).m15171().m9591();
            this.f1017.removeMessages(100);
            float pro = this.f1011.f13723.getPro();
            if (this.f1015) {
                if (this.f1011.f13712.m1594() && this.f1011.f13712.m1593()) {
                    this.f1011.f13712.startButton.performClick();
                }
                this.f1017.sendEmptyMessageDelayed(100, 500L);
            }
            float f = jM9591;
            long jMin = (long) (0.01f * f);
            if (z2) {
                jMin = Math.min(jMin, 1000L);
            }
            long jMin2 = Math.min(jM9591, Math.max(0L, (long) (z ? (pro * f) + jMin : (pro * f) - jMin)));
            float f2 = ((jMin2 * 1.0f) / f) * 100.0f;
            C4638.m14099("slimmm", "pro:" + pro + MyUTIL.white_space + f2);
            this.f1011.f13723.setValueAndUpdateUI(f2);
            this.f1011.f13712.m1595((int) f2);
            this.f1011.f13712.posterImageView.setVisibility(8);
            if (r1.m8144(this.f1035) && this.f1014 != -1 && jM9591 > 0) {
                m1536(this.f1011.f13712.m1596(jMin2));
            }
            this.f1034 = false;
        }
    }

    /* renamed from: ಀ, reason: contains not printable characters */
    public final void m1527(boolean z) {
        int i;
        if (!this.f1034 && r1.m8144(this.f1035) && (i = this.f1014) >= 0) {
            this.f1034 = true;
            long jM9591 = this.f1035.get(i).m15171().m9591();
            this.f1017.removeMessages(100);
            float pro = this.f1011.f13723.getPro();
            if (this.f1015) {
                if (this.f1011.f13712.m1594() && this.f1011.f13712.m1593()) {
                    this.f1011.f13712.startButton.performClick();
                }
                this.f1017.sendEmptyMessageDelayed(100, 500L);
            }
            long jMin = Math.min(jM9591, Math.max(0L, (long) (z ? (pro * jM9591) + 5000 : (pro * jM9591) - 5000)));
            float f = ((jMin * 1.0f) / jM9591) * 100.0f;
            this.f1011.f13723.setValueAndUpdateUI(f);
            this.f1011.f13712.m1595((int) f);
            this.f1011.f13712.posterImageView.setVisibility(8);
            ACHelper.getInstance().setAlbumPercent(f / 100.0f);
            if (r1.m8144(this.f1035) && this.f1014 != -1 && jM9591 > 0) {
                m1536(this.f1011.f13712.m1596(jMin));
            }
            this.f1034 = false;
        }
    }

    /* renamed from: ೱ, reason: contains not printable characters */
    public final void m1528(int i) {
        SubscribeInfoCallback subscribeInfoCallbackM7605 = n.m7588().m7605();
        C4757.m14304().m14323(i, this, subscribeInfoCallbackM7605.getSub_gplay_id(), subscribeInfoCallbackM7605.getSub_hms_id(), new C0480(subscribeInfoCallbackM7605));
    }

    /* renamed from: ೲ, reason: contains not printable characters */
    public final void m1529() {
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
        C3608.m11650().m11653(str2, str, new C0453());
        e5.m5988().m5995();
        m1532(false);
    }

    /* renamed from: ഄ, reason: contains not printable characters */
    public final void m1530(boolean z, int i) {
        int visibility = this.f1011.f13695.getVisibility();
        if (!z || i <= 0) {
            if (visibility != 8) {
                this.f1011.f13695.setVisibility(8);
                return;
            }
            return;
        }
        if (visibility != 0) {
            this.f1011.f13695.setVisibility(0);
        }
        if (this.f1033 != i) {
            this.f1011.f13695.m2561(i + "");
            this.f1033 = i;
        }
    }

    /* renamed from: ഩ, reason: contains not printable characters */
    public final void m1531(boolean z) {
        if (z) {
            this.f1011.f13702.setImageResource(R.drawable.icon_34_player_fps_original);
        } else {
            this.f1011.f13702.setImageResource(R.drawable.icon_34_player_fps_changed);
        }
    }

    /* renamed from: ഺ, reason: contains not printable characters */
    public final void m1532(boolean z) {
        C4535.m13880().m13890();
        this.f1011.f13726.setSignState(e5.m5988().m5994());
        if (z) {
            this.f1011.f13726.m2583();
            C3744 c3744 = this.f1018;
            if (c3744 == null || this.f1024 == 3) {
                return;
            }
            c3744.m12008(1);
        }
    }

    /* renamed from: ൎ, reason: contains not printable characters */
    public final void m1533() {
        if (e5.m5988().m5993()) {
            return;
        }
        if (r1.m8142(n.m7588().m7605())) {
            this.f1011.f13726.m2595(null, 2);
        } else {
            n.m7588().m7604(new C0482(2));
        }
    }

    /* renamed from: ൔ, reason: contains not printable characters */
    public void m1534(boolean z, int i, String str, int i2) {
        AbstractC3958 abstractC3958 = this.f1011;
        if (abstractC3958 == null) {
            return;
        }
        if (!z) {
            abstractC3958.f13705.m4159(0);
            this.f1011.f13705.m4168(5);
            this.f1011.f13705.setCenterState(1);
            m1530(false, i);
            this.f1011.f13735.setVisibility(8);
            return;
        }
        this.f1011.f13705.m4159(!"Wi-Fi".equals(C3688.m11833(FilmApp.m402())) ? 1 : 0);
        this.f1011.f13705.m4168(i2);
        this.f1011.f13705.setCenterState(3);
        this.f1011.f13705.m4165(i, str);
        m1530(true, i);
        if (this.f1032 != i2) {
            this.f1011.f13695.setContentTextColor(getResources().getColor(TransmitHelper.getSignalColor(i2), null));
            this.f1011.f13705.m4168(i2);
            this.f1032 = i2;
        }
        if (!ACHelper.getInstance().isCloudPush()) {
            this.f1011.f13735.setVisibility(8);
            return;
        }
        this.f1011.f13735.setVisibility(0);
        String roomId = ACHelper.getInstance().getRoomId();
        if (r1.m8143(roomId) && !roomId.equals(this.f1011.f13735.getText().toString())) {
            this.f1011.f13735.setText(roomId);
        }
        this.f1011.f13735.m4174(ACHelper.getInstance().getWifiViewLevelByLevel(ACHelper.getInstance().wifiLevel(PingHelper.getInstance().getProtakeWifiStatus())));
    }

    /* renamed from: ൕ, reason: contains not printable characters */
    public final void m1535(String str) {
        this.f1011.f13734.m2561(str);
        ACHelper.getInstance().setAlbumDesStr(str);
    }

    /* renamed from: ൖ, reason: contains not printable characters */
    public final void m1536(String str) {
        this.f1011.f13736.m2561(str);
        ACHelper.getInstance().setAlbumTimelapseStr(str);
    }

    /* renamed from: ൟ, reason: contains not printable characters */
    public final void m1537(boolean z) {
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
            C3608.m11650().m11659(str, access_token, new C0478(zM5993));
        }
    }

    /* renamed from: ຆ, reason: contains not printable characters */
    public final void m1538(boolean z, int i) {
        if (!z) {
            this.f1011.f13692.m1603(i);
            C4008.m12886(this.f1011.f13681, 0.0f, 0.0f, i, null);
        } else {
            this.f1011.f13692.m1608(i);
            C4008.m12886(this.f1011.f13681, 0.0f, r4.getLayoutParams().height, i, null);
        }
    }

    /* renamed from: ຉ, reason: contains not printable characters */
    public final void m1539(boolean z, int i) {
        this.f1012 = z;
        if (!z) {
            C5049.m14852().m14859(false);
            this.f1048 = 0;
            m1502();
            m1552();
            m1553();
            m1554();
            m1514();
        }
        if (!z) {
            C4008.m12886(this.f1011.f13722, 0.0f, C4792.m14375().m14498() ? this.f1047 : this.f1046, i, null);
            C4008.m12886(this.f1011.f13681, 0.0f, 0.0f, i, null);
        } else {
            m1503();
            C4008.m12886(this.f1011.f13722, 0.0f, 0.0f, i, null);
            C4008.m12886(this.f1011.f13681, 0.0f, -(C4792.m14375().m14498() ? this.f1047 : this.f1046), i, null);
        }
    }

    /* renamed from: ຌ, reason: contains not printable characters */
    public final void m1540(boolean z, int i) throws Resources.NotFoundException {
        this.f1011.f13693.setVisibility(0);
        this.f1011.f13693.setAlpha(0.0f);
        this.f1011.f13693.m2909(z ? 13 : 5, null, i);
        C4008.m12876(this.f1011.f13693, 1.0f, 100, null);
    }

    /* renamed from: ຎ, reason: contains not printable characters */
    public final void m1541(String str) {
        this.f1011.f13694.m2580(str, false);
        this.f1030 = System.currentTimeMillis();
        if (!this.f1029) {
            this.f1029 = true;
            this.f1026 = false;
            m1549(0.0f, 1.0f, this.f1016);
            return;
        }
        this.f1017.removeMessages(201);
        ValueAnimator valueAnimator = this.f1025;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f1026 = true;
        }
        ValueAnimator valueAnimator2 = this.f1027;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f1028 = true;
        }
        this.f1026 = false;
        m1549(0.0f, 1.0f, 0L);
    }

    /* renamed from: ຏ, reason: contains not printable characters */
    public final void m1542() {
        m1543(-1);
    }

    /* renamed from: ຐ, reason: contains not printable characters */
    public final void m1543(int i) {
        C4689.m14213(this).m14230(C4792.m14375().m14498());
        C4689.m14213(this).m14232(this, new C0463(i));
    }

    /* renamed from: ຑ, reason: contains not printable characters */
    public final void m1544(boolean z) {
        C4689.m14213(this).m14230(C4792.m14375().m14498());
        C4689.m14213(this).m14233(new C0468(z), new C0470());
    }

    /* renamed from: ຒ, reason: contains not printable characters */
    public final void m1545() {
        if (!C2813.f10275) {
            m1541(getResources().getString(R.string.MONITOR_ERROR_H265_GENERAL));
            return;
        }
        if (r1.m8143(ACHelper.getInstance().getRoomId())) {
            this.f1018.m12016(ACHelper.getInstance().getRoomId());
        }
        C4008.m12877(this.f1011.f13720, 0.0f, 200, new C0553());
    }

    /* renamed from: ຓ, reason: contains not printable characters */
    public final void m1546() {
        this.f1011.f13713.postDelayed(new RunnableC0547(), 200L);
    }

    /* renamed from: ຘ, reason: contains not printable characters */
    public final void m1547(int i) {
        ViewGroup.LayoutParams layoutParams = this.f1011.f13716.getLayoutParams();
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
        this.f1011.f13716.setLayoutParams(layoutParams);
        this.f1011.f13717.m2984(layoutParams.width, layoutParams.height);
        this.f1011.f13717.setShowType(C5213.m15215() ? 1 : 0);
        this.f1011.f13717.m2985(new C0555(i));
        this.f1011.f13684.setVisibility(0);
        this.f1011.f13716.setAlpha(0.0f);
        this.f1011.f13716.setVisibility(0);
        C4008.m12876(this.f1011.f13716, 1.0f, 100, null);
    }

    /* renamed from: ຠ, reason: contains not printable characters */
    public final void m1548() {
        this.f1011.f13725.setVisibility(0);
        this.f1011.f13725.setAlpha(0.0f);
        this.f1011.f13725.m2908(18, null);
        this.f1011.f13725.setOnButtonClick(new C0450());
        C4008.m12876(this.f1011.f13725, 1.0f, 100, null);
    }

    /* renamed from: ຨ, reason: contains not printable characters */
    public final void m1549(float f, float f2, long j) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.f1025 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(j);
        this.f1025.setInterpolator(C4008.m12881());
        this.f1025.addUpdateListener(new C0551());
        this.f1025.addListener(new C0552());
        this.f1025.start();
    }

    /* renamed from: ຩ, reason: contains not printable characters */
    public final void m1550() {
        if (this.f1015 && this.f1011.f13712.m1594() && this.f1011.f13712.m1593()) {
            this.f1011.f13712.startButton.performClick();
        }
        this.f1015 = false;
        m1515();
        m1514();
        m1501();
        this.f1011.f13723.setValueAndUpdateUI(0.0f);
        ACHelper.getInstance().setAlbumPercent(0.0f);
    }

    /* renamed from: ຬ, reason: contains not printable characters */
    public final void m1551(boolean z) {
        MobSDK.submitPolicyGrantResult(z, new C0558());
    }

    /* renamed from: ໞ, reason: contains not printable characters */
    public final void m1552() {
        if (C5049.m14852().m14858()) {
            this.f1011.f13728.setVisibility(8);
            this.f1011.f13727.setVisibility(8);
            this.f1011.f13729.setVisibility(8);
            this.f1011.f13723.setVisibility(8);
            this.f1011.f13706.setVisibility(8);
            this.f1011.f13704.setVisibility(8);
            this.f1011.f13703.setVisibility(8);
            this.f1011.f13707.setVisibility(8);
            this.f1011.f13715.setVisibility(8);
            this.f1011.f13710.setVisibility(8);
            this.f1011.f13709.setVisibility(8);
            this.f1011.f13718.setVisibility(8);
            this.f1011.f13733.setVisibility(0);
            this.f1011.f13731.setVisibility(0);
            this.f1011.f13698.setVisibility(0);
            this.f1011.f13699.setVisibility(0);
            this.f1011.f13700.setVisibility(0);
            this.f1011.f13686.setVisibility(0);
            this.f1011.f13689.setVisibility(0);
            this.f1011.f13688.setVisibility(0);
            this.f1011.f13690.setVisibility(0);
            this.f1011.f13687.setVisibility(0);
            return;
        }
        this.f1011.f13728.setVisibility(0);
        this.f1011.f13727.setVisibility(0);
        this.f1011.f13729.setVisibility(0);
        this.f1011.f13723.setVisibility(0);
        this.f1011.f13706.setVisibility(0);
        this.f1011.f13704.setVisibility(0);
        this.f1011.f13703.setVisibility(0);
        this.f1011.f13707.setVisibility(0);
        this.f1011.f13715.setVisibility(0);
        this.f1011.f13710.setVisibility(0);
        this.f1011.f13709.setVisibility(0);
        this.f1011.f13718.setVisibility(0);
        this.f1011.f13733.setVisibility(8);
        this.f1011.f13731.setVisibility(8);
        this.f1011.f13698.setVisibility(8);
        this.f1011.f13699.setVisibility(8);
        this.f1011.f13700.setVisibility(8);
        this.f1011.f13686.setVisibility(8);
        this.f1011.f13689.setVisibility(8);
        this.f1011.f13688.setVisibility(8);
        this.f1011.f13690.setVisibility(8);
        this.f1011.f13687.setVisibility(8);
    }

    /* renamed from: ໟ, reason: contains not printable characters */
    public final void m1553() {
        if (C5049.m14852().m14858()) {
            return;
        }
        boolean z = false;
        if (r1.m8144(this.f1035)) {
            Iterator<C5202> it = this.f1035.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                it.next().m15174(false);
                z2 = true;
            }
            z = z2;
        }
        C4272 c4272 = this.f1013;
        if (c4272 == null || !z) {
            return;
        }
        c4272.notifyDataSetChanged();
    }

    /* renamed from: ྈ, reason: contains not printable characters */
    public final void m1554() {
        if (C5049.m14852().m14858()) {
            StringBuilder sb = new StringBuilder(getResources().getString(R.string.PLAYBACK_CANCEL));
            if (r1.m8144(this.f1035)) {
                Iterator<C5202> it = this.f1035.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next().m15172()) {
                        i++;
                    }
                }
                if (i > 0) {
                    sb.append(MyUTIL.white_space);
                    sb.append("(");
                    sb.append(i);
                    sb.append(")");
                    m1509(true);
                } else {
                    m1509(false);
                }
            }
            this.f1011.f13732.m2561(sb.toString().toUpperCase());
        } else {
            this.f1011.f13732.m2561(getResources().getString(R.string.PLAYBACK_SELECT).toUpperCase());
        }
        this.f1011.f13732.post(new RunnableC0536());
    }

    /* renamed from: ྉ, reason: contains not printable characters */
    public final void m1555() {
        m1502();
        if (this.f1048 != 5 && r1.m8144(this.f1035)) {
            for (C5202 c5202 : this.f1035) {
                c5202.m15174(false);
                C2628 c2628M15171 = c5202.m15171();
                int i = this.f1048;
                if (i == 1) {
                    c5202.m15174(true);
                } else if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && c2628M15171.m9630() == 1) {
                            c5202.m15174(true);
                        }
                    } else if (c2628M15171.m9596() == 1) {
                        c5202.m15174(true);
                    }
                } else if (c2628M15171.m9594() == 1) {
                    c5202.m15174(true);
                }
            }
            this.f1013.notifyDataSetChanged();
            m1554();
        }
    }
}
