package defpackage;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import defpackage.C3083;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.jcodec.containers.mkv.muxer.MKVMuxerTrack;

/* compiled from: Http2Connection.kt */
/* renamed from: ơ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2426 implements Closeable {

    /* renamed from: ޒ, reason: contains not printable characters */
    public static final C4825 f9024;

    /* renamed from: ޓ, reason: contains not printable characters */
    public static final C2429 f9025 = new C2429(null);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean f9026;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC2430 f9027;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Map<Integer, C4419> f9028;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String f9029;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f9030;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f9031;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f9032;

    /* renamed from: ֏, reason: contains not printable characters */
    public final m1 f9033;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final l1 f9034;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final l1 f9035;

    /* renamed from: ހ, reason: contains not printable characters */
    public final l1 f9036;

    /* renamed from: ށ, reason: contains not printable characters */
    public final InterfaceC4683 f9037;

    /* renamed from: ނ, reason: contains not printable characters */
    public long f9038;

    /* renamed from: ރ, reason: contains not printable characters */
    public long f9039;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f9040;

    /* renamed from: ޅ, reason: contains not printable characters */
    public long f9041;

    /* renamed from: ކ, reason: contains not printable characters */
    public long f9042;

    /* renamed from: އ, reason: contains not printable characters */
    public long f9043;

    /* renamed from: ވ, reason: contains not printable characters */
    public final C4825 f9044;

    /* renamed from: މ, reason: contains not printable characters */
    public C4825 f9045;

    /* renamed from: ފ, reason: contains not printable characters */
    public long f9046;

    /* renamed from: ދ, reason: contains not printable characters */
    public long f9047;

    /* renamed from: ތ, reason: contains not printable characters */
    public long f9048;

    /* renamed from: ލ, reason: contains not printable characters */
    public long f9049;

    /* renamed from: ގ, reason: contains not printable characters */
    public final Socket f9050;

    /* renamed from: ޏ, reason: contains not printable characters */
    public final C2809 f9051;

    /* renamed from: ސ, reason: contains not printable characters */
    public final C2433 f9052;

    /* renamed from: ޑ, reason: contains not printable characters */
    public final Set<Integer> f9053;

    /* compiled from: TaskQueue.kt */
    /* renamed from: ơ$Ϳ, reason: contains not printable characters */
    public static final class C2427 extends f1 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f9054;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2426 f9055;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ long f9056;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2427(String str, String str2, C2426 c2426, long j) {
            super(str2, false, 2, null);
            this.f9054 = str;
            this.f9055 = c2426;
            this.f9056 = j;
        }

        @Override // defpackage.f1
        /* renamed from: Ԭ */
        public long mo6034() throws IOException {
            boolean z;
            synchronized (this.f9055) {
                if (this.f9055.f9039 < this.f9055.f9038) {
                    z = true;
                } else {
                    this.f9055.f9038++;
                    z = false;
                }
            }
            if (z) {
                this.f9055.m8941(null);
                return -1L;
            }
            this.f9055.m8970(false, 1, 0);
            return this.f9056;
        }
    }

    /* compiled from: Http2Connection.kt */
    /* renamed from: ơ$Ԩ, reason: contains not printable characters */
    public static final class C2428 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public Socket f9057;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public String f9058;

        /* renamed from: ԩ, reason: contains not printable characters */
        public BufferedSource f9059;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public BufferedSink f9060;

        /* renamed from: ԫ, reason: contains not printable characters */
        public AbstractC2430 f9061;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4683 f9062;

        /* renamed from: ԭ, reason: contains not printable characters */
        public int f9063;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f9064;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final m1 f9065;

        public C2428(boolean z, m1 m1Var) {
            C3921.m12667(m1Var, "taskRunner");
            this.f9064 = z;
            this.f9065 = m1Var;
            this.f9061 = AbstractC2430.f9066;
            this.f9062 = InterfaceC4683.f15900;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2426 m8974() {
            return new C2426(this);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m8975() {
            return this.f9064;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final String m8976() {
            String str = this.f9058;
            if (str == null) {
                C3921.m12681("connectionName");
            }
            return str;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final AbstractC2430 m8977() {
            return this.f9061;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int m8978() {
            return this.f9063;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4683 m8979() {
            return this.f9062;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final BufferedSink m8980() {
            BufferedSink bufferedSink = this.f9060;
            if (bufferedSink == null) {
                C3921.m12681("sink");
            }
            return bufferedSink;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final Socket m8981() {
            Socket socket = this.f9057;
            if (socket == null) {
                C3921.m12681("socket");
            }
            return socket;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final BufferedSource m8982() {
            BufferedSource bufferedSource = this.f9059;
            if (bufferedSource == null) {
                C3921.m12681("source");
            }
            return bufferedSource;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final m1 m8983() {
            return this.f9065;
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public final C2428 m8984(AbstractC2430 abstractC2430) {
            C3921.m12667(abstractC2430, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.f9061 = abstractC2430;
            return this;
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public final C2428 m8985(int i) {
            this.f9063 = i;
            return this;
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public final C2428 m8986(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) throws IOException {
            String str2;
            C3921.m12667(socket, "socket");
            C3921.m12667(str, "peerName");
            C3921.m12667(bufferedSource, "source");
            C3921.m12667(bufferedSink, "sink");
            this.f9057 = socket;
            if (this.f9064) {
                str2 = i5.f6771 + ' ' + str;
            } else {
                str2 = "MockWebServer " + str;
            }
            this.f9058 = str2;
            this.f9059 = bufferedSource;
            this.f9060 = bufferedSink;
            return this;
        }
    }

    /* compiled from: Http2Connection.kt */
    /* renamed from: ơ$Ԫ, reason: contains not printable characters */
    public static final class C2429 {
        public C2429() {
        }

        public /* synthetic */ C2429(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C4825 m8987() {
            return C2426.f9024;
        }
    }

    /* compiled from: Http2Connection.kt */
    /* renamed from: ơ$Ԭ, reason: contains not printable characters */
    public static abstract class AbstractC2430 {

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final C2432 f9067 = new C2432(null);

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final AbstractC2430 f9066 = new C2431();

        /* compiled from: Http2Connection.kt */
        /* renamed from: ơ$Ԭ$Ϳ, reason: contains not printable characters */
        public static final class C2431 extends AbstractC2430 {
            @Override // defpackage.C2426.AbstractC2430
            /* renamed from: ԩ */
            public void mo7800(C4419 c4419) throws IOException {
                C3921.m12667(c4419, "stream");
                c4419.m13616(ErrorCode.REFUSED_STREAM, null);
            }
        }

        /* compiled from: Http2Connection.kt */
        /* renamed from: ơ$Ԭ$Ԩ, reason: contains not printable characters */
        public static final class C2432 {
            public C2432() {
            }

            public /* synthetic */ C2432(C4184 c4184) {
                this();
            }
        }

        /* renamed from: Ԩ */
        public void mo7799(C2426 c2426, C4825 c4825) {
            C3921.m12667(c2426, "connection");
            C3921.m12667(c4825, "settings");
        }

        /* renamed from: ԩ */
        public abstract void mo7800(C4419 c4419) throws IOException;
    }

    /* compiled from: Http2Connection.kt */
    /* renamed from: ơ$Ԯ, reason: contains not printable characters */
    public final class C2433 implements C3083.InterfaceC3086, InterfaceC4090<i4> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C3083 f9068;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2426 f9069;

        /* compiled from: TaskQueue.kt */
        /* renamed from: ơ$Ԯ$Ϳ, reason: contains not printable characters */
        public static final class C2434 extends f1 {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ String f9070;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ boolean f9071;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final /* synthetic */ C2433 f9072;

            /* renamed from: Ԯ, reason: contains not printable characters */
            public final /* synthetic */ boolean f9073;

            /* renamed from: ԯ, reason: contains not printable characters */
            public final /* synthetic */ Ref$ObjectRef f9074;

            /* renamed from: ՠ, reason: contains not printable characters */
            public final /* synthetic */ C4825 f9075;

            /* renamed from: ֈ, reason: contains not printable characters */
            public final /* synthetic */ Ref$LongRef f9076;

            /* renamed from: ֏, reason: contains not printable characters */
            public final /* synthetic */ Ref$ObjectRef f9077;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2434(String str, boolean z, String str2, boolean z2, C2433 c2433, boolean z3, Ref$ObjectRef ref$ObjectRef, C4825 c4825, Ref$LongRef ref$LongRef, Ref$ObjectRef ref$ObjectRef2) {
                super(str2, z2);
                this.f9070 = str;
                this.f9071 = z;
                this.f9072 = c2433;
                this.f9073 = z3;
                this.f9074 = ref$ObjectRef;
                this.f9075 = c4825;
                this.f9076 = ref$LongRef;
                this.f9077 = ref$ObjectRef2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.f1
            /* renamed from: Ԭ */
            public long mo6034() {
                this.f9072.f9069.m8945().mo7799(this.f9072.f9069, (C4825) this.f9074.element);
                return -1L;
            }
        }

        /* compiled from: TaskQueue.kt */
        /* renamed from: ơ$Ԯ$Ԩ, reason: contains not printable characters */
        public static final class C2435 extends f1 {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ String f9078;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ boolean f9079;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final /* synthetic */ C4419 f9080;

            /* renamed from: Ԯ, reason: contains not printable characters */
            public final /* synthetic */ C2433 f9081;

            /* renamed from: ԯ, reason: contains not printable characters */
            public final /* synthetic */ C4419 f9082;

            /* renamed from: ՠ, reason: contains not printable characters */
            public final /* synthetic */ int f9083;

            /* renamed from: ֈ, reason: contains not printable characters */
            public final /* synthetic */ List f9084;

            /* renamed from: ֏, reason: contains not printable characters */
            public final /* synthetic */ boolean f9085;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2435(String str, boolean z, String str2, boolean z2, C4419 c4419, C2433 c2433, C4419 c44192, int i, List list, boolean z3) {
                super(str2, z2);
                this.f9078 = str;
                this.f9079 = z;
                this.f9080 = c4419;
                this.f9081 = c2433;
                this.f9082 = c44192;
                this.f9083 = i;
                this.f9084 = list;
                this.f9085 = z3;
            }

            @Override // defpackage.f1
            /* renamed from: Ԭ */
            public long mo6034() {
                try {
                    this.f9081.f9069.m8945().mo7800(this.f9080);
                    return -1L;
                } catch (IOException e2) {
                    C2708.f10025.m9964().m9955("Http2Connection.Listener failure for " + this.f9081.f9069.m8943(), 4, e2);
                    try {
                        this.f9080.m13616(ErrorCode.PROTOCOL_ERROR, e2);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* compiled from: TaskQueue.kt */
        /* renamed from: ơ$Ԯ$Ԫ, reason: contains not printable characters */
        public static final class C2436 extends f1 {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ String f9086;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ boolean f9087;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final /* synthetic */ C2433 f9088;

            /* renamed from: Ԯ, reason: contains not printable characters */
            public final /* synthetic */ int f9089;

            /* renamed from: ԯ, reason: contains not printable characters */
            public final /* synthetic */ int f9090;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2436(String str, boolean z, String str2, boolean z2, C2433 c2433, int i, int i2) {
                super(str2, z2);
                this.f9086 = str;
                this.f9087 = z;
                this.f9088 = c2433;
                this.f9089 = i;
                this.f9090 = i2;
            }

            @Override // defpackage.f1
            /* renamed from: Ԭ */
            public long mo6034() throws IOException {
                this.f9088.f9069.m8970(true, this.f9089, this.f9090);
                return -1L;
            }
        }

        /* compiled from: TaskQueue.kt */
        /* renamed from: ơ$Ԯ$Ԭ, reason: contains not printable characters */
        public static final class C2437 extends f1 {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ String f9091;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ boolean f9092;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final /* synthetic */ C2433 f9093;

            /* renamed from: Ԯ, reason: contains not printable characters */
            public final /* synthetic */ boolean f9094;

            /* renamed from: ԯ, reason: contains not printable characters */
            public final /* synthetic */ C4825 f9095;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2437(String str, boolean z, String str2, boolean z2, C2433 c2433, boolean z3, C4825 c4825) {
                super(str2, z2);
                this.f9091 = str;
                this.f9092 = z;
                this.f9093 = c2433;
                this.f9094 = z3;
                this.f9095 = c4825;
            }

            @Override // defpackage.f1
            /* renamed from: Ԭ */
            public long mo6034() {
                this.f9093.m8998(this.f9094, this.f9095);
                return -1L;
            }
        }

        public C2433(C2426 c2426, C3083 c3083) {
            C3921.m12667(c3083, "reader");
            this.f9069 = c2426;
            this.f9068 = c3083;
        }

        @Override // defpackage.InterfaceC4090
        public /* bridge */ /* synthetic */ i4 invoke() throws Throwable {
            m8999();
            return i4.f6762;
        }

        @Override // defpackage.C3083.InterfaceC3086
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo8988() {
        }

        @Override // defpackage.C3083.InterfaceC3086
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo8989(boolean z, int i, int i2, List<C3168> list) {
            C3921.m12667(list, "headerBlock");
            if (this.f9069.m8960(i)) {
                this.f9069.m8957(i, list, z);
                return;
            }
            synchronized (this.f9069) {
                C4419 c4419M8949 = this.f9069.m8949(i);
                if (c4419M8949 != null) {
                    i4 i4Var = i4.f6762;
                    c4419M8949.m13636(i5.m6268(list), z);
                    return;
                }
                if (this.f9069.f9032) {
                    return;
                }
                if (i <= this.f9069.m8944()) {
                    return;
                }
                if (i % 2 == this.f9069.m8946() % 2) {
                    return;
                }
                C4419 c4419 = new C4419(i, this.f9069, false, z, i5.m6268(list));
                this.f9069.m8963(i);
                this.f9069.m8950().put(Integer.valueOf(i), c4419);
                l1 l1VarM7528 = this.f9069.f9033.m7528();
                String str = this.f9069.m8943() + '[' + i + "] onStream";
                l1VarM7528.m7467(new C2435(str, true, str, true, c4419, this, c4419M8949, i, list, z), 0L);
            }
        }

        @Override // defpackage.C3083.InterfaceC3086
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo8990(int i, long j) {
            if (i != 0) {
                C4419 c4419M8949 = this.f9069.m8949(i);
                if (c4419M8949 != null) {
                    synchronized (c4419M8949) {
                        c4419M8949.m13613(j);
                        i4 i4Var = i4.f6762;
                    }
                    return;
                }
                return;
            }
            synchronized (this.f9069) {
                C2426 c2426 = this.f9069;
                c2426.f9049 = c2426.m8951() + j;
                C2426 c24262 = this.f9069;
                if (c24262 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                }
                c24262.notifyAll();
                i4 i4Var2 = i4.f6762;
            }
        }

        @Override // defpackage.C3083.InterfaceC3086
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo8991(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            C3921.m12667(bufferedSource, "source");
            if (this.f9069.m8960(i)) {
                this.f9069.m8956(i, bufferedSource, i2, z);
                return;
            }
            C4419 c4419M8949 = this.f9069.m8949(i);
            if (c4419M8949 == null) {
                this.f9069.m8972(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                this.f9069.m8967(j);
                bufferedSource.skip(j);
                return;
            }
            c4419M8949.m13635(bufferedSource, i2);
            if (z) {
                c4419M8949.m13636(i5.f6764, true);
            }
        }

        @Override // defpackage.C3083.InterfaceC3086
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo8992(boolean z, int i, int i2) {
            if (!z) {
                l1 l1Var = this.f9069.f9034;
                String str = this.f9069.m8943() + " ping";
                l1Var.m7467(new C2436(str, true, str, true, this, i, i2), 0L);
                return;
            }
            synchronized (this.f9069) {
                if (i == 1) {
                    this.f9069.f9039++;
                } else if (i != 2) {
                    if (i == 3) {
                        this.f9069.f9042++;
                        C2426 c2426 = this.f9069;
                        if (c2426 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                        }
                        c2426.notifyAll();
                    }
                    i4 i4Var = i4.f6762;
                } else {
                    this.f9069.f9041++;
                }
            }
        }

        @Override // defpackage.C3083.InterfaceC3086
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo8993(int i, int i2, int i3, boolean z) {
        }

        @Override // defpackage.C3083.InterfaceC3086
        /* renamed from: Ԯ, reason: contains not printable characters */
        public void mo8994(int i, ErrorCode errorCode) {
            C3921.m12667(errorCode, "errorCode");
            if (this.f9069.m8960(i)) {
                this.f9069.m8959(i, errorCode);
                return;
            }
            C4419 c4419M8961 = this.f9069.m8961(i);
            if (c4419M8961 != null) {
                c4419M8961.m13637(errorCode);
            }
        }

        @Override // defpackage.C3083.InterfaceC3086
        /* renamed from: ԯ, reason: contains not printable characters */
        public void mo8995(boolean z, C4825 c4825) {
            C3921.m12667(c4825, "settings");
            l1 l1Var = this.f9069.f9034;
            String str = this.f9069.m8943() + " applyAndAckSettings";
            l1Var.m7467(new C2437(str, true, str, true, this, z, c4825), 0L);
        }

        @Override // defpackage.C3083.InterfaceC3086
        /* renamed from: ՠ, reason: contains not printable characters */
        public void mo8996(int i, int i2, List<C3168> list) {
            C3921.m12667(list, "requestHeaders");
            this.f9069.m8958(i2, list);
        }

        @Override // defpackage.C3083.InterfaceC3086
        /* renamed from: ֈ, reason: contains not printable characters */
        public void mo8997(int i, ErrorCode errorCode, ByteString byteString) {
            int i2;
            C4419[] c4419Arr;
            C3921.m12667(errorCode, "errorCode");
            C3921.m12667(byteString, "debugData");
            byteString.size();
            synchronized (this.f9069) {
                Object[] array = this.f9069.m8950().values().toArray(new C4419[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                c4419Arr = (C4419[]) array;
                this.f9069.f9032 = true;
                i4 i4Var = i4.f6762;
            }
            for (C4419 c4419 : c4419Arr) {
                if (c4419.m13622() > i && c4419.m13632()) {
                    c4419.m13637(ErrorCode.REFUSED_STREAM);
                    this.f9069.m8961(c4419.m13622());
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [T, ත] */
        /* renamed from: ֏, reason: contains not printable characters */
        public final void m8998(boolean z, C4825 c4825) {
            C2426 c2426;
            T t;
            l1 l1Var;
            String str;
            C3921.m12667(c4825, "settings");
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            synchronized (this.f9069.m8952()) {
                C2426 c24262 = this.f9069;
                synchronized (c24262) {
                    try {
                        C4825 c4825M8948 = this.f9069.m8948();
                        if (z) {
                            ref$ObjectRef2.element = c4825;
                        } else {
                            ?? c48252 = new C4825();
                            c48252.m14558(c4825M8948);
                            c48252.m14558(c4825);
                            ref$ObjectRef2.element = c48252;
                        }
                        long jM14554 = ((C4825) ref$ObjectRef2.element).m14554() - c4825M8948.m14554();
                        ref$LongRef.element = jM14554;
                        if (jM14554 == 0 || this.f9069.m8950().isEmpty()) {
                            t = 0;
                        } else {
                            Object[] array = this.f9069.m8950().values().toArray(new C4419[0]);
                            if (array == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            t = (C4419[]) array;
                        }
                        ref$ObjectRef.element = t;
                        this.f9069.m8964((C4825) ref$ObjectRef2.element);
                        l1Var = this.f9069.f9036;
                        str = this.f9069.m8943() + " onSettings";
                        c2426 = c24262;
                    } catch (Throwable th) {
                        th = th;
                        c2426 = c24262;
                    }
                    try {
                        l1Var.m7467(new C2434(str, true, str, true, this, z, ref$ObjectRef2, c4825, ref$LongRef, ref$ObjectRef), 0L);
                        i4 i4Var = i4.f6762;
                        try {
                            this.f9069.m8952().m10126((C4825) ref$ObjectRef2.element);
                        } catch (IOException e2) {
                            this.f9069.m8941(e2);
                        }
                        i4 i4Var2 = i4.f6762;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
            T t2 = ref$ObjectRef.element;
            if (((C4419[]) t2) != null) {
                C4419[] c4419Arr = (C4419[]) t2;
                if (c4419Arr == null) {
                    C3921.m12675();
                }
                for (C4419 c4419 : c4419Arr) {
                    synchronized (c4419) {
                        c4419.m13613(ref$LongRef.element);
                        i4 i4Var3 = i4.f6762;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, ҷ] */
        /* renamed from: ׯ, reason: contains not printable characters */
        public void m8999() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            IOException e2 = null;
            try {
                try {
                    this.f9068.m10658(this);
                    while (this.f9068.m10657(false, this)) {
                    }
                    errorCode2 = ErrorCode.NO_ERROR;
                } catch (IOException e3) {
                    e2 = e3;
                } catch (Throwable th) {
                    th = th;
                    errorCode = errorCode3;
                    this.f9069.m8940(errorCode, errorCode3, e2);
                    i5.m6240(this.f9068);
                    throw th;
                }
                try {
                    this.f9069.m8940(errorCode2, ErrorCode.CANCEL, null);
                    errorCode = errorCode2;
                } catch (IOException e4) {
                    e2 = e4;
                    ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                    C2426 c2426 = this.f9069;
                    c2426.m8940(errorCode4, errorCode4, e2);
                    errorCode = c2426;
                    errorCode3 = this.f9068;
                    i5.m6240(errorCode3);
                }
                errorCode3 = this.f9068;
                i5.m6240(errorCode3);
            } catch (Throwable th2) {
                th = th2;
                this.f9069.m8940(errorCode, errorCode3, e2);
                i5.m6240(this.f9068);
                throw th;
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    /* renamed from: ơ$ՠ, reason: contains not printable characters */
    public static final class C2438 extends f1 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f9096;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f9097;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2426 f9098;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f9099;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ Buffer f9100;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final /* synthetic */ int f9101;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final /* synthetic */ boolean f9102;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2438(String str, boolean z, String str2, boolean z2, C2426 c2426, int i, Buffer buffer, int i2, boolean z3) {
            super(str2, z2);
            this.f9096 = str;
            this.f9097 = z;
            this.f9098 = c2426;
            this.f9099 = i;
            this.f9100 = buffer;
            this.f9101 = i2;
            this.f9102 = z3;
        }

        @Override // defpackage.f1
        /* renamed from: Ԭ */
        public long mo6034() {
            try {
                boolean zMo14196 = this.f9098.f9037.mo14196(this.f9099, this.f9100, this.f9101, this.f9102);
                if (zMo14196) {
                    this.f9098.m8952().m10136(this.f9099, ErrorCode.CANCEL);
                }
                if (!zMo14196 && !this.f9102) {
                    return -1L;
                }
                synchronized (this.f9098) {
                    this.f9098.f9053.remove(Integer.valueOf(this.f9099));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    /* renamed from: ơ$ֈ, reason: contains not printable characters */
    public static final class C2439 extends f1 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f9103;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f9104;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2426 f9105;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f9106;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ List f9107;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final /* synthetic */ boolean f9108;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2439(String str, boolean z, String str2, boolean z2, C2426 c2426, int i, List list, boolean z3) {
            super(str2, z2);
            this.f9103 = str;
            this.f9104 = z;
            this.f9105 = c2426;
            this.f9106 = i;
            this.f9107 = list;
            this.f9108 = z3;
        }

        @Override // defpackage.f1
        /* renamed from: Ԭ */
        public long mo6034() {
            boolean zMo14194 = this.f9105.f9037.mo14194(this.f9106, this.f9107, this.f9108);
            if (zMo14194) {
                try {
                    this.f9105.m8952().m10136(this.f9106, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!zMo14194 && !this.f9108) {
                return -1L;
            }
            synchronized (this.f9105) {
                this.f9105.f9053.remove(Integer.valueOf(this.f9106));
            }
            return -1L;
        }
    }

    /* compiled from: TaskQueue.kt */
    /* renamed from: ơ$֏, reason: contains not printable characters */
    public static final class C2440 extends f1 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f9109;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f9110;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2426 f9111;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f9112;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ List f9113;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2440(String str, boolean z, String str2, boolean z2, C2426 c2426, int i, List list) {
            super(str2, z2);
            this.f9109 = str;
            this.f9110 = z;
            this.f9111 = c2426;
            this.f9112 = i;
            this.f9113 = list;
        }

        @Override // defpackage.f1
        /* renamed from: Ԭ */
        public long mo6034() {
            if (!this.f9111.f9037.mo14193(this.f9112, this.f9113)) {
                return -1L;
            }
            try {
                this.f9111.m8952().m10136(this.f9112, ErrorCode.CANCEL);
                synchronized (this.f9111) {
                    this.f9111.f9053.remove(Integer.valueOf(this.f9112));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    /* renamed from: ơ$ׯ, reason: contains not printable characters */
    public static final class C2441 extends f1 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f9114;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f9115;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2426 f9116;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f9117;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ ErrorCode f9118;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2441(String str, boolean z, String str2, boolean z2, C2426 c2426, int i, ErrorCode errorCode) {
            super(str2, z2);
            this.f9114 = str;
            this.f9115 = z;
            this.f9116 = c2426;
            this.f9117 = i;
            this.f9118 = errorCode;
        }

        @Override // defpackage.f1
        /* renamed from: Ԭ */
        public long mo6034() {
            this.f9116.f9037.mo14195(this.f9117, this.f9118);
            synchronized (this.f9116) {
                this.f9116.f9053.remove(Integer.valueOf(this.f9117));
            }
            return -1L;
        }
    }

    /* compiled from: TaskQueue.kt */
    /* renamed from: ơ$ؠ, reason: contains not printable characters */
    public static final class C2442 extends f1 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f9119;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f9120;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2426 f9121;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2442(String str, boolean z, String str2, boolean z2, C2426 c2426) {
            super(str2, z2);
            this.f9119 = str;
            this.f9120 = z;
            this.f9121 = c2426;
        }

        @Override // defpackage.f1
        /* renamed from: Ԭ */
        public long mo6034() throws IOException {
            this.f9121.m8970(false, 2, 0);
            return -1L;
        }
    }

    /* compiled from: TaskQueue.kt */
    /* renamed from: ơ$ހ, reason: contains not printable characters */
    public static final class C2443 extends f1 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f9122;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f9123;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2426 f9124;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f9125;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ ErrorCode f9126;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2443(String str, boolean z, String str2, boolean z2, C2426 c2426, int i, ErrorCode errorCode) {
            super(str2, z2);
            this.f9122 = str;
            this.f9123 = z;
            this.f9124 = c2426;
            this.f9125 = i;
            this.f9126 = errorCode;
        }

        @Override // defpackage.f1
        /* renamed from: Ԭ */
        public long mo6034() throws IOException {
            try {
                this.f9124.m8971(this.f9125, this.f9126);
                return -1L;
            } catch (IOException e2) {
                this.f9124.m8941(e2);
                return -1L;
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    /* renamed from: ơ$ށ, reason: contains not printable characters */
    public static final class C2444 extends f1 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f9127;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f9128;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2426 f9129;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f9130;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ long f9131;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2444(String str, boolean z, String str2, boolean z2, C2426 c2426, int i, long j) {
            super(str2, z2);
            this.f9127 = str;
            this.f9128 = z;
            this.f9129 = c2426;
            this.f9130 = i;
            this.f9131 = j;
        }

        @Override // defpackage.f1
        /* renamed from: Ԭ */
        public long mo6034() throws IOException {
            try {
                this.f9129.m8952().m10138(this.f9130, this.f9131);
                return -1L;
            } catch (IOException e2) {
                this.f9129.m8941(e2);
                return -1L;
            }
        }
    }

    static {
        C4825 c4825 = new C4825();
        c4825.m14559(7, 65535);
        c4825.m14559(5, 16384);
        f9024 = c4825;
    }

    public C2426(C2428 c2428) {
        C3921.m12667(c2428, "builder");
        boolean zM8975 = c2428.m8975();
        this.f9026 = zM8975;
        this.f9027 = c2428.m8977();
        this.f9028 = new LinkedHashMap();
        String strM8976 = c2428.m8976();
        this.f9029 = strM8976;
        this.f9031 = c2428.m8975() ? 3 : 2;
        m1 m1VarM8983 = c2428.m8983();
        this.f9033 = m1VarM8983;
        l1 l1VarM7528 = m1VarM8983.m7528();
        this.f9034 = l1VarM7528;
        this.f9035 = m1VarM8983.m7528();
        this.f9036 = m1VarM8983.m7528();
        this.f9037 = c2428.m8979();
        C4825 c4825 = new C4825();
        if (c2428.m8975()) {
            c4825.m14559(7, 16777216);
        }
        this.f9044 = c4825;
        this.f9045 = f9024;
        this.f9049 = r2.m14554();
        this.f9050 = c2428.m8981();
        this.f9051 = new C2809(c2428.m8980(), zM8975);
        this.f9052 = new C2433(this, new C3083(c2428.m8982(), zM8975));
        this.f9053 = new LinkedHashSet();
        if (c2428.m8978() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(c2428.m8978());
            String str = strM8976 + " ping";
            l1VarM7528.m7467(new C2427(str, str, this, nanos), nanos);
        }
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public static /* synthetic */ void m8939(C2426 c2426, boolean z, m1 m1Var, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            m1Var = m1.f7970;
        }
        c2426.m8966(z, m1Var);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m8940(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void flush() throws IOException {
        this.f9051.flush();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m8940(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) throws IOException {
        int i;
        C3921.m12667(errorCode, "connectionCode");
        C3921.m12667(errorCode2, "streamCode");
        if (i5.f6770 && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        try {
            m8965(errorCode);
        } catch (IOException unused) {
        }
        C4419[] c4419Arr = null;
        synchronized (this) {
            if (!this.f9028.isEmpty()) {
                Object[] array = this.f9028.values().toArray(new C4419[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                c4419Arr = (C4419[]) array;
                this.f9028.clear();
            }
            i4 i4Var = i4.f6762;
        }
        if (c4419Arr != null) {
            for (C4419 c4419 : c4419Arr) {
                try {
                    c4419.m13616(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f9051.close();
        } catch (IOException unused3) {
        }
        try {
            this.f9050.close();
        } catch (IOException unused4) {
        }
        this.f9034.m7471();
        this.f9035.m7471();
        this.f9036.m7471();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m8941(IOException iOException) throws IOException {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        m8940(errorCode, errorCode, iOException);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final boolean m8942() {
        return this.f9026;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final String m8943() {
        return this.f9029;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final int m8944() {
        return this.f9030;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final AbstractC2430 m8945() {
        return this.f9027;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final int m8946() {
        return this.f9031;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final C4825 m8947() {
        return this.f9044;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final C4825 m8948() {
        return this.f9045;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final synchronized C4419 m8949(int i) {
        return this.f9028.get(Integer.valueOf(i));
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final Map<Integer, C4419> m8950() {
        return this.f9028;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final long m8951() {
        return this.f9049;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final C2809 m8952() {
        return this.f9051;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final synchronized boolean m8953(long j) {
        if (this.f9032) {
            return false;
        }
        if (this.f9041 < this.f9040) {
            if (j >= this.f9043) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final C4419 m8954(int i, List<C3168> list, boolean z) throws IOException {
        int i2;
        C4419 c4419;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.f9051) {
            synchronized (this) {
                if (this.f9031 > 1073741823) {
                    m8965(ErrorCode.REFUSED_STREAM);
                }
                if (this.f9032) {
                    throw new ConnectionShutdownException();
                }
                i2 = this.f9031;
                this.f9031 = i2 + 2;
                c4419 = new C4419(i2, this, z3, false, null);
                z2 = !z || this.f9048 >= this.f9049 || c4419.m13630() >= c4419.m13629();
                if (c4419.m13633()) {
                    this.f9028.put(Integer.valueOf(i2), c4419);
                }
                i4 i4Var = i4.f6762;
            }
            if (i == 0) {
                this.f9051.m10132(z3, i2, list);
            } else {
                if (!(true ^ this.f9026)) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                }
                this.f9051.m10135(i, i2, list);
            }
        }
        if (z2) {
            this.f9051.flush();
        }
        return c4419;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final C4419 m8955(List<C3168> list, boolean z) throws IOException {
        C3921.m12667(list, "requestHeaders");
        return m8954(0, list, z);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m8956(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        C3921.m12667(bufferedSource, "source");
        Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        l1 l1Var = this.f9035;
        String str = this.f9029 + '[' + i + "] onData";
        l1Var.m7467(new C2438(str, true, str, true, this, i, buffer, i2, z), 0L);
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m8957(int i, List<C3168> list, boolean z) {
        C3921.m12667(list, "requestHeaders");
        l1 l1Var = this.f9035;
        String str = this.f9029 + '[' + i + "] onHeaders";
        l1Var.m7467(new C2439(str, true, str, true, this, i, list, z), 0L);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m8958(int i, List<C3168> list) {
        C3921.m12667(list, "requestHeaders");
        synchronized (this) {
            if (this.f9053.contains(Integer.valueOf(i))) {
                m8972(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f9053.add(Integer.valueOf(i));
            l1 l1Var = this.f9035;
            String str = this.f9029 + '[' + i + "] onRequest";
            l1Var.m7467(new C2440(str, true, str, true, this, i, list), 0L);
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final void m8959(int i, ErrorCode errorCode) {
        C3921.m12667(errorCode, "errorCode");
        l1 l1Var = this.f9035;
        String str = this.f9029 + '[' + i + "] onReset";
        l1Var.m7467(new C2441(str, true, str, true, this, i, errorCode), 0L);
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final boolean m8960(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final synchronized C4419 m8961(int i) {
        C4419 c4419Remove;
        c4419Remove = this.f9028.remove(Integer.valueOf(i));
        notifyAll();
        return c4419Remove;
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final void m8962() {
        synchronized (this) {
            long j = this.f9041;
            long j2 = this.f9040;
            if (j < j2) {
                return;
            }
            this.f9040 = j2 + 1;
            this.f9043 = System.nanoTime() + MKVMuxerTrack.DEFAULT_TIMESCALE;
            i4 i4Var = i4.f6762;
            l1 l1Var = this.f9034;
            String str = this.f9029 + " ping";
            l1Var.m7467(new C2442(str, true, str, true, this), 0L);
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final void m8963(int i) {
        this.f9030 = i;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final void m8964(C4825 c4825) {
        C3921.m12667(c4825, "<set-?>");
        this.f9045 = c4825;
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public final void m8965(ErrorCode errorCode) throws IOException {
        C3921.m12667(errorCode, "statusCode");
        synchronized (this.f9051) {
            synchronized (this) {
                if (this.f9032) {
                    return;
                }
                this.f9032 = true;
                int i = this.f9030;
                i4 i4Var = i4.f6762;
                this.f9051.m10131(i, errorCode, i5.f6763);
            }
        }
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public final void m8966(boolean z, m1 m1Var) throws IOException {
        C3921.m12667(m1Var, "taskRunner");
        if (z) {
            this.f9051.m10127();
            this.f9051.m10137(this.f9044);
            if (this.f9044.m14554() != 65535) {
                this.f9051.m10138(0, r9 - 65535);
            }
        }
        l1 l1VarM7528 = m1Var.m7528();
        String str = this.f9029;
        l1VarM7528.m7467(new k1(this.f9052, str, true, str, true), 0L);
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public final synchronized void m8967(long j) {
        long j2 = this.f9046 + j;
        this.f9046 = j2;
        long j3 = j2 - this.f9047;
        if (j3 >= this.f9044.m14554() / 2) {
            m8973(0, j3);
            this.f9047 += j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r4 = (int) java.lang.Math.min(r13, r6 - r4);
        r2.element = r4;
        r4 = java.lang.Math.min(r4, r9.f9051.m10133());
        r2.element = r4;
        r9.f9048 += r4;
        r2 = defpackage.i4.f6762;
     */
    /* renamed from: ޡ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m8968(int r10, boolean r11, okio.Buffer r12, long r13) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            ΰ r13 = r9.f9051
            r13.m10128(r11, r10, r12, r3)
            return
        Ld:
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto L76
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            monitor-enter(r9)
        L17:
            long r4 = r9.f9048     // Catch: java.lang.Throwable -> L65 java.lang.InterruptedException -> L67
            long r6 = r9.f9049     // Catch: java.lang.Throwable -> L65 java.lang.InterruptedException -> L67
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L37
            java.util.Map<java.lang.Integer, ଦ> r4 = r9.f9028     // Catch: java.lang.Throwable -> L65 java.lang.InterruptedException -> L67
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L65 java.lang.InterruptedException -> L67
            boolean r4 = r4.containsKey(r5)     // Catch: java.lang.Throwable -> L65 java.lang.InterruptedException -> L67
            if (r4 == 0) goto L2f
            r9.wait()     // Catch: java.lang.Throwable -> L65 java.lang.InterruptedException -> L67
            goto L17
        L2f:
            java.io.IOException r10 = new java.io.IOException     // Catch: java.lang.Throwable -> L65 java.lang.InterruptedException -> L67
            java.lang.String r11 = "stream closed"
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L65 java.lang.InterruptedException -> L67
            throw r10     // Catch: java.lang.Throwable -> L65 java.lang.InterruptedException -> L67
        L37:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r13, r6)     // Catch: java.lang.Throwable -> L65
            int r4 = (int) r4     // Catch: java.lang.Throwable -> L65
            r2.element = r4     // Catch: java.lang.Throwable -> L65
            ΰ r5 = r9.f9051     // Catch: java.lang.Throwable -> L65
            int r5 = r5.m10133()     // Catch: java.lang.Throwable -> L65
            int r4 = java.lang.Math.min(r4, r5)     // Catch: java.lang.Throwable -> L65
            r2.element = r4     // Catch: java.lang.Throwable -> L65
            long r5 = r9.f9048     // Catch: java.lang.Throwable -> L65
            long r7 = (long) r4     // Catch: java.lang.Throwable -> L65
            long r5 = r5 + r7
            r9.f9048 = r5     // Catch: java.lang.Throwable -> L65
            i4 r2 = defpackage.i4.f6762     // Catch: java.lang.Throwable -> L65
            monitor-exit(r9)
            long r5 = (long) r4
            long r13 = r13 - r5
            ΰ r2 = r9.f9051
            if (r11 == 0) goto L60
            int r5 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r5 != 0) goto L60
            r5 = 1
            goto L61
        L60:
            r5 = r3
        L61:
            r2.m10128(r5, r10, r12, r4)
            goto Ld
        L65:
            r10 = move-exception
            goto L74
        L67:
            java.lang.Thread r10 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L65
            r10.interrupt()     // Catch: java.lang.Throwable -> L65
            java.io.InterruptedIOException r10 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L65
            r10.<init>()     // Catch: java.lang.Throwable -> L65
            throw r10     // Catch: java.lang.Throwable -> L65
        L74:
            monitor-exit(r9)
            throw r10
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C2426.m8968(int, boolean, okio.Buffer, long):void");
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m8969(int i, boolean z, List<C3168> list) throws IOException {
        C3921.m12667(list, "alternating");
        this.f9051.m10132(z, i, list);
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final void m8970(boolean z, int i, int i2) throws IOException {
        try {
            this.f9051.m10134(z, i, i2);
        } catch (IOException e2) {
            m8941(e2);
        }
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public final void m8971(int i, ErrorCode errorCode) throws IOException {
        C3921.m12667(errorCode, "statusCode");
        this.f9051.m10136(i, errorCode);
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public final void m8972(int i, ErrorCode errorCode) {
        C3921.m12667(errorCode, "errorCode");
        l1 l1Var = this.f9034;
        String str = this.f9029 + '[' + i + "] writeSynReset";
        l1Var.m7467(new C2443(str, true, str, true, this, i, errorCode), 0L);
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public final void m8973(int i, long j) {
        l1 l1Var = this.f9034;
        String str = this.f9029 + '[' + i + "] windowUpdate";
        l1Var.m7467(new C2444(str, true, str, true, this, i, j), 0L);
    }
}
