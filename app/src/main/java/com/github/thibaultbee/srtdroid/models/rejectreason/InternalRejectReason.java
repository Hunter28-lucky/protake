package com.github.thibaultbee.srtdroid.models.rejectreason;

import com.github.thibaultbee.srtdroid.enums.RejectReasonCode;
import defpackage.C3921;

/* compiled from: InternalRejectReason.kt */
/* loaded from: classes.dex */
public final class InternalRejectReason extends RejectReason {
    private final RejectReasonCode code;

    public InternalRejectReason(RejectReasonCode rejectReasonCode) {
        C3921.m12666(rejectReasonCode, "code");
        this.code = rejectReasonCode;
    }

    public static /* synthetic */ InternalRejectReason copy$default(InternalRejectReason internalRejectReason, RejectReasonCode rejectReasonCode, int i, Object obj) {
        if ((i & 1) != 0) {
            rejectReasonCode = internalRejectReason.code;
        }
        return internalRejectReason.copy(rejectReasonCode);
    }

    public final RejectReasonCode component1() {
        return this.code;
    }

    public final InternalRejectReason copy(RejectReasonCode rejectReasonCode) {
        C3921.m12666(rejectReasonCode, "code");
        return new InternalRejectReason(rejectReasonCode);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof InternalRejectReason) && C3921.m12662(this.code, ((InternalRejectReason) obj).code);
        }
        return true;
    }

    public final RejectReasonCode getCode() {
        return this.code;
    }

    public int hashCode() {
        RejectReasonCode rejectReasonCode = this.code;
        if (rejectReasonCode != null) {
            return rejectReasonCode.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "InternalRejectReason(code=" + this.code + ")";
    }
}
