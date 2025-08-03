package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.util.Log;

/* loaded from: classes2.dex */
public class IdentifierIdObserver extends ContentObserver {
    private String b;
    private int c;
    private IdentifierIdClient d;

    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i, String str) {
        super(null);
        this.d = identifierIdClient;
        this.c = i;
        this.b = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        IdentifierIdClient identifierIdClient = this.d;
        if (identifierIdClient != null) {
            identifierIdClient.a(this.c, this.b);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
