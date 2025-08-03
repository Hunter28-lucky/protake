package retrofit2;

import defpackage.AbstractC4809;
import defpackage.C2314;
import defpackage.C4539;
import defpackage.C4770;
import defpackage.InterfaceC3428;
import defpackage.InterfaceC5054;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

/* loaded from: classes2.dex */
final class OkHttpCall<T> implements Call<T> {

    @Nullable
    private final Object[] args;
    private volatile boolean canceled;

    @GuardedBy("this")
    @Nullable
    private Throwable creationFailure;

    @GuardedBy("this")
    private boolean executed;

    @GuardedBy("this")
    @Nullable
    private InterfaceC5054 rawCall;
    private final ServiceMethod<T, ?> serviceMethod;

    public static final class ExceptionCatchingRequestBody extends AbstractC4809 {
        private final AbstractC4809 delegate;
        public IOException thrownException;

        public ExceptionCatchingRequestBody(AbstractC4809 abstractC4809) {
            this.delegate = abstractC4809;
        }

        @Override // defpackage.AbstractC4809, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // defpackage.AbstractC4809
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // defpackage.AbstractC4809
        public C2314 contentType() {
            return this.delegate.contentType();
        }

        @Override // defpackage.AbstractC4809
        public BufferedSource source() {
            return Okio.buffer(new ForwardingSource(this.delegate.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingRequestBody.1
                @Override // okio.ForwardingSource, okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    try {
                        return super.read(buffer, j);
                    } catch (IOException e2) {
                        ExceptionCatchingRequestBody.this.thrownException = e2;
                        throw e2;
                    }
                }
            });
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends AbstractC4809 {
        private final long contentLength;
        private final C2314 contentType;

        public NoContentResponseBody(C2314 c2314, long j) {
            this.contentType = c2314;
            this.contentLength = j;
        }

        @Override // defpackage.AbstractC4809
        public long contentLength() {
            return this.contentLength;
        }

        @Override // defpackage.AbstractC4809
        public C2314 contentType() {
            return this.contentType;
        }

        @Override // defpackage.AbstractC4809
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(ServiceMethod<T, ?> serviceMethod, @Nullable Object[] objArr) {
        this.serviceMethod = serviceMethod;
        this.args = objArr;
    }

    private InterfaceC5054 createRawCall() throws IOException {
        InterfaceC5054 call = this.serviceMethod.toCall(this.args);
        if (call != null) {
            return call;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    @Override // retrofit2.Call
    public void cancel() {
        InterfaceC5054 interfaceC5054;
        this.canceled = true;
        synchronized (this) {
            interfaceC5054 = this.rawCall;
        }
        if (interfaceC5054 != null) {
            interfaceC5054.cancel();
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        InterfaceC5054 interfaceC5054;
        Throwable th;
        Utils.checkNotNull(callback, "callback == null");
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            interfaceC5054 = this.rawCall;
            th = this.creationFailure;
            if (interfaceC5054 == null && th == null) {
                try {
                    InterfaceC5054 interfaceC5054CreateRawCall = createRawCall();
                    this.rawCall = interfaceC5054CreateRawCall;
                    interfaceC5054 = interfaceC5054CreateRawCall;
                } catch (Throwable th2) {
                    th = th2;
                    Utils.throwIfFatal(th);
                    this.creationFailure = th;
                }
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            interfaceC5054.cancel();
        }
        interfaceC5054.mo9226(new InterfaceC3428() { // from class: retrofit2.OkHttpCall.1
            private void callFailure(Throwable th3) {
                try {
                    callback.onFailure(OkHttpCall.this, th3);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }

            @Override // defpackage.InterfaceC3428
            public void onFailure(InterfaceC5054 interfaceC50542, IOException iOException) {
                callFailure(iOException);
            }

            @Override // defpackage.InterfaceC3428
            public void onResponse(InterfaceC5054 interfaceC50542, C4770 c4770) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(c4770));
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                } catch (Throwable th4) {
                    callFailure(th4);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        InterfaceC5054 interfaceC5054CreateRawCall;
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            Throwable th = this.creationFailure;
            if (th != null) {
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw ((Error) th);
            }
            interfaceC5054CreateRawCall = this.rawCall;
            if (interfaceC5054CreateRawCall == null) {
                try {
                    interfaceC5054CreateRawCall = createRawCall();
                    this.rawCall = interfaceC5054CreateRawCall;
                } catch (IOException | Error | RuntimeException e2) {
                    Utils.throwIfFatal(e2);
                    this.creationFailure = e2;
                    throw e2;
                }
            }
        }
        if (this.canceled) {
            interfaceC5054CreateRawCall.cancel();
        }
        return parseResponse(interfaceC5054CreateRawCall.execute());
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            InterfaceC5054 interfaceC5054 = this.rawCall;
            if (interfaceC5054 == null || !interfaceC5054.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> parseResponse(C4770 c4770) throws IOException {
        AbstractC4809 abstractC4809M14330 = c4770.m14330();
        C4770 c4770M14351 = c4770.m14343().m14350(new NoContentResponseBody(abstractC4809M14330.contentType(), abstractC4809M14330.contentLength())).m14351();
        int iM14334 = c4770M14351.m14334();
        if (iM14334 < 200 || iM14334 >= 300) {
            try {
                return Response.error(Utils.buffer(abstractC4809M14330), c4770M14351);
            } finally {
                abstractC4809M14330.close();
            }
        }
        if (iM14334 == 204 || iM14334 == 205) {
            abstractC4809M14330.close();
            return Response.success((Object) null, c4770M14351);
        }
        ExceptionCatchingRequestBody exceptionCatchingRequestBody = new ExceptionCatchingRequestBody(abstractC4809M14330);
        try {
            return Response.success(this.serviceMethod.toResponse(exceptionCatchingRequestBody), c4770M14351);
        } catch (RuntimeException e2) {
            exceptionCatchingRequestBody.throwIfCaught();
            throw e2;
        }
    }

    @Override // retrofit2.Call
    public synchronized C4539 request() {
        InterfaceC5054 interfaceC5054 = this.rawCall;
        if (interfaceC5054 != null) {
            return interfaceC5054.request();
        }
        Throwable th = this.creationFailure;
        if (th != null) {
            if (th instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.creationFailure);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            InterfaceC5054 interfaceC5054CreateRawCall = createRawCall();
            this.rawCall = interfaceC5054CreateRawCall;
            return interfaceC5054CreateRawCall.request();
        } catch (IOException e2) {
            this.creationFailure = e2;
            throw new RuntimeException("Unable to create request.", e2);
        } catch (Error e3) {
            e = e3;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.serviceMethod, this.args);
    }
}
