// OBSOLETE: Google Play BillingFlowParams - No longer used. Safe to delete if not referenced.
/*
package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.ProductDetails;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
public class BillingFlowParams {

    @NonNull
    public static final String EXTRA_PARAM_KEY_ACCOUNT_ID = "accountId";
    private boolean zza;
    private String zzb;
    private String zzc;
    private SubscriptionUpdateParams zzd;
    private com.google.android.gms.internal.play_billing.zzai zze;
    private ArrayList zzf;
    private boolean zzg;

    /* compiled from: com.android.billingclient:billing@@7.0.0 */
    public static class Builder {
        private String zza;
        private String zzb;
        private List zzc;
        private ArrayList zzd;
        private boolean zze;
        private SubscriptionUpdateParams.Builder zzf;

        private Builder() {
            SubscriptionUpdateParams.Builder builderNewBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(builderNewBuilder);
            this.zzf = builderNewBuilder;
        }

        @NonNull
        public BillingFlowParams build() {
            ArrayList arrayList = this.zzd;
            boolean z = true;
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.zzc;
            boolean z3 = (list == null || list.isEmpty()) ? false : true;
            if (!z2 && !z3) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z2 && z3) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            zzca zzcaVar = null;
            if (!z2) {
                ProductDetailsParams productDetailsParams = (ProductDetailsParams) this.zzc.get(0);
                for (int i = 0; i < this.zzc.size(); i++) {
                    ProductDetailsParams productDetailsParams2 = (ProductDetailsParams) this.zzc.get(i);
                    if (productDetailsParams2 == null) {
                        throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                    }
                    if (i != 0 && !productDetailsParams2.zza().getProductType().equals(productDetailsParams.zza().getProductType()) && !productDetailsParams2.zza().getProductType().equals("play_pass_subs")) {
                        throw new IllegalArgumentException("All products should have same ProductType.");
                    }
                }
                String strZza = productDetailsParams.zza().zza();
                for (ProductDetailsParams productDetailsParams3 : this.zzc) {
                    if (!productDetailsParams.zza().getProductType().equals("play_pass_subs") && !productDetailsParams3.zza().getProductType().equals("play_pass_subs") && !strZza.equals(productDetailsParams3.zza().zza())) {
                        throw new IllegalArgumentException("All products must have the same package name.");
                    }
                }
            } else {
                if (this.zzd.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.zzd.size() > 1) {
                    SkuDetails skuDetails = (SkuDetails) this.zzd.get(0);
                    String type = skuDetails.getType();
                    ArrayList arrayList2 = this.zzd;
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        SkuDetails skuDetails2 = (SkuDetails) arrayList2.get(i2);
                        if (!type.equals("play_pass_subs") && !skuDetails2.getType().equals("play_pass_subs") && !type.equals(skuDetails2.getType())) {
                            throw new IllegalArgumentException("SKUs should have the same type.");
                        }
                    }
                    String strZzd = skuDetails.zzd();
                    ArrayList arrayList3 = this.zzd;
                    int size2 = arrayList3.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        SkuDetails skuDetails3 = (SkuDetails) arrayList3.get(i3);
                        if (!type.equals("play_pass_subs") && !skuDetails3.getType().equals("play_pass_subs") && !strZzd.equals(skuDetails3.zzd())) {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                }
            }
            BillingFlowParams billingFlowParams = new BillingFlowParams(zzcaVar);
            if ((!z2 || ((SkuDetails) this.zzd.get(0)).zzd().isEmpty()) && (!z3 || ((ProductDetailsParams) this.zzc.get(0)).zza().zza().isEmpty())) {
                z = false;
            }
            billingFlowParams.zza = z;
            billingFlowParams.zzb = this.zza;
            billingFlowParams.zzc = this.zzb;
            billingFlowParams.zzd = this.zzf.build();
            ArrayList arrayList4 = this.zzd;
            billingFlowParams.zzf = arrayList4 != null ? new ArrayList(arrayList4) : new ArrayList();
            billingFlowParams.zzg = this.zze;
            List list2 = this.zzc;
            billingFlowParams.zze = list2 != null ? com.google.android.gms.internal.play_billing.zzai.zzj(list2) : com.google.android.gms.internal.play_billing.zzai.zzk();
            return billingFlowParams;
        }

        @NonNull
        public Builder setIsOfferPersonalized(boolean z) {
            this.zze = z;
            return this;
        }

        @NonNull
        public Builder setObfuscatedAccountId(@NonNull String str) {
            this.zza = str;
            return this;
        }

        @NonNull
        public Builder setObfuscatedProfileId(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        @NonNull
        public Builder setProductDetailsParamsList(@NonNull List<ProductDetailsParams> list) {
            this.zzc = new ArrayList(list);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSkuDetails(@NonNull SkuDetails skuDetails) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(skuDetails);
            this.zzd = arrayList;
            return this;
        }

        @NonNull
        public Builder setSubscriptionUpdateParams(@NonNull SubscriptionUpdateParams subscriptionUpdateParams) {
            this.zzf = SubscriptionUpdateParams.zzb(subscriptionUpdateParams);
            return this;
        }

        public /* synthetic */ Builder(zzbv zzbvVar) {
            SubscriptionUpdateParams.Builder builderNewBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(builderNewBuilder);
            this.zzf = builderNewBuilder;
        }
    }

    /* compiled from: com.android.billingclient:billing@@7.0.0 */
    public static final class ProductDetailsParams {
        private final ProductDetails zza;

        @Nullable
        private final String zzb;

        /* compiled from: com.android.billingclient:billing@@7.0.0 */
        public static class Builder {
            private ProductDetails zza;

            @Nullable
            private String zzb;

            private Builder() {
                throw null;
            }

            public /* synthetic */ Builder(zzbw zzbwVar) {
            }

            @NonNull
            public ProductDetailsParams build() {
                com.google.android.gms.internal.play_billing.zzaa.zzc(this.zza, "ProductDetails is required for constructing ProductDetailsParams.");
                if (this.zza.getSubscriptionOfferDetails() != null) {
                    com.google.android.gms.internal.play_billing.zzaa.zzc(this.zzb, "offerToken is required for constructing ProductDetailsParams for subscriptions.");
                }
                return new ProductDetailsParams(this, null);
            }

            @NonNull
            public Builder setOfferToken(@NonNull String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("offerToken can not be empty");
                }
                this.zzb = str;
                return this;
            }

            @NonNull
            public Builder setProductDetails(@NonNull ProductDetails productDetails) {
                this.zza = productDetails;
                if (productDetails.getOneTimePurchaseOfferDetails() != null) {
                    productDetails.getOneTimePurchaseOfferDetails().getClass();
                    ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                    if (oneTimePurchaseOfferDetails.zza() != null) {
                        this.zzb = oneTimePurchaseOfferDetails.zza();
                    }
                }
                return this;
            }
        }

        public /* synthetic */ ProductDetailsParams(Builder builder, zzbx zzbxVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
        }

        @NonNull
        public static Builder newBuilder() {
            return new Builder(null);
        }

        @NonNull
        public final ProductDetails zza() {
            return this.zza;
        }

        @Nullable
        public final String zzb() {
            return this.zzb;
        }
    }

    /* compiled from: com.android.billingclient:billing@@7.0.0 */
    public static class SubscriptionUpdateParams {
        private String zza;
        private String zzb;
        private int zzc = 0;

        /* compiled from: com.android.billingclient:billing@@7.0.0 */
        public static class Builder {
            private String zza;
            private String zzb;
            private boolean zzc;
            private int zzd = 0;

            private Builder() {
            }

            public /* synthetic */ Builder(zzby zzbyVar) {
            }

            public static /* synthetic */ Builder zza(Builder builder) {
                builder.zzc = true;
                return builder;
            }

            @NonNull
            public SubscriptionUpdateParams build() {
                zzbz zzbzVar = null;
                boolean z = (TextUtils.isEmpty(this.zza) && TextUtils.isEmpty(null)) ? false : true;
                boolean zIsEmpty = true ^ TextUtils.isEmpty(this.zzb);
                if (z && zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.zzc && !z && !zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                SubscriptionUpdateParams subscriptionUpdateParams = new SubscriptionUpdateParams(zzbzVar);
                subscriptionUpdateParams.zza = this.zza;
                subscriptionUpdateParams.zzc = this.zzd;
                subscriptionUpdateParams.zzb = this.zzb;
                return subscriptionUpdateParams;
            }

            @NonNull
            public Builder setOldPurchaseToken(@NonNull String str) {
                this.zza = str;
                return this;
            }

            @NonNull
            @zzf
            public Builder setOriginalExternalTransactionId(@NonNull String str) {
                this.zzb = str;
                return this;
            }

            @NonNull
            public Builder setSubscriptionReplacementMode(int i) {
                this.zzd = i;
                return this;
            }

            @NonNull
            @Deprecated
            public final Builder zzb(@NonNull String str) {
                this.zza = str;
                return this;
            }
        }

        /* compiled from: com.android.billingclient:billing@@7.0.0 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface ReplacementMode {
            public static final int CHARGE_FULL_PRICE = 5;
            public static final int CHARGE_PRORATED_PRICE = 2;
            public static final int DEFERRED = 6;
            public static final int UNKNOWN_REPLACEMENT_MODE = 0;
            public static final int WITHOUT_PRORATION = 3;
            public static final int WITH_TIME_PRORATION = 1;
        }

        private SubscriptionUpdateParams() {
        }

        public /* synthetic */ SubscriptionUpdateParams(zzbz zzbzVar) {
        }

        @NonNull
        public static Builder newBuilder() {
            return new Builder(null);
        }

        public static /* bridge */ /* synthetic */ Builder zzb(SubscriptionUpdateParams subscriptionUpdateParams) {
            Builder builderNewBuilder = newBuilder();
            builderNewBuilder.zzb(subscriptionUpdateParams.zza);
            builderNewBuilder.setSubscriptionReplacementMode(subscriptionUpdateParams.zzc);
            builderNewBuilder.setOriginalExternalTransactionId(subscriptionUpdateParams.zzb);
            return builderNewBuilder;
        }

        public final int zza() {
            return this.zzc;
        }

        public final String zzc() {
            return this.zza;
        }

        public final String zzd() {
            return this.zzb;
        }
    }

    private BillingFlowParams() {
        throw null;
    }

    public /* synthetic */ BillingFlowParams(zzca zzcaVar) {
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder(null);
    }

    public final int zza() {
        return this.zzd.zza();
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    @Nullable
    public final String zzc() {
        return this.zzc;
    }

    @Nullable
    public final String zzd() {
        return this.zzd.zzc();
    }

    @Nullable
    public final String zze() {
        return this.zzd.zzd();
    }

    @NonNull
    public final ArrayList zzf() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzf);
        return arrayList;
    }

    @NonNull
    public final List zzg() {
        return this.zze;
    }

    public final boolean zzo() {
        return this.zzg;
    }

    public final boolean zzp() {
        return (this.zzb == null && this.zzc == null && this.zzd.zzd() == null && this.zzd.zza() == 0 && !this.zza && !this.zzg) ? false : true;
    }
}
*/
