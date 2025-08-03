package com.polidea.rxandroidble2.internal.scan;

import androidx.annotation.IntRange;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import defpackage.AbstractC3101;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC5298;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ScanSettingsEmulator {
    public final InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> emulateFirstMatch;
    public final AbstractC4585 scheduler;
    public final InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> emulateMatchLost = new InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.5
        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<RxBleInternalScanResult> apply(AbstractC4262<RxBleInternalScanResult> abstractC4262) {
            return abstractC4262.debounce(10L, TimeUnit.SECONDS, ScanSettingsEmulator.this.scheduler).map(ScanSettingsEmulator.toMatchLost());
        }
    };
    private final InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> emulateFirstMatchAndMatchLost = new InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.7
        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<RxBleInternalScanResult> apply(AbstractC4262<RxBleInternalScanResult> abstractC4262) {
            return abstractC4262.publish(new InterfaceC2368<AbstractC4262<RxBleInternalScanResult>, AbstractC4262<RxBleInternalScanResult>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.7.1
                @Override // defpackage.InterfaceC2368
                public AbstractC4262<RxBleInternalScanResult> apply(AbstractC4262<RxBleInternalScanResult> abstractC42622) {
                    return AbstractC4262.merge(abstractC42622.compose(ScanSettingsEmulator.this.emulateFirstMatch), abstractC42622.compose(ScanSettingsEmulator.this.emulateMatchLost));
                }
            });
        }
    };

    /* renamed from: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$1, reason: invalid class name */
    public class AnonymousClass1 implements InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> {
        public final AbstractC4262<Long> timerObservable;
        public final /* synthetic */ AbstractC4585 val$scheduler;
        public final InterfaceC2368<RxBleInternalScanResult, RxBleInternalScanResult> toFirstMatchFunc = ScanSettingsEmulator.toFirstMatch();
        public final InterfaceC2368<RxBleInternalScanResult, AbstractC4262<?>> emitAfterTimerFunc = new InterfaceC2368<RxBleInternalScanResult, AbstractC4262<?>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.1.1
            @Override // defpackage.InterfaceC2368
            public AbstractC4262<?> apply(RxBleInternalScanResult rxBleInternalScanResult) {
                return AnonymousClass1.this.timerObservable;
            }
        };
        public final InterfaceC2368<AbstractC4262<RxBleInternalScanResult>, AbstractC4262<RxBleInternalScanResult>> takeFirstFromEachWindowFunc = new InterfaceC2368<AbstractC4262<RxBleInternalScanResult>, AbstractC4262<RxBleInternalScanResult>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.1.2
            @Override // defpackage.InterfaceC2368
            public AbstractC4262<RxBleInternalScanResult> apply(AbstractC4262<RxBleInternalScanResult> abstractC4262) {
                return abstractC4262.take(1L);
            }
        };

        public AnonymousClass1(AbstractC4585 abstractC4585) {
            this.val$scheduler = abstractC4585;
            this.timerObservable = AbstractC4262.timer(10L, TimeUnit.SECONDS, abstractC4585);
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<RxBleInternalScanResult> apply(AbstractC4262<RxBleInternalScanResult> abstractC4262) {
            return abstractC4262.publish(new InterfaceC2368<AbstractC4262<RxBleInternalScanResult>, InterfaceC2856<RxBleInternalScanResult>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.1.3
                @Override // defpackage.InterfaceC2368
                public InterfaceC2856<RxBleInternalScanResult> apply(AbstractC4262<RxBleInternalScanResult> abstractC42622) {
                    return abstractC42622.window(abstractC42622.switchMap(AnonymousClass1.this.emitAfterTimerFunc)).flatMap(AnonymousClass1.this.takeFirstFromEachWindowFunc).map(AnonymousClass1.this.toFirstMatchFunc);
                }
            });
        }
    }

    public ScanSettingsEmulator(AbstractC4585 abstractC4585) {
        this.scheduler = abstractC4585;
        this.emulateFirstMatch = new AnonymousClass1(abstractC4585);
    }

    private InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> repeatedWindowTransformer(@IntRange(from = 0, to = 4999) final int i) {
        final long jMax = Math.max(TimeUnit.SECONDS.toMillis(5L) - i, 0L);
        return new InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.2
            @Override // defpackage.InterfaceC5298
            public InterfaceC2856<RxBleInternalScanResult> apply(AbstractC4262<RxBleInternalScanResult> abstractC4262) {
                return abstractC4262.take(i, TimeUnit.MILLISECONDS, ScanSettingsEmulator.this.scheduler).repeatWhen(new InterfaceC2368<AbstractC4262<Object>, InterfaceC2856<?>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.2.1
                    @Override // defpackage.InterfaceC2368
                    public InterfaceC2856<?> apply(AbstractC4262<Object> abstractC42622) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        return abstractC42622.delay(jMax, TimeUnit.MILLISECONDS, ScanSettingsEmulator.this.scheduler);
                    }
                });
            }
        };
    }

    private InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> scanModeBalancedTransformer() {
        return repeatedWindowTransformer(2500);
    }

    private InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> scanModeLowPowerTransformer() {
        return repeatedWindowTransformer(500);
    }

    private static InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> splitByAddressAndForEach(final InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> interfaceC5298) {
        return new InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.3
            @Override // defpackage.InterfaceC5298
            public InterfaceC2856<RxBleInternalScanResult> apply(AbstractC4262<RxBleInternalScanResult> abstractC4262) {
                return abstractC4262.groupBy(new InterfaceC2368<RxBleInternalScanResult, String>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.3.2
                    @Override // defpackage.InterfaceC2368
                    public String apply(RxBleInternalScanResult rxBleInternalScanResult) {
                        return rxBleInternalScanResult.getBluetoothDevice().getAddress();
                    }
                }).flatMap(new InterfaceC2368<AbstractC3101<String, RxBleInternalScanResult>, AbstractC4262<RxBleInternalScanResult>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.3.1
                    @Override // defpackage.InterfaceC2368
                    public AbstractC4262<RxBleInternalScanResult> apply(AbstractC3101<String, RxBleInternalScanResult> abstractC3101) {
                        return abstractC3101.compose(interfaceC5298);
                    }
                });
            }
        };
    }

    public static InterfaceC2368<RxBleInternalScanResult, RxBleInternalScanResult> toFirstMatch() {
        return new InterfaceC2368<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.4
            @Override // defpackage.InterfaceC2368
            public RxBleInternalScanResult apply(RxBleInternalScanResult rxBleInternalScanResult) {
                return new RxBleInternalScanResult(rxBleInternalScanResult.getBluetoothDevice(), rxBleInternalScanResult.getRssi(), rxBleInternalScanResult.getTimestampNanos(), rxBleInternalScanResult.getScanRecord(), ScanCallbackType.CALLBACK_TYPE_FIRST_MATCH);
            }
        };
    }

    public static InterfaceC2368<RxBleInternalScanResult, RxBleInternalScanResult> toMatchLost() {
        return new InterfaceC2368<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.6
            @Override // defpackage.InterfaceC2368
            public RxBleInternalScanResult apply(RxBleInternalScanResult rxBleInternalScanResult) {
                return new RxBleInternalScanResult(rxBleInternalScanResult.getBluetoothDevice(), rxBleInternalScanResult.getRssi(), rxBleInternalScanResult.getTimestampNanos(), rxBleInternalScanResult.getScanRecord(), ScanCallbackType.CALLBACK_TYPE_MATCH_LOST);
            }
        };
    }

    public InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> emulateCallbackType(int i) {
        return i != 2 ? i != 4 ? i != 6 ? ObservableUtil.identityTransformer() : splitByAddressAndForEach(this.emulateFirstMatchAndMatchLost) : splitByAddressAndForEach(this.emulateMatchLost) : splitByAddressAndForEach(this.emulateFirstMatch);
    }

    public InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> emulateScanMode(int i) {
        if (i == -1) {
            RxBleLog.w("Cannot emulate opportunistic scan mode since it is OS dependent - fallthrough to low power", new Object[0]);
        } else if (i != 0) {
            return i != 1 ? ObservableUtil.identityTransformer() : scanModeBalancedTransformer();
        }
        return scanModeLowPowerTransformer();
    }
}
