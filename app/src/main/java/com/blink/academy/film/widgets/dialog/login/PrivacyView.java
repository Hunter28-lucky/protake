package com.blink.academy.film.widgets.dialog.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC4395;
import defpackage.C2579;
import defpackage.InterfaceC3655;

/* loaded from: classes.dex */
public class PrivacyView extends CardView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4395 f3015;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC3655 f3016;

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1082 implements View.OnClickListener {
        public ViewOnClickListenerC1082() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1083 implements View.OnClickListener {
        public ViewOnClickListenerC1083() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PrivacyView.this.f3016 != null) {
                PrivacyView.this.f3016.mo3086();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyView$Ԫ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1084 implements View.OnTouchListener {
        public ViewOnTouchListenerC1084() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setAlpha(0.1f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            view.setAlpha(0.3f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1085 implements View.OnClickListener {
        public ViewOnClickListenerC1085() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PrivacyView.this.f3016 != null) {
                PrivacyView.this.f3016.mo3086();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyView$Ԯ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1086 implements View.OnTouchListener {
        public ViewOnTouchListenerC1086() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            view.setAlpha(1.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyView$ՠ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1087 implements View.OnTouchListener {
        public ViewOnTouchListenerC1087() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (PrivacyView.this.f3015.f15119.getVisibility() == 0) {
                view.setAlpha(1.0f);
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setAlpha(0.3f);
            } else if (action == 1 || action == 3) {
                view.setAlpha(1.0f);
            }
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1088 implements View.OnClickListener {
        public ViewOnClickListenerC1088() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PrivacyView.this.f3015.f15119.getVisibility() == 0) {
                return;
            }
            PrivacyView.this.m2969();
            if (PrivacyView.this.f3016 != null) {
                PrivacyView.this.f3016.mo3089("", "");
            }
        }
    }

    public PrivacyView(@NonNull Context context) {
        this(context, null);
    }

    public void setOnNextCallback(InterfaceC3655 interfaceC3655) {
        this.f3016 = interfaceC3655;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2969() {
        setVisibility(8);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m2970() {
        this.f3015 = AbstractC4395.m13587(LayoutInflater.from(getContext()), this, true);
        m2972();
        m2971();
        setRadius(C2579.m9438(0.0f));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m2971() {
        this.f3015.f15115.setOnClickListener(new ViewOnClickListenerC1082());
        this.f3015.f15123.setOnClickListener(new ViewOnClickListenerC1083());
        this.f3015.f15123.setOnTouchListener(new ViewOnTouchListenerC1084());
        this.f3015.f15117.setOnClickListener(new ViewOnClickListenerC1085());
        this.f3015.f15117.setOnTouchListener(new ViewOnTouchListenerC1086());
        this.f3015.f15118.setOnTouchListener(new ViewOnTouchListenerC1087());
        this.f3015.f15118.setOnClickListener(new ViewOnClickListenerC1088());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m2972() {
        this.f3015.f15124.setTypeface(FilmApp.m404());
        this.f3015.f15121.setTypeface(FilmApp.m404());
        this.f3015.f15123.setTypeface(FilmApp.m404());
        this.f3015.f15122.setTypeface(FilmApp.m404());
    }

    public PrivacyView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrivacyView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2970();
    }
}
