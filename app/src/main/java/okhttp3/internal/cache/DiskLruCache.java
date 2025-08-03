package okhttp3.internal.cache;

import defpackage.C2708;
import defpackage.C3122;
import defpackage.C3494;
import defpackage.C3921;
import defpackage.C4184;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC2635;
import defpackage.e0;
import defpackage.f1;
import defpackage.i4;
import defpackage.i5;
import defpackage.l1;
import defpackage.m1;
import io.jsonwebtoken.JwtParser;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* compiled from: DiskLruCache.kt */
/* loaded from: classes2.dex */
public final class DiskLruCache implements Closeable, Flushable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public long f8140;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final File f8141;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final File f8142;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final File f8143;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f8144;

    /* renamed from: ՠ, reason: contains not printable characters */
    public BufferedSink f8145;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final LinkedHashMap<String, C2213> f8146;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f8147;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f8148;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f8149;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f8150;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f8151;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f8152;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f8153;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f8154;

    /* renamed from: ޅ, reason: contains not printable characters */
    public final l1 f8155;

    /* renamed from: ކ, reason: contains not printable characters */
    public final C2216 f8156;

    /* renamed from: އ, reason: contains not printable characters */
    public final InterfaceC2635 f8157;

    /* renamed from: ވ, reason: contains not printable characters */
    public final File f8158;

    /* renamed from: މ, reason: contains not printable characters */
    public final int f8159;

    /* renamed from: ފ, reason: contains not printable characters */
    public final int f8160;

    /* renamed from: ޖ, reason: contains not printable characters */
    public static final C2212 f8139 = new C2212(null);

    /* renamed from: ދ, reason: contains not printable characters */
    public static final String f8128 = com.jakewharton.disklrucache.DiskLruCache.JOURNAL_FILE;

    /* renamed from: ތ, reason: contains not printable characters */
    public static final String f8129 = com.jakewharton.disklrucache.DiskLruCache.JOURNAL_FILE_TEMP;

    /* renamed from: ލ, reason: contains not printable characters */
    public static final String f8130 = com.jakewharton.disklrucache.DiskLruCache.JOURNAL_FILE_BACKUP;

    /* renamed from: ގ, reason: contains not printable characters */
    public static final String f8131 = com.jakewharton.disklrucache.DiskLruCache.MAGIC;

    /* renamed from: ޏ, reason: contains not printable characters */
    public static final String f8132 = "1";

    /* renamed from: ސ, reason: contains not printable characters */
    public static final long f8133 = -1;

    /* renamed from: ޑ, reason: contains not printable characters */
    public static final Regex f8134 = new Regex("[a-z0-9_-]{1,120}");

    /* renamed from: ޒ, reason: contains not printable characters */
    public static final String f8135 = "CLEAN";

    /* renamed from: ޓ, reason: contains not printable characters */
    public static final String f8136 = "DIRTY";

    /* renamed from: ޔ, reason: contains not printable characters */
    public static final String f8137 = "REMOVE";

    /* renamed from: ޕ, reason: contains not printable characters */
    public static final String f8138 = "READ";

    /* compiled from: DiskLruCache.kt */
    public final class Editor {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean[] f8161;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean f8162;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C2213 f8163;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ DiskLruCache f8164;

        public Editor(DiskLruCache diskLruCache, C2213 c2213) {
            C3921.m12667(c2213, "entry");
            this.f8164 = diskLruCache;
            this.f8163 = c2213;
            this.f8161 = c2213.m7782() ? null : new boolean[diskLruCache.m7755()];
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m7769() throws IOException {
            synchronized (this.f8164) {
                if (!(!this.f8162)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (C3921.m12662(this.f8163.m7777(), this)) {
                    this.f8164.m7748(this, false);
                }
                this.f8162 = true;
                i4 i4Var = i4.f6762;
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m7770() throws IOException {
            synchronized (this.f8164) {
                if (!(!this.f8162)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (C3921.m12662(this.f8163.m7777(), this)) {
                    this.f8164.m7748(this, true);
                }
                this.f8162 = true;
                i4 i4Var = i4.f6762;
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final void m7771() throws IOException {
            if (C3921.m12662(this.f8163.m7777(), this)) {
                if (this.f8164.f8149) {
                    this.f8164.m7748(this, false);
                } else {
                    this.f8163.m7792(true);
                }
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C2213 m7772() {
            return this.f8163;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final boolean[] m7773() {
            return this.f8161;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Sink m7774(final int i) {
            synchronized (this.f8164) {
                if (!(!this.f8162)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (!C3921.m12662(this.f8163.m7777(), this)) {
                    return Okio.blackhole();
                }
                if (!this.f8163.m7782()) {
                    boolean[] zArr = this.f8161;
                    if (zArr == null) {
                        C3921.m12675();
                    }
                    zArr[i] = true;
                }
                try {
                    return new C3122(this.f8164.m7754().mo9721(this.f8163.m7778().get(i)), new InterfaceC2392<IOException, i4>() { // from class: okhttp3.internal.cache.DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // defpackage.InterfaceC2392
                        public /* bridge */ /* synthetic */ i4 invoke(IOException iOException) {
                            m7768(iOException);
                            return i4.f6762;
                        }

                        /* renamed from: Ϳ, reason: contains not printable characters */
                        public final void m7768(IOException iOException) {
                            C3921.m12667(iOException, "it");
                            synchronized (this.this$0.f8164) {
                                this.this$0.m7771();
                                i4 i4Var = i4.f6762;
                            }
                        }
                    });
                } catch (FileNotFoundException unused) {
                    return Okio.blackhole();
                }
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* renamed from: okhttp3.internal.cache.DiskLruCache$Ϳ, reason: contains not printable characters */
    public static final class C2212 {
        public C2212() {
        }

        public /* synthetic */ C2212(C4184 c4184) {
            this();
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* renamed from: okhttp3.internal.cache.DiskLruCache$Ԩ, reason: contains not printable characters */
    public final class C2213 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final long[] f8165;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final List<File> f8166;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final List<File> f8167;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean f8168;

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f8169;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Editor f8170;

        /* renamed from: ԭ, reason: contains not printable characters */
        public int f8171;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public long f8172;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final String f8173;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final /* synthetic */ DiskLruCache f8174;

        /* compiled from: DiskLruCache.kt */
        /* renamed from: okhttp3.internal.cache.DiskLruCache$Ԩ$Ϳ, reason: contains not printable characters */
        public static final class C2214 extends ForwardingSource {

            /* renamed from: ԫ, reason: contains not printable characters */
            public boolean f8175;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final /* synthetic */ Source f8177;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2214(Source source, Source source2) {
                super(source2);
                this.f8177 = source;
            }

            @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                if (this.f8175) {
                    return;
                }
                this.f8175 = true;
                synchronized (C2213.this.f8174) {
                    C2213.this.m7789(r1.m7781() - 1);
                    if (C2213.this.m7781() == 0 && C2213.this.m7784()) {
                        C2213 c2213 = C2213.this;
                        c2213.f8174.m7764(c2213);
                    }
                    i4 i4Var = i4.f6762;
                }
            }
        }

        public C2213(DiskLruCache diskLruCache, String str) {
            C3921.m12667(str, "key");
            this.f8174 = diskLruCache;
            this.f8173 = str;
            this.f8165 = new long[diskLruCache.m7755()];
            this.f8166 = new ArrayList();
            this.f8167 = new ArrayList();
            StringBuilder sb = new StringBuilder(str);
            sb.append(JwtParser.SEPARATOR_CHAR);
            int length = sb.length();
            int iM7755 = diskLruCache.m7755();
            for (int i = 0; i < iM7755; i++) {
                sb.append(i);
                this.f8166.add(new File(diskLruCache.m7753(), sb.toString()));
                sb.append(".tmp");
                this.f8167.add(new File(diskLruCache.m7753(), sb.toString()));
                sb.setLength(length);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final List<File> m7776() {
            return this.f8166;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final Editor m7777() {
            return this.f8170;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final List<File> m7778() {
            return this.f8167;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final String m7779() {
            return this.f8173;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final long[] m7780() {
            return this.f8165;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final int m7781() {
            return this.f8171;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final boolean m7782() {
            return this.f8168;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final long m7783() {
            return this.f8172;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final boolean m7784() {
            return this.f8169;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final Void m7785(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public final Source m7786(int i) throws FileNotFoundException {
            Source sourceMo9720 = this.f8174.m7754().mo9720(this.f8166.get(i));
            if (this.f8174.f8149) {
                return sourceMo9720;
            }
            this.f8171++;
            return new C2214(sourceMo9720, sourceMo9720);
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public final void m7787(Editor editor) {
            this.f8170 = editor;
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public final void m7788(List<String> list) throws IOException {
            C3921.m12667(list, "strings");
            if (list.size() != this.f8174.m7755()) {
                m7785(list);
                throw null;
            }
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    this.f8165[i] = Long.parseLong(list.get(i));
                }
            } catch (NumberFormatException unused) {
                m7785(list);
                throw null;
            }
        }

        /* renamed from: ؠ, reason: contains not printable characters */
        public final void m7789(int i) {
            this.f8171 = i;
        }

        /* renamed from: ހ, reason: contains not printable characters */
        public final void m7790(boolean z) {
            this.f8168 = z;
        }

        /* renamed from: ށ, reason: contains not printable characters */
        public final void m7791(long j) {
            this.f8172 = j;
        }

        /* renamed from: ނ, reason: contains not printable characters */
        public final void m7792(boolean z) {
            this.f8169 = z;
        }

        /* renamed from: ރ, reason: contains not printable characters */
        public final C2215 m7793() throws IOException {
            DiskLruCache diskLruCache = this.f8174;
            if (i5.f6770 && !Thread.holdsLock(diskLruCache)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                C3921.m12663(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(diskLruCache);
                throw new AssertionError(sb.toString());
            }
            if (!this.f8168) {
                return null;
            }
            if (!this.f8174.f8149 && (this.f8170 != null || this.f8169)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.f8165.clone();
            try {
                int iM7755 = this.f8174.m7755();
                for (int i = 0; i < iM7755; i++) {
                    arrayList.add(m7786(i));
                }
                return new C2215(this.f8174, this.f8173, this.f8172, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    i5.m6240((Source) it.next());
                }
                try {
                    this.f8174.m7764(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        /* renamed from: ބ, reason: contains not printable characters */
        public final void m7794(BufferedSink bufferedSink) throws IOException {
            C3921.m12667(bufferedSink, "writer");
            for (long j : this.f8165) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* renamed from: okhttp3.internal.cache.DiskLruCache$Ԫ, reason: contains not printable characters */
    public final class C2215 implements Closeable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final String f8178;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f8179;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final List<Source> f8180;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final long[] f8181;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ DiskLruCache f8182;

        /* JADX WARN: Multi-variable type inference failed */
        public C2215(DiskLruCache diskLruCache, String str, long j, List<? extends Source> list, long[] jArr) {
            C3921.m12667(str, "key");
            C3921.m12667(list, "sources");
            C3921.m12667(jArr, "lengths");
            this.f8182 = diskLruCache;
            this.f8178 = str;
            this.f8179 = j;
            this.f8180 = list;
            this.f8181 = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Iterator<Source> it = this.f8180.iterator();
            while (it.hasNext()) {
                i5.m6240(it.next());
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Editor m7795() throws IOException {
            return this.f8182.m7750(this.f8178, this.f8179);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final Source m7796(int i) {
            return this.f8180.get(i);
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* renamed from: okhttp3.internal.cache.DiskLruCache$Ԭ, reason: contains not printable characters */
    public static final class C2216 extends f1 {
        public C2216(String str) {
            super(str, false, 2, null);
        }

        @Override // defpackage.f1
        /* renamed from: Ԭ */
        public long mo6034() {
            synchronized (DiskLruCache.this) {
                if (!DiskLruCache.this.f8150 || DiskLruCache.this.m7752()) {
                    return -1L;
                }
                try {
                    DiskLruCache.this.m7766();
                } catch (IOException unused) {
                    DiskLruCache.this.f8152 = true;
                }
                try {
                    if (DiskLruCache.this.m7757()) {
                        DiskLruCache.this.m7762();
                        DiskLruCache.this.f8147 = 0;
                    }
                } catch (IOException unused2) {
                    DiskLruCache.this.f8153 = true;
                    DiskLruCache.this.f8145 = Okio.buffer(Okio.blackhole());
                }
                return -1L;
            }
        }
    }

    public DiskLruCache(InterfaceC2635 interfaceC2635, File file, int i, int i2, long j, m1 m1Var) {
        C3921.m12667(interfaceC2635, "fileSystem");
        C3921.m12667(file, "directory");
        C3921.m12667(m1Var, "taskRunner");
        this.f8157 = interfaceC2635;
        this.f8158 = file;
        this.f8159 = i;
        this.f8160 = i2;
        this.f8140 = j;
        this.f8146 = new LinkedHashMap<>(0, 0.75f, true);
        this.f8155 = m1Var.m7528();
        this.f8156 = new C2216(i5.f6771 + " Cache");
        if (!(j > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (!(i2 > 0)) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.f8141 = new File(file, f8128);
        this.f8142 = new File(file, f8129);
        this.f8143 = new File(file, f8130);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static /* synthetic */ Editor m7746(DiskLruCache diskLruCache, String str, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = f8133;
        }
        return diskLruCache.m7750(str, j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Editor editorM7777;
        if (this.f8150 && !this.f8151) {
            Collection<C2213> collectionValues = this.f8146.values();
            C3921.m12663(collectionValues, "lruEntries.values");
            Object[] array = collectionValues.toArray(new C2213[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            for (C2213 c2213 : (C2213[]) array) {
                if (c2213.m7777() != null && (editorM7777 = c2213.m7777()) != null) {
                    editorM7777.m7771();
                }
            }
            m7766();
            BufferedSink bufferedSink = this.f8145;
            if (bufferedSink == null) {
                C3921.m12675();
            }
            bufferedSink.close();
            this.f8145 = null;
            this.f8151 = true;
            return;
        }
        this.f8151 = true;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f8150) {
            m7747();
            m7766();
            BufferedSink bufferedSink = this.f8145;
            if (bufferedSink == null) {
                C3921.m12675();
            }
            bufferedSink.flush();
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final synchronized void m7747() {
        if (!(!this.f8151)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final synchronized void m7748(Editor editor, boolean z) throws IOException {
        C3921.m12667(editor, "editor");
        C2213 c2213M7772 = editor.m7772();
        if (!C3921.m12662(c2213M7772.m7777(), editor)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (z && !c2213M7772.m7782()) {
            int i = this.f8160;
            for (int i2 = 0; i2 < i; i2++) {
                boolean[] zArrM7773 = editor.m7773();
                if (zArrM7773 == null) {
                    C3921.m12675();
                }
                if (!zArrM7773[i2]) {
                    editor.m7769();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                }
                if (!this.f8157.mo9723(c2213M7772.m7778().get(i2))) {
                    editor.m7769();
                    return;
                }
            }
        }
        int i3 = this.f8160;
        for (int i4 = 0; i4 < i3; i4++) {
            File file = c2213M7772.m7778().get(i4);
            if (!z || c2213M7772.m7784()) {
                this.f8157.mo9725(file);
            } else if (this.f8157.mo9723(file)) {
                File file2 = c2213M7772.m7776().get(i4);
                this.f8157.mo9724(file, file2);
                long j = c2213M7772.m7780()[i4];
                long jMo9727 = this.f8157.mo9727(file2);
                c2213M7772.m7780()[i4] = jMo9727;
                this.f8144 = (this.f8144 - j) + jMo9727;
            }
        }
        c2213M7772.m7787(null);
        if (c2213M7772.m7784()) {
            m7764(c2213M7772);
            return;
        }
        this.f8147++;
        BufferedSink bufferedSink = this.f8145;
        if (bufferedSink == null) {
            C3921.m12675();
        }
        if (c2213M7772.m7782() || z) {
            c2213M7772.m7790(true);
            bufferedSink.writeUtf8(f8135).writeByte(32);
            bufferedSink.writeUtf8(c2213M7772.m7779());
            c2213M7772.m7794(bufferedSink);
            bufferedSink.writeByte(10);
            if (z) {
                long j2 = this.f8154;
                this.f8154 = 1 + j2;
                c2213M7772.m7791(j2);
            }
        } else {
            this.f8146.remove(c2213M7772.m7779());
            bufferedSink.writeUtf8(f8137).writeByte(32);
            bufferedSink.writeUtf8(c2213M7772.m7779());
            bufferedSink.writeByte(10);
        }
        bufferedSink.flush();
        if (this.f8144 > this.f8140 || m7757()) {
            l1.m7458(this.f8155, this.f8156, 0L, 2, null);
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m7749() throws IOException {
        close();
        this.f8157.mo9722(this.f8158);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final synchronized Editor m7750(String str, long j) throws IOException {
        C3921.m12667(str, "key");
        m7756();
        m7747();
        m7767(str);
        C2213 c2213 = this.f8146.get(str);
        if (j != f8133 && (c2213 == null || c2213.m7783() != j)) {
            return null;
        }
        if ((c2213 != null ? c2213.m7777() : null) != null) {
            return null;
        }
        if (c2213 != null && c2213.m7781() != 0) {
            return null;
        }
        if (!this.f8152 && !this.f8153) {
            BufferedSink bufferedSink = this.f8145;
            if (bufferedSink == null) {
                C3921.m12675();
            }
            bufferedSink.writeUtf8(f8136).writeByte(32).writeUtf8(str).writeByte(10);
            bufferedSink.flush();
            if (this.f8148) {
                return null;
            }
            if (c2213 == null) {
                c2213 = new C2213(this, str);
                this.f8146.put(str, c2213);
            }
            Editor editor = new Editor(this, c2213);
            c2213.m7787(editor);
            return editor;
        }
        l1.m7458(this.f8155, this.f8156, 0L, 2, null);
        return null;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final synchronized C2215 m7751(String str) throws IOException {
        C3921.m12667(str, "key");
        m7756();
        m7747();
        m7767(str);
        C2213 c2213 = this.f8146.get(str);
        if (c2213 == null) {
            return null;
        }
        C3921.m12663(c2213, "lruEntries[key] ?: return null");
        C2215 c2215M7793 = c2213.m7793();
        if (c2215M7793 == null) {
            return null;
        }
        this.f8147++;
        BufferedSink bufferedSink = this.f8145;
        if (bufferedSink == null) {
            C3921.m12675();
        }
        bufferedSink.writeUtf8(f8138).writeByte(32).writeUtf8(str).writeByte(10);
        if (m7757()) {
            l1.m7458(this.f8155, this.f8156, 0L, 2, null);
        }
        return c2215M7793;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final boolean m7752() {
        return this.f8151;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final File m7753() {
        return this.f8158;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final InterfaceC2635 m7754() {
        return this.f8157;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final int m7755() {
        return this.f8160;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final synchronized void m7756() throws IOException {
        if (i5.f6770 && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (this.f8150) {
            return;
        }
        if (this.f8157.mo9723(this.f8143)) {
            if (this.f8157.mo9723(this.f8141)) {
                this.f8157.mo9725(this.f8143);
            } else {
                this.f8157.mo9724(this.f8143, this.f8141);
            }
        }
        this.f8149 = i5.m6259(this.f8157, this.f8143);
        if (this.f8157.mo9723(this.f8141)) {
            try {
                m7760();
                m7759();
                this.f8150 = true;
                return;
            } catch (IOException e2) {
                C2708.f10025.m9964().m9955("DiskLruCache " + this.f8158 + " is corrupt: " + e2.getMessage() + ", removing", 5, e2);
                try {
                    m7749();
                    this.f8151 = false;
                } catch (Throwable th) {
                    this.f8151 = false;
                    throw th;
                }
            }
        }
        m7762();
        this.f8150 = true;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final boolean m7757() {
        int i = this.f8147;
        return i >= 2000 && i >= this.f8146.size();
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final BufferedSink m7758() throws FileNotFoundException {
        return Okio.buffer(new C3122(this.f8157.mo9726(this.f8141), new InterfaceC2392<IOException, i4>() { // from class: okhttp3.internal.cache.DiskLruCache$newJournalWriter$faultHidingSink$1
            {
                super(1);
            }

            @Override // defpackage.InterfaceC2392
            public /* bridge */ /* synthetic */ i4 invoke(IOException iOException) {
                m7775(iOException);
                return i4.f6762;
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final void m7775(IOException iOException) {
                C3921.m12667(iOException, "it");
                DiskLruCache diskLruCache = this.this$0;
                if (!i5.f6770 || Thread.holdsLock(diskLruCache)) {
                    this.this$0.f8148 = true;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                C3921.m12663(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(diskLruCache);
                throw new AssertionError(sb.toString());
            }
        }));
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m7759() throws IOException {
        this.f8157.mo9725(this.f8142);
        Iterator<C2213> it = this.f8146.values().iterator();
        while (it.hasNext()) {
            C2213 next = it.next();
            C3921.m12663(next, "i.next()");
            C2213 c2213 = next;
            int i = 0;
            if (c2213.m7777() == null) {
                int i2 = this.f8160;
                while (i < i2) {
                    this.f8144 += c2213.m7780()[i];
                    i++;
                }
            } else {
                c2213.m7787(null);
                int i3 = this.f8160;
                while (i < i3) {
                    this.f8157.mo9725(c2213.m7776().get(i));
                    this.f8157.mo9725(c2213.m7778().get(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m7760() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        BufferedSource bufferedSourceBuffer = Okio.buffer(this.f8157.mo9720(this.f8141));
        try {
            String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict2 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict3 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict4 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict5 = bufferedSourceBuffer.readUtf8LineStrict();
            if (!(!C3921.m12662(f8131, utf8LineStrict)) && !(!C3921.m12662(f8132, utf8LineStrict2)) && !(!C3921.m12662(String.valueOf(this.f8159), utf8LineStrict3)) && !(!C3921.m12662(String.valueOf(this.f8160), utf8LineStrict4))) {
                int i = 0;
                if (!(utf8LineStrict5.length() > 0)) {
                    while (true) {
                        try {
                            m7761(bufferedSourceBuffer.readUtf8LineStrict());
                            i++;
                        } catch (EOFException unused) {
                            this.f8147 = i - this.f8146.size();
                            if (bufferedSourceBuffer.exhausted()) {
                                this.f8145 = m7758();
                            } else {
                                m7762();
                            }
                            i4 i4Var = i4.f6762;
                            C3494.m11412(bufferedSourceBuffer, null);
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + ']');
        } finally {
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m7761(String str) throws IOException {
        String strSubstring;
        int iM7285 = StringsKt__StringsKt.m7285(str, ' ', 0, false, 6, null);
        if (iM7285 == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iM7285 + 1;
        int iM72852 = StringsKt__StringsKt.m7285(str, ' ', i, false, 4, null);
        if (iM72852 == -1) {
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str.substring(i);
            C3921.m12663(strSubstring, "(this as java.lang.String).substring(startIndex)");
            String str2 = f8137;
            if (iM7285 == str2.length() && e0.m5980(str, str2, false, 2, null)) {
                this.f8146.remove(strSubstring);
                return;
            }
        } else {
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str.substring(i, iM72852);
            C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        C2213 c2213 = this.f8146.get(strSubstring);
        if (c2213 == null) {
            c2213 = new C2213(this, strSubstring);
            this.f8146.put(strSubstring, c2213);
        }
        if (iM72852 != -1) {
            String str3 = f8135;
            if (iM7285 == str3.length() && e0.m5980(str, str3, false, 2, null)) {
                int i2 = iM72852 + 1;
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring2 = str.substring(i2);
                C3921.m12663(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                List<String> listM7305 = StringsKt__StringsKt.m7305(strSubstring2, new char[]{' '}, false, 0, 6, null);
                c2213.m7790(true);
                c2213.m7787(null);
                c2213.m7788(listM7305);
                return;
            }
        }
        if (iM72852 == -1) {
            String str4 = f8136;
            if (iM7285 == str4.length() && e0.m5980(str, str4, false, 2, null)) {
                c2213.m7787(new Editor(this, c2213));
                return;
            }
        }
        if (iM72852 == -1) {
            String str5 = f8138;
            if (iM7285 == str5.length() && e0.m5980(str, str5, false, 2, null)) {
                return;
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final synchronized void m7762() throws IOException {
        BufferedSink bufferedSink = this.f8145;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink bufferedSinkBuffer = Okio.buffer(this.f8157.mo9721(this.f8142));
        try {
            bufferedSinkBuffer.writeUtf8(f8131).writeByte(10);
            bufferedSinkBuffer.writeUtf8(f8132).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.f8159).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.f8160).writeByte(10);
            bufferedSinkBuffer.writeByte(10);
            for (C2213 c2213 : this.f8146.values()) {
                if (c2213.m7777() != null) {
                    bufferedSinkBuffer.writeUtf8(f8136).writeByte(32);
                    bufferedSinkBuffer.writeUtf8(c2213.m7779());
                    bufferedSinkBuffer.writeByte(10);
                } else {
                    bufferedSinkBuffer.writeUtf8(f8135).writeByte(32);
                    bufferedSinkBuffer.writeUtf8(c2213.m7779());
                    c2213.m7794(bufferedSinkBuffer);
                    bufferedSinkBuffer.writeByte(10);
                }
            }
            i4 i4Var = i4.f6762;
            C3494.m11412(bufferedSinkBuffer, null);
            if (this.f8157.mo9723(this.f8141)) {
                this.f8157.mo9724(this.f8141, this.f8143);
            }
            this.f8157.mo9724(this.f8142, this.f8141);
            this.f8157.mo9725(this.f8143);
            this.f8145 = m7758();
            this.f8148 = false;
            this.f8153 = false;
        } finally {
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final synchronized boolean m7763(String str) throws IOException {
        C3921.m12667(str, "key");
        m7756();
        m7747();
        m7767(str);
        C2213 c2213 = this.f8146.get(str);
        if (c2213 == null) {
            return false;
        }
        C3921.m12663(c2213, "lruEntries[key] ?: return false");
        boolean zM7764 = m7764(c2213);
        if (zM7764 && this.f8144 <= this.f8140) {
            this.f8152 = false;
        }
        return zM7764;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final boolean m7764(C2213 c2213) throws IOException {
        BufferedSink bufferedSink;
        C3921.m12667(c2213, "entry");
        if (!this.f8149) {
            if (c2213.m7781() > 0 && (bufferedSink = this.f8145) != null) {
                bufferedSink.writeUtf8(f8136);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(c2213.m7779());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (c2213.m7781() > 0 || c2213.m7777() != null) {
                c2213.m7792(true);
                return true;
            }
        }
        Editor editorM7777 = c2213.m7777();
        if (editorM7777 != null) {
            editorM7777.m7771();
        }
        int i = this.f8160;
        for (int i2 = 0; i2 < i; i2++) {
            this.f8157.mo9725(c2213.m7776().get(i2));
            this.f8144 -= c2213.m7780()[i2];
            c2213.m7780()[i2] = 0;
        }
        this.f8147++;
        BufferedSink bufferedSink2 = this.f8145;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(f8137);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(c2213.m7779());
            bufferedSink2.writeByte(10);
        }
        this.f8146.remove(c2213.m7779());
        if (m7757()) {
            l1.m7458(this.f8155, this.f8156, 0L, 2, null);
        }
        return true;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final boolean m7765() throws IOException {
        for (C2213 c2213 : this.f8146.values()) {
            if (!c2213.m7784()) {
                C3921.m12663(c2213, "toEvict");
                m7764(c2213);
                return true;
            }
        }
        return false;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m7766() throws IOException {
        while (this.f8144 > this.f8140) {
            if (!m7765()) {
                return;
            }
        }
        this.f8152 = false;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m7767(String str) {
        if (f8134.m7263(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }
}
