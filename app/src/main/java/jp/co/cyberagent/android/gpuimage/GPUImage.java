package jp.co.cyberagent.android.gpuimage;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.view.WindowManager;
import androidx.appcompat.widget.ActivityChooserModel;
import defpackage.C4327;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* loaded from: classes2.dex */
public class GPUImage {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f7751;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C2130 f7752;

    /* renamed from: ԩ, reason: contains not printable characters */
    public GLSurfaceView f7753;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C4327 f7754;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Bitmap f7755;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public ScaleType f7756 = ScaleType.CENTER_CROP;

    public enum ScaleType {
        CENTER_INSIDE,
        CENTER_CROP
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImage$Ϳ, reason: contains not printable characters */
    public class AsyncTaskC2126 extends AbstractAsyncTaskC2127 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final File f7760;

        public AsyncTaskC2126(GPUImage gPUImage, File file) {
            super(gPUImage);
            this.f7760 = file;
        }

        @Override // jp.co.cyberagent.android.gpuimage.GPUImage.AbstractAsyncTaskC2127
        /* renamed from: Ԩ, reason: contains not printable characters */
        public Bitmap mo7135(BitmapFactory.Options options) {
            return BitmapFactory.decodeFile(this.f7760.getAbsolutePath(), options);
        }

        @Override // jp.co.cyberagent.android.gpuimage.GPUImage.AbstractAsyncTaskC2127
        /* renamed from: Ԫ, reason: contains not printable characters */
        public int mo7136() throws IOException {
            int attributeInt = new ExifInterface(this.f7760.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return MPEGConst.SEQUENCE_ERROR_CODE;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImage$Ԩ, reason: contains not printable characters */
    public abstract class AbstractAsyncTaskC2127 extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final GPUImage f7762;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f7763;

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f7764;

        public AbstractAsyncTaskC2127(GPUImage gPUImage) {
            this.f7762 = gPUImage;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean m7137(boolean z, boolean z2) {
            return GPUImage.this.f7756 == ScaleType.CENTER_CROP ? z && z2 : z || z2;
        }

        /* renamed from: Ԩ */
        public abstract Bitmap mo7135(BitmapFactory.Options options);

        @Override // android.os.AsyncTask
        /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            if (GPUImage.this.f7752 != null && GPUImage.this.f7752.m7162() == 0) {
                try {
                    synchronized (GPUImage.this.f7752.f7784) {
                        GPUImage.this.f7752.f7784.wait(3000L);
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            this.f7763 = GPUImage.this.m7125();
            this.f7764 = GPUImage.this.m7124();
            return m7140();
        }

        /* renamed from: Ԫ */
        public abstract int mo7136() throws IOException;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int[] m7139(int i, int i2) {
            float f;
            float f2;
            float f3 = i;
            float f4 = f3 / this.f7763;
            float f5 = i2;
            float f6 = f5 / this.f7764;
            if (GPUImage.this.f7756 != ScaleType.CENTER_CROP ? f4 < f6 : f4 > f6) {
                f2 = this.f7764;
                f = (f2 / f5) * f3;
            } else {
                float f7 = this.f7763;
                float f8 = (f7 / f3) * f5;
                f = f7;
                f2 = f8;
            }
            return new int[]{Math.round(f), Math.round(f2)};
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Bitmap m7140() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            mo7135(options);
            int i = 1;
            while (true) {
                if (!m7137(options.outWidth / i > this.f7763, options.outHeight / i > this.f7764)) {
                    break;
                }
                i++;
            }
            int i2 = i - 1;
            if (i2 < 1) {
                i2 = 1;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i2;
            options2.inPreferredConfig = Bitmap.Config.RGB_565;
            options2.inPurgeable = true;
            options2.inTempStorage = new byte[32768];
            Bitmap bitmapMo7135 = mo7135(options2);
            if (bitmapMo7135 == null) {
                return null;
            }
            return m7143(m7142(bitmapMo7135));
        }

        @Override // android.os.AsyncTask
        /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            this.f7762.m7123();
            this.f7762.m7129(bitmap);
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final Bitmap m7142(Bitmap bitmap) {
            Bitmap bitmapCreateBitmap;
            IOException e2;
            int iMo7136;
            if (bitmap == null) {
                return null;
            }
            try {
                iMo7136 = mo7136();
            } catch (IOException e3) {
                bitmapCreateBitmap = bitmap;
                e2 = e3;
            }
            if (iMo7136 == 0) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(iMo7136);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            try {
                bitmap.recycle();
            } catch (IOException e4) {
                e2 = e4;
                e2.printStackTrace();
                return bitmapCreateBitmap;
            }
            return bitmapCreateBitmap;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final Bitmap m7143(Bitmap bitmap) {
            int[] iArrM7139 = m7139(bitmap.getWidth(), bitmap.getHeight());
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, iArrM7139[0], iArrM7139[1], true);
            if (bitmapCreateScaledBitmap != bitmap) {
                bitmap.recycle();
                System.gc();
                bitmap = bitmapCreateScaledBitmap;
            }
            if (GPUImage.this.f7756 != ScaleType.CENTER_CROP) {
                return bitmap;
            }
            int i = iArrM7139[0];
            int i2 = i - this.f7763;
            int i3 = iArrM7139[1];
            int i4 = i3 - this.f7764;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i2 / 2, i4 / 2, i - i2, i3 - i4);
            if (bitmapCreateBitmap == bitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return bitmapCreateBitmap;
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImage$Ԫ, reason: contains not printable characters */
    public class AsyncTaskC2128 extends AbstractAsyncTaskC2127 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Uri f7766;

        public AsyncTaskC2128(GPUImage gPUImage, Uri uri) {
            super(gPUImage);
            this.f7766 = uri;
        }

        @Override // jp.co.cyberagent.android.gpuimage.GPUImage.AbstractAsyncTaskC2127
        /* renamed from: Ԩ */
        public Bitmap mo7135(BitmapFactory.Options options) {
            try {
                return BitmapFactory.decodeStream((this.f7766.getScheme().startsWith("http") || this.f7766.getScheme().startsWith("https")) ? new URL(this.f7766.toString()).openStream() : GPUImage.this.f7751.getContentResolver().openInputStream(this.f7766), null, options);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // jp.co.cyberagent.android.gpuimage.GPUImage.AbstractAsyncTaskC2127
        /* renamed from: Ԫ */
        public int mo7136() throws IOException {
            Cursor cursorQuery = GPUImage.this.f7751.getContentResolver().query(this.f7766, new String[]{"orientation"}, null, null, null);
            if (cursorQuery == null || cursorQuery.getCount() != 1) {
                return 0;
            }
            cursorQuery.moveToFirst();
            int i = cursorQuery.getInt(0);
            cursorQuery.close();
            return i;
        }
    }

    public GPUImage(Context context) {
        if (!m7134(context)) {
            throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
        }
        this.f7751 = context;
        this.f7754 = new C4327();
        this.f7752 = new C2130(this.f7754);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m7123() {
        this.f7752.m7160();
        this.f7755 = null;
        m7126();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int m7124() {
        C2130 c2130 = this.f7752;
        if (c2130 != null && c2130.m7161() != 0) {
            return this.f7752.m7161();
        }
        Bitmap bitmap = this.f7755;
        return bitmap != null ? bitmap.getHeight() : ((WindowManager) this.f7751.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int m7125() {
        C2130 c2130 = this.f7752;
        if (c2130 != null && c2130.m7162() != 0) {
            return this.f7752.m7162();
        }
        Bitmap bitmap = this.f7755;
        return bitmap != null ? bitmap.getWidth() : ((WindowManager) this.f7751.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m7126() {
        GLSurfaceView gLSurfaceView = this.f7753;
        if (gLSurfaceView != null) {
            gLSurfaceView.requestRender();
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m7127(C4327 c4327) {
        this.f7754 = c4327;
        this.f7752.m7165(c4327);
        m7126();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m7128(GLSurfaceView gLSurfaceView) {
        this.f7753 = gLSurfaceView;
        gLSurfaceView.setEGLContextClientVersion(2);
        this.f7753.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.f7753.getHolder().setFormat(1);
        this.f7753.setRenderer(this.f7752);
        this.f7753.setRenderMode(0);
        this.f7753.requestRender();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m7129(Bitmap bitmap) {
        this.f7755 = bitmap;
        this.f7752.m7166(bitmap, false);
        m7126();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m7130(Uri uri) {
        new AsyncTaskC2128(this, uri).execute(new Void[0]);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m7131(File file) {
        new AsyncTaskC2126(this, file).execute(new Void[0]);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m7132(Rotation rotation) {
        this.f7752.m7167(rotation);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m7133(ScaleType scaleType) {
        this.f7756 = scaleType;
        this.f7752.m7169(scaleType);
        this.f7752.m7160();
        this.f7755 = null;
        m7126();
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final boolean m7134(Context context) {
        return ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }
}
