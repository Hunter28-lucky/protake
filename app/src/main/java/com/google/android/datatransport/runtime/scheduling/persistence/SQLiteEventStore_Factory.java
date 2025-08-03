package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {
    private final InterfaceC4815<Clock> clockProvider;
    private final InterfaceC4815<EventStoreConfig> configProvider;
    private final InterfaceC4815<String> packageNameProvider;
    private final InterfaceC4815<SchemaManager> schemaManagerProvider;
    private final InterfaceC4815<Clock> wallClockProvider;

    public SQLiteEventStore_Factory(InterfaceC4815<Clock> interfaceC4815, InterfaceC4815<Clock> interfaceC48152, InterfaceC4815<EventStoreConfig> interfaceC48153, InterfaceC4815<SchemaManager> interfaceC48154, InterfaceC4815<String> interfaceC48155) {
        this.wallClockProvider = interfaceC4815;
        this.clockProvider = interfaceC48152;
        this.configProvider = interfaceC48153;
        this.schemaManagerProvider = interfaceC48154;
        this.packageNameProvider = interfaceC48155;
    }

    public static SQLiteEventStore_Factory create(InterfaceC4815<Clock> interfaceC4815, InterfaceC4815<Clock> interfaceC48152, InterfaceC4815<EventStoreConfig> interfaceC48153, InterfaceC4815<SchemaManager> interfaceC48154, InterfaceC4815<String> interfaceC48155) {
        return new SQLiteEventStore_Factory(interfaceC4815, interfaceC48152, interfaceC48153, interfaceC48154, interfaceC48155);
    }

    public static SQLiteEventStore newInstance(Clock clock, Clock clock2, Object obj, Object obj2, InterfaceC4815<String> interfaceC4815) {
        return new SQLiteEventStore(clock, clock2, (EventStoreConfig) obj, (SchemaManager) obj2, interfaceC4815);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public SQLiteEventStore get() {
        return newInstance(this.wallClockProvider.get(), this.clockProvider.get(), this.configProvider.get(), this.schemaManagerProvider.get(), this.packageNameProvider);
    }
}
