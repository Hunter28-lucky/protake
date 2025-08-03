package defpackage;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.jakewharton.disklrucache.DiskLruCache;
import io.jsonwebtoken.JwtParser;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* renamed from: ๅ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4932 implements Closeable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final File f16622;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final File f16623;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final File f16624;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final File f16625;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f16626;

    /* renamed from: ՠ, reason: contains not printable characters */
    public long f16627;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final int f16628;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Writer f16630;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f16632;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f16629 = 0;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final LinkedHashMap<String, C4936> f16631 = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: ށ, reason: contains not printable characters */
    public long f16633 = 0;

    /* renamed from: ނ, reason: contains not printable characters */
    public final ThreadPoolExecutor f16634 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC4934(null));

    /* renamed from: ރ, reason: contains not printable characters */
    public final Callable<Void> f16635 = new CallableC4933();

    /* compiled from: DiskLruCache.java */
    /* renamed from: ๅ$Ϳ, reason: contains not printable characters */
    public class CallableC4933 implements Callable<Void> {
        public CallableC4933() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (C4932.this) {
                if (C4932.this.f16630 == null) {
                    return null;
                }
                C4932.this.m14688();
                if (C4932.this.m14682()) {
                    C4932.this.m14686();
                    C4932.this.f16632 = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: ๅ$Ԩ, reason: contains not printable characters */
    public static final class ThreadFactoryC4934 implements ThreadFactory {
        public ThreadFactoryC4934() {
        }

        public /* synthetic */ ThreadFactoryC4934(CallableC4933 callableC4933) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: ๅ$Ԫ, reason: contains not printable characters */
    public final class C4935 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C4936 f16637;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean[] f16638;

        /* renamed from: ԩ, reason: contains not printable characters */
        public boolean f16639;

        public /* synthetic */ C4935(C4932 c4932, C4936 c4936, CallableC4933 callableC4933) {
            this(c4936);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m14692() throws IOException {
            C4932.this.m14677(this, false);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m14693() {
            if (this.f16639) {
                return;
            }
            try {
                m14692();
            } catch (IOException unused) {
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m14694() throws IOException {
            C4932.this.m14677(this, true);
            this.f16639 = true;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public File m14695(int i) throws IOException {
            File fileM14706;
            synchronized (C4932.this) {
                if (this.f16637.f16646 != this) {
                    throw new IllegalStateException();
                }
                if (!this.f16637.f16645) {
                    this.f16638[i] = true;
                }
                fileM14706 = this.f16637.m14706(i);
                if (!C4932.this.f16622.exists()) {
                    C4932.this.f16622.mkdirs();
                }
            }
            return fileM14706;
        }

        public C4935(C4936 c4936) {
            this.f16637 = c4936;
            this.f16638 = c4936.f16645 ? null : new boolean[C4932.this.f16628];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: ๅ$Ԭ, reason: contains not printable characters */
    public final class C4936 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String f16641;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final long[] f16642;

        /* renamed from: ԩ, reason: contains not printable characters */
        public File[] f16643;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public File[] f16644;

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f16645;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public C4935 f16646;

        /* renamed from: ԭ, reason: contains not printable characters */
        public long f16647;

        public /* synthetic */ C4936(C4932 c4932, String str, CallableC4933 callableC4933) {
            this(str);
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public File m14705(int i) {
            return this.f16643[i];
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public File m14706(int i) {
            return this.f16644[i];
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public String m14707() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f16642) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public final IOException m14708(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: ؠ, reason: contains not printable characters */
        public final void m14709(String[] strArr) throws IOException {
            if (strArr.length != C4932.this.f16628) {
                throw m14708(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f16642[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw m14708(strArr);
                }
            }
        }

        public C4936(String str) {
            this.f16641 = str;
            this.f16642 = new long[C4932.this.f16628];
            this.f16643 = new File[C4932.this.f16628];
            this.f16644 = new File[C4932.this.f16628];
            StringBuilder sb = new StringBuilder(str);
            sb.append(JwtParser.SEPARATOR_CHAR);
            int length = sb.length();
            for (int i = 0; i < C4932.this.f16628; i++) {
                sb.append(i);
                this.f16643[i] = new File(C4932.this.f16622, sb.toString());
                sb.append(".tmp");
                this.f16644[i] = new File(C4932.this.f16622, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: ๅ$Ԯ, reason: contains not printable characters */
    public final class C4937 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String f16649;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final long f16650;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final long[] f16651;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final File[] f16652;

        public /* synthetic */ C4937(C4932 c4932, String str, long j, File[] fileArr, long[] jArr, CallableC4933 callableC4933) {
            this(str, j, fileArr, jArr);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public File m14710(int i) {
            return this.f16652[i];
        }

        public C4937(String str, long j, File[] fileArr, long[] jArr) {
            this.f16649 = str;
            this.f16650 = j;
            this.f16652 = fileArr;
            this.f16651 = jArr;
        }
    }

    public C4932(File file, int i, int i2, long j) {
        this.f16622 = file;
        this.f16626 = i;
        this.f16623 = new File(file, DiskLruCache.JOURNAL_FILE);
        this.f16624 = new File(file, DiskLruCache.JOURNAL_FILE_TEMP);
        this.f16625 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        this.f16628 = i2;
        this.f16627 = j;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static void m14673(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static C4932 m14674(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        if (file2.exists()) {
            File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
            if (file3.exists()) {
                file2.delete();
            } else {
                m14675(file2, file3, false);
            }
        }
        C4932 c4932 = new C4932(file, i, i2, j);
        if (c4932.f16623.exists()) {
            try {
                c4932.m14684();
                c4932.m14683();
                return c4932;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                c4932.m14678();
            }
        }
        file.mkdirs();
        C4932 c49322 = new C4932(file, i, i2, j);
        c49322.m14686();
        return c49322;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static void m14675(File file, File file2, boolean z) throws IOException {
        if (z) {
            m14673(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f16630 == null) {
            return;
        }
        Iterator it = new ArrayList(this.f16631.values()).iterator();
        while (it.hasNext()) {
            C4936 c4936 = (C4936) it.next();
            if (c4936.f16646 != null) {
                c4936.f16646.m14692();
            }
        }
        m14688();
        this.f16630.close();
        this.f16630 = null;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m14676() {
        if (this.f16630 == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final synchronized void m14677(C4935 c4935, boolean z) throws IOException {
        C4936 c4936 = c4935.f16637;
        if (c4936.f16646 != c4935) {
            throw new IllegalStateException();
        }
        if (z && !c4936.f16645) {
            for (int i = 0; i < this.f16628; i++) {
                if (!c4935.f16638[i]) {
                    c4935.m14692();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!c4936.m14706(i).exists()) {
                    c4935.m14692();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f16628; i2++) {
            File fileM14706 = c4936.m14706(i2);
            if (!z) {
                m14673(fileM14706);
            } else if (fileM14706.exists()) {
                File fileM14705 = c4936.m14705(i2);
                fileM14706.renameTo(fileM14705);
                long j = c4936.f16642[i2];
                long length = fileM14705.length();
                c4936.f16642[i2] = length;
                this.f16629 = (this.f16629 - j) + length;
            }
        }
        this.f16632++;
        c4936.f16646 = null;
        if (c4936.f16645 || z) {
            c4936.f16645 = true;
            this.f16630.append((CharSequence) "CLEAN");
            this.f16630.append(' ');
            this.f16630.append((CharSequence) c4936.f16641);
            this.f16630.append((CharSequence) c4936.m14707());
            this.f16630.append('\n');
            if (z) {
                long j2 = this.f16633;
                this.f16633 = 1 + j2;
                c4936.f16647 = j2;
            }
        } else {
            this.f16631.remove(c4936.f16641);
            this.f16630.append((CharSequence) "REMOVE");
            this.f16630.append(' ');
            this.f16630.append((CharSequence) c4936.f16641);
            this.f16630.append('\n');
        }
        this.f16630.flush();
        if (this.f16629 > this.f16627 || m14682()) {
            this.f16634.submit(this.f16635);
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m14678() throws IOException {
        close();
        k5.m7175(this.f16622);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public C4935 m14679(String str) throws IOException {
        return m14680(str, -1L);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final synchronized C4935 m14680(String str, long j) throws IOException {
        m14676();
        C4936 c4936 = this.f16631.get(str);
        CallableC4933 callableC4933 = null;
        if (j != -1 && (c4936 == null || c4936.f16647 != j)) {
            return null;
        }
        if (c4936 == null) {
            c4936 = new C4936(this, str, callableC4933);
            this.f16631.put(str, c4936);
        } else if (c4936.f16646 != null) {
            return null;
        }
        C4935 c4935 = new C4935(this, c4936, callableC4933);
        c4936.f16646 = c4935;
        this.f16630.append((CharSequence) "DIRTY");
        this.f16630.append(' ');
        this.f16630.append((CharSequence) str);
        this.f16630.append('\n');
        this.f16630.flush();
        return c4935;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public synchronized C4937 m14681(String str) throws IOException {
        m14676();
        C4936 c4936 = this.f16631.get(str);
        if (c4936 == null) {
            return null;
        }
        if (!c4936.f16645) {
            return null;
        }
        for (File file : c4936.f16643) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f16632++;
        this.f16630.append((CharSequence) "READ");
        this.f16630.append(' ');
        this.f16630.append((CharSequence) str);
        this.f16630.append('\n');
        if (m14682()) {
            this.f16634.submit(this.f16635);
        }
        return new C4937(this, str, c4936.f16647, c4936.f16643, c4936.f16642, null);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final boolean m14682() {
        int i = this.f16632;
        return i >= 2000 && i >= this.f16631.size();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m14683() throws IOException {
        m14673(this.f16624);
        Iterator<C4936> it = this.f16631.values().iterator();
        while (it.hasNext()) {
            C4936 next = it.next();
            int i = 0;
            if (next.f16646 == null) {
                while (i < this.f16628) {
                    this.f16629 += next.f16642[i];
                    i++;
                }
            } else {
                next.f16646 = null;
                while (i < this.f16628) {
                    m14673(next.m14705(i));
                    m14673(next.m14706(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m14684() throws IOException {
        s sVar = new s(new FileInputStream(this.f16623), k5.f7821);
        try {
            String strM8205 = sVar.m8205();
            String strM82052 = sVar.m8205();
            String strM82053 = sVar.m8205();
            String strM82054 = sVar.m8205();
            String strM82055 = sVar.m8205();
            if (!DiskLruCache.MAGIC.equals(strM8205) || !"1".equals(strM82052) || !Integer.toString(this.f16626).equals(strM82053) || !Integer.toString(this.f16628).equals(strM82054) || !"".equals(strM82055)) {
                throw new IOException("unexpected journal header: [" + strM8205 + ", " + strM82052 + ", " + strM82054 + ", " + strM82055 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m14685(sVar.m8205());
                    i++;
                } catch (EOFException unused) {
                    this.f16632 = i - this.f16631.size();
                    if (sVar.m8204()) {
                        m14686();
                    } else {
                        this.f16630 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16623, true), k5.f7821));
                    }
                    k5.m7174(sVar);
                    return;
                }
            }
        } catch (Throwable th) {
            k5.m7174(sVar);
            throw th;
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m14685(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f16631.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        C4936 c4936 = this.f16631.get(strSubstring);
        CallableC4933 callableC4933 = null;
        if (c4936 == null) {
            c4936 = new C4936(this, strSubstring, callableC4933);
            this.f16631.put(strSubstring, c4936);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(MyUTIL.white_space);
            c4936.f16645 = true;
            c4936.f16646 = null;
            c4936.m14709(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            c4936.f16646 = new C4935(this, c4936, callableC4933);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final synchronized void m14686() throws IOException {
        Writer writer = this.f16630;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16624), k5.f7821));
        try {
            bufferedWriter.write(DiskLruCache.MAGIC);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f16626));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f16628));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C4936 c4936 : this.f16631.values()) {
                if (c4936.f16646 != null) {
                    bufferedWriter.write("DIRTY " + c4936.f16641 + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + c4936.f16641 + c4936.m14707() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f16623.exists()) {
                m14675(this.f16623, this.f16625, true);
            }
            m14675(this.f16624, this.f16623, false);
            this.f16625.delete();
            this.f16630 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16623, true), k5.f7821));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public synchronized boolean m14687(String str) throws IOException {
        m14676();
        C4936 c4936 = this.f16631.get(str);
        if (c4936 != null && c4936.f16646 == null) {
            for (int i = 0; i < this.f16628; i++) {
                File fileM14705 = c4936.m14705(i);
                if (fileM14705.exists() && !fileM14705.delete()) {
                    throw new IOException("failed to delete " + fileM14705);
                }
                this.f16629 -= c4936.f16642[i];
                c4936.f16642[i] = 0;
            }
            this.f16632++;
            this.f16630.append((CharSequence) "REMOVE");
            this.f16630.append(' ');
            this.f16630.append((CharSequence) str);
            this.f16630.append('\n');
            this.f16631.remove(str);
            if (m14682()) {
                this.f16634.submit(this.f16635);
            }
            return true;
        }
        return false;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m14688() throws IOException {
        while (this.f16629 > this.f16627) {
            m14687(this.f16631.entrySet().iterator().next().getKey());
        }
    }
}
