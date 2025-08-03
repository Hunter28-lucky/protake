package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class HTTPPart implements PublicMemberKeeper {
    private long a;
    private OnReadListener b;

    public abstract InputStream a() throws Throwable;

    public abstract long b() throws Throwable;

    public Object getInputStreamEntity() throws Throwable {
        InputStream inputStream = toInputStream();
        long jB = b() - this.a;
        ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
        return ReflectHelper.newInstance("InputStreamEntity", inputStream, Long.valueOf(jB));
    }

    public void setOffset(long j) {
        this.a = j;
    }

    public void setOnReadListener(OnReadListener onReadListener) {
        this.b = onReadListener;
    }

    public InputStream toInputStream() throws Throwable {
        return new ByteCounterInputStream(a());
    }
}
