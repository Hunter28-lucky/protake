package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;

/* compiled from: DisplayCutoutSupportP.java */
/* renamed from: ࡂ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3919 implements InterfaceC3463 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String f13542 = C3919.class.getSimpleName();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f13543 = -1;

    /* compiled from: DisplayCutoutSupportP.java */
    /* renamed from: ࡂ$Ϳ, reason: contains not printable characters */
    public class ViewOnApplyWindowInsetsListenerC3920 implements View.OnApplyWindowInsetsListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Activity f13544;

        public ViewOnApplyWindowInsetsListenerC3920(Activity activity) {
            this.f13544 = activity;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        @TargetApi(28)
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            if (windowInsets != null) {
                try {
                    DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                    if (displayCutout != null) {
                        C3919.this.f13543 = displayCutout.getSafeInsetTop();
                        C4638.m14099(C3919.this.f13542, "**controlView**" + displayCutout.getBoundingRects());
                        C4638.m14099(C3919.this.f13542, String.format("mDisplayCutoutHeight : %s , controlView : %s ", Integer.valueOf(C3919.this.f13543), displayCutout.getBoundingRects()));
                    } else {
                        C3919.this.f13543 = C4257.m13373().m13374(this.f13544);
                        C4638.m14099(C3919.this.f13542, String.format("mDisplayCutoutHeight : %s ", Integer.valueOf(C3919.this.f13543)));
                    }
                } catch (Error unused) {
                    C3919.this.f13543 = C4257.m13373().m13374(this.f13544);
                    C4638.m14099(C3919.this.f13542, String.format("mDisplayCutoutHeight : %s ", Integer.valueOf(C3919.this.f13543)));
                }
            }
            this.f13544.getWindow().getDecorView().setOnApplyWindowInsetsListener(null);
            return windowInsets;
        }
    }

    @Override // defpackage.InterfaceC3463
    @TargetApi(28)
    /* renamed from: Ϳ */
    public void mo10680(Activity activity) {
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        activity.requestWindowFeature(1);
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            activity.getWindow().setAttributes(attributes);
        } catch (Error unused) {
        }
        m12661(activity);
        activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC3920(activity));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m12661(Activity activity) {
        y0.m8615(activity);
    }
}
