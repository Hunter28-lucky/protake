package com.github.thibaultbee.srtdroid.models.rejectreason;

/* compiled from: UserDefinedRejectReason.kt */
/* loaded from: classes.dex */
public final class UserDefinedRejectReason extends RejectReason {
    private final int code;

    public UserDefinedRejectReason(int i) {
        this.code = i;
    }

    public static /* synthetic */ UserDefinedRejectReason copy$default(UserDefinedRejectReason userDefinedRejectReason, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = userDefinedRejectReason.code;
        }
        return userDefinedRejectReason.copy(i);
    }

    public final int component1() {
        return this.code;
    }

    public final UserDefinedRejectReason copy(int i) {
        return new UserDefinedRejectReason(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof UserDefinedRejectReason) && this.code == ((UserDefinedRejectReason) obj).code;
        }
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public int hashCode() {
        return this.code;
    }

    public String toString() {
        return "UserDefinedRejectReason(code=" + this.code + ")";
    }
}
