package defpackage;

import android.content.Context;
import android.widget.ImageView;

/* compiled from: GlideUtil.java */
/* renamed from: ძ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5299 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C5299 f17490;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C3900 f17491;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C3900 f17492;

    public C5299() {
        C3900 c3900M12630 = new C3900().m12588().m12585().m12630(false);
        AbstractC3541 abstractC3541 = AbstractC3541.f12340;
        this.f17491 = c3900M12630.m12584(abstractC3541);
        this.f17492 = new C3900().m12581().m12585().m12630(false).m12584(abstractC3541);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C5299 m15341() {
        if (f17490 == null) {
            synchronized (C5299.class) {
                if (f17490 == null) {
                    f17490 = new C5299();
                }
            }
        }
        return f17490;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m15342(Context context, ImageView imageView, int i) {
        ComponentCallbacks2C3498.m11425(context).m13319(Integer.valueOf(i)).m13956(this.f17491).m13966(imageView);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m15343(Context context, ImageView imageView, String str) {
        ComponentCallbacks2C3498.m11425(context).m13320(str).m13956(this.f17491).m13966(imageView);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m15344(Context context, ImageView imageView, String str, int i) {
        ComponentCallbacks2C3498.m11425(context).m13320(str).m13956(new C3900().m12581().m12585().m12630(false).m12587(i).m12584(AbstractC3541.f12340)).m13966(imageView);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m15345(Context context, ImageView imageView, String str) {
        ComponentCallbacks2C3498.m11425(context).m13320(str).m13956(this.f17492).m13966(imageView);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m15346(Context context, ImageView imageView, int i) {
        ComponentCallbacks2C3498.m11425(context).m13319(Integer.valueOf(i)).m13956(new C3900().m12581().m12585().m12630(false).m12584(AbstractC3541.f12340)).m13966(imageView);
    }
}
