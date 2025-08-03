package defpackage;

import android.R;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import com.blink.academy.film.FilmApp;

/* compiled from: SpannableUtils.java */
/* renamed from: ஆ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4451 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int f15333 = 33;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Spannable m13715(String str, int i, int i2) {
        if (r1.m8138(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        m13716(spannableString, i, i2);
        return spannableString;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m13716(Spannable spannable, int i, int i2) {
        if (i > i2) {
            i = i2;
        }
        spannable.setSpan(new StyleSpan(1), i, i2, f15333);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m13717(SpannableString spannableString, View.OnClickListener onClickListener, int i, int i2) {
        spannableString.setSpan(new C4887(onClickListener), i, i2, f15333);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), i, i2, f15333);
        spannableString.setSpan(new BackgroundColorSpan(0), i, i2, f15333);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m13718(SpannableString spannableString, View.OnClickListener onClickListener, int i, int i2) {
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#3b8fd8")), i, i2, f15333);
        spannableString.setSpan(new C4368(Color.parseColor("#3b8fd8"), i, i2, onClickListener), i, i2, f15333);
        spannableString.setSpan(new BackgroundColorSpan(FilmApp.m402().getResources().getColor(R.color.transparent)), i, i2, f15333);
    }
}
