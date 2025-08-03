package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;
import defpackage.C3444;
import org.jcodec.codecs.mjpeg.JpegConst;

/* compiled from: SizeAdaptation.java */
/* renamed from: ඖ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4792 {

    /* renamed from: ຑ, reason: contains not printable characters */
    public static C4792 f16137 = null;

    /* renamed from: ຒ, reason: contains not printable characters */
    public static float f16138 = 6.0f;

    /* renamed from: ޏ, reason: contains not printable characters */
    public float f16168;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f16169;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f16170;

    /* renamed from: ޗ, reason: contains not printable characters */
    public TextPaint f16176;

    /* renamed from: ޘ, reason: contains not printable characters */
    public TextPaint f16177;

    /* renamed from: ޙ, reason: contains not printable characters */
    public int f16178;

    /* renamed from: ޚ, reason: contains not printable characters */
    public boolean f16179;

    /* renamed from: ޛ, reason: contains not printable characters */
    public int f16180;

    /* renamed from: ޜ, reason: contains not printable characters */
    public int f16181;

    /* renamed from: ޝ, reason: contains not printable characters */
    public int f16182;

    /* renamed from: ޞ, reason: contains not printable characters */
    public int f16183;

    /* renamed from: ޟ, reason: contains not printable characters */
    public int f16184;

    /* renamed from: ޠ, reason: contains not printable characters */
    public int f16185;

    /* renamed from: ޡ, reason: contains not printable characters */
    public int f16186;

    /* renamed from: ޢ, reason: contains not printable characters */
    public int f16187;

    /* renamed from: ޣ, reason: contains not printable characters */
    public int f16188;

    /* renamed from: ޤ, reason: contains not printable characters */
    public int f16189;

    /* renamed from: ޥ, reason: contains not printable characters */
    public int f16190;

    /* renamed from: ޱ, reason: contains not printable characters */
    public int f16191;

    /* renamed from: ߾, reason: contains not printable characters */
    public int f16192;

    /* renamed from: ߿, reason: contains not printable characters */
    public int f16193;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public int f16194;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public int f16195;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public int f16196;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public int f16197;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public int f16198;

    /* renamed from: ࡥ, reason: contains not printable characters */
    public int f16199;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public int f16200;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public int f16201;

    /* renamed from: ࡨ, reason: contains not printable characters */
    public int f16202;

    /* renamed from: ࡩ, reason: contains not printable characters */
    public int f16203;

    /* renamed from: ࡪ, reason: contains not printable characters */
    public int f16204;

    /* renamed from: ࢠ, reason: contains not printable characters */
    public int f16205;

    /* renamed from: ࢡ, reason: contains not printable characters */
    public int f16206;

    /* renamed from: ࢢ, reason: contains not printable characters */
    public int f16207;

    /* renamed from: ࢣ, reason: contains not printable characters */
    public int f16208;

    /* renamed from: ࢤ, reason: contains not printable characters */
    public int f16209;

    /* renamed from: ࢪ, reason: contains not printable characters */
    public int f16215;

    /* renamed from: ࢫ, reason: contains not printable characters */
    public int f16216;

    /* renamed from: ࢬ, reason: contains not printable characters */
    public int f16217;

    /* renamed from: ࢭ, reason: contains not printable characters */
    public int f16218;

    /* renamed from: ࢮ, reason: contains not printable characters */
    public int f16219;

    /* renamed from: ࢯ, reason: contains not printable characters */
    public int f16220;

    /* renamed from: ࢰ, reason: contains not printable characters */
    public int f16221;

    /* renamed from: ࢱ, reason: contains not printable characters */
    public int f16222;

    /* renamed from: ࢲ, reason: contains not printable characters */
    public int f16223;

    /* renamed from: ࢳ, reason: contains not printable characters */
    public int f16224;

    /* renamed from: ࢴ, reason: contains not printable characters */
    public int f16225;

    /* renamed from: ࢶ, reason: contains not printable characters */
    public int f16226;

    /* renamed from: ഄ, reason: contains not printable characters */
    public boolean f16249;

    /* renamed from: ഩ, reason: contains not printable characters */
    public int f16250;

    /* renamed from: ഺ, reason: contains not printable characters */
    public int f16251;

    /* renamed from: ൔ, reason: contains not printable characters */
    public boolean f16253;

    /* renamed from: ຆ, reason: contains not printable characters */
    public int f16257;

    /* renamed from: ຉ, reason: contains not printable characters */
    public int f16258;

    /* renamed from: ຌ, reason: contains not printable characters */
    public int f16259;

    /* renamed from: ຎ, reason: contains not printable characters */
    public int f16260;

    /* renamed from: ຏ, reason: contains not printable characters */
    public int f16261;

    /* renamed from: ຐ, reason: contains not printable characters */
    public int f16262;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f16139 = 35;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f16140 = 45;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f16141 = 360;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f16142 = JpegConst.RST2;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f16143 = JpegConst.APP6;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f16144 = 106;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f16145 = 5;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f16146 = JpegConst.APP1;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f16147 = 56;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f16148 = 151;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f16149 = 36;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f16150 = 70;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f16151 = 102;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f16152 = 102;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f16153 = 82;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f16154 = 82;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f16155 = 82;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f16156 = 84;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f16157 = 74;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f16158 = 118;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f16159 = 114;

    /* renamed from: އ, reason: contains not printable characters */
    public int f16160 = 360;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f16161 = 52;

    /* renamed from: މ, reason: contains not printable characters */
    public int f16162 = 16;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f16163 = 10;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f16164 = 74;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f16165 = 114;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f16166 = 60;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f16167 = 128;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f16171 = 360;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f16172 = 52;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f16173 = 16;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f16174 = 10;

    /* renamed from: ޖ, reason: contains not printable characters */
    public int f16175 = 74;

    /* renamed from: ࢥ, reason: contains not printable characters */
    public float f16210 = 1.0f;

    /* renamed from: ࢦ, reason: contains not printable characters */
    public final float f16211 = 1.7777778f;

    /* renamed from: ࢧ, reason: contains not printable characters */
    public float f16212 = 1.0f;

    /* renamed from: ࢨ, reason: contains not printable characters */
    public float f16213 = 1.0f;

    /* renamed from: ࢩ, reason: contains not printable characters */
    public int f16214 = 63;

    /* renamed from: ࢷ, reason: contains not printable characters */
    public int f16227 = 5;

    /* renamed from: ࢸ, reason: contains not printable characters */
    public int f16228 = 15;

    /* renamed from: ࢹ, reason: contains not printable characters */
    public int f16229 = 12;

    /* renamed from: ࢺ, reason: contains not printable characters */
    public int f16230 = 71;

    /* renamed from: ࢻ, reason: contains not printable characters */
    public int f16231 = Color.parseColor("#ffba00");

    /* renamed from: ࢼ, reason: contains not printable characters */
    public int f16232 = Color.parseColor("#ffba00");

    /* renamed from: ࢽ, reason: contains not printable characters */
    public int f16233 = 8;

    /* renamed from: ࢾ, reason: contains not printable characters */
    public float f16234 = 2.5f;

    /* renamed from: ࢿ, reason: contains not printable characters */
    public int f16235 = 10;

    /* renamed from: ࣀ, reason: contains not printable characters */
    public int f16236 = 58;

    /* renamed from: ࣁ, reason: contains not printable characters */
    public int f16237 = 50;

    /* renamed from: ࣂ, reason: contains not printable characters */
    public int f16238 = 20;

    /* renamed from: ࣃ, reason: contains not printable characters */
    public int f16239 = 300;

    /* renamed from: ࣄ, reason: contains not printable characters */
    public int f16240 = 1;

    /* renamed from: ࣅ, reason: contains not printable characters */
    public int f16241 = 1;

    /* renamed from: ࣆ, reason: contains not printable characters */
    public int f16242 = 1;

    /* renamed from: ࣇ, reason: contains not printable characters */
    public int f16243 = 280;

    /* renamed from: ৼ, reason: contains not printable characters */
    public int f16244 = 127;

    /* renamed from: ૹ, reason: contains not printable characters */
    public int f16245 = 255;

    /* renamed from: ಀ, reason: contains not printable characters */
    public float f16246 = 0.2f;

    /* renamed from: ೱ, reason: contains not printable characters */
    public int f16247 = 197;

    /* renamed from: ೲ, reason: contains not printable characters */
    public float f16248 = 1.0f;

    /* renamed from: ൎ, reason: contains not printable characters */
    public int f16252 = 5;

    /* renamed from: ൕ, reason: contains not printable characters */
    public float f16254 = 0.8f;

    /* renamed from: ൖ, reason: contains not printable characters */
    public float f16255 = 1.0f;

    /* renamed from: ൟ, reason: contains not printable characters */
    public float f16256 = 1.7777778f;

    /* compiled from: SizeAdaptation.java */
    /* renamed from: ඖ$Ϳ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC4793 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ ViewTreeObserver f16263;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ Activity f16264;

        public ViewTreeObserverOnGlobalLayoutListenerC4793(ViewTreeObserver viewTreeObserver, Activity activity) {
            this.f16263 = viewTreeObserver;
            this.f16264 = activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            DisplayCutout displayCutout;
            if (C4792.this.f16179) {
                return;
            }
            C4792.this.f16179 = true;
            if (this.f16263.isAlive()) {
                this.f16263.removeOnGlobalLayoutListener(this);
            }
            if (Build.VERSION.SDK_INT < 28 || (displayCutout = this.f16264.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout()) == null || C4792.this.f16178 != 0) {
                return;
            }
            int safeInsetTop = displayCutout.getSafeInsetTop();
            int safeInsetLeft = displayCutout.getSafeInsetLeft();
            displayCutout.getSafeInsetBottom();
            displayCutout.getSafeInsetRight();
            if (C2579.m9446(this.f16264) == 1) {
                C4792.this.f16180 = safeInsetTop;
            } else {
                C4792.this.f16180 = safeInsetLeft;
            }
        }
    }

    /* renamed from: ࡪ, reason: contains not printable characters */
    public static C4792 m14375() {
        if (f16137 == null) {
            synchronized (C4792.class) {
                if (f16137 == null) {
                    f16137 = new C4792();
                }
            }
        }
        return f16137;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m14376() {
        int i = (int) (this.f16170 * 0.4787037f);
        this.f16251 = i;
        this.f16250 = i * 2;
        this.f16249 = true;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m14377() {
        return m14429(30.0f);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public int m14378() {
        return m14429(36.0f);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int m14379() {
        return m14429(39.0f);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public int m14380() {
        return m14429(42.0f);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public int m14381() {
        return m14429(45.0f);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public int m14382() {
        return m14429(48.0f);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public int m14383() {
        return m14429(54.0f);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public int m14384() {
        return m14429(60.0f);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public int m14385() {
        return m14429(72.0f);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public int m14386() {
        return m14429(75.0f);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public int m14387() {
        return m14429(84.0f);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public int m14388() {
        return m14429(6.0f);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public int m14389() {
        return m14429(90.0f);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public int m14390() {
        return m14429(102.0f);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public int m14391() {
        return m14429(9.0f);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public int m14392() {
        return m14429(126.0f);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public int m14393() {
        return m14429(15.0f);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public int m14394() {
        return m14429(18.0f);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public int m14395() {
        return m14429(21.0f);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public int m14396() {
        return m14429(24.0f);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public int m14397() {
        return m14429(27.0f);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public float m14398() {
        return m14429(28.0f);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public int m14399() {
        return this.f16237;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public int m14400() {
        return this.f16236;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public int m14401() {
        return this.f16238;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public float m14402() {
        return this.f16248;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public int m14403() {
        return this.f16207;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public int m14404() {
        return m14476(this.f16228);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public int m14405() {
        return (int) (this.f16194 * this.f16212);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public int m14406() {
        return (int) (this.f16197 * this.f16212);
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public int m14407() {
        return (int) (this.f16195 * this.f16212);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public int m14408() {
        return (int) (this.f16196 * this.f16212);
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public int m14409() {
        return this.f16200;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public int m14410() {
        return this.f16199;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public int m14411() {
        return this.f16201;
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public int m14412() {
        return this.f16198;
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public int m14413() {
        return this.f16244;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public int m14414() {
        return this.f16245;
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public int m14415() {
        return this.f16243;
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public float m14416() {
        return this.f16246;
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public int m14417() {
        return FilmApp.m402().getResources().getColor(R.color.colorhalfWhite);
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public int m14418() {
        return this.f16192;
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public int m14419() {
        return m14381();
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public int m14420() {
        return this.f16227;
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public int m14421() {
        return this.f16203;
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public int m14422() {
        return this.f16205;
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public int m14423() {
        return this.f16206;
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public int m14424() {
        return this.f16204;
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public int m14425() {
        return this.f16216;
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public int m14426() {
        return this.f16217;
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public int m14427() {
        return this.f16215;
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public float m14428(float f) {
        return f * 1.0f * m14455(1125.0f);
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public int m14429(float f) {
        return (int) ((m14430(f) * 0.9f) + 0.5f);
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public final float m14430(float f) {
        return f * m14455(1128.0f);
    }

    /* renamed from: ࡤ, reason: contains not printable characters */
    public int m14431() {
        return this.f16231;
    }

    /* renamed from: ࡥ, reason: contains not printable characters */
    public int m14432() {
        return this.f16184;
    }

    /* renamed from: ࡦ, reason: contains not printable characters */
    public int m14433() {
        return this.f16183;
    }

    /* renamed from: ࡧ, reason: contains not printable characters */
    public float m14434() {
        return this.f16212;
    }

    /* renamed from: ࡨ, reason: contains not printable characters */
    public int m14435() {
        return C2579.m9438(this.f16242);
    }

    /* renamed from: ࡩ, reason: contains not printable characters */
    public int m14436() {
        return this.f16224;
    }

    /* renamed from: ࢠ, reason: contains not printable characters */
    public int m14437() {
        if (!this.f16249) {
            m14376();
        }
        return this.f16251;
    }

    /* renamed from: ࢡ, reason: contains not printable characters */
    public int m14438() {
        if (!this.f16249) {
            m14376();
        }
        return this.f16250;
    }

    /* renamed from: ࢢ, reason: contains not printable characters */
    public float m14439() {
        return m14476(this.f16247);
    }

    /* renamed from: ࢣ, reason: contains not printable characters */
    public int m14440(Context context) {
        StrokeTextView strokeTextView = new StrokeTextView(context);
        strokeTextView.m2562(0, m14375().m14381());
        strokeTextView.setContentTypeFace(FilmApp.m403());
        Paint.FontMetrics fontMetrics = strokeTextView.getPaint().getFontMetrics();
        int i = (int) (fontMetrics.bottom - fontMetrics.top);
        int iM14476 = (int) (m14375().m14476(30) * m14434());
        Paint paint = new Paint();
        paint.setStrokeWidth(f16138);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        paint.setTextSize(m14375().m14384());
        paint.setTypeface(FilmApp.m404());
        paint.setTypeface(FilmApp.m404());
        int iDescent = (int) ((paint.descent() - paint.ascent()) + f16138);
        StrokeTextView strokeTextView2 = new StrokeTextView(context);
        strokeTextView2.m2562(0, m14375().m14397());
        strokeTextView2.setContentTypeFace(FilmApp.m404());
        strokeTextView2.setContentTextColor(-1);
        Paint.FontMetrics fontMetrics2 = strokeTextView.getPaint().getFontMetrics();
        return ((int) (fontMetrics2.bottom - fontMetrics2.top)) + iDescent + iM14476 + i;
    }

    /* renamed from: ࢤ, reason: contains not printable characters */
    public int m14441() {
        return C2579.m9438(this.f16252);
    }

    /* renamed from: ࢥ, reason: contains not printable characters */
    public float m14442() {
        int i;
        if (this.f16178 == 0 && (i = this.f16180) != 0) {
            this.f16178 = i;
        }
        return this.f16178;
    }

    /* renamed from: ࢦ, reason: contains not printable characters */
    public float m14443() {
        return m14428(this.f16234);
    }

    /* renamed from: ࢧ, reason: contains not printable characters */
    public float m14444() {
        return this.f16256;
    }

    /* renamed from: ࢨ, reason: contains not printable characters */
    public int m14445() {
        return this.f16193;
    }

    /* renamed from: ࢩ, reason: contains not printable characters */
    public float m14446() {
        return C2579.m9438(2.0f);
    }

    /* renamed from: ࢪ, reason: contains not printable characters */
    public float m14447() {
        return this.f16254;
    }

    /* renamed from: ࢫ, reason: contains not printable characters */
    public int m14448() {
        return C2579.m9438(15.0f);
    }

    /* renamed from: ࢬ, reason: contains not printable characters */
    public int m14449() {
        return C2579.m9438(30.0f);
    }

    /* renamed from: ࢭ, reason: contains not printable characters */
    public int m14450() {
        return C2579.m9438(50.0f);
    }

    /* renamed from: ࢮ, reason: contains not printable characters */
    public int m14451() {
        return C2579.m9438(64.0f);
    }

    /* renamed from: ࢯ, reason: contains not printable characters */
    public int m14452(int i) {
        return (int) ((i * 9.0f) / 16.0f);
    }

    /* renamed from: ࢰ, reason: contains not printable characters */
    public int m14453() {
        return this.f16186;
    }

    /* renamed from: ࢱ, reason: contains not printable characters */
    public int m14454() {
        return this.f16181;
    }

    /* renamed from: ࢲ, reason: contains not printable characters */
    public float m14455(float f) {
        float f2 = this.f16170;
        if (f2 > f) {
            f2 = ((f2 - f) / 2.0f) + f;
        }
        return f2 / f;
    }

    /* renamed from: ࢳ, reason: contains not printable characters */
    public int m14456() {
        return this.f16260;
    }

    /* renamed from: ࢴ, reason: contains not printable characters */
    public int m14457() {
        return this.f16258;
    }

    /* renamed from: ࢶ, reason: contains not printable characters */
    public int m14458() {
        return this.f16257;
    }

    /* renamed from: ࢷ, reason: contains not printable characters */
    public int m14459() {
        return this.f16220;
    }

    /* renamed from: ࢸ, reason: contains not printable characters */
    public int m14460() {
        return this.f16219;
    }

    /* renamed from: ࢹ, reason: contains not printable characters */
    public int m14461() {
        return this.f16262;
    }

    /* renamed from: ࢺ, reason: contains not printable characters */
    public int m14462() {
        return this.f16175;
    }

    /* renamed from: ࢻ, reason: contains not printable characters */
    public void m14463(View view, Activity activity) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC4793(viewTreeObserver, activity));
    }

    /* renamed from: ࢼ, reason: contains not printable characters */
    public int m14464() {
        return this.f16214;
    }

    /* renamed from: ࢽ, reason: contains not printable characters */
    public int m14465() {
        return this.f16185;
    }

    /* renamed from: ࢾ, reason: contains not printable characters */
    public void m14466(View view, Activity activity) {
        int iWidth;
        int iHeight;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics();
            iWidth = currentWindowMetrics.getBounds().width();
            iHeight = currentWindowMetrics.getBounds().height();
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            iWidth = displayMetrics.widthPixels;
            iHeight = displayMetrics.heightPixels;
        }
        C2579.f9594 = iWidth;
        C2579.f9593 = iHeight;
        if (m14498()) {
            C2579.f9594 = Math.min(iWidth, iHeight);
            C2579.f9593 = Math.max(iWidth, iHeight);
        } else {
            C2579.f9594 = Math.max(iWidth, iHeight);
            C2579.f9593 = Math.min(iWidth, iHeight);
        }
        C2579.f9595 = iHeight > iWidth ? iWidth : iHeight;
        if (iHeight <= iWidth) {
            iHeight = iWidth;
        }
        C2579.f9596 = iHeight;
        m14463(view, activity);
        this.f16249 = false;
        m14375().m14492(activity);
    }

    /* renamed from: ࢿ, reason: contains not printable characters */
    public int m14467() {
        return m14476(this.f16229);
    }

    /* renamed from: ࣀ, reason: contains not printable characters */
    public int m14468() {
        return m14469(0);
    }

    /* renamed from: ࣁ, reason: contains not printable characters */
    public int m14469(int i) {
        if (!m14498()) {
            return m14470(i);
        }
        int i2 = this.f16209;
        int i3 = (((int) ((this.f16170 * 16.0f) / 9.0f)) >> 1) << 1;
        if (i3 > i2) {
            i3 = i2;
        }
        return Math.max((i2 - i3) / 2, C2579.m9438(i == 0 ? 20.0f : i));
    }

    /* renamed from: ࣂ, reason: contains not printable characters */
    public int m14470(int i) {
        int i2 = this.f16208;
        int i3 = this.f16178;
        int i4 = i2 - i3;
        int i5 = (((int) ((this.f16170 * 16.0f) / 9.0f)) >> 1) << 1;
        if (i5 > i4) {
            i5 = i4;
        }
        return Math.max(((i4 - i5) / 2) + i3, C2579.m9438(i == 0 ? 20.0f : i));
    }

    /* renamed from: ࣃ, reason: contains not printable characters */
    public float m14471() {
        return this.f16213;
    }

    /* renamed from: ࣄ, reason: contains not printable characters */
    public int m14472() {
        return this.f16191;
    }

    /* renamed from: ࣅ, reason: contains not printable characters */
    public int m14473() {
        return this.f16190;
    }

    /* renamed from: ࣆ, reason: contains not printable characters */
    public int m14474() {
        return this.f16239;
    }

    /* renamed from: ࣇ, reason: contains not printable characters */
    public int m14475() {
        return this.f16223;
    }

    /* renamed from: ৼ, reason: contains not printable characters */
    public int m14476(int i) {
        return (int) ((i * 1.0f * m14455(1125.0f)) + 0.5f);
    }

    /* renamed from: ૹ, reason: contains not printable characters */
    public int m14477(float f, float f2) {
        return (int) ((f * m14455(1241.0f) * f2) + 0.5f);
    }

    /* renamed from: ಀ, reason: contains not printable characters */
    public int m14478(float f, float f2) {
        return (int) ((f * m14455(1284.0f) * f2) + 0.5f);
    }

    /* renamed from: ೱ, reason: contains not printable characters */
    public int m14479(float f, float f2) {
        return (int) ((f * m14455(1316.0f) * f2) + 0.5f);
    }

    /* renamed from: ೲ, reason: contains not printable characters */
    public int m14480(float f, float f2) {
        return (int) ((f * m14455(740.0f) * f2) + 0.5f);
    }

    /* renamed from: ഄ, reason: contains not printable characters */
    public int m14481() {
        return m14429(48.0f);
    }

    /* renamed from: ഩ, reason: contains not printable characters */
    public int m14482() {
        return (int) ((m14476(25) * 0.9f) + 0.5f);
    }

    /* renamed from: ഺ, reason: contains not printable characters */
    public int m14483() {
        return this.f16235;
    }

    /* renamed from: ൎ, reason: contains not printable characters */
    public float m14484() {
        C2579.m9451(FilmApp.m402());
        return (this.f16208 * 1.0f) / this.f16209;
    }

    /* renamed from: ൔ, reason: contains not printable characters */
    public int m14485() {
        return this.f16172;
    }

    /* renamed from: ൕ, reason: contains not printable characters */
    public int m14486() {
        return this.f16171;
    }

    /* renamed from: ൖ, reason: contains not printable characters */
    public int m14487() {
        return this.f16225;
    }

    /* renamed from: ൟ, reason: contains not printable characters */
    public int m14488() {
        return this.f16230;
    }

    /* renamed from: ຆ, reason: contains not printable characters */
    public int m14489() {
        return this.f16241;
    }

    /* renamed from: ຉ, reason: contains not printable characters */
    public int m14490() {
        return this.f16232;
    }

    /* renamed from: ຌ, reason: contains not printable characters */
    public int m14491() {
        return this.f16182;
    }

    /* renamed from: ຎ, reason: contains not printable characters */
    public void m14492(Activity activity) {
        int iM9443 = C2579.m9443(activity);
        int iM9442 = C2579.m9442(activity);
        this.f16208 = iM9442 > iM9443 ? iM9442 : iM9443;
        if (iM9442 <= iM9443) {
            iM9443 = iM9442;
        }
        this.f16209 = iM9443;
        this.f16178 = C4257.m13373().m13374(FilmApp.m402());
        m14494();
        m14493(activity);
        m14496();
        int iM14430 = (int) (m14430(15.0f) + 0.5f);
        C4638.m14099("SizeAdaptation", String.format("needAddTopMargin : %s ", Integer.valueOf(iM14430)));
        float fM14455 = m14455(1125.0f);
        this.f16168 = fM14455;
        float f = (this.f16170 * 1.0f) / 1440.0f;
        this.f16210 = f;
        f16138 = f * 6.0f * 0.8f;
        this.f16194 = (((int) ((218.0f * fM14455) + 0.5f)) >> 1) << 1;
        this.f16195 = (((int) ((314.0f * fM14455) + 0.5f)) >> 1) << 1;
        this.f16196 = (int) ((fM14455 * 40.0f) + 0.5f);
        this.f16199 = (int) ((this.f16143 * fM14455) + 0.5f);
        this.f16200 = (int) ((this.f16144 * fM14455) + 0.5f);
        this.f16201 = (int) ((this.f16145 * fM14455) + 0.5f);
        this.f16202 = (int) ((this.f16146 * fM14455) + 0.5f);
        this.f16203 = (int) ((this.f16147 * fM14455) + 0.5f);
        this.f16204 = (int) ((this.f16148 * fM14455) + 0.5f);
        this.f16205 = (int) ((fM14455 * 20.0f) + 0.5f);
        this.f16206 = (int) ((20.0f * fM14455) + 0.5f);
        this.f16190 = ((int) ((this.f16149 * fM14455) + 0.5f)) + iM14430;
        this.f16191 = (int) ((this.f16150 * fM14455) + 0.5f);
        this.f16192 = (int) ((this.f16151 * fM14455) + 0.5f);
        this.f16193 = (int) ((this.f16152 * fM14455) + 0.5f);
        this.f16181 = (int) ((this.f16153 * fM14455) + 0.5f);
        this.f16182 = (int) ((this.f16154 * fM14455) + 0.5f);
        this.f16183 = (int) ((this.f16155 * fM14455) + 0.5f);
        this.f16171 = (int) ((this.f16160 * fM14455) + 0.5f);
        this.f16172 = (int) ((this.f16161 * fM14455) + 0.5f);
        this.f16173 = (int) ((this.f16162 * fM14455) + 0.5f);
        this.f16174 = (int) ((this.f16163 * fM14455) + 0.5f);
        this.f16175 = (int) ((this.f16164 * fM14455) + 0.5f);
        this.f16197 = (((int) ((m14455(1125.0f) * 415.0f) + 0.5f)) >> 1) << 1;
        this.f16198 = (((int) ((m14455(1125.0f) * 633.0f) + 0.5f)) >> 1) << 1;
        float f2 = this.f16156;
        float f3 = this.f16168;
        this.f16184 = (int) ((f2 * f3) + 0.5f);
        this.f16185 = (int) ((this.f16157 * f3) + 0.5f);
        this.f16186 = (int) ((this.f16159 * f3) + 0.5f);
        this.f16187 = (int) ((this.f16165 * f3) + 0.5f);
        this.f16188 = (int) ((this.f16166 * f3) + 0.5f);
        this.f16189 = (int) ((this.f16167 * f3) + 0.5f);
        this.f16207 = (int) ((this.f16158 * f3) + 0.5f);
        this.f16176 = new TextPaint();
        float fM14381 = m14375().m14381();
        this.f16176.setTextSize(fM14381);
        this.f16176.setTypeface(FilmApp.m403());
        C4638.m14099("SizeAdaptation", String.format("textSize_15 : %s ", Float.valueOf(fM14381)));
        this.f16177 = new TextPaint();
        int iM14386 = m14375().m14386();
        this.f16177.setTextSize(iM14386);
        this.f16177.setTypeface(FilmApp.m404());
        C4638.m14099("SizeAdaptation", String.format("textSize_25 : %s ", Integer.valueOf(iM14386)));
        int iMeasureText = (int) (this.f16176.measureText("1080P") + 1.0f);
        int iMeasureText2 = (int) (this.f16176.measureText("24 (12.5×)") + 1.0f);
        int iMeasureText3 = (int) (this.f16176.measureText("1/1234") + 1.0f);
        int iMeasureText4 = (int) (this.f16176.measureText("6400") + 1.0f);
        int iMeasureText5 = (int) (this.f16176.measureText("1234K") + 1.0f);
        int iMeasureText6 = (int) (this.f16176.measureText(C3444.InterfaceC3449.f11902.m12139()) + 1.0f);
        float f4 = this.f16168;
        int i = (int) ((63.0f * f4) + 0.5f);
        this.f16214 = i;
        int i2 = (int) ((10 * f4) + 0.5f);
        this.f16227 = i2;
        this.f16219 = ((((int) ((30.0f * f4) + 0.5f)) >> 1) << 1) + iM14430;
        this.f16220 = (int) ((38 * f4) + 0.5f);
        this.f16221 = iMeasureText + i;
        this.f16222 = iMeasureText2 + i;
        this.f16223 = iMeasureText3 + i + i2;
        this.f16224 = iMeasureText4 + i + i2;
        this.f16225 = iMeasureText5 + i + i2;
        this.f16226 = iMeasureText6 + i;
        this.f16215 = (int) ((40.0f * f4) + 0.5f);
        this.f16216 = (int) ((1054.0f * f4) + 0.5f);
        this.f16217 = (int) ((28.0f * f4) + 0.5f);
        this.f16218 = (int) ((f4 * 36.0f) + 0.5f);
    }

    /* renamed from: ຏ, reason: contains not printable characters */
    public void m14493(Context context) {
        float f;
        float f2;
        float fM14444;
        if (this.f16208 == 0 || this.f16209 == 0) {
            C2579.m9443(context);
            C2579.m9442(context);
        }
        if (C2579.m9451(FilmApp.m402())) {
            if ((C2579.m9444() * 1.0f) / C2579.m9445() > 1.5f) {
                if (m14498()) {
                    f2 = C2579.f9593 * 0.9f;
                    fM14444 = m14444();
                } else {
                    f2 = C2579.f9594 * 0.9f;
                    fM14444 = m14444();
                }
            } else if (m14498()) {
                f2 = C2579.f9593;
                fM14444 = m14444();
            } else {
                f2 = C2579.f9594;
                fM14444 = m14444();
            }
            f = f2 / fM14444;
        } else {
            int i = C2579.f9594;
            int i2 = C2579.f9593;
            f = i > i2 ? i2 : C2579.f9594;
        }
        int i3 = (((int) ((f * 16.0f) / 9.0f)) >> 1) << 1;
        int i4 = this.f16208;
        if (i3 > i4) {
            f = (((int) ((i4 * 9.0f) / 16.0f)) >> 1) << 1;
            i3 = i4;
        }
        if (m14498()) {
            C2579.f9597 = i3;
            C2579.f9598 = (int) f;
        } else {
            C2579.f9597 = (int) f;
            C2579.f9598 = i3;
        }
        this.f16169 = i3;
        int i5 = (int) f;
        this.f16170 = i5;
        C2579.f9600 = i5;
        C2579.f9599 = i3;
        C4638.m14101("WME", "mCameraShort: " + this.f16170 + " mCameraLong: " + this.f16169 + " mCameraWidth: " + C2579.f9598 + " mCameraHeight: " + C2579.f9597);
        this.f16168 = m14455(1125.0f);
    }

    /* renamed from: ຐ, reason: contains not printable characters */
    public final void m14494() {
        int i = this.f16208;
        float f = (i - this.f16178) * 1.0f;
        int i2 = this.f16170;
        if (f / i2 > 1.7777778f) {
            this.f16212 = 1.0f;
        } else {
            this.f16212 = i / (i2 * 1.7777778f);
        }
    }

    /* renamed from: ຑ, reason: contains not printable characters */
    public void m14495() {
        this.f16253 = C2618.m9565("orientation_bool_sp", false);
    }

    /* renamed from: ຒ, reason: contains not printable characters */
    public final void m14496() {
        float f = (this.f16170 * 16.0f) / 9.0f;
        float f2 = this.f16208 - this.f16178;
        if (f > f2) {
            this.f16213 = f2 / f;
        }
    }

    /* renamed from: ຓ, reason: contains not printable characters */
    public boolean m14497() {
        return this.f16179;
    }

    /* renamed from: ຘ, reason: contains not printable characters */
    public boolean m14498() {
        return this.f16253;
    }

    /* renamed from: ຠ, reason: contains not printable characters */
    public int m14499(String str) {
        return (int) (this.f16177.measureText(str) + 1.0f);
    }

    /* renamed from: ຨ, reason: contains not printable characters */
    public void m14500() {
        this.f16223 = ((int) ((C3947.m12727().m12764() ? this.f16176.measureText("127.8°") : this.f16176.measureText("1/1234")) + 1.0f)) + this.f16214 + this.f16227;
    }

    /* renamed from: ຩ, reason: contains not printable characters */
    public void m14501(String str, String str2, String str3) {
        int iMeasureText = (int) (this.f16176.measureText(str2) + 1.0f);
        int iMeasureText2 = (int) (this.f16176.measureText(str3) + 1.0f);
        int i = this.f16214;
        this.f16224 = iMeasureText + i + this.f16227;
        this.f16222 = iMeasureText2 + i;
    }

    /* renamed from: ຬ, reason: contains not printable characters */
    public void m14502(boolean z) {
        this.f16179 = z;
    }

    /* renamed from: ໞ, reason: contains not printable characters */
    public void m14503(int i) {
        this.f16261 = i;
    }

    /* renamed from: ໟ, reason: contains not printable characters */
    public void m14504(boolean z) {
        this.f16253 = z;
        C2618.m9570("orientation_bool_sp", z);
    }

    /* renamed from: ྈ, reason: contains not printable characters */
    public void m14505(int i) {
        this.f16260 = i;
    }

    /* renamed from: ྉ, reason: contains not printable characters */
    public void m14506(int i) {
        this.f16258 = i;
    }

    /* renamed from: ྌ, reason: contains not printable characters */
    public void m14507(int i) {
        this.f16259 = i;
    }

    /* renamed from: ဢ, reason: contains not printable characters */
    public void m14508(int i) {
        this.f16257 = i;
    }

    /* renamed from: ဨ, reason: contains not printable characters */
    public void m14509(float f) {
        this.f16255 = f;
    }

    /* renamed from: ၚ, reason: contains not printable characters */
    public void m14510(int i) {
        this.f16262 = i;
    }
}
