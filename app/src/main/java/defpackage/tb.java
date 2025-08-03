package defpackage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;

/* loaded from: classes.dex */
public class tb {

    /* renamed from: tb$Ϳ, reason: contains not printable characters */
    public static class DialogInterfaceOnKeyListenerC2287 implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static AlertDialog.Builder m8299(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(str3) && onClickListener2 != null) {
            builder.setPositiveButton(str3, onClickListener2);
        }
        if (!TextUtils.isEmpty(str2) && onClickListener != null) {
            builder.setNegativeButton(str2, onClickListener);
        }
        return builder;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Dialog m8300(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builderM8299 = m8299(context, str, str3, onClickListener, str4, onClickListener2);
        builderM8299.setTitle(str);
        builderM8299.setMessage(str2);
        AlertDialog alertDialogCreate = builderM8299.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setOnKeyListener(new DialogInterfaceOnKeyListenerC2287());
        try {
            alertDialogCreate.show();
        } catch (Throwable th) {
            hf.m6204("mspl", "showDialog ", th);
        }
        return alertDialogCreate;
    }
}
