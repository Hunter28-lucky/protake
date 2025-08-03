package io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes2.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public static final class CompositeExceptionCausalChain extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$Ϳ, reason: contains not printable characters */
    public static abstract class AbstractC1973 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public abstract void mo6308(Object obj);
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$Ԩ, reason: contains not printable characters */
    public static final class C1974 extends AbstractC1973 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final PrintStream f6789;

        public C1974(PrintStream printStream) {
            this.f6789 = printStream;
        }

        @Override // io.reactivex.exceptions.CompositeException.AbstractC1973
        /* renamed from: Ϳ */
        public void mo6308(Object obj) {
            this.f6789.println(obj);
        }
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$Ԫ, reason: contains not printable characters */
    public static final class C1975 extends AbstractC1973 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final PrintWriter f6790;

        public C1975(PrintWriter printWriter) {
            this.f6790 = printWriter;
        }

        @Override // io.reactivex.exceptions.CompositeException.AbstractC1973
        /* renamed from: Ϳ */
        public void mo6308(Object obj) {
            this.f6790.println(obj);
        }
    }

    public CompositeException(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.cause == null) {
            CompositeExceptionCausalChain compositeExceptionCausalChain = new CompositeExceptionCausalChain();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.exceptions.iterator();
            Throwable thM6306 = compositeExceptionCausalChain;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th : m6305(next)) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        thM6306.initCause(next);
                    } catch (Throwable unused) {
                    }
                    thM6306 = m6306(thM6306);
                }
            }
            this.cause = compositeExceptionCausalChain;
        }
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m6303(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            m6303(sb, th.getCause(), "");
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public List<Throwable> m6304() {
        return this.exceptions;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final List<Throwable> m6305(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Throwable m6306(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || th == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m6307(AbstractC1973 abstractC1973) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.exceptions) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            m6303(sb, th, "\t");
            i++;
        }
        abstractC1973.mo6308(sb.toString());
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        m6307(new C1974(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        m6307(new C1975(printWriter));
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).m6304());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            List<Throwable> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            this.exceptions = listUnmodifiableList;
            this.message = listUnmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}
