package com.mob.commons;

import com.mob.pushsdk.MobPush;
import com.mob.tools.proguard.ClassKeeper;

/* loaded from: classes2.dex */
public class MOBPUSH implements MobProduct, ClassKeeper {
    @Override // com.mob.commons.MobProduct
    public String getProductTag() {
        return MobPush.sdkTag;
    }

    @Override // com.mob.commons.MobProduct
    public int getSdkver() {
        return MobPush.SDK_VERSION_CODE;
    }
}
