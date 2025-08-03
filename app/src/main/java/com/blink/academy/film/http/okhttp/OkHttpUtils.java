package com.blink.academy.film.http.okhttp;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.blink.academy.film.http.okhttp.cache.RxCache;
import com.blink.academy.film.http.okhttp.cache.converter.IDiskConverter;
import com.blink.academy.film.http.okhttp.cache.converter.SerializableDiskConverter;
import com.blink.academy.film.http.okhttp.cache.model.CacheMode;
import com.blink.academy.film.http.okhttp.cookie.CookieManger;
import com.blink.academy.film.http.okhttp.https.HttpsUtils;
import com.blink.academy.film.http.okhttp.interceptor.HttpLoggingInterceptor;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.blink.academy.film.http.okhttp.model.HttpParams;
import com.blink.academy.film.http.okhttp.request.CustomRequest;
import com.blink.academy.film.http.okhttp.request.DeleteRequest;
import com.blink.academy.film.http.okhttp.request.DownloadRequest;
import com.blink.academy.film.http.okhttp.request.GetRequest;
import com.blink.academy.film.http.okhttp.request.PostRequest;
import com.blink.academy.film.http.okhttp.request.PutRequest;
import com.blink.academy.film.http.okhttp.utils.RxUtil;
import com.blink.academy.film.http.okhttp.utils.Utils;
import defpackage.C3661;
import defpackage.C4638;
import defpackage.C5121;
import defpackage.C5198;
import defpackage.InterfaceC2818;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5054;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes.dex */
public final class OkHttpUtils {
    public static final int DEFAULT_CACHE_NEVER_EXPIRE = -1;
    public static final int DEFAULT_MILLISECONDS = 60000;
    private static final int DEFAULT_RETRY_COUNT = 3;
    private static final int DEFAULT_RETRY_DELAY = 500;
    private static final int DEFAULT_RETRY_INCREASEDELAY = 0;
    private static Application sContext;
    private static volatile OkHttpUtils singleton;
    private CookieManger cookieJar;
    private String mBaseUrl;
    private File mCacheDirectory;
    private long mCacheMaxSize;
    private HttpHeaders mCommonHeaders;
    private HttpParams mCommonParams;
    private C5121.C5122 okHttpClientBuilder;
    private Retrofit.Builder retrofitBuilder;
    private RxCache.Builder rxCacheBuilder;
    private C3661 mCache = null;
    private CacheMode mCacheMode = CacheMode.NO_CACHE;
    private long mCacheTime = -1;
    private int mRetryCount = 3;
    private int mRetryDelay = DEFAULT_RETRY_DELAY;
    private int mRetryIncreaseDelay = 0;

