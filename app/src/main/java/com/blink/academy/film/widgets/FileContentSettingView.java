package com.blink.academy.film.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.protake.R;
import defpackage.C3180;
import defpackage.r1;

/* loaded from: classes.dex */
public class FileContentSettingView extends FrameLayout implements View.OnFocusChangeListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Switch f2136;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public EditText f2137;

    /* renamed from: ԭ, reason: contains not printable characters */
    public EditText f2138;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public EditText f2139;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2140;

    /* renamed from: ՠ, reason: contains not printable characters */
    public EditText f2141;

    public FileContentSettingView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C3180.m10807(z);
        m2283();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        switch (view.getId()) {
            case R.id.file_name_reel /* 2131296628 */:
                if (!z) {
                    C3180.m10804(this.f2137.getText().toString().trim());
                    break;
                }
                break;
            case R.id.file_name_scene /* 2131296629 */:
                if (!z) {
                    C3180.m10805(this.f2138.getText().toString().trim());
                    break;
                }
                break;
            case R.id.file_name_shot /* 2131296630 */:
                if (!z) {
                    C3180.m10806(this.f2141.getText().toString().trim());
                    break;
                }
                break;
            case R.id.file_name_take /* 2131296631 */:
                if (!z) {
                    String strTrim = this.f2139.getText().toString().trim();
                    if (!r1.m8138(this.f2139.getText().toString().trim())) {
                        C3180.m10808(Integer.parseInt(strTrim));
                        break;
                    } else {
                        C3180.m10808(this.f2140);
                        break;
                    }
                }
                break;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2282() {
        View.inflate(getContext(), R.layout.layout_file_content_setting, this);
        this.f2136 = (Switch) findViewById(R.id.file_content_switch);
        this.f2137 = (EditText) findViewById(R.id.file_name_reel);
        this.f2138 = (EditText) findViewById(R.id.file_name_scene);
        this.f2141 = (EditText) findViewById(R.id.file_name_shot);
        this.f2139 = (EditText) findViewById(R.id.file_name_take);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2283() {
        boolean zM10799 = C3180.m10799();
        this.f2137.setEnabled(zM10799);
        this.f2138.setEnabled(zM10799);
        this.f2141.setEnabled(zM10799);
        this.f2139.setEnabled(zM10799);
        this.f2136.setChecked(zM10799);
        this.f2137.setText(C3180.m10796());
        this.f2138.setText(C3180.m10797());
        this.f2141.setText(C3180.m10798());
        int iM10800 = C3180.m10800();
        this.f2140 = iM10800;
        this.f2139.setText(String.valueOf(iM10800));
        this.f2137.setHint("1");
        this.f2138.setHint("1");
        this.f2141.setHint("1");
        this.f2139.setHint("1");
        this.f2137.setOnFocusChangeListener(this);
        this.f2138.setOnFocusChangeListener(this);
        this.f2141.setOnFocusChangeListener(this);
        this.f2139.setOnFocusChangeListener(this);
        this.f2136.setOnCheckedChangeListener(this);
    }

    public FileContentSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FileContentSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2282();
    }
}
