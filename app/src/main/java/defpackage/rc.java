package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class rc extends od {
    @Override // defpackage.se
    /* renamed from: Ϳ, reason: contains not printable characters */
    public AbstractC5165 mo8168(Context context, int i, Intent intent) {
        if (4103 != i && 4098 != i) {
            return null;
        }
        AbstractC5165 abstractC5165M8169 = m8169(intent);
        re.m8171().m8177((C2318) abstractC5165M8169, "push_transmit", i);
        return abstractC5165M8169;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public AbstractC5165 m8169(Intent intent) {
        try {
            C2318 c2318 = new C2318();
            c2318.m8709(xa.m8599(intent.getStringExtra("messageID")));
            c2318.m8711(xa.m8599(intent.getStringExtra("taskID")));
            c2318.m8706(xa.m8599(intent.getStringExtra("appPackage")));
            c2318.m8712(xa.m8599(intent.getStringExtra("title")));
            c2318.m8707(xa.m8599(intent.getStringExtra("content")));
            c2318.m8708(xa.m8599(intent.getStringExtra("description")));
            String strM8599 = xa.m8599(intent.getStringExtra("notifyID"));
            c2318.m8710(TextUtils.isEmpty(strM8599) ? 0 : Integer.parseInt(strM8599));
            return c2318;
        } catch (Exception e2) {
            qd.m8124("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }
}
