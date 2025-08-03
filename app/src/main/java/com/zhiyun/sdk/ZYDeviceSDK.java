package com.zhiyun.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.polidea.rxandroidble2.ClientComponent;
import com.zhiyun.sdk.exception.UninitializedException;
import com.zhiyun.sdk.util.AssetUtil;
import defpackage.db;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ZYDeviceSDK {

    @SuppressLint({"StaticFieldLeak"})
    private static ZYDeviceSDK sInstance;
    private String appId;
    private String cert;
    private final Context context;
    private String key;

    static {
        System.loadLibrary(ClientComponent.PlatformConstants.INT_DEVICE_SDK);
    }

    private ZYDeviceSDK(@NonNull Context context) {
        this(context, null, null, null);
    }

    public static ZYDeviceSDK getInstance() {
        ZYDeviceSDK zYDeviceSDK = sInstance;
        if (zYDeviceSDK != null) {
            return zYDeviceSDK;
        }
        throw new UninitializedException("Did not perform initialization! ");
    }

    public static void init(@NonNull Context context, String str, String str2, String str3) {
        sInstance = new ZYDeviceSDK(context.getApplicationContext(), str, str2, str3);
    }

    public String getAppId() {
        return this.appId;
    }

    public String getCert() {
        return this.cert;
    }

    public Context getContext() {
        return this.context;
    }

    public String getKey() {
        return this.key;
    }

    private ZYDeviceSDK(@NonNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (context == null) {
            throw new NullPointerException("context cannot be null ");
        }
        this.context = context.getApplicationContext();
        this.appId = str;
        this.key = str2;
        this.cert = str3;
    }

    public static void init(@NonNull Context context, String str) throws Throwable {
        sInstance = new ZYDeviceSDK(context.getApplicationContext());
        try {
            String strLoad = AssetUtil.load(context, str);
            if (strLoad != null) {
                JSONObject jSONObject = new JSONObject(strLoad);
                sInstance.appId = jSONObject.getString("appid");
                sInstance.key = jSONObject.getString("secret");
                sInstance.cert = jSONObject.getString("certificate");
            }
        } catch (JSONException unused) {
            db.m5935("Certificate parsing failed. ");
        }
    }
}
