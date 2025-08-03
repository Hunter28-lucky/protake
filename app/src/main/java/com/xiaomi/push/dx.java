package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* loaded from: classes2.dex */
public class dx extends dy {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private PendingIntent f5810a;
    private int b;

    /* renamed from: b, reason: collision with other field name */
    private Bitmap f5811b;
    private int c;

    /* renamed from: c, reason: collision with other field name */
    private CharSequence f5812c;

    public dx(Context context, int i, String str) {
        super(context, i, str);
        this.a = 16777216;
        this.b = 16777216;
        this.c = 16777216;
    }

    @Override // com.xiaomi.push.dy
    /* renamed from: a */
    public String mo5432a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.dy
    /* renamed from: a */
    public boolean mo5426a() {
        if (!j.m5689a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
    }

    public dx b(String str) {
        if (m5435b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dy
    public String b() {
        return "notification_colorful_copy";
    }

    public dx c(String str) {
        if (m5435b() && !TextUtils.isEmpty(str)) {
            try {
                this.c = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("parse colorful notification image text color error");
            }
        }
        return this;
    }

    public dx a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m5435b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f5812c = charSequence;
            this.f5810a = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.dw
    /* renamed from: a */
    public dx mo5427a(String str) {
        if (m5435b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dy
    /* renamed from: a */
    public dx setLargeIcon(Bitmap bitmap) {
        if (m5435b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && bitmap.getHeight() >= 177 && bitmap.getHeight() <= 207) {
                this.f5811b = bitmap;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m5113a("colorful notification bg image resolution error, must [984*177, 984*207]");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dy, com.xiaomi.push.dw
    /* renamed from: a */
    public void mo5425a() {
        if (m5435b()) {
            super.mo5425a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int iA = a(resources, "icon", "id", packageName);
            if (((dy) this).f5813a == null) {
                a(iA);
            } else {
                m5431a().setImageViewBitmap(iA, ((dy) this).f5813a);
            }
            int iA2 = a(resources, "title", "id", packageName);
            int iA3 = a(resources, "content", "id", packageName);
            m5431a().setTextViewText(iA2, ((dy) this).f5815a);
            m5431a().setTextViewText(iA3, ((dy) this).f5820b);
            if (!TextUtils.isEmpty(this.f5812c)) {
                int iA4 = a(resources, "buttonContainer", "id", packageName);
                int iA5 = a(resources, "button", "id", packageName);
                int iA6 = a(resources, "buttonBg", "id", packageName);
                m5431a().setViewVisibility(iA4, 0);
                m5431a().setTextViewText(iA5, this.f5812c);
                m5431a().setOnClickPendingIntent(iA4, this.f5810a);
                if (this.b != 16777216) {
                    int iA7 = a(70.0f);
                    int iA8 = a(29.0f);
                    m5431a().setImageViewBitmap(iA6, com.xiaomi.push.service.x.a(a(this.b, iA7, iA8, iA8 / 2.0f)));
                    m5431a().setTextColor(iA5, m5433a(this.b) ? -1 : ViewCompat.MEASURED_STATE_MASK);
                }
            }
            int iA9 = a(resources, "bg", "id", packageName);
            int iA10 = a(resources, "container", "id", packageName);
            if (this.a != 16777216) {
                if (j.a(a()) >= 10) {
                    m5431a().setImageViewBitmap(iA9, com.xiaomi.push.service.x.a(a(this.a, 984, 192, 30.0f)));
                } else {
                    m5431a().setImageViewBitmap(iA9, com.xiaomi.push.service.x.a(a(this.a, 984, 192, 0.0f)));
                }
                a(m5431a(), iA10, iA2, iA3, m5433a(this.a));
            } else if (this.f5811b != null) {
                if (j.a(a()) >= 10) {
                    m5431a().setImageViewBitmap(iA9, a(this.f5811b, 30.0f));
                } else {
                    m5431a().setImageViewBitmap(iA9, this.f5811b);
                }
                Map<String, String> map = ((dy) this).f5818a;
                if (map != null && this.c == 16777216) {
                    c(map.get("notification_image_text_color"));
                }
                int i = this.c;
                a(m5431a(), iA10, iA2, iA3, i == 16777216 || !m5433a(i));
            } else if (Build.VERSION.SDK_INT >= 24) {
                m5431a().setViewVisibility(iA, 8);
                m5431a().setViewVisibility(iA9, 8);
                try {
                    ax.a((Object) this, "setStyle", s.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(m5431a());
            return;
        }
        m5434b();
    }

    private void a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        int iA = a(6.0f);
        remoteViews.setViewPadding(i, iA, 0, iA, 0);
        if (z) {
            remoteViews.setTextColor(i2, -1);
            remoteViews.setTextColor(i3, -1);
        } else {
            remoteViews.setTextColor(i2, ViewCompat.MEASURED_STATE_MASK);
            remoteViews.setTextColor(i3, ViewCompat.MEASURED_STATE_MASK);
        }
    }

    private Drawable a(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }
}
