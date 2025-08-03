package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class SchemaManager_Factory implements Factory<SchemaManager> {
    private final InterfaceC4815<Context> contextProvider;
    private final InterfaceC4815<String> dbNameProvider;
    private final InterfaceC4815<Integer> schemaVersionProvider;

    public SchemaManager_Factory(InterfaceC4815<Context> interfaceC4815, InterfaceC4815<String> interfaceC48152, InterfaceC4815<Integer> interfaceC48153) {
        this.contextProvider = interfaceC4815;
        this.dbNameProvider = interfaceC48152;
        this.schemaVersionProvider = interfaceC48153;
    }

    public static SchemaManager_Factory create(InterfaceC4815<Context> interfaceC4815, InterfaceC4815<String> interfaceC48152, InterfaceC4815<Integer> interfaceC48153) {
        return new SchemaManager_Factory(interfaceC4815, interfaceC48152, interfaceC48153);
    }

    public static SchemaManager newInstance(Context context, String str, int i) {
        return new SchemaManager(context, str, i);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public SchemaManager get() {
        return newInstance(this.contextProvider.get(), this.dbNameProvider.get(), this.schemaVersionProvider.get().intValue());
    }
}
