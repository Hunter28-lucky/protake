package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.support.controller.StoreController;
import com.blink.academy.protake.R;

/* compiled from: PaymentDialog.java */
/* renamed from: ക, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4689 {

    /* renamed from: ޏ, reason: contains not printable characters */
    public static C4689 f15910;

    /* renamed from: ސ, reason: contains not printable characters */
    public static Context f15911;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Dialog f15912 = new Dialog(f15911);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public View f15913;

    /* renamed from: ԩ, reason: contains not printable characters */
    public View f15914;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public View f15915;

    /* renamed from: ԫ, reason: contains not printable characters */
    public View f15916;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public TextView f15917;

    /* renamed from: ԭ, reason: contains not printable characters */
    public TextView f15918;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public TextView f15919;

    /* renamed from: ԯ, reason: contains not printable characters */
    public TextView f15920;

    /* renamed from: ՠ, reason: contains not printable characters */
    public View f15921;

    /* renamed from: ֈ, reason: contains not printable characters */
    public TextView f15922;

    /* renamed from: ֏, reason: contains not printable characters */
    public TextView f15923;

    /* renamed from: ׯ, reason: contains not printable characters */
    public TextView f15924;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final LinearLayout f15925;

    /* renamed from: ހ, reason: contains not printable characters */
    public final TextView f15926;

    /* renamed from: ށ, reason: contains not printable characters */
    public final TextView f15927;

    /* renamed from: ނ, reason: contains not printable characters */
    public final View f15928;

    /* renamed from: ރ, reason: contains not printable characters */
    public final LinearLayout f15929;

    /* renamed from: ބ, reason: contains not printable characters */
    public final ImageView f15930;

    /* renamed from: ޅ, reason: contains not printable characters */
    public final ImageView f15931;

    /* renamed from: ކ, reason: contains not printable characters */
    public final ImageView f15932;

    /* renamed from: އ, reason: contains not printable characters */
    public final ImageView f15933;

    /* renamed from: ވ, reason: contains not printable characters */
    public final float f15934;

    /* renamed from: މ, reason: contains not printable characters */
    public final LinearLayout f15935;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f15936;

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean f15937;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f15938;

    /* renamed from: ލ, reason: contains not printable characters */
    public InterfaceC4697 f15939;

    /* renamed from: ގ, reason: contains not printable characters */
    public InterfaceC4696 f15940;

    /* compiled from: PaymentDialog.java */
    /* renamed from: ക$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC4690 implements View.OnClickListener {
        public ViewOnClickListenerC4690() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C4689.this.m14222();
            if (C4689.this.f15940 != null) {
                C4689.this.f15940.mo1332();
            }
        }
    }

    /* compiled from: PaymentDialog.java */
    /* renamed from: ക$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC4691 implements View.OnClickListener {
        public ViewOnClickListenerC4691() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: PaymentDialog.java */
    /* renamed from: ക$Ԫ, reason: contains not printable characters */
    public class ViewOnTouchListenerC4692 implements View.OnTouchListener {
        public ViewOnTouchListenerC4692() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                C4689.this.f15917.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            C4689.this.f15917.setAlpha(1.0f);
            return false;
        }
    }

    /* compiled from: PaymentDialog.java */
    /* renamed from: ക$Ԭ, reason: contains not printable characters */
    public class ViewOnTouchListenerC4693 implements View.OnTouchListener {
        public ViewOnTouchListenerC4693() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                C4689.this.f15918.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            C4689.this.f15918.setAlpha(1.0f);
            return false;
        }
    }

    /* compiled from: PaymentDialog.java */
    /* renamed from: ക$Ԯ, reason: contains not printable characters */
    public class ViewOnTouchListenerC4694 implements View.OnTouchListener {
        public ViewOnTouchListenerC4694() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                C4689.this.f15919.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            C4689.this.f15919.setAlpha(1.0f);
            return false;
        }
    }

    /* compiled from: PaymentDialog.java */
    /* renamed from: ക$ՠ, reason: contains not printable characters */
    public class ViewOnTouchListenerC4695 implements View.OnTouchListener {
        public ViewOnTouchListenerC4695() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                C4689.this.f15920.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            C4689.this.f15920.setAlpha(1.0f);
            return false;
        }
    }

    /* compiled from: PaymentDialog.java */
    /* renamed from: ക$ֈ, reason: contains not printable characters */
    public interface InterfaceC4696 {
        /* renamed from: Ϳ */
        void mo1332();
    }

    /* compiled from: PaymentDialog.java */
    /* renamed from: ക$֏, reason: contains not printable characters */
    public interface InterfaceC4697 {
        /* renamed from: Ϳ */
        void mo1331(int i);
    }

    public C4689() {
        View viewInflate = View.inflate(f15911, R.layout.layout_payment_dialog_content, null);
        this.f15916 = viewInflate.findViewById(R.id.payment_dialog_content);
        this.f15925 = (LinearLayout) viewInflate.findViewById(R.id.payment_content);
        this.f15913 = viewInflate.findViewById(R.id.payment_alipay);
        this.f15914 = viewInflate.findViewById(R.id.payment_wechat);
        this.f15915 = viewInflate.findViewById(R.id.payment_google);
        this.f15928 = viewInflate.findViewById(R.id.payment_huawei);
        this.f15929 = (LinearLayout) viewInflate.findViewById(R.id.payment_type_parent);
        this.f15935 = (LinearLayout) viewInflate.findViewById(R.id.title_parent);
        this.f15917 = (TextView) viewInflate.findViewById(R.id.tv_google);
        this.f15918 = (TextView) viewInflate.findViewById(R.id.tv_wechat);
        this.f15919 = (TextView) viewInflate.findViewById(R.id.tv_alipay);
        this.f15920 = (TextView) viewInflate.findViewById(R.id.tv_huawei);
        TextView textView = (TextView) viewInflate.findViewById(R.id.payment_tv_des);
        this.f15926 = textView;
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.payment_tv_title);
        this.f15927 = textView2;
        this.f15930 = (ImageView) viewInflate.findViewById(R.id.iv_huawei);
        this.f15931 = (ImageView) viewInflate.findViewById(R.id.iv_alipay);
        this.f15932 = (ImageView) viewInflate.findViewById(R.id.iv_wechat);
        this.f15933 = (ImageView) viewInflate.findViewById(R.id.iv_google);
        this.f15917.setTypeface(FilmApp.m404());
        this.f15918.setTypeface(FilmApp.m404());
        this.f15919.setTypeface(FilmApp.m404());
        this.f15920.setTypeface(FilmApp.m404());
        textView.setTypeface(FilmApp.m404());
        textView2.setTypeface(FilmApp.m404());
        float fM14377 = C4792.m14375().m14377();
        this.f15934 = fM14377;
        this.f15917.setTextSize(0, fM14377);
        this.f15918.setTextSize(0, fM14377);
        this.f15919.setTextSize(0, fM14377);
        this.f15920.setTextSize(0, fM14377);
        textView.setTextSize(0, fM14377);
        textView2.setTextSize(0, fM14377);
        this.f15922 = (TextView) viewInflate.findViewById(R.id.tv_service);
        this.f15923 = (TextView) viewInflate.findViewById(R.id.tv_policies);
        this.f15924 = (TextView) viewInflate.findViewById(R.id.mail_support);
        this.f15921 = viewInflate.findViewById(R.id.v_line);
        this.f15912.requestWindowFeature(1);
        this.f15912.setContentView(viewInflate);
        this.f15912.setCanceledOnTouchOutside(true);
        Window window = this.f15912.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.gravity = 17;
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (i >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            window.setAttributes(attributes);
            window.getDecorView().setSystemUiVisibility(2);
            window.getDecorView().setSystemUiVisibility(5894);
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static C4689 m14213(Context context) {
        if (f15910 == null || f15911 != context) {
            synchronized (C4689.class) {
                if (f15910 == null || f15911 != context) {
                    f15911 = context;
                    C4689 c4689 = new C4689();
                    f15910 = c4689;
                    boolean z = true;
                    if (C4843.m14569().m14570() != 1) {
                        z = false;
                    }
                    c4689.m14224(context, z, C4843.m14569().m14572());
                }
            }
        }
        return f15910;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ކ, reason: contains not printable characters */
    public /* synthetic */ void m14214(View view) {
        InterfaceC4697 interfaceC4697 = this.f15939;
        if (interfaceC4697 != null) {
            interfaceC4697.mo1331(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: އ, reason: contains not printable characters */
    public /* synthetic */ void m14215(View view) {
        InterfaceC4697 interfaceC4697 = this.f15939;
        if (interfaceC4697 != null) {
            interfaceC4697.mo1331(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ވ, reason: contains not printable characters */
    public /* synthetic */ void m14216(View view) {
        InterfaceC4697 interfaceC4697 = this.f15939;
        if (interfaceC4697 != null) {
            interfaceC4697.mo1331(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: މ, reason: contains not printable characters */
    public /* synthetic */ void m14217(View view) {
        InterfaceC4697 interfaceC4697 = this.f15939;
        if (interfaceC4697 != null) {
            interfaceC4697.mo1331(4);
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static /* synthetic */ void m14218(View view) {
        C4320.m13461(f15911);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static /* synthetic */ void m14219(View view) {
        C4320.m13460(f15911);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static /* synthetic */ void m14220(View view) throws Resources.NotFoundException {
        C4320.m13462(f15911);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m14221() {
        m14222();
        f15911 = null;
        f15910 = null;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m14222() {
        Dialog dialog = this.f15912;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f15912.dismiss();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final int m14223(float f) {
        return C4792.m14375().m14477(f, 1.0f);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m14224(Context context, boolean z, boolean z2) {
        if (!z) {
            this.f15915.setVisibility(8);
        }
        if (z2) {
            return;
        }
        this.f15928.setVisibility(8);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m14225(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15925.getLayoutParams();
        layoutParams.width = C4792.m14375().m14438();
        layoutParams.height = C4792.m14375().m14437();
        if (z) {
            int iM9438 = C2579.f9594 - C2579.m9438(50.0f);
            layoutParams.width = iM9438;
            layoutParams.height = iM9438 / 2;
        }
        this.f15925.setLayoutParams(layoutParams);
        int i = (int) (layoutParams.width * 0.084f);
        this.f15925.setPadding(0, (int) (layoutParams.height * 0.116f), 0, m14223(10.0f));
        this.f15935.setPadding(i, 0, i, 0);
        ((LinearLayout.LayoutParams) this.f15926.getLayoutParams()).topMargin = (int) (layoutParams.height * 0.056f);
        m14228(layoutParams, i, z2);
        this.f15916.setOnClickListener(new ViewOnClickListenerC4690());
        this.f15925.setOnClickListener(new ViewOnClickListenerC4691());
        this.f15915.setOnTouchListener(new ViewOnTouchListenerC4692());
        this.f15914.setOnTouchListener(new ViewOnTouchListenerC4693());
        this.f15913.setOnTouchListener(new ViewOnTouchListenerC4694());
        this.f15928.setOnTouchListener(new ViewOnTouchListenerC4695());
        this.f15913.setOnClickListener(new View.OnClickListener() { // from class: ઊ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14780.m14214(view);
            }
        });
        this.f15914.setOnClickListener(new View.OnClickListener() { // from class: җ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10694.m14215(view);
            }
        });
        this.f15915.setOnClickListener(new View.OnClickListener() { // from class: ன
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15379.m14216(view);
            }
        });
        this.f15928.setOnClickListener(new View.OnClickListener() { // from class: ణ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15544.m14217(view);
            }
        });
        this.f15922.setOnClickListener(new View.OnClickListener() { // from class: ష
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4689.m14218(view);
            }
        });
        this.f15923.setOnClickListener(new View.OnClickListener() { // from class: ݤ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4689.m14219(view);
            }
        });
        this.f15924.setOnClickListener(new View.OnClickListener() { // from class: ۍ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                C4689.m14220(view);
            }
        });
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m14226(Context context) {
        this.f15936 = m14227(context);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final boolean m14227(Context context) {
        return C4628.m14086().m14087(context) && r1.m8143(StoreController.WECHAT_APP_ID);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m14228(RelativeLayout.LayoutParams layoutParams, int i, boolean z) {
        float f;
        int i2;
        boolean zM14571 = C4843.m14569().m14571();
        boolean zM14572 = C4843.m14569().m14572();
        boolean z2 = this.f15936;
        TextPaint paint = this.f15917.getPaint();
        float fMeasureText = paint.measureText(f15911.getString(R.string.ANDROID_BUTTON_PAYMENT_HUAWEI));
        float fMeasureText2 = paint.measureText(f15911.getString(R.string.ANDROID_BUTTON_PAYMENT_ALIPAY));
        float fMeasureText3 = paint.measureText(f15911.getString(R.string.ANDROID_BUTTON_PAYMENT_WECHAT));
        float fMeasureText4 = paint.measureText(f15911.getString(R.string.ANDROID_BUTTON_PAYMENT_GOOGLE));
        int iM14223 = m14223(89.0f);
        int iM142232 = m14223(25.0f);
        float fM9438 = (iM14223 * 2) + C2579.m9438(42.0f);
        this.f15938 = 1;
        if (z) {
            this.f15938 = 2;
            f = fM9438 * 2;
            fMeasureText2 += fMeasureText4 + fMeasureText;
            this.f15914.setVisibility(8);
            this.f15913.setVisibility(8);
            this.f15915.setVisibility(0);
            this.f15928.setVisibility(0);
        } else {
            this.f15915.setVisibility(zM14571 ? 0 : 8);
            this.f15928.setVisibility(zM14572 ? 0 : 8);
            this.f15914.setVisibility(z2 ? 0 : 8);
            this.f15913.setVisibility(0);
            if (zM14571) {
                i2 = 1;
                this.f15938++;
                fMeasureText2 += fMeasureText4;
            } else {
                i2 = 1;
            }
            if (zM14572) {
                this.f15938 += i2;
                fMeasureText2 += fMeasureText;
            }
            if (z2) {
                this.f15938 += i2;
                fMeasureText2 += fMeasureText3;
            }
            f = fM9438 * this.f15938;
        }
        float fMax = Math.max(f, fMeasureText2);
        float f2 = layoutParams.width - i;
        if (fMax > f2) {
            iM14223 = (int) (((f2 - (r13 * r4)) / this.f15938) / 2.0f);
        }
        int i3 = (int) (iM14223 * 1.0f);
        int i4 = (int) (iM142232 * 1.0f);
        this.f15915.setPadding(i3, 0, i3, 0);
        this.f15914.setPadding(i3, 0, i3, 0);
        this.f15913.setPadding(i3, 0, i3, 0);
        this.f15928.setPadding(i3, 0, i3, 0);
        this.f15917.setPadding(0, i4, 0, 0);
        this.f15918.setPadding(0, i4, 0, 0);
        this.f15919.setPadding(0, i4, 0, 0);
        this.f15920.setPadding(0, i4, 0, 0);
        m14231(this.f15917, this.f15934 * 1.0f);
        m14231(this.f15918, this.f15934 * 1.0f);
        m14231(this.f15919, this.f15934 * 1.0f);
        m14231(this.f15920, this.f15934 * 1.0f);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f15921.getLayoutParams();
        layoutParams2.height = m14223(2.0f);
        layoutParams2.leftMargin = i;
        layoutParams2.rightMargin = i;
        layoutParams2.topMargin = 0;
        this.f15921.setLayoutParams(layoutParams2);
        this.f15921.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        float fM14482 = C4792.m14375().m14482() * C4792.m14375().m14471();
        this.f15922.setPadding((int) (layoutParams.width * 0.084f), m14223(20.0f), 0, m14223(20.0f));
        this.f15923.setPadding(m14223(30.0f), m14223(20.0f), 0, m14223(20.0f));
        this.f15924.setPadding(m14223(30.0f), m14223(20.0f), 0, m14223(20.0f));
        m14231(this.f15922, fM14482);
        m14231(this.f15923, fM14482);
        m14231(this.f15924, fM14482);
        int iM9438 = C2579.m9438(42.0f);
        m14229(this.f15933, iM9438);
        m14229(this.f15932, iM9438);
        m14229(this.f15931, iM9438);
        m14229(this.f15930, iM9438);
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m14229(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m14230(boolean z) {
        this.f15937 = z;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final void m14231(TextView textView, float f) {
        textView.setTypeface(FilmApp.m404());
        textView.setTextSize(0, f);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m14232(Context context, InterfaceC4697 interfaceC4697) {
        this.f15939 = interfaceC4697;
        Dialog dialog = this.f15912;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        m14226(context);
        m14225(this.f15937, false);
        this.f15912.show();
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m14233(InterfaceC4697 interfaceC4697, InterfaceC4696 interfaceC4696) {
        this.f15939 = interfaceC4697;
        this.f15940 = interfaceC4696;
        Dialog dialog = this.f15912;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        m14225(this.f15937, true);
        this.f15912.show();
    }
}
