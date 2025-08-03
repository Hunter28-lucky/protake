package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: BtDevAdapter.java */
/* renamed from: ї, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2924 extends RecyclerView.Adapter<ViewOnClickListenerC2926> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<BluetoothDevice> f10628 = new ArrayList();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC2925 f10629;

    /* compiled from: BtDevAdapter.java */
    /* renamed from: ї$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2925 {
        /* renamed from: Ϳ */
        void mo2284(BluetoothDevice bluetoothDevice);
    }

    /* compiled from: BtDevAdapter.java */
    /* renamed from: ї$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC2926 extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final TextView f10630;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final TextView f10631;

        public ViewOnClickListenerC2926(View view) {
            super(view);
            view.setOnClickListener(this);
            this.f10630 = (TextView) view.findViewById(R.id.name);
            this.f10631 = (TextView) view.findViewById(R.id.address);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition < 0 || adapterPosition >= C2924.this.f10628.size()) {
                return;
            }
            C2924.this.f10629.mo2284((BluetoothDevice) C2924.this.f10628.get(adapterPosition));
        }
    }

    public C2924(InterfaceC2925 interfaceC2925) {
        this.f10629 = interfaceC2925;
        m10324();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10628.size();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m10323(BluetoothDevice bluetoothDevice) {
        if (this.f10628.contains(bluetoothDevice)) {
            return;
        }
        this.f10628.add(bluetoothDevice);
        notifyDataSetChanged();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m10324() {
        Set<BluetoothDevice> bondedDevices;
        if ((Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_SCAN") == 0) && (bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices()) != null) {
            this.f10628.addAll(bondedDevices);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull ViewOnClickListenerC2926 viewOnClickListenerC2926, int i) {
        BluetoothDevice bluetoothDevice = this.f10628.get(i);
        if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_SCAN") == 0) {
            String name = bluetoothDevice.getName();
            String address = bluetoothDevice.getAddress();
            int bondState = bluetoothDevice.getBondState();
            TextView textView = viewOnClickListenerC2926.f10630;
            if (name == null) {
                name = "";
            }
            textView.setText(name);
            TextView textView2 = viewOnClickListenerC2926.f10631;
            Object[] objArr = new Object[2];
            objArr[0] = address;
            objArr[1] = bondState == 10 ? "未配对" : "配对";
            textView2.setText(String.format("%s (%s)", objArr));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public ViewOnClickListenerC2926 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewOnClickListenerC2926(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_dev, viewGroup, false));
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m10327() {
        this.f10628.clear();
        m10324();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_SCAN") == 0) {
            if (!defaultAdapter.isDiscovering()) {
                defaultAdapter.startDiscovery();
            }
            notifyDataSetChanged();
        }
    }
}
