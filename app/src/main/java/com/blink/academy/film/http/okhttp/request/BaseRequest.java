package com.blink.academy.film.http.okhttp.request;

import android.content.Context;
import android.text.TextUtils;
import com.blink.academy.film.http.okhttp.OkHttpUtils;
import com.blink.academy.film.http.okhttp.api.APIService;
import com.blink.academy.film.http.okhttp.cache.RxCache;
import com.blink.academy.film.http.okhttp.cache.converter.IDiskConverter;
import com.blink.academy.film.http.okhttp.cache.model.CacheMode;
import com.blink.academy.film.http.okhttp.https.HttpsUtils;
import com.blink.academy.film.http.okhttp.interceptor.BaseDynamicInterceptor;
import com.blink.academy.film.http.okhttp.interceptor.CacheInterceptor;
import com.blink.academy.film.http.okhttp.interceptor.CacheInterceptorOffline;
import com.blink.academy.film.http.okhttp.interceptor.HeadersInterceptor;
import com.blink.academy.film.http.okhttp.interceptor.NoCacheInterceptor;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.blink.academy.film.http.okhttp.model.HttpParams;
import com.blink.academy.film.http.okhttp.request.BaseRequest;
import com.blink.academy.film.http.okhttp.utils.HttpUtil;
import com.blink.academy.film.http.okhttp.utils.RxUtil;
import com.blink.academy.film.http.okhttp.utils.Utils;
import com.blink.academy.film.support.controller.LoginController;
import com.blink.academy.film.support.controller.StoreController;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.StringUtil;
import defpackage.AbstractC2613;
import defpackage.AbstractC4262;
import defpackage.AbstractC4809;
import defpackage.C2314;
import defpackage.C2632;
import defpackage.C3135;
import defpackage.C3573;
import defpackage.C3661;
import defpackage.C4539;
import defpackage.C4638;
import defpackage.C4770;
import defpackage.C5121;
import defpackage.InterfaceC2818;
import defpackage.InterfaceC2857;
import defpackage.r1;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import okio.Buffer;
import org.jcodec.platform.Platform;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* loaded from: classes.dex */
public abstract class BaseRequest<R extends BaseRequest> {
    private static final Charset UTF8 = Charset.forName(Platform.UTF_8);
    public APIService apiManager;
    public String baseUrl;
    public C3661 cache;
    public String cacheKey;
    public CacheMode cacheMode;
    public long cacheTime;
    public long connectTimeout;
    public Context context;
    public IDiskConverter diskConverter;
    public HostnameVerifier hostnameVerifier;
    public C3573 httpUrl;
    public final List<InterfaceC2818> interceptors;
    public boolean isSyncRequest;
    public C5121 okHttpClient;
    public Proxy proxy;
    public long readTimeOut;
    public Retrofit retrofit;
    public int retryCount;
    public int retryDelay;
    public int retryIncreaseDelay;
    public RxCache rxCache;
    public HttpsUtils.SSLParams sslParams;
    public String url;
    public long writeTimeOut;
    public List<C2632> cookies = new ArrayList();
    public final List<InterfaceC2818> networkInterceptors = new ArrayList();
    public HttpHeaders headers = new HttpHeaders();
    public HttpParams params = new HttpParams();
    private boolean sign = false;
    private boolean timeStamp = false;
    private boolean accessToken = false;
    public List<Converter.Factory> converterFactories = new ArrayList();
    public List<CallAdapter.Factory> adapterFactories = new ArrayList();

    /* renamed from: com.blink.academy.film.http.okhttp.request.BaseRequest$Ϳ, reason: contains not printable characters */
    public class C0396 implements InterfaceC2818 {
        public C0396() {
        }

