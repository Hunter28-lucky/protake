// TODO: REMOVE - This class is now a stub. All billing logic removed. Safe to delete after confirming no references remain.
package com.blink.academy.film.support.pay.google;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Refactored: All billing/subscription logic is bypassed. User is always premium.
public class BillingManager implements com.android.billingclient.api.PurchasesUpdatedListener {
    public static final int BILLING_MANAGER_NOT_INITIALIZED = -1;
    private static final String TAG = "BillingManager";
    private Activity mActivity;
    private final BillingUpdatesListener mBillingUpdatesListener;
    private boolean mIsServiceConnected = true;
    private String mSkuId;
    private Set<String> mTokensToBeConsumed;
    private boolean verbose = false;
    private int mBillingClientResponseCode = 0;

    public interface BillingUpdatesListener {
        void onBillingClientSetupFailed();
        void onBillingClientSetupFinished();
        void onConsumeFinished(String str, int i);
        void onPurchaseItemAlreadyOwned(String str);
        void onPurchaseQueryFinished(String str, Object purchase);
        void onPurchasesCanceled(String str);
        void onPurchasesFailed(String str, int i);
        void onPurchasesFinished(String str, List<Object> list);
    }

    public interface OnSupportEnable {
        void onDisable();
        void onEnable();
    }

    public interface ServiceConnectedListener {
        void onServiceConnected(int i);
    }

    public BillingManager(Activity activity, BillingUpdatesListener billingUpdatesListener) {
        this.mActivity = activity;
        this.mBillingUpdatesListener = billingUpdatesListener != null ? billingUpdatesListener : new BillingUpdatesListener() {
            @Override public void onBillingClientSetupFailed() {}
            @Override public void onBillingClientSetupFinished() {}
            @Override public void onConsumeFinished(String str, int i) {}
            @Override public void onPurchaseItemAlreadyOwned(String str) {}
            @Override public void onPurchaseQueryFinished(String str, Object purchase) {}
            @Override public void onPurchasesCanceled(String str) {}
            @Override public void onPurchasesFailed(String str, int i) {}
            @Override public void onPurchasesFinished(String str, List<Object> list) {}
        };
    }

    // Always return true for subscription support
    public boolean areSubscriptionsSupported() {
        return true;
    }

    // Simulate successful purchase query
    public void queryPurchases(final String str) {
        if (mBillingUpdatesListener != null) {
            // Simulate a successful purchase with a fake object or empty list
            mBillingUpdatesListener.onPurchasesFinished(str, new ArrayList<>());
        }
    }

    // Simulate successful purchase query (overload)
    public void queryPurchases(boolean z, Object interfaceC4886) {
        if (interfaceC4886 != null) {
            try {
                interfaceC4886.getClass().getMethod("onQueryPurchases", List.class)
                    .invoke(interfaceC4886, new ArrayList<>());
            } catch (Exception ignored) {}
        }
    }

    // Simulate successful consume
    public void consumeAsync(final String str) {
        if (mBillingUpdatesListener != null) {
            mBillingUpdatesListener.onConsumeFinished(str, 0);
        }
    }

    public void destroy() {
        // No-op
        this.mActivity = null;
    }

    public int getBillingClientResponseCode() {
        return 0;
    }

    public Context getContext() {
        return this.mActivity;
    }

    // Simulate successful purchase handling
    public void handlePurchase(Object purchase, final List<Object> list) {
        if (mBillingUpdatesListener != null) {
            mBillingUpdatesListener.onPurchasesFinished(mSkuId, list);
        }
    }

    // Simulate purchase flow: always success
    public void initiatePurchaseFlow(String str, String str2) {
        this.mSkuId = str;
        if (mBillingUpdatesListener != null) {
            mBillingUpdatesListener.onPurchasesFinished(str, new ArrayList<>());
        }
    }

    // Simulate purchase flow: always success
    private void initiatePurchaseFlow(final String str, ArrayList<String> arrayList, final String str2) {
        this.mSkuId = str;
        if (mBillingUpdatesListener != null) {
            mBillingUpdatesListener.onPurchasesFinished(str, new ArrayList<>());
        }
    }

    // Always call onEnable for support
    public void supportEnable(OnSupportEnable onSupportEnable) {
        if (onSupportEnable != null) {
            onSupportEnable.onEnable();
        }
    }

    // Always simulate successful purchase update
    @Override
    public void onPurchasesUpdated(Object billingResult, @Nullable List<Object> list) {
        if (mBillingUpdatesListener != null) {
            mBillingUpdatesListener.onPurchasesFinished(mSkuId, list != null ? list : new ArrayList<>());
        }
    }
}
