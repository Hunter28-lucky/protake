package com.blink.academy.film.support.stream.ts;

/* loaded from: classes.dex */
class TsFilter {
    public final TsCallback mTsCallback;
    public final int needTsPid;

    public interface TsCallback {
        void onTsReceived(byte[] bArr);
    }

    public TsFilter(int i, TsCallback tsCallback) {
        this.needTsPid = i;
        this.mTsCallback = tsCallback;
    }

    public void filterTsStream(byte[] bArr) {
        if (new TsPacket(bArr).mTsHeader.pid == this.needTsPid) {
            this.mTsCallback.onTsReceived(bArr);
        }
    }
}
