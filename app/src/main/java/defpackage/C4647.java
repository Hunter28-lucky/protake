package defpackage;

import com.blink.academy.film.zxing.CaptureActivity;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.google.zxing.client.result.ResultParser;

/* compiled from: ResultHandlerFactory.java */
/* renamed from: ಯ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4647 {

    /* compiled from: ResultHandlerFactory.java */
    /* renamed from: ಯ$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C4648 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f15815 = new int[ParsedResultType.values().length];
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static AbstractC4118 m14117(CaptureActivity captureActivity, Result result) {
        ParsedResult parsedResultM14118 = m14118(result);
        int i = C4648.f15815[parsedResultM14118.getType().ordinal()];
        return new q1(captureActivity, parsedResultM14118, result);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static ParsedResult m14118(Result result) {
        return ResultParser.parseResult(result);
    }
}
