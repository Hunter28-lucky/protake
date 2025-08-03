package defpackage;

import com.zhiyun.protocol.constants.Model;
import com.zhiyun.sdk.device.ble.BleStabilizer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class xe {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final BleStabilizer f8745;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public InterfaceC4478 f8746;

    public xe(BleStabilizer bleStabilizer) {
        this.f8745 = bleStabilizer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Ԫ, reason: contains not printable characters */
    public /* synthetic */ InterfaceC3951 m8604(Long l) {
        return m8609();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static /* synthetic */ void m8606(byte[] bArr) {
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m8607() {
        return this.f8746 != null;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean m8608(Model model) {
        return model.hid() == 1 || model.hid() == 2;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC4838<byte[]> m8609() {
        return this.f8745.writeCharacteristic(cb.f203).onErrorReturnItem(new byte[0]);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m8610(Model model) {
        if (m8608(model) && !m8607()) {
            this.f8746 = AbstractC4262.interval(500L, TimeUnit.MILLISECONDS).flatMapSingle(new InterfaceC2368() { // from class: fe
                @Override // defpackage.InterfaceC2368
                public final Object apply(Object obj) {
                    return this.f6638.m8604((Long) obj);
                }
            }).subscribe(new InterfaceC2857() { // from class: ge
                @Override // defpackage.InterfaceC2857
                public final void accept(Object obj) {
                    xe.m8606((byte[]) obj);
                }
            }, new InterfaceC2857() { // from class: he
                @Override // defpackage.InterfaceC2857
                public final void accept(Object obj) {
                    db.m5929("heart: ", (Throwable) obj);
                }
            });
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m8611() {
        InterfaceC4478 interfaceC4478 = this.f8746;
        if (interfaceC4478 != null) {
            interfaceC4478.dispose();
            this.f8746 = null;
        }
    }
}
