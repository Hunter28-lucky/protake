package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* loaded from: classes2.dex */
public class MobViewPager extends ViewGroup {
    private static final int DECELERATION = 10;
    private static final int SNAP_VELOCITY = 500;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private ViewPagerAdapter adapter;
    private View currentPage;
    private int currentScreen;
    private int flingVelocity;
    private float lastMotionX;
    private float lastMotionY;
    private int maximumVelocity;
    private View nextPage;
    private int pageWidth;
    private View previousPage;
    private int screenCount;
    private Scroller scroller;
    private boolean skipScreen;
    private int touchSlop;
    private int touchState;
    private VelocityTracker velocityTracker;

    public MobViewPager(Context context) {
        this(context, null);
    }

    private void adjustScroller() {
        this.skipScreen = true;
        if (this.currentPage != null) {
            View focusedChild = getFocusedChild();
            View view = this.currentPage;
            if (focusedChild == view) {
                view.clearFocus();
            }
        }
        int width = (this.currentScreen * getWidth()) - getScrollX();
        this.scroller.abortAnimation();
        if (width != 0) {
            this.scroller.startScroll(getScrollX(), 0, width, 0, 0);
        }
        invalidate();
    }

    private void handleInterceptMove(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int iAbs = (int) Math.abs(x - this.lastMotionX);
        if (((int) Math.abs(y - this.lastMotionY)) >= iAbs || iAbs <= this.touchSlop) {
            return;
        }
        this.touchState = 1;
        this.lastMotionX = x;
    }

    private void handleScrollMove(MotionEvent motionEvent) {
        int right;
        if (this.adapter == null) {
            return;
        }
        float x = motionEvent.getX();
        int i = (int) (this.lastMotionX - x);
        this.lastMotionX = x;
        if (i < 0) {
            if (getScrollX() > 0) {
                scrollBy(Math.max(-getScrollX(), i), 0);
            }
        } else {
            if (i <= 0 || getChildCount() == 0 || (right = (getChildAt(getChildCount() - 1).getRight() - getScrollX()) - getWidth()) <= 0) {
                return;
            }
            scrollBy(Math.min(right, i), 0);
        }
    }

