package com.polidea.rxandroidble2;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.helpers.LocationServicesOkObservable;
import com.polidea.rxandroidble2.internal.scan.BackgroundScannerImpl;
import com.polidea.rxandroidble2.internal.scan.InternalToExternalScanResultConverter;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi18;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi24;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi21;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi23;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl;
import com.polidea.rxandroidble2.internal.serialization.RxBleThreadFactory;
import com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi18;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi23;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanResult;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.C4877;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC4461;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ClientScope
/* loaded from: classes2.dex */
public interface ClientComponent {

    public static class BluetoothConstants {
        public static final String DISABLE_NOTIFICATION_VALUE = "disable-notification-value";
        public static final String ENABLE_INDICATION_VALUE = "enable-indication-value";
        public static final String ENABLE_NOTIFICATION_VALUE = "enable-notification-value";

        private BluetoothConstants() {
        }
    }

    public interface Builder {
        Builder applicationContext(Context context);

        ClientComponent build();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface ClientComponentFinalizer {
        void onFinalize();
    }

    public static abstract class ClientModule {
        @Nullable
        public static BluetoothAdapter provideBluetoothAdapter() {
            return BluetoothAdapter.getDefaultAdapter();
        }

        @ClientScope
        public static AbstractC4585 provideBluetoothCallbacksScheduler() {
            return C3671.m11786(new RxBleThreadFactory());
        }

        @ClientScope
        public static ExecutorService provideBluetoothInteractionExecutorService() {
            return Executors.newSingleThreadExecutor();
        }

        @ClientScope
        public static AbstractC4585 provideBluetoothInteractionScheduler(ExecutorService executorService) {
            return C4877.m14601(executorService);
        }

        public static BluetoothManager provideBluetoothManager(Context context) {
            return (BluetoothManager) context.getSystemService("bluetooth");
        }

        public static AbstractC4585 provideComputationScheduler() {
            return C4877.m14600();
        }

        @ClientScope
        public static ExecutorService provideConnectionQueueExecutorService() {
            return Executors.newCachedThreadPool();
        }

        public static ContentResolver provideContentResolver(Context context) {
            return context.getContentResolver();
        }

        public static int provideDeviceSdk() {
            return Build.VERSION.SDK_INT;
        }

        public static byte[] provideDisableNotificationValue() {
            return BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        }

        public static byte[] provideEnableIndicationValue() {
            return BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        }

        public static byte[] provideEnableNotificationValue() {
            return BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        }

        public static ClientComponentFinalizer provideFinalizationCloseable(final ExecutorService executorService, final AbstractC4585 abstractC4585, final ExecutorService executorService2) {
            return new ClientComponentFinalizer() { // from class: com.polidea.rxandroidble2.ClientComponent.ClientModule.1
                @Override // com.polidea.rxandroidble2.ClientComponent.ClientComponentFinalizer
                public void onFinalize() {
                    executorService.shutdown();
                    abstractC4585.mo7000();
                    executorService2.shutdown();
                }
            };
        }

        @SuppressLint({"InlinedApi"})
        public static boolean provideIsAndroidWear(Context context, int i) {
            return i >= 20 && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        }

        public static LocationManager provideLocationManager(Context context) {
            return (LocationManager) context.getSystemService("location");
        }

        public static AbstractC4262<Boolean> provideLocationServicesOkObservable(int i, LocationServicesOkObservableApi23Factory locationServicesOkObservableApi23Factory) {
            return i < 23 ? ObservableUtil.justOnNext(Boolean.TRUE) : locationServicesOkObservableApi23Factory.get();
        }

        public static LocationServicesStatus provideLocationServicesStatus(int i, InterfaceC4461<LocationServicesStatusApi18> interfaceC4461, InterfaceC4461<LocationServicesStatusApi23> interfaceC44612) {
            return i < 23 ? interfaceC4461.get() : interfaceC44612.get();
        }

        public static String[] provideRecommendedScanRuntimePermissionNames(int i, int i2) {
            int iMin = Math.min(i, i2);
            return iMin < 23 ? new String[0] : iMin < 29 ? new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"} : new String[]{"android.permission.ACCESS_FINE_LOCATION"};
        }

        public static ScanPreconditionsVerifier provideScanPreconditionVerifier(int i, InterfaceC4461<ScanPreconditionsVerifierApi18> interfaceC4461, InterfaceC4461<ScanPreconditionsVerifierApi24> interfaceC44612) {
            return i < 24 ? interfaceC4461.get() : interfaceC44612.get();
        }

        @ClientScope
        public static ScanSetupBuilder provideScanSetupProvider(int i, InterfaceC4461<ScanSetupBuilderImplApi18> interfaceC4461, InterfaceC4461<ScanSetupBuilderImplApi21> interfaceC44612, InterfaceC4461<ScanSetupBuilderImplApi23> interfaceC44613) {
            return i < 21 ? interfaceC4461.get() : i < 23 ? interfaceC44612.get() : interfaceC44613.get();
        }

        public static int provideTargetSdk(Context context) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion;
            } catch (Throwable unused) {
                return Integer.MAX_VALUE;
            }
        }

        public abstract BackgroundScanner bindBackgroundScanner(BackgroundScannerImpl backgroundScannerImpl);

        @ClientScope
        public abstract ClientOperationQueue bindClientOperationQueue(ClientOperationQueueImpl clientOperationQueueImpl);

        @ClientScope
        public abstract RxBleClient bindRxBleClient(RxBleClientImpl rxBleClientImpl);

        public abstract AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> bindStateObs(RxBleAdapterStateObservable rxBleAdapterStateObservable);

        public abstract AbstractC4585 bindTimeoutScheduler(AbstractC4585 abstractC4585);

        public abstract InterfaceC2368<RxBleInternalScanResult, ScanResult> provideScanResultMapper(InternalToExternalScanResultConverter internalToExternalScanResultConverter);
    }

    public static class NamedBooleanObservables {
        public static final String LOCATION_SERVICES_OK = "location-ok-boolean-observable";

        private NamedBooleanObservables() {
        }
    }

    public static class NamedExecutors {
        public static final String BLUETOOTH_INTERACTION = "executor_bluetooth_interaction";
        public static final String CONNECTION_QUEUE = "executor_connection_queue";

        private NamedExecutors() {
        }
    }

    public static class NamedSchedulers {
        public static final String BLUETOOTH_CALLBACKS = "bluetooth_callbacks";
        public static final String BLUETOOTH_INTERACTION = "bluetooth_interaction";
        public static final String COMPUTATION = "computation";
        public static final String TIMEOUT = "timeout";

        private NamedSchedulers() {
        }
    }

    public static class PlatformConstants {
        public static final String BOOL_IS_ANDROID_WEAR = "android-wear";
        public static final String INT_DEVICE_SDK = "device-sdk";
        public static final String INT_TARGET_SDK = "target-sdk";
        public static final String STRING_ARRAY_SCAN_PERMISSIONS = "scan-permissions";

        private PlatformConstants() {
        }
    }

    LocationServicesOkObservable locationServicesOkObservable();

    RxBleClient rxBleClient();
}
