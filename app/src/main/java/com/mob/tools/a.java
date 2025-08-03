package com.mob.tools;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class a {
    private static final Object a = new Object();
    private static final Object b = new Object();
    private volatile HashSet<String> c = new HashSet<>();
    private File d;

    /* renamed from: e, reason: collision with root package name */
    private int f17710e;
    private String f;

    /* renamed from: com.mob.tools.a$a, reason: collision with other inner class name */
    public interface InterfaceC1902a {
        void a(String str);

        boolean a(DH.DHResponse dHResponse);
    }

    public a(String str, String str2, int i) {
        this.f17710e = i;
        if (str2 == null) {
            str2 = "null";
        } else if (TextUtils.isDigitsOnly(str2)) {
            str2 = str + str2;
        }
        this.f = str2;
        File dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContextSafely(), str);
        this.d = dataCacheFile;
        if (dataCacheFile.isDirectory()) {
            return;
        }
        this.d.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        synchronized (this.c) {
            this.c.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                return true;
            }
            this.c.add(str);
            return false;
        }
    }

    public void a(String str) {
        a(str, false);
    }

    public void a(String str, boolean z) {
        String strEncodeToString;
        FileWriter fileWriter;
        String name;
        BufferedWriter bufferedWriter;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            strEncodeToString = Base64.encodeToString(str.getBytes("utf-8"), 2);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            strEncodeToString = null;
        }
        if (TextUtils.isEmpty(strEncodeToString)) {
            return;
        }
        synchronized (a) {
            File fileA = a(z);
            try {
                fileWriter = new FileWriter(fileA, true);
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                fileWriter = null;
            }
            try {
                bufferedWriter.newLine();
                bufferedWriter.write(strEncodeToString);
                ResHelper.closeIOs(bufferedWriter);
                ResHelper.closeIOs(fileWriter);
                name = fileA.getName();
            } catch (Throwable th4) {
                th = th4;
                bufferedWriter2 = bufferedWriter;
                try {
                    MobLog.getInstance().d(th);
                    ResHelper.closeIOs(bufferedWriter2);
                    ResHelper.closeIOs(fileWriter);
                    name = fileA.getName();
                    c(name);
                } catch (Throwable th5) {
                    ResHelper.closeIOs(bufferedWriter2);
                    ResHelper.closeIOs(fileWriter);
                    c(fileA.getName());
                    throw th5;
                }
            }
            c(name);
        }
    }

    private File a(boolean z) {
        File file;
        File[] fileArrListFiles = this.d.listFiles();
        int i = 5;
        int i2 = 3;
        char c = 2;
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            int length = fileArrListFiles.length;
            int i3 = 0;
            int i4 = 1;
            while (i3 < length) {
                File file2 = fileArrListFiles[i3];
                String name = file2.getName();
                if (name.startsWith(this.f)) {
                    String[] strArrSplit = name.split("_");
                    if (!z && strArrSplit.length == i2) {
                        try {
                            int i5 = Integer.parseInt(strArrSplit[c]);
                            if (i5 < this.f17710e && !b(name)) {
                                File file3 = this.d;
                                Object[] objArr = new Object[i];
                                objArr[0] = this.f;
                                objArr[1] = "_";
                                objArr[2] = Integer.valueOf(i4);
                                objArr[3] = "_";
                                objArr[4] = Integer.valueOf(i5 + 1);
                                File file4 = new File(file3, a(objArr));
                                return file2.renameTo(file4) ? file4 : file2;
                            }
                        } catch (Throwable th) {
                            MobLog.getInstance().d(th);
                        }
                    }
                    if (strArrSplit.length > 1) {
                        try {
                            if (Integer.parseInt(strArrSplit[1]) == i4) {
                                i4++;
                            }
                        } catch (Throwable th2) {
                            MobLog.getInstance().d(th2);
                        }
                    }
                }
                i3++;
                i = 5;
                i2 = 3;
                c = 2;
            }
            file = new File(this.d, a(this.f, "_", Integer.valueOf(i4), "_", 0));
        } else {
            file = new File(this.d, a(this.f, "_", 1, "_", 0));
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
        return file;
    }

    public void a(final InterfaceC1902a interfaceC1902a) {
        if (interfaceC1902a == null) {
            return;
        }
        synchronized (b) {
            final File[] fileArrListFiles = this.d.listFiles(new FilenameFilter() { // from class: com.mob.tools.a.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return !TextUtils.isEmpty(str) && str.startsWith(a.this.f);
                }
            });
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                DH.requester(MobSDK.getContext()).getDetailNetworkTypeForStatic().getAppName().getDeviceKey().getDeviceId().request(new DH.DHResponder() { // from class: com.mob.tools.a.2
                    @Override // com.mob.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        BufferedReader bufferedReader;
                        for (File file : fileArrListFiles) {
                            String name = file.getName();
                            if (!a.this.b(name)) {
                                FileReader fileReader = null;
                                try {
                                    FileReader fileReader2 = new FileReader(file);
                                    try {
                                        bufferedReader = new BufferedReader(fileReader2);
                                        while (true) {
                                            try {
                                                String line = bufferedReader.readLine();
                                                if (line == null) {
                                                    break;
                                                } else {
                                                    interfaceC1902a.a(new String(Base64.decode(line, 2), "utf-8"));
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                fileReader = fileReader2;
                                                try {
                                                    MobLog.getInstance().d(th);
                                                    ResHelper.closeIOs(bufferedReader);
                                                    ResHelper.closeIOs(fileReader);
                                                    a.this.c(name);
                                                } catch (Throwable th2) {
                                                    ResHelper.closeIOs(bufferedReader);
                                                    ResHelper.closeIOs(fileReader);
                                                    a.this.c(name);
                                                    throw th2;
                                                }
                                            }
                                        }
                                        if (interfaceC1902a.a(dHResponse)) {
                                            file.delete();
                                        }
                                        ResHelper.closeIOs(bufferedReader);
                                        ResHelper.closeIOs(fileReader2);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedReader = null;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    bufferedReader = null;
                                }
                                a.this.c(name);
                            }
                        }
                    }
                });
            }
        }
    }

    public void a(long j) {
        synchronized (b) {
            File[] fileArrListFiles = this.d.listFiles(new FilenameFilter() { // from class: com.mob.tools.a.3
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return !TextUtils.isEmpty(str) && str.startsWith(a.this.f);
                }
            });
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                long length = 0;
                for (File file : fileArrListFiles) {
                    length += file.length();
                }
                if (length >= j) {
                    for (File file2 : fileArrListFiles) {
                        file2.delete();
                    }
                }
            }
        }
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb.toString();
    }
}
