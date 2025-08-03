package defpackage;

import com.blink.academy.film.widgets.wheel.view.WheelView;
import java.util.TimerTask;

/* compiled from: SmoothScrollTimerTask.java */
/* renamed from: ஔ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4464 extends TimerTask {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f15357 = Integer.MAX_VALUE;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f15358 = 0;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f15359;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final WheelView f15360;

    public C4464(WheelView wheelView, int i) {
        this.f15360 = wheelView;
        this.f15359 = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f15357 == Integer.MAX_VALUE) {
            this.f15357 = this.f15359;
        }
        int i = this.f15357;
        int i2 = (int) (i * 0.1f);
        this.f15358 = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f15358 = -1;
            } else {
                this.f15358 = 1;
            }
        }
        if (Math.abs(i) <= 1) {
            this.f15360.m4714();
            this.f15360.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f15360;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f15358);
        if (!this.f15360.m4721()) {
            float itemHeight = this.f15360.getItemHeight();
            float itemsCount = ((this.f15360.getItemsCount() - 1) - this.f15360.getInitPosition()) * itemHeight;
            if (this.f15360.getTotalScrollY() <= (-this.f15360.getInitPosition()) * itemHeight || this.f15360.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f15360;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f15358);
                this.f15360.m4714();
                this.f15360.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f15360.getHandler().sendEmptyMessage(1000);
        this.f15357 -= this.f15358;
    }
}
