package defpackage;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* compiled from: SystemProvider.java */
/* loaded from: classes.dex */
public class x0 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f8732 = C4122.f14279;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean f8733 = C4122.f14280;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m8584(Context context, Locale locale, Location location, InterfaceC4515 interfaceC4515) {
        boolean z = true;
        if (f8733) {
            C4638.m14099(f8732, String.format("reverseGeocodingWithPoint lat : %s , long : %s ", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        }
        if (!Geocoder.isPresent()) {
            if (f8733) {
                C4638.m14099(f8732, "Geocoder not present");
            }
            if (interfaceC4515 != null) {
                interfaceC4515.mo12338();
                return;
            }
            return;
        }
        try {
            List<Address> fromLocation = new Geocoder(context, locale).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (fromLocation != null && fromLocation.size() > 0) {
                fromLocation.get(0).getThoroughfare();
                fromLocation.get(0).getSubThoroughfare();
                fromLocation.get(0).getLocality();
                fromLocation.get(0).getSubLocality();
                String adminArea = fromLocation.get(0).getAdminArea();
                fromLocation.get(0).getSubAdminArea();
                fromLocation.get(0).getPostalCode();
                fromLocation.get(0).getPremises();
                fromLocation.get(0).getPhone();
                fromLocation.get(0).getCountryName();
                fromLocation.get(0).getFeatureName();
                fromLocation.get(0).getCountryCode();
                fromLocation.get(0).getUrl();
                String str = "Thoroughfare : " + fromLocation.get(0).getThoroughfare() + "\nSubThoroughfare : " + fromLocation.get(0).getSubThoroughfare() + "\nLocality : " + fromLocation.get(0).getLocality() + "\nSubLocality : " + fromLocation.get(0).getSubLocality() + "\nAdminArea : " + fromLocation.get(0).getAdminArea() + "\nSubAdminArea : " + fromLocation.get(0).getSubAdminArea() + "\nPostalCode : " + fromLocation.get(0).getPostalCode() + "\nPremises : " + fromLocation.get(0).getPremises() + "\nPhone : " + fromLocation.get(0).getPhone() + "\nCountryName : " + fromLocation.get(0).getCountryName() + "\nFeatureName : " + fromLocation.get(0).getFeatureName() + "\nCountryCode : " + fromLocation.get(0).getCountryCode() + "\nUrl : " + fromLocation.get(0).getUrl() + "\n";
                if (f8733) {
                    C4638.m14099(f8732, str);
                }
                if (interfaceC4515 != null && r1.m8143(adminArea)) {
                    interfaceC4515.mo12339(adminArea);
                    return;
                }
            } else if (f8733) {
                String str2 = f8732;
                StringBuilder sb = new StringBuilder();
                sb.append("addresses null ? ");
                if (fromLocation != null) {
                    z = false;
                }
                sb.append(z);
                C4638.m14099(str2, sb.toString());
            }
        } catch (IOException e2) {
            if (f8733) {
                C4638.m14101(f8732, e2.getMessage());
            }
            e2.printStackTrace();
        }
        if (interfaceC4515 != null) {
            interfaceC4515.mo12338();
        }
    }
}
