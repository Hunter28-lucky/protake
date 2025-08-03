package com.mob.tools.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes2.dex */
public class PullToRequestView extends RelativeLayout {
    private static final int FAULT_TOLERANCE_RANGE = 10;
    private static final long MIN_REF_TIME = 1000;
    private PullToRequestAdatper adapter;
    private View bodyView;
    private float downY;
    private int footerHeight;
    private View footerView;
    private int headerHeight;
    private View headerView;
    private long pullTime;
    private boolean pullingDownLock;
    private boolean pullingUpLock;
    private int state;
    private Runnable stopAct;
    private int top;

    public PullToRequestView(Context context) {
        super(context);
        init();
    }

    private boolean canPullDown() {
        return !this.pullingDownLock && this.adapter.isPullDownReady() && this.state == 0;
    }

    private boolean canPullUp() {
        return !this.pullingUpLock && this.adapter.isPullUpReady() && this.state == 0;
    }

    private MotionEvent getCancelEvent(MotionEvent motionEvent) {
        return MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    private void init() {
        this.stopAct = new Runnable() { // from class: com.mob.tools.gui.PullToRequestView.1
            @Override // java.lang.Runnable
            public void run() {
                PullToRequestView.this.reversePulling();
            }
        };
    }

    private void performRequestNext() {
        this.pullTime = System.currentTimeMillis();
        this.state = -1;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onRequestNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reversePulling() {
        this.top = 0;
        scrollTo(0, 0);
        this.state = 0;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onReversed();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0118  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.PullToRequestView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void lockPullingDown() {
        this.pullingDownLock = true;
    }

    public void lockPullingUp() {
        this.pullingUpLock = true;
    }

    public void performFresh() {
        this.pullTime = System.currentTimeMillis();
        this.state = 1;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onRefresh();
        }
    }

    public void performPullingDown(boolean z) {
        int i = this.headerHeight;
        this.top = i;
        scrollTo(0, -i);
        if (z) {
            performFresh();
        }
    }

    public void performPullingUp(boolean z) {
        int i = -this.footerHeight;
        this.top = i;
        scrollTo(0, -i);
        if (z) {
            performRequestNext();
        }
    }

    public void releasePullingDownLock() {
        this.pullingDownLock = false;
    }

    public void releasePullingUpLock() {
        this.pullingUpLock = false;
    }

    public void setAdapter(PullToRequestAdatper pullToRequestAdatper) {
        this.adapter = pullToRequestAdatper;
        removeAllViews();
        this.bodyView = (View) pullToRequestAdatper.getBodyView();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(9);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        addView(this.bodyView, layoutParams);
        View headerView = pullToRequestAdatper.getHeaderView();
        this.headerView = headerView;
        headerView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.headerView.measure(0, 0);
        this.headerHeight = this.headerView.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, this.headerHeight);
        layoutParams2.addRule(9);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = -this.headerHeight;
        addView(this.headerView, layoutParams2);
        View footerView = pullToRequestAdatper.getFooterView();
        this.footerView = footerView;
        footerView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.footerView.measure(0, 0);
        this.footerHeight = this.footerView.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, this.headerHeight);
        layoutParams3.addRule(9);
        layoutParams3.addRule(11);
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = -this.headerHeight;
        addView(this.footerView, layoutParams3);
    }

    public void stopPulling() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.pullTime;
        if (jCurrentTimeMillis < 1000) {
            postDelayed(this.stopAct, 1000 - jCurrentTimeMillis);
        } else {
            post(this.stopAct);
        }
    }

    public PullToRequestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PullToRequestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
