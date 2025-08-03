package com.zhiyun.sdk.device.ble;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.polidea.rxandroidble2.RxBleDevice;
import com.zhiyun.protocol.constants.InteractCode;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.constants.PhoneControlMode;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.protocol.message.a;
import com.zhiyun.protocol.message.f;
import com.zhiyun.protocol.utils.d;
import com.zhiyun.sdk.ZYDeviceSDK;
import com.zhiyun.sdk.callbaks.AngleCallback;
import com.zhiyun.sdk.callbaks.Callback;
import com.zhiyun.sdk.device.ble.BleStabilizer;
import com.zhiyun.sdk.exception.OptionalDeviceException;
import defpackage.AbstractC2900;
import defpackage.AbstractC3630;
import defpackage.AbstractC4262;
import defpackage.AbstractC4838;
import defpackage.C2719;
import defpackage.C4000;
import defpackage.C4877;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4671;
import defpackage.InterfaceC4807;
import defpackage.InterfaceC5247;
import defpackage.bb;
import defpackage.db;
import defpackage.ud;
import defpackage.vb;
import defpackage.xe;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class BleStabilizer extends BleDevice {
    private final SparseArray<c> h;
    private final bb i;
    private final Model j;
    private xe k;
    private InterfaceC4478 l;
    private InterfaceC4478 m;
    private WorkingMode n;

    public class a implements InterfaceC3809 {
        public final /* synthetic */ WorkingMode a;

        public a(BleStabilizer bleStabilizer, WorkingMode workingMode) {
            this.a = workingMode;
        }

        @Override // defpackage.InterfaceC3809
        public void run() {
            db.m5928("设置工作模式：" + this.a);
        }
    }

    public class b implements vb.InterfaceC2302 {
        private b() {
        }

        @Override // defpackage.vb.InterfaceC2302
        public void a(byte[] bArr) {
            try {
                int[] iArrA = BleStabilizer.this.a(bArr, 0);
                if (iArrA != null) {
                    BleStabilizer.this.a(iArrA[0], iArrA[1], iArrA[2]);
                    return;
                }
                if (new f().parseFrom(bArr) || new com.zhiyun.protocol.message.c().parseFrom(bArr)) {
                    return;
                }
                int[] iArrA2 = BleStabilizer.this.a(bArr, 1);
                if (iArrA2 != null) {
                    a(iArrA2);
                } else {
                    if (new com.zhiyun.protocol.message.b().parseFrom(bArr)) {
                        return;
                    }
                    com.zhiyun.protocol.message.a aVar = new com.zhiyun.protocol.message.a();
                    if (aVar.parseFrom(bArr)) {
                        BleStabilizer.this.a(200L, aVar);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public /* synthetic */ b(BleStabilizer bleStabilizer, a aVar) {
            this();
        }

        private void a(@NonNull int[] iArr) {
            if (iArr.length < 3 || iArr[0] != 1) {
                return;
            }
            BleStabilizer.this.a(iArr[1], iArr[2]);
        }
    }

    public interface c {
        void a(com.zhiyun.protocol.message.a aVar);
    }

    public BleStabilizer(RxBleDevice rxBleDevice, Model model) {
        super(rxBleDevice);
        this.h = new SparseArray<>();
        this.j = model;
        this.i = new bb(model, new b(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.zhiyun.protocol.message.a a(com.zhiyun.protocol.message.a aVar, byte[] bArr) {
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Pair b(byte[] bArr) {
        return Pair.create(Boolean.TRUE, bArr);
    }

    private boolean b(int i, int i2) {
        int i3 = 1 << i2;
        return (i & i3) == i3;
    }

    private void d() {
        this.l = AbstractC4262.merge(setStarsNotification().map(new InterfaceC2368() { // from class: ʲ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return BleStabilizer.a((byte[]) obj);
            }
        }), setSimpleNotification().map(new InterfaceC2368() { // from class: ʺ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return BleStabilizer.b((byte[]) obj);
            }
        })).observeOn(C4877.m14604()).subscribe(new InterfaceC2857() { // from class: ʰ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                this.f10044.a((Pair<Boolean, byte[]>) obj);
            }
        }, new InterfaceC2857() { // from class: ʶ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                this.f10046.c((Throwable) obj);
            }
        });
    }

    private AbstractC2900 e(int i, int i2) {
        return d(i, i2).ignoreElement();
    }

    private AbstractC4838<Integer> f() {
        return d(InteractCode.LOCATION_POINT_STATE_REGISTER).map(new C2719());
    }

    private AbstractC4838<Float> g() {
        return e(InteractCode.PITCH_ANGLE_R);
    }

    private AbstractC2900 h(int i) {
        return e(InteractCode.LOCATION_POINT_CONTROLLER, i);
    }

    private AbstractC4838<com.zhiyun.protocol.message.a> i(final int i) {
        return AbstractC4838.create(new InterfaceC4807() { // from class: ݳ
            @Override // defpackage.InterfaceC4807
            public final void subscribe(InterfaceC4671 interfaceC4671) {
                this.f12992.a(i, interfaceC4671);
            }
        });
    }

    private AbstractC4838<Float> j() {
        return e(InteractCode.YAW_ANGLE_R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        a(false).m10275(b(false)).m10275(n()).m10287(new InterfaceC3809() { // from class: ˢ
            @Override // defpackage.InterfaceC3809
            public final void run() {
                BleStabilizer.k();
            }
        }, new InterfaceC2857() { // from class: ˣ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InterfaceC2837 m() {
        WorkingMode workingMode = this.n;
        return workingMode == null ? AbstractC2900.m10268() : b(workingMode);
    }

    private AbstractC2900 n() {
        return AbstractC2900.m10269(new Callable() { // from class: ʸ
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f10047.m();
            }
        });
    }

    private AbstractC2900 o() {
        return i().map(new InterfaceC2368() { // from class: ٱ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return Boolean.valueOf(this.f12244.a((WorkingMode) obj));
            }
        }).flatMapCompletable(new InterfaceC2368() { // from class: ٲ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return this.f12245.b((Boolean) obj);
            }
        });
    }

    private native int[] parse(Context context, int i, String str, String str2, String str3, byte[] bArr);

    @Override // com.zhiyun.sdk.device.ble.BleDevice
    public void c(int i) {
        if (this.k == null) {
            this.k = new xe(this);
        }
        if (i == 2) {
            this.k.m8610(this.j);
            d();
        } else if (i == 0) {
            this.k.m8611();
            b();
        }
    }

    @Override // com.zhiyun.sdk.device.Device
    public void cancelMove() {
        if (isMoving()) {
            this.m.dispose();
            this.m = null;
        }
    }

    @Override // com.zhiyun.sdk.device.Device
    public void getAngle(@NonNull final AngleCallback angleCallback) {
        Objects.requireNonNull(angleCallback);
        e().observeOn(C4000.m12867()).subscribe(new InterfaceC2857() { // from class: ͺ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                BleStabilizer.a(angleCallback, (float[]) obj);
            }
        }, new InterfaceC2857() { // from class: ߵ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                BleStabilizer.a(angleCallback, (Throwable) obj);
            }
        });
    }

    @Override // com.zhiyun.sdk.device.Device
    public boolean isMoving() {
        InterfaceC4478 interfaceC4478 = this.m;
        return (interfaceC4478 == null || interfaceC4478.isDisposed()) ? false : true;
    }

    @Override // com.zhiyun.sdk.device.Device
    public void moveTo(float f, float f2, float f3, int i, final Callback<Boolean> callback) {
        if (isMoving()) {
            return;
        }
        Objects.requireNonNull(callback);
        this.m = a(f, f2, f3, i).m10282(C4000.m12867()).m10287(new InterfaceC3809() { // from class: ჼ
            @Override // defpackage.InterfaceC3809
            public final void run() {
                BleStabilizer.a(callback);
            }
        }, new InterfaceC2857() { // from class: ۥ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                BleStabilizer.a(callback, (Throwable) obj);
            }
        });
    }

    @Override // com.zhiyun.sdk.device.Device
    public boolean send(byte[] bArr) {
        if (!isConnected()) {
            return false;
        }
        writeCharacteristic(bArr).subscribe(new InterfaceC2857() { // from class: ݴ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                db.m5930("Send succeeded: ", (byte[]) obj);
            }
        }, new InterfaceC2857() { // from class: ˠ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                db.m5929("Send failed: ", (Throwable) obj);
            }
        });
        return true;
    }

    @Override // com.zhiyun.sdk.device.Device
    public void setCameraMode() {
        b(e.a.CAMERA);
    }

    @Override // com.zhiyun.sdk.device.Device
    public void setPhoneMode() {
        b(e.a.PHONE);
    }

    public AbstractC4262<byte[]> setSimpleNotification() {
        return setupNotification(ud.f8648).onErrorReturnItem(new byte[0]);
    }

    public AbstractC4262<byte[]> setStarsNotification() {
        return setupNotification(ud.f8647).onErrorReturnItem(new byte[0]);
    }

    public AbstractC4838<byte[]> writeCharacteristic(byte[] bArr) {
        return writeCharacteristic(ud.f8646, bArr);
    }

    private void b() {
        InterfaceC4478 interfaceC4478 = this.l;
        if (interfaceC4478 != null) {
            interfaceC4478.dispose();
            this.l = null;
        }
    }

    private AbstractC4838<Float> e(int i) {
        return d(i).map(new C2719()).map(new InterfaceC2368() { // from class: ء
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return Short.valueOf(((Integer) obj).shortValue());
            }
        }).onErrorReturnItem((short) 0).map(new InterfaceC2368() { // from class: ـ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return BleStabilizer.a((Short) obj);
            }
        });
    }

    private AbstractC2900 g(int i) {
        int i2 = i >>> 16;
        return e(InteractCode.POINT_MOTION_TIME_LOW_BIT, i & 65535).m10275(e(InteractCode.POINT_MOTION_TIME_HIGH_BIT, i2));
    }

    private AbstractC4838<Float> h() {
        return e(InteractCode.ROLL_ANGLE_R);
    }

    private AbstractC4838<WorkingMode> i() {
        return d(InteractCode.WORK_MODE_CODE_R).map(new C2719()).map(new InterfaceC2368() { // from class: י
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return WorkingMode.from(((Integer) obj).intValue());
            }
        });
    }

    private AbstractC2900 f(int i) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return AbstractC3630.interval(300L, timeUnit).concatMapSingle(new InterfaceC2368() { // from class: ˎ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return this.f10088.a((Long) obj);
            }
        }).map(new InterfaceC2368() { // from class: آ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return this.f11780.a((Integer) obj);
            }
        }).onErrorReturnItem(Boolean.FALSE).filter(new InterfaceC4178() { // from class: أ
            @Override // defpackage.InterfaceC4178
            public final boolean test(Object obj) {
                return ((Boolean) obj).booleanValue();
            }
        }).take(1L).timeout(i + ModuleDescriptor.MODULE_VERSION, timeUnit).singleOrError().ignoreElement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(long j, com.zhiyun.protocol.message.a aVar) {
        c cVar;
        int iA = aVar.a();
        long j2 = 0;
        while (true) {
            cVar = this.h.get(iA);
            if (cVar != null) {
                break;
            }
            try {
                db.m5928("等待注册数据桥");
                TimeUnit.MILLISECONDS.sleep(5L);
                j2 += 5;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (j2 >= j) {
                db.m5935("等待回执数据超时: " + j);
                break;
            }
            continue;
        }
        if (cVar != null) {
            this.h.delete(iA);
            cVar.a(aVar);
        }
    }

    private void b(final e.a aVar) {
        if (this.j != Model.CRANE_M2) {
            db.m5935("The device does not support this operation: [load mode]");
        } else {
            AbstractC2900.m10272(new Runnable() { // from class: ˑ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10091.a(aVar);
                }
            }).m10283().m10286();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Throwable th) {
        db.m5931(th);
    }

    private AbstractC4838<float[]> e() {
        return AbstractC4838.concat(g(), h(), j()).buffer(3).singleOrError().map(new InterfaceC2368() { // from class: ʵ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return BleStabilizer.a((List) obj);
            }
        });
    }

    private AbstractC4838<com.zhiyun.protocol.message.a> d(int i) {
        return d(i, 0);
    }

    private com.zhiyun.protocol.message.a c(int i, int i2) {
        com.zhiyun.protocol.message.a aVar = new com.zhiyun.protocol.message.a();
        aVar.a(d.a());
        aVar.a(i);
        aVar.b(i2);
        return aVar;
    }

    private AbstractC4838<com.zhiyun.protocol.message.a> d(final int i, final int i2) {
        com.zhiyun.protocol.message.a aVarC = c(i, i2);
        return AbstractC4838.zip(i(aVarC.a()), writeCharacteristic(aVarC.toData()).retry(2L), new InterfaceC5247() { // from class: ʷ
            @Override // defpackage.InterfaceC5247
            public final Object apply(Object obj, Object obj2) {
                return BleStabilizer.a((a) obj, (byte[]) obj2);
            }
        }).timeout(500L, TimeUnit.MILLISECONDS).doOnSuccess(new InterfaceC2857() { // from class: ˏ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                BleStabilizer.a(i, i2, (a) obj);
            }
        }).doOnError(new InterfaceC2857() { // from class: ا
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                db.m5927(i, i2, (Throwable) obj);
            }
        });
    }

    private AbstractC2900 b(WorkingMode workingMode) {
        return e(InteractCode.WORK_MODE_CODE_W, workingMode.code).m10279(new a(this, workingMode));
    }

    private AbstractC2900 b(float f) {
        return a(InteractCode.ROLL_ROTATE_ANGLE_CONTROL, a(f, this.j.getMoveLimit()[1]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Pair a(byte[] bArr) {
        return Pair.create(Boolean.FALSE, bArr);
    }

    private AbstractC2900 c(float f) {
        return a(InteractCode.YAW_ROTATE_ANGLE_CONTROL, a(f, this.j.getMoveLimit()[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Pair<Boolean, byte[]> pair) {
        this.i.m162(((Boolean) pair.first).booleanValue(), (byte[]) pair.second);
    }

    private AbstractC2900 b(boolean z) {
        if (this.j != Model.SMOOTH4) {
            return AbstractC2900.m10268();
        }
        return e(InteractCode.PHONE_CONTROL_MODE, PhoneControlMode.to(z ? PhoneControlMode.BEGIN : PhoneControlMode.END));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] a(byte[] bArr, int i) {
        ZYDeviceSDK zYDeviceSDK = ZYDeviceSDK.getInstance();
        return parse(zYDeviceSDK.getContext(), i, zYDeviceSDK.getAppId(), zYDeviceSDK.getKey(), zYDeviceSDK.getCert(), bArr);
    }

    private InterfaceC3809 c() {
        return new InterfaceC3809() { // from class: ߴ
            @Override // defpackage.InterfaceC3809
            public final void run() {
                this.f13313.l();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InterfaceC2837 b(Boolean bool) {
        if (bool.booleanValue()) {
            return AbstractC2900.m10268();
        }
        return b(WorkingMode.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(e.a aVar) {
        com.zhiyun.protocol.message.b bVar = new com.zhiyun.protocol.message.b();
        bVar.a(aVar);
        send(bVar.toData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, final InterfaceC4671 interfaceC4671) {
        SparseArray<c> sparseArray = this.h;
        Objects.requireNonNull(interfaceC4671);
        sparseArray.append(i, new c() { // from class: com.zhiyun.sdk.device.ble.Ϳ
            @Override // com.zhiyun.sdk.device.ble.BleStabilizer.c
            public final void a(a aVar) {
                interfaceC4671.onSuccess(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, int i2, com.zhiyun.protocol.message.a aVar) {
        db.m5926(i, i2, aVar.b());
    }

    private AbstractC2900 a(boolean z) {
        return e(InteractCode.LOCATION_SET_POINT_POWERED, z ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Float a(Short sh) {
        return Float.valueOf((sh.shortValue() * 1.0f) / 100.0f);
    }

    private float a(float f, float[] fArr) {
        float f2 = fArr[0];
        float f3 = fArr[1];
        return f > f3 ? f2 + (f - f3) : f < f2 ? f3 - Math.abs(f - f2) : f;
    }

    private AbstractC2900 a(int i, float f) {
        return e(i, Math.round(f * 100.0f));
    }

    private AbstractC2900 a(float f) {
        return a(InteractCode.PITCH_ROTATE_ANGLE_CONTROL, a(f, this.j.getMoveLimit()[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float[] a(List list) {
        return new float[]{((Float) list.get(0)).floatValue(), ((Float) list.get(1)).floatValue(), ((Float) list.get(2)).floatValue()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InterfaceC3951 a(Long l) {
        return f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean a(Integer num) {
        return Boolean.valueOf(b(num.intValue(), 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WorkingMode workingMode) {
        this.n = null;
        boolean z = workingMode == WorkingMode.L;
        if (!z) {
            this.n = workingMode;
        }
        return z;
    }

    private AbstractC2900 a(float f, float f2, float f3, int i) {
        return o().m10275(b(true)).m10275(a(true)).m10275(h(0)).m10275(g(i)).m10275(a(f)).m10275(b(f2)).m10275(c(f3)).m10275(h(1)).m10275(f(i)).m10278(c()).m10281(new InterfaceC2857() { // from class: ˮ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                this.f10096.a((InterfaceC4478) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InterfaceC4478 interfaceC4478) {
        this.m = interfaceC4478;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AngleCallback angleCallback, float[] fArr) {
        angleCallback.call(fArr[0], fArr[1], fArr[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AngleCallback angleCallback, Throwable th) {
        angleCallback.onFailed(OptionalDeviceException.getInstance(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Callback callback) {
        callback.call(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Callback callback, Throwable th) {
        th.printStackTrace();
        callback.call(Boolean.FALSE);
    }
}
