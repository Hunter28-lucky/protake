package com.blink.academy.film.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import defpackage.C4638;
import defpackage.C5075;

/* loaded from: classes.dex */
public class HeadsetReceiver extends BroadcastReceiver {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean f421 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public InterfaceC0123 f423;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String f422 = HeadsetReceiver.class.getSimpleName();

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f424 = false;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean f425 = false;

    /* renamed from: com.blink.academy.film.home.HeadsetReceiver$Ϳ, reason: contains not printable characters */
    public interface InterfaceC0123 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo622();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo623();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo624();

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo625();
    }

    public HeadsetReceiver(InterfaceC0123 interfaceC0123) {
        this.f423 = interfaceC0123;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (f421) {
            C4638.m14099(this.f422, String.format("intent : %s ", intent));
        }
        String action = intent.getAction();
        if ("android.intent.action.HEADSET_PLUG".equals(action)) {
            if (intent.hasExtra("state")) {
                if (intent.getIntExtra("state", 0) == 0) {
                    if (this.f424) {
                        this.f424 = false;
                        if (f421) {
                            C4638.m14099(this.f422, String.format("headset not connected : %s ", intent));
                        }
                        InterfaceC0123 interfaceC0123 = this.f423;
                        if (interfaceC0123 != null) {
                            interfaceC0123.mo625();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (intent.getIntExtra("state", 0) != 1 || this.f424) {
                    return;
                }
                this.f424 = true;
                if (f421) {
                    C4638.m14099(this.f422, String.format("headset connected : %s ", intent));
                }
                InterfaceC0123 interfaceC01232 = this.f423;
                if (interfaceC01232 != null) {
                    interfaceC01232.mo623();
                    return;
                }
                return;
            }
            return;
        }
        if ("android.bluetooth.device.action.ACL_CONNECTED".equals(action)) {
            if (!C5075.m14900() || this.f425) {
                return;
            }
            this.f425 = true;
            if (f421) {
                C4638.m14099(this.f422, String.format("onBlueToothHeadsetConnected : %s ", "onBlueToothHeadsetConnected"));
            }
            InterfaceC0123 interfaceC01233 = this.f423;
            if (interfaceC01233 != null) {
                interfaceC01233.mo624();
                return;
            }
            return;
        }
        if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
            if (C5075.m14900()) {
                if (this.f425) {
                    return;
                }
                this.f425 = true;
                if (f421) {
                    C4638.m14099(this.f422, String.format("onBlueToothHeadsetConnected : %s ", "onBlueToothHeadsetConnected"));
                }
                InterfaceC0123 interfaceC01234 = this.f423;
                if (interfaceC01234 != null) {
                    interfaceC01234.mo624();
                    return;
                }
                return;
            }
            if (this.f425) {
                this.f425 = false;
                if (f421) {
                    C4638.m14099(this.f422, String.format("onBlueToothHeadsetDisconnected : %s ", "onBlueToothHeadsetDisconnected"));
                }
                InterfaceC0123 interfaceC01235 = this.f423;
                if (interfaceC01235 != null) {
                    interfaceC01235.mo622();
                    return;
                }
                return;
            }
            return;
        }
        if ("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED".equals(action)) {
            if (C5075.m14900() || !this.f425) {
                return;
            }
            this.f425 = false;
            if (f421) {
                C4638.m14099(this.f422, String.format("onBlueToothHeadsetDisconnected : %s ", "onBlueToothHeadsetDisconnected"));
            }
            InterfaceC0123 interfaceC01236 = this.f423;
            if (interfaceC01236 != null) {
                interfaceC01236.mo622();
                return;
            }
            return;
        }
        int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        int intExtra2 = intent.getIntExtra("android.media.ACTION_SCO_AUDIO_STATE_UPDATED", -1);
        if (f421) {
            C4638.m14099(this.f422, String.format("EXTRA_SCO_AUDIO_STATE : %s , state_updated : %s ", Integer.valueOf(intExtra), Integer.valueOf(intExtra2)));
        }
        if (intExtra == 0) {
            if (C5075.m14900() || !this.f425) {
                return;
            }
            this.f425 = false;
            if (f421) {
                C4638.m14099(this.f422, String.format("onBlueToothHeadsetDisconnected : %s ", "onBlueToothHeadsetDisconnected"));
            }
            InterfaceC0123 interfaceC01237 = this.f423;
            if (interfaceC01237 != null) {
                interfaceC01237.mo622();
                return;
            }
            return;
        }
        if (1 == intExtra && C5075.m14900() && !this.f425) {
            this.f425 = true;
            if (f421) {
                C4638.m14099(this.f422, String.format("onBlueToothHeadsetConnected : %s ", "onBlueToothHeadsetConnected"));
            }
            InterfaceC0123 interfaceC01238 = this.f423;
            if (interfaceC01238 != null) {
                interfaceC01238.mo624();
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public HeadsetReceiver m621(InterfaceC0123 interfaceC0123) {
        this.f423 = interfaceC0123;
        return this;
    }
}
