package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.mob.tools.MobLog;
import com.mob.tools.utils.BitmapHelper;

/* loaded from: classes2.dex */
public class ScaledImageView extends ImageView implements View.OnTouchListener {
    private static final int DRAG_1 = 1;
    private static final int DRAG_2 = 2;
    private static final int NONE = 0;
    private static final int ZOOM = 3;
    private Bitmap bitmap;
    private float distSquare;
    private float[] downPoint;
    private int dragScrollMinDistSquare;
    private OnMatrixChangedListener listener;
    private Matrix matrix;
    private int mode;
    private Matrix savedMatrix;

    public interface OnMatrixChangedListener {
        void onMactrixChage(Matrix matrix);
    }

    public ScaledImageView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dragScrollMinDistSquare = scaledTouchSlop * scaledTouchSlop;
        setOnTouchListener(this);
    }

    public Bitmap getCropedBitmap(Rect rect) {
        try {
            Bitmap bitmapCaptureView = BitmapHelper.captureView(this, getWidth(), getHeight());
            if (bitmapCaptureView == null) {
                MobLog.getInstance().w("ivPhoto.getDrawingCache() returns null");
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCaptureView, rect.left, rect.top, rect.width(), rect.height());
            bitmapCaptureView.recycle();
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                Matrix matrix = new Matrix();
                this.matrix = matrix;
                matrix.set(getImageMatrix());
                Matrix matrix2 = new Matrix();
                this.savedMatrix = matrix2;
                matrix2.set(this.matrix);
                this.downPoint = new float[]{motionEvent.getX(0), motionEvent.getY(0)};
                this.mode = 1;
            } else if (action == 1) {
                OnMatrixChangedListener onMatrixChangedListener = this.listener;
                if (onMatrixChangedListener != null) {
                    onMatrixChangedListener.onMactrixChage(this.matrix);
                }
                float x = motionEvent.getX(0) - this.downPoint[0];
                float y = motionEvent.getY(0) - this.downPoint[1];
                if (this.mode == 1 && (x * x) + (y * y) <= this.dragScrollMinDistSquare) {
                    performClick();
                }
                this.mode = 0;
            } else if (action == 2) {
                int i = this.mode;
                if (i == 1) {
                    float[] fArr = {motionEvent.getX(0), motionEvent.getY(0)};
                    this.matrix.set(this.savedMatrix);
                    Matrix matrix3 = this.matrix;
                    float f = fArr[0];
                    float[] fArr2 = this.downPoint;
                    matrix3.postTranslate(f - fArr2[0], fArr[1] - fArr2[1]);
                } else if (i == 2) {
                    float[] fArr3 = {motionEvent.getX(1), motionEvent.getY(1)};
                    this.matrix.set(this.savedMatrix);
                    Matrix matrix4 = this.matrix;
                    float f2 = fArr3[0];
                    float[] fArr4 = this.downPoint;
                    matrix4.postTranslate(f2 - fArr4[0], fArr3[1] - fArr4[1]);
                } else if (i == 3) {
                    float[] fArr5 = {motionEvent.getX(0), motionEvent.getY(0)};
                    float y2 = motionEvent.getY(1);
                    float[] fArr6 = {motionEvent.getX(1), y2};
                    float f3 = fArr5[0] - fArr6[0];
                    float f4 = fArr5[1] - y2;
                    this.matrix.set(this.savedMatrix);
                    float fSqrt = (float) Math.sqrt(((f3 * f3) + (f4 * f4)) / this.distSquare);
                    this.matrix.postScale(fSqrt, fSqrt, (fArr5[0] + fArr6[0]) / 2.0f, (fArr5[1] + fArr6[1]) / 2.0f);
                }
            } else if (action == 5) {
                float[] fArr7 = {motionEvent.getX(0), motionEvent.getY(0)};
                float y3 = motionEvent.getY(1);
                float f5 = fArr7[0] - new float[]{motionEvent.getX(1), y3}[0];
                float f6 = fArr7[1] - y3;
                this.distSquare = (f5 * f5) + (f6 * f6);
                this.mode = 3;
            } else if (action == 6) {
                this.downPoint = new float[]{motionEvent.getX(1), motionEvent.getY(1)};
                this.savedMatrix.set(this.matrix);
                this.mode = 2;
            } else if (action == 261) {
                float[] fArr8 = {motionEvent.getX(0), motionEvent.getY(0)};
                float y4 = motionEvent.getY(1);
                float f7 = fArr8[0] - new float[]{motionEvent.getX(1), y4}[0];
                float f8 = fArr8[1] - y4;
                this.distSquare = (f7 * f7) + (f8 * f8);
                this.mode = 3;
            } else {
                if (action != 262) {
                    return false;
                }
                this.downPoint = new float[]{motionEvent.getX(0), motionEvent.getY(0)};
                this.savedMatrix.set(this.matrix);
                this.mode = 1;
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return true;
    }

    public void rotateLeft() {
        try {
            Matrix matrix = new Matrix();
            this.matrix = matrix;
            float[] fArr = {0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            matrix.setValues(fArr);
            Bitmap bitmap = this.bitmap;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = bitmapCreateBitmap;
            }
            setImageBitmap(this.bitmap);
            Matrix matrix2 = new Matrix();
            this.matrix = matrix2;
            matrix2.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = {getWidth(), getHeight()};
            float height = fArr[4] * this.bitmap.getHeight();
            float f = (iArr[0] - new float[]{fArr[0] * this.bitmap.getWidth(), height}[0]) / 2.0f;
            fArr[2] = f;
            fArr[5] = (iArr[1] - height) / 2.0f;
            this.matrix.setValues(fArr);
            OnMatrixChangedListener onMatrixChangedListener = this.listener;
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public void rotateRight() {
        try {
            Matrix matrix = new Matrix();
            this.matrix = matrix;
            float[] fArr = {0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            matrix.setValues(fArr);
            Bitmap bitmap = this.bitmap;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = bitmapCreateBitmap;
            }
            setImageBitmap(this.bitmap);
            Matrix matrix2 = new Matrix();
            this.matrix = matrix2;
            matrix2.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = {getWidth(), getHeight()};
            float height = fArr[4] * this.bitmap.getHeight();
            float f = (iArr[0] - new float[]{fArr[0] * this.bitmap.getWidth(), height}[0]) / 2.0f;
            fArr[2] = f;
            fArr[5] = (iArr[1] - height) / 2.0f;
            this.matrix.setValues(fArr);
            OnMatrixChangedListener onMatrixChangedListener = this.listener;
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        setImageBitmap(bitmap);
        int[] iArr = {getWidth(), getHeight()};
        int[] iArrFixRect = BitmapHelper.fixRect(new int[]{this.bitmap.getWidth(), this.bitmap.getHeight()}, iArr);
        int[] iArr2 = {(iArr[0] - iArrFixRect[0]) / 2, (iArr[1] - iArrFixRect[1]) / 2};
        float[] fArr = {iArrFixRect[0] / r1[0], iArrFixRect[1] / r1[1]};
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        matrix.set(getImageMatrix());
        this.matrix.postScale(fArr[0], fArr[1]);
        this.matrix.postTranslate(iArr2[0], iArr2[1]);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void setOnMatrixChangedListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.listener = onMatrixChangedListener;
        Matrix matrix = this.matrix;
        if (matrix != null) {
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(matrix);
            }
            setImageMatrix(this.matrix);
        }
    }

    public void zoomIn() {
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        matrix.set(getImageMatrix());
        this.matrix.postScale(1.072f, 1.072f);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void zoomOut() {
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        matrix.set(getImageMatrix());
        this.matrix.postScale(0.933f, 0.933f);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
