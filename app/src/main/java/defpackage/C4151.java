package defpackage;

import com.blink.academy.film.FilmApp;
import com.blink.academy.film.http.okhttp.OkHttpUtils;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.callback.DownloadProgressCallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.store.DownloadFilterTask;
import com.blink.academy.film.netbean.store.DownloadTaskBean;
import com.blink.academy.film.netbean.store.FilterBean;
import com.blink.academy.film.netbean.store.FilterGroupBean;
import com.blink.academy.film.netbean.store.FilterGroupCollectionBean;
import com.blink.academy.film.netbean.store.FilterTokenBean;
import com.blink.academy.film.netbean.store.FilterTokenCallback;
import com.blink.academy.film.netbean.store.StoreCallbackEntity;
import com.blink.academy.film.support.controller.StoreController;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C2445;
import defpackage.C3184;
import defpackage.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FilterFileManager.java */
/* renamed from: গ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4151 {

    /* renamed from: ށ, reason: contains not printable characters */
    public static C4151 f14383;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public DownloadFilterTask f14384;

    /* renamed from: ԩ, reason: contains not printable characters */
    public C5244 f14386;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public List<Integer> f14387;

    /* renamed from: ԫ, reason: contains not printable characters */
    public List<Integer> f14388;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f14389;

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<FilterBean> f14390;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public List<FilterBean> f14391;

    /* renamed from: ԯ, reason: contains not printable characters */
    public List<FilterBean> f14392;

    /* renamed from: ՠ, reason: contains not printable characters */
    public List<FilterBean> f14393;

    /* renamed from: ֈ, reason: contains not printable characters */
    public String f14394;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f14398;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f14395 = 0;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final Object f14396 = new Object();

    /* renamed from: ؠ, reason: contains not printable characters */
    public List<InterfaceC4478> f14397 = new ArrayList();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public List<C2531> f14385 = C3184.m10827().m10854();

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$Ϳ, reason: contains not printable characters */
    public class C4152 extends CallBack<String> {
        public C4152() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            C4638.m14097();
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            C4638.m14097();
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$Ԩ, reason: contains not printable characters */
    public class C4153 extends CallBack<FilterTokenCallback> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4169 f14400;

        public C4153(InterfaceC4169 interfaceC4169) {
            this.f14400 = interfaceC4169;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            C4151.this.f14384 = null;
            InterfaceC4169 interfaceC4169 = this.f14400;
            if (interfaceC4169 != null) {
                interfaceC4169.mo1356(2);
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(FilterTokenCallback filterTokenCallback) {
            if (filterTokenCallback == null) {
                C4151.this.f14384 = null;
                InterfaceC4169 interfaceC4169 = this.f14400;
                if (interfaceC4169 != null) {
                    interfaceC4169.mo1356(2);
                    return;
                }
                return;
            }
            String client_nonce = filterTokenCallback.getClient_nonce();
            if (!r1.m8143(C4151.this.f14394)) {
                C4151.this.f14384 = null;
                InterfaceC4169 interfaceC41692 = this.f14400;
                if (interfaceC41692 != null) {
                    interfaceC41692.mo1356(2);
                    return;
                }
                return;
            }
            if (!C4151.this.f14394.equals(client_nonce)) {
                C4151.this.f14384 = null;
                InterfaceC4169 interfaceC41693 = this.f14400;
                if (interfaceC41693 != null) {
                    interfaceC41693.mo1356(2);
                    return;
                }
                return;
            }
            List<FilterTokenBean> download_signs = filterTokenCallback.getDownload_signs();
            if (C4151.this.f14384 == null) {
                C4151.this.m13174(this.f14400);
                return;
            }
            List<DownloadTaskBean> tasks = C4151.this.f14384.getTasks();
            if (r1.m8144(tasks) && r1.m8144(download_signs)) {
                for (FilterTokenBean filterTokenBean : download_signs) {
                    for (DownloadTaskBean downloadTaskBean : tasks) {
                        if (filterTokenBean.getFile_id() == downloadTaskBean.getVersion_id()) {
                            downloadTaskBean.setDownload_token(filterTokenBean.getDownload_sign());
                            downloadTaskBean.setDownload_token_timeout(filterTokenBean.getDownload_sign_timeout());
                        }
                    }
                }
                InterfaceC4169 interfaceC41694 = this.f14400;
                if (interfaceC41694 != null) {
                    interfaceC41694.mo1357((C4151.this.f14384.getCurrentBytesRead() * 0.9f) / C4151.this.f14384.getTotalBytesRead());
                }
                C4151.this.m13175(this.f14400);
            }
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$Ԫ, reason: contains not printable characters */
    public class C4154 extends TypeToken<List<FilterGroupBean>> {
        public C4154() {
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$Ԭ, reason: contains not printable characters */
    public class RunnableC4155 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f14403;

        public RunnableC4155(String str) {
            this.f14403 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3180.m10795(this.f14403);
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$Ԯ, reason: contains not printable characters */
    public class RunnableC4156 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2531 f14405;

        public RunnableC4156(C2531 c2531) {
            this.f14405 = c2531;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3180.m10793(C4151.this.m13181(this.f14405.m9346() + ""));
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ՠ, reason: contains not printable characters */
    public class RunnableC4157 implements Runnable {
        public RunnableC4157() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r1.m8144(C4151.this.f14385)) {
                for (C2531 c2531 : C4151.this.f14385) {
                    String strM9347 = c2531.m9347();
                    File parentFile = new File(strM9347).getParentFile();
                    if (parentFile != null && parentFile.exists()) {
                        File[] fileArrListFiles = parentFile.listFiles();
                        if (r1.m8142(fileArrListFiles)) {
                            for (File file : fileArrListFiles) {
                                if (!strM9347.equals(file.getAbsolutePath()) && !file.getAbsolutePath().equals(c2531.m9349())) {
                                    C3180.m10794(file);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ֈ, reason: contains not printable characters */
    public class C4158 implements C3184.InterfaceC3217 {
        public C4158() {
        }

        @Override // defpackage.C3184.InterfaceC3217
        /* renamed from: Ϳ */
        public void mo10874() {
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$֏, reason: contains not printable characters */
    public class C4159 extends TypeToken<List<Integer>> {
        public C4159() {
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ׯ, reason: contains not printable characters */
    public class RunnableC4160 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ StoreCallbackEntity f14410;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ n.InterfaceC2187 f14411;

        /* compiled from: FilterFileManager.java */
        /* renamed from: গ$ׯ$Ϳ, reason: contains not printable characters */
        public class C4161 implements C2445.InterfaceC2449 {
            public C4161() {
            }

            @Override // defpackage.C2445.InterfaceC2449
            public void onSuc() {
                C4151.this.m13188(RunnableC4160.this.f14410.getFilter_groups(), RunnableC4160.this.f14410.getFilters(), RunnableC4160.this.f14410.getFilter_group_collections());
                n.InterfaceC2187 interfaceC2187 = RunnableC4160.this.f14411;
                if (interfaceC2187 != null) {
                    interfaceC2187.mo1339();
                }
            }

            @Override // defpackage.C2445.InterfaceC2449
            /* renamed from: Ϳ */
            public void mo9013(float f) {
            }
        }

        public RunnableC4160(StoreCallbackEntity storeCallbackEntity, n.InterfaceC2187 interfaceC2187) {
            this.f14410 = storeCallbackEntity;
            this.f14411 = interfaceC2187;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            if (C4151.this.f14389) {
                return;
            }
            if (this.f14410 == null) {
                n.InterfaceC2187 interfaceC2187 = this.f14411;
                if (interfaceC2187 != null) {
                    interfaceC2187.mo1340();
                    return;
                }
                return;
            }
            C4151.this.f14389 = true;
            List<FilterBean> filters = this.f14410.getFilters();
            C4151.this.f14390 = new ArrayList();
            C4151.this.f14392 = new ArrayList();
            C4151.this.f14393 = new ArrayList();
            C4151.this.f14391 = new ArrayList();
            C4151.this.f14388.clear();
            if (r1.m8144(filters)) {
                List<FilterGroupBean> filter_groups = this.f14410.getFilter_groups();
                if (r1.m8144(filter_groups)) {
                    for (FilterGroupBean filterGroupBean : filter_groups) {
                        if (!filterGroupBean.isPurchase_required()) {
                            int[] filters2 = filterGroupBean.getFilters();
                            int[] preview_filters = filterGroupBean.getPreview_filters();
                            if (r1.m8142(filters2)) {
                                for (int i : filters2) {
                                    if (!C4151.this.f14388.contains(Integer.valueOf(i))) {
                                        C4151.this.f14388.add(Integer.valueOf(i));
                                    }
                                }
                            }
                            if (r1.m8142(preview_filters)) {
                                for (int i2 : preview_filters) {
                                    if (!C4151.this.f14388.contains(Integer.valueOf(i2))) {
                                        C4151.this.f14388.add(Integer.valueOf(i2));
                                    }
                                }
                            }
                        }
                    }
                }
                if (e5.m5988().m5993()) {
                    C4151.this.f14391.addAll(filters);
                } else if (r1.m8144(C4151.this.f14388)) {
                    for (FilterBean filterBean : filters) {
                        if (C4151.this.f14388.contains(Integer.valueOf(filterBean.getId()))) {
                            C4151.this.f14391.add(filterBean);
                        }
                    }
                }
                if (r1.m8144(C4151.this.f14385)) {
                    C4151.this.f14387 = new ArrayList();
                    for (C2531 c2531 : C4151.this.f14385) {
                        int iM9350 = c2531.m9350();
                        int iM9346 = c2531.m9346();
                        boolean z = false;
                        for (FilterBean filterBean2 : C4151.this.f14391) {
                            int id = filterBean2.getId();
                            int file_id = filterBean2.getFile_id();
                            if (id == iM9346) {
                                if (file_id > iM9350) {
                                    C4151.this.f14390.add(filterBean2);
                                    C4151.this.f14392.add(filterBean2);
                                }
                                z = true;
                            }
                        }
                        if (!z) {
                            C4151.this.f14387.add(Integer.valueOf(iM9346));
                        }
                    }
                    for (FilterBean filterBean3 : C4151.this.f14391) {
                        Iterator it = C4151.this.f14385.iterator();
                        boolean z2 = false;
                        while (it.hasNext()) {
                            if (((C2531) it.next()).m9346() == filterBean3.getId()) {
                                z2 = true;
                            }
                        }
                        if (!z2 && !C4151.this.f14390.contains(filterBean3)) {
                            C4151.this.f14390.add(filterBean3);
                            C4151.this.f14393.add(filterBean3);
                        }
                    }
                    if (!r1.m8144(C4151.this.f14390)) {
                        C4151.this.m13166();
                        C4151.this.m13172();
                        List<C3893> listM13185 = C4151.this.m13185(null);
                        if (r1.m8144(listM13185)) {
                            C2445.m9004().m9011(listM13185, new C4161());
                        } else {
                            C4151.this.m13188(filter_groups, this.f14410.getFilters(), this.f14410.getFilter_group_collections());
                        }
                    }
                }
            }
            C4151.this.f14389 = false;
            n.InterfaceC2187 interfaceC21872 = this.f14411;
            if (interfaceC21872 != null) {
                interfaceC21872.onSuccess();
            }
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ؠ, reason: contains not printable characters */
    public class C4162 extends CallBack<FilterTokenCallback> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4169 f14414;

        public C4162(InterfaceC4169 interfaceC4169) {
            this.f14414 = interfaceC4169;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            C4151.this.f14384 = null;
            InterfaceC4169 interfaceC4169 = this.f14414;
            if (interfaceC4169 != null) {
                interfaceC4169.mo1356(2);
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(FilterTokenCallback filterTokenCallback) {
            if (C4151.this.f14384 == null) {
                return;
            }
            if (filterTokenCallback == null) {
                C4151.this.f14384 = null;
                InterfaceC4169 interfaceC4169 = this.f14414;
                if (interfaceC4169 != null) {
                    interfaceC4169.mo1356(2);
                    return;
                }
                return;
            }
            String client_nonce = filterTokenCallback.getClient_nonce();
            if (!r1.m8143(C4151.this.f14394)) {
                C4151.this.f14384 = null;
                InterfaceC4169 interfaceC41692 = this.f14414;
                if (interfaceC41692 != null) {
                    interfaceC41692.mo1356(2);
                    return;
                }
                return;
            }
            if (!C4151.this.f14394.equals(client_nonce)) {
                C4151.this.f14384 = null;
                InterfaceC4169 interfaceC41693 = this.f14414;
                if (interfaceC41693 != null) {
                    interfaceC41693.mo1356(2);
                    return;
                }
                return;
            }
            List<FilterTokenBean> download_signs = filterTokenCallback.getDownload_signs();
            if (C4151.this.f14384 == null) {
                C4151.this.m13174(this.f14414);
                return;
            }
            List<DownloadTaskBean> tasks = C4151.this.f14384.getTasks();
            if (!r1.m8144(tasks) || !r1.m8144(download_signs)) {
                C4151.this.m13174(this.f14414);
                return;
            }
            for (FilterTokenBean filterTokenBean : download_signs) {
                for (DownloadTaskBean downloadTaskBean : tasks) {
                    if (filterTokenBean.getFile_id() == downloadTaskBean.getVersion_id()) {
                        downloadTaskBean.setDownload_token(filterTokenBean.getDownload_sign());
                        downloadTaskBean.setDownload_token_timeout(filterTokenBean.getDownload_sign_timeout());
                    }
                }
            }
            InterfaceC4169 interfaceC41694 = this.f14414;
            if (interfaceC41694 != null) {
                interfaceC41694.mo1357((C4151.this.f14384.getCurrentBytesRead() * 0.9f) / C4151.this.f14384.getTotalBytesRead());
            }
            C4151.this.m13175(this.f14414);
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ހ, reason: contains not printable characters */
    public class C4163 implements C2445.InterfaceC2449 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4169 f14416;

        public C4163(InterfaceC4169 interfaceC4169) {
            this.f14416 = interfaceC4169;
        }

        @Override // defpackage.C2445.InterfaceC2449
        public void onSuc() {
            C4151.this.m13189(this.f14416);
        }

        @Override // defpackage.C2445.InterfaceC2449
        /* renamed from: Ϳ */
        public void mo9013(float f) {
            InterfaceC4169 interfaceC4169;
            if (C4151.this.f14384 == null || (interfaceC4169 = this.f14416) == null) {
                return;
            }
            interfaceC4169.mo1357((f * 0.1f) + 0.9f);
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ށ, reason: contains not printable characters */
    public class C4164 extends TypeToken<List<FilterGroupBean>> {
        public C4164() {
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ނ, reason: contains not printable characters */
    public class C4165 implements C3184.InterfaceC3217 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4169 f14419;

        public C4165(InterfaceC4169 interfaceC4169) {
            this.f14419 = interfaceC4169;
        }

        @Override // defpackage.C3184.InterfaceC3217
        /* renamed from: Ϳ */
        public void mo10874() {
            C4151.this.f14384 = null;
            C4151.this.f14385 = C3184.m10827().m10854();
            C4151.this.m13190();
            C4151.this.m13166();
            C4151.this.f14390.clear();
            C4151.this.f14393.clear();
            InterfaceC4169 interfaceC4169 = this.f14419;
            if (interfaceC4169 != null) {
                interfaceC4169.mo1356(1);
            }
            C4151.this.f14392.clear();
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ރ, reason: contains not printable characters */
    public class RunnableC4166 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2531 f14421;

        public RunnableC4166(C2531 c2531) {
            this.f14421 = c2531;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3180.m10795(this.f14421.m9347());
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ބ, reason: contains not printable characters */
    public class C4167 extends DownloadProgressCallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ DownloadTaskBean f14423;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4169 f14424;

        public C4167(DownloadTaskBean downloadTaskBean, InterfaceC4169 interfaceC4169) {
            this.f14423 = downloadTaskBean;
            this.f14424 = interfaceC4169;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.DownloadProgressCallBack
        public void onComplete(String str) {
            synchronized (C4151.this.f14396) {
                if (C4151.this.f14384 != null) {
                    C4151.this.f14384.setLastClipBytesRead(0L);
                    C4638.m14099("slimmm", "id:" + this.f14423.getId() + " onComplete");
                    this.f14423.setEndMS(System.currentTimeMillis());
                    List<C2531> doneList = C4151.this.f14384.getDoneList();
                    C2531 c2531 = new C2531();
                    if (r1.m8144(C4151.this.f14385)) {
                        for (C2531 c25312 : C4151.this.f14385) {
                            if (c25312.m9346() == this.f14423.getId()) {
                                c2531.m9351(c25312.m9345());
                            }
                        }
                    }
                    c2531.m9352(this.f14423.getId());
                    c2531.m9353(str);
                    c2531.m9356(this.f14423.getVersion_id());
                    doneList.add(c2531);
                    c2531.m9355(C4151.this.m13196(c2531));
                    C4151.this.m13192(this.f14423.getVersion_id());
                    if (C4151.this.f14384 != null) {
                        if (C4151.this.f14384.getDoneList().size() == C4151.this.f14384.getDoneCount() + C4151.this.f14384.getAlreadyDoneCount()) {
                            C4151.this.f14397 = new ArrayList();
                            C4151.this.m13165(this.f14424);
                        } else if (C4151.this.f14384.getDoneList().size() + C4151.this.f14384.getErrorList().size() == C4151.this.f14384.getAlreadyDoneCount() + C4151.this.f14384.getDoneCount()) {
                            C4151.this.m13174(this.f14424);
                        }
                    }
                }
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            apiException.printStackTrace();
            this.f14423.setEndMS(System.currentTimeMillis());
            C4151.this.m13191(this.f14423.getVersion_id());
            if (this.f14423.getRetryCount() < 3) {
                DownloadTaskBean downloadTaskBean = this.f14423;
                downloadTaskBean.setRetryCount(downloadTaskBean.getRetryCount() + 1);
                C4151.this.m13194(this.f14423, this.f14424);
            } else {
                List<Integer> errorList = C4151.this.f14384.getErrorList();
                if (errorList.indexOf(Integer.valueOf(this.f14423.getId())) < 0) {
                    errorList.add(Integer.valueOf(this.f14423.getId()));
                }
                if (C4151.this.f14384.getDoneList().size() + C4151.this.f14384.getErrorList().size() == C4151.this.f14384.getAlreadyDoneCount() + C4151.this.f14384.getDoneCount()) {
                    C4151.this.m13174(this.f14424);
                }
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
            C4638.m14099("slimmm", "id:" + this.f14423.getId() + " onStart");
        }

        @Override // com.blink.academy.film.http.okhttp.callback.DownloadProgressCallBack
        public void update(long j, long j2, boolean z) {
            if (C4151.this.f14384 != null) {
                synchronized (C4151.this.f14396) {
                }
                Long l = C4151.this.f14384.getProMap().get(Integer.valueOf(this.f14423.getId()));
                if (l == null) {
                    l = 0L;
                }
                long currentBytesRead = (C4151.this.f14384.getCurrentBytesRead() + j) - l.longValue();
                C4151.this.f14384.getProMap().put(Integer.valueOf(this.f14423.getId()), Long.valueOf(j));
                C4151.this.f14384.setCurrentBytesRead(currentBytesRead);
                InterfaceC4169 interfaceC4169 = this.f14424;
                if (interfaceC4169 != null) {
                    interfaceC4169.mo1357((currentBytesRead * 0.9f) / C4151.this.f14384.getTotalBytesRead());
                }
            }
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ޅ, reason: contains not printable characters */
    public class C4168 extends CallBack<String> {
        public C4168() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
        }
    }

    /* compiled from: FilterFileManager.java */
    /* renamed from: গ$ކ, reason: contains not printable characters */
    public interface InterfaceC4169 {
        /* renamed from: Ϳ */
        void mo1356(int i);

        /* renamed from: Ԩ */
        void mo1357(float f);
    }

    public C4151() {
        C5244 c5244M10857 = C3184.m10827().m10857();
        this.f14386 = c5244M10857;
        if (c5244M10857 != null) {
            String strM15268 = c5244M10857.m15268();
            if (r1.m8143(strM15268)) {
                this.f14388 = (List) new Gson().fromJson(strM15268, new C4159().getType());
            }
        }
        if (this.f14388 == null) {
            this.f14388 = new ArrayList();
        }
        m13190();
        m13164();
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public static C4151 m13162() {
        if (f14383 == null) {
            synchronized (C4151.class) {
                if (f14383 == null) {
                    f14383 = new C4151();
                }
            }
        }
        return f14383;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean m13163() {
        this.f14398++;
        return true;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m13164() {
        new Thread(new RunnableC4157()).start();
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m13165(InterfaceC4169 interfaceC4169) {
        StoreCallbackEntity storeCallbackEntityM7601 = n.m7588().m7601();
        if (storeCallbackEntityM7601 != null) {
            m13188(storeCallbackEntityM7601.getFilter_groups(), storeCallbackEntityM7601.getFilters(), storeCallbackEntityM7601.getFilter_group_collections());
        }
        if (this.f14386 == null) {
            if (interfaceC4169 != null) {
                interfaceC4169.mo1356(3);
            }
        } else {
            List<C3893> listM13185 = m13185(interfaceC4169);
            if (r1.m8144(listM13185)) {
                C2445.m9004().m9011(listM13185, new C4163(interfaceC4169));
            } else {
                m13189(interfaceC4169);
            }
        }
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final void m13166() {
        if (r1.m8144(this.f14387)) {
            Iterator<C2531> it = this.f14385.iterator();
            while (it.hasNext()) {
                C2531 next = it.next();
                if (this.f14387.contains(Integer.valueOf(next.m9346()))) {
                    it.remove();
                    C3184.m10827().m10843(next);
                    new Thread(new RunnableC4166(next)).start();
                }
            }
        }
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean m13167() {
        if (!r1.m8144(this.f14390)) {
            return false;
        }
        Iterator<FilterBean> it = this.f14390.iterator();
        while (it.hasNext()) {
            if (!r1.m8143(it.next().getDownload_url())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m13168() {
        this.f14384 = null;
        if (this.f14386 == null || !r1.m8144(this.f14388) || !r1.m8144(this.f14385)) {
            m13170();
            return;
        }
        List<FilterGroupBean> list = (List) new Gson().fromJson(this.f14386.m15270(), new C4154().getType());
        if (r1.m8144(list)) {
            ArrayList arrayList = new ArrayList();
            ArrayList<C2531> arrayList2 = new ArrayList();
            arrayList2.addAll(this.f14385);
            for (FilterGroupBean filterGroupBean : list) {
                if (filterGroupBean.isPurchase_required()) {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    int[] preview_filters = filterGroupBean.getPreview_filters();
                    if (r1.m8142(preview_filters)) {
                        for (int i : preview_filters) {
                            for (C2531 c2531 : arrayList2) {
                                if (i == c2531.m9346()) {
                                    sb.append(i);
                                    sb.append("_");
                                    sb2.append(c2531.m9350());
                                    sb2.append("_");
                                }
                            }
                        }
                        String string = sb.toString();
                        if (r1.m8143(string)) {
                            String strM13184 = m13184(false, string.substring(0, string.length() - 1), sb2.toString().substring(0, r4.length() - 1));
                            arrayList.add(strM13184);
                            new Thread(new RunnableC4155(strM13184)).start();
                        }
                    }
                }
            }
            if (r1.m8144(arrayList)) {
                C2445.m9004().m9010(arrayList);
            }
        }
        Iterator<C2531> it = this.f14385.iterator();
        ArrayList arrayList3 = new ArrayList();
        while (it.hasNext()) {
            C2531 next = it.next();
            if (!this.f14388.contains(Integer.valueOf(next.m9346()))) {
                arrayList3.add(next);
                new Thread(new RunnableC4156(next)).start();
                it.remove();
            }
        }
        C3184.m10827().m10844(arrayList3);
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m13169() {
        this.f14398 = 0;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public void m13170() {
        C3184.m10827().m10839();
        this.f14385 = new ArrayList();
        C3180.m10793(m13182("", true));
        C3180.m10793(m13184(true, "", ""));
        C2445.m9004().m9005();
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m13171(InterfaceC4169 interfaceC4169) {
        int size;
        String str;
        String access_token;
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (this.f14384 == null && r1.m8144(this.f14391)) {
            DownloadFilterTask downloadFilterTask = new DownloadFilterTask();
            this.f14384 = downloadFilterTask;
            downloadFilterTask.setIndex(1);
            ArrayList arrayList = new ArrayList();
            for (FilterBean filterBean : this.f14391) {
                DownloadTaskBean downloadTaskBean = new DownloadTaskBean();
                downloadTaskBean.setDownload_url(filterBean.getDownload_url());
                downloadTaskBean.setId(filterBean.getId());
                downloadTaskBean.setVersion_id(filterBean.getFile_id());
                downloadTaskBean.setHashStr(filterBean.getFile_hash());
                downloadTaskBean.setFile_size(filterBean.getFile_size());
                arrayList.add(downloadTaskBean);
            }
            this.f14384.setDoneList(new ArrayList());
            this.f14384.setErrorList(new ArrayList());
            this.f14384.setTotalBytesRead(m13178());
            if (r1.m8144(arrayList)) {
                size = arrayList.size();
                Iterator it = arrayList.iterator();
                List<C2531> listM10854 = C3184.m10827().m10854();
                while (it.hasNext()) {
                    DownloadTaskBean downloadTaskBean2 = (DownloadTaskBean) it.next();
                    String hashStr = downloadTaskBean2.getHashStr();
                    StringBuilder sb = new StringBuilder();
                    sb.append(m13181(downloadTaskBean2.getId() + ""));
                    sb.append(downloadTaskBean2.getVersion_id());
                    sb.append(".dat");
                    File file = new File(sb.toString());
                    if (file.exists() && hashStr.equals(C3180.m10801(file))) {
                        it.remove();
                        C2531 c2531 = new C2531();
                        c2531.m9356(downloadTaskBean2.getVersion_id());
                        c2531.m9352(downloadTaskBean2.getId());
                        c2531.m9353(file.getAbsolutePath());
                        if (r1.m8144(listM10854)) {
                            for (C2531 c25312 : listM10854) {
                                if (c25312.m9346() == downloadTaskBean2.getId()) {
                                    c2531.m9351(c25312.m9345());
                                }
                            }
                        }
                        c2531.m9355(m13196(c2531));
                        this.f14384.getDoneList().add(c2531);
                        this.f14384.setCurrentBytesRead(this.f14384.getCurrentBytesRead() + downloadTaskBean2.getFile_size());
                    }
                }
            } else {
                size = 0;
            }
            if (!r1.m8144(arrayList)) {
                m13165(interfaceC4169);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                sb2.append(((DownloadTaskBean) it2.next()).getVersion_id());
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.f14384.setDoneCount(arrayList.size());
            if (size > arrayList.size()) {
                this.f14384.setAlreadyDoneCount(size - arrayList.size());
            } else {
                this.f14384.setAlreadyDoneCount(0);
            }
            this.f14384.setTasks(arrayList);
            String string = sb2.toString();
            String strSubstring = string.substring(0, string.length() - 1);
            if (userBeanM5990 != null) {
                String str2 = userBeanM5990.getId() + "";
                access_token = userBeanM5990.getAccess_token();
                str = str2;
            } else {
                str = "";
                access_token = str;
            }
            String strM7592 = n.m7588().m7592();
            this.f14394 = strM7592;
            StoreController.getFilterToken(strM7592, true, str, access_token, strSubstring, new C4162(interfaceC4169));
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public void m13172() throws Throwable {
        if (r1.m8144(this.f14385)) {
            boolean z = false;
            for (C2531 c2531 : this.f14385) {
                String strM9349 = c2531.m9349();
                if (!r1.m8143(strM9349)) {
                    strM9349 = m13181(c2531.m9346() + "") + "real_" + c2531.m9350() + ".dat";
                }
                if (!new File(strM9349).exists()) {
                    z = true;
                    m13196(c2531);
                }
            }
            if (z) {
                C3184.m10827().m10832(this.f14385, new C4158());
            }
        }
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public void m13173(InterfaceC4169 interfaceC4169) {
        int size;
        String str;
        String str2;
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (r1.m8144(this.f14390) && this.f14384 == null) {
            ArrayList<FilterBean> arrayList = new ArrayList();
            arrayList.addAll(this.f14390);
            DownloadFilterTask downloadFilterTask = new DownloadFilterTask();
            this.f14384 = downloadFilterTask;
            downloadFilterTask.setIndex(2);
            ArrayList arrayList2 = new ArrayList();
            for (FilterBean filterBean : arrayList) {
                DownloadTaskBean downloadTaskBean = new DownloadTaskBean();
                downloadTaskBean.setDownload_url(filterBean.getDownload_url());
                downloadTaskBean.setId(filterBean.getId());
                downloadTaskBean.setVersion_id(filterBean.getFile_id());
                downloadTaskBean.setHashStr(filterBean.getFile_hash());
                downloadTaskBean.setFile_size(filterBean.getFile_size());
                arrayList2.add(downloadTaskBean);
            }
            this.f14384.setDoneList(new ArrayList());
            this.f14384.setErrorList(new ArrayList());
            this.f14384.setTotalBytesRead(m13187());
            if (r1.m8144(arrayList2)) {
                size = arrayList2.size();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    DownloadTaskBean downloadTaskBean2 = (DownloadTaskBean) it.next();
                    String hashStr = downloadTaskBean2.getHashStr();
                    StringBuilder sb = new StringBuilder();
                    sb.append(m13181(downloadTaskBean2.getId() + ""));
                    sb.append(downloadTaskBean2.getVersion_id());
                    sb.append(".dat");
                    File file = new File(sb.toString());
                    if (file.exists() && hashStr.equals(C3180.m10801(file))) {
                        it.remove();
                        C2531 c2531 = new C2531();
                        c2531.m9356(downloadTaskBean2.getVersion_id());
                        c2531.m9352(downloadTaskBean2.getId());
                        c2531.m9353(file.getAbsolutePath());
                        c2531.m9355(m13196(c2531));
                        this.f14384.getDoneList().add(c2531);
                        this.f14384.setCurrentBytesRead(this.f14384.getCurrentBytesRead() + downloadTaskBean2.getFile_size());
                    }
                }
            } else {
                size = 0;
            }
            if (!r1.m8144(arrayList2)) {
                m13165(interfaceC4169);
                C4638.m14099("slimmm", "update done for cache");
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                sb2.append(((DownloadTaskBean) it2.next()).getVersion_id());
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.f14384.setDoneCount(arrayList2.size());
            if (size > arrayList2.size()) {
                this.f14384.setAlreadyDoneCount(size - arrayList2.size());
            } else {
                this.f14384.setAlreadyDoneCount(0);
            }
            this.f14384.setTasks(arrayList2);
            String strSubstring = sb2.toString().substring(0, r1.length() - 1);
            if (userBeanM5990 != null) {
                str = userBeanM5990.getId() + "";
                str2 = userBeanM5990.getAccess_token() + "";
            } else {
                str = "";
                str2 = str;
            }
            String strM7592 = n.m7588().m7592();
            this.f14394 = strM7592;
            StoreController.getFilterToken(strM7592, true, str, str2, strSubstring, new C4153(interfaceC4169));
        }
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final void m13174(InterfaceC4169 interfaceC4169) {
        this.f14384 = null;
        if (interfaceC4169 != null) {
            interfaceC4169.mo1356(2);
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final void m13175(InterfaceC4169 interfaceC4169) {
        DownloadFilterTask downloadFilterTask = this.f14384;
        if (downloadFilterTask != null) {
            Iterator<DownloadTaskBean> it = downloadFilterTask.getTasks().iterator();
            while (it.hasNext()) {
                m13194(it.next(), interfaceC4169);
            }
        }
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public int m13176() {
        DownloadFilterTask downloadFilterTask = this.f14384;
        if (downloadFilterTask != null) {
            return 1 == downloadFilterTask.getIndex() ? 3 : 4;
        }
        if (r1.m8144(this.f14385) && r1.m8144(C2445.m9004().m9008())) {
            return r1.m8144(this.f14390) ? 1 : 0;
        }
        return 2;
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public String m13177(C2531 c2531) {
        StringBuilder sb = new StringBuilder();
        sb.append(m13162().m13181(c2531.m9346() + ""));
        sb.append("real_");
        sb.append(c2531.m9350());
        sb.append(".dat");
        return sb.toString();
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public long m13178() {
        long file_size = 0;
        if (r1.m8144(this.f14391)) {
            Iterator<FilterBean> it = this.f14391.iterator();
            while (it.hasNext()) {
                file_size += it.next().getFile_size();
            }
        }
        return file_size;
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public List<C2531> m13179() {
        return this.f14385;
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public C5244 m13180() {
        return this.f14386;
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public String m13181(String str) {
        return m13182(str, false);
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public String m13182(String str, boolean z) {
        String strM12993 = C4062.m12993();
        String str2 = strM12993 + str + "/";
        if (!z) {
            strM12993 = str2;
        }
        File file = new File(strM12993);
        if (!file.exists()) {
            file.mkdirs();
        }
        return strM12993;
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public List<FilterBean> m13183() {
        return this.f14392;
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public String m13184(boolean z, String str, String str2) {
        String strM12992 = C4062.m12992();
        String str3 = strM12992 + str + "/" + str2 + ".jpg";
        if (!z) {
            strM12992 = str3;
        }
        File file = new File(strM12992);
        if (!file.exists()) {
            if (z) {
                file.mkdirs();
            } else {
                file.getParentFile().mkdirs();
            }
        }
        return strM12992;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01cc A[SYNTHETIC] */
    /* renamed from: ޱ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<defpackage.C3893> m13185(defpackage.C4151.InterfaceC4169 r17) {
        /*
            Method dump skipped, instructions count: 469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C4151.m13185(গ$ކ):java.util.List");
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public int m13186() {
        return this.f14398;
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public long m13187() {
        long file_size = 0;
        if (r1.m8144(this.f14390)) {
            Iterator<FilterBean> it = this.f14390.iterator();
            while (it.hasNext()) {
                file_size += it.next().getFile_size();
            }
        }
        return file_size;
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public final void m13188(List<FilterGroupBean> list, List<FilterBean> list2, List<FilterGroupCollectionBean> list3) {
        if (r1.m8144(list)) {
            C5244 c5244 = this.f14386;
            if (c5244 != null) {
                c5244.m15275(new Gson().toJson(list));
                this.f14386.m15272(new Gson().toJson(list2));
                this.f14386.m15274(new Gson().toJson(list3));
                this.f14386.m15273(new Gson().toJson(this.f14388));
                C3184.m10827().m10868(this.f14386);
                return;
            }
            C5244 c52442 = new C5244();
            this.f14386 = c52442;
            c52442.m15275(new Gson().toJson(list));
            this.f14386.m15272(new Gson().toJson(list2));
            this.f14386.m15274(new Gson().toJson(list3));
            this.f14386.m15273(new Gson().toJson(this.f14388));
            C3184.m10827().m10833(this.f14386);
        }
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public final void m13189(InterfaceC4169 interfaceC4169) {
        if (this.f14384 == null) {
            return;
        }
        C3184.m10827().m10832(this.f14384.getDoneList(), new C4165(interfaceC4169));
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public final void m13190() {
        if (!r1.m8144(this.f14385)) {
            C4638.m14099("slimm", "mLocalFilterBeans size 0");
            return;
        }
        C4638.m14099("slimm", "mLocalFilterBeans size:" + this.f14385.size());
        Iterator<C2531> it = this.f14385.iterator();
        while (it.hasNext()) {
            C4638.m14099("slimm", "" + it.next().toString());
        }
        C4638.m14099("slimm", "mLocalFilterBeans print done");
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public final void m13191(int i) {
        String access_token;
        String str;
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (userBeanM5990 != null) {
            str = "" + userBeanM5990.getId();
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
            str = access_token;
        }
        StoreController.FilterRecordFail("filter", str, access_token, i + "", new C4168());
    }

    /* renamed from: ࡤ, reason: contains not printable characters */
    public final void m13192(int i) {
        String access_token;
        String str;
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (userBeanM5990 != null) {
            str = "" + userBeanM5990.getId();
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
            str = access_token;
        }
        StoreController.FilterRecordSuc("filter", str, access_token, i + "", new C4152());
    }

    /* renamed from: ࡥ, reason: contains not printable characters */
    public void m13193(StoreCallbackEntity storeCallbackEntity, n.InterfaceC2187 interfaceC2187) {
        FilmApp.m405().m427(new RunnableC4160(storeCallbackEntity, interfaceC2187));
    }

    /* renamed from: ࡦ, reason: contains not printable characters */
    public final void m13194(DownloadTaskBean downloadTaskBean, InterfaceC4169 interfaceC4169) {
        String str = downloadTaskBean.getDownload_url() + "?sign=" + downloadTaskBean.getDownload_token() + "&t=" + downloadTaskBean.getDownload_token_timeout();
        if (downloadTaskBean.getStartMS() == 0) {
            downloadTaskBean.setStartMS(System.currentTimeMillis());
        }
        this.f14397.add(OkHttpUtils.downLoad(str).connectTimeout(15000L).writeTimeOut(15000L).readTimeOut(15000L).headers("Referer", "https://protake.dafork.com/download/sign").savePath(m13181(downloadTaskBean.getId() + "")).saveName("" + downloadTaskBean.getVersion_id() + ".dat").execute(new C4167(downloadTaskBean, interfaceC4169)));
    }

    /* renamed from: ࡧ, reason: contains not printable characters */
    public void m13195() {
        if (r1.m8144(this.f14397)) {
            for (InterfaceC4478 interfaceC4478 : this.f14397) {
                if (interfaceC4478 != null) {
                    interfaceC4478.dispose();
                }
            }
            this.f14397 = new ArrayList();
        }
        this.f14384 = null;
        m13169();
    }

    /* renamed from: ࡨ, reason: contains not printable characters */
    public String m13196(C2531 c2531) throws Throwable {
        String str = m13181(c2531.m9346() + "") + "real_" + c2531.m9350() + ".dat";
        String strM9347 = c2531.m9347();
        if (new File(strM9347).exists()) {
            C3180.m10809(C3927.m12688(C5015.m14802(strM9347)), str);
        }
        return str;
    }
}
