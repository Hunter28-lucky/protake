package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.http.okhttp.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: FileUtil.java */
/* renamed from: Ը, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3180 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Bitmap.CompressFormat f11258 = Bitmap.CompressFormat.JPEG;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Executor f11259 = Executors.newCachedThreadPool();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m10789(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & ExifInterface.MARKER);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m10790(File file) {
        if (!file.exists()) {
            return true;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                m10790(file2);
                file2.delete();
            } else if (file2.exists()) {
                file2.delete();
            }
        }
        return true;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m10791(String str, String str2) throws IOException {
        ContentResolver contentResolver;
        ContentValues contentValues;
        Uri uriInsert;
        FileOutputStream fileOutputStream;
        FileChannel channel;
        FileChannel channel2;
        long size;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string = "";
        if (C2813.m10151()) {
            long j = 0;
            try {
                contentResolver = FilmApp.m402().getContentResolver();
                contentValues = new ContentValues();
                contentValues.put("is_pending", (Integer) 1);
                String str3 = Environment.DIRECTORY_DCIM + "/" + C4062.f14103;
                contentValues.put("mime_type", "video/mp4");
                contentValues.put("title", str2);
                contentValues.put("_display_name", str2);
                contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
                contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("relative_path", str3);
                uriInsert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
                string = uriInsert.toString();
                RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
                fileOutputStream = new FileOutputStream(FilmApp.m402().getContentResolver().openFileDescriptor(uriInsert, "rw").getFileDescriptor());
                channel = randomAccessFile.getChannel();
                channel2 = fileOutputStream.getChannel();
                size = channel.size();
            } catch (Exception e2) {
                e = e2;
            }
            try {
                long size2 = channel.size();
                int i = 0;
                while (j < size2) {
                    long j2 = i;
                    int i2 = i;
                    long jTransferTo = channel.transferTo(j2, size2, channel2);
                    if (jTransferTo > 0) {
                        size2 -= jTransferTo;
                        i = (int) (j2 + jTransferTo);
                    } else {
                        i = i2;
                    }
                    j = 0;
                }
                channel.close();
                channel2.close();
                fileOutputStream.close();
                contentValues.clear();
                contentValues.put("is_pending", (Integer) 0);
                contentResolver.update(uriInsert, contentValues, null, null);
                j = size;
            } catch (Exception e3) {
                e = e3;
                j = size;
                e.printStackTrace();
                C4638.m14101("WME", "Exception: " + e.toString());
                C4638.m14101("WME", "time: " + (System.currentTimeMillis() - jCurrentTimeMillis) + " fileSize: " + ((j / 1024.0f) / 1024.0f));
                return string;
            }
            C4638.m14101("WME", "time: " + (System.currentTimeMillis() - jCurrentTimeMillis) + " fileSize: " + ((j / 1024.0f) / 1024.0f));
        }
        return string;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m10792(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (FilmApp.m402().getContentResolver().delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[]{str}) != 0) {
                    return true;
                }
                File file = new File(str);
                if (file.exists()) {
                    return file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                File file2 = new File(str);
                if (file2.exists()) {
                    return file2.delete();
                }
            }
        }
        return false;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m10793(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return true;
        }
        boolean zM10793 = true;
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                zM10793 = m10795(file2.getAbsolutePath());
                if (!zM10793) {
                    break;
                }
            } else {
                zM10793 = m10793(file2.getAbsolutePath());
                if (!zM10793) {
                    break;
                }
            }
        }
        return zM10793 && file.delete();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m10794(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    file2.delete();
                } else {
                    m10794(file2);
                }
            }
        }
        file.delete();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static boolean m10795(String str) {
        if (r1.m8138(str)) {
            return false;
        }
        return m10792(str);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m10796() {
        return C2618.m9569("content_produce", "1");
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String m10797() {
        return C2618.m9569("content_scence", "1");
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String m10798() {
        return C2618.m9569("content_shot", "1");
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static boolean m10799() {
        return C2618.m9565("content_state", false);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static int m10800() {
        return C2618.m9566("content_take", 1);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String m10801(File file) throws NoSuchAlgorithmException, IOException {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int i = fileInputStream.read(bArr, 0, 1024);
                if (i == -1) {
                    fileInputStream.close();
                    return m10789(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, i);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static boolean m10802(String str) {
        if (!r1.m8143(str)) {
            return false;
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = FilmApp.m402().getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r");
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                Utils.close(assetFileDescriptorOpenAssetFileDescriptor);
                return false;
            }
            Utils.close(assetFileDescriptorOpenAssetFileDescriptor);
            Utils.close(assetFileDescriptorOpenAssetFileDescriptor);
            return true;
        } catch (FileNotFoundException unused) {
            Utils.close(null);
            return false;
        } catch (Throwable th) {
            Utils.close(null);
            throw th;
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static void m10803(String str) {
        new File(str).mkdirs();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static void m10804(String str) {
        C2618.m9573("content_produce", str);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static void m10805(String str) {
        C2618.m9573("content_scence", str);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static void m10806(String str) {
        C2618.m9573("content_shot", str);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static void m10807(boolean z) {
        C2618.m9570("content_state", z);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static void m10808(int i) {
        C2618.m9571("content_take", i);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0048 -> B:51:0x004b). Please report as a decompilation issue!!! */
    /* renamed from: ކ, reason: contains not printable characters */
    public static void m10809(byte[] bArr, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    try {
                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int i = byteArrayInputStream2.read(bArr2);
                                if (i != -1) {
                                    fileOutputStream.write(bArr2, 0, i);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            byteArrayInputStream2.close();
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            e = e3;
                            byteArrayInputStream = byteArrayInputStream2;
                            e.printStackTrace();
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            byteArrayInputStream = byteArrayInputStream2;
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileOutputStream == null) {
                                throw th;
                            }
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e7) {
                    e = e7;
                }
            } catch (Exception e8) {
                e = e8;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        }
    }
}
