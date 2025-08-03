package com.efs.sdk.base.core.util.a;

import androidx.annotation.NonNull;
import com.efs.sdk.base.http.HttpResponse;

/* loaded from: classes.dex */
public final class c extends com.efs.sdk.base.core.util.concurrent.d<HttpResponse> {
    public b a;

    public c(@NonNull b bVar) {
        super(bVar);
        this.a = bVar;
    }

    @NonNull
    public final HttpResponse b() {
        this.a.f17648e = "post";
        return a();
    }
}
