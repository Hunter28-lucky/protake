package com.zhiyun.sdk.callbaks;

import com.zhiyun.sdk.exception.OptionalDeviceException;

/* loaded from: classes2.dex */
public interface AngleCallback {
    void call(float f, float f2, float f3);

    void onFailed(OptionalDeviceException optionalDeviceException);
}
