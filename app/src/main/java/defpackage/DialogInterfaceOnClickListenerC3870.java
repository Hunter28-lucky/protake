package defpackage;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: FinishListener.java */
/* renamed from: ߪ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC3870 implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Activity f13312;

    public DialogInterfaceOnClickListenerC3870(Activity activity) {
        this.f13312 = activity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m12319();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        m12319();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m12319() {
        this.f13312.finish();
    }
}
