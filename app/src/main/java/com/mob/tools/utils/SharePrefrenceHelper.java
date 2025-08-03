package com.mob.tools.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.commons.C5340r;
import com.mob.commons.n;
import com.mob.commons.u;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class SharePrefrenceHelper implements PublicMemberKeeper {
    private Context a;
    private volatile a b;

    public static final class a {
        private static Handler c;
        private File a;
        private HashMap<String, Object> b = new HashMap<>();

        static {
            String str;
            if (TextUtils.isEmpty("M-")) {
                str = null;
            } else {
                str = u.a + n.b("002Tdgfg");
            }
            c = MobHandlerThread.newHandler(str, new Handler.Callback() { // from class: com.mob.tools.utils.SharePrefrenceHelper.a.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    try {
                        Bundle data = message.getData();
                        String string = data.getString(n.b("0041geefdbcj"));
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(data.getString(n.b("004*egcddcGh"))), "utf-8");
                        outputStreamWriter.append((CharSequence) string);
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                        return false;
                    } catch (Throwable th) {
                        MobLog.getInstance().w(th);
                        return false;
                    }
                }
            });
        }

        public a(Context context, String str) {
            if (context != null) {
                try {
                    File file = new File(new File(context.getFilesDir(), n.b("003Bfhdbeb")), str);
                    this.a = file;
                    if (!file.getParentFile().exists()) {
                        this.a.getParentFile().mkdirs();
                    }
                    if (!this.a.exists()) {
                        this.a.createNewFile();
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                    return;
                }
            }
            c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b(String str) {
            Object obj;
            synchronized (this.b) {
                obj = this.b.get(str);
            }
            return obj;
        }

        private void c() {
            BufferedReader bufferedReader;
            Throwable th;
            synchronized (this.b) {
                File file = this.a;
                if (file != null && file.exists()) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.a), "utf-8"));
                    } catch (Throwable th2) {
                        bufferedReader = null;
                        th = th2;
                    }
                    try {
                        StringBuilder sb = new StringBuilder();
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            if (sb.length() > 0) {
                                sb.append("\n");
                            }
                            sb.append(line);
                        }
                        this.b = HashonHelper.fromJson(sb.toString());
                        C5340r.a(bufferedReader);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            MobLog.getInstance().w(th);
                            C5340r.a(bufferedReader);
                        } catch (Throwable th4) {
                            C5340r.a(bufferedReader);
                            throw th4;
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, Object obj) {
            synchronized (this.b) {
                this.b.put(str, obj);
                if (c != null && this.a != null) {
                    Message message = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putString(n.b("004Mgeefdbcj"), HashonHelper.fromHashMap(this.b));
                    bundle.putString(n.b("004!egcddcZh"), this.a.getAbsolutePath());
                    message.setData(bundle);
                    message.what = 1;
                    c.sendMessage(message);
                }
            }
        }

        public void b(String str, int i) {
            a(str, Integer.valueOf(i));
        }

        public void b(String str, long j) {
            a(str, Long.valueOf(j));
        }

        public void b(String str, boolean z) {
            a(str, z ? (byte) 1 : (byte) 0);
        }

        public void b(String str, String str2) {
            a(str, (Object) str2);
        }

        public void b() {
            synchronized (this.b) {
                this.b.clear();
            }
            if (c == null || this.a == null) {
                return;
            }
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString(n.b("0045geefdbcj"), HashonHelper.fromHashMap(this.b));
            bundle.putString(n.b("004=egcddcOh"), this.a.getAbsolutePath());
            message.setData(bundle);
            message.what = 1;
            c.sendMessage(message);
        }

        public void a(String str, byte b) {
            a(str, Byte.valueOf(b));
        }

        public int a(String str, int i) {
            Object objB = b(str);
            return objB != null ? ((Number) objB).intValue() : i;
        }

        public long a(String str, long j) {
            Object objB = b(str);
            return objB != null ? ((Number) objB).longValue() : j;
        }

        public boolean a(String str, boolean z) {
            Object objB = b(str);
            return objB != null ? ((Number) objB).byteValue() == 1 : z;
        }

        public String a(String str, String str2) {
            Object objB = b(str);
            return objB != null ? (String) objB : str2;
        }

        public HashMap<String, Object> a() {
            HashMap<String, Object> map;
            synchronized (this.b) {
                map = new HashMap<>();
                map.putAll(this.b);
            }
            return map;
        }

        public void a(HashMap<String, Object> map) {
            synchronized (this.b) {
                this.b.putAll(map);
            }
            if (c == null || this.a == null) {
                return;
            }
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString(n.b("004Xgeefdbcj"), HashonHelper.fromHashMap(this.b));
            bundle.putString(n.b("004ZegcddcIh"), this.a.getAbsolutePath());
            message.setData(bundle);
            message.what = 1;
            c.sendMessage(message);
        }

        public void a(String str) {
            a(str, (Object) null);
        }
    }

    public SharePrefrenceHelper(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
    }

    public void clear() {
        if (this.b != null) {
            this.b.b();
        }
    }

    public Object get(String str) {
        ObjectInputStream objectInputStream;
        try {
            String string = getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(string, 2)));
            } catch (Throwable th) {
                th = th;
                objectInputStream = null;
            }
            try {
                Object object = objectInputStream.readObject();
                objectInputStream.close();
                C5340r.a(objectInputStream);
                return object;
            } catch (Throwable th2) {
                th = th2;
                C5340r.a(objectInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            MobLog.getInstance().w(th3);
            return null;
        }
    }

    public HashMap<String, Object> getAll() {
        return this.b != null ? this.b.a() : new HashMap<>();
    }

    public boolean getBoolean(String str) {
        if (this.b != null) {
            return this.b.a(str, false);
        }
        return false;
    }

    public int getInt(String str) {
        if (this.b != null) {
            return this.b.a(str, 0);
        }
        return 0;
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public Object getObj(String str, Object obj) {
        return this.b != null ? this.b.b(str) : obj;
    }

    public String getString(String str) {
        return this.b != null ? this.b.a(str, "") : "";
    }

    public void open(String str) {
        open(str, 0);
    }

    public void put(String str, Object obj) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        if (obj == null) {
            return;
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            putString(str, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
            C5340r.a(objectOutputStream);
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            try {
                MobLog.getInstance().w(th);
                C5340r.a(objectOutputStream2);
            } catch (Throwable th3) {
                C5340r.a(objectOutputStream2);
                throw th3;
            }
        }
    }

    public void putAll(HashMap<String, Object> map) {
        if (this.b != null) {
            this.b.a(map);
        }
    }

    public void putBoolean(String str, Boolean bool) {
        if (this.b != null) {
            this.b.b(str, bool.booleanValue());
        }
    }

    public void putInt(String str, Integer num) {
        if (this.b != null) {
            this.b.b(str, num.intValue());
        }
    }

    public void putLong(String str, Long l) {
        if (this.b != null) {
            this.b.b(str, l.longValue());
        }
    }

    public void putObj(String str, Object obj) {
        if (obj == null && this.b != null) {
            this.b.a(str);
        } else if (this.b != null) {
            this.b.a(str, obj);
        }
    }

    public void putString(String str, String str2) {
        if (this.b != null) {
            this.b.b(str, str2);
        }
    }

    public void remove(String str) {
        if (this.b != null) {
            this.b.a(str);
        }
    }

    public long getLong(String str, long j) {
        return this.b != null ? this.b.a(str, j) : j;
    }

    public void open(String str, int i) {
        this.b = new a(this.a, str + "_" + i);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.b != null ? this.b.a(str, z) : z;
    }

    public int getInt(String str, int i) {
        return this.b != null ? this.b.a(str, i) : i;
    }

    public String getString(String str, String str2) {
        return this.b != null ? this.b.a(str, str2) : str2;
    }
}
