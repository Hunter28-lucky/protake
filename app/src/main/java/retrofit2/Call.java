package retrofit2;

import defpackage.C4539;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    /* renamed from: clone */
    Call<T> mo8196clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    C4539 request();
}
