package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.internal.operations.ConnectOperation;
import java.util.Set;

@ConnectionScope
/* loaded from: classes2.dex */
public interface ConnectionComponent {

    public interface Builder {
        Builder autoConnect(boolean z);

        ConnectionComponent build();

        Builder operationTimeout(Timeout timeout);

        Builder suppressOperationChecks(boolean z);
    }

    public static class NamedBooleans {
        public static final String AUTO_CONNECT = "autoConnect";
        public static final String SUPPRESS_OPERATION_CHECKS = "suppressOperationChecks";

        private NamedBooleans() {
        }
    }

    public static class NamedInts {
        public static final String GATT_MTU_MINIMUM = "GATT_MTU_MINIMUM";
        public static final String GATT_WRITE_MTU_OVERHEAD = "GATT_WRITE_MTU_OVERHEAD";

        private NamedInts() {
        }
    }

    @ConnectionScope
    ConnectOperation connectOperation();

    @ConnectionScope
    Set<ConnectionSubscriptionWatcher> connectionSubscriptionWatchers();

    @ConnectionScope
    RxBleGattCallback gattCallback();

    @ConnectionScope
    RxBleConnection rxBleConnection();
}
