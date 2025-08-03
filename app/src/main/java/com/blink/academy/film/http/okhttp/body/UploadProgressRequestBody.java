package com.blink.academy.film.http.okhttp.body;

import defpackage.AbstractC2613;
import defpackage.C2314;
import defpackage.C4638;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: classes.dex */
public class UploadProgressRequestBody extends AbstractC2613 {
    public CountingSink countingSink;
    public AbstractC2613 delegate;
    public ProgressResponseCallBack progressCallBack;

    public final class CountingSink extends ForwardingSink {
        private long bytesWritten;
        private long contentLength;
        private long lastRefreshUiTime;

        public CountingSink(Sink sink) {
            super(sink);
            this.bytesWritten = 0L;
            this.contentLength = 0L;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            if (this.contentLength <= 0) {
                this.contentLength = UploadProgressRequestBody.this.contentLength();
            }
            this.bytesWritten += j;
            if (System.currentTimeMillis() - this.lastRefreshUiTime >= 100 || this.bytesWritten == this.contentLength) {
                ProgressResponseCallBack progressResponseCallBack = UploadProgressRequestBody.this.progressCallBack;
                long j2 = this.bytesWritten;
                long j3 = this.contentLength;
                progressResponseCallBack.onResponseProgress(j2, j3, j2 == j3);
                this.lastRefreshUiTime = System.currentTimeMillis();
            }
            C4638.m14103("bytesWritten=" + this.bytesWritten + " ,totalBytesCount=" + this.contentLength);
        }
    }

    public UploadProgressRequestBody(ProgressResponseCallBack progressResponseCallBack) {
        this.progressCallBack = progressResponseCallBack;
    }

    @Override // defpackage.AbstractC2613
    public long contentLength() {
        try {
            return this.delegate.contentLength();
        } catch (IOException e2) {
            C4638.m14100(e2.getMessage());
            return -1L;
        }
    }

    @Override // defpackage.AbstractC2613
    public C2314 contentType() {
        return this.delegate.contentType();
    }

    public void setRequestBody(AbstractC2613 abstractC2613) {
        this.delegate = abstractC2613;
    }

    @Override // defpackage.AbstractC2613
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        CountingSink countingSink = new CountingSink(bufferedSink);
        this.countingSink = countingSink;
        BufferedSink bufferedSinkBuffer = Okio.buffer(countingSink);
        this.delegate.writeTo(bufferedSinkBuffer);
        bufferedSinkBuffer.flush();
    }

    public UploadProgressRequestBody(AbstractC2613 abstractC2613, ProgressResponseCallBack progressResponseCallBack) {
        this.delegate = abstractC2613;
        this.progressCallBack = progressResponseCallBack;
    }
}
