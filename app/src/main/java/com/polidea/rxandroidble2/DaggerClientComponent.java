package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.helpers.LocationServicesOkObservable;
import com.polidea.rxandroidble2.helpers.LocationServicesOkObservable_Factory;
import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvideBluetoothDeviceFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvideConnectionStateChangeListenerFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvideConnectionStateRelayFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvidesConnectTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvidesDisconnectTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.RxBleDeviceImpl_Factory;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider_Factory;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache_Factory;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider_Factory;
import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_GattWriteMtuOverheadFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_MinimumMtuFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvideBluetoothGattFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvideCharacteristicPropertiesParserFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvideIllegalOperationHandlerFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvidesOperationTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher;
import com.polidea.rxandroidble2.internal.connection.ConnectorImpl_Factory;
import com.polidea.rxandroidble2.internal.connection.DescriptorWriter_Factory;
import com.polidea.rxandroidble2.internal.connection.DisconnectAction_Factory;
import com.polidea.rxandroidble2.internal.connection.DisconnectionRouter_Factory;
import com.polidea.rxandroidble2.internal.connection.IllegalOperationChecker_Factory;
import com.polidea.rxandroidble2.internal.connection.IllegalOperationMessageCreator_Factory;
import com.polidea.rxandroidble2.internal.connection.LoggingIllegalOperationHandler_Factory;
import com.polidea.rxandroidble2.internal.connection.LongWriteOperationBuilderImpl_Factory;
import com.polidea.rxandroidble2.internal.connection.MtuBasedPayloadSizeLimit_Factory;
import com.polidea.rxandroidble2.internal.connection.MtuWatcher_Factory;
import com.polidea.rxandroidble2.internal.connection.NativeCallbackDispatcher_Factory;
import com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager_Factory;
import com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl;
import com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl_Factory;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback_Factory;
import com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager_Factory;
import com.polidea.rxandroidble2.internal.connection.ThrowingIllegalOperationHandler_Factory;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices_Factory;
import com.polidea.rxandroidble2.internal.operations.ConnectOperation;
import com.polidea.rxandroidble2.internal.operations.ConnectOperation_Factory;
import com.polidea.rxandroidble2.internal.operations.DisconnectOperation_Factory;
import com.polidea.rxandroidble2.internal.operations.OperationsProviderImpl_Factory;
import com.polidea.rxandroidble2.internal.operations.ReadRssiOperation_Factory;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.scan.AndroidScanObjectsConverter_Factory;
import com.polidea.rxandroidble2.internal.scan.BackgroundScannerImpl_Factory;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator_Factory;
import com.polidea.rxandroidble2.internal.scan.InternalToExternalScanResultConverter_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi18_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi24_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi21_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi23_Factory;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl_Factory;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl_Factory;
import com.polidea.rxandroidble2.internal.util.BleConnectionCompat;
import com.polidea.rxandroidble2.internal.util.CheckerLocationPermission;
import com.polidea.rxandroidble2.internal.util.CheckerLocationPermission_Factory;
import com.polidea.rxandroidble2.internal.util.CheckerLocationProvider_Factory;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi18_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi23_Factory;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper_Factory;
import com.polidea.rxandroidble2.internal.util.UUIDUtil_Factory;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.C2935;
import defpackage.C3650;
import defpackage.C3821;
import defpackage.C4106;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class DaggerClientComponent implements ClientComponent {
    private AndroidScanObjectsConverter_Factory androidScanObjectsConverterProvider;
    private Context applicationContext;
    private InterfaceC4461<Context> applicationContextProvider;
    private BackgroundScannerImpl_Factory backgroundScannerImplProvider;
    private InterfaceC4461<ClientOperationQueue> bindClientOperationQueueProvider;
    private InterfaceC4461<RxBleClient> bindRxBleClientProvider;
    private InterfaceC4461<CheckerLocationPermission> checkerLocationPermissionProvider;
    private CheckerLocationProvider_Factory checkerLocationProvider;
    private ClientOperationQueueImpl_Factory clientOperationQueueImplProvider;
    private ClientStateObservable_Factory clientStateObservableProvider;
    private InterfaceC4461<DeviceComponent.Builder> deviceComponentBuilderProvider;
    private InterfaceC4461<DeviceComponentCache> deviceComponentCacheProvider;
    private InterfaceC4461<InternalScanResultCreator> internalScanResultCreatorProvider;
    private InternalToExternalScanResultConverter_Factory internalToExternalScanResultConverterProvider;
    private LocationServicesOkObservableApi23Factory_Factory locationServicesOkObservableApi23FactoryProvider;
    private LocationServicesStatusApi23_Factory locationServicesStatusApi23Provider;
    private InterfaceC4461<AbstractC4585> provideBluetoothCallbacksSchedulerProvider;
    private InterfaceC4461<ExecutorService> provideBluetoothInteractionExecutorServiceProvider;
    private InterfaceC4461<AbstractC4585> provideBluetoothInteractionSchedulerProvider;
    private ClientComponent_ClientModule_ProvideBluetoothManagerFactory provideBluetoothManagerProvider;
    private InterfaceC4461<ExecutorService> provideConnectionQueueExecutorServiceProvider;
    private ClientComponent_ClientModule_ProvideContentResolverFactory provideContentResolverProvider;
    private ClientComponent_ClientModule_ProvideFinalizationCloseableFactory provideFinalizationCloseableProvider;
    private ClientComponent_ClientModule_ProvideIsAndroidWearFactory provideIsAndroidWearProvider;
    private ClientComponent_ClientModule_ProvideLocationManagerFactory provideLocationManagerProvider;
    private ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory provideLocationServicesOkObservableProvider;
    private ClientComponent_ClientModule_ProvideLocationServicesStatusFactory provideLocationServicesStatusProvider;
    private ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory provideRecommendedScanRuntimePermissionNamesProvider;
    private ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory provideScanPreconditionVerifierProvider;
    private InterfaceC4461<ScanSetupBuilder> provideScanSetupProvider;
    private ClientComponent_ClientModule_ProvideTargetSdkFactory provideTargetSdkProvider;
    private RxBleAdapterStateObservable_Factory rxBleAdapterStateObservableProvider;
    private RxBleAdapterWrapper_Factory rxBleAdapterWrapperProvider;
    private RxBleClientImpl_Factory rxBleClientImplProvider;
    private InterfaceC4461<RxBleDeviceProvider> rxBleDeviceProvider;
    private ScanPreconditionsVerifierApi18_Factory scanPreconditionsVerifierApi18Provider;
    private ScanPreconditionsVerifierApi24_Factory scanPreconditionsVerifierApi24Provider;
    private ScanSettingsEmulator_Factory scanSettingsEmulatorProvider;
    private ScanSetupBuilderImplApi18_Factory scanSetupBuilderImplApi18Provider;
    private ScanSetupBuilderImplApi21_Factory scanSetupBuilderImplApi21Provider;
    private ScanSetupBuilderImplApi23_Factory scanSetupBuilderImplApi23Provider;

    public static final class Builder implements ClientComponent.Builder {
        private Context applicationContext;

        private Builder() {
        }

        @Override // com.polidea.rxandroidble2.ClientComponent.Builder
        public ClientComponent build() {
            if (this.applicationContext != null) {
                return new DaggerClientComponent(this);
            }
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }

        @Override // com.polidea.rxandroidble2.ClientComponent.Builder
        public Builder applicationContext(Context context) {
            this.applicationContext = (Context) C4618.m14072(context);
            return this;
        }
    }

    public final class DeviceComponentBuilder implements DeviceComponent.Builder {
        private String macAddress;

        private DeviceComponentBuilder() {
        }

        @Override // com.polidea.rxandroidble2.internal.DeviceComponent.Builder
        public DeviceComponent build() {
            if (this.macAddress != null) {
                return new DeviceComponentImpl(this);
            }
            throw new IllegalStateException(String.class.getCanonicalName() + " must be set");
        }

        @Override // com.polidea.rxandroidble2.internal.DeviceComponent.Builder
        public DeviceComponentBuilder macAddress(String str) {
            this.macAddress = (String) C4618.m14072(str);
            return this;
        }
    }

    public final class DeviceComponentImpl implements DeviceComponent {
        private InterfaceC4461<ConnectionComponent.Builder> connectionComponentBuilderProvider;
        private ConnectorImpl_Factory connectorImplProvider;
        private String macAddress;
        private InterfaceC4461<String> macAddressProvider;
        private DeviceModule_ProvideBluetoothDeviceFactory provideBluetoothDeviceProvider;
        private InterfaceC4461<ConnectionStateChangeListener> provideConnectionStateChangeListenerProvider;
        private InterfaceC4461<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provideConnectionStateRelayProvider;
        private DeviceModule_ProvidesDisconnectTimeoutConfFactory providesDisconnectTimeoutConfProvider;
        private InterfaceC4461 rxBleDeviceImplProvider;

        public final class ConnectionComponentBuilder implements ConnectionComponent.Builder {
            private Boolean autoConnect;
            private Timeout operationTimeout;
            private Boolean suppressOperationChecks;

            private ConnectionComponentBuilder() {
            }

            @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent.Builder
            public ConnectionComponent build() {
                if (this.autoConnect == null) {
                    throw new IllegalStateException(Boolean.class.getCanonicalName() + " must be set");
                }
                if (this.suppressOperationChecks == null) {
                    throw new IllegalStateException(Boolean.class.getCanonicalName() + " must be set");
                }
                if (this.operationTimeout != null) {
                    return new ConnectionComponentImpl(this);
                }
                throw new IllegalStateException(Timeout.class.getCanonicalName() + " must be set");
            }

            @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent.Builder
            public ConnectionComponentBuilder autoConnect(boolean z) {
                this.autoConnect = (Boolean) C4618.m14072(Boolean.valueOf(z));
                return this;
            }

            @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent.Builder
            public ConnectionComponentBuilder operationTimeout(Timeout timeout) {
                this.operationTimeout = (Timeout) C4618.m14072(timeout);
                return this;
            }

            @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent.Builder
            public ConnectionComponentBuilder suppressOperationChecks(boolean z) {
                this.suppressOperationChecks = (Boolean) C4618.m14072(Boolean.valueOf(z));
                return this;
            }
        }

        public final class ConnectionComponentImpl implements ConnectionComponent {
            private Boolean autoConnect;
            private InterfaceC4461<BluetoothGattProvider> bluetoothGattProvider;
            private InterfaceC4461<ConnectionOperationQueueImpl> connectionOperationQueueImplProvider;
            private InterfaceC4461 descriptorWriterProvider;
            private InterfaceC4461 disconnectActionProvider;
            private DisconnectOperation_Factory disconnectOperationProvider;
            private InterfaceC4461 disconnectionRouterProvider;
            private IllegalOperationChecker_Factory illegalOperationCheckerProvider;
            private IllegalOperationMessageCreator_Factory illegalOperationMessageCreatorProvider;
            private LoggerUtilBluetoothServices_Factory loggerUtilBluetoothServicesProvider;
            private LoggingIllegalOperationHandler_Factory loggingIllegalOperationHandlerProvider;
            private LongWriteOperationBuilderImpl_Factory longWriteOperationBuilderImplProvider;
            private InterfaceC4461 mtuBasedPayloadSizeLimitProvider;
            private InterfaceC4461 mtuWatcherProvider;
            private InterfaceC4461 notificationAndIndicationManagerProvider;
            private InterfaceC4461<Timeout> operationTimeoutProvider;
            private OperationsProviderImpl_Factory operationsProviderImplProvider;
            private ConnectionModule_ProvideBluetoothGattFactory provideBluetoothGattProvider;
            private ConnectionModule_ProvideIllegalOperationHandlerFactory provideIllegalOperationHandlerProvider;
            private ConnectionModule_ProvidesOperationTimeoutConfFactory providesOperationTimeoutConfProvider;
            private ReadRssiOperation_Factory readRssiOperationProvider;
            private InterfaceC4461<RxBleConnectionImpl> rxBleConnectionImplProvider;
            private InterfaceC4461<RxBleGattCallback> rxBleGattCallbackProvider;
            private InterfaceC4461 serviceDiscoveryManagerProvider;
            private InterfaceC4461<Boolean> suppressOperationChecksProvider;
            private ThrowingIllegalOperationHandler_Factory throwingIllegalOperationHandlerProvider;

            private BleConnectionCompat getBleConnectionCompat() {
                return new BleConnectionCompat(DaggerClientComponent.this.applicationContext);
            }

            private void initialize(ConnectionComponentBuilder connectionComponentBuilder) {
                this.bluetoothGattProvider = C3821.m12133(BluetoothGattProvider_Factory.create());
                this.disconnectionRouterProvider = C3821.m12133(DisconnectionRouter_Factory.create(DeviceComponentImpl.this.macAddressProvider, DaggerClientComponent.this.rxBleAdapterWrapperProvider, DaggerClientComponent.this.rxBleAdapterStateObservableProvider));
                this.rxBleGattCallbackProvider = C3821.m12133(RxBleGattCallback_Factory.create(DaggerClientComponent.this.provideBluetoothCallbacksSchedulerProvider, this.bluetoothGattProvider, this.disconnectionRouterProvider, NativeCallbackDispatcher_Factory.create()));
                this.autoConnect = connectionComponentBuilder.autoConnect;
                this.connectionOperationQueueImplProvider = C3821.m12133(ConnectionOperationQueueImpl_Factory.create(DeviceComponentImpl.this.macAddressProvider, this.disconnectionRouterProvider, DaggerClientComponent.this.provideConnectionQueueExecutorServiceProvider, DaggerClientComponent.this.provideBluetoothInteractionSchedulerProvider));
                this.provideBluetoothGattProvider = ConnectionModule_ProvideBluetoothGattFactory.create(this.bluetoothGattProvider);
                this.loggerUtilBluetoothServicesProvider = LoggerUtilBluetoothServices_Factory.create(ConnectionModule_ProvideCharacteristicPropertiesParserFactory.create());
                this.operationTimeoutProvider = C2935.m10335(connectionComponentBuilder.operationTimeout);
                ConnectionModule_ProvidesOperationTimeoutConfFactory connectionModule_ProvidesOperationTimeoutConfFactoryCreate = ConnectionModule_ProvidesOperationTimeoutConfFactory.create(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create(), this.operationTimeoutProvider);
                this.providesOperationTimeoutConfProvider = connectionModule_ProvidesOperationTimeoutConfFactoryCreate;
                this.readRssiOperationProvider = ReadRssiOperation_Factory.create(this.rxBleGattCallbackProvider, this.provideBluetoothGattProvider, connectionModule_ProvidesOperationTimeoutConfFactoryCreate);
                OperationsProviderImpl_Factory operationsProviderImpl_FactoryCreate = OperationsProviderImpl_Factory.create(this.rxBleGattCallbackProvider, this.provideBluetoothGattProvider, this.loggerUtilBluetoothServicesProvider, this.providesOperationTimeoutConfProvider, DaggerClientComponent.this.provideBluetoothInteractionSchedulerProvider, ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create(), this.readRssiOperationProvider);
                this.operationsProviderImplProvider = operationsProviderImpl_FactoryCreate;
                this.serviceDiscoveryManagerProvider = C3821.m12133(ServiceDiscoveryManager_Factory.create(this.connectionOperationQueueImplProvider, this.provideBluetoothGattProvider, operationsProviderImpl_FactoryCreate));
                this.descriptorWriterProvider = C3821.m12133(DescriptorWriter_Factory.create(this.connectionOperationQueueImplProvider, this.operationsProviderImplProvider));
                this.notificationAndIndicationManagerProvider = C3821.m12133(NotificationAndIndicationManager_Factory.create(ClientComponent_ClientModule_ProvideEnableNotificationValueFactory.create(), ClientComponent_ClientModule_ProvideEnableIndicationValueFactory.create(), ClientComponent_ClientModule_ProvideDisableNotificationValueFactory.create(), this.provideBluetoothGattProvider, this.rxBleGattCallbackProvider, this.descriptorWriterProvider));
                this.mtuWatcherProvider = C3821.m12133(MtuWatcher_Factory.create(this.rxBleGattCallbackProvider, ConnectionModule_MinimumMtuFactory.create()));
                C4106 c4106 = new C4106();
                this.rxBleConnectionImplProvider = c4106;
                InterfaceC4461 interfaceC4461M12133 = C3821.m12133(MtuBasedPayloadSizeLimit_Factory.create(c4106, ConnectionModule_GattWriteMtuOverheadFactory.create()));
                this.mtuBasedPayloadSizeLimitProvider = interfaceC4461M12133;
                this.longWriteOperationBuilderImplProvider = LongWriteOperationBuilderImpl_Factory.create(this.connectionOperationQueueImplProvider, interfaceC4461M12133, this.rxBleConnectionImplProvider, this.operationsProviderImplProvider);
                this.suppressOperationChecksProvider = C2935.m10335(connectionComponentBuilder.suppressOperationChecks);
                IllegalOperationMessageCreator_Factory illegalOperationMessageCreator_FactoryCreate = IllegalOperationMessageCreator_Factory.create(ConnectionModule_ProvideCharacteristicPropertiesParserFactory.create());
                this.illegalOperationMessageCreatorProvider = illegalOperationMessageCreator_FactoryCreate;
                this.loggingIllegalOperationHandlerProvider = LoggingIllegalOperationHandler_Factory.create(illegalOperationMessageCreator_FactoryCreate);
                ThrowingIllegalOperationHandler_Factory throwingIllegalOperationHandler_FactoryCreate = ThrowingIllegalOperationHandler_Factory.create(this.illegalOperationMessageCreatorProvider);
                this.throwingIllegalOperationHandlerProvider = throwingIllegalOperationHandler_FactoryCreate;
                ConnectionModule_ProvideIllegalOperationHandlerFactory connectionModule_ProvideIllegalOperationHandlerFactoryCreate = ConnectionModule_ProvideIllegalOperationHandlerFactory.create(this.suppressOperationChecksProvider, this.loggingIllegalOperationHandlerProvider, throwingIllegalOperationHandler_FactoryCreate);
                this.provideIllegalOperationHandlerProvider = connectionModule_ProvideIllegalOperationHandlerFactoryCreate;
                this.illegalOperationCheckerProvider = IllegalOperationChecker_Factory.create(connectionModule_ProvideIllegalOperationHandlerFactoryCreate);
                C4106 c41062 = (C4106) this.rxBleConnectionImplProvider;
                InterfaceC4461<RxBleConnectionImpl> interfaceC4461M121332 = C3821.m12133(RxBleConnectionImpl_Factory.create(this.connectionOperationQueueImplProvider, this.rxBleGattCallbackProvider, this.provideBluetoothGattProvider, this.serviceDiscoveryManagerProvider, this.notificationAndIndicationManagerProvider, this.mtuWatcherProvider, this.descriptorWriterProvider, this.operationsProviderImplProvider, this.longWriteOperationBuilderImplProvider, DaggerClientComponent.this.provideBluetoothInteractionSchedulerProvider, this.illegalOperationCheckerProvider));
                this.rxBleConnectionImplProvider = interfaceC4461M121332;
                c41062.m13051(interfaceC4461M121332);
                this.disconnectOperationProvider = DisconnectOperation_Factory.create(this.rxBleGattCallbackProvider, this.bluetoothGattProvider, DeviceComponentImpl.this.macAddressProvider, DaggerClientComponent.this.provideBluetoothManagerProvider, DaggerClientComponent.this.provideBluetoothInteractionSchedulerProvider, DeviceComponentImpl.this.providesDisconnectTimeoutConfProvider, DeviceComponentImpl.this.provideConnectionStateChangeListenerProvider);
                this.disconnectActionProvider = C3821.m12133(DisconnectAction_Factory.create(DaggerClientComponent.this.bindClientOperationQueueProvider, this.disconnectOperationProvider));
            }

            @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent
            public ConnectOperation connectOperation() {
                return ConnectOperation_Factory.newConnectOperation(DeviceComponentImpl.this.getBluetoothDevice(), getBleConnectionCompat(), this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), DeviceComponentImpl.this.getNamedTimeoutConfiguration(), this.autoConnect.booleanValue(), (ConnectionStateChangeListener) DeviceComponentImpl.this.provideConnectionStateChangeListenerProvider.get());
            }

            @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent
            public Set<ConnectionSubscriptionWatcher> connectionSubscriptionWatchers() {
                return C3650.m11736(3).m11737((ConnectionSubscriptionWatcher) this.mtuWatcherProvider.get()).m11737((ConnectionSubscriptionWatcher) this.disconnectActionProvider.get()).m11737(this.connectionOperationQueueImplProvider.get()).m11738();
            }

            @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent
            public RxBleGattCallback gattCallback() {
                return this.rxBleGattCallbackProvider.get();
            }

            @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent
            public RxBleConnection rxBleConnection() {
                return this.rxBleConnectionImplProvider.get();
            }

            private ConnectionComponentImpl(ConnectionComponentBuilder connectionComponentBuilder) {
                initialize(connectionComponentBuilder);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BluetoothDevice getBluetoothDevice() {
            return DeviceModule_ProvideBluetoothDeviceFactory.proxyProvideBluetoothDevice(this.macAddress, DaggerClientComponent.this.getRxBleAdapterWrapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TimeoutConfiguration getNamedTimeoutConfiguration() {
            return DeviceModule_ProvidesConnectTimeoutConfFactory.proxyProvidesConnectTimeoutConf(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.proxyProvideComputationScheduler());
        }

        private void initialize(DeviceComponentBuilder deviceComponentBuilder) {
            InterfaceC3628 interfaceC3628M10335 = C2935.m10335(deviceComponentBuilder.macAddress);
            this.macAddressProvider = interfaceC3628M10335;
            this.provideBluetoothDeviceProvider = DeviceModule_ProvideBluetoothDeviceFactory.create(interfaceC3628M10335, DaggerClientComponent.this.rxBleAdapterWrapperProvider);
            this.connectionComponentBuilderProvider = new InterfaceC4461<ConnectionComponent.Builder>() { // from class: com.polidea.rxandroidble2.DaggerClientComponent.DeviceComponentImpl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // defpackage.InterfaceC4461
                public ConnectionComponent.Builder get() {
                    return new ConnectionComponentBuilder();
                }
            };
            this.connectorImplProvider = ConnectorImpl_Factory.create(DaggerClientComponent.this.bindClientOperationQueueProvider, this.connectionComponentBuilderProvider, DaggerClientComponent.this.provideBluetoothCallbacksSchedulerProvider);
            InterfaceC4461<BehaviorRelay<RxBleConnection.RxBleConnectionState>> interfaceC4461M12133 = C3821.m12133(DeviceModule_ProvideConnectionStateRelayFactory.create());
            this.provideConnectionStateRelayProvider = interfaceC4461M12133;
            this.rxBleDeviceImplProvider = C3821.m12133(RxBleDeviceImpl_Factory.create(this.provideBluetoothDeviceProvider, this.connectorImplProvider, interfaceC4461M12133));
            this.macAddress = deviceComponentBuilder.macAddress;
            this.provideConnectionStateChangeListenerProvider = C3821.m12133(DeviceModule_ProvideConnectionStateChangeListenerFactory.create(this.provideConnectionStateRelayProvider));
            this.providesDisconnectTimeoutConfProvider = DeviceModule_ProvidesDisconnectTimeoutConfFactory.create(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
        }

        @Override // com.polidea.rxandroidble2.internal.DeviceComponent
        public RxBleDevice provideDevice() {
            return (RxBleDevice) this.rxBleDeviceImplProvider.get();
        }

        private DeviceComponentImpl(DeviceComponentBuilder deviceComponentBuilder) {
            initialize(deviceComponentBuilder);
        }
    }

    public static ClientComponent.Builder builder() {
        return new Builder();
    }

    private LocationServicesOkObservableApi23Factory getLocationServicesOkObservableApi23Factory() {
        return LocationServicesOkObservableApi23Factory_Factory.newLocationServicesOkObservableApi23Factory(this.applicationContext, getLocationServicesStatus());
    }

    private LocationServicesStatus getLocationServicesStatus() {
        return ClientComponent_ClientModule_ProvideLocationServicesStatusFactory.proxyProvideLocationServicesStatus(ClientComponent.ClientModule.provideDeviceSdk(), LocationServicesStatusApi18_Factory.create(), this.locationServicesStatusApi23Provider);
    }

    private AbstractC4262<Boolean> getNamedObservableOfBoolean() {
        return ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory.proxyProvideLocationServicesOkObservable(ClientComponent.ClientModule.provideDeviceSdk(), getLocationServicesOkObservableApi23Factory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RxBleAdapterWrapper getRxBleAdapterWrapper() {
        return new RxBleAdapterWrapper(ClientComponent.ClientModule.provideBluetoothAdapter());
    }

    private void initialize(Builder builder) {
        this.applicationContext = builder.applicationContext;
        InterfaceC3628 interfaceC3628M10335 = C2935.m10335(builder.applicationContext);
        this.applicationContextProvider = interfaceC3628M10335;
        this.provideContentResolverProvider = ClientComponent_ClientModule_ProvideContentResolverFactory.create(interfaceC3628M10335);
        ClientComponent_ClientModule_ProvideLocationManagerFactory clientComponent_ClientModule_ProvideLocationManagerFactoryCreate = ClientComponent_ClientModule_ProvideLocationManagerFactory.create(this.applicationContextProvider);
        this.provideLocationManagerProvider = clientComponent_ClientModule_ProvideLocationManagerFactoryCreate;
        this.checkerLocationProvider = CheckerLocationProvider_Factory.create(this.provideContentResolverProvider, clientComponent_ClientModule_ProvideLocationManagerFactoryCreate);
        this.provideTargetSdkProvider = ClientComponent_ClientModule_ProvideTargetSdkFactory.create(this.applicationContextProvider);
        ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory clientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactoryCreate = ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.provideTargetSdkProvider);
        this.provideRecommendedScanRuntimePermissionNamesProvider = clientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactoryCreate;
        this.checkerLocationPermissionProvider = C3821.m12133(CheckerLocationPermission_Factory.create(this.applicationContextProvider, clientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactoryCreate));
        ClientComponent_ClientModule_ProvideIsAndroidWearFactory clientComponent_ClientModule_ProvideIsAndroidWearFactoryCreate = ClientComponent_ClientModule_ProvideIsAndroidWearFactory.create(this.applicationContextProvider, ClientComponent_ClientModule_ProvideDeviceSdkFactory.create());
        this.provideIsAndroidWearProvider = clientComponent_ClientModule_ProvideIsAndroidWearFactoryCreate;
        this.locationServicesStatusApi23Provider = LocationServicesStatusApi23_Factory.create(this.checkerLocationProvider, this.checkerLocationPermissionProvider, this.provideTargetSdkProvider, clientComponent_ClientModule_ProvideIsAndroidWearFactoryCreate);
        this.rxBleAdapterWrapperProvider = RxBleAdapterWrapper_Factory.create(ClientComponent_ClientModule_ProvideBluetoothAdapterFactory.create());
        InterfaceC4461<ExecutorService> interfaceC4461M12133 = C3821.m12133(ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory.create());
        this.provideBluetoothInteractionExecutorServiceProvider = interfaceC4461M12133;
        InterfaceC4461<AbstractC4585> interfaceC4461M121332 = C3821.m12133(ClientComponent_ClientModule_ProvideBluetoothInteractionSchedulerFactory.create(interfaceC4461M12133));
        this.provideBluetoothInteractionSchedulerProvider = interfaceC4461M121332;
        ClientOperationQueueImpl_Factory clientOperationQueueImpl_FactoryCreate = ClientOperationQueueImpl_Factory.create(interfaceC4461M121332);
        this.clientOperationQueueImplProvider = clientOperationQueueImpl_FactoryCreate;
        this.bindClientOperationQueueProvider = C3821.m12133(clientOperationQueueImpl_FactoryCreate);
        this.rxBleAdapterStateObservableProvider = RxBleAdapterStateObservable_Factory.create(this.applicationContextProvider);
        ClientComponent_ClientModule_ProvideLocationServicesStatusFactory clientComponent_ClientModule_ProvideLocationServicesStatusFactoryCreate = ClientComponent_ClientModule_ProvideLocationServicesStatusFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), LocationServicesStatusApi18_Factory.create(), this.locationServicesStatusApi23Provider);
        this.provideLocationServicesStatusProvider = clientComponent_ClientModule_ProvideLocationServicesStatusFactoryCreate;
        this.locationServicesOkObservableApi23FactoryProvider = LocationServicesOkObservableApi23Factory_Factory.create(this.applicationContextProvider, clientComponent_ClientModule_ProvideLocationServicesStatusFactoryCreate);
        ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory clientComponent_ClientModule_ProvideLocationServicesOkObservableFactoryCreate = ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.locationServicesOkObservableApi23FactoryProvider);
        this.provideLocationServicesOkObservableProvider = clientComponent_ClientModule_ProvideLocationServicesOkObservableFactoryCreate;
        this.clientStateObservableProvider = ClientStateObservable_Factory.create(this.rxBleAdapterWrapperProvider, this.rxBleAdapterStateObservableProvider, clientComponent_ClientModule_ProvideLocationServicesOkObservableFactoryCreate, this.provideLocationServicesStatusProvider, ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
        this.deviceComponentCacheProvider = C3821.m12133(DeviceComponentCache_Factory.create());
        InterfaceC4461<DeviceComponent.Builder> interfaceC4461 = new InterfaceC4461<DeviceComponent.Builder>() { // from class: com.polidea.rxandroidble2.DaggerClientComponent.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // defpackage.InterfaceC4461
            public DeviceComponent.Builder get() {
                return new DeviceComponentBuilder();
            }
        };
        this.deviceComponentBuilderProvider = interfaceC4461;
        this.rxBleDeviceProvider = C3821.m12133(RxBleDeviceProvider_Factory.create(this.deviceComponentCacheProvider, interfaceC4461));
        this.internalScanResultCreatorProvider = C3821.m12133(InternalScanResultCreator_Factory.create(UUIDUtil_Factory.create()));
        ScanSettingsEmulator_Factory scanSettingsEmulator_FactoryCreate = ScanSettingsEmulator_Factory.create(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
        this.scanSettingsEmulatorProvider = scanSettingsEmulator_FactoryCreate;
        this.scanSetupBuilderImplApi18Provider = ScanSetupBuilderImplApi18_Factory.create(this.rxBleAdapterWrapperProvider, this.internalScanResultCreatorProvider, scanSettingsEmulator_FactoryCreate);
        AndroidScanObjectsConverter_Factory androidScanObjectsConverter_FactoryCreate = AndroidScanObjectsConverter_Factory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create());
        this.androidScanObjectsConverterProvider = androidScanObjectsConverter_FactoryCreate;
        this.scanSetupBuilderImplApi21Provider = ScanSetupBuilderImplApi21_Factory.create(this.rxBleAdapterWrapperProvider, this.internalScanResultCreatorProvider, this.scanSettingsEmulatorProvider, androidScanObjectsConverter_FactoryCreate);
        this.scanSetupBuilderImplApi23Provider = ScanSetupBuilderImplApi23_Factory.create(this.rxBleAdapterWrapperProvider, this.internalScanResultCreatorProvider, this.scanSettingsEmulatorProvider, this.androidScanObjectsConverterProvider);
        this.provideScanSetupProvider = C3821.m12133(ClientComponent_ClientModule_ProvideScanSetupProviderFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.scanSetupBuilderImplApi18Provider, this.scanSetupBuilderImplApi21Provider, this.scanSetupBuilderImplApi23Provider));
        ScanPreconditionsVerifierApi18_Factory scanPreconditionsVerifierApi18_FactoryCreate = ScanPreconditionsVerifierApi18_Factory.create(this.rxBleAdapterWrapperProvider, this.provideLocationServicesStatusProvider);
        this.scanPreconditionsVerifierApi18Provider = scanPreconditionsVerifierApi18_FactoryCreate;
        this.scanPreconditionsVerifierApi24Provider = ScanPreconditionsVerifierApi24_Factory.create(scanPreconditionsVerifierApi18_FactoryCreate, ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
        this.provideScanPreconditionVerifierProvider = ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.scanPreconditionsVerifierApi18Provider, this.scanPreconditionsVerifierApi24Provider);
        this.internalToExternalScanResultConverterProvider = InternalToExternalScanResultConverter_Factory.create(this.rxBleDeviceProvider);
        this.provideBluetoothCallbacksSchedulerProvider = C3821.m12133(ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory.create());
        InterfaceC4461<ExecutorService> interfaceC4461M121333 = C3821.m12133(ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory.create());
        this.provideConnectionQueueExecutorServiceProvider = interfaceC4461M121333;
        this.provideFinalizationCloseableProvider = ClientComponent_ClientModule_ProvideFinalizationCloseableFactory.create(this.provideBluetoothInteractionExecutorServiceProvider, this.provideBluetoothCallbacksSchedulerProvider, interfaceC4461M121333);
        this.backgroundScannerImplProvider = BackgroundScannerImpl_Factory.create(this.rxBleAdapterWrapperProvider, this.androidScanObjectsConverterProvider, this.internalScanResultCreatorProvider, this.internalToExternalScanResultConverterProvider);
        RxBleClientImpl_Factory rxBleClientImpl_FactoryCreate = RxBleClientImpl_Factory.create(this.rxBleAdapterWrapperProvider, this.bindClientOperationQueueProvider, this.rxBleAdapterStateObservableProvider, UUIDUtil_Factory.create(), this.provideLocationServicesStatusProvider, this.clientStateObservableProvider, this.rxBleDeviceProvider, this.provideScanSetupProvider, this.provideScanPreconditionVerifierProvider, this.internalToExternalScanResultConverterProvider, this.provideBluetoothInteractionSchedulerProvider, this.provideFinalizationCloseableProvider, this.backgroundScannerImplProvider, this.checkerLocationPermissionProvider);
        this.rxBleClientImplProvider = rxBleClientImpl_FactoryCreate;
        this.bindRxBleClientProvider = C3821.m12133(rxBleClientImpl_FactoryCreate);
        this.provideBluetoothManagerProvider = ClientComponent_ClientModule_ProvideBluetoothManagerFactory.create(this.applicationContextProvider);
    }

    @Override // com.polidea.rxandroidble2.ClientComponent
    public LocationServicesOkObservable locationServicesOkObservable() {
        return LocationServicesOkObservable_Factory.newLocationServicesOkObservable(getNamedObservableOfBoolean());
    }

    @Override // com.polidea.rxandroidble2.ClientComponent
    public RxBleClient rxBleClient() {
        return this.bindRxBleClientProvider.get();
    }

    private DaggerClientComponent(Builder builder) {
        initialize(builder);
    }
}
