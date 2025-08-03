package com.blink.academy.film.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.blink.academy.protake.R;

/* loaded from: classes.dex */
public class HardwareSelectView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public SwitchCompat f2340;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public TextView f2341;

    /* renamed from: com.blink.academy.film.widgets.HardwareSelectView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC0922 implements View.OnClickListener {
        public ViewOnClickListenerC0922() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            HardwareSelectView.this.f2340.setChecked(!HardwareSelectView.this.f2340.isChecked());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.HardwareSelectView$Ԩ, reason: contains not printable characters */
    public class C0923 implements CompoundButton.OnCheckedChangeListener {
        public C0923() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        }
    }

    public HardwareSelectView(@NonNull Context context) {
        this(context, null);
    }

    private void setStateText(int i) {
        m2426(i, "");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2425() {
        View.inflate(getContext(), R.layout.layout_hardware_select, this);
        this.f2340 = (SwitchCompat) findViewById(R.id.sc);
        this.f2341 = (TextView) findViewById(R.id.tv_dji_state);
        findViewById(R.id.sc_click).setOnClickListener(new ViewOnClickListenerC0922());
        this.f2340.setOnCheckedChangeListener(new C0923());
        setStateText(0);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2426(int i, String str) {
        String str2;
        switch (i) {
            case 1:
                str2 = "初始化...";
                break;
            case 2:
                str2 = "初始化成功";
                break;
            case 3:
                str2 = "初始化失败，请重启应用重新初始化";
                break;
            case 4:
                str2 = "搜索设备中";
                break;
            case 5:
                str2 = "搜索到设备";
                break;
            case 6:
                str2 = "开始连接设备:" + str;
                break;
            case 7:
                str2 = "连接设备:" + str;
                break;
            case 8:
                str2 = "连接失败";
                break;
            case 9:
                str2 = "已初始化";
                break;
            default:
                str2 = "";
                break;
        }
        this.f2341.setText(str2);
    }

    public HardwareSelectView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HardwareSelectView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2425();
    }
}
