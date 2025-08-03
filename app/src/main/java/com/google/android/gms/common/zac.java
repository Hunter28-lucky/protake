package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;

/* compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* loaded from: classes2.dex */
final class zac implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity zaa;
    public final /* synthetic */ int zab;
    public final /* synthetic */ ActivityResultLauncher zac;
    public final /* synthetic */ GoogleApiAvailability zad;

    public zac(GoogleApiAvailability googleApiAvailability, Activity activity, int i, ActivityResultLauncher activityResultLauncher) {
        this.zad = googleApiAvailability;
        this.zaa = activity;
        this.zab = i;
        this.zac = activityResultLauncher;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        PendingIntent errorResolutionPendingIntent = this.zad.getErrorResolutionPendingIntent(this.zaa, this.zab, 0);
        if (errorResolutionPendingIntent == null) {
            return;
        }
        this.zac.launch(new IntentSenderRequest.Builder(errorResolutionPendingIntent.getIntentSender()).build());
    }
}
