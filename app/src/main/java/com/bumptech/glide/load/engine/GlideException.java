package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import defpackage.InterfaceC3773;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class GlideException extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final StackTraceElement[] f5232 = new StackTraceElement[0];
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private InterfaceC3773 key;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m4896(List<Throwable> list, Appendable appendable) {
        try {
            m4897(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m4897(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof GlideException) {
                ((GlideException) th).m4903(appendable);
            } else {
                m4898(th, appendable);
            }
            i = i2;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m4898(Throwable th, Appendable appendable) throws IOException {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        sb.append(this.dataClass != null ? ", " + this.dataClass : "");
        sb.append(this.dataSource != null ? ", " + this.dataSource : "");
        sb.append(this.key != null ? ", " + this.key : "");
        List<Throwable> listM4901 = m4901();
        if (listM4901.isEmpty()) {
            return sb.toString();
        }
        if (listM4901.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(listM4901.size());
            sb.append(" causes:");
        }
        for (Throwable th : listM4901) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() throws IOException {
        printStackTrace(System.err);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4899(Throwable th, List<Throwable> list) {
        if (!(th instanceof GlideException)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> it = ((GlideException) th).m4900().iterator();
        while (it.hasNext()) {
            m4899(it.next(), list);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public List<Throwable> m4900() {
        return this.causes;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public List<Throwable> m4901() {
        ArrayList arrayList = new ArrayList();
        m4899(this, arrayList);
        return arrayList;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4902(String str) {
        List<Throwable> listM4901 = m4901();
        int size = listM4901.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), listM4901.get(i));
            i = i2;
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m4903(Appendable appendable) throws IOException {
        m4898(this, appendable);
        m4896(m4900(), new C1802(appendable));
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4904(InterfaceC3773 interfaceC3773, DataSource dataSource) {
        m4905(interfaceC3773, dataSource, null);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4905(InterfaceC3773 interfaceC3773, DataSource dataSource, Class<?> cls) {
        this.key = interfaceC3773;
        this.dataSource = dataSource;
        this.dataClass = cls;
    }

    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) throws IOException {
        m4903(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(f5232);
        this.causes = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) throws IOException {
        m4903(printWriter);
    }

    /* renamed from: com.bumptech.glide.load.engine.GlideException$Ϳ, reason: contains not printable characters */
    public static final class C1802 implements Appendable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Appendable f5233;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f5234 = true;

        public C1802(Appendable appendable) {
            this.f5233 = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            if (this.f5234) {
                this.f5234 = false;
                this.f5233.append("  ");
            }
            this.f5234 = c == '\n';
            this.f5233.append(c);
            return this;
        }

        @NonNull
        /* renamed from: Ϳ, reason: contains not printable characters */
        public final CharSequence m4906(@Nullable CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) throws IOException {
            CharSequence charSequenceM4906 = m4906(charSequence);
            return append(charSequenceM4906, 0, charSequenceM4906.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence charSequenceM4906 = m4906(charSequence);
            boolean z = false;
            if (this.f5234) {
                this.f5234 = false;
                this.f5233.append("  ");
            }
            if (charSequenceM4906.length() > 0 && charSequenceM4906.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.f5234 = z;
            this.f5233.append(charSequenceM4906, i, i2);
            return this;
        }
    }
}