    public class DefaultHostnameVerifier implements HostnameVerifier {
        public DefaultHostnameVerifier() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.OkHttpUtils$Ϳ, reason: contains not printable characters */
    public class C0362 implements InterfaceC2857<Boolean> {
        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Boolean bool) throws Exception {
            C4638.m14103("clearCache success!!!");
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.OkHttpUtils$Ԩ, reason: contains not printable characters */
    public class C0363 implements InterfaceC2857<Throwable> {
        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            C4638.m14103("clearCache err!!!");
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.OkHttpUtils$Ԫ, reason: contains not printable characters */
    public class C0364 implements InterfaceC2857<Boolean> {
        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Boolean bool) throws Exception {
            C4638.m14103("removeCache success!!!");
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.OkHttpUtils$Ԭ, reason: contains not printable characters */
    public class C0365 implements InterfaceC2857<Throwable> {
        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            C4638.m14103("removeCache err!!!");
        }
    }

    private OkHttpUtils() {
        C5121.C5122 c5122 = new C5121.C5122();
        this.okHttpClientBuilder = c5122;
        c5122.m15022(new DefaultHostnameVerifier());
        C5121.C5122 c51222 = this.okHttpClientBuilder;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c51222.m14988(60000L, timeUnit);
        this.okHttpClientBuilder.m15025(60000L, timeUnit);
        this.okHttpClientBuilder.m15027(60000L, timeUnit);
        this.retrofitBuilder = new Retrofit.Builder();
        this.rxCacheBuilder = new RxCache.Builder().init(sContext).diskConverter(new SerializableDiskConverter());
    }

    public static void cancelSubscription(InterfaceC4478 interfaceC4478) {
        if (interfaceC4478 == null || interfaceC4478.isDisposed()) {
            return;
        }
        interfaceC4478.dispose();
    }

    public static void clearCache() {
        getRxCache().clear().compose(RxUtil.io_main()).subscribe(new C0362(), new C0363());
    }

    public static CustomRequest custom() {
        return new CustomRequest();
    }

    public static DeleteRequest delete(String str) {
        return new DeleteRequest(str);
    }

    public static DownloadRequest downLoad(String str) {
        return new DownloadRequest(str);
    }

    public static GetRequest get(String str) {
        return new GetRequest(str);
    }

    public static String getBaseUrl() {
        return getInstance().mBaseUrl;
    }

    public static File getCacheDirectory() {
        return getInstance().mCacheDirectory;
    }

    public static long getCacheMaxSize() {
        return getInstance().mCacheMaxSize;
    }

    public static CacheMode getCacheMode() {
        return getInstance().mCacheMode;
    }

    public static long getCacheTime() {
        return getInstance().mCacheTime;
    }

    public static Context getContext() {
        testInitialize();
        return sContext;
    }

    public static CookieManger getCookieJar() {
        return getInstance().cookieJar;
    }

    public static C3661 getHttpCache() {
        return getInstance().mCache;
    }

    public static OkHttpUtils getInstance() {
        testInitialize();
        if (singleton == null) {
            synchronized (OkHttpUtils.class) {
                if (singleton == null) {
                    singleton = new OkHttpUtils();
                }
            }
        }
        return singleton;
    }

    public static C5121 getOkHttpClient() {
        return getInstance().okHttpClientBuilder.m14986();
    }

    public static C5121.C5122 getOkHttpClientBuilder() {
        return getInstance().okHttpClientBuilder;
    }

    public static Retrofit getRetrofit() {
        return getInstance().retrofitBuilder.build();
    }

    public static Retrofit.Builder getRetrofitBuilder() {
        return getInstance().retrofitBuilder;
    }

    public static int getRetryCount() {
        return getInstance().mRetryCount;
    }

    public static int getRetryDelay() {
        return getInstance().mRetryDelay;
    }

    public static int getRetryIncreaseDelay() {
        return getInstance().mRetryIncreaseDelay;
    }

    public static RxCache getRxCache() {
        return getInstance().rxCacheBuilder.build();
    }

    public static RxCache.Builder getRxCacheBuilder() {
        return getInstance().rxCacheBuilder;
    }

    public static void init(Application application) {
        sContext = application;
    }

    public static PostRequest post(String str) {
        return new PostRequest(str);
    }

    public static PutRequest put(String str) {
        return new PutRequest(str);
    }

    public static void removeCache(String str) {
        getRxCache().remove(str).compose(RxUtil.io_main()).subscribe(new C0364(), new C0365());
    }

    private static void testInitialize() {
        if (sContext == null) {
            throw new ExceptionInInitializerError("请先在全局Application中调用 EasyHttp.init() 初始化！");
        }
    }

    public OkHttpUtils addCallAdapterFactory(CallAdapter.Factory factory) {
        this.retrofitBuilder.addCallAdapterFactory((CallAdapter.Factory) Utils.checkNotNull(factory, "factory == null"));
        return this;
    }

    public OkHttpUtils addCommonHeaders(HttpHeaders httpHeaders) {
        if (this.mCommonHeaders == null) {
            this.mCommonHeaders = new HttpHeaders();
        }
        this.mCommonHeaders.put(httpHeaders);
        return this;
    }

    public OkHttpUtils addCommonParams(HttpParams httpParams) {
        if (this.mCommonParams == null) {
            this.mCommonParams = new HttpParams();
        }
        this.mCommonParams.put(httpParams);
        return this;
    }

    public OkHttpUtils addConverterFactory(Converter.Factory factory) {
        this.retrofitBuilder.addConverterFactory((Converter.Factory) Utils.checkNotNull(factory, "factory == null"));
        return this;
    }

    public OkHttpUtils addInterceptor(InterfaceC2818 interfaceC2818) {
        this.okHttpClientBuilder.m14984((InterfaceC2818) Utils.checkNotNull(interfaceC2818, "interceptor == null"));
        return this;
    }

    public OkHttpUtils addNetworkInterceptor(InterfaceC2818 interfaceC2818) {
        this.okHttpClientBuilder.m14985((InterfaceC2818) Utils.checkNotNull(interfaceC2818, "interceptor == null"));
        return this;
    }

    public OkHttpUtils debug(String str) {
        debug(str, true);
        return this;
    }

    public HttpHeaders getCommonHeaders() {
        return this.mCommonHeaders;
    }

    public HttpParams getCommonParams() {
        return this.mCommonParams;
    }

    public OkHttpUtils setBaseUrl(String str) {
        this.mBaseUrl = (String) Utils.checkNotNull(str, "baseUrl == null");
        return this;
    }

    public OkHttpUtils setCacheDirectory(File file) {
        this.mCacheDirectory = (File) Utils.checkNotNull(file, "directory == null");
        this.rxCacheBuilder.diskDir(file);
        return this;
    }

    public OkHttpUtils setCacheDiskConverter(IDiskConverter iDiskConverter) {
        this.rxCacheBuilder.diskConverter((IDiskConverter) Utils.checkNotNull(iDiskConverter, "converter == null"));
        return this;
    }

    public OkHttpUtils setCacheMaxSize(long j) {
        this.mCacheMaxSize = j;
        return this;
    }

    public OkHttpUtils setCacheMode(CacheMode cacheMode) {
        this.mCacheMode = cacheMode;
        return this;
    }

    public OkHttpUtils setCacheTime(long j) {
        if (j <= -1) {
            j = -1;
        }
        this.mCacheTime = j;
        return this;
    }

    public OkHttpUtils setCacheVersion(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("cacheersion must > 0");
        }
        this.rxCacheBuilder.appVersion(i);
        return this;
    }

    public OkHttpUtils setCallFactory(InterfaceC5054.InterfaceC5055 interfaceC5055) {
        this.retrofitBuilder.callFactory((InterfaceC5054.InterfaceC5055) Utils.checkNotNull(interfaceC5055, "factory == null"));
        return this;
    }

    public OkHttpUtils setCallbackExecutor(Executor executor) {
        this.retrofitBuilder.callbackExecutor((Executor) Utils.checkNotNull(executor, "executor == null"));
        return this;
    }

    public OkHttpUtils setCertificates(InputStream... inputStreamArr) throws UnrecoverableKeyException, NoSuchAlgorithmException, IOException, CertificateException, KeyManagementException {
        HttpsUtils.SSLParams sslSocketFactory = HttpsUtils.getSslSocketFactory(null, null, inputStreamArr);
        this.okHttpClientBuilder.m15026(sslSocketFactory.sSLSocketFactory, sslSocketFactory.trustManager);
        return this;
    }

    public OkHttpUtils setConnectTimeout(long j) {
        this.okHttpClientBuilder.m14988(j, TimeUnit.MILLISECONDS);
        return this;
    }

    public OkHttpUtils setCookieStore(CookieManger cookieManger) {
        this.cookieJar = cookieManger;
        this.okHttpClientBuilder.m14990(cookieManger);
        return this;
    }

    public OkHttpUtils setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.okHttpClientBuilder.m15022(hostnameVerifier);
        return this;
    }

