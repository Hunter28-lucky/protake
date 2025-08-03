package com.blink.academy.film.support.pay.huawei;

import android.app.Activity;
import android.os.Build;
import com.blink.academy.film.FilmApp;
import com.google.gson.Gson;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.C4665;
import defpackage.C5213;
import defpackage.InterfaceC4183;
import defpackage.InterfaceC4533;
import defpackage.e5;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class HuaweiPay implements InterfaceC4183 {
    private Activity activity;
    private InterfaceC4533 mCallback;
    private String mId;

    public HuaweiPay(Activity activity) {
        this.activity = activity;
    }

    public static String generateHuaweiJson(String str, String str2, String str3, String str4) {
        UploadHuaweiBean uploadHuaweiBean = new UploadHuaweiBean();
        uploadHuaweiBean.setAccess_token(str2);
        uploadHuaweiBean.setCurrent_user_id(str);
        ArrayList arrayList = new ArrayList();
        HuaweiPurchaseBean huaweiPurchaseBean = new HuaweiPurchaseBean();
        huaweiPurchaseBean.setSignature(str4);
        huaweiPurchaseBean.setSignedData(str3);
        arrayList.add(huaweiPurchaseBean);
        uploadHuaweiBean.setHms_purchases(arrayList);
        String str5 = Build.VERSION.RELEASE;
        uploadHuaweiBean.setOSVersion(str5);
        uploadHuaweiBean.setUuid(e5.m5988().m5991());
        uploadHuaweiBean.setPlatform_type(AnalyticsConstants.SDK_TYPE);
        uploadHuaweiBean.setPlatform_version(str5);
        uploadHuaweiBean.setPlatform_locale(C5213.m15206());
        uploadHuaweiBean.setApp_version("3.0.17");
        uploadHuaweiBean.setApp_build(String.valueOf(130));
        uploadHuaweiBean.setDevice_manufacturer(Build.MANUFACTURER);
        uploadHuaweiBean.setDevice_model(Build.MODEL);
        uploadHuaweiBean.setA_sha(C4665.m14153(FilmApp.m402(), FilmApp.m402().getOpPackageName(), "SHA1"));
        return new Gson().toJson(uploadHuaweiBean);
    }

    public void cancelPay() {
        InterfaceC4533 interfaceC4533 = this.mCallback;
        if (interfaceC4533 != null) {
            interfaceC4533.mo13876(this.mId, "cancel");
        }
    }

    @Override // defpackage.InterfaceC4183
    public void destroy() {
        this.activity = null;
    }

    @Override // defpackage.InterfaceC4183
    public void startPay(String str, InterfaceC4533 interfaceC4533, boolean z, boolean z2) {
    }
}
