package com.blink.academy.film.http.okhttp.cache;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.blink.academy.film.http.okhttp.cache.converter.IDiskConverter;
import com.blink.academy.film.http.okhttp.cache.converter.SerializableDiskConverter;
import com.blink.academy.film.http.okhttp.cache.core.CacheCore;
import com.blink.academy.film.http.okhttp.cache.core.LruDiskCache;
import com.blink.academy.film.http.okhttp.cache.model.CacheMode;
import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import com.blink.academy.film.http.okhttp.cache.stategy.IStrategy;
import com.blink.academy.film.http.okhttp.utils.Utils;
import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.C4638;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC5201;
import defpackage.InterfaceC5245;
import defpackage.InterfaceC5298;
import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class RxCache {
    private final int appVersion;
    private final CacheCore cacheCore;
    private final String cacheKey;
    private final long cacheTime;
    private final Context context;
    private final IDiskConverter diskConverter;
    private final File diskDir;
    private final long diskMaxSize;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.RxCache$Ϳ, reason: contains not printable characters */
    public class C0368<T> implements InterfaceC5298<T, CacheResult<T>> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Type f914;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ IStrategy f915;

        public C0368(Type type, IStrategy iStrategy) {
            this.f914 = type;
            this.f915 = iStrategy;
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<CacheResult<T>> apply(AbstractC4262<T> abstractC4262) {
            C4638.m14103("cackeKey=" + RxCache.this.cacheKey);
            Type parameterizedType = this.f914;
            if ((parameterizedType instanceof ParameterizedType) && CacheResult.class.isAssignableFrom((Class) ((ParameterizedType) parameterizedType).getRawType())) {
                parameterizedType = Utils.getParameterizedType(this.f914, 0);
            }
            Type type = parameterizedType;
            IStrategy iStrategy = this.f915;
            RxCache rxCache = RxCache.this;
            return iStrategy.execute(rxCache, rxCache.cacheKey, RxCache.this.cacheTime, abstractC4262, type);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.RxCache$Ԩ, reason: contains not printable characters */
    public class C0369<T> extends AbstractC0374<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Type f917;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f918;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ long f919;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0369(Type type, String str, long j) {
            super(null);
            this.f917 = type;
            this.f918 = str;
            this.f919 = j;
        }

        @Override // com.blink.academy.film.http.okhttp.cache.RxCache.AbstractC0374
        /* renamed from: Ϳ, reason: contains not printable characters */
        public T mo1379() {
            return (T) RxCache.this.cacheCore.load(this.f917, this.f918, this.f919);
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.cache.RxCache$Ԫ, reason: contains not printable characters */
    public class C0370 extends AbstractC0374<Boolean> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ String f921;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ Object f922;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0370(String str, Object obj) {
            super(null);
            this.f921 = str;
            this.f922 = obj;
        }

        @Override // com.blink.academy.film.http.okhttp.cache.RxCache.AbstractC0374
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean mo1379() throws Throwable {
            RxCache.this.cacheCore.save(this.f921, this.f922);
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.cache.RxCache$Ԭ, reason: contains not printable characters */
    public class C0371 extends AbstractC0374<Boolean> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ String f924;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0371(String str) {
            super(null);
            this.f924 = str;
        }

        @Override // com.blink.academy.film.http.okhttp.cache.RxCache.AbstractC0374
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean mo1379() throws Throwable {
            return Boolean.valueOf(RxCache.this.cacheCore.containsKey(this.f924));
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.cache.RxCache$Ԯ, reason: contains not printable characters */
    public class C0372 extends AbstractC0374<Boolean> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ String f926;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0372(String str) {
            super(null);
            this.f926 = str;
        }

        @Override // com.blink.academy.film.http.okhttp.cache.RxCache.AbstractC0374
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean mo1379() throws Throwable {
            return Boolean.valueOf(RxCache.this.cacheCore.remove(this.f926));
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.cache.RxCache$ՠ, reason: contains not printable characters */
    public class C0373 extends AbstractC0374<Boolean> {
        public C0373() {
            super(null);
        }

        @Override // com.blink.academy.film.http.okhttp.cache.RxCache.AbstractC0374
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean mo1379() throws Throwable {
            return Boolean.valueOf(RxCache.this.cacheCore.clear());
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.cache.RxCache$ֈ, reason: contains not printable characters */
    public static abstract class AbstractC0374<T> implements InterfaceC5201<T> {
        public AbstractC0374() {
        }

        public /* synthetic */ AbstractC0374(C0368 c0368) {
            this();
        }

        @Override // defpackage.InterfaceC5201
        public void subscribe(InterfaceC5245<T> interfaceC5245) throws Exception {
            try {
                T tMo1379 = mo1379();
                if (!interfaceC5245.isDisposed()) {
                    interfaceC5245.onNext(tMo1379);
                }
                if (interfaceC5245.isDisposed()) {
                    return;
                }
                interfaceC5245.onComplete();
            } catch (Throwable th) {
                C4638.m14100(th.getMessage());
                if (!interfaceC5245.isDisposed()) {
                    interfaceC5245.onError(th);
                }
                C4089.m13026(th);
            }
        }

        /* renamed from: Ϳ */
        public abstract T mo1379() throws Throwable;
    }

    public /* synthetic */ RxCache(Builder builder, C0368 c0368) {
        this(builder);
    }

    private IStrategy loadStrategy(CacheMode cacheMode) {
        try {
            return (IStrategy) Class.forName(IStrategy.class.getPackage().getName() + "." + cacheMode.getClassName()).newInstance();
        } catch (Exception e2) {
            throw new RuntimeException("loadStrategy(" + cacheMode + ") err!!" + e2.getMessage());
        }
    }

    public AbstractC4262<Boolean> clear() {
        return AbstractC4262.create(new C0373());
    }

    public AbstractC4262<Boolean> containsKey(String str) {
        return AbstractC4262.create(new C0371(str));
    }

    public int getAppVersion() {
        return this.appVersion;
    }

    public CacheCore getCacheCore() {
        return this.cacheCore;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public long getCacheTime() {
        return this.cacheTime;
    }

    public Context getContext() {
        return this.context;
    }

    public IDiskConverter getDiskConverter() {
        return this.diskConverter;
    }

    public File getDiskDir() {
        return this.diskDir;
    }

    public long getDiskMaxSize() {
        return this.diskMaxSize;
    }

    public <T> AbstractC4262<T> load(Type type, String str) {
        return load(type, str, -1L);
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public AbstractC4262<Boolean> remove(String str) {
        return AbstractC4262.create(new C0372(str));
    }

    public <T> AbstractC4262<Boolean> save(String str, T t) {
        return AbstractC4262.create(new C0370(str, t));
    }

    public <T> InterfaceC5298<T, CacheResult<T>> transformer(CacheMode cacheMode, Type type) {
        return new C0368(type, loadStrategy(cacheMode));
    }

    public RxCache() {
        this(new Builder());
    }

    public <T> AbstractC4262<T> load(Type type, String str, long j) {
        return AbstractC4262.create(new C0369(type, str, j));
    }

    private RxCache(Builder builder) {
        this.context = builder.context;
        this.cacheKey = builder.cachekey;
        this.cacheTime = builder.cacheTime;
        File file = builder.diskDir;
        this.diskDir = file;
        int i = builder.appVersion;
        this.appVersion = i;
        long j = builder.diskMaxSize;
        this.diskMaxSize = j;
        IDiskConverter iDiskConverter = builder.diskConverter;
        this.diskConverter = iDiskConverter;
        this.cacheCore = new CacheCore(new LruDiskCache(iDiskConverter, file, i, j));
    }

    public static final class Builder {
        public static final long CACHE_NEVER_EXPIRE = -1;
        private static final int MAX_DISK_CACHE_SIZE = 52428800;
        private static final int MIN_DISK_CACHE_SIZE = 5242880;
        private int appVersion;
        private long cacheTime;
        private String cachekey;
        private Context context;
        private IDiskConverter diskConverter;
        private File diskDir;
        private long diskMaxSize;

        public Builder() {
            this.diskConverter = new SerializableDiskConverter();
            this.cacheTime = -1L;
            this.appVersion = 1;
        }

        private static long calculateDiskCacheSize(File file) {
            long blockCount;
            try {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                blockCount = (statFs.getBlockCount() * statFs.getBlockSize()) / 50;
            } catch (IllegalArgumentException unused) {
                blockCount = 0;
            }
            return Math.max(Math.min(blockCount, 52428800L), 5242880L);
        }

        public Builder appVersion(int i) {
            this.appVersion = i;
            return this;
        }

        public RxCache build() {
            Context context;
            if (this.diskDir == null && (context = this.context) != null) {
                this.diskDir = getDiskCacheDir(context, "data-cache");
            }
            Utils.checkNotNull(this.diskDir, "diskDir==null");
            if (!this.diskDir.exists()) {
                this.diskDir.mkdirs();
            }
            if (this.diskConverter == null) {
                this.diskConverter = new SerializableDiskConverter();
            }
            if (this.diskMaxSize <= 0) {
                this.diskMaxSize = calculateDiskCacheSize(this.diskDir);
            }
            this.cacheTime = Math.max(-1L, this.cacheTime);
            this.appVersion = Math.max(1, this.appVersion);
            return new RxCache(this, null);
        }

        public Builder cacheTime(long j) {
            this.cacheTime = j;
            return this;
        }

        public Builder cachekey(String str) {
            this.cachekey = str;
            return this;
        }

        public Builder diskConverter(IDiskConverter iDiskConverter) {
            this.diskConverter = iDiskConverter;
            return this;
        }

        public Builder diskDir(File file) {
            this.diskDir = file;
            return this;
        }

        public Builder diskMax(long j) {
            this.diskMaxSize = j;
            return this;
        }

        public File getDiskCacheDir(Context context, String str) {
            File externalCacheDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalCacheDir() : context.getCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            return new File(externalCacheDir.getPath() + File.separator + str);
        }

        public Builder init(Context context) {
            this.context = context;
            return this;
        }

        public Builder(RxCache rxCache) {
            this.context = rxCache.context;
            this.appVersion = rxCache.appVersion;
            this.diskMaxSize = rxCache.diskMaxSize;
            this.diskDir = rxCache.diskDir;
            this.diskConverter = rxCache.diskConverter;
            this.context = rxCache.context;
            this.cachekey = rxCache.cacheKey;
            this.cacheTime = rxCache.cacheTime;
        }
    }
}
