package com.mob.tools.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.os.Handler;
import android.view.View;
import com.mob.tools.MobLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public class f implements com.mob.tools.a.a {
    private HashMap<String, Object> a;

    public abstract class a<T> {
        private Object[] a;

        public a(Object... objArr) {
            this.a = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T a(Object obj) {
            return obj;
        }

        public abstract T b(Object[] objArr);
    }

    public f(HashMap<String, Object> map) {
        this.a = map;
    }

    @Override // com.mob.tools.a.a
    public String A() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.64
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gbrd", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String B() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.65
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdvtp", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String[] C() {
        return (String[]) a(String[].class, new a<String[]>(new Object[0]) { // from class: com.mob.tools.a.f.66
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String[] b(Object[] objArr) {
                return a(f.this.a("qriei", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String D() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.67
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gbhnm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public int E() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.68
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gcld", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public int F() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.69
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gcllc", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public int G() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.70
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gpcmt", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public int H() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.71
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gcmlt", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public int I() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.73
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gcmln", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public int J() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.74
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gcmbd", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public int K() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.75
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gcmsd", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public int L() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.76
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gcmnd", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public ArrayList<HashMap<String, Object>> M() {
        return (ArrayList) a(ArrayList.class, new a<ArrayList>(new Object[0]) { // from class: com.mob.tools.a.f.77
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList b(Object[] objArr) {
                return a(f.this.a("gnbclin", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public HashMap<String, Object> N() {
        return (HashMap) a(HashMap.class, new a<HashMap>(new Object[0]) { // from class: com.mob.tools.a.f.78
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap b(Object[] objArr) {
                return a(f.this.a("wmcwi", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public ArrayList<HashMap<String, Object>> O() {
        return (ArrayList) a(ArrayList.class, new a<ArrayList>(new Object[0]) { // from class: com.mob.tools.a.f.79
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList b(Object[] objArr) {
                return a(f.this.a("gavlwls", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public boolean P() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.80
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("scwls", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public int Q() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.81
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("govsit", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public String R() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.82
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("govsnm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String S() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.84
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("golgu", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String T() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.85
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gocnty", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public HashMap<String, Object> U() {
        return (HashMap) a(HashMap.class, new a<HashMap>(new Object[0]) { // from class: com.mob.tools.a.f.86
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap b(Object[] objArr) {
                return a(f.this.a("gcuin", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public ArrayList<ArrayList<String>> V() {
        return (ArrayList) a(ArrayList.class, new a<ArrayList>(new Object[0]) { // from class: com.mob.tools.a.f.87
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList b(Object[] objArr) {
                return a(f.this.a("gtydvin", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public int W() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.89
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gsnbtns", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public int X() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.90
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gsnbtmd", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public String Y() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.91
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gqmkn", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public HashMap<String, HashMap<String, Long>> Z() {
        return (HashMap) a(HashMap.class, new a<HashMap>(new Object[0]) { // from class: com.mob.tools.a.f.92
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap b(Object[] objArr) {
                return a(f.this.a("gszin", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public HashMap<String, Object> aA() {
        return (HashMap) a(HashMap.class, new a<HashMap>(new Object[0]) { // from class: com.mob.tools.a.f.130
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap b(Object[] objArr) {
                return a(f.this.a("gdltm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public ArrayList<HashMap<String, Object>> aB() {
        return (ArrayList) a(ArrayList.class, new a<ArrayList>(new Object[0]) { // from class: com.mob.tools.a.f.131
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList b(Object[] objArr) {
                return a(f.this.a("gmlt", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aC() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.133
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gscpt", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aD() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.134
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gsnmd", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aE() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.136
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gpgnm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aF() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.137
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gpnmmt", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public int aG() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.4
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gpvsnm", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public String aH() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.5
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gpvsme", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public boolean aI() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.6
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("cinmnps", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public String aJ() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.7
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gcrtpcnm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public boolean aK() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.8
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("ciafgd", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public Object aL() {
        return a(Object.class, new a<Object>(new Object[0]) { // from class: com.mob.tools.a.f.10
            @Override // com.mob.tools.a.f.a
            public Object b(Object[] objArr) {
                return a(f.this.a("crtavthd", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public Context aM() {
        return (Context) a(Context.class, new a<Context>(new Object[0]) { // from class: com.mob.tools.a.f.11
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Context b(Object[] objArr) {
                return a(f.this.a("gaplcn", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aN() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.18
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdvda", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aO() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.19
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdvdtnas", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public long aP() {
        return ((Long) a(Long.TYPE, new a<Long>(new Object[0]) { // from class: com.mob.tools.a.f.21
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long b(Object[] objArr) {
                return a(f.this.a("galtut", objArr));
            }
        })).longValue();
    }

    @Override // com.mob.tools.a.a
    public String aQ() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.22
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gbrdm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aR() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.23
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdvme", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aS() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.25
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdpyd", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aT() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.26
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gfgrnt", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aU() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.27
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("grivsn", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aV() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.28
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gcrup", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aW() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.29
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gcifm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aX() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.30
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("godm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aY() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.31
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("godhm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aZ() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.32
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gadm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public HashMap<String, Long> aa() {
        return (HashMap) a(HashMap.class, new a<HashMap>(new Object[0]) { // from class: com.mob.tools.a.f.93
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap b(Object[] objArr) {
                return a(f.this.a("gmrin", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public int ab() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.95
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gabct", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public String ac() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.96
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("galgu", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String ad() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.97
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gscsz", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String ae() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.98
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gneyp", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String af() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.100
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gnktpfs", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String ag() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.101
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdtlnktpfs", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public boolean ah() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.102
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("cknavbl", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public int ai() {
        return ((Integer) a(Integer.TYPE, new a<Integer>(new Object[0]) { // from class: com.mob.tools.a.f.103
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object[] objArr) {
                return a(f.this.a("gdntp", objArr));
            }
        })).intValue();
    }

    @Override // com.mob.tools.a.a
    public ArrayList<HashMap<String, String>> aj() {
        return (ArrayList) a(ArrayList.class, new a<ArrayList>(new Object[0]) { // from class: com.mob.tools.a.f.104
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList b(Object[] objArr) {
                return a(f.this.a("gcrslt", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String ak() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.106
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gtmne", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public HashMap<String, Object> al() {
        return (HashMap) a(HashMap.class, new a<HashMap>(new Object[0]) { // from class: com.mob.tools.a.f.107
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap b(Object[] objArr) {
                return a(f.this.a("gspt", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public HashMap<String, String> am() {
        return (HashMap) a(HashMap.class, new a<HashMap>(new Object[0]) { // from class: com.mob.tools.a.f.108
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap b(Object[] objArr) {
                return a(f.this.a("gcfre", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String an() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.109
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gctp", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String ao() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.110
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gflv", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public HashMap<String, Object> ap() {
        return (HashMap) a(HashMap.class, new a<HashMap>(new Object[0]) { // from class: com.mob.tools.a.f.111
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap b(Object[] objArr) {
                return a(f.this.a("gtrc", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String aq() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.112
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gbsbd", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String ar() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.113
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gbfspy", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String as() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.114
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gbplfo", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public HashMap<String, Object> at() {
        return (HashMap) a(HashMap.class, new a<HashMap>(new Object[0]) { // from class: com.mob.tools.a.f.115
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap b(Object[] objArr) {
                return a(f.this.a("gdvmua", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String au() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.117
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("giads", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public ArrayList<HashMap<String, String>> av() {
        return (ArrayList) a(ArrayList.class, new a<ArrayList>(new Object[0]) { // from class: com.mob.tools.a.f.119
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList b(Object[] objArr) {
                return a(f.this.a("gal", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public ArrayList<HashMap<String, String>> aw() {
        return (ArrayList) a(ArrayList.class, new a<ArrayList>(new Object[0]) { // from class: com.mob.tools.a.f.120
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList b(Object[] objArr) {
                return a(f.this.a("gsl", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String ax() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.123
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdvci", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String ay() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.124
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdvk", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String az() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.129
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdltmpg", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public boolean b() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.50
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("cx", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public String ba() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.33
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gvdm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String bb() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.34
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gudm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public HashMap<String, Object> bc() {
        return (HashMap) a(HashMap.class, new a<HashMap>(new Object[0]) { // from class: com.mob.tools.a.f.36
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap b(Object[] objArr) {
                return a(f.this.a("galdm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public ApplicationInfo bd() {
        return (ApplicationInfo) a(ApplicationInfo.class, new a<ApplicationInfo>(new Object[0]) { // from class: com.mob.tools.a.f.40
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ApplicationInfo b(Object[] objArr) {
                return a(f.this.a("gtaif", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public ArrayList<HashMap<String, Object>> be() {
        return (ArrayList) a(ArrayList.class, new a<ArrayList>(new Object[0]) { // from class: com.mob.tools.a.f.41
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList b(Object[] objArr) {
                return a(f.this.a("gtaifok", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public boolean bf() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.43
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("gpsavlb", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public boolean c() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.61
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("ckpd", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public boolean d() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.72
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("degb", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public boolean e() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.83
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("vnmt", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public boolean f() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.94
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("ckua", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public boolean g() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.105
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("dvenbl", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public boolean h() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.116
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("ubenbl", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public boolean i() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.127
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("iwpxy", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public boolean j() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.2
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("ismlt", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public boolean k() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.24
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("istvdv", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public String l() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.35
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gsrln", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String m() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.44
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gavti", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String n() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.45
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gimi", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String o() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.47
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gimimem", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String p() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.48
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gisi", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String[] q() {
        return (String[]) a(String[].class, new a<String[]>(new Object[0]) { // from class: com.mob.tools.a.f.51
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String[] b(Object[] objArr) {
                return a(f.this.a("qryisi", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String r() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.52
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gsimt", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String s() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.53
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gbsi", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String t() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.54
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gcrie", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String u() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.56
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gcrnm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String v() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.58
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gssn", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String w() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.59
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gmivsn", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String x() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.60
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("godmt", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String y() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.62
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("bgmdl", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String z() {
        return (String) a(String.class, new a<String>(new Object[0]) { // from class: com.mob.tools.a.f.63
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gmnft", objArr));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(String str, Object[] objArr) {
        LinkedList<Object> linkedListA;
        try {
            HashMap<String, Object> map = this.a;
            if (map == null || !map.containsKey(str) || (linkedListA = com.mob.commons.cc.a.a(this.a.get(str), objArr)) == null || linkedListA.isEmpty()) {
                return null;
            }
            return linkedListA.get(0);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    @Override // com.mob.tools.a.a
    public String b(boolean z) {
        return (String) a(String.class, new a<String>(Boolean.valueOf(z)) { // from class: com.mob.tools.a.f.49
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gisip", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String c(boolean z) {
        return (String) a(String.class, new a<String>(Boolean.valueOf(z)) { // from class: com.mob.tools.a.f.55
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gcriefce", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String d(boolean z) {
        return (String) a(String.class, new a<String>(Boolean.valueOf(z)) { // from class: com.mob.tools.a.f.57
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gcrnmfce", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String e(boolean z) {
        return (String) a(String.class, new a<String>(Boolean.valueOf(z)) { // from class: com.mob.tools.a.f.99
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gneypfce", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public ArrayList<HashMap<String, String>> f(boolean z) {
        return (ArrayList) a(ArrayList.class, new a<ArrayList>(Boolean.valueOf(z)) { // from class: com.mob.tools.a.f.118
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList b(Object[] objArr) {
                return a(f.this.a("gia", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String g(boolean z) {
        return (String) a(String.class, new a<String>(Boolean.valueOf(z)) { // from class: com.mob.tools.a.f.125
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdvkfc", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public boolean h(String str) {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(str) { // from class: com.mob.tools.a.f.9
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("ckpmsi", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public String b(String str) {
        return (String) a(String.class, new a<String>(str) { // from class: com.mob.tools.a.f.122
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gstmpts", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String c(String str) {
        return (String) a(String.class, new a<String>(str) { // from class: com.mob.tools.a.f.126
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gdfrspg", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public List<String> d(String str) {
        return (List) a(List.class, new a<List>(str) { // from class: com.mob.tools.a.f.128
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public List b(Object[] objArr) {
                return a(f.this.a("grsvps", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public boolean e(String str) {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(str) { // from class: com.mob.tools.a.f.132
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("ipgist", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public String f(String str) {
        return (String) a(String.class, new a<String>(str) { // from class: com.mob.tools.a.f.135
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gsnmdfp", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String g(String str) {
        return (String) a(String.class, new a<String>(str) { // from class: com.mob.tools.a.f.3
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gpnmfp", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public ResolveInfo b(Intent intent, int i) {
        return (ResolveInfo) a(ResolveInfo.class, new a<ResolveInfo>(intent, Integer.valueOf(i)) { // from class: com.mob.tools.a.f.14
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResolveInfo b(Object[] objArr) {
                return a(f.this.a("rsaciy", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public void b(View view) {
        a(Void.class, new a<Void>(view) { // from class: com.mob.tools.a.f.17
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void b(Object[] objArr) {
                return a(f.this.a("swstin", objArr));
            }
        });
    }

    private <T> T a(Class<T> cls, a<T> aVar) {
        T tCast;
        T t = null;
        if (cls != null && aVar != null) {
            try {
                T tB = aVar.b(((a) aVar).a);
                if (tB != null && cls != Void.class) {
                    if (cls == Boolean.TYPE) {
                        tCast = (T) Boolean.class.cast(tB);
                    } else if (cls == Integer.TYPE) {
                        tCast = (T) Integer.class.cast(tB);
                    } else if (cls == Byte.TYPE) {
                        tCast = (T) Byte.class.cast(tB);
                    } else if (cls == Character.TYPE) {
                        tCast = (T) Character.class.cast(tB);
                    } else if (cls == Short.TYPE) {
                        tCast = (T) Short.class.cast(tB);
                    } else if (cls == Long.TYPE) {
                        tCast = (T) Long.class.cast(tB);
                    } else if (cls == Float.TYPE) {
                        tCast = (T) Float.class.cast(tB);
                    } else if (cls == Double.TYPE) {
                        tCast = (T) Double.class.cast(tB);
                    } else {
                        tCast = cls.cast(tB);
                    }
                    t = tCast;
                }
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }
        if (t != null) {
            return t;
        }
        if (cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Integer.TYPE) {
            return (T) (-1);
        }
        if (cls == Byte.TYPE) {
            return (T) (byte) 0;
        }
        if (cls == Character.TYPE) {
            return (T) (char) 0;
        }
        if (cls == Short.TYPE) {
            return (T) (short) 0;
        }
        if (cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Float.TYPE) {
            return (T) Float.valueOf(0.0f);
        }
        return cls == Double.TYPE ? (T) Double.valueOf(0.0d) : t;
    }

    @Override // com.mob.tools.a.a
    public boolean a() {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(new Object[0]) { // from class: com.mob.tools.a.f.1
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("cird", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public boolean a(String str) {
        return ((Boolean) a(Boolean.TYPE, new a<Boolean>(str) { // from class: com.mob.tools.a.f.13
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object[] objArr) {
                return a(f.this.a("ifkps", objArr));
            }
        })).booleanValue();
    }

    @Override // com.mob.tools.a.a
    public String a(boolean z) {
        return (String) a(String.class, new a<String>(Boolean.valueOf(z)) { // from class: com.mob.tools.a.f.46
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("gimip", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public void a(Handler.Callback callback) {
        a(Void.class, new a<Void>(callback) { // from class: com.mob.tools.a.f.88
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void b(Object[] objArr) {
                return a(f.this.a("gbtrstt", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public Location a(int i, int i2, boolean z) {
        return (Location) a(Location.class, new a<Location>(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)) { // from class: com.mob.tools.a.f.121
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Location b(Object[] objArr) {
                return a(f.this.a("glctn", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public List<ResolveInfo> a(Intent intent, int i) {
        return (List) a(List.class, new a<List>(intent, Integer.valueOf(i)) { // from class: com.mob.tools.a.f.12
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public List b(Object[] objArr) {
                return a(f.this.a("qritsvc", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public PackageInfo a(boolean z, int i, String str, int i2) {
        return (PackageInfo) a(PackageInfo.class, new a<PackageInfo>(Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2)) { // from class: com.mob.tools.a.f.15
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PackageInfo b(Object[] objArr) {
                return a(f.this.a("gpgiffist", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public void a(View view) {
        a(Void.class, new a<Void>(view) { // from class: com.mob.tools.a.f.16
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void b(Object[] objArr) {
                return a(f.this.a("hdstipu", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public String a(String str, String str2) {
        return (String) a(String.class, new a<String>(str, str2) { // from class: com.mob.tools.a.f.20
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Object[] objArr) {
                return a(f.this.a("bsasm", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public void a(BroadcastReceiver broadcastReceiver) throws Throwable {
        a(Void.class, new a<Void>(broadcastReceiver) { // from class: com.mob.tools.a.f.37
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void b(Object[] objArr) {
                return a(f.this.a("unrgrcv", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) throws Throwable {
        a(Void.class, new a<Void>(broadcastReceiver, intentFilter) { // from class: com.mob.tools.a.f.38
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void b(Object[] objArr) {
                return a(f.this.a("rgrcv", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public void a(BlockingQueue<Boolean> blockingQueue) {
        a(Void.class, new a<Void>(blockingQueue) { // from class: com.mob.tools.a.f.39
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void b(Object[] objArr) {
                return a(f.this.a("rgwsr", objArr));
            }
        });
    }

    @Override // com.mob.tools.a.a
    public ApplicationInfo a(String str, int i) {
        return (ApplicationInfo) a(ApplicationInfo.class, new a<ApplicationInfo>(str, Integer.valueOf(i)) { // from class: com.mob.tools.a.f.42
            @Override // com.mob.tools.a.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ApplicationInfo b(Object[] objArr) {
                return a(f.this.a("gtaifprm", objArr));
            }
        });
    }
}
