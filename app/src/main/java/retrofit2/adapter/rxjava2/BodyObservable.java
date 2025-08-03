package retrofit2.adapter.rxjava2;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Response;

/* loaded from: classes2.dex */
final class BodyObservable<T> extends AbstractC4262<T> {
    private final AbstractC4262<Response<T>> upstream;

    public static class BodyObserver<R> implements InterfaceC5102<Response<R>> {
        private final InterfaceC5102<? super R> observer;
        private boolean terminated;

        public BodyObserver(InterfaceC5102<? super R> interfaceC5102) {
            this.observer = interfaceC5102;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.terminated) {
                return;
            }
            this.observer.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.terminated) {
                this.observer.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            C3671.m11803(assertionError);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.observer.onSubscribe(interfaceC4478);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(new CompositeException(httpException, th));
            }
        }
    }

    public BodyObservable(AbstractC4262<Response<T>> abstractC4262) {
        this.upstream = abstractC4262;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.upstream.subscribe(new BodyObserver(interfaceC5102));
    }
}
