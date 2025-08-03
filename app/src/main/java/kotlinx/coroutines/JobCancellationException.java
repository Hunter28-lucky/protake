package kotlinx.coroutines;

import defpackage.C3921;
import defpackage.InterfaceC5238;
import java.util.concurrent.CancellationException;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public final class JobCancellationException extends CancellationException {
    public final InterfaceC5238 job;

    public JobCancellationException(String str, Throwable th, InterfaceC5238 interfaceC5238) {
        super(str);
        this.job = interfaceC5238;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!C3921.m12662(jobCancellationException.getMessage(), getMessage()) || !C3921.m12662(jobCancellationException.job, this.job) || !C3921.m12662(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        C3921.m12664(message);
        int iHashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause == null ? 0 : cause.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }
}
