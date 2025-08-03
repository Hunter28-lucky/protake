package com.google.android.gms.location;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
@Deprecated
/* loaded from: classes2.dex */
public interface ActivityRecognitionApi {
    @NonNull
    @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    PendingResult<Status> removeActivityUpdates(@NonNull GoogleApiClient googleApiClient, @NonNull PendingIntent pendingIntent);

    @NonNull
    @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    PendingResult<Status> requestActivityUpdates(@NonNull GoogleApiClient googleApiClient, long j, @NonNull PendingIntent pendingIntent);
}
