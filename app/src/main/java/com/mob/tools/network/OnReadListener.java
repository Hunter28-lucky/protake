package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface OnReadListener extends PublicMemberKeeper {
    void onRead(long j) throws IOException;
}
