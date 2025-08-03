package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import defpackage.InterfaceC4815;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {
    private InterfaceC4815<SchedulerConfig> configProvider;
    private InterfaceC4815 creationContextFactoryProvider;
    private InterfaceC4815<DefaultScheduler> defaultSchedulerProvider;
    private InterfaceC4815<Executor> executorProvider;
    private InterfaceC4815 metadataBackendRegistryProvider;
    private InterfaceC4815<String> packageNameProvider;
    private InterfaceC4815<SQLiteEventStore> sQLiteEventStoreProvider;
    private InterfaceC4815 schemaManagerProvider;
    private InterfaceC4815<Context> setApplicationContextProvider;
    private InterfaceC4815<TransportRuntime> transportRuntimeProvider;
    private InterfaceC4815<Uploader> uploaderProvider;
    private InterfaceC4815<WorkInitializer> workInitializerProvider;
    private InterfaceC4815<WorkScheduler> workSchedulerProvider;

    public static final class Builder implements TransportRuntimeComponent.Builder {
        private Context setApplicationContext;

        private Builder() {
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        public TransportRuntimeComponent build() {
            Preconditions.checkBuilderRequirement(this.setApplicationContext, Context.class);
            return new DaggerTransportRuntimeComponent(this.setApplicationContext);
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        public Builder setApplicationContext(Context context) {
            this.setApplicationContext = (Context) Preconditions.checkNotNull(context);
            return this;
        }
    }

    public static TransportRuntimeComponent.Builder builder() {
        return new Builder();
    }

    private void initialize(Context context) {
        this.executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory.create());
        Factory factoryCreate = InstanceFactory.create(context);
        this.setApplicationContextProvider = factoryCreate;
        CreationContextFactory_Factory creationContextFactory_FactoryCreate = CreationContextFactory_Factory.create(factoryCreate, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create());
        this.creationContextFactoryProvider = creationContextFactory_FactoryCreate;
        this.metadataBackendRegistryProvider = DoubleCheck.provider(MetadataBackendRegistry_Factory.create(this.setApplicationContextProvider, creationContextFactory_FactoryCreate));
        this.schemaManagerProvider = SchemaManager_Factory.create(this.setApplicationContextProvider, EventStoreModule_DbNameFactory.create(), EventStoreModule_SchemaVersionFactory.create());
        this.packageNameProvider = DoubleCheck.provider(EventStoreModule_PackageNameFactory.create(this.setApplicationContextProvider));
        this.sQLiteEventStoreProvider = DoubleCheck.provider(SQLiteEventStore_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), EventStoreModule_StoreConfigFactory.create(), this.schemaManagerProvider, this.packageNameProvider));
        SchedulingConfigModule_ConfigFactory schedulingConfigModule_ConfigFactoryCreate = SchedulingConfigModule_ConfigFactory.create(TimeModule_EventClockFactory.create());
        this.configProvider = schedulingConfigModule_ConfigFactoryCreate;
        SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactoryCreate = SchedulingModule_WorkSchedulerFactory.create(this.setApplicationContextProvider, this.sQLiteEventStoreProvider, schedulingConfigModule_ConfigFactoryCreate, TimeModule_UptimeClockFactory.create());
        this.workSchedulerProvider = schedulingModule_WorkSchedulerFactoryCreate;
        InterfaceC4815<Executor> interfaceC4815 = this.executorProvider;
        InterfaceC4815 interfaceC48152 = this.metadataBackendRegistryProvider;
        InterfaceC4815<SQLiteEventStore> interfaceC48153 = this.sQLiteEventStoreProvider;
        this.defaultSchedulerProvider = DefaultScheduler_Factory.create(interfaceC4815, interfaceC48152, schedulingModule_WorkSchedulerFactoryCreate, interfaceC48153, interfaceC48153);
        InterfaceC4815<Context> interfaceC48154 = this.setApplicationContextProvider;
        InterfaceC4815 interfaceC48155 = this.metadataBackendRegistryProvider;
        InterfaceC4815<SQLiteEventStore> interfaceC48156 = this.sQLiteEventStoreProvider;
        this.uploaderProvider = Uploader_Factory.create(interfaceC48154, interfaceC48155, interfaceC48156, this.workSchedulerProvider, this.executorProvider, interfaceC48156, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.sQLiteEventStoreProvider);
        InterfaceC4815<Executor> interfaceC48157 = this.executorProvider;
        InterfaceC4815<SQLiteEventStore> interfaceC48158 = this.sQLiteEventStoreProvider;
        this.workInitializerProvider = WorkInitializer_Factory.create(interfaceC48157, interfaceC48158, this.workSchedulerProvider, interfaceC48158);
        this.transportRuntimeProvider = DoubleCheck.provider(TransportRuntime_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.defaultSchedulerProvider, this.uploaderProvider, this.workInitializerProvider));
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    public EventStore getEventStore() {
        return this.sQLiteEventStoreProvider.get();
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    public TransportRuntime getTransportRuntime() {
        return this.transportRuntimeProvider.get();
    }

    private DaggerTransportRuntimeComponent(Context context) {
        initialize(context);
    }
}
