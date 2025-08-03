package com.mob.pushsdk.biz;

import androidx.core.app.NotificationCompat;
import com.mob.MobCommunicator;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class b {
    private Hashon a = new Hashon();

    public void a(Object obj) {
        b(obj);
    }

    public void b(Object obj) {
    }

    public void a(Throwable th) {
        if (!(th instanceof MobCommunicator.NetworkError)) {
            a(-1, th);
            return;
        }
        HashMap mapFromJson = this.a.fromJson(th.getMessage());
        if (mapFromJson == null || mapFromJson.isEmpty()) {
            return;
        }
        a(((Integer) ResHelper.forceCast(mapFromJson.get(NotificationCompat.CATEGORY_STATUS), -1)).intValue(), th);
    }

    public void a(int i, Throwable th) {
        PLog.getInstance().d(Integer.valueOf(i), new Object[0]);
        PLog.getInstance().d(th);
    }
}
