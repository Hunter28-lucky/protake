package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.util.CheckerLocationPermission;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.UUIDUtil;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanResult;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.C3821;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;
import defpackage.InterfaceC5234;

/* loaded from: classes2.dex */
public final class RxBleClientImpl_Factory implements InterfaceC3628<RxBleClientImpl> {
    private final InterfaceC4461<AbstractC4262<RxBleAdapterStateObservable.BleAdapterState>> adapterStateObservableProvider;
    private final InterfaceC4461<BackgroundScanner> backgroundScannerProvider;
    private final InterfaceC4461<AbstractC4585> bluetoothInteractionSchedulerProvider;
    private final InterfaceC4461<CheckerLocationPermission> checkerLocationPermissionProvider;
    private final InterfaceC4461<ClientComponent.ClientComponentFinalizer> clientComponentFinalizerProvider;
    private final InterfaceC4461<ClientStateObservable> clientStateObservableProvider;
    private final InterfaceC4461<InterfaceC2368<RxBleInternalScanResult, ScanResult>> internalToExternalScanResultMapFunctionProvider;
    private final InterfaceC4461<LocationServicesStatus> locationServicesStatusProvider;
    private final InterfaceC4461<ClientOperationQueue> operationQueueProvider;
    private final InterfaceC4461<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    private final InterfaceC4461<RxBleDeviceProvider> rxBleDeviceProvider;
    private final InterfaceC4461<ScanPreconditionsVerifier> scanPreconditionVerifierProvider;
    private final InterfaceC4461<ScanSetupBuilder> scanSetupBuilderProvider;
    private final InterfaceC4461<UUIDUtil> uuidUtilProvider;

    public RxBleClientImpl_Factory(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<ClientOperationQueue> interfaceC44612, InterfaceC4461<AbstractC4262<RxBleAdapterStateObservable.BleAdapterState>> interfaceC44613, InterfaceC4461<UUIDUtil> interfaceC44614, InterfaceC4461<LocationServicesStatus> interfaceC44615, InterfaceC4461<ClientStateObservable> interfaceC44616, InterfaceC4461<RxBleDeviceProvider> interfaceC44617, InterfaceC4461<ScanSetupBuilder> interfaceC44618, InterfaceC4461<ScanPreconditionsVerifier> interfaceC44619, InterfaceC4461<InterfaceC2368<RxBleInternalScanResult, ScanResult>> interfaceC446110, InterfaceC4461<AbstractC4585> interfaceC446111, InterfaceC4461<ClientComponent.ClientComponentFinalizer> interfaceC446112, InterfaceC4461<BackgroundScanner> interfaceC446113, InterfaceC4461<CheckerLocationPermission> interfaceC446114) {
        this.rxBleAdapterWrapperProvider = interfaceC4461;
        this.operationQueueProvider = interfaceC44612;
        this.adapterStateObservableProvider = interfaceC44613;
        this.uuidUtilProvider = interfaceC44614;
        this.locationServicesStatusProvider = interfaceC44615;
        this.clientStateObservableProvider = interfaceC44616;
        this.rxBleDeviceProvider = interfaceC44617;
        this.scanSetupBuilderProvider = interfaceC44618;
        this.scanPreconditionVerifierProvider = interfaceC44619;
        this.internalToExternalScanResultMapFunctionProvider = interfaceC446110;
        this.bluetoothInteractionSchedulerProvider = interfaceC446111;
        this.clientComponentFinalizerProvider = interfaceC446112;
        this.backgroundScannerProvider = interfaceC446113;
        this.checkerLocationPermissionProvider = interfaceC446114;
    }

    public static RxBleClientImpl_Factory create(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<ClientOperationQueue> interfaceC44612, InterfaceC4461<AbstractC4262<RxBleAdapterStateObservable.BleAdapterState>> interfaceC44613, InterfaceC4461<UUIDUtil> interfaceC44614, InterfaceC4461<LocationServicesStatus> interfaceC44615, InterfaceC4461<ClientStateObservable> interfaceC44616, InterfaceC4461<RxBleDeviceProvider> interfaceC44617, InterfaceC4461<ScanSetupBuilder> interfaceC44618, InterfaceC4461<ScanPreconditionsVerifier> interfaceC44619, InterfaceC4461<InterfaceC2368<RxBleInternalScanResult, ScanResult>> interfaceC446110, InterfaceC4461<AbstractC4585> interfaceC446111, InterfaceC4461<ClientComponent.ClientComponentFinalizer> interfaceC446112, InterfaceC4461<BackgroundScanner> interfaceC446113, InterfaceC4461<CheckerLocationPermission> interfaceC446114) {
        return new RxBleClientImpl_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614, interfaceC44615, interfaceC44616, interfaceC44617, interfaceC44618, interfaceC44619, interfaceC446110, interfaceC446111, interfaceC446112, interfaceC446113, interfaceC446114);
    }

    public static RxBleClientImpl newRxBleClientImpl(RxBleAdapterWrapper rxBleAdapterWrapper, ClientOperationQueue clientOperationQueue, AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> abstractC4262, UUIDUtil uUIDUtil, LocationServicesStatus locationServicesStatus, InterfaceC5234<ClientStateObservable> interfaceC5234, RxBleDeviceProvider rxBleDeviceProvider, ScanSetupBuilder scanSetupBuilder, ScanPreconditionsVerifier scanPreconditionsVerifier, InterfaceC2368<RxBleInternalScanResult, ScanResult> interfaceC2368, AbstractC4585 abstractC4585, ClientComponent.ClientComponentFinalizer clientComponentFinalizer, BackgroundScanner backgroundScanner, CheckerLocationPermission checkerLocationPermission) {
        return new RxBleClientImpl(rxBleAdapterWrapper, clientOperationQueue, abstractC4262, uUIDUtil, locationServicesStatus, interfaceC5234, rxBleDeviceProvider, scanSetupBuilder, scanPreconditionsVerifier, interfaceC2368, abstractC4585, clientComponentFinalizer, backgroundScanner, checkerLocationPermission);
    }

    @Override // defpackage.InterfaceC4461
    public RxBleClientImpl get() {
        return new RxBleClientImpl(this.rxBleAdapterWrapperProvider.get(), this.operationQueueProvider.get(), this.adapterStateObservableProvider.get(), this.uuidUtilProvider.get(), this.locationServicesStatusProvider.get(), C3821.m12132(this.clientStateObservableProvider), this.rxBleDeviceProvider.get(), this.scanSetupBuilderProvider.get(), this.scanPreconditionVerifierProvider.get(), this.internalToExternalScanResultMapFunctionProvider.get(), this.bluetoothInteractionSchedulerProvider.get(), this.clientComponentFinalizerProvider.get(), this.backgroundScannerProvider.get(), this.checkerLocationPermissionProvider.get());
    }
}
