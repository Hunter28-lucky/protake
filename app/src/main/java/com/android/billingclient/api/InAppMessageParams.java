package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
public final class InAppMessageParams {
    private final ArrayList zza;

    /* compiled from: com.android.billingclient:billing@@7.0.0 */
    public static final class Builder {
        private final Set zza = new HashSet();

        @NonNull
        public Builder addAllInAppMessageCategoriesToShow() {
            this.zza.add(2);
            return this;
        }

        @NonNull
        public Builder addInAppMessageCategoryToShow(int i) {
            this.zza.add(Integer.valueOf(i));
            return this;
        }

        @NonNull
        public InAppMessageParams build() {
            return new InAppMessageParams(this.zza, null);
        }
    }

    /* compiled from: com.android.billingclient:billing@@7.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InAppMessageCategoryId {
        public static final int TRANSACTIONAL = 2;
        public static final int UNKNOWN_IN_APP_MESSAGE_CATEGORY_ID = 0;
    }

    public /* synthetic */ InAppMessageParams(Set set, zzcn zzcnVar) {
        this.zza = new ArrayList(Collections.unmodifiableList(new ArrayList(set)));
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    public final ArrayList zza() {
        return this.zza;
    }
}
