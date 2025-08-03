package retrofit2.adapter.rxjava2;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes2.dex */
final class CallExecuteObservable<T> extends AbstractC4262<Response<T>> {
    private final Call<T> originalCall;

    public static final class CallDisposable implements InterfaceC4478 {
        private final Call<?> call;

        public CallDisposable(Call<?> call) {
            this.call = call;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.call.cancel();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.call.isCanceled();
        }
    }

    public CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Response<T>> interfaceC5102) {
        boolean z;
        Call<T> callClone = this.originalCall.clone();
        interfaceC5102.onSubscribe(new CallDisposable(callClone));
        try {
            Response<T> responseExecute = callClone.execute();
            if (!callClone.isCanceled()) {
                interfaceC5102.onNext(responseExecute);
            }
            if (callClone.isCanceled()) {
                return;
            }
            try {
                interfaceC5102.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                C4089.m13026(th);
                if (z) {
                    C3671.m11803(th);
                    return;
                }
                if (callClone.isCanceled()) {
                    return;
                }
                try {
                    interfaceC5102.onError(th);
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    C3671.m11803(new CompositeException(th, th2));
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
