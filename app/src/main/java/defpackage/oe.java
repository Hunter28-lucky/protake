package defpackage;

import android.database.ContentObserver;
import android.util.Log;

/* loaded from: classes.dex */
public class oe extends ContentObserver {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f8097;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f8098;

    /* renamed from: ԩ, reason: contains not printable characters */
    public ed f8099;

    public oe(ed edVar, int i, String str) {
        super(null);
        this.f8099 = edVar;
        this.f8098 = i;
        this.f8097 = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        ed edVar = this.f8099;
        if (edVar != null) {
            edVar.m6023(this.f8098, this.f8097);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
