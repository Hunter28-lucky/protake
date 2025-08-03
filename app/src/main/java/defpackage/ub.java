package defpackage;

import com.jakewharton.rx.ReplayingShare;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import io.reactivex.subjects.PublishSubject;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ub {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final PublishSubject<Boolean> f8640 = PublishSubject.m7034();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final RxBleDevice f8641;

    /* renamed from: ԩ, reason: contains not printable characters */
    public AbstractC4262<RxBleConnection> f8642;

    /* renamed from: ub$Ϳ, reason: contains not printable characters */
    public class C2295 implements InterfaceC2857<Throwable> {
        public C2295(ub ubVar) {
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            db.m5929("prepareConnectionObservable ", th);
        }
    }

    public ub(RxBleDevice rxBleDevice) {
        new C2527();
        this.f8641 = rxBleDevice;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC2856 m8382(AbstractC4262 abstractC4262) {
        return abstractC4262;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC2856 m8383(UUID uuid, RxBleConnection rxBleConnection) {
        return rxBleConnection.setupNotification(uuid);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC3951 m8384(UUID uuid, byte[] bArr, RxBleConnection rxBleConnection) {
        return rxBleConnection.writeCharacteristic(uuid, bArr);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public AbstractC4262<byte[]> m8385(final UUID uuid) {
        return m8389().flatMap(new InterfaceC2368() { // from class: nb
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return ub.m8383(uuid, (RxBleConnection) obj);
            }
        }).flatMap(new InterfaceC2368() { // from class: ob
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return ub.m8382((AbstractC4262) obj);
            }
        });
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4262<RxBleConnection> m8386(boolean z, long j) {
        AbstractC4262<RxBleConnection> abstractC4262M8390 = m8390(z, j);
        this.f8642 = abstractC4262M8390;
        return abstractC4262M8390;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public AbstractC4838<byte[]> m8387(final UUID uuid, final byte[] bArr) {
        return m8389().flatMapSingle(new InterfaceC2368() { // from class: pb
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return ub.m8384(uuid, bArr, (RxBleConnection) obj);
            }
        }).firstOrError();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m8388() {
        this.f8640.onNext(Boolean.FALSE);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final AbstractC4262<RxBleConnection> m8389() {
        return this.f8641.getConnectionState() != RxBleConnection.RxBleConnectionState.CONNECTED ? AbstractC4262.error(BleDisconnectedException.adapterDisabled(this.f8641.getMacAddress())) : this.f8642;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final AbstractC4262<RxBleConnection> m8390(boolean z, long j) {
        return this.f8641.establishConnection(z, new Timeout(j, TimeUnit.MILLISECONDS)).takeUntil(this.f8640).compose(ReplayingShare.instance()).doOnError(new C2295(this));
    }
}
