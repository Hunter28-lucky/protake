package defpackage;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* loaded from: classes.dex */
public class bd implements Runnable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final /* synthetic */ DataReportRequest f149;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final /* synthetic */ zd f150;

    public bd(zd zdVar, DataReportRequest dataReportRequest) {
        this.f150 = zdVar;
        this.f149 = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DataReportResult unused = zd.f8791 = this.f150.f8794.reportData(this.f149);
        } catch (Throwable th) {
            DataReportResult unused2 = zd.f8791 = new DataReportResult();
            zd.f8791.success = false;
            zd.f8791.resultCode = "static data rpc upload error, " + ua.m8368(th);
            ua.m8368(th);
        }
    }
}
