package com.github.thibaultbee.srtdroid.models;

import com.github.thibaultbee.srtdroid.enums.Boundary;
import defpackage.C3921;
import defpackage.C4184;

/* compiled from: MsgCtrl.kt */
/* loaded from: classes.dex */
public final class MsgCtrl {
    private final Boundary boundary;
    private final int flags;
    private final boolean inOrder;
    private final int no;
    private final int pktSeq;
    private final long srcTime;
    private final int ttl;

    public MsgCtrl() {
        this(0, 0, false, null, 0L, 0, 0, 127, null);
    }

    public MsgCtrl(int i, int i2, boolean z, Boundary boundary, long j, int i3, int i4) {
        C3921.m12666(boundary, "boundary");
        this.flags = i;
        this.ttl = i2;
        this.inOrder = z;
        this.boundary = boundary;
        this.srcTime = j;
        this.pktSeq = i3;
        this.no = i4;
    }

    public final int component1() {
        return this.flags;
    }

    public final int component2() {
        return this.ttl;
    }

    public final boolean component3() {
        return this.inOrder;
    }

    public final Boundary component4() {
        return this.boundary;
    }

    public final long component5() {
        return this.srcTime;
    }

    public final int component6() {
        return this.pktSeq;
    }

    public final int component7() {
        return this.no;
    }

    public final MsgCtrl copy(int i, int i2, boolean z, Boundary boundary, long j, int i3, int i4) {
        C3921.m12666(boundary, "boundary");
        return new MsgCtrl(i, i2, z, boundary, j, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgCtrl)) {
            return false;
        }
        MsgCtrl msgCtrl = (MsgCtrl) obj;
        return this.flags == msgCtrl.flags && this.ttl == msgCtrl.ttl && this.inOrder == msgCtrl.inOrder && C3921.m12662(this.boundary, msgCtrl.boundary) && this.srcTime == msgCtrl.srcTime && this.pktSeq == msgCtrl.pktSeq && this.no == msgCtrl.no;
    }

    public final Boundary getBoundary() {
        return this.boundary;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final boolean getInOrder() {
        return this.inOrder;
    }

    public final int getNo() {
        return this.no;
    }

    public final int getPktSeq() {
        return this.pktSeq;
    }

    public final long getSrcTime() {
        return this.srcTime;
    }

    public final int getTtl() {
        return this.ttl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = ((this.flags * 31) + this.ttl) * 31;
        boolean z = this.inOrder;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        Boundary boundary = this.boundary;
        int iHashCode = (i3 + (boundary != null ? boundary.hashCode() : 0)) * 31;
        long j = this.srcTime;
        return ((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + this.pktSeq) * 31) + this.no;
    }

    public String toString() {
        return "MsgCtrl(flags=" + this.flags + ", ttl=" + this.ttl + ", inOrder=" + this.inOrder + ", boundary=" + this.boundary + ", srcTime=" + this.srcTime + ", pktSeq=" + this.pktSeq + ", no=" + this.no + ")";
    }

    public /* synthetic */ MsgCtrl(int i, int i2, boolean z, Boundary boundary, long j, int i3, int i4, int i5, C4184 c4184) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? -1 : i2, (i5 & 4) == 0 ? z : false, (i5 & 8) != 0 ? Boundary.SUBSEQUENT : boundary, (i5 & 16) != 0 ? 0L : j, (i5 & 32) != 0 ? -1 : i3, (i5 & 64) == 0 ? i4 : -1);
    }
}
