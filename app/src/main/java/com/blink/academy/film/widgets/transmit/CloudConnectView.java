package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.srt.SRTConnectionCallbackEntity;
import com.blink.academy.film.netbean.store.NvtInfoCallbackEntity;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.stream.PingHelper;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.transmit.InputPwdView;
import com.blink.academy.protake.R;
import defpackage.AbstractC2802;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C4008;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.ViewOnTouchListenerC3426;
import defpackage.n;
import defpackage.r1;

/* loaded from: classes.dex */
public class CloudConnectView extends ConstraintLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2802 f4195;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4196;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Rect f4197;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f4198;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f4199;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f4200;

    /* renamed from: ֈ, reason: contains not printable characters */
    public ViewTreeObserver.OnGlobalLayoutListener f4201;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f4202;

    /* renamed from: ׯ, reason: contains not printable characters */
    public InterfaceC1576 f4203;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f4204;

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1552 implements View.OnClickListener {
        public ViewOnClickListenerC1552() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudConnectView.this.f4195.f10221.m4248();
            CloudConnectView.this.m4200();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1553 implements View.OnClickListener {
        public ViewOnClickListenerC1553() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudConnectView.this.f4195.f10221.m4249();
            if (CloudConnectView.this.f4203 != null) {
                CloudConnectView.this.f4203.mo4212();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1554 implements View.OnClickListener {
        public ViewOnClickListenerC1554() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            if (CloudConnectView.this.f4195.f10217.getAlpha() == 1.0f || CloudConnectView.this.f4200) {
                return;
            }
            CloudConnectView.this.f4200 = true;
            CloudConnectView cloudConnectView = CloudConnectView.this;
            cloudConnectView.m4209(cloudConnectView.getResources().getString(R.string.MONITOR_EXTEND_HINT), true);
            CloudConnectView.this.m4196();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$Ԭ, reason: contains not printable characters */
    public class RunnableC1555 implements Runnable {
        public RunnableC1555() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CloudConnectView.this.f4195.f10220.setAlpha(0.5f);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$Ԯ, reason: contains not printable characters */
    public class RunnableC1556 implements Runnable {
        public RunnableC1556() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CloudConnectView.this.f4195.f10220.setAlpha(1.0f);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ՠ, reason: contains not printable characters */
    public class RunnableC1557 implements Runnable {
        public RunnableC1557() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CloudConnectView.this.f4195.f10220.setAlpha(0.5f);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ֈ, reason: contains not printable characters */
    public class RunnableC1558 implements Runnable {
        public RunnableC1558() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CloudConnectView.this.f4195.f10220.setAlpha(1.0f);
            CloudConnectView.this.f4200 = false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$֏, reason: contains not printable characters */
    public class C1559 extends AbstractC4012 {
        public C1559() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            CloudConnectView.this.setVisibility(8);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ׯ, reason: contains not printable characters */
    public class AnimationAnimationListenerC1560 implements Animation.AnimationListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4213;

        public AnimationAnimationListenerC1560(boolean z) {
            this.f4213 = z;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f4213) {
                CloudConnectView.this.m4201(3000L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ؠ, reason: contains not printable characters */
    public class AnimationAnimationListenerC1561 implements Animation.AnimationListener {
        public AnimationAnimationListenerC1561() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (CloudConnectView.this.f4204) {
                CloudConnectView.this.f4195.f10225.setVisibility(4);
                CloudConnectView.this.f4204 = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ހ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1562 implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC1562() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (CloudConnectView.this.f4202) {
                CloudConnectView cloudConnectView = CloudConnectView.this;
                cloudConnectView.f4195.f10226.getWindowVisibleDisplayFrame(cloudConnectView.f4197);
                if (CloudConnectView.this.f4195.f10226.getRootView().getHeight() - CloudConnectView.this.f4197.bottom <= 100) {
                    if (CloudConnectView.this.f4198 != 0) {
                        CloudConnectView.this.f4198 = 0;
                        C4008.m12886(CloudConnectView.this.f4195.f10218, 0.0f, 0.0f, 100, null);
                        C4008.m12886(CloudConnectView.this.f4195.f10219, 0.0f, 0.0f, 100, null);
                        C4008.m12886(CloudConnectView.this.f4195.f10225, 0.0f, 0.0f, 100, null);
                    }
                    CloudConnectView.this.f4199 = false;
                    return;
                }
                int iM9438 = ((int) ((-(C2579.f9593 - CloudConnectView.this.f4197.height())) / 2.0f)) - C2579.m9438(20.0f);
                if (iM9438 != CloudConnectView.this.f4198) {
                    CloudConnectView.this.f4198 = iM9438;
                    C4008.m12886(CloudConnectView.this.f4195.f10218, 0.0f, r4.f4198, 100, null);
                    C4008.m12886(CloudConnectView.this.f4195.f10219, 0.0f, -r0, 100, null);
                    int i = CloudConnectView.this.f4198;
                    if (Math.abs(CloudConnectView.this.f4198) > C2579.m9438(50.0f)) {
                        i = -C2579.m9438(40.0f);
                    }
                    C4008.m12886(CloudConnectView.this.f4195.f10225, 0.0f, i, 100, null);
                }
                CloudConnectView.this.f4199 = true;
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ށ, reason: contains not printable characters */
    public class ViewOnClickListenerC1563 implements View.OnClickListener {
        public ViewOnClickListenerC1563() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ނ, reason: contains not printable characters */
    public class ViewOnClickListenerC1564 implements View.OnClickListener {
        public ViewOnClickListenerC1564() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ރ, reason: contains not printable characters */
    public class C1565 implements InputPwdView.InterfaceC1591 {
        public C1565() {
        }

        @Override // com.blink.academy.film.widgets.transmit.InputPwdView.InterfaceC1591
        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo4210() {
            return CloudConnectView.this.f4199;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ބ, reason: contains not printable characters */
    public class ViewOnClickListenerC1566 implements View.OnClickListener {
        public ViewOnClickListenerC1566() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudConnectView.this.f4196 = 0;
            CloudConnectView.this.m4197(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ޅ, reason: contains not printable characters */
    public class ViewOnClickListenerC1567 implements View.OnClickListener {
        public ViewOnClickListenerC1567() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudConnectView.this.f4196 = 1;
            CloudConnectView.this.m4197(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ކ, reason: contains not printable characters */
    public class ViewOnClickListenerC1568 implements View.OnClickListener {
        public ViewOnClickListenerC1568() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudConnectView.this.f4196 = 2;
            CloudConnectView.this.m4197(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$އ, reason: contains not printable characters */
    public class ViewOnClickListenerC1569 implements View.OnClickListener {
        public ViewOnClickListenerC1569() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudConnectView.this.f4196 = 3;
            CloudConnectView.this.m4197(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ވ, reason: contains not printable characters */
    public class ViewOnClickListenerC1570 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ވ$Ϳ, reason: contains not printable characters */
        public class C1571 implements n.InterfaceC2189 {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ String f4225;

            /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ވ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC1572 implements Runnable {

                /* renamed from: ԫ, reason: contains not printable characters */
                public final /* synthetic */ ApiException f4227;

                public RunnableC1572(ApiException apiException) {
                    this.f4227 = apiException;
                }

                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    CloudConnectView.this.f4195.f10217.setVisibility(0);
                    CloudConnectView.this.f4195.f10223.setVisibility(4);
                    if (this.f4227.getCode() == 409) {
                        CloudConnectView cloudConnectView = CloudConnectView.this;
                        cloudConnectView.m4209(String.format(cloudConnectView.getResources().getString(R.string.MONITOR_STATUES_COULD_CAMERA_NOT_FOUND), C1571.this.f4225 + ""), true);
                        return;
                    }
                    if (this.f4227.getCode() == 420) {
                        FinderManager.getInstance().updateRemoteMap(CloudConnectView.this.getMachineNameByIndex(), C1571.this.f4225);
                        C2618.m9573("remote_last_input_room_id_sp", C1571.this.f4225);
                        if (CloudConnectView.this.f4203 != null) {
                            CloudConnectView.this.f4203.mo4213(CloudConnectView.this.f4196);
                        }
                        CloudConnectView.this.f4195.f10221.m4248();
                        CloudConnectView.this.m4200();
                        return;
                    }
                    if (this.f4227.getCode() == 429) {
                        CloudConnectView cloudConnectView2 = CloudConnectView.this;
                        cloudConnectView2.m4209(cloudConnectView2.getResources().getString(R.string.MONITOR_STATUES_CANNOT_CONNECT_TO_INTERNET), true);
                        return;
                    }
                    if (this.f4227.getCode() == 403) {
                        FinderManager.getInstance().updateRemoteMap(CloudConnectView.this.getMachineNameByIndex(), C1571.this.f4225);
                        C2618.m9573("remote_last_input_room_id_sp", C1571.this.f4225);
                        if (CloudConnectView.this.f4203 != null) {
                            CloudConnectView.this.f4203.mo4213(CloudConnectView.this.f4196);
                        }
                        CloudConnectView.this.f4195.f10221.m4248();
                        CloudConnectView.this.m4200();
                        return;
                    }
                    if (this.f4227.getCode() == 423) {
                        FinderManager.getInstance().updateRemoteMap(CloudConnectView.this.getMachineNameByIndex(), C1571.this.f4225);
                        C2618.m9573("remote_last_input_room_id_sp", C1571.this.f4225);
                        if (CloudConnectView.this.f4203 != null) {
                            CloudConnectView.this.f4203.mo4213(CloudConnectView.this.f4196);
                        }
                        CloudConnectView.this.f4195.f10221.m4248();
                        CloudConnectView.this.m4200();
                        return;
                    }
                    if (this.f4227.getCode() == 401) {
                        CloudConnectView cloudConnectView3 = CloudConnectView.this;
                        cloudConnectView3.m4209(cloudConnectView3.getResources().getString(R.string.MONITOR_STATUES_CANNOT_CONNECT_TO_PROTAKE_CLOUD), true);
                        return;
                    }
                    int netState = PingHelper.getInstance().getNetState();
                    if (netState == 2) {
                        CloudConnectView cloudConnectView4 = CloudConnectView.this;
                        cloudConnectView4.m4209(cloudConnectView4.getResources().getString(R.string.MONITOR_STATUES_CANNOT_CONNECT_TO_PROTAKE_CLOUD), true);
                    } else if (netState == 0 || netState == 1) {
                        CloudConnectView cloudConnectView5 = CloudConnectView.this;
                        cloudConnectView5.m4209(cloudConnectView5.getResources().getString(R.string.MONITOR_STATUES_CANNOT_CONNECT_TO_INTERNET), true);
                    }
                }
            }

            /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ވ$Ϳ$Ԩ, reason: contains not printable characters */
            public class RunnableC1573 implements Runnable {
                public RunnableC1573() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    FinderManager.getInstance().updateRemoteMap(CloudConnectView.this.getMachineNameByIndex(), C1571.this.f4225);
                    C2618.m9573("remote_last_input_room_id_sp", C1571.this.f4225);
                    if (CloudConnectView.this.f4203 != null) {
                        CloudConnectView.this.f4203.mo4213(CloudConnectView.this.f4196);
                    }
                    CloudConnectView.this.f4195.f10221.m4248();
                    CloudConnectView.this.m4200();
                }
            }

            public C1571(String str) {
                this.f4225 = str;
            }

            @Override // defpackage.n.InterfaceC2189
            public void onFail(ApiException apiException) {
                C4638.m14097();
                FilmApp.m405().m427(new RunnableC1572(apiException));
            }

            @Override // defpackage.n.InterfaceC2189
            public void onSuc(SRTConnectionCallbackEntity sRTConnectionCallbackEntity) {
                C4638.m14097();
                FilmApp.m405().m427(new RunnableC1573());
            }
        }

        public ViewOnClickListenerC1570() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CloudConnectView.this.f4195.f10217.getVisibility() != 0) {
                return;
            }
            String code = CloudConnectView.this.f4195.f10221.getCode();
            if (r1.m8143(code)) {
                String upperCase = code.toUpperCase();
                if (r1.m8143(upperCase) && upperCase.length() == 6) {
                    CloudConnectView.this.f4195.f10217.setVisibility(4);
                    CloudConnectView.this.f4195.f10223.setVisibility(0);
                    n.m7588().m7599(new C1571(upperCase), false, upperCase);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$މ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1574 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public StrokeTextViewWithBottomBlock f4230;

        /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$މ$Ϳ, reason: contains not printable characters */
        public class RunnableC1575 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4231;

            public RunnableC1575(View view) {
                this.f4231 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4231.isEnabled()) {
                    ViewOnTouchListenerC1574.this.f4230.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1574(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock) {
            this.f4230 = strokeTextViewWithBottomBlock;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (this.f4230.m2574()) {
                    return false;
                }
                this.f4230.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler(Looper.myLooper()).postDelayed(new RunnableC1575(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudConnectView$ފ, reason: contains not printable characters */
    public interface InterfaceC1576 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo4212();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo4213(int i);
    }

    public CloudConnectView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMachineNameByIndex() {
        int i = this.f4196;
        return i != 0 ? i != 1 ? i != 2 ? FinderManager.MACHINE_D : FinderManager.MACHINE_C : "2" : "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ލ, reason: contains not printable characters */
    public /* synthetic */ void m4195(long j) throws Resources.NotFoundException {
        if (j == -1) {
            this.f4195.f10225.setVisibility(4);
        } else if (this.f4195.f10225.getVisibility() == 0) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.actionbar_translate_exit);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1561());
            this.f4195.f10225.startAnimation(animationLoadAnimation);
        }
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m4196() {
        postDelayed(new RunnableC1555(), 300L);
        postDelayed(new RunnableC1556(), 400L);
        postDelayed(new RunnableC1557(), 600L);
        postDelayed(new RunnableC1558(), 700L);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m4197(boolean z) {
        int i = z ? 100 : 0;
        int i2 = this.f4196;
        if (i2 == 0) {
            this.f4195.f10211.m2575(true, i);
            this.f4195.f10212.m2575(false, i);
            this.f4195.f10213.m2575(false, i);
            this.f4195.f10214.m2575(false, i);
            return;
        }
        if (i2 == 1) {
            this.f4195.f10211.m2575(false, i);
            this.f4195.f10212.m2575(true, i);
            this.f4195.f10213.m2575(false, i);
            this.f4195.f10214.m2575(false, i);
            return;
        }
        if (i2 == 2) {
            this.f4195.f10211.m2575(false, i);
            this.f4195.f10212.m2575(false, i);
            this.f4195.f10213.m2575(true, i);
            this.f4195.f10214.m2575(false, i);
            return;
        }
        if (i2 != 3) {
            return;
        }
        this.f4195.f10211.m2575(false, i);
        this.f4195.f10212.m2575(false, i);
        this.f4195.f10213.m2575(false, i);
        this.f4195.f10214.m2575(true, i);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m4198() {
        if (FinderManager.getInstance().machineCanConnRemote("1")) {
            this.f4195.f10211.setBottomBgColor(getResources().getColor(R.color.colorTransmitBlue, null));
            this.f4195.f10211.setTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
        } else {
            this.f4195.f10211.setBottomBgColor(-1);
            this.f4195.f10211.setTextColor(-1);
        }
        if (FinderManager.getInstance().machineCanConnRemote("2")) {
            this.f4195.f10212.setBottomBgColor(getResources().getColor(R.color.colorTransmitBlue, null));
            this.f4195.f10212.setTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
        } else {
            this.f4195.f10212.setBottomBgColor(-1);
            this.f4195.f10212.setTextColor(-1);
        }
        if (FinderManager.getInstance().machineCanConnRemote(FinderManager.MACHINE_C)) {
            this.f4195.f10213.setBottomBgColor(getResources().getColor(R.color.colorTransmitBlue, null));
            this.f4195.f10213.setTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
        } else {
            this.f4195.f10213.setBottomBgColor(-1);
            this.f4195.f10213.setTextColor(-1);
        }
        if (FinderManager.getInstance().machineCanConnRemote(FinderManager.MACHINE_D)) {
            this.f4195.f10214.setBottomBgColor(getResources().getColor(R.color.colorTransmitBlue, null));
            this.f4195.f10214.setTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
        } else {
            this.f4195.f10214.setBottomBgColor(-1);
            this.f4195.f10214.setTextColor(-1);
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final int m4199() {
        if (!FinderManager.getInstance().machineCanConnRemote(FinderManager.MACHINE_D)) {
            return 3;
        }
        if (!FinderManager.getInstance().machineCanConnRemote(FinderManager.MACHINE_C)) {
            return 2;
        }
        if (FinderManager.getInstance().machineCanConnRemote("2")) {
            return !FinderManager.getInstance().machineCanConnRemote("1") ? 0 : 3;
        }
        return 1;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m4200() {
        this.f4202 = false;
        this.f4199 = false;
        this.f4195.f10226.getViewTreeObserver().removeOnGlobalLayoutListener(this.f4201);
        m4201(-1L);
        C4008.m12876(this, 0.0f, 200, new C1559());
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m4201(final long j) {
        if (this.f4195.f10225.getVisibility() != 0 || this.f4204) {
            this.f4195.f10225.setVisibility(4);
            this.f4204 = false;
        } else {
            this.f4204 = true;
            FilmApp.m405().m428(new Runnable() { // from class: օ
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f11441.m4195(j);
                }
            }, j);
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m4202() {
        this.f4195 = AbstractC2802.m10122(LayoutInflater.from(getContext()), this, true);
        if (C2579.m9451(getContext())) {
            m4205();
        } else {
            m4203();
        }
        m4204();
        m4197(false);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m4203() {
        float fM14471 = C4792.m14375().m14471();
        float fM14381 = (int) ((C4792.m14375().m14381() * fM14471) + 0.5f);
        m4207(this.f4195.f10211, fM14381, "A");
        m4207(this.f4195.f10212, fM14381, TransmitHelper.CAMERA_UNIT_B_CONTENT);
        m4207(this.f4195.f10213, fM14381, TransmitHelper.CAMERA_UNIT_C_CONTENT);
        m4207(this.f4195.f10214, fM14381, TransmitHelper.CAMERA_UNIT_D_CONTENT);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4195.f10221.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14479(35.0f, fM14471);
        this.f4195.f10221.setLayoutParams(layoutParams);
        int iM14476 = C4792.m14375().m14476(15);
        int iM144762 = (int) (C4792.m14375().m14476(70) / 2.0f);
        this.f4195.f10211.setPadding(iM144762, iM14476, iM144762, iM14476);
        this.f4195.f10212.setPadding(iM144762, iM14476, iM144762, iM14476);
        this.f4195.f10213.setPadding(iM144762, iM14476, iM144762, iM14476);
        this.f4195.f10214.setPadding(iM144762, iM14476, iM144762, iM14476);
        int iM14479 = C4792.m14375().m14479(-10.0f, fM14471);
        this.f4195.f10211.setBottomBlockMargin(iM14479);
        this.f4195.f10212.setBottomBlockMargin(iM14479);
        this.f4195.f10213.setBottomBlockMargin(iM14479);
        this.f4195.f10214.setBottomBlockMargin(iM14479);
        int iM144763 = C4792.m14375().m14476(10);
        this.f4195.f10211.setBottomBlockHeight(iM144763);
        this.f4195.f10212.setBottomBlockHeight(iM144763);
        this.f4195.f10213.setBottomBlockHeight(iM144763);
        this.f4195.f10214.setBottomBlockHeight(iM144763);
        this.f4195.f10230.setContentTypeFace(FilmApp.m404());
        float fM14377 = (int) ((C4792.m14375().m14377() * fM14471) + 0.5f);
        this.f4195.f10230.m2562(0, fM14377);
        this.f4195.f10230.setTextColor(-1);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4195.f10231.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = C4792.m14375().m14479(44.0f, fM14471);
        this.f4195.f10231.setLayoutParams(layoutParams2);
        this.f4195.f10231.setContentTypeFace(FilmApp.m404());
        this.f4195.f10231.m2562(0, fM14377);
        this.f4195.f10231.setTextColor(-1);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4195.f10217.getLayoutParams();
        this.f4195.f10217.setBackgroundResource(R.drawable.shap_bg_blue_5dp);
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = C4792.m14375().m14476(90);
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = C4792.m14375().m14476(20);
        this.f4195.f10217.setLayoutParams(layoutParams3);
        int iM144764 = C4792.m14375().m14476(60);
        this.f4195.f10228.setTextSize(0, fM14381);
        this.f4195.f10228.setTypeface(FilmApp.m403());
        this.f4195.f10228.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4195.f10228.setPadding(iM144764, 0, iM144764, 0);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4195.f10216.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = ((ViewGroup.MarginLayoutParams) layoutParams3).height;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) ((iM144764 * 2) + this.f4195.f10228.getPaint().measureText(this.f4195.f10228.getText().toString()));
        this.f4195.f10216.setLayoutParams(layoutParams4);
        int iM144765 = C4792.m14375().m14476(60);
        this.f4195.f10224.setTextSize(0, C4792.m14375().m14377());
        this.f4195.f10224.setTypeface(FilmApp.m404());
        this.f4195.f10224.setPadding(iM144765, 0, iM144765, 0);
        ViewGroup.LayoutParams layoutParams5 = this.f4195.f10225.getLayoutParams();
        int iM144766 = C4792.m14375().m14476(70);
        layoutParams5.height = iM144766;
        this.f4195.f10225.setRadius(iM144766 / 2.0f);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f4195.f10222.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = C4792.m14375().m14479(100.0f, fM14471);
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = C4792.m14375().m14479(50.0f, fM14471);
        this.f4195.f10222.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f4195.f10215.getLayoutParams();
        layoutParams7.width = C4792.m14375().m14479(60.0f, fM14471);
        layoutParams7.height = C4792.m14375().m14479(60.0f, fM14471);
        this.f4195.f10215.setLayoutParams(layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f4195.f10219.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin + ((C2579.m9438(44.0f) - layoutParams7.width) / 2);
        ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = C4792.m14375().m14476(40);
        this.f4195.f10219.setLayoutParams(layoutParams8);
        this.f4195.f10227.setTypeface(FilmApp.m403());
        this.f4195.f10227.setTextSize(0, fM14377);
        this.f4195.f10227.setText(R.string.BUTTON_EXTEND);
        this.f4195.f10229.m2562(0, fM14377);
        this.f4195.f10229.setContentTextColor(-1);
        TextPaint paint = this.f4195.f10229.getPaint();
        int iM144767 = C4792.m14375().m14476(15);
        int iM144768 = C4792.m14375().m14476(25);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = (int) (fontMetrics.descent - fontMetrics.ascent);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f4195.f10220.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams9).leftMargin = C4792.m14375().m14476(35);
        ((ViewGroup.MarginLayoutParams) layoutParams9).width = (int) (paint.measureText(getContext().getString(R.string.BUTTON_EXTEND).toUpperCase()) + (iM144768 * 2));
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = (int) (f + (iM144767 * 2));
        this.f4195.f10220.setLayoutParams(layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f4195.f10225.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).topMargin = C2579.m9438(50.0f);
        this.f4195.f10225.setLayoutParams(layoutParams10);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m4204() {
        setOnClickListener(new ViewOnClickListenerC1563());
        this.f4195.f10218.setOnClickListener(new ViewOnClickListenerC1564());
        this.f4195.f10221.setOnInputCallback(new C1565());
        this.f4195.f10211.setOnClickListener(new ViewOnClickListenerC1566());
        this.f4195.f10212.setOnClickListener(new ViewOnClickListenerC1567());
        this.f4195.f10213.setOnClickListener(new ViewOnClickListenerC1568());
        this.f4195.f10214.setOnClickListener(new ViewOnClickListenerC1569());
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock = this.f4195.f10211;
        strokeTextViewWithBottomBlock.setOnTouchListener(new ViewOnTouchListenerC1574(strokeTextViewWithBottomBlock));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock2 = this.f4195.f10212;
        strokeTextViewWithBottomBlock2.setOnTouchListener(new ViewOnTouchListenerC1574(strokeTextViewWithBottomBlock2));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock3 = this.f4195.f10213;
        strokeTextViewWithBottomBlock3.setOnTouchListener(new ViewOnTouchListenerC1574(strokeTextViewWithBottomBlock3));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock4 = this.f4195.f10214;
        strokeTextViewWithBottomBlock4.setOnTouchListener(new ViewOnTouchListenerC1574(strokeTextViewWithBottomBlock4));
        this.f4195.f10217.setOnClickListener(new ViewOnClickListenerC1570());
        RelativeLayout relativeLayout = this.f4195.f10217;
        relativeLayout.setOnTouchListener(new ViewOnTouchListenerC3426(relativeLayout));
        this.f4195.f10222.setOnClickListener(new ViewOnClickListenerC1552());
        RelativeLayout relativeLayout2 = this.f4195.f10222;
        relativeLayout2.setOnTouchListener(new ViewOnTouchListenerC3426(relativeLayout2));
        this.f4195.f10220.setOnClickListener(new ViewOnClickListenerC1553());
        FrameLayout frameLayout = this.f4195.f10220;
        frameLayout.setOnTouchListener(new ViewOnTouchListenerC3426(frameLayout));
        this.f4195.f10216.setOnClickListener(new ViewOnClickListenerC1554());
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m4205() {
        float fM14471 = C4792.m14375().m14471();
        float fM14381 = (int) ((C4792.m14375().m14381() * fM14471) + 0.5f);
        m4207(this.f4195.f10211, fM14381, "A");
        m4207(this.f4195.f10212, fM14381, TransmitHelper.CAMERA_UNIT_B_CONTENT);
        m4207(this.f4195.f10213, fM14381, TransmitHelper.CAMERA_UNIT_C_CONTENT);
        m4207(this.f4195.f10214, fM14381, TransmitHelper.CAMERA_UNIT_D_CONTENT);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4195.f10221.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14479(35.0f, fM14471);
        this.f4195.f10221.setLayoutParams(layoutParams);
        int iM14476 = C4792.m14375().m14476(30);
        int iM144762 = (int) (C4792.m14375().m14476(70) / 2.0f);
        this.f4195.f10211.setPadding(iM144762, iM14476, iM144762, iM14476);
        this.f4195.f10212.setPadding(iM144762, iM14476, iM144762, iM14476);
        this.f4195.f10213.setPadding(iM144762, iM14476, iM144762, iM14476);
        this.f4195.f10214.setPadding(iM144762, iM14476, iM144762, iM14476);
        int iM14479 = C4792.m14375().m14479(-10.0f, fM14471);
        this.f4195.f10211.setBottomBlockMargin(iM14479);
        this.f4195.f10212.setBottomBlockMargin(iM14479);
        this.f4195.f10213.setBottomBlockMargin(iM14479);
        this.f4195.f10214.setBottomBlockMargin(iM14479);
        int iM144763 = C4792.m14375().m14476(10);
        this.f4195.f10211.setBottomBlockHeight(iM144763);
        this.f4195.f10212.setBottomBlockHeight(iM144763);
        this.f4195.f10213.setBottomBlockHeight(iM144763);
        this.f4195.f10214.setBottomBlockHeight(iM144763);
        this.f4195.f10230.setContentTypeFace(FilmApp.m404());
        float fM14377 = (int) ((C4792.m14375().m14377() * fM14471) + 0.5f);
        this.f4195.f10230.m2562(0, fM14377);
        this.f4195.f10230.setTextColor(-1);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4195.f10231.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = C4792.m14375().m14479(44.0f, fM14471);
        this.f4195.f10231.setLayoutParams(layoutParams2);
        this.f4195.f10231.setContentTypeFace(FilmApp.m404());
        this.f4195.f10231.m2562(0, fM14377);
        this.f4195.f10231.setTextColor(-1);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4195.f10217.getLayoutParams();
        this.f4195.f10217.setBackgroundResource(R.drawable.shap_bg_blue_6dp);
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = C4792.m14375().m14476(110);
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = C4792.m14375().m14476(40);
        this.f4195.f10217.setLayoutParams(layoutParams3);
        int iM144764 = C4792.m14375().m14476(70);
        this.f4195.f10228.setTextSize(0, C4792.m14375().m14380());
        this.f4195.f10228.setTypeface(FilmApp.m403());
        this.f4195.f10228.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4195.f10228.setPadding(iM144764, 0, iM144764, 0);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4195.f10216.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = ((ViewGroup.MarginLayoutParams) layoutParams3).height;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) ((iM144764 * 2) + this.f4195.f10228.getPaint().measureText(this.f4195.f10228.getText().toString()));
        this.f4195.f10216.setLayoutParams(layoutParams4);
        int iM144765 = C4792.m14375().m14476(60);
        this.f4195.f10224.setTextSize(0, C4792.m14375().m14377());
        this.f4195.f10224.setTypeface(FilmApp.m404());
        this.f4195.f10224.setPadding(iM144765, 0, iM144765, 0);
        ViewGroup.LayoutParams layoutParams5 = this.f4195.f10225.getLayoutParams();
        int iM144766 = C4792.m14375().m14476(70);
        layoutParams5.height = iM144766;
        this.f4195.f10225.setRadius(iM144766 / 2.0f);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f4195.f10222.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = C4792.m14375().m14479(100.0f, fM14471);
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = C4792.m14375().m14479(50.0f, fM14471);
        this.f4195.f10222.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f4195.f10215.getLayoutParams();
        layoutParams7.width = C4792.m14375().m14479(60.0f, fM14471);
        layoutParams7.height = C4792.m14375().m14479(60.0f, fM14471);
        this.f4195.f10215.setLayoutParams(layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f4195.f10219.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin + ((C2579.m9438(44.0f) - layoutParams7.width) / 2);
        ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = C4792.m14375().m14476(40);
        this.f4195.f10219.setLayoutParams(layoutParams8);
        this.f4195.f10227.setTypeface(FilmApp.m404());
        this.f4195.f10227.setTextSize(0, fM14377);
        this.f4195.f10227.setText(R.string.BUTTON_EXTEND);
        this.f4195.f10229.m2562(0, fM14377);
        this.f4195.f10229.setContentTextColor(-1);
        TextPaint paint = this.f4195.f10229.getPaint();
        int iM144767 = C4792.m14375().m14476(23);
        int iM144768 = C4792.m14375().m14476(26);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = (int) (fontMetrics.descent - fontMetrics.ascent);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f4195.f10220.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams9).leftMargin = C4792.m14375().m14476(25);
        ((ViewGroup.MarginLayoutParams) layoutParams9).width = (int) (paint.measureText(getContext().getString(R.string.BUTTON_EXTEND).toUpperCase()) + (iM144768 * 2));
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = (int) (f + (iM144767 * 2));
        this.f4195.f10220.setLayoutParams(layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f4195.f10225.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).topMargin = C2579.m9438(50.0f);
        this.f4195.f10225.setLayoutParams(layoutParams10);
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m4206() {
        boolean z;
        NvtInfoCallbackEntity nvtInfoCallbackEntityM7595 = n.m7588().m7595();
        if (nvtInfoCallbackEntityM7595 != null) {
            long jMax = Math.max(0L, nvtInfoCallbackEntityM7595.getBalance());
            int i = (int) (jMax / 60);
            if (i < 5) {
                this.f4195.f10229.setContentTextColor(getResources().getColor(R.color.colorRed, null));
            } else {
                this.f4195.f10229.setContentTextColor(-1);
            }
            z = jMax > 0;
            this.f4195.f10229.m2561(String.format(getResources().getString(R.string.MONITOR_TIME_LEFT_TIME2), "" + i));
        } else {
            this.f4195.f10229.m2561("N/A");
            z = false;
        }
        if (z) {
            this.f4195.f10217.setAlpha(1.0f);
            this.f4195.f10217.setEnabled(true);
            this.f4195.f10216.setVisibility(8);
        } else {
            this.f4195.f10217.setAlpha(0.3f);
            this.f4195.f10217.setEnabled(false);
            this.f4195.f10216.setVisibility(0);
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m4207(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, float f, String str) {
        strokeTextViewWithBottomBlock.m2576(0, f);
        strokeTextViewWithBottomBlock.setTextColor(-1);
        strokeTextViewWithBottomBlock.setText(str);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m4208(InterfaceC1576 interfaceC1576) {
        int iM4199 = m4199();
        this.f4203 = interfaceC1576;
        this.f4196 = iM4199;
        this.f4202 = true;
        m4197(false);
        m4198();
        this.f4195.f10223.setVisibility(8);
        this.f4195.f10217.setVisibility(0);
        this.f4195.f10221.m4256();
        this.f4195.f10226.getViewTreeObserver().addOnGlobalLayoutListener(this.f4201);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m4209(String str, boolean z) throws Resources.NotFoundException {
        this.f4195.f10224.setText(str.toUpperCase());
        if (this.f4195.f10225.getVisibility() == 4) {
            this.f4195.f10225.setVisibility(0);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.actionbar_translate_enter);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1560(z));
            this.f4195.f10225.startAnimation(animationLoadAnimation);
        }
    }

    public CloudConnectView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloudConnectView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4196 = 3;
        this.f4197 = new Rect();
        this.f4198 = 0;
        this.f4199 = false;
        this.f4201 = new ViewTreeObserverOnGlobalLayoutListenerC1562();
        this.f4204 = false;
        m4202();
    }
}
