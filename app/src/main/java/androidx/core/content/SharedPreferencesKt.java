package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: SharedPreferences.kt */
/* loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences sharedPreferences, boolean z, InterfaceC2392<? super SharedPreferences.Editor, i4> interfaceC2392) {
        C3921.m12666(sharedPreferences, "<this>");
        C3921.m12666(interfaceC2392, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        C3921.m12665(editorEdit, "editor");
        interfaceC2392.invoke(editorEdit);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z, InterfaceC2392 interfaceC2392, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        C3921.m12666(sharedPreferences, "<this>");
        C3921.m12666(interfaceC2392, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        C3921.m12665(editorEdit, "editor");
        interfaceC2392.invoke(editorEdit);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
