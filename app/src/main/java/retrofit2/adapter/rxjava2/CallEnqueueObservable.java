package retrofit2.adapter.rxjava2;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes2.dex */
final class CallEnqueueObservable<T> extends AbstractC4262<Response<T>> {
    private final Call<T> originalCall;

    public static final class CallCallback<T> implements InterfaceC4478, Callback<T> {
        private final Call<?> call;
        private final InterfaceC5102<? super Response<T>> observer;
        public boolean terminated = false;

        public CallCallback(Call<?> call, InterfaceC5102<? super Response<T>> interfaceC5102) {
            this.call = call;
            this.observer = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.call.cancel();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.call.isCanceled();
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th) {
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onError(th);
            } catch (Throwable th2) {
                C4089.m13026(th2);
                C3671.m11803(new CompositeException(th, th2));
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onNext(response);
                if (call.isCanceled()) {
                    return;
                }
                this.terminated = true;
                this.observer.onComplete();
            } catch (Throwable th) {
                if (this.terminated) {
                    C3671.m11803(th);
                    return;
                }
                if (call.isCanceled()) {
                    return;
                }
                try {
                    this.observer.onError(th);
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    C3671.m11803(new CompositeException(th, th2));
                }
            }
        }
    }

    public CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Response<T>> interfaceC5102) {
        Call<T> callClone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(callClone, interfaceC5102);
        interfaceC5102.onSubscribe(callCallback);
        callClone.enqueue(callCallback);
    }
}
