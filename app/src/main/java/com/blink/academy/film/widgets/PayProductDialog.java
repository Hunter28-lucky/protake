package com.blink.academy.film.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.netbean.store.NvtProductItem;
import com.blink.academy.film.widgets.PayProductDialog;
import com.blink.academy.protake.R;
import defpackage.AbstractC3819;
import defpackage.AbstractC3861;
import defpackage.AbstractC4012;
import defpackage.C4008;
import defpackage.C4628;
import defpackage.C4792;
import defpackage.C5213;
import defpackage.e5;
import defpackage.r1;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PayProductDialog extends ConstraintLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3861 f2420;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f2421;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2422;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f2423;

    /* renamed from: ԯ, reason: contains not printable characters */
    public List<NvtProductItem> f2424;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f2425;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f2426;

    /* renamed from: ֏, reason: contains not printable characters */
    public InterfaceC0936 f2427;

    /* renamed from: com.blink.academy.film.widgets.PayProductDialog$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC0929 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.PayProductDialog$Ϳ$Ϳ, reason: contains not printable characters */
        public class C0930 extends AbstractC4012 {
            public C0930() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PayProductDialog.this.setVisibility(8);
            }
        }

        public ViewOnClickListenerC0929() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PayProductDialog.this.f2427 != null && PayProductDialog.this.f2427.mo2493()) {
                PayProductDialog.this.m2480(new C0930());
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.PayProductDialog$Ԩ, reason: contains not printable characters */
    public class C0931 extends AbstractC4012 {
        public C0931() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            PayProductDialog.this.setVisibility(8);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.PayProductDialog$Ԫ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC0932 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public RoundButton f2431;

        /* renamed from: com.blink.academy.film.widgets.PayProductDialog$Ԫ$Ϳ, reason: contains not printable characters */
        public class RunnableC0933 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f2432;

            public RunnableC0933(View view) {
                this.f2432 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f2432.isEnabled()) {
                    ViewOnTouchListenerC0932.this.f2431.setContentAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0932(RoundButton roundButton) {
            this.f2431 = roundButton;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2431.setContentAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0933(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.PayProductDialog$Ԭ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC0934 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f2434;

        /* renamed from: com.blink.academy.film.widgets.PayProductDialog$Ԭ$Ϳ, reason: contains not printable characters */
        public class RunnableC0935 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f2435;

            public RunnableC0935(View view) {
                this.f2435 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f2435.isEnabled()) {
                    ViewOnTouchListenerC0934.this.f2434.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0934(View view) {
            this.f2434 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2434.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0935(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.PayProductDialog$Ԯ, reason: contains not printable characters */
    public interface InterfaceC0936 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean mo2493();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo2494(NvtProductItem nvtProductItem);

        /* renamed from: ֈ, reason: contains not printable characters */
        void mo2495();
    }

    public PayProductDialog(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static /* synthetic */ void m2471(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ނ, reason: contains not printable characters */
    public /* synthetic */ void m2472(View view) {
        m2488(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ރ, reason: contains not printable characters */
    public /* synthetic */ void m2473(View view) {
        m2488(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ބ, reason: contains not printable characters */
    public /* synthetic */ void m2474(View view) {
        m2488(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޅ, reason: contains not printable characters */
    public /* synthetic */ void m2475(View view) {
        InterfaceC0936 interfaceC0936 = this.f2427;
        if (interfaceC0936 != null) {
            interfaceC0936.mo2495();
        }
    }

    public void setList(@Nullable List<NvtProductItem> list) throws Resources.NotFoundException {
        if (r1.m8144(list) && this.f2424.containsAll(list)) {
            return;
        }
        this.f2424.clear();
        if (r1.m8144(list)) {
            this.f2424.addAll(list);
        }
        int size = list == null ? 0 : list.size();
        boolean z = size == 0;
        m2486(this.f2420.f13269, z || size >= 2);
        m2486(this.f2420.f13270, z || size >= 3);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14378() * this.f2421);
        textPaint.setTypeface(FilmApp.m404());
        int iMeasureText = (int) (textPaint.measureText("PAY (100% OFF)") + m2478(100));
        if (z) {
            m2487(this.f2420.f13271, null, iMeasureText);
        } else {
            NvtProductItem nvtProductItem = list.get(0);
            this.f2425 = m2490(nvtProductItem.getPrice_cny());
            this.f2426 = m2490(nvtProductItem.getPrice_usd());
            m2487(this.f2420.f13271, nvtProductItem, iMeasureText);
        }
        int i = (this.f2422 * 2) + iMeasureText + 0;
        if (z || size >= 2) {
            m2487(this.f2420.f13272, z ? null : list.get(1), iMeasureText);
            i += (this.f2422 * 2) + iMeasureText;
        } else {
            this.f2420.f13272.getRoot().setVisibility(8);
        }
        if (z || size >= 3) {
            m2487(this.f2420.f13273, z ? null : list.get(2), iMeasureText);
            i += iMeasureText + (this.f2422 * 2);
        } else {
            this.f2420.f13273.getRoot().setVisibility(8);
        }
        int iMax = Math.max(C4792.m14375().m14438(), i);
        ViewGroup.LayoutParams layoutParams = this.f2420.f13275.getLayoutParams();
        layoutParams.width = iMax;
        this.f2420.f13275.setLayoutParams(layoutParams);
    }

    public void setOnPayProductDialogListener(InterfaceC0936 interfaceC0936) {
        this.f2427 = interfaceC0936;
    }

    public void setPortrait(boolean z) {
        m2482(z);
    }

    public void setRatio(float f) {
        this.f2421 = f;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final String m2476(int i) {
        switch (i) {
            case 1:
                return "一折";
            case 2:
                return "二折";
            case 3:
                return "三折";
            case 4:
                return "四折";
            case 5:
                return "五折";
            case 6:
                return "六折";
            case 7:
                return "七折";
            case 8:
                return "八折";
            case 9:
                return "九折";
            default:
                return "";
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String m2477(NvtProductItem nvtProductItem, long j) {
        if (r1.m8137(nvtProductItem)) {
            return "";
        }
        if (C5213.m15210()) {
            float fM2490 = m2490(nvtProductItem.getPrice_cny());
            float f = this.f2425 * j;
            return (f == 0.0f || fM2490 == f) ? "" : m2476(Math.round((fM2490 / f) * 10.0f));
        }
        float fM24902 = m2490(nvtProductItem.getPrice_usd());
        float f2 = this.f2426 * j;
        if (f2 == 0.0f || fM24902 == f2) {
            return "";
        }
        return Math.round((1.0f - (fM24902 / f2)) * 100.0f) + "% OFF";
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public int m2478(int i) {
        return C4792.m14375().m14477(i, this.f2421);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m2479() {
        C4008.m12876(this, 0.0f, 100, new C0931());
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m2480(AbstractC4012 abstractC4012) {
        C4008.m12876(this, 0.0f, 100, abstractC4012);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m2481() {
        this.f2420 = AbstractC3861.m12297(LayoutInflater.from(getContext()), this, true);
        this.f2421 = C4792.m14375().m14434();
        this.f2422 = m2478(80);
        m2483();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m2482(boolean z) {
        this.f2420.f13275.setBackgroundColor(C4792.m14375().m14431());
        this.f2420.f13275.setPadding(0, m2478(70), 0, m2478(60));
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2420.f13267.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = m2478(600);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = m2478(54);
        this.f2420.f13267.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2420.f13276.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = m2478(50);
        layoutParams2.setMarginStart(this.f2422);
        layoutParams2.setMarginEnd(this.f2422);
        this.f2420.f13276.setLayoutParams(layoutParams2);
        this.f2420.f13276.setTypeface(FilmApp.m404());
        this.f2420.f13276.setTextSize(0, C4792.m14375().m14378() * this.f2421);
        this.f2420.f13276.setCustomText(getResources().getString(R.string.PAY_CLOUD_INFO));
        m2484(this.f2420.f13271);
        m2484(this.f2420.f13272);
        m2484(this.f2420.f13273);
        this.f2420.f13274.setPadding(m2478(40), m2478(60), m2478(40), 0);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f2420.f13268.getLayoutParams();
        layoutParams3.width = m2478(50);
        layoutParams3.height = m2478(50);
        this.f2420.f13268.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f2420.f13277.getLayoutParams();
        layoutParams4.leftMargin = m2478(10);
        this.f2420.f13277.setLayoutParams(layoutParams4);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m2483() {
        setOnClickListener(new ViewOnClickListenerC0929());
        this.f2420.f13275.setOnClickListener(new View.OnClickListener() { // from class: ဃ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayProductDialog.m2471(view);
            }
        });
        RoundButton roundButton = this.f2420.f13271.f13091;
        roundButton.setOnTouchListener(new ViewOnTouchListenerC0932(roundButton));
        this.f2420.f13271.f13091.setOnClickListener(new View.OnClickListener() { // from class: ݠ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12944.m2472(view);
            }
        });
        RoundButton roundButton2 = this.f2420.f13272.f13091;
        roundButton2.setOnTouchListener(new ViewOnTouchListenerC0932(roundButton2));
        this.f2420.f13272.f13091.setOnClickListener(new View.OnClickListener() { // from class: ؿ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11985.m2473(view);
            }
        });
        RoundButton roundButton3 = this.f2420.f13273.f13091;
        roundButton3.setOnTouchListener(new ViewOnTouchListenerC0932(roundButton3));
        this.f2420.f13273.f13091.setOnClickListener(new View.OnClickListener() { // from class: ఆ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15409.m2474(view);
            }
        });
        LinearLayout linearLayout = this.f2420.f13274;
        linearLayout.setOnTouchListener(new ViewOnTouchListenerC0934(linearLayout));
        this.f2420.f13274.setOnClickListener(new View.OnClickListener() { // from class: ൺ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f16024.m2475(view);
            }
        });
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m2484(AbstractC3819 abstractC3819) {
        abstractC3819.f13092.setTypeface(FilmApp.m404());
        abstractC3819.f13093.setTypeface(FilmApp.m404());
        abstractC3819.f13091.setTypeface(FilmApp.m404());
        abstractC3819.f13092.setTextSize(0, C4792.m14375().m14389() * this.f2421);
        abstractC3819.f13093.setTextSize(0, C4792.m14375().m14378() * this.f2421);
        abstractC3819.f13093.setLineSpacing(m2478(10), 1.0f);
        abstractC3819.getRoot().setPadding(this.f2422, m2478(80), this.f2422, 0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) abstractC3819.f13093.getLayoutParams();
        layoutParams.topMargin = m2478(20);
        layoutParams.bottomMargin = m2478(26);
        abstractC3819.f13093.setLayoutParams(layoutParams);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m2485() {
        boolean zM5994 = e5.m5988().m5994();
        if (this.f2423 != zM5994) {
            this.f2423 = zM5994;
            this.f2420.f13274.setVisibility(zM5994 ? 8 : 0);
            this.f2420.f13275.setPadding(0, m2478(70), 0, m2478(zM5994 ? 80 : 60));
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m2486(View view, boolean z) {
        if (!z) {
            view.setVisibility(8);
        } else if (view.getVisibility() != 0) {
            view.setVisibility(0);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = m2478(70);
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m2487(AbstractC3819 abstractC3819, NvtProductItem nvtProductItem, int i) throws Resources.NotFoundException {
        String string;
        String str;
        String str2;
        abstractC3819.getRoot().setVisibility(0);
        if (nvtProductItem == null) {
            string = getResources().getString(R.string.PAY_CLOUD_PAY);
            str = "N/A";
            str2 = "\nN/A";
        } else {
            String price_cny = C5213.m15210() ? nvtProductItem.getPrice_cny() : nvtProductItem.getPrice_usd();
            float fM2490 = m2490(price_cny);
            long amount = nvtProductItem.getAmount() / 60;
            long jMax = Math.max(amount / 60, 1L);
            int iRound = Math.round((fM2490 / jMax) * 100.0f);
            String str3 = String.format("%s%s", getResources().getString(R.string.PRICE_UNIT), price_cny);
            String str4 = String.format("%s %s\n%s%s / %s", Long.valueOf(amount), getResources().getString(R.string.MONITOR_MINUTES), getResources().getString(R.string.PRICE_UNIT), new DecimalFormat("#.00").format(iRound / 100.0d), getResources().getString(R.string.PAY_CLOUD_HOUR));
            String strM2477 = m2477(nvtProductItem, jMax);
            string = r1.m8143(strM2477) ? String.format("%s (%s)", getResources().getString(R.string.PAY_CLOUD_PAY), strM2477) : getResources().getString(R.string.PAY_CLOUD_PAY);
            str = str3;
            str2 = str4;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) abstractC3819.f13091.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = m2478(100);
        abstractC3819.f13091.setLayoutParams(layoutParams);
        abstractC3819.f13091.m2540(ViewCompat.MEASURED_STATE_MASK).m2542(m2478(50)).m2539(0, C4792.m14375().m14379() * this.f2421).m2538(C4792.m14375().m14431()).m2537(string.toUpperCase()).m2535().m2534();
        abstractC3819.f13092.setText(str);
        abstractC3819.f13093.setText(str2);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m2488(int i) {
        NvtProductItem nvtProductItem = i >= this.f2424.size() ? null : this.f2424.get(i);
        InterfaceC0936 interfaceC0936 = this.f2427;
        if (interfaceC0936 != null) {
            interfaceC0936.mo2494(nvtProductItem);
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m2489(AbstractC4012 abstractC4012) {
        setAlpha(0.0f);
        setVisibility(0);
        m2485();
        setBackgroundColor(getResources().getColor(R.color.colorHalfBlack, null));
        C4008.m12876(this, 1.0f, 100, abstractC4012);
        C4628.m14086().m14089(getContext());
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final float m2490(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public PayProductDialog(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PayProductDialog(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2423 = false;
        this.f2424 = new ArrayList();
        this.f2425 = 0.0f;
        this.f2426 = 0.0f;
        m2481();
    }
}
