package defpackage;

import android.graphics.RectF;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.blink.academy.film.widgets.exposure.CameraTouchView;
import com.blink.academy.film.widgets.iso.FocusZoomWheelView;
import java.util.Locale;

/* compiled from: BaseHomeFragment.java */
/* renamed from: ၥ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC5160 extends Fragment {

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f17095 = false;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f17096;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f17097;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f17098;

    /* compiled from: BaseHomeFragment.java */
    /* renamed from: ၥ$Ϳ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC5161 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f17099;

        /* compiled from: BaseHomeFragment.java */
        /* renamed from: ၥ$Ϳ$Ϳ, reason: contains not printable characters */
        public class RunnableC5162 implements Runnable {
            public RunnableC5162() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewOnTouchListenerC5161.this.f17099.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC5161(View view) {
            this.f17099 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f17099.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC5162(), 100L);
            return false;
        }
    }

    /* renamed from: Ϳ */
    public void mo10463(boolean z) {
    }

    /* renamed from: Ԩ */
    public boolean mo10470() {
        return false;
    }

    /* renamed from: ԩ */
    public void mo10471(float f) {
    }

    /* renamed from: Ԫ */
    public void mo10472() {
    }

    /* renamed from: ԫ */
    public void mo10473(float f, float f2) {
    }

    /* renamed from: Ԭ */
    public abstract void mo10474(boolean z);

    /* renamed from: ԭ */
    public void mo10475(boolean z) {
    }

    /* renamed from: Ԯ */
    public void mo10476(boolean z) {
    }

    /* renamed from: ԯ */
    public abstract void mo10477(boolean z);

    /* renamed from: ՠ */
    public void mo10478(boolean z) {
    }

    /* renamed from: ֈ */
    public void mo10480(boolean z) {
    }

    /* renamed from: ֏ */
    public abstract void mo10481(int i, int i2, int i3);

    /* renamed from: ׯ */
    public void mo10485(boolean z) {
    }

    /* renamed from: ؠ */
    public abstract int mo10487();

    /* renamed from: ހ */
    public void mo10500() {
    }

    /* renamed from: ށ */
    public abstract void mo10501();

    /* renamed from: ނ */
    public void mo10502() {
    }

    /* renamed from: ރ */
    public abstract void mo10503();

    /* renamed from: ބ */
    public void mo10504(boolean z) {
    }

    /* renamed from: ޅ */
    public abstract void mo10505();

    /* renamed from: ކ */
    public void mo10506(float f, boolean z) {
    }

    /* renamed from: އ */
    public abstract void mo10507(int i, FocusZoomWheelView.InterfaceC1175 interfaceC1175);

    /* renamed from: ވ */
    public void mo10508(boolean z, int i) {
    }

    /* renamed from: މ */
    public void mo10509() {
    }

    /* renamed from: ފ */
    public abstract void mo10510();

    /* renamed from: ދ */
    public float mo10511(float f) {
        return 0.0f;
    }

    /* renamed from: ތ */
    public float mo10512(float f) {
        return 0.0f;
    }

    /* renamed from: ލ */
    public RectF mo10513() {
        return null;
    }

    /* renamed from: ގ */
    public abstract float mo10514();

    /* renamed from: ޏ */
    public abstract int mo10515();

    /* renamed from: ސ */
    public float[] mo10516() {
        return null;
    }

    /* renamed from: ޑ */
    public float mo10517() {
        return 0.0f;
    }

    /* renamed from: ޒ */
    public float mo10518() {
        return 0.0f;
    }

    /* renamed from: ޓ */
    public abstract float mo10519(float f, float f2, float f3);

    /* renamed from: ޔ, reason: contains not printable characters */
    public int m15085(int i) {
        return C4792.m14375().m14477(i, this.f17096);
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public String m15086(int i) {
        return getString(i).toUpperCase(Locale.US);
    }

    /* renamed from: ޖ */
    public void mo10520(int i) {
    }

    /* renamed from: ޗ */
    public abstract void mo10521(int i);

    /* renamed from: ޘ */
    public void mo10522() {
    }

    /* renamed from: ޙ */
    public void mo10523() {
    }

    /* renamed from: ޚ */
    public void mo10524(int i) {
    }

    /* renamed from: ޛ */
    public void mo10525() {
    }

    /* renamed from: ޜ */
    public void mo10526(int i, int i2, int i3) {
    }

    /* renamed from: ޝ */
    public void mo10527(float f, int i) {
    }

    /* renamed from: ޞ */
    public void mo10528() {
    }

    /* renamed from: ޟ */
    public abstract void mo10529(long j, int i, boolean z);

    /* renamed from: ޠ */
    public boolean mo10530() {
        return false;
    }

    /* renamed from: ޡ */
    public abstract boolean mo10531();

    /* renamed from: ޢ */
    public abstract void mo10532();

    /* renamed from: ޣ */
    public void mo10533() {
    }

    /* renamed from: ޤ */
    public void mo10534() {
    }

    /* renamed from: ޥ */
    public void mo10535(float f) {
    }

    /* renamed from: ޱ */
    public void mo10536(float f) {
    }

    /* renamed from: ߾ */
    public void mo10541() {
    }

    /* renamed from: ߿ */
    public abstract void mo10542(int i, boolean z);

    /* renamed from: ࡠ */
    public void mo10544() {
    }

    /* renamed from: ࡡ */
    public void mo10545() {
    }

    /* renamed from: ࡢ */
    public void mo10546() {
    }

    /* renamed from: ࡣ */
    public void mo10547() {
    }

    /* renamed from: ࡤ */
    public void mo10548(boolean z) {
    }

    /* renamed from: ࡥ */
    public abstract void mo10549(int i);

    /* renamed from: ࡦ */
    public abstract void mo10550();

    /* renamed from: ࡧ */
    public abstract void mo10551();

    /* renamed from: ࡨ */
    public abstract void mo10552(float f);

    /* renamed from: ࡩ */
    public abstract void mo10553(float f);

    /* renamed from: ࡪ */
    public abstract void mo10554();

    /* renamed from: ࢠ */
    public void mo10555(float f) {
    }

    /* renamed from: ࢡ */
    public void mo10556(float f, float f2) {
    }

    /* renamed from: ࢢ */
    public void mo10557(String str, int i, String str2) {
    }

    /* renamed from: ࢣ */
    public void mo10558() {
    }

    /* renamed from: ࢤ */
    public void mo10559(long j) {
    }

    /* renamed from: ࢥ */
    public void mo10560(boolean z) {
    }

    /* renamed from: ࢦ */
    public abstract void mo10561();

    /* renamed from: ࢧ */
    public void mo10562() {
    }

    /* renamed from: ࢨ */
    public abstract void mo10563();

    /* renamed from: ࢩ */
    public void mo10564() {
    }

    /* renamed from: ࢪ */
    public void mo10565() {
    }

    /* renamed from: ࢫ */
    public abstract void mo10566();

    /* renamed from: ࢬ */
    public abstract void mo10567(boolean z);

    /* renamed from: ࢭ */
    public void mo10568() {
    }

    /* renamed from: ࢮ */
    public abstract void mo10569(boolean z);

    /* renamed from: ࢯ */
    public void mo10570(int i) {
    }

    /* renamed from: ࢰ */
    public void mo10571() {
    }

    /* renamed from: ࢱ */
    public void mo10572() {
    }

    /* renamed from: ࢲ */
    public void mo10573() {
    }

    /* renamed from: ࢳ */
    public void mo10574(String str) {
    }

    /* renamed from: ࢴ */
    public void mo10575() {
    }

    /* renamed from: ࢶ */
    public void mo10576() {
    }

    /* renamed from: ࢷ */
    public abstract void mo10577();

    /* renamed from: ࢸ */
    public abstract void mo10578();

    /* renamed from: ࢹ */
    public abstract void mo10579();

    /* renamed from: ࢺ */
    public void mo10580(float f, float f2) {
    }

    /* renamed from: ࢻ */
    public void mo10581() {
    }

    /* renamed from: ࢼ */
    public void mo10582(String str) {
    }

    /* renamed from: ࢽ */
    public void mo10583() {
    }

    /* renamed from: ࢾ */
    public abstract void mo10584();

    /* renamed from: ࢿ */
    public void mo10585(float f) {
    }

    /* renamed from: ࣀ */
    public void mo10586(float f, float f2) {
    }

    /* renamed from: ࣁ */
    public void mo10587() {
    }

    /* renamed from: ࣂ */
    public void mo10588() {
    }

    /* renamed from: ࣃ */
    public abstract void mo10589(int i);

    /* renamed from: ࣄ */
    public void mo10590() {
    }

    /* renamed from: ࣅ */
    public void mo10591(boolean z) {
    }

    /* renamed from: ࣆ */
    public void mo10592() {
    }

    /* renamed from: ࣇ */
    public void mo10593(int i) {
    }

    /* renamed from: ৼ */
    public abstract void mo10596(boolean z);

    /* renamed from: ૹ */
    public abstract void mo10597(int i);

    /* renamed from: ಀ */
    public abstract void mo10598(String str);

    /* renamed from: ೱ */
    public abstract void mo10599(int i);

    /* renamed from: ೲ */
    public abstract void mo10600();

    /* renamed from: ഄ */
    public abstract void mo10601(boolean z, float f);

    /* renamed from: ഩ */
    public void mo10602(float f) {
    }

    /* renamed from: ഺ */
    public void mo10603(int i) {
    }

    /* renamed from: ൎ */
    public void mo10605(float f, float f2) {
    }

    /* renamed from: ൔ */
    public void mo10606() {
    }

    /* renamed from: ൕ */
    public abstract void mo10607(int i);

    /* renamed from: ൖ */
    public void mo10608(float f) {
    }

    /* renamed from: ൟ */
    public void mo10609(C3828 c3828) {
    }

    /* renamed from: ຆ */
    public abstract void mo10611(boolean z);

    /* renamed from: ຉ */
    public void mo10612(int i) {
    }

    /* renamed from: ຌ */
    public void mo10613(boolean z) {
    }

    /* renamed from: ຎ */
    public void mo10614() {
    }

    /* renamed from: ຏ */
    public void mo10615(float f, float f2) {
    }

    /* renamed from: ຐ */
    public void mo10616(float f, float f2) {
    }

    /* renamed from: ຑ */
    public abstract void mo10617(float f, float f2, boolean z);

    /* renamed from: ຒ */
    public void mo10618() {
    }

    /* renamed from: ຓ */
    public abstract void mo10619(int i);

    /* renamed from: ຘ */
    public void mo10620(float f) {
    }

    /* renamed from: ຠ */
    public abstract void mo10621(String str, int i);

    /* renamed from: ຨ */
    public void mo10622() {
    }

    /* renamed from: ຩ */
    public abstract void mo10623(boolean z, boolean z2);

    /* renamed from: ຬ */
    public abstract void mo10624(float f, int i, CameraTouchView.InterfaceC1143 interfaceC1143);

    /* renamed from: ໞ */
    public abstract void mo10625(String str);

    /* renamed from: ໟ */
    public void mo10626(int i, int i2) {
    }

    /* renamed from: ྈ */
    public void mo10630() {
    }

    /* renamed from: ྉ */
    public void mo10631(float f, float f2, boolean z, boolean z2) {
    }

    /* renamed from: ྌ */
    public void mo10633(boolean z, int i) {
    }

    /* renamed from: ဢ */
    public void mo10634(boolean z) {
    }

    /* renamed from: ဨ */
    public void mo10635(boolean z) {
    }

    /* renamed from: ၚ */
    public void mo10636(boolean z) {
    }

    /* renamed from: ၛ */
    public void mo10637(boolean z) {
    }

    /* renamed from: ၜ */
    public void mo10638(boolean z) {
    }

    /* renamed from: ၝ */
    public void mo10639() {
    }

    /* renamed from: ၡ */
    public void mo10640(int i) {
    }

    /* renamed from: ၥ */
    public abstract void mo10641();

    /* renamed from: ၦ */
    public void mo10642() {
    }
}
