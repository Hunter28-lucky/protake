package com.efs.sdk.pa;

import android.content.Context;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.pa.config.ConfigManager;
import com.efs.sdk.pa.config.IEfsReporter;
import com.efs.sdk.pa.config.PackageLevel;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PAFactory {
    private static final long DEFAULT_TIME_OUT_TIME = 2000;
    private static final long INVALID_TIME_OUT_TIME = 0;
    private static final long MAX_TIME_OUT_TIME = 4000;
    private static final String TAG = "pafactory";
    public static final ThreadLocal<PA> sThreadLocal = new ThreadLocal<>();
    private ConfigManager mConfigManager;
    private Context mContext;
    private HashMap<String, String> mExtend;
    private EfsReporter mReporter;
    private IEfsReporter mReporterFactory;
    private String mSerial;
    private String mSver;
    private long mTimeOutTime;
    private PATraceListener mTraceListener;

    public static class Builder {
        private PackageLevel a;
        private IEfsReporter b;
        private boolean c;
        private Context d;

        /* renamed from: e, reason: collision with root package name */
        private String f17658e;
        private HashMap<String, String> f;
        private String g;
        private long h = PAFactory.DEFAULT_TIME_OUT_TIME;
        private PATraceListener i;

        public Builder(Context context, IEfsReporter iEfsReporter) {
            if (context == null) {
                throw new RuntimeException("context Should Not null");
            }
            if (iEfsReporter == null) {
                throw new RuntimeException("reporter Should Not Empty");
            }
            this.b = iEfsReporter;
            this.d = context;
        }

        public PAFactory build() {
            if (this.a != null) {
                return new PAFactory(this.d, this.a, this.b, this.c, this.f17658e, this.f, this.g, this.h, this.i);
            }
            throw new RuntimeException(String.format("%s Should Not Null", ""));
        }

        public Builder extendLogInfo(HashMap<String, String> map) {
            this.f = map;
            return this;
        }

        public Builder isNewInstall(boolean z) {
            this.c = z;
            return this;
        }

        public Builder packageLevel(PackageLevel packageLevel) {
            this.a = packageLevel;
            return this;
        }

        public Builder serial(String str) {
            this.f17658e = str;
            return this;
        }

        public Builder sver(String str) {
            this.g = str;
            return this;
        }

        public Builder timeoutTime(long j) {
            if (j <= PAFactory.INVALID_TIME_OUT_TIME) {
                Log.w(PAFactory.TAG, "Timeout time is invalid, and the default value 2s will be used");
                this.h = PAFactory.DEFAULT_TIME_OUT_TIME;
            } else {
                if (j > PAFactory.MAX_TIME_OUT_TIME) {
                    Log.w(PAFactory.TAG, "Timeout time over 4s is not recommended, and the default value 2s will be used");
                    this.h = PAFactory.DEFAULT_TIME_OUT_TIME;
                    return this;
                }
                this.h = j;
            }
            return this;
        }

        public Builder traceListener(PATraceListener pATraceListener) {
            this.i = pATraceListener;
            return this;
        }
    }

    public ConfigManager getConfigManager() {
        return this.mConfigManager;
    }

    public HashMap<String, String> getExtend() {
        return this.mExtend;
    }

    public synchronized PA getPaInstance() {
        PA cVar;
        ThreadLocal<PA> threadLocal = sThreadLocal;
        cVar = threadLocal.get();
        if (cVar == null) {
            cVar = new com.efs.sdk.pa.a.c(this.mConfigManager.enableTracer());
            cVar.registerPAANRListener(this.mContext, new a(this), this.mTimeOutTime);
            threadLocal.set(cVar);
        }
        return cVar;
    }

    public EfsReporter getReporter() {
        if (this.mReporter == null) {
            IEfsReporter iEfsReporter = this.mReporterFactory;
            this.mReporter = iEfsReporter != null ? iEfsReporter.getReporter() : null;
        }
        return this.mReporter;
    }

    public String getSerial() {
        return this.mSerial;
    }

    public String getSver() {
        return this.mSver;
    }

    public PATraceListener getTraceListener() {
        return this.mTraceListener;
    }

    private PAFactory(Context context, PackageLevel packageLevel, IEfsReporter iEfsReporter, boolean z, String str, HashMap<String, String> map, String str2, long j, PATraceListener pATraceListener) {
        this.mReporterFactory = iEfsReporter;
        this.mSerial = str;
        this.mExtend = map;
        this.mSver = str2;
        this.mContext = context;
        this.mTraceListener = pATraceListener;
        this.mTimeOutTime = j;
        this.mConfigManager = new ConfigManager(context, packageLevel, iEfsReporter, z);
    }
}
