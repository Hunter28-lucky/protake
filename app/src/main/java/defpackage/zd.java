package defpackage;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zd implements jb {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static zd f8790;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static DataReportResult f8791;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public w f8792;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public BugTrackMessageService f8793;

    /* renamed from: ԩ, reason: contains not printable characters */
    public DataReportService f8794;

    public zd(Context context, String str) {
        this.f8792 = null;
        this.f8793 = null;
        this.f8794 = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.f8792 = hVar;
        this.f8793 = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.f8794 = (DataReportService) this.f8792.a(DataReportService.class, aaVar);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static synchronized zd m8673(Context context, String str) {
        if (f8790 == null) {
            f8790 = new zd(context, str);
        }
        return f8790;
    }

    @Override // defpackage.jb
    public boolean logCollect(String str) {
        BugTrackMessageService bugTrackMessageService;
        if (ua.m8370(str) || (bugTrackMessageService = this.f8793) == null) {
            return false;
        }
        String strLogCollect = null;
        try {
            strLogCollect = bugTrackMessageService.logCollect(ua.m8377(str));
        } catch (Throwable unused) {
        }
        if (ua.m8370(strLogCollect)) {
            return false;
        }
        return ((Boolean) new JSONObject(strLogCollect).get("success")).booleanValue();
    }

    @Override // defpackage.jb
    /* renamed from: Ϳ */
    public DataReportResult mo7110(DataReportRequest dataReportRequest) throws InterruptedException {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.f8794 != null) {
            f8791 = null;
            new Thread(new bd(this, dataReportRequest)).start();
            for (int i = 300000; f8791 == null && i >= 0; i -= 50) {
                Thread.sleep(50L);
            }
        }
        return f8791;
    }
}
