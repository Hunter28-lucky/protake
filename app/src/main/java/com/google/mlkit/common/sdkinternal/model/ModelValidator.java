package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.model.RemoteModel;
import java.io.File;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public interface ModelValidator {

    /* compiled from: com.google.mlkit:common@@18.1.0 */
    @KeepForSdk
    public static class ValidationResult {

        @NonNull
        @KeepForSdk
        public static final ValidationResult VALID = new ValidationResult(ErrorCode.OK, null);
        private final ErrorCode zza;

        @Nullable
        private final String zzb;

        /* compiled from: com.google.mlkit:common@@18.1.0 */
        @KeepForSdk
        public enum ErrorCode {
            OK,
            TFLITE_VERSION_INCOMPATIBLE,
            MODEL_FORMAT_INVALID
        }

        @KeepForSdk
        public ValidationResult(@NonNull ErrorCode errorCode, @Nullable String str) {
            this.zza = errorCode;
            this.zzb = str;
        }

        @NonNull
        @KeepForSdk
        public ErrorCode getErrorCode() {
            return this.zza;
        }

        @Nullable
        @KeepForSdk
        public String getErrorMessage() {
            return this.zzb;
        }

        @KeepForSdk
        public boolean isValid() {
            return this.zza == ErrorCode.OK;
        }
    }

    @NonNull
    @KeepForSdk
    ValidationResult validateModel(@NonNull File file, @NonNull RemoteModel remoteModel);
}
