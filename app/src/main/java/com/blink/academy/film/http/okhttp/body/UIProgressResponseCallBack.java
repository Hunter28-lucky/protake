package com.blink.academy.film.http.okhttp.body;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class UIProgressResponseCallBack implements ProgressResponseCallBack {
    private static final int RESPONSE_UPDATE = 2;
    private final Handler mHandler = new HandlerC0367(Looper.getMainLooper(), this);

    public class ProgressModel implements Serializable {
        private long contentLength;
        private long currentBytes;
        private boolean done;

        public ProgressModel(long j, long j2, boolean z) {
            this.currentBytes = j;
            this.contentLength = j2;
            this.done = z;
        }

        public long getContentLength() {
            return this.contentLength;
        }

        public long getCurrentBytes() {
            return this.currentBytes;
        }

        public boolean isDone() {
            return this.done;
        }

        public ProgressModel setContentLength(long j) {
            this.contentLength = j;
            return this;
        }

        public ProgressModel setCurrentBytes(long j) {
            this.currentBytes = j;
            return this;
        }

        public ProgressModel setDone(boolean z) {
            this.done = z;
            return this;
        }

        public String toString() {
            return "ProgressModel{currentBytes=" + this.currentBytes + ", contentLength=" + this.contentLength + ", done=" + this.done + '}';
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.body.UIProgressResponseCallBack$Ϳ, reason: contains not printable characters */
    public static class HandlerC0367 extends Handler {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final WeakReference<UIProgressResponseCallBack> f913;

        public HandlerC0367(Looper looper, UIProgressResponseCallBack uIProgressResponseCallBack) {
            super(looper);
            this.f913 = new WeakReference<>(uIProgressResponseCallBack);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            UIProgressResponseCallBack uIProgressResponseCallBack = this.f913.get();
            if (uIProgressResponseCallBack != null) {
                ProgressModel progressModel = (ProgressModel) message.obj;
                uIProgressResponseCallBack.onUIResponseProgress(progressModel.getCurrentBytes(), progressModel.getContentLength(), progressModel.isDone());
            }
        }
    }

    @Override // com.blink.academy.film.http.okhttp.body.ProgressResponseCallBack
    public void onResponseProgress(long j, long j2, boolean z) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = new ProgressModel(j, j2, z);
        messageObtain.what = 2;
        this.mHandler.sendMessage(messageObtain);
    }

    public abstract void onUIResponseProgress(long j, long j2, boolean z);
}
