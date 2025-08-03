package com.zhiyun.sdk.exception;

/* loaded from: classes2.dex */
public class UninitializedException extends RuntimeException {
    public UninitializedException() {
    }

    public UninitializedException(String str) {
        super(str);
    }

    public UninitializedException(String str, Throwable th) {
        super(str, th);
    }

    public UninitializedException(Throwable th) {
        super(th);
    }
}
