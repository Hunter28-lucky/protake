package defpackage;

import android.os.Build;
import com.blink.academy.film.netbean.UserBean;

/* compiled from: UserManager.java */
/* loaded from: classes.dex */
public class e5 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static e5 f6603;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public UserBean f6604;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f6605 = false;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f6606;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static e5 m5988() {
        if (f6603 == null) {
            synchronized (e5.class) {
                if (f6603 == null) {
                    f6603 = new e5();
                }
            }
        }
        return f6603;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m5989() {
        this.f6604 = null;
        C3184.m10827().m10847();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public synchronized UserBean m5990() {
        if (this.f6604 == null) {
            try {
                this.f6604 = C3184.m10827().m10860();
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f6604 = null;
            }
        }
        return this.f6604;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m5991() {
        if (!r1.m8143(this.f6606)) {
            String strM9569 = C2618.m9569("save_still_str_sp", "");
            if (!r1.m8143(strM9569)) {
                strM9569 = w.m8494();
                C2618.m9573("save_still_str_sp", strM9569);
            }
            this.f6606 = w.m8495(Build.MANUFACTURER + Build.MODEL + strM9569 + "Protake");
        }
        return this.f6606;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m5992(UserBean userBean) {
        this.f6604 = userBean;
        C3184.m10827().m10837(userBean);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean m5993() {
        UserBean userBean = this.f6604;
        return userBean != null ? userBean.getIs_subscription_user() : C3659.m11744().m11750();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m5994() {
        return r1.m8142(m5988().m5990());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m5995() {
        m5988().m5989();
        C3659.m11744().m11745(0);
        C4535.m13880().m13905(false);
        C4151.m13162().m13168();
        C2618.m9573("gimbal_his_sp", "");
        C2618.m9573("protake_focus_his_sp", "");
        if (c9.m219().m229()) {
            c9.m219().m225();
        }
        if (C4567.m14006().m14015()) {
            C4567.m14006().m14012();
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m5996(UserBean userBean) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        UserBean userBean2 = this.f6604;
        if (userBean2 != null) {
            jCurrentTimeMillis = userBean2.getDb_id();
        }
        this.f6604 = userBean;
        userBean.setDb_id(jCurrentTimeMillis);
        C3184.m10827().m10872(userBean);
    }
}
