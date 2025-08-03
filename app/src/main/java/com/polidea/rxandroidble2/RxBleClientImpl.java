package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothDevice;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.operations.LegacyScanOperation;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResultLegacy;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanSetup;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.util.CheckerLocationPermission;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.UUIDUtil;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;
import defpackage.AbstractC4262;
import defpackage.AbstractC4274;
import defpackage.AbstractC4585;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC5234;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
class RxBleClientImpl extends RxBleClient {

    @Deprecated
    public static final String TAG = "RxBleClient";
    private final BackgroundScanner backgroundScanner;
    public final AbstractC4585 bluetoothInteractionScheduler;
    private final CheckerLocationPermission checkerLocationPermission;
    private final ClientComponent.ClientComponentFinalizer clientComponentFinalizer;
    public final InterfaceC2368<RxBleInternalScanResult, ScanResult> internalToExternalScanResultMapFunction;
    private final InterfaceC5234<ClientStateObservable> lazyClientStateObservable;
    private final LocationServicesStatus locationServicesStatus;
    public final ClientOperationQueue operationQueue;
    public final Map<Set<UUID>, AbstractC4262<RxBleScanResult>> queuedScanOperations = new HashMap();
    private final AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> rxBleAdapterStateObservable;
    private final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final RxBleDeviceProvider rxBleDeviceProvider;
    public final ScanPreconditionsVerifier scanPreconditionVerifier;
    public final ScanSetupBuilder scanSetupBuilder;
    private final UUIDUtil uuidUtil;

    public RxBleClientImpl(RxBleAdapterWrapper rxBleAdapterWrapper, ClientOperationQueue clientOperationQueue, AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> abstractC4262, UUIDUtil uUIDUtil, LocationServicesStatus locationServicesStatus, InterfaceC5234<ClientStateObservable> interfaceC5234, RxBleDeviceProvider rxBleDeviceProvider, ScanSetupBuilder scanSetupBuilder, ScanPreconditionsVerifier scanPreconditionsVerifier, InterfaceC2368<RxBleInternalScanResult, ScanResult> interfaceC2368, AbstractC4585 abstractC4585, ClientComponent.ClientComponentFinalizer clientComponentFinalizer, BackgroundScanner backgroundScanner, CheckerLocationPermission checkerLocationPermission) {
        this.uuidUtil = uUIDUtil;
        this.operationQueue = clientOperationQueue;
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.rxBleAdapterStateObservable = abstractC4262;
        this.locationServicesStatus = locationServicesStatus;
        this.lazyClientStateObservable = interfaceC5234;
        this.rxBleDeviceProvider = rxBleDeviceProvider;
        this.scanSetupBuilder = scanSetupBuilder;
        this.scanPreconditionVerifier = scanPreconditionsVerifier;
        this.internalToExternalScanResultMapFunction = interfaceC2368;
        this.bluetoothInteractionScheduler = abstractC4585;
        this.clientComponentFinalizer = clientComponentFinalizer;
        this.backgroundScanner = backgroundScanner;
        this.checkerLocationPermission = checkerLocationPermission;
    }

