package defpackage;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.SingleRequest;

/* compiled from: RequestBuilder.java */
/* renamed from: ఱ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4553<TranscodeType> implements Cloneable {

    /* renamed from: ކ, reason: contains not printable characters */
    public static final C3900 f15569 = new C3900().m12584(AbstractC3541.f12341).m12623(Priority.LOW).m12630(true);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Context f15570;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C4226 f15571;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Class<TranscodeType> f15572;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C3900 f15573;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final ComponentCallbacks2C3498 f15574;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C2964 f15575;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public C3900 f15576;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public n3<?, ? super TranscodeType> f15577;

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public Object f15578;

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public InterfaceC4828<TranscodeType> f15579;

    /* renamed from: ހ, reason: contains not printable characters */
    @Nullable
    public C4553<TranscodeType> f15580;

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public C4553<TranscodeType> f15581;

    /* renamed from: ނ, reason: contains not printable characters */
    @Nullable
    public Float f15582;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f15583 = true;

    /* renamed from: ބ, reason: contains not printable characters */
    public boolean f15584;

    /* renamed from: ޅ, reason: contains not printable characters */
    public boolean f15585;

    /* compiled from: RequestBuilder.java */
    /* renamed from: ఱ$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C4554 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f15586;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f15587;

        static {
            int[] iArr = new int[Priority.values().length];
            f15587 = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15587[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15587[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15587[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f15586 = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15586[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15586[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15586[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15586[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15586[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15586[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f15586[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public C4553(ComponentCallbacks2C3498 componentCallbacks2C3498, C4226 c4226, Class<TranscodeType> cls, Context context) {
        this.f15574 = componentCallbacks2C3498;
        this.f15571 = c4226;
        this.f15572 = cls;
        C3900 c3900M13317 = c4226.m13317();
        this.f15573 = c3900M13317;
        this.f15570 = context;
        this.f15577 = c4226.m13318(cls);
        this.f15576 = c3900M13317;
        this.f15575 = componentCallbacks2C3498.m11431();
    }

    @NonNull
    @CheckResult
    /* renamed from: Ϳ, reason: contains not printable characters */
    public C4553<TranscodeType> m13956(@NonNull C3900 c3900) {
        C4513.m13867(c3900);
        this.f15576 = m13961().m12579(c3900);
        return this;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC3684 m13957(c1<TranscodeType> c1Var, @Nullable InterfaceC4828<TranscodeType> interfaceC4828, C3900 c3900) {
        return m13958(c1Var, interfaceC4828, null, this.f15577, c3900.m12600(), c3900.m12597(), c3900.m12596(), c3900);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC3684 m13958(c1<TranscodeType> c1Var, @Nullable InterfaceC4828<TranscodeType> interfaceC4828, @Nullable InterfaceC2839 interfaceC2839, n3<?, ? super TranscodeType> n3Var, Priority priority, int i, int i2, C3900 c3900) {
        InterfaceC2839 interfaceC28392;
        InterfaceC2839 c4220;
        if (this.f15581 != null) {
            c4220 = new C4220(interfaceC2839);
            interfaceC28392 = c4220;
        } else {
            interfaceC28392 = null;
            c4220 = interfaceC2839;
        }
        InterfaceC3684 interfaceC3684M13959 = m13959(c1Var, interfaceC4828, c4220, n3Var, priority, i, i2, c3900);
        if (interfaceC28392 == null) {
            return interfaceC3684M13959;
        }
        int iM12597 = this.f15581.f15576.m12597();
        int iM12596 = this.f15581.f15576.m12596();
        if (j5.m7101(i, i2) && !this.f15581.f15576.m12615()) {
            iM12597 = c3900.m12597();
            iM12596 = c3900.m12596();
        }
        C4553<TranscodeType> c4553 = this.f15581;
        C4220 c42202 = interfaceC28392;
        c42202.m13308(interfaceC3684M13959, c4553.m13958(c1Var, interfaceC4828, interfaceC28392, c4553.f15577, c4553.f15576.m12600(), iM12597, iM12596, this.f15581.f15576));
        return c42202;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3684 m13959(c1<TranscodeType> c1Var, InterfaceC4828<TranscodeType> interfaceC4828, @Nullable InterfaceC2839 interfaceC2839, n3<?, ? super TranscodeType> n3Var, Priority priority, int i, int i2, C3900 c3900) {
        C4553<TranscodeType> c4553 = this.f15580;
        if (c4553 == null) {
            if (this.f15582 == null) {
                return m13972(c1Var, interfaceC4828, c3900, interfaceC2839, n3Var, priority, i, i2);
            }
            l2 l2Var = new l2(interfaceC2839);
            l2Var.m7482(m13972(c1Var, interfaceC4828, c3900, l2Var, n3Var, priority, i, i2), m13972(c1Var, interfaceC4828, c3900.clone().m12629(this.f15582.floatValue()), l2Var, n3Var, m13962(priority), i, i2));
            return l2Var;
        }
        if (this.f15585) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        n3<?, ? super TranscodeType> n3Var2 = c4553.f15583 ? n3Var : c4553.f15577;
        Priority priorityM12600 = c4553.f15576.m12609() ? this.f15580.f15576.m12600() : m13962(priority);
        int iM12597 = this.f15580.f15576.m12597();
        int iM12596 = this.f15580.f15576.m12596();
        if (j5.m7101(i, i2) && !this.f15580.f15576.m12615()) {
            iM12597 = c3900.m12597();
            iM12596 = c3900.m12596();
        }
        l2 l2Var2 = new l2(interfaceC2839);
        InterfaceC3684 interfaceC3684M13972 = m13972(c1Var, interfaceC4828, c3900, l2Var2, n3Var, priority, i, i2);
        this.f15585 = true;
        C4553<TranscodeType> c45532 = this.f15580;
        InterfaceC3684 interfaceC3684M13958 = c45532.m13958(c1Var, interfaceC4828, l2Var2, n3Var2, priorityM12600, iM12597, iM12596, c45532.f15576);
        this.f15585 = false;
        l2Var2.m7482(interfaceC3684M13972, interfaceC3684M13958);
        return l2Var2;
    }

    @CheckResult
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C4553<TranscodeType> clone() {
        try {
            C4553<TranscodeType> c4553 = (C4553) super.clone();
            c4553.f15576 = c4553.f15576.clone();
            c4553.f15577 = c4553.f15577.clone();
            return c4553;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    /* renamed from: ԭ, reason: contains not printable characters */
    public C3900 m13961() {
        C3900 c3900 = this.f15573;
        C3900 c39002 = this.f15576;
        return c3900 == c39002 ? c39002.clone() : c39002;
    }

    @NonNull
    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Priority m13962(@NonNull Priority priority) {
        int i = C4554.f15587[priority.ordinal()];
        if (i == 1) {
            return Priority.NORMAL;
        }
        if (i == 2) {
            return Priority.HIGH;
        }
        if (i == 3 || i == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + this.f15576.m12600());
    }

    @NonNull
    /* renamed from: ԯ, reason: contains not printable characters */
    public <Y extends c1<TranscodeType>> Y m13963(@NonNull Y y) {
        return (Y) m13964(y, null);
    }

    @NonNull
    /* renamed from: ՠ, reason: contains not printable characters */
    public <Y extends c1<TranscodeType>> Y m13964(@NonNull Y y, @Nullable InterfaceC4828<TranscodeType> interfaceC4828) {
        return (Y) m13965(y, interfaceC4828, m13961());
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final <Y extends c1<TranscodeType>> Y m13965(@NonNull Y y, @Nullable InterfaceC4828<TranscodeType> interfaceC4828, @NonNull C3900 c3900) {
        j5.m7084();
        C4513.m13867(y);
        if (!this.f15584) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        C3900 c3900M12580 = c3900.m12580();
        InterfaceC3684 interfaceC3684M13957 = m13957(y, interfaceC4828, c3900M12580);
        InterfaceC3684 interfaceC3684Mo181 = y.mo181();
        if (!interfaceC3684M13957.mo5028(interfaceC3684Mo181) || m13967(c3900M12580, interfaceC3684Mo181)) {
            this.f15571.m13316(y);
            y.mo176(interfaceC3684M13957);
            this.f15571.m13324(y, interfaceC3684M13957);
            return y;
        }
        interfaceC3684M13957.recycle();
        if (!((InterfaceC3684) C4513.m13867(interfaceC3684Mo181)).isRunning()) {
            interfaceC3684Mo181.mo5034();
        }
        return y;
    }

    @NonNull
    /* renamed from: ֏, reason: contains not printable characters */
    public q7<ImageView, TranscodeType> m13966(@NonNull ImageView imageView) {
        j5.m7084();
        C4513.m13867(imageView);
        C3900 c3900M12617 = this.f15576;
        if (!c3900M12617.m12614() && c3900M12617.m12612() && imageView.getScaleType() != null) {
            switch (C4554.f15586[imageView.getScaleType().ordinal()]) {
                case 1:
                    c3900M12617 = c3900M12617.clone().m12617();
                    break;
                case 2:
                    c3900M12617 = c3900M12617.clone().m12618();
                    break;
                case 3:
                case 4:
                case 5:
                    c3900M12617 = c3900M12617.clone().m12619();
                    break;
                case 6:
                    c3900M12617 = c3900M12617.clone().m12618();
                    break;
            }
        }
        return (q7) m13965(this.f15575.m10371(imageView, this.f15572), null, c3900M12617);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final boolean m13967(C3900 c3900, InterfaceC3684 interfaceC3684) {
        return !c3900.m12608() && interfaceC3684.isComplete();
    }

    @NonNull
    @CheckResult
    /* renamed from: ؠ, reason: contains not printable characters */
    public C4553<TranscodeType> m13968(@Nullable @DrawableRes @RawRes Integer num) {
        return m13971(num).m13956(C3900.m12578(C4747.m14291(this.f15570)));
    }

    @NonNull
    @CheckResult
    /* renamed from: ހ, reason: contains not printable characters */
    public C4553<TranscodeType> m13969(@Nullable Object obj) {
        return m13971(obj);
    }

    @NonNull
    @CheckResult
    /* renamed from: ށ, reason: contains not printable characters */
    public C4553<TranscodeType> m13970(@Nullable String str) {
        return m13971(str);
    }

    @NonNull
    /* renamed from: ނ, reason: contains not printable characters */
    public final C4553<TranscodeType> m13971(@Nullable Object obj) {
        this.f15578 = obj;
        this.f15584 = true;
        return this;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final InterfaceC3684 m13972(c1<TranscodeType> c1Var, InterfaceC4828<TranscodeType> interfaceC4828, C3900 c3900, InterfaceC2839 interfaceC2839, n3<?, ? super TranscodeType> n3Var, Priority priority, int i, int i2) {
        Context context = this.f15570;
        C2964 c2964 = this.f15575;
        return SingleRequest.m5025(context, c2964, this.f15578, this.f15572, c3900, i, i2, priority, c1Var, interfaceC4828, this.f15579, interfaceC2839, c2964.m10375(), n3Var.m7624());
    }
}