        @Override // defpackage.InterfaceC2818
        public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
            return interfaceC2819.mo10160(BaseRequest.getSignedRequest(interfaceC2819));
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.BaseRequest$Ԩ, reason: contains not printable characters */
    public class C0397 implements InterfaceC2857<Boolean> {
        public C0397() {
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Boolean bool) throws Exception {
            C4638.m14103("removeCache success!!!");
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.BaseRequest$Ԫ, reason: contains not printable characters */
    public class C0398 implements InterfaceC2857<Throwable> {
        public C0398() {
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            C4638.m14103("removeCache err!!!" + th);
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.BaseRequest$Ԭ, reason: contains not printable characters */
    public static /* synthetic */ class C0399 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f961;

        static {
            int[] iArr = new int[CacheMode.values().length];
            f961 = iArr;
            try {
                iArr[CacheMode.NO_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f961[CacheMode.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f961[CacheMode.FIRSTREMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f961[CacheMode.FIRSTCACHE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f961[CacheMode.ONLYREMOTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f961[CacheMode.ONLYCACHE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f961[CacheMode.CACHEANDREMOTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f961[CacheMode.CACHEANDREMOTEDISTINCT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public BaseRequest(String str) {
        this.cache = null;
        this.cacheMode = CacheMode.NO_CACHE;
        this.cacheTime = -1L;
        ArrayList arrayList = new ArrayList();
        this.interceptors = arrayList;
        this.url = str;
        this.context = OkHttpUtils.getContext();
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        String baseUrl = OkHttpUtils.getBaseUrl();
        this.baseUrl = baseUrl;
        if (!TextUtils.isEmpty(baseUrl)) {
            this.httpUrl = C3573.m11525(this.baseUrl);
        }
        this.cacheMode = OkHttpUtils.getCacheMode();
        this.cacheTime = OkHttpUtils.getCacheTime();
        this.retryCount = OkHttpUtils.getRetryCount();
        this.retryDelay = OkHttpUtils.getRetryDelay();
        this.retryIncreaseDelay = OkHttpUtils.getRetryIncreaseDelay();
        this.cache = OkHttpUtils.getHttpCache();
        String acceptLanguage = HttpHeaders.getAcceptLanguage();
        if (!TextUtils.isEmpty(acceptLanguage)) {
            headers(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, acceptLanguage);
        }
        String userAgent = HttpHeaders.getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            headers(HttpHeaders.HEAD_KEY_USER_AGENT, userAgent);
        }
        if (okHttpUtils.getCommonParams() != null) {
            this.params.put(okHttpUtils.getCommonParams());
        }
        if (okHttpUtils.getCommonHeaders() != null) {
            this.headers.put(okHttpUtils.getCommonHeaders());
        }
        arrayList.add(new C0396());
    }

    public static byte[] addBytes(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String bodyToString(C4539 c4539) {
        try {
            C4539 c4539M13927 = c4539.m13924().m13927();
            Buffer buffer = new Buffer();
            c4539M13927.m13916().writeTo(buffer);
            Charset charsetM8684 = UTF8;
            C2314 c2314ContentType = c4539M13927.m13916().contentType();
            if (c2314ContentType != null) {
                charsetM8684 = c2314ContentType.m8684(charsetM8684);
            }
            return buffer.readString(charsetM8684);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private C5121.C5122 generateOkClient() {
        if (this.readTimeOut <= 0 && this.writeTimeOut <= 0 && this.connectTimeout <= 0 && this.sslParams == null && this.cookies.size() == 0 && this.hostnameVerifier == null && this.proxy == null && this.headers.isEmpty()) {
            C5121.C5122 okHttpClientBuilder = OkHttpUtils.getOkHttpClientBuilder();
            for (InterfaceC2818 interfaceC2818 : okHttpClientBuilder.m15023()) {
                if (interfaceC2818 instanceof BaseDynamicInterceptor) {
                    ((BaseDynamicInterceptor) interfaceC2818).sign(this.sign).timeStamp(this.timeStamp).accessToken(this.accessToken);
                }
            }
            return okHttpClientBuilder;
        }
        C5121.C5122 c5122M14971 = OkHttpUtils.getOkHttpClient().m14971();
        long j = this.readTimeOut;
        if (j > 0) {
            c5122M14971.m15025(j, TimeUnit.MILLISECONDS);
        }
        long j2 = this.writeTimeOut;
        if (j2 > 0) {
            c5122M14971.m15027(j2, TimeUnit.MILLISECONDS);
        }
        long j3 = this.connectTimeout;
        if (j3 > 0) {
            c5122M14971.m14988(j3, TimeUnit.MILLISECONDS);
        }
        HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        if (hostnameVerifier != null) {
            c5122M14971.m15022(hostnameVerifier);
        }
        HttpsUtils.SSLParams sSLParams = this.sslParams;
        if (sSLParams != null) {
            c5122M14971.m15026(sSLParams.sSLSocketFactory, sSLParams.trustManager);
        }
        Proxy proxy = this.proxy;
        if (proxy != null) {
            c5122M14971.m15024(proxy);
        }
        if (this.cookies.size() > 0) {
            OkHttpUtils.getCookieJar().addCookies(this.cookies);
        }
        c5122M14971.m14984(new HeadersInterceptor(this.headers));
        for (InterfaceC2818 interfaceC28182 : this.interceptors) {
            if (interfaceC28182 instanceof BaseDynamicInterceptor) {
                ((BaseDynamicInterceptor) interfaceC28182).sign(this.sign).timeStamp(this.timeStamp).accessToken(this.accessToken);
            }
            c5122M14971.m14984(interfaceC28182);
        }
        for (InterfaceC2818 interfaceC28183 : c5122M14971.m15023()) {
            if (interfaceC28183 instanceof BaseDynamicInterceptor) {
                ((BaseDynamicInterceptor) interfaceC28183).sign(this.sign).timeStamp(this.timeStamp).accessToken(this.accessToken);
            }
        }
        if (this.networkInterceptors.size() > 0) {
            Iterator<InterfaceC2818> it = this.networkInterceptors.iterator();
            while (it.hasNext()) {
                c5122M14971.m14985(it.next());
            }
        }
        return c5122M14971;
    }

    private Retrofit.Builder generateRetrofit() {
        if (this.converterFactories.isEmpty() && this.adapterFactories.isEmpty()) {
            return OkHttpUtils.getRetrofitBuilder().baseUrl(this.baseUrl);
        }
        Retrofit.Builder builder = new Retrofit.Builder();
        if (this.converterFactories.isEmpty()) {
            Iterator<Converter.Factory> it = OkHttpUtils.getRetrofit().converterFactories().iterator();
            while (it.hasNext()) {
                builder.addConverterFactory(it.next());
            }
        } else {
            Iterator<Converter.Factory> it2 = this.converterFactories.iterator();
            while (it2.hasNext()) {
                builder.addConverterFactory(it2.next());
            }
        }
        if (this.adapterFactories.isEmpty()) {
            Iterator<CallAdapter.Factory> it3 = OkHttpUtils.getRetrofit().callAdapterFactories().iterator();
            while (it3.hasNext()) {
                builder.addCallAdapterFactory(it3.next());
            }
        } else {
            Iterator<CallAdapter.Factory> it4 = this.adapterFactories.iterator();
            while (it4.hasNext()) {
                builder.addCallAdapterFactory(it4.next());
            }
        }
        return builder.baseUrl(this.baseUrl);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private RxCache.Builder generateRxCache() {
        RxCache.Builder rxCacheBuilder = OkHttpUtils.getRxCacheBuilder();
        switch (C0399.f961[this.cacheMode.ordinal()]) {
            case 1:
                NoCacheInterceptor noCacheInterceptor = new NoCacheInterceptor();
                this.interceptors.add(noCacheInterceptor);
                this.networkInterceptors.add(noCacheInterceptor);
                return rxCacheBuilder;
            case 2:
                if (this.cache == null) {
                    File cacheDirectory = OkHttpUtils.getCacheDirectory();
                    if (cacheDirectory == null) {
                        cacheDirectory = new File(OkHttpUtils.getContext().getCacheDir(), "okhttp-cache");
                    } else if (cacheDirectory.isDirectory() && !cacheDirectory.exists()) {
                        cacheDirectory.mkdirs();
                    }
                    this.cache = new C3661(cacheDirectory, Math.max(5242880L, OkHttpUtils.getCacheMaxSize()));
                }
                String str = String.format("max-age=%d", Long.valueOf(Math.max(-1L, this.cacheTime)));
                CacheInterceptor cacheInterceptor = new CacheInterceptor(OkHttpUtils.getContext(), str);
                CacheInterceptorOffline cacheInterceptorOffline = new CacheInterceptorOffline(OkHttpUtils.getContext(), str);
                this.networkInterceptors.add(cacheInterceptor);
                this.networkInterceptors.add(cacheInterceptorOffline);
                this.interceptors.add(cacheInterceptorOffline);
                return rxCacheBuilder;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                this.interceptors.add(new NoCacheInterceptor());
                if (this.diskConverter == null) {
                    rxCacheBuilder.cachekey((String) Utils.checkNotNull(this.cacheKey, "cacheKey == null")).cacheTime(this.cacheTime);
                    return rxCacheBuilder;
                }
                RxCache.Builder builderNewBuilder = OkHttpUtils.getRxCache().newBuilder();
                builderNewBuilder.diskConverter(this.diskConverter).cachekey((String) Utils.checkNotNull(this.cacheKey, "cacheKey == null")).cacheTime(this.cacheTime);
                return builderNewBuilder;
            default:
                return rxCacheBuilder;
        }
    }

    public static String getBodyString(C4539 c4539) {
        StringBuilder sb = new StringBuilder();
        AbstractC2613 abstractC2613M13916 = c4539.m13916();
        if (abstractC2613M13916 != null) {
            if (abstractC2613M13916 instanceof C3135) {
                C3135 c3135 = (C3135) abstractC2613M13916;
                if (c3135.m10728() > 0) {
                    for (int i = 0; i < c3135.m10728(); i++) {
                        if (i > 0) {
                            sb.append("&");
                        }
                        sb.append(c3135.m10726(i));
                        sb.append("=");
                        sb.append(c3135.m10727(i));
                    }
                }
            } else {
                C2314 c2314ContentType = abstractC2613M13916.contentType();
                if (c2314ContentType == null) {
                    return "";
                }
                C2314 c2314M8683 = C2314.m8683("application/json; charset=utf-8");
                C2314 c2314M86832 = C2314.m8683("application/json");
                if (c2314M8683 == null || c2314M86832 == null) {
                    return "";
                }
                if (c2314M8683.toString().equals(c2314ContentType.toString()) || c2314ContentType.toString().equals(c2314M86832.toString())) {
                    return bodyToString(c4539);
                }
            }
        }
        return sb.toString();
    }

    public static String getSign(String str, String str2, String str3) throws NoSuchAlgorithmException {
        String strBytesToMD5;
        C4638.m14099("slimCCCC", "pathStr:" + str);
        C4638.m14099("slimCCCC", "bodyStr:" + str2);
        C4638.m14099("slimCCCC", "timeStr:" + str3);
        byte[] bArrEncryptToByte = StringUtil.EncryptToByte(str + "\n\n" + str2, "");
        return (bArrEncryptToByte == null || (strBytesToMD5 = StringUtil.bytesToMD5(addBytes(bArrEncryptToByte, str3.getBytes()))) == null) ? "" : strBytesToMD5;
    }

    public static C4539 getSignedRequest(InterfaceC2818.InterfaceC2819 interfaceC2819) throws NoSuchAlgorithmException {
        String sign;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C4539 c4539Request = interfaceC2819.request();
        String[] strArrSplit = c4539Request.m13925().toString().split(OkHttpUtils.getBaseUrl());
        String str = strArrSplit.length == 2 ? strArrSplit[1] : "";
        if (r1.m8143(str)) {
            sign = getSign(str, getBodyString(c4539Request), jCurrentTimeMillis + "");
        } else {
            sign = "";
        }
        C4539.C4540 c4540M13924 = c4539Request.m13924();
        if (r1.m8143(sign)) {
            c4540M13924.m13929("Timestamp", "" + jCurrentTimeMillis);
            c4540M13924.m13929("Sign", "" + sign);
            if (str.contains(LoginController.USER_INFO)) {
                if (HttpUtil.uInfoClientNonceList.size() >= 100) {
                    HttpUtil.uInfoClientNonceList.remove(0);
                }
                HttpUtil.uInfoClientNonceList.add(sign);
            } else if (str.contains(StoreController.PRODUCT_LIST_URL)) {
                if (HttpUtil.filterClientNonceList.size() >= 100) {
                    HttpUtil.filterClientNonceList.remove(0);
                }
                HttpUtil.filterClientNonceList.add(sign);
            } else if (str.contains(LoginController.REGISTER_URL)) {
                if (HttpUtil.registerClientNonceList.size() >= 100) {
                    HttpUtil.registerClientNonceList.remove(0);
                }
                HttpUtil.registerClientNonceList.add(sign);
            }
        }
        return c4540M13924.m13927();
    }

    public R accessToken(boolean z) {
        this.accessToken = z;
        return this;
    }

    public R addCallAdapterFactory(CallAdapter.Factory factory) {
        this.adapterFactories.add(factory);
        return this;
    }

    public R addConverterFactory(Converter.Factory factory) {
        this.converterFactories.add(factory);
        return this;
    }

    public R addCookie(String str, String str2) {
        this.cookies.add(new C2632.C2633().m9708(str).m9711(str2).m9703(this.httpUrl.m11532()).m9702());
        return this;
    }

    public R addCookies(List<C2632> list) {
        this.cookies.addAll(list);
        return this;
    }

    public R addInterceptor(InterfaceC2818 interfaceC2818) {
        this.interceptors.add((InterfaceC2818) Utils.checkNotNull(interfaceC2818, "interceptor == null"));
        return this;
    }

    public R addNetworkInterceptor(InterfaceC2818 interfaceC2818) {
        this.networkInterceptors.add((InterfaceC2818) Utils.checkNotNull(interfaceC2818, "interceptor == null"));
        return this;
    }

    public R baseUrl(String str) {
        this.baseUrl = str;
        if (!TextUtils.isEmpty(str)) {
            this.httpUrl = C3573.m11525(str);
        }
        return this;
    }

    public R build() {
        RxCache.Builder builderGenerateRxCache = generateRxCache();
        C5121.C5122 c5122GenerateOkClient = generateOkClient();
        if (this.cacheMode == CacheMode.DEFAULT) {
            c5122GenerateOkClient.m14987(this.cache);
        }
        Retrofit.Builder builderGenerateRetrofit = generateRetrofit();
        builderGenerateRetrofit.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        C5121 c5121M14986 = c5122GenerateOkClient.m14986();
        this.okHttpClient = c5121M14986;
        builderGenerateRetrofit.client(c5121M14986);
        this.retrofit = builderGenerateRetrofit.build();
        this.rxCache = builderGenerateRxCache.build();
        this.apiManager = (APIService) this.retrofit.create(APIService.class);
        return this;
    }

    public R cacheDiskConverter(IDiskConverter iDiskConverter) {
        this.diskConverter = (IDiskConverter) Utils.checkNotNull(iDiskConverter, "converter == null");
        return this;
    }

    public R cacheKey(String str) {
        this.cacheKey = str;
        return this;
    }

    public R cacheMode(CacheMode cacheMode) {
        this.cacheMode = cacheMode;
        return this;
    }

    public R cacheTime(long j) {
        if (j <= -1) {
            j = -1;
        }
        this.cacheTime = j;
        return this;
    }

    public R certificates(InputStream... inputStreamArr) {
        this.sslParams = HttpsUtils.getSslSocketFactory(null, null, inputStreamArr);
        return this;
    }

    public R connectTimeout(long j) {
        this.connectTimeout = j;
        return this;
    }

    public abstract AbstractC4262<AbstractC4809> generateRequest();

    public HttpParams getParams() {
        return this.params;
    }

    public R headers(HttpHeaders httpHeaders) {
        this.headers.put(httpHeaders);
        return this;
    }

    public R hostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }

    public R okCache(C3661 c3661) {
        this.cache = c3661;
        return this;
    }

    public R okproxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }

    public R params(HttpParams httpParams) {
        this.params.put(httpParams);
        return this;
    }

    public R readTimeOut(long j) {
        this.readTimeOut = j;
        return this;
    }

    public R removeAllHeaders() {
        this.headers.clear();
        return this;
    }

    public R removeAllParams() {
        this.params.clear();
        return this;
    }

    public void removeCache(String str) {
        OkHttpUtils.getRxCache().remove(str).compose(RxUtil.io_main()).subscribe(new C0397(), new C0398());
    }

    public R removeHeader(String str) {
        this.headers.remove(str);
        return this;
    }

    public R removeParam(String str) {
        this.params.remove(str);
        return this;
    }

    public R retryCount(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("retryCount must > 0");
        }
        this.retryCount = i;
        return this;
    }

    public R retryDelay(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("retryDelay must > 0");
        }
        this.retryDelay = i;
        return this;
    }

    public R retryIncreaseDelay(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("retryIncreaseDelay must > 0");
        }
        this.retryIncreaseDelay = i;
        return this;
    }

    public R sign(boolean z) {
        this.sign = z;
        return this;
    }

    public R syncRequest(boolean z) {
        this.isSyncRequest = z;
        return this;
    }

    public R timeStamp(boolean z) {
        this.timeStamp = z;
        return this;
    }

    public R writeTimeOut(long j) {
        this.writeTimeOut = j;
        return this;
    }

    public R certificates(InputStream inputStream, String str, InputStream... inputStreamArr) {
        this.sslParams = HttpsUtils.getSslSocketFactory(inputStream, str, inputStreamArr);
        return this;
    }

    public R headers(String str, String str2) {
        this.headers.put(str, str2);
        return this;
    }

    public R params(String str, String str2) {
        this.params.put(str, str2);
        return this;
    }

    public R addCookie(C2632 c2632) {
        this.cookies.add(c2632);
        return this;
    }
}