    private AbstractC4262<RxBleScanResult> createScanOperationApi18(@Nullable UUID[] uuidArr) {
        final Set<UUID> distinctSet = this.uuidUtil.toDistinctSet(uuidArr);
        return this.operationQueue.queue(new LegacyScanOperation(uuidArr, this.rxBleAdapterWrapper, this.uuidUtil)).doFinally(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.RxBleClientImpl.7
            @Override // defpackage.InterfaceC3809
            public void run() {
                synchronized (RxBleClientImpl.this.queuedScanOperations) {
                    RxBleClientImpl.this.queuedScanOperations.remove(distinctSet);
                }
            }
        }).mergeWith(bluetoothAdapterOffExceptionObservable()).map(new InterfaceC2368<RxBleInternalScanResultLegacy, RxBleScanResult>() { // from class: com.polidea.rxandroidble2.RxBleClientImpl.6
            @Override // defpackage.InterfaceC2368
            public RxBleScanResult apply(RxBleInternalScanResultLegacy rxBleInternalScanResultLegacy) {
                return RxBleClientImpl.this.convertToPublicScanResult(rxBleInternalScanResultLegacy);
            }
        }).doOnNext(new InterfaceC2857<RxBleScanResult>() { // from class: com.polidea.rxandroidble2.RxBleClientImpl.5
            @Override // defpackage.InterfaceC2857
            public void accept(RxBleScanResult rxBleScanResult) {
                RxBleLog.i("%s", rxBleScanResult);
            }
        }).share();
    }

    private void guardBluetoothAdapterAvailable() {
        if (!this.rxBleAdapterWrapper.hasBluetoothAdapter()) {
            throw new UnsupportedOperationException("RxAndroidBle library needs a BluetoothAdapter to be available in the system to work. If this is a test on an emulator then you can use 'https://github.com/Polidea/RxAndroidBle/tree/master/mockrxandroidble'");
        }
    }

    public <T> AbstractC4262<T> bluetoothAdapterOffExceptionObservable() {
        return this.rxBleAdapterStateObservable.filter(new InterfaceC4178<RxBleAdapterStateObservable.BleAdapterState>() { // from class: com.polidea.rxandroidble2.RxBleClientImpl.4
            @Override // defpackage.InterfaceC4178
            public boolean test(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) {
                return bleAdapterState != RxBleAdapterStateObservable.BleAdapterState.STATE_ON;
            }
        }).firstElement().m13387(new InterfaceC2368<RxBleAdapterStateObservable.BleAdapterState, InterfaceC3517<T>>() { // from class: com.polidea.rxandroidble2.RxBleClientImpl.3
            @Override // defpackage.InterfaceC2368
            public InterfaceC3517<T> apply(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) {
                return AbstractC4274.m13385(new BleScanException(1));
            }
        }).m13390();
    }

    public RxBleScanResult convertToPublicScanResult(RxBleInternalScanResultLegacy rxBleInternalScanResultLegacy) {
        return new RxBleScanResult(getBleDevice(rxBleInternalScanResultLegacy.getBluetoothDevice().getAddress()), rxBleInternalScanResultLegacy.getRssi(), rxBleInternalScanResultLegacy.getScanRecord());
    }

    public void finalize() throws Throwable {
        this.clientComponentFinalizer.onFinalize();
        super.finalize();
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public BackgroundScanner getBackgroundScanner() {
        return this.backgroundScanner;
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public RxBleDevice getBleDevice(@NonNull String str) {
        guardBluetoothAdapterAvailable();
        return this.rxBleDeviceProvider.getBleDevice(str);
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public Set<RxBleDevice> getBondedDevices() {
        guardBluetoothAdapterAvailable();
        HashSet hashSet = new HashSet();
        Iterator<BluetoothDevice> it = this.rxBleAdapterWrapper.getBondedDevices().iterator();
        while (it.hasNext()) {
            hashSet.add(getBleDevice(it.next().getAddress()));
        }
        return hashSet;
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public String[] getRecommendedScanRuntimePermissions() {
        return this.checkerLocationPermission.getRecommendedScanRuntimePermissions();
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public RxBleClient.State getState() {
        return !this.rxBleAdapterWrapper.hasBluetoothAdapter() ? RxBleClient.State.BLUETOOTH_NOT_AVAILABLE : !this.locationServicesStatus.isLocationPermissionOk() ? RxBleClient.State.LOCATION_PERMISSION_NOT_GRANTED : !this.rxBleAdapterWrapper.isBluetoothEnabled() ? RxBleClient.State.BLUETOOTH_NOT_ENABLED : !this.locationServicesStatus.isLocationProviderOk() ? RxBleClient.State.LOCATION_SERVICES_NOT_ENABLED : RxBleClient.State.READY;
    }

    public AbstractC4262<RxBleScanResult> initializeScan(@Nullable UUID[] uuidArr) {
        AbstractC4262<RxBleScanResult> abstractC4262CreateScanOperationApi18;
        Set<UUID> distinctSet = this.uuidUtil.toDistinctSet(uuidArr);
        synchronized (this.queuedScanOperations) {
            abstractC4262CreateScanOperationApi18 = this.queuedScanOperations.get(distinctSet);
            if (abstractC4262CreateScanOperationApi18 == null) {
                abstractC4262CreateScanOperationApi18 = createScanOperationApi18(uuidArr);
                this.queuedScanOperations.put(distinctSet, abstractC4262CreateScanOperationApi18);
            }
        }
        return abstractC4262CreateScanOperationApi18;
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public boolean isScanRuntimePermissionGranted() {
        return this.checkerLocationPermission.isScanRuntimePermissionGranted();
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public AbstractC4262<RxBleClient.State> observeStateChanges() {
        return this.lazyClientStateObservable.get();
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public AbstractC4262<ScanResult> scanBleDevices(final ScanSettings scanSettings, final ScanFilter... scanFilterArr) {
        return AbstractC4262.defer(new Callable<InterfaceC2856<? extends ScanResult>>() { // from class: com.polidea.rxandroidble2.RxBleClientImpl.1
            @Override // java.util.concurrent.Callable
            public InterfaceC2856<? extends ScanResult> call() throws BleScanException {
                RxBleClientImpl.this.scanPreconditionVerifier.verify(scanSettings.shouldCheckLocationProviderState());
                ScanSetup scanSetupBuild = RxBleClientImpl.this.scanSetupBuilder.build(scanSettings, scanFilterArr);
                return RxBleClientImpl.this.operationQueue.queue(scanSetupBuild.scanOperation).unsubscribeOn(RxBleClientImpl.this.bluetoothInteractionScheduler).compose(scanSetupBuild.scanOperationBehaviourEmulatorTransformer).map(RxBleClientImpl.this.internalToExternalScanResultMapFunction).doOnNext(new InterfaceC2857<ScanResult>() { // from class: com.polidea.rxandroidble2.RxBleClientImpl.1.1
                    @Override // defpackage.InterfaceC2857
                    public void accept(ScanResult scanResult) {
                        if (RxBleLog.getShouldLogScannedPeripherals()) {
                            RxBleLog.i("%s", scanResult);
                        }
                    }
                }).mergeWith(RxBleClientImpl.this.bluetoothAdapterOffExceptionObservable());
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public AbstractC4262<RxBleScanResult> scanBleDevices(@Nullable final UUID... uuidArr) {
        return AbstractC4262.defer(new Callable<InterfaceC2856<? extends RxBleScanResult>>() { // from class: com.polidea.rxandroidble2.RxBleClientImpl.2
            @Override // java.util.concurrent.Callable
            public InterfaceC2856<? extends RxBleScanResult> call() throws BleScanException {
                RxBleClientImpl.this.scanPreconditionVerifier.verify(true);
                return RxBleClientImpl.this.initializeScan(uuidArr);
            }
        });
    }
}
