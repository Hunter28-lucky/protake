package defpackage;

import androidx.core.app.NotificationCompat;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.AbstractC2613;
import defpackage.AbstractC3415;
import defpackage.AbstractC4809;
import defpackage.C5207;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.collections.C2138;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;

/* compiled from: Util.kt */
/* loaded from: classes2.dex */
public final class i5 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final byte[] f6763;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C5207 f6764 = C5207.f17261.m15202(new String[0]);

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final AbstractC4809 f6765;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final AbstractC2613 f6766;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Options f6767;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final TimeZone f6768;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final Regex f6769;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final boolean f6770;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final String f6771;

    /* compiled from: Util.kt */
    /* renamed from: i5$Ϳ, reason: contains not printable characters */
    public static final class C1970 implements AbstractC3415.InterfaceC3418 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC3415 f6772;

        public C1970(AbstractC3415 abstractC3415) {
            this.f6772 = abstractC3415;
        }

        @Override // defpackage.AbstractC3415.InterfaceC3418
        public AbstractC3415 create(InterfaceC5054 interfaceC5054) {
            C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
            return this.f6772;
        }
    }

    /* compiled from: Util.kt */
    /* renamed from: i5$Ԩ, reason: contains not printable characters */
    public static final class ThreadFactoryC1971 implements ThreadFactory {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f6773;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f6774;

        public ThreadFactoryC1971(String str, boolean z) {
            this.f6773 = str;
            this.f6774 = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f6773);
            thread.setDaemon(this.f6774);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f6763 = bArr;
        f6765 = AbstractC4809.C4811.m14531(AbstractC4809.Companion, bArr, null, 1, null);
        f6766 = AbstractC2613.C2614.m9556(AbstractC2613.Companion, bArr, null, 0, 0, 7, null);
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        f6767 = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        if (timeZone == null) {
            C3921.m12675();
        }
        f6768 = timeZone;
        f6769 = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f6770 = false;
        String name = C5121.class.getName();
        C3921.m12663(name, "OkHttpClient::class.java.name");
        f6771 = StringsKt__StringsKt.m7301(StringsKt__StringsKt.m7300(name, "okhttp3."), "Client");
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <E> void m6231(List<E> list, E e2) {
        C3921.m12667(list, "$this$addIfAbsent");
        if (list.contains(e2)) {
            return;
        }
        list.add(e2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final int m6232(byte b, int i) {
        return b & i;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final int m6233(short s, int i) {
        return s & i;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final long m6234(int i, long j) {
        return i & j;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final AbstractC3415.InterfaceC3418 m6235(AbstractC3415 abstractC3415) {
        C3921.m12667(abstractC3415, "$this$asFactory");
        return new C1970(abstractC3415);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final boolean m6236(String str) {
        C3921.m12667(str, "$this$canParseAsIpAddress");
        return f6769.m7263(str);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final boolean m6237(C3573 c3573, C3573 c35732) {
        C3921.m12667(c3573, "$this$canReuseConnectionFor");
        C3921.m12667(c35732, "other");
        return C3921.m12662(c3573.m11532(), c35732.m11532()) && c3573.m11537() == c35732.m11537() && C3921.m12662(c3573.m11543(), c35732.m11543());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final int m6238(String str, long j, TimeUnit timeUnit) {
        C3921.m12667(str, "name");
        boolean z = true;
        if (!(j >= 0)) {
            throw new IllegalStateException((str + " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j);
        if (!(millis <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException((str + " too large.").toString());
        }
        if (millis == 0 && j > 0) {
            z = false;
        }
        if (z) {
            return (int) millis;
        }
        throw new IllegalArgumentException((str + " too small.").toString());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final void m6239(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final void m6240(Closeable closeable) throws IOException {
        C3921.m12667(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final void m6241(Socket socket) throws IOException {
        C3921.m12667(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static final String[] m6242(String[] strArr, String str) {
        C3921.m12667(strArr, "$this$concat");
        C3921.m12667(str, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        C3921.m12663(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[C4962.m14742(strArr2)] = str;
        return strArr2;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final int m6243(String str, char c, int i, int i2) {
        C3921.m12667(str, "$this$delimiterOffset");
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final int m6244(String str, String str2, int i, int i2) {
        C3921.m12667(str, "$this$delimiterOffset");
        C3921.m12667(str2, "delimiters");
        while (i < i2) {
            if (StringsKt__StringsKt.m7274(str2, str.charAt(i), false, 2, null)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static /* synthetic */ int m6245(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return m6243(str, c, i, i2);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static final boolean m6246(Source source, int i, TimeUnit timeUnit) {
        C3921.m12667(source, "$this$discard");
        C3921.m12667(timeUnit, "timeUnit");
        try {
            return m6265(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static final String m6247(String str, Object... objArr) {
        C3921.m12667(str, "format");
        C3921.m12667(objArr, "args");
        t tVar = t.f8531;
        Locale locale = Locale.US;
        C3921.m12663(locale, "Locale.US");
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        C3921.m12663(str2, "java.lang.String.format(locale, format, *args)");
        return str2;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static final boolean m6248(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        C3921.m12667(strArr, "$this$hasIntersection");
        C3921.m12667(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static final long m6249(C4770 c4770) {
        C3921.m12667(c4770, "$this$headersContentLength");
        String strM15182 = c4770.m14339().m15182(HttpHeaders.HEAD_KEY_CONTENT_LENGTH);
        if (strM15182 != null) {
            return m6273(strM15182, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    /* renamed from: ޅ, reason: contains not printable characters */
    public static final <T> List<T> m6250(T... tArr) {
        C3921.m12667(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, objArr.length)));
        C3921.m12663(listUnmodifiableList, "Collections.unmodifiable…sList(*elements.clone()))");
        return listUnmodifiableList;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public static final int m6251(String[] strArr, String str, Comparator<String> comparator) {
        C3921.m12667(strArr, "$this$indexOf");
        C3921.m12667(str, "value");
        C3921.m12667(comparator, "comparator");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public static final int m6252(String str) {
        C3921.m12667(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static final int m6253(String str, int i, int i2) {
        C3921.m12667(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public static /* synthetic */ int m6254(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return m6253(str, i, i2);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static final int m6255(String str, int i, int i2) {
        C3921.m12667(str, "$this$indexOfLastNonAsciiWhitespace");
        int i3 = i2 - 1;
        if (i3 >= i) {
            while (true) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3 + 1;
                }
                if (i3 == i) {
                    break;
                }
                i3--;
            }
        }
        return i;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static /* synthetic */ int m6256(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return m6255(str, i, i2);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static final int m6257(String str, int i) {
        C3921.m12667(str, "$this$indexOfNonWhitespace");
        int length = str.length();
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static final String[] m6258(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        C3921.m12667(strArr, "$this$intersect");
        C3921.m12667(strArr2, "other");
        C3921.m12667(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static final boolean m6259(InterfaceC2635 interfaceC2635, File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        C3921.m12667(interfaceC2635, "$this$isCivilized");
        C3921.m12667(file, "file");
        Sink sinkMo9721 = interfaceC2635.mo9721(file);
        try {
            try {
                interfaceC2635.mo9725(file);
                C3494.m11412(sinkMo9721, null);
                return true;
            } finally {
            }
        } catch (IOException unused) {
            i4 i4Var = i4.f6762;
            C3494.m11412(sinkMo9721, null);
            interfaceC2635.mo9725(file);
            return false;
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static final boolean m6260(Socket socket, BufferedSource bufferedSource) throws SocketException {
        C3921.m12667(socket, "$this$isHealthy");
        C3921.m12667(bufferedSource, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !bufferedSource.exhausted();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static final int m6261(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public static final Charset m6262(BufferedSource bufferedSource, Charset charset) throws IOException {
        C3921.m12667(bufferedSource, "$this$readBomAsCharset");
        C3921.m12667(charset, "default");
        int iSelect = bufferedSource.select(f6767);
        if (iSelect == -1) {
            return charset;
        }
        if (iSelect == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            C3921.m12663(charset2, "UTF_8");
            return charset2;
        }
        if (iSelect == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            C3921.m12663(charset3, "UTF_16BE");
            return charset3;
        }
        if (iSelect == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            C3921.m12663(charset4, "UTF_16LE");
            return charset4;
        }
        if (iSelect == 3) {
            return C5241.f17364.m15260();
        }
        if (iSelect == 4) {
            return C5241.f17364.m15261();
        }
        throw new AssertionError();
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public static final int m6263(BufferedSource bufferedSource) throws IOException {
        C3921.m12667(bufferedSource, "$this$readMedium");
        return m6232(bufferedSource.readByte(), 255) | (m6232(bufferedSource.readByte(), 255) << 16) | (m6232(bufferedSource.readByte(), 255) << 8);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public static final int m6264(Buffer buffer, byte b) throws EOFException {
        C3921.m12667(buffer, "$this$skipAll");
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b) {
            i++;
            buffer.readByte();
        }
        return i;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public static final boolean m6265(Source source, int i, TimeUnit timeUnit) throws IOException {
        boolean z;
        C3921.m12667(source, "$this$skipAll");
        C3921.m12667(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i)) + jNanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            z = true;
        } catch (InterruptedIOException unused) {
            z = false;
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
            }
        } catch (Throwable th) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
        if (jDeadlineNanoTime == Long.MAX_VALUE) {
            source.timeout().clearDeadline();
        } else {
            source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
        }
        return z;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public static final ThreadFactory m6266(String str, boolean z) {
        C3921.m12667(str, "name");
        return new ThreadFactoryC1971(str, z);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public static final List<C3168> m6267(C5207 c5207) {
        C3921.m12667(c5207, "$this$toHeaderList");
        C2523 c2523M13950 = C4542.m13950(0, c5207.size());
        ArrayList arrayList = new ArrayList(C4362.m13522(c2523M13950, 10));
        Iterator<Integer> it = c2523M13950.iterator();
        while (it.hasNext()) {
            int iNextInt = ((AbstractC2348) it).nextInt();
            arrayList.add(new C3168(c5207.m15183(iNextInt), c5207.m15185(iNextInt)));
        }
        return arrayList;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public static final C5207 m6268(List<C3168> list) {
        C3921.m12667(list, "$this$toHeaders");
        C5207.C5208 c5208 = new C5207.C5208();
        for (C3168 c3168 : list) {
            c5208.m15189(c3168.m10775().utf8(), c3168.m10776().utf8());
        }
        return c5208.m15191();
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public static final String m6269(C3573 c3573, boolean z) {
        String strM11532;
        C3921.m12667(c3573, "$this$toHostHeader");
        if (StringsKt__StringsKt.m7275(c3573.m11532(), Constants.COLON_SEPARATOR, false, 2, null)) {
            strM11532 = '[' + c3573.m11532() + ']';
        } else {
            strM11532 = c3573.m11532();
        }
        if (!z && c3573.m11537() == C3573.f12453.m11581(c3573.m11543())) {
            return strM11532;
        }
        return strM11532 + ':' + c3573.m11537();
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public static /* synthetic */ String m6270(C3573 c3573, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return m6269(c3573, z);
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public static final <T> List<T> m6271(List<? extends T> list) {
        C3921.m12667(list, "$this$toImmutableList");
        List<T> listUnmodifiableList = Collections.unmodifiableList(C2543.m9384(list));
        C3921.m12663(listUnmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public static final <K, V> Map<K, V> m6272(Map<K, ? extends V> map) {
        C3921.m12667(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            return C2138.m7235();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        C3921.m12663(mapUnmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return mapUnmodifiableMap;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public static final long m6273(String str, long j) {
        C3921.m12667(str, "$this$toLongOrDefault");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public static final int m6274(String str, int i) throws NumberFormatException {
        if (str != null) {
            try {
                long j = Long.parseLong(str);
                if (j > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (j < 0) {
                    return 0;
                }
                return (int) j;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public static final String m6275(String str, int i, int i2) {
        C3921.m12667(str, "$this$trimSubstring");
        int iM6253 = m6253(str, i, i2);
        String strSubstring = str.substring(iM6253, m6255(str, iM6253, i2));
        C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public static /* synthetic */ String m6276(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return m6275(str, i, i2);
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public static final Throwable m6277(Exception exc, List<? extends Exception> list) {
        C3921.m12667(exc, "$this$withSuppressed");
        C3921.m12667(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            exc.addSuppressed(it.next());
        }
        return exc;
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public static final void m6278(BufferedSink bufferedSink, int i) throws IOException {
        C3921.m12667(bufferedSink, "$this$writeMedium");
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }
}
