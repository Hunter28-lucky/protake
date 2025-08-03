package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
final class zzbs extends com.google.android.gms.internal.play_billing.zzt {
    public final WeakReference zza;
    public final ResultReceiver zzb;

    public /* synthetic */ zzbs(WeakReference weakReference, ResultReceiver resultReceiver, zzbr zzbrVar) {
        this.zza = weakReference;
        this.zzb = resultReceiver;
    }

    @Override // com.google.android.gms.internal.play_billing.zzu
    public final void zza(Bundle bundle) throws RemoteException {
        ResultReceiver resultReceiver = this.zzb;
        if (resultReceiver == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Unable to send result for in-app messaging");
            return;
        }
        if (bundle == null) {
            resultReceiver.send(0, null);
            return;
        }
        Activity activity = (Activity) this.zza.get();
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("KEY_LAUNCH_INTENT");
        if (activity == null || pendingIntent == null) {
            this.zzb.send(0, null);
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Unable to launch intent for in-app messaging");
            return;
        }
        try {
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
            intent.putExtra(ProxyBillingActivity.KEY_IN_APP_MESSAGE_RESULT_RECEIVER, this.zzb);
            intent.putExtra("IN_APP_MESSAGE_INTENT", pendingIntent);
            activity.startActivity(intent);
        } catch (CancellationException e2) {
            this.zzb.send(0, null);
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Exception caught while launching intent for in-app messaging.", e2);
        }
    }
}
