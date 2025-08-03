package com.mob.socketservice;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.mob.MobSDK;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class g {
    private static final byte[] a = new byte[0];
    private a b;
    private int f;
    private String g;
    private int h;
    private volatile String i;
    private Socket j;
    private InputStream k;
    private OutputStream l;
    private Handler m;
    private Timer n;
    private TimerTask o;
    private String r;
    private String s;
    private String t;
    private String u;
    private int p = 0;
    private volatile int q = TypedValues.TransitionType.TYPE_AUTO_TRANSITION;
    private volatile Object v = new Object();

    /* renamed from: e, reason: collision with root package name */
    private MobRSA f17709e = new MobRSA(1024);
    private BigInteger c = new BigInteger("009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", 16);
    private BigInteger d = new BigInteger("1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1", 16);

    public interface a {
        void h();

        void i();

        void j();

        void k();
    }

    public g(a aVar) {
        this.b = aVar;
    }

    public static /* synthetic */ int j(g gVar) {
        int i = gVar.p;
        gVar.p = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Socket socket = this.j;
        if (socket == null || socket.isClosed()) {
            return;
        }
        try {
            if (TextUtils.isEmpty(this.i)) {
                CLog.getInstance().d("pushService sendPing token is null", new Object[0]);
                return;
            }
            CLog.getInstance().d("pushService tcp ping by token:" + this.i, new Object[0]);
            ByteMsg byteMsg = new ByteMsg();
            byteMsg.setHead((byte) 1);
            byteMsg.setType(1002);
            byteMsg.setLength(this.i.getBytes().length);
            byteMsg.setContent(this.i.getBytes());
            a(this.j, byteMsg);
        } catch (Throwable th) {
            CLog.getInstance().d("pushService tcp ping failed:" + th.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            if (this.n == null) {
                this.n = new Timer();
            }
            if (this.o == null) {
                this.o = new TimerTask() { // from class: com.mob.socketservice.g.3
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (g.this.p < 0) {
                            g.this.k();
                            g.j(g.this);
                            return;
                        }
                        synchronized (g.this.v) {
                            if (g.this.n != null) {
                                g.this.n.cancel();
                            }
                        }
                        g.this.p = 0;
                        g.this.q = TypedValues.TransitionType.TYPE_TO;
                        g.this.a(3000L);
                    }
                };
            }
            this.n.schedule(this.o, 0L, 1000L);
        } catch (Throwable th) {
            CLog.getInstance().e(th);
        }
    }

    private void m() {
        synchronized (this.v) {
            try {
                Timer timer = this.n;
                if (timer != null) {
                    timer.cancel();
                    this.n = null;
                }
                TimerTask timerTask = this.o;
                if (timerTask != null) {
                    timerTask.cancel();
                    this.o = null;
                }
                this.p = 0;
            } finally {
            }
        }
    }

    private void n() {
        int iA;
        byte[] bArr;
        try {
            this.k = this.j.getInputStream();
            while (this.j.isConnected() && !this.j.isClosed()) {
                int i = this.k.read();
                while (i != 1) {
                    if (i == -1) {
                        throw new Exception("read failed, try reconnect");
                    }
                }
                int iA2 = a(this.k);
                if (iA2 >= 0 && iA2 <= 33554432 && (iA = a(this.k)) >= 1000 && iA <= 20000) {
                    if (iA2 > 0) {
                        bArr = new byte[iA2];
                        a(this.k, bArr);
                    } else {
                        bArr = new byte[0];
                    }
                    CLog.getInstance().i("pushService client receive tcp server send msg type:" + iA, new Object[0]);
                    if (iA == 1000) {
                        b(bArr);
                    } else if (iA == 1002) {
                        a(bArr, iA2);
                    } else if (iA != 9003) {
                        if (iA == 9004) {
                            a(bArr);
                        }
                        a(iA, bArr);
                    } else {
                        k();
                    }
                }
            }
        } catch (Throwable th) {
            CLog.getInstance().e("pushService tcp receiver failed, error:" + th.getMessage(), new Object[0]);
        }
        e();
    }

    private void d() {
        try {
            String str = this.r;
            String strI = i();
            CLog.getInstance().i("pushService login tcp by rid:" + str + ", guardId:" + strI, new Object[0]);
            JSONObject jSONObject = new JSONObject();
            String appkey = TextUtils.isEmpty(MobSDK.getAppkey()) ? this.t : MobSDK.getAppkey();
            try {
                if (TextUtils.isEmpty(appkey)) {
                    for (int i = 1; i <= 5; i++) {
                        CLog.getInstance().i("pushService login try get appkey times:" + i, new Object[0]);
                        Thread.sleep(2000L);
                        appkey = MobSDK.getAppkey();
                        if (!TextUtils.isEmpty(appkey)) {
                            break;
                        }
                    }
                }
            } catch (InterruptedException unused) {
                CLog.getInstance().i("pushService login try get appkey InterruptedException", new Object[0]);
            }
            jSONObject.put("appkey", appkey);
            jSONObject.put("plat", "1");
            jSONObject.put("sdkVersion", MobConnect.SDK_VERSION_CODE);
            jSONObject.put("rid", str);
            jSONObject.put("guardId", strI);
            jSONObject.put("apppkg", MobSDK.getContext().getPackageName());
            String string = jSONObject.toString();
            CLog.getInstance().d("pushService login tcp json:" + string, new Object[0]);
            int length = string.getBytes("utf-8").length;
            ByteMsg byteMsg = new ByteMsg();
            byteMsg.setHead((byte) 1);
            byteMsg.setLength(length);
            byteMsg.setType(1001);
            byteMsg.setContent(string.getBytes());
            a(this.j, byteMsg);
            j();
        } catch (Throwable th) {
            CLog.getInstance().e("pushService login failed, error:" + th.getMessage(), new Object[0]);
        }
    }

    private void e() {
        CLog.getInstance().d("pushService socket reConnect", new Object[0]);
        g();
        a aVar = this.b;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void f() throws IOException {
        CLog.getInstance().d("pushService tcp redirect", new Object[0]);
        g();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            this.q = TypedValues.TransitionType.TYPE_AUTO_TRANSITION;
            m();
            InputStream inputStream = this.k;
            if (inputStream != null) {
                inputStream.close();
                this.k = null;
            }
            OutputStream outputStream = this.l;
            if (outputStream != null) {
                outputStream.close();
                this.l = null;
            }
            Socket socket = this.j;
            if (socket != null) {
                socket.close();
                this.j = null;
            }
        } catch (Throwable th) {
            CLog.getInstance().d("pushService close failed, error:" + th, new Object[0]);
        }
    }

    private void h() throws IOException {
        try {
            CLog.getInstance().d("pushService Init connect to {" + this.g + "}:{" + this.h + "}", new Object[0]);
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(this.g, this.h), this.f);
            this.j = socket;
            CLog.getInstance().i("pushService tcp connect successful.", new Object[0]);
            a aVar = this.b;
            if (aVar != null) {
                aVar.i();
            }
            d();
            n();
        } catch (IOException e2) {
            CLog.getInstance().d("pushService Init connect failed, error:" + e2, new Object[0]);
            e();
        }
    }

    private String i() {
        if (!TextUtils.isEmpty(this.s)) {
            return this.s;
        }
        String strF = d.f();
        this.s = strF;
        return strF;
    }

    private void j() {
        new Thread(new Runnable() { // from class: com.mob.socketservice.g.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(g.this.f);
                    if (TextUtils.isEmpty(g.this.i)) {
                        g.this.g();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).start();
    }

    public void c() {
        k();
        a(2000L);
        this.q = 703;
    }

    public void b(String str) {
        this.s = str;
    }

    public void a(int i) {
        this.f = i * 1000;
    }

    public boolean b() {
        try {
            Socket socket = this.j;
            if (socket != null) {
                return !socket.isClosed();
            }
            return false;
        } catch (Throwable th) {
            CLog.getInstance().d("pushService isSocketAlive error:" + th.getMessage(), new Object[0]);
            return false;
        }
    }

    public void a(String str, int i) {
        this.g = str;
        this.h = i;
        g();
        h();
    }

    public void c(String str) {
        this.t = str;
    }

    private void b(byte[] bArr) throws IOException, NullPointerException {
        HashMap map = (HashMap) new Hashon().fromJson(new String(bArr, "utf-8")).get("data");
        if (map == null) {
            return;
        }
        CLog.getInstance().d("pushService tcp receiver dealMsgResponse, data:" + map.toString(), new Object[0]);
        int iIntValue = ((Integer) map.get("type")).intValue();
        if (iIntValue == 2) {
            String str = (String) map.get("domain");
            this.g = str.substring(0, str.indexOf(Constants.COLON_SEPARATOR));
            this.h = Integer.valueOf(str.substring(str.indexOf(Constants.COLON_SEPARATOR) + 1)).intValue();
            f();
            return;
        }
        if (iIntValue == 1) {
            this.i = String.valueOf(map.get("token"));
            a aVar = this.b;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    public void a(String str) {
        this.r = str;
    }

    public void a(int i, String str) {
        if (str == null) {
            CLog.getInstance().e("pushService sendSocketMsg content is null", new Object[0]);
            return;
        }
        try {
            CLog.getInstance().d("pushService sendSocketMsg content:" + str + " ,type:" + i, new Object[0]);
            ByteMsg byteMsg = new ByteMsg();
            byteMsg.setHead((byte) 1);
            byteMsg.setType(i);
            byteMsg.setLength(str.getBytes().length);
            byteMsg.setContent(str.getBytes());
            a(this.j, byteMsg);
        } catch (Throwable th) {
            CLog.getInstance().e(th);
        }
    }

    public void a() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        try {
            if (this.m == null) {
                this.m = new Handler(new Handler.Callback() { // from class: com.mob.socketservice.g.2
                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        switch (g.this.q) {
                            case TypedValues.TransitionType.TYPE_FROM /* 701 */:
                                CLog.getInstance().d("pushService checkPing:ping success -- " + g.this.q, new Object[0]);
                                return false;
                            case TypedValues.TransitionType.TYPE_TO /* 702 */:
                                CLog.getInstance().d("pushService checkPing:ping close -- " + g.this.q, new Object[0]);
                                g.this.g();
                                return false;
                            case 703:
                                CLog.getInstance().d("pushService checkPing:ping rePing -- " + g.this.q, new Object[0]);
                                g.this.l();
                                return false;
                            default:
                                return false;
                        }
                    }
                });
            }
            this.m.sendMessageDelayed(new Message(), j);
        } catch (Throwable th) {
            CLog.getInstance().d("pushService checkPing failed:" + th.getMessage(), new Object[0]);
        }
    }

    private void a(Socket socket, ByteMsg byteMsg) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        this.l = outputStream;
        byte[] bArr = new byte[8];
        outputStream.write(byteMsg.getHead());
        com.mob.socketservice.a.a(byteMsg.getLength(), bArr);
        this.l.write(bArr, 0, 4);
        com.mob.socketservice.a.a(byteMsg.getType(), bArr);
        this.l.write(bArr, 0, 4);
        this.l.write(byteMsg.getContent());
        this.l.flush();
    }

    public void d(String str) {
        this.u = str;
    }

    private void a(int i, byte[] bArr) {
        HashMap<Integer, String> mapB = f.a().b();
        if (mapB.size() == 0) {
            CLog.getInstance().e("pushService dealMsgPlugin typeMap.size() == 0", new Object[0]);
            return;
        }
        Iterator<Integer> it = mapB.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (i == iIntValue) {
                Bundle bundle = new Bundle();
                bundle.putByteArray(mapB.get(Integer.valueOf(iIntValue)), bArr);
                CLog.getInstance().d("pushService dealMsgPlugin sendClientMessage:" + i, new Object[0]);
                f.a().a(i, bundle);
                return;
            }
        }
    }

    private void a(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            String str = new String(Data.AES128Decode(String.format("%16s", this.r).replaceAll(MyUTIL.white_space, "0").getBytes(), Base64.decode(bArr, 2)), "utf-8");
            CLog.getInstance().d("pushService tcp parseGuardMsg:" + str, new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putString("content", str);
            f.a().a(9004, bundle);
        } catch (Throwable th) {
            CLog.getInstance().e(th);
        }
    }

    private void a(byte[] bArr, int i) {
        byte b = i > 0 ? bArr[0] : (byte) 0;
        CLog.getInstance().d("pushService tcp tick type:" + ((int) b), new Object[0]);
        if (b == 1) {
            this.q = TypedValues.TransitionType.TYPE_FROM;
            m();
            a aVar = this.b;
            if (aVar != null) {
                aVar.k();
                return;
            }
            return;
        }
        e();
    }

    private int a(InputStream inputStream) throws IOException {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) + (inputStream.read() & 255);
        }
        return i;
    }

    private void a(InputStream inputStream, byte[] bArr) throws IOException {
        a(inputStream, bArr, 0, bArr.length);
    }

    private void a(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i + i3] = (byte) inputStream.read();
        }
    }
}
