package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import java.util.Map;

/* compiled from: RequestOptions.java */
/* renamed from: ࠌ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3900 implements Cloneable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f13493;

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public Drawable f13497;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f13498;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public Drawable f13499;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f13500;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f13505;

    /* renamed from: ބ, reason: contains not printable characters */
    @Nullable
    public Drawable f13507;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f13508;

    /* renamed from: މ, reason: contains not printable characters */
    public boolean f13512;

    /* renamed from: ފ, reason: contains not printable characters */
    @Nullable
    public Resources.Theme f13513;

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean f13514;

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean f13515;

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean f13516;

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean f13518;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f13494 = 1.0f;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public AbstractC3541 f13495 = AbstractC3541.f12343;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public Priority f13496 = Priority.NORMAL;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f13501 = true;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f13502 = -1;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f13503 = -1;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public InterfaceC3773 f13504 = C2499.m9211();

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f13506 = true;

    /* renamed from: ކ, reason: contains not printable characters */
    @NonNull
    public C3475 f13509 = new C3475();

    /* renamed from: އ, reason: contains not printable characters */
    @NonNull
    public Map<Class<?>, a3<?>> f13510 = new C2756();

    /* renamed from: ވ, reason: contains not printable characters */
    @NonNull
    public Class<?> f13511 = Object.class;

    /* renamed from: ގ, reason: contains not printable characters */
    public boolean f13517 = true;

    @NonNull
    @CheckResult
    /* renamed from: ԭ, reason: contains not printable characters */
    public static C3900 m12575(@NonNull Class<?> cls) {
        return new C3900().m12583(cls);
    }

    @NonNull
    @CheckResult
    /* renamed from: ԯ, reason: contains not printable characters */
    public static C3900 m12576(@NonNull AbstractC3541 abstractC3541) {
        return new C3900().m12584(abstractC3541);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public static boolean m12577(int i, int i2) {
        return (i & i2) != 0;
    }

    @NonNull
    @CheckResult
    /* renamed from: ߿, reason: contains not printable characters */
    public static C3900 m12578(@NonNull InterfaceC3773 interfaceC3773) {
        return new C3900().m12628(interfaceC3773);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3900)) {
            return false;
        }
        C3900 c3900 = (C3900) obj;
        return Float.compare(c3900.f13494, this.f13494) == 0 && this.f13498 == c3900.f13498 && j5.m7086(this.f13497, c3900.f13497) && this.f13500 == c3900.f13500 && j5.m7086(this.f13499, c3900.f13499) && this.f13508 == c3900.f13508 && j5.m7086(this.f13507, c3900.f13507) && this.f13501 == c3900.f13501 && this.f13502 == c3900.f13502 && this.f13503 == c3900.f13503 && this.f13505 == c3900.f13505 && this.f13506 == c3900.f13506 && this.f13515 == c3900.f13515 && this.f13516 == c3900.f13516 && this.f13495.equals(c3900.f13495) && this.f13496 == c3900.f13496 && this.f13509.equals(c3900.f13509) && this.f13510.equals(c3900.f13510) && this.f13511.equals(c3900.f13511) && j5.m7086(this.f13504, c3900.f13504) && j5.m7086(this.f13513, c3900.f13513);
    }

    public int hashCode() {
        return j5.m7096(this.f13513, j5.m7096(this.f13504, j5.m7096(this.f13511, j5.m7096(this.f13510, j5.m7096(this.f13509, j5.m7096(this.f13496, j5.m7096(this.f13495, j5.m7097(this.f13516, j5.m7097(this.f13515, j5.m7097(this.f13506, j5.m7097(this.f13505, j5.m7095(this.f13503, j5.m7095(this.f13502, j5.m7097(this.f13501, j5.m7096(this.f13507, j5.m7095(this.f13508, j5.m7096(this.f13499, j5.m7095(this.f13500, j5.m7096(this.f13497, j5.m7095(this.f13498, j5.m7093(this.f13494)))))))))))))))))))));
    }

    @NonNull
    @CheckResult
    /* renamed from: Ϳ, reason: contains not printable characters */
    public C3900 m12579(@NonNull C3900 c3900) {
        if (this.f13514) {
            return clone().m12579(c3900);
        }
        if (m12577(c3900.f13493, 2)) {
            this.f13494 = c3900.f13494;
        }
        if (m12577(c3900.f13493, 262144)) {
            this.f13515 = c3900.f13515;
        }
        if (m12577(c3900.f13493, 1048576)) {
            this.f13518 = c3900.f13518;
        }
        if (m12577(c3900.f13493, 4)) {
            this.f13495 = c3900.f13495;
        }
        if (m12577(c3900.f13493, 8)) {
            this.f13496 = c3900.f13496;
        }
        if (m12577(c3900.f13493, 16)) {
            this.f13497 = c3900.f13497;
        }
        if (m12577(c3900.f13493, 32)) {
            this.f13498 = c3900.f13498;
        }
        if (m12577(c3900.f13493, 64)) {
            this.f13499 = c3900.f13499;
        }
        if (m12577(c3900.f13493, 128)) {
            this.f13500 = c3900.f13500;
        }
        if (m12577(c3900.f13493, 256)) {
            this.f13501 = c3900.f13501;
        }
        if (m12577(c3900.f13493, 512)) {
            this.f13503 = c3900.f13503;
            this.f13502 = c3900.f13502;
        }
        if (m12577(c3900.f13493, 1024)) {
            this.f13504 = c3900.f13504;
        }
        if (m12577(c3900.f13493, 4096)) {
            this.f13511 = c3900.f13511;
        }
        if (m12577(c3900.f13493, 8192)) {
            this.f13507 = c3900.f13507;
        }
        if (m12577(c3900.f13493, 16384)) {
            this.f13508 = c3900.f13508;
        }
        if (m12577(c3900.f13493, 32768)) {
            this.f13513 = c3900.f13513;
        }
        if (m12577(c3900.f13493, 65536)) {
            this.f13506 = c3900.f13506;
        }
        if (m12577(c3900.f13493, 131072)) {
            this.f13505 = c3900.f13505;
        }
        if (m12577(c3900.f13493, 2048)) {
            this.f13510.putAll(c3900.f13510);
            this.f13517 = c3900.f13517;
        }
        if (m12577(c3900.f13493, 524288)) {
            this.f13516 = c3900.f13516;
        }
        if (!this.f13506) {
            this.f13510.clear();
            int i = this.f13493 & (-2049);
            this.f13505 = false;
            this.f13493 = i & (-131073);
            this.f13517 = true;
        }
        this.f13493 |= c3900.f13493;
        this.f13509.m11330(c3900.f13509);
        return m12626();
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public C3900 m12580() {
        if (this.f13512 && !this.f13514) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f13514 = true;
        return m12616();
    }

    @NonNull
    @CheckResult
    /* renamed from: ԩ, reason: contains not printable characters */
    public C3900 m12581() {
        return m12633(DownsampleStrategy.f5358, new C3647());
    }

    @CheckResult
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C3900 clone() {
        try {
            C3900 c3900 = (C3900) super.clone();
            C3475 c3475 = new C3475();
            c3900.f13509 = c3475;
            c3475.m11330(this.f13509);
            C2756 c2756 = new C2756();
            c3900.f13510 = c2756;
            c2756.putAll(this.f13510);
            c3900.f13512 = false;
            c3900.f13514 = false;
            return c3900;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    @CheckResult
    /* renamed from: Ԭ, reason: contains not printable characters */
    public C3900 m12583(@NonNull Class<?> cls) {
        if (this.f13514) {
            return clone().m12583(cls);
        }
        this.f13511 = (Class) C4513.m13867(cls);
        this.f13493 |= 4096;
        return m12626();
    }

    @NonNull
    @CheckResult
    /* renamed from: Ԯ, reason: contains not printable characters */
    public C3900 m12584(@NonNull AbstractC3541 abstractC3541) {
        if (this.f13514) {
            return clone().m12584(abstractC3541);
        }
        this.f13495 = (AbstractC3541) C4513.m13867(abstractC3541);
        this.f13493 |= 4;
        return m12626();
    }

    @NonNull
    @CheckResult
    /* renamed from: ՠ, reason: contains not printable characters */
    public C3900 m12585() {
        return m12627(C3605.f12534, Boolean.TRUE);
    }

    @NonNull
    @CheckResult
    /* renamed from: ֈ, reason: contains not printable characters */
    public C3900 m12586(@NonNull DownsampleStrategy downsampleStrategy) {
        return m12627(DownsampleStrategy.f5364, C4513.m13867(downsampleStrategy));
    }

    @NonNull
    @CheckResult
    /* renamed from: ֏, reason: contains not printable characters */
    public C3900 m12587(@DrawableRes int i) {
        if (this.f13514) {
            return clone().m12587(i);
        }
        this.f13498 = i;
        this.f13493 |= 32;
        return m12626();
    }

    @NonNull
    @CheckResult
    /* renamed from: ׯ, reason: contains not printable characters */
    public C3900 m12588() {
        return m12624(DownsampleStrategy.f5357, new C3629());
    }

    @NonNull
    /* renamed from: ؠ, reason: contains not printable characters */
    public final AbstractC3541 m12589() {
        return this.f13495;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final int m12590() {
        return this.f13498;
    }

    @Nullable
    /* renamed from: ށ, reason: contains not printable characters */
    public final Drawable m12591() {
        return this.f13497;
    }

    @Nullable
    /* renamed from: ނ, reason: contains not printable characters */
    public final Drawable m12592() {
        return this.f13507;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final int m12593() {
        return this.f13508;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final boolean m12594() {
        return this.f13516;
    }

    @NonNull
    /* renamed from: ޅ, reason: contains not printable characters */
    public final C3475 m12595() {
        return this.f13509;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final int m12596() {
        return this.f13502;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final int m12597() {
        return this.f13503;
    }

    @Nullable
    /* renamed from: ވ, reason: contains not printable characters */
    public final Drawable m12598() {
        return this.f13499;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final int m12599() {
        return this.f13500;
    }

    @NonNull
    /* renamed from: ފ, reason: contains not printable characters */
    public final Priority m12600() {
        return this.f13496;
    }

    @NonNull
    /* renamed from: ދ, reason: contains not printable characters */
    public final Class<?> m12601() {
        return this.f13511;
    }

    @NonNull
    /* renamed from: ތ, reason: contains not printable characters */
    public final InterfaceC3773 m12602() {
        return this.f13504;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final float m12603() {
        return this.f13494;
    }

    @Nullable
    /* renamed from: ގ, reason: contains not printable characters */
    public final Resources.Theme m12604() {
        return this.f13513;
    }

    @NonNull
    /* renamed from: ޏ, reason: contains not printable characters */
    public final Map<Class<?>, a3<?>> m12605() {
        return this.f13510;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final boolean m12606() {
        return this.f13518;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final boolean m12607() {
        return this.f13515;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final boolean m12608() {
        return this.f13501;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final boolean m12609() {
        return m12611(8);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean m12610() {
        return this.f13517;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final boolean m12611(int i) {
        return m12577(this.f13493, i);
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final boolean m12612() {
        return this.f13506;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final boolean m12613() {
        return this.f13505;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final boolean m12614() {
        return m12611(2048);
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final boolean m12615() {
        return j5.m7101(this.f13503, this.f13502);
    }

    @NonNull
    /* renamed from: ޛ, reason: contains not printable characters */
    public C3900 m12616() {
        this.f13512 = true;
        return this;
    }

    @NonNull
    @CheckResult
    /* renamed from: ޜ, reason: contains not printable characters */
    public C3900 m12617() {
        return m12621(DownsampleStrategy.f5358, new C3647());
    }

    @NonNull
    @CheckResult
    /* renamed from: ޝ, reason: contains not printable characters */
    public C3900 m12618() {
        return m12620(DownsampleStrategy.f5361, new C2608());
    }

    @NonNull
    @CheckResult
    /* renamed from: ޞ, reason: contains not printable characters */
    public C3900 m12619() {
        return m12620(DownsampleStrategy.f5357, new C3629());
    }

    @NonNull
    /* renamed from: ޟ, reason: contains not printable characters */
    public final C3900 m12620(@NonNull DownsampleStrategy downsampleStrategy, @NonNull a3<Bitmap> a3Var) {
        return m12625(downsampleStrategy, a3Var, false);
    }

    @NonNull
    /* renamed from: ޠ, reason: contains not printable characters */
    public final C3900 m12621(@NonNull DownsampleStrategy downsampleStrategy, @NonNull a3<Bitmap> a3Var) {
        if (this.f13514) {
            return clone().m12621(downsampleStrategy, a3Var);
        }
        m12586(downsampleStrategy);
        return m12632(a3Var, false);
    }

    @NonNull
    @CheckResult
    /* renamed from: ޡ, reason: contains not printable characters */
    public C3900 m12622(int i, int i2) {
        if (this.f13514) {
            return clone().m12622(i, i2);
        }
        this.f13503 = i;
        this.f13502 = i2;
        this.f13493 |= 512;
        return m12626();
    }

    @NonNull
    @CheckResult
    /* renamed from: ޢ, reason: contains not printable characters */
    public C3900 m12623(@NonNull Priority priority) {
        if (this.f13514) {
            return clone().m12623(priority);
        }
        this.f13496 = (Priority) C4513.m13867(priority);
        this.f13493 |= 8;
        return m12626();
    }

    @NonNull
    /* renamed from: ޣ, reason: contains not printable characters */
    public final C3900 m12624(@NonNull DownsampleStrategy downsampleStrategy, @NonNull a3<Bitmap> a3Var) {
        return m12625(downsampleStrategy, a3Var, true);
    }

    @NonNull
    /* renamed from: ޤ, reason: contains not printable characters */
    public final C3900 m12625(@NonNull DownsampleStrategy downsampleStrategy, @NonNull a3<Bitmap> a3Var, boolean z) {
        C3900 c3900M12633 = z ? m12633(downsampleStrategy, a3Var) : m12621(downsampleStrategy, a3Var);
        c3900M12633.f13517 = true;
        return c3900M12633;
    }

    @NonNull
    /* renamed from: ޥ, reason: contains not printable characters */
    public final C3900 m12626() {
        if (this.f13512) {
            throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
        }
        return this;
    }

    @NonNull
    @CheckResult
    /* renamed from: ޱ, reason: contains not printable characters */
    public <T> C3900 m12627(@NonNull C4238<T> c4238, @NonNull T t) {
        if (this.f13514) {
            return clone().m12627(c4238, t);
        }
        C4513.m13867(c4238);
        C4513.m13867(t);
        this.f13509.m11331(c4238, t);
        return m12626();
    }

    @NonNull
    @CheckResult
    /* renamed from: ߾, reason: contains not printable characters */
    public C3900 m12628(@NonNull InterfaceC3773 interfaceC3773) {
        if (this.f13514) {
            return clone().m12628(interfaceC3773);
        }
        this.f13504 = (InterfaceC3773) C4513.m13867(interfaceC3773);
        this.f13493 |= 1024;
        return m12626();
    }

    @NonNull
    @CheckResult
    /* renamed from: ࡠ, reason: contains not printable characters */
    public C3900 m12629(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.f13514) {
            return clone().m12629(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f13494 = f;
        this.f13493 |= 2;
        return m12626();
    }

    @NonNull
    @CheckResult
    /* renamed from: ࡡ, reason: contains not printable characters */
    public C3900 m12630(boolean z) {
        if (this.f13514) {
            return clone().m12630(true);
        }
        this.f13501 = !z;
        this.f13493 |= 256;
        return m12626();
    }

    @NonNull
    @CheckResult
    /* renamed from: ࡢ, reason: contains not printable characters */
    public C3900 m12631(@NonNull a3<Bitmap> a3Var) {
        return m12632(a3Var, true);
    }

    @NonNull
    /* renamed from: ࡣ, reason: contains not printable characters */
    public final C3900 m12632(@NonNull a3<Bitmap> a3Var, boolean z) {
        if (this.f13514) {
            return clone().m12632(a3Var, z);
        }
        C4208 c4208 = new C4208(a3Var, z);
        m12634(Bitmap.class, a3Var, z);
        m12634(Drawable.class, c4208, z);
        m12634(BitmapDrawable.class, c4208.m13289(), z);
        m12634(C3465.class, new C2465(a3Var), z);
        return m12626();
    }

    @NonNull
    @CheckResult
    /* renamed from: ࡤ, reason: contains not printable characters */
    public final C3900 m12633(@NonNull DownsampleStrategy downsampleStrategy, @NonNull a3<Bitmap> a3Var) {
        if (this.f13514) {
            return clone().m12633(downsampleStrategy, a3Var);
        }
        m12586(downsampleStrategy);
        return m12631(a3Var);
    }

    @NonNull
    /* renamed from: ࡥ, reason: contains not printable characters */
    public final <T> C3900 m12634(@NonNull Class<T> cls, @NonNull a3<T> a3Var, boolean z) {
        if (this.f13514) {
            return clone().m12634(cls, a3Var, z);
        }
        C4513.m13867(cls);
        C4513.m13867(a3Var);
        this.f13510.put(cls, a3Var);
        int i = this.f13493 | 2048;
        this.f13506 = true;
        int i2 = i | 65536;
        this.f13493 = i2;
        this.f13517 = false;
        if (z) {
            this.f13493 = i2 | 131072;
            this.f13505 = true;
        }
        return m12626();
    }

    @NonNull
    @CheckResult
    /* renamed from: ࡦ, reason: contains not printable characters */
    public C3900 m12635(boolean z) {
        if (this.f13514) {
            return clone().m12635(z);
        }
        this.f13518 = z;
        this.f13493 |= 1048576;
        return m12626();
    }
}
