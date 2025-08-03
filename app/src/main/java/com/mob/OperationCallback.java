package com.mob;

import com.mob.tools.proguard.PublicMemberKeeper;

@Deprecated
/* loaded from: classes2.dex */
public abstract class OperationCallback<T> implements PublicMemberKeeper {
    public abstract void onComplete(T t);

    public abstract void onFailure(Throwable th);
}
