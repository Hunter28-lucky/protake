package com.mob.tools.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.opengl.GLES10;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.mob.commons.n;
import com.mob.tools.MobLog;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class BitmapHelper implements PublicMemberKeeper {
    private static int a;
    private static int b;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int iMax = Math.max(iArr[0], 2048);
        a = iMax;
        b = iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(HttpConnection httpConnection, String str) throws Throwable {
        String strSubstring;
        List<String> list;
        int iLastIndexOf;
        List<String> list2;
        Map<String, List<String>> headerFields = httpConnection.getHeaderFields();
        if (headerFields == null || (list2 = headerFields.get(HttpHeaders.HEAD_KEY_CONTENT_DISPOSITION)) == null || list2.size() <= 0) {
            strSubstring = null;
        } else {
            strSubstring = null;
            for (String str2 : list2.get(0).split(";")) {
                if (str2.trim().startsWith("filename")) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length >= 2) {
                        strSubstring = strArrSplit[1];
                        if (!TextUtils.isEmpty(strSubstring) && strSubstring.startsWith("\"") && strSubstring.endsWith("\"")) {
                            strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                        }
                    }
                }
            }
        }
        if (strSubstring != null) {
            return strSubstring;
        }
        String strMD5 = Data.MD5(str);
        if (headerFields == null || (list = headerFields.get(HttpHeaders.HEAD_KEY_CONTENT_TYPE)) == null || list.size() <= 0) {
            return strMD5;
        }
        String str3 = list.get(0);
        String strTrim = str3 == null ? "" : str3.trim();
        if (strTrim.startsWith("image/")) {
            String strSubstring2 = strTrim.substring(6);
            StringBuilder sb = new StringBuilder();
            sb.append(strMD5);
            sb.append(".");
            if ("jpeg".equals(strSubstring2)) {
                strSubstring2 = "jpg";
            }
            sb.append(strSubstring2);
            return sb.toString();
        }
        int iLastIndexOf2 = str.lastIndexOf(47);
        String strSubstring3 = iLastIndexOf2 > 0 ? str.substring(iLastIndexOf2 + 1) : null;
        if (strSubstring3 == null || strSubstring3.length() <= 0 || (iLastIndexOf = strSubstring3.lastIndexOf(46)) <= 0 || strSubstring3.length() - iLastIndexOf >= 10) {
            return strMD5;
        }
        return strMD5 + strSubstring3.substring(iLastIndexOf);
    }

    public static Bitmap blur(Bitmap bitmap, int i, int i2) {
        float f = i2;
        int i3 = (int) ((i / f) + 0.5f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) ((bitmap.getWidth() / f) + 0.5f), (int) ((bitmap.getHeight() / f) + 0.5f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f2 = 1.0f / f;
        canvas.scale(f2, f2);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        a(bitmapCreateBitmap, i3, true);
        return bitmapCreateBitmap;
    }

    public static Bitmap captureView(View view, int i, int i2) throws Throwable {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i) {
        return compressByQuality(bitmap, i, false);
    }

    public static Bitmap cropBitmap(Bitmap bitmap, int i, int i2, int i3, int i4) throws Throwable {
        int width = (bitmap.getWidth() - i) - i3;
        int height = (bitmap.getHeight() - i2) - i4;
        if (width == bitmap.getWidth() && height == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, -i, -i2, new Paint());
        return bitmapCreateBitmap;
    }

    public static String downloadBitmap(Context context, final String str) throws Throwable {
        final String cachePath = ResHelper.getCachePath(context, "images");
        File file = new File(cachePath, Data.MD5(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        final HashMap map = new HashMap();
        new NetworkHelper().rawGet(str, new HttpResponseCallback() { // from class: com.mob.tools.utils.BitmapHelper.1
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                int responseCode = httpConnection.getResponseCode();
                if (responseCode != 200) {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(line);
                    }
                    bufferedReader.close();
                    HashMap map2 = new HashMap();
                    map2.put(n.b("005h(cgcgdbcg"), sb.toString());
                    map2.put(n.b("006IefKc)ce c>cbef"), Integer.valueOf(responseCode));
                    throw new Throwable(HashonHelper.fromHashMap(map2));
                }
                String strB = BitmapHelper.b(httpConnection, str);
                File file2 = new File(cachePath, strB);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (file2.exists()) {
                    file2.delete();
                }
                try {
                    Bitmap bitmap = BitmapHelper.getBitmap(new FilterInputStream(httpConnection.getInputStream()) { // from class: com.mob.tools.utils.BitmapHelper.1.1
                        @Override // java.io.FilterInputStream, java.io.InputStream
                        public long skip(long j) throws IOException {
                            long j2 = 0;
                            while (j2 < j) {
                                long jSkip = ((FilterInputStream) this).in.skip(j - j2);
                                if (jSkip == 0) {
                                    break;
                                }
                                j2 += jSkip;
                            }
                            return j2;
                        }
                    }, 1);
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    if (strB.toLowerCase().endsWith(".gif") || strB.toLowerCase().endsWith(".png")) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    } else {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    map.put("bitmap", file2.getAbsolutePath());
                } catch (Throwable th) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    throw th;
                }
            }
        }, (NetworkHelper.NetworkTimeOut) null);
        return (String) map.get("bitmap");
    }

    public static int[] fixRect(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[2];
        int i = iArr[0];
        int i2 = iArr[1];
        float f = i / i2;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        if (f > i3 / i4) {
            iArr3[0] = i3;
            iArr3[1] = (int) (((i2 * iArr2[0]) / iArr[0]) + 0.5f);
        } else {
            iArr3[1] = i4;
            iArr3[0] = (int) (((i * iArr2[1]) / iArr[1]) + 0.5f);
        }
        return iArr3;
    }

    public static int[] fixRect_2(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[2];
        int i = iArr[0];
        int i2 = iArr[1];
        float f = i / i2;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        if (f > i3 / i4) {
            iArr3[1] = i4;
            iArr3[0] = (int) (((i * iArr2[1]) / iArr[1]) + 0.5f);
        } else {
            iArr3[0] = i3;
            iArr3[1] = (int) (((i2 * iArr2[0]) / iArr[0]) + 0.5f);
        }
        return iArr3;
    }

    public static Bitmap getBitmap(String str, int i) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getBitmap(new File(str), i);
    }

    public static Bitmap getBitmapByCompressQuality(String str, int i, int i2, int i3, long j) throws Throwable {
        Bitmap bitmapByCompressSize = getBitmapByCompressSize(str, i, i2);
        if (i3 < 10 || i3 > 100) {
            i3 = 100;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat bmpFormat = getBmpFormat(str);
        bitmapByCompressSize.compress(bmpFormat, i3, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (j < 10240) {
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused) {
            }
            return bitmapDecodeByteArray;
        }
        while (byteArray.length > j && i3 >= 11) {
            byteArrayOutputStream.reset();
            i3 -= 6;
            bitmapByCompressSize.compress(bmpFormat, i3, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        if (i3 != 100) {
            bitmapByCompressSize = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        try {
            byteArrayOutputStream.close();
        } catch (Throwable unused2) {
        }
        return bitmapByCompressSize;
    }

    public static Bitmap getBitmapByCompressSize(String str, int i, int i2) throws Throwable {
        int i3;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i <= 1 || i2 <= 1) {
            i3 = 1;
        } else {
            float f = 1.0f;
            float fMin = (Math.min(i4, i5) * 1.0f) / Math.min(i, i2);
            float fMax = (Math.max(i4, i5) * 1.0f) / Math.max(i, i2);
            float f2 = i4 / i5;
            if (f2 <= 2.0f && f2 >= 0.5d) {
                float fMin2 = Math.min(fMin, fMax);
                while (true) {
                    float f3 = f * 2.0f;
                    if (f3 > fMin2) {
                        break;
                    }
                    f = f3;
                }
            } else {
                while (true) {
                    float f4 = f * 2.0f;
                    if (f4 > fMin) {
                        break;
                    }
                    f = f4;
                }
            }
            i3 = (int) f;
        }
        int i6 = i3 >= 1 ? i3 : 1;
        while (true) {
            if (i4 / i6 <= a && i5 / i6 <= b) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inPreferredConfig = Bitmap.Config.RGB_565;
                options2.inSampleSize = i6;
                return BitmapFactory.decodeFile(str, options2);
            }
            i6++;
        }
    }

    public static Bitmap.CompressFormat getBmpFormat(byte[] bArr) {
        String strA = a(bArr);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        return strA != null ? (strA.endsWith("png") || strA.endsWith("gif")) ? Bitmap.CompressFormat.PNG : compressFormat : compressFormat;
    }

    public static String getMime(String str) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[8];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return a(bArr);
        } catch (Exception e2) {
            MobLog.getInstance().w(e2);
            return "";
        }
    }

    public static boolean isBlackBitmap(Bitmap bitmap) throws Throwable {
        if (bitmap == null || bitmap.isRecycled()) {
            return true;
        }
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= width) {
                break;
            }
            if ((iArr[i] & ViewCompat.MEASURED_SIZE_MASK) != 0) {
                z = true;
                break;
            }
            i++;
        }
        return !z;
    }

    public static int mixAlpha(int i, int i2) {
        int i3 = i >>> 24;
        int i4 = 255 - i3;
        return ((((((i & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >>> 16) * i3) + (((16711680 & i2) >>> 16) * i4)) / 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((((((i & 65280) >>> 8) * i3) + (((65280 & i2) >>> 8) * i4)) / 255) << 8) | (((i3 * (i & 255)) + (i4 * (i2 & 255))) / 255);
    }

    public static Bitmap roundBitmap(Bitmap bitmap, int i, int i2, float f, float f2, float f3, float f4) throws Throwable {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        Bitmap bitmapCreateBitmap = (width == i && height == i2) ? Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect2 = new Rect(0, 0, i, i2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float[] fArr = {f, f, f2, f2, f3, f3, f4, f4};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(0.0f, 0.0f, 0.0f, 0.0f), fArr));
        shapeDrawable.setBounds(rect2);
        shapeDrawable.draw(canvas);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return bitmapCreateBitmap;
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, FileUtils.getFileByPath(str), compressFormat, false);
    }

    public static String saveBitmap(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) throws Throwable {
        File file = new File(ResHelper.getCachePath(context, "images"), String.valueOf(System.currentTimeMillis()) + (compressFormat == Bitmap.CompressFormat.PNG ? ".png" : ".jpg"));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(compressFormat, i, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file.getAbsolutePath();
    }

    public static String saveBitmapByCompress(String str, int i, int i2, int i3) throws Throwable {
        Bitmap bitmapByCompressSize = getBitmapByCompressSize(str, i, i2);
        if (i3 > 100) {
            i3 = 100;
        } else if (i3 < 10) {
            i3 = 10;
        }
        Bitmap.CompressFormat bmpFormat = getBmpFormat(str);
        String str2 = bmpFormat == Bitmap.CompressFormat.PNG ? ".png" : ".jpg";
        File file = new File(new File(str).getParent(), String.valueOf(System.currentTimeMillis()) + str2);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmapByCompressSize.compress(bmpFormat, i3, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file.getAbsolutePath();
    }

    public static String saveViewToImage(View view) throws Throwable {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        return saveViewToImage(view, width, height);
    }

    public static Bitmap scaleBitmapByHeight(Context context, int i, int i2) throws Throwable {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i);
        boolean z = i2 != bitmapDecodeResource.getHeight();
        Bitmap bitmapScaleBitmapByHeight = scaleBitmapByHeight(bitmapDecodeResource, i2);
        if (z) {
            bitmapDecodeResource.recycle();
        }
        return bitmapScaleBitmapByHeight;
    }

    private static Bitmap a(Bitmap bitmap, int i, boolean z) {
        int[] iArr;
        int i2 = i;
        Bitmap bitmapCopy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i2 < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        bitmapCopy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i6, 3);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap2 = bitmapCopy;
            int i15 = height;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = -i2;
            int i25 = 0;
            while (i24 <= i2) {
                int i26 = i5;
                int[] iArr9 = iArr6;
                int i27 = iArr2[i13 + Math.min(i4, Math.max(i24, 0))];
                int[] iArr10 = iArr8[i24 + i2];
                iArr10[0] = (i27 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                iArr10[1] = (i27 & 65280) >> 8;
                iArr10[2] = i27 & 255;
                int iAbs = i11 - Math.abs(i24);
                int i28 = iArr10[0];
                i25 += i28 * iAbs;
                int i29 = iArr10[1];
                i16 += i29 * iAbs;
                int i30 = iArr10[2];
                i17 += iAbs * i30;
                if (i24 > 0) {
                    i21 += i28;
                    i22 += i29;
                    i23 += i30;
                } else {
                    i18 += i28;
                    i19 += i29;
                    i20 += i30;
                }
                i24++;
                i5 = i26;
                iArr6 = iArr9;
            }
            int i31 = i5;
            int[] iArr11 = iArr6;
            int i32 = i2;
            int i33 = i25;
            int i34 = 0;
            while (i34 < width) {
                iArr3[i13] = iArr7[i33];
                iArr4[i13] = iArr7[i16];
                iArr5[i13] = iArr7[i17];
                int i35 = i33 - i18;
                int i36 = i16 - i19;
                int i37 = i17 - i20;
                int[] iArr12 = iArr8[((i32 - i2) + i6) % i6];
                int i38 = i18 - iArr12[0];
                int i39 = i19 - iArr12[1];
                int i40 = i20 - iArr12[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr11[i34] = Math.min(i34 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i41 = iArr2[i14 + iArr11[i34]];
                int i42 = (i41 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                iArr12[0] = i42;
                int i43 = (i41 & 65280) >> 8;
                iArr12[1] = i43;
                int i44 = i41 & 255;
                iArr12[2] = i44;
                int i45 = i21 + i42;
                int i46 = i22 + i43;
                int i47 = i23 + i44;
                i33 = i35 + i45;
                i16 = i36 + i46;
                i17 = i37 + i47;
                i32 = (i32 + 1) % i6;
                int[] iArr13 = iArr8[i32 % i6];
                int i48 = iArr13[0];
                i18 = i38 + i48;
                int i49 = iArr13[1];
                i19 = i39 + i49;
                int i50 = iArr13[2];
                i20 = i40 + i50;
                i21 = i45 - i48;
                i22 = i46 - i49;
                i23 = i47 - i50;
                i13++;
                i34++;
                iArr7 = iArr;
            }
            i14 += width;
            i12++;
            bitmapCopy = bitmap2;
            height = i15;
            i5 = i31;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = bitmapCopy;
        int i51 = i5;
        int[] iArr14 = iArr6;
        int i52 = height;
        int[] iArr15 = iArr7;
        int i53 = 0;
        while (i53 < width) {
            int i54 = -i2;
            int i55 = i6;
            int[] iArr16 = iArr2;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = i54;
            int i64 = i54 * width;
            int i65 = 0;
            int i66 = 0;
            while (i63 <= i2) {
                int i67 = width;
                int iMax = Math.max(0, i64) + i53;
                int[] iArr17 = iArr8[i63 + i2];
                iArr17[0] = iArr3[iMax];
                iArr17[1] = iArr4[iMax];
                iArr17[2] = iArr5[iMax];
                int iAbs2 = i11 - Math.abs(i63);
                i65 += iArr3[iMax] * iAbs2;
                i66 += iArr4[iMax] * iAbs2;
                i56 += iArr5[iMax] * iAbs2;
                if (i63 > 0) {
                    i60 += iArr17[0];
                    i61 += iArr17[1];
                    i62 += iArr17[2];
                } else {
                    i57 += iArr17[0];
                    i58 += iArr17[1];
                    i59 += iArr17[2];
                }
                int i68 = i51;
                if (i63 < i68) {
                    i64 += i67;
                }
                i63++;
                i51 = i68;
                width = i67;
            }
            int i69 = width;
            int i70 = i51;
            int i71 = i2;
            int i72 = i53;
            int i73 = i66;
            int i74 = i52;
            int i75 = i65;
            int i76 = 0;
            while (i76 < i74) {
                iArr16[i72] = (iArr16[i72] & ViewCompat.MEASURED_STATE_MASK) | (iArr15[i75] << 16) | (iArr15[i73] << 8) | iArr15[i56];
                int i77 = i75 - i57;
                int i78 = i73 - i58;
                int i79 = i56 - i59;
                int[] iArr18 = iArr8[((i71 - i2) + i55) % i55];
                int i80 = i57 - iArr18[0];
                int i81 = i58 - iArr18[1];
                int i82 = i59 - iArr18[2];
                if (i53 == 0) {
                    iArr14[i76] = Math.min(i76 + i11, i70) * i69;
                }
                int i83 = iArr14[i76] + i53;
                int i84 = iArr3[i83];
                iArr18[0] = i84;
                int i85 = iArr4[i83];
                iArr18[1] = i85;
                int i86 = iArr5[i83];
                iArr18[2] = i86;
                int i87 = i60 + i84;
                int i88 = i61 + i85;
                int i89 = i62 + i86;
                i75 = i77 + i87;
                i73 = i78 + i88;
                i56 = i79 + i89;
                i71 = (i71 + 1) % i55;
                int[] iArr19 = iArr8[i71];
                int i90 = iArr19[0];
                i57 = i80 + i90;
                int i91 = iArr19[1];
                i58 = i81 + i91;
                int i92 = iArr19[2];
                i59 = i82 + i92;
                i60 = i87 - i90;
                i61 = i88 - i91;
                i62 = i89 - i92;
                i72 += i69;
                i76++;
                i2 = i;
            }
            i53++;
            i2 = i;
            i51 = i70;
            i52 = i74;
            i6 = i55;
            iArr2 = iArr16;
            width = i69;
        }
        int i93 = width;
        bitmap3.setPixels(iArr2, 0, i93, 0, 0, i93, i52);
        return bitmap3;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i, boolean z) {
        if (a(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z) {
        boolean zCompress;
        if (a(bitmap) || !FileUtils.createFileByDeleteOldFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                zCompress = bitmap.compress(compressFormat, 100, bufferedOutputStream2);
                if (z) {
                    try {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            MobLog.getInstance().d(th);
                            FileUtils.closeIO(bufferedOutputStream);
                            return zCompress;
                        } catch (Throwable th2) {
                            FileUtils.closeIO(bufferedOutputStream);
                            throw th2;
                        }
                    }
                }
                FileUtils.closeIO(bufferedOutputStream2);
            } catch (Throwable th3) {
                th = th3;
                zCompress = false;
            }
        } catch (Throwable th4) {
            th = th4;
            zCompress = false;
        }
        return zCompress;
    }

    public static Bitmap getBitmap(File file, int i) throws Throwable {
        if (file == null || !file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        Bitmap bitmap = getBitmap(fileInputStream, i);
        fileInputStream.close();
        return bitmap;
    }

    public static String saveViewToImage(View view, int i, int i2) throws Throwable {
        Bitmap bitmapCaptureView = captureView(view, i, i2);
        if (bitmapCaptureView == null || bitmapCaptureView.isRecycled()) {
            return null;
        }
        File file = new File(ResHelper.getCachePath(view.getContext(), "screenshot"), String.valueOf(System.currentTimeMillis()) + ".jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmapCaptureView.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file.getAbsolutePath();
    }

    public static Bitmap.CompressFormat getBmpFormat(String str) throws IOException {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("png") && !lowerCase.endsWith("gif")) {
            if (!lowerCase.endsWith("jpg") && !lowerCase.endsWith("jpeg") && !lowerCase.endsWith("bmp") && !lowerCase.endsWith("tif")) {
                String mime = getMime(str);
                if (!mime.endsWith("png") && !mime.endsWith("gif")) {
                    return Bitmap.CompressFormat.JPEG;
                }
                return Bitmap.CompressFormat.PNG;
            }
            return Bitmap.CompressFormat.JPEG;
        }
        return Bitmap.CompressFormat.PNG;
    }

    public static Bitmap scaleBitmapByHeight(Bitmap bitmap, int i) throws Throwable {
        return Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * i) / bitmap.getHeight(), i, true);
    }

    public static Bitmap getBitmap(InputStream inputStream, int i) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j) {
        return compressByQuality(bitmap, j, false);
    }

    public static String saveBitmap(Context context, Bitmap bitmap) throws Throwable {
        return saveBitmap(context, bitmap, Bitmap.CompressFormat.JPEG, 80);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j, boolean z) {
        byte[] byteArray;
        if (a(bitmap) || j <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.size() <= j) {
            byteArray = byteArrayOutputStream.toByteArray();
        } else {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= j) {
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                int i2 = 0;
                int i3 = 0;
                while (i2 < i) {
                    i3 = (i2 + i) / 2;
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                    long size = byteArrayOutputStream.size();
                    if (size == j) {
                        break;
                    }
                    if (size > j) {
                        i = i3 - 1;
                    } else {
                        i2 = i3 + 1;
                    }
                }
                if (i == i3 - 1) {
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                }
                byteArray = byteArrayOutputStream.toByteArray();
            }
        }
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap getBitmap(String str) throws Throwable {
        return getBitmap(str, 1);
    }

    public static Bitmap getBitmap(Context context, String str) throws Throwable {
        return getBitmap(downloadBitmap(context, str));
    }

    private static String a(byte[] bArr) {
        byte[] bArr2 = {-1, -40, -1, ExifInterface.MARKER_APP1};
        if (a(bArr, new byte[]{-1, -40, -1, -32}) || a(bArr, bArr2)) {
            return "jpg";
        }
        if (a(bArr, new byte[]{-119, 80, 78, 71})) {
            return "png";
        }
        if (a(bArr, "GIF".getBytes())) {
            return "gif";
        }
        if (a(bArr, "BM".getBytes())) {
            return "bmp";
        }
        return (a(bArr, new byte[]{73, 73, ExifInterface.START_CODE}) || a(bArr, new byte[]{77, 77, ExifInterface.START_CODE})) ? "tif" : "";
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }
}
