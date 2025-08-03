package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaScannerConnection;
import android.net.Uri;
import com.blink.academy.film.FilmApp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: BitmapUtil.java */
/* renamed from: ˁ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2735 {

    /* compiled from: BitmapUtil.java */
    /* renamed from: ˁ$Ϳ, reason: contains not printable characters */
    public class C2736 implements MediaScannerConnection.OnScanCompletedListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ C2628 f10065;

        public C2736(C2628 c2628) {
            this.f10065 = c2628;
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            this.f10065.m9641(uri.toString());
            C5049.m14852().m14860(this.f10065);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Bitmap m9986(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        System.gc();
        return bitmapCreateBitmap;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m9987(String str, C2628 c2628) {
        MediaScannerConnection.scanFile(FilmApp.m402(), new String[]{str}, null, new C2736(c2628));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m9988(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
        System.gc();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x004f -> B:32:0x0052). Please report as a decompilation issue!!! */
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m9989(Bitmap bitmap, String str) throws Throwable {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!file.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream = null;
        try {
        } catch (IOException e2) {
            e2.printStackTrace();
            fileOutputStream = fileOutputStream;
        }
        try {
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(str);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream3);
                    fileOutputStream3.flush();
                    StringBuilder sb = new StringBuilder();
                    sb.append("save success : filePath : ");
                    sb.append(str);
                    C4638.m14099("saveBitmapToLocal", sb.toString());
                    fileOutputStream3.close();
                    fileOutputStream = sb;
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream2 = fileOutputStream3;
                    e.printStackTrace();
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                        fileOutputStream = fileOutputStream2;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m9990(Bitmap bitmap) throws Throwable {
        String strM12994 = C4062.m12994();
        File file = new File(strM12994);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = strM12994 + System.currentTimeMillis();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream2);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return str;
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        return "";
                    }
                    try {
                        fileOutputStream.close();
                        return "";
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return "";
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static String m9991(Bitmap bitmap) throws Throwable {
        String strM12995 = C4062.m12995();
        File file = new File(strM12995);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = strM12995 + System.currentTimeMillis();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream2);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return str;
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        return "";
                    }
                    try {
                        fileOutputStream.close();
                        return "";
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return "";
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
