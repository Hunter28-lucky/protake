package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.blink.academy.film.FilmApp;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* compiled from: AddressUtils.java */
/* renamed from: ࢩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3973 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f13903 = System.getProperties().getProperty("os.name").toUpperCase();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String f13904;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final String f13905;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.BRAND);
        sb.append("_");
        String str = Build.PRODUCT;
        sb.append(str);
        f13904 = sb.toString();
        f13905 = str;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m12821() throws SocketException {
        InetAddress inetAddressM12826 = m12826();
        return inetAddressM12826 != null ? inetAddressM12826.getCanonicalHostName() : "";
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m12822() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter == null ? "" : (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_CONNECT") == 0) ? defaultAdapter.getName() : "";
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m12823() throws SocketException {
        InetAddress inetAddressM12826 = m12826();
        return inetAddressM12826 != null ? inetAddressM12826.getHostAddress() : "";
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m12824() throws SocketException {
        InetAddress inetAddressM12826 = m12826();
        return inetAddressM12826 != null ? inetAddressM12826.getHostName() : "";
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static InterfaceAddress m12825() throws SocketException {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                for (InterfaceAddress interfaceAddress : networkInterfaceNextElement.getInterfaceAddresses()) {
                    if ((interfaceAddress.getAddress() instanceof Inet4Address) && networkInterfaceNextElement.getName().startsWith("wlan")) {
                        return interfaceAddress;
                    }
                }
            }
            return null;
        } catch (SocketException e2) {
            e2.printStackTrace(System.err);
            return null;
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static InetAddress m12826() throws SocketException {
        InterfaceAddress interfaceAddressM12825 = m12825();
        if (interfaceAddressM12825 != null) {
            return interfaceAddressM12825.getAddress();
        }
        return null;
    }
}
