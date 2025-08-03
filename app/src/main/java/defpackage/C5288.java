package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: SequenceBuilder.kt */
/* renamed from: ტ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5288<T> extends AbstractC4232<T> implements Iterator<T>, InterfaceC4355<i4>, InterfaceC4947 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f17475;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public T f17476;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Iterator<? extends T> f17477;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC4355<? super i4> f17478;

    @Override // defpackage.InterfaceC4355
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f7835;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i = this.f17475;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw m15327();
                }
                Iterator<? extends T> it = this.f17477;
                C3921.m12664(it);
                if (it.hasNext()) {
                    this.f17475 = 2;
                    return true;
                }
                this.f17477 = null;
            }
            this.f17475 = 5;
            InterfaceC4355<? super i4> interfaceC4355 = this.f17478;
            C3921.m12664(interfaceC4355);
            this.f17478 = null;
            Result.C2137 c2137 = Result.f7828;
            interfaceC4355.resumeWith(Result.m7211(i4.f6762));
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i = this.f17475;
        if (i == 0 || i == 1) {
            return m15328();
        }
        if (i == 2) {
            this.f17475 = 1;
            Iterator<? extends T> it = this.f17477;
            C3921.m12664(it);
            return it.next();
        }
        if (i != 3) {
            throw m15327();
        }
        this.f17475 = 0;
        T t = this.f17476;
        this.f17476 = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // defpackage.InterfaceC4355
    public void resumeWith(Object obj) throws Throwable {
        C4817.m14542(obj);
        this.f17475 = 4;
    }

    @Override // defpackage.AbstractC4232
    /* renamed from: Ϳ */
    public Object mo13328(T t, InterfaceC4355<? super i4> interfaceC4355) {
        this.f17476 = t;
        this.f17475 = 3;
        this.f17478 = interfaceC4355;
        Object objM15170 = C5199.m15170();
        if (objM15170 == C5199.m15170()) {
            C5148.m15061(interfaceC4355);
        }
        return objM15170 == C5199.m15170() ? objM15170 : i4.f6762;
    }

    @Override // defpackage.AbstractC4232
    /* renamed from: Ԫ */
    public Object mo13330(Iterator<? extends T> it, InterfaceC4355<? super i4> interfaceC4355) {
        if (!it.hasNext()) {
            return i4.f6762;
        }
        this.f17477 = it;
        this.f17475 = 2;
        this.f17478 = interfaceC4355;
        Object objM15170 = C5199.m15170();
        if (objM15170 == C5199.m15170()) {
            C5148.m15061(interfaceC4355);
        }
        return objM15170 == C5199.m15170() ? objM15170 : i4.f6762;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Throwable m15327() {
        int i = this.f17475;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f17475);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final T m15328() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m15329(InterfaceC4355<? super i4> interfaceC4355) {
        this.f17478 = interfaceC4355;
    }
}
