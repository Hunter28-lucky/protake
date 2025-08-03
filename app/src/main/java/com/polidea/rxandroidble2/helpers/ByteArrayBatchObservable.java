package com.polidea.rxandroidble2.helpers;

import androidx.annotation.NonNull;
import defpackage.AbstractC3630;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3487;
import java.nio.ByteBuffer;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public class ByteArrayBatchObservable extends AbstractC3630<byte[]> {

    @NonNull
    public final ByteBuffer byteBuffer;
    public final int maxBatchSize;

    public ByteArrayBatchObservable(@NonNull byte[] bArr, int i) {
        if (i > 0) {
            this.byteBuffer = ByteBuffer.wrap(bArr);
            this.maxBatchSize = i;
        } else {
            throw new IllegalArgumentException("maxBatchSize must be > 0 but found: " + i);
        }
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super byte[]> subscriber) {
        AbstractC3630.generate(new InterfaceC2857<InterfaceC3487<byte[]>>() { // from class: com.polidea.rxandroidble2.helpers.ByteArrayBatchObservable.1
            @Override // defpackage.InterfaceC2857
            public void accept(InterfaceC3487<byte[]> interfaceC3487) {
                int iMin = Math.min(ByteArrayBatchObservable.this.byteBuffer.remaining(), ByteArrayBatchObservable.this.maxBatchSize);
                if (iMin == 0) {
                    interfaceC3487.onComplete();
                    return;
                }
                byte[] bArr = new byte[iMin];
                ByteArrayBatchObservable.this.byteBuffer.get(bArr);
                interfaceC3487.onNext(bArr);
            }
        }).subscribe(subscriber);
    }
}
