package defpackage;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class od implements se {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static List<AbstractC5165> m7707(Context context, Intent intent) throws NumberFormatException {
        AbstractC5165 abstractC5165Mo8168;
        if (intent == null) {
            return null;
        }
        int i = 4096;
        try {
            i = Integer.parseInt(xa.m8599(intent.getStringExtra("type")));
        } catch (Exception e2) {
            qd.m8125("MessageParser--getMessageByIntent--Exception:" + e2.getMessage());
        }
        qd.m8124("MessageParser--getMessageByIntent--type:" + i);
        ArrayList arrayList = new ArrayList();
        for (se seVar : re.m8171().m8189()) {
            if (seVar != null && (abstractC5165Mo8168 = seVar.mo8168(context, i, intent)) != null) {
                arrayList.add(abstractC5165Mo8168);
            }
        }
        return arrayList;
    }
}
