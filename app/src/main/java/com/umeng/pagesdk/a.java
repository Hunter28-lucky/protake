package com.umeng.pagesdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Choreographer;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    public float a;
    public long b;
    public int c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f17833e;
    public Map<String, Double> f = new HashMap();
    public boolean g;
    public long h;
    public long i;
    public String j;
    private Context k;

    public a(Context context) {
        SharedPreferences sharedPreferences;
        this.a = 1000.0f;
        this.f17833e = 6;
        this.i = Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL;
        this.k = context;
        if (context == null || (sharedPreferences = context.getSharedPreferences("efs_page", 0)) == null) {
            return;
        }
        this.a = sharedPreferences.getFloat(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL, 1000.0f);
        this.f17833e = sharedPreferences.getInt(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, 6);
        this.i = sharedPreferences.getLong(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC, Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL);
        if (PageManger.isDebug) {
            Log.i("PageManger-PageFPSImpl", "init fps. diff is " + this.a + ", count diff is " + this.f17833e + ", dlealt time is " + this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() throws JSONException {
        Iterator<Map.Entry<String, Double>> it = this.f.entrySet().iterator();
        if (it != null) {
            JSONArray jSONArray = null;
            while (it.hasNext()) {
                Map.Entry<String, Double> next = it.next();
                if (next != null) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(next.getKey(), next.getValue());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("pN", this.j);
                    jSONObject2.put("pF", jSONArray);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                EfsJSONLog efsJSONLog = new EfsJSONLog("fpsperf");
                efsJSONLog.put("fps", jSONObject2);
                EfsReporter reporter = PageManger.getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                }
            }
        }
    }

    public final void a() {
        if (this.g) {
            if (PageManger.isDebug) {
                Log.i("PageManger-PageFPSImpl", "state is start!");
            }
        } else {
            this.g = true;
            if (PageManger.isDebug) {
                Log.i("PageManger-PageFPSImpl", "start, page is " + this.j);
            }
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.umeng.pagesdk.a.1
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) throws JSONException {
                    String str = PageManger.TAG;
                    a aVar = a.this;
                    if (aVar.g) {
                        if (aVar.h == 0) {
                            aVar.h = System.currentTimeMillis();
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        a aVar2 = a.this;
                        if (jCurrentTimeMillis - aVar2.h > aVar2.i) {
                            aVar2.b();
                            return;
                        }
                        if (aVar2.b == 0) {
                            aVar2.b = j;
                        }
                        float f = (j - aVar2.b) / 1000000.0f;
                        if (f > aVar2.a) {
                            double d = (aVar2.c * 1000) / f;
                            aVar2.c = 0;
                            aVar2.b = 0L;
                            if (PageManger.isDebug) {
                                Log.i("PageManger-PageFPSImpl", "doFrame: " + d + ", map size is " + a.this.f.size() + ", page is " + a.this.j);
                            }
                            Map<String, Double> map = a.this.f;
                            StringBuilder sb = new StringBuilder();
                            sb.append(System.currentTimeMillis());
                            map.put(sb.toString(), Double.valueOf(d));
                            a aVar3 = a.this;
                            int i = aVar3.d + 1;
                            aVar3.d = i;
                            if (i >= aVar3.f17833e) {
                                aVar3.c();
                                a aVar4 = a.this;
                                aVar4.d = 0;
                                Map<String, Double> map2 = aVar4.f;
                                if (map2 != null) {
                                    map2.clear();
                                }
                            }
                        } else {
                            aVar2.c++;
                        }
                        Choreographer.getInstance().postFrameCallback(this);
                    }
                }
            });
        }
    }

    public final void b() {
        if (PageManger.isDebug) {
            Log.i("PageManger-PageFPSImpl", "stop, page is " + this.j);
        }
        c();
        this.g = false;
        this.h = 0L;
        this.b = 0L;
        this.c = 0;
        Map<String, Double> map = this.f;
        if (map != null) {
            map.clear();
        }
        this.d = 0;
    }
}
