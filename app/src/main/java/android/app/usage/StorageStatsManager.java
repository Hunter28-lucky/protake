package android.app.usage;

import android.annotation.NonNull;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
public /* synthetic */ class StorageStatsManager {
    static {
        throw new NoClassDefFoundError();
    }

    public native /* synthetic */ long getFreeBytes(@NonNull UUID uuid) throws IOException;

    public native /* synthetic */ long getTotalBytes(@NonNull UUID uuid) throws IOException;
}
