package defpackage;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class wb {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static be m8525(DataReportResult dataReportResult) {
        be beVar = new be();
        if (dataReportResult == null) {
            return null;
        }
        beVar.f8685 = dataReportResult.success;
        beVar.f8686 = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            beVar.f151 = map.get("apdid");
            beVar.f152 = map.get("apdidToken");
            beVar.f155 = map.get("dynamicKey");
            beVar.f156 = map.get("timeInterval");
            beVar.f157 = map.get("webrtcUrl");
            beVar.f158 = "";
            String str = map.get("drmSwitch");
            if (ua.m8373(str)) {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(0));
                    beVar.f153 = sb.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(2));
                    beVar.f154 = sb2.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                beVar.f159 = map.get("apse_degrade");
            }
        }
        return beVar;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static DataReportRequest m8526(df dfVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dfVar == null) {
            return null;
        }
        dataReportRequest.os = dfVar.f6567;
        dataReportRequest.rpcVersion = dfVar.f6576;
        dataReportRequest.bizType = "1";
        HashMap map = new HashMap();
        dataReportRequest.bizData = map;
        map.put("apdid", dfVar.f6568);
        dataReportRequest.bizData.put("apdidToken", dfVar.f6569);
        dataReportRequest.bizData.put("umidToken", dfVar.f6570);
        dataReportRequest.bizData.put("dynamicKey", dfVar.f6571);
        dataReportRequest.deviceData = dfVar.f6572;
        return dataReportRequest;
    }
}
