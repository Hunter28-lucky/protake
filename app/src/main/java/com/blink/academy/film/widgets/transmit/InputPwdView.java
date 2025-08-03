package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC3097;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C4066;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.r1;

/* loaded from: classes.dex */
public class InputPwdView extends ConstraintLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3097 f4259;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f4260;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4261;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f4262;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC1591 f4263;

    /* renamed from: com.blink.academy.film.widgets.transmit.InputPwdView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1587 implements View.OnClickListener {
        public ViewOnClickListenerC1587() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.InputPwdView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1588 implements View.OnClickListener {
        public ViewOnClickListenerC1588() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InputPwdView.this.f4263 == null || InputPwdView.this.f4263.mo4210()) {
                return;
            }
            C4066.m13003(InputPwdView.this.getContext());
            InputPwdView.this.f4259.f11024.requestFocus();
            InputPwdView.this.f4259.f11024.requestFocusFromTouch();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.InputPwdView$Ԫ, reason: contains not printable characters */
    public class C1589 implements TextWatcher {
        public C1589() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            C4638.m14099("afterTextChanged", "afterTextChanged:" + editable.toString());
            String string = editable.toString();
            if (!r1.m8143(string)) {
                InputPwdView.this.f4260 = "";
                InputPwdView.this.m4247();
                return;
            }
            if (string.length() > 6) {
                InputPwdView.this.f4259.f11024.setText(string.substring(0, 6));
                InputPwdView.this.f4259.f11024.setSelection(6);
            } else {
                if (!InputPwdView.this.f4262 || string.length() >= 6) {
                    InputPwdView.this.f4260 = string;
                    InputPwdView.this.m4257();
                    return;
                }
                InputPwdView.this.f4262 = false;
                C2618.m9573("remote_last_input_room_id_sp", "");
                InputPwdView.this.f4259.f11024.setText("");
                InputPwdView.this.f4260 = "";
                InputPwdView.this.m4247();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C4638.m14097();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C4638.m14097();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.InputPwdView$Ԭ, reason: contains not printable characters */
    public class C1590 extends DigitsKeyListener {
        public C1590() {
        }

        @Override // android.text.method.DigitsKeyListener, android.text.method.NumberKeyListener
        public char[] getAcceptedChars() {
            return "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        }

        @Override // android.text.method.DigitsKeyListener, android.text.method.KeyListener
        public int getInputType() {
            return 4096;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.InputPwdView$Ԯ, reason: contains not printable characters */
    public interface InterfaceC1591 {
        /* renamed from: Ϳ */
        boolean mo4210();
    }

    public InputPwdView(@NonNull Context context) {
        this(context, null);
    }

    public String getCode() {
        return this.f4260;
    }

    public void setOnInputCallback(InterfaceC1591 interfaceC1591) {
        this.f4263 = interfaceC1591;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m4247() {
        this.f4260 = "";
        this.f4259.f11026.setText("");
        this.f4259.f11028.setText("");
        this.f4259.f11030.setText("");
        this.f4259.f11032.setText("");
        this.f4259.f11034.setText("");
        this.f4259.f11036.setText("");
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4248() {
        this.f4262 = false;
        this.f4259.f11024.clearFocus();
        this.f4259.f11024.setText("");
        m4249();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4249() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f4259.f11024.getWindowToken(), 0);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m4250() {
        this.f4259 = AbstractC3097.m10691(LayoutInflater.from(getContext()), this, true);
        if (C2579.m9451(getContext())) {
            m4253();
        } else {
            m4251();
        }
        m4252();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m4251() {
        this.f4261 = C4792.m14375().m14476(120);
        int iM14476 = C4792.m14375().m14476(30);
        int iM144762 = C4792.m14375().m14476(108);
        m4254(this.f4259.f11027, true, iM14476, iM144762);
        m4254(this.f4259.f11029, false, iM14476, iM144762);
        m4254(this.f4259.f11031, false, iM14476, iM144762);
        m4254(this.f4259.f11033, false, iM14476, iM144762);
        m4254(this.f4259.f11035, false, iM14476, iM144762);
        m4254(this.f4259.f11037, false, iM14476, iM144762);
        int iM14387 = C4792.m14375().m14387();
        Typeface typefaceM404 = FilmApp.m404();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(iM14387);
        textPaint.setTypeface(typefaceM404);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        int i = (int) ((((fontMetrics.bottom - fontMetrics.top) - fontMetrics.descent) + fontMetrics.ascent) / 2.0f);
        m4255(this.f4259.f11026, iM14387, typefaceM404, i);
        m4255(this.f4259.f11028, iM14387, typefaceM404, i);
        m4255(this.f4259.f11030, iM14387, typefaceM404, i);
        m4255(this.f4259.f11032, iM14387, typefaceM404, i);
        m4255(this.f4259.f11034, iM14387, typefaceM404, i);
        m4255(this.f4259.f11036, iM14387, typefaceM404, i);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m4252() {
        setOnClickListener(new ViewOnClickListenerC1587());
        this.f4259.f11025.setOnClickListener(new ViewOnClickListenerC1588());
        this.f4259.f11024.addTextChangedListener(new C1589());
        this.f4259.f11024.setKeyListener(new C1590());
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m4253() {
        this.f4261 = C4792.m14375().m14476(170);
        int iM14476 = C4792.m14375().m14476(40);
        int iM144762 = C4792.m14375().m14476(133);
        m4254(this.f4259.f11027, true, iM14476, iM144762);
        m4254(this.f4259.f11029, false, iM14476, iM144762);
        m4254(this.f4259.f11031, false, iM14476, iM144762);
        m4254(this.f4259.f11033, false, iM14476, iM144762);
        m4254(this.f4259.f11035, false, iM14476, iM144762);
        m4254(this.f4259.f11037, false, iM14476, iM144762);
        int iM14392 = C4792.m14375().m14392();
        Typeface typefaceM404 = FilmApp.m404();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(iM14392);
        textPaint.setTypeface(typefaceM404);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        int i = (int) ((((fontMetrics.bottom - fontMetrics.top) - fontMetrics.descent) + fontMetrics.ascent) / 2.0f);
        m4255(this.f4259.f11026, iM14392, typefaceM404, i);
        m4255(this.f4259.f11028, iM14392, typefaceM404, i);
        m4255(this.f4259.f11030, iM14392, typefaceM404, i);
        m4255(this.f4259.f11032, iM14392, typefaceM404, i);
        m4255(this.f4259.f11034, iM14392, typefaceM404, i);
        m4255(this.f4259.f11036, iM14392, typefaceM404, i);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m4254(CardView cardView, boolean z, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardView.getLayoutParams();
        layoutParams.height = this.f4261;
        layoutParams.width = i2;
        if (!z) {
            layoutParams.leftMargin = i;
        }
        cardView.setLayoutParams(layoutParams);
        cardView.setRadius(i2 / 8.0f);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m4255(TextView textView, int i, Typeface typeface, int i2) {
        textView.setTextColor(-1);
        textView.setTypeface(typeface);
        textView.setTextSize(0, i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.topMargin = -i2;
        textView.setLayoutParams(layoutParams);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m4256() {
        C4066.m13003(getContext());
        this.f4259.f11024.requestFocus();
        this.f4259.f11024.requestFocusFromTouch();
        String strM9569 = C2618.m9569("remote_last_input_room_id_sp", "");
        if (r1.m8143(strM9569)) {
            this.f4259.f11024.setText(strM9569);
            this.f4259.f11024.setSelection(strM9569.length());
            this.f4262 = true;
        }
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m4257() {
        switch (this.f4260.length()) {
            case 0:
                m4247();
                break;
            case 1:
                this.f4259.f11026.setText(this.f4260);
                this.f4259.f11028.setText("");
                this.f4259.f11030.setText("");
                this.f4259.f11032.setText("");
                this.f4259.f11034.setText("");
                this.f4259.f11036.setText("");
                break;
            case 2:
                this.f4259.f11026.setText(this.f4260.substring(0, 1));
                this.f4259.f11028.setText(this.f4260.substring(1, 2));
                this.f4259.f11030.setText("");
                this.f4259.f11032.setText("");
                this.f4259.f11034.setText("");
                this.f4259.f11036.setText("");
                break;
            case 3:
                this.f4259.f11026.setText(this.f4260.substring(0, 1));
                this.f4259.f11028.setText(this.f4260.substring(1, 2));
                this.f4259.f11030.setText(this.f4260.substring(2, 3));
                this.f4259.f11032.setText("");
                this.f4259.f11034.setText("");
                this.f4259.f11036.setText("");
                break;
            case 4:
                this.f4259.f11026.setText(this.f4260.substring(0, 1));
                this.f4259.f11028.setText(this.f4260.substring(1, 2));
                this.f4259.f11030.setText(this.f4260.substring(2, 3));
                this.f4259.f11032.setText(this.f4260.substring(3, 4));
                this.f4259.f11034.setText("");
                this.f4259.f11036.setText("");
                break;
            case 5:
                this.f4259.f11026.setText(this.f4260.substring(0, 1));
                this.f4259.f11028.setText(this.f4260.substring(1, 2));
                this.f4259.f11030.setText(this.f4260.substring(2, 3));
                this.f4259.f11032.setText(this.f4260.substring(3, 4));
                this.f4259.f11034.setText(this.f4260.substring(4, 5));
                this.f4259.f11036.setText("");
                break;
            case 6:
                this.f4259.f11026.setText(this.f4260.substring(0, 1));
                this.f4259.f11028.setText(this.f4260.substring(1, 2));
                this.f4259.f11030.setText(this.f4260.substring(2, 3));
                this.f4259.f11032.setText(this.f4260.substring(3, 4));
                this.f4259.f11034.setText(this.f4260.substring(4, 5));
                this.f4259.f11036.setText(this.f4260.substring(5, 6));
                break;
        }
    }

    public InputPwdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPwdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4262 = false;
        m4250();
    }
}
