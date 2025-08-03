package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SupportRequestManagerFragment.java */
/* loaded from: classes.dex */
public class q0 extends Fragment {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C3874 f8309;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4598 f8310;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Set<q0> f8311;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @Nullable
    public q0 f8312;

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public C4226 f8313;

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public Fragment f8314;

    /* compiled from: SupportRequestManagerFragment.java */
    /* renamed from: q0$Ϳ, reason: contains not printable characters */
    public class C2228 implements InterfaceC4598 {
        public C2228() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + q0.this + "}";
        }
    }

    public q0() {
        this(new C3874());
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            m7991(getActivity());
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f8309.m12323();
        m7995();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f8314 = null;
        m7995();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f8309.m12324();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f8309.m12325();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + m7988() + "}";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m7986(q0 q0Var) {
        this.f8311.add(q0Var);
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public C3874 m7987() {
        return this.f8309;
    }

    @Nullable
    /* renamed from: ԩ, reason: contains not printable characters */
    public final Fragment m7988() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f8314;
    }

    @Nullable
    /* renamed from: Ԫ, reason: contains not printable characters */
    public C4226 m7989() {
        return this.f8313;
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC4598 m7990() {
        return this.f8310;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m7991(@NonNull FragmentActivity fragmentActivity) {
        m7995();
        q0 q0VarM12907 = ComponentCallbacks2C3498.m11419(fragmentActivity).m11433().m12907(fragmentActivity);
        this.f8312 = q0VarM12907;
        if (equals(q0VarM12907)) {
            return;
        }
        this.f8312.m7986(this);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m7992(q0 q0Var) {
        this.f8311.remove(q0Var);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m7993(@Nullable Fragment fragment) {
        this.f8314 = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        m7991(fragment.getActivity());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m7994(@Nullable C4226 c4226) {
        this.f8313 = c4226;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m7995() {
        q0 q0Var = this.f8312;
        if (q0Var != null) {
            q0Var.m7992(this);
            this.f8312 = null;
        }
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public q0(@NonNull C3874 c3874) {
        this.f8310 = new C2228();
        this.f8311 = new HashSet();
        this.f8309 = c3874;
    }
}
