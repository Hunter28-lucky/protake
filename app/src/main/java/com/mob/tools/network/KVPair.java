package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;

/* loaded from: classes2.dex */
public class KVPair<T> implements PublicMemberKeeper {
    public final String name;
    public final T value;

    public KVPair(String str, T t) {
        this.name = str;
        this.value = t;
    }

    public String toString() {
        return this.name + " = " + this.value;
    }
}
