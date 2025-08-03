package defpackage;

import android.app.Activity;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;

/* compiled from: TextResultHandler.java */
/* loaded from: classes.dex */
public final class q1 extends AbstractC4118 {

    /* renamed from: ֏, reason: contains not printable characters */
    public static final int[] f8316 = new int[0];

    public q1(Activity activity, ParsedResult parsedResult, Result result) {
        super(activity, parsedResult, result);
    }

    @Override // defpackage.AbstractC4118
    /* renamed from: Ԭ, reason: contains not printable characters */
    public void mo7996(int i) {
        String displayResult = m13063().getDisplayResult();
        if (i == 0) {
            m13072(displayResult);
            return;
        }
        if (i == 1) {
            m13070(displayResult);
        } else if (i == 2) {
            m13071(displayResult);
        } else {
            if (i != 3) {
                return;
            }
            m13066(m13060(displayResult));
        }
    }
}
