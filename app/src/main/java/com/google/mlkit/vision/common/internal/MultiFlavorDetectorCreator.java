package com.google.mlkit.vision.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.mlkit:vision-common@@17.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class MultiFlavorDetectorCreator {
    private final Map zza = new HashMap();

    /* compiled from: com.google.mlkit:vision-common@@17.1.0 */
    @KeepForSdk
    public interface DetectorCreator<DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> {
        @NonNull
        @KeepForSdk
        DetectorT create(@NonNull OptionsT optionst);
    }

    /* compiled from: com.google.mlkit:vision-common@@17.1.0 */
    @KeepForSdk
    public interface DetectorOptions<DetectorT> {
    }

    /* compiled from: com.google.mlkit:vision-common@@17.1.0 */
    @KeepForSdk
    public interface MultiFlavorDetector {
    }

    /* compiled from: com.google.mlkit:vision-common@@17.1.0 */
    @KeepForSdk
    public static class Registration {
        private final Class zza;
        private final Provider zzb;
        private final int zzc;

        @KeepForSdk
        public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> Registration(@NonNull Class<? extends OptionsT> cls, @NonNull Provider<? extends DetectorCreator<DetectorT, OptionsT>> provider) {
            this(cls, provider, 100);
        }

        @KeepForSdk
        public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> Registration(@NonNull Class<? extends OptionsT> cls, @NonNull Provider<? extends DetectorCreator<DetectorT, OptionsT>> provider, int i) {
            this.zza = cls;
            this.zzb = provider;
            this.zzc = i;
        }

        public final int zza() {
            return this.zzc;
        }

        public final Provider zzb() {
            return this.zzb;
        }

        public final Class zzc() {
            return this.zza;
        }
    }

    public MultiFlavorDetectorCreator(Set set) {
        HashMap map = new HashMap();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Registration registration = (Registration) it.next();
            Class clsZzc = registration.zzc();
            if (!this.zza.containsKey(clsZzc) || registration.zza() >= ((Integer) Preconditions.checkNotNull((Integer) map.get(clsZzc))).intValue()) {
                this.zza.put(clsZzc, registration.zzb());
                map.put(clsZzc, Integer.valueOf(registration.zza()));
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static synchronized MultiFlavorDetectorCreator getInstance() {
        return (MultiFlavorDetectorCreator) MlKitContext.getInstance().get(MultiFlavorDetectorCreator.class);
    }

    @NonNull
    @KeepForSdk
    public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> DetectorT create(@NonNull OptionsT optionst) {
        return (DetectorT) ((DetectorCreator) ((Provider) Preconditions.checkNotNull((Provider) this.zza.get(optionst.getClass()))).get()).create(optionst);
    }
}
