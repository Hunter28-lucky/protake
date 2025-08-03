package com.blink.academy.film.http.okhttp.subsciber;

import android.content.Context;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.callback.DownloadProgressCallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import defpackage.AbstractC4262;
import defpackage.AbstractC4809;
import defpackage.C4000;
import defpackage.C4638;
import defpackage.InterfaceC2857;

/* loaded from: classes.dex */
public class DownloadSubscriber<ResponseBody extends AbstractC4809> extends BaseSubscriber<ResponseBody> {
    private static String APK_CONTENTTYPE = "application/vnd.android.package-archive";
    private static String JPG_CONTENTTYPE = "image/jpg";
    private static String PNG_CONTENTTYPE = "image/png";
    private static String fileSuffix = "";
    private Context context;
    private long lastRefreshUiTime;
    public CallBack mCallBack;
    private String name;
    private String path;

    /* renamed from: com.blink.academy.film.http.okhttp.subsciber.DownloadSubscriber$Ϳ, reason: contains not printable characters */
    public class C0431 implements InterfaceC2857<Long> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ CallBack f993;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ long f994;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ long f995;

        public C0431(CallBack callBack, long j, long j2) {
            this.f993 = callBack;
            this.f994 = j;
            this.f995 = j2;
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            CallBack callBack = this.f993;
            if (callBack instanceof DownloadProgressCallBack) {
                DownloadProgressCallBack downloadProgressCallBack = (DownloadProgressCallBack) callBack;
                long j = this.f994;
                long j2 = this.f995;
                downloadProgressCallBack.update(j, j2, j == j2);
            }
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.subsciber.DownloadSubscriber$Ԩ, reason: contains not printable characters */
    public class C0432 implements InterfaceC2857<Throwable> {
        public C0432() {
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.subsciber.DownloadSubscriber$Ԫ, reason: contains not printable characters */
    public class C0433 implements InterfaceC2857<String> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ CallBack f998;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC4809 f999;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ String f1000;

        public C0433(CallBack callBack, AbstractC4809 abstractC4809, String str) {
            this.f998 = callBack;
            this.f999 = abstractC4809;
            this.f1000 = str;
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            if (this.f998 instanceof DownloadProgressCallBack) {
                this.f999.close();
                ((DownloadProgressCallBack) this.f998).onComplete(this.f1000);
            }
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.subsciber.DownloadSubscriber$Ԭ, reason: contains not printable characters */
    public class C0434 implements InterfaceC2857<Throwable> {
        public C0434() {
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.subsciber.DownloadSubscriber$Ԯ, reason: contains not printable characters */
    public class C0435 implements InterfaceC2857<ApiException> {
        public C0435() {
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(ApiException apiException) throws Exception {
            CallBack callBack = DownloadSubscriber.this.mCallBack;
            if (callBack != null) {
                callBack.onError(apiException);
            }
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.subsciber.DownloadSubscriber$ՠ, reason: contains not printable characters */
    public class C0436 implements InterfaceC2857<Throwable> {
        public C0436() {
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public DownloadSubscriber(Context context, String str, String str2, CallBack callBack) {
        super(context);
        this.path = str;
        this.name = str2;
        this.mCallBack = callBack;
        this.context = context;
        this.lastRefreshUiTime = System.currentTimeMillis();
    }

    private void finalonError(Exception exc) {
        if (this.mCallBack == null) {
            return;
        }
        AbstractC4262.just(new ApiException(exc, 100)).observeOn(C4000.m12867()).subscribe(new C0435(), new C0436());
    }

    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0265 A[Catch: IOException -> 0x027e, TryCatch #7 {IOException -> 0x027e, blocks: (B:26:0x0101, B:38:0x018e, B:85:0x0270, B:87:0x0275, B:89:0x027a, B:90:0x027d, B:77:0x0260, B:79:0x0265, B:81:0x026a), top: B:94:0x0101 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x026a A[Catch: IOException -> 0x027e, TryCatch #7 {IOException -> 0x027e, blocks: (B:26:0x0101, B:38:0x018e, B:85:0x0270, B:87:0x0275, B:89:0x027a, B:90:0x027d, B:77:0x0260, B:79:0x0265, B:81:0x026a), top: B:94:0x0101 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0275 A[Catch: IOException -> 0x027e, TryCatch #7 {IOException -> 0x027e, blocks: (B:26:0x0101, B:38:0x018e, B:85:0x0270, B:87:0x0275, B:89:0x027a, B:90:0x027d, B:77:0x0260, B:79:0x0265, B:81:0x026a), top: B:94:0x0101 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x027a A[Catch: IOException -> 0x027e, TryCatch #7 {IOException -> 0x027e, blocks: (B:26:0x0101, B:38:0x018e, B:85:0x0270, B:87:0x0275, B:89:0x027a, B:90:0x027d, B:77:0x0260, B:79:0x0265, B:81:0x026a), top: B:94:0x0101 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean writeResponseBodyToDisk(java.lang.String r22, java.lang.String r23, android.content.Context r24, defpackage.AbstractC4809 r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.http.okhttp.subsciber.DownloadSubscriber.writeResponseBodyToDisk(java.lang.String, java.lang.String, android.content.Context, ඦ):boolean");
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber, defpackage.InterfaceC5102
    public final void onComplete() {
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber
    public void onError(ApiException apiException) {
        C4638.m14098("DownSubscriber:>>>> onError:" + apiException.getMessage());
        finalonError(apiException);
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber, defpackage.AbstractC5105
    public void onStart() {
        super.onStart();
        CallBack callBack = this.mCallBack;
        if (callBack != null) {
            callBack.onStart();
        }
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber, defpackage.InterfaceC5102
    public void onNext(ResponseBody responsebody) throws Throwable {
        C4638.m14098("DownSubscriber:>>>> onNext");
        writeResponseBodyToDisk(this.path, this.name, this.context, responsebody);
    }
}
