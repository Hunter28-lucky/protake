package com.blink.academy.film.http.okhttp.cache.stategy;

import com.blink.academy.film.http.okhttp.cache.RxCache;
import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import defpackage.AbstractC4262;
import defpackage.C4638;
import defpackage.C4877;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import java.lang.reflect.Type;
import java.util.ConcurrentModificationException;

/* loaded from: classes.dex */
public abstract class BaseStrategy implements IStrategy {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.BaseStrategy$Ϳ, reason: contains not printable characters */
    public class C0375<T> implements InterfaceC2368<T, InterfaceC2856<CacheResult<T>>> {
        public C0375() {
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<CacheResult<T>> apply(T t) throws Exception {
            return t == null ? AbstractC4262.error(new NullPointerException("Not find the cache!")) : AbstractC4262.just(new CacheResult(true, t));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.BaseStrategy$Ԩ, reason: contains not printable characters */
    public class C0376<T> implements InterfaceC2368<Throwable, InterfaceC2856<? extends CacheResult<T>>> {
        public C0376() {
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<? extends CacheResult<T>> apply(Throwable th) throws Exception {
            return AbstractC4262.empty();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.BaseStrategy$Ԫ, reason: contains not printable characters */
    public class C0377<T> implements InterfaceC2368<T, CacheResult<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ RxCache f931;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ String f932;

        /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.BaseStrategy$Ԫ$Ϳ, reason: contains not printable characters */
        public class C0378 implements InterfaceC2857<Boolean> {
            public C0378() {
            }

            @Override // defpackage.InterfaceC2857
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void accept(Boolean bool) throws Exception {
                C4638.m14103("save status => " + bool);
            }
        }

        /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.BaseStrategy$Ԫ$Ԩ, reason: contains not printable characters */
        public class C0379 implements InterfaceC2857<Throwable> {
            public C0379() {
            }

            @Override // defpackage.InterfaceC2857
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void accept(Throwable th) throws Exception {
                if (th instanceof ConcurrentModificationException) {
                    C4638.m14104("Save failed, please use a synchronized cache strategy :", th);
                } else {
                    C4638.m14103(th.getMessage());
                }
            }
        }

        public C0377(RxCache rxCache, String str) {
            this.f931 = rxCache;
            this.f932 = str;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public CacheResult<T> apply(T t) throws Exception {
            C4638.m14103("loadRemote result=" + t);
            this.f931.save(this.f932, t).subscribeOn(C4877.m14602()).subscribe(new C0378(), new C0379());
            return new CacheResult<>(false, t);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.BaseStrategy$Ԭ, reason: contains not printable characters */
    public class C0380<T> implements InterfaceC2368<Throwable, InterfaceC2856<? extends CacheResult<T>>> {
        public C0380() {
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<? extends CacheResult<T>> apply(Throwable th) throws Exception {
            return AbstractC4262.empty();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.BaseStrategy$Ԯ, reason: contains not printable characters */
    public class C0381<T> implements InterfaceC2368<T, InterfaceC2856<CacheResult<T>>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ RxCache f937;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ String f938;

        /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.BaseStrategy$Ԯ$Ϳ, reason: contains not printable characters */
        public class C0382 implements InterfaceC2368<Throwable, CacheResult<T>> {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ Object f940;

            public C0382(Object obj) {
                this.f940 = obj;
            }

            @Override // defpackage.InterfaceC2368
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public CacheResult<T> apply(Throwable th) throws Exception {
                C4638.m14103("save status => " + th);
                return new CacheResult<>(false, this.f940);
            }
        }

        /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.BaseStrategy$Ԯ$Ԩ, reason: contains not printable characters */
        public class C0383 implements InterfaceC2368<Boolean, CacheResult<T>> {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ Object f942;

            public C0383(Object obj) {
                this.f942 = obj;
            }

            @Override // defpackage.InterfaceC2368
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public CacheResult<T> apply(Boolean bool) throws Exception {
                C4638.m14103("save status => " + bool);
                return new CacheResult<>(false, this.f942);
            }
        }

        public C0381(RxCache rxCache, String str) {
            this.f937 = rxCache;
            this.f938 = str;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<CacheResult<T>> apply(T t) throws Exception {
            return this.f937.save(this.f938, t).map(new C0383(t)).onErrorReturn(new C0382(t));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.BaseStrategy$ՠ, reason: contains not printable characters */
    public class C0384<T> implements InterfaceC2368<Throwable, InterfaceC2856<? extends CacheResult<T>>> {
        public C0384() {
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<? extends CacheResult<T>> apply(Throwable th) throws Exception {
            return AbstractC4262.empty();
        }
    }

    public <T> AbstractC4262<CacheResult<T>> loadCache(RxCache rxCache, Type type, String str, long j, boolean z) {
        AbstractC4262<CacheResult<T>> abstractC4262 = (AbstractC4262<CacheResult<T>>) rxCache.load(type, str, j).flatMap(new C0375());
        return z ? abstractC4262.onErrorResumeNext(new C0376()) : abstractC4262;
    }

    public <T> AbstractC4262<CacheResult<T>> loadRemote(RxCache rxCache, String str, AbstractC4262<T> abstractC4262, boolean z) {
        AbstractC4262<CacheResult<T>> abstractC42622 = (AbstractC4262<CacheResult<T>>) abstractC4262.flatMap(new C0381(rxCache, str));
        return z ? abstractC42622.onErrorResumeNext(new C0384()) : abstractC42622;
    }

    public <T> AbstractC4262<CacheResult<T>> loadRemote2(RxCache rxCache, String str, AbstractC4262<T> abstractC4262, boolean z) {
        AbstractC4262<CacheResult<T>> abstractC42622 = (AbstractC4262<CacheResult<T>>) abstractC4262.map(new C0377(rxCache, str));
        return z ? abstractC42622.onErrorResumeNext(new C0380()) : abstractC42622;
    }
}
