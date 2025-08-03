package defpackage;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

/* compiled from: RequestManagerFragment.java */
@Deprecated
/* renamed from: ఴ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class FragmentC4557 extends Fragment {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C3874 f15591;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4598 f15592;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Set<FragmentC4557> f15593;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @Nullable
    public C4226 f15594;

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public FragmentC4557 f15595;

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public Fragment f15596;

    /* compiled from: RequestManagerFragment.java */
    /* renamed from: ఴ$Ϳ, reason: contains not printable characters */
    public class C4558 implements InterfaceC4598 {
        public C4558() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + FragmentC4557.this + "}";
        }
    }

    public FragmentC4557() {
        this(new C3874());
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            m13979(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f15591.m12323();
        m13983();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        m13983();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f15591.m12324();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f15591.m12325();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + m13976() + "}";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m13974(FragmentC4557 fragmentC4557) {
        this.f15593.add(fragmentC4557);
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public C3874 m13975() {
        return this.f15591;
    }

    @Nullable
    @TargetApi(17)
    /* renamed from: ԩ, reason: contains not printable characters */
    public final Fragment m13976() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f15596;
    }

    @Nullable
    /* renamed from: Ԫ, reason: contains not printable characters */
    public C4226 m13977() {
        return this.f15594;
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC4598 m13978() {
        return this.f15592;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m13979(@NonNull Activity activity) {
        m13983();
        FragmentC4557 fragmentC4557M12905 = ComponentCallbacks2C3498.m11419(activity).m11433().m12905(activity);
        this.f15595 = fragmentC4557M12905;
        if (equals(fragmentC4557M12905)) {
            return;
        }
        this.f15595.m13974(this);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m13980(FragmentC4557 fragmentC4557) {
        this.f15593.remove(fragmentC4557);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m13981(@Nullable Fragment fragment) {
        this.f15596 = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        m13979(fragment.getActivity());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m13982(@Nullable C4226 c4226) {
        this.f15594 = c4226;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m13983() {
        FragmentC4557 fragmentC4557 = this.f15595;
        if (fragmentC4557 != null) {
            fragmentC4557.m13980(this);
            this.f15595 = null;
        }
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public FragmentC4557(@NonNull C3874 c3874) {
        this.f15592 = new C4558();
        this.f15593 = new HashSet();
        this.f15591 = c3874;
    }
}
