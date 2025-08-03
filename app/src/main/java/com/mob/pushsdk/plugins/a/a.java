package com.mob.pushsdk.plugins.a;

import android.content.Context;
import android.text.TextUtils;
import com.mob.pushsdk.impl.m;
import com.mob.tools.utils.Hashon;

/* loaded from: classes2.dex */
public abstract class a {
    public static final int ACTION_ALIAS = 4;
    public static final int ACTION_COMMAND_RESULT = 3;
    public static final int ACTION_NOTIFICATION_MESSAGE_ARRIVED = 1;
    public static final int ACTION_NOTIFICATION_MESSAGE_CLICKED = 0;
    public static final int ACTION_NOTIFICATION_SHOW = 6;
    public static final int ACTION_RECEIVE_REGISTER_RESULT = 2;
    public static final int ACTION_TAGS = 5;
    public static final Hashon HASHON = new Hashon();
    public m pushSDKImpl = m.a();

    public void bindPlugin(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            com.mob.pushsdk.b.d.a().b("[" + str + "] channel register failure.");
            return;
        }
        com.mob.pushsdk.b.d.a().b("[" + str + "] channel register successful.");
        this.pushSDKImpl.a(str2);
    }

    public abstract void doPluginRecevier(Context context, int i, Object obj);
}
