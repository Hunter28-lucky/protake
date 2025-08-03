package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes2.dex */
public class MobDrawerLayout extends ViewGroup {
    private static final int SNAP_VELOCITY = 500;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private FrameLayout bodyContainer;
    private FrameLayout drawerContainer;
    private double drawerWidth;
    private float lastMotionX;
    private float lastMotionY;
    private OnDrawerStateChangeListener listener;
    private boolean lockScroll;
    private int maximumVelocity;
    private boolean opened;
    private Paint paint;
    private Scroller scroller;
    private int touchSlop;
    private int touchState;
    private DrawerType type;
    private VelocityTracker velocityTracker;

    /* renamed from: com.mob.tools.gui.MobDrawerLayout$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;

        static {
            int[] iArr = new int[DrawerType.values().length];
            $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType = iArr;
            try {
                iArr[DrawerType.LEFT_COVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[DrawerType.RIGHT_COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[DrawerType.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[DrawerType.LEFT_PUSH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[DrawerType.RIGHT_BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[DrawerType.RIGHT_PUSH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum DrawerType {
        LEFT_COVER,
        RIGHT_COVER,
        LEFT_BOTTOM,
        RIGHT_BOTTOM,
        LEFT_PUSH,
        RIGHT_PUSH
    }

    public interface OnDrawerStateChangeListener {
        void onClosing(MobDrawerLayout mobDrawerLayout, int i);

        void onOpening(MobDrawerLayout mobDrawerLayout, int i);
    }

    public MobDrawerLayout(Context context) {
        super(context);
        init(context);
    }

    private void computeDrag(int i) {
        if (i >= SNAP_VELOCITY) {
            switch (AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()]) {
                case 1:
                case 3:
                case 4:
                    open();
                    break;
                case 2:
                case 5:
                case 6:
                    close();
                    break;
            }
        }
        if (i <= -500) {
            switch (AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()]) {
                case 1:
                case 3:
                case 4:
                    close();
                    break;
                case 2:
                case 5:
                case 6:
                    open();
                    break;
            }
        }
        int right = 0;
        switch (AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()]) {
            case 1:
            case 4:
                right = this.drawerContainer.getRight();
                break;
            case 2:
            case 6:
                right = getWidth() - this.drawerContainer.getLeft();
                break;
            case 3:
                right = this.bodyContainer.getLeft();
                break;
            case 5:
                right = -this.bodyContainer.getLeft();
                break;
        }
        if (right >= ((int) (getWidth() * this.drawerWidth)) / 2) {
            open();
        } else {
            close();
        }
    }

    private void dragToLeft(int i) {
        switch (AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()]) {
            case 1:
                int right = this.drawerContainer.getRight();
                if (right > 0) {
                    int i2 = right - i;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    this.drawerContainer.layout(i2 - ((int) (getWidth() * this.drawerWidth)), 0, i2, getHeight());
                    break;
                }
                break;
            case 2:
                int right2 = this.drawerContainer.getRight();
                int width = getWidth();
                if (right2 > width) {
                    int i3 = right2 - i;
                    if (i3 >= width) {
                        width = i3;
                    }
                    this.drawerContainer.layout(width - ((int) (getWidth() * this.drawerWidth)), 0, width, getHeight());
                    break;
                }
                break;
            case 3:
                int left = this.bodyContainer.getLeft();
                if (left > 0) {
                    int i4 = left - i;
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    this.bodyContainer.layout(i4, 0, getWidth() + i4, getHeight());
                    break;
                }
                break;
            case 4:
                int right3 = this.drawerContainer.getRight();
                if (right3 > 0) {
                    int i5 = right3 - i;
                    if (i5 < 0) {
                        i5 = 0;
                    }
                    int width2 = i5 - ((int) (getWidth() * this.drawerWidth));
                    int width3 = getWidth() + i5;
                    this.drawerContainer.layout(width2, 0, i5, getHeight());
                    this.bodyContainer.layout(i5, 0, width3, getHeight());
                    break;
                }
                break;
            case 5:
                int left2 = this.bodyContainer.getLeft();
                int i6 = (int) ((-getWidth()) * this.drawerWidth);
                if (left2 > i6) {
                    int i7 = left2 - i;
                    if (i7 >= i6) {
                        i6 = i7;
                    }
                    this.bodyContainer.layout(i6, 0, getWidth() + i6, getHeight());
                    break;
                }
                break;
            case 6:
                int right4 = this.drawerContainer.getRight();
                int width4 = getWidth();
                if (right4 > width4) {
                    int i8 = right4 - i;
                    if (i8 >= width4) {
                        width4 = i8;
                    }
                    int width5 = width4 - ((int) (getWidth() * this.drawerWidth));
                    int width6 = width5 - getWidth();
                    this.drawerContainer.layout(width5, 0, width4, getHeight());
                    this.bodyContainer.layout(width6, 0, width5, getHeight());
                    break;
                }
                break;
        }
    }

    private void dragToRight(int i) {
        switch (AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()]) {
            case 1:
                int left = this.drawerContainer.getLeft();
                if (left < 0) {
                    int i2 = left + i;
                    if (i2 > 0) {
                        i2 = 0;
                    }
                    this.drawerContainer.layout(i2, 0, ((int) (getWidth() * this.drawerWidth)) + i2, getHeight());
                    break;
                }
                break;
            case 2:
                int left2 = this.drawerContainer.getLeft();
                int width = getWidth();
                if (left2 < width) {
                    int i3 = left2 + i;
                    if (i3 <= width) {
                        width = i3;
                    }
                    this.drawerContainer.layout(width, 0, ((int) (getWidth() * this.drawerWidth)) + width, getHeight());
                    break;
                }
                break;
            case 3:
                int left3 = this.bodyContainer.getLeft();
                int width2 = (int) (getWidth() * this.drawerWidth);
                if (left3 < width2) {
                    int i4 = left3 + i;
                    if (i4 <= width2) {
                        width2 = i4;
                    }
                    this.bodyContainer.layout(width2, 0, getWidth() + width2, getHeight());
                    break;
                }
                break;
            case 4:
                int left4 = this.drawerContainer.getLeft();
                if (left4 < 0) {
                    int i5 = left4 + i;
                    if (i5 > 0) {
                        i5 = 0;
                    }
                    int width3 = ((int) (getWidth() * this.drawerWidth)) + i5;
                    int width4 = getWidth() + width3;
                    this.drawerContainer.layout(i5, 0, width3, getHeight());
                    this.bodyContainer.layout(width3, 0, width4, getHeight());
                    break;
                }
                break;
            case 5:
                int left5 = this.bodyContainer.getLeft();
                if (left5 < 0) {
                    int i6 = left5 + i;
                    if (i6 > 0) {
                        i6 = 0;
                    }
                    this.bodyContainer.layout(i6, 0, getWidth() + i6, getHeight());
                    break;
                }
                break;
            case 6:
                int left6 = this.bodyContainer.getLeft();
                if (left6 < 0) {
                    int i7 = left6 + i;
                    if (i7 > 0) {
                        i7 = 0;
                    }
                    int width5 = getWidth() + i7;
                    int width6 = ((int) (getWidth() * this.drawerWidth)) + width5;
                    this.bodyContainer.layout(i7, 0, width5, getHeight());
                    this.drawerContainer.layout(width5, 0, width6, getHeight());
                    break;
                }
                break;
        }
    }

    private void drawShadow(Canvas canvas) {
        int i = AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()];
        if (i == 1) {
            int right = this.drawerContainer.getRight();
            if (right > 0) {
                float f = right;
                float f2 = right + 25;
                this.paint.setShader(new LinearGradient(f, 0.0f, f2, 0.0f, Integer.MIN_VALUE, 0, Shader.TileMode.CLAMP));
                canvas.drawRect(f, 0.0f, f2, getHeight(), this.paint);
                return;
            }
            return;
        }
        if (i == 2) {
            int left = this.drawerContainer.getLeft();
            if (left < getWidth()) {
                float f3 = left - 25;
                float f4 = left;
                this.paint.setShader(new LinearGradient(f3, 0.0f, f4, 0.0f, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
                canvas.drawRect(f3, 0.0f, f4, getHeight(), this.paint);
                return;
            }
            return;
        }
        if (i == 5 || i == 6) {
            int right2 = this.bodyContainer.getRight();
            if (right2 < getWidth()) {
                float f5 = right2;
                float f6 = right2 + 25;
                this.paint.setShader(new LinearGradient(f5, 0.0f, f6, 0.0f, Integer.MIN_VALUE, 0, Shader.TileMode.CLAMP));
                canvas.drawRect(f5, 0.0f, f6, getHeight(), this.paint);
                return;
            }
            return;
        }
        int left2 = this.bodyContainer.getLeft();
        if (left2 > 0) {
            float f7 = left2 - 25;
            float f8 = left2;
            this.paint.setShader(new LinearGradient(f7, 0.0f, f8, 0.0f, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
            canvas.drawRect(f7, 0.0f, f8, getHeight(), this.paint);
        }
    }

    private void init(Context context) {
        this.scroller = SmoothScroller.DEFAULT.getScroller(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.type = DrawerType.LEFT_COVER;
        this.drawerWidth = 0.8d;
        this.touchState = 0;
        this.paint = new Paint();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.mob.tools.gui.MobDrawerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        FrameLayout frameLayout = new FrameLayout(context);
        this.bodyContainer = frameLayout;
        frameLayout.setOnClickListener(onClickListener);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.drawerContainer = frameLayout2;
        frameLayout2.setOnClickListener(onClickListener);
        addView(this.bodyContainer);
        addView(this.drawerContainer);
    }

    private boolean isClose() {
        boolean z = true;
        switch (AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()]) {
            case 1:
                if (this.drawerContainer.getRight() != 0) {
                }
                return z;
            case 2:
                if (this.drawerContainer.getLeft() != getWidth()) {
                }
                return z;
            case 3:
            case 4:
                if (this.bodyContainer.getLeft() != 0) {
                }
                return z;
            case 5:
            case 6:
                if (this.bodyContainer.getRight() != getWidth()) {
                }
                return z;
            default:
                return false;
        }
        z = false;
        return z;
    }

    private void switchDrawer(boolean z, boolean z2) {
        int left;
        double width;
        double d;
        int i;
        int i2;
        this.bodyContainer.clearFocus();
        this.drawerContainer.clearFocus();
        switch (AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()]) {
            case 1:
            case 4:
                left = this.drawerContainer.getLeft();
                if (!z) {
                    width = -getWidth();
                    d = this.drawerWidth;
                    d = width * d;
                }
                i = (int) d;
                i2 = left;
                break;
            case 2:
            case 6:
                int width2 = getWidth();
                int left2 = this.drawerContainer.getLeft();
                i = width2 - ((int) (z ? width2 * this.drawerWidth : 0.0d));
                i2 = left2;
                break;
            case 3:
                left = this.bodyContainer.getLeft();
                if (z) {
                    width = getWidth();
                    d = this.drawerWidth;
                    d = width * d;
                }
                i = (int) d;
                i2 = left;
                break;
            case 5:
                left = this.bodyContainer.getLeft();
                if (z) {
                    width = -getWidth();
                    d = this.drawerWidth;
                    d = width * d;
                }
                i = (int) d;
                i2 = left;
                break;
            default:
                i = 0;
                i2 = 0;
                break;
        }
        this.scroller.abortAnimation();
        if (i2 != i) {
            this.scroller.startScroll(i2, 0, i - i2, 0, z2 ? 0 : 100);
        }
        invalidate();
    }

    public void close(boolean z) {
        switchDrawer(false, z);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.scroller.computeScrollOffset()) {
            if (isClose()) {
                this.opened = false;
                return;
            } else {
                this.opened = true;
                return;
            }
        }
        switch (AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()]) {
            case 1:
            case 2:
                int currX = this.scroller.getCurrX();
                this.drawerContainer.layout(currX, 0, ((int) (getWidth() * this.drawerWidth)) + currX, getHeight());
                break;
            case 3:
            case 5:
                int currX2 = this.scroller.getCurrX();
                this.bodyContainer.layout(currX2, 0, getWidth() + currX2, getHeight());
                break;
            case 4:
                int width = getWidth();
                int currX3 = this.scroller.getCurrX();
                int i = ((int) (width * this.drawerWidth)) + currX3;
                this.drawerContainer.layout(currX3, 0, i, getHeight());
                this.bodyContainer.layout(i, 0, width + i, getHeight());
                break;
            case 6:
                int width2 = getWidth();
                int currX4 = this.scroller.getCurrX();
                int i2 = currX4 - width2;
                int i3 = ((int) (width2 * this.drawerWidth)) + currX4;
                this.bodyContainer.layout(i2, 0, currX4, getHeight());
                this.drawerContainer.layout(currX4, 0, i3, getHeight());
                break;
        }
        postInvalidate();
        if (this.listener == null || this.scroller.getFinalX() == this.scroller.getStartX()) {
            return;
        }
        int currX5 = ((this.scroller.getCurrX() - this.scroller.getStartX()) * 100) / (this.scroller.getFinalX() - this.scroller.getStartX());
        if (this.opened) {
            this.listener.onClosing(this, currX5);
        } else {
            this.listener.onOpening(this, currX5);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        long drawingTime = getDrawingTime();
        int i = AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()];
        if (i == 1 || i == 2 || i == 6) {
            frameLayout = this.bodyContainer;
            frameLayout2 = this.drawerContainer;
        } else {
            frameLayout = this.drawerContainer;
            frameLayout2 = this.bodyContainer;
        }
        drawChild(canvas, frameLayout, drawingTime);
        drawChild(canvas, frameLayout2, drawingTime);
        drawShadow(canvas);
    }

    public boolean isOpened() {
        return this.opened;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.lockScroll
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r2 = 2
            r3 = 1
            if (r0 != r2) goto L13
            int r4 = r5.touchState
            if (r4 == 0) goto L13
            return r3
        L13:
            android.view.VelocityTracker r4 = r5.velocityTracker
            if (r4 != 0) goto L1d
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r5.velocityTracker = r4
        L1d:
            android.view.VelocityTracker r4 = r5.velocityTracker
            r4.addMovement(r6)
            if (r0 == 0) goto L5d
            if (r0 == r3) goto L50
            if (r0 == r2) goto L2c
            r6 = 3
            if (r0 == r6) goto L50
            goto L72
        L2c:
            float r0 = r6.getX()
            float r6 = r6.getY()
            float r2 = r5.lastMotionX
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r2 = (int) r2
            float r4 = r5.lastMotionY
            float r6 = r6 - r4
            float r6 = java.lang.Math.abs(r6)
            int r6 = (int) r6
            if (r6 >= r2) goto L72
            int r6 = r5.touchSlop
            if (r2 <= r6) goto L72
            r5.touchState = r3
            r5.lastMotionX = r0
            goto L72
        L50:
            android.view.VelocityTracker r6 = r5.velocityTracker
            if (r6 == 0) goto L5a
            r6.recycle()
            r6 = 0
            r5.velocityTracker = r6
        L5a:
            r5.touchState = r1
            goto L72
        L5d:
            float r0 = r6.getX()
            r5.lastMotionX = r0
            float r6 = r6.getY()
            r5.lastMotionY = r6
            android.widget.Scroller r6 = r5.scroller
            boolean r6 = r6.isFinished()
            r6 = r6 ^ r3
            r5.touchState = r6
        L72:
            int r6 = r5.touchState
            if (r6 == 0) goto L77
            r1 = r3
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.MobDrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = (int) (i5 * this.drawerWidth);
        if (!isOpened()) {
            switch (AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()]) {
                case 1:
                    this.bodyContainer.layout(0, 0, i5, i6);
                    this.drawerContainer.layout(-i7, 0, 0, i6);
                    break;
                case 2:
                    this.bodyContainer.layout(0, 0, i5, i6);
                    this.drawerContainer.layout(i5, 0, i7 + i5, i6);
                    break;
                case 3:
                    this.bodyContainer.layout(0, 0, i5, i6);
                    this.drawerContainer.layout(0, 0, i7, i6);
                    break;
                case 4:
                    this.bodyContainer.layout(0, 0, i5, i6);
                    this.drawerContainer.layout(-i7, 0, 0, i6);
                    break;
                case 5:
                    this.bodyContainer.layout(0, 0, i5, i6);
                    this.drawerContainer.layout(i5 - i7, 0, i5, i6);
                    break;
                case 6:
                    this.bodyContainer.layout(0, 0, i5, i6);
                    this.drawerContainer.layout(i5, 0, i7 + i5, i6);
                    break;
            }
        }
        switch (AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[this.type.ordinal()]) {
            case 1:
                this.bodyContainer.layout(0, 0, i5, i6);
                this.drawerContainer.layout(0, 0, i7, i6);
                break;
            case 2:
                this.bodyContainer.layout(0, 0, i5, i6);
                this.drawerContainer.layout(i5 - i7, 0, i5, i6);
                break;
            case 3:
                this.bodyContainer.layout(i7, 0, i5 + i7, i6);
                this.drawerContainer.layout(0, 0, i7, i6);
                break;
            case 4:
                this.bodyContainer.layout(i7, 0, i5 + i7, i6);
                this.drawerContainer.layout(0, 0, i7, i6);
                break;
            case 5:
                int i8 = -i7;
                int i9 = i5 - i7;
                this.bodyContainer.layout(i8, 0, i9, i6);
                this.drawerContainer.layout(i9, 0, i5, i6);
                break;
            case 6:
                int i10 = -i7;
                int i11 = i5 - i7;
                this.bodyContainer.layout(i10, 0, i11, i6);
                this.drawerContainer.layout(i11, 0, i5, i6);
                break;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.bodyContainer.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.drawerContainer.measure(View.MeasureSpec.makeMeasureSpec((int) (measuredWidth * this.drawerWidth), 1073741824), iMakeMeasureSpec2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            android.view.VelocityTracker r0 = r3.velocityTracker
            if (r0 != 0) goto La
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r3.velocityTracker = r0
        La:
            android.view.VelocityTracker r0 = r3.velocityTracker
            r0.addMovement(r4)
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L6a
            if (r0 == r1) goto L44
            r2 = 2
            if (r0 == r2) goto L1f
            r4 = 3
            if (r0 == r4) goto L44
            goto L81
        L1f:
            int r0 = r3.touchState
            if (r0 == r1) goto L2d
            boolean r0 = r3.onInterceptTouchEvent(r4)
            if (r0 == 0) goto L81
            int r0 = r3.touchState
            if (r0 != r1) goto L81
        L2d:
            float r4 = r4.getX()
            float r0 = r3.lastMotionX
            float r0 = r0 - r4
            int r0 = (int) r0
            if (r0 >= 0) goto L3c
            int r0 = -r0
            r3.dragToRight(r0)
            goto L41
        L3c:
            if (r0 <= 0) goto L41
            r3.dragToLeft(r0)
        L41:
            r3.lastMotionX = r4
            goto L81
        L44:
            int r4 = r3.touchState
            if (r4 != r1) goto L66
            android.view.VelocityTracker r4 = r3.velocityTracker
            if (r4 == 0) goto L66
            r0 = 1000(0x3e8, float:1.401E-42)
            int r2 = r3.maximumVelocity
            float r2 = (float) r2
            r4.computeCurrentVelocity(r0, r2)
            android.view.VelocityTracker r4 = r3.velocityTracker
            float r4 = r4.getXVelocity()
            int r4 = (int) r4
            r3.computeDrag(r4)
            android.view.VelocityTracker r4 = r3.velocityTracker
            r4.recycle()
            r4 = 0
            r3.velocityTracker = r4
        L66:
            r4 = 0
            r3.touchState = r4
            goto L81
        L6a:
            int r0 = r3.touchState
            if (r0 == 0) goto L81
            android.widget.Scroller r0 = r3.scroller
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L7b
            android.widget.Scroller r0 = r3.scroller
            r0.abortAnimation()
        L7b:
            float r4 = r4.getX()
            r3.lastMotionX = r4
        L81:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.MobDrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void open(boolean z) {
        switchDrawer(true, z);
    }

    public void setBody(View view) {
        if (ResHelper.isEqual(this.bodyContainer.getChildCount() == 0 ? null : this.bodyContainer.getChildAt(0), view)) {
            return;
        }
        this.bodyContainer.removeAllViews();
        this.bodyContainer.addView(view);
    }

    public void setDrawer(View view) {
        if (ResHelper.isEqual(this.drawerContainer.getChildCount() == 0 ? null : this.drawerContainer.getChildAt(0), view)) {
            return;
        }
        this.drawerContainer.removeAllViews();
        this.drawerContainer.addView(view);
    }

    public void setDrawerType(DrawerType drawerType) {
        if (drawerType == null) {
            drawerType = DrawerType.LEFT_COVER;
        }
        if (this.type != drawerType) {
            this.type = drawerType;
            int i = AnonymousClass2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType[drawerType.ordinal()];
            if (i == 1 || i == 2) {
                this.drawerContainer.bringToFront();
            } else {
                this.bodyContainer.bringToFront();
            }
            postInvalidate();
        }
    }

    public void setDrawerWidth(double d) {
        if (d < 0.0d) {
            d = 0.800000011920929d;
        }
        if (d > 1.0d) {
            d = 1.0d;
        }
        if (this.drawerWidth != d) {
            this.drawerWidth = d;
            postInvalidate();
        }
    }

    public void setLockScroll(boolean z) {
        this.lockScroll = z;
    }

    public void setOnDrawerStateChangeListener(OnDrawerStateChangeListener onDrawerStateChangeListener) {
        this.listener = onDrawerStateChangeListener;
    }

    public void close() {
        close(false);
    }

    public void open() {
        open(false);
    }

    public MobDrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MobDrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
