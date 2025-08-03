package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.blink.academy.protake.R;

/* compiled from: LoadingDialog.java */
/* renamed from: ڿ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3617 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C3617 f12562;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Context f12563;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Dialog f12564;

    /* compiled from: LoadingDialog.java */
    /* renamed from: ڿ$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC3618 implements View.OnClickListener {
        public ViewOnClickListenerC3618() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m11670() {
        C3617 c3617 = f12562;
        if (c3617 != null) {
            c3617.m11673();
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static C3617 m11671(Context context) {
        if (f12562 == null || f12563 != context) {
            synchronized (C3617.class) {
                if (f12562 == null || f12563 != context) {
                    C3617 c3617 = new C3617();
                    f12562 = c3617;
                    c3617.m11674(context);
                }
            }
        }
        return f12562;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m11672() {
        m11673();
        f12563 = null;
        f12562 = null;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m11673() {
        Dialog dialog = this.f12564;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f12564.dismiss();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m11674(Context context) {
        f12563 = context;
        this.f12564 = new Dialog(context);
        View viewInflate = View.inflate(context, R.layout.layout_loading_dialog_content, null);
        viewInflate.findViewById(R.id.loading_dialog_root).setOnClickListener(new ViewOnClickListenerC3618());
        this.f12564.requestWindowFeature(1);
        this.f12564.setContentView(viewInflate);
        Window window = this.f12564.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.gravity = 17;
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            window.setAttributes(attributes);
            window.getDecorView().setSystemUiVisibility(2);
            window.getDecorView().setSystemUiVisibility(5894);
        }
        this.f12564.setCancelable(false);
        this.f12564.setCanceledOnTouchOutside(false);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m11675() {
        Dialog dialog = this.f12564;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        this.f12564.show();
    }
}
