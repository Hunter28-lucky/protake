package com.mob.pushsdk;

import com.mob.MobSDK;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes2.dex */
public class MobPushException extends RuntimeException implements PublicMemberKeeper {
    public int code;
    public String msgRes;

    public enum MobPushError implements PublicMemberKeeper {
        INVALIDFCMTAGS(-3, "fcm_topic_invalid");

        private int code;
        private String msgRes;

        MobPushError(int i, String str) {
            this.code = i;
            this.msgRes = str;
        }
    }

    public MobPushException(MobPushError mobPushError) {
        super(MobSDK.getContext().getString(ResHelper.getStringRes(MobSDK.getContext(), mobPushError.msgRes)));
        String string = MobSDK.getContext().getString(ResHelper.getStringRes(MobSDK.getContext(), mobPushError.msgRes));
        this.code = mobPushError.code;
        this.msgRes = string;
    }
}
