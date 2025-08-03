package defpackage;

import android.content.Context;
import android.view.View;
import com.blink.academy.film.netbean.store.StoreMessageBean;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;

/* compiled from: AppMessageManager.java */
/* renamed from: ഄ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4666 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static C4666 f15858;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f15859;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public StoreMessageBean f15860;

    /* renamed from: ԩ, reason: contains not printable characters */
    public SettingHintDialog f15861;

    /* compiled from: AppMessageManager.java */
    /* renamed from: ഄ$Ϳ, reason: contains not printable characters */
    public class C4667 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Context f15862;

        public C4667(Context context) {
            this.f15862 = context;
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            C4666.this.m14158(true, this.f15862);
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            C4666.this.m14158(false, this.f15862);
        }
    }

    /* compiled from: AppMessageManager.java */
    /* renamed from: ഄ$Ԩ, reason: contains not printable characters */
    public class C4668 extends AbstractC4012 {
        public C4668() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C4666.this.f15861.setVisibility(8);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C4666 m14156() {
        if (f15858 == null) {
            synchronized (C4666.class) {
                if (f15858 == null) {
                    f15858 = new C4666();
                }
            }
        }
        return f15858;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m14157() {
        C4008.m12876(this.f15861, 0.0f, 100, new C4668());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* renamed from: Ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m14158(boolean r7, android.content.Context r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L9
            com.blink.academy.film.netbean.store.StoreMessageBean r7 = r6.f15860
            java.lang.String r7 = r7.getButton_left_action()
            goto Lf
        L9:
            com.blink.academy.film.netbean.store.StoreMessageBean r7 = r6.f15860
            java.lang.String r7 = r7.getButton_right_action()
        Lf:
            java.lang.String r0 = ":"
            r1 = 2
            java.lang.String[] r7 = r7.split(r0, r1)
            r0 = 0
            r2 = r7[r0]
            r3 = -1
            int r4 = r2.hashCode()
            r5 = 1
            switch(r4) {
                case -985832103: goto L4a;
                case -140003240: goto L40;
                case 94756344: goto L36;
                case 933480745: goto L2c;
                case 1035732741: goto L23;
                default: goto L22;
            }
        L22:
            goto L54
        L23:
            java.lang.String r4 = "goto_store"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L54
            goto L55
        L2c:
            java.lang.String r0 = "url_webview"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L54
            r0 = r5
            goto L55
        L36:
            java.lang.String r0 = "close"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L54
            r0 = 3
            goto L55
        L40:
            java.lang.String r0 = "url_browser"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L54
            r0 = r1
            goto L55
        L4a:
            java.lang.String r0 = "download_and_install_apk"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L54
            r0 = 4
            goto L55
        L54:
            r0 = r3
        L55:
            java.lang.String r2 = "android.intent.action.VIEW"
            if (r0 == 0) goto L7d
            if (r0 == r5) goto L65
            if (r0 == r1) goto L65
            com.blink.academy.film.widgets.dialog.SettingHintDialog r7 = r6.f15861
            if (r7 == 0) goto L8b
            r6.m14157()
            goto L8b
        L65:
            int r0 = r7.length
            if (r0 != r1) goto L8b
            r7 = r7[r5]
            android.net.Uri r7 = android.net.Uri.parse(r7)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            r0.setAction(r2)
            r0.setData(r7)
            r8.startActivity(r0)
            goto L8b
        L7d:
            java.lang.String r7 = "market://details?id=com.blink.academy.protake"
            android.net.Uri r7 = android.net.Uri.parse(r7)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r2, r7)
            r8.startActivity(r0)     // Catch: java.lang.Exception -> L8b
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C4666.m14158(boolean, android.content.Context):void");
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m14159(StoreMessageBean storeMessageBean, Context context, SettingHintDialog settingHintDialog) {
        this.f15860 = storeMessageBean;
        this.f15861 = settingHintDialog;
        if (storeMessageBean != null) {
            String show_on = storeMessageBean.getShow_on();
            if (r1.m8143(show_on)) {
                if (!"app_launch".equals(show_on)) {
                    if ("app_resume".equals(show_on)) {
                        m14161(context);
                    }
                } else {
                    if (this.f15859) {
                        return;
                    }
                    this.f15859 = true;
                    m14161(context);
                }
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m14160() {
        this.f15861.setVisibility(0);
        this.f15861.setAlpha(0.0f);
        C4008.m12876(this.f15861, 1.0f, 100, null);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m14161(Context context) {
        this.f15861.m2905(this.f15860.isClose_on_lost_focus());
        C3891 c3891 = new C3891();
        c3891.m12515(this.f15860.getTitle());
        c3891.m12553(this.f15860.getBody());
        c3891.m12516(this.f15860.getButton_left_title());
        c3891.m12503(this.f15860.getButton_right_title());
        this.f15861.m2908(30, c3891);
        this.f15861.setOnButtonClick(new C4667(context));
        m14160();
    }
}