    public OkHttpUtils setHttpCache(C3661 c3661) {
        this.mCache = c3661;
        return this;
    }

    public OkHttpUtils setOkclient(C5121 c5121) {
        this.retrofitBuilder.client((C5121) Utils.checkNotNull(c5121, "client == null"));
        return this;
    }

    public OkHttpUtils setOkconnectionPool(C5198 c5198) {
        this.okHttpClientBuilder.m14989((C5198) Utils.checkNotNull(c5198, "connectionPool == null"));
        return this;
    }

    public OkHttpUtils setOkproxy(Proxy proxy) {
        this.okHttpClientBuilder.m15024((Proxy) Utils.checkNotNull(proxy, "proxy == null"));
        return this;
    }

    public OkHttpUtils setReadTimeOut(long j) {
        this.okHttpClientBuilder.m15025(j, TimeUnit.MILLISECONDS);
        return this;
    }

    public OkHttpUtils setRetryCount(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("retryCount must > 0");
        }
        this.mRetryCount = i;
        return this;
    }

    public OkHttpUtils setRetryDelay(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("retryDelay must > 0");
        }
        this.mRetryDelay = i;
        return this;
    }

    public OkHttpUtils setRetryIncreaseDelay(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("retryIncreaseDelay must > 0");
        }
        this.mRetryIncreaseDelay = i;
        return this;
    }

    public OkHttpUtils setWriteTimeOut(long j) {
        this.okHttpClientBuilder.m15027(j, TimeUnit.MILLISECONDS);
        return this;
    }

    public OkHttpUtils debug(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = "RxEasyHttp_";
        }
        if (z) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(str, z);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            this.okHttpClientBuilder.m14984(httpLoggingInterceptor);
        }
        return this;
    }

    public OkHttpUtils setCertificates(InputStream inputStream, String str, InputStream... inputStreamArr) throws UnrecoverableKeyException, NoSuchAlgorithmException, IOException, CertificateException, KeyManagementException {
        HttpsUtils.SSLParams sslSocketFactory = HttpsUtils.getSslSocketFactory(inputStream, str, inputStreamArr);
        this.okHttpClientBuilder.m15026(sslSocketFactory.sSLSocketFactory, sslSocketFactory.trustManager);
        return this;
    }
}
