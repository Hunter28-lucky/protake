package com.blink.academy.film.widgets;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.protake.R;
import defpackage.C2924;
import defpackage.C3273;
import defpackage.C3923;
import defpackage.C4131;
import java.io.File;

/* loaded from: classes.dex */
public class FileSynchronizedSettingView extends FrameLayout implements C3273.InterfaceC3276, C2924.InterfaceC2925, View.OnClickListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Button f2142;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Button f2143;

    /* renamed from: ԭ, reason: contains not printable characters */
    public RelativeLayout f2144;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public LinearLayout f2145;

    /* renamed from: ԯ, reason: contains not printable characters */
    public TextView f2146;

    /* renamed from: ՠ, reason: contains not printable characters */
    public RecyclerView f2147;

    /* renamed from: ֈ, reason: contains not printable characters */
    public C3923 f2148;

    /* renamed from: ֏, reason: contains not printable characters */
    public C4131 f2149;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Button f2150;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Button f2151;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f2152;

    /* renamed from: ށ, reason: contains not printable characters */
    public C2924 f2153;

    /* renamed from: ނ, reason: contains not printable characters */
    public Context f2154;

    /* renamed from: ރ, reason: contains not printable characters */
    public TextView f2155;

    public FileSynchronizedSettingView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_rescan /* 2131296448 */:
                m2289();
                break;
            case R.id.btn_send_file /* 2131296449 */:
                m2290();
                break;
            case R.id.client /* 2131296526 */:
                m2286();
                break;
            case R.id.server /* 2131297372 */:
                m2287();
                break;
        }
    }

    public void setDevices(BluetoothDevice bluetoothDevice) {
        C2924 c2924 = this.f2153;
        if (c2924 != null) {
            c2924.m10323(bluetoothDevice);
        }
    }

    @Override // defpackage.C2924.InterfaceC2925
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo2284(BluetoothDevice bluetoothDevice) {
        if (this.f2148.m10947(bluetoothDevice)) {
            Toast.makeText(getContext(), "已经连接了", 0).show();
            return;
        }
        this.f2148.m12682(bluetoothDevice);
        Toast.makeText(getContext(), "正在连接...", 0).show();
        this.f2146.setText("正在连接...");
    }

    @Override // defpackage.C3273.InterfaceC3276
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo2285(int i, Object obj) {
        String str;
        if (i == 0) {
            str = "连接断开";
            this.f2155.setText("连接断开");
        } else if (i != 1) {
            str = (i == 2 || i == 3) ? String.format("\n%s", obj) : null;
        } else {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
            if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(getContext(), "android.permission.BLUETOOTH_CONNECT") != 0) {
                return;
            }
            str = String.format("与%s(%s)连接成功", bluetoothDevice.getName(), bluetoothDevice.getAddress());
            this.f2155.setText(str);
        }
        Toast.makeText(getContext(), str, 0).show();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2286() {
        this.f2152 = 2;
        this.f2144.setVisibility(0);
        this.f2145.setVisibility(8);
        this.f2143.setVisibility(8);
        this.f2142.setVisibility(8);
        this.f2148 = new C3923(this);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m2287() {
        this.f2152 = 1;
        this.f2144.setVisibility(8);
        this.f2145.setVisibility(0);
        this.f2142.setVisibility(8);
        this.f2143.setVisibility(8);
        this.f2155.setText("暂无连接");
        this.f2149 = new C4131(this);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m2288() {
        View.inflate(getContext(), R.layout.layout_file_synchronized, this);
        this.f2142 = (Button) findViewById(R.id.client);
        this.f2143 = (Button) findViewById(R.id.server);
        this.f2144 = (RelativeLayout) findViewById(R.id.lin_client);
        this.f2145 = (LinearLayout) findViewById(R.id.lin_server);
        this.f2146 = (TextView) findViewById(R.id.tv_tips);
        this.f2147 = (RecyclerView) findViewById(R.id.rv_bt);
        this.f2150 = (Button) findViewById(R.id.btn_rescan);
        this.f2151 = (Button) findViewById(R.id.btn_send_file);
        this.f2155 = (TextView) findViewById(R.id.tv_device_name);
        this.f2142.setOnClickListener(this);
        this.f2143.setOnClickListener(this);
        this.f2150.setOnClickListener(this);
        this.f2151.setOnClickListener(this);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m2289() {
        this.f2153.m10327();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2290() {
        if (!this.f2149.m10947(null)) {
            Toast.makeText(getContext(), "没有连接", 0).show();
        } else if (TextUtils.isEmpty("/sdcard/333.pdf") || !new File("/sdcard/333.pdf").isFile()) {
            Toast.makeText(getContext(), "文件无效", 0).show();
        } else {
            this.f2149.m10950("/sdcard/333.pdf");
        }
    }

    public FileSynchronizedSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FileSynchronizedSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2153 = new C2924(this);
        this.f2154 = context;
        m2288();
    }
}
