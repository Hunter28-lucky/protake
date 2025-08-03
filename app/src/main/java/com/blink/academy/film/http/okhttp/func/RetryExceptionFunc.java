package com.blink.academy.film.http.okhttp.func;

import com.blink.academy.film.http.okhttp.exception.ApiException;
import defpackage.AbstractC4262;
import defpackage.C4638;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC5247;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class RetryExceptionFunc implements InterfaceC2368<AbstractC4262<? extends Throwable>, AbstractC4262<?>> {
    private int count;
    private long delay;
    private long increaseDelay;

    /* renamed from: com.blink.academy.film.http.okhttp.func.RetryExceptionFunc$Ϳ, reason: contains not printable characters */
    public class C0389 implements InterfaceC2368<C0391, InterfaceC2856<?>> {
        public C0389() {
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<?> apply(C0391 c0391) throws Exception {
            if (c0391.f951 > 1) {
                C4638.m14103("重试次数：" + c0391.f951);
            }
            int code = c0391.f952 instanceof ApiException ? ((ApiException) c0391.f952).getCode() : 0;
            return (((c0391.f952 instanceof ConnectException) || (c0391.f952 instanceof SocketTimeoutException) || code == 1002 || code == 1005 || (c0391.f952 instanceof SocketTimeoutException) || (c0391.f952 instanceof TimeoutException)) && c0391.f951 < RetryExceptionFunc.this.count + 1) ? AbstractC4262.timer(RetryExceptionFunc.this.delay + ((c0391.f951 - 1) * RetryExceptionFunc.this.increaseDelay), TimeUnit.MILLISECONDS) : AbstractC4262.error(c0391.f952);
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.func.RetryExceptionFunc$Ԩ, reason: contains not printable characters */
    public class C0390 implements InterfaceC5247<Throwable, Integer, C0391> {
        public C0390() {
        }

        @Override // defpackage.InterfaceC5247
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public C0391 apply(Throwable th, Integer num) throws Exception {
            return RetryExceptionFunc.this.new C0391(th, num.intValue());
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.func.RetryExceptionFunc$Ԫ, reason: contains not printable characters */
    public class C0391 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public int f951;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public Throwable f952;

        public C0391(Throwable th, int i) {
            this.f951 = i;
            this.f952 = th;
        }
    }

    public RetryExceptionFunc() {
        this.count = 0;
        this.delay = 500L;
        this.increaseDelay = 3000L;
    }

    @Override // defpackage.InterfaceC2368
    public AbstractC4262<?> apply(AbstractC4262<? extends Throwable> abstractC4262) throws Exception {
        return abstractC4262.zipWith(AbstractC4262.range(1, this.count + 1), new C0390()).flatMap(new C0389());
    }

    public RetryExceptionFunc(int i, long j) {
        this.increaseDelay = 3000L;
        this.count = i;
        this.delay = j;
    }

    public RetryExceptionFunc(int i, long j, long j2) {
        this.count = i;
        this.delay = j;
        this.increaseDelay = j2;
    }
}
