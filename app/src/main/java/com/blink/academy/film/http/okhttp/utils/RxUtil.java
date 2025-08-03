package com.blink.academy.film.http.okhttp.utils;

import com.blink.academy.film.http.okhttp.func.HandleFuc;
import com.blink.academy.film.http.okhttp.func.HttpResponseFunc;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import defpackage.AbstractC4262;
import defpackage.C4000;
import defpackage.C4877;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5298;

/* loaded from: classes.dex */
public class RxUtil {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.utils.RxUtil$Ϳ, reason: contains not printable characters */
    public class C0437<T> implements InterfaceC5298<T, T> {

        /* renamed from: com.blink.academy.film.http.okhttp.utils.RxUtil$Ϳ$Ϳ, reason: contains not printable characters */
        public class C0438 implements InterfaceC3809 {
            public C0438() {
            }

            @Override // defpackage.InterfaceC3809
            public void run() throws Exception {
            }
        }

        /* renamed from: com.blink.academy.film.http.okhttp.utils.RxUtil$Ϳ$Ԩ, reason: contains not printable characters */
        public class C0439 implements InterfaceC2857<InterfaceC4478> {
            public C0439() {
            }

            @Override // defpackage.InterfaceC2857
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void accept(InterfaceC4478 interfaceC4478) throws Exception {
            }
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<T> abstractC4262) {
            return abstractC4262.subscribeOn(C4877.m14602()).unsubscribeOn(C4877.m14602()).doOnSubscribe(new C0439()).doFinally(new C0438()).observeOn(C4000.m12867());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.utils.RxUtil$Ԩ, reason: contains not printable characters */
    public class C0440<T> implements InterfaceC5298<ApiResult<T>, T> {

        /* renamed from: com.blink.academy.film.http.okhttp.utils.RxUtil$Ԩ$Ϳ, reason: contains not printable characters */
        public class C0441 implements InterfaceC3809 {
            public C0441() {
            }

            @Override // defpackage.InterfaceC3809
            public void run() throws Exception {
            }
        }

        /* renamed from: com.blink.academy.film.http.okhttp.utils.RxUtil$Ԩ$Ԩ, reason: contains not printable characters */
        public class C0442 implements InterfaceC2857<InterfaceC4478> {
            public C0442() {
            }

            @Override // defpackage.InterfaceC2857
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void accept(InterfaceC4478 interfaceC4478) throws Exception {
            }
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<ApiResult<T>> abstractC4262) {
            return abstractC4262.subscribeOn(C4877.m14602()).unsubscribeOn(C4877.m14602()).observeOn(C4000.m12867()).map(new HandleFuc()).doOnSubscribe(new C0442()).doFinally(new C0441()).onErrorResumeNext(new HttpResponseFunc());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.utils.RxUtil$Ԫ, reason: contains not printable characters */
    public class C0443<T> implements InterfaceC5298<ApiResult<T>, T> {

        /* renamed from: com.blink.academy.film.http.okhttp.utils.RxUtil$Ԫ$Ϳ, reason: contains not printable characters */
        public class C0444 implements InterfaceC3809 {
            public C0444() {
            }

            @Override // defpackage.InterfaceC3809
            public void run() throws Exception {
            }
        }

        /* renamed from: com.blink.academy.film.http.okhttp.utils.RxUtil$Ԫ$Ԩ, reason: contains not printable characters */
        public class C0445 implements InterfaceC2857<InterfaceC4478> {
            public C0445() {
            }

            @Override // defpackage.InterfaceC2857
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void accept(InterfaceC4478 interfaceC4478) throws Exception {
            }
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<ApiResult<T>> abstractC4262) {
            return abstractC4262.map(new HandleFuc()).doOnSubscribe(new C0445()).doFinally(new C0444()).onErrorResumeNext(new HttpResponseFunc());
        }
    }

    public static <T> InterfaceC5298<ApiResult<T>, T> _io_main() {
        return new C0440();
    }

    public static <T> InterfaceC5298<ApiResult<T>, T> _main() {
        return new C0443();
    }

    public static <T> InterfaceC5298<T, T> io_main() {
        return new C0437();
    }
}
