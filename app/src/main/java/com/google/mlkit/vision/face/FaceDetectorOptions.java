package com.google.mlkit.vision.face;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.mlkit_vision_face.zzv;
import com.google.android.gms.internal.mlkit_vision_face.zzw;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public class FaceDetectorOptions {
    public static final int CLASSIFICATION_MODE_ALL = 2;
    public static final int CLASSIFICATION_MODE_NONE = 1;
    public static final int CONTOUR_MODE_ALL = 2;
    public static final int CONTOUR_MODE_NONE = 1;
    public static final int LANDMARK_MODE_ALL = 2;
    public static final int LANDMARK_MODE_NONE = 1;
    public static final int PERFORMANCE_MODE_ACCURATE = 2;
    public static final int PERFORMANCE_MODE_FAST = 1;

    @LandmarkMode
    private final int zza;

    @ContourMode
    private final int zzb;

    @ClassificationMode
    private final int zzc;

    @PerformanceMode
    private final int zzd;
    private final boolean zze;
    private final float zzf;

    @Nullable
    private final Executor zzg;

    /* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
    public static class Builder {

        @LandmarkMode
        private int zza = 1;

        @ContourMode
        private int zzb = 1;

        @ClassificationMode
        private int zzc = 1;

        @PerformanceMode
        private int zzd = 1;
        private boolean zze = false;
        private float zzf = 0.1f;

        @Nullable
        private Executor zzg;

        @NonNull
        public FaceDetectorOptions build() {
            return new FaceDetectorOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, null);
        }

        @NonNull
        public Builder enableTracking() {
            this.zze = true;
            return this;
        }

        @NonNull
        public Builder setClassificationMode(@ClassificationMode int i) {
            this.zzc = i;
            return this;
        }

        @NonNull
        public Builder setContourMode(@ContourMode int i) {
            this.zzb = i;
            return this;
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            this.zzg = executor;
            return this;
        }

        @NonNull
        public Builder setLandmarkMode(@LandmarkMode int i) {
            this.zza = i;
            return this;
        }

        @NonNull
        public Builder setMinFaceSize(float f) {
            this.zzf = f;
            return this;
        }

        @NonNull
        public Builder setPerformanceMode(@PerformanceMode int i) {
            this.zzd = i;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
    @Retention(RetentionPolicy.CLASS)
    public @interface ClassificationMode {
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
    @Retention(RetentionPolicy.CLASS)
    public @interface ContourMode {
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
    @Retention(RetentionPolicy.CLASS)
    public @interface LandmarkMode {
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
    @Retention(RetentionPolicy.CLASS)
    public @interface PerformanceMode {
    }

    public /* synthetic */ FaceDetectorOptions(int i, int i2, int i3, int i4, boolean z, float f, Executor executor, zza zzaVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = z;
        this.zzf = f;
        this.zzg = executor;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FaceDetectorOptions)) {
            return false;
        }
        FaceDetectorOptions faceDetectorOptions = (FaceDetectorOptions) obj;
        return Float.floatToIntBits(this.zzf) == Float.floatToIntBits(faceDetectorOptions.zzf) && Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(faceDetectorOptions.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(faceDetectorOptions.zzb)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(faceDetectorOptions.zzd)) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(faceDetectorOptions.zze)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(faceDetectorOptions.zzc)) && Objects.equal(this.zzg, faceDetectorOptions.zzg);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Float.floatToIntBits(this.zzf)), Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzd), Boolean.valueOf(this.zze), Integer.valueOf(this.zzc), this.zzg);
    }

    @NonNull
    public String toString() {
        zzv zzvVarZza = zzw.zza("FaceDetectorOptions");
        zzvVarZza.zzb("landmarkMode", this.zza);
        zzvVarZza.zzb("contourMode", this.zzb);
        zzvVarZza.zzb("classificationMode", this.zzc);
        zzvVarZza.zzb("performanceMode", this.zzd);
        zzvVarZza.zzd("trackingEnabled", this.zze);
        zzvVarZza.zza("minFaceSize", this.zzf);
        return zzvVarZza.toString();
    }

    public final float zza() {
        return this.zzf;
    }

    @ClassificationMode
    public final int zzb() {
        return this.zzc;
    }

    @ContourMode
    public final int zzc() {
        return this.zzb;
    }

    @LandmarkMode
    public final int zzd() {
        return this.zza;
    }

    @PerformanceMode
    public final int zze() {
        return this.zzd;
    }

    @Nullable
    public final Executor zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zze;
    }
}
