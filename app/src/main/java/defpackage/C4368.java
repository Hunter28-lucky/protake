package defpackage;

import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* compiled from: LinkUnderlineSpan.java */
/* renamed from: સ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4368 extends ClickableSpan {

    /* renamed from: ԫ, reason: contains not printable characters */
    public View.OnClickListener f15026;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f15027;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f15028;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f15029;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f15030;

    /* compiled from: LinkUnderlineSpan.java */
    /* renamed from: સ$Ϳ, reason: contains not printable characters */
    public class RunnableC4369 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ SpannableStringBuilder f15031;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ View f15032;

        public RunnableC4369(SpannableStringBuilder spannableStringBuilder, View view) {
            this.f15031 = spannableStringBuilder;
            this.f15032 = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15031.setSpan(new C4368(C4368.this.f15027, C4368.this.f15029, C4368.this.f15030, null), C4368.this.f15029, C4368.this.f15030, C4451.f15333);
            ((TextView) this.f15032).setText(this.f15031);
        }
    }

    /* compiled from: LinkUnderlineSpan.java */
    /* renamed from: સ$Ԩ, reason: contains not printable characters */
    public class RunnableC4370 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ SpannableString f15034;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ View f15035;

        public RunnableC4370(SpannableString spannableString, View view) {
            this.f15034 = spannableString;
            this.f15035 = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15034.setSpan(new C4368(C4368.this.f15027, C4368.this.f15029, C4368.this.f15030, null), C4368.this.f15029, C4368.this.f15030, C4451.f15333);
            ((TextView) this.f15035).setText(this.f15034);
        }
    }

    /* compiled from: LinkUnderlineSpan.java */
    /* renamed from: સ$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC4371 implements View.OnClickListener {
        public ViewOnClickListenerC4371() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public C4368(int i, int i2, int i3, View.OnClickListener onClickListener) {
        this.f15028 = 0;
        this.f15027 = i;
        this.f15026 = onClickListener;
        this.f15029 = i2;
        this.f15030 = i3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (!r1.m8142(this.f15026)) {
            new ViewOnClickListenerC4371();
            return;
        }
        TextView textView = (TextView) view;
        CharSequence text = textView.getText();
        if (text instanceof SpannableStringBuilder) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) textView.getText();
            spannableStringBuilder.setSpan(new C4368(this.f15027, Color.parseColor("#CCCCCC"), this.f15029, this.f15030, null), this.f15029, this.f15030, C4451.f15333);
            textView.setText(spannableStringBuilder);
            new Handler().postDelayed(new RunnableC4369(spannableStringBuilder, view), 200L);
        } else if (text instanceof SpannableString) {
            SpannableString spannableString = (SpannableString) textView.getText();
            spannableString.setSpan(new C4368(this.f15027, Color.parseColor("#CCCCCC"), this.f15029, this.f15030, null), this.f15029, this.f15030, C4451.f15333);
            textView.setText(spannableString);
            new Handler().postDelayed(new RunnableC4370(spannableString, view), 200L);
        }
        View.OnClickListener onClickListener = this.f15026;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f15027);
        textPaint.setFlags(1);
        textPaint.setFlags(textPaint.getFlags() | 128 | 1);
        textPaint.bgColor = this.f15028;
        textPaint.linkColor = this.f15027;
        textPaint.setUnderlineText(true);
    }

    public C4368(int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        this.f15027 = i;
        this.f15028 = i2;
        this.f15026 = onClickListener;
        this.f15029 = i3;
        this.f15030 = i4;
    }
}
