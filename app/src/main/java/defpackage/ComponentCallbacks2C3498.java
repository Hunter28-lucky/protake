package defpackage;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.C1814;
import com.bumptech.glide.load.resource.bitmap.C1835;
import com.bumptech.glide.load.resource.bitmap.C1838;
import defpackage.C2337;
import defpackage.C2463;
import defpackage.C2515;
import defpackage.C2630;
import defpackage.C2686;
import defpackage.C4021;
import defpackage.C4033;
import defpackage.C4333;
import defpackage.C4344;
import defpackage.C4562;
import defpackage.C4988;
import defpackage.C5009;
import defpackage.C5057;
import defpackage.a5;
import defpackage.b5;
import defpackage.c5;
import defpackage.l4;
import defpackage.v;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Glide.java */
/* renamed from: ٷ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class ComponentCallbacks2C3498 implements ComponentCallbacks2 {

    /* renamed from: ށ, reason: contains not printable characters */
    public static volatile ComponentCallbacks2C3498 f12252;

    /* renamed from: ނ, reason: contains not printable characters */
    public static volatile boolean f12253;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C1814 f12254;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2731 f12255;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC3889 f12256;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C2729 f12257;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final C2964 f12258;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final Registry f12259;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final InterfaceC4950 f12260;

    /* renamed from: ֏, reason: contains not printable characters */
    public final C4024 f12261;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final InterfaceC2673 f12262;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final List<C4226> f12263 = new ArrayList();

    /* renamed from: ހ, reason: contains not printable characters */
    public MemoryCategory f12264 = MemoryCategory.NORMAL;

    public ComponentCallbacks2C3498(@NonNull Context context, @NonNull C1814 c1814, @NonNull InterfaceC3889 interfaceC3889, @NonNull InterfaceC2731 interfaceC2731, @NonNull InterfaceC4950 interfaceC4950, @NonNull C4024 c4024, @NonNull InterfaceC2673 interfaceC2673, int i, @NonNull C3900 c3900, @NonNull Map<Class<?>, n3<?, ?>> map) {
        this.f12254 = c1814;
        this.f12255 = interfaceC2731;
        this.f12260 = interfaceC4950;
        this.f12256 = interfaceC3889;
        this.f12261 = c4024;
        this.f12262 = interfaceC2673;
        this.f12257 = new C2729(interfaceC3889, interfaceC2731, (DecodeFormat) c3900.m12595().m11329(C1835.f5374));
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f12259 = registry;
        registry.m4847(new C2452());
        C1835 c1835 = new C1835(registry.m4838(), resources.getDisplayMetrics(), interfaceC2731, interfaceC4950);
        C4923 c4923 = new C4923(context, registry.m4838(), interfaceC2731, interfaceC4950);
        InterfaceC3907<ParcelFileDescriptor, Bitmap> interfaceC3907M8351 = u5.m8351(interfaceC2731);
        C5071 c5071 = new C5071(c1835);
        C1838 c1838 = new C1838(c1835, interfaceC4950);
        C3673 c3673 = new C3673(context);
        C5009.C5012 c5012 = new C5009.C5012(resources);
        C5009.C5013 c5013 = new C5009.C5013(resources);
        C5009.C5011 c5011 = new C5009.C5011(resources);
        C5009.C5010 c5010 = new C5009.C5010(resources);
        C2740 c2740 = new C2740(interfaceC4950);
        C5325 c5325 = new C5325();
        C2859 c2859 = new C2859();
        ContentResolver contentResolver = context.getContentResolver();
        Registry registryM4846 = registry.m4832(ByteBuffer.class, new C3873()).m4832(InputStream.class, new p(interfaceC4950)).m4836("Bitmap", ByteBuffer.class, Bitmap.class, c5071).m4836("Bitmap", InputStream.class, Bitmap.class, c1838).m4836("Bitmap", ParcelFileDescriptor.class, Bitmap.class, interfaceC3907M8351).m4836("Bitmap", AssetFileDescriptor.class, Bitmap.class, u5.m8347(interfaceC2731)).m4834(Bitmap.class, Bitmap.class, l4.C2167.m7485()).m4836("Bitmap", Bitmap.class, Bitmap.class, new j4()).m4833(Bitmap.class, c2740).m4836("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new C3495(resources, c5071)).m4836("BitmapDrawable", InputStream.class, BitmapDrawable.class, new C3495(resources, c1838)).m4836("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new C3495(resources, interfaceC3907M8351)).m4833(BitmapDrawable.class, new C2737(interfaceC2731, c2740)).m4836("Gif", InputStream.class, C3465.class, new q(registry.m4838(), c4923, interfaceC4950)).m4836("Gif", ByteBuffer.class, C3465.class, c4923).m4833(C3465.class, new C4109()).m4834(InterfaceC3507.class, InterfaceC3507.class, l4.C2167.m7485()).m4836("Bitmap", InterfaceC3507.class, Bitmap.class, new C2451(interfaceC2731)).m4835(Uri.class, Drawable.class, c3673).m4835(Uri.class, Bitmap.class, new C4708(c3673, interfaceC2731)).m4846(new C2515.C2516()).m4834(File.class, ByteBuffer.class, new C2337.C2339()).m4834(File.class, InputStream.class, new C4033.C4039()).m4835(File.class, File.class, new C4139()).m4834(File.class, ParcelFileDescriptor.class, new C4033.C4035()).m4834(File.class, File.class, l4.C2167.m7485()).m4846(new C2463.C2464(interfaceC4950));
        Class cls = Integer.TYPE;
        registryM4846.m4834(cls, InputStream.class, c5012).m4834(cls, ParcelFileDescriptor.class, c5011).m4834(Integer.class, InputStream.class, c5012).m4834(Integer.class, ParcelFileDescriptor.class, c5011).m4834(Integer.class, Uri.class, c5013).m4834(cls, AssetFileDescriptor.class, c5010).m4834(Integer.class, AssetFileDescriptor.class, c5010).m4834(cls, Uri.class, c5013).m4834(String.class, InputStream.class, new C4333.C4336()).m4834(Uri.class, InputStream.class, new C4333.C4336()).m4834(String.class, InputStream.class, new v.C2301()).m4834(String.class, ParcelFileDescriptor.class, new v.C2300()).m4834(String.class, AssetFileDescriptor.class, new v.C2299()).m4834(Uri.class, InputStream.class, new C4344.C4345()).m4834(Uri.class, InputStream.class, new C4988.C4991(context.getAssets())).m4834(Uri.class, ParcelFileDescriptor.class, new C4988.C4990(context.getAssets())).m4834(Uri.class, InputStream.class, new C4562.C4563(context)).m4834(Uri.class, InputStream.class, new C4021.C4022(context)).m4834(Uri.class, InputStream.class, new a5.C0003(contentResolver)).m4834(Uri.class, ParcelFileDescriptor.class, new a5.C0001(contentResolver)).m4834(Uri.class, AssetFileDescriptor.class, new a5.C0000(contentResolver)).m4834(Uri.class, InputStream.class, new c5.C0051()).m4834(URL.class, InputStream.class, new b5.C0045()).m4834(Uri.class, File.class, new C2686.C2687(context)).m4834(C4207.class, InputStream.class, new C2630.C2631()).m4834(byte[].class, ByteBuffer.class, new C5057.C5058()).m4834(byte[].class, InputStream.class, new C5057.C5062()).m4834(Uri.class, Uri.class, l4.C2167.m7485()).m4834(Drawable.class, Drawable.class, l4.C2167.m7485()).m4835(Drawable.class, Drawable.class, new k4()).m4848(Bitmap.class, BitmapDrawable.class, new C2738(resources)).m4848(Bitmap.class, byte[].class, c5325).m4848(Drawable.class, byte[].class, new C2403(interfaceC2731, c5325, c2859)).m4848(C3465.class, byte[].class, c2859);
        this.f12258 = new C2964(context, interfaceC4950, registry, new C2643(), c3900, map, c1814, i);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m11418(@NonNull Context context) throws PackageManager.NameNotFoundException {
        if (f12253) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f12253 = true;
        m11422(context);
        f12253 = false;
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public static ComponentCallbacks2C3498 m11419(@NonNull Context context) {
        if (f12252 == null) {
            synchronized (ComponentCallbacks2C3498.class) {
                if (f12252 == null) {
                    m11418(context);
                }
            }
        }
        return f12252;
    }

    @Nullable
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static AbstractC2864 m11420() {
        try {
            return (AbstractC2864) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e2) {
            m11424(e2);
            return null;
        } catch (InstantiationException e3) {
            m11424(e3);
            return null;
        } catch (NoSuchMethodException e4) {
            m11424(e4);
            return null;
        } catch (InvocationTargetException e5) {
            m11424(e5);
            return null;
        }
    }

    @NonNull
    /* renamed from: ֏, reason: contains not printable characters */
    public static C4024 m11421(@Nullable Context context) {
        C4513.m13868(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return m11419(context).m11433();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static void m11422(@NonNull Context context) throws PackageManager.NameNotFoundException {
        m11423(context, new C3776());
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static void m11423(@NonNull Context context, @NonNull C3776 c3776) throws PackageManager.NameNotFoundException {
        Context applicationContext = context.getApplicationContext();
        AbstractC2864 abstractC2864M11420 = m11420();
        List<InterfaceC4372> listEmptyList = Collections.emptyList();
        if (abstractC2864M11420 == null || abstractC2864M11420.m14147()) {
            listEmptyList = new C3869(applicationContext).m12318();
        }
        if (abstractC2864M11420 != null && !abstractC2864M11420.m10203().isEmpty()) {
            Set<Class<?>> setM10203 = abstractC2864M11420.m10203();
            Iterator<InterfaceC4372> it = listEmptyList.iterator();
            while (it.hasNext()) {
                InterfaceC4372 next = it.next();
                if (setM10203.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<InterfaceC4372> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        c3776.m12081(abstractC2864M11420 != null ? abstractC2864M11420.m10204() : null);
        Iterator<InterfaceC4372> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().mo14146(applicationContext, c3776);
        }
        if (abstractC2864M11420 != null) {
            abstractC2864M11420.mo14146(applicationContext, c3776);
        }
        ComponentCallbacks2C3498 componentCallbacks2C3498M12080 = c3776.m12080(applicationContext);
        Iterator<InterfaceC4372> it4 = listEmptyList.iterator();
        while (it4.hasNext()) {
            it4.next().mo13399(applicationContext, componentCallbacks2C3498M12080, componentCallbacks2C3498M12080.f12259);
        }
        if (abstractC2864M11420 != null) {
            abstractC2864M11420.mo13399(applicationContext, componentCallbacks2C3498M12080, componentCallbacks2C3498M12080.f12259);
        }
        applicationContext.registerComponentCallbacks(componentCallbacks2C3498M12080);
        f12252 = componentCallbacks2C3498M12080;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static void m11424(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    /* renamed from: ޅ, reason: contains not printable characters */
    public static C4226 m11425(@NonNull Context context) {
        return m11421(context).m12902(context);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        m11426();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        m11436(i);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m11426() {
        j5.m7084();
        this.f12256.m12342();
        this.f12255.mo9981();
        this.f12260.mo9472();
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC4950 m11427() {
        return this.f12260;
    }

    @NonNull
    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC2731 m11428() {
        return this.f12255;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC2673 m11429() {
        return this.f12262;
    }

    @NonNull
    /* renamed from: Ԯ, reason: contains not printable characters */
    public Context m11430() {
        return this.f12258.getBaseContext();
    }

    @NonNull
    /* renamed from: ԯ, reason: contains not printable characters */
    public C2964 m11431() {
        return this.f12258;
    }

    @NonNull
    /* renamed from: ՠ, reason: contains not printable characters */
    public Registry m11432() {
        return this.f12259;
    }

    @NonNull
    /* renamed from: ֈ, reason: contains not printable characters */
    public C4024 m11433() {
        return this.f12261;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m11434(C4226 c4226) {
        synchronized (this.f12263) {
            if (this.f12263.contains(c4226)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.f12263.add(c4226);
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean m11435(@NonNull c1<?> c1Var) {
        synchronized (this.f12263) {
            Iterator<C4226> it = this.f12263.iterator();
            while (it.hasNext()) {
                if (it.next().m13325(c1Var)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m11436(int i) {
        j5.m7084();
        this.f12256.mo9574(i);
        this.f12255.mo9980(i);
        this.f12260.mo9471(i);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m11437(C4226 c4226) {
        synchronized (this.f12263) {
            if (!this.f12263.contains(c4226)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.f12263.remove(c4226);
        }
    }
}
