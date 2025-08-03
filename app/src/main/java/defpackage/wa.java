package defpackage;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public class wa extends od {
    @Override // defpackage.se
    /* renamed from: Ϳ */
    public AbstractC5165 mo8168(Context context, int i, Intent intent) {
        if (4105 == i) {
            return m8524(intent);
        }
        return null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public AbstractC5165 m8524(Intent intent) {
        try {
            va vaVar = new va();
            vaVar.m8477(Integer.parseInt(xa.m8599(intent.getStringExtra("command"))));
            vaVar.m8479(Integer.parseInt(xa.m8599(intent.getStringExtra("code"))));
            vaVar.m8482(xa.m8599(intent.getStringExtra("content")));
            vaVar.m8478(xa.m8599(intent.getStringExtra("appKey")));
            vaVar.m8480(xa.m8599(intent.getStringExtra("appSecret")));
            vaVar.m8484(xa.m8599(intent.getStringExtra("appPackage")));
            qd.m8124("OnHandleIntent-message:" + vaVar.toString());
            return vaVar;
        } catch (Exception e2) {
            qd.m8124("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }
}
