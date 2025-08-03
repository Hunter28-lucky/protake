package defpackage;

import com.blink.academy.film.widgets.wheel.view.WheelView;
import java.util.TimerTask;

/* compiled from: InertiaTimerTask.java */
/* renamed from: ن, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3484 extends TimerTask {

    /* renamed from: ԫ, reason: contains not printable characters */
    public float f12109 = 2.1474836E9f;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final float f12110;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final WheelView f12111;

    public C3484(WheelView wheelView, float f) {
        this.f12111 = wheelView;
        this.f12110 = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f12109 == 2.1474836E9f) {
            if (Math.abs(this.f12110) > 2000.0f) {
                this.f12109 = this.f12110 <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f12109 = this.f12110;
            }
        }
        if (Math.abs(this.f12109) >= 0.0f && Math.abs(this.f12109) <= 20.0f) {
            this.f12111.m4714();
            this.f12111.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.f12109 / 100.0f);
        WheelView wheelView = this.f12111;
        float f = i;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f);
        if (!this.f12111.m4721()) {
            float itemHeight = this.f12111.getItemHeight();
            float totalScrollY = (-this.f12111.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f12111.getItemsCount() - 1) - this.f12111.getInitPosition()) * itemHeight;
            double d = itemHeight * 0.25d;
            if (this.f12111.getTotalScrollY() - d < totalScrollY) {
                totalScrollY = this.f12111.getTotalScrollY() + f;
            } else if (this.f12111.getTotalScrollY() + d > itemsCount) {
                itemsCount = this.f12111.getTotalScrollY() + f;
            }
            if (this.f12111.getTotalScrollY() <= totalScrollY) {
                this.f12109 = 40.0f;
                this.f12111.setTotalScrollY((int) totalScrollY);
            } else if (this.f12111.getTotalScrollY() >= itemsCount) {
                this.f12111.setTotalScrollY((int) itemsCount);
                this.f12109 = -40.0f;
            }
        }
        float f2 = this.f12109;
        if (f2 < 0.0f) {
            this.f12109 = f2 + 20.0f;
        } else {
            this.f12109 = f2 - 20.0f;
        }
        this.f12111.getHandler().sendEmptyMessage(1000);
    }
}
