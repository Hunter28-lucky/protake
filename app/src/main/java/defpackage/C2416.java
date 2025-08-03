package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableDoOnEach.java */
/* renamed from: ƒ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2416<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super T> f9003;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super Throwable> f9004;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC3809 f9005;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC3809 f9006;

    /* compiled from: FlowableDoOnEach.java */
    /* renamed from: ƒ$Ϳ, reason: contains not printable characters */
    public static final class C2417<T> extends AbstractC5177<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2857<? super T> f9007;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final InterfaceC2857<? super Throwable> f9008;

        /* renamed from: ֏, reason: contains not printable characters */
        public final InterfaceC3809 f9009;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final InterfaceC3809 f9010;

        public C2417(InterfaceC2697<? super T> interfaceC2697, InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC3809 interfaceC38092) {
            super(interfaceC2697);
            this.f9007 = interfaceC2857;
            this.f9008 = interfaceC28572;
            this.f9009 = interfaceC3809;
            this.f9010 = interfaceC38092;
        }

        @Override // defpackage.AbstractC5177, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f17138) {
                return;
            }
            try {
                this.f9009.run();
                this.f17138 = true;
                this.f17135.onComplete();
                try {
                    this.f9010.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            } catch (Throwable th2) {
                m15120(th2);
            }
        }

        @Override // defpackage.AbstractC5177, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f17138) {
                C3671.m11803(th);
                return;
            }
            boolean z = true;
            this.f17138 = true;
            try {
                this.f9008.accept(th);
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.f17135.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.f17135.onError(th);
            }
            try {
                this.f9010.run();
            } catch (Throwable th3) {
                C4089.m13026(th3);
                C3671.m11803(th3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f17138) {
                return;
            }
            if (this.f17139 != 0) {
                this.f17135.onNext(null);
                return;
            }
            try {
                this.f9007.accept(t);
                this.f17135.onNext(t);
            } catch (Throwable th) {
                m15120(th);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            try {
                T tPoll = this.f17137.poll();
                if (tPoll != null) {
                    try {
                        this.f9007.accept(tPoll);
                    } catch (Throwable th) {
                        try {
                            C4089.m13026(th);
                            try {
                                this.f9008.accept(th);
                                throw ExceptionHelper.m7022(th);
                            } catch (Throwable th2) {
                                throw new CompositeException(th, th2);
                            }
                        } finally {
                            this.f9010.run();
                        }
                    }
                } else if (this.f17139 == 1) {
                    this.f9009.run();
                }
                return tPoll;
            } catch (Throwable th3) {
                C4089.m13026(th3);
                try {
                    this.f9008.accept(th3);
                    throw ExceptionHelper.m7022(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15121(i);
        }

        @Override // defpackage.InterfaceC2697
        /* renamed from: ԭ */
        public boolean mo6426(T t) {
            if (this.f17138) {
                return false;
            }
            try {
                this.f9007.accept(t);
                return this.f17135.mo6426(t);
            } catch (Throwable th) {
                m15120(th);
                return false;
            }
        }
    }

    /* compiled from: FlowableDoOnEach.java */
    /* renamed from: ƒ$Ԩ, reason: contains not printable characters */
    public static final class C2418<T> extends AbstractC5179<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2857<? super T> f9011;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final InterfaceC2857<? super Throwable> f9012;

        /* renamed from: ֏, reason: contains not printable characters */
        public final InterfaceC3809 f9013;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final InterfaceC3809 f9014;

        public C2418(Subscriber<? super T> subscriber, InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC3809 interfaceC38092) {
            super(subscriber);
            this.f9011 = interfaceC2857;
            this.f9012 = interfaceC28572;
            this.f9013 = interfaceC3809;
            this.f9014 = interfaceC38092;
        }

        @Override // defpackage.AbstractC5179, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f17148) {
                return;
            }
            try {
                this.f9013.run();
                this.f17148 = true;
                this.f17145.onComplete();
                try {
                    this.f9014.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            } catch (Throwable th2) {
                m15128(th2);
            }
        }

        @Override // defpackage.AbstractC5179, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f17148) {
                C3671.m11803(th);
                return;
            }
            boolean z = true;
            this.f17148 = true;
            try {
                this.f9012.accept(th);
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.f17145.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.f17145.onError(th);
            }
            try {
                this.f9014.run();
            } catch (Throwable th3) {
                C4089.m13026(th3);
                C3671.m11803(th3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f17148) {
                return;
            }
            if (this.f17149 != 0) {
                this.f17145.onNext(null);
                return;
            }
            try {
                this.f9011.accept(t);
                this.f17145.onNext(t);
            } catch (Throwable th) {
                m15128(th);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            try {
                T tPoll = this.f17147.poll();
                if (tPoll != null) {
                    try {
                        this.f9011.accept(tPoll);
                    } catch (Throwable th) {
                        try {
                            C4089.m13026(th);
                            try {
                                this.f9012.accept(th);
                                throw ExceptionHelper.m7022(th);
                            } catch (Throwable th2) {
                                throw new CompositeException(th, th2);
                            }
                        } finally {
                            this.f9014.run();
                        }
                    }
                } else if (this.f17149 == 1) {
                    this.f9013.run();
                }
                return tPoll;
            } catch (Throwable th3) {
                C4089.m13026(th3);
                try {
                    this.f9012.accept(th3);
                    throw ExceptionHelper.m7022(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15129(i);
        }
    }

    public C2416(AbstractC3630<T> abstractC3630, InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC3809 interfaceC38092) {
        super(abstractC3630);
        this.f9003 = interfaceC2857;
        this.f9004 = interfaceC28572;
        this.f9005 = interfaceC3809;
        this.f9006 = interfaceC38092;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof InterfaceC2697) {
            this.f11385.subscribe((InterfaceC3899) new C2417((InterfaceC2697) subscriber, this.f9003, this.f9004, this.f9005, this.f9006));
        } else {
            this.f11385.subscribe((InterfaceC3899) new C2418(subscriber, this.f9003, this.f9004, this.f9005, this.f9006));
        }
    }
}
