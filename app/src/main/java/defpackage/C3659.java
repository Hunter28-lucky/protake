package defpackage;

import com.android.billingclient.api.Purchase;
import com.blink.academy.film.netbean.CacheHuaweiBean;
import com.blink.academy.film.netbean.CachePlayStoreBean;
import com.blink.academy.film.support.pay.google.VerifyBillingBean;
import com.google.gson.Gson;
import java.util.ArrayList;

/* compiled from: LocalSubsInfoManager.java */
/* renamed from: ܗ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3659 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C3659 f12676;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public CachePlayStoreBean f12677;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public CacheHuaweiBean f12678;

    public C3659() {
        String strM9569 = C2618.m9569("local_sub_pus_sp", "");
        String strM95692 = C2618.m9569("local_sub_id_sp", "");
        int iM9566 = C2618.m9566("local_sub_date_sp", 0);
        boolean zM9565 = C2618.m9565("local_sub_pro_sp", false);
        if (r1.m8143(strM95692) && r1.m8143(strM9569)) {
            CachePlayStoreBean cachePlayStoreBean = new CachePlayStoreBean();
            this.f12677 = cachePlayStoreBean;
            cachePlayStoreBean.setSubsId(strM95692);
            this.f12677.setSubscription_expire_time(iM9566);
            this.f12677.setSubscription_is_valid(zM9565);
            this.f12677.setPurchase((Purchase) new Gson().fromJson(strM9569, Purchase.class));
        }
        String strM95693 = C2618.m9569("local_sub_huawei_data_sp", "");
        String strM95694 = C2618.m9569("local_sub_huawei_sig_sp", "");
        String strM95695 = C2618.m9569("local_sub_huawei_id_sp", "");
        if (r1.m8143(strM95695) && r1.m8143(strM95693) && r1.m8143(strM95694)) {
            CacheHuaweiBean cacheHuaweiBean = new CacheHuaweiBean();
            this.f12678 = cacheHuaweiBean;
            cacheHuaweiBean.setSubsId(strM95695);
            this.f12678.setSubscription_expire_time(iM9566);
            this.f12678.setSubscription_is_valid(zM9565);
            this.f12678.setInAppPurchaseData(strM95693);
            this.f12678.setInAppSignature(strM95694);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static C3659 m11744() {
        if (f12676 == null) {
            synchronized (C3659.class) {
                if (f12676 == null) {
                    f12676 = new C3659();
                }
            }
        }
        return f12676;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m11745(int i) {
        if (i == 1 || i == 0) {
            C2618.m9573("local_sub_pus_sp", "");
            C2618.m9573("local_sub_id_sp", "");
            if (this.f12677 != null) {
                C2618.m9571("local_sub_date_sp", 0);
                C2618.m9570("local_sub_pro_sp", false);
            }
            this.f12677 = null;
        }
        if (i == 2 || i == 0) {
            C2618.m9573("local_sub_huawei_data_sp", "");
            C2618.m9573("local_sub_huawei_data_sp", "");
            C2618.m9573("local_sub_huawei_id_sp", "");
            if (this.f12678 != null) {
                C2618.m9571("local_sub_date_sp", 0);
                C2618.m9570("local_sub_pro_sp", false);
            }
            this.f12678 = null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public CacheHuaweiBean m11746() {
        return this.f12678;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public CachePlayStoreBean m11747() {
        return this.f12677;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int m11748() {
        CachePlayStoreBean cachePlayStoreBean = this.f12677;
        if (cachePlayStoreBean != null) {
            return cachePlayStoreBean.getSubscription_expire_time();
        }
        CacheHuaweiBean cacheHuaweiBean = this.f12678;
        if (cacheHuaweiBean != null) {
            return cacheHuaweiBean.getSubscription_expire_time();
        }
        return 0;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String m11749(int i) {
        CacheHuaweiBean cacheHuaweiBean;
        if (i == 0) {
            CachePlayStoreBean cachePlayStoreBean = this.f12677;
            if (cachePlayStoreBean != null && cachePlayStoreBean.getPurchase() != null) {
                VerifyBillingBean verifyBillingBean = new VerifyBillingBean();
                Purchase purchase = this.f12677.getPurchase();
                String originalJson = purchase.getOriginalJson();
                verifyBillingBean.setSignature(purchase.getSignature());
                verifyBillingBean.setSignedData(originalJson);
                verifyBillingBean.setUuid(e5.m5988().m5991());
                ArrayList arrayList = new ArrayList();
                arrayList.add(verifyBillingBean);
                return new Gson().toJson(arrayList);
            }
        } else if (i == 1 && (cacheHuaweiBean = this.f12678) != null && r1.m8143(cacheHuaweiBean.getInAppPurchaseData()) && r1.m8143(this.f12678.getInAppSignature())) {
            VerifyBillingBean verifyBillingBean2 = new VerifyBillingBean();
            verifyBillingBean2.setSignature(this.f12678.getInAppSignature());
            verifyBillingBean2.setSignedData(this.f12678.getInAppPurchaseData());
            verifyBillingBean2.setUuid(e5.m5988().m5991());
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(verifyBillingBean2);
            return new Gson().toJson(arrayList2);
        }
        return "";
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m11750() {
        CachePlayStoreBean cachePlayStoreBean = this.f12677;
        if (cachePlayStoreBean != null) {
            return cachePlayStoreBean.isSubscription_is_valid();
        }
        CacheHuaweiBean cacheHuaweiBean = this.f12678;
        if (cacheHuaweiBean != null) {
            return cacheHuaweiBean.isSubscription_is_valid();
        }
        return false;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m11751(int i) {
        if (i != 0) {
            if (i == 1) {
                CachePlayStoreBean cachePlayStoreBean = this.f12677;
                if (cachePlayStoreBean != null) {
                    cachePlayStoreBean.setSubscription_expire_time(C2618.m9566("local_sub_date_sp", 0));
                    this.f12677.setSubscription_is_valid(C2618.m9565("local_sub_pro_sp", false));
                }
                CacheHuaweiBean cacheHuaweiBean = this.f12678;
                if (cacheHuaweiBean != null) {
                    cacheHuaweiBean.setSubscription_expire_time(C2618.m9566("local_sub_date_sp", 0));
                    this.f12678.setSubscription_is_valid(C2618.m9565("local_sub_pro_sp", false));
                    return;
                }
                return;
            }
            return;
        }
        String strM9569 = C2618.m9569("local_sub_pus_sp", "");
        String strM95692 = C2618.m9569("local_sub_id_sp", "");
        if (r1.m8143(strM9569) && r1.m8143(strM95692)) {
            if (this.f12677 == null) {
                this.f12677 = new CachePlayStoreBean();
            }
            this.f12677.setSubsId(strM95692);
            this.f12677.setPurchase((Purchase) new Gson().fromJson(strM9569, Purchase.class));
            return;
        }
        String strM95693 = C2618.m9569("local_sub_huawei_id_sp", "");
        String strM95694 = C2618.m9569("local_sub_huawei_data_sp", "");
        String strM95695 = C2618.m9569("local_sub_huawei_sig_sp", "");
        if (!r1.m8143(strM95693) || !r1.m8143(strM95694) || !r1.m8143(strM95695)) {
            m11745(0);
            return;
        }
        if (this.f12678 == null) {
            this.f12678 = new CacheHuaweiBean();
        }
        this.f12678.setSubsId(strM95693);
        this.f12678.setInAppSignature(strM95695);
        this.f12678.setInAppPurchaseData(strM95694);
    }
}
