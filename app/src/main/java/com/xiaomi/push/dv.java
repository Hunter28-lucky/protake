package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* loaded from: classes2.dex */
public class dv extends dy {
    private int a;
    private Bitmap b;
    private Bitmap c;

    public dv(Context context, String str) {
        super(context, str);
        this.a = 16777216;
    }

    @Override // com.xiaomi.push.dy, android.app.Notification.Builder
    /* renamed from: a */
    public dy setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.dy
    /* renamed from: a */
    public String mo5432a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.dy
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo5426a() {
        if (!j.m5689a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(a().getResources(), "bg", "id", a().getPackageName()) == 0 || a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || j.a(a()) < 9) ? false : true;
    }

    public dv b(Bitmap bitmap) {
        if (m5435b() && bitmap != null) {
            this.c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.dy
    public String b() {
        return null;
    }

    @Override // com.xiaomi.push.dy
    /* renamed from: a */
    public dv setLargeIcon(Bitmap bitmap) {
        if (m5435b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.b = bitmap;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m5113a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dw
    /* renamed from: a */
    public dv mo5427a(String str) {
        if (m5435b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dy, com.xiaomi.push.dw
    /* renamed from: a, reason: collision with other method in class */
    public void mo5425a() {
        if (m5435b() && this.b != null) {
            super.mo5425a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int iA = a(resources, "bg", "id", packageName);
            if (j.a(a()) >= 10) {
                m5431a().setImageViewBitmap(iA, a(this.b, 30.0f));
            } else {
                m5431a().setImageViewBitmap(iA, this.b);
            }
            int iA2 = a(resources, "icon", "id", packageName);
            if (this.c != null) {
                m5431a().setImageViewBitmap(iA2, this.c);
            } else {
                a(iA2);
            }
            int iA3 = a(resources, "title", "id", packageName);
            m5431a().setTextViewText(iA3, ((dy) this).f5815a);
            Map<String, String> map = ((dy) this).f5818a;
            if (map != null && this.a == 16777216) {
                mo5427a(map.get("notification_image_text_color"));
            }
            RemoteViews remoteViewsM5431a = m5431a();
            int i = this.a;
            remoteViewsM5431a.setTextColor(iA3, (i == 16777216 || !m5433a(i)) ? -1 : ViewCompat.MEASURED_STATE_MASK);
            setCustomContentView(m5431a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            return;
        }
        m5434b();
    }
}