    private void init(Context context) {
        this.scroller = new Scroller(context, new Interpolator() { // from class: com.mob.tools.gui.MobViewPager.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (2.0f - f) * f;
            }
        });
        this.touchState = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void onScreenChange(int i) {
        if (this.adapter != null) {
            if (this.skipScreen && Math.abs(i - this.currentScreen) > 2) {
                removeAllViews();
                int i2 = this.currentScreen;
                if (i2 > 0) {
                    View view = this.adapter.getView(i2 - 1, this.previousPage, this);
                    this.previousPage = view;
                    addView(view);
                }
                View view2 = this.adapter.getView(this.currentScreen, this.currentPage, this);
                this.currentPage = view2;
                addView(view2);
                int i3 = this.currentScreen;
                if (i3 < this.screenCount - 1) {
                    View view3 = this.adapter.getView(i3 + 1, this.nextPage, this);
                    this.nextPage = view3;
                    addView(view3);
                }
            } else if (this.currentScreen > i) {
                for (int i4 = 0; i4 < this.currentScreen - i; i4++) {
                    int i5 = i + i4 + 1;
                    View view4 = this.previousPage;
                    this.previousPage = this.currentPage;
                    this.currentPage = this.nextPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(0);
                    }
                    if (i5 < this.screenCount - 1) {
                        View view5 = this.adapter.getView(i5 + 1, view4, this);
                        this.nextPage = view5;
                        addView(view5);
                    } else {
                        this.nextPage = view4;
                    }
                }
            } else {
                for (int i6 = 0; i6 < i - this.currentScreen; i6++) {
                    int i7 = (i - i6) - 1;
                    View view6 = this.nextPage;
                    this.nextPage = this.currentPage;
                    this.currentPage = this.previousPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(2);
                    }
                    if (i7 > 0) {
                        View view7 = this.adapter.getView(i7 - 1, view6, this);
                        this.previousPage = view7;
                        addView(view7, 0);
                    } else {
                        this.previousPage = view6;
                    }
                }
            }
            this.adapter.onScreenChange(this.currentScreen, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[PHI: r10
      0x0053: PHI (r10v4 int) = (r10v3 int), (r10v5 int) binds: [B:10:0x0024, B:15:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void scrollToScreenOnUIThread(int r10, boolean r11) {
        /*
            r9 = this;
            r9.skipScreen = r11
            android.view.View r0 = r9.currentPage
            if (r0 == 0) goto L11
            android.view.View r0 = r9.getFocusedChild()
            android.view.View r1 = r9.currentPage
            if (r0 != r1) goto L11
            r1.clearFocus()
        L11:
            int r0 = r9.getWidth()
            int r10 = r10 * r0
            int r0 = r9.getScrollX()
            int r4 = r10 - r0
            android.widget.Scroller r10 = r9.scroller
            r10.abortAnimation()
            if (r4 == 0) goto L5f
            r10 = 0
            if (r11 != 0) goto L53
            int r11 = java.lang.Math.abs(r4)
            int r11 = r11 / 2
            int r0 = r9.flingVelocity
            if (r0 == 0) goto L4d
            int r10 = java.lang.Math.abs(r0)
            int r0 = java.lang.Math.abs(r4)
            r1 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r5 = (double) r10
            int r10 = r10 * r10
            int r0 = r0 * 20
            int r10 = r10 - r0
            double r7 = (double) r10
            double r7 = java.lang.Math.sqrt(r7)
            double r5 = r5 - r7
            double r5 = r5 * r1
            r0 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r5 = r5 / r0
            int r10 = (int) r5
        L4d:
            if (r10 == 0) goto L51
            if (r10 <= r11) goto L53
        L51:
            r6 = r11
            goto L54
        L53:
            r6 = r10
        L54:
            android.widget.Scroller r1 = r9.scroller
            int r2 = r9.getScrollX()
            r3 = 0
            r5 = 0
            r1.startScroll(r2, r3, r4, r5, r6)
        L5f:
            r9.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.MobViewPager.scrollToScreenOnUIThread(int, boolean):void");
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            postInvalidate();
        } else {
            int i = this.currentScreen;
            int currX = this.scroller.getCurrX();
            int width = getWidth();
            int i2 = currX / width;
            if (currX % width > width / 2) {
                i2++;
            }
            int iMax = Math.max(0, Math.min(i2, this.screenCount - 1));
            this.currentScreen = iMax;
            if (i != iMax) {
                onScreenChange(i);
            }
        }
        if (this.adapter != null) {
            this.adapter.onScreenChanging(getScrollX() / getWidth());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        if (this.currentScreen > 0) {
            drawChild(canvas, this.previousPage, drawingTime);
        }
        drawChild(canvas, this.currentPage, drawingTime);
        if (this.currentScreen < this.screenCount - 1) {
            drawChild(canvas, this.nextPage, drawingTime);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i) {
        int i2;
        if (this.adapter == null) {
            return super.dispatchUnhandledMove(view, i);
        }
        if (i == 17) {
            int i3 = this.currentScreen;
            if (i3 > 0) {
                scrollToScreenOnUIThread(i3 - 1, false);
                return true;
            }
        } else if (i == 66 && (i2 = this.currentScreen) < this.screenCount - 1) {
            scrollToScreenOnUIThread(i2 + 1, false);
            return true;
        }
        return super.dispatchUnhandledMove(view, i);
    }

    public int getCurrentScreen() {
        return this.currentScreen;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto Ld
            int r3 = r4.touchState
            if (r3 == 0) goto Ld
            return r2
        Ld:
            android.view.VelocityTracker r3 = r4.velocityTracker
            if (r3 != 0) goto L17
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r4.velocityTracker = r3
        L17:
            android.view.VelocityTracker r3 = r4.velocityTracker
            r3.addMovement(r5)
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L2b
            if (r0 == r1) goto L27
            r5 = 3
            if (r0 == r5) goto L2b
            goto L4d
        L27:
            r4.handleInterceptMove(r5)
            goto L4d
        L2b:
            android.view.VelocityTracker r5 = r4.velocityTracker
            if (r5 == 0) goto L35
            r5.recycle()
            r5 = 0
            r4.velocityTracker = r5
        L35:
            r4.touchState = r3
            goto L4d
        L38:
            float r0 = r5.getX()
            float r5 = r5.getY()
            r4.lastMotionX = r0
            r4.lastMotionY = r5
            android.widget.Scroller r5 = r4.scroller
            boolean r5 = r5.isFinished()
            r5 = r5 ^ r2
            r4.touchState = r5
        L4d:
            int r5 = r4.touchState
            if (r5 == 0) goto L52
            goto L53
        L52:
            r2 = r3
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.MobViewPager.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = this.currentScreen;
        int i8 = i7 * i5;
        if (i7 > 0) {
            this.previousPage.layout(i8 - i5, 0, i8, i6);
        }
        int i9 = i8 + i5;
        this.currentPage.layout(i8, 0, i9, i6);
        if (this.currentScreen < this.screenCount - 1) {
            this.nextPage.layout(i9, 0, i5 + i9, i6);
        }
        if (this.pageWidth != getWidth()) {
            int i10 = this.pageWidth;
            this.pageWidth = getWidth();
            if (i10 != 0) {
                adjustScroller();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (this.adapter == null) {
            return false;
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        if (action != 0) {
            if (action == 1) {
                if (this.touchState == 1) {
                    this.velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
                    int xVelocity = (int) this.velocityTracker.getXVelocity();
                    this.flingVelocity = xVelocity;
                    if (xVelocity > SNAP_VELOCITY && (i2 = this.currentScreen) > 0) {
                        scrollToScreenOnUIThread(i2 - 1, false);
                    } else if (xVelocity >= -500 || (i = this.currentScreen) >= this.screenCount - 1) {
                        int width = getWidth();
                        scrollToScreenOnUIThread((getScrollX() + (width / 2)) / width, false);
                    } else {
                        scrollToScreenOnUIThread(i + 1, false);
                    }
                    VelocityTracker velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.velocityTracker = null;
                    }
                }
                this.touchState = 0;
            } else if (action != 2) {
                if (action == 3) {
                    this.touchState = 0;
                }
            } else if (this.touchState == 1) {
                handleScrollMove(motionEvent);
            } else if (onInterceptTouchEvent(motionEvent) && this.touchState == 1) {
                handleScrollMove(motionEvent);
            }
        } else if (this.touchState != 0) {
            if (!this.scroller.isFinished()) {
                this.scroller.abortAnimation();
            }
            this.lastMotionX = x;
        }
        return true;
    }

    public void scrollLeft(boolean z) {
        int i = this.currentScreen;
        if (i > 0) {
            scrollToScreen(i - 1, z);
        }
    }

    public void scrollRight(boolean z) {
        int i = this.currentScreen;
        if (i < this.screenCount - 1) {
            scrollToScreen(i + 1, z);
        }
    }

    public void scrollToScreen(final int i, final boolean z) {
        post(new Runnable() { // from class: com.mob.tools.gui.MobViewPager.2
            @Override // java.lang.Runnable
            public void run() {
                MobViewPager.this.scrollToScreenOnUIThread(i, z);
            }
        });
    }

    public void setAdapter(ViewPagerAdapter viewPagerAdapter) {
        ViewPagerAdapter viewPagerAdapter2 = this.adapter;
        if (viewPagerAdapter2 != null) {
            viewPagerAdapter2.setMobViewPager(null);
        }
        this.adapter = viewPagerAdapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.setMobViewPager(this);
        }
        if (viewPagerAdapter == null) {
            this.currentScreen = 0;
            removeAllViews();
            return;
        }
        int count = viewPagerAdapter.getCount();
        this.screenCount = count;
        if (count <= 0) {
            this.currentScreen = 0;
            removeAllViews();
            return;
        }
        if (count <= this.currentScreen) {
            scrollToScreenOnUIThread(count - 1, true);
            return;
        }
        removeAllViews();
        int i = this.currentScreen;
        if (i > 0) {
            View view = viewPagerAdapter.getView(i - 1, this.previousPage, this);
            this.previousPage = view;
            addView(view);
        }
        View view2 = viewPagerAdapter.getView(this.currentScreen, this.currentPage, this);
        this.currentPage = view2;
        addView(view2);
        int i2 = this.currentScreen;
        if (i2 < this.screenCount - 1) {
            View view3 = viewPagerAdapter.getView(i2 + 1, this.nextPage, this);
            this.nextPage = view3;
            addView(view3);
        }
    }

    public MobViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public void scrollToScreen(int i, boolean z, boolean z2) {
        scrollToScreen(i, z);
    }

    public MobViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
