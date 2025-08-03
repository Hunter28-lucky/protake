package retrofit2.adapter.rxjava2;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Response;

/* loaded from: classes2.dex */
final class ResultObservable<T> extends AbstractC4262<Result<T>> {
    private final AbstractC4262<Response<T>> upstream;

    public static class ResultObserver<R> implements InterfaceC5102<Response<R>> {
        private final InterfaceC5102<? super Result<R>> observer;

        public ResultObserver(InterfaceC5102<? super Result<R>> interfaceC5102) {
            this.observer = interfaceC5102;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.observer.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            try {
                this.observer.onNext(Result.error(th));
                this.observer.onComplete();
            } catch (Throwable th2) {
                try {
                    this.observer.onError(th2);
                } catch (Throwable th3) {
                    C4089.m13026(th3);
                    C3671.m11803(new CompositeException(th2, th3));
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.observer.onSubscribe(interfaceC4478);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Response<R> response) {
            this.observer.onNext(Result.response(response));
        }
    }

    public ResultObservable(AbstractC4262<Response<T>> abstractC4262) {
        this.upstream = abstractC4262;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Result<T>> interfaceC5102) {
        this.upstream.subscribe(new ResultObserver(interfaceC5102));
    }
}
